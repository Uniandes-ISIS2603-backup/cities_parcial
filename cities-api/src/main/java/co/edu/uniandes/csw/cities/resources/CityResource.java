/*
 * CityResource.java
 * Clase que representa el recurso "/cities"
 * Implementa varios métodos para manipular las ciudades
 */
package co.edu.uniandes.csw.cities.resources;

import co.edu.uniandes.csw.cities.api.ICityLogic;
import co.edu.uniandes.csw.cities.dtos.CityDTO;
import co.edu.uniandes.csw.cities.entities.CityEntity;
import co.edu.uniandes.csw.company.exceptions.BusinessLogicException;
import java.util.ArrayList;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

/**
 * Clase que implementa el recurso REST correspondiente a "cities".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "cities". Al ejecutar la aplicación, el recurse
 * será accesibe a través de la ruta "/api/cities"
 *
 * @author Asistente
 */
@Path("cities")
@Produces("application/json")
public class CityResource {

    @Inject
    ICityLogic cityLogic;

    /**
     * Convierte una lista de CityEntity a una lista de CityDTO.
     *
     * @param entityList Lista de CityEntity a convertir.
     * @return Lista de CityDTO convertida.
     *
     */
    private List<CityDTO> listEntity2DTO(List<CityEntity> entityList) {
        List<CityDTO> list = new ArrayList<>();
        for (CityEntity entity : entityList) {
            list.add(new CityDTO(entity));
        }
        return list;
    }

    /**
     * Obtiene la lista de los registros de City
     *
     * @return Colección de objetos de CityDTO
     *
     */
    @GET
    public List<CityDTO> getCitys() {

        return listEntity2DTO(cityLogic.getCities());
    }

    /**
     * Obtiene los datos de una instancia de City a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CityDTO con los datos del City consultado
     *
     */
    @GET
    @Path("{id: \\d+}")
    public CityDTO getCity(@PathParam("id") Long id) {
        return new CityDTO(cityLogic.getCity(id));
    }

    /**
     * Obtiene los datos de una instancia de City a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CityDTO con los datos del City consultado
     *
     */
    @GET
    @Path("name")
    public CityDTO getCityByName(@QueryParam("name") String name) {
        CityEntity cityE = cityLogic.getCityByName(name);
        if (cityE == null) {
            throw new WebApplicationException("La compañía no existe", 404);
        } else {
            return new CityDTO(cityE);
        }
    }

    /**
     * Se encarga de crear un City en la base de datos
     *
     * @param dto Objeto de CityDTO con los datos nuevos
     * @return Objeto de CityDTOcon los datos nuevos y su ID
     *
     */
    @POST
    public CityDTO createCity(CityDTO dto) throws BusinessLogicException {
        return new CityDTO(cityLogic.createCity(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de City
     *
     * @param id Identificador de la instancia de City a modificar
     * @param dto Instancia de CityDTO con los nuevos datos
     * @return Instancia de CityDTO con los datos actualizados
     *
     */
    @PUT
    @Path("{id: \\d+}")
    public CityDTO updateCity(@PathParam("id") Long id, CityDTO dto) {
        CityEntity entity = dto.toEntity();
        entity.setId(id);
        return new CityDTO(cityLogic.updateCity(entity));
    }

    /**
     * Elimina una instancia de City de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCity(@PathParam("id") Long id) {
        cityLogic.deleteCity(id);
    }

}
