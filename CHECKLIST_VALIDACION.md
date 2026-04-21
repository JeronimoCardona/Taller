# CHECKLIST - Taller Android Studio con Kotlin

**Nombre:** ________________________  
**Fecha:** ______________

---

## BLOQUE 1: Configuración del entorno (30 min)

- [ ] Android Studio instalado y abierto
- [ ] Creado proyecto "ListaDeTareas"
- [ ] Paquete configurado como `com.ejemplo.listadetareas`
- [ ] SDK mínimo en API 24
- [ ] Gradle sincronizado correctamente
- [ ] Emulador Pixel 6 con API 34 creado (o celular conectado)
- [ ] La aplicación "¡Hola Mundo!" se ejecuta correctamente

---

## BLOQUE 2: Sintaxis de Kotlin (60 min)

### Variables
- [ ] Entiendo diferencia entre `val` (inmutable) y `var` (mutable)
- [ ] Puedo declarar variables con y sin tipos explícitos
- [ ] Comprendo la inferencia de tipos en Kotlin

### Seguridad nula
- [ ] Entiendo los tipos nullable (`String?`)
- [ ] Uso el operador acceso seguro (`?.`)
- [ ] Uso el operador Elvis (`?:`) correctamente
- [ ] No usaría el operador `!!` sin razón

### Funciones
- [ ] Puedo escribir funciones simples
- [ ] Entiendo funciones con valores por defecto
- [ ] Puedo usar argumentos nombrados
- [ ] Comprendo las lambdas y su sintaxis

### Condicionales
- [ ] Uso `if` para devolver valores
- [ ] Entiendo `when` como reemplazo de `switch`
- [ ] Puedo escribir `when` con múltiples condiciones

### Colecciones
- [ ] Sé la diferencia entre `listOf()` y `mutableListOf()`
- [ ] Uso `.filter { }` para filtrar elementos
- [ ] Uso `.map { }` para transformar elementos
- [ ] Puedo encadenar operaciones sobre listas
- [ ] Entiendo `mapOf()` para diccionarios

### Clases
- [ ] Entiendo las Data Classes
- [ ] Sé qué genera automáticamente una Data Class
- [ ] Conozco el método `copy()` de Data Classes

---

## BLOQUE 3: Ejercicios de práctica (30 min)

### Ejercicio 1 - Seguridad nula
- [ ] Función `describirEstudiante()` escrita
- [ ] Maneja `null` correctamente con Elvis
- [ ] Prueba con Carlos → correcto
- [ ] Prueba con Ana (null) → correcto

### Ejercicio 2 - Cuando
- [ ] Función `calcularDescuento()` escrita
- [ ] Usa `when` con `tipoCliente.lowercase()`
- [ ] Premium: 20% descuento
- [ ] Regular: 10% descuento
- [ ] Nuevo: 5% descuento
- [ ] Pruebas pasan correctamente

### Ejercicio 3 - Colecciones
- [ ] Data Class `Estudiante` creada
- [ ] Filtra aprobados (nota >= 3.0)
- [ ] Ordena de mayor a menor nota
- [ ] Extrae solo nombres
- [ ] Resultado: [María, Sofía, Laura]

### Ejercicio 4 - Data Classes
- [ ] Data Class `Producto` creada
- [ ] Función `resumenCarrito()` escrita
- [ ] Cuenta cantidad total correctamente
- [ ] Suma montos correctamente
- [ ] Formatea con 2 decimales
- [ ] Resultado esperado: "Artículos: 4, Total: $2710000.00"

---

## BLOQUE 4: Receso (15 min)

- [ ] Descansé 15 minutos ☕

---

## BLOQUE 5: Estructura Android (25 min)

- [ ] Entiendo la estructura `app/src/main/`
- [ ] Sé dónde van los archivos Kotlin (`java/com/ejemplo/...`)
- [ ] Sé dónde van los XMLs (`res/layout/`)
- [ ] Conozco `AndroidManifest.xml` y su propósito
- [ ] Encuentro `MainActivity.kt` fácilmente
- [ ] Entiendo qué es View Binding
- [ ] View Binding activado en `build.gradle.kts`

---

## BLOQUE 6: Aplicación Lista de Tareas (70 min)

### Setup (7 min)
- [ ] Proyecto "ListaDeTareas" creado
- [ ] Paquete: `com.ejemplo.listadetareas`
- [ ] View Binding activado
- [ ] Sincronización completada

### Archivos creados (32 min)

