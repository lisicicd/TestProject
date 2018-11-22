package tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.Taco;
import tacos.Ingredient;
import tacos.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
		  new Ingredient("FLTO", "Integralno brasno", Type.WRAP),
		  new Ingredient("COTO", "Kukuruzno brasno", Type.WRAP),
		  new Ingredient("GRBF", "Govodje", Type.PROTEIN),
		  new Ingredient("CARN", "Teletina", Type.PROTEIN),
		  new Ingredient("TMTO", "Paradajz kockice", Type.VEGGIES),
		  new Ingredient("LUKA", "Luk beli", Type.VEGGIES),
		  new Ingredient("CHED", "Cedar", Type.CHEESE),
		  new Ingredient("JACK", "Iriski", Type.CHEESE),
		  new Ingredient("SLSA", "Salsa ljuta", Type.SAUCE),
		  new Ingredient("SRCR", "Salsa blaga", Type.SAUCE)
		);
		
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
		  model.addAttribute(type.toString().toLowerCase(),
		      filterByType(ingredients, type));
		}
		
		model.addAttribute("poruka", "Lovely Jubbly Taco Design Factory!!!");
	}
	
	
	  @GetMapping
	  public String showDesignForm(Model model) {
	    model.addAttribute("design", new Taco());
	    return "design";
	  }
	

	  @PostMapping
	  public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, Model model) {
	    if (errors.hasErrors()) {
	      return "design";
	    }

	    // Save the taco design...
	    // We'll do this in chapter 3
	    log.info("Processing design: " + design);

	    return "redirect:/orders/current";
	  }
	

	
	
	
	private List<Ingredient> filterByType(
		      List<Ingredient> ingredients, Type type) {
		    return ingredients
		              .stream()
		              .filter(x -> x.getType().equals(type))
		              .collect(Collectors.toList());
		  }
	
}
