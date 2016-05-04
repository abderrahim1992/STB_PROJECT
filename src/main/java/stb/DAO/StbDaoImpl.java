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
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import stb.model.STB;
import stb.model.StbClient;
import stb.model.StbCommentaire;
import stb.model.StbEquipe;
import stb.model.StbFonctionnalites;

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
	 StbClient client;
	 StbFonctionnalites fonctionnalite;
	 List<StbEquipe> equipe;
	 StbCommentaire comment;
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
                     titre= stb.getTitre();
                     version= stb.getVersion();
                     date =   stb.getDate();
                     description =  stb.getDescription();
                     String sql =  "INSERT INTO stbType (titre, version, date, description)"
		                    + "VALUES ('"+titre+"','"+version+"','"+date+"','"+description+"')";
                     jdbcTemplate.execute(sql); 
                        
               

//		    }
	}
	
	@Override
	public STB get(int stbId) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM stbType WHERE stb_id=" + stbId;
		client = new ClientDAO(getDataSource()).get(stbId);
		equipe = new EquipeDao(getDataSource()).list(stbId);
		fonctionnalite=new FonctionnalitesDao(getDataSource()).get(stbId);
		comment=new CommentaireDao(getDataSource()).get(stbId);
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
	                stb.setClient(client);
	                stb.setListEquipe(equipe);
	                stb.setFonctionnalite(fonctionnalite);
	                stb.setCommentaire(comment);
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
                return stb;
	        }
	 
	    });
	    return listStb;
	}
	
	public int getMaxStbId() {
		String query = "SELECT max(stb_id) FROM stbType";
		@SuppressWarnings("deprecation")
		int id = jdbcTemplate.queryForInt(query);
	    return id;
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
