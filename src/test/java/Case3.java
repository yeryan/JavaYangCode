import com.yzk18.GUI.GUI;
import com.yzk18.commons.IOHelpers;

public class Case3 {
    public static void main(String[] args) {
        String savePath = GUI.dirSaveBox("选择保存的文件夹");
        boolean input = true;
        while (input) {                            // do while
            String[] userMessage = GUI.multiInputBox("输入个人信息", "姓名", "性别", "邮箱");
            writeMessage one = new writeMessage();
            one.writeMessage(savePath, userMessage);
            input = GUI.yesNoBox("是否继续输入");
        }
        GUI.msgBox("完成");
    }
}

class writeMessage {
    public void writeMessage(String savePath, String[] userMessage) {
        for (int i = 0; i < userMessage.length; i++) {
            String name = userMessage[0];
            String[] a = {name, "\t", userMessage[1], "\t", userMessage[2]};
            IOHelpers.writeAllLines(savePath + "\\" + name + ".txt", a);
        }
    }
}