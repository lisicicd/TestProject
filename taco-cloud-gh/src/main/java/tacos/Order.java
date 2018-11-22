package tacos;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
public class Order {
	@NotBlank(message="Vase ime i prezime je neophodan podatak")
	private String name;
	@NotBlank(message="Naziv ulice je neophodan")
	private String street;
	@NotBlank(message="Naziv grada je neophodan")
	private String city;
	@NotBlank(message="Naziv drzave je neophodan")
	private String state;
	@NotBlank(message="Postanski broj je neophodan")
	private String zip;
	@CreditCardNumber(message="Unesite ispravan broj kreditne kartice")
	private String ccNumber;
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$", 
			 message="Unesite datum isteka kreditne kartice u formi MM/YY")
	private String ccExpiration;
	@Digits(integer=3, fraction=0, message="Neispravan CVV")
	private String ccCVV;
}
