package com.develop.converter.parsers;

import com.develop.converter.entity.Car;
import com.develop.converter.parsers.base.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileParser implements Parser {

    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public List<Car> convertFrom(String filePath) throws Exception {
        dataInputStream = new DataInputStream(new FileInputStream(filePath));
        List<Car> cars = new ArrayList<>();
        try {
            while (true) {
                int size = dataInputStream.readInt();
                while (size > 0) {
                    String date = dataInputStream.readUTF();
                    String brandName = dataInputStream.readUTF();
                    String price = dataInputStream.readUTF();
                    cars.add(new Car(date, brandName, price));
                    size--;
                }
            }
        } catch (EOFException e) {
            //reach end of file
        } finally {
            dataInputStream.close();
        }
        return cars;
    }

    @Override
    public void convertTo(String filePath, List<Car> cars) throws Exception {
        dataOutputStream = new DataOutputStream(new FileOutputStream(filePath));
        dataOutputStream.writeInt(cars.size());
        for (Car car : cars) {
            write(car);
        }
        save();
    }

    private void write(Car car) throws IOException {
        dataOutputStream.writeUTF(car.getDate());
        dataOutputStream.writeUTF(car.getBrandName());
        dataOutputStream.writeUTF(car.getPrice());
    }

    private void save() throws IOException {
        dataOutputStream.close();
    }

}
