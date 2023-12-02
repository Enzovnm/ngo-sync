package com.monteiro.enzo.ngosync.mapper;

import com.monteiro.enzo.ngosync.dtos.DonorDtoResponse;
import com.monteiro.enzo.ngosync.dtos.DonorDtoSaveUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.monteiro.enzo.ngosync.entities.Donor;

@Mapper(componentModel = "spring")
public interface DonorMapper {

	DonorMapper INSTANCE = Mappers.getMapper(DonorMapper.class);
				
	DonorDtoResponse donorToDto(Donor donor);
		
	Donor donorDtoToDonor(DonorDtoResponse donorDtoResponse);
	
	Donor donorDtoInsertToDonor(DonorDtoSaveUpdate donorDtoSaveUpdate);
}
