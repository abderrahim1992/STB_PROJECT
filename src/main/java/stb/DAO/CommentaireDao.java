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
		
		int id_project=cmt.getIdCommentaire();
		int id_organisme=cmt.getIdOrganisme();
		String information=cmt.getInformation();
		 String sql = "INSERT INTO commentaire (id_project, id_organisme, id_membreEquipe, informations)"
                 + " VALUES (1,1,2,'"+information+"')";
		 jdbcTemplate.execute(sql);
	}

	@Override
	public void delete(int commentaireId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM commentaire WHERE stb_id=?";
	    jdbcTemplate.update(sql, commentaireId);
	}

	@Override
	public Object get(int commentaireId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM commentaire WHERE id_commentaire=" + commentaireId;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<StbCommentaire>() {
	 
	        @Override
	        public StbCommentaire extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	StbCommentaire comment = new StbCommentaire();
	            	comment.setIdCommentaire(rs.getInt("id_commentaire"));
	            	comment.setIdOrganisme(rs.getInt("id_organisme"));
	            	comment.setIdMemberEquipe(rs.getInt("id_membreEquipe"));
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
		        	cmt.setIdOrganisme(rs.getInt("id_organisme"));
		        	cmt.setIdMemberEquipe(rs.getInt("id_membreEquipe"));
		        	cmt.setInformation(rs.getString("informations"));
	                return cmt;
		        }
		 
		    });
		 
		    return listComment;
	}

}
