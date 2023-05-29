package page_object;


import java.io.FileReader;
import com.opencsv.*;

public class ReadMultipleCSVData {
	private static final String CSV_FILE1
		= "srs/test/resources/TestData/InstrumentDetails.csv";
	private static final String CSV_FILE2
		= "srs/test/resources/TestData/PositionDetails.csv";
	private static final String CSV_FILE3
	= "srs/test/resources/TestData/Output.csv";

	
   /**
    * read csv files
    */
	public void ReadCSVFiles()
	{

		System.out.println("Read InstrumentsDetails File data \n");
		readCsvFile(CSV_FILE1);
		System.out.println("_______________________________________________");

		System.out.println("Read PositionDetails files data \n");
		readCsvFile(CSV_FILE2);
		System.out.println("_______________________________________________");

		System.out.println("Read Output files data \n");
		readCsvFile(CSV_FILE3);
		
	}
	/**
	 * 
	 * @param file
	 */
	
   public static void readCsvFile(String file)
	{

		try {
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord1;
          
			while ((nextRecord1 = csvReader.readNext()) != null) {
				for (String cell : nextRecord1) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}	