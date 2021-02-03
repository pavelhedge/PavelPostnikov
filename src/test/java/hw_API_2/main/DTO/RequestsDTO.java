package hw_API_2.main.DTO;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hw_API_2.main.Options;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@Accessors(fluent = true)
public class RequestsDTO {
    private List<String> text;
    private String lang;
    private int options;
    private String format;

    public RequestsDTO(){
        this.text = new LinkedList<>();
    }

    public RequestsDTO(Options...options){
        super();
        setOptions(options);
    }

    public RequestsDTO(int options, String ... text){
        super();
        setOptions(options);
        this.text = Arrays.asList(text);
    }

    public RequestsDTO setOptions(Options... options){
        this.options = Options.getOptions(options);
        return this;
    }

    public RequestsDTO setText(String text){
        this.text.add(text);
        return this;
    }

    public RequestsDTO setOptions(int options){
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
