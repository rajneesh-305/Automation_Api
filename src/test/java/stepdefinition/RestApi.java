package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page_object.ListUsers;

public class RestApi {
	ListUsers listusers;
	@Given("I want to execute ListUsers")
	public void i_want_to_execute_list_users() {
		listusers = new ListUsers();
		listusers.listUser();
	}

	@When("I submit  the GET request")
	public void i_submit_the_get_request() {
		listusers.singleUser();
	}

	@When("I submit  the POST request")
	public void i_submit_the_post_request() {
		listusers.createUser();
	}

	@When("I submit  the PUT request")
	public void i_submit_the_put_request() {
		listusers.patchResponse();
	}

	@When("I submit  the PATCH request")
	public void i_submit_the_patch_request() {
		listusers.patchResponse();
	}

	@When("I submit  the DELETE request")
	public void i_submit_the_delete_request() {
		listusers.deleteResponse();
	}
}
