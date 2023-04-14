package dto;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Teacher {
	
	private Long id;
	private String name;
	private String subject;
	private Long idClass;
	private ZonedDateTime createDatetime;
	private ZonedDateTime updateDatetime;

	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	
	public Teacher(Long id, String name, String subject, Long idClass, ZonedDateTime createDatetime,
			ZonedDateTime updateDatetime) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.idClass = idClass;
		this.createDatetime = createDatetime;
		this.updateDatetime = updateDatetime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getIdClass() {
		return idClass;
	}

	public void setIdClass(Long idClass) {
		this.idClass = idClass;
	}

	public ZonedDateTime getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(ZonedDateTime createDatetime) {
		this.createDatetime = createDatetime;
	}

	public ZonedDateTime getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(ZonedDateTime updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", subject=" + subject + ", idClass=" + idClass
				+ ", createDatetime=" + createDatetime + ", updateDatetime=" + updateDatetime + "]";
	}
}
