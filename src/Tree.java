public class Tree {
    public String __str__() {
        /*
        Return a string representation of this tree.

        For each node, its item is printed before any of its
        descendants' items. The output is nicely indented.
         */
        return this._str_indented(0).toString();
    }
    public StringBuilder _str_indented(int depth) {
        /*
        Return an indented string representation of this tree.

        The indentation level is specified by the <depth> parameter.
         */
        if (this.is_empty()) {
            return new StringBuilder();
        }
        else {
            StringBuilder s = new StringBuilder();
            s.append("  ".repeat(Math.max(0, depth)));
            s.append(String.valueOf(this._root)).append("\n");
            for (Tree subtree: this._subtrees) {
                s.append(subtree._str_indented(depth + 1));
            }
            return s;
        }
    }
    public float average() {
        /* Return the average of all the values in this tree.

        Return 0.0 if this tree is empty.

        Precondition: this is a tree of numbers.
         */
        if (this.is_empty()) {
            return 0.0F;
        }
        else {
            int[] average = this._average_helper();
            return (float) average[0] / average[1];
        }
    }

    public int[] _average_helper() {
        if (this.is_empty()) {
            return new int[]{0, 0};
        }
        else {
            int total = this._root;
            int size = 1;
            for (Tree subtree: this._subtrees) {
                int[] subtreeTotal = _average_helper();
                total += subtreeTotal[0];
                size += subtreeTotal[1];
            }
            return new int[]{total, size};
        }
    }


}
