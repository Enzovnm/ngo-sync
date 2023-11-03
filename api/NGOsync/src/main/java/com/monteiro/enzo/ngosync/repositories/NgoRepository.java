package com.monteiro.enzo.ngosync.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monteiro.enzo.ngosync.entities.Ngo;


public interface NgoRepository extends JpaRepository<Ngo, Long>{
	
}
