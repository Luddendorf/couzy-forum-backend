package com.breeze.summer.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
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

	@PrePersist
	protected void onCreate() {
		createdDatetime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Vilnius"));
		updatedDatetime = createdDatetime;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedDatetime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Vilnius"));
	}

	public Post addComment(Post comment) {
		this.comments.add(comment);
		comment.setParentPost(this);
		return comment;
	}
}
