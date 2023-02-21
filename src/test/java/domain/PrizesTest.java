package domain;

import exception.ErrorMessage;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {
    private final Users users = new Users(List.of("홍실", "다니"));

    @Test
    @DisplayName("poition에 맞는 Prize를 반환하는 기능 테스튼")
    void getPrizeByPositionTest() {
        final int position = 0;
        final List<String> prizeNames = List.of("1등", "2등");
        final Prizes prizes = new Prizes(prizeNames, users);

        Assertions.assertThat(prizes.getPrizeBy(position))
                .extracting("name")
                .isEqualTo(prizeNames.get(position));
    }

    @Test
    @DisplayName("상품의 수가 Users의 수와 다르면 예외처리한다.")
    void throwExceptionWhenPrizesCountIsDifferentUsersCount() {
        final List<String> prizeNames = List.of("1등", "2등", "3등");

        Assertions.assertThatThrownBy(() -> new Prizes(prizeNames, users))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PRIZES_SIZE_IS_NOT_EQUAL_USERS_SIZE_EXCEPTION.getMessage());
    }
}
