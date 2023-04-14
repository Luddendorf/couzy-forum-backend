package com.breeze.summer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.breeze.summer.service.TeacherService;

import dto.Pupil;
import dto.Teacher;

@RestController
public class TeacherController {
	
	@Autowired
	private final TeacherService teacherService;

	@Autowired
	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@PostMapping("/teacher/by-name")
	Teacher findTeacherByName(@RequestBody Teacher teacher) {
		return teacherService.findTeacherByName(teacher.getName());
	}

}
