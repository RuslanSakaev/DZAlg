public class Main {
    public static void main(String[] args) {
        HashMapCustom<Integer, String> map = new HashMapCustom<>();
        map.put(4, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));

        System.out.println(map.remove(2));
        System.out.println(map.containsKey(2));

        System.out.println(map.replace(3, "NewThree"));
        System.out.println(map.get(3));

        System.out.println(map.size());
        System.out.println(map.containsValue("One"));
        System.out.println(map.containsValue("Four"));
    }
}
