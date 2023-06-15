package com.breeze.summer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Sort;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilterPost {
	private ZonedDateTime fromDatetime;
	private ZonedDateTime toDatetime;
	private String title;
	private Long userId;
	private String userName;
	private Integer currentPageNumber;
	private Integer postsPerPage;
	private String sortBy;
	private Sort.Direction sortDirection;
}
