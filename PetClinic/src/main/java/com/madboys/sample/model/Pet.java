package com.madboys.sample.model;
/**
 * This is a sample Application written for practice with Spring framework and also other
 * frameworks used in web development. This application references the pet clinic application
 * on springframework tutorials.This application can be reused by anyone who wants to use
 * it for learning purpose.
 * 
 * 
 *
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Simple Bean describing the Pet class
 * @author Joker
 *
 */
@Entity
@Table(name="Pets")
public class Pet extends NamedEntity{
	
	@Column(name="birth_date")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private DateTime birthDate;
	
	@ManyToOne
	@JoinColumn(name="type_id")
	private PetType type;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="pet",fetch=FetchType.EAGER)
	private Set<Visit> visits;
	
	public void setBirthDate(DateTime birthDate){
		this.birthDate = birthDate;
	}
	
	public DateTime getBirthDate(){
		return this.birthDate;
	}
	
	public void setType(PetType type){
		this.type =type;
	}
	
	public PetType getType(){
		return type;
	}
	
	protected void setOwner(Owner owner){
		this.owner =owner;
	}
	
	public Owner getOwner(){
		return owner;
	}
	protected void setVisitsInternal(Set<Visit> visits){
		this.visits = visits;
	}
	
	protected Set<Visit> getVisitsInternal(){
		if(this.visits == null)
			visits = new HashSet<Visit>();
		return this.visits;
	}
	
	public List<Visit> getVisits(){
		List<Visit> sortedVisits = new ArrayList<Visit>(getVisitsInternal());
		PropertyComparator.sort(sortedVisits,new MutableSortDefinition("date",false,false));
		return Collections.unmodifiableList(sortedVisits);
	}
	
	public void addVisit(Visit visit){
		getVisitsInternal().add(visit);
		visit.setPet(this);
	}
	
	public boolean isNew(){
		
		return true;
	}

}
