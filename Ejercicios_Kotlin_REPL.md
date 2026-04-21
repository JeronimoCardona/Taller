# Ejercicios Kotlin - Listos para el REPL o Playground

Copia y pega cada sección en **Tools → Kotlin → Kotlin REPL** o en **play.kotlinlang.org**

---

## EJERCICIO 1 - Seguridad nula

```kotlin
fun describirEstudiante(nombre: String, edad: Int, correo: String?): String {
    val correoMostrado = correo ?: "No registrado"
    return "Nombre: $nombre, Edad: $edad, Correo: $correoMostrado"
}

// Pruebas
println(describirEstudiante("Carlos", 22, "carlos@mail.com"))
println(describirEstudiante("Ana", 21, null))
```

**Salida esperada:**
```
Nombre: Carlos, Edad: 22, Correo: carlos@mail.com
Nombre: Ana, Edad: 21, Correo: No registrado
```

---

## EJERCICIO 2 - Cuando (When)

```kotlin
fun calcularDescuento(tipoCliente: String, monto: Double): Double {
    val descuento = when (tipoCliente.lowercase()) {
        "premium" -> 0.20  // 20%
        "regular" -> 0.10  // 10%
        "nuevo" -> 0.05    // 5%
        else -> 0.0        // 0%
    }
    return monto * (1 - descuento)
}

// Pruebas
println(calcularDescuento("premium", 100000.0))
println(calcularDescuento("regular", 50000.0))
println(calcularDescuento("otro", 30000.0))
```

**Salida esperada:**
```
80000.0
45000.0
30000.0
```

---

## EJERCICIO 3 - Colecciones

```kotlin
data class Estudiante(val nombre: String, val nota: Double)

val estudiantes = listOf(
    Estudiante("María", 4.5),
    Estudiante("Pedro", 2.8),
    Estudiante("Laura", 3.9),
    Estudiante("Juan", 2.5),
    Estudiante("Sofía", 4.2)
)

val aprobados = estudiantes
    .filter { it.nota >= 3.0 }
    .sortedByDescending { it.nota }
    .map { it.nombre }

println(aprobados)
```

**Salida esperada:**
```
[María, Sofía, Laura]
```

---

## EJERCICIO 4 - Data Classes

```kotlin
data class Producto(
    val nombre: String,
    val precio: Double,
    val cantidad: Int
)

fun resumenCarrito(productos: List<Producto>): String {
    val cantidadTotal = productos.sumOf { it.cantidad }
    val montoTotal = productos.sumOf { it.precio * it.cantidad }
    
    return "Artículos: $cantidadTotal, Total: $${"%.2f".format(montoTotal)}"
}

val carrito = listOf(
    Producto("Laptop", 2500000.0, 1),
    Producto("Mouse", 45000.0, 2),
    Producto("Teclado", 120000.0, 1)
)

println(resumenCarrito(carrito))
```

**Salida esperada:**
```
Artículos: 4, Total: $2710000.00
```

---

## OTROS EJEMPLOS ÚTILES DE KOTLIN

### Variables y tipos
```kotlin
// Inmutable
val nombre = "Kotlin"
val version: Int = 14
val pi = 3.14159

// Mutable
var contador = 0
contador = 1

// Nullability
var apellido: String? = null
val longitud = apellido?.length ?: 0
```

### Funciones
```kotlin
// Normal
fun saludar(nombre: String): String = "Hola, $nombre!"

// Con valores por defecto
fun crearUsuario(nombre: String, edad: Int = 18): String {
    return "Usuario: $nombre, Edad: $edad"
}

// Lambda
val duplicar: (Int) -> Int = { numero -> numero * 2 }
val resultado = duplicar(5)  // 10
```

### Condicionales
```kotlin
val edad = 20
val categoria = if (edad >= 18) "Adulto" else "Menor"

val dia = 3
val nombreDia = when (dia) {
    1 -> "Lunes"
    2 -> "Martes"
    3 -> "Miércoles"
    else -> "Otro"
}
```

### Operaciones con listas
```kotlin
val numeros = listOf(1, 2, 3, 4, 5)

val pares = numeros.filter { it % 2 == 0 }
val dobles = numeros.map { it * 2 }
val suma = numeros.sum()

val resultado = numeros
    .filter { it > 2 }
    .map { it * 2 }
    .sum()
```

---

## CHECKLIST DE COMPRENSIÓN

- [ ] Entiendo la diferencia entre `val` y `var`
- [ ] Puedo usar el operador Elvis `?:`
- [ ] Sé cómo usar `when` en lugar de `if-else`
- [ ] Puedo encadenar operaciones sobre listas (filter, map, sorted)
- [ ] Entiendo Data Classes y sus beneficios
- [ ] Puedo escribir lambdas simples
- [ ] Uso string templates en Kotlin
