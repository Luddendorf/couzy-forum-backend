package com.breeze.summer.dto;

import java.util.List;

public class FoundPosts {
	private List<Post> foundPosts;
	private Long totalPosts;

	public FoundPosts() {
		super();
	}

	public FoundPosts(List<Post> foundPosts, Long totalPosts) {
		super();
		this.foundPosts = foundPosts;
		this.totalPosts = totalPosts;
	}

	public List<Post> getFoundPosts() {
		return foundPosts;
	}

	public void setFoundPosts(List<Post> foundPosts) {
		this.foundPosts = foundPosts;
	}

	public Long getTotalPosts() {
		return totalPosts;
	}

	public void setTotalPosts(Long totalPosts) {
		this.totalPosts = totalPosts;
	}
}
