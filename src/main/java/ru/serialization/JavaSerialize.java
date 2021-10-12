package ru.serialization;

import ru.serialization.model.Car;

import java.io.*;

public class JavaSerialize {
    public static void main(String[] args) {
        String path = "src\\main\\resources\\car.txt";
        try (
                ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(path));
                ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path))
                ) {
            Car car = new Car();
            car.setModel("Car model");
            car.setCarName("Car name");
            car.setAge(10);
            oo.writeObject(car);

            Object fromDeser = oi.readObject();
            if(fromDeser.getClass() == Car.class) {
                Car carFromDeser = (Car) fromDeser;
                System.out.println(carFromDeser);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
