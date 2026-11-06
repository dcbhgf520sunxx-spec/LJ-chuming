package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class SaveInvoiceDto {
   @ApiModelProperty(name = "projectId", value = "项目编号+简称")
   private String projectName;
   @ApiModelProperty(name = "projectAttribute", value = "项目类型")
   private Integer projectAttribute;
   @ApiModelProperty(name = "projectManagerName", value = "项目经理姓名")
   private String projectManagerName;
   @ApiModelProperty(name = "projectManagerId", notes = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "collectionAmountSum", notes = "累计已开票金额")
   private BigDecimal collectionAmountSum;
   @ApiModelProperty(name = "collectionUnit", value = "收票单位")
   private String collectionUnit;
   @ApiModelProperty(name = "invoiceUnitId", value = "开票单位id")
   private Long invoiceUnitId;
   @ApiModelProperty(name = "invoiceUnit", value = "开票单位")
   private String invoiceUnit;
   @ApiModelProperty(name = "userId", value = "创建人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "创建人姓名")
   private String userName;

   public String getProjectName() {
      return this.projectName;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public BigDecimal getCollectionAmountSum() {
      return this.collectionAmountSum;
   }

   public String getCollectionUnit() {
      return this.collectionUnit;
   }

   public Long getInvoiceUnitId() {
      return this.invoiceUnitId;
   }

   public String getInvoiceUnit() {
      return this.invoiceUnit;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public SaveInvoiceDto setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public SaveInvoiceDto setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public SaveInvoiceDto setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
      return this;
   }

   public SaveInvoiceDto setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public SaveInvoiceDto setCollectionAmountSum(final BigDecimal collectionAmountSum) {
      this.collectionAmountSum = collectionAmountSum;
      return this;
   }

   public SaveInvoiceDto setCollectionUnit(final String collectionUnit) {
      this.collectionUnit = collectionUnit;
      return this;
   }

   public SaveInvoiceDto setInvoiceUnitId(final Long invoiceUnitId) {
      this.invoiceUnitId = invoiceUnitId;
      return this;
   }

   public SaveInvoiceDto setInvoiceUnit(final String invoiceUnit) {
      this.invoiceUnit = invoiceUnit;
      return this;
   }

   public SaveInvoiceDto setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public SaveInvoiceDto setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SaveInvoiceDto)) {
         return false;
      }

      SaveInvoiceDto other = (SaveInvoiceDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectAttribute = this.getProjectAttribute();
      Object other$projectAttribute = other.getProjectAttribute();
      if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
         Object this$projectManagerId = this.getProjectManagerId();
         Object other$projectManagerId = other.getProjectManagerId();
         if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
            Object this$invoiceUnitId = this.getInvoiceUnitId();
            Object other$invoiceUnitId = other.getInvoiceUnitId();
            if (this$invoiceUnitId == null ? other$invoiceUnitId == null : this$invoiceUnitId.equals(other$invoiceUnitId)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$projectName = this.getProjectName();
                  Object other$projectName = other.getProjectName();
                  if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                     Object this$projectManagerName = this.getProjectManagerName();
                     Object other$projectManagerName = other.getProjectManagerName();
                     if (this$projectManagerName == null ? other$projectManagerName == null : this$projectManagerName.equals(other$projectManagerName)) {
                        Object this$collectionAmountSum = this.getCollectionAmountSum();
                        Object other$collectionAmountSum = other.getCollectionAmountSum();
                        if (this$collectionAmountSum == null ? other$collectionAmountSum == null : this$collectionAmountSum.equals(other$collectionAmountSum)) {
                           Object this$collectionUnit = this.getCollectionUnit();
                           Object other$collectionUnit = other.getCollectionUnit();
                           if (this$collectionUnit == null ? other$collectionUnit == null : this$collectionUnit.equals(other$collectionUnit)) {
                              Object this$invoiceUnit = this.getInvoiceUnit();
                              Object other$invoiceUnit = other.getInvoiceUnit();
                              if (this$invoiceUnit == null ? other$invoiceUnit == null : this$invoiceUnit.equals(other$invoiceUnit)) {
                                 Object this$userName = this.getUserName();
                                 Object other$userName = other.getUserName();
                                 return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof SaveInvoiceDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $invoiceUnitId = this.getInvoiceUnitId();
      result = result * 59 + ($invoiceUnitId == null ? 43 : $invoiceUnitId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $collectionAmountSum = this.getCollectionAmountSum();
      result = result * 59 + ($collectionAmountSum == null ? 43 : $collectionAmountSum.hashCode());
      Object $collectionUnit = this.getCollectionUnit();
      result = result * 59 + ($collectionUnit == null ? 43 : $collectionUnit.hashCode());
      Object $invoiceUnit = this.getInvoiceUnit();
      result = result * 59 + ($invoiceUnit == null ? 43 : $invoiceUnit.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "SaveInvoiceDto(projectName="
         + this.getProjectName()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", collectionAmountSum="
         + this.getCollectionAmountSum()
         + ", collectionUnit="
         + this.getCollectionUnit()
         + ", invoiceUnitId="
         + this.getInvoiceUnitId()
         + ", invoiceUnit="
         + this.getInvoiceUnit()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public SaveInvoiceDto(
      final String projectName,
      final Integer projectAttribute,
      final String projectManagerName,
      final Long projectManagerId,
      final BigDecimal collectionAmountSum,
      final String collectionUnit,
      final Long invoiceUnitId,
      final String invoiceUnit,
      final Long userId,
      final String userName
   ) {
      this.projectName = projectName;
      this.projectAttribute = projectAttribute;
      this.projectManagerName = projectManagerName;
      this.projectManagerId = projectManagerId;
      this.collectionAmountSum = collectionAmountSum;
      this.collectionUnit = collectionUnit;
      this.invoiceUnitId = invoiceUnitId;
      this.invoiceUnit = invoiceUnit;
      this.userId = userId;
      this.userName = userName;
   }

   public SaveInvoiceDto() {
   }
}
