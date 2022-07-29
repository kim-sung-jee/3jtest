import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.AttributedCharacterIterator;

public class TEST3 {
    public static void main(String[] args) throws IOException, FontFormatException {



        Font font = openFontTTF();
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = img.getGraphics();
        g.setFont(font);
        FontRenderContext fontRenderContext = g.getFontMetrics().getFontRenderContext();
        GlyphVector glyphVector = font.createGlyphVector(fontRenderContext,"a");

        System.out.println(g.getFontMetrics().getFont());
        System.out.println(glyphVector.getGlyphOutline(0).getBounds());
        System.out.println(glyphVector.getGlyphLogicalBounds(0).getBounds());
        System.out.println(glyphVector.getGlyphCode(0));
        System.out.println(glyphVector.getGlyphOutline(0).getBounds2D());
//        System.out.println(glyphVector.getGlyphOutline(0).getBounds2D().getY());
        System.out.println(glyphVector.getGlyphCharIndex(0));



    }


    public static Font openFontTTF() throws IOException, FontFormatException {
        String fontPath = "C:\\Users\\lsvk3_myhkka7\\web3jANDjs\\awtjava\\src\\main\\resources\\NanumGothic.ttf";
        Font font = Font.createFont(Font.TRUETYPE_FONT,new File(fontPath));
        return font.deriveFont(12f);
    }
}
