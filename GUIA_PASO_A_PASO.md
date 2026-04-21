# GUÍA PASO A PASO - Taller Android Studio con Kotlin

## PARTE 1: Preparación en Android Studio

### Paso 1: Crear el proyecto
1. Abre Android Studio
2. Selecciona **File → New → New Project**
3. Elige **Empty Views Activity**
4. Completa los campos:
   - **Name:** ListaDeTareas
   - **Package name:** com.ejemplo.listadetareas
   - **Save location:** Elige donde quieras
   - **Language:** Kotlin
   - **Minimum SDK:** API 24
   - **Build configuration language:** Kotlin DSL
5. Click en **Finish**
6. Espera a que termine de sincronizar Gradle (verás abajo a la derecha "Gradle: Build successful")

---

### Paso 2: Activar View Binding

1. Abre el archivo `build.gradle.kts` del módulo `app`
2. Busca el bloque `android { }`
3. Dentro, agrega este código (después de `buildTypes`):

```kotlin
buildFeatures {
    viewBinding = true
}
```

4. Click en **Sync Now** (aparecerá una barra azul arriba)
5. Espera a que termine

---

## PARTE 2: Crear los archivos

### Paso 3: Crear la clase Tarea

1. En el panel izquierdo (Project), expande:
   - `app` → `src` → `main` → `java` → `com` → `ejemplo` → `listadetareas`

2. Click derecho en la carpeta `listadetareas` → **New → Kotlin Class/File**

3. Nombre: `Tarea`

4. Selecciona **File** y click **OK**

5. Copia y pega el contenido de `Tarea.kt` (del archivo creado)

6. El código quedará así:
```kotlin
package com.ejemplo.listadetareas

data class Tarea(
    val id: Int,
    val titulo: String,
    var completada: Boolean = false
)
```

---

### Paso 4: Crear los layouts XML

#### 4.1 Crear `activity_main.xml`

1. En el panel izquierdo, expande:
   - `app` → `src` → `main` → `res` → `layout`

2. Click derecho en `layout` → **New → Layout Resource File**

3. Nombre: `activity_main`

4. Click **OK**

5. Reemplaza TODO el contenido con el código de `activity_main.xml`

#### 4.2 Crear `item_tarea.xml`

1. Click derecho en `layout` → **New → Layout Resource File**

2. Nombre: `item_tarea`

3. Click **OK**

4. Reemplaza TODO el contenido con el código de `item_tarea.xml`

---

### Paso 5: Crear el Adapter

1. Click derecho en la carpeta `listadetareas` → **New → Kotlin Class/File**

2. Nombre: `TareaAdapter`

3. Selecciona **File** y click **OK**

4. Copia y pega el contenido de `TareaAdapter.kt`

---

### Paso 6: Reemplazar MainActivity

1. Abre `MainActivity.kt` (debería estar abierto ya)

2. Selecciona TODO el contenido (Ctrl + A)

3. Pega el contenido de `MainActivity.kt` (el archivo creado)

---

## PARTE 3: Probar la aplicación

### Paso 7: Crear un emulador (o conectar celular)

**OPCIÓN A: Usar emulador**

1. Abre el **Device Manager** (arriba a la derecha, aparece como un icono de teléfono)

2. Click en **Create Device**

3. Selecciona **Pixel 6** y click **Next**

4. En "System Image", selecciona **API 34** y click **Next**

5. Click **Finish**

6. Espera a que descargue (puede tomar un par de minutos)

**OPCIÓN B: Conectar celular físico**

1. Conecta el celular por USB
2. En el celular: Ajustes → Opciones de desarrollador → Activar "Depuración USB"
3. Acepta el permiso en el celular

### Paso 8: Ejecutar la app

1. Click en el botón **▶ (Play)** (verde, arriba a la derecha)

2. O presiona **Shift + F10**

3. El emulador se abrirá y compilará la app (puede tardar 1-2 minutos la primera vez)

4. Deberías ver la app con:
   - Título "Mis Tareas"
   - Campo para escribir tareas
   - Un botón "Agregar"
   - Un contador de tareas pendientes
   - Una lista vacía

---

## PARTE 4: Probar funcionalidades

### Agregar tareas
1. Escribe "Estudiar Kotlin" en el campo
2. Click en **Agregar**
3. La tarea debe aparecer en la lista

### Marcar como completada
1. Click en el CheckBox de la tarea
2. El texto debe tacharse

### Eliminar tarea
1. Click en el botón de basura
2. La tarea debe desaparecer

### Ver contador
1. El contador debe actualizarse automáticamente
2. Ej: "3 tareas pendientes"

---

## TROUBLESHOOTING (Si algo no funciona)

### "Error: Cannot resolve symbol ActivityMainBinding"
- Solución: Verifica que View Binding esté activado en `build.gradle.kts`
- Click en **Sync Now**

### "Error: Package name mismatch"
- Solución: Verifica que el `package` en cada archivo sea exactamente:
  ```
  com.ejemplo.listadetareas
  ```

### El emulador va muy lento
- Solución: Conecta un celular físico por USB (ver Paso 7, Opción B)

### "Gradle sync failed"
- Solución: 
  - Click en **File → Invalidate Caches**
  - Click **Invalidate and Restart**
  - Espera a que reinicie

---

## RESPUESTAS A LAS PREGUNTAS DE CIERRE

**¿Cuál es la diferencia entre `val` y `var`?**
- `val`: inmutable (no se puede cambiar)
- `var`: mutable (se puede cambiar)

**¿Para qué sirve el operador `?:`?**
- Proporciona un valor por defecto cuando algo es `null`
- Ej: `apellido ?: "Desconocido"`

**¿Qué genera automáticamente una data class?**
- `toString()`, `equals()`, `hashCode()` y `copy()`

**¿Qué hace el Adapter en un RecyclerView?**
- Conecta los datos (lista de objetos) con la interfaz (vistas en pantalla)

**¿Por qué usar View Binding en lugar de `findViewById`?**
- Es más seguro (sin errores de tipos)
- Es más rápido
- Genera menos código
- Es más legible

---

## IDEAS PARA AMPLIAR LA APP

1. **Guardar tareas:** Usa `SharedPreferences` para que persistan al cerrar
2. **Editar tareas:** Agrega un botón para modificar el título
3. **Categorías:** Usa un `Spinner` para clasificar tareas
4. **Mejor diseño:** Usa `MaterialCardView` para cada tarea
5. **Colores:** Cambia colores según si está completada o no

¡Listo! Ahora tienes todo para completar el taller. 🚀
