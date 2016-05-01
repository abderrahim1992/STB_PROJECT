package stb.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement (name = "stb")
@XmlAccessorType(XmlAccessType.NONE)
public class STB implements Serializable 
{
    private static final long serialVersionUID = 1L;
 
    @XmlAttribute
    private Integer id;
     
    @XmlElement
    private String projectTitle;
    
    @XmlElement
    private String stbVersion;
    
    @XmlElement
    private String stbDate;
     
    @XmlElement
    private String description;
    
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
    
    private StbCommentaire commentaire;
    
    private StbEquipe equipe;
    
    private StbFonctionnalites fonctionalite;
    
    private StbExigence exigence;
    
    private StbFonctionnalites fonctionnalites;
    
    
   
    public STB(Integer id, String projectTitle, String stbVersion, String stbDate, String description, String nomClient, String prenomClient, String genderClient, int contactClient,int numRue, String nomRue, String nomVille, int codePostale){
        super();
        this.id = id;
        this.projectTitle = projectTitle;
        this.stbVersion = stbVersion;
        this.stbDate = stbDate;
        this.description = description;
        this.nomClient=nomClient;
        this.prenomClient=prenomClient;
        this.contactClient=contactClient;
    } 
    public STB(){
    	
	    
    }
    
    //getters
    public int getID(){
    	return id;
    }
    
    public String getTitre(){
    	return projectTitle;
    }
    
    public String getVersion(){
    	return stbVersion;
    }
    
    public String getDate(){
    	return stbDate;
    }
    
    public String getDescription(){
    	return description;
    }
    
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
    
    public StbCommentaire getCommentaire(){
    	return commentaire;
    }
   
    public StbEquipe getEquipe(){
    	return equipe;
    }
    
    public StbFonctionnalites getFonctionnalite(){
    	return fonctionalite;
    }
    
    public StbExigence getExigence (){
    	return exigence;
    }
    
    public StbFonctionnalites getFonctionnalites(){
    	return fonctionnalites; 
    }
    
    //setter	
    public void setID(int id){
    	this.id=id;
    	
    }
    
    public void setTitre(String projectTitle ){
    	this.projectTitle =projectTitle;
    }
    
    public void setVersion(String stbVersion){
    	 this.stbVersion=stbVersion;
    }
    
    public void setDate(String stbDate){
    	this.stbDate=stbDate;
    }
    
    public void  setDescription(String description){
    	this.description=description;
    }
    
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
    
    
 
    @Override
    public String toString() {
        return "stb [id=" + id + ", titre_project=" + projectTitle
                + ", version=" + stbVersion + ", date=" + stbDate +", discription="+description+"]";
    }
}