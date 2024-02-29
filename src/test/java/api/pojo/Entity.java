package api.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Builder
@Getter
@Setter
public class Entity {
    public String title;
    public Boolean verified;
    public ArrayList<Integer> important_numbers;
    public Addition addition;

    @Builder
    public static class Addition {
        public String additional_info;
        public Integer additional_number;
    }
}
