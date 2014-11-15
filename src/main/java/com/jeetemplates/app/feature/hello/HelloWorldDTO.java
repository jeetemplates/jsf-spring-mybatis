/**
 *
 */
package com.jeetemplates.app.feature.hello;

import com.jeetemplates.app.common.GenericDTO;

/**
 * Hello world dto
 *
 * @author jeetemplates
 */
public class HelloWorldDTO extends GenericDTO {

    /**
     * Serial UID.
     */
    private static final long serialVersionUID = -4404486271848958120L;

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
     * @param lastName the lastName to set
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
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
