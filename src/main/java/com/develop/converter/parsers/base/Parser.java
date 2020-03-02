package com.develop.converter.parsers.base;

public interface Parser {
    Object convertFrom(String filePath);
    String convertTo(Object object);
}
