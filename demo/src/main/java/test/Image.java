package test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

/**
 * Created by 845477519@qq.com on 2017/10/13 0013.
 */
public class Image extends JFrame {

    private JLabel label;
    private Icon icon;
    private Image image;

    private String text;

    public Image(String text){
        try{
            setTitle("支付宝收款码");
            setSize(300,300);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            label = new JLabel("alipay", SwingConstants.CENTER);
            add(label);
            setVisible(true);
            Hashtable hints = new Hashtable();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, 300, 300,hints);
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for(int x = 0;x < width; x++){
                for(int y = 0;y < height; y++){
                    image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }
            icon = new ImageIcon(image);
        }catch(Exception e){
            System.out.println("生成二维码错误"+e.getMessage());
        }
        label.setIcon(icon);
    }
}
