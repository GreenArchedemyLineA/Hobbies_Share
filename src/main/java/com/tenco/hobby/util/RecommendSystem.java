package com.tenco.hobby.util;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tenco.hobby.enums.UserHobby;
import com.tenco.hobby.repository.interfaces.BoardRepository;
import com.tenco.hobby.repository.interfaces.HobbyRepository;
import com.tenco.hobby.repository.interfaces.UserRepository;
import com.tenco.hobby.repository.model.Board;
import com.tenco.hobby.repository.model.ReportBoard;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.repository.model.UserHobbies;

@Component
public class RecommendSystem {
	private final int AGE10 = 10;
	private final int AGE20 = 20;
	private final int AGE30 = 30;
	private final int AGE40 = 40;
	private final int AGE50 = 50;
	private final int AGE60 = 60;
	private UserRepository userRepository;
	private HobbyRepository hobbyRepository;
	private BoardRepository boardRepository;
	private static Map<Integer, List<User>> userAgeMap = new HashMap<>();
	private static Map<UserHobby, List<User>> userHobbiesMap = new HashMap<>();

	@Autowired // 생성자 주입
	public RecommendSystem(
			UserRepository userRepository,
			HobbyRepository hobbyRepository,
			BoardRepository boardRepository
			) throws NoSuchFieldException, IllegalAccessException {
		this.userRepository = userRepository;
		this.hobbyRepository = hobbyRepository;
		this.boardRepository = boardRepository;
		List<User> userList = userRepository.findByAll();
		List<UserHobbies> hobbiesList = hobbyRepository.findByAll();
		List<Board> boardList = boardRepository.findAll();
		System.out.println(boardList.toString());
		setUserAgeMap(userList);
		setUserHobbiesMap(hobbiesList);
		thread.start();
	}
	
	private void setUserAgeMap(List<User> userList) {
		List<User> userList10 = new ArrayList<User>();
		List<User> userList20 = new ArrayList<User>();
		List<User> userList30 = new ArrayList<User>();
		List<User> userList40 = new ArrayList<User>();
		List<User> userList50 = new ArrayList<User>();
		List<User> userList60 = new ArrayList<User>();
		userList.stream().forEach(user -> {
			// 세대별 분리
			int age = seperateGeneration(user.getBirth().getYear() + 1900);
			user.setPassword(null);
			switch(age) {
			case 10:
				userList10.add(user);
				break;
			case 20:
				userList20.add(user);
				break;
			case 30:
				userList30.add(user);
				break;
			case 40:
				userList40.add(user);
				break;
			case 50:
				userList50.add(user);
				break;
			case 60:
				userList60.add(user);
				break;
			}
		});
		userAgeMap.put(10, userList10);
		userAgeMap.put(20, userList20);
		userAgeMap.put(30, userList30);
		userAgeMap.put(40, userList40);
		userAgeMap.put(50, userList50);
		userAgeMap.put(60, userList60);
	}

	private void setUserHobbiesMap(List<UserHobbies> hobbiesList) throws NoSuchFieldException, IllegalAccessException {
		UserHobby[] userHobbies = getEnumValues(UserHobby.class);
		for(int i = 0; i < userHobbies.length; i++) {
			userHobbiesMap.put(userHobbies[i], new ArrayList<User>());
		}

		hobbiesList.stream().forEach(hobbies -> {
			userHobbiesMap.get(hobbies.getHobby()).add(hobbies.getUser());
		});
	}
	
	private int seperateGeneration(int year) {
		int nowGeneration = AGE60;
		int nowYear = LocalDateTime.now().getYear();
		if(nowYear - year <= 59) {
			nowGeneration = AGE50;
		}
		if(nowYear - year <= 49) {
			nowGeneration = AGE40;
		}
		if(nowYear - year <= 39) {
			nowGeneration = AGE30;
		}
		if(nowYear - year <= 29 ) {
			nowGeneration = AGE20;
		}
		if(nowYear - year <= 19) {
			nowGeneration = AGE10;
		}
		return nowGeneration;
	}
	
	private <E extends UserHobby> E[] getEnumValues(Class<E> enumClass) throws NoSuchFieldException, IllegalAccessException{
		Field[] f = enumClass.getFields();
		UserHobby[] o = new UserHobby[f.length];
		for(int i = 0; i<f.length; i++) {
			f[i].setAccessible(true);
			o[i] = (UserHobby) f[i].get(null);
		}
		return (E[]) o;
//        f.setAccessible(true);
//        Object o = f.get(null);
//        return (E[]) o;
//        return null;
	}
	public List<User> ageRecommendUserList(Integer id) {
		List<User> userAgeRecommendList = userAgeMap.get(id);
		return userAgeRecommendList;
	}
	public List<User> hobbyRecommendUserList(UserHobby name) {
		List<User> userhobbyRecommendList = userHobbiesMap.get(name);
		return userhobbyRecommendList;
	}
	
	Thread thread = new Thread(new Runnable() {
		private final int THIRTYMINUTES = 1000 * 60 * 30;
		@Override
		public void run(){
			try {
				while(true) {
					List<User> userList = userRepository.findByAll();
					List<UserHobbies> hobbiesList = hobbyRepository.findByAll();
					List<Board> boardList = boardRepository.findAll();
					setUserAgeMap(userList);
					setUserHobbiesMap(hobbiesList);
					try {
						Thread.sleep(THIRTYMINUTES);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	});
}