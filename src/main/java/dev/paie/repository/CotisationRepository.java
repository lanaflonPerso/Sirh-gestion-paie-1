package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Avantage;
import dev.paie.entite.Cotisation;

public interface CotisationRepository extends JpaRepository <Cotisation, Integer> {

}
