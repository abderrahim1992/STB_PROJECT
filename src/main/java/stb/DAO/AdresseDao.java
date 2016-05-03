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
import org.xml.sax.SAXException;

import stb.model.Adresse;
import stb.model.STB;
import stb.model.StbClient;
import stb.model.StbExigence;
import stb.model.StbFonctionnalites;

public class AdresseDao implements StbDAO{
	
	private JdbcTemplate jdbcTemplate;
	 
	public AdresseDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public void saveOrUpdate(STB stb) throws FileNotFoundException,
			ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		// TODO Auto-generated method stub
				StbClient client=stb.getClient();
				Adresse adr= client.getAdresse();
				int numRue=adr.getnumRue();
				String nomRue=adr.getNomRue();
				String ville=adr.getNomVille();
				int code=adr.getCode();
				
				//select the last stb stocked
		        String query = "SELECT max(stb_id) FROM stbType";
				@SuppressWarnings("deprecation")
				int stbId=jdbcTemplate.queryForInt(query);
				
				String query2 = "SELECT max(id_client) FROM client WHERE id_stb='"+stbId+"'";
				int clienttId=jdbcTemplate.queryForInt(query2);
				
				String sql = "INSERT INTO exigences (numRue, nomRue, nomVille, code, id_client, id_stb)"
		                + " VALUES ('"+numRue+"','"+nomRue+"','"+ville+"','"+code+"','"+clienttId+"','"+stbId+"')";
				 jdbcTemplate.execute(sql);
		
		
		
	}

	

	@Override
	public Object get(int stbID) {
		// TODO Auto-generated method stub
		String query = "SELECT id_client FROM client WHERE id_stb=" + stbID;
		@SuppressWarnings("deprecation")
		int clientId=jdbcTemplate.queryForInt(query);
		String sql = "SELECT * FROM adresse WHERE id_stb=" + clientId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Adresse>() {
	        @Override
	        public Adresse extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Adresse adresse = new Adresse();
	            	adresse.setnumRue(rs.getInt("numRue"));
	            	adresse.setNomRue(rs.getString("nomRue"));
	            	adresse.setNomVille(rs.getString("nomVille"));
	            	
	                return adresse;
	            }
	            return null;
	        }
	 
	    });

		
	}
}
