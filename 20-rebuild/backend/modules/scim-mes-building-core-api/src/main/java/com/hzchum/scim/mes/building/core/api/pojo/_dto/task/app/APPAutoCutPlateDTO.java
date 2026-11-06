package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class APPAutoCutPlateDTO {
   private Long id;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private BigDecimal quantity;
   @ApiModelProperty(name = "length", value = "长", notes = "长")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "thickness", value = "厚", notes = "厚")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", value = "宽", notes = "宽")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "surplusSn", value = "余料编号", notes = "余料编号")
   @JsonProperty("surplusSn")
   private String surplusSn;
   @ApiModelProperty(name = "materialIsWhole", value = "整料余料 1 整料 2 余料", notes = "整料余料 1 整料 2 余料")
   @JsonProperty("materialIsWhole")
   @JSONField(name = "materialIsWhole")
   private Integer materialIsWhole;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   private String classifyName;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "workshopName", value = "仓库", notes = "仓库")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "warehouseName", value = "仓库名称", notes = "仓库名称")
   @JsonProperty("warehouseName")
   @JSONField(name = "warehouseName")
   private String warehouseName;

   public static APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder builder() {
      return new APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getSurplusSn() {
      return this.surplusSn;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getWarehouseName() {
      return this.warehouseName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("quantity")
   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("thickness")
   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   @JsonProperty("width")
   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   @JsonProperty("surplusSn")
   public void setSurplusSn(final String surplusSn) {
      this.surplusSn = surplusSn;
   }

   @JsonProperty("materialIsWhole")
   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   @JsonProperty("classifyName")
   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("workshopName")
   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   @JsonProperty("warehouseName")
   public void setWarehouseName(final String warehouseName) {
      this.warehouseName = warehouseName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof APPAutoCutPlateDTO)) {
         return false;
      }

      APPAutoCutPlateDTO other = (APPAutoCutPlateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialIsWhole = this.getMaterialIsWhole();
         Object other$materialIsWhole = other.getMaterialIsWhole();
         if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$length = this.getLength();
               Object other$length = other.getLength();
               if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                  Object this$thickness = this.getThickness();
                  Object other$thickness = other.getThickness();
                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                     Object this$width = this.getWidth();
                     Object other$width = other.getWidth();
                     if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                        Object this$surplusSn = this.getSurplusSn();
                        Object other$surplusSn = other.getSurplusSn();
                        if (this$surplusSn == null ? other$surplusSn == null : this$surplusSn.equals(other$surplusSn)) {
                           Object this$classifyName = this.getClassifyName();
                           Object other$classifyName = other.getClassifyName();
                           if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$mete = this.getMete();
                                 Object other$mete = other.getMete();
                                 if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                    Object this$workshopName = this.getWorkshopName();
                                    Object other$workshopName = other.getWorkshopName();
                                    if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                       Object this$warehouseName = this.getWarehouseName();
                                       Object other$warehouseName = other.getWarehouseName();
                                       return this$warehouseName == null ? other$warehouseName == null : this$warehouseName.equals(other$warehouseName);
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
      return other instanceof APPAutoCutPlateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $surplusSn = this.getSurplusSn();
      result = result * 59 + ($surplusSn == null ? 43 : $surplusSn.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $warehouseName = this.getWarehouseName();
      return result * 59 + ($warehouseName == null ? 43 : $warehouseName.hashCode());
   }

   @Override
   public String toString() {
      return "APPAutoCutPlateDTO(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", surplusSn="
         + this.getSurplusSn()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", mete="
         + this.getMete()
         + ", workshopName="
         + this.getWorkshopName()
         + ", warehouseName="
         + this.getWarehouseName()
         + ")";
   }

   public APPAutoCutPlateDTO(
      final Long id,
      final BigDecimal quantity,
      final BigDecimal length,
      final BigDecimal thickness,
      final BigDecimal width,
      final String surplusSn,
      final Integer materialIsWhole,
      final String classifyName,
      final String specification,
      final BigDecimal mete,
      final String workshopName,
      final String warehouseName
   ) {
      this.id = id;
      this.quantity = quantity;
      this.length = length;
      this.thickness = thickness;
      this.width = width;
      this.surplusSn = surplusSn;
      this.materialIsWhole = materialIsWhole;
      this.classifyName = classifyName;
      this.specification = specification;
      this.mete = mete;
      this.workshopName = workshopName;
      this.warehouseName = warehouseName;
   }

   public APPAutoCutPlateDTO() {
   }

   public static class APPAutoCutPlateDTOBuilder {
      private Long id;
      private BigDecimal quantity;
      private BigDecimal length;
      private BigDecimal thickness;
      private BigDecimal width;
      private String surplusSn;
      private Integer materialIsWhole;
      private String classifyName;
      private String specification;
      private BigDecimal mete;
      private String workshopName;
      private String warehouseName;

      APPAutoCutPlateDTOBuilder() {
      }

      public APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("thickness")
      public APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("width")
      public APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("surplusSn")
      public APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder surplusSn(final String surplusSn) {
         this.surplusSn = surplusSn;
         return this;
      }

      @JsonProperty("materialIsWhole")
      public APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      @JsonProperty("classifyName")
      public APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specification")
      public APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("mete")
      public APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("workshopName")
      public APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("warehouseName")
      public APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder warehouseName(final String warehouseName) {
         this.warehouseName = warehouseName;
         return this;
      }

      public APPAutoCutPlateDTO build() {
         return new APPAutoCutPlateDTO(
            this.id,
            this.quantity,
            this.length,
            this.thickness,
            this.width,
            this.surplusSn,
            this.materialIsWhole,
            this.classifyName,
            this.specification,
            this.mete,
            this.workshopName,
            this.warehouseName
         );
      }

      @Override
      public String toString() {
         return "APPAutoCutPlateDTO.APPAutoCutPlateDTOBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", length="
            + this.length
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", surplusSn="
            + this.surplusSn
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", mete="
            + this.mete
            + ", workshopName="
            + this.workshopName
            + ", warehouseName="
            + this.warehouseName
            + ")";
      }
   }
}
