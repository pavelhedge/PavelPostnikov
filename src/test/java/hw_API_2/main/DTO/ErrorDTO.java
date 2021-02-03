package hw_API_2.main.DTO;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ErrorDTO {
    private int code;
    private int pos;
    private int row;
    private int col;
    private int len;
    private String word;
    private String[] s;
}
