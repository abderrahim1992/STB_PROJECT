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
import stb.model.StbEquipe;
import stb.model.StbExigence;

public class ExigenceDao implements StbDAO {
	
	private JdbcTemplate jdbcTemplate;
	 
	public ExigenceDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Object stb) {
		// TODO Auto-generated method stub
		StbExigence exg=((STB) stb).getExigence();
		String description=exg.getDescription();
		int priorite=exg.getPriorite();
		int idFctnl=exg.getIdFonctionnalite();
		String sql = "INSERT INTO exigences (description, priorite, id_fonctionalite)"
                + " VALUES ('"+description+"','"+priorite+"','"+1+"')";
		 jdbcTemplate.execute(sql);
	}

	@Override
	public void delete(int exigenceId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM exigences WHERE exigenceId=?";
	    jdbcTemplate.update(sql, exigenceId);
	}

	@Override
	public StbExigence get(int exgId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM exigences WHERE exigenceId=" + exgId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<StbExigence>() {
	        @Override
	        public StbExigence extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	StbExigence exigence = new StbExigence();
	            	exigence.setIdExigence(rs.getInt("exgId"));
	            	exigence.setDescription(rs.getString("description"));
	            	exigence.setPriorite(rs.getInt("priorite"));
	            	exigence.setIdFonctionnalite(rs.getInt("id_fonctionalite"));
	            	
	                return exigence;
	            }
	            return null;
	        }
	 
	    });
	}
	
	public List<Object> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM exigences";
		List<Object> listExigence = jdbcTemplate.query(sql, new RowMapper<Object>() {
			 
		        @Override
		        public StbExigence mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	StbExigence exg = new StbExigence();
		        	exg.setIdExigence(rs.getInt("exgId"));
		        	exg.setDescription(rs.getString("description"));
		        	exg.setPriorite(rs.getInt("priorite"));
		        	exg.setIdFonctionnalite(rs.getInt("id_fonctionalite"));
	            	
	                return exg;
		        }
		 
		    });
		 
		    return listExigence;
		}
	
}
