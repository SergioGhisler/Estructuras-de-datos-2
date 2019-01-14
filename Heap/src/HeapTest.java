import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void checkPeekPoll() throws Exception {
        Heap h = new Heap();
        h.add(1);
        h.add(3);
        h.add(2);
        h.add(0);
        assertEquals(h.peek(), 0);
        assertEquals(h.poll(), 0);

        assertEquals(h.peek(), 1);
        assertEquals(h.poll(), 1);

        assertEquals(h.peek(), 2);
        assertEquals(h.poll(), 2);

        assertEquals(h.peek(), 3);
        assertEquals(h.poll(), 3);
    }

    @Test
    public void checkListConstructor() throws Exception {
        int[] l = new int[4];
        l[0] = 3;
        l[1] = 1;
        l[2] = 2;
        l[3]=-2;
        Heap h = new Heap(l);
        assertEquals(h.peek(), -2);
        assertEquals(h.poll(), -2);

        assertEquals(h.peek(), 1);
        assertEquals(h.poll(), 1);

        assertEquals(h.peek(), 2);
        assertEquals(h.poll(), 2);

        assertEquals(h.peek(), 3);
        assertEquals(h.poll(), 3);
    }

    @Test
    public void checkSorting() throws Exception {
        List l1 = new List();
        l1.addLast(0);
        l1.addLast(10);
        l1.addLast(5);
        l1.addLast(20);
        l1.addLast(1);
        l1.addLast(100);
        l1.sort();

        Heap h = new Heap();
        h.add(0);
        h.add(10);
        h.add(5);
        h.add(20);
        h.add(1);
        h.add(100);

        assertEquals(h.toList().toString(), l1.toString());
    }

    @Test(expected = Exception.class)
    public void checkPeekException() throws Exception {
        Heap h = new Heap();
        h.peek();
    }

    @Test(expected = Exception.class)
    public void checkPollException() throws Exception {
        Heap h = new Heap();
        h.poll();
    }
}