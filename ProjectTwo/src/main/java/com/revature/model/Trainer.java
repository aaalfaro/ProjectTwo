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
@Table(name="TRAINER")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Trainer {

	@Id
	@GeneratedValue(generator="trainer_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="trainer_seq", allocationSize=1, initialValue=1)
	@Column(name="TRAINER_ID")
	private int id;
	
	@Column(name="TRAINER_NAME")
	private String name;

	public Trainer() {
		super();
	}

	public Trainer(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
