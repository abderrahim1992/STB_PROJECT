package stb.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="equipe")
@XmlAccessorType(XmlAccessType.NONE)
public class StbEquipe {
	
	/** 
	 * Attributs
	 * */
	 @XmlElement
	private int id_membre;
	 
	 @XmlElement
	private int id_stb;
	 
	 @XmlElement
	private String nomMembre;
	 
	 @XmlElement
	private String prenomMembre;
	 
	 @XmlElement
	private String genderMembre;
	
	 @XmlElement
	private String contactMembre;
	/** 
	 * Constructors
	 * */
	public StbEquipe(int id_membre, int id_stb, String nom, String prenom, String gender, String contactMembre ){
		this.id_membre=id_membre;
		this.id_stb=id_stb;
		this.nomMembre=nom;
		this.prenomMembre=prenom;
		this.genderMembre=gender;
		this.contactMembre=contactMembre;
	}
	
	public StbEquipe(){
		
	}
	
	/** 
	 * Getters
	 * */
	public int getIdMember(){
		return id_membre;
	}
	
	public int getIdStb(){
		return id_stb;
	}
	
	public String getNom(){
		return nomMembre;
	}
	public String getPrenom(){
		return prenomMembre;
	}
	public String getGender(){
		return genderMembre;
	}
	
	public String getContact(){
		return contactMembre;
	}
	/** 
	 * Setters
	 * */
	public void setIdMember(int id_membre){
		this.id_membre= id_membre;
	}
	
	public void setIdStb(int id_stb){
		this.id_stb= id_stb;
	}
	
	public void setNom(String nom){
		this.nomMembre= nom;
	}
	public void setPrenom(String prenom){
		this.prenomMembre= prenom;
	}
	public void setGender(String gender){
		this.genderMembre= gender;
	}
	public void setContact(String contact){
		this.contactMembre= contact;
	}
}
