package Skeep.backend.location.userLocation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;

@Builder
public record UserLocationPatchDto(
        @JsonProperty("userLocationList")
        List<UserLocationDto> userLocationDtoList,
        @JsonProperty("successCount")
        Integer successCount,
        @JsonProperty("failedCount")
        Integer failedCount
) implements Serializable {
    public static UserLocationPatchDto of(
            final List<UserLocationDto> userLocationDtoList,
            final Integer successCount,
            final Integer failedCount
    ) {
        return UserLocationPatchDto.builder()
                .userLocationDtoList(userLocationDtoList)
                .successCount(successCount)
                .failedCount(failedCount)
                .build();
    }
}
