package recursion;

public class SortCheck {
    public boolean check(int arr[], int n){

        if(n==1||n==0)
            return true;

        if(arr[n-1]<arr[n-2])
            return false;

        return check(arr, n-1);
    }
}
