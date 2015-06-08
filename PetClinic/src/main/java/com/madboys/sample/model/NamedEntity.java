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
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


/**
 * Simple java bean class which provides named property to the classes that inherit from it
 * @author t_chalc
 *
 */
public class NamedEntity {

	@Column(name="name")
	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String toString(){
		return this.getName();
		
	}
}
