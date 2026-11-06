package com.hzchum.scim.plan.core.api.pojo.dto.drawing;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProductDrawingsSummaryDTO", description = "产品图纸数据统计返回类")
public class ProductDrawingsSummaryDTO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名")
   private String monomerName;
   @ApiModelProperty(name = "monomerId", value = "区域Id")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "productType", value = "产品类型 1零件 2构件 16组立")
   private Integer productType;
   @ApiModelProperty(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件")
   private Integer dataType;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "drawingQuantity", value = "图纸总数")
   private Integer drawingQuantity;
   @ApiModelProperty(name = "productWeldQuantity", value = "焊缝数量")
   private Integer productWeldQuantity;
   @ApiModelProperty(name = "productWeldMapQuantity", value = "焊图数量")
   private Integer productWeldMapQuantity;
   @ApiModelProperty(name = "summaryDetailDTO", value = "产品图纸总数")
   private ProductDrawingsSummaryDetailDTO summaryDetailDTO;

   public static ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder builder() {
      return new ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder();
   }

   public ProductDrawingsSummaryDTO() {
   }

   public ProductDrawingsSummaryDTO(
      final Long projectId,
      final Long monomerId,
      final String monomerName,
      final Long areaId,
      final String areaName,
      final Integer productType,
      final Integer dataType,
      final Integer quantity,
      final Integer drawingQuantity,
      final Integer productWeldQuantity,
      final Integer productWeldMapQuantity,
      final ProductDrawingsSummaryDetailDTO summaryDetailDTO
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.productType = productType;
      this.dataType = dataType;
      this.quantity = quantity;
      this.drawingQuantity = drawingQuantity;
      this.productWeldQuantity = productWeldQuantity;
      this.productWeldMapQuantity = productWeldMapQuantity;
      this.summaryDetailDTO = summaryDetailDTO;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
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

   public Integer getDataType() {
      return this.dataType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getDrawingQuantity() {
      return this.drawingQuantity;
   }

   public Integer getProductWeldQuantity() {
      return this.productWeldQuantity;
   }

   public Integer getProductWeldMapQuantity() {
      return this.productWeldMapQuantity;
   }

   public ProductDrawingsSummaryDetailDTO getSummaryDetailDTO() {
      return this.summaryDetailDTO;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
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

   public void setDataType(final Integer dataType) {
      this.dataType = dataType;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setDrawingQuantity(final Integer drawingQuantity) {
      this.drawingQuantity = drawingQuantity;
   }

   public void setProductWeldQuantity(final Integer productWeldQuantity) {
      this.productWeldQuantity = productWeldQuantity;
   }

   public void setProductWeldMapQuantity(final Integer productWeldMapQuantity) {
      this.productWeldMapQuantity = productWeldMapQuantity;
   }

   public void setSummaryDetailDTO(final ProductDrawingsSummaryDetailDTO summaryDetailDTO) {
      this.summaryDetailDTO = summaryDetailDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductDrawingsSummaryDTO)) {
         return false;
      }

      ProductDrawingsSummaryDTO other = (ProductDrawingsSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$dataType = this.getDataType();
                  Object other$dataType = other.getDataType();
                  if (this$dataType == null ? other$dataType == null : this$dataType.equals(other$dataType)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$drawingQuantity = this.getDrawingQuantity();
                        Object other$drawingQuantity = other.getDrawingQuantity();
                        if (this$drawingQuantity == null ? other$drawingQuantity == null : this$drawingQuantity.equals(other$drawingQuantity)) {
                           Object this$productWeldQuantity = this.getProductWeldQuantity();
                           Object other$productWeldQuantity = other.getProductWeldQuantity();
                           if (this$productWeldQuantity == null
                              ? other$productWeldQuantity == null
                              : this$productWeldQuantity.equals(other$productWeldQuantity)) {
                              Object this$productWeldMapQuantity = this.getProductWeldMapQuantity();
                              Object other$productWeldMapQuantity = other.getProductWeldMapQuantity();
                              if (this$productWeldMapQuantity == null
                                 ? other$productWeldMapQuantity == null
                                 : this$productWeldMapQuantity.equals(other$productWeldMapQuantity)) {
                                 Object this$monomerName = this.getMonomerName();
                                 Object other$monomerName = other.getMonomerName();
                                 if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                    Object this$areaName = this.getAreaName();
                                    Object other$areaName = other.getAreaName();
                                    if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                       Object this$summaryDetailDTO = this.getSummaryDetailDTO();
                                       Object other$summaryDetailDTO = other.getSummaryDetailDTO();
                                       return this$summaryDetailDTO == null
                                          ? other$summaryDetailDTO == null
                                          : this$summaryDetailDTO.equals(other$summaryDetailDTO);
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
      return other instanceof ProductDrawingsSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $drawingQuantity = this.getDrawingQuantity();
      result = result * 59 + ($drawingQuantity == null ? 43 : $drawingQuantity.hashCode());
      Object $productWeldQuantity = this.getProductWeldQuantity();
      result = result * 59 + ($productWeldQuantity == null ? 43 : $productWeldQuantity.hashCode());
      Object $productWeldMapQuantity = this.getProductWeldMapQuantity();
      result = result * 59 + ($productWeldMapQuantity == null ? 43 : $productWeldMapQuantity.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $summaryDetailDTO = this.getSummaryDetailDTO();
      return result * 59 + ($summaryDetailDTO == null ? 43 : $summaryDetailDTO.hashCode());
   }

   @Override
   public String toString() {
      return "ProductDrawingsSummaryDTO(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", productType="
         + this.getProductType()
         + ", dataType="
         + this.getDataType()
         + ", quantity="
         + this.getQuantity()
         + ", drawingQuantity="
         + this.getDrawingQuantity()
         + ", productWeldQuantity="
         + this.getProductWeldQuantity()
         + ", productWeldMapQuantity="
         + this.getProductWeldMapQuantity()
         + ", summaryDetailDTO="
         + this.getSummaryDetailDTO()
         + ")";
   }

   public static class ProductDrawingsSummaryDTOBuilder {
      private Long projectId;
      private Long monomerId;
      private String monomerName;
      private Long areaId;
      private String areaName;
      private Integer productType;
      private Integer dataType;
      private Integer quantity;
      private Integer drawingQuantity;
      private Integer productWeldQuantity;
      private Integer productWeldMapQuantity;
      private ProductDrawingsSummaryDetailDTO summaryDetailDTO;

      ProductDrawingsSummaryDTOBuilder() {
      }

      public ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      public ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder drawingQuantity(final Integer drawingQuantity) {
         this.drawingQuantity = drawingQuantity;
         return this;
      }

      public ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder productWeldQuantity(final Integer productWeldQuantity) {
         this.productWeldQuantity = productWeldQuantity;
         return this;
      }

      public ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder productWeldMapQuantity(final Integer productWeldMapQuantity) {
         this.productWeldMapQuantity = productWeldMapQuantity;
         return this;
      }

      public ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder summaryDetailDTO(final ProductDrawingsSummaryDetailDTO summaryDetailDTO) {
         this.summaryDetailDTO = summaryDetailDTO;
         return this;
      }

      public ProductDrawingsSummaryDTO build() {
         return new ProductDrawingsSummaryDTO(
            this.projectId,
            this.monomerId,
            this.monomerName,
            this.areaId,
            this.areaName,
            this.productType,
            this.dataType,
            this.quantity,
            this.drawingQuantity,
            this.productWeldQuantity,
            this.productWeldMapQuantity,
            this.summaryDetailDTO
         );
      }

      @Override
      public String toString() {
         return "ProductDrawingsSummaryDTO.ProductDrawingsSummaryDTOBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", productType="
            + this.productType
            + ", dataType="
            + this.dataType
            + ", quantity="
            + this.quantity
            + ", drawingQuantity="
            + this.drawingQuantity
            + ", productWeldQuantity="
            + this.productWeldQuantity
            + ", productWeldMapQuantity="
            + this.productWeldMapQuantity
            + ", summaryDetailDTO="
            + this.summaryDetailDTO
            + ")";
      }
   }
}
