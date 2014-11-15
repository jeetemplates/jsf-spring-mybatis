/**
 *
 */
package com.jeetemplates.app.common;

import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO Interface. CRUD methods.
 *
 * @author jeetemplates
 * @param <ID>
 * @param <BE>
 */
public interface BusinessDao<ID extends Serializable, BE extends BusinessEntity<ID>> {

    /**
     * Create in database
     *
     * @param entity
     * @return entity persisted
     */
    ID create(BE entity);

    /**
     * Retrieve from database by id
     *
     * @param id
     * @return
     */
    BE retrieveById(ID id);

    /**
     * Retrieve all entries from database
     *
     * @return
     */
    List<BE> retrieveAll();

    /**
     * Update entity in database
     *
     * @param entity : entity to update
     * @return persisted entity
     */
    BE update(BE entity);

    /**
     * Delete from database by id
     *
     * @param id : entity's id to delete
     */
    void deleteById(ID id);

}
