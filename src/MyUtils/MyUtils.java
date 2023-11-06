/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyUtils;

/**
 *
 * @author 84362
 */
import java.util.*;
import java.lang.*;

public class MyUtils {
private static Scanner sc = new Scanner(System.in);

//    phương thức để nhập và trả về một số nguyên từ người dùng.
    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
//phương thức để nhập và trả về một số nguyên từ người dùng với giới hạn
//        lowerBound và upperBound để xác định khoảng giới hạn cho số nguyên.
    public static int getAnInteger(String inputMsg, String errorMsg, int lower, int upper) {
        int n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        if (lower > upper) {
            tmp = lower;
            lower = upper;
            upper = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
//                Kiểm tra xem giá trị số nguyên n có nằm trong khoảng giới hạn(lower va uper hay ko)
//                Nếu không, chúng ta ném một ngoại lệ để báo lỗi và vòng lặp tiếp tục để yêu cầu người dùng nhập lại.
                if (n < lower || n > upper) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    //nhập vào 1 số thực, găn chặn mọi trường hợp nhập không hợp lệ.
    public static double getADouble(String inputMsg, String errorMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg, double lower, double upper) {
        double n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        if (lower > upper) {
            tmp = lower;
            lower = upper;
            upper = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lower || n > upper) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static double getADouble(String inputMsg, String errorMsg, double lower) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lower) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

//   Phương thức này được sử dụng để yêu cầu người dùng nhập một chuỗi ký tự theo một định dạng cụ thể, sử dụng biểu thức chính quy (Regular Expression).
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
//            Kiểm tra xem chuỗi id có rỗng (độ dài bằng 0), có chứa khoảng trắng hoặc không phù hợp với định dạng format.
//            Nếu bất kỳ điều kiện nào đều đúng, thông báo lỗi (errorMsg) sẽ được in ra và vòng lặp tiếp tục để yêu cầu người dùng nhập lại.
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;  
            }
        }
    }
    
    public static String getID(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
//            kiểm tra xem chuỗi id có rỗng (độ dài bằng 0) hoặc chứa khoảng trắng hay không. 
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }
    
//    Phương thức này được sử dụng để yêu cầu người dùng nhập một chuỗi ký tự, và nó đảm bảo rằng chuỗi không được rỗng.
    public static String getString(String inputMsg, String errorMsg) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return str;
            }
        }
    }
     
        
}
