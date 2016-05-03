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
@ComponentScan(basePackages = {"stb"})


public class AppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public DataSource getDataSource() {
		String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        host = "127.0.0.1";
        port = "3306";
        String dbName = "stb";
		String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
		String user = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
		String passwd = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
		user = "root";
		passwd = "";
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword( passwd );
		return dataSource;
	}
	
	@Bean
	public StbDAO getStbDAO() {
		return new StbDaoImpl(getDataSource());
	}
	
	

}

