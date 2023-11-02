package com.monteiro.enzo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ngo")
public class Ngo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String name;
	private String email;
	private String password;
	private boolean status;
	private String cnpj;
	private String logo;
	private String Description;
	private String site;
	private String state;
	private String city;
	private String neighborhood;
	private String postalCode;
	private String address;
	private int addressNumber;
	private String addressComplement;
	private String phone;
	
	
}
