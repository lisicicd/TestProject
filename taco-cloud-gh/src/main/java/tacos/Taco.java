package tacos;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {
	
	private Long id;
	private Date createdAt;
	
	@NotNull
	@Size(min=5, message="Ime mora imati bar 5 karaktera!")
	private String name;
	@NotEmpty (message="Morate izabrati bar jedan sastojak!")
	private List<Ingredient> ingredients;
	 
}
