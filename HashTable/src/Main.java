public class Main {

    public static void main(String[] args) throws Exception {
        // Make sure it works
        HashTable h = new HashTable();

        h.set("Hugo", 99);
        h.set("Pepe", 81);
        h.set("Mar", 11);
        h.set("Pedro", 33);

        System.out.println(h.get("Hugo"));
        System.out.println(h.get("Pepe"));
        System.out.println(h.get("Mar"));
        System.out.println(h.get("Pedro"));
        System.out.println(h.get("Alguien"));

        h.delete("Hugo");
        System.out.println(h.get("Mar"));
        System.out.println(h.get("Hugo"));
    }
}
