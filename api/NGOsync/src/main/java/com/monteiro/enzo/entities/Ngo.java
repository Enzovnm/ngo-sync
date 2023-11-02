package com.monteiro.enzo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ngo")
public class Ngo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 320)
	private String email;
	
	@Column(nullable = false, columnDefinition = "char(60)")
	private String password;
	
	private boolean status;
	
	@Column(nullable = false, unique = true, columnDefinition = "char(14")
	private String cnpj;
	
	private String logo;
	
	private String Description;
	
	private String site;
	
	@Column(nullable = false, columnDefinition = "char(2)")
	private String state;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String neighborhood;
	
	@Column(nullable = false, columnDefinition = "char(8)")
	private String postalCode;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private int addressNumber;
	
	private String addressComplement;
	
	@Column(nullable = false, length = 15)
	private String phone;
	
	
}
