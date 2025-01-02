package in.techcamp.firstapp;

import lombok.Data;

import java.time.LocalDate;

@Data
public class KaikeiFinbookForm {
    private String name;
    private long fiscalYear;
    private LocalDate startDate;
    private LocalDate endDate;
    private long groupId;
}
