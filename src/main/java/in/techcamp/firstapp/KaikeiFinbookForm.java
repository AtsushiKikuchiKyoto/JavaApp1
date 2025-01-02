package in.techcamp.firstapp;

import lombok.Data;

import java.time.LocalDate;

@Data
public class KaikeiFinbookForm {
    private String name;
    private int fiscalYear;
    private LocalDate startDate;
    private LocalDate endDate;
    private long groupId;
}
