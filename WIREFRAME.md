# Wireframe/Prototipo - TodoList App

Este documento describe el diseño visual y la experiencia de usuario de la aplicación TodoList.

## Flujo de Navegación

```
[Pantalla de Inicio]
    ├──> [Agregar Tarea] ──> [Volver a Inicio]
    └──> [Lista de Tareas]
            └──> [Detalle de Tarea] ──> [Volver a Lista]
```

---

## Pantalla 1: Pantalla de Inicio (MainActivity)

### Diseño Visual
```
┌─────────────────────────────────┐
│  ← TodoList App                 │ (Action Bar)
├─────────────────────────────────┤
│                                 │
│        Mis Tareas               │ (Título grande)
│                                 │
│   ┌───────────────────────┐    │
│   │  Tareas Pendientes    │    │ (Card naranja)
│   │                       │    │
│   │         5             │    │ (Número grande)
│   └───────────────────────┘    │
│                                 │
│   ┌───────────────────────┐    │
│   │  Tareas Completadas   │    │ (Card verde)
│   │                       │    │
│   │         12            │    │ (Número grande)
│   └───────────────────────┘    │
│                                 │
│   ┌───────────────────────┐    │
│   │ Ver Todas las Tareas  │    │ (Botón primario)
│   └───────────────────────┘    │
│                                 │
│                           ( + ) │ (FAB flotante)
└─────────────────────────────────┘
```

### Elementos Interactivos
1. **Botón "Ver Todas las Tareas"**: Navega a la lista completa
2. **FAB (+)**: Abre el formulario para agregar nueva tarea

### Experiencia de Usuario
- Al abrir la app, el usuario ve inmediatamente un resumen visual
- Los colores (naranja/verde) facilitan identificar el estado
- El FAB está en posición ergonómica (esquina inferior derecha)
- La pantalla se actualiza automáticamente al regresar

---

## Pantalla 2: Agregar Tarea (AddTaskActivity)

### Diseño Visual
```
┌─────────────────────────────────┐
│  ← Nueva Tarea                  │ (Action Bar)
├─────────────────────────────────┤
│                                 │
│  Nueva Tarea                    │ (Título)
│                                 │
│  ┌───────────────────────────┐ │
│  │ Nombre de la tarea        │ │ (Input text)
│  └───────────────────────────┘ │
│                                 │
│  ┌───────────────────────────┐ │
│  │ Descripción               │ │
│  │                           │ │ (Input multiline)
│  │                           │ │
│  └───────────────────────────┘ │
│                                 │
│  Tipo de tarea                  │
│  ◉ Trabajo                      │ (Radio button)
│  ○ Casa                         │ (Radio button)
│  ○ Negocios                     │ (Radio button)
│                                 │
│  ┌───────────────────────────┐ │
│  │      Guardar              │ │ (Botón primario)
│  └───────────────────────────┘ │
│                                 │
│  ┌───────────────────────────┐ │
│  │      Cancelar             │ │ (Botón outline)
│  └───────────────────────────┘ │
│                                 │
└─────────────────────────────────┘
```

### Elementos Interactivos
1. **Campo Nombre**: Input de una línea
2. **Campo Descripción**: Input multilinea (3-5 líneas)
3. **Radio Buttons**: Selección única entre tres tipos
4. **Botón Guardar**: Valida y guarda la tarea
5. **Botón Cancelar**: Descarta y vuelve atrás
6. **Flecha de retroceso**: En Action Bar

### Experiencia de Usuario
- Formulario simple y directo
- Validación: muestra mensaje si faltan campos
- "Trabajo" seleccionado por defecto
- Feedback visual al guardar (Toast message)
- Retorna automáticamente a la pantalla anterior

---

## Pantalla 3: Lista de Tareas (TaskListActivity)

### Diseño Visual
```
┌─────────────────────────────────┐
│  ← Lista de Tareas              │ (Action Bar)
├─────────────────────────────────┤
│                                 │
│  Lista de Tareas                │ (Título)
│                                 │
│  ┌───────────────────────────┐ │
│  │ Reunión del equipo    [T] │ │ (Card)
│  │ Discutir el proyecto      │ │
│  │                           │ │
│  │  [Completar]  [Eliminar]  │ │
│  └───────────────────────────┘ │
│                                 │
│  ┌───────────────────────────┐ │
│  │ Comprar despensa      [C] │ │ (Card)
│  │ Leche, pan, huevos        │ │
│  │                           │ │
│  │  [Completar]  [Eliminar]  │ │
│  └───────────────────────────┘ │
│                                 │
│  ┌───────────────────────────┐ │
│  │ Llamar al cliente     [N] │ │ (Card - completada)
│  │ Seguimiento de venta      │ │ (texto en gris)
│  │                           │ │
│  │               [Eliminar]  │ │ (sin botón completar)
│  └───────────────────────────┘ │
│                                 │
└─────────────────────────────────┘
```

### Elementos Interactivos
1. **Card de Tarea**: Click abre los detalles
2. **Botón Completar**: Marca tarea como completada
3. **Botón Eliminar**: Muestra diálogo de confirmación
4. **Scroll Vertical**: Para ver más tareas

### Experiencia de Usuario
- Las tareas completadas se muestran en gris
- Botón "Completar" desaparece en tareas completadas
- Descripción truncada a 2 líneas con "..."
- Tipo de tarea mostrado como badge: [T]rabajo, [C]asa, [N]egocios
- Mensaje "No hay tareas" si la lista está vacía
- Confirmación antes de eliminar

---

## Pantalla 4: Detalle de Tarea (TaskDetailActivity)

