/**
 * 
 */
package com.jeetemplates.web.controller;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Header controller
 * 
 * @author jeetemplates
 */
@ManagedBean
@SessionScoped
public class HeaderController {

	/* ************************************ */
	/* Dependencies */
	/* ************************************ */

	/* ************************************ */
	/* Attributes */
	/* ************************************ */

	/**
	 * Locale.
	 */
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

	/* ************************************ */
	/* Methods */
	/* ************************************ */

	/**
	 * Set language.
	 * 
	 * @param language
	 *            : new language
	 */
	public void setLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	/* ************************************ */
	/* Getters & Setters */
	/* ************************************ */

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
