package main.java.annotation;

import main.mybatis.Student;
import main.mybatis.annotation.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        //For adding Mapper
        session.getConfiguration().addMapper(StudentMapper.class);

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student student = (Student) session.selectOne("Student.callById", 9);

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
        //Create a new student object
       // Student student = new Student();

        //Set the values
        /*student.setName("zara");
        student.setBranch("EEE");
        student.setEmail("zara@gmail.com");
        student.setPercentage(90);
        student.setPhone(123412341);

        //Insert student data
      //  mapper.insert(student);
        //System.out.println("record inserted successfully");

         */

        //select a particular student using id
       /* Student student = mapper.getById(9);
        System.out.println("Current details of the student are "+student.toString());

        //Set new values to the mail and phone number of the student
        student.setEmail("Shyam123@yahoo.com");
        student.setPhone(984802233);

        //Update the student record
        mapper.update(student);
        System.out.println("Record updated successfully");

        */
        /*
        //Get the student details
        Student student = mapper.getById(9);
        System.out.println(student.getBranch());
        System.out.println(student.getEmail());
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getPercentage());
        System.out.println(student.getPhone());
*/

      //  mapper.delete(10);

 /*       System.out.println("record deleted successfully");
        session.commit();
        session.close();

  */
    }
}
