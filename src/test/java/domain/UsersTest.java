package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.ErrorMessage;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UsersTest {
    private final List<String> testUserNames = List.of("썬샷", "홍실", "다니");

    @Test
    @DisplayName("유저의 수가 0이 들어오는 경우")
    void usersNumberIsZero() {
        assertThatThrownBy(() -> new Users(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.USERS_NAME_BLANK_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("정상적으로 Users가 생성되는 경우")
    void generateUsersTest() {
        Assertions.assertDoesNotThrow(() -> new Users(testUserNames));
    }

    @Test
    @DisplayName("유저의 수를 반환하는 메서드 테스트")
    void getUsersNumberTest() {
        final Users users = new Users(testUserNames);
        assertThat(users.size()).isEqualTo(testUserNames.size());
    }

    @Test
    @DisplayName("유저의 이름들을 반환하는 메서드 테스트")
    void getUsersNameTest() {
        final Users users = new Users(testUserNames);
        assertThat(users.getUserNames()).containsExactlyElementsOf(testUserNames);
    }

    @Test
    @DisplayName("입력한 사용자와 동일한 이름을 가진 객체가 없는 경우 예외처리")
    void throwExceptionIfCantFindUser() {
        final Users users = new Users(testUserNames);
        assertThatThrownBy(() -> users.validateParticipateUser("로지"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.USER_NOT_FOUND_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("이름으로 현재 index를 반환하는 메서드 추가")
    void getIndexByUserName() {
        final Users users = new Users(testUserNames);
        assertThat(users.getIndexByUserName("다니"))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("line을 순회하면서 Link가 되어있는 경우, 유저의 위치를 swap")
    void swapUserByLine() {
        final Users users = new Users(testUserNames);
        final Line line = new Line(List.of(Link.LINKED, Link.UNLINKED));

        users.swapUserByLine(line);

        assertThat(users.getUserNames())
                .containsExactly("홍실", "썬샷", "다니");
    }

    @Test
    @DisplayName("User의 위치에 맞는 Prize를 반환하는 기능")
    void getPrizeByUserName() {
        final Users users = new Users(testUserNames);
        final Prizes prizes = new Prizes(List.of("1등", "2등", "3등"), users);

        final Prize receivedPrizeHongSile = users.getPrizeByUserName(prizes, "홍실");

        assertThat(receivedPrizeHongSile.getName()).isEqualTo("2등");
    }
}
