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
import stb.model.StbExigence;
import stb.model.StbFonctionnalites;

public class FonctionnalitesDao implements StbDAO {
	
	private JdbcTemplate jdbcTemplate;
	 
	public FonctionnalitesDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Object stb) {
		// TODO Auto-generated method stub
		
		StbFonctionnalites fct=((STB) stb).getFonctionnalites();
		String description=fct.getDescription();
		int priorite=fct.getPriorite();
		String sql = "INSERT INTO fonctionnalites (description, priorite, id_stb)"
                + " VALUES ('"+description+"','"+priorite+"',1)";
		 jdbcTemplate.execute(sql);
	}
	@Override
	public void delete(int fctId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM fonctionnalites WHERE id_fonctionnalite=?";
	    jdbcTemplate.update(sql, fctId);
		
	}
	@Override
	public StbFonctionnalites get(int fctId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM fonctionnalites WHERE id_fonctionnalite=" + fctId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<StbFonctionnalites>() {
	        @Override
	        public StbFonctionnalites extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	StbFonctionnalites fonctionnalite = new StbFonctionnalites();
	            	fonctionnalite.setIdFonctionnalite(rs.getInt("id_fonctionnalite"));
	            	fonctionnalite.setDescription(rs.getString("description"));
	            	fonctionnalite.setPriorite(rs.getInt("priorite"));
	            	fonctionnalite.setIdStb(rs.getInt("id_stb"));
	                return fonctionnalite;
	            }
	            return null;
	        }
	 
	    });
	}

	public List<Object> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM fonctionnalites";
		List<Object> listFonctionnalites= jdbcTemplate.query(sql, new RowMapper<Object>() {
			 
		        @Override
		        public StbFonctionnalites mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	StbFonctionnalites fct = new StbFonctionnalites();
		        	fct.setIdFonctionnalite(rs.getInt("id_fonctionnalite"));
		        	fct.setDescription(rs.getString("description"));
		        	fct.setPriorite(rs.getInt("priorite"));
		        	fct.setIdStb(rs.getInt("id_stb"));
		        	
	                return fct;
		        }
		 
		    });
		 
		    return listFonctionnalites;
	}

}
