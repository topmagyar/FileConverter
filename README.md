FileConverter library was developed for converting special object "Car" between different file types. Also user can change files content using this library.

Library contains main FileReader interface and FileReaderImpl class as the implementation.
Supported parsers localed into "parsers" folder. 
Library supports 3 types of files: 
- xml
- json
- binary

FileReader interface contains next opened methods for user:
- addParser(Parser): user can add his own parser for some special type of file. User just have to implement "Parser" interface and develop all methods from it;
- readFrom(String filepath, Parser): method for reading file with specified parser object;
- readFrom(String filepath, String parserType): method for reading file with specified parser type;
- save(): method for saving current data state;
- saveTo(String filepath, String parserType): method for saving current data state into specified file with specified parser type;
- saveTo(String filepath, Parser): method for saving current data state into specified file with specified parser object;
- addEntity(Car): method for adding new entity to end of file data;
- getFileData(): return all Car entities from data file;
- removeFirstEntity(): remove first Car entity from data file;
- removeLastEntity(): remove last Car entity from data file;
- removeEntity(int itemIndex): remove Car entity by item number from data file;
- uploadData(List<Car> cars): upload data for file;  

Future development:
- supporting different types(not just Car object);
- supporting more types of files;
- multithreading(working with several files);
- 100% of code coverage;
- custom exceptions for different cases;