package stb.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import stb.model.STB;
import stb.model.StbCommentaire;
import stb.model.StbEquipe;
import stb.model.StbExigence;
import stb.model.StbFonctionnalites;

public class EquipeDao implements StbDAO {

	private JdbcTemplate jdbcTemplate;
	 
	public EquipeDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(STB stb) {
		// TODO Auto-generated method stub
		
		List<StbEquipe> listEquipe=stb.getListEquipe();
		//select the last stb stocked
        String query = "SELECT max(stb_id) FROM stbType";
		@SuppressWarnings("deprecation")
		int stbId=jdbcTemplate.queryForInt(query);
		
		for (StbEquipe euipe : listEquipe){
			String nom=euipe.getNom();
			String prenom=euipe.getPrenom();
			String gender="masculin";
			String contact=euipe.getContact();
			String sql = "INSERT INTO membreEquipe (nom, prenom, gender,  contact , id_stb)"
	                + " VALUES ('"+nom+"','"+prenom+"','"+gender+"','"+contact+"','"+stbId+"')";
			 jdbcTemplate.execute(sql);
		}
		
	}

	

	@Override
	public StbEquipe get(int stbId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM membreEquipe WHERE id_stb=" + stbId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<StbEquipe>() {
	        @Override
	        public StbEquipe extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	StbEquipe equipe = new StbEquipe();
	            	equipe.setIdMember(rs.getInt("id_membre"));
	            	equipe.setNom(rs.getString("nom"));
	            	equipe.setPrenom(rs.getString("prenom"));
	            	equipe.setGender(rs.getString("gender"));
	            	equipe.setContact(rs.getString("contact"));
	            	
	                return equipe;
	            }
	            return null;
	        }
	 
	    });
	}
	
	public List<StbEquipe> list(int stbId) {
		
		String sql = "SELECT * FROM membreEquipe WHERE id_stb=" + stbId;
	    List<StbEquipe> listEquipe = jdbcTemplate.query(sql, new RowMapper<StbEquipe>() {
	        @Override
	        public StbEquipe mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	StbEquipe equipe = new StbEquipe();
	        	equipe.setNom(rs.getString("nom"));
            	equipe.setPrenom(rs.getString("prenom"));
            	equipe.setGender(rs.getString("gender"));
            	equipe.setContact(rs.getString("contact"));
                return equipe;
	        }
	 
	    });
	    return listEquipe;
	}
}
