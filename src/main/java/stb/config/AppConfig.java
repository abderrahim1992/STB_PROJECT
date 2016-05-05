package stb.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import stb.DAO.ClientDAO;
import stb.DAO.StbDAO;
import stb.DAO.StbDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "stb" })

public class AppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public DataSource getDataSource() {
		String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
		// String port = "3306";
		String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
		String dbName = "stb";
		// String url = "\"jdbc:mysql://" + host + ":" + port + "/" + dbName +
		// "\"";
		// String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
		String url = "jdbc:mysql://" + "127.11.194.2" + ":" + "3306" + "/" + "stb";
		String user = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
		String passwd = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername("adminkmwGWnE");
		dataSource.setPassword("7ngTMBxe_ai3");
		return dataSource;
	}

	@Bean
	public StbDAO getStbDAO() {
		return new StbDaoImpl(getDataSource());
	}

}
