package dev.paie.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EnreprisesRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private GradeRepository gradeRepository;
	@Autowired
	private EnreprisesRepository entrepriseRepository;
	@Autowired
	private ProfilRemunerationRepository profilRepository;
	@Autowired
	RemunerationEmployeRepository remunerationEmployeRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/init")
	public ModelAndView initPageEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("grades", gradeRepository.findAll());

		mv.addObject("entreprise", entrepriseRepository.findAll());

		mv.addObject("profil", profilRepository.findAll());
		return mv;

	}
	

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye(HttpServletRequest request) {

		String gradeIdString = request.getParameter("gradeId");
		Integer gradeId = Integer.parseInt(gradeIdString);
		Grade grade = gradeRepository.findOne(gradeId);

		String entrepriseIdString = request.getParameter("entrepriseId");
		Integer entrepriseId = Integer.parseInt(entrepriseIdString);
		Entreprise entreprise = entrepriseRepository.findOne(entrepriseId);

		RemunerationEmploye employe = new RemunerationEmploye();
		employe.setGrade(grade);
		employe.setEntreprise(entreprise);
		employe.setProfilRemuneration(null);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("prefixMatricule", "M00");
		return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmployes");
		mv.addObject("listeEmployes", remunerationEmployeRepository.findAll());		
		//entrepriseRepository.findAll().forEach(System.out::println);
		return mv;
	}

}
