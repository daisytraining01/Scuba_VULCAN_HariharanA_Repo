package com.ToolsQAProject.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class ResultAnalysisLog {

	FileReader fileReader = null;
	BufferedReader bufferReader = null;

	String readLine = null;
	String filePath = null;
	StringBuffer stringBuffer = new StringBuffer();
	List<String> log = new ArrayList<String>();

	public List<String> readfile(String filePath){
		try {
			fileReader = new FileReader(filePath);
			bufferReader = new BufferedReader(fileReader);

			while((readLine = bufferReader.readLine()) != null ) {
				log.add(readLine+"\n");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return log;

	}


	public void writeFile( List<String> output) throws IOException {
		BufferedWriter file_output = null;
		try {
			new File("./logs/logAnalysis").mkdirs();
			File file = new File("./logs/logAnalysis/TotalCase.txt");
			file_output = new BufferedWriter(new FileWriter(file));
			file_output.write(output.toString().replace(",", "").replace("[", "").replace("]", ""));
			file_output.newLine();
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			if ( output != null ) {
				file_output.close();
			}
		}
	}

	public  ResultAnalysisLog()
	{        
		try {
			List<String> output = readfile("./logs/TAF.log");
			int totalcasecount = 0;
			int passcasecount = 0;
			int failcasecount = 0;
			int skipcasecount = 0;

			List<String>  passedCasesDesc = new ArrayList<String>();
			List<String>  failedCasesDesc = new ArrayList<String>();
			List<String>  skippedCasesDesc = new ArrayList<String>();
			List<String>  resultDetails = new ArrayList<String>();

			for (int i=0;i<=output.size()-1;i++)
			{
				if (output.get(i).contains("STARTED ||")) {
					totalcasecount = totalcasecount +1; 
					
				}
				else if (output.get(i).contains("PASS ||")) {
					passcasecount = passcasecount +1;
					passedCasesDesc.add("Case Index: "+passcasecount+"\nDescripition of Case:\t "+output.get(i).toString()+"\n");   
				}
				else if(output.get(i).contains("FAIL ||")) {
					failcasecount = failcasecount +1;
					failedCasesDesc.add("Case Index: "+failcasecount+"\nDescripition of Case:\t "+output.get(i).toString()+"\n");
				}
				else if(output.get(i).contains("SKIP ||")) {
					skipcasecount = skipcasecount +1;
					skippedCasesDesc.add("Case Index: "+skipcasecount+"\nDescripition of Case:\t "+output.get(i).toString()+"\n");
				}
			}
			resultDetails.add("------------------------------------Overview Analysis--------------------------\n\n");
			resultDetails.add("Total No of cases Exectuted\t : "+totalcasecount+"\n");
			resultDetails.add("Total No of Passed cases\t : "+passcasecount+"\n");
			resultDetails.add("Total No of Failed cases\t : "+failcasecount+"\n");
			resultDetails.add("Total No of Skipped cases\t : "+skipcasecount+"\n");
			
			resultDetails.add("\n\n------------------------------------Detailed Analysis--------------------------\n\n");
			resultDetails.add("\n\t** Passed Cases **\n"+passedCasesDesc);
			resultDetails.add("\n\t** Failed Cases **\n"+failedCasesDesc);
			resultDetails.add("\n\t** Skipped Cases **\n"+skippedCasesDesc);
			
			writeFile(resultDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
