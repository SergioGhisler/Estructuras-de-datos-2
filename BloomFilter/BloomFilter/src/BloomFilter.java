import java.util.Random;
class BloomFilter {
    boolean[] bloomFilter;
   int[] hashParameters;// optionally byte
    int[] hashSeeds;
    BloomFilter(int buckets, int numHashes) {
        this.bloomFilter = new boolean[buckets]; // optionally byte
        this.hashParameters = new int[numHashes];
        this.hashSeeds = new int[numHashes];
        for (int i = 0; i < numHashes; ++i) {
            hashSeeds[i]= new Random().nextInt(100);

        }
    }

    public void add(String element){
    int num= numString(element);
        for(int i=0; i<hashSeeds.length;i++){
        int j= getHash(num,hashSeeds[i]);
        this.bloomFilter[j]=true;
    }
    };

    public boolean get(String element) {
        int num = numString(element);
        boolean temp = false;
        for (int i = 0; i < hashSeeds.length; i++) {
            int j = getHash(num, hashSeeds[i]);
            if(this.bloomFilter[j]==true){
                temp=true;
            }else {
                temp=false;
            }
        }
       return temp;
    }



    private int numString(String key) {
        // Convert each char in number
        // Return absolute value of remainder with current capacity
        int total = 0;
        for (int i = 0; i < key.length(); i++) {
            total += (int) key.charAt(i);
        }

        return total;
    }

    private int getHash(int num, int seed){
        int temp=num*seed;
        return temp%bloomFilter.length;
    }
}
