# **Tipos de búsqueda** #

La plataforma está diseñada para trabajar con tres tipos de búsqueda, aunque es posible extenderla de ser necesario.

Estos tipos son:

  1. Búsqueda no informada
  1. Búsqueda informada
  1. Búsqueda con adversario

## **Búsqueda no informada** ##

En la búsqueda no informada se parte de un estado inicial y se exploran todos los estados obtenibles formando una estructura de árbol, la búsqueda termina cuando se encuentra un estado exitoso o cuando no quedan estados por explorar.

Es necesario tener las siguientes funciones:
  * Determinar si un estado es exitoso
  * Determinar si un estado es final (no se le puede aplicar ningún cambio)

## **Búsqueda informada** ##

En la búsqueda informada se agrega una función de puntuación al algoritmo de búsqueda para guiar el recorrido (o desarrollo) del árbol hacia aquellos estados que tengan mejor puntaje.

El puntaje es un indicador de cuan cerca o cuan bueno es un estado respecto a la solución esperada, un ejemplo puede ser la distancia de un punto a otro en el problema del laberinto, donde un punto es la posición actual y el otro sería la salida del laberinto. Cabe destacar que una mala función de puntuación puede empeorar la búsqueda y hacer que se tarde mas.

Es necesario tener las siguientes funciones:
  * Determinar el puntaje de un estado (manteniendo el invariante que si el estado es exitoso entonces tiene puntaje máximo)
  * Determinar cuales son las cotas del puntaje, puntaje mínimo y máximo

La plataforma utiliza una clase "_!IComparable_" para definir los valores de evaluación, actualmente hay dos clases implementadas, "_**ComparableInt**_" y "_**ComparableFloat**_".

## **Búsqueda con adversario** ##

En un problema de búsqueda con adversario un estado ahora puede pertenecer a uno u otro jugador (turno) y salvo juegos muy simples el árbol de búsqueda no puede desarrollarse hasta llegar a un estado final, por lo que en general se hacen búsqueda hasta n niveles.

Es necesario tener las siguientes funciones:
  * Determinar si un estado es min o max (los turnos posibles)
  * Determinar si el estado es exitoso para min o para max (manteniendo que un estado es exitoso si y solo si es exitoso para min o para max de forma exclusiva)

[principal](garoe_wiki.md)