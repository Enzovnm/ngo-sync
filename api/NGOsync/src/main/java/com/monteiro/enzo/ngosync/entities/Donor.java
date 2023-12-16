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
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Entity
@Table(name = "Donors")
public class Donor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true, length = 320)
	private String email;
	
	@Column(unique= true, columnDefinition = "char(11)")
	private String cpf;
	
	@Column(unique = true, columnDefinition = "char(14)")
	private String cnpj;
	
	@Column(length = 11)
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

	@Column(columnDefinition = "boolean default true")
	private boolean enabled;

	@CreationTimestamp
	private Instant createdAt;

	@UpdateTimestamp
	private Instant updatedAt;

	@ManyToOne
	@JoinColumn(name = "ngo_id")
	private Ngo ngo;
}
