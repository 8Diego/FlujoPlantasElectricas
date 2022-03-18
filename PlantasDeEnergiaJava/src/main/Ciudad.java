package main;

public class Ciudad {

	public String nombre;
	public int id;
	public Ciudad(String nombre, int id) {
		this.nombre =nombre;
		this.id =id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
