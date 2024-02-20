package chapter_07;

// import java.awt.*;
// import java.awt.event.*;

// class Ex07_28_InnnerEx06 {
//     public static void main(String[] args) {
//         Button b = new Button("Start");
//         b.addActionListener(new EventHandler());
//     }
// }


/* Button객체 b의 addActionListener메서드의 매개변수로, EventHandler 클래스의 객체가 생성되어 전달된다.
이러한 EventHandler 클래스는 대부분 한번만 사용되고, 다시 사용되지 않는다. 따라서, 이러한 상황에는 해당 클래스를 따로 정의해주기 보다는,
익명클래스로 만들어서, addActionListener의 매개변수에서 선언과 동시에 객체를 생성하는 1회용 클래스로 만들어 주는 것이 더욱 효율적이다.*/

// class EventHandler implements ActionListener {
//     public void actionPerformed(ActionEvent e) {
//         System.out.println("Action occurred.");
//     }
// }

import java.awt.*;
import java.awt.event.*;

class Ex07_28_InnerEx06 {
    public static void main(String[] args) {
        Button b = new Button("Start");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Actionoccurred.");
            }
        });
    }
}