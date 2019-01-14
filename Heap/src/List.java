/**
 * Implementation of a Double Linked List of ints
 */
public  class List {

    public Node head; // First element of the list
    public Node tail; // Last element of the list
    public  int size; // How many objects are in the list

    /**
     * List constructor
     * head & tail will be null, while the size is 0
     */
    List() {
        size = 0;
    }

    /**
     * Getter for size
     * Note: the size is protected to avoid external manipulation
     * @return list size
     */
    int size() {
        return this.size;
    }

    /**
     * Node class contains the elements to store in the list
     * with their pointers to the next and previous element
     *
     * [0 <--> 1 <--> 2]
     *
     * 0.prev = null
     * 0.next = 1
     * 1.prev = 0
     * 1.next = 2
     * 2.prev = 1
     * 2.next = null
     */
    public static class Node {

        public int element;
        Node next;
        Node prev;

        /**
         * Node constructor
         * @param e int element
         * @param n reference to next node
         * @param p reference to previous node
         */
       public  Node(int e, Node n, Node p) {
            element = e;
            next = n;
            prev = p;
        }
    }

    /**
     * Initializes the list with a Node
     * @param element element
     */
    private void initialize(int element) {
        Node n = new Node(element, null, null);
        this.head = n;
        this.tail = n;

        ++size;
    }

    /**
     * Add element to the start of the list
     * @param element element
     */
    void addFirst(int element) {
        // If list is empty initialize
        if (size == 0) {
            this.initialize(element);
            return;
        }

        Node first = this.head;
        this.head = new Node(element, first, null);
        first.prev = this.head;

        ++size;
    }

    /**
     * Append to end of list
     * @param element number
     */
    void addLast(int element) {

        // If list is empty initialize
        if (size == 0) {
            this.initialize(element);
            return;
        }

        Node last = this.tail;
        this.tail = new Node(element, null, last);
        last.next = this.tail;

        ++size;
    }

    /**
     * Add number to list at the specified index
     * The old element is shifted UP
     *
     * Example:
     * Insert 2 at pos 2
     * [0 <--> 1 <--> 3]
     * [0 <--> 1 <--> 2 <--> 3]
     *
     * @param element element
     * @param index index
     * @throws Exception Invalid index
     */
   private void add(int element, int index) throws Exception {

        if (index==0){
            addFirst(element);

        }
        else if(index==size){
            addLast(element);

        }else if (index<size && index>0) {
            Node temp = this.head;
            for(int i = 0; i<index-1;i++)
                temp = temp.next;

            temp.next=(new Node(element,temp.next,temp));
            temp.next.next.prev= temp.next;
            size++;

        }
        if (index<0)
            throw new Exception("Es un indice muy bajo");

        if(index>this.size)
            throw new Exception("Es un idice demasiado alto");


    }


    /**
     * Returns an element
     * @param index index
     * @return element
     * @throws Exception Invalid index
     */
    int get(int index) throws Exception {
        Node n = this.getNode(index);

        if (n == null) {
            throw new Exception("");
        }

        return n.element;
    }

    /**
     * Returns the Node from the specified index
     * @param index index
     * @return element
     * @throws Exception Invalid index
     */
    private Node getNode(int index) throws Exception {
      if(index>=0 && index<size) {
          Node temp = this.head;

          for (int i = 0; i < index; i++)
              temp = temp.next;

          return temp;
      }
        if (index<0)
            throw new ArithmeticException("Es un indice muy bajo");

        if(index>=size)
            throw new ArithmeticException("Es un idice demasiado alto");

        return null;
    }

    /**
     * Removes and returns head of the list
     * @return element
     * @throws Exception Empty list
     */
    int removeFirst() throws Exception {
        return this.remove(0);
    }

    /**
     * Remove asn returns the tail of the list
     * @return element
     * @throws Exception Empty list
     */
    int removeLast() throws Exception {
        return this.remove(this.size - 1);
    }

    /**
     * Remove and return the element from the given index
     * @param i index
     * @return element
     * @throws Exception invalid index or empty list
     */
    int remove(int i) throws Exception {
        if (i == 0) {
            Node temp = this.head;
            head = this.head.next;
            --size;
            if (size != 0)
                this.head.prev = null;
            return temp.element;


        } else if (i >= 0 && i < size - 1) {
            Node temp = this.head;
            for (int j = 0; j < i; j++)
                temp = temp.next;

            int u = temp.element;
            temp = temp.prev;

            temp.next = temp.next.next;
            --size;
            return u;
        }
            else if (i== size - 1) {
                Node temp = this.head;
                for (int j = 0; j < i; j++)
                    temp = temp.next;

                int u = temp.element;
                temp = temp.prev;

                temp.next = temp.next.next;
                --size;
                tail=this.tail.prev;
                return u;

            }
            if (i < 0)
                throw new Exception("Es un indice muy bajo");

            if (i >= size)
                throw new Exception("Es un idice demasiado alto");
            return 0;
        }


    /**
     * Sorts the list using Quicksort algorithm
     */
    void sort() throws Exception {
        this.quickSort(0, this.size() - 1);
    }

    private void quickSort(int lo, int hi) throws Exception {

        if (lo < hi) {
            int p = partition(lo, hi);
            quickSort(lo, p-1);
            quickSort(p + 1, hi);

        }
    }

    private int partition(int lo, int hi) throws Exception {

        int pivot =this.getNode(hi).element;
        int i=lo-1;
        for(int j=lo;j<=hi-1;j++){
            if(this.getNode(j).element<=pivot){
                if(i != j+1) {
                    ++i;
                    swap(i, j);
                }

            }
        }
        ++i;
        swap(i, hi);
        return i;
    }

    /**
     * Exchange two elements
     * @param i index of first Node
     * @param j index of second Node
     * @throws Exception Invalid index
     */
    void swap(int i, int j) throws Exception {
        Node iNode = this.getNode(i);
        Node jNode = this.getNode(j);

        int iElem = iNode.element;

        iNode.element = jNode.element;
        jNode.element = iElem;
    }

    /**
     * Converts list to string
     * @return string representation of the list
     */
    public String toString() {
        Node n = this.head;

        if (this.head == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        while (n != null) {
            builder.append(String.valueOf(n.element));
            n = n.next;

            if (n != null) {
                builder.append(", ");
            }
        }

        return builder.toString();
    }


}

