
import Model.ListaEnlazadaSimple;
import Model.ElementoNoEncontradoException;


class PruebaListaEnlazada {
    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        
        try {
            System.out.println("=== INSERTANDO ELEMENTOS ===");
            lista.insertar(5);
            lista.insertar(10);
            lista.insertar(15);
            lista.insertarAlInicio(2);
            System.out.println(lista);
            System.out.println("Tamaño: " + lista.getTamaño());
            
            System.out.println("\n=== BUSCANDO ELEMENTOS ===");
            int posicion = lista.buscar(10);
            System.out.println("Elemento 10 encontrado en posición: " + posicion);
            
            System.out.println("\n=== SUMA RECURSIVA ===");
            int suma = lista.sumaRecursiva();
            System.out.println("Suma de todos los elementos: " + suma);
            
            System.out.println("\n=== ELIMINANDO ELEMENTOS ===");
            boolean eliminado = lista.eliminar(10);
            System.out.println("¿Se eliminó el 10? " + eliminado);
            System.out.println(lista);
            
            suma = lista.sumaRecursiva();
            System.out.println("Nueva suma: " + suma);
            
            System.out.println("\n=== BUSCANDO ELEMENTO INEXISTENTE ===");
            lista.buscar(100); 
            
        } catch (ElementoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}