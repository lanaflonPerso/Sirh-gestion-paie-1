package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Service
public class CotisationServiceJpa implements CotisationService {
	@PersistenceContext private EntityManager em;

	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
		
	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		Cotisation cotis = em.find(Cotisation.class, cotisation.getId());		
		cotisation.setCode(cotisation.getCode());
		cotis.setLibelle(cotisation.getLibelle());
		cotis.setTauxSalarial(cotisation.getTauxSalarial());
		cotis.setTauxPatronal(cotisation.getTauxPatronal());
		em.persist(cotis);
	
	}

	@Override
	public List<Cotisation> lister() {
		System.out.println("query 1: ");
		Query query = em.createQuery("SELECT e FROM Cotisation e");
	    return (List<Cotisation>) query.getResultList();
	}

	
}
