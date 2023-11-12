package com.monteiro.enzo.ngosync.dtos;

import com.monteiro.enzo.ngosync.entities.Ngo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class DonorDto {

	private long id;
	private String name;
	private String phone;
	private String state;
	private String city;
	private String neighborhood;
	private String postalCode;
	private String address;
	private int addressNumber;
	private String addressComplement;
	private Ngo ngo;
	
}
