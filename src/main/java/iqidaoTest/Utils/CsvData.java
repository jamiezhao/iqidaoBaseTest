package iqidaoTest.Utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CsvData {
	
	@DataProvider(name="testData")
	public static Object[][] getData() throws IOException{
		return getCsvData();
	}
	
	@Test(dataProvider="testData")
	public void test(String n1, String n2) {
		System.out.println(n1 + "========" + n2);
	}
	
	
	public static Object[][] getCsvData() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("testData.csv"),"UTF-8"));
		List<String[]> loginDatas = new ArrayList<String[]>();
		String record;
		while((record=br.readLine()) != null) {
			String[] fileds = record.split(",");
			loginDatas.add(fileds);
		}
		br.close();	
		
		Object[][] result = new Object[loginDatas.size()][];
		for(int i = 0; i < loginDatas.size(); i++) {
			result[i] = loginDatas.get(i);
		}
		return result;
	}
	



}
