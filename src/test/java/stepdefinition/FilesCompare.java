package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page_object.DataComparision;
import page_object.ReadMultipleCSVData;

public class FilesCompare {
	ReadMultipleCSVData read;
	DataComparision data;
	@Given("User Read Multiple Files")
	public void user_read_multiple_files() {
		read=new ReadMultipleCSVData();
		read.ReadCSVFiles();
		
	}

	@Then("User validate the input output files")
	public void user_validate_the_input_output_files() {
		data=new DataComparision();
		data.comparision();
	}

}
