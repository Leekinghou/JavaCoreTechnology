package v1ch02;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author: lijinhao
 * @date: 2021/10/27 18:04
 */

public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("图片查看器");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/*
    一个可以展示带有标签的图片的框架
 */
class ImageViewerFrame extends JFrame{
    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    // 构造函数
    public ImageViewerFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // 使用一个label去展示图片
        label = new JLabel();
        add(label);

        // 设置文件选择器
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // 设置菜单栏
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("文件");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("打开");
        menu.add(openItem);
        // 监听用户动作
        openItem.addActionListener(event ->{
            // 展示文件选择日志
            int result = chooser.showOpenDialog(null);

            // 如果文件已经被选择，将文件设置为标签的标志
            if(result == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        JMenuItem exitItem = new JMenuItem("退出");
        menuBar.add(exitItem);
        exitItem.addActionListener(event ->System.exit(0));

    }
}