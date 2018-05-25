package com.revature.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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
	
	@Column(name="GOOD_GRADE")
	private int goodGrade;
	
	@Column(name="PASSING_GRADE")
	private int passingGrade;
	
	@Column(name="MONTH")
	private int month;
	
	@Column(name="DAY")
	private int day;
	
	@Column(name="YEAR")
	private int year;
	
	public Batch(String name, String location, int goodGrade, int passingGrade, int month, int day, int year) {
		super();
		this.name = name;
		this.location = location;
		this.goodGrade = goodGrade;
		this.passingGrade = passingGrade;
		this.day = day;
		this.month = month;
		this.year = year;
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
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", location=" + location + ", goodGrade=" + goodGrade
				+ ", passingGrade=" + passingGrade + ", month=" + month + ", day=" + day + ", year=" + year + "]";
	}

	public static void main(String[] args) {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		System.out.println(localDate.getYear());
	}
	
}
