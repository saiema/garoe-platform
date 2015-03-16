Una librería que permite el desarrollo de algoritmos de búsqueda y problemas de búsqueda con sus respectivos estados y reglas. La meta de este proyecto es evitar tener que re diseñar y re implementar algoritmos para cada programa donde se los necesita y en cambio ofrecer una plataforma estable que permita la re utilización y diseño por herencia.

Un ejemplo de como esta plataforma ayuda es:

Un equipo debe resolver el problema de las jarras de agua, otro el problema de indiana jones. Normalmente cada equipo diseñaría e implementaría todo el código desde cero, incluso si ambos utilizan el mismo algoritmo de búsqueda lo mas probable es que ambos motores no sean intercambiables.

Esta plataforma permitiría implementar un solo motor mediante extensión, implementar los estados y las reglas de cambio de estado y nada mas.

En resumen lo que propone esta plataforma es lo mismo que proponen los patrones de diseño, utilizar una solución genérica, estable y que permite su re utilización para diferentes instancias de un mismo problema.