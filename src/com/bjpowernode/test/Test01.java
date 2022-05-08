package com.bjpowernode.test;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.util.ServiceFactory;

public class Test01 {
    public static void main(String[] args) {
        Student s = new Student();
        s.setId("A0006");
        s.setName("cxk");
        s.setAge(23);
        // 测试添加操作
        StudentService ss1 = new StudentServiceImpl();
        StudentService ss2 = (StudentService) ServiceFactory.getService(ss1);
//        ss2.save(s);

        Student s2 = ss2.getById("A0002");
        System.out.println(s2);
    }
}
