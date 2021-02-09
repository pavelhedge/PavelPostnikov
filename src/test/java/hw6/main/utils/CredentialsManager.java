package hw6.main.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class CredentialsManager {

    static Document doc;
    static XPath xPath = XPathFactory.newInstance().newXPath();

    static {
        try {
            File inputFile = new File("src/test/resources/hw6/credentials.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();

            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLogin(String username) {
        try {
        String expression = "/user[@name='" + username + "']";
        Element elem = (Element) xPath.compile(expression).evaluate(
                doc, XPathConstants.NODE);
        return elem.getElementsByTagName("login").item(0).getTextContent();
        }catch (XPathExpressionException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String getPassword(String username) {
        try {
            String expression = "/user[@name='" + username + "']";
            Element elem = (Element) xPath.compile(expression).evaluate(
                    doc, XPathConstants.NODE);
            return elem.getElementsByTagName("password").item(0).getTextContent();
        }catch (XPathExpressionException e){
            e.printStackTrace();
            return null;
        }
    }
}