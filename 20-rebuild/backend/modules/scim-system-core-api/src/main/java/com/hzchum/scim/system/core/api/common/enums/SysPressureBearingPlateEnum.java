package com.hzchum.scim.system.core.api.common.enums;

import com.hzchum.scim.system.core.api.pojo.dto.SysEnclosureDictionarySimpleDTO;
import java.util.ArrayList;
import java.util.List;

public enum SysPressureBearingPlateEnum {
   MODE("mode", "类型"),
   PLATE_TYPE("plate_type", "板型"),
   THICKNESS("thickness", "板厚(mm)"),
   BRAND("brand", "品牌"),
   COATING("coating", "涂层"),
   PLATING("plating", "镀层"),
   YIELD_STRENGTH("yield_strength", "屈服强度(mpa)");

   private final String name;
   private final String remark;

   public static boolean checkName(String name) {
      for (SysPressureBearingPlateEnum ele : values()) {
         if (ele.getName().equals(name)) {
            return true;
         }
      }

      return false;
   }

   public static String getRemarkByName(String name) {
      for (SysPressureBearingPlateEnum ele : values()) {
         if (ele.getName().equals(name)) {
            return ele.getRemark();
         }
      }

      return null;
   }

   public static List<SysEnclosureDictionarySimpleDTO> listAll() {
      List<SysEnclosureDictionarySimpleDTO> responseVOS = new ArrayList<>();

      for (SysPressureBearingPlateEnum ele : values()) {
         SysEnclosureDictionarySimpleDTO responseVO = new SysEnclosureDictionarySimpleDTO();
         responseVO.setRemark(ele.getRemark());
         responseVO.setName(ele.getName());
         responseVOS.add(responseVO);
      }

      return responseVOS;
   }

   SysPressureBearingPlateEnum(final String name, final String remark) {
      this.name = name;
      this.remark = remark;
   }

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }
}
