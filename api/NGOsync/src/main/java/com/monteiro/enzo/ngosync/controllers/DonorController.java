package com.monteiro.enzo.ngosync.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monteiro.enzo.ngosync.dtos.DonorDto;
import com.monteiro.enzo.ngosync.dtos.DonorDtoInsert;
import com.monteiro.enzo.ngosync.services.DonorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DonorController {
	
	private final DonorService donorService;
	
	@PostMapping("ngos/{ngoId}/donors")
	public ResponseEntity<DonorDto> save(@PathVariable(value = "ngoId") Long id, @Valid @RequestBody DonorDtoInsert donor){
		return new ResponseEntity<DonorDto>(donorService.save(id, donor), HttpStatus.CREATED);
	}
}
