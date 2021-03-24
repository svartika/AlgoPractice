package testdome;

import java.util.ArrayList;
import java.util.List;

public class MergeNames {

    public static Boolean findInRes(String nameToFind, List<String> res) {
        for(String name: res) {
            if(name.compareTo(nameToFind)==0) return true;
        }
        return false;
    }

    public static String[] uniqueNames(String[] names1, String[] names2) {
        List<String> res = new ArrayList<String>();
        for(String name: names1) {
            if(!findInRes(name, res)) res.add(name);
        }
        for(String name: names2) {
            if(!findInRes(name, res)) res.add(name);
        }
        String[] resArr = new String[res.size()];
        for(int i=0; i<resArr.length; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
        // throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
