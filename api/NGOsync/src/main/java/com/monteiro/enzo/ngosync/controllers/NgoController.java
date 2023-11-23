package com.monteiro.enzo.ngosync.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monteiro.enzo.ngosync.dtos.NgoDto;
import com.monteiro.enzo.ngosync.dtos.NgoDtoInsert;
import com.monteiro.enzo.ngosync.dtos.NgoDtoUpdate;
import com.monteiro.enzo.ngosync.services.NgoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ngos")
@RequiredArgsConstructor
public class NgoController {
	
	private final NgoService ngoService;
	
	@GetMapping
	public ResponseEntity<List<NgoDto>> findAll(){
		return ResponseEntity.ok(ngoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NgoDto> findById(@PathVariable Long id ){
		return ResponseEntity.ok(ngoService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<NgoDto> save(@Valid @RequestBody NgoDtoInsert ngo){
		return new ResponseEntity<NgoDto>(ngoService.save(ngo),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<NgoDto> update(@PathVariable Long id, @Valid @RequestBody NgoDtoUpdate ngoUpdate){
		return ResponseEntity.ok(ngoService.update(id, ngoUpdate));
	}

}
