package api.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class Entity {
    private String title;
    private Boolean verified;
    @SerializedName(value = "important_numbers")
    private ArrayList<Integer> importantNumbers;
    private Addition addition;

    @Getter
    @Setter
    @Builder
    public static class Addition {
        @SerializedName(value = "additional_info")
        private String additionalInfo;
        @SerializedName(value = "additional_number")
        private Integer additionalNumber;
    }
}
