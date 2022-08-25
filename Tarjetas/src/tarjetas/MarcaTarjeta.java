package tarjetas;

import java.sql.Date;

public interface MarcaTarjeta {

	public double calcularTasa(Date date);
	public String devolverNombreTarjeta();
}
