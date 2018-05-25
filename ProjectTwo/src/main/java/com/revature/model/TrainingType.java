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
@Table(name="TRAINING_TYPE")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class TrainingType {

	
	@Id
	@GeneratedValue(generator="training_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="training_seq", allocationSize=1, initialValue=1)
	@Column(name="TYPE_ID")
	private int id;
	
	@Column(name="TYPE_NAME")
	private String type;

	public TrainingType(String type) {
		super();
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TrainingType [id=" + id + ", type=" + type + "]";
	}
	
	
}
