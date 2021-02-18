package backtracking;

public class BinaryOfLengthN {
    public void binaryGen(int n,int arr[], int i){

        if(i==n) {
            for (int x = 0; x < n; x++)
            {
                System.out.print(arr[x]+" ");
            }
            System.out.println();
            return;
        }
        arr[i]=0;
        binaryGen(n,arr,i+1);
        arr[i]=1;
        binaryGen(n,arr,i+1);
    }
}
