package dev.paie.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.paie.util.PaieUtils;

public class PaieUtilsTest {
	private ClassPathXmlApplicationContext context;
	private PaieUtils paieUtils;
	@Before
	public void onSetup() {
		context = new ClassPathXmlApplicationContext("app-config.xml");
		paieUtils = context.getBean(PaieUtils.class);
	}
	@Test
	public void test_formaterBigDecimal_entier_positif() {
	String resultat = paieUtils.formaterBigDecimal(new BigDecimal("2"));
	assertThat(resultat, equalTo("2.00"));
	}
	@Test
	public void test_formaterBigDecimal_trois_chiffres_apres_la_virgule() {
	String resultat = paieUtils.formaterBigDecimal(new BigDecimal("2.199"));
	assertThat(resultat, equalTo("2.20"));
	}
	@Test
	public void test_formaterBigDecimal_un_chiffres_apres_la_virgule() {
	String resultat = paieUtils.formaterBigDecimal(new BigDecimal("2.1"));
	assertThat(resultat, equalTo("2.10"));
	}
	@After
	public void onExit() {
		context.close();
	}

}
