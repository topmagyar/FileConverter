package com.develop;

import com.develop.converter.entity.Car;
import com.develop.converter.parsers.base.Parser;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface FileReader {

    FileReader addParser(Parser parser);

    FileReader readFrom(String filePath, String parserType) throws Exception;

    FileReader readFrom(String filePath, Parser parserFrom) throws Exception;

    FileReader save() throws Exception;

    void saveTo(String filePath, String parserType) throws Exception;

    void saveTo(String filePath, Parser parserTo) throws Exception;

    FileReader addEntity(String date, String brandName, Integer price) throws ParseException;

    FileReader addEntity(Date date, String brandName, Integer price);

    List<Car> getFileData();

    FileReader removeFirstEntity();

    FileReader removeLastEntity();

    FileReader removeEntity(int itemIndex);

    FileReader uploadData(List<Car> cars);
}
