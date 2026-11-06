package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("分包app-图表分析")
public class ProjectInstallSumDTO {
   @ApiModelProperty("区域id")
   private Long areaId;
   @ApiModelProperty("区域名称")
   private String areaName;
   @ApiModelProperty(name = "productType", value = "产品类型(2构件 , 4围护 , 8配套件)")
   private Integer productType;
   @ApiModelProperty(name = "quantity", value = "清单数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "reportMete", value = "清单量(重量kg/长度m)")
   private BigDecimal mete;
   @ApiModelProperty(name = "totalArea", value = "清单总面积(m2)")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "actualQuantity", value = "安装数量")
   private BigDecimal actualQuantity;
   @ApiModelProperty(name = "actualMete", value = "安装量(重量kg/长度m)")
   private BigDecimal actualMete;
   @ApiModelProperty(name = "actualTotalArea", value = "安装总面积(m2)")
   private BigDecimal actualTotalArea;

   public static ProjectInstallSumDTO.ProjectInstallSumDTOBuilder builder() {
      return new ProjectInstallSumDTO.ProjectInstallSumDTOBuilder();
   }

   public ProjectInstallSumDTO(
      final Long areaId,
      final String areaName,
      final Integer productType,
      final BigDecimal quantity,
      final BigDecimal mete,
      final BigDecimal totalArea,
      final BigDecimal actualQuantity,
      final BigDecimal actualMete,
      final BigDecimal actualTotalArea
   ) {
      this.areaId = areaId;
      this.areaName = areaName;
      this.productType = productType;
      this.quantity = quantity;
      this.mete = mete;
      this.totalArea = totalArea;
      this.actualQuantity = actualQuantity;
      this.actualMete = actualMete;
      this.actualTotalArea = actualTotalArea;
   }

   public ProjectInstallSumDTO() {
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getActualQuantity() {
      return this.actualQuantity;
   }

   public BigDecimal getActualMete() {
      return this.actualMete;
   }

   public BigDecimal getActualTotalArea() {
      return this.actualTotalArea;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setActualQuantity(final BigDecimal actualQuantity) {
      this.actualQuantity = actualQuantity;
   }

   public void setActualMete(final BigDecimal actualMete) {
      this.actualMete = actualMete;
   }

   public void setActualTotalArea(final BigDecimal actualTotalArea) {
      this.actualTotalArea = actualTotalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInstallSumDTO)) {
         return false;
      }

      ProjectInstallSumDTO other = (ProjectInstallSumDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$areaId = this.getAreaId();
      Object other$areaId = other.getAreaId();
      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$areaName = this.getAreaName();
            Object other$areaName = other.getAreaName();
            if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$totalArea = this.getTotalArea();
                     Object other$totalArea = other.getTotalArea();
                     if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                        Object this$actualQuantity = this.getActualQuantity();
                        Object other$actualQuantity = other.getActualQuantity();
                        if (this$actualQuantity == null ? other$actualQuantity == null : this$actualQuantity.equals(other$actualQuantity)) {
                           Object this$actualMete = this.getActualMete();
                           Object other$actualMete = other.getActualMete();
                           if (this$actualMete == null ? other$actualMete == null : this$actualMete.equals(other$actualMete)) {
                              Object this$actualTotalArea = this.getActualTotalArea();
                              Object other$actualTotalArea = other.getActualTotalArea();
                              return this$actualTotalArea == null ? other$actualTotalArea == null : this$actualTotalArea.equals(other$actualTotalArea);
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
      return other instanceof ProjectInstallSumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $actualMete = this.getActualMete();
      result = result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
      Object $actualTotalArea = this.getActualTotalArea();
      return result * 59 + ($actualTotalArea == null ? 43 : $actualTotalArea.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallSumDTO(areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", totalArea="
         + this.getTotalArea()
         + ", actualQuantity="
         + this.getActualQuantity()
         + ", actualMete="
         + this.getActualMete()
         + ", actualTotalArea="
         + this.getActualTotalArea()
         + ")";
   }

   public static class ProjectInstallSumDTOBuilder {
      private Long areaId;
      private String areaName;
      private Integer productType;
      private BigDecimal quantity;
      private BigDecimal mete;
      private BigDecimal totalArea;
      private BigDecimal actualQuantity;
      private BigDecimal actualMete;
      private BigDecimal actualTotalArea;

      ProjectInstallSumDTOBuilder() {
      }

      public ProjectInstallSumDTO.ProjectInstallSumDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectInstallSumDTO.ProjectInstallSumDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public ProjectInstallSumDTO.ProjectInstallSumDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectInstallSumDTO.ProjectInstallSumDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectInstallSumDTO.ProjectInstallSumDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectInstallSumDTO.ProjectInstallSumDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public ProjectInstallSumDTO.ProjectInstallSumDTOBuilder actualQuantity(final BigDecimal actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      public ProjectInstallSumDTO.ProjectInstallSumDTOBuilder actualMete(final BigDecimal actualMete) {
         this.actualMete = actualMete;
         return this;
      }

      public ProjectInstallSumDTO.ProjectInstallSumDTOBuilder actualTotalArea(final BigDecimal actualTotalArea) {
         this.actualTotalArea = actualTotalArea;
         return this;
      }

      public ProjectInstallSumDTO build() {
         return new ProjectInstallSumDTO(
            this.areaId, this.areaName, this.productType, this.quantity, this.mete, this.totalArea, this.actualQuantity, this.actualMete, this.actualTotalArea
         );
      }

      @Override
      public String toString() {
         return "ProjectInstallSumDTO.ProjectInstallSumDTOBuilder(areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", totalArea="
            + this.totalArea
            + ", actualQuantity="
            + this.actualQuantity
            + ", actualMete="
            + this.actualMete
            + ", actualTotalArea="
            + this.actualTotalArea
            + ")";
      }
   }
}
