package releaseandfeature.task.releaseandfeature.enum_release;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ReleaseStatus {
    PLANNED("PLANNED"), RELEASED("RELEASED");

    private String stat;

    public static ReleaseStatus getFromStatus(String stat) {
        switch (stat) {
            case "PLANNED":
                return ReleaseStatus.PLANNED;
            case "RELEASED":
                return ReleaseStatus.RELEASED;

            default:
                throw new IllegalArgumentException(stat + " " + "no such status available");
        }

    }
}
