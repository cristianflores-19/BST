# Tarea: Árbol Binario de Búsqueda (BST) en Java

**Curso:** Programación 3  
**Tema:** Estructuras de datos no lineales — Árboles  
**Estudiante:** Cristian Josué Flores Pleitez  
**Carné:** 0905-24-4847  
**Universidad:** Universidad Mariano Gálvez de Guatemala  

---

## 1. Descripción del Proyecto

Este proyecto consiste en la extensión y completación **manual** de un Árbol Binario de Búsqueda (BST) en Java, desarrollado de forma nativa **sin utilizar java.util ni librerías externas**. Toda la estructura de memoria y almacenamiento se basa en punteros internos y recursividad pura.

El desarrollo se realizó de manera incremental y ordenada directamente en el repositorio, garantizando que el archivo principal Principal.java ejecute primero las métricas base del árbol, luego la suite de pruebas lógicas de la tarea y, por último, las eliminaciones y la inversión en espejo de la estructura.

---

## 2. Requisitos de Ejecución

Para compilar y ejecutar este proyecto desde la consola utilizando Apache Maven, sitúese en la raíz del repositorio y ejecute los siguientes comandos:

* Para compilar los archivos fuente del proyecto:
mvn compile

* Para ejecutar la clase Principal:
java -cp target/classes umg.edu.progra.arboles.Principal

---

## 3. Problemas Resueltos e Implementación Lógica

A continuación se detalla la lógica algorítmica aplicada para la solución de cada uno de los 5 problemas obligatorios establecidos en la rúbrica:

###  Problema 1 — Contar Nodos Recursivamente (contarNodos)
* **Lógica:** Calcula de manera puramente recursiva la cantidad total de nodos cargados en memoria. No utiliza el atributo global tamanio.
* **Caso Base:** Si el nodo evaluado es null, retorna 0. En caso contrario, se suma 1 (el nodo actual) más el resultado recursivo de sus subárboles izquierdo y derecho.

###  Problema 2 — ¿Está Balanceado? (esBalanceado)
* **Lógica:** Determina si el árbol mantiene un equilibrio de carga. Para cada nodo individual, calcula la altura del hijo izquierdo y del derecho utilizando el método alturaRecursiva base. Si la diferencia absoluta de alturas supera a 1, el árbol se declara desbalanceado.

###  3. Validar que sea un BST (esBSTValido)
* **Lógica:** Verifica que la propiedad fundamental del BST se cumpla en cada nivel (valores a la izquierda estrictamente menores y a la derecha estrictamente mayores). Se implementó pasando un rango dinámico limitado por enteros máximos y mínimos (Integer.MIN_VALUE y Integer.MAX_VALUE) que se va estrechando recursivamente al bajar por el árbol.
* **Método Auxiliar:** Se incluyó romperArbolParaPrueba(), el cual modifica forzadamente un puntero para demostrar la efectividad del validador devolviendo false.

###  Problema 4 — Ancestro Común Más Bajo (ancestroComunMasBajo)
* **Lógica:** Encuentra el nodo raíz compartido más cercano (Lowest Common Ancestor - LCA) para dos valores específicos. Aprovechando el ordenamiento del BST, si ambos valores son menores que la raíz actual se avanza a la izquierda; si ambos son mayores se avanza a la derecha; si se dividen, la raíz actual es el LCA.
* **Control de Excepciones:** Si alguno de los valores solicitados no existe en la estructura, el sistema dispara un IllegalArgumentException.

###  Problema 5 — Espejo del Árbol (invertir)
* **Lógica:** Transforma físicamente la estructura del árbol invirtiendo sus sentidos en memoria. Utilizando una asignación temporal clásica, intercambia el puntero izquierdo por el derecho en todos los nodos de manera recursiva.

---

## 4. Bitácora de Salida en Consola (Output Real)

Al ejecutar la clase principal en la terminal, se genera la siguiente salida ordenada que valida el cumplimiento estricto de cada requerimiento de la asignación:

===== Arbol Binario de Busqueda =====
Tamanio: 8
Altura:  3
Minimo:  10
Maximo:  80
Hojas:   4

--- Representacion visual (rotada 90 grados) ---
          -> 80
     -> 70
          -> 60
-> 50
          -> 40
     -> 30
          -> 20
               -> 10

--- Recorridos ---
InOrden    (ascendente): 10 20 30 40 50 60 70 80 
PreOrden   (raiz primero): 50 30 20 10 40 70 60 80 
PostOrden  (raiz al final): 10 20 40 30 60 80 70 50 
Por niveles (BFS):         50 30 70 20 40 60 80 10 

--- Busquedas ---
Contiene 40? true
Contiene 99? false

--- Eliminacion ---
Eliminando 20 (nodo con 1 hijo)...
InOrden tras eliminar 20: 10 30 40 50 60 70 80 
Eliminando 30 (nodo con 2 hijos)...
InOrden tras eliminar 30: 10 40 50 60 70 80 
Eliminando 50 (raiz)...
InOrden tras eliminar la raiz: 10 40 60 70 80 

--- Estado final ---
          -> 80
     -> 70
-> 60
     -> 40
          -> 10
Tamanio final: 5
Altura final:  2

==================================================
        EVALUACIÓN DE PROBLEMAS DE LA TAREA       
==================================================

--- Prueba Problema 1: Contar Nodos ---
Tamanio por atributo: 5
Tamanio recursivo:    5

--- Prueba Problema 2: Es Balanceado ---
¿El arbol inicial esta balanceado?: true
¿El arbol (1->2->3->4->5) esta balanceado?: false

--- Prueba Problema 3: Validar BST ---
¿El arbol original es un BST valido?: true
¿El arbol modificado manualmente es un BST valido?: false

--- Prueba Problema 4: Ancestro Comun Mas Bajo (LCA) ---
LCA de 10 y 40 (Debe ser 40): 40
LCA de 70 y 80 (Debe ser 70): 70
LCA de 10 y 80 (Debe ser 60): 60
Excepcion controlada exitosamente: Uno o ambos valores no existen en el arbol.

--- Prueba Problema 5: Espejo (Invertir) ---
InOrden antes de invertir (ordenado): 10 40 60 70 80 
InOrden despues de invertir (debe quedar invertido): 80 70 60 40 10 
Representacion visual del arbol invertido:
          -> 10
     -> 40
-> 60
     -> 70
          -> 80