package com.revature.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="BATCH")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Batch {
	
	@Id
	@GeneratedValue(generator="batch_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="batch_seq", allocationSize=1, initialValue=1)
	@Column(name="BATCH_ID")
	private int id;
	
	@Column(name="TRAINING_NAME")
	private String name;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="LOCATION_CATEGORY")
	private String locationCategory;
	
	@Column(name="GOOD_GRADE")
	private int goodGrade;
	
	@Column(name="PASSING_GRADE")
	private int passingGrade;
	
	@Column(name="START_DATE")
	private String startDate;
	
	@Column(name="END_DATE")
	private String endDate;
	
	@OneToMany(mappedBy="batch")
	public List<Trainer> trainers;
	
	@ManyToOne
	@JoinColumn(name = "SKILL_ID")
	private SkillType skill;
	
	@ManyToOne
	@JoinColumn(name = "TYPE_ID")
	private TrainingType type;
	public Batch() {
		super();
	}

	
	
	public Batch(String name, String location, String locationCategory, int goodGrade, int passingGrade,
			String startDate, String endDate, List<Trainer> trainers, SkillType skill, TrainingType type) {
		super();
		this.name = name;
		this.location = location;
		this.locationCategory = locationCategory;
		this.goodGrade = goodGrade;
		this.passingGrade = passingGrade;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainers = trainers;
		this.skill = skill;
		this.type = type;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getGoodGrade() {
		return goodGrade;
	}

	public void setGoodGrade(int goodGrade) {
		this.goodGrade = goodGrade;
	}

	public int getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(int passingGrade) {
		this.passingGrade = passingGrade;
	}
	

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	

	public String getLocationCategory() {
		return locationCategory;
	}



	public void setLocationCategory(String locationCategory) {
		this.locationCategory = locationCategory;
	}



	public List<Trainer> getTrainers() {
		return trainers;
	}



	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}



	public SkillType getSkill() {
		return skill;
	}



	public void setSkill(SkillType skill) {
		this.skill = skill;
	}



	public TrainingType getType() {
		return type;
	}



	public void setType(TrainingType type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", location=" + location + ", locationCategory="
				+ locationCategory + ", goodGrade=" + goodGrade + ", passingGrade=" + passingGrade + ", startDate="
				+ startDate + ", endDate=" + endDate + ", trainers=" + trainers + ", skill=" + skill + ", type=" + type
				+ "]";
	}



	public static void main(String[] args) {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		System.out.println(localDate.getYear());
	}
	
}
