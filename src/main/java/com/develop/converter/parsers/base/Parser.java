package com.develop.converter.parsers.base;

import com.develop.converter.entity.Car;

import java.util.List;

public interface Parser {
    List<Car> convertFrom(String filePath) throws Exception;
    void convertTo(String filePath, List<Car> object) throws Exception;
}
