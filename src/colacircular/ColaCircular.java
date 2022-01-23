package colacircular;

/**
 * Clase genérica que simula una cola circular, una estructura FIFO
 * First in, firts out
 * 
 * @author Mateo Mtz.
 * @param <T> tipo de datos para la cola
 * @since 1.0.0
 */
public class ColaCircular<T> implements IColaEstatica<T>{
	/**
	 * Apuntador al frente de la cola, donde se quitan los elementos
	 */
	private int frente;
	/**
	 * Apuntador al final de los elementos, por donde se agregan elementos
	 */
	private int posterior;
	/**
	 * Tamaño de la cola
	 */
	private int tamanio;
	/**
	 * Número de elementos que tiene agregado la cola
	 */
	private int numeroElementos;
	/**
	 * Arreglo que almacenará los elementos
	 */
	private Object cola[];

	/**
	 * Constructor, se inicializan los atributos y se crea el arreglo
	 * @param n
	 */
	public ColaCircular(int n) {
		if(n < 1) {
			throw new IllegalArgumentException(
					"El tamaño debe ser mayor a 0");
		}
		this.cola = new Object[n];
		this.frente = this.posterior = this.numeroElementos = 0;
		this.tamanio = n;
	}

	/**
	 * Función para calcular el incremento
	 * @param i  frente o posterior
	 * @return   frente o posterior incrementados
	 */
	private int incremento(int i) {
		return (i + 1) % tamanio;
	}
	
	/**
	 * Comprueba si la cola esta llena
	 * @return true si la cola esta llena
	 *         false si esta vacía
	 */
	@Override
	public boolean estaLlena() {
		return numeroElementos == tamanio;
	}
	
	/**
	 * Comprueba si la cola esta vacía
	 * @return true si esta vacía
	 *         false si no esta vacía
	 */
	@Override
	public boolean estaVacia() {
		return numeroElementos == 0;
	}
	
	/**
	 * Agregar elementos a la cola si no esta llena (enqueue)
	 * @param Elemento que se desea agregar
	 */
	@Override
	public void agregar(T elemento) {
		if(!estaLlena()) {
			this.cola[posterior] = elemento;
			posterior = incremento(posterior);
			numeroElementos++;
		}else {
			System.out.println("Cola llena");
		}
	}
	
	/**
	 * Retorna el primer elemento sin quitarlo (peek)
	 * @return primer elemento agregado
	 *         null si esta vacío
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T mostrar() {
		if(!estaVacia()) {
			return (T) cola[this.frente];
		}
		System.out.println("Cola vacía");
		return null;
	}

	/**
	 * Quita el primer elemento agregado (dequeue)
	 * @return elemento quitado
	 *         nulo si esta vacío
	 */
	@Override
	public T quitar() {
		if(!estaVacia()) {
			T elemento = mostrar();
			this.cola[frente] = null;
			this.frente = incremento(this.frente);
			numeroElementos--;
			return elemento;
		}
		System.out.println("Pila vacía");
		return null;
	}
	
	@Override
	public int numeroElementos() {
		return numeroElementos;
	}
	
	public String toString() {
		String cadena = "[";
		for(int i = 0; i < cola.length; i++) {
			if(this.cola.length - 1 == i)
				cadena += this.cola[i] + "]";
			else
				cadena += this.cola[i] + ", ";
		}
		return cadena;
	}
}