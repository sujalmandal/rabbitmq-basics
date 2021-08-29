package com.bsr.rabbitmqbasics.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Job {
	
	private String id;
	private Map<String,Object> details;
	private LocalDate createdDate;
	private LocalTime createdTime;
	private String status;
	public Job() {
		id=UUID.randomUUID().toString();
		status="pending";
		createdDate=LocalDate.now();
		createdTime=LocalTime.now();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, Object> getDetails() {
		return details;
	}
	public void setDetails(Map<String, Object> details) {
		this.details = details;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalTime createdTime) {
		this.createdTime = createdTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(createdTime, details, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		return Objects.equals(createdTime, other.createdTime) && Objects.equals(details, other.details)
				&& Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", details=" + details + ", createdTime=" + createdTime + "]";
	}

	
	
	
}
