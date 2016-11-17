/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.cities.ejbs;

import co.edu.uniandes.csw.cities.api.ICityLogic;
import co.edu.uniandes.csw.cities.entities.CityEntity;
import co.edu.uniandes.csw.cities.persistence.CityPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

@Stateless
public class CityLogic implements ICityLogic {

    @Inject
    private CityPersistence persistence;

    /**
     * Obtiene la lista de los registros de City.
     *
     * @return Colección de objetos de CityEntity.
     * @generated
     */
    @Override
    public List<CityEntity> getCities() {
        return persistence.findAll();
    }

    /**
     * Obtiene los datos de una instancia de City a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CityEntity con los datos del City consultado.
     * @generated
     */
    @Override
    public CityEntity getCity(Long id) {
        return persistence.find(id);
    }

    /**
     * Se encarga de crear un City en la base de datos.
     *
     * @param entity Objeto de CityEntity con los datos nuevos
     * @return Objeto de CityEntity con los datos nuevos y su ID.
     * @generated
     */
    @Override
    public CityEntity createCity(CityEntity entity) {
        persistence.create(entity);
        return entity;
    }

    /**
     * Actualiza la información de una instancia de City.
     *
     * @param entity Instancia de CityEntity con los nuevos datos.
     * @return Instancia de CityEntity con los datos actualizados.
     * @generated
     */
    @Override
    public CityEntity updateCity(CityEntity entity) {
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de City de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    @Override
    public void deleteCity(Long id) {
        persistence.delete(id);
    }

    @Override
    public CityEntity getCityByName(String name) {
   
        return persistence.findByName(name);
    }

}
