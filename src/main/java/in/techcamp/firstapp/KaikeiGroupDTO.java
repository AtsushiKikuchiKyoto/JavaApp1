package in.techcamp.firstapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KaikeiGroupDTO {
    private long id;
    private String name;
    private String info;
}
