public class Main {

    public static void main(String[] args) throws Exception {
        // Make sure it works
        HashTable h = new HashTable(5);

        h.set("Hugo", 99);
        h.set("Pepe", 81);
        h.set("Mara", 12);
        h.set("Pedro", 14);

        System.out.println(h.get("Hugo"));
        System.out.println(h.get("Pepe"));
        System.out.println(h.get("Mar"));
        System.out.println(h.get("Pedro"));
        System.out.println(h.get("Mar"));
    //    System.out.println(h.get("Alguien"));

        h.delete("Pedro");
        System.out.println(h.get("Mar"));
        System.out.println(h.get("Hugo"));
    }
}
