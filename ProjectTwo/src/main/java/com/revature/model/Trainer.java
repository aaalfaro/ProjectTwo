package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "BATCH_ID")
	private Batch batch;
	
	public Trainer() {
		super();
	}

	public Trainer(String name) {
		super();
		this.name = name;
	}

	public Trainer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Trainer(int id, String name, Batch batch) {
		super();
		this.id = id;
		this.name = name;
		this.batch = batch;
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

	
	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", batch=" + batch + "]";
	}

	
	
	
	
}
