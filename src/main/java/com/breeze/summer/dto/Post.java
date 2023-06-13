package com.breeze.summer.dto;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long postId;
	private Long userId;
	private String userName;
	private String title;
	private String text;

	@ManyToOne(fetch = FetchType.LAZY)
	private Post parentPost;
	private Long subcategoryId;
	private Boolean isPoll;
	private Integer state;
	private Integer source;
	private String ip;

	@OneToMany(mappedBy = "parentPost")
	private List<Post> comments;

	@CreatedDate
	@Column(name = "created_datetime", updatable = false)
	private ZonedDateTime createdDatetime;

	@LastModifiedDate
	private ZonedDateTime updatedDatetime;

	public Post() {
	}

	public Post(Long postId, Long userId, String userName, String title, String text, Post parentPost,
			Long subcategoryId,
			Boolean isPoll, Integer state, Integer source, String ip, List<Post> comments, ZonedDateTime createdDatetime,
			ZonedDateTime updatedDatetime) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.userName = userName;
		this.title = title;
		this.text = text;
		this.parentPost = parentPost;
		this.subcategoryId = subcategoryId;
		this.isPoll = isPoll;
		this.state = state;
		this.source = source;
		this.ip = ip;
		this.comments = comments;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Post getParentPost() {
		return parentPost;
	}

	public void setParentPost(Post parentPost) {
		this.parentPost = parentPost;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
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

	public List<Post> getComments() {
		return comments;
	}

	public void setComments(List<Post> comments) {
		this.comments = comments;
	}

	@PrePersist
	protected void onCreate() {
		createdDatetime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Vilnius"));
		updatedDatetime = createdDatetime;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedDatetime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Vilnius"));
	}

	@Override
	public int hashCode() {
		return Objects.hash(comments, createdDatetime, ip, isPoll, parentPost, postId, source, state, subcategoryId,
				text, title, updatedDatetime, userId);
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
		return Objects.equals(comments, other.comments) && Objects.equals(createdDatetime, other.createdDatetime)
				&& Objects.equals(ip, other.ip) && Objects.equals(isPoll, other.isPoll)
				&& Objects.equals(parentPost, other.parentPost) && Objects.equals(postId, other.postId)
				&& Objects.equals(source, other.source) && Objects.equals(state, other.state)
				&& Objects.equals(subcategoryId, other.subcategoryId) && Objects.equals(text, other.text)
				&& Objects.equals(title, other.title) && Objects.equals(updatedDatetime, other.updatedDatetime)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", userName=" + userName + ", title=" + title + ", text="
				+ text + ", parentPost=" + parentPost + ", subcategoryId=" + subcategoryId + ", isPoll=" + isPoll + ", state="
				+ state + ", source=" + source + ", ip=" + ip + ", comments=" + comments + ", createdDatetime="
				+ createdDatetime + ", updatedDatetime=" + updatedDatetime + "]";
	}

	public Post addComment(Post comment) {
		this.comments.add(comment);
		comment.setParentPost(this);
		return comment;
	}
}
