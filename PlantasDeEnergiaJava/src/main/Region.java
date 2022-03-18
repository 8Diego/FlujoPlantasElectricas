package main;

import java.util.List;

public class Region {
	public String nombre;
	public int id;
	public List<Ciudad> ciudad;
	public Region(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
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
	public List<Ciudad> getCiudad() {
		return ciudad;
	}
	public void setCiudad(List<Ciudad> ciudad) {
		this.ciudad = ciudad;
	}
}
