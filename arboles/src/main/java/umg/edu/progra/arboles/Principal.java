package umg.edu.progra.arboles;

/**
 * Clase principal que demuestra el uso del Arbol Binario de Busqueda (BST)
 * implementado manualmente, sin usar librerias como java.util.
 *
 * Ejecucion sugerida:
 *   1. mvn compile
 *   2. mvn exec:java -Dexec.mainClass="umg.edu.progra.arboles.Principal"
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        /*
         * Insertamos estos valores para formar el siguiente BST:
         *
         *               50
         *              /  \
         *            30    70
         *           /  \   / \
         *          20  40 60  80
         *         /
         *        10
         */
        int[] valores = { 50, 30, 70, 20, 40, 60, 80, 10 };
        for (int v : valores) {
            arbol.insertar(v);
        }

        System.out.println("===== Arbol Binario de Busqueda =====");
        System.out.println("Tamanio: " + arbol.tamanio());
        System.out.println("Altura:  " + arbol.altura());
        System.out.println("Minimo:  " + arbol.minimo());
        System.out.println("Maximo:  " + arbol.maximo());
        System.out.println("Hojas:   " + arbol.contarHojas());

        System.out.println("\n--- Representacion visual (rotada 90 grados) ---");
        arbol.imprimirArbol();

        System.out.println("\n--- Recorridos ---");
        System.out.print("InOrden    (ascendente): ");
        arbol.inOrden();

        System.out.print("PreOrden   (raiz primero): ");
        arbol.preOrden();

        System.out.print("PostOrden  (raiz al final): ");
        arbol.postOrden();

        System.out.print("Por niveles (BFS):         ");
        arbol.recorridoPorNiveles();

        System.out.println("\n--- Busquedas ---");
        System.out.println("Contiene 40? " + arbol.contiene(40));
        System.out.println("Contiene 99? " + arbol.contiene(99));

        System.out.println("\n--- Eliminacion ---");
        System.out.println("Eliminando 20 (nodo con 1 hijo)...");
        arbol.eliminar(20);
        System.out.print("InOrden tras eliminar 20: ");
        arbol.inOrden();

        System.out.println("Eliminando 30 (nodo con 2 hijos)...");
        arbol.eliminar(30);
        System.out.print("InOrden tras eliminar 30: ");
        arbol.inOrden();

        System.out.println("Eliminando 50 (raiz)...");
        arbol.eliminar(50);
        System.out.print("InOrden tras eliminar la raiz: ");
        arbol.inOrden();

        System.out.println("\n--- Estado final ---");
        arbol.imprimirArbol();
        System.out.println("Tamanio final: " + arbol.tamanio());
        System.out.println("Altura final:  " + arbol.altura());
        
     // ============================================================
        // EJECUCIÓN DE LOS PROBLEMAS DE LA TAREA
        // ============================================================
        System.out.println("\n==================================================");
        System.out.println("        EVALUACIÓN DE PROBLEMAS DE LA TAREA       ");
        System.out.println("==================================================");

        System.out.println("\n--- Prueba Problema 1: Contar Nodos ---");
        System.out.println("Tamanio por atributo: " + arbol.tamanio());
        System.out.println("Tamanio recursivo:    " + arbol.contarNodos());
        System.out.println("\n--- Prueba Problema 2: Es Balanceado ---");
        System.out.println("¿El arbol inicial esta balanceado?: " + arbol.esBalanceado());

        // Caso desbalanceado requerido por la guía (1->2->3->4->5)
        ArbolBinarioBusqueda arbolDesbalanceado = new ArbolBinarioBusqueda();
        for (int i = 1; i <= 5; i++) arbolDesbalanceado.insertar(i);
        System.out.println("¿El arbol (1->2->3->4->5) esta balanceado?: " + arbolDesbalanceado.esBalanceado());
        
        System.out.println("\n--- Prueba Problema 3: Validar BST ---");
        System.out.println("¿El arbol original es un BST valido?: " + arbol.esBSTValido());

        // Creamos un árbol alternativo y lo modificamos a la fuerza para romperlo
        ArbolBinarioBusqueda arbolRoto = new ArbolBinarioBusqueda();
        arbolRoto.insertar(50);
        arbolRoto.insertar(30);
        arbolRoto.insertar(70);
        arbolRoto.romperArbolParaPrueba(); // Forzamos el error
        System.out.println("¿El arbol modificado manualmente es un BST valido?: " + arbolRoto.esBSTValido());
        
        System.out.println("\n--- Prueba Problema 4: Ancestro Comun Mas Bajo (LCA) ---");
        // Probamos con nodos que sí sobrevivieron a la eliminación en el árbol actual
        System.out.println("LCA de 10 y 40 (Debe ser 40): " + arbol.ancestroComunMasBajo(10, 40));
        System.out.println("LCA de 70 y 80 (Debe ser 70): " + arbol.ancestroComunMasBajo(70, 80));
        System.out.println("LCA de 10 y 80 (Debe ser 60): " + arbol.ancestroComunMasBajo(10, 80));
        
        try {
            // El 30 ya fue eliminado previamente, por lo que debe disparar la excepción
            arbol.ancestroComunMasBajo(10, 30); 
        } catch (IllegalArgumentException e) {
            System.out.println("Excepcion controlada exitosamente: " + e.getMessage());
        }
        
     // ============================================================
        // PRUEBA PROBLEMA 5: INVERTIR (AL FINAL DE TODO)
        // ============================================================
        System.out.println("\n--- Prueba Problema 5: Espejo (Invertir) ---");
        System.out.print("InOrden antes de invertir (ordenado): ");
        arbol.inOrden();
        
        arbol.invertir(); // Aplicamos el efecto espejo
        
        System.out.print("InOrden despues de invertir (debe quedar invertido): ");
        arbol.inOrden();
        System.out.println("Representacion visual del arbol invertido:");
        arbol.imprimirArbol();

        /*
         * Ejercicios
         *
         *  1. Implementar un metodo que devuelva la cantidad TOTAL de nodos
         *     usando recursividad (sin usar el campo 'tamanio').
         *  2. Implementar un metodo 'esBalanceado()' que indique si el arbol
         *     esta balanceado (diferencia de alturas <= 1 en cada nodo).
         *  3. Implementar 'esBSTValido()' que verifique que el arbol cumple
         *     la propiedad de BST recorriendo los nodos.
         *  4. Implementar un metodo para encontrar el ancestro comun mas
         *     bajo (LCA) entre dos valores.
         *  5. Implementar la inversion del arbol (espejo).
         */
    }
}
