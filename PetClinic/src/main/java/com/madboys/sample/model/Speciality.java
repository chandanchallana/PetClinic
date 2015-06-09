package com.madboys.sample.model;

import javax.persistence.Entity;
import javax.persistence.Table;



/**
 * Simple java bean describing the speciality of a Vet
 * Modesl a {@link Vet Vet's} Speciality 
 * 
 * @author Joker
 *
 */
@Entity
@Table(name="specialities")
public class Speciality extends NamedEntity {

}
