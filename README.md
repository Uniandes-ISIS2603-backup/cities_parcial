# cities_parcial

Instrucciones:

1. Importe la colección  de request postman que se encuentra en la raiz de la aplicación. 
2. Ejecute los  POST:
a. POST http://localhost:8080/cities-api/api/cities con Body:   
{
    "id": 1,
    "name": "Bogota"
  }
b. POST http://localhost:8080/cities-api/api/cities con Body:   
{
    "id": 2,
    "name": "Medellin"
  }
  
3. En CityResource modifique el método de actualización de una ciudad para que verifique que:
a. el id del dto que viene de parámetro sea igual al del path , si no es igual debe disparar una exception WebApplicationException
b. que la ciudad con el id del path si existe.

4. En CityLogic modifique el método de actualización de una ciudad para que verifique que:
a. el nuevo valor del nombre no corresponde con el de una ciudad que ya existe
b. si ya existe debe disparar BusinessLogicException
c. modifique CityResource para declarar la exception

5. Pruebe con:
a.  PUT http://localhost:8080/cities-api/api/cities/1 con Body:   
{
    "id": 1,
    "name": "Cali"
  }
 b.  PUT http://localhost:8080/cities-api/api/cities/1 con Body:   
{
    "id": 3,
    "name": "Cali"
  }
  
   b.  PUT http://localhost:8080/cities-api/api/cities/2 con Body:   
{
    "id": 2,
    "name": "Cali"
  }
