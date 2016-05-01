package stb.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import stb.model.STB;

public interface StbDAO {
	
	public void saveOrUpdate(STB stb) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException, XPathExpressionException;
    public void delete(int stbId);
    public Object get(int stbID);
    public List<Object> list();

}
