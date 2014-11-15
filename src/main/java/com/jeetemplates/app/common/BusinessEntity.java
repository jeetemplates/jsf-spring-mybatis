/**
 *
 */
package com.jeetemplates.app.common;

import java.io.Serializable;

/**
 * Business Entity
 *
 * @author jeetemplates
 * @param <ID>
 */
public abstract class BusinessEntity<ID extends Serializable> implements Serializable {

    /**
     * Serial UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id.
     */
    private ID id;

    /**
     * @return the id
     */
    public ID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ID id) {
        this.id = id;
    }

}
