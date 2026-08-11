package controlador;
import java.util.HashMap;
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
	public void registrarSocio(String rut, String nombre, int Edad, boolean estado) {
		// No quiero imprimir aquí la salida en caso de que el rut ya exista
		// ¿Cómo puedo imprimirlo desde menuConsola/menuVentana?
		
		
		// Posible opción : Utilizar funciones con retorno booleano, False si ya existe
		// True si se añadió correctamente
	}
	
	// Método para registrar nueva actividad
	public void registrarActividad(String nombre, int cupoMaximo, String id) {
		//...
	}
	
	// Método para inscribir socio existente a una actividad
	public void inscribirSocioEnActividad(String rut, int indiceActividad) {
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
