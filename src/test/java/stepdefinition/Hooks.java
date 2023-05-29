package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	 @Before
	    public void initialization()  {
	        System.out.println("TestScenario execution start ....");

	    }

	    @After
	    public void tearDown() throws Exception {
	        System.out.println("Execution completed successfully.....");
	    }
}


