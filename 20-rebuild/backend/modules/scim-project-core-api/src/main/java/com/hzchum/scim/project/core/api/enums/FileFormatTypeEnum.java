package com.hzchum.scim.project.core.api.enums;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public enum FileFormatTypeEnum {
   ARCHIVE(1),
   PICTURE(2),
   PDF(4);

   private final Integer type;

   public static Integer getTypeBySuffix(String suffix) {
      Preconditions.checkArgument(StringUtils.isNotBlank(suffix), "文件名后缀为空");
      List<String> archiveList = Arrays.asList("ZIP", "RAR");
      List<String> pictureList = Arrays.asList("JPG", "JPEG", "GIF", "BMP", "PNG");
      if (archiveList.contains(suffix.toUpperCase())) {
         return ARCHIVE.getType();
      } else if (pictureList.contains(suffix.toUpperCase())) {
         return PICTURE.getType();
      } else {
         return "PDF".equalsIgnoreCase(suffix) ? PDF.getType() : null;
      }
   }

   public static List<Integer> getTypes(Integer format) {
      return Arrays.stream(values()).map(FileFormatTypeEnum::getType).filter(type -> (format & type) > 0).collect(Collectors.toList());
   }

   public Integer getType() {
      return this.type;
   }

   FileFormatTypeEnum(final Integer type) {
      this.type = type;
   }
}
