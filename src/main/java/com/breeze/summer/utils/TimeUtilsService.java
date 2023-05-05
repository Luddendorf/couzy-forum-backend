package com.breeze.summer.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

@Service
public class TimeUtilsService {
  
	public static ZonedDateTime getDateTimeNow() {
		 return ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Vilnius"));
	}
}
