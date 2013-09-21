/**
 * 
 */
package com.jeetemplates.app.common.domain;

import java.io.Serializable;

/**
 * Business Entity
 * 
 * @author jeetemplates
 */
public abstract class BusinessEntity implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id.
	 */
	private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
