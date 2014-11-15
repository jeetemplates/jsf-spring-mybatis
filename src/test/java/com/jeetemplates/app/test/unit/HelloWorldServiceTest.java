/**
 *
 */
package com.jeetemplates.app.test.unit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.jeetemplates.app.domain.HelloWorld;
import com.jeetemplates.app.persistence.HelloWorldDao;
import com.jeetemplates.app.feature.hello.HelloWorldDTO;
import com.jeetemplates.app.feature.hello.HelloWorldService;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test of {@link HelloWorldService}.
 *
 * @author jeetemplates
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloWorldServiceTest {

    /* ************************************************************** */
    /* Service to test */
    /* ************************************************************** */
    /**
     * {@link HelloWorldService}.
     */
    private HelloWorldService helloWorldService;

    /**
     * Init.
     */
    @Before
    public void init() {
        helloWorldService = new HelloWorldService();
        ReflectionTestUtils.setField(helloWorldService, "helloWorldDao", helloWorldDao);
    }

    /* ************************************************************** */
    /* Mocks */
    /* ************************************************************** */
    /**
     * {@link HelloWorldDao}.
     */
    @Mock
    private HelloWorldDao helloWorldDao;

    /* ************************************************************** */
    /* Methods */
    /* ************************************************************** */
    /**
     * Test of method {@link HelloWorldService#retrieveAll()}.
     */
    @Test
    public void testRetrieveAll() {
        // Mock result
        List<HelloWorld> mockResult = new ArrayList<HelloWorld>();
        HelloWorld mockHello = new HelloWorld();
        mockHello.setFirstName("first name");
        mockHello.setLastName("last name");
        mockResult.add(mockHello);

        // Mock call method
        Mockito.when(helloWorldDao.retrieveAll()).thenReturn(mockResult);

        // Call service
        List<HelloWorldDTO> result = helloWorldService.retrieveAll();

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("first name", result.get(0).getFirstName());
        Assert.assertEquals("last name", result.get(0).getLastName());
    }

}
