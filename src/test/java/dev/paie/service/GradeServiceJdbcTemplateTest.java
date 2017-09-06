package dev.paie.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

@ContextConfiguration(classes = { DataSourceMySQLConfig.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;
	@Autowired
	private Grade nouveauGrade;

	@Autowired
	private Grade updateGrade;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		// TODO sauvegarder un nouveau grade

		List<Grade> tab = new ArrayList<Grade>();
		tab = gradeService.lister();

		int taille = tab.size();

		nouveauGrade.setCode("test");
		nouveauGrade.setNbHeuresBase(new BigDecimal(63.5));
		nouveauGrade.setTauxBase(new BigDecimal(100));
		gradeService.sauvegarder(nouveauGrade);

		tab = gradeService.lister();
		int apres = tab.size();
		assertEquals(taille + 1, apres);

		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode
		// lister

		assertTrue(tab.contains(nouveauGrade));

		// TODO modifier un grade
		// 1 - ajout de l'élément util dans la table
		String code = "util";
		nouveauGrade.setCode(code);
		nouveauGrade.setNbHeuresBase(new BigDecimal(6.3));
		gradeService.sauvegarder(nouveauGrade);

		// récupération des données de la table avec la fonction lister
		tab = gradeService.lister();
		assertTrue(tab.contains(nouveauGrade));

		// 2- tri des objets Grade selon leur code : "util"
		List<Grade> trier = tab.stream().filter(grade -> grade.getCode().equals(code)).collect(Collectors.toList());

		// 3- Modification de nouveauGrade
		updateGrade.setCode("toto");
		updateGrade.setNbHeuresBase(new BigDecimal(12.0));
		updateGrade.setTauxBase(new BigDecimal(6.0));

		// TODO vérifier que les modifications sont bien prises en compte via la méthode
		// lister
		tab = gradeService.lister();
		assertTrue(tab.contains(nouveauGrade));

	}
}
