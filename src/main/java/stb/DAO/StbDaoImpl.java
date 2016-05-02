package stb.DAO;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import stb.model.STB;
import stb.model.StbClient;

public class StbDaoImpl implements StbDAO {
	 private JdbcTemplate jdbcTemplate;
	 String titre ;
	 String version ;
	 String date ;
	 String description ;
	 String nom ;
	 String prenom ;
	 String gen ;
	 int contact ;
	 int num ;
	 String rue;
	 String ville ;
	 int code;
	 
	public StbDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public 	void saveOrUpdate(STB stb){
		// TODO Auto-generated method stub
//		 if (stb.getID() == 1) {
//		        // update
//		        String sql = "UPDATE stbTest SET titre='stbtitre1', version='3.1', date='23-06-2016', "
//		                    + "description='stb de godar' WHERE stb_id=1";
//		        jdbcTemplate.update(sql, stb.getTitre(), stb.getVersion(),
//		                stb.getDate(), stb.getDescription(), stb.getID());
//		    } else {
		        // insert
//			Transformer transformer = TransformerFactory.newInstance().newTransformer();
//			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//	
//			StreamResult result = new StreamResult(new StringWriter());
//			DOMSource source = new DOMSource(stb.getID());
//			transformer.transform(source, result);
//			String xmlString = result.getWriter().toString();
//			System.out.println(xmlString);
					 StbClient client=stb.getClient();
                     titre=stb.getTitre();
                     version=stb.getVersion();
                     date =  stb.getDate();
                     description =  stb.getDescription();
                     nom =  client.getNomClient();
                     prenom =  client.getPrenomClient();
                     gen =  client.getGenderClient();
                     contact =  client.getContactClient();
                     num =  client.getnumRue();
                     rue =  client.getNomRue();
                     ville = client.getNomVille();
                     code =  client.getCode();
                     String sql =  "INSERT INTO stbType (titre, version, date, description, nom_client, " +
		        			  "prenom_client, gender_client,  num_rue, nom_rue, nom_ville, code_postal,contact_client)"
		                    + " VALUES ('"+titre+"','"+version+"','"+date+"','"+description+"','"+nom+"','"+prenom+
		                    "','"+gen+"','"+num+"','"+rue+"','"+ville+"','"+code+"','"+contact+"')";
                     jdbcTemplate.execute(sql); 
                        
               

//		    }
	}
	
	@Override
	public void delete(int stbId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM stbType WHERE stb_id=?";
	    jdbcTemplate.update(sql, stbId);
		
	}

	@Override
	public STB get(int stbId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM stbType WHERE stb_id=" + stbId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<STB>() {
	 
	        @Override
	        public STB extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                STB stb = new STB();
	                stb.setID(rs.getInt("stb_id"));
	                stb.setTitre(rs.getString("titre"));
	                stb.setVersion(rs.getString("version"));
	                stb.setDate(rs.getString("date"));
	                stb.setDescription(rs.getString("description"));
//	                stb.getClient().setNomClient(rs.getString("nom_client"));
//	                stb.getClient().setPrenomClient(rs.getString("prenom_client"));
//	                stb.getClient().setGenderClient(rs.getString("gender_client"));
//	                stb.getClient().setContactClient(rs.getInt("contact_client"));
//	                stb.getClient().setnumRue(rs.getInt("num_rue"));
//	                stb.getClient().setNomRue(rs.getString("nom_rue"));
//	                stb.getClient().setNomVille(rs.getString("nom_ville"));
//	                stb.getClient().setCode(rs.getInt("code_postal"));
	                return stb;
	            }
	            return null;
	        }
	 
	    });
	}
	
	public List<Object> list() {
		String sql = "SELECT * FROM stbType";
	    List<Object> listStb = jdbcTemplate.query(sql, new RowMapper<Object>() {
	        @Override
	        public STB mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	STB stb = new STB();
                stb.setID(rs.getInt("stb_id"));
                stb.setTitre(rs.getString("titre"));
                stb.setVersion(rs.getString("version"));
                stb.setDate(rs.getString("date"));
                stb.setDescription(rs.getString("description"));
//                stb.getClient().setNomClient(rs.getString("nom_client"));
//                stb.getClient().setPrenomClient(rs.getString("prenom_client"));
//                stb.getClient().setGenderClient(rs.getString("gender_client"));
//                stb.getClient().setContactClient(rs.getInt("contact_client"));
//                stb.getClient().setnumRue(rs.getInt("num_rue"));
//                stb.getClient().setNomRue(rs.getString("nom_rue"));
//                stb.getClient().setNomVille(rs.getString("nom_ville"));
//                stb.getClient().setCode(rs.getInt("code_postal"));
                return stb;
	        }
	 
	    });
	    return listStb;
	}
}
