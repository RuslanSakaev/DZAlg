
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // Если список пустой или состоит из одного элемента, то он уже развернут
        if (head == null || head.next == null)
            return head;

        ListNode prev = null; // Предыдущий узел
        ListNode current = head; // Текущий узел
        ListNode next = null; // Следующий узел

        while (current != null) {
            next = current.next; // Сохраняем ссылку на следующий узел
            current.next = prev; // Меняем ссылку текущего узла на предыдущий

            prev = current; // Перемещаем указатель на предыдущий узел
            current = next; // Перемещаем указатель на текущий узел
        }

        // После завершения цикла prev указывает на новую голову списка (бывший хвост)
        return prev;
    }

    // Пример использования
    public static void main(String args[]) {
        // Создаем список: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(456);
        head.next = new ListNode(7989);
        head.next.next = new ListNode(897);
        head.next.next.next = new ListNode(541);
        head.next.next.next.next = new ListNode(555);

        // Выводим исходный список
        System.out.println("Исходный список:");
        printList(head);

        // Разворачиваем список
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode reversedHead = reverseLinkedList.reverseList(head);

        // Выводим развернутый список
        System.out.println("Развернутый список:");
        printList(reversedHead);
    }

    // Вспомогательный метод для вывода списка
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}