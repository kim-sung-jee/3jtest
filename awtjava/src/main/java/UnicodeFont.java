import com.sun.tools.javac.Main;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class UnicodeFont {
    public static void main(String[] args) throws IOException, FontFormatException {
        //File file = new File("C:\\Users\\lsvk3_myhkka7\\fontglyph\\awtjava\\src\\main\\resources\\abcd.ttf");
        String fName = "C:\\Users\\lsvk3_myhkka7\\fontglyph\\awtjava\\src\\main\\resources\\abcd.ttf";

        InputStream is = Main.class.getResourceAsStream(fName);

        Font font1= Font.createFont(Font.TRUETYPE_FONT,is);
    }
}
