package in.techcamp.firstapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KaikeiGroupDTO {
    private Long id;
    private String name;
    private String info;
}
