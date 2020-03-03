package com.develop;

import com.develop.converter.parsers.XmlParser;

public class Exmpl {

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader()
                .readFrom("/Users/bobyk/sources/FileConverter/src/main/resources/data.xml", new XmlParser());
        fileReader.saveTo("/Users/bobyk/sources/FileConverter/src/main/resources/data1.xml", new XmlParser());
    }

}
