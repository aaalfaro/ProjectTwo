package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="status")
	public List<Trainee> trainees;
	
	public Status() {
		super();
	}

	public Status(String status) {
		super();
		this.status = status;
	}

	public Status(int id, String status, List<Trainee> trainees) {
		super();
		this.id = id;
		this.status = status;
		this.trainees = trainees;
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

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", status=" + status + ", trainees=" + trainees + "]";
	}

	
	
	
	
}
