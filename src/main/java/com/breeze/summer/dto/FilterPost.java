package com.breeze.summer.dto;

import java.time.ZonedDateTime;

import org.springframework.data.domain.Sort;

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

	public FilterPost() {
		super();
	}

	public FilterPost(ZonedDateTime fromDatetime, ZonedDateTime toDatetime, String title, Long userId,
		String userName, Integer currentPageNumber, Integer postsPerPage,
		String sortBy, Sort.Direction sortDirection) {
		super();
		this.fromDatetime = fromDatetime;
		this.toDatetime = toDatetime;
		this.title = title;
		this.userId = userId;
		this.userName = userName;
		this.currentPageNumber = currentPageNumber;
		this.postsPerPage = postsPerPage;
		this.sortBy = sortBy;
		this.sortDirection = sortDirection;
	}

	public ZonedDateTime getFromDatetime() {
		return fromDatetime;
	}

	public void setFromDatetime(ZonedDateTime fromDatetime) {
		this.fromDatetime = fromDatetime;
	}

	public ZonedDateTime getToDatetime() {
		return toDatetime;
	}

	public void setToDatetime(ZonedDateTime toDatetime) {
		this.toDatetime = toDatetime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(Integer currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}

	public Integer getPostsPerPage() {
		return postsPerPage;
	}

	public void setPostsPerPage(Integer postsPerPage) {
		this.postsPerPage = postsPerPage;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public Sort.Direction getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(Sort.Direction sortDirection) {
		this.sortDirection = sortDirection;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "FilterPost [fromDatetime=" + fromDatetime + ", toDatetime=" + toDatetime + ", title=" + title
				+ ", userId=" + userId + ", userName=" + userName
				+ ", currentPageNumber=" + currentPageNumber + ", postsPerPage=" + postsPerPage
				+ ", sortBy=" + sortBy + ", sortDirection=" + sortDirection + "]";
	}
}
