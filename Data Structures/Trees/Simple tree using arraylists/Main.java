public class Main {
        public static void main(String[] args) {
            treenode numbers = new treenode("numbers");
            treenode odds = new treenode("odd");
            treenode even = new treenode("even");
            treenode one = new treenode("one");
            treenode two = new treenode("two");
            treenode three = new treenode("three");
            treenode four = new treenode("four");
            treenode five = new treenode("five");
            treenode six = new treenode("six");

            numbers.addNode(odds);
            numbers.addNode(even);
            odds.addNode(one);
            odds.addNode(three);
            three.addNode(five);
            even.addNode(two);
            even.addNode(four);
            four.addNode(six);

            System.out.println(numbers.printnode(0));
        }
}
