public class Heap {
    // Min Binary Heap

    private List heap; // Use your own List, or a Java Standard Library Data Structure

    Heap() {
        heap = new List();
        int size=0;
    }

    /**
     * Constructs a heap from a List
     * @param list
     * @throws Exception
     */
    Heap(int[] list) throws Exception {
        heap = new List();
        int size=0;
        for (int i = 0;i<list.length;i++){
        add(list[i]);


        }


    }


    private int getLeftChildIndex(int parentIndex) throws Exception {
        int leftChildIndex = (parentIndex*2)+1;
        return leftChildIndex;
    }
    private int getRightChildIndex(int parentIndex) throws Exception {
        int rightChildIndex = (parentIndex*2)+2;
        return rightChildIndex;
    }
    private int getParentIndex(int childIndex) throws Exception {
        int ParentIndex = (childIndex-1)/2;
        return ParentIndex;

    }

    private boolean hasLeftChild(int index) throws Exception { return getLeftChildIndex(index) < heap.size(); }
    private boolean hasRightChild(int index) throws Exception { return getRightChildIndex(index) < heap.size(); }
    private boolean hasParent(int index) throws Exception { return getParentIndex(index) >= 0;}

    private int leftChild(int index) throws Exception { return heap.get(getLeftChildIndex(index)); }
    private int rightChild(int index) throws Exception { return heap.get(getRightChildIndex(index)); }
    private int parent(int index) throws Exception { return heap.get(getParentIndex(index)); }

    /**
     * Exchange two heap positions
     * @param idx1
     * @param idx2
     * @throws Exception invalid indices
     */
    private void swap(int idx1, int idx2) throws Exception {
        heap.swap(idx1, idx2);
    }

    /**
     * Return the minimum element without removing it
     * @return Element
     * @throws Exception Empty list
     */
    public int peek() throws Exception {
        if (heap.size() == 0) throw new Exception();
        return heap.get(0);
    }

    /**
     * Remove and return the minimum element. Afterwards downheaps to maintain order
     * @return
     * @throws Exception Empty list
     */
    public int poll() throws Exception {

        int temp = this.peek();
        heap.removeFirst();
        this.heap.addFirst(this.heap.tail.element);
       heap.removeLast();
       downHeap();

        return temp;

    }

    /**
     * Add new element to heap. Afterwards upheaps to maintain order
     * @param item
     * @throws Exception
     */
    public void add(int item) throws Exception {
        heap.addLast(item);
        upHeap();
    }

    private void downHeap() throws Exception {
        int index = 0;
        while (hasLeftChild(index)) {
           int hijoPequeno = getLeftChildIndex(index);

           if(hasRightChild(index) && (rightChild(index)<leftChild(index))){
               hijoPequeno = getRightChildIndex(index);

            }
            if(heap.get(index)<heap.get(hijoPequeno)){
                break;
            }else{
                swap(index,hijoPequeno);
            }
            index=hijoPequeno;
        }
    }

    private void upHeap() throws Exception {
        //indice es el elemento mas pequeño
        int index = heap.size() - 1;
        //mientras que sea menor que el padre
        while (hasParent(index) && parent(index) > heap.get(index)) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    /**
     * Returns the heap as a SORTED list (using heapsort)
     * @return Sorted List
     * @throws Exception empty list
     */
    public List toList() throws Exception {
        List l = new List();
        while(this.heap.size() != 0){
            l.addLast(this.poll());
        }
        return l;
    }

    public boolean isEmpty() {

        return heap.size() == 0;
    }

}
