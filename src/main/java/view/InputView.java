package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TODO: static 키워드 제거
public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final InputValidator inputValidator = new InputValidator();
    private static final String USER_NAMES_GUIDE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_GUIDE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String PRIZE_NAMES_GUIDE_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String RESULT_USER_GUIDE_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String DELIMITER = "\\s*,\\s*";

    //TODO: readUserNames와 readPrizeNames의 중복로직을 제거
    public static List<String> readUserNames() {
        System.out.println(USER_NAMES_GUIDE_MESSAGE);
        String names = scanner.nextLine();
        System.out.println();
        //inputValidator.validateAscii(names);
        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toUnmodifiableList());
    }

    public static List<String> readPrizeNames() {
        System.out.println(PRIZE_NAMES_GUIDE_MESSAGE);
        String names = scanner.nextLine();
        System.out.println();
        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toUnmodifiableList());
    }

    public static int readLadderHeight() {
        System.out.println(LADDER_HEIGHT_GUIDE_MESSAGE);
        String height = scanner.nextLine();
        System.out.println();
        return inputValidator.validateHeight(height);
    }

    public static String readUserName() {
        System.out.println(RESULT_USER_GUIDE_MESSAGE);
        return scanner.nextLine();
    }
}
