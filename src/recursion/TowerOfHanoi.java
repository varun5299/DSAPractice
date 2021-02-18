package recursion;

public class TowerOfHanoi {
    public void toh(int n, char from, char to, char aux){
        if(n==1) {
            System.out.println("Disk " + n + " moved from " + from + " to " + to);
            return;
        }

        toh(n-1,from,aux,to);
        System.out.println("Disk " +n +" moved from " +from +" to "+to);
        toh(n-1,aux,to,from);
    }
}
