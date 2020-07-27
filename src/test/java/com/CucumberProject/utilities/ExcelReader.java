package com.CucumberProject.utilities;

import java.util.ArrayList;
import java.util.HashMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReader {
	 
	
	public static HashMap<Object, Object> ReadExcel(String Filepath, String Sheetname, String Wherecondition) throws FilloException
	{
		Fillo fillo=new Fillo();
		HashMap<Object, Object> testdata = new HashMap<Object, Object>();
		String Query = "select * from  " + Sheetname;
		Connection connection = fillo.getConnection(Filepath);
		Recordset recordset = connection.executeQuery(Query).where(Wherecondition);


		if (recordset != null) {
			ArrayList<String> colname = new ArrayList<String>(recordset.getFieldNames());
			while (recordset.next()) {
				for (int i = 0; i < colname.size(); i++) {
					String header = colname.get(i);
					String value = recordset.getField(header);
					testdata.put(header, value);
				}
			}
		}
		recordset.close();
		connection.close();
		return testdata;

	}
}
