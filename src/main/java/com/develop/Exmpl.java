package com.develop;

import com.develop.converter.parsers.BinaryFileParser;
import com.develop.converter.parsers.JsonParser;
import com.develop.converter.parsers.XmlParser;

public class Exmpl {

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader()
                .readFrom("/Users/bobyk/sources/FileConverter/src/main/resources/data.xml", new XmlParser());
//        fileReader.addEntity("21.07.2010", "Opel", "12000");
        fileReader.saveTo("/Users/bobyk/sources/FileConverter/src/main/resources/data1.dat", new BinaryFileParser());
    }

}
