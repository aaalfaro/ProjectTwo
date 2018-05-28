package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="STATUS")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Status {
	
	@Id
	@GeneratedValue(generator="status_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="status_seq", allocationSize=1, initialValue=1)
	private int id;
	
	@Column(name="type")
	private String status;
	

	public Status() {
		super();
	}

	public Status(String status) {
		super();
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", status=" + status + "]";
	}
	
	
	
}
