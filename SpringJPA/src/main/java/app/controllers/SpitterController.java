package app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.pojos.Spitter;
import app.repository.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpitterRepository repo;

	@Autowired
	public SpitterController(SpitterRepository repo) {
		this.repo = repo;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute(new Spitter());
		return "requestForm";
	}

	@RequestMapping(value = "/register/{username}", method = RequestMethod.GET)
	public String find(@PathVariable String username, Model model) {
		Spitter spitter = repo.getByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String save(@Valid Spitter spitter, Errors errors) {
		if(errors.hasErrors())
			return "/register";
		repo.save(spitter);
		return "redirect:/spitter/register/" + spitter.getUsername();
	}

}
