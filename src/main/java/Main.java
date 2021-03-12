package main.java;

import com.mysql.cj.Session;
import main.mybatis.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //select a particular student  by  id
        Student student = (Student) session.selectOne("main.mybatis.Student.callById", 9);

        //Print the student details
        System.out.println("Details of the student are:: ");
        System.out.println("Id :"+student.getId());
        System.out.println("Name :"+student.getName());
        System.out.println("Branch :"+student.getBranch());
        System.out.println("Percentage :"+student.getPercentage());
        System.out.println("Email :"+student.getEmail());
        System.out.println("Phone :"+student.getPhone());
        session.commit();
        session.close();
        /*Student student=new Student();
        student.setId(9);
        student.setName("Elnady");
        student.setEmail("elnady@gmail.com");
        student.setBranch("Zagazig");
        student.setPercentage(3);
        student.setPhone(33);
         */
       /* Reader reader = Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        //Insert student data
       /* session.insert("main.mybatis.Student.insert", student);
        System.out.println("record inserted successfully");


        //Update Data
        session.update("main.mybatis.Student.update",student);
        System.out.println("record Updated successfully");

        //Delete Data
        //Delete By id
        session.delete("main.mybatis.Student.deleteById",11);
        System.out.println("record Deleted successfully");


        //Select all Data
        List<Student> students=session.selectList("main.mybatis.Student.getAllStudent");
        students.forEach(s-> System.out.println(s));

        */
         //select data
        // Student result=session.selectOne("main.mybatis.Student.getById", 9);
        //select a particular student  by  id
      /*  Student student = (Student) session.selectOne("main.mybatis.Student.getRecByName_Id", "Shimaa");

        //Print the student details
        System.out.println("Details of the student are:: ");
        System.out.println("Id :"+student.getId());
        System.out.println("Name :"+student.getName());
        System.out.println("Branch :"+student.getBranch());
        System.out.println("Percentage :"+student.getPercentage());
        System.out.println("Email :"+student.getEmail());
        System.out.println("Phone :"+student.getPhone());


        session.commit();
        session.close();

       */
    }
}
