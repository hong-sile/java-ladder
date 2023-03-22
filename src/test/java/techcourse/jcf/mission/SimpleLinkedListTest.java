package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {

    @Test
    void addList() {
        final SimpleLinkedList list = new SimpleLinkedList();

        list.add("홍실");

        Assertions.assertAll(
                () -> assertThat(list)
                        .extracting("size")
                        .isEqualTo(1),
                () -> assertThat(list.getStartNode().getValue())
                        .isEqualTo("홍실")
        );
    }

    @Test
    void addListAtIndex() {
        final String[] values = {"홍실", "다니"};
        final SimpleLinkedList list = new SimpleLinkedList(values);

        list.add(0, "썬샷");

        Assertions.assertAll(
                () -> assertThat(list.getStartNode().getValue())
                        .isEqualTo("썬샷"),
                () -> assertThat(list.getStartNode().getNext().getValue())
                        .isEqualTo("홍실")
        );
    }

    @Test
    void set() {
        final SimpleLinkedList list = new SimpleLinkedList("홍실", "다니", "제이미", "에단");

        list.set(1, "로지");

        assertThat(list.indexOf("로지")).isEqualTo(1);
    }

    @Test
    void get() {
        final String[] values = {"홍실", "썬샷"};
        final SimpleLinkedList linkedList = new SimpleLinkedList(values);

        Assertions.assertAll(
                () -> assertThat(linkedList.get(0)).isEqualTo("홍실"),
                () -> assertThat(linkedList.get(1)).isEqualTo("썬샷")
        );
    }

    @Test
    void contains() {
        final SimpleLinkedList list = new SimpleLinkedList("홍실", "다니", "제이미", "에단");

        Assertions.assertAll(
                () -> assertThat(list.contains("준팍")).isFalse(),
                () -> assertThat(list.contains("홍실")).isTrue()
        );
    }

    @Test
    void indexOf() {
        final SimpleLinkedList list = new SimpleLinkedList("홍실", "다니", "제이미");

        assertThat(list.indexOf("다니")).isEqualTo(1);
    }

    @Test
    void size() {
        final SimpleLinkedList list = new SimpleLinkedList("홍실", "다니", "제이미");

        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void isEmpty() {
        final SimpleLinkedList list = new SimpleLinkedList("홍실", "로지", "준팍");
        final SimpleLinkedList emptyList = new SimpleLinkedList();

        Assertions.assertAll(
                () -> assertFalse(list.isEmpty()),
                () -> assertTrue(emptyList.isEmpty())
        );
    }

    @Test
    void remove() {
    }

    @Test
    void clear() {
        final SimpleLinkedList list = new SimpleLinkedList("홍실", "로지", "준팍");

        list.clear();

        assertTrue(list.isEmpty());
    }
}
