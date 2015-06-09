package com.madboys.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import org.springframework.format.annotation.DateTimeFormat;



/**
 * A simple java bean representing a visit
 * @author Joker
 *
 */
@Entity
@Table(name="visits")

public class Visit extends BaseEntity {

	@Column(name="visit_date")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private DateTime date;
	
	@NotEmpty
	@Column(name="description")
	private String description;
	
	
	/**
	 * Holds value of a property pet
	 */
	@ManyToOne
	@JoinColumn(name="pet_id")
	private Pet pet;
	
	public Visit(){
		this.date = new DateTime();
	}
	
	public DateTime getDate(){
		return date;
	}
	
	public void setDateTime(DateTime date){
		this.date = date;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return description;
	}
	
	public Pet getPet(){
		return this.pet;
	}
	
	public void setPet(Pet pet){
		this.pet = pet;
	}
}

