package colacircular;

public interface IColaEstatica<T> {
	public boolean estaLlena();
	public boolean estaVacia();
	public void agregar(T elemento);
	public T mostrar();
	public T quitar();
	public int numeroElementos();
}
