import stack.*;

import java.util.Stack;

public class main {
    public static void main(String[] args) throws Exception {
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        duplicateRemover.remover(new int[]{1,2,3,4,1,2,3});
    }
}
