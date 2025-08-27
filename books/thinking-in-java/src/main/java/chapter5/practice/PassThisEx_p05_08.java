package chapter5.practice;

/**
 * @author liu.hua
 */
class Doc {
   void intubate() {
       System.out.println();
       // 测试this 在父类调用方法和字段。加this和不加this是否有区别多太。字段也需要测试（已经无多态，当前类里的字段值）
       laryngoscopy();
       this.laryngoscopy();
   }

   void laryngoscopy(){
       System.out.println("use laryngoscope");
   }
}
public class PassThisEx_p05_08 {
    public static void main(String[] args) {
        new Doc().intubate();
    }
}
