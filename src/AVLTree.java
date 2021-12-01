import org.jetbrains.uast.values.UBooleanConstant;

/**
 *
 * AVLTree
 *
 * An implementation of aמ AVL Tree with
 * distinct integer keys and info.
 *
 */

public class AVLTree {
    AVLNode root = null;
    AVLNode min = null;
    AVLNode max = null;

    /**
     * public boolean empty()
     *
     * Returns true if and only if the tree is empty.
     *
     */
    public boolean empty() {
        if (root == null) {
            return true;
        }
        return false;
    }


    /**
     * public String search(int k)
     *
     * Returns the info of an item with key k if it exists in the tree.
     * otherwise, returns null.
     */
    public String search(int k)
    {
        AVLNode node = this.root;
        while (node.key != -1) {
            if (node.key == k) {
                return node.info;
            }
            if (node.key < k) {
                node = node.right;
            }
            if (node.key > k) {
                node = node.left;
            }
        }
        return null;
    }

    /**
     * public int insert(int k, String i)
     *
     * Inserts an item with key k and info i to the AVL tree.
     * The tree must remain valid, i.e. keep its invariants.
     * Returns the number of re-balancing operations, or 0 if no re-balancing operations were necessary.
     * A promotion/rotation counts as one re-balance operation, double-rotation is counted as 2.
     * Returns -1 if an item with key k already exists in the tree.
     */
    public int insert(int k, String i) {

        if (empty()) {
            AVLNode root = null;
            root.key = k;
            root.info = i;
            AVLNode child1 = null;
            AVLNode child2 = null;
            child1.key = -1;
            child2.key = -1;
            child1.parent = root;
            child2.parent = root;
            root.left = child1;
            root.right = child2;
            root.rank = 0;
            root.parent = null;
            return 0;
        }
        AVLNode node = this.root;
        AVLNode parent1 = node;
        int rank_cnt = node.rank;
        while (node.key != -1) {
            if (node.key == k) {
                return -1;
            }
            if (node.key > k) {
                parent1 = node;
                node = node.left;
            }
            if (node.key < k) {
                parent1 = node;
                node = node.right;
            }
            rank_cnt--;
        }
        node.parent = parent1;
        node.rank = rank_cnt;
        node.key = k;
        node.info = i;
        if (k<min.key) {
            min = node;
        }
        if (k>max.key) {
            max = node;
        }
        AVLNode child1 = node.left;
        AVLNode child2 = node.right;
        child1.key = -1;
        child2.key = -1;
        if(node.parent.key == 0) {
            node.parent.rank++;
            node = node.parent;
            // needs completion
        }
        else{
            return 0;
        }
        return 420;
    }

    /**
     * public int delete(int k)
     *
     * Deletes an item with key k from the binary tree, if it is there.
     * The tree must remain valid, i.e. keep its invariants.
     * Returns the number of re-balancing operations, or 0 if no re-balancing operations were necessary.
     * A promotion/rotation counts as one re-balance operation, double-rotation is counted as 2.
     * Returns -1 if an item with key k was not found in the tree.
     */


    public int delete(int k)
    {
        if (search(k) == null)
            return -1;
        else{
            String x = search(k);
            if (x == this.min.info)
                if (this.min.parent.info.equals(this.min.info)) {
                    this.min.parent.left = null;
                    this.min.info = this.min.parent.info;


                    this.min = this.min.parent;
                }
        }

        return 421;	// to be replaced by student code
    }

    /**
     * public String min()
     *
     * Returns the info of the item with the smallest key in the tree,
     * or null if the tree is empty.
     */
    public String min()
    {
        if (empty())
            return null;
        return this.min.info; // to be replaced by student code
    }

    /**
     * public String max()
     *
     * Returns the info of the item with the largest key in the tree,
     * or null if the tree is empty.
     */
    public String max()
    {
        if(empty())
            return null;
        return this.max.info; // to be replaced by student code
    }

    /**
     * public int[] keysToArray()
     *
     * Returns a sorted array which contains all keys in the tree,
     * or an empty array if the tree is empty.
     */
    public int[] keysToArray()
    {
        return new int[33]; // to be replaced by student code
    }

