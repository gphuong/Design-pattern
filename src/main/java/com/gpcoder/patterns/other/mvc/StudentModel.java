package com.gpcoder.patterns.other.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StudentModel {
    private Integer id;
    private String name;
    private LocalDate updatedDate;

    public boolean save() {
        if (name.length() <= 10) {
            this.updatedDate = LocalDate.now();
            return true;
        }
        return false;
    }
}
