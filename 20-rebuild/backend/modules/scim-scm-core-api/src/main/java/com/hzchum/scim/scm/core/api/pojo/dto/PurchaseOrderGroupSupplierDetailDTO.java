package com.hzchum.scim.scm.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("采购月度详情")
public class PurchaseOrderGroupSupplierDetailDTO {
   @ApiModelProperty(name = "materialType", value = "材料类型", notes = "材料类型")
   private Integer materialType;
   @ApiModelProperty(name = "materialTypeName", value = "材料类型", notes = "材料类型")
   private String materialTypeName;
   @ApiModelProperty(name = "supplierName", value = "供应商", notes = "供应商")
   private String supplierName;
   @ApiModelProperty(name = "socialCode", value = "社会统一代码", notes = "社会统一代码")
   private String socialCode;
   @ApiModelProperty(name = "supplierClassification", value = "供应商类型", notes = "供应商类型")
   private Integer supplierClassification;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;

   public static PurchaseOrderGroupSupplierDetailDTO.PurchaseOrderGroupSupplierDetailDTOBuilder builder() {
      return new PurchaseOrderGroupSupplierDetailDTO.PurchaseOrderGroupSupplierDetailDTOBuilder();
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public String getMaterialTypeName() {
      return this.materialTypeName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public Integer getSupplierClassification() {
      return this.supplierClassification;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setMaterialTypeName(final String materialTypeName) {
      this.materialTypeName = materialTypeName;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
   }

   public void setSupplierClassification(final Integer supplierClassification) {
      this.supplierClassification = supplierClassification;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderGroupSupplierDetailDTO)) {
         return false;
      }

      PurchaseOrderGroupSupplierDetailDTO other = (PurchaseOrderGroupSupplierDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$materialType = this.getMaterialType();
      Object other$materialType = other.getMaterialType();
      if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
         Object this$supplierClassification = this.getSupplierClassification();
         Object other$supplierClassification = other.getSupplierClassification();
         if (this$supplierClassification == null ? other$supplierClassification == null : this$supplierClassification.equals(other$supplierClassification)) {
            Object this$materialTypeName = this.getMaterialTypeName();
            Object other$materialTypeName = other.getMaterialTypeName();
            if (this$materialTypeName == null ? other$materialTypeName == null : this$materialTypeName.equals(other$materialTypeName)) {
               Object this$supplierName = this.getSupplierName();
               Object other$supplierName = other.getSupplierName();
               if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                  Object this$socialCode = this.getSocialCode();
                  Object other$socialCode = other.getSocialCode();
                  if (this$socialCode == null ? other$socialCode == null : this$socialCode.equals(other$socialCode)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof PurchaseOrderGroupSupplierDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $supplierClassification = this.getSupplierClassification();
      result = result * 59 + ($supplierClassification == null ? 43 : $supplierClassification.hashCode());
      Object $materialTypeName = this.getMaterialTypeName();
      result = result * 59 + ($materialTypeName == null ? 43 : $materialTypeName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $socialCode = this.getSocialCode();
      result = result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseOrderGroupSupplierDetailDTO(materialType="
         + this.getMaterialType()
         + ", materialTypeName="
         + this.getMaterialTypeName()
         + ", supplierName="
         + this.getSupplierName()
         + ", socialCode="
         + this.getSocialCode()
         + ", supplierClassification="
         + this.getSupplierClassification()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public PurchaseOrderGroupSupplierDetailDTO(
      final Integer materialType,
      final String materialTypeName,
      final String supplierName,
      final String socialCode,
      final Integer supplierClassification,
      final LocalDateTime createTime
   ) {
      this.materialType = materialType;
      this.materialTypeName = materialTypeName;
      this.supplierName = supplierName;
      this.socialCode = socialCode;
      this.supplierClassification = supplierClassification;
      this.createTime = createTime;
   }

   public PurchaseOrderGroupSupplierDetailDTO() {
   }

   public static class PurchaseOrderGroupSupplierDetailDTOBuilder {
      private Integer materialType;
      private String materialTypeName;
      private String supplierName;
      private String socialCode;
      private Integer supplierClassification;
      private LocalDateTime createTime;

      PurchaseOrderGroupSupplierDetailDTOBuilder() {
      }

      public PurchaseOrderGroupSupplierDetailDTO.PurchaseOrderGroupSupplierDetailDTOBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public PurchaseOrderGroupSupplierDetailDTO.PurchaseOrderGroupSupplierDetailDTOBuilder materialTypeName(final String materialTypeName) {
         this.materialTypeName = materialTypeName;
         return this;
      }

      public PurchaseOrderGroupSupplierDetailDTO.PurchaseOrderGroupSupplierDetailDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public PurchaseOrderGroupSupplierDetailDTO.PurchaseOrderGroupSupplierDetailDTOBuilder socialCode(final String socialCode) {
         this.socialCode = socialCode;
         return this;
      }

      public PurchaseOrderGroupSupplierDetailDTO.PurchaseOrderGroupSupplierDetailDTOBuilder supplierClassification(final Integer supplierClassification) {
         this.supplierClassification = supplierClassification;
         return this;
      }

      public PurchaseOrderGroupSupplierDetailDTO.PurchaseOrderGroupSupplierDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public PurchaseOrderGroupSupplierDetailDTO build() {
         return new PurchaseOrderGroupSupplierDetailDTO(
            this.materialType, this.materialTypeName, this.supplierName, this.socialCode, this.supplierClassification, this.createTime
         );
      }

      @Override
      public String toString() {
         return "PurchaseOrderGroupSupplierDetailDTO.PurchaseOrderGroupSupplierDetailDTOBuilder(materialType="
            + this.materialType
            + ", materialTypeName="
            + this.materialTypeName
            + ", supplierName="
            + this.supplierName
            + ", socialCode="
            + this.socialCode
            + ", supplierClassification="
            + this.supplierClassification
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
