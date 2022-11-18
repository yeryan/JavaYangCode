public class TestCase2 {
    public static void main(String[] args) {
        Tower a = new Tower();
        a.MoveTower(3, 'a', 'b', 'c');
    }
}

class Tower {
    public void MoveTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println(a + "\tto\t" + c);
        } else {
            MoveTower(num - 1, a, c, b);
            MoveTower(1, a, b, c);
            MoveTower(num - 1, b, a, c);
        }
    }
}