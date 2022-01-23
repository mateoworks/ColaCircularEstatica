# Cola estática círcular con Java

La cola estática circular se construye con un arreglo, la parte que lo hace especial, es que se simula un arreglo circular, así se optimizan los procesos al quitar un elemento de la cola, en el caso de la cola estática simple, para quitar un elemento se tiene que desplazar los elementos posteriores hacia el frente en uno. En el caso de la cola circular no, se tienen dos apuntadores a los índices del arreglo, uno en el frente y uno en el posterior, en el frente se van quitando los elementos y el posterior se van agregando.

# Uso

Este proyecto fue realizado con el IDE Eclipse, por lo tanto se recomienda abrirlo con el mismo. Más detalles sobre la cola circular estática [aquí](https://gobitza.com/cola-estatica-circular-con-java/)

# Operaciones básicas de una cola circular

## Incremento para la cola circular

```Java
private int incremento(int i) {
	return (i + 1) % tamanio;
}
```

## Cola vacía

Para realizar esta operación, crearemos un contador de elementos, este nos indicará la cantidad de elementos en la cola, cuando esté en ceros, entonces la cola está vacía, de lo contrario, no lo esta.

```Java
public boolean estaVacia() {
	return numeroElementos == 0;
}
```

## Cola llena

En esta operación, volvemos a ocupar el contador de elementos, lo comparamos con el tamaño del arreglo, si es igual, entonces la cola esta llena, de lo contrario, no lo esta.

```Java
public boolean estaLlena() {
	return numeroElementos == tamanio;
}
```

## Agregar elementos, encolar (enqueue)

Para agregar un elemento, primero comprobamos que no este llena, sino lo esta, procedemos a agregar el elemento en el índice posterior, realizamos el incremento de posterior usando la función incremento y finalmente incrementamos el contador numeroElmentos.

```Java
public void agregar(T elemento) {
	if(!estaLlena()) {
		this.cola[posterior] = elemento;
		posterior = incremento(posterior);
		numeroElementos++;
	}else {
		System.out.println("Cola llena");
	}
}
```

## Mostrar primer elemento sin quitarlo (peek)

El primer elemento agregado está apuntado por el indicador frente, por lo tanto, para obtener el primer elemento, primero validar si la cola no está vacía, sino lo esta, retornar el elemento que está en la posición del frente, de lo contrario, retornar nulo.

```Java
public T mostrar() {
	if(!estaVacia()) {
		return (T) cola[this.frente];
	}
	System.out.println("Cola vacía");
	return null;
}
```

## Quitar primer elemento (dequeue)

En las colas, el primero que entra es el primero que sale, para quitar el primer elemento, primero se valida si la cola no está vacía, si no lo esta creamos una variable temporal para guardar el elemento de la cola en la posición del frente, colocamos el arreglo en la posición del frente en nulo, incrementamos el frente usando la función incremento, incrementamos el contador numeroElementos en uno y procedemos a retornar el valor de la variable temporal. Si está vacía, mostramos un mensaje de cola vacía.

```Java
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
```
