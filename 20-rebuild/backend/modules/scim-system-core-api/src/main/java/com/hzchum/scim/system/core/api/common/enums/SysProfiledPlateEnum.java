package com.hzchum.scim.system.core.api.common.enums;

import com.hzchum.scim.system.core.api.pojo.dto.SysEnclosureDictionarySimpleDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum SysProfiledPlateEnum {
   BRAND("brand", "品牌"),
   THICKNESS("thickness", "厚度(mm)"),
   PLATE_TYPE("plate_type", "板型"),
   CLADDING("cladding", "镀层"),
   COLOR("color", "颜色"),
   COATING("coating", "涂层"),
   YIELD_STRENGTH("yield_strength", "屈服强度(mpa)");

   private String name;
   private String remark;

   public static String getRemarkByName(String name) {
      for (SysProfiledPlateEnum ele : values()) {
         if (ele.getName().equals(name)) {
            return ele.getRemark();
         }
      }

      return null;
   }

   public static boolean isExist(String name) {
      Optional<SysProfiledPlateEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getName().equals(name)).findFirst();
      return optional.isPresent();
   }

   public static boolean checkName(String name) {
      for (SysProfiledPlateEnum ele : values()) {
         if (ele.getName().equals(name)) {
            return true;
         }
      }

      return false;
   }

   public static List<SysEnclosureDictionarySimpleDTO> listAll() {
      List<SysEnclosureDictionarySimpleDTO> responseVOS = new ArrayList<>();

      for (SysProfiledPlateEnum ele : values()) {
         SysEnclosureDictionarySimpleDTO responseVO = new SysEnclosureDictionarySimpleDTO();
         responseVO.setRemark(ele.getRemark());
         responseVO.setName(ele.getName());
         responseVOS.add(responseVO);
      }

      return responseVOS;
   }

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   SysProfiledPlateEnum(final String name, final String remark) {
      this.name = name;
      this.remark = remark;
   }
}
