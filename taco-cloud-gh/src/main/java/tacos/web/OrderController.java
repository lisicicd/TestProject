package tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.Taco;
import tacos.Order;
import tacos.Ingredient;
import tacos.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		model.addAttribute("poruka", "Lovely Jubbly Taco Design Factory!!!");
		return "orderForm";
	}
	
	@PostMapping()
	public String processForm(@Valid Order order, Errors errors) {
		if(errors.hasErrors()) {
			return "orderForm";
		}
		// Save the Order
		log.info("Order submitted: " + order);
		return "redirect:/";
	}
	
	
}
