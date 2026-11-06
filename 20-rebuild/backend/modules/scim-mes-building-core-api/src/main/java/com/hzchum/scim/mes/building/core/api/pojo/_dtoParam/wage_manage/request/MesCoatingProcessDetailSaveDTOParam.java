package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("涂装工艺详情表新增类")
public class MesCoatingProcessDetailSaveDTOParam {
   @ApiModelProperty(name = "paintType", value = "油漆类型(PaintingTypeEnum)", notes = "油漆类型(PaintingTypeEnum)")
   @EnumValidator(groups = {Add.class, Update.class}, value = PaintingTypeEnum.class, message = "油漆类型不存在")
   @NotNull(groups = {Add.class, Update.class}, message = "油漆类型不能为空")
   private Integer paintType;
   @ApiModelProperty(name = "paintBrand", value = "油漆品牌", notes = "油漆品牌")
   @NotBlank(groups = {Add.class, Update.class}, message = "油漆品牌不能为空")
   private String paintBrand;
   @ApiModelProperty(name = "paintCategory", value = "油漆种类", notes = "油漆种类")
   private String paintCategory;
   @ApiModelProperty(name = "thickness", value = "干膜厚度(μm)", notes = "干膜厚度(μm)")
   @NotNull(groups = {Add.class, Update.class}, message = "干膜厚度(μm)不能为空")
   private Integer thickness;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static MesCoatingProcessDetailSaveDTOParam.MesCoatingProcessDetailSaveDTOParamBuilder builder() {
      return new MesCoatingProcessDetailSaveDTOParam.MesCoatingProcessDetailSaveDTOParamBuilder();
   }

   public MesCoatingProcessDetailSaveDTOParam() {
   }

   public MesCoatingProcessDetailSaveDTOParam(
      final Integer paintType, final String paintBrand, final String paintCategory, final Integer thickness, final String remark
   ) {
      this.paintType = paintType;
      this.paintBrand = paintBrand;
      this.paintCategory = paintCategory;
      this.thickness = thickness;
      this.remark = remark;
   }

   public Integer getPaintType() {
      return this.paintType;
   }

   public String getPaintBrand() {
      return this.paintBrand;
   }

   public String getPaintCategory() {
      return this.paintCategory;
   }

   public Integer getThickness() {
      return this.thickness;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setPaintType(final Integer paintType) {
      this.paintType = paintType;
   }

   public void setPaintBrand(final String paintBrand) {
      this.paintBrand = paintBrand;
   }

   public void setPaintCategory(final String paintCategory) {
      this.paintCategory = paintCategory;
   }

   public void setThickness(final Integer thickness) {
      this.thickness = thickness;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesCoatingProcessDetailSaveDTOParam)) {
         return false;
      }

      MesCoatingProcessDetailSaveDTOParam other = (MesCoatingProcessDetailSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paintType = this.getPaintType();
      Object other$paintType = other.getPaintType();
      if (this$paintType == null ? other$paintType == null : this$paintType.equals(other$paintType)) {
         Object this$thickness = this.getThickness();
         Object other$thickness = other.getThickness();
         if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
            Object this$paintBrand = this.getPaintBrand();
            Object other$paintBrand = other.getPaintBrand();
            if (this$paintBrand == null ? other$paintBrand == null : this$paintBrand.equals(other$paintBrand)) {
               Object this$paintCategory = this.getPaintCategory();
               Object other$paintCategory = other.getPaintCategory();
               if (this$paintCategory == null ? other$paintCategory == null : this$paintCategory.equals(other$paintCategory)) {
                  Object this$remark = this.getRemark();
                  Object other$remark = other.getRemark();
                  return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof MesCoatingProcessDetailSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paintType = this.getPaintType();
      result = result * 59 + ($paintType == null ? 43 : $paintType.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $paintBrand = this.getPaintBrand();
      result = result * 59 + ($paintBrand == null ? 43 : $paintBrand.hashCode());
      Object $paintCategory = this.getPaintCategory();
      result = result * 59 + ($paintCategory == null ? 43 : $paintCategory.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "MesCoatingProcessDetailSaveDTOParam(paintType="
         + this.getPaintType()
         + ", paintBrand="
         + this.getPaintBrand()
         + ", paintCategory="
         + this.getPaintCategory()
         + ", thickness="
         + this.getThickness()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class MesCoatingProcessDetailSaveDTOParamBuilder {
      private Integer paintType;
      private String paintBrand;
      private String paintCategory;
      private Integer thickness;
      private String remark;

      MesCoatingProcessDetailSaveDTOParamBuilder() {
      }

      public MesCoatingProcessDetailSaveDTOParam.MesCoatingProcessDetailSaveDTOParamBuilder paintType(final Integer paintType) {
         this.paintType = paintType;
         return this;
      }

      public MesCoatingProcessDetailSaveDTOParam.MesCoatingProcessDetailSaveDTOParamBuilder paintBrand(final String paintBrand) {
         this.paintBrand = paintBrand;
         return this;
      }

      public MesCoatingProcessDetailSaveDTOParam.MesCoatingProcessDetailSaveDTOParamBuilder paintCategory(final String paintCategory) {
         this.paintCategory = paintCategory;
         return this;
      }

      public MesCoatingProcessDetailSaveDTOParam.MesCoatingProcessDetailSaveDTOParamBuilder thickness(final Integer thickness) {
         this.thickness = thickness;
         return this;
      }

      public MesCoatingProcessDetailSaveDTOParam.MesCoatingProcessDetailSaveDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesCoatingProcessDetailSaveDTOParam build() {
         return new MesCoatingProcessDetailSaveDTOParam(this.paintType, this.paintBrand, this.paintCategory, this.thickness, this.remark);
      }

      @Override
      public String toString() {
         return "MesCoatingProcessDetailSaveDTOParam.MesCoatingProcessDetailSaveDTOParamBuilder(paintType="
            + this.paintType
            + ", paintBrand="
            + this.paintBrand
            + ", paintCategory="
            + this.paintCategory
            + ", thickness="
            + this.thickness
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
