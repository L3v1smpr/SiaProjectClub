package controlador;
import java.util.HashMap;

import modelo.Actividad;
import modelo.Socio;

import java.util.ArrayList;


public class SistemaClub {

	// Primera instancia de atributo de SistemaClub - HashMap de Socio
	// Almacenará a los socios registrados dentro del club
	private HashMap<String, Socio> socios;
	
	// Instanciación para el arreglo que contendrá actividades
	// Tendrá la lista total de actividades registradas por el administrador
	private ArrayList<Actividad> actividades;
	
	
	// Constructor SistemaClub, encargado de inicializar las colecciones primarias
	public SistemaClub() {
		this.socios = new HashMap<>();
		this.actividades = new ArrayList<>();
	}
	
	// Método para registrar nuevo socio
	public boolean registrarSocio(String rut, String nombre, int edad) {
		
		// False si ya existe
		// True si se añadió correctamente
		
		if (socios.containsKey(rut)) {
			return false;
		}
		
		Socio nuevoSocio = new Socio(rut, nombre, edad, false);
		this.socios.put(rut, nuevoSocio);
		
		return true;
	}
	
	// Método para registrar nueva actividad
	public boolean registrarActividad(String nombre, int cupoMaximo, String idActividad) {
		
		//Recorremos el ArrayList para consultar si existe una actividad con el mismo id
		for (int i = 0; i < actividades.size(); i++) {
			Actividad actividadActual = actividades.get(i);
			if (actividadActual.getIdActividad().equals(idActividad)) {
				return false;
			}
		}
		
		//Si no existe añadimos una nueva actividad al ArrayList de actividades
		
		Actividad nuevaActividad = new Actividad(nombre, cupoMaximo, idActividad);
		
		this.actividades.add(nuevaActividad);
		return true;	
		
	}
	
	
	public boolean validarDisponibilidadInscribirSocioEnActividad(String rut, int indiceActividad) throws ExcepcionMorosidad, ExcepcionCupoMaximo {
		// Si el usuario ingresa un valor que no se encuentra en la lista de actividades, retorna false, de lo contrario retorna true
		if (indiceActividad < 0 || indiceActividad >= this.actividades.size()) {
			return false;
		}	
				
		// Si el mapa de socios no contiene el rut, el usuario no es socio, por lo que no puede inscribirse en la actividad
		if (!this.socios.containsKey(rut)) {
			return false;
		}
				
		// Obtenemos el socio y la actividad a trabajar
		Socio socioActual = this.socios.get(rut);
		Actividad actividadActual = this.actividades.get(indiceActividad);
				
				
		// Si el socio tiene una deuda, no puede inscribirse hasta pagarla -> a futuro mostraremos el dinero que debe 
		if (socioActual.isMoroso()) {
			throw new ExcepcionMorosidad("El socio con RUT: " + rut + "tiene una deuda activa.");
		}
				
		// Si el cupo maximo esta completo, el usuario no puede inscribirse por limite de cupos
		if (actividadActual.getReservas().size() >= actividadActual.getCupoMaximo()) {
			throw new ExcepcionCupoMaximo("La actividad: " + actividadActual.getNombre() + "no tiene cupos disponibles.")
		}
		
		return true;
	}
	
	
	// Método para inscribir socio existente a una actividad
	public void inscribirSocioEnActividad(String rut, int indiceActividad, String fechaDeseada) throws ExcepcionMorosidad, ExcepcionCupoMaximo {
		
		if (validarDisponibilidad(rut, indiceActividad)) {
			Actividad actividadActual = this.actividades.get(indiceActividad);
			int nuevoId = actividadActual.getReservas.size() + 1;
			
			Reserva nuevaReserva = new Reserva(nuevoId, fechaDeseada, rut, actividadActual.getIdActividad());
			actividadActual.agregarReserva(nuevaReserva);
		
			return true;
		}
		
		return false;	
	}
	
	
	public boolean cancelarReserva(String rut, int idActividad) {
		//...
	}
	
	public void purgarMorosos() {
		//...
	}
	
	public void cargarDatosIniciales() {
		//...
	}
	
	public ArrayList<Actividad> getActividades(){
		//...
	}
	
	public HashMap<String, Socio> getSocios(){
		//...
	}
	
	// Método getter para obtener las actividades dentro del ArrayList<Actividad>
	public ArrayList<Actividad> getActividades() {
		//...
	}
	
	// Método getter para obtener socios dentro de HashMap<Rut : String, Socio>
	public HashMap<String ,Socio> getSocios (){
		//...
	}
	
}
