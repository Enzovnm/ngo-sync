package com.monteiro.enzo.ngosync.dtos;

public record NgoDtoUpdate(long id, String name,String cnpj, String logo, String description, String site, String state, String city, String neighborhood,
		String postalCode, String address, int addressNumber, String addressComplement, String phone) {

}
