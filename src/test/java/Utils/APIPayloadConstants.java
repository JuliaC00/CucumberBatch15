package Utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;

public class APIPayloadConstants {
    public static String createEmployeePayload(){
        String createEmployeePayload="{\n" +
                "  \"emp_firstname\": \"Julia\",\n" +
                "  \"emp_lastname\": \"Cherviakova\",\n" +
                "  \"emp_middle_name\": \"A\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2000-06-07\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"Mechanical Engineer\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeePayloadJson(){
        JSONObject object=new JSONObject();
        object.put("emp_firstname", "Julia");
        object.put("emp_lastname","Cherviakova");
        object.put("emp_middle_name", "A");
        object.put("emp_birthday", "2000-06-07");
        object.put("emp_status", "Confirmed");
        object.put("emp_job_title", "Mechanical Engineer");
        return object.toString();
    }


    public static String createEmployeePayloadDynamic
            (String emp_firstname, String emp_lastname,
             String emp_middle_name, String emp_gender, String emp_birthday,
             String emp_status, String emp_job_title){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();
    }
    public static String updateEmployeePayloadJson(){
        JSONObject object=new JSONObject();
        object.put("emp_firstname", "Gulia");
        object.put("emp_lastname","Svetlakova");
        object.put("emp_middle_name", "A");
        object.put("emp_birthday", "1987-06-09");
        object.put("emp_status", "Confirmed");
        object.put("emp_job_title", "QA");
        return object.toString();
    }
}
