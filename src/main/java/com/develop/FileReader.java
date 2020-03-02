package com.develop;

import com.develop.converter.FileConverter;
import com.develop.converter.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private String filePath;
    private List<Car> cars = new ArrayList<Car>();
    private FileConverter converter;

    public FileReader(FileConverter converter) {
        this.converter = converter;
    }

    public void addEntity(String date, String brandName, String price) {
        Car car = new Car(date, brandName, price);
        cars.add(car);
    }

    public void editFile() {

    }

    public List<Car> readEntities(String filePath) {

    }

    public String save() {

    }

    public FileReader setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }
}
