package main.mybatis;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
@ToString
public class Student {
    private int id;
    private String name;
    private String branch;
    private int percentage;
    private int phone;

   /* public Student(String name, String branch, int percentage, int phone, String email) {
        this.name = name;
        this.branch = branch;
        this.percentage = percentage;
        this.phone = phone;
        this.email = email;
    }

    */

    private String email;
}
