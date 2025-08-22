package Model;



class Nodo {
    private int dato;
    private Nodo siguiente;
    
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    public int getDato() {
        return dato;
    }
    
    public void setDato(int dato) {
        this.dato = dato;
    }
    
    public Nodo getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

public class ListaEnlazadaSimple {
    private Nodo cabeza;
    private int tamaño;
    
    public ListaEnlazadaSimple() {
        this.cabeza = null;
        this.tamaño = 0;
    }
    
    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamaño++;
    }
    
    public void insertarEnPosicion(int indice, int dato) {
        if (indice < 0 || indice > tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        
        if (indice == 0) {
            insertarAlInicio(dato);
            return;
        }
        
        Nodo nuevoNodo = new Nodo(dato);
        Nodo actual = cabeza;
        
        for (int i = 0; i < indice - 1; i++) {
            actual = actual.getSiguiente();
        }
        
        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);
        tamaño++;
    }
    
    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
        tamaño++;
    }
    
    public boolean eliminar(int dato) {
        if (cabeza == null) {
            return false;
        }
        
        if (cabeza.getDato() == dato) {
            cabeza = cabeza.getSiguiente();
            tamaño--;
            return true;
        }
        
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato() == dato) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                tamaño--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        
        return false;
    }
    
    public void eliminarEnPosicion(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        
        if (indice == 0) {
            cabeza = cabeza.getSiguiente();
            tamaño--;
            return;
        }
        
        Nodo actual = cabeza;
        for (int i = 0; i < indice - 1; i++) {
            actual = actual.getSiguiente();
        }
        
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        tamaño--;
    }
    
    public int buscar(int dato) throws ElementoNoEncontradoException {
        Nodo actual = cabeza;
        int indice = 0;
        
        while (actual != null) {
            if (actual.getDato() == dato) {
                return indice;
            }
            actual = actual.getSiguiente();
            indice++;
        }
        
        throw new ElementoNoEncontradoException("El elemento " + dato + " no se encuentra en la lista");
    }
    
    public boolean contiene(int dato) {
        try {
            buscar(dato);
            return true;
        } catch (ElementoNoEncontradoException e) {
            return false;
        }
    }
    
    public int sumaRecursiva() {
        return sumaRecursivaAuxiliar(cabeza);
    }
    
    private int sumaRecursivaAuxiliar(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        
        return nodo.getDato() + sumaRecursivaAuxiliar(nodo.getSiguiente());
    }
    
    public int getTamaño() {
        return tamaño;
    }
    
    public boolean estaVacia() {
        return cabeza == null;
    }
    
    public int obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        
        Nodo actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        
        return actual.getDato();
    }
    
    @Override
    public String toString() {
        if (cabeza == null) {
            return "Lista vacía: []";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Lista: [");
        
        Nodo actual = cabeza;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) {
                sb.append(", ");
            }
            actual = actual.getSiguiente();
        }
        
        sb.append("]");
        return sb.toString();
    }
    
    public void limpiar() {
        cabeza = null;
        tamaño = 0;
    }
}
