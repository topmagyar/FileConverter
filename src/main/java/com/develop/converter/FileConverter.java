package com.develop.converter;

import com.develop.converter.parsers.base.Parser;

public class FileConverter {

    private Parser parseFrom;
    private Parser parseTo;

    public FileConverter setParseFrom(Parser parseFrom) {
        this.parseFrom = parseFrom;
        return this;
    }

    public FileConverter setParseTo(Parser parseTo) {
        this.parseTo = parseTo;
        return this;
    }

    public Parser getParseFrom() {
        return parseFrom;
    }

    public Parser getParseTo() {
        return parseTo;
    }

    public String convert() {
        Parser fromParser = getParseFrom();
        Parser toParser = getParseTo();
        return toParser.convertTo(fromParser.convertFrom("filePath"));
    }
}
