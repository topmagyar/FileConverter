package com.develop.usage.example;

import com.develop.converter.entity.Car;
import com.develop.converter.parsers.base.Parser;

import java.util.List;

public class CustomParser implements Parser {

    @Override
    public List<Car> convertFrom(String filePath) throws Exception {
        //develop parser for converting from specified file
        return null;
    }

    @Override
    public void convertTo(String filePath, List<Car> cars) throws Exception {
        //develop parser for converting to specified file
    }

    @Override
    public String getParserId() {
        //return specified parser id
        return null;
    }
}
