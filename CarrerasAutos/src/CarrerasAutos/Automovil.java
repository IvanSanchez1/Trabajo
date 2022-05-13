package CarrerasAutos;

import java.util.concurrent.TimeUnit;

public class Automovil extends Posicion {
	private String color;
	private int id;
	private double vel, velMax = 4;

	public Automovil(String color) {
		super();
		// me imagino que esto lo podremos buscar desde la pantalla despues
		this.color = color;
		vel = 0;
		// tal vez nos es util mas adelante
		this.id = (int)(1000*Math.random());
	}

	public int getXPos() {
		return super.getX();
	}

	public int getYPos() {
		return super.getY();
	}

	public void setXPos(int x) {
		super.setX(x);
	}

	public void setYPos(int y) {
		super.setY(y);
	}

	public void moverseArriba() {

		// Hay que hacer que se pueda mover en los limites del mapa
//		if(this.getYPos() + 1 < mapa.getLargo()) {
		if (vel < velMax) {
			this.vel++;
		}
		this.setYPos(this.getYPos() + (int) vel);
//		}
		// tambien hay que considerar otros autos en el futuro
	}

	public void moverseIzquierda() {
		// Hay que hacer que se pueda mover en los limites del mapa
//		if(this.getXPos() - 1 > 0) {
		this.setXPos(this.getXPos() - 1);
//		}
		// tambien hay que considerar otros autos en el futuro
	}

	public void moverseDerecha() {
		// Hay que hacer que se pueda mover en los limites del mapa
//		if(this.getXPos() + 1 < mapa.getAncho()) {
		this.setXPos(this.getXPos() + 1);
//		}
		// tambien hay que considerar otros autos en el futuro
	}

	public void moverseRetroceder() {
		// Hay que hacer que se pueda mover en los limites del mapa
//		if(this.getYPos() - 1 > 0) {
		if (vel > 0) {
			this.vel--;
		}
		this.setYPos(this.getYPos() + (int) vel);
//		}
		// tambien hay que considerar otros autos en el futuro
	}

	public void chocar(Automovil auto) {
		// tenemos que hablar sobre si vamos a tener codigo corriendo todo el
		// tiempo viendo si colisionan 2 autos o vamos a usar una lista
		auto.recibirChoque();
	}

	public void recibirChoque() {
		// tiempo de penalizacion por chocar de 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// mueve al auto a otra X pero lo deja a la misma altura Y
		this.setXPos(1);
	}
}
