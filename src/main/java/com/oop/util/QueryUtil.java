package com.oop.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class QueryUtil extends CommonUtil{
	public static String userQueryByID(String id) throws SAXException, IOException, ParserConfigurationException {

		NodeList nodeList;
		Element element = null;

		
		//NOT WORKING!!! = System.out.println("Im from QueryUtil.java");
		/*
		 * Read the UserQuery.xml file and read each query node into node
		 * list. It refers tag name query
		 */
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\oop_prjct\\WEB-INF\\UserQuery.xml"))
				.getElementsByTagName(CommonConstants.TAG_NAME);
		
		//NOT WORKING!!! = System.out.println("Im from QueryUtil.java");
		
		
		//"C:\Users\ARSHAQ SHAZLY\eclipse-workspace\oop_prjct\src\main\webapp\WEB-INF\UserQuery.xml"
		//"C:\Users\ARSHAQ SHAZLY\eclipse-workspace\OOPEmployeeWebApp\WebContent\WEB-INF\EmployeeQuery.xml"
		/*
		 * Extract the node from node list using query id query id is taken from
		 * query node attribute
		 */
		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);
			if (element.getAttribute(CommonConstants.ATTRIB_ID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}
	
	public static String reviewQueryByID(String id) throws SAXException, IOException, ParserConfigurationException {

		NodeList nodeList;
		Element element = null;
		/*
		 * Read the ReviewQuery.xml file and read each query node into node
		 * list. It refers tag name query
		 */
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\oop_prjct\\WEB-INF\\UserQuery.xml"))
				.getElementsByTagName(CommonConstants.TAG_NAME);

		/*
		 * Extract the node from node list using query id query id is taken from
		 * query node attribute
		 */
		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);
			if (element.getAttribute(CommonConstants.ATTRIB_ID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}
	
	public static String movieQueryByID(String id) throws SAXException, IOException, ParserConfigurationException {

		NodeList nodeList;
		Element element = null;
		/*
		 * Read the ReviewQuery.xml file and read each query node into node
		 * list. It refers tag name query
		 */
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\oop_prjct\\WEB-INF\\UserQuery.xml"))
				.getElementsByTagName(CommonConstants.TAG_NAME);

		/*
		 * Extract the node from node list using query id query id is taken from
		 * query node attribute
		 */
		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);
			if (element.getAttribute(CommonConstants.ATTRIB_ID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}
	
	public static String seriesQueryByID(String id) throws SAXException, IOException, ParserConfigurationException {

		NodeList nodeList;
		Element element = null;
		/*
		 * Read the ReviewQuery.xml file and read each query node into node
		 * list. It refers tag name query
		 */
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\oop_prjct\\WEB-INF\\UserQuery.xml"))
				.getElementsByTagName(CommonConstants.TAG_NAME);

		/*
		 * Extract the node from node list using query id query id is taken from
		 * query node attribute
		 */
		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);
			if (element.getAttribute(CommonConstants.ATTRIB_ID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}
}
