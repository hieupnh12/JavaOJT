
package com.ojt.testjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lecture {
    private int lecture_id;
    private String name;
    private String email;
    private String department;

    public Lecture(String name, String email, String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }
    
    
}
