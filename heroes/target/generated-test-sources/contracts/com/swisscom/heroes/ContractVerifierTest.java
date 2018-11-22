package com.swisscom.heroes;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.swisscom.heroes.miBaseTestClass;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import org.junit.Test;

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;

public class ContractVerifierTest extends miBaseTestClass {

	@Test
	public void validate_addHeroClara() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json")
					.body("{\"name\":\"Vera\"}");

		// when:
			ResponseOptions response = given().spec(request)
					.post("/heroes");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).isEqualTo("application/json;charset=UTF-8");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['id']").isEqualTo("5");
			assertThatJson(parsedJson).field("['name']").isEqualTo("Vera");
	}

	@Test
	public void validate_addHeroLeah() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json")
					.body("{\"name\":\"Eugenio\"}");

		// when:
			ResponseOptions response = given().spec(request)
					.post("/heroes");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).isEqualTo("application/json;charset=UTF-8");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['id']").isEqualTo("6");
			assertThatJson(parsedJson).field("['name']").isEqualTo("Eugenio");
	}

	@Test
	public void validate_deleteHeroPupa() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json");

		// when:
			ResponseOptions response = given().spec(request)
					.delete("/heroes/1");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
	}

	@Test
	public void validate_deleteHeroUnknown() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json");

		// when:
			ResponseOptions response = given().spec(request)
					.delete("/heroes/120");

		// then:
			assertThat(response.statusCode()).isEqualTo(400);
	}

	@Test
	public void validate_getHeroClara() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json");

		// when:
			ResponseOptions response = given().spec(request)
					.get("/heroes/3");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).isEqualTo("application/json;charset=UTF-8");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['id']").isEqualTo("3");
			assertThatJson(parsedJson).field("['name']").isEqualTo("Mausi");
	}

	@Test
	public void validate_getHeroes() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json");

		// when:
			ResponseOptions response = given().spec(request)
					.get("/heroes");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).isEqualTo("application/json;charset=UTF-8");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo("2");
			assertThatJson(parsedJson).array().contains("['name']").isEqualTo("Mausi");
			assertThatJson(parsedJson).array().contains("['name']").isEqualTo("Nani");
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo("4");
			assertThatJson(parsedJson).array().contains("['name']").isEqualTo("Nico");
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo("5");
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo("3");
			assertThatJson(parsedJson).array().contains("['name']").isEqualTo("Vera");
	}

	@Test
	public void validate_getHeroLeah() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.get("/heroes/2");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).isEqualTo("application/json;charset=UTF-8");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['name']").isEqualTo("Nani");
			assertThatJson(parsedJson).field("['id']").isEqualTo("2");
	}

	@Test
	public void validate_updateHeroClara() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json")
					.body("{\"id\":\"3\",\"name\":\"Clara\"}");

		// when:
			ResponseOptions response = given().spec(request)
					.put("/heroes");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
	}

	@Test
	public void validate_updateHeroLeah() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json")
					.body("{\"id\":\"2\",\"name\":\"Leah\"}");

		// when:
			ResponseOptions response = given().spec(request)
					.post("/heroes");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
	}

}
