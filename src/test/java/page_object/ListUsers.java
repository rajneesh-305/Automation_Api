package page_object;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;

public class ListUsers {
	/**
	 * get request
	 */
	public void listUser() {
		try {
			  RestAssured.baseURI="https://reqres.in/api";
				RestAssured.given()
				.get("/users?page=2")
				.then()
				.statusCode(200)
				.body("data[4].first_name", equalTo("George"));
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	/**
	 * get request
	 */
	public void singleUser() {
		try {
			  RestAssured.baseURI="https://reqres.in/api";
				RestAssured.given()
				.get("/users/2")
				.then()
				.statusCode(200)
				.body("data.first_name", equalTo("Janet"))
				.body("data.last_name", equalTo("Weaver"));
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	/**
	 * post request
	 */
  public void createUser() {
	  try {
		  RestAssured.baseURI="https://reqres.in/api";
		  String json= "{\r\n"
		    		+ "    \"name\": \"morpheus\",\r\n"
		    		+ "    \"job\": \"leader\"\r\n"
		    		+ "}";
		  RestAssured.given()
		  .contentType("application/json")
		  .body(json)
		  .post("/users")
		  .then()
		  .log()
		  .all()
		  .assertThat()
		  .statusCode(201);
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  /**
   * put request
   */
  public void putResponse() {
	  try {
		RestAssured.baseURI="https://reqres.in/api";
		 String json= "{\r\n"
		    		+ "    \"name\": \"morpheus\",\r\n"
		    		+ "    \"job\": \"leader\"\r\n"
		    		+ "}";
		 RestAssured.given()
		 .body(json)
		 .put("/users/2")
		 .then()
		 .log()
		 .all()
		 .assertThat()
		 .statusCode(200);
	}catch(Exception e) {
		e.printStackTrace();
	}
  }
/**
 * Patch request
 */
	public void patchResponse() {
		try {
		RestAssured.baseURI="https://reqres.in/api";
		 String json= "{\r\n"
		    		+ "    \"name\": \"morpheus\",\r\n"
		    		+ "    \"job\": \"leader\"\r\n"
		    		+ "}";
		 RestAssured.given()
		 .body(json)
		 .patch("/users/2")
		 .then()
		 .log()
		 .all()
		 .assertThat()
		 .statusCode(200);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	/**
	 * delete request
	 */
	public void deleteResponse() {
		try {
		RestAssured.baseURI="https://reqres.in/api";
		 RestAssured.given()
		 .delete("/users/2")
		 .then()
		 .log()
		 .all()
		 .assertThat()
		 .statusCode(204);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