    /**
     * public String[] infoToArray()
     *
     * Returns an array which contains all info in the tree,
     * sorted by their respective keys,
     * or an empty array if the tree is empty.
     */
    public String[] infoToArray()
    {
        return new String[55]; // to be replaced by student code
    }

    /**
     * public int size()
     *
     * Returns the number of nodes in the tree.
     */
    public int size()
    {
        return 422; // to be replaced by student code
    }

    /**
     * public int getRoot()
     *
     * Returns the root AVL node, or null if the tree is empty
     */
    public IAVLNode getRoot()
    {
        return null;
    }

    /**
     * public AVLTree[] split(int x)
     *
     * splits the tree into 2 trees according to the key x.
     * Returns an array [t1, t2] with two AVL trees. keys(t1) < x < keys(t2).
     *
     * precondition: search(x) != null (i.e. you can also assume that the tree is not empty)
     * postcondition: none
     */
    public AVLTree[] split(int x)
    {
        return null;
    }

    /**
     * public int join(IAVLNode x, AVLTree t)
     *
     * joins t and x with the tree.
     * Returns the complexity of the operation (|tree.rank - t.rank| + 1).
     *
     * precondition: keys(t) < x < keys() or keys(t) > x > keys(). t/tree might be empty (rank = -1).
     * postcondition: none
     */
    public int join(IAVLNode x, AVLTree t)
    {
        return -1;
    }

    /**
     * public interface IAVLNode
     * ! Do not delete or modify this - otherwise all tests will fail !
     */
    public interface IAVLNode{
        public int getKey(); // Returns node's key (for virtual node return -1).
        public String getValue(); // Returns node's value [info], for virtual node returns null.
        public void setLeft(IAVLNode node); // Sets left child.
        public IAVLNode getLeft(); // Returns left child, if there is no left child returns null.
        public void setRight(IAVLNode node); // Sets right child.
        public IAVLNode getRight(); // Returns right child, if there is no right child return null.
        public void setParent(IAVLNode node); // Sets parent.
        public IAVLNode getParent(); // Returns the parent, if there is no parent return null.
        public boolean isRealNode(); // Returns True if this is a non-virtual AVL node.
        public void setHeight(int height); // Sets the height of the node.
        public int getHeight(); // Returns the height of the node (-1 for virtual nodes).
    }

    /**
     * public class AVLNode
     *
     * If you wish to implement classes other than AVLTree
     * (for example AVLNode), do it in this file, not in another file.
     *
     * This class can and MUST be modified (It must implement IAVLNode).
     */
    public class AVLNode implements IAVLNode{
        private int key;
        private String info;
        private int rank;
        private AVLNode left;
        private AVLNode right;
        private AVLNode parent;

        public AVLNode(){
            this.key= Integer.parseInt(null);
            this.info=null;
            this.rank=-1;
            this.left=null;
            this.right=null;
            this.parent=null;
        }
        public AVLNode(int key,String info,AVLNode parent){
            this.key=key;
            this.info=info;
            this.rank=-1;
            this.left=null;
            this.right=null;
            this.parent=parent;
        }

        public int getKey()
        {
            return this.key; // to be replaced by student code
        }
        public String getValue()
        {
            return this.info; // to be replaced by student code
        }
        public void setLeft(IAVLNode node)
        {
            this.left.key=node.getKey();
            this.left.info= node.getValue();
            //******
        }
        public IAVLNode getLeft()
        {
            return this.left; // to be replaced by student code
        }
        public void setRight(IAVLNode node)
        {
            return; // to be replaced by student code
        }
        public IAVLNode getRight()
        {
            return this.right; // to be replaced by student code
        }
        public void setParent(IAVLNode node)
        {
            return; // to be replaced by student code
        }
        public IAVLNode getParent()
        {
            return this.parent; // to be replaced by student code
        }
        public boolean isRealNode()
        {
            if (this.key == Integer.parseInt(null) || this.info==null)
                return false;
            return true; // to be replaced by student code
        }
        public void setHeight(int height)
        {
            this.rank += height; // to be replaced by student code
        }
        public int getHeight()
        {
            return rank; // to be replaced by student code
        }
    }

}


