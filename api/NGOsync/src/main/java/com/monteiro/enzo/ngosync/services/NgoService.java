package com.monteiro.enzo.ngosync.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monteiro.enzo.ngosync.dtos.NgoDto;
import com.monteiro.enzo.ngosync.mapper.NgoMapper;
import com.monteiro.enzo.ngosync.repositories.NgoRepository;
import com.monteiro.enzo.ngosync.services.exceptions.EntityNotFoundException;


@Service
public class NgoService {
	
	@Autowired
	private NgoRepository ngoRepository;
	
	
	public List<NgoDto> findAll(){
		var ngos = ngoRepository.findAll();
		return ngos.stream().map(NgoMapper.INSTANCE::ngoToDto).toList();
	}
	
	public NgoDto findById(long id) {
		var result = ngoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Id not found " + id));
		return NgoMapper.INSTANCE.ngoToDto(result);
	}
}
