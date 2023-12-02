package com.monteiro.enzo.ngosync.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monteiro.enzo.ngosync.entities.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long>{

    boolean existsByEmail (String email);

    boolean existsByCpfOrCnpj (String cpf, String cpj);
}
