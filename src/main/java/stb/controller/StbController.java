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

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import stb.DAO.StbDAO;
import stb.DAO.StbDaoImpl;
import stb.model.ListStb;
import stb.model.STB;


@RestController
public class StbController
{
	
	private Date stbDate;
	@Autowired
	private StbDAO StbDao;
	int id=1;
	String titre = "agora";
	String version="2.2";
	Date dt=new Date(2016/04/23);
	String Description="specification des besoins du projet master 1 gil agora";
	
    @RequestMapping(value = "/resume")
    public @ResponseBody ListStb getAllStb()
    {
    	ListStb stbLst = new ListStb();
    	List<Object> lst =StbDao.list(); 
    	for (int i=0; i<lst.size(); i++){
    		stbLst.getStbList().add((STB)lst.get(i));
    	}
        return stbLst;
	 }
   
    @RequestMapping(value = "/depot")
    public ModelAndView saveStb(@ModelAttribute STB stb) throws FileNotFoundException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
    	
    	StbDao.saveOrUpdate(stb);
        return new ModelAndView("redirect:/resume");
    }
    
    @RequestMapping(value = "/resume/{id}")
    public @ResponseBody STB getStbById (@PathVariable("id") int id) 
    {
        if (id == 1) {
            STB stb = (STB) StbDao.get(1);
            return  stb;
        }
        return null;
    }
}
