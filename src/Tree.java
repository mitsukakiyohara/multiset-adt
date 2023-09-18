public class Tree {
    private int root;
    private int[] subtrees;

    public Tree(int r, int[] subs) {
        this.root = r;
        this.subtrees = subs;
    }

    boolean is_empty() {
        return this.root == 0;
    }

    int length(int[] subtrees) {
        if (this.is_empty()) {
            return 0;
        }
        else {
           return length(this.subtrees);
        }
    }
}