package com.monteiro.enzo.ngosync.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.monteiro.enzo.ngosync.entities.Ngo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class DonorDtoSaveUpdate {

	@NotEmpty(message = "The field 'name' must not be empty")
	private String name;

	@NotEmpty(message = "The field 'email' must not be empty")
	@Email(message = "The field 'email' is not valid")
	private String email;

	@CPF
	private String cpf;

	@CNPJ
	private String cnpj;

	@Length(min = 11, max = 11, message = "The field 'phone' must have 11 characters")
	private String phone;

	@Size(min = 2, max = 2,message = "The field 'state' must have 2 characters")
	private String state;

	private String city;

	private String neighborhood;

	@Size(min = 8,max = 8,message ="The field 'postalCode' must have 8 characters")
	private String postalCode;

	private String address;

	private int addressNumber;

	private String addressComplement;

	private boolean isActive;

	@JsonIgnore
	private Ngo ngo;
	
}
