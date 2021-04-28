package releaseandfeature.task.releaseandfeature.enum_release;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ReleaseConverter implements AttributeConverter<ReleaseStatus, String> {
    @Override
    public String convertToDatabaseColumn(ReleaseStatus releaseStatus) {
        return releaseStatus.getStat();
    }

    @Override
    public ReleaseStatus convertToEntityAttribute(String s) {
        return ReleaseStatus.getFromStatus(s);
    }
}
