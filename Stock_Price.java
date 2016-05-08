import java.util.Scanner;

/**
 * Created by Vishal on 4/27/2016.
 */
public class stockPrice {
    private static class Node{
        Node left, right;
        int time, value;

        Node(int newTiem, int newValue){
            left = right = null;
            time = newTiem;
            value = newValue;
        }
    }

    private static Node insert(Node node, int time, int data){
        if(node==null)
            node = new Node(time, data);
        else{
            if(time < node.time)
                node.left = insert(node.left, time, data);
            else
                node.right = insert(node.right, time, data);
        }
        return(node);
    }

    public static void main(String []args) throws Exception{
        Scanner in = new Scanner(System.in);
        Node root;
        int i=0, cnt=0, tim=0, num=0;
        cnt=in.nextInt();
        root=null;
        for(i=0; i<cnt; i++){
            tim=in.nextInt();
            num=in.nextInt();
            if(i == 0)
                root = new Node(tim, num);
            else
                insert(root, tim, num);
        }

        int q = in.nextInt();

        for(i=0; i<q; i++){
            int x=in.nextInt();
            System.out.println(findStockPrice(root,x));
        }
    }

    private static int findStockPrice(Node root, int t) {
/* For your reference
class Node {
		Node left, right;
		int time, value;
	}
*/
        int tMin = findMin(root), tMax = findMax(root);

        if(root == null || t < tMin)
            return -1;
        else if(t > tMax)
            return printMaxTime(root);
        else
            return findBetween(root,t);
    }

    private static int printMaxTime(Node root) {
        int max=0;
        if(root.right != null)
            max = printMaxTime(root.right);
        else
            return root.value;
        return max;
    }

    private static int findBetween(Node root, int t){
        int tTemp = 0;
        if(t == root.time)
            return root.value;
        else if(t < root.time){
            if(root.left != null)
                tTemp = findStockPrice(root.left, t);
            else
                return Integer.MIN_VALUE;
        }
        else if(t > root.time){
            if(root.right != null)
                tTemp = findStockPrice(root.right, t);
            else
                return Integer.MIN_VALUE;
        }
        else
            tTemp = root.value;

        if(tTemp != Integer.MIN_VALUE)
            return tTemp;
        else
            return root.value;
    }

    private static int findMin(Node root) {
        int min=0;
        if(root == null)
            return -1;
        else if(root.left != null)
            min = findMin(root.left);
        else
            min = root.time;
        return min;
    }

    private static int findMax(Node root) {
        int max=0;
        if(root == null)
            return -1;
        else if(root.right != null)
            max = findMin(root.right);
        else
            max = root.time;
        return max;
    }


}