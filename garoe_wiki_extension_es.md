# Extensión de la plataforma #

Si bien es posible modelar una generosa cantidad de problemas de búsqueda mediante esta librería, siempre existe un problema que nos dificulta la existencia o un algoritmo mas eficiente que el que ya está implementado por ejemplo para obtener los sucesores de un estado.

Hay dos formas en la que se puede extender esta librería, una es extender la librería misma añadiendo nuevas clases o bien generar una nueva que utilice a esta como base.

## Extender en una nueva librería ##

Una forma de extender la librería es usar de base a la actual como librería (en formato .jar) y desarrollar un nuevo proyecto por encima que haga las extensiones correspondientes.

Una ventaja que tiene esta opción es que si esta librería se actualiza entonces podemos ganar algunas actualizaciones gratis en nuestra librería extendida. La desventaja es que podría suceder que se cambien ciertas clases que nuestra librería extendida necesita.

## Extender la librería Garoé ##

Sea para un proyecto que necesita de alguna extensión en la plataforma o de comenzar una librería alternativa, es posible extender la propia librería Garoé usando el código fuente de la misma.

Es aconsejable tomar en cuenta lo siguiente.

La librería se divide en 6 partes

  * El framework que representa la base sobre la cual construir
  * Los motores disponibles
  * Ejemplos individuales de uso
  * Demo con todos los ejemplos incluidos
  * Utilidades
  * Imagenes y recursos


Cada extensión debe estar sobre la parte correcta, es decir que un nuevo motor no debe incluirse dentro del paquete "framework" pero si una clase que defina un nuevo tipo de motor.

[principal](garoe_wiki.md) | [anterior](garoe_wiki_uso_es.md)