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
    
    private StbCommentaire commentaire;
    
    @XmlElement
    private StbEquipe equipe;
    
    
    @XmlElement
    private StbExigence exigence;
    
    @XmlElement
	private StbFonctionnalites fonctionnalites;
    
    @XmlElement
	private StbClient client;
    
    
   
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
    
    
    
    public StbCommentaire getCommentaire(){
    	return commentaire;
    }
   
    public StbEquipe getEquipe(){
    	return equipe;
    }
    
    
    public StbExigence getExigence (){
    	return exigence;
    }
    
    public StbFonctionnalites getFonctionnalites(){
    	return fonctionnalites; 
    }
    
    public StbClient getClient(){
    	return client; 
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
    

    
    
 
    @Override
    public String toString() {
        return "stb [id=" + id + ", titre_project=" + projectTitle
                + ", version=" + stbVersion + ", date=" + stbDate +", discription="+description+"]";
    }
}