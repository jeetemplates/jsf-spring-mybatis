/**
 * 
 */
package com.jeetemplates.web.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.jeetemplates.business.model.HelloWorld;
import com.jeetemplates.service.HelloWorldService;
import com.jeetemplates.service.dto.HelloWorldDTO;
import com.jeetemplates.util.LoggerUtils;
import com.jeetemplates.util.MapperUtils;
import com.jeetemplates.web.form.HelloWorldForm;

/**
 * Welcome controller.
 * 
 * @author jeetemplates
 */
@ManagedBean
public class WelcomeController {

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	/**
	 * {@link HelloWorldService}
	 */
	@ManagedProperty(value = HelloWorldService.EL_NAME)
	private HelloWorldService helloWorldService;

	/**
	 * {@link HelloWorldService}
	 */
	@ManagedProperty(value = HelloWorldForm.EL_NAME)
	private HelloWorldForm helloWorldForm;

	/* ************************************ */
	/* Attributes */
	/* ************************************ */

	/**
	 * List of hellos
	 */
	private List<HelloWorldDTO> listHellos;

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	public String createHello() {
		helloWorldService.create((HelloWorld) MapperUtils.map(helloWorldForm, HelloWorld.class));
		return "welcome?faces-redirect=true";
	}

	/**
	 * Retrieve hello dto
	 * 
	 * @return list of hello dto
	 */
	public List<HelloWorldDTO> retrieveList() {
		// Prevent multiple calls from JSF
		if (listHellos == null) {
			LoggerUtils.logDebug("Initialize hello world list for display");
			listHellos = helloWorldService.retrieveAll();
		}
		return listHellos;
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	public void setHelloWorldForm(HelloWorldForm helloWorldForm) {
		this.helloWorldForm = helloWorldForm;
	}

	public HelloWorldService getHelloWorldService() {
		return helloWorldService;
	}

	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

}
