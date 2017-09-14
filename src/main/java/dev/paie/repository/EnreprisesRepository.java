package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Avantage;
import dev.paie.entite.Entreprise;

public interface EnreprisesRepository extends JpaRepository <Entreprise, Integer> {

}
