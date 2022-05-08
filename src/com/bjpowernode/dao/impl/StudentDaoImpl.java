package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student getById(String id) {
        SqlSession session = SqlSessionUtil.getSession();
        Student s = session.selectOne("test01.getById",id);
        return s;
    }

    @Override
    public void save(Student s) {
        SqlSession session = SqlSessionUtil.getSession();
        session.insert("test01.save",s);
    }



//    public static void main(String[] args) {
//        StudentDaoImpl impl = new StudentDaoImpl();
//        Student s = impl.getById("A0001");
//        System.out.println(s);
//    }
}
