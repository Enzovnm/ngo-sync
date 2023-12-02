package com.monteiro.enzo.ngosync.services;

import com.monteiro.enzo.ngosync.dtos.DonorDtoSaveUpdate;
import com.monteiro.enzo.ngosync.entities.Donor;
import com.monteiro.enzo.ngosync.services.exceptions.EntityConflictException;
import com.monteiro.enzo.ngosync.services.exceptions.EntityUnprocessableException;
import org.springframework.stereotype.Service;

import com.monteiro.enzo.ngosync.dtos.DonorDtoResponse;
import com.monteiro.enzo.ngosync.entities.Ngo;
import com.monteiro.enzo.ngosync.mapper.DonorMapper;
import com.monteiro.enzo.ngosync.repositories.DonorRepository;
import com.monteiro.enzo.ngosync.repositories.NgoRepository;
import com.monteiro.enzo.ngosync.services.exceptions.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DonorService {
	
	private final DonorRepository donorRepository;
	private final NgoRepository ngoRepository;

	@Transactional
	public DonorDtoResponse save(Long ngoId, DonorDtoSaveUpdate donor) {
		Ngo ngo = ngoRepository.findById(ngoId).orElseThrow(() -> new EntityNotFoundException("Ngo not found: " + ngoId));
		donor.setNgo(ngo);

		checkIfcpfAndCnpjAreValid(donor.getCpf(), donor.getCnpj());
		checkIfEmailExists(donor.getEmail());

		var result = donorRepository.save(DonorMapper.INSTANCE.donorDtoInsertToDonor(donor));
		return DonorMapper.INSTANCE.donorToDto(result);
	}

	@Transactional
	public DonorDtoResponse update(Long ngoId, Long donorId, DonorDtoSaveUpdate donor){
		checkIfcpfAndCnpjAreValid(donor.getCpf(), donor.getCnpj());
		checkIfEmailExists(donor.getEmail());

		Ngo ngo = ngoRepository.findById(ngoId).orElseThrow(() -> new EntityNotFoundException("Ngo not found: " + ngoId));
		Donor donorEntity = donorRepository.findById(donorId).orElseThrow(() -> new EntityNotFoundException("Donor not found: " + donorId));
		donorEntity.setNgo(ngo);

		return DonorMapper.INSTANCE.donorToDto(donorEntity);
	}

	private void checkIfcpfAndCnpjAreValid(String cpf, String cnpj){
		if (cpf == null && cnpj == null) throw new EntityUnprocessableException("cpf and cnpj are null. At least one of them must be filled");
		if (cpf != null && cnpj != null) throw new EntityUnprocessableException("Exactly one of cpf or cnpj must be filled");
		if(donorRepository.existsByCpfOrCnpj(cpf, cnpj)) throw new EntityConflictException("cpf/cnpj already exists");
	}

	private void checkIfEmailExists (String email){
		if(donorRepository.existsByEmail(email)) throw new EntityConflictException("email already exists");
	}
}	
