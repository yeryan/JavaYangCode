public class TestCase1 {
    public static void main(String[] args) {
        double money = 5000;
        int count = 0;
        while(money>=1000){
            if(money > 50000){
                money = 0.95*money;
                count += 1;
            }else{
                money -= 1000;
                count += 1;
            }
        }
        System.out.println("共经过" + count + "个路口。");
    }
}
