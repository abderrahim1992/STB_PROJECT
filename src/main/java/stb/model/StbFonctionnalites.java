package stb.model;

import javax.xml.bind.annotation.XmlElement;

public class StbFonctionnalites {
	
	/** 
	 *Attributs
	 * */
	 @XmlElement
	private int id_fonctionnalite;
	 
	 @XmlElement
	private String descriptionFonctionnalite;
	 
	 @XmlElement
	private int prioriteFonctionnalite;
	 
	 @XmlElement
	private int id_stb;
	
	/** 
	 * Constructors
	 * */
	
	public StbFonctionnalites(int id_fonctionnalite, String description, int priorite, int id_stb ){
		this.id_fonctionnalite=id_fonctionnalite;
		this.descriptionFonctionnalite=description;
		this.prioriteFonctionnalite=priorite;
		this.id_stb=id_stb;
	}
	
	public StbFonctionnalites(){
		
	}
	
	/** 
	 * Getters
	 * */
	
	public int getIdFonctionnalite(){
		return id_fonctionnalite;
	}
	
	public String getDescription(){
		return descriptionFonctionnalite;
	}
	
	public int getPriorite(){
		return prioriteFonctionnalite;
	}
	
	public int getIdStb(){
		return id_stb;
	}
	
	/** 
	 * Setters
	 * */
	
	public void setIdFonctionnalite(int id_fonctionnalite){
		this.id_fonctionnalite= id_fonctionnalite;
	}
	
	public void setDescription(String description){
		this.descriptionFonctionnalite= description;
	}
	
	public void setPriorite(int priorite){
		this.prioriteFonctionnalite= priorite;
	}
	
	public void setIdStb(int id_stb){
		this.id_stb=id_stb;
	}
}