**Tarea.kt**
- [ ] Data class creada con:
  - [ ] `id: Int`
  - [ ] `titulo: String`
  - [ ] `completada: Boolean = false`

**item_tarea.xml**
- [ ] XML copiado correctamente
- [ ] CheckBox con id `cbCompletada`
- [ ] TextView con id `tvTitulo`
- [ ] ImageButton con id `btnEliminar`

**TareaAdapter.kt**
- [ ] Adapter creado e importaciones correctas
- [ ] TODO 1: `tvTitulo.text = tarea.titulo` ✓
- [ ] TODO 2: `cbCompletada.isChecked = tarea.completada` ✓
- [ ] TODO 3: CheckBox listener actualiza estado ✓
- [ ] TODO 4: Botón eliminar llama a `onEliminar()` ✓

**activity_main.xml**
- [ ] XML copiado correctamente
- [ ] EditText con id `etNuevaTarea`
- [ ] Button con id `btnAgregar`
- [ ] TextView con id `tvContador`
- [ ] RecyclerView con id `rvTareas`

**MainActivity.kt**
- [ ] TODO 1: Adapter creado con lambda ✓
- [ ] TODO 2: LinearLayoutManager asignado ✓
- [ ] TODO 3: Adapter asignado a RecyclerView ✓
- [ ] TODO 4: `contadorId++` en agregarTarea ✓
- [ ] TODO 5: Nueva Tarea creada ✓
- [ ] TODO 6: Tarea agregada a lista ✓
- [ ] TODO 7: `notifyItemInserted()` llamado ✓
- [ ] TODO 8: `actualizarContador()` llamado ✓
- [ ] TODO 9: Tarea removida en eliminarTarea ✓
- [ ] TODO 10: Notificaciones de adapter ✓
- [ ] TODO 11: `actualizarContador()` en eliminarTarea ✓
- [ ] TODO 12: Contador de pendientes calculado ✓
- [ ] TODO 13: TextView actualizado ✓

### Pruebas funcionales (8 min)

- [ ] **Agregar tareas:** Escribo "Estudiar Kotlin" y aparece en la lista
- [ ] **Marcar completada:** Al hacer check, el texto se tacha
- [ ] **Eliminar tarea:** Al clickear basura, desaparece
- [ ] **Contador actualiza:** De "0 tareas" a "1 tarea" al agregar
- [ ] **Contador al completar:** Disminuye al marcar como completada
- [ ] **Validación:** No puedo agregar tarea vacía (muestra Toast)
- [ ] **Múltiples tareas:** Puedo agregar y gestionar varias tareas
- [ ] **UI responsive:** La app no se congela al realizar acciones

---

## BLOQUE 7: Cierre y Preguntas (10 min)

### Responde brevemente:

**1. ¿Cuál es la diferencia entre `val` y `var`?**
```
Escribir respuesta aquí:
_________________________________________________________________
_________________________________________________________________
```

**2. ¿Para qué sirve el operador Elvis `?:`?**
```
Escribir respuesta aquí:
_________________________________________________________________
_________________________________________________________________
```

**3. ¿Qué genera automáticamente una data class?**
```
Escribir respuesta aquí:
_________________________________________________________________
_________________________________________________________________
```

**4. ¿Qué hace el Adapter en un RecyclerView?**
```
Escribir respuesta aquí:
_________________________________________________________________
_________________________________________________________________
```

**5. ¿Por qué usar View Binding en lugar de findViewById?**
```
Escribir respuesta aquí:
_________________________________________________________________
_________________________________________________________________
```

---

## REFLEXIÓN FINAL

**Puntos clave aprendidos:**
- [ ] Kotlin es conciso y seguro (nullability)
- [ ] Android tiene una estructura clara de componentes
- [ ] El patrón Adapter + RecyclerView es poderoso
- [ ] Data Classes simplifican el código mucho

**Preguntas que tengo:**
```
_________________________________________________________________
_________________________________________________________________
_________________________________________________________________
```

**Para seguir practicando en casa:**
- [ ] Agregar persistencia con `SharedPreferences`
- [ ] Implementar edición de tareas
- [ ] Agregar categorías con `Spinner`
- [ ] Mejorar UI con `MaterialCardView`

---

**TOTAL COMPLETADO:** ____ / 50 puntos

**COMENTARIOS DEL INSTRUCTOR:**

_________________________________________________________________
_________________________________________________________________
_________________________________________________________________

---

**Fecha de finalización:** ______________  
**Firma del estudiante:** ______________
