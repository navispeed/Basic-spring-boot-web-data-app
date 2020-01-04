package eu.navispeed.test.test.controller;

import eu.navispeed.test.test.model.Personnage;
import eu.navispeed.test.test.repository.PersonnageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by grimaceplume on 18/12/2019.
 */
@Controller
public class HomeController {
  private final PersonnageRepository personnageRepository;

  public HomeController(PersonnageRepository personnageRepository) {
    this.personnageRepository = personnageRepository;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("name", "test");
    model.addAttribute("personnages", personnageRepository.findAll());
    return "index";
  }

  @PostMapping
  public String form(@RequestParam(name = "nom") String nom, Model model) {
    personnageRepository.save(Personnage.builder().name(nom).build());
    List<Integer> integer = IntStream.range(1, 100).boxed().collect(Collectors.toList());
    model.addAttribute("name", nom);
    model.addAttribute("numbers", integer);
    model.addAttribute("personnages", personnageRepository.findAll());
    return "index";
  }
}
