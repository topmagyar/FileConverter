package com.develop.converter.parsers;

import com.develop.converter.entity.Car;
import com.develop.converter.parsers.base.Parser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser implements Parser {

    public List<Car> convertFrom(String filePath) {
        List<Car> cars = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("employees.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;
            employeeList.forEach( car -> {
                Car carObject = parseCarObject( (JSONObject) car );
                cars.add(carObject);
            } );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cars;
    }

    @Override
    public void convertTo(String filePath, List<Car> cars) throws Exception {
        JSONArray carJsonList = new JSONArray();
        for (Car car : cars) {
            JSONObject carJsonDetails = new JSONObject();
            carJsonDetails.put("date", car.getDate());
            carJsonDetails.put("brandName", car.getBrandName());
            carJsonDetails.put("price", car.getPrice());

            JSONObject carJsonObject = new JSONObject();
            carJsonObject.put("car", carJsonDetails);

            carJsonList.add(carJsonObject);
        }
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(carJsonList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Car parseCarObject(JSONObject car) {
        JSONObject carObject = (JSONObject) car.get("car");
        String date = (String) carObject.get("date");
        String brandName = (String) carObject.get("brandName");
        String price = (String) carObject.get("price");
        return new Car(date, brandName, price);
    }

}
