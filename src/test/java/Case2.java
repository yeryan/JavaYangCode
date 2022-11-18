import com.yzk18.GUI.GUI;

public class Case2 {
    public static void main(String[] args) {
        boolean gender = GUI.buttonsBox("请选择性别", "男", "女").equals("男");
        double height = GUI.doubleBox("请输入身高(cm)");
        double weight = GUI.doubleBox("请输入体重(Kg)");
        Weight a = new Weight();
        double stanWei = a.stanWeight(gender, height);
        a.compare(stanWei, weight);

    }
}

class Weight {
    public double stanWeight(boolean gender, double height) {
        double s = 0;
        if (gender) {
            s = (height - 80) * 0.7;
        } else {
            s = (height - 70) * 0.6;
        }
        return s;
    }

    public void compare(double stanWeight, double weight) {
        double a = (weight - stanWeight) / stanWeight;
        if (a < 0.1 || a > -0.1) {
            GUI.msgBox("正常体重");
        } else if ((a >= 0.1 && a < 0.2) || (a <= -0.1 && a > -0.2)) {
            GUI.msgBox("偏胖或偏瘦");
        } else {
            GUI.msgBox("严重肥胖或严重瘦弱");
        }
    }
}