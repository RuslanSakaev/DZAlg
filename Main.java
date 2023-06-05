public class Main {
    public static void main(String[] args) {
        Mapa<Integer, String> map = new Mapa<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println(map.get(1)); // Выводит: "One"
        System.out.println(map.get(2)); // Выводит: "Two"
        System.out.println(map.get(3)); // Выводит: "Three"

        System.out.println(map.remove(2)); // Выводит: "Two"
        System.out.println(map.containsKey(2)); // Выводит: false

        System.out.println(map.replace(3, "NewThree")); // Выводит: "Three"
        System.out.println(map.get(3)); // Выводит: "NewThree"

        System.out.println(map.size()); // Выводит: 2
        System.out.println(map.containsValue("One")); // Выводит: true
        System.out.println(map.containsValue("Four")); // Выводит: false
    }
}
