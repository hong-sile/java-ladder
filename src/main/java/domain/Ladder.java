package domain;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MINIMUM_HEIGHT = 1;

    private final List<Line> lines = new ArrayList<>();

    public Ladder(final int height, final int personCount, final LinkGenerator linkGenerator) {
        validateHeight(height);
        generateLines(height, personCount, new LineGenerator(linkGenerator));
    }

    private void validateHeight(final int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.LADDER_HEIGHT_EXCEPTION.getMessage());
        }
    }

    private void generateLines(final int height, final int personCount, final LineGenerator lineGenerator) {
        for (int index = 0; index < height; index++) {
            lines.add(lineGenerator.generate(personCount));
        }
    }

    public void playLadderGame(final Users users) {
        for (final Line line : lines) {
            users.swapUserByLine(line);
        }
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}

