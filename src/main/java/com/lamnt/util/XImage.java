/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.util;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class XImage {
     public static Image getAppIcon(){ // xử lý hình ảnh
        URL url = XImage.class.getResource("/com/lamnt/icons/sach.png");
        return new ImageIcon(url).getImage();
    }
     /**
     * Sao chép file logo chuyên đề vào thư mục logo
     * @param src là đối tượng file ảnh
     */  
    // đưa một file vào, người ta sẽ copy cái field đó vào một thư mục nào đó để cất
    public static void save(File src){// lưu file vào thư mục có tên logos
        File dst = new File("src\\main\\resources\\com\\lamnt\\icons", src.getName());// tạo đối tượng file trỏ tới thư mục logos và lấy tên file người ta đưa vô
        if(!dst.getParentFile().exists()){// kiểm tra thư mục logos có tồn tại hay chưa
            dst.getParentFile().mkdirs();// nếu chưa tồn tại thì phải tạo thư mục đó ra rồi mới lưu file người ta đưa vô đó
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);// copy file vào thư mục logos (nếu file tồn tại rồi thì thay thế luôn)
   
        } 
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public static ImageIcon read(String fileName){// đưa cho tôi tên file và tôi sẽ đưa cho anh hình ảnh
        File path = new File("src\\main\\resources\\com\\lamnt\\icons",fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
