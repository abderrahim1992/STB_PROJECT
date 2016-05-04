package stb.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import stb.model.Adresse;
import stb.model.STB;
import stb.model.StbExigence;
import stb.model.StbFonctionnalites;

public class FonctionnalitesDao implements StbDAO {
	
	private JdbcTemplate jdbcTemplate;
	List<StbExigence> exigence;
	 
	public FonctionnalitesDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(STB stb) {
		// TODO Auto-generated method stub
		
		StbFonctionnalites fct= stb.getFonctionnalites();
		String descriptionFonctionnalite=fct.getDescription();
		int prioriteFonctionnalite=fct.getPriorite();
		
		//select the last stb stocked
        String query = "SELECT max(stb_id) FROM stbType";
		@SuppressWarnings("deprecation")
		int stbId=jdbcTemplate.queryForInt(query);
		String sql = "INSERT INTO fonctionnalites (description, priorite, id_stb) VALUES ('"+descriptionFonctionnalite+"','"+prioriteFonctionnalite+"','"+stbId+"')";
		
		jdbcTemplate.execute(sql);
	}
	
	@Override
	public StbFonctionnalites get(int stbId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM fonctionnalites WHERE id_stb=" + stbId;
		exigence = new ExigenceDao(getDataSource()).list(stbId);
		return jdbcTemplate.query(sql, new ResultSetExtractor<StbFonctionnalites>() {
	        @Override
	        public StbFonctionnalites extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	StbFonctionnalites fonctionnalite = new StbFonctionnalites();
	            	fonctionnalite.setIdFonctionnalite(rs.getInt("id_fonctionnalite"));
	            	fonctionnalite.setDescription(rs.getString("description"));
	            	fonctionnalite.setPriorite(rs.getInt("priorite"));
	            	//fonctionnalite.setExigenceList(exigence);
	            	fonctionnalite.setIdStb(rs.getInt("id_stb"));
	                return fonctionnalite;
	            }
	            return null;
	        }
	 
	    });
	}

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
		passwd = "root";
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword( passwd );
		return dataSource;
	}

}
