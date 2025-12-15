# TodoList App - Aplicación de Gestión de Tareas

Aplicación móvil Android nativa desarrollada en Kotlin para la gestión de listas de tareas.

## Descripción

TodoList App es una herramienta simple y funcional para gestionar tareas pendientes. Permite a los usuarios crear, visualizar, completar y eliminar tareas de manera intuitiva.

## Características Principales

### 1. Pantalla de Inicio

- Resumen visual de tareas pendientes y completadas
- Navegación rápida a la lista completa de tareas
- Botón flotante para agregar nuevas tareas

### 2. Agregar Tareas

- Formulario simple con tres campos:
  - **Nombre**: Título de la tarea
  - **Descripción**: Detalles de la tarea
  - **Tipo**: Clasificación (Trabajo, Casa, Negocios)
- Validación de campos obligatorios

### 3. Lista de Tareas

- Vista completa de todas las tareas
- Cada tarea muestra:
  - Nombre y descripción
  - Tipo de tarea
  - Estado (pendiente/completada)
- Acciones disponibles:
  - Marcar como completada
  - Eliminar tarea
  - Ver detalles completos

### 4. Detalles de Tarea

- Visualización completa de la información de la tarea
- Opciones para completar o eliminar
- Navegación clara desde la lista de tareas

## Tecnologías Utilizadas

- **Lenguaje**: Kotlin
- **Framework**: Android Native
- **UI**: Material Design 3
- **Almacenamiento**: SharedPreferences con Gson
- **Arquitectura**: Patrón MVC simplificado
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)

## Estructura del Proyecto

```
TodoListApp/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/todolist/
│   │   │   ├── MainActivity.kt              # Pantalla de inicio
│   │   │   ├── AddTaskActivity.kt           # Pantalla para agregar tareas
│   │   │   ├── TaskListActivity.kt          # Lista de tareas
│   │   │   ├── TaskDetailActivity.kt        # Detalles de tarea
│   │   │   ├── models/
│   │   │   │   └── Task.kt                  # Modelo de datos
│   │   │   ├── utils/
│   │   │   │   └── TaskManager.kt           # Gestor de persistencia
│   │   │   └── adapters/
│   │   │       └── TaskAdapter.kt           # Adaptador RecyclerView
│   │   ├── res/
│   │   │   ├── layout/                      # Archivos XML de interfaz
│   │   │   └── values/                      # Recursos (strings, colors)
│   │   └── AndroidManifest.xml
│   └── build.gradle
└── README.md
```

## Requisitos del Sistema

### Para Desarrollo

- Android Studio Giraffe (2022.3.1) o superior
- JDK 8 o superior
- SDK de Android (API 24 - API 34)
- Gradle 8.1.0 o superior

### Para Ejecución

- Dispositivo Android con versión 7.0 (API 24) o superior
- Al menos 50 MB de espacio disponible

## Instalación y Configuración

### Opción 1: Abrir en Android Studio

1. **Clonar o descargar el proyecto**

   ```bash
   git clone [URL_DEL_REPOSITORIO]
   ```

2. **Abrir Android Studio**

   - File → Open
   - Navegar a la carpeta del proyecto
   - Seleccionar la carpeta raíz "Proyecto Final"
   - Click en "OK"

3. **Sincronizar Gradle**

   - Android Studio sincronizará automáticamente
   - Si no lo hace, click en: File → Sync Project with Gradle Files

4. **Esperar la sincronización**
   - El proceso puede tardar unos minutos
   - Se descargarán las dependencias necesarias

### Opción 2: Instalar APK Directamente

1. Descargar el archivo APK desde la carpeta `releases/`
2. En el dispositivo Android:
   - Ir a Configuración → Seguridad
   - Habilitar "Instalación de apps de fuentes desconocidas"
3. Abrir el archivo APK descargado
4. Seguir las instrucciones de instalación

## Cómo Probar la Aplicación

### Método 1: Emulador de Android Studio

1. **Crear un Emulador** (si no tienes uno)

   - Tools → Device Manager
   - Click en "Create Device"
   - Seleccionar un dispositivo (recomendado: Pixel 6)
   - Seleccionar imagen del sistema (API 34 recomendado)
   - Click en "Finish"

2. **Ejecutar la Aplicación**
   - Click en el botón "Run" (▶️) en la barra superior
   - Seleccionar el emulador creado
   - Esperar que la app se compile e instale

