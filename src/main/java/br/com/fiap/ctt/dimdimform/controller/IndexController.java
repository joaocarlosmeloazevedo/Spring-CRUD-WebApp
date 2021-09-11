package br.com.fiap.ctt.dimdimform.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.ctt.dimdimform.model.Form;
import br.com.fiap.ctt.dimdimform.repository.FormRepository;

@Controller
public class IndexController {
	@Autowired
	private FormRepository repository;

	@GetMapping("/index")
	public String indexPage() {
		return "index";
	}

	@GetMapping("/cadastro")
	public String cadastroPage() {
		return "cadastro";
	}

	@PostMapping("/cadastro/add") // value="add"
	public String saveData(Form form) {
		repository.save(form);
		return "form";
	}

	@GetMapping("/form")
	public ModelAndView showForm() // FormRepository repository
	{
		ModelAndView modelAndView = new ModelAndView("form");
		List<Form> form = repository.findAll();
		modelAndView.addObject("form", form);
		return modelAndView;
		// List<Form> form =(List<Form>) repository.findAll();
		// return form;
	}

	@GetMapping("/update/{id}")
	public ModelAndView editForm(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("update");
		Form form = repository.findById(id).orElse(null);
		mv.addObject("form", form);
		return mv;
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, @Valid Form newForm) {
		Optional<Form> optional = repository.findById(id);
		
		Form form = optional.get();
		form.setEmail(newForm.getEmail());
		form.setNome(newForm.getNome());
		form.setEmpresa(newForm.getEmpresa());
		repository.save(form);
		return "form";
	}

	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable("id") int id) {
		repository.deleteById(id);
		return "index";
	}
}
