package stb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="ListStb")

public class ListStb implements Serializable 
{
    private static final long serialVersionUID = 1L;
     
    private List<STB> stb = new ArrayList<STB>();
 
    public List<STB> getStbList() {
        return stb;
    }
 
    public void setStbList(List<STB> stb) {
        this.stb = stb;
    }
}
