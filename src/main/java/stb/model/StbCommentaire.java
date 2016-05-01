package stb.model;

import javax.xml.bind.annotation.XmlElement;

public class StbCommentaire {
	
	/** 
	 * Attributs 
	 * */
	 @XmlElement
	private int id_commentaire;
	 
	 @XmlElement
	private int id_project;
	 
	 @XmlElement
	private int id_organisme;
	 
	 @XmlElement
	private int id_memberEquipe;
	 
	 @XmlElement
	private String informations;
	
	/** 
	 * COnstructors
	 * */
	public StbCommentaire(int id_commentaire, int id_project, int id_organisme, int id_memberEquipe, String information){
		this.id_commentaire=id_commentaire;
		this.id_project =id_project;
		this.id_organisme=id_organisme;
		this.id_memberEquipe=id_memberEquipe;
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
	
	public int getIdProject(){
		return id_project;
	}
	
	public int getIdOrganisme(){
		return id_organisme;
	}
	
	public int getIdMemberEquipe(){
		return id_memberEquipe;
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
	
	public void setIdProject(int id_project){
		this.id_project=id_project;
	}
	
	public void setIdOrganisme(int id_organisme){
		this.id_organisme= id_organisme;
	}
	
	public void setIdMemberEquipe(int id_memberEquipe){
		this.id_memberEquipe= id_memberEquipe;
	}
	
	public void setInformation(String informations){
		this.informations= informations;
	}

}
