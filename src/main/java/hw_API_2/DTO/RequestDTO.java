package hw_API_2.DTO;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hw_API_2.DTO.subentities.Options;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class RequestDTO {
    private String text;
    private String lang;
    private int options;
    private String format;

    public RequestDTO(String text, Options...options){
        setOptions(options);
        this.text = text;
    }

    public RequestDTO setOptions(Options... options){
        this.options = Options.getOptions(options);
        return this;
    }

    public RequestDTO setOptions(int options){
        this.options = options;
        return this;
    }

    public Map<String, Object> toMap() {
        return new Gson().fromJson(this.toString(), new TypeToken<Map<String, ?>>() {
        }.getType());
    }

    @Override
    public String toString() {
        return new Gson().toJson(this, getClass());
    }
}
