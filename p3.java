import java.util.*;

class DFS {
    private final ArrayList<String> treePaths;

    public DFS(ArrayList<Integer> tree) {
        this.treePaths = new ArrayList<>();
        DFShelper(tree, 0, "");
    }

    private void DFShelper(ArrayList<Integer> tree, int x, String path) {

        if (tree == null || x >= tree.size() || tree.get(x) == null)
            return;

        if (!path.isEmpty()) path += "->";
        path += tree.get(x);

        int left = 2 * x + 1;
        int right = 2 * x + 2;

        boolean isLeaf = 
            (left >= tree.size() || tree.get(left) == null) &&
            (right >= tree.size() || tree.get(right) == null);

        if (isLeaf) {
            treePaths.add(path);
            return;
        }

        DFShelper(tree, left, path);
        DFShelper(tree, right, path);
    }

    public void showPaths() {
        for (String s : treePaths) {
            System.out.println(s);
        }
    }
}

public class p3 {
    public static void main(String[] args) {

        ArrayList<Integer> tree = new ArrayList<>(
                Arrays.asList(1, 
                                2, 3, 
                                4, 5, 6, 7, 
                                8, 9, 10, 11, 12, 13, 14, 15,
                                null, null, 16, 17, null, null, 18, 19, null, null, null, null, 20, 21, null, 22)
        );

        DFS trav = new DFS(tree);
        trav.showPaths();
    }
}
