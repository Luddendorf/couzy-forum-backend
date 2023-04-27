package com.breeze.summer.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dto.Teacher;

@Service
@DependsOn({"pupilService"})
@Scope("singleton")
public class TeacherService {
	
	// @Value("${school.favorite-teacher.name}")
	private String teacherName;
	
	// @Value("${school.favorite-pupil.name}")
	private String pupilName;
	
	@Autowired
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public TeacherService(@Value("${school.favorite-teacher.name}") String teacherName,
			              @Value("${school.favorite-pupil.name}") String pupilName,
			              JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		
		this.teacherName = teacherName;
		this.pupilName = pupilName;
		
		System.out.println(this.teacherName + " and " + this.pupilName + " are friends.");
	}
	
	public Teacher findTeacherByName(String teacherName) {

        String sql = "SELECT * FROM teacher WHERE name = ? LIMIT 0, 1";

        return jdbcTemplate.queryForObject(sql, new Object[]{teacherName}, (rs, rowNum) ->
                new Teacher(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getTimestamp(5).toLocalDateTime().atZone(ZoneId.of("Europe/Vilnius")),
                        rs.getTimestamp(6).toLocalDateTime().atZone(ZoneId.of("Europe/Vilnius"))
                ));
    }

}
