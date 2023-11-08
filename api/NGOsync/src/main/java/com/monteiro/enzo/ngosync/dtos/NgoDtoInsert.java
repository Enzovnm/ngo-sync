package com.monteiro.enzo.ngosync.dtos;

public record NgoDtoInsert(long id, String name, String email,String password,String cnpj, String logo, String description, String site, String state, String city, String neighborhood,
		String postalCode, String address, String addressNumber, String addressComplement, String phone) {

}
