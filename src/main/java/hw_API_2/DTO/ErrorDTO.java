package hw_API_2.DTO;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ErrorDTO {
    private int code;
    private int pos;
    private int row;
    private int col;
    private int len;
    private String word;
    private String[] s;

    @Override
    public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof ErrorDTO)) {
                return false;
            }
            ErrorDTO other = (ErrorDTO) o;

            if (this.code != 0 && other.code != 0 && this.code != other.code) return false;
            if (this.pos != 0 && other.pos != 0 && this.pos != other.pos) return false;
            if (this.row != 0 && other.row != 0 && this.row != other.row) return false;
            if (this.col != 0 && other.col != 0 && this.col != other.col) return false;
            if (this.len != 0 && other.len != 0 && this.len != other.len) return false;
            if (this.word != null && other.word != null && !this.word.equals(other.word)) return false;
            if (this.s != null && other.s != null) {
                int minLength = Math.min(this.s.length, other.s.length);
                for (int i = 0; i < minLength; i++) {
                    if (this.s[i].equals(other.s[i])) return false;
                }
            }
            return true;

        }
}
