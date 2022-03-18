package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class SistemaElectrico {

	/*=========METODOS LLAMADOS EN EL MENU===========*/
	public static List<PlanElectrica> metodo1() {
		List<PlanElectrica> setDatos = LlenarPlantaElectrica();
		System.out.println("Ingrese el nombre de una planta");
		String planta = sc.nextLine();
		System.out.println("Ingrese el nombre de una Ciudad");
		String ciudad = sc.nextLine();
		PlanElectrica consumoPLantaCiudad = ConsumoTotalPlantaCiudad(planta, ciudad, setDatos);
		if(consumoPLantaCiudad.getError() == "OK") {
			System.out.println("El consumo total de megavatios de la planta " +planta+ " Ciudad: " +ciudad+ " es:" +consumoPLantaCiudad.getTotalConsumo());
		}else {
			System.out.println(consumoPLantaCiudad.getError());
		}
		return setDatos;
	}
	
	public static void metodo2(List<Region> regionList,List<PlanElectrica> setDatos) {
		System.out.println("Ingrese el nombre de una region");
		String region = sc.nextLine();
		PlanElectrica consumoPorRegion = ConsumoTotalPorRegion(region, regionList,setDatos);
		if(consumoPorRegion.getError() == "OK") {
			System.out.println("Recaudacion de la region Sierra"  +consumoPorRegion.getTotaltarifa());
		}else {
			System.out.println(consumoPorRegion.getError());
		}
	}
	
	public static void metodo3(List<PlanElectrica> setDatos) {
		System.out.println("Ingrese el nombre de una Ciudad");
		String ciudadnew = sc.nextLine();
		IngresarPlantaCiudad(ciudadnew, setDatos);
	}
	/*=========METODOS LLAMADOS EN EL MENU===========*/
	
	
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		List<PlanElectrica> setDatos = LlenarPlantaElectrica();
		List<Region> regionList = LlenarCiudadPorRegion();
		//metodo2(regionList,setDatos);
		//metodo3(setDatos);
		boolean control = true;
		Scanner leer;
		int item;
		while (control) {
			leer = new Scanner(System.in);
			System.out.println("\n******* MENÚ *******\n");
			System.out.println("1. Consultar Total de Megavatios por Ciudad y Planta");
			System.out.println("2. Ingresar una Region y Presentar el total de recaudos");
			System.out.println("3. Ingresar nueva ciudad, consultar el total de megavatio de las planta y ciudades");
			System.out.println("4. Salir\n");

			System.out.print("Escoja una opción: ");
			item = leer.nextInt();

			if (item == 1) {
				setDatos = metodo1();
			}

			if (item == 2) {
				metodo2(regionList,setDatos);	
			}
			
			if (item == 3) {
				metodo3(setDatos);
			}

			if (item == 4) {
				System.out.print("\nSalió del menú");
				control = false;
			}

		}
	}
	
	
	/*=================METODOS DE BASE DE DATOS=================*/
	public static List<PlanElectrica> LlenarPlantaElectrica(){
		//Definir Instancias
		PlanElectrica planta = new PlanElectrica();
		PlanElectrica planta2 = new PlanElectrica();
		List<PlanElectrica> miLista = new ArrayList<PlanElectrica>();
		//Inicializar Listas
		planta.ciudad = new ArrayList<Ciudad>();
		planta.consumo= new ArrayList<Consumo>();
		planta2.ciudad = new ArrayList<Ciudad>();
		planta2.consumo= new ArrayList<Consumo>();
		Consumo consumo;
		
		/*Planta : Cocacodo Sinclair Ciudad: Quito*/
		planta.setNombre("Cocacodo Sinclair");
		planta.setTarifa(65);
		Ciudad ciudad = new Ciudad("Quito",1717);
		consumo = new Consumo();
		consumo.setCantidad(400);
		planta.ciudad.add(ciudad);
		planta.consumo.add(consumo);
		//Consumo II de la ciudad de Quito
		consumo = new Consumo();
		consumo.setCantidad(800);
		planta.consumo.add(consumo);
		
		/*Planta : Cocacodo Sinclair Ciudad: Guayaquil*/
		Ciudad ciudadg = new Ciudad("Guayaquil",1818);
		consumo = new Consumo();
		consumo.setCantidad(120);
		planta.ciudad.add(ciudadg);
		planta.consumo.add(consumo);
		miLista.add(planta);
		
		/*Planta: Sopladora */
		planta2.setNombre("Sopladora");
		planta2.setTarifa(12);
		Ciudad ciudadII = new Ciudad("Guayaquil",1111);
		consumo = new Consumo();
		consumo.setCantidad(120);
		planta2.ciudad.add(ciudadII);
		planta2.consumo.add(consumo);
		
		/*Sopladora: Quito*/
		Ciudad ciudadQ = new Ciudad("Quito",1112);
		consumo = new Consumo();
		consumo.setCantidad(120);
		planta2.ciudad.add(ciudadQ);
		planta2.consumo.add(consumo);
		
		/*Sopladora: Loja*/
		Ciudad ciudadL = new Ciudad("Loja",1112);
		consumo = new Consumo();
		consumo.setCantidad(120);
		planta2.ciudad.add(ciudadL);
		planta2.consumo.add(consumo);
		miLista.add(planta2);
		
		return miLista;
	}

	public static List<Region> LlenarCiudadPorRegion() {
		List<Region> regionList = new ArrayList<Region>(); 
		/*Region Costa*/
		Region region = new Region("costa", 1000);
		region.ciudad = new ArrayList<Ciudad>();
		Ciudad ciudad = new Ciudad("Guayaquil",1010);
		Ciudad ciudad2 = new Ciudad("Manta",1010);
		region.ciudad.add(ciudad);
		region.ciudad.add(ciudad2);
		regionList.add(region);
		/*Region Sierra*/
		Region regions = new Region("sierra", 2000);
		regions.ciudad = new ArrayList<Ciudad>();
		Ciudad ciudads = new Ciudad("Quito",2010);
		Ciudad ciudad3 = new Ciudad("Ambato",2010);
		regions.ciudad.add(ciudads);
		regions.ciudad.add(ciudad3);
		regionList.add(regions);
		/*Region Oriente*/
		Region regiono = new Region("oriente", 3000);
		regiono.ciudad = new ArrayList<Ciudad>();
		Ciudad ciudado = new Ciudad("Tena",3010);
		Ciudad ciudad4 = new Ciudad("Nueva Loja",3010);
		regiono.ciudad.add(ciudado);
		regiono.ciudad.add(ciudad4);
		regionList.add(regiono);
		return regionList;
	}
	
	/*=================METODOS DE BASE DE DATOS=================*/
	
	/*=================METODOS DE LOGICA========================*/
	public static PlanElectrica ConsumoTotalPlantaCiudad(String outplanta, String outciudad, List<PlanElectrica> setDatos) {		
		PlanElectrica planta = new PlanElectrica();
		int total = 0;
		for (PlanElectrica element : setDatos) {
			
			if(element.getNombre().equalsIgnoreCase(outplanta)) {
				
				for (Ciudad ciudad : element.getCiudad()) {
					if(ciudad.getNombre().equalsIgnoreCase(outciudad)) {
						
						for (Consumo consumo : element.getConsumo()) {
							total = total + consumo.getCantidad() ;   
						}
						planta.setError("OK");
						planta.setTotalConsumo(total);
						return planta;
					}else {
						//Valida que la ciudad no cuenta con registros
						planta.setError("La ciudad no cuenta en los registros de la planta " + element.getNombre());		
					}
				}
				
			} else {
				//Valida que la planta que se ingreso no se encuentra en los registros
				planta.setError("La planta Ingresada no cuenta en los registros");
			}
		}
		return planta;
	}

	public static PlanElectrica ConsumoTotalPorRegion(String region, List<Region> regionList, List<PlanElectrica> setDatos) {
		PlanElectrica electrica = new PlanElectrica(); 
		double tarifaTotal = 0.0;
		double Total = 0.0;
		for (Region item : regionList) {
			if(item.getNombre() == "sierra") {
				for (PlanElectrica item2 : setDatos) {
					for (Ciudad ciudad : item2.getCiudad()) {
						if(ciudad.getId() == 1717) { //Codigo Para Ciudades de la Sierra
							for (Consumo consumo : item2.getConsumo()) {
								tarifaTotal = tarifaTotal + consumo.getCantidad();
								Total = tarifaTotal * item2.getTarifa();
							}
							electrica.setError("OK");
							electrica.setTotaltarifa(Total);
							return electrica;
						}
					}
				} 
			}else {
				electrica.setError("La region Solicitada no se encuentra en el catalogo");
			}
		}
		return electrica;
	}

	public static List<PlanElectrica> IngresarPlantaCiudad(String ciudadnew, List<PlanElectrica> setDatos) {
		double tarifaTotal = 0.0;
		double Total = 0.0;
		PlanElectrica planta = new PlanElectrica();
		planta.ciudad = new ArrayList<Ciudad>();
		planta.consumo= new ArrayList<Consumo>();
		Ciudad ciudad = new Ciudad(ciudadnew,8000);
		Consumo consumo = new Consumo();
		consumo.setCantidad(400);
		for (PlanElectrica item : setDatos) {
			item.ciudad.add(ciudad);
			item.consumo.add(consumo);
			planta.ciudad.add(ciudad);
			planta.consumo.add(consumo);
		}
		setDatos.add(planta);
		
		System.out.println("Se ah agregado la ciudad " +ciudadnew +" A las plantas ingresadas");
		//Recorrer para saber la cantidad de megabatios
		for (PlanElectrica item2 : setDatos) {
			for (Ciudad item3 : item2.getCiudad()) {
				for (Consumo consumoItem : item2.getConsumo()) {
					tarifaTotal = tarifaTotal + consumoItem.getCantidad();
					Total = tarifaTotal * item2.getTarifa();
				}
				if(item2.getNombre() != null) {
					System.out.println("La planta: "+item2.getNombre()+" "+"EL Total recaudado de la ciudad de "+ item3.nombre+ " es: " +Total);
				}
			}
			
		}
		return setDatos; 
	}
	
	
}
