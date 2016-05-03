package stb.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.xml.sax.SAXException;

import stb.model.Adresse;
import stb.model.STB;
import stb.model.StbClient;

public class ClientDAO implements StbDAO {
	
	private JdbcTemplate jdbcTemplate;
	Adresse adresse ;

	public ClientDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public ClientDAO(){
		
	}
	@Override
	public void saveOrUpdate(STB stb) throws FileNotFoundException, ParserConfigurationException, SAXException,
			IOException, XPathExpressionException {
		// TODO Auto-generated method stub
		StbClient client = stb.getClient();
        String nom =  client.getNomClient();
        String prenom =  client.getPrenomClient();
        String gender =  client.getGenderClient();
        int contact =  client.getContactClient(); 
        
        //select the last stb stocked
        String query = "SELECT max(stb_id) FROM stbType";
		@SuppressWarnings("deprecation")
		int stbId=jdbcTemplate.queryForInt(query);
        
        String sql =  "INSERT INTO client (nom, prenom, gender, contact, id_stb)"
              + " VALUES ('"+nom+"','"+prenom+"','"+gender+"','"+contact+"','"+stbId+"')";
        jdbcTemplate.execute(sql); 
		
	}

	

	@Override
	public StbClient get(int stbID) {
		// TODO Auto-generated method stub
				String sql = "SELECT * FROM client WHERE id_stb=" + stbID;
				adresse = (Adresse) new AdresseDao(getDataSource()).get(stbID);
			    return jdbcTemplate.query(sql, new ResultSetExtractor<StbClient>() {
			        @Override
			        public StbClient extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			            if (rs.next()) {
			                StbClient client = new StbClient();
			                client.setNomClient(rs.getString("nom"));
			                client.setPrenomClient(rs.getString("prenom"));
			                client.setGenderClient(rs.getString("gender"));
			                client.setContactClient(rs.getInt("contact"));
			                client.setAdresse(adresse);
			                return client;
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
		passwd = "";
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword( passwd );
		return dataSource;
	}
}
