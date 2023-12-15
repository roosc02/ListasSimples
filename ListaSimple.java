public class ListaSimple{
    Node top;

    //Métodos para los casos de inserción de nodos
    public boolean insertaPrimerNodo(String dato){
        if (top == null) { //La lista no está vacía
            top = new Node();
            top.name = dato;
            top.next = null;

            return true;
        }
        else {
            return false;
        }
    }

    public void insertaAntesPrimerNodo(String nombre){
        Node temp; 
        temp = new Node ();
        temp.name = nombre;
        temp.next = this.top;
        this.top = temp;
        temp = null;
    }

    public void insertaAlFinal(String nombre){
        Node temp = new Node ();
        temp.name = nombre;
        temp.next = null;
        //Node temp2;
        Node temp2 = this.top;

        while (temp2.next != null)
            temp2 = temp2.next;

        temp2.next = temp;
        temp = null;
        temp2 = null;
    }

    public boolean insertaEntreNodos(String nombre, String buscado){
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.top;

        //boolean NodoNoEncontrado = true;

        while ( (temp2 != null) 
                && temp2.name.equals(buscado) == false ) {    
                 temp2 = temp2.next;
        }

        if (temp2 != null){  //Nodo buscado se encontró
            temp.next = temp2.next;
            temp2.next = temp;
            temp = null;
            temp2 = null;
            return true;
        }
        else return false;
    } 

    public void imprimir(){
        for (Node temp = this.top; temp != null; temp = temp.next){
            System.out.print("[ " + temp.name + " ] -> ");
        }
        System.out.print("[X]\n"); 
    }
    
    public String toString(){
        String cadAux = "";
        for (Node temp = this.top; temp != null; temp = temp.next){
            cadAux += "[ " + temp.name + " ] -> ";
        }

        cadAux += "[X]\n"; 

        return cadAux;
    }
    //Mètodo para intercambiar nods
    public boolean intercambiarNodos(String valorNodoA, String valorNodoB) {
        if (valorNodoA.equals(valorNodoB)) {
            // No es necesario intercambiar nodos si son iguales
            return false;
        }

        Node nodoAnteriorA = null;
        Node nodoActualA = this.top;

        // Buscar el nodo A y su nodo anterior
        while (nodoActualA != null && !nodoActualA.name.equals(valorNodoA)) {
            nodoAnteriorA = nodoActualA;
            nodoActualA = nodoActualA.next;
        }

        Node nodoAnteriorB = null;
        Node nodoActualB = this.top;

        // Buscar el nodo B y su nodo anterior
        while (nodoActualB != null && !nodoActualB.name.equals(valorNodoB)) {
            nodoAnteriorB = nodoActualB;
            nodoActualB = nodoActualB.next;
        }

        // Verificar si ambos nodos fueron encontrados
        if (nodoActualA == null || nodoActualB == null) {
            return false; // Uno o ambos nodos no fueron encontrados
        }

        // Actualizar los enlaces para intercambiar los nodos
        if (nodoAnteriorA != null) {
            nodoAnteriorA.next = nodoActualB;
        } else {
            this.top = nodoActualB;
        }

        if (nodoAnteriorB != null) {
            nodoAnteriorB.next = nodoActualA;
        } else {
            this.top = nodoActualA;
        }

        Node temp = nodoActualA.next;
        nodoActualA.next = nodoActualB.next;
        nodoActualB.next = temp;

        return true; // Intercambio realizado
    }
   
    //Métodos de borrado
    public void borrarPrimerNodo(){
        this.top = this.top.next;
    }
    
    //Borrar cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado){
        Node temp = this.top;

        while ( (temp != null) 
                && temp.name.equals(buscado) == false ) {    
                 temp = temp.next;
        }

        if (temp != null){  //Nodo buscado se encontró
            temp.next = temp.next.next;
            temp = null;
            
            return true;
        }
        else return false;
    }
    
     public Node buscarNodoPorValor(String valorBuscado) {
        Node temp = this.top;

        while (temp != null && !temp.name.equals(valorBuscado)) {
            temp = temp.next;
        }
        return temp;  // Devuelve la referencia al nodo encontrado o null si no se encontró.
    }
     public void insertarDespuesDeNodo(String claveBuscada, String nuevoNombre) {
        Node temp = this.top;

        while (temp != null && !temp.name.equals(claveBuscada)) {
            temp = temp.next;
        }

        if (temp != null) {
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoNombre;
            nuevoNodo.next = temp.next;
            temp.next = nuevoNodo;
        }
    }
}