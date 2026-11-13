# Documentación de Ejecución - Proyecto Hibernate (Pokédex)

Este documento detalla paso a paso el flujo de ejecución del método `main`, mostrando las llamadas realizadas, la lógica interna de los servicios y los resultados obtenidos por consola.

## Índice
1. [Inserción de datos iniciales (Create)](#1-inserción-de-datos-iniciales-create)
    - [1.1. Insertar 10 Pokémon en la Pokédex](#11-insertar-10-pokémon-en-la-pokédex)
    - [1.2. Insertar 2 Adiestradores](#12-insertar-2-adiestradores)
    - [1.3. Insertar 12 Pokémon asociados a Adiestradores](#13-insertar-12-pokémon-asociados-a-adiestradores)
2. [Primer listado de datos (Read)](#2-primer-listado-de-datos-read)
    - [2.1. Listar Pokédex](#21-listar-pokédex)
    - [2.2. Listar Adiestradores](#22-listar-adiestradores)
    - [2.3. Listar Pokémon](#23-listar-pokémon)
3. [Exportación y Serialización](#3-exportación-y-serialización)
    - [3.1. Serializar entradas de la Pokédex](#31-serializar-entradas-de-la-pokédex)
    - [3.2. Exportar Adiestradores a XML](#32-exportar-adiestradores-a-xml)
4. [Modificación de registros (Update)](#4-modificación-de-registros-update)
    - [4.1. Modificar entradas de la Pokédex](#41-modificar-entradas-de-la-pokédex)
    - [4.2. Modificar Adiestradores](#42-modificar-adiestradores)
    - [4.3. Modificar Pokémon](#43-modificar-pokémon)
5. [Segundo listado tras modificaciones (Read)](#5-segundo-listado-tras-modificaciones-read)
6. [Importación y Restauración desde archivos](#6-importación-y-restauración-desde-archivos)
    - [6.1. Deserializar y restaurar Pokédex](#61-deserializar-y-restaurar-pokédex)
    - [6.2. Importar y restaurar Adiestradores desde XML](#62-importar-y-restaurar-adiestradores-desde-xml)
7. [Listado final tras restauración (Read)](#7-listado-final-tras-restauración-read)
8. [Eliminación de todos los datos (Delete)](#8-eliminación-de-todos-los-datos-delete)

---

## 1. Inserción de datos iniciales (Create)

### 1.1. Insertar 10 Pokémon en la Pokédex
* **Código en `main`:**
  ![Main Insertar Pokedex](images/1.png)
* **Método ejecutado (`PokedexService.create`):**
   de la clase Pokedex)*
* ![31.png](images/31.png)

### 1.2. Insertar 2 Adiestradores
* **Código en `main`:**
  ![Main Insertar Adestradores](images/4.png)
* **Método ejecutado (`AdestradorService.create`):**
  ![Metodo Create Adestrador](images/5.png)


### 1.3. Insertar 12 Pokémon asociados a Adiestradores
* **Código en `main`:**
  ![Main Insertar Pokemons](images/8.png)
* **Método ejecutado (`PokemonService.create`):**
  ![Metodo Create Pokemon](images/2.png)

---

## 2. Primer listado de datos (Read)

### 2.1. Listar Pokédex
* **Código en `main`:**

  ![Main Listar Pokedex](images/11.png)
* **Método ejecutado (`PokedexService.read`):**
  ![32.png](images/32.png)
* **Resultado por terminal:**
  ![33.png](images/33.png)

### 2.2. Listar Adiestradores
* **Código en `main`:**
  ![Main Listar Adestradores](images/13.png)
* **Método ejecutado (`AdestradorService.read`):**
  ![34.png](images/34.png)
* **Resultado por terminal:**

  ![34.png](images/6.png)

### 2.3. Listar Pokémon
* **Código en `main`:**

  ![Main Listar Pokemons](images/14.png)
* **Método ejecutado (`PokemonService.read`):**
  ![Metodo Read Pokemon](images/12.png)
* **Resultado por terminal:**
  ![Metodo Read Pokemon](images/3.png)

---

## 3. Exportación y Serialización

### 3.1. Serializar entradas de la Pokédex
* **Código en `main`:**

  ![Main Serializar Pokedex](images/15.png)
* **Método ejecutado (`PokedexService.serializar`):**
  ![35.png](images/35.png)
* **Resultado por terminal / Archivo generado:**
  
  ![36.png](images/36.png)

### 3.2. Exportar Adiestradores a XML
* **Código en `main`:**

  ![Main Exportar XML](images/16.png)
* **Método ejecutado (`AdestradorService.toXML`):**
  ![37.png](images/37.png)
* **Resultado por terminal / Archivo XML generado:**
  
  ![38.png](images/38.png)

---

## 4. Modificación de registros (Update)

### 4.1. Modificar entradas de la Pokédex
* **Código en `main`:**
  ![Main Update Pokedex](images/17.png)
* **Método ejecutado (`PokedexService.update`):**
  ![38.png](images/38.png)
* **Resultado por terminal:**
  > *(⚠️ Falta captura de la consola)*

### 4.2. Modificar Adiestradores
* **Código en `main`:**
  ![Main Update Adestradores](images/18.png)
* **Método ejecutado (`AdestradorService.update`):**
  
![39.png](images/39.png)


### 4.3. Modificar Pokémon
* **Código en `main`:**
  ![Main Update Pokemons](images/19.png)
* **Método ejecutado (`PokemonService.update`):**
  
![40.png](images/40.png)


---

## 5. Segundo listado tras modificaciones (Read)
* **Código en `main`:**

  ![Main Segundo Read Pokedex](images/20.png)

  ![Main Segundo Read Adestradores](images/21.png)

  ![Main Segundo Read Pokemons](images/22.png)
* **Métodos ejecutados:** *(Ya mostrados en el apartado 2).*
* **Resultado por terminal:**
  ![41.png](images/41.png)

---

## 6. Importación y Restauración desde archivos

### 6.1. Deserializar y restaurar Pokédex
* **Código en `main`:**

  ![Main Deserializar Pokedex](images/23.png)

  ![Main Restaurar Serializados](images/24.png)
* **Métodos ejecutados (`deserializar` y `restaurarSerializados`):**
  ![42.png](images/42.png)
![43.png](images/43.png)


### 6.2. Importar y restaurar Adiestradores desde XML
* **Código en `main`:**

  ![Main Importar XML](images/25.png)

  ![Main Restaurar XML](images/26.png)
* **Métodos ejecutados (`importarXML` y `restaurarXML`):**
    ![44.png](images/44.png)
    ![45.png](images/45.png)

---

## 7. Listado final tras restauración (Read)
* **Código en `main`:**

  ![Main Tercer Read](images/27.png)
* **Resultado por terminal:**
    ![41.png](images/41.png)  

---

## 8. Eliminación de todos los datos (Delete)
* **Código en `main`:**

  ![Main Delete](images/28.png)
* **Métodos ejecutados (`delete` en los 3 servicios):**
  
![46.png](images/46.png)
![47.png](images/47.png)
![48.png](images/48.png)
* **Resultado por terminal:**
* 
  ![49.png](images/49.png)