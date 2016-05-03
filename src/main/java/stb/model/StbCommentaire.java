package stb.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="commentaire")
@XmlAccessorType(XmlAccessType.NONE)
public class StbCommentaire {
	/** 
	 * Attributs 
	 * */
	 @XmlElement
	private int id_commentaire;
	 
	 @XmlElement
	private String project;
	 
	 @XmlElement
	private String organismeComment;
	 
	 
	 @XmlElement
	private String informations;
	
	/** 
	 * COnstructors
	 * */
	public StbCommentaire(int id_commentaire, String project, String organisme, String information){
		this.id_commentaire=id_commentaire;
		this.project =project;
		this.organismeComment=organisme;
		this.informations=informations;
	}
	
	public StbCommentaire(){
		
	}
	
	/** 
	 * Getters
	 * */
	
	public int getIdCommentaire(){
		return id_commentaire;
	}
	
	public String getProject(){
		return project;
	}
	
	public String getOrganisme(){
		return organismeComment;
	}
	
	
	public String getInformation( ){
		return informations;
	}
	
	/** 
	 * Setters
	 * */
	
	public void setIdCommentaire(int id_commentaire){
		this.id_commentaire=id_commentaire;
	}
	
	public void setProject(String project){
		this.project=project;
	}
	
	public void setOrganisme(String organisme){
		this.organismeComment= organisme;
	}
	
	public void setInformation(String informations){
		this.informations= informations;
	}

}
