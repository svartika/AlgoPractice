package march;

import java.util.ArrayList;
import java.util.List;

// This doesnt work when i give hashmap array size as 100(one value is different) or 10(timeout)
//this works when i give hashmap array size as 1000
class MyHashMap {
    class Item {
        int key, value;

        Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Item[] items;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        items = new Item[10];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int pos = createPosition(key);
        if (pos == -1) {
            System.out.println("hashMap is full");
        }
        items[pos] = new Item(key, value);
    }

    private int createPosition(int key) {
        int pos = Integer.hashCode(key) % items.length;
        int orgPos = pos;
        while (pos <= items.length) {
            if (pos == items.length) pos = 0;
            else if(items[pos] != null) {
                if (items[pos].key == key) return pos;
                else pos++;
                if (pos == orgPos) {
                    pos = items.length;
                    increaseSizeOfArray();
                   /* createPosition(key);*/
                    return pos;
                }
            } else if(items[pos] == null) {
                return pos;
            }
        }
        return pos;
    }

    private void increaseSizeOfArray() {
        Item[] newItems = new Item[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        items = null;
        items = newItems;

    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int pos = getPositionForKey(key);
        if (pos == -1) {
            return -1;
        } else {
            return items[pos].value;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int pos = getPositionForKey(key);
        if (pos!=-1 && items[pos]!=null) {
            items[pos] = null;
        }
    }

    private int getPositionForKey(int key) {
        int pos = Integer.hashCode(key) % items.length;
        int orgPos = -1;
        while (pos <= items.length ) {
            if(orgPos==-1) orgPos=pos;
            else if(pos==orgPos) return -1;

            if(pos<items.length && items[pos]!=null && items[pos].key == key ) {
                return pos;
            }
            else if(pos<items.length ) { //&& items[pos]!=null && items[pos].key != key ) {
                pos++;
            }
            else if (pos >= items.length) {
                pos = 0;
            }
        }
        if (items[pos]!=null && items[pos].key == key) {
            return pos;
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.remove(14);
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));
    }
}

