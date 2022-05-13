package CarrerasAutos;

public abstract class Posicion {
	private int x, y, cantMax = 4;

	public Posicion() {
		// solo deja entrar a una cantidad predefinida de jugadores
		for (int i = 0; i < cantMax; i++) {
			// placeholder todavia no aclaramos como detectar otros autos
			this.x = i;
		}
		this.y = 0;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
