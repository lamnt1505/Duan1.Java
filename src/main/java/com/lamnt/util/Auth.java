/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.util;

import com.lamnt.entity.NguoiDung;

/**
 *
 * @author DELL
 */
public class Auth {
    public static NguoiDung user = null;// duy trì user đăng nhập vào hệ thống
    public static void clear(){// xóa bỏ user đã đăng nhập (khi đăng xuất sẽ xóa)
        Auth.user = null;
    }
    public static boolean isLogin(){// kiểm tra người ta đăng nhập hay chưa
        return Auth.user != null;   
    }
    public static boolean isManager(){// kiểm tra phải trưởng phòng hay không
        return Auth.isLogin()&& user.getVaiTro();
    }
    
}
