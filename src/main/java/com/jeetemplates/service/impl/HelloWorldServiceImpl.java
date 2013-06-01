/**
 * 
 */
package com.jeetemplates.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jeetemplates.business.model.HelloWorld;
import com.jeetemplates.business.persistence.HelloWorldDao;
import com.jeetemplates.service.HelloWorldService;
import com.jeetemplates.service.dto.HelloWorldDTO;
import com.jeetemplates.util.LoggerUtils;
import com.jeetemplates.util.MapperUtils;

/**
 * Implementation of {@link HelloWorldService}
 * 
 * @author jeetemplates
 */
@Named(HelloWorldService.BEAN_NAME)
public class HelloWorldServiceImpl implements HelloWorldService {

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	/**
	 * {@link HelloWorldDao}
	 */
	@Inject
	private HelloWorldDao helloWorldDao;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void create(HelloWorld entity) {
		LoggerUtils.logStartMethod("create");
		helloWorldDao.create(entity);
		LoggerUtils.logEndMethod("create");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<HelloWorldDTO> retrieveAll() {
		LoggerUtils.logStartMethod("retrieveAll");
		List<HelloWorld> listEntities = helloWorldDao.retrieveAll();
		@SuppressWarnings("unchecked")
		List<HelloWorldDTO> returnValue = (List<HelloWorldDTO>) MapperUtils.mapAsList(listEntities, HelloWorldDTO.class);
		LoggerUtils.logEndMethod("retrieveAll");
		return returnValue;
	}

}
