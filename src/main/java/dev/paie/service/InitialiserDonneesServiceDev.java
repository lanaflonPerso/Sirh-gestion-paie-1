package dev.paie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.paie.entite.Avantage;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.AvantageRepository;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EnreprisesRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Component
class InitialiserDonneesServiceDev implements InitialiserDonneesService {
	@Autowired
	private CotisationRepository cotisationRepository;
	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private EnreprisesRepository entrepriseRepository;
	@Autowired
	private ProfilRemunerationRepository remunerationRepository;
	@Autowired
	private PeriodeRepository periodeRepository;
	
	@Autowired
	private List<Cotisation> cotisations;
	@Autowired
	private List<Grade> grades;
	@Autowired
	private List<Entreprise> entreprise;
	@Autowired
	private List<ProfilRemuneration> profils;

	@Override
	public void initialiser() {
		for (Cotisation c : cotisations) {
			cotisationRepository.save(c);
		}
		for (Entreprise e : entreprise) {
			entrepriseRepository.save(e);
		}
		for (ProfilRemuneration p : profils) {
			remunerationRepository.save(p);
		}
		for (Grade g : grades) {
			gradeRepository.save(g);
		
		for(int i=1; i<=12; i++) {
			periodeRepository.save(new Periode(i));
		}
		
	}
 
}
}
