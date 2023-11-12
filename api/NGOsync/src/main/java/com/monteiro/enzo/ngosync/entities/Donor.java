package com.monteiro.enzo.ngosync.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Donates")
public class Donor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, length = 15)
	private String phone;
	
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

	@ManyToOne
	@JoinColumn(name = "ngo_id")
	private Ngo ngo;
}