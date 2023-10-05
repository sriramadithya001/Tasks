public class RectangleAreaCalculator {
    public static void main(String[] args) {
        class Rectangle {
            int length, breadth;
            public Rectangle(int length, int breadth) {
                this.length = length;
                this.breadth = breadth;
            }
            public int Area() {
                return length * breadth;
            }
        }
        Rectangle first_rectangle = new Rectangle(4,5);
        Rectangle second_rectangle = new Rectangle(5,8);
        first_rectangle.Area();
        second_rectangle.Area();
    }
}