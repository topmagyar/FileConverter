package com.develop.usage.example;

import com.develop.FileReaderImpl;
import com.develop.converter.parsers.XmlParser;

public class UsageExample {

    public static void main(String[] args) throws Exception {
        new FileReaderImpl()
                .readFrom("path/to/file", new XmlParser()) //read data from file
                .addEntity("10.02.2010","Audi", 123123) //adding new Car object
                .saveTo("path/to/destination/file", new CustomParser()); //using custom parser
    }
}
