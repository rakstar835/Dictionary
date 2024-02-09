package vocabvista.rk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vocabvista.rk.model.Dictionary;
import vocabvista.rk.service.DictionaryService;
import vocabvista.rk.utility.RecordNotFoundException;

@Controller
public class QGeniusController {
	
	@Autowired
	DictionaryService service;

	@GetMapping("/")
	public String getAllEmployees(Model model) {
		Dictionary mcsc = new Dictionary();
		model.addAttribute("mcsc", mcsc);
		return "home";
	}

	@GetMapping("/list")
	public String showEmployee(Model model) {
		List<Dictionary> list = service.getAllItems();
		model.addAttribute("mcsc", list);
		return "mcsclist";
	}

	@PostMapping("/saveMCSC")
	public String saveEmployee(@ModelAttribute("mcsc") Dictionary mcsc) throws RecordNotFoundException {
		service.createOrUpdateMCSC(mcsc);
		return "redirect:/list";
	}

}
