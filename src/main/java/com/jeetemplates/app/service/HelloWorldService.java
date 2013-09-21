/**
 * 
 */
package com.jeetemplates.app.service;

import java.util.List;

import com.jeetemplates.app.domain.HelloWorld;
import com.jeetemplates.app.service.dto.HelloWorldDTO;

/**
 * Hello world service
 * 
 * @author jeetemplates
 */
public interface HelloWorldService {

	/**
	 * Bean name.
	 */
	static String BEAN_NAME = "helloWorldService";

	/**
	 * El name.
	 */
	static String EL_NAME = "#{helloWorldService}";

	/**
	 * Create an entity hello world
	 * 
	 * @param entity
	 *            : entity to create
	 */
	void create(HelloWorld entity);

	/**
	 * Retrieve hello world.
	 * 
	 * @return
	 */
	List<HelloWorldDTO> retrieveAll();

}
