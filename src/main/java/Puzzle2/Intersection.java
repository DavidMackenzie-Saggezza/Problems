package Puzzle2;

public class Intersection {
    public static Node getIntersection(LinkedList ll1, LinkedList ll2){
        Node current1 = ll1.getHead();
        Node current2 = ll2.getHead();
        while (current1 != null) {
            while(current2 != null) {
                if (current1 == current2) {
                    return current1;
                }
                current2 = current2.getNext();
            }
            current1 = current1.getNext();
            current2 = ll2.getHead();
        }
        return null;
    }
}
