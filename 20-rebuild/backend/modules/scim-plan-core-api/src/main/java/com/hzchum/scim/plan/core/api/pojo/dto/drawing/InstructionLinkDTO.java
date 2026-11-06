package com.hzchum.scim.plan.core.api.pojo.dto.drawing;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InstructionLinkDTO", description = "技术指导书产品关联关系")
public class InstructionLinkDTO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名")
   private String areaName;
   @ApiModelProperty(name = "productType", value = "产品类型 1零件 2构件 16组立")
   private Integer productType;
   @ApiModelProperty("产品id")
   private String productId;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图 16XML文件")
   private Integer dataType;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "sign", value = "是否与当前图纸关联")
   private Integer sign;
   @ApiModelProperty(name = "classification", value = "产品类型")
   private String classification;

   public static InstructionLinkDTO.InstructionLinkDTOBuilder builder() {
      return new InstructionLinkDTO.InstructionLinkDTOBuilder();
   }

   public InstructionLinkDTO() {
   }

   public InstructionLinkDTO(
      final Long projectId,
      final Long areaId,
      final String areaName,
      final Integer productType,
      final String productId,
      final String serialNumber,
      final Integer dataType,
      final Integer quantity,
      final Integer sign,
      final String classification
   ) {
      this.projectId = projectId;
      this.areaId = areaId;
      this.areaName = areaName;
      this.productType = productType;
      this.productId = productId;
      this.serialNumber = serialNumber;
      this.dataType = dataType;
      this.quantity = quantity;
      this.sign = sign;
      this.classification = classification;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public String getProductId() {
      return this.productId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getDataType() {
      return this.dataType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getSign() {
      return this.sign;
   }

   public String getClassification() {
      return this.classification;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
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

   public void setProductId(final String productId) {
      this.productId = productId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setDataType(final Integer dataType) {
      this.dataType = dataType;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setSign(final Integer sign) {
      this.sign = sign;
   }

   public void setClassification(final String classification) {
      this.classification = classification;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InstructionLinkDTO)) {
         return false;
      }

      InstructionLinkDTO other = (InstructionLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
                     Object this$sign = this.getSign();
                     Object other$sign = other.getSign();
                     if (this$sign == null ? other$sign == null : this$sign.equals(other$sign)) {
                        Object this$areaName = this.getAreaName();
                        Object other$areaName = other.getAreaName();
                        if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                           Object this$productId = this.getProductId();
                           Object other$productId = other.getProductId();
                           if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$classification = this.getClassification();
                                 Object other$classification = other.getClassification();
                                 return this$classification == null ? other$classification == null : this$classification.equals(other$classification);
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
      return other instanceof InstructionLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $sign = this.getSign();
      result = result * 59 + ($sign == null ? 43 : $sign.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $classification = this.getClassification();
      return result * 59 + ($classification == null ? 43 : $classification.hashCode());
   }

   @Override
   public String toString() {
      return "InstructionLinkDTO(projectId="
         + this.getProjectId()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", dataType="
         + this.getDataType()
         + ", quantity="
         + this.getQuantity()
         + ", sign="
         + this.getSign()
         + ", classification="
         + this.getClassification()
         + ")";
   }

   public static class InstructionLinkDTOBuilder {
      private Long projectId;
      private Long areaId;
      private String areaName;
      private Integer productType;
      private String productId;
      private String serialNumber;
      private Integer dataType;
      private Integer quantity;
      private Integer sign;
      private String classification;

      InstructionLinkDTOBuilder() {
      }

      public InstructionLinkDTO.InstructionLinkDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public InstructionLinkDTO.InstructionLinkDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public InstructionLinkDTO.InstructionLinkDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public InstructionLinkDTO.InstructionLinkDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public InstructionLinkDTO.InstructionLinkDTOBuilder productId(final String productId) {
         this.productId = productId;
         return this;
      }

      public InstructionLinkDTO.InstructionLinkDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public InstructionLinkDTO.InstructionLinkDTOBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      public InstructionLinkDTO.InstructionLinkDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public InstructionLinkDTO.InstructionLinkDTOBuilder sign(final Integer sign) {
         this.sign = sign;
         return this;
      }

      public InstructionLinkDTO.InstructionLinkDTOBuilder classification(final String classification) {
         this.classification = classification;
         return this;
      }

      public InstructionLinkDTO build() {
         return new InstructionLinkDTO(
            this.projectId,
            this.areaId,
            this.areaName,
            this.productType,
            this.productId,
            this.serialNumber,
            this.dataType,
            this.quantity,
            this.sign,
            this.classification
         );
      }

      @Override
      public String toString() {
         return "InstructionLinkDTO.InstructionLinkDTOBuilder(projectId="
            + this.projectId
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", serialNumber="
            + this.serialNumber
            + ", dataType="
            + this.dataType
            + ", quantity="
            + this.quantity
            + ", sign="
            + this.sign
            + ", classification="
            + this.classification
            + ")";
      }
   }
}
