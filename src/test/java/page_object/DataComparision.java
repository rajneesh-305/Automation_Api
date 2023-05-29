package page_object;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReaderBuilder;
import com.opencsv.RFC4180Parser;
import com.opencsv.RFC4180ParserBuilder;

public class DataComparision {
	/**
	 * compare output files 
	 */
	public void comparision() {
           try {
		String inputfile1="srs/test/resources/TestData/InstrumentDetails.csv";
		List<Object> listOfInstrumentalDetail = readCSVFile(inputfile1);
		
		String inputfile2="srs/test/resources/TestData/PositionDetails.csv";
		List<Object> listOfPositionDetails = readCSVFile(inputfile2);
		
		String OutputFile="srs/test/resources/TestData/Output.csv";
		List<Object> listOfOutPutfilerecords = readCSVFile(OutputFile);
		
		validateCSVFiles(listOfInstrumentalDetail,listOfPositionDetails,listOfOutPutfilerecords);
          }catch(Exception e) {
	      e.printStackTrace();
          }
	}
	/**
	 * 
	 * @param inputFilePath
	 * @return
	 * @throws IOException
	 */
	
	public static List<Object> readCSVFile(String inputFilePath) throws IOException {
		
		RFC4180Parser rfc4180Parser = new RFC4180ParserBuilder().build();
		Reader reader1 = Files.newBufferedReader(Paths.get(inputFilePath));
		CSVReaderBuilder csvReaderBuilder = new CSVReaderBuilder(reader1).withCSVParser(rfc4180Parser);
		String[] nextRecord;
		try (com.opencsv.CSVReader csvReader1 = csvReaderBuilder.build()) {

			nextRecord = csvReader1.readNext();
			 
			if(nextRecord .length==4) {
				List<Object> listOfInputPojo1 = new ArrayList<>();
				while (null != (nextRecord = csvReader1.readNext())) {
					InputPojo1 temp_InputPojo1 = new InputPojo1();
					temp_InputPojo1.setID(nextRecord[0]);
					temp_InputPojo1.setISIN(nextRecord[2]);
					temp_InputPojo1.setName(nextRecord[1]);
					temp_InputPojo1.setUnitPrice(Integer.parseInt(nextRecord[3]));
				
					listOfInputPojo1.add(temp_InputPojo1);
				}
				return listOfInputPojo1;
			}else if(nextRecord .length==3) {
				List<Object> listOfInputPojo2 = new ArrayList<>();
				while (null != (nextRecord = csvReader1.readNext())) {
					InputPojo2 temp_InputPojo2 = new InputPojo2();
					temp_InputPojo2.setID(nextRecord[0]);
					temp_InputPojo2.setInstrument_ID(nextRecord[1]);
					temp_InputPojo2.setQuantity(Integer.parseInt(nextRecord[2]));
									
					listOfInputPojo2.add(temp_InputPojo2);
				}
				return listOfInputPojo2;
				
				
			}else if(nextRecord .length==5) {
				List<Object> listOfInputPojo2 = new ArrayList<>();
				while (null != (nextRecord = csvReader1.readNext())) {
					OutPutPojo temp_OutPutPojo = new OutPutPojo();
					temp_OutPutPojo.setID(nextRecord[0]);
					temp_OutPutPojo.setPositionID(nextRecord[1]);
					temp_OutPutPojo.setISIN(nextRecord[2]);
					temp_OutPutPojo.setQuantity(nextRecord[3]);
					temp_OutPutPojo.setTotalPrice(Integer.parseInt(nextRecord[4]));
									
					listOfInputPojo2.add(temp_OutPutPojo);
				}
				return listOfInputPojo2;
			}
						
		} catch (Exception e) {}
		return null;
		
		
		}
	/**
	 * 
	 * @param inputFile1
	 * @param inputFile2
	 * @param outputFile
	 */
	
	private static void validateCSVFiles(List<Object> inputFile1,List<Object> inputFile2,List<Object> outputFile) {
		
		for(int i=0;i<outputFile.size();i++) {
			
			OutPutPojo outPutFileRec = (OutPutPojo) outputFile.get(i);
			String positionID=outPutFileRec.getPositionID();
			String ISIN = outPutFileRec.getISIN();
			int totalPrice = outPutFileRec.getTotalPrice();
			
			for(int j=i;j<inputFile2.size();j++) {
				
				InputPojo2 Temp_InputPojo2 =(InputPojo2) inputFile2.get(j);
				String inputFile2_ID = Temp_InputPojo2.getID();
				String inputFile2_InstrumentID =Temp_InputPojo2.getInstrument_ID();
				int inputFile2_Quantity =Temp_InputPojo2.getQuantity();
				
				for(int k=0;k<inputFile1.size();k++) {
					InputPojo1 temp_InputPojo1= (InputPojo1) inputFile1.get(k);
					String inputFile1_ID = temp_InputPojo1.getID();
					String inputFile1_ISIN = temp_InputPojo1.getISIN();
					int inputFile1_unitPrice = temp_InputPojo1.getUnitPrice();
					boolean found=false;
					
					if(positionID.equals(inputFile2_ID) && inputFile2_InstrumentID.equals(inputFile1_ID) 
							&& inputFile1_ISIN.equals(ISIN)
							&&totalPrice==(inputFile1_unitPrice*inputFile2_Quantity)) {
						System.out.println(positionID +" is matching in two input files");
						found=true;
						break;
						
					}
					
						if(k==inputFile1.size()-1 && found==false) {
							System.out.println(positionID +" is not matching in two input files");
						}
					
				}
				break;
			}
			
		}
		
	}
	

	

}

