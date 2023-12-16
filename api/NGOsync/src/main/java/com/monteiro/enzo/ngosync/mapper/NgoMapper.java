package com.monteiro.enzo.ngosync.mapper;

import com.monteiro.enzo.ngosync.dtos.NgoDtoSave;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.monteiro.enzo.ngosync.dtos.NgoDtoResponse;
import com.monteiro.enzo.ngosync.entities.Ngo;

@Mapper(componentModel = "spring")
public interface NgoMapper {
	
	NgoMapper INSTANCE = Mappers.getMapper(NgoMapper.class);
			
	NgoDtoResponse ngoToDto(Ngo ngo);

	@Mapping(target = "enabled", constant = "true")
	Ngo ngoDtoInsertToNgo(NgoDtoSave ngo);
	
}
