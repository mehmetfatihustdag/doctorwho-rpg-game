package com.company.util;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;


/**
 *
 * @author fustdag <br>
 *         <b> ASCII Art Utility to print ASCII String</b>
 *
 */
public class ASCIIArtUtil {

    /**
     * Prints the ASCII ART
     *
     * @param guiString
     *            - String you want to print in ASCII Art
     */
    public static void printAsci(String guiString) {
        try {
            System.out.println();
            int width = 80;
            int height = 35;

            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);

            Graphics g = image.getGraphics();
            g.setFont(new Font("SansSerif", Font.PLAIN, 17));

            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            graphics.drawString(guiString, 1, 20);

            for (int y = 0; y < height; y++) {
                StringBuilder sb = new StringBuilder();
                for (int x = 0; x < width; x++) {
                    sb.append(image.getRGB(x, y) == -16777216 ? " " : "*");
                }

                if (sb.toString().trim().isEmpty()) {
                    continue;
                }
                System.out.println(sb);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(guiString);
        }
    }
}
