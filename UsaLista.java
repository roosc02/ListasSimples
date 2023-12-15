public class UsaLista{
        
        public static void main(String[] args){
        ListaSimple lista = new ListaSimple ();
        
        lista.insertaPrimerNodo("H");
        lista.insertaAntesPrimerNodo("O");
        lista.insertaAlFinal ("Y");
        lista.insertaEntreNodos("R","Y");
        lista.imprimir();
        System.out.print(lista); 
        
        // Buscar un nodo por el valor de su campo clave
        String valorBuscado = "R";
        Node nodoEncontrado = lista.buscarNodoPorValor(valorBuscado);

        if (nodoEncontrado != null) {
            System.out.println("Nodo encontrado: " + nodoEncontrado.name);
        } else {
            System.out.println("Nodo no encontrado");
        }
        String claveBuscada = "H";
        String nuevoNombre = "G";
        lista.insertarDespuesDeNodo(claveBuscada, nuevoNombre);

        // Imprimime list después de agregar otro nodo
        lista.imprimir();
        System.out.print(lista);
        
         // Intercambiar nodos "O" y "Y"
        String nodoA = "O";
        String nodoB = "Y";
        boolean exitoIntercambio = lista.intercambiarNodos(nodoA, nodoB);

        if (exitoIntercambio) {
            System.out.println("Intercambio exitoso");
        } else {
            System.out.println("No se pudo realizar el intercambio");
        }

        // Imprimir la lista después del intercambio
        lista.imprimir();
        System.out.print(lista);
    }
}