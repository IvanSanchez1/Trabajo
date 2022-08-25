package tarjetas;

import java.sql.Date;

public class Nara implements MarcaTarjeta{

	//Pongo un limite de 5% como dice el enunciado
	@SuppressWarnings("deprecation")
	@Override
	public double calcularTasa(Date date) {
		int dia = date.getDate();
		if((double)dia * 0.5 > 5) {
			return 5;
		}
		return (double)dia * 0.5;
	}
	
	@Override
	public String devolverNombreTarjeta() {
		return "Nara";
	}
}
