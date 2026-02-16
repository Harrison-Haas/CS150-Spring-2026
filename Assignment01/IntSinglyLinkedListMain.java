public class IntSinglyLinkedListMain {
    public static void main(String[] args){
        IntSinglyLinkedList list = new IntSinglyLinkedList();
        System.out.println("Initial List: " +  list);
        list.addFirst(2);
        System.out.println("Add first: " + list);
        list.addFirst(3);
        System.out.println("Add first: " + list);
        list.addLast(1);
        System.out.println("Add last: " + list);
        list.addLast(0);
        System.out.println("Add last: " + list);
        System.out.println("Get index 2: " + list.get(2));
        list.removeFirst();
        System.out.println("Remove first: " + list);
        System.out.println("Remove value of 0: " + list.removeValue(0));
        System.out.println("Remove value of 0: " + list);
        System.out.println("Remove value of 4: " + list.removeValue(4));
        System.out.println("Remove value of 4: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("IsEmpty: " + list.isEmpty());
    }
}