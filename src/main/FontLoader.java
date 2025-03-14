package main;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {

    public static Font loadFont(String path, float size) {
        try {
            File fontFile = new File(path);
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont;
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Serif", Font.PLAIN, (int) size); // Fallback font
        }
    }

    public static Font loadFontFromResource(String resourcePath, float size) {
        try {
            InputStream is = FontLoader.class.getResourceAsStream(resourcePath);
            if (is == null) {
                throw new IOException("Font resource not found: " + resourcePath);
            }
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont;
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Serif", Font.PLAIN, (int) size); // Fallback font
        }
    }

}
