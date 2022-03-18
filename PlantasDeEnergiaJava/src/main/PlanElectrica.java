package main;

import java.util.List;

public class PlanElectrica {
	public int id;
	public String nombre;
	public String error;
	public int totalConsumo;
	public List<Ciudad> ciudad;
	public List<Consumo> consumo;
	public double tarifa;
	public double Totaltarifa;
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
	public double getTarifa() {
		return tarifa;
	}
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	public List<Consumo> getConsumo() {
		return consumo;
	}
	public void setConsumo(List<Consumo> consumo) {
		this.consumo = consumo;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public int getTotalConsumo() {
		return totalConsumo;
	}
	public void setTotalConsumo(int totalConsumo) {
		this.totalConsumo = totalConsumo;
	}
	public double getTotaltarifa() {
		return Totaltarifa;
	}
	public void setTotaltarifa(double totaltarifa) {
		Totaltarifa = totaltarifa;
	}
}
