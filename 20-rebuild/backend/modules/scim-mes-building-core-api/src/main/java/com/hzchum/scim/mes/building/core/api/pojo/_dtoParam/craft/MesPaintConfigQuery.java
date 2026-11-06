package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("油漆配置Query")
public class MesPaintConfigQuery {
   @ApiModelProperty("涂装类型")
   private Integer paintingTypeEnum;
   @ApiModelProperty("油漆品牌")
   private String paintBrand;
   @ApiModelProperty("油漆类型")
   private String paintType;
   @ApiModelProperty("油漆品牌List")
   private List<String> paintBrandList;
   @ApiModelProperty("油漆类型List")
   private List<String> paintTypeList;

   public Integer getPaintingTypeEnum() {
      return this.paintingTypeEnum;
   }

   public String getPaintBrand() {
      return this.paintBrand;
   }

   public String getPaintType() {
      return this.paintType;
   }

   public List<String> getPaintBrandList() {
      return this.paintBrandList;
   }

   public List<String> getPaintTypeList() {
      return this.paintTypeList;
   }

   public void setPaintingTypeEnum(final Integer paintingTypeEnum) {
      this.paintingTypeEnum = paintingTypeEnum;
   }

   public void setPaintBrand(final String paintBrand) {
      this.paintBrand = paintBrand;
   }

   public void setPaintType(final String paintType) {
      this.paintType = paintType;
   }

   public void setPaintBrandList(final List<String> paintBrandList) {
      this.paintBrandList = paintBrandList;
   }

   public void setPaintTypeList(final List<String> paintTypeList) {
      this.paintTypeList = paintTypeList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintConfigQuery)) {
         return false;
      }

      MesPaintConfigQuery other = (MesPaintConfigQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paintingTypeEnum = this.getPaintingTypeEnum();
      Object other$paintingTypeEnum = other.getPaintingTypeEnum();
      if (this$paintingTypeEnum == null ? other$paintingTypeEnum == null : this$paintingTypeEnum.equals(other$paintingTypeEnum)) {
         Object this$paintBrand = this.getPaintBrand();
         Object other$paintBrand = other.getPaintBrand();
         if (this$paintBrand == null ? other$paintBrand == null : this$paintBrand.equals(other$paintBrand)) {
            Object this$paintType = this.getPaintType();
            Object other$paintType = other.getPaintType();
            if (this$paintType == null ? other$paintType == null : this$paintType.equals(other$paintType)) {
               Object this$paintBrandList = this.getPaintBrandList();
               Object other$paintBrandList = other.getPaintBrandList();
               if (this$paintBrandList == null ? other$paintBrandList == null : this$paintBrandList.equals(other$paintBrandList)) {
                  Object this$paintTypeList = this.getPaintTypeList();
                  Object other$paintTypeList = other.getPaintTypeList();
                  return this$paintTypeList == null ? other$paintTypeList == null : this$paintTypeList.equals(other$paintTypeList);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesPaintConfigQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paintingTypeEnum = this.getPaintingTypeEnum();
      result = result * 59 + ($paintingTypeEnum == null ? 43 : $paintingTypeEnum.hashCode());
      Object $paintBrand = this.getPaintBrand();
      result = result * 59 + ($paintBrand == null ? 43 : $paintBrand.hashCode());
      Object $paintType = this.getPaintType();
      result = result * 59 + ($paintType == null ? 43 : $paintType.hashCode());
      Object $paintBrandList = this.getPaintBrandList();
      result = result * 59 + ($paintBrandList == null ? 43 : $paintBrandList.hashCode());
      Object $paintTypeList = this.getPaintTypeList();
      return result * 59 + ($paintTypeList == null ? 43 : $paintTypeList.hashCode());
   }

   @Override
   public String toString() {
      return "MesPaintConfigQuery(paintingTypeEnum="
         + this.getPaintingTypeEnum()
         + ", paintBrand="
         + this.getPaintBrand()
         + ", paintType="
         + this.getPaintType()
         + ", paintBrandList="
         + this.getPaintBrandList()
         + ", paintTypeList="
         + this.getPaintTypeList()
         + ")";
   }
}
