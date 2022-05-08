package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        Student s =  session.selectOne("test01.getById","A0001");
        System.out.println("选出的s==" + s);
        int[] o = new int[5];
        System.out.println(o[0]);
        System.out.println(o[1]);
        System.out.println(o[2]);
        System.out.println(o[3]);
        System.out.println(o[4]);
        System.out.println(o[5]);
        InputStream in = Resources.getResourceAsStream("ad");

//        List<Student> studentList= session.selectList("test01.getById");
//        System.out.println(studentList.get(0));


        Student s2 = new Student();

        //   插入操作
//        s2.setId("A0006");
//        s2.setName("cxk");
//        s2.setAge(23);
//        session.insert("test01.save",s2);

        // 修改操作
//        s2.setId("A0006");
//        s2.setName("cxk2");
//        s2.setAge(25);
//        session.update("test01.update",s2);

//        s2.setId("A0006");
//        session.delete("test01.delete",s2);



        session.commit();
        session.close();


    }
}
