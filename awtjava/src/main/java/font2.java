import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class font2 {
    public static void main(String[] args) throws IOException, FontFormatException {

//        BufferedImage bufferedImage
//                =
        BufferedImage bufferedImage = null;
        try{
            String fontPath = "C:\\Users\\lsvk3_myhkka7\\fontglyph\\awtjava\\src\\main\\resources\\NanumGothic.ttf";
            bufferedImage = stringToBufferedImage("ㄱ",fontPath);

            File outputFile = new File("OCR-B.png");
            ImageIO.write(bufferedImage,"png",outputFile);

        }catch ( IOException e){
            e.printStackTrace();
        }
        JFrame jFrame = new JFrame("OCR-B");
        jFrame.add(new OCRDrawPane(bufferedImage));
        jFrame.setVisible(true);
        jFrame.pack();

    }
    public static BufferedImage stringToBufferedImage(String s,String fontPath) throws IOException, FontFormatException {
        //First, we have to calculate the string's width and height

        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = img.getGraphics();

        //Set the font to be used when drawing the string
        Font f = Font.createFont(Font.TRUETYPE_FONT,new File(fontPath));
        g.setFont(f);

        //Get the string visual bounds
        FontRenderContext frc = g.getFontMetrics().getFontRenderContext();
        GlyphVector glyphVector = f.createGlyphVector(frc, s);
        Shape outline = glyphVector.getOutline();
        int numGlyphs = glyphVector.getNumGlyphs();
        System.out.println("abcd"+outline.getBounds()+" "+numGlyphs);
        System.out.println(glyphVector.getGlyphOutline(0).getBounds());
        System.out.println(glyphVector.getGlyphCharIndex(0));
        System.out.println(glyphVector.getGlyphCode(0));
        System.out.println(glyphVector.getGlyphMetrics(0).getAdvance());
        Rectangle2D rect = f.getStringBounds(s, frc);
        //Release resources
        g.dispose();

        //Then, we have to draw the string on the final image

        //Create a new image where to print the character
        img = new BufferedImage((int) Math.ceil(rect.getWidth()), (int) Math.ceil(rect.getHeight()), BufferedImage.TYPE_4BYTE_ABGR);
        g = img.getGraphics();
        g.setColor(Color.black); //Otherwise the text would be white
        g.setFont(f);

        //Calculate x and y for that string
        FontMetrics fm = g.getFontMetrics();
        int x = 0;
        int y = fm.getAscent(); //getAscent() = baseline
        g.drawString(s, x, y);

        //Release resources
        g.dispose();

        //Return the image
        return img;
    }
    static final class OCRDrawPane extends JPanel{
        private static final long serialVersionUID = 1L;
        final BufferedImage bufImg;
        OCRDrawPane(final BufferedImage bufImg){
            this.bufImg = bufImg;
        }
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(bufImg.getWidth(),bufImg.getHeight());
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            if(bufImg!=null){
                Graphics2D g2d = (Graphics2D) g.create();
                int x = (getWidth()-bufImg.getWidth())/2;
                int y =(getHeight()- bufImg.getHeight())/2;
                g2d.drawImage(bufImg,x,y,this);
                g2d.dispose();
            }
        }
    }
}