### Método 2: Dispositivo Físico

1. **Habilitar Opciones de Desarrollador**

   - Ir a Configuración → Acerca del teléfono
   - Tocar 7 veces en "Número de compilación"

2. **Habilitar Depuración USB**

   - Configuración → Sistema → Opciones de desarrollador
   - Activar "Depuración USB"

3. **Conectar el Dispositivo**

   - Conectar el dispositivo al PC mediante USB
   - Aceptar el mensaje de depuración USB en el dispositivo

4. **Ejecutar desde Android Studio**
   - Click en "Run" (▶️)
   - Seleccionar tu dispositivo de la lista
   - La app se instalará y ejecutará

## Generar APK

### APK de Depuración (Debug)

1. En Android Studio:
   - Build → Build Bundle(s) / APK(s) → Build APK(s)
2. Esperar la compilación
3. Click en "locate" cuando aparezca la notificación
4. El APK estará en: `app/build/outputs/apk/debug/app-debug.apk`

### APK de Lanzamiento (Release)

1. En Android Studio:
   - Build → Generate Signed Bundle / APK
   - Seleccionar "APK"
   - Click en "Next"
   - Crear o seleccionar un keystore (primera vez)
   - Completar la información de firma
   - Seleccionar "release" como build variant
   - Click en "Finish"
2. El APK estará en: `app/build/outputs/apk/release/app-release.apk`

## Guía de Uso

### 1. Inicio

Al abrir la app, verás la pantalla principal con:

- Número de tareas pendientes (naranja)
- Número de tareas completadas (verde)
- Botón "Ver Todas las Tareas"
- Botón flotante "+" para agregar tareas

### 2. Agregar una Tarea

1. Click en el botón flotante "+"
2. Completa los campos:
   - Nombre de la tarea
   - Descripción
   - Selecciona el tipo (Trabajo/Casa/Negocios)
3. Click en "Guardar"

### 3. Ver Lista de Tareas

1. Click en "Ver Todas las Tareas" desde la pantalla principal
2. Verás todas tus tareas organizadas
3. Desde aquí puedes:
   - Click en una tarea para ver detalles
   - "Marcar como completada" para terminar una tarea
   - "Eliminar" para borrar una tarea

### 4. Ver Detalles

1. Click en cualquier tarea de la lista
2. Verás toda la información detallada
3. Puedes marcarla como completada o eliminarla

## Almacenamiento de Datos

- Las tareas se guardan en **SharedPreferences**
- Utiliza **Gson** para serialización de objetos
- Los datos persisten entre sesiones
- No requiere conexión a internet
- Almacenamiento local en el dispositivo

## Características Técnicas

### Componentes Principales

1. **Task.kt**: Modelo de datos con propiedades:

   - id (UUID único)
   - name (String)
   - description (String)
   - type (TaskType enum)
   - isCompleted (Boolean)
   - createdAt (Long timestamp)

2. **TaskManager.kt**: Singleton para gestión de datos

   - CRUD completo de tareas
   - Persistencia con SharedPreferences
   - Métodos para filtrar tareas pendientes/completadas

3. **Activities**: 4 pantallas principales
   - MainActivity: Resumen
   - AddTaskActivity: Formulario de creación
   - TaskListActivity: Lista completa con RecyclerView
   - TaskDetailActivity: Vista detallada

### Dependencias

```gradle
implementation 'androidx.core:core-ktx:1.12.0'
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'com.google.android.material:material:1.11.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
implementation 'com.google.code.gson:gson:2.10.1'
```

## Solución de Problemas

### Error de Sincronización Gradle

- Verificar conexión a internet
- File → Invalidate Caches / Restart
- Verificar que la versión de Gradle sea compatible

### APK no Instala en el Dispositivo

- Verificar que la versión de Android sea 7.0 o superior
- Habilitar instalación de fuentes desconocidas
- Verificar espacio disponible en el dispositivo

### Emulador Lento

- Asignar más RAM al emulador
- Habilitar aceleración de hardware (HAXM/WHPX)
- Usar un emulador con API más reciente

### Cambios no se Reflejan

- Hacer Clean Project (Build → Clean Project)
- Rebuild Project (Build → Rebuild Project)
- Reinstalar la app en el dispositivo/emulador
