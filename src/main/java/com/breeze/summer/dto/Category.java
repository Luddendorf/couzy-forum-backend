package com.breeze.summer.dto;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;

	private String title;
	private String description;
	private String ip;

	@CreatedDate
	private ZonedDateTime createdDatetime;

	@LastModifiedDate
	private ZonedDateTime updatedDatetime;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(Long categoryId, String title, String description, String ip, ZonedDateTime createdDatetime,
			ZonedDateTime updatedDatetime) {
		super();
		this.categoryId = categoryId;
		this.title = title;
		this.description = description;
		this.ip = ip;
		this.createdDatetime = createdDatetime;
		this.updatedDatetime = updatedDatetime;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public ZonedDateTime getCreatedDateTime() {
		return createdDatetime;
	}

	public void setCreatedDateTime(ZonedDateTime createdDateTime) {
		this.createdDatetime = createdDateTime;
	}

	public ZonedDateTime getUpdatedDateTime() {
		return updatedDatetime;
	}

	public void setUpdatedDateTime(ZonedDateTime updatedDateTime) {
		this.updatedDatetime = updatedDateTime;
	}

	@PrePersist
	protected void onCreate() {
		createdDatetime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Vilnius"));
	}

	@PreUpdate
	protected void onUpdate() {
		updatedDatetime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Vilnius"));
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", title=" + title + ", description=" + description + ", ip=" + ip
				+ ", createdDateTime=" + createdDatetime + ", updatedDateTime=" + updatedDatetime + "]";
	}
}
