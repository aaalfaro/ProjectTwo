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
@Table(name="ASSESSMENT")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Assessment {
	
	@Id
	@GeneratedValue(generator="assessment_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="assessment_seq", allocationSize=1,initialValue=1)
	@Column(name="assessment_id")
	private int id;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="TYPE")
	private String type;

	public Assessment(String category, String type) {
		super();
		this.category = category;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Assessment [id=" + id + ", category=" + category + ", type=" + type + "]";
	}
	
	

}
