package com.monteiro.enzo.ngosync.dtos;

public record NgoDto(Long id, String name, String email, String cnpj, String logo, String description, String site, String state, String city, String neighborhood,
		String postalCode, String address, int addressNumber, String addressComplement, String phone) {

}
