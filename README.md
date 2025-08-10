# Challenge ONE - Conversor de Moneda

## Descripción
Este proyecto es un conversor de monedas desarrollado en Java como parte del Challenge ONE. Permite convertir valores entre diferentes monedas, utilizando una API externa para obtener tasas de conversión en tiempo real. 

## Uso
1. Ejecuta la clase principal `ConversorMoneda.java`.
2. En la consola, se mostrara un menú con distintas opciones:
   - 1: Convertir entre USD y otra moneda.
   - 2: Convertir entre cualquier moneda de la lista.
   - 3: Salir.
3. Selecciona una opción y sigue las instrucciones en pantalla para elegir monedas base y objetivo.
4. Ingresa el monto a convertir.
5. El programa mostrará el resultado de la conversión, por ejemplo: "El valor 100 [USD] corresponde al valor final de =>>> 95000 [COP]".

**Nota:** Se Requiere tener conexión a internet para consultar la API de tasas de cambio (https://exchangerate-api.com).

## Funcionalidades
- **Menú interactivo:** Permite seleccionar conversiones con USD como base o entre cualquier par de monedas.
- **Lista de monedas predefinida:** Incluye ARS, BOB, BRL, CLP, COP y USD.
- **Consulta a API externa:** Se ejecuta una peticion HTTP para obtener tasas de conversión en tiempo real y calcula el resultado.

## Instalación
1. **Requisitos:**
   - Java JDK 8 o superior.
   - Librería Gson (para parsing JSON). Descárgala desde https://mvnrepository.com/artifact/com.google.code.gson/gson y agrégala al classpath.

## Challenge realizado por Fernando Jose Galdamez Mendoza