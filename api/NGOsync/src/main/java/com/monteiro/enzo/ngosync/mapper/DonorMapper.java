package com.monteiro.enzo.ngosync.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.monteiro.enzo.ngosync.dtos.DonorDto;
import com.monteiro.enzo.ngosync.entities.Donor;

@Mapper(componentModel = "spring")
public interface DonorMapper {

	DonorMapper INSTANCE = Mappers.getMapper(DonorMapper.class);
				
	DonorDto donorToDto(Donor donor);
		
	Donor donorDtoToDonor (DonorDto donorDto);
}
