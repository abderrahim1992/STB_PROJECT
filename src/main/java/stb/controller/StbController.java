package stb.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import org.xml.sax.SAXException;

import stb.DAO.AdresseDao;
import stb.DAO.ClientDAO;
import stb.DAO.CommentaireDao;
import stb.DAO.EquipeDao;
import stb.DAO.ExigenceDao;
import stb.DAO.FonctionnalitesDao;
import stb.DAO.StbDAO;
import stb.DAO.StbDaoImpl;
import stb.model.ListStb;
import stb.model.STB;
import stb.model.StbClient;
import stb.model.StbCommentaire;
import stb.model.StbEquipe;
import stb.model.StbExigence;
import stb.model.StbFonctionnalites;

@RestController
public class StbController {

	private Date stbDate;
	@Autowired
	private StbDAO StbDao;
	private StbDaoImpl stbImpl;
	private ClientDAO clientDao;
	private CommentaireDao commentaire;
	private EquipeDao equipe;
	private ExigenceDao exigence;
	private FonctionnalitesDao fonctionnalite;
	private AdresseDao adresse;
	int id = 1;
	String titre = "agora";
	String version = "2.2";
	Date dt = new Date(2016 / 04 / 23);
	String Description = "specification des besoins du projet master 1 gil agora";

	public void initDao() {
		clientDao = new ClientDAO(getDataSource());
		commentaire = new CommentaireDao(getDataSource());
		equipe = new EquipeDao(getDataSource());
		exigence = new ExigenceDao(getDataSource());
		fonctionnalite = new FonctionnalitesDao(getDataSource());
		adresse = new AdresseDao(getDataSource());
		stbImpl = new StbDaoImpl(getDataSource());
	}

	@RequestMapping(value = "/resume")
	public @ResponseBody ListStb getAllStb() {
		initDao();
		ListStb stbLst = new ListStb();
		List<Object> lst = stbImpl.list();
		for (int i = 0; i < lst.size(); i++) {
			stbLst.getStbList().add((STB) lst.get(i));
		}
		return stbLst;
	}

	@RequestMapping(value = "/accueil")
	public @ResponseBody String getAccueil() {
		initDao();
		int stbCount = stbImpl.getStbCount();
		String homeStr = "Membres :\nAbderrahim SI-ZIANI\nMohamed IBRIHEN\nNombre de STB : " + stbCount;
		return homeStr;
	}

	// @RequestMapping(value = "/depot")
	// public ModelAndView saveStb(@ModelAttribute STB stb) throws
	// FileNotFoundException, XPathExpressionException,
	// ParserConfigurationException, SAXException, IOException {
	// System.out.println("TITRE -> " + stb.getTitre());
	//
	// StbDao.saveOrUpdate(stb);
	//// return new ModelAndView("redirect:/resume");
	// }

	@RequestMapping(value = "/depot", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Void> saveStb(@RequestBody STB stb, UriComponentsBuilder ucBuilder)
			throws FileNotFoundException, XPathExpressionException, ParserConfigurationException, SAXException,
			IOException {
		// TODO Vérifier si la STB existe déjà dans la BDD si c'est le cas
		// retourner une erreur HTTP 409 (conflit)
		// System.out.println("********" + stb.toString());
		// StbExigence exigence = stb.getExigence();
		// StbFonctionnalites fonctionnalite = stb.getFonctionnalites();
		// StbClient client = stb.getClient();
		// StbEquipe equipe = stb.getEquipe();
		// System.out.println("nom equipe = " + equipe.getNom());
		// System.out.println("\n\n\npriorite = " + exigence.getPriorite() + "
		// fonc = " + fonctionnalite.getDescription());
		// System.out.println("nom client : " + client.getNomClient());
		initDao();
		StbDao.saveOrUpdate(stb);
		clientDao.saveOrUpdate(stb);
		equipe.saveOrUpdate(stb);
		commentaire.saveOrUpdate(stb);
		fonctionnalite.saveOrUpdate(stb);
		exigence.saveOrUpdate(stb);
		adresse.saveOrUpdate(stb);
		int id = 21;
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/resume/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	public DataSource getDataSource() {
		String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
		// String port = "3306";
		String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
		String dbName = "stb";
		// String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
		String url = "jdbc:mysql://" + "127.11.194.2" + ":" + "3306" + "/" + "stb";
		String user = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
		String passwd = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername("adminkmwGWnE");
		dataSource.setPassword("7ngTMBxe_ai3");
		return dataSource;
	}

	@RequestMapping(value = "/resume/{id}")
	public @ResponseBody STB getStbById(@PathVariable("id") int id) {
		STB stb = (STB) StbDao.get(id);
		return stb;
	}
}
