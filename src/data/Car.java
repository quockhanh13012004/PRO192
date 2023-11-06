/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author 84362
 */
import java.util.*;
import java.lang.*;

public class Car implements Comparable<Car> {
    private String carID, color, frameID, engineID;
    public Brand brand;

    public Car() {
    }

    public Car(String carID, String color, String frameID, String engineID, Brand brand) {
        this.carID = carID;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
        this.brand = brand;
    }

    public String getCarID() {
        return carID;
    }

    public String getColor() {
        return color;
    }

    public String getFrameID() {
        return frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public int compareTo(Car car) {
        int d = this.getBrand().getBrandName().compareTo(car.getBrand().getBrandName());
        if(d==0){
            d = this.getCarID().compareTo(car.getCarID());
        }
        return d;
    }

    @Override
    public String toString() {
       return "<" + carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID + ">";
    }
public String screenString () {
        return brand + "\n" + carID + ", " + color + ", " + frameID + ", " + engineID;
    }
    
}
