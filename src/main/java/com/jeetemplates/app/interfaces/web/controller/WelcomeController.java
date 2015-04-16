/**
 *
 */
package com.jeetemplates.app.interfaces.web.controller;

import java.util.List;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.jeetemplates.app.domain.HelloWorld;
import com.jeetemplates.app.application.HelloWorldDTO;
import com.jeetemplates.app.application.HelloWorldService;
import com.jeetemplates.app.interfaces.web.form.HelloWorldForm;

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
        HelloWorld entity = new HelloWorld();
        entity.setFirstName(helloWorldForm.getFirstName());
        entity.setLastName(helloWorldForm.getLastName());
        helloWorldService.create(entity);
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
            listHellos = helloWorldService.retrieveAll();
        }
        return listHellos;
    }

    /**
     * Throw {@link FacesException}.
     *
     * @return outcome "welcome"
     */
    public String throwException() {
        throw new FacesException();
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
