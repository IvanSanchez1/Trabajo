package CarrerasAutos;

import java.util.concurrent.TimeUnit;

public class Automovil {
	private PosicionAuto pos;
	private String color;
	private int id;
	
	public Automovil(String color, int id) {
		this.color = color;
		this.id = id;
		this.pos = new PosicionAuto();
	}
	
	public int getXPos() {
		return this.pos.getX();
	}
	
	public int getYPos() {
		return this.pos.getY();
	}
	
	public void setXPos(int x) {
		this.pos.setX(x);
	}
	
	public void setYPos(int y) {
		this.pos.setY(y);
	}
	
	public void moverse(int x, int y) {
		//Hay que hacer que se pueda mover en los limites del mapa
//		if(x + this.getXPos() < mapa.getAncho() && x + this.getXPos() > 0) {
			this.setXPos(this.getXPos() + x);
//		}
			
//		if(y + this.getYPos() < mapa.getLargo() && y + this.getYPos() > 0) {
			this.setYPos(this.getYPos() + y);
//		}
		//tambien hay que considerar otros autos en el futuro
	}
	
	public void recibirChoque() {
		//tiempo de penalizacion por chocar de 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//mueve al auto a otra X pero lo deja a la misma altura Y
		this.setXPos(1);
	}
}
