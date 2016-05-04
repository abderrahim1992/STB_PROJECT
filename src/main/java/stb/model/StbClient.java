package stb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.NONE)
public class StbClient {
	/**
	 * @param args
	 */
	@XmlElement
    private String nomClient;
    
    @XmlElement
    private String prenomClient;
    
    @XmlElement
    private String genderClient;
    
    @XmlElement
    private int contactClient;
    
    @XmlElement
    private Adresse adresse;
    
    public StbClient(String nom, String prenom, String gender, int contact){
    	this.nomClient=nom;
    	this.prenomClient=prenom;
    	this.genderClient=gender;
    	this.contactClient=contact;
    }
    
    public StbClient(){}
    
    //getters
    public String getNomClient(){
    	return nomClient;
    }
    
    public String getPrenomClient(){
    	return prenomClient;
    }
    
    public String getGenderClient(){
    	return genderClient;
    }
    
    public int getContactClient(){
    	return contactClient;
    }
    
    public Adresse getAdresse(){
    	return adresse;
    }
    
    
    //setters
    public void setNomClient(String nomClient){
    	this.nomClient=nomClient;
    }
    
    public void setPrenomClient(String prenomClient){
    	this.prenomClient=prenomClient;
    }
    
    public void setGenderClient(String genderClient){
    	this.genderClient=genderClient;
    }
    
    public void setContactClient(int contactClient){
    	this.contactClient=contactClient;
    }
    
    public void setAdresse(Adresse adresse){
    	this.adresse=adresse;
    }  
}
