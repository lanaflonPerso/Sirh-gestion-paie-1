package dev.paie.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)

public class CotisationServiceJpaTest {
	
	@Autowired
	private CotisationService cotisationService;
	
	@Autowired
	private List<Cotisation> listeCotisation;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la
		// méthode lister
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la m
		// éthode lister

		{// test insertion en base
			System.out.println(listeCotisation.get(0));
			cotisationService.sauvegarder(listeCotisation.get(0));
			List<Cotisation> cotisations = cotisationService.lister();
			System.out.println(cotisations);
			assertTrue(!cotisations.isEmpty());
			assertEquals(1, cotisationService.lister().size());
		}
		{
			List<Cotisation> cotisations = cotisationService.lister();
			if (!cotisations.isEmpty()) {
				Cotisation updated = cotisations.get(0);
				updated.setCode("souf");
				cotisationService.mettreAJour(updated);
				System.out.println(updated);
				cotisations = cotisationService.lister();
				System.out.println(cotisations);
				assertTrue(updated.equals(cotisations.get(0)));

			}
		}
	}
}
