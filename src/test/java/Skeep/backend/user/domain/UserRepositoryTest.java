package Skeep.backend.user.domain;

import Skeep.backend.global.RepositoryTest;
import Skeep.backend.user.dto.UserSecurityForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("[Repository Layer] -> UserRepository 테스트")
class UserRepositoryTest extends RepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findUserSecurityFromByAppleSerialId() {
        // given
        Long userId = userRepository.save(User.createAppleUser("1234567890", "Chaerin Yang", Email.createEmail("abcdegf@gmail.com"), ERole.USER)).getId();

        // when
        Optional<UserSecurityForm> find_user_security_form = userRepository.findUserSecurityFromBySerialId("1234567890");

        // then
        assertThat(find_user_security_form.get().getId()).isEqualTo(userId);
    }

    @Test
    void findUserSecurityFromById() {
        // given
        Long userId = userRepository.save(User.createAppleUser("1234567890", "Chaerin Yang", Email.createEmail("abcdegf@gmail.com"), ERole.USER)).getId();

        // when
        Optional<UserSecurityForm> find_user_security_form = userRepository.findUserSecurityFromById(userId);

        // then
        assertThat(find_user_security_form.get().getId()).isEqualTo(userId);
    }

    @Test
    void findByAppleSerialId() {
        // given
        Long userId = userRepository.save(User.createAppleUser("1234567890", "Chaerin Yang", Email.createEmail("abcdegf@gmail.com"), ERole.USER)).getId();

        // when
        Optional<User> find_user = userRepository.findBySerialId("1234567890");

        // then
        assertAll(
                () -> assertThat(find_user.get().getId()).isEqualTo(userId),
                () -> assertThat(find_user.get().getSerialId()).isEqualTo("1234567890"),
                () -> assertThat(find_user.get().getName()).isEqualTo("Chaerin Yang"),
                () -> assertThat(find_user.get().getEmail().getEmail()).isEqualTo("abcdegf@gmail.com"),
                () -> assertThat(find_user.get().getProvider()).isEqualTo(EProvider.APPLE),
                () -> assertThat(find_user.get().getStatus()).isEqualTo(EStatus.ACTIVATED)
        );
    }
}