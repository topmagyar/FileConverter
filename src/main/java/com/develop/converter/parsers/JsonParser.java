package com.develop.converter.parsers;

import com.develop.converter.entity.Car;
import com.develop.converter.parsers.base.Parser;
import com.develop.converter.utils.Utils;
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
        try (FileReader reader = new FileReader(filePath))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;
            employeeList.forEach( car -> {
                Car carObject = null;
                try {
                    carObject = parseCarObject( (JSONObject) car );
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
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
    public void convertTo(String filePath, List<Car> cars) {
        JSONArray carJsonList = new JSONArray();
        for (Car car : cars) {
            JSONObject carJsonDetails = new JSONObject();
            carJsonDetails.put("date", Utils.convertDateToString(car.getDate()));
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

    @Override
    public String getParserId() {
        return ParserType.JSON.name();
    }

    private Car parseCarObject(JSONObject car) throws java.text.ParseException {
        JSONObject carObject = (JSONObject) car.get("car");
        String date = (String) carObject.get("date");
        String brandName = (String) carObject.get("brandName");
        int price = ((Long)(carObject.get("price"))).intValue();
        return new Car(Utils.convertStringToDate(date), brandName, price);
    }

}
