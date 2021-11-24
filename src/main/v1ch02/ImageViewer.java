package v1ch02;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author: lijinhao
 * @date: 2021/11/12 10:41
 */
public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ImageViewerFrame extends JFrame{
    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        label = new JLabel();
        add(label);

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("open");
        menu.add(openItem);

        openItem.addActionListener(event -> {
            int result = chooser.showOpenDialog(null);

            // if file selected, set it as icon of the label
            if(result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });
        JMenuItem exitItem = new JMenuItem("exit");
        menu.add(exitItem);

        exitItem.addActionListener(event -> System.exit(0));
    }
}
