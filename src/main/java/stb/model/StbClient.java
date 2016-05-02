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
	private String contactClient;

	@XmlElement
	private String numRue;

	@XmlElement
	private String nomRue;

	@XmlElement
	private String nomVille;

	@XmlElement
	private String codePostal;

	public StbClient(String nom, String prenom, String gender, String contact, String num, String rue, String ville,
			String code) {
		this.nomClient = nom;
		this.prenomClient = prenom;
		this.genderClient = gender;
		this.contactClient = contact;
		this.numRue = num;
		this.nomRue = rue;
		this.nomVille = ville;
		this.codePostal = code;
	}

	public StbClient() {
	}

	// getters
	public String getNomClient() {
		return nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public String getGenderClient() {
		return genderClient;
	}

	public String getContactClient() {
		return contactClient;
	}

	public String getnumRue() {
		return numRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public String getNomVille() {
		return nomVille;
	}

	public String getCode() {
		return codePostal;
	}

	// setters
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public void setGenderClient(String genderClient) {
		this.genderClient = genderClient;
	}

	public void setContactClient(String contactClient) {
		this.contactClient = contactClient;
	}

	public void setnumRue(String numRue) {
		this.numRue = numRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public void setCode(String codePostal) {
		this.codePostal = codePostal;
	}

}
