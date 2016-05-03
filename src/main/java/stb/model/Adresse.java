package stb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="adresse")
@XmlAccessorType(XmlAccessType.NONE)
public class Adresse {

    @XmlElement
    private int numRue;
    
    @XmlElement
    private String nomRue;
    
    @XmlElement
    private String nomVille;
    
    @XmlElement
    private int codePostal;
    
    public Adresse(int numRue, String nomRue, String nomVille, int codePostal){
    	this.numRue=numRue;
    	this.nomRue=nomRue;
    	this.nomVille=nomVille;
    	this.codePostal=codePostal;
    }
    
    public Adresse(){
    	
    }
    
    //getters
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
