package com.madboys.sample.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;



/**
 * A simpple bean representing a veterinarian
 * @author Joker
 *
 */
@Entity
@Table(name="vets")
public class Vet extends Person{
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="vet_specialities",joinColumns=@JoinColumn(name="vet_id"),
	inverseJoinColumns=@JoinColumn(name="speciality_id"))
	private Set<Speciality> specialities;
	
	protected void setSpecialitiesInternal(Set<Speciality>specialities){
		this.specialities = specialities;
	}
	
	protected Set<Speciality> getSpecialitiesInternal(){
		if(this.specialities == null)
			specialities = new HashSet<Speciality>();
		return this.specialities;
	}
	
	@XmlElement
	public List<Speciality>getSpecialities(){
		List<Speciality> sortedSpecs = new ArrayList<Speciality>(getSpecialitiesInternal());
		PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name",true,true));
		return Collections.unmodifiableList(sortedSpecs);
	}
	
	public int getNumberOfSpecialities(){
		return getSpecialitiesInternal().size();
	}
	
	public void addSpeciality(Speciality spec){
		specialities.add(spec);
	}

}
