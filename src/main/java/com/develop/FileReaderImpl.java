package com.develop;

import com.develop.converter.entity.Car;
import com.develop.converter.parsers.BinaryFileParser;
import com.develop.converter.parsers.JsonParser;
import com.develop.converter.parsers.XmlParser;
import com.develop.converter.parsers.base.Parser;
import com.develop.converter.utils.Utils;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileReaderImpl implements FileReader {

    private String filePathFrom;
    private Parser parserFrom;
    private List<Car> cars = new ArrayList<>();
    private List<Parser> supportedParsers = new ArrayList<>();

    public FileReaderImpl() {
        supportedParsers.add(new XmlParser());
        supportedParsers.add(new JsonParser());
        supportedParsers.add(new BinaryFileParser());
    }

    public FileReaderImpl addParser(Parser parser) {
        supportedParsers.add(parser);
        return this;
    }

    public FileReaderImpl addEntity(String date, String brandName, Integer price) throws ParseException {
        Car car = new Car(Utils.convertStringToDate(date), brandName, price);
        cars.add(car);
        return this;
    }

    public FileReaderImpl addEntity(Date date, String brandName, Integer price) {
        Car car = new Car(date, brandName, price);
        cars.add(car);
        return this;
    }

    public FileReaderImpl readFrom(String filePath, String parserType) throws Exception {
        Parser parserFrom = getParser(parserType);
        parserFrom.convertFrom(filePath);
        return this;
    }

    public FileReaderImpl readFrom(String filePath, Parser parserFrom) throws Exception {
        this.parserFrom = parserFrom;
        cars = parserFrom.convertFrom(filePath);
        return this;
    }

    public FileReaderImpl save() throws Exception {
        this.parserFrom.convertTo(this.filePathFrom, this.cars);
        return this;
    }

    public void saveTo(String filePath, String parserType) throws Exception {
        Parser parserTo = getParser(parserType);
        parserTo.convertTo(filePath, cars);
    }

    public void saveTo(String filePath, Parser parserTo) throws Exception {
        new File(filePath).createNewFile();
        parserTo.convertTo(filePath, cars);
    }

    private Parser getParser(String parserType) {
        return supportedParsers.stream().filter(parser -> parser.getParserId().equals(parserType)).findFirst().get();
    }

    public List<Car> getFileData() {
        return cars;
    }

    @Override
    public FileReader removeFirstEntity() {
        getFileData().remove(0);
        return this;
    }

    @Override
    public FileReader removeLastEntity() {
        getFileData().remove(getFileData().size() - 1);
        return this;
    }

    @Override
    public FileReader removeEntity(int itemIndex) {
        getFileData().remove(itemIndex);
        return this;
    }

    @Override
    public FileReader uploadData(List<Car> cars) {
        this.cars = cars;
        return this;
    }
}
