import java.util.*;
import javax.swing.*;


class Dialogbox{

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("my first notepad");

        JLabel label = new JLabel("note pad ");

        frame.add(label);

        frame.setSize(300,200);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        
    }
}