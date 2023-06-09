package com.breeze.summer.utils;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SortField {
  DATE("date"),
  TITLE("title"),
  TEXT("text"),
  USER_NAME("userName");
  
  private final String value;
  
  SortField(String value) { this.value = value; }
	
  public String getValue() { return this.value; }

  @JsonCreator
  public static SortField convertFromValue(String label) {
	  for (SortField e : values()) {
		if (e.value.equals(label)) {
			return e;
		}
	  }
	  return null;
  }
}
