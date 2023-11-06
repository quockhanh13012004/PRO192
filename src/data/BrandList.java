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
import MeNu.Menu;
import MyUtils.MyUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.lang.*;

//public BrandList();
//public boolean loadFromFile(String);
//public boolean saveToFile(String);
//public int searchID (String ID);
//public Brand getUserChoice();
//public void addBrand();
//public void updateBrand();
//public void listBrands();
public class BrandList extends ArrayList<Brand> {
private ArrayList<Brand> brandList;
    private String brandID, brandName, soundBrand;
    private double price;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<String> brandIDList = new ArrayList<>();

    public BrandList() {
        brandList = new ArrayList<Brand>();
    }
   

   public boolean loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] arr;
            String line = br.readLine();
            while ((line != null)) {
                arr = line.split(",");
                brandID = arr[0].trim();
                brandName = arr[1].trim();
                soundBrand = arr[2].split(":")[0].trim();
                price = Double.parseDouble(arr[2].split(":")[1].trim());
                this.add(new Brand(brandID, brandName, soundBrand, price));
                line = br.readLine();
            }
            br.close();
            return true;
        } catch (IOException e) {
            System.out.println("File " + filename + " not found !");
        }
        return false;
    }
   public boolean saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Brand i : this) {
                pw.println(i);
            }
            pw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


//   
   

  public int searchID(String bID) {
        if (this.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (bID.equals(this.get(i).getBrandID())) {
                return i;
            }
        }
        return -1;
    }
    

    //chuyển list thành 1 menu cho người dùng chọn 1 brand từ đây
    public Brand getUserChoice() {
        Menu mnu = new Menu();
        return (Brand) mnu.ref_getChoice(this);
    }

    public void addBrand() {
        int pos;
        do {
            brandID = MyUtils.getID("Input brand ID: ", " Try again !");
            pos = searchID(brandID);
            if (pos >= 0) {
                System.out.println("This brand ID is existed. Try !");
            }
        } while (pos != -1);

        brandName = MyUtils.getString("Enter brand name: ", " Try again !");
        soundBrand = MyUtils.getString("Enter sound brand: ", " Try again !");
        price = MyUtils.getADouble("Enter price: ", "The price > 0. Try again !", 0);
        this.add(new Brand(brandID, brandName, soundBrand, price));
        System.out.println("Brand  add successfully");
    }
//     

//
    public void updateBrand() {
        brandID = MyUtils.getID("Input brand ID: ", " Try again !");
        int pos = searchID(brandID);
        if (pos == -1) {
            System.out.println("Not found !");
        } else {
            Brand x = this.get(pos);
            System.out.println(" Brand before updating");
            x.toString();
            brandName = MyUtils.getString("Enter brand name: ", " Try again !");
            soundBrand = MyUtils.getString("Enter sound brand: ", " Try again !");
            price = MyUtils.getADouble("Enter price: ", "The price > 0. Try again !", 0);
            x.setBrandName(brandName);
            x.setSoundBrand(soundBrand);
            x.setPrice(price);
            System.out.println("Brand update successfully !");
        }
    }
//     

    public void listBrands() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
    }
   

}