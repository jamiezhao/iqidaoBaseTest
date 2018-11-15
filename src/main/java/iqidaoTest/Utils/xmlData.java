package iqidaoTest.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xmlData {
	
	public static String getParamFromXml(String paramName) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		String paramValue = null;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse("TestData.xml");
			NodeList paramList = doc.getElementsByTagName(paramName);
			paramValue = paramList.item(0).getFirstChild().getNodeValue();
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return paramValue;
		
	}
	
	public static String[] getParamArrayFromXml(String paramName) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		String[] paramValue = null;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse("TestData.xml");
			NodeList paramList = doc.getElementsByTagName(paramName);
			ArrayList<Node> param = new ArrayList<Node>();
			//List<String> param1 = new ArrayList<String>();
			for (int i = 0; i < paramList.getLength(); i++) {
				param.add(paramList.item(i));
			}
			int size = param.size();
			String[] array=new String[size];
			for (int i = 0; i < param.size(); i++) {
				array[i]=(String)param.get(i).getFirstChild().getNodeValue();
				paramValue=array;
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return paramValue;
	}
	
	public static List<String> getParamsFromXml(String paramName, int n) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		List<String> paramValueList = new ArrayList<String>();
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse("TestData.xml");
			//获取一级标签，放入列表
			NodeList paramList = doc.getElementsByTagName(paramName);
			//依次取一级标签
			Node param = paramList.item(n);
			//取一级标签下的子标签，放入列表
			NodeList childParamList = param.getChildNodes();
			//循环取出子标签的value值放入列表
			for(int i = 0; i < childParamList.getLength(); i++) {
				if(childParamList.item(i).getNodeType() == Node.ELEMENT_NODE) {
					String paramValue = childParamList.item(i).getFirstChild().getNodeValue();
					paramValueList.add(paramValue);
				}
				
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return paramValueList;
	}
	
	
}
