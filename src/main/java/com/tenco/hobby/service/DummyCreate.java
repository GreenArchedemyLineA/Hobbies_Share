package com.tenco.hobby.service;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tenco.hobby.enums.UserHobby;
import com.tenco.hobby.repository.interfaces.BoardRepository;
import com.tenco.hobby.repository.model.Board;

public class DummyCreate {
	private UserHobby[] hobbyArrays;
	private int hobbiesLength;
	private BoardRepository boardRepository;
	private Board board;
	private SqlSessionFactory sqlSessionFactory;
	 
	public DummyCreate(BoardRepository boardRepository) throws NoSuchFieldException, IllegalAccessException, SQLException {
		this.hobbyArrays = getEnumValues(UserHobby.class);
		this.board = new Board();
		this.boardRepository = boardRepository;
		this.hobbiesLength = this.hobbyArrays.length;
		dummyDataCreated();
	}
	private <E extends UserHobby> E[] getEnumValues(Class<E> enumClass) throws NoSuchFieldException, IllegalAccessException{
		Field[] f = enumClass.getFields();
		UserHobby[] o = new UserHobby[f.length];
		for(int i = 0; i<f.length; i++) {
			f[i].setAccessible(true);
			o[i] = (UserHobby) f[i].get(null);
		}
		return (E[]) o;
	}
	
	private void dummyDataCreated() throws SQLException {
		Random random = new Random();
		for(int i = 0; i< 100; i++) {
			UUID content = UUID.randomUUID();
			UUID title = UUID.randomUUID();
			int userId = random.nextInt(5)+1;
			int hobbyId = random.nextInt(hobbiesLength)+1;
			board.setTitle(title.toString());
			board.setContent(content.toString());
			board.setUserId(Integer.toUnsignedLong(userId));
			board.setHobbyId(Integer.toUnsignedLong(hobbyId));
			
			boardRepository.insert(board);
		}
	}
}
