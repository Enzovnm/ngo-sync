package com.monteiro.enzo.ngosync.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monteiro.enzo.ngosync.dtos.NgoDto;
import com.monteiro.enzo.ngosync.mapper.NgoMapper;
import com.monteiro.enzo.ngosync.repositories.NgoRepository;

@Service
public class NgoService {
	
	@Autowired
	private NgoRepository ngoRepository;
	
	@Autowired
	private NgoMapper ngoMapper;
	
	
	public List<NgoDto> findAll(){
		var ngos = ngoRepository.findAll();
		return ngos.stream().map(ngoMapper.INSTANCE::ngoToDto).toList();
	}
}
