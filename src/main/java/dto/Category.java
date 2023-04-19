package dto;

import java.time.ZonedDateTime;

public class Category {
	private Long categoryId;
	private String title;
	private String description;
	private String ip;
	private ZonedDateTime createdDateTime;
	private ZonedDateTime updatedDateTime;

	public Category() {
		// TODO Auto-generated constructor stub
	}

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
