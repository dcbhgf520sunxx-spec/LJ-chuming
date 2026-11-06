package com.hzchum.scim.rest.pojo.vo.scm.supplier;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BatchSaveVORequest {
   @NotBlank(message = "供应商名称不能为空")
   private String name;
   private String shortName;
   private String socialCode;
   @NotNull(message = "供应商分类不能为空")
   private Integer supplierClassification;
   @ApiModelProperty(name = "classifyId", value = "分类id", notes = "分类id")
   private Long classifyId;
   @ApiModelProperty(name = "qualificationsId", value = "资质id", notes = "资质id")
   private Long qualificationsId;

   BatchSaveVORequest(
      final String name,
      final String shortName,
      final String socialCode,
      final Integer supplierClassification,
      final Long classifyId,
      final Long qualificationsId
   ) {
      this.name = name;
      this.shortName = shortName;
      this.socialCode = socialCode;
      this.supplierClassification = supplierClassification;
      this.classifyId = classifyId;
      this.qualificationsId = qualificationsId;
   }

   public static BatchSaveVORequest.BatchSaveVORequestBuilder builder() {
      return new BatchSaveVORequest.BatchSaveVORequestBuilder();
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public Integer getSupplierClassification() {
      return this.supplierClassification;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Long getQualificationsId() {
      return this.qualificationsId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
   }

   public void setSupplierClassification(final Integer supplierClassification) {
      this.supplierClassification = supplierClassification;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setQualificationsId(final Long qualificationsId) {
      this.qualificationsId = qualificationsId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BatchSaveVORequest)) {
         return false;
      }

      BatchSaveVORequest other = (BatchSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierClassification = this.getSupplierClassification();
      Object other$supplierClassification = other.getSupplierClassification();
      if (this$supplierClassification == null ? other$supplierClassification == null : this$supplierClassification.equals(other$supplierClassification)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$qualificationsId = this.getQualificationsId();
            Object other$qualificationsId = other.getQualificationsId();
            if (this$qualificationsId == null ? other$qualificationsId == null : this$qualificationsId.equals(other$qualificationsId)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$socialCode = this.getSocialCode();
                     Object other$socialCode = other.getSocialCode();
                     return this$socialCode == null ? other$socialCode == null : this$socialCode.equals(other$socialCode);
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
      return other instanceof BatchSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierClassification = this.getSupplierClassification();
      result = result * 59 + ($supplierClassification == null ? 43 : $supplierClassification.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $qualificationsId = this.getQualificationsId();
      result = result * 59 + ($qualificationsId == null ? 43 : $qualificationsId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $socialCode = this.getSocialCode();
      return result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
   }

   @Override
   public String toString() {
      return "BatchSaveVORequest(name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", socialCode="
         + this.getSocialCode()
         + ", supplierClassification="
         + this.getSupplierClassification()
         + ", classifyId="
         + this.getClassifyId()
         + ", qualificationsId="
         + this.getQualificationsId()
         + ")";
   }

   public static class BatchSaveVORequestBuilder {
      private String name;
      private String shortName;
      private String socialCode;
      private Integer supplierClassification;
      private Long classifyId;
      private Long qualificationsId;

      BatchSaveVORequestBuilder() {
      }

      public BatchSaveVORequest.BatchSaveVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BatchSaveVORequest.BatchSaveVORequestBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public BatchSaveVORequest.BatchSaveVORequestBuilder socialCode(final String socialCode) {
         this.socialCode = socialCode;
         return this;
      }

      public BatchSaveVORequest.BatchSaveVORequestBuilder supplierClassification(final Integer supplierClassification) {
         this.supplierClassification = supplierClassification;
         return this;
      }

      public BatchSaveVORequest.BatchSaveVORequestBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public BatchSaveVORequest.BatchSaveVORequestBuilder qualificationsId(final Long qualificationsId) {
         this.qualificationsId = qualificationsId;
         return this;
      }

      public BatchSaveVORequest build() {
         return new BatchSaveVORequest(this.name, this.shortName, this.socialCode, this.supplierClassification, this.classifyId, this.qualificationsId);
      }

      @Override
      public String toString() {
         return "BatchSaveVORequest.BatchSaveVORequestBuilder(name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", socialCode="
            + this.socialCode
            + ", supplierClassification="
            + this.supplierClassification
            + ", classifyId="
            + this.classifyId
            + ", qualificationsId="
            + this.qualificationsId
            + ")";
      }
   }
}
