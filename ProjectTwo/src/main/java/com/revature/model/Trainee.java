package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="TRAINEE")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Trainee {
	
	@Id
	@GeneratedValue(generator="trainee_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="trainee_seq", allocationSize=1, initialValue=1)
	@Column(name="TRAINEE_ID")
	private int id;
	
	@Column(name="TRAINEE_FULLNAME")
	private String name;
	
	@Column(name="TRAINEE_EMAIL")
	private String email;
	
	@Column(name="TRAINEE_SKYPEID")
	private String skype;
	
	@Column(name="TRAINEE_PHONE")
	private String phone;
	
	@Column(name="COLLEGE")
	private String college;
	
	@Column(name="DEGREE")
	private String degree;
	
	@Column(name="MAJOR")
	private String major;
	
	@Column(name="RECRUITER_NAME")
	private String recruiter;
	
	@Column(name="SCREENER")
	private String screener;
	
	@Column(name="PROJECT_COMPLETION")
	private int completion;
	
	@Column(name="URL")
	private String url;
	
	public Trainee() {
		super();
	}

	public Trainee(String name, String email, String skype, String phone, String college, String degree, String major,
			String recruiter, String screener, int completion, String url) {
		super();
		this.name = name;
		this.email = email;
		this.skype = skype;
		this.phone = phone;
		this.college = college;
		this.degree = degree;
		this.major = major;
		this.recruiter = recruiter;
		this.screener = screener;
		this.completion = completion;
		this.url = url;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public String getScreener() {
		return screener;
	}

	public void setScreener(String screener) {
		this.screener = screener;
	}

	public int getCompletion() {
		return completion;
	}

	public void setCompletion(int completion) {
		this.completion = completion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", email=" + email + ", skype=" + skype + ", phone=" + phone
				+ ", college=" + college + ", degree=" + degree + ", major=" + major + ", recruiter=" + recruiter
				+ ", screener=" + screener + ", completion=" + completion + ", url=" + url + "]";
	}
	
	
	
	
}
