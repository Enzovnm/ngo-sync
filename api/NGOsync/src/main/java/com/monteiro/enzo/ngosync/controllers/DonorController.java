package com.monteiro.enzo.ngosync.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monteiro.enzo.ngosync.dtos.DonorDto;
import com.monteiro.enzo.ngosync.services.DonorService;

@RestController
public class DonorController {
	
	private final DonorService donorService;
	
	@Autowired
	public DonorController(DonorService donorService) {
		this.donorService = donorService;
	}

	@PostMapping("ngos/{ngoId}/donors")
	public ResponseEntity<DonorDto> save(@PathVariable(value = "ngoId") Long id, @RequestBody DonorDto donor){
		return new ResponseEntity<DonorDto>(donorService.save(id, donor), HttpStatus.CREATED);
	}
}
