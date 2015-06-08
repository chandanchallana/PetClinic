package com.madboys.sample.model;

/**
* This is a sample Application written for practice with Spring framework and also other
* frameworks used in web development. This application references the pet clinic application
* on springframework tutorials.This application can be reused by anyone who wants to use
* it for learning purpose.
*
*/

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import org.hibernate.validator.constraints.NotEmpty;




/**
 * @author t_chalc
 * Simple java class representing person identity
 */
@MappedSuperclass
public class Person extends BaseEntity {

	@Column(name="first_name")
	@NotEmpty
	protected String firstName;
	
	@Column(name="last_name")
	@NotEmpty
	protected String lastName;
	
	public String getFirstName(){
		return this.firstName;
	}
	public String getLastName(){
		return lastName;	
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
}
