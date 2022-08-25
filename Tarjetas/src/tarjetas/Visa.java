package tarjetas;

import java.sql.Date;

public class Visa implements MarcaTarjeta{

	//Pongo un limite de 5% como dice el enunciado
	@SuppressWarnings("deprecation")
	@Override
	public double calcularTasa(Date date) {
		int mes = date.getMonth() + 1;
		int anio = date.getYear() - 100;
		if((double)anio/(double)mes > 5) {
			return 5;
		}
		return (double)anio/(double)mes;
	}
	
	@Override
	public String devolverNombreTarjeta() {
		return "Visa";
	}
}
