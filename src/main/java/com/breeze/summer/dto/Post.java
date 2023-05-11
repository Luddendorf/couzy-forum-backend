package com.breeze.summer.dto;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public class Post {

	@Id                     
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long postId;
	private Long userId;
    private String title;
    private String text;
    private Long parentPostId;
    private Long subcategoryId;
    private Boolean isPoll;
    private Byte state;
    private Byte source;
    private String ip;
    
	@CreatedDate
	private ZonedDateTime createdDatetime;
	
	@LastModifiedDate
	private ZonedDateTime updatedDatetime;
	
	public Post() {}
	
	public Post(Long postId, Long userId, String title, String text, Long parentPostId,
			Long subcategoryId, Boolean isPoll, Byte state, Byte source, String ip,
			ZonedDateTime createdDatetime, ZonedDateTime updatedDatetime) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.title = title;
		this.text = text;
		this.parentPostId = parentPostId;
		this.subcategoryId = subcategoryId;
		this.isPoll = isPoll;
		this.state = state;
		this.source = source;
		this.ip = ip;
		this.createdDatetime = createdDatetime;
		this.updatedDatetime = updatedDatetime;
	}

    

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getParentPostId() {
		return parentPostId;
	}

	public void setParentPostId(Long parentPostId) {
		this.parentPostId = parentPostId;
	}

	public Long getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(Long subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public Boolean getIsPoll() {
		return isPoll;
	}

	public void setIsPoll(Boolean isPoll) {
		this.isPoll = isPoll;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public Byte getSource() {
		return source;
	}

	public void setSource(Byte source) {
		this.source = source;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public ZonedDateTime getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(ZonedDateTime createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public ZonedDateTime getUpdatedDatetime() {
		return updatedDatetime;
	}

	public void setUpdatedDatetime(ZonedDateTime updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
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
	public int hashCode() {
		return Objects.hash(createdDatetime, ip, isPoll, parentPostId, postId, source, state, subcategoryId, text,
				title, updatedDatetime, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(createdDatetime, other.createdDatetime) && Objects.equals(ip, other.ip)
				&& Objects.equals(isPoll, other.isPoll) && Objects.equals(parentPostId, other.parentPostId)
				&& Objects.equals(postId, other.postId) && Objects.equals(source, other.source)
				&& Objects.equals(state, other.state) && Objects.equals(subcategoryId, other.subcategoryId)
				&& Objects.equals(text, other.text) && Objects.equals(title, other.title)
				&& Objects.equals(updatedDatetime, other.updatedDatetime) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", title=" + title + ", text=" + text
				+ ", parentPostId=" + parentPostId + ", subcategoryId=" + subcategoryId + ", isPoll=" + isPoll
				+ ", state=" + state + ", source=" + source + ", ip=" + ip + ", createdDatetime=" + createdDatetime
				+ ", updatedDatetime=" + updatedDatetime + "]";
	}
}
