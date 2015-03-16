## **Uso de la plataforma** ##

La plataforma Garoé permite un desarrollo ágil de soluciones para problemas de búsqueda así como la reutilización de módulos ya implementados, por lo que se explicará el uso para ambos casos.

### **Estado** ###

Para un problema de búsqueda se tiene siempre un estado, un estado particular va a tener atributos y métodos particulares al problema y así también otros que van a ser particulares al tipo del problema, estos últimos siempre deben estar disponibles y tener los mismos tipos sea cual sea el estado particular.

Al crear un nuevo estado se debe distinguir a que [tipo de búsqueda](garoe_wiki_tipo_busquedas_es.md) corresponde para determinar a cual estado abstracto va a implementar el nuevo estado particular.

En general nuestro estado va a estar definido como:

```

public class NuevoEstado implements EstadoAbstracto
```

Donde **EstadoAbstracto** es uno de los estados definidos tanto en el paquete "_framework_" de la librería o de algún otro definido en el proyecto nuevo.

Para conocer los métodos requeridos se puede consultar el javadoc generado en la sección [descargas](http://code.google.com/p/garoe-platform/downloads/list)

**Cualquier estado debe implementar los métodos de "IBasicState".**

### **Reglas** ###

Cada problema tiene asociado un conjunto de reglas de cambio de estado, cada regla describe una acción determinada que se le puede aplicar a un estado no final, ejemplos de estas pueden ser:

  * Colocar una ficha (ta-te-ti, reversi, 4 en raya)
  * Mover un personaje (problema de indiana)
  * Vaciar, llenar una jarra (problema de las jarras)

Es posible tener distintos niveles de granularidad al definir reglas, por ejemplo en el ta-te-ti se podría tener una sola regla _Mover_ o una regla por cada casillero del tablero. Este nivel afecta en cuan simple es cada regla y a la eficiencia.

Una regla debe ser capaz de dos cosas:

  1. Verificar si la regla se aplica a un estado
  1. Aplicar la regla a un estado y devolver la lista de estados conseguidos

Las reglas se definen para un tipo particular pero pueden usarse en cualquier problema que utilice el mismo estado o compatible.

```

public class Regla1 implements <IRule<MiEstado>>
```

### **Problema** ###

La plataforma provee un problema genérico que puede ser utilizado para cualquier solución a problemas de búsqueda, un problema solo debe proveer un constructor, formas de obtener y definir el estado inicial del mismo y una forma de obtener los sucesores de un estado. El enfoque de utilizar reglas permite un algoritmo genérico de obtención de sucesores:

```

public List<State> getSuccessors(State s) {
List<State> successors = new LinkedList<State>();
for (IRule<State> rule : rules) {
if (rule.isApplicable(s)) {
successors.addAll(rule.apply(s));
}
}
return successors;
}
```

Lo que se debe cumplir es que las reglas operen sobre el mismo estado del problema o uno compatible.

### **Motor** ###

Teniendo en cuenta los [tipos de búsqueda](garoe_wiki_tipo_busquedas_es.md) es fácil distinguir dos tipos distintos de motor de búsqueda, aquellos que devuelven la solución al problema o no la encuentran y aquellos que devuelven el siguiente movimiento (o una serie de movimientos) en algún juego. La diferencia entre que una búsqueda sin adversario sea guiada o no solo se ve dentro del algoritmo de búsqueda pero ambos algoritmos devuelven la solución a un problema.

Por lo tanto existen dos motores abstractos que se distinguen, aquellos para búsquedas con adversario y aquellos para búsqueda sin adversario. Un tercer motor abstracto contiene las características en común a los dos anteriores.

El motor abstracto "_**SearchEngine**_" usado en búsquedas sin adversario está declarado como:

```

public class SearchEngine<State extends IBasicState> extends BasicSearchEngine<State>
```

Esto significa que es posible implementar un motor que extienda a "_**SearchEngine**_" utilizando cualquier estado que extienda a "_**!IBasicState**_".

Este motor ofrece los métodos:

```

abstract public boolean performSearch();
```

para realizar la búsqueda

```

final public List<State> getPath()
```

para obtener el camino del estado inicial al final luego de haber realizado una búsqueda.

Este último método ya está implementado y la razón de ser un método "hoja", es decir que no puede ser redefinido por ninguna clase que extienda a "_**SearchEngine**_", es por que si distintos motores proveen distintas formas de obtener el camino del estado inicial al final, podrían causar como resultado una incompatibilidad entre distintos motores.

El motor abstracto "_**AdversarySearchEngine**_" usado en búsquedas con adversarios está declarado como:

```

abstract public AdversaryState nextMove(AdversaryState state)
```

que dado un estado devuelve el siguiente (realiza una jugada)

Y provee métodos para definir y obtener la altura máxima del árbol de búsqueda.

Finalmente el motor abstracto "_**BasicSearchEngine**_" que provee atributos y métodos en común para los motores anteriores.

Para implementar un nuevo motor, la clase nueva debería estar definida como:

```

public class MiMotor<S extends EstadoMinimoNecesario> extends MotorAbstracto<S>
```

En donde "_**MotorAbstracto**_" es o bien "_**AdversarySearchEngine**_" o "_**SearchEngine**_", "_**EstadoMinimoNecesario**_" es el estado que contiene los métodos necesarios para mi motor, esta forma de definir un motor le brinda compatibilidad con estados que extiendan al que nosotros pedimos como mínimo.

### **Uniendo las partes** ###

A continuación se dará un ejemplo para saber como una vez implementadas las partes de una solución a un problema de búsqueda estas se unen.

El ejemplo va a ser el problema de Indiana:

_Indiana Jones junto con su amante, su padre y su abuelo están escapando de los villanos hasta llegan a un puente colgante, con solo una linterna y el puente que solo puede soportar a 2 personas como máximo, todos deben cruzar el puente en a lo sumo M minutos, es de noche y salvo por la pequeña área que ilumina la linterna es imposible ver por donde se camina, esto obliga a no solo cruzar el puente de a dos como máximo sino también a que siempre haya alguien sosteniendo la linterna mientras cruzan, por lo que cuando dos personas cruzan el puente la velocidad es la del mas lento._

El problema generaliza un poco al problema clásico al permitir que los tiempos que tardan en cruzar sean establecidos de forma independiente unos de otros.

En primer lugar (principalmente para demostrar la compatibilidad de los motores de búsqueda) se va a implementar este problema para que pueda usar búsqueda informada. Con esto podemos definir el estado del problema:

```

public class EstadoIndiana implements IinformedState
```

Dado que no solo hay que poder cruzar el puente sino regresar a buscar a los que aún no cruzaron se van a necesitar dos reglas:

```

public class ReglaCruzar implements IRule<EstadoIndiana>
public class ReglaVolver implements IRule<EstadoIndiana>
```

Vamos a suponer que el motor de búsqueda ya está implementado (lo cual es cierto ya que la plataforma viene con varios motores de búsqueda listos para usar) y el problema ya está implementado, solo requiere de un conjunto de reglas y un estado inicial.

Finalmente hay que juntar las partes:

  1. Crear el estado inicial y las reglas

```

//estado
EstadoIndiana estadoInicial = new EstadoIndiana();
estadoInicial.definirTiempoIndiana(1);
estadoInicial.definirTiempoAmante(2);
estadoInicial.definirTiempoPadre(4);
estadoInicial.definirTiempoAbuelo(5);

//reglas
List<IRule<EstadoIndiana>> reglasIndiana = new LinkedList<IRule<EstadoIndiana>>;
reglasIndiana.add(new ReglaCruzar());
reglasIndiana.add(new ReglaVolver());
```

  1. Crear el problema

```

SearchProblem<EstadoIndiana> problemaIndiana= new SearchProblem<EstadoIndiana>(estadoInicial, reglasIndiana);
```

  1. Crear el motor

```

//motor de búsqueda guiada
SearchEngine<EstadoIndiana> motorGuiado = new BestFirstSearchEngine<EstadoIndiana>(problemaIndiana);

//motor de búsqueda no guiada
SearchEngine<EstadoIndiana> motorNoGuiado = new BreadthFirstSearchEngine<EstadoIndiana>(problemaIndiana);
```

En la zona [descargas](http://code.google.com/p/garoe-platform/downloads/list) se encuentra el archivo "_ejemploParaImplementar.rar_" que contiene el ejemplo anterior (un poco mas elaborado) para que puedan completar su implementación y practicar el uso de la librería.

[principal](garoe_wiki.md) | [anterior](garoe_wiki_obtener_es.md) | [siguiente](garoe_wiki_extension_es.md)