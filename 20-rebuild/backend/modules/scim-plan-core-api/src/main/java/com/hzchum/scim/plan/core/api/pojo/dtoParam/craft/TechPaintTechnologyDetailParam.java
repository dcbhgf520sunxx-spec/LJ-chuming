package com.hzchum.scim.plan.core.api.pojo.dtoParam.craft;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.PaintingTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "TechpaintTechnologyDetail对象", description = "涂装工艺详情表 ")
public class TechPaintTechnologyDetailParam {
   private static final long serialVersionUID = 1L;
   @NotNull(message = "喷漆类型未填写!")
   @EnumValidator(value = PaintingTypeEnum.class, message = "喷漆类型有误!")
   @ApiModelProperty(name = "paintingTypeEnum", value = "喷漆类型 1底漆 2中间漆 4面漆", notes = "喷漆类型 1底漆 2中间漆 4面漆")
   private Integer paintingTypeEnum;
   @NotNull(message = "喷漆配置id未填写!")
   @ApiModelProperty(name = "paintConfigId", value = "油漆配置id", notes = "油漆配置id")
   private Long paintConfigId;
   @NotBlank(message = "油漆颜色未填写!")
   @ApiModelProperty(name = "paintColor", value = "油漆颜色", notes = "油漆颜色")
   private String paintColor;
   @NotNull(message = "漆膜厚度(μm)未填写!")
   @ApiModelProperty(name = "paintFilmThickness", value = "漆膜厚度(μm)", notes = "漆膜厚度(μm)")
   private BigDecimal paintFilmThickness;

   public static TechPaintTechnologyDetailParam.TechPaintTechnologyDetailParamBuilder builder() {
      return new TechPaintTechnologyDetailParam.TechPaintTechnologyDetailParamBuilder();
   }

   public TechPaintTechnologyDetailParam() {
   }

   public TechPaintTechnologyDetailParam(final Integer paintingTypeEnum, final Long paintConfigId, final String paintColor, final BigDecimal paintFilmThickness) {
      this.paintingTypeEnum = paintingTypeEnum;
      this.paintConfigId = paintConfigId;
      this.paintColor = paintColor;
      this.paintFilmThickness = paintFilmThickness;
   }

   public Integer getPaintingTypeEnum() {
      return this.paintingTypeEnum;
   }

   public Long getPaintConfigId() {
      return this.paintConfigId;
   }

   public String getPaintColor() {
      return this.paintColor;
   }

   public BigDecimal getPaintFilmThickness() {
      return this.paintFilmThickness;
   }

   public void setPaintingTypeEnum(final Integer paintingTypeEnum) {
      this.paintingTypeEnum = paintingTypeEnum;
   }

   public void setPaintConfigId(final Long paintConfigId) {
      this.paintConfigId = paintConfigId;
   }

   public void setPaintColor(final String paintColor) {
      this.paintColor = paintColor;
   }

   public void setPaintFilmThickness(final BigDecimal paintFilmThickness) {
      this.paintFilmThickness = paintFilmThickness;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechPaintTechnologyDetailParam)) {
         return false;
      }

      TechPaintTechnologyDetailParam other = (TechPaintTechnologyDetailParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paintingTypeEnum = this.getPaintingTypeEnum();
      Object other$paintingTypeEnum = other.getPaintingTypeEnum();
      if (this$paintingTypeEnum == null ? other$paintingTypeEnum == null : this$paintingTypeEnum.equals(other$paintingTypeEnum)) {
         Object this$paintConfigId = this.getPaintConfigId();
         Object other$paintConfigId = other.getPaintConfigId();
         if (this$paintConfigId == null ? other$paintConfigId == null : this$paintConfigId.equals(other$paintConfigId)) {
            Object this$paintColor = this.getPaintColor();
            Object other$paintColor = other.getPaintColor();
            if (this$paintColor == null ? other$paintColor == null : this$paintColor.equals(other$paintColor)) {
               Object this$paintFilmThickness = this.getPaintFilmThickness();
               Object other$paintFilmThickness = other.getPaintFilmThickness();
               return this$paintFilmThickness == null ? other$paintFilmThickness == null : this$paintFilmThickness.equals(other$paintFilmThickness);
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
      return other instanceof TechPaintTechnologyDetailParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paintingTypeEnum = this.getPaintingTypeEnum();
      result = result * 59 + ($paintingTypeEnum == null ? 43 : $paintingTypeEnum.hashCode());
      Object $paintConfigId = this.getPaintConfigId();
      result = result * 59 + ($paintConfigId == null ? 43 : $paintConfigId.hashCode());
      Object $paintColor = this.getPaintColor();
      result = result * 59 + ($paintColor == null ? 43 : $paintColor.hashCode());
      Object $paintFilmThickness = this.getPaintFilmThickness();
      return result * 59 + ($paintFilmThickness == null ? 43 : $paintFilmThickness.hashCode());
   }

   @Override
   public String toString() {
      return "TechPaintTechnologyDetailParam(paintingTypeEnum="
         + this.getPaintingTypeEnum()
         + ", paintConfigId="
         + this.getPaintConfigId()
         + ", paintColor="
         + this.getPaintColor()
         + ", paintFilmThickness="
         + this.getPaintFilmThickness()
         + ")";
   }

   public static class TechPaintTechnologyDetailParamBuilder {
      private Integer paintingTypeEnum;
      private Long paintConfigId;
      private String paintColor;
      private BigDecimal paintFilmThickness;

      TechPaintTechnologyDetailParamBuilder() {
      }

      public TechPaintTechnologyDetailParam.TechPaintTechnologyDetailParamBuilder paintingTypeEnum(final Integer paintingTypeEnum) {
         this.paintingTypeEnum = paintingTypeEnum;
         return this;
      }

      public TechPaintTechnologyDetailParam.TechPaintTechnologyDetailParamBuilder paintConfigId(final Long paintConfigId) {
         this.paintConfigId = paintConfigId;
         return this;
      }

      public TechPaintTechnologyDetailParam.TechPaintTechnologyDetailParamBuilder paintColor(final String paintColor) {
         this.paintColor = paintColor;
         return this;
      }

      public TechPaintTechnologyDetailParam.TechPaintTechnologyDetailParamBuilder paintFilmThickness(final BigDecimal paintFilmThickness) {
         this.paintFilmThickness = paintFilmThickness;
         return this;
      }

      public TechPaintTechnologyDetailParam build() {
         return new TechPaintTechnologyDetailParam(this.paintingTypeEnum, this.paintConfigId, this.paintColor, this.paintFilmThickness);
      }

      @Override
      public String toString() {
         return "TechPaintTechnologyDetailParam.TechPaintTechnologyDetailParamBuilder(paintingTypeEnum="
            + this.paintingTypeEnum
            + ", paintConfigId="
            + this.paintConfigId
            + ", paintColor="
            + this.paintColor
            + ", paintFilmThickness="
            + this.paintFilmThickness
            + ")";
      }
   }
}
