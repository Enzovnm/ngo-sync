package com.monteiro.enzo.ngosync.services;

import org.springframework.stereotype.Service;

import com.monteiro.enzo.ngosync.dtos.DonorDto;
import com.monteiro.enzo.ngosync.entities.Ngo;
import com.monteiro.enzo.ngosync.mapper.DonorMapper;
import com.monteiro.enzo.ngosync.repositories.DonorRepository;
import com.monteiro.enzo.ngosync.repositories.NgoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DonorService {
	
	private final DonorRepository donorRepository;
	private final NgoRepository ngoRepository;
	
	public DonorDto save(Long id,DonorDto donor) {
		Ngo ngo = ngoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ngo not found: " + id));
		donor.setNgo(ngo);
		var result = donorRepository.save(DonorMapper.INSTANCE.donorDtoToDonor(donor));
		return DonorMapper.INSTANCE.donorToDto(result);
	}
}	
