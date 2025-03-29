# Proyecto de Hilos en Java

Este proyecto contiene varias implementaciones de hilos en Java. A continuación se describen los diferentes fragmentos de código que puedes encontrar en el proyecto y su propósito.

## Descripción General

El proyecto tiene ejemplos de hilos tanto con la clase `Thread` como con la interfaz `Runnable`. A lo largo de los fragmentos de código se exploran diferentes maneras de crear, iniciar y manejar hilos en Java, mostrando su estado y comportamiento durante la ejecución.

## Archivos Principales

### 1. `ThreadSimple.java`

Este archivo contiene la clase `ThreadSimple`, que extiende la clase `Thread`. Esta clase sobrescribe el método `run()` para ejecutar una secuencia de acciones en un hilo. El hilo imprime su nombre y realiza un retraso aleatorio durante su ejecución.

**Características:**
- Usa la clase `Thread` para crear un hilo.
- Ejecuta un ciclo de 100 iteraciones.
- En cada iteración, realiza un `Thread.sleep` con un tiempo aleatorio.

### 2. `Hilos.java`

Este archivo contiene la clase `Hilos`, donde se crean y ejecutan dos hilos utilizando la clase `ThreadSimple`.

**Características:**
- Crea dos hilos con nombres diferentes (`"Juan"` y `"Jose"`).
- Cada hilo ejecuta el método `run()` definido en `ThreadSimple`.
- Imprime el estado del hilo principal.

### 3. `HilosR.java`

Este archivo contiene la clase `HilosR`, que demuestra el uso de `Runnable` en lugar de extender la clase `Thread`. Se crea un hilo utilizando la interfaz `Runnable` y se ejecutan varias instancias de este hilo.

**Características:**
- Define un `Runnable` que imprime el número de iteraciones y el estado del hilo.
- Crea varios hilos para simular una "carrera de caballos".
- Usa `join()` para esperar a que todos los hilos finalicen antes de continuar con el hilo principal.
- Muestra el estado de cada hilo después de su ejecución.

### 4. `RunnableSimple.java`

Este archivo define la clase `RunnableSimple`, que implementa la interfaz `Runnable` y ejecuta una serie de acciones en un hilo. Es similar a la clase `ThreadSimple`, pero utiliza `Runnable` en lugar de extender `Thread`.

**Características:**
- Implementa la interfaz `Runnable`.
- Ejecuta un ciclo de 10 iteraciones.
- Imprime el nombre del hilo en cada iteración y simula una pausa aleatoria.

## Uso

1. **Compilación y Ejecución:**
   - Para compilar y ejecutar los ejemplos, asegúrate de tener instalado JDK.
   - Ejecuta el siguiente comando para compilar:
     ```bash
     javac Hilos.java HilosR.java RunnableSimple.java ThreadSimple.java
     ```
   - Para ejecutar un archivo, utiliza:
     ```bash
     java Hilos
     java HilosR
     java RunnableSimple
     ```

2. **Salida Esperada:**
   - Cada hilo imprimirá su nombre y su estado durante su ejecución.
   - Verás cómo el estado de los hilos cambia durante su ciclo de vida, desde que se inicia hasta que finaliza.

---

# - Productor-Consumidor 

## Descripción

Este proyecto implementa el patrón **Productor-Consumidor** utilizando sincronización con los métodos `wait()` y `notify()` en Java. En este ejemplo, el productor es el **Panadero**, que hornea pan, y el consumidor es el **Cliente**, que consume el pan. Ambas entidades comparten una clase **Panaderia** que maneja la sincronización y comunicación entre ellos.

El flujo del programa consiste en un hilo que representa al panadero horneando pan, y otro hilo que representa al consumidor consumiendo ese pan. La clase **Panaderia** se encarga de gestionar los procesos de horneado y consumo de manera sincronizada, evitando que el pan sea consumido antes de ser horneado.

## Estructura del Proyecto

### Clases

1. **Panaderia.java**: Esta clase gestiona la sincronización entre el panadero y el consumidor. Contiene los métodos `hornear()` y `consumir()`, que aseguran que el pan no se consuma antes de ser horneado, y viceversa.
   
2. **Consumidor.java**: Representa al cliente que consume el pan. Implementa `Runnable` y ejecuta el proceso de consumo en un hilo.
   
3. **Panadero.java**: Representa el productor que hornea pan. Implementa `Runnable` y ejecuta el proceso de horneado en otro hilo.
   
4. **EjemploProductorConsumidor.java**: Esta clase ejecuta el ejemplo básico de productor-consumidor utilizando hilos de manera tradicional.

5. **EjemploProductorConsumidorJava8.java**: Variante utilizando expresiones lambda para manejar los hilos de manera más moderna y concisa.

### Conceptos Clave

#### ¿Qué es una flag?

En programación, una **flag** (o bandera) es una variable que se usa para indicar si una condición es verdadera o falsa. Normalmente, las flags se utilizan para controlar el flujo de ejecución de un programa, por ejemplo, para indicar si un recurso está disponible, si un proceso está completo, o si un error ha ocurrido.

#### ¿Qué es el método `wait()`?

El método `wait()` en Java se utiliza para hacer que el hilo actual espere hasta que otro hilo lo despierte. Este método debe ser llamado dentro de un bloque sincronizado (`synchronized`). Cuando un hilo llama a `wait()`, libera el monitor (bloqueo) del objeto sincronizado y entra en estado de espera. El hilo permanecerá en espera hasta que otro hilo lo despierte utilizando el método `notify()` o `notifyAll()`.

#### ¿Qué es el método `notify()`?

El método `notify()` en Java se usa para despertar a un solo hilo que se encuentra en espera dentro de un bloque sincronizado. Si hay varios hilos esperando en el mismo objeto, `notify()` despertará a uno de ellos, que podrá continuar su ejecución. Este método debe ser llamado también dentro de un bloque sincronizado.

#### Diferencias entre programación normal y programación funcional

- **Programación normal (imperativa)**:
  En este estilo, el enfoque es sobre cómo hacer las cosas. Los programas se componen de una secuencia de instrucciones que modifican el estado del programa. La programación imperativa a menudo depende de bucles, condiciones y variables mutables. Los efectos secundarios son comunes.

- **Programación funcional**:
  La programación funcional se enfoca en lo que se debe hacer, en lugar de cómo hacerlo. El programa se compone de funciones puras que toman datos y devuelven resultados sin modificar el estado del programa ni tener efectos secundarios. Se usan funciones de orden superior y se evitan las variables mutables y los bucles explícitos, favoreciendo la recursión.
