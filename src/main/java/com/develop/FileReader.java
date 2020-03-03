package com.develop;

import com.develop.converter.FileConverter;
import com.develop.converter.entity.Car;
import com.develop.converter.parsers.base.Parser;

import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private String filePath;
    private List<Car> cars = new ArrayList<Car>();
    private FileConverter converter = new FileConverter();

    public FileReader() {
    }

    public FileReader addEntity(String date, String brandName, String price) {
        Car car = new Car(date, brandName, price);
        cars.add(car);
        return this;
    }

    public FileReader readFrom(String filePath, String parserType) {
        return this;
    }

    public FileReader readFrom(String filePath, Parser parserFrom) throws Exception {
        cars = parserFrom.convertFrom(filePath);
        return this;
    }

    public void editFile() {

    }

//    public List<Car> readEntities() {
//    }

    public FileReader save() {
        return this;
    }

    public void saveTo(String filePath, String parserType) {

    }

    public void saveTo(String filePath, Parser parserTo) throws Exception {
        parserTo.convertTo(filePath, cars);
    }

    public FileReader setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }
}
