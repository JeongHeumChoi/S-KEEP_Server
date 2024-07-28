package Skeep.backend.location.domain;

import Skeep.backend.category.domain.ECategory;
import Skeep.backend.global.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicUpdate
@Table(name = "location")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Location extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "kakao_map_id", nullable = false)
    private String kakaoMapId;

    @Column(name = "fixed_category", nullable = false)
    @Enumerated(EnumType.STRING)
    private ECategory fixedCategory;

    @Builder
    private Location(final String kakaoMapId, final ECategory fixedCategory) {
        this.kakaoMapId = kakaoMapId;
        this.fixedCategory = fixedCategory;
    }

    public static Location createLocation(String kakaoMapId, ECategory fixedCategory) {
        return Location.builder()
                .kakaoMapId(kakaoMapId)
                .fixedCategory(fixedCategory)
                .build();
    }
}
