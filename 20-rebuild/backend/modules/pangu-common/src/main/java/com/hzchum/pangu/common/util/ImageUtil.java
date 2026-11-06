package com.hzchum.pangu.common.util;

import java.io.IOException;
import java.io.InputStream;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageUtil {
   private static final Logger log = LoggerFactory.getLogger(ImageUtil.class);

   private ImageUtil() {
   }

   public static void imgThumb(InputStream source, String output, int width, int height) throws IOException {
      Thumbnails.of(source).size(width, height).toFile(output);
   }

   public static void imgScale(InputStream source, String output, double scale) throws IOException {
      Thumbnails.of(source).scale(scale).toFile(output);
   }
}
