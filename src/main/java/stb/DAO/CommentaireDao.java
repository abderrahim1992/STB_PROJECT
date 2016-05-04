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

public class CommentaireDao implements StbDAO {

	private JdbcTemplate jdbcTemplate;
	 
	public CommentaireDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void saveOrUpdate(STB stb) {
		// TODO Auto-generated method stub
		
		StbCommentaire cmt=stb.getCommentaire();
		
		String project=cmt.getProject();
		String organisme=cmt.getOrganisme();
		String information=cmt.getInformation();
		
		//select the last stb stocked
        String query = "SELECT max(stb_id) FROM stbType";
		@SuppressWarnings("deprecation")
		int stbId=jdbcTemplate.queryForInt(query);
		
		 String sql = "INSERT INTO commentaire (project, organisme, informations , id_stb)"
                 + " VALUES ('"+project+"','"+organisme+"','"+information+"','"+stbId+"')";
		 jdbcTemplate.execute(sql);
	}

	

	@Override
	public StbCommentaire get(int stbId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM commentaire WHERE id_stb=" + stbId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<StbCommentaire>() {
	 
	        @Override
	        public StbCommentaire extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	StbCommentaire comment = new StbCommentaire();
	            	comment.setIdCommentaire(rs.getInt("id_commentaire"));
	            	comment.setProject(rs.getString("project"));
	            	comment.setOrganisme(rs.getString("organisme"));
	            	comment.setInformation(rs.getString("informations"));
	                return comment;
	            }
	            return null;
	        }
	 
	    });
	}
	
	public List<Object> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM commentaire";
		List<Object> listComment = jdbcTemplate.query(sql, new RowMapper<Object>() {
			 
		        @Override
		        public StbCommentaire mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	StbCommentaire cmt = new StbCommentaire();
		        	cmt.setIdCommentaire(rs.getInt("id_commentaire"));
		        	cmt.setProject(rs.getString("project"));
		        	cmt.setOrganisme(rs.getString("organisme"));
		        	cmt.setInformation(rs.getString("informations"));
	                return cmt;
		        }
		 
		    });
		 
		    return listComment;
	}

}
