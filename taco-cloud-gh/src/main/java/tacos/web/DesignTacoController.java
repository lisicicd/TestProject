package tacos.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tacos.Taco;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Order;
import tacos.data.TacoRepository;
import tacos.data.IngredientRepository;


@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
  
	private final IngredientRepository ingredientRepo;
  	private TacoRepository designRepo;

  	@Autowired
  	public DesignTacoController(
        IngredientRepository ingredientRepo, 
        TacoRepository designRepo) {
  			this.ingredientRepo = ingredientRepo;
  			this.designRepo = designRepo;
  	}

	//tag::modelAttributes[]
	 @ModelAttribute(name = "order")
	 public Order order() {
	   return new Order();
	 }
	 
	 @ModelAttribute(name = "taco")
	 public Taco taco() {
	   return new Taco();
	 }
  
	 @ModelAttribute
	 public void addIngredientsToModel(Model model) {
	  	List<Ingredient> ingredients = new ArrayList<>();
	    ingredientRepo.findAll().forEach(i -> ingredients.add(i));
	    
	    Type[] types = Ingredient.Type.values();
	    for (Type type : types) {
	      model.addAttribute(type.toString().toLowerCase(), 
	          filterByType(ingredients, type));      
	    }
	    
	    model.addAttribute("poruka", "Lovely Jubbly Taco Design Factory!!!");
	 }
  
	 @GetMapping
  		public String showDesignForm(Model model) {
  		model.addAttribute("taco", new Taco());
  		return "design1";
  		}

	 @PostMapping
	  public String processDesign(
	     @Valid  @ModelAttribute("taco")Taco taco, Errors errors, Model model,
	     @ModelAttribute Order order) {
		 System.out.println("ERROR");
		 System.out.println(taco);
		 System.out.println(errors);
		 if (errors.hasErrors()) {
			 return "design1";
		 }
		 System.out.println("OK");
	    Taco saved = designRepo.save(taco);
	    order.addDesign(saved);

	    return "redirect:/orders/current";
	  }

//	 @PostMapping
//	 public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, Model model) {
//	    if (errors.hasErrors()) {
//	      return "design1";
//	    }
//	    //    Taco saved = designRepo.save(design);
//	    //    order.addDesign(saved);
//	    return "redirect:/orders/current";
//	 }

  
	 private List<Ingredient> filterByType(
			 List<Ingredient> ingredients, Type type) {
		 return ingredients
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
	 }

	}
