package stb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="fonctionnalites")
@XmlAccessorType(XmlAccessType.NONE)
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
	 
	 @XmlElement
	 private StbExigence exigence;
	
	 @XmlElementWrapper(name="listExigence")
	 @XmlElement(name="exigence")
	 private List<StbExigence> listExigence;
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
	
	public StbExigence getExigence (){
	    	return exigence;
	}
	
	public List<StbExigence> getListExigence (){
    	return listExigence;
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
	
	public void setExigence (StbExigence exigence){
    	 this.exigence=exigence;
	}
	
	public void setIdStb(int id_stb){
		this.id_stb=id_stb;
	}
	
	 public void setExigenceList(List<StbExigence> exigences) {
	        this.listExigence = exigences;
	    }
		
}
