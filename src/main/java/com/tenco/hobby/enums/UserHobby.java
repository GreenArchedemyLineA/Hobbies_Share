package com.tenco.hobby.enums;

public enum UserHobby {
	CODING("코딩"), HEALTH("헬스"),GAME("게임"),MUSIC("음악감상"),ESCAPEROOM("방탈출"),HOMECAFE("카페"),
	PICTURE("사진찍기"),FOOOTOUR("맛집탐방"),SHOPPING("쇼핑"),EXHIBITION("전시회"),	PAINTING("그림그리기"),
	FLOWERARRANGEMENT("꽃꽂이"),COOKING("요리"),MEDITATION("명상"),	INSTRUMENT("악기"),	DANCING("댄스"),SINGING("노래"),
	BAKING("베이킹"),MOVIE("영화"),	TRAVEL("여행"),	FANGIRLING("덕질"),	BOOK("독서"),FISHING("낚시"),BOWLING("볼링"),
	CLIMBING("클라이밍"),MOUNTAIN("등산"),CYCLING("자전거"),FOREIGNLANGUAGE("외국어배우기"),WATCHPERFORMANCE("공연관람"),
   CAMPING("캠핑"), GOLF("골프"), SOCCER("축구"), BASKETBALL("야구");
	
	private final String name;
	UserHobby(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
