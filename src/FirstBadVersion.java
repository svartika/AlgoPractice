public class FirstBadVersion {
    boolean isBadVersion(int version) {
       if(version == 1702766719) return true;
       else return false;
    }

    /*public int firstBadVersion(int n) {
        if(n==1) return 1;
        int mid = n/2, prevBadAt = mid;
        while(mid>0 && mid<n) {
            if(isBadVersion(mid) == true) {
                prevBadAt = mid;
                mid = mid/2;
            } else {
                prevBadAt = mid;
                mid = mid+mid/2;
            }
            if(prevBadAt<=mid) mid++;
            else mid--;
        }
        return prevBadAt;
    }
*/
    public int firstBadVersion(int n) {
        if(n==1) return 1;
        int start = 1, end = n;
        while(start<end) {
            //int mid = (start/2+end/2);
            int mid = start+(end-start)/2;
            System.out.println(String.format("Start:%d, End:%d", start, end));
            if(isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    public  static  void main(String args[]) {
        System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
    }
}
