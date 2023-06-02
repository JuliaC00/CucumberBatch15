package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HardCodedExamples {

    String baseURI=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ5NzI3NzUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTAxNTk3NSwidXNlcklkIjoiNTM5OCJ9.Ac4agvyw-eRhWD7W9eXywezKa5My4CNJRhGZfFxsu8I";
    static String employee_id;


    @Test
    public void createEmployee(){
        //prepare the request
        RequestSpecification preparedRequest= given().
                header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "  \"emp_firstname\": \"Julia\",\n" +
                        "  \"emp_lastname\": \"Cherviakova\",\n" +
                        "  \"emp_middle_name\": \"A\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2000-06-07\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"Mechanical Engineer\"\n" +
                        "}");
        //hitting the endpoint/send the request
        Response response=preparedRequest.when().post("/createEmployee.php");
        //it will print the output in the console
        response.prettyPrint();

        //verifying the assertion
        response.then().assertThat().statusCode(201);

        //we are capturing employee id fromm the response
        employee_id=response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

      response.then().assertThat().
           body("Employee.emp_firstname", equalTo("Julia"));
        response.then().assertThat().
                body("Employee.emp_lastname", equalTo("Cherviakova"));


        //verify the response header
        response.then().assertThat().header("Content-Type","application/json");
        System.out.println("My test case is passed");

    }

    @Test
    public void getCreatedEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        // hitting the endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        // verify the response
        response.then().assertThat().statusCode(200);
        String tempEmpId=response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(employee_id, tempEmpId);
    }

    public void updateEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization", token).body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"visnja\",\n" +
                        "  \"emp_lastname\": \"hasmik\",\n" +
                        "  \"emp_middle_name\": \"msa\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2003-05-20\",\n" +
                        "  \"emp_status\": \"probation\",\n" +
                        "  \"emp_job_title\": \"CEO\"\n" +
                        "}");

        //hitting the endpoint
        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);
        //for verification
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));
    }

    public void getUpdaredEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response=preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        //if you want tot verify the body of the response.
        //you can do that using hamcrest matchers
}
}