### Diseño Visual
```
┌─────────────────────────────────┐
│  ← Detalles de Tarea            │ (Action Bar)
├─────────────────────────────────┤
│                                 │
│  Detalles de Tarea              │ (Título)
│                                 │
│  ┌───────────────────────────┐ │
│  │                           │ │
│  │  NOMBRE DE LA TAREA       │ │ (Card elevado)
│  │  Reunión del equipo       │ │
│  │                           │ │
│  │  ───────────────────────  │ │
│  │                           │ │
│  │  DESCRIPCIÓN              │ │
│  │  Discutir el avance del   │ │
│  │  proyecto y asignar       │ │
│  │  nuevas tareas            │ │
│  │                           │ │
│  │  ───────────────────────  │ │
│  │                           │ │
│  │  TIPO DE TAREA            │ │
│  │  [Trabajo]                │ │ (Badge)
│  │                           │ │
│  │  ───────────────────────  │ │
│  │                           │ │
│  │  ESTADO                   │ │
│  │  Pendiente                │ │ (naranja/verde)
│  │                           │ │
│  └───────────────────────────┘ │
│                                 │
│  ┌───────────────────────────┐ │
│  │  Marcar como Completada   │ │ (Botón primario)
│  └───────────────────────────┘ │
│                                 │
│  ┌───────────────────────────┐ │
│  │      Eliminar Tarea       │ │ (Botón rojo outline)
│  └───────────────────────────┘ │
│                                 │
└─────────────────────────────────┘
```

### Elementos Interactivos
1. **Botón "Marcar como Completada"**: Cambia estado (desaparece si ya está completada)
2. **Botón "Eliminar Tarea"**: Muestra confirmación y elimina
3. **Flecha de retroceso**: Vuelve a la lista

### Experiencia de Usuario
- Muestra toda la información sin truncar
- Estado visual claro (colores naranja/verde)
- Botón de completar desaparece si ya está completada
- Confirmación antes de eliminar
- Al eliminar, regresa a la lista automáticamente

---

## Paleta de Colores

### Colores Principales
- **Primary**: Púrpura (#6200EE) - Títulos y elementos principales
- **Accent**: Verde azulado (#03DAC5) - FAB y acentos

### Colores de Estado
- **Naranja** (#FF9800): Tareas pendientes
- **Verde** (#4CAF50): Tareas completadas
- **Rojo** (#F44336): Eliminar/advertencias

### Colores Neutros
- **Negro** (#000000): Texto principal
- **Gris oscuro** (#9E9E9E): Texto secundario
- **Gris claro** (#E0E0E0): Bordes y separadores
- **Blanco** (#FFFFFF): Fondo

---

## Interacciones y Gestos

### Navegación
1. **Tap en card**: Ver detalles
2. **Tap en botón**: Ejecutar acción
3. **Flecha atrás**: Regresar a pantalla anterior
4. **Botón físico atrás**: Comportamiento estándar de Android

### Feedback Visual
1. **Toast Messages**:
   - "Tarea agregada exitosamente"
   - "Tarea completada"
   - "Tarea eliminada"
   - "Por favor completa todos los campos"

2. **Diálogos de Confirmación**:
   - Al eliminar tarea (¿Estás seguro?)

3. **Estados Visuales**:
   - Botones presionados (ripple effect)
   - Cards seleccionables
   - Inputs activos (línea inferior coloreada)

---

## Flujo de Usuario Típico

### Escenario 1: Agregar Primera Tarea
1. Usuario abre la app → Ve 0 pendientes, 0 completadas
2. Click en FAB (+) → Se abre formulario
3. Completa campos → Click en "Guardar"
4. Toast "Tarea agregada" → Vuelve a inicio
5. Ve 1 pendiente, 0 completadas

### Escenario 2: Completar Tarea
1. Usuario en inicio → Click "Ver Todas las Tareas"
2. Ve lista de tareas → Click en "Completar" en una tarea
3. Toast "Tarea completada" → Tarea se vuelve gris
4. Vuelve a inicio → Contadores actualizados

### Escenario 3: Ver Detalles y Eliminar
1. Usuario en lista → Click en una tarea
2. Ve detalles completos → Click en "Eliminar Tarea"
3. Diálogo de confirmación → Click en "Eliminar"
4. Toast "Tarea eliminada" → Vuelve a lista
5. Tarea ya no aparece

---

## Diseño Responsivo

### Orientación Portrait (Vertical)
- Diseño optimizado para uso con una mano
- FAB accesible con el pulgar
- Cards de ancho completo

### Orientación Landscape (Horizontal)
- Layouts se adaptan automáticamente
- ConstraintLayout mantiene proporciones
- ScrollView permite navegación vertical

---

## Accesibilidad

1. **Tamaños de Texto**: Mínimo 14sp, títulos 18-24sp
2. **Contraste**: Cumple con estándares WCAG
3. **Áreas Táctiles**: Mínimo 48dp x 48dp
4. **Content Descriptions**: En FAB y botones de acción
5. **Navegación por Teclado**: Soportada en inputs

---

## Estados de la Aplicación

### Estado Vacío
- Pantalla de inicio: 0 pendientes, 0 completadas
- Lista de tareas: Mensaje "No hay tareas"

### Estado con Datos
- Contadores actualizados
- Lista scrolleable
- Todas las funciones activas

### Estado de Tarea Completada
- Texto en gris (alpha 0.5)
- Sin botón "Completar"
- Solo botón "Eliminar" disponible

---

Este diseño prioriza la **simplicidad** y **usabilidad**, cumpliendo con todos los requisitos del proyecto mientras mantiene una experiencia de usuario clara y directa.
