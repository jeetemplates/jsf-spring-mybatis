/**
 * 
 */
package com.jeetemplates.app.util;

import java.util.List;

import ma.glasnost.orika.MapperFacade;

import com.jeetemplates.app.mapper.OrikaMapper;

/**
 * Utils for Mapping between objects.
 * 
 * @author jeetemplates
 */
public final class MapperUtils {

	/* ************************************************************** */
	/* Dependencies */
	/* ************************************************************** */

	/**
	 * Mapper.
	 */
	private static MapperFacade orikaMapper;

	/**
	 * @return the Orika Mapper
	 */
	private static MapperFacade getOrikaMapper() {
		if (orikaMapper == null) {
			orikaMapper = new OrikaMapper();
		}
		return orikaMapper;
	}

	/**
	 * Convert a collection to a list.
	 * 
	 * @param source
	 *            : collection source
	 * @param destinationClass
	 *            : destination entity class in list
	 * @return list of destination class
	 */
	public static List<?> mapAsList(Iterable<?> source,
			Class<?> destinationClass) {
		return getOrikaMapper().mapAsList(source, destinationClass);
	}

	/**
	 * Map the source into a new object of destination class type.
	 * 
	 * @param source
	 *            : source object
	 * @param destinationClass
	 *            : type of the new object
	 * @return new object
	 */
	public static Object map(Object source, Class<?> destinationClass) {
		return getOrikaMapper().map(source, destinationClass);
	}

}
