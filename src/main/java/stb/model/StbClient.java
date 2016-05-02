package stb.model;

import javax.xml.bind.annotation.XmlElement;

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
    private int numRue;
    
    @XmlElement
    private String nomRue;
    
    @XmlElement
    private String nomVille;
    
    @XmlElement
    private int codePostal;
    
    public StbClient(String nom, String prenom, String gender, int contact, int num, String rue, String ville, int code){
    	this.nomClient=nom;
    	this.prenomClient=prenom;
    	this.genderClient=gender;
    	this.contactClient=contact;
    	this.numRue=num;
    	this.nomRue=rue;
    	this.nomVille=ville;
    	this.codePostal=code;
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
    
    public int getnumRue(){
    	return numRue;
    }
    
    public String getNomRue(){
    	return nomRue;
    }
    
    public String getNomVille(){
    	return nomVille;
    }
    
    public int getCode(){
    	return codePostal;
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
    
    public void setnumRue(int numRue){
    	this.numRue=numRue;
    }
    
    public void setNomRue(String nomRue){
    	this.nomRue= nomRue;
    }
    
    public  void setNomVille(String nomVille){
    	this.nomVille= nomVille;
    }
    
    public void setCode(int codePostal){
    	this.codePostal=codePostal;
    }
    
}
