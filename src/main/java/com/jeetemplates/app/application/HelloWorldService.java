/**
 *
 */
package com.jeetemplates.app.application;

import com.jeetemplates.app.domain.HelloWorldRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jeetemplates.app.domain.HelloWorld;
import java.util.stream.Collectors;

/**
 * Implementation of {@link HelloWorldService}
 *
 * @author jeetemplates
 */
@Service(HelloWorldService.BEAN_NAME)
public class HelloWorldService {

    /**
     * Bean name.
     */
    public static final String BEAN_NAME = "helloWorldService";

    /**
     * El name.
     */
    public static final String EL_NAME = "#{helloWorldService}";

    /* ************************************ */
    /* Dependencies */
    /* ************************************ */
    /**
     * {@link HelloWorldRepository}
     */
    @Autowired
    private HelloWorldRepository helloWorldRepository;

    /* ************************************ */
    /* Methods */
    /* ************************************ */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void create(HelloWorld entity) {
        helloWorldRepository.create(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<HelloWorldDTO> retrieveAll() {
        List<HelloWorld> entities = helloWorldRepository.retrieveAll();
        return entities.stream().map((HelloWorld entity) -> {
            HelloWorldDTO dto = new HelloWorldDTO();
            dto.setFirstName(entity.getFirstName());
            dto.setLastName(entity.getLastName());
            return dto;
        }).collect(Collectors.toList());
    }

}
