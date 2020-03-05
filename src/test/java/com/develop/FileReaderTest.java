package com.develop;

import com.develop.converter.parsers.BinaryFileParser;
import com.develop.converter.parsers.JsonParser;
import com.develop.converter.parsers.XmlParser;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    private ClassLoader classLoader = getClass().getClassLoader();

    @Test
    public void convertFromXmlToBinaryTest() throws Exception {
        URL xmlResource = getResource("data.xml");
        URL binaryResource = getResource("data.dat");
        FileReader fileReader = new FileReaderImpl()
                .readFrom(xmlResource.getPath(), new XmlParser());
        fileReader.saveTo(binaryResource.getPath(), new BinaryFileParser());
        assertEquals(4, fileReader.getFileData().size());
        fileReader.readFrom(binaryResource.getPath(), new BinaryFileParser());
        fileReader.addEntity("01.02.2020","Nissan",12312);
        assertEquals(5, fileReader.getFileData().size());
    }

    @Test
    public void convertFromXmlToJsonTest() throws Exception {
        URL xmlResource = getResource("data.xml");
        URL binaryResource = getResource("data.json");
        FileReader fileReader = new FileReaderImpl()
                .readFrom(xmlResource.getPath(), new XmlParser());
        fileReader.saveTo(binaryResource.getPath(), new JsonParser());
        assertEquals(4, fileReader.getFileData().size());
        fileReader.readFrom(binaryResource.getPath(), new JsonParser());
        fileReader.addEntity("01.02.2020","Nissan",12312);
        assertEquals(5, fileReader.getFileData().size());
    }

    @Test
    public void convertFromBinaryToXmlTest() throws Exception {
        URL xmlResource = getResource("data.dat");
        URL binaryResource = getResource("data.xml");
        FileReader fileReader = new FileReaderImpl()
                .readFrom(xmlResource.getPath(), new BinaryFileParser());
        fileReader.saveTo(binaryResource.getPath(), new XmlParser());
        assertEquals(4, fileReader.getFileData().size());
        fileReader.readFrom(binaryResource.getPath(), new XmlParser());
        fileReader.addEntity("01.02.2020","Nissan",12312);
        assertEquals(5, fileReader.getFileData().size());
    }

    @Test
    public void convertFromJsonToXmlTest() throws Exception {
        URL xmlResource = getResource("data.json");
        URL binaryResource = getResource("data.xml");
        FileReader fileReader = new FileReaderImpl()
                .readFrom(xmlResource.getPath(), new JsonParser());
        fileReader.saveTo(binaryResource.getPath(), new XmlParser());
        assertEquals(4, fileReader.getFileData().size());
        fileReader.readFrom(binaryResource.getPath(), new XmlParser());
        fileReader.addEntity("01.02.2020","Nissan",12312);
        assertEquals(5, fileReader.getFileData().size());
    }

    @Test
    public void convertFromBinaryToJsonTest() throws Exception {
        URL xmlResource = getResource("data.dat");
        URL binaryResource = getResource("data.json");
        FileReader fileReader = new FileReaderImpl()
                .readFrom(xmlResource.getPath(), new BinaryFileParser());
        fileReader.saveTo(binaryResource.getPath(), new JsonParser());
        assertEquals(4, fileReader.getFileData().size());
        fileReader.readFrom(binaryResource.getPath(), new JsonParser());
        fileReader.addEntity("01.02.2020","Nissan",12312);
        assertEquals(5, fileReader.getFileData().size());
    }

    @Test
    public void convertFromJsonToBinaryTest() throws Exception {
        URL xmlResource = getResource("data.json");
        URL binaryResource = getResource("data.dat");
        FileReader fileReader = new FileReaderImpl()
                .readFrom(xmlResource.getPath(), new JsonParser());
        fileReader.saveTo(binaryResource.getPath(), new BinaryFileParser());
        assertEquals(4, fileReader.getFileData().size());
        fileReader.readFrom(binaryResource.getPath(), new BinaryFileParser());
        fileReader.addEntity("01.02.2020","Nissan",12312);
        assertEquals(5, fileReader.getFileData().size());
    }

    private URL getResource(String filename) {
        return classLoader.getResource(filename);
    }

}
