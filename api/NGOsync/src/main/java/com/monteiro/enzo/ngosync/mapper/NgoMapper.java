package com.monteiro.enzo.ngosync.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.monteiro.enzo.ngosync.dtos.NgoDto;
import com.monteiro.enzo.ngosync.entities.Ngo;

@Mapper(componentModel = "spring")
public interface NgoMapper {
	
	NgoMapper INSTANCE = Mappers.getMapper(NgoMapper.class);
	
	NgoDto ngoToDto(Ngo ngo);
}
