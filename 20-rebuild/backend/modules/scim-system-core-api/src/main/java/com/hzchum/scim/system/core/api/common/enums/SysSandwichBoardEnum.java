package com.hzchum.scim.system.core.api.common.enums;

import com.hzchum.scim.system.core.api.pojo.dto.SysEnclosureDictionarySimpleDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum SysSandwichBoardEnum {
   THICKNESS("thickness", "厚度(mm)"),
   PLATE_TYPE("plate_type", "板型"),
   EFFECTIVE_WIDTH("effective_width", "有效宽度(mm)"),
   OUT_MATERIAL("out_material", "外板钢板材质"),
   OUT_COATING("out_coating", "外板钢板涂层"),
   OUT_PLATING("out_plating", "外板钢板镀层"),
   OUT_STEEL_PLATE_BRAND("out_steel_plate_brand", "外板钢板品牌"),
   OUT_THICKNESS("out_thickness", "外板钢板厚度"),
   OUT_COLOUR("out_colour", "外板钢板颜色"),
   OUT_EFFECTIVE_WIDTH("out_effective_width", "外板钢板宽度"),
   OUT_PLATE_SHAPE("out_plate_shape", "外板钢板形状"),
   IN_MATERIAL("in_material", "内板钢板材质"),
   IN_COATING("in_coating", "内板钢板涂层"),
   IN_PLATING("in_plating", "内板钢板镀层"),
   IN_STEEL_PLATE_BRAND("in_Steel_Plate_brand", "内板钢板品牌"),
   IN_THICKNESS("in_thickness", "内板钢板厚度"),
   IN_EFFECTIVE_WIDTH("in_effective_width", "内板钢板宽度"),
   IN_PLATESHAPE("in_plate_shape", "内板钢板形状"),
   IN_COLOUR("in_colour", "内板钢板颜色"),
   KIND_CORE("kind_core", "芯材种类"),
   BRAND_CORE("brand_core", "芯材品牌"),
   UNIT_WEIGHT_CORE("unit_weight_core", "芯材容重(kg/m³)");

   private String name;
   private String remark;

   public static String getRemarkByName(String name) {
      for (SysSandwichBoardEnum ele : values()) {
         if (ele.getName().equals(name)) {
            return ele.getRemark();
         }
      }

      return null;
   }

   public static boolean isExist(String name) {
      Optional<SysSandwichBoardEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getName().equals(name)).findFirst();
      return optional.isPresent();
   }

   public static boolean checkName(String name) {
      for (SysSandwichBoardEnum ele : values()) {
         if (ele.getName().equals(name)) {
            return true;
         }
      }

      return false;
   }

   public static List<SysEnclosureDictionarySimpleDTO> listAll() {
      List<SysEnclosureDictionarySimpleDTO> responseVOS = new ArrayList<>();

      for (SysSandwichBoardEnum ele : values()) {
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

   SysSandwichBoardEnum(final String name, final String remark) {
      this.name = name;
      this.remark = remark;
   }
}
