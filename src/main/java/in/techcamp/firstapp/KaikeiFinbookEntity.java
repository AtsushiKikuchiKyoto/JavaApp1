package in.techcamp.firstapp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class KaikeiFinbookEntity {
    private long id;
    private String name;
    private int fiscalYear;
    private LocalDate startDate;
    private LocalDate endDate;
    private long groupId;
}
