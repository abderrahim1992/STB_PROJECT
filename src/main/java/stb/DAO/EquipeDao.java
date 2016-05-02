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

public class EquipeDao implements StbDAO {

	private JdbcTemplate jdbcTemplate;
	 
	public EquipeDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Object stb) {
		// TODO Auto-generated method stub
		
		StbEquipe mbr=((STB) stb).getEquipe();
		
		String nom=mbr.getNom();
		String prenom=mbr.getPrenom();
		String gender=mbr.getGender();
		String sql = "INSERT INTO membreEquipe (nom, prenom, gender, id_stb)"
                + " VALUES ('"+nom+"','"+prenom+"','"+gender+"',1)";
		 jdbcTemplate.execute(sql);
	}

	@Override
	public void delete(int equipeId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM membreEquipe WHERE id_membre=?";
	    jdbcTemplate.update(sql, equipeId);
	}

	@Override
	public StbEquipe get(int membrId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM membreEquipe WHERE id_membre=" + membrId;
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
	            	equipe.setIdStb(rs.getInt("id_stb"));
	                return equipe;
	            }
	            return null;
	        }
	 
	    });
	}

	
	public List<Object> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM membreEquipe";
		List<Object> listEquip = jdbcTemplate.query(sql, new RowMapper<Object>() {
			 
		        @Override
		        public StbEquipe mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	StbEquipe eqp = new StbEquipe();
		        	eqp.setIdMember(rs.getInt("id_membre"));
		        	eqp.setNom(rs.getString("nom"));
		        	eqp.setPrenom(rs.getString("prenom"));
		        	eqp.setGender(rs.getString("gender"));
		        	eqp.setIdStb(rs.getInt("id_stb"));		            
		        	
		        	return eqp;
		        }
		 
		    });
		 
		    return listEquip;
		}
}
