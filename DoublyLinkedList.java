public class DoublyLinkedList<T> {
    private Node<T> head;

    // Вспомогательный класс узла двусвязного списка
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Метод для разворота двусвязного списка
    public void reverse() {
        Node<T> current = head;
        Node<T> temp = null;

        // Перебираем все узлы списка
        while (current != null) {
            // Меняем местами ссылки на предыдущий и следующий узлы
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // Переходим к следующему узлу
            current = current.prev;
        }

        // Проверяем, если список не пустой, меняем голову на последний элемент
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Пример использования
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Добавляем элементы в список
        list.add(1555);
        list.add(2757);
        list.add(389);
        list.add(4050);
        list.add(576);
        list.add(1555);
        list.add(2757);
        list.add(389);
        list.add(4050);
        list.add(576);
        list.add(1555);
        list.add(2757);
        list.add(389);
        list.add(4050);
        list.add(576);

        System.out.println("Исходный список:");
        list.print();

        // Разворачиваем список
        list.reverse();

        System.out.println("Развернутый список:");
        list.print();
    }

    // Метод для добавления элемента в начало списка
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Метод для печати списка
    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void display() {
    }
}
