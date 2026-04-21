# Soluciones Ejercicios Kotlin — Taller Android Studio

## Ejercicio 1 — Seguridad nula

```kotlin
fun describirEstudiante(nombre: String, edad: Int, correo: String?): String {
    val correoMostrado = correo ?: "No registrado"
    return "Nombre: $nombre, Edad: $edad, Correo: $correoMostrado"
}

// Pruebas:
println(describirEstudiante("Carlos", 22, "carlos@mail.com"))
// Resultado: Nombre: Carlos, Edad: 22, Correo: carlos@mail.com

println(describirEstudiante("Ana", 21, null))
// Resultado: Nombre: Ana, Edad: 21, Correo: No registrado
```

**Explicación:** El operador Elvis `?:` proporciona un valor por defecto cuando el lado izquierdo es `null`.

---

## Ejercicio 2 — Cuando

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

// Pruebas:
println(calcularDescuento("premium", 100000.0))  // 80000.0
println(calcularDescuento("regular", 50000.0))   // 45000.0
println(calcularDescuento("otro", 30000.0))      // 30000.0
```

**Explicación:** `when` evalúa el tipo de cliente y aplica el descuento correspondiente. `lowercase()` asegura que funcione independientemente de mayúsculas.

---

## Ejercicio 3 — Colecciones

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
    .filter { it.nota >= 3.0 }           // Filtrar aprobados
    .sortedByDescending { it.nota }     // Ordenar de mayor a menor
    .map { it.nombre }                   // Quedarse solo con nombres

println(aprobados)
// Resultado: [María, Sofía, Laura]
```

**Explicación:** Se encadenan tres operaciones funcionales:
- `filter` elimina los que no aprobaron
- `sortedByDescending` ordena por nota (mayor primero)
- `map` extrae solo los nombres

---

## Ejercicio 4 — Clases de datos

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

// Pruebas:
val carrito = listOf(
    Producto("Laptop", 2500000.0, 1),
    Producto("Mouse", 45000.0, 2),
    Producto("Teclado", 120000.0, 1)
)

println(resumenCarrito(carrito))
// Resultado: Artículos: 4, Total: $2710000.00
```

**Explicación:** 
- `sumOf { it.cantidad }` suma todas las cantidades
- `sumOf { it.precio * it.cantidad }` suma el total por producto
- `"%.2f".format()` formatea el número con 2 decimales

---

## Respuestas a Preguntas de Cierre

### ¿Cuál es la diferencia entre `val` y `var`?
- **`val`** (inmutable): No se puede reasignar después del primer valor. Equivale a `final` en Java.
- **`var`** (mutable): Se puede cambiar el valor cuantas veces sea necesario.

```kotlin
val nombre = "Kotlin"
// nombre = "Java"  // ❌ Error: no se puede reasignar

var edad = 22
age = 23  // ✅ Correcto
```

### ¿Para qué sirve el operador `?:` (Elvis)?
Proporciona un valor por defecto cuando el lado izquierdo es `null`. Es más conciso que `if-else` para nullables.

```kotlin
val apellido: String? = null
val apellidoSeguro = apellido ?: "Desconocido"  // "Desconocido"
```

### ¿Qué genera automáticamente una `data class` que una clase normal no?
Una `data class` genera automáticamente:
- `toString()`: representación en String
- `equals()` y `hashCode()`: comparación y uso en colecciones
- `copy()`: crea una copia modificando solo los campos indicados

```kotlin
data class Persona(val nombre: String, val edad: Int)

val p1 = Persona("Ana", 25)
val p2 = p1.copy(edad = 26)
println(p1)  // Persona(nombre=Ana, edad=25)
println(p2)  // Persona(nombre=Ana, edad=26)
```

### ¿Qué hace el Adapter en un RecyclerView?
El Adapter es el intermediario entre los datos (lista de objetos) y la interfaz (vistas). Se encarga de:
- Crear las vistas (ViewHolder) para cada elemento
- Vincular los datos a cada vista (onBindViewHolder)
- Indicar cuántos elementos hay en la lista

### ¿Por qué usar View Binding en lugar de `findViewById`?
- **Seguridad de tipos**: Evita errores en tiempo de compilación si un ID no existe
- **Rendimiento**: No busca por ID en el árbol de vistas cada vez
- **Nullability**: Manejo automático de vistas opcionales
- **Menos código**: No necesitas casts manuales
