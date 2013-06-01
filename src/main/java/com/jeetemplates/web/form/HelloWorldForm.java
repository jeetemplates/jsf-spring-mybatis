/**
 * 
 */
package com.jeetemplates.web.form;

import javax.faces.bean.ManagedBean;

/**
 * Hello world form
 * 
 * @author jeetemplates
 */
@ManagedBean
public class HelloWorldForm {

	/**
	 * Name of el property.
	 */
	public static final String EL_NAME = "#{helloWorldForm}";

	/**
	 * Last name.
	 */
	private String lastName;

	/**
	 * First name.
	 */
	private String firstName;

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
