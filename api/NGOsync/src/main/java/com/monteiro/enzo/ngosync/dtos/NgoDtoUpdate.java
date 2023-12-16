package com.monteiro.enzo.ngosync.dtos;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NgoDtoUpdate(
		
		@NotEmpty(message= "The field 'name' must not be empty")
		String name,
		
		@NotEmpty(message = "The field 'cnpj' must not be empty")
		@CNPJ(message = "The field 'cnpj' is invalid")
		String cnpj,
		
		String logo,
		
		String description,
		
		@URL(message = "The field 'site' must be a URL")
		String site, 
		
		@NotEmpty(message="The field 'state' must not be empty")
		@Size(min = 2, max = 2,message = "The field 'state' must have 2 characters")
		String state,
		
		@NotEmpty(message="The field 'city' must not be empty")
		String city,
		
		@NotEmpty(message="The field 'neighborhood' must not be empty")
		String neighborhood,
		
		@NotEmpty(message="The field 'postalCode' must not be empty")
		@Size(min = 8,max = 8,message ="The field 'postalCode' must have 8 characters")
		String postalCode,
		
		@NotEmpty(message="The field 'address' must not be empty")
		String address,
		
		@NotNull(message="The field 'addressNumber' must not be null")
		int addressNumber,
		
		String addressComplement,

		@Length(min = 11, max = 11, message = "The field 'phone' must have 11 characters")
		String phone, boolean enabled) {}
