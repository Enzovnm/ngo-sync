package com.monteiro.enzo.ngosync.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monteiro.enzo.ngosync.dtos.NgoDto;
import com.monteiro.enzo.ngosync.dtos.NgoDtoInsert;
import com.monteiro.enzo.ngosync.services.NgoService;

@RestController
@RequestMapping("/ngos")
public class NgoController {
	
	@Autowired
	private NgoService ngoService;
	
	@GetMapping
	public ResponseEntity<List<NgoDto>> findAll(){
		return ResponseEntity.ok(ngoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NgoDto> findById(@PathVariable Long id ){
		return ResponseEntity.ok(ngoService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<NgoDto> save(@RequestBody NgoDtoInsert ngo){
		return new ResponseEntity<NgoDto>(ngoService.save(ngo),HttpStatus.CREATED);
	}


}
