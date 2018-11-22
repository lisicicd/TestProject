package tacos;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {
	
	@NotNull
	@Size(min=5, message="Ime mora imati baz 5 karaktera")
	private String name;
	@Size(min=1, message="Morate izabrati bar jedan sastojak")
	private List<String> ingredients;
	
	
}
