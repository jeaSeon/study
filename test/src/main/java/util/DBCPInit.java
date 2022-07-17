package util;


import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


public class DBCPInit extends HttpServlet {
	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
		initConnectionPool();
	}

	private void initConnectionPool() {
		try {
		String url="jdbc:mariadb://localhost:3306/chap14";
		String user="jspur";
		String pass="qwe1234";
		ConnectionFactory connFactory=new DriverManagerConnectionFactory(url, user, pass);
		PoolableConnectionFactory poolableConnFactory=new PoolableConnectionFactory(connFactory, null);
		poolableConnFactory.setValidationQuery("select 1");
		GenericObjectPoolConfig poolConfig=new GenericObjectPoolConfig();
		poolConfig.setTimeBetweenEvictionRunsMillis(1000L*60L*5L);
		poolConfig.setTestWhileIdle(true);
		poolConfig.setMinIdle(4);
		poolConfig.setMaxTotal(50);
		
		GenericObjectPool<PoolableConnection> connectionPool=new GenericObjectPool<>(poolableConnFactory,poolConfig);
		poolableConnFactory.setPool(connectionPool);
		
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
				//풀링 드라이버 찾는거.
			PoolingDriver driver=(PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
				//아팟치 찾는거..
			driver.registerPool("chap14", connectionPool);
				//풀 생성, 
			System.out.println("====>폴링 드라이버 로딩");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	//드라이버 찾는거.
	private void loadJDBCDriver() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("====>드라이버 로딩");
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("Fail to load JDBC Driver,ex");
			
		}
		
	}
   
}
