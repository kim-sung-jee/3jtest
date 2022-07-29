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
        System.out.println(g.getFontMetrics().getFont());
        FontRenderContext frc = g.getFontMetrics().getFontRenderContext();
        GlyphVector glyphVector = font.createGlyphVector(frc, "a");
        System.out.println(glyphVector.getGlyphOutline(0).getBounds());
        System.out.println(glyphVector.getGlyphCode(0));
        System.out.println(glyphVector.getGlyphCharIndex(0));
        System.out.println(glyphVector.getGlyphOutline(0).getBounds2D());
        GlyphVector glyphVector2 = font.createGlyphVector(frc, "b");
        System.out.println(glyphVector2.getGlyphOutline(0).getBounds());
        System.out.println(glyphVector2.getGlyphCode(0));
        System.out.println(glyphVector2.getGlyphCharIndex(0));
        System.out.println(glyphVector2.getGlyphOutline(0).getBounds2D());
        GlyphVector glyphVector3 = font.createGlyphVector(frc, "ㄱ");
        System.out.println(glyphVector3.getGlyphOutline(0).getBounds());
        System.out.println(glyphVector3.getGlyphCode(0));
        System.out.println(glyphVector3.getGlyphCharIndex(0));
        System.out.println(glyphVector3.getGlyphOutline(0).getBounds2D());
    }


    public static Font openFontTTF() throws IOException, FontFormatException {
        String fontPath = "C:\\Users\\lsvk3_myhkka7\\fontglyph\\awtjava\\src\\main\\resources\\NanumGothic.ttf";
        Font font = Font.createFont(Font.TRUETYPE_FONT,new File(fontPath));
        return font.deriveFont(12f);
    }
}
