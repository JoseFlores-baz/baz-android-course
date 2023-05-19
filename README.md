# Reto de Criptomonedas
El desafío original consistia en construir una aplicación de Android completa por cuenta propia. Sin limitaciones.
El propósito original era construir una aplicación que use la API pública de Bitso, la cuál debía incluir:

- Una pantalla que muestre todas las monedas disponibles
- Una pantalla de detalle para cada moneda
- Persistencia local

## Requerimientos

- La aplicación debe implementar lo siguiente:
    - Mejores prácticas
    - Diseño de API
    - Diseño de UI
    - Patrones de diseño


## Los entregables: 

## Primer Entregable
Con base en el material de autoestudio y las mentorías hasta este entregable, sugerimos que desarrolles lo siguiente:

- Crear un cliente de red para poder consumir los siguientes servicios haciendo uso de `GsonAdapter` para obtener las clases de manera sencilla:
  - https://bitso.com/api_info#available-books
  - https://bitso.com/api_info#ticker
  - https://bitso.com/api_info#order-book 
- Busca imágenes que representen las monedas y agrega dichas imágenes a la lista de monedas.
- Trabaja con MVVM y LiveData para poder diseñar la aplicación:
    - Crear una pantalla que va a mostrar una lista de las monedas utilizando el servicio `available-books`
    - Crear una pantalla de detalle que mostrará el último precio, el más alto y el más bajo. Además, mostrar una lista de `bids` y `asks` haciendo uso del servicio `order-book`
- Hacer uso de buenas prácticas



## Segundo Entregable

Con base en el material de autoestudio y las mentorías hasta este entregable, sugerimos que desarrolles lo siguiente:

- Agregar persistencia utilizando `Room` para poder usar la aplicación cuando no se cuente con conexión a internet.
- Agregar la librería `OkHttp` para hacer uso del `HttpLoggingInterceptor` para todos los eventos de red, y además añadir el header `User-Agent`
- Implementar `function type`, `lambdas` y `extension function`
- Agregar algunas pruebas unitarias y de vista.
- Hacer _refactor_ de la vista, actualiza tus layouts haciendo uso de `ConstraintLayout`
- Hacer uso de buenas prácticas


## Tercer y último entregable
- Agrega un `linter` para poder hacer análisis estático de tu código.
- Has uso de algunas características avanzadas de Kotlin como: `inline functions`, `tail recursive`, `delegated properties` y `collection operations`
- Implementa `coroutines` y usa `suspend functions` con _Retrofit_.
- Implementa Hilt como _framework_ de inyección de dependencias.
- Implementa `navigation component` para navegar entre las distintas pantallas.
- Implementa RxJava2 o RxJava3, envuelve la respuesta de _Retrofit_ y crea un `observable` que vaya a ser observado o cambia la respuesta de _Retrofit_ a un `Observable`.
- Hacer uso de buenas prácticas


## Fases posteriores:

Posteriormente a los entregables originales he creadao una migracion de la UI de legacy a JetPack Compose en la rama:
- compose_migration

Esta rama se ha integrado a main.
