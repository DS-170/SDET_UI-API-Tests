package api.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/*
* Я очень долго боролся с тем что lombok и JsonAlias вместе не работают, не смог найти ответа
*/

@Getter
@Setter
@Builder
public class Entity {
    private String title;
    private Boolean verified;
    private ArrayList<Integer> important_numbers;
    private Addition addition;

    @Getter
    @Setter
    @Builder
    public static class Addition {
        private String additional_info;
        private Integer additional_number;
    }
}
