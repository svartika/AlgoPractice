package march;
import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        List<Integer>keysInRoom = rooms.get(0);
        //while(room!=null) {
        //List<Integer> keys = room;
        for(Integer key: keysInRoom) {
            visitRoom(key, visited, rooms);
        }
       // }
        for(int i=0; i<visited.length; i++) {
            if(visited[i]==false) return false;
        }
        return true;
    }

    private void visitRoom(int key, boolean[] visited, List<List<Integer>> rooms) {
        if(visited[key]==true) return;
        visited[key] = true;
        List<Integer> keys = rooms.get(key);
        for(Integer currkey: keys) {
            visitRoom(currkey, visited, rooms);
        }
    }

    public static void main(String args[]) {
        List<Integer>keys1 = new ArrayList<>();
        keys1.add(1); keys1.add(3);

        List<Integer>keys2 = new ArrayList<>();
        keys2.add(3); keys2.add(0);  keys2.add(1);

        List<Integer>keys3 = new ArrayList<>();
        keys3.add(2);

        List<Integer>keys4 = new ArrayList<>();
        keys4.add(0);

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(keys1);
        rooms.add(keys2);
        rooms.add(keys3);
        rooms.add(keys4);

        System.out.println(new KeysAndRooms().canVisitAllRooms(rooms));
    }
}
