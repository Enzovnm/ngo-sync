package com.monteiro.enzo.ngosync.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monteiro.enzo.ngosync.entities.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long>{

}
