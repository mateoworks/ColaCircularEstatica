package main;

import colacircular.ColaCircular;

public class Main {

	public static void main(String[] args) {
		ColaCircular<Object> cola = new ColaCircular<>(3);
		cola.agregar(1);
		cola.agregar(2);
		cola.agregar(3);
		cola.agregar(4);
		System.out.println(cola);
		System.out.println(cola.quitar());
	}

}
