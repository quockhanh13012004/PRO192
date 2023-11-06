/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MeNu;

/**
 *
 * @author 84362
 */
import MyUtils.MyUtils;
import data.Brand;
import java.util.*;
import java.lang.*;

public class Menu {

    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();

    
    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public Menu() {
        
    }

    // Phương thức này dùng để bổ sung một lựa chọn mới vào danh sách menu
//     Nó nhận vào một chuỗi newOption và thêm nó vào danh sách optionList.
    public void addNewOption(String newOption) {
//         kiểm tra coi option đưa vào có trùng với option sẵn có hay ko?
//        
//        //nếu ko trùng, add vào danh sách lựa chọn
        optionList.add(newOption);
    }

//     Phương thức này được sử dụng để in ra danh sách các lựa chọn trong menu.
//     Nếu danh sách trống, nó sẽ thông báo rằng không có mục nào trong menu. 
//    Nếu có lựa chọn, nó sẽ in tên menu và liệt kê các lựa chọn.
    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There is no item in the menu");
            return;
        }
        System.out.println("\n------------------------------------");
        System.out.println("Welcome to " + menuTitle);
        for (String x : optionList) {
            System.out.println(x);
        }
    }

    //có menu mới có lựa chọn. Hàm trả về con số người dùng chọn
    //dùng để lấy lựa chọn của người dùng trong dạng số nguyên. 
    public int int_getChoice() {
//        số lựa chọn tối đa trong danh sách optionList bằng cách sử dụng phương thức size() của ArrayList
        int maxOption = optionList.size();
        //lựa chọn lớn nhất là số thứ tự ứng với số mục chọn
        String inputMsg = " choose option 1-->" + maxOption + " ";
        String errorMsg = "You must choose option 1-->" + maxOption;
        return MyUtils.getAnInteger(inputMsg, errorMsg, 1, maxOption);
    }
    
    //lấy lựa chọn của người dùng nhưng là cac doi tuong Brand trong brandList
        public Brand ref_getChoice(ArrayList<Brand> options) {
//            số lựa chọn tối đa trong danh sách options (danh sách các đối tượng Brand). 
            int maxOption = options.size();
            int response;
            System.out.println("Brand ID list:");
            do {
//                 Phương thức int_getChoice hiển thị danh sách lựa chọn từ danh sách options và trả về số mà người dùng chọn.
                response = int_getChoice(options);
            } while (response < 0 || response > maxOption);
            return options.get(response - 1);
//            Vòng lặp sẽ tiếp tục chạy cho đến khi người dùng chọn một số hợp lệ nằm trong khoảng từ 1 đến maxOption.
        }
// lấy lựa chọn của người dùng từ danh sách các đối tượng Brand
    private int int_getChoice(ArrayList<Brand> options) {
        int maxOption = options.size();
        int response;
        for (int i = 0; i < maxOption; i++) {
            System.out.println("" + (i + 1) + ". " + options.get(i));
        }
        String inputMsg = "Please choose an option [1-->" + maxOption + "]: ";
        String errorMsg = "You must choose an option 1-->" + maxOption;
        response = MyUtils.getAnInteger(inputMsg, errorMsg, 1, maxOption);
        return response;
    }

    
   
}

