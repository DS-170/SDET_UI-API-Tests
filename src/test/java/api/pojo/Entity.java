package api.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
@Setter
@Builder
public class Entity {

    @Builder.Default
    private String title = "Test title";
    @Builder.Default
    private Boolean verified = true;
    @Builder.Default
    @SerializedName(value = "important_numbers")
    private ArrayList<Integer> importantNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    private Addition addition;

    @Getter
    @Setter
    @Builder
    public static class Addition {
        @Builder.Default
        @SerializedName(value = "additional_info")
        private String additionalInfo = "Test additional info";
        @Builder.Default
        @SerializedName(value = "additional_number")
        private Integer additionalNumber = 1;
    }
}
