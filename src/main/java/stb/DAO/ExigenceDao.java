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
import stb.model.StbFonctionnalites;

public class ExigenceDao implements StbDAO {
	
	private JdbcTemplate jdbcTemplate;
	 
	public ExigenceDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(STB stb) {
		// TODO Auto-generated method stub
		StbFonctionnalites fct=stb.getFonctionnalites();
		List<StbExigence> exigences= fct.getListExigence();
		System.out.println("***********" + exigences + "***********");		
		//select the last stb stocked
        String query = "SELECT max(stb_id) FROM stbType";
		@SuppressWarnings("deprecation")
		int stbId=jdbcTemplate.queryForInt(query);
		
		String query2 = "SELECT max(id_fonctionnalite) FROM fonctionnalites WHERE id_stb='"+stbId+"'";
		int fonctId=jdbcTemplate.queryForInt(query2);
		for(StbExigence exigence : exigences){
			String description=exigence.getDescription();
			int priorite=exigence.getPriorite();
			String sql = "INSERT INTO exigences (description, priorite, id_fonctionalite, id_stb)"
	                + " VALUES ('"+description+"','"+priorite+"','"+fonctId+"','"+stbId+"')";
			 jdbcTemplate.execute(sql);
		}
		
	}

	
	@Override
	public StbExigence get(int stbId) {
		// TODO Auto-generated method stub
		String query = "SELECT id_fonctionnalite FROM fonctionnalites WHERE id_stb=" + stbId;
		@SuppressWarnings("deprecation")
		int fonctionnaliteId=jdbcTemplate.queryForInt(query);
		String sql = "SELECT * FROM exigences WHERE id_fonctionalite=" + fonctionnaliteId;
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
	
	public List<StbExigence> list(int stbId) {
		String query = "SELECT id_fonctionnalite FROM fonctionnalites WHERE id_stb=" + stbId;
		@SuppressWarnings("deprecation")
		int fctId=jdbcTemplate.queryForInt(query);
		String sql = "SELECT * FROM exigences WHERE id_fonctionalite=" + fctId;
	    List<StbExigence> listExigence = jdbcTemplate.query(sql, new RowMapper<StbExigence>() {
	        @Override
	        public StbExigence mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	StbExigence exigence = new StbExigence();
                exigence.setDescription(rs.getString("description"));
                exigence.setPriorite(rs.getInt("priorite"));
                return exigence;
	        }
	 
	    });
	    return listExigence;
	}
}
