package com.monteiro.enzo.ngosync.controllers;

import com.monteiro.enzo.ngosync.dtos.DonorDtoResponse;
import com.monteiro.enzo.ngosync.dtos.DonorDtoSaveUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.monteiro.enzo.ngosync.services.DonorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DonorController {
	
	private final DonorService donorService;

	@GetMapping("ngos/{ngoId}/donors")
	public  ResponseEntity<List<DonorDtoResponse>> findAll(@PathVariable Long ngoId){
		return ResponseEntity.ok(donorService.findAllByNgo(ngoId));
	}

	@GetMapping("donors/{donorId}")
	public ResponseEntity<DonorDtoResponse> findById(@PathVariable Long donorId){
		return ResponseEntity.ok(donorService.findById(donorId));
	}

	@PostMapping("ngos/{ngoId}/donors")
	public ResponseEntity<DonorDtoResponse> save(@PathVariable(value = "ngoId") Long ngoId, @Valid @RequestBody DonorDtoSaveUpdate donor){
		return new ResponseEntity<DonorDtoResponse>(donorService.save(ngoId, donor), HttpStatus.CREATED);
	}

	@PutMapping("ngos/{ngoId}/donors/{donorId}")
	public ResponseEntity<DonorDtoResponse> update(@PathVariable(value = "ngoId") Long ngoId, @PathVariable Long donorId, @Valid @RequestBody DonorDtoSaveUpdate donor){
		return ResponseEntity.ok(donorService.update(ngoId,donorId,donor));
	}

	@DeleteMapping("donors/{donorId}")
	public ResponseEntity<String> delete(@PathVariable Long donorId){
		donorService.delete(donorId);
		return ResponseEntity.noContent().build();
	}

}
