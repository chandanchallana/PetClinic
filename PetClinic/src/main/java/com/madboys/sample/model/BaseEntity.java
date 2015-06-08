package com.madboys.sample.model;



/**
 *
 * 
 * This is a sample Application written for practice with Spring framework and also other
 * frameworks used in web development. This application references the pet clinic application
 * on springframework tutorials.This application can be reused by anyone who wants to use
 * it for learning purpose.
 *
 */
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * Simple java bean object which provides id property to other classes that inherits
 * from it.
 * @author t_chalc
 *
 */
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	public void setInteger(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public boolean isNew(){
		return (this.id==null);
	}

}
