package top.clearlight.book.coretech.logging;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.*;

public class LoggingImageViewer {

    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null
                && System.getProperty("java.util.logging.config.file") == null) {
            try {
                // 获得给定名字的日志记录器.如果这个日志记录器不存在,创建一个日志记录器
                Logger.getLogger("top.clearlight.book.coretech").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                // 构造一个文件处理器
                /*
                pattern 构造日志文件名的模式
                limit 在打开一个新日志文件之前,日志文件可以包含的近似最大字节数
                count 循环序列的文件数量
                append 新构造的文件处理器对象应该追加在一个已存在的日志文件尾部.则为true.
                 */
                Handler handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("top.clearlight.book.coretech").addHandler(handler);
            } catch (IOException e) {
                Logger.getLogger("top.clearlight.book.coretech").log(Level.SEVERE, "Can't create log file handler", e);
            }
        }

        EventQueue.invokeLater(() -> {
            Handler windowHandler = new WindowHandler();
            // 获得和设置这个日志记录器的级别
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("top.clearlight.book.coretech").addHandler(windowHandler);

            JFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("top.clearlight.book.coretech").fine("Showing frame");
            frame.setVisible(true);
        });
    }

}

class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;
    private static Logger logger = Logger.getLogger("top.clearlight.book.coretech");

    public ImageViewerFrame() {
        // 记录一个描述进入/退出方法的日志记录,其中应该包括给定参数和返回值
        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // set up menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.fine("Exiting");
                System.exit(0);
            }
        });

        // use a label to display the images
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame", "<init>");
    }

    private class FileOpenListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", event);

            // set up file chooser
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            // accept all files ending with.gif
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {

                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF Images";
                }
            });

            // show file chooser dialog
            int r = chooser.showOpenDialog(ImageViewerFrame.this);

            // if image file accepted, set it as icon of the label
            if (r == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                // 记录一个给定级别和消息的日志记录,其中可以包括对象或者可抛出对象. 要想包括对象,消息中必须包含格式化占位符{0},{1}等
                logger.log(Level.FINE, "Reading file {0}", name);
                label.setIcon(new ImageIcon(name));
            } else {
                logger.fine("File open dialog canceled.");
            }
            logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
        }
    }
}

class WindowHandler extends StreamHandler {
    private JFrame frame;

    public WindowHandler() {
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200, 200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }

            public void write(byte[] b, int off, int len) {
                output.append(new String(b, off, len));
            }
        });
    }

    // 将日志记录发送到希的目的地
    public void publish(LogRecord record) {
        if (!frame.isVisible()) {
            return;
        }
        super.publish(record);
        flush();
    }
}