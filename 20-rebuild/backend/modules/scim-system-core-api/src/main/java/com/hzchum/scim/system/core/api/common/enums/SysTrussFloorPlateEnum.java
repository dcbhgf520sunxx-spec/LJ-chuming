package com.hzchum.scim.system.core.api.common.enums;

import com.hzchum.scim.system.core.api.pojo.dto.SysEnclosureDictionarySimpleDTO;
import java.util.ArrayList;
import java.util.List;

public enum SysTrussFloorPlateEnum {
   FIRST_QUARTER("firstQuarter", "上弦(mm)"),
   LAST_QUARTER("lastQuarter", "下弦(mm)"),
   WEB_MEMBER("webMember", "腹杆(mm)"),
   VERTICAL("vertical", "竖向(mm)"),
   LEVEL("level", "水平(mm)"),
   BASEMENT_MEMBRANE("basementMembrane", "底膜(mm)"),
   EFFECTIVE_WIDTH("effectiveWidth", "有效宽度(mm)"),
   WEIGHT_METER("weightMeter", "重量(kg)/m");

   private final String name;
   private final String remark;

   public static boolean checkName(String name) {
      for (SysTrussFloorPlateEnum ele : values()) {
         if (ele.getName().equals(name)) {
            return true;
         }
      }

      return false;
   }

   public static String getRemarkByName(String name) {
      for (SysTrussFloorPlateEnum ele : values()) {
         if (ele.getName().equals(name)) {
            return ele.getRemark();
         }
      }

      return null;
   }

   public static List<SysEnclosureDictionarySimpleDTO> listAll() {
      List<SysEnclosureDictionarySimpleDTO> responseVOS = new ArrayList<>();

      for (SysTrussFloorPlateEnum ele : values()) {
         SysEnclosureDictionarySimpleDTO responseVO = new SysEnclosureDictionarySimpleDTO();
         responseVO.setRemark(ele.getRemark());
         responseVO.setName(ele.getName());
         responseVOS.add(responseVO);
      }

      return responseVOS;
   }

   SysTrussFloorPlateEnum(final String name, final String remark) {
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
