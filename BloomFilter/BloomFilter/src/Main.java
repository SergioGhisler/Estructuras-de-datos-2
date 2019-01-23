public class Main {

    public static void main(String[] args) {

        BloomFilter h= new BloomFilter(10,3);
        h.add("Hola");
        h.add("Adios");
        System.out.println(h.get("Adios "));


    }
}
