package stb.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class ClientDAO implements StbDAO {

	@Override
	public void saveOrUpdate(Object stb) throws FileNotFoundException, ParserConfigurationException, SAXException,
			IOException, XPathExpressionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int stbId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object get(int stbID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
