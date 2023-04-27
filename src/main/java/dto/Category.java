package dto;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;

@Entity
@Table(name="category")
@EntityListeners(AuditingEntityListener.class)
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id")
	private Long categoryId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="ip")
	private String ip;
	
	@Column(name="created_datetime")
	private ZonedDateTime createdDateTime;
	
	@Column(name="updated_datetime")
	private ZonedDateTime updatedDateTime;

	public Category() {}

	public Category(Long categoryId, String title, String description, String ip, ZonedDateTime createdDateTime,
			ZonedDateTime updatedDateTime) {
		super();
		this.categoryId = categoryId;
		this.title = title;
		this.description = description;
		this.ip = ip;
		this.createdDateTime = createdDateTime;
		this.updatedDateTime = updatedDateTime;
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
		return createdDateTime;
	}

	public void setCreatedDateTime(ZonedDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public ZonedDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(ZonedDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}


	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", title=" + title + ", description=" + description + ", ip=" + ip
				+ ", createdDateTime=" + createdDateTime + ", updatedDateTime=" + updatedDateTime + "]";
	}
	
	

}
