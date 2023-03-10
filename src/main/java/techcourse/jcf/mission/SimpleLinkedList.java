package techcourse.jcf.mission;

public class SimpleLinkedList implements SimpleList {

    public static final int NOT_CONATIN_OBJECT_INDEX = -1;
    private int size = 0;
    private Node startNode;

    public SimpleLinkedList() {
    }

    public SimpleLinkedList(final String... values) {
        for (final String value : values) {
            this.add(value);
        }
    }

    @Override
    public boolean add(final String value) {
        final Node newNode = new Node(value, null);
        size += 1;
        if (startNode == null) {
            startNode = newNode;
            return true;
        }
        final Node lastNode = startNode.findLastNode();
        lastNode.next = newNode;
        return true;
    }

    @Override
    public void add(final int index, final String value) {
        Node curNode = startNode;
        if (index == 0) {
            startNode = new Node(value, curNode);
            size += 1;
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            curNode = curNode.next;
        }
        final Node nodeAtIndex = curNode.next;
        curNode.next = new Node(value, nodeAtIndex);
        size += 1;
    }

    @Override
    public String set(final int index, final String value) {
        return null;
    }

    @Override
    public String get(final int index) {
        Node curNode = startNode;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.value;
    }

    @Override
    public boolean contains(final String value) {
        return false;
    }

    @Override
    public int indexOf(final String value) {
        int index = 0;
        for (Node node = startNode; node != null; node = node.next) {
            if (node.value.equals(value)) {
                return index;
            }
            index += 1;
        }
        return NOT_CONATIN_OBJECT_INDEX;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(final String value) {
        return false;
    }

    @Override
    public String remove(final int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    public Node getStartNode() {
        return startNode;
    }

    static class Node {
        private String value;
        private Node next;

        Node(final String value, final Node next) {
            this.value = value;
            this.next = next;
        }

        public Node findLastNode() {
            if (this.next == null) {
                return this;
            }
            return this.next.findLastNode();
        }

        String getValue() {
            return value;
        }

        Node getNext() {
            return next;
        }
    }
}
