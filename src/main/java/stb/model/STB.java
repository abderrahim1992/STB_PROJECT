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
import javax.xml.bind.annotation.XmlElementWrapper;
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
   	private StbClient client;
    
    @XmlElement
    private StbEquipe membre;
    
    @XmlElementWrapper(name="listEquipe")
   	@XmlElement(name="membre")
   	private List<StbEquipe> listEquipe;
    
    @XmlElement
	private StbFonctionnalites fonctionnalites;
    
    @XmlElement
    private StbCommentaire commentaire;
    
    
   
    public STB(Integer id, String projectTitle, String stbVersion, String stbDate, String description){
        super();
        this.id = id;
        this.projectTitle = projectTitle;
        this.stbVersion = stbVersion;
        this.stbDate = stbDate;
        this.description = description;
        
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
    
    public StbClient getClient(){
    	return client; 
    }
    
    public StbEquipe getEquipe(){
    	return membre;
    }
    
    public StbFonctionnalites getFonctionnalites(){
    	return fonctionnalites; 
    }
    
    
    
    public StbCommentaire getCommentaire(){
    	return commentaire;
    }
    
    public List<StbEquipe> getListEquipe(){
    	return listEquipe;
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
    
    public void setClient(StbClient stbclient){
    	this.client=stbclient; 
    }
    
    public  void setListEquipe(List<StbEquipe> listEquipe){
    	this.listEquipe=listEquipe;
    }
    
    public void setEquipe(StbEquipe mbr){
    	this.membre=mbr; 
    }
    
    public void setFonctionnalite(StbFonctionnalites stbFonctionnalite){
    	this.fonctionnalites=stbFonctionnalite; 
    }
    
    public void setCommentaire(StbCommentaire comment){
    	this.commentaire=comment; 
    }

    @Override
    public String toString() {
        return "stb [id=" + id + ", titre_project=" + projectTitle
                + ", version=" + stbVersion + ", date=" + stbDate +", discription="+description+"]";
    }

}