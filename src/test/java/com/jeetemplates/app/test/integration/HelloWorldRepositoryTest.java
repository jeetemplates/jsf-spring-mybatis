/**
 *
 */
package com.jeetemplates.app.test.integration;

import com.jeetemplates.app.domain.HelloWorldRepository;
import java.io.FileInputStream;
import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeetemplates.app.common.BaseRepositoryTest;
import com.jeetemplates.app.domain.HelloWorld;

/**
 * Test of {@link HelloWorldRepository}.
 *
 * @author jeetemplates
 */
public class HelloWorldRepositoryTest extends BaseRepositoryTest {

    /**
     * {@link HelloWorldRepository}.
     */
    @Autowired
    private HelloWorldRepository helloWorldDao;

    /**
     * @return @throws java.lang.Exception
     * @see org.dbunit.DatabaseTestCase#getDataSet()
     */
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dataset/dataset.xml"));
    }

    @Test
    public void testRetrieveAll() {
        List<HelloWorld> results = helloWorldDao.retrieveAll();
        Assert.assertNotNull(results);
        Assert.assertEquals(2, results.size());
    }

}
