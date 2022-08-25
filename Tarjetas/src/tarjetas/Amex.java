package tarjetas;

import java.sql.Date;

public class Amex implements MarcaTarjeta{

	//No puede dar mas que 5%
	@SuppressWarnings("deprecation")
	@Override
	public double calcularTasa(Date date) {
		int mes = date.getMonth() + 1;
		return (double)mes * 0.1;
	}
	
	@Override
	public String devolverNombreTarjeta() {
		return "Amex";
	}
}
