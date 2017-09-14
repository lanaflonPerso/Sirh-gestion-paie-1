package dev.paie.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public void creerEmploye(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");

		RemunerationEmploye employe = new RemunerationEmploye();
		employe.setMatricule(request.getParameter("matricule"));
		employe.setGrade(gradeRepository.findOne(Integer.parseInt(request.getParameter("gradeId"))));
		employe.setEntreprise(entrepriseRepository.findOne(Integer.parseInt(request.getParameter("entrepriseId"))));
		employe.setProfilRemuneration(profilRepository.findOne(Integer.parseInt(request.getParameter("profilId"))));

		remunerationEmployeRepository.save(employe);

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmployes");
		mv.addObject("listeEmployes", remunerationEmployeRepository.findAll());

		return mv;
	}

}
