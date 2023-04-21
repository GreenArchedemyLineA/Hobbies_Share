package com.tenco.hobby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	// 글 전체조회
	@GetMapping("/list")
	public String list() {

		return "/board/list";
	}

	// 글 상세보기
	@GetMapping("/detail")
	public String detail() {

		return "/board/detail";
	}

	// 글 쓰기
	@GetMapping("/write")
	public String write() {

		return "/board/write";
	}

	// 글 수정하자
	@GetMapping("/update")
	public String update() {

		return "/board/update";
	}

	@GetMapping("/delete")
	public String delete() {

		return "/board/list";

	}

}
