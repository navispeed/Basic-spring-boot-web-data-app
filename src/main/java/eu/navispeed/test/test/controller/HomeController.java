package eu.navispeed.test.test.controller;

import eu.navispeed.test.test.model.Personnage;
import eu.navispeed.test.test.repository.PersonnageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by grimaceplume on 18/12/2019.
 */
@Controller("/")
public class HomeController {
  private final PersonnageRepository personnageRepository;

  public HomeController(PersonnageRepository personnageRepository) {
    this.personnageRepository = personnageRepository;
  }

  @GetMapping
  public String index(Model model) {
    model.addAttribute("name", "test");
    model.addAttribute("personnages", personnageRepository.findAll());
    return "index";
  }

  @PostMapping
  public String form(@RequestParam(name = "nom") String nom, Model model) {
    personnageRepository.save(Personnage.builder().name(nom).build());
    return "redirect:/";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable(name = "id") Integer id) {
    personnageRepository.delete(Personnage.builder().id(id).build());
    return "redirect:/";
  }
}
