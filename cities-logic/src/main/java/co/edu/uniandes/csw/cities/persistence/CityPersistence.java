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
package co.edu.uniandes.csw.cities.persistence;

import co.edu.uniandes.csw.cities.entities.CityEntity;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @generated
 */
@Stateless
public class CityPersistence {

    @PersistenceContext(unitName="cityPU")
    protected EntityManager em;

    public CityEntity find(Long id) {
      
        return em.find(CityEntity.class, id);
    }

    public CityEntity findByName(String name) {
       
        TypedQuery<CityEntity> q
                = em.createQuery("select u from CityEntity u where u.name = :name", CityEntity.class);
        q = q.setParameter("name", name);
        
       List<CityEntity> companiesSimilarName = q.getResultList();
        if (companiesSimilarName.isEmpty() ) {
            return null; 
        } else {
            return companiesSimilarName.get(0);
        }
    }

    public List<CityEntity> findAll() {
       
        Query q = em.createQuery("select u from CityEntity u");
        return q.getResultList();
    }

    public CityEntity create(CityEntity entity) {
      
        em.persist(entity);
        
        return entity;
    }

    public CityEntity update(CityEntity entity) {
       
        return em.merge(entity);
    }

    public void delete(Long id) {
        
        CityEntity entity = em.find(CityEntity.class, id);
        em.remove(entity);
    }

}
