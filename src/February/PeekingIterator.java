package February;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {
    private Integer peekedElem = null;
    private Iterator<Integer> iterator = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(hasNext()) {
            peekedElem = next();
            return peekedElem;
        } else {
            return null;
        }
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(peekedElem!=null) {
            Integer temp = peekedElem;
            peekedElem = null;
            return temp;
        } else {
            return iterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        if(peekedElem!=null) {
            return true;
        } else {
           return iterator.hasNext();
        }
    }

    public static void main(String [] args) {
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        PeekingIterator peekingIterator = new PeekingIterator(nums.iterator());

        System.out.print(peekingIterator.next());
        System.out.print(peekingIterator.peek());

        while(peekingIterator.hasNext()) {
            System.out.print(peekingIterator.peek());
            System.out.print(peekingIterator.next());
        }


    }
}
