package com.monteiro.enzo.ngosync.services;

import java.util.List;

import com.monteiro.enzo.ngosync.services.exceptions.EntityConflictException;
import org.springframework.stereotype.Service;

import com.monteiro.enzo.ngosync.dtos.NgoDto;
import com.monteiro.enzo.ngosync.dtos.NgoDtoInsert;
import com.monteiro.enzo.ngosync.dtos.NgoDtoUpdate;
import com.monteiro.enzo.ngosync.entities.Ngo;
import com.monteiro.enzo.ngosync.mapper.NgoMapper;
import com.monteiro.enzo.ngosync.repositories.NgoRepository;
import com.monteiro.enzo.ngosync.services.exceptions.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class NgoService {

	private final NgoRepository ngoRepository;
	@Transactional(readOnly = true)
	public List<NgoDto> findAll(){
		var result = ngoRepository.findAll();
		return result.stream().map(NgoMapper.INSTANCE::ngoToDto).toList();
	}

	@Transactional(readOnly = true)
	public NgoDto findById(Long id) {
		var result = ngoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Id not found: " + id));
		return NgoMapper.INSTANCE.ngoToDto(result);
	}

	@Transactional
	public NgoDto save(NgoDtoInsert ngo) {

		if(ngoRepository.existsByEmail(ngo.email())) throw new EntityConflictException("email already exists");
		if(ngoRepository.existsByCnpj(ngo.cnpj())) throw new EntityConflictException("cnpj already exists");

		var result = ngoRepository.save(NgoMapper.INSTANCE.ngoDtoInsertToNgo(ngo));
		return NgoMapper.INSTANCE.ngoToDto(result);
	}

	@Transactional
	public NgoDto update(Long id, NgoDtoUpdate ngoUpdate ) {
		var result = ngoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id not found " + id));
		updateNgoFields(result, ngoUpdate);
		result = ngoRepository.save(result);
		
		return NgoMapper.INSTANCE.ngoToDto(result);
		
	}

	private void updateNgoFields(Ngo ngo, NgoDtoUpdate ngoUpdate) {
		ngo.setName(ngoUpdate.name());
		ngo.setCnpj(ngoUpdate.cnpj());
		ngo.setLogo(ngoUpdate.logo());
		ngo.setDescription(ngoUpdate.description());
		ngo.setSite(ngoUpdate.site());
		ngo.setState(ngoUpdate.state());
		ngo.setCity(ngoUpdate.city());
		ngo.setNeighborhood(ngoUpdate.neighborhood());
		ngo.setPostalCode(ngoUpdate.postalCode());
		ngo.setAddress(ngoUpdate.address());
		ngo.setAddressNumber(ngoUpdate.addressNumber());
		ngo.setAddressComplement(ngoUpdate.addressComplement());
		ngo.setPhone(ngoUpdate.phone());
	}
}
