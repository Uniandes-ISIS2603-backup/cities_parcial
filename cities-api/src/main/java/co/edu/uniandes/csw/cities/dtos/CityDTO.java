/*
 * CityDTO
 * Objeto de transferencia de datos de Ciudades.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 */
package co.edu.uniandes.csw.cities.dtos;

import co.edu.uniandes.csw.cities.entities.CityEntity;

/**
 * Objeto de transferencia de datos de Ciudades.
 *
 * @author Asistente
 */
public class CityDTO {

    private Long id;
    private String name;

    /**
     * Constructor por defecto
     */
    public CityDTO() {

    }

    public CityDTO(CityEntity entity) {
        if (entity != null) {
            this.name = entity.getName();
            this.id = entity.getId();
        }
    }

    /**
     * Convierte un objeto CityDTO a CityEntity.
     *
     * @return Nueva objeto CityEntity.
     *
     */
    public CityEntity toEntity() {
        CityEntity entity = new CityEntity();
        entity.setName(this.getName());
        entity.setId(this.getId());
        return entity;
    }

    /**
     * Constructor con parámetros.
     *
     * @param id identificador de la ciudad
     * @param name nombre de la ciudad
     */
    public CityDTO(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
        return "{ id : " + getId() + ", name : \"" + getName() + "\" }";
    }
}
