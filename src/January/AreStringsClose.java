package January;


import java.util.HashMap;
import java.util.Map;

public class AreStringsClose {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        //create hashmap with character counts in the words
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        for (int i=0; i<word1.length(); i++) {
            Integer val = hm1.get(word1.charAt(i));
            if(val==null) hm1.put(word1.charAt(i), 1);
            else hm1.put(word1.charAt(i), val+1);
            if(hm2.get(word1.charAt(i))==null) hm2.put(word1.charAt(i), null);

            val = hm2.get(word2.charAt(i));
            if(val==null) hm2.put(word2.charAt(i), 1);
            else hm2.put(word2.charAt(i), val+1);
            if(hm1.get(word2.charAt(i))==null) hm1.put(word2.charAt(i), null);
        }



        //create arrays for counts
        int[] arr1 = new int[hm1.size()];
        int i=0;
        for(Map.Entry<Character,Integer> entry: hm1.entrySet()) {
            if(entry.getValue()==null) return false;
            arr1[i++] = entry.getValue();
        }

        int[] arr2 = new int[hm2.size()];
        i=0;
        for(Map.Entry<Character,Integer> entry: hm2.entrySet()) {
            if(entry.getValue()==null) return false;
            arr2[i++] = entry.getValue();
        }

        if(arr1.length!=arr2.length) return false;

        //sort the elements in the count arrays
        quickSort(arr1, 0, arr1.length-1);
        quickSort(arr2, 0, arr2.length-1);

        //if the elements are not same then any number of steps with not make the transformation from word1 to word2 possible
        for(int j=0; j<arr1.length; j++) {
            if(arr1[j]!=arr2[j]) return false;
        }

        return true;
    }

    private void quickSort(int[] arr, int p, int r) {
        if(p<r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q-1);
            quickSort(arr, q+1, r);
        }
    }

    private int partition(int[] arr, int p, int r) {
        int i=p-1;
        int x=arr[r];
        for(int j=p; j<r; j++) {
            if(arr[j]<=x) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[r];
        arr[r] = arr[i];
        arr[i] = temp;
        return i;
     }

     public static void main(String args[]) {
        System.out.println(new AreStringsClose().closeStrings("cabbba", "abbccc"));
        System.out.println(new AreStringsClose().closeStrings("cabbba", "aabbss"));
        System.out.println(new AreStringsClose().closeStrings("uau", "ssx"));
     }
}
