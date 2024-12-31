package in.techcamp.firstapp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KaikeiGroupEntity {
    private long id;
    private String name;
    private String info;
}
