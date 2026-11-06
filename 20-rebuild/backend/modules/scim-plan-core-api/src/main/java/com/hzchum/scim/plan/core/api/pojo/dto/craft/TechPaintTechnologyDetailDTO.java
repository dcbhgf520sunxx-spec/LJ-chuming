package com.hzchum.scim.plan.core.api.pojo.dto.craft;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TechPaintTechnologyDetail对象", description = "涂装工艺详情表 ")
public class TechPaintTechnologyDetailDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "paintTechnologyId", value = "涂装工艺id", notes = "涂装工艺id")
   private Long paintTechnologyId;
   @ApiModelProperty(name = "paintingTypeEnum", value = "喷漆类型 1底漆 2中间漆 4面漆", notes = "喷漆类型 1底漆 2中间漆 4面漆")
   private Integer paintingTypeEnum;
   @ApiModelProperty(name = "paintConfigId", value = "油漆配置id", notes = "油漆配置id")
   private Long paintConfigId;
   @ApiModelProperty(name = "paintType", value = "油漆类型(名称)", notes = "油漆类型(名称)")
   private String paintType;
   @ApiModelProperty(name = "paintBrand", value = "油漆品牌", notes = "油漆品牌")
   private String paintBrand;
   @ApiModelProperty(name = "paintColor", value = "油漆颜色", notes = "油漆颜色")
   private String paintColor;
   @ApiModelProperty(name = "paintFilmThickness", value = "漆膜厚度(μm)", notes = "漆膜厚度(μm)")
   private BigDecimal paintFilmThickness;

   public static TechPaintTechnologyDetailDTO.TechPaintTechnologyDetailDTOBuilder builder() {
      return new TechPaintTechnologyDetailDTO.TechPaintTechnologyDetailDTOBuilder();
   }

   public TechPaintTechnologyDetailDTO() {
   }

   public TechPaintTechnologyDetailDTO(
      final Long id,
      final Long paintTechnologyId,
      final Integer paintingTypeEnum,
      final Long paintConfigId,
      final String paintType,
      final String paintBrand,
      final String paintColor,
      final BigDecimal paintFilmThickness
   ) {
      this.id = id;
      this.paintTechnologyId = paintTechnologyId;
      this.paintingTypeEnum = paintingTypeEnum;
      this.paintConfigId = paintConfigId;
      this.paintType = paintType;
      this.paintBrand = paintBrand;
      this.paintColor = paintColor;
      this.paintFilmThickness = paintFilmThickness;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPaintTechnologyId() {
      return this.paintTechnologyId;
   }

   public Integer getPaintingTypeEnum() {
      return this.paintingTypeEnum;
   }

   public Long getPaintConfigId() {
      return this.paintConfigId;
   }

   public String getPaintType() {
      return this.paintType;
   }

   public String getPaintBrand() {
      return this.paintBrand;
   }

   public String getPaintColor() {
      return this.paintColor;
   }

   public BigDecimal getPaintFilmThickness() {
      return this.paintFilmThickness;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPaintTechnologyId(final Long paintTechnologyId) {
      this.paintTechnologyId = paintTechnologyId;
   }

   public void setPaintingTypeEnum(final Integer paintingTypeEnum) {
      this.paintingTypeEnum = paintingTypeEnum;
   }

   public void setPaintConfigId(final Long paintConfigId) {
      this.paintConfigId = paintConfigId;
   }

   public void setPaintType(final String paintType) {
      this.paintType = paintType;
   }

   public void setPaintBrand(final String paintBrand) {
      this.paintBrand = paintBrand;
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

      if (!(o instanceof TechPaintTechnologyDetailDTO)) {
         return false;
      }

      TechPaintTechnologyDetailDTO other = (TechPaintTechnologyDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paintTechnologyId = this.getPaintTechnologyId();
         Object other$paintTechnologyId = other.getPaintTechnologyId();
         if (this$paintTechnologyId == null ? other$paintTechnologyId == null : this$paintTechnologyId.equals(other$paintTechnologyId)) {
            Object this$paintingTypeEnum = this.getPaintingTypeEnum();
            Object other$paintingTypeEnum = other.getPaintingTypeEnum();
            if (this$paintingTypeEnum == null ? other$paintingTypeEnum == null : this$paintingTypeEnum.equals(other$paintingTypeEnum)) {
               Object this$paintConfigId = this.getPaintConfigId();
               Object other$paintConfigId = other.getPaintConfigId();
               if (this$paintConfigId == null ? other$paintConfigId == null : this$paintConfigId.equals(other$paintConfigId)) {
                  Object this$paintType = this.getPaintType();
                  Object other$paintType = other.getPaintType();
                  if (this$paintType == null ? other$paintType == null : this$paintType.equals(other$paintType)) {
                     Object this$paintBrand = this.getPaintBrand();
                     Object other$paintBrand = other.getPaintBrand();
                     if (this$paintBrand == null ? other$paintBrand == null : this$paintBrand.equals(other$paintBrand)) {
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
      return other instanceof TechPaintTechnologyDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paintTechnologyId = this.getPaintTechnologyId();
      result = result * 59 + ($paintTechnologyId == null ? 43 : $paintTechnologyId.hashCode());
      Object $paintingTypeEnum = this.getPaintingTypeEnum();
      result = result * 59 + ($paintingTypeEnum == null ? 43 : $paintingTypeEnum.hashCode());
      Object $paintConfigId = this.getPaintConfigId();
      result = result * 59 + ($paintConfigId == null ? 43 : $paintConfigId.hashCode());
      Object $paintType = this.getPaintType();
      result = result * 59 + ($paintType == null ? 43 : $paintType.hashCode());
      Object $paintBrand = this.getPaintBrand();
      result = result * 59 + ($paintBrand == null ? 43 : $paintBrand.hashCode());
      Object $paintColor = this.getPaintColor();
      result = result * 59 + ($paintColor == null ? 43 : $paintColor.hashCode());
      Object $paintFilmThickness = this.getPaintFilmThickness();
      return result * 59 + ($paintFilmThickness == null ? 43 : $paintFilmThickness.hashCode());
   }

   @Override
   public String toString() {
      return "TechPaintTechnologyDetailDTO(id="
         + this.getId()
         + ", paintTechnologyId="
         + this.getPaintTechnologyId()
         + ", paintingTypeEnum="
         + this.getPaintingTypeEnum()
         + ", paintConfigId="
         + this.getPaintConfigId()
         + ", paintType="
         + this.getPaintType()
         + ", paintBrand="
         + this.getPaintBrand()
         + ", paintColor="
         + this.getPaintColor()
         + ", paintFilmThickness="
         + this.getPaintFilmThickness()
         + ")";
   }

   public static class TechPaintTechnologyDetailDTOBuilder {
      private Long id;
      private Long paintTechnologyId;
      private Integer paintingTypeEnum;
      private Long paintConfigId;
      private String paintType;
      private String paintBrand;
      private String paintColor;
      private BigDecimal paintFilmThickness;

      TechPaintTechnologyDetailDTOBuilder() {
      }

      public TechPaintTechnologyDetailDTO.TechPaintTechnologyDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechPaintTechnologyDetailDTO.TechPaintTechnologyDetailDTOBuilder paintTechnologyId(final Long paintTechnologyId) {
         this.paintTechnologyId = paintTechnologyId;
         return this;
      }

      public TechPaintTechnologyDetailDTO.TechPaintTechnologyDetailDTOBuilder paintingTypeEnum(final Integer paintingTypeEnum) {
         this.paintingTypeEnum = paintingTypeEnum;
         return this;
      }

      public TechPaintTechnologyDetailDTO.TechPaintTechnologyDetailDTOBuilder paintConfigId(final Long paintConfigId) {
         this.paintConfigId = paintConfigId;
         return this;
      }

      public TechPaintTechnologyDetailDTO.TechPaintTechnologyDetailDTOBuilder paintType(final String paintType) {
         this.paintType = paintType;
         return this;
      }

      public TechPaintTechnologyDetailDTO.TechPaintTechnologyDetailDTOBuilder paintBrand(final String paintBrand) {
         this.paintBrand = paintBrand;
         return this;
      }

      public TechPaintTechnologyDetailDTO.TechPaintTechnologyDetailDTOBuilder paintColor(final String paintColor) {
         this.paintColor = paintColor;
         return this;
      }

      public TechPaintTechnologyDetailDTO.TechPaintTechnologyDetailDTOBuilder paintFilmThickness(final BigDecimal paintFilmThickness) {
         this.paintFilmThickness = paintFilmThickness;
         return this;
      }

      public TechPaintTechnologyDetailDTO build() {
         return new TechPaintTechnologyDetailDTO(
            this.id,
            this.paintTechnologyId,
            this.paintingTypeEnum,
            this.paintConfigId,
            this.paintType,
            this.paintBrand,
            this.paintColor,
            this.paintFilmThickness
         );
      }

      @Override
      public String toString() {
         return "TechPaintTechnologyDetailDTO.TechPaintTechnologyDetailDTOBuilder(id="
            + this.id
            + ", paintTechnologyId="
            + this.paintTechnologyId
            + ", paintingTypeEnum="
            + this.paintingTypeEnum
            + ", paintConfigId="
            + this.paintConfigId
            + ", paintType="
            + this.paintType
            + ", paintBrand="
            + this.paintBrand
            + ", paintColor="
            + this.paintColor
            + ", paintFilmThickness="
            + this.paintFilmThickness
            + ")";
      }
   }
}
