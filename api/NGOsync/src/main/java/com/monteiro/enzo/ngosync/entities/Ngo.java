package com.monteiro.enzo.ngosync.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Ngos")
public class Ngo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, unique = true, length = 320)
	private String email;
	
	@Column(nullable = false, columnDefinition = "char(60)")
	private String password;
	
	@Column(nullable = false, unique = true, columnDefinition = "char(14)")
	private String cnpj;
	
	private String logo;
	
	private String description;
	
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
	
	@OneToMany(mappedBy = "ngo",fetch = FetchType.EAGER)
	private List<Donor> donors;
	
}
