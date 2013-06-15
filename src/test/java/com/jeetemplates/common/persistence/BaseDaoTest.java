/**
 * 
 */
package com.jeetemplates.common.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.dbunit.DBTestCase;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.hsqldb.HsqldbConnection;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Base class for dao test.
 * 
 * @author jeetemplates
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-spring-global.xml" })
public abstract class BaseDaoTest extends DBTestCase {

	/**
	 * {@link DataSource} : datasource.
	 */
	@Inject
	private DataSource datasource;

	/**
	 * {@link Connection} : connection.
	 */
	private Connection connection;

	/**
	 * {@link IDatabaseConnection} : DBUnit connection.
	 */
	private IDatabaseConnection dbunitConnection;

	/**
	 * Init test.
	 * 
	 * @throws Exception
	 * @throws SQLException
	 */
	@Before
	public void init() throws SQLException, Exception {
		connection = datasource.getConnection();
		dbunitConnection = new HsqldbConnection(connection, null);
		DatabaseOperation.CLEAN_INSERT.execute(dbunitConnection, getDataSet());
	}

	/**
	 * Clean test.
	 * 
	 * @throws SQLException
	 */
	@After
	public void clean() throws SQLException {
		// Close database connection after each method to avoid problem with a
		// lot of tests
		dbunitConnection.close();
		connection.close();
	}

}
