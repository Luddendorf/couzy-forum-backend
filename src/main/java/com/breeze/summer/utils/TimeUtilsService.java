package com.breeze.summer.utils;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeUtilsService {

	public static ZonedDateTime getDateTimeNow() {
		return ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Vilnius"));
	}

	public static String getShortDate(Instant dateTime) {
		return DateTimeFormatter.ofPattern("dd.MM.yyyy")
				.withZone(ZoneId.systemDefault()).format(dateTime);
	}
}
