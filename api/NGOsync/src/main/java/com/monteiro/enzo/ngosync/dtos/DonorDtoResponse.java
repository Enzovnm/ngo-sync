package com.monteiro.enzo.ngosync.dtos;
public record DonorDtoResponse(
		Long id,
		String name,
		String email,
		String cpf,
		String cnpj,
		String phone,
		String state,
		String city,
		String neighborhood,
		String postalCode,
		String address,
		int addressNumber,
		String addressComplement
		){}
