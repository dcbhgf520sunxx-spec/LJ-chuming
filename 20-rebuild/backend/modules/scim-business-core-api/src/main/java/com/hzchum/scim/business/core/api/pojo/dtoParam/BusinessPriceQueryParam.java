package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "BusinessPrice对象", description = "产品计价-查询")
public class BusinessPriceQueryParam {
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   private LocalDateTime year;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id", notes = "分支机构id")
   private Long branchCompanyId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "pricingName", value = "计价名称", notes = "计价名称")
   private String pricingName;
   @ApiModelProperty(name = "pricingMannerEnum", value = "计价类型", notes = "计价类型")
   private Integer pricingMannerEnum;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2已通过 4已驳回", notes = "审核状态 1未审核 2已通过 4已驳回")
   private Integer auditStatus;
   @ApiModelProperty(name = "projectIds", value = "项目id列表", notes = "项目id列表")
   private List<Long> projectIds;

   public static BusinessPriceQueryParam.BusinessPriceQueryParamBuilder builder() {
      return new BusinessPriceQueryParam.BusinessPriceQueryParamBuilder();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPriceQueryParam)) {
         return false;
      }

      BusinessPriceQueryParam other = (BusinessPriceQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$pricingMannerEnum = this.getPricingMannerEnum();
               Object other$pricingMannerEnum = other.getPricingMannerEnum();
               if (this$pricingMannerEnum == null ? other$pricingMannerEnum == null : this$pricingMannerEnum.equals(other$pricingMannerEnum)) {
                  Object this$auditStatus = this.getAuditStatus();
                  Object other$auditStatus = other.getAuditStatus();
                  if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                     Object this$year = this.getYear();
                     Object other$year = other.getYear();
                     if (this$year == null ? other$year == null : this$year.equals(other$year)) {
                        Object this$pricingName = this.getPricingName();
                        Object other$pricingName = other.getPricingName();
                        if (this$pricingName == null ? other$pricingName == null : this$pricingName.equals(other$pricingName)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$projectIds = this.getProjectIds();
                                 Object other$projectIds = other.getProjectIds();
                                 return this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds);
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
      return other instanceof BusinessPriceQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $pricingMannerEnum = this.getPricingMannerEnum();
      result = result * 59 + ($pricingMannerEnum == null ? 43 : $pricingMannerEnum.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $pricingName = this.getPricingName();
      result = result * 59 + ($pricingName == null ? 43 : $pricingName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectIds = this.getProjectIds();
      return result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
   }

   public BusinessPriceQueryParam() {
   }

   public BusinessPriceQueryParam(
      final LocalDateTime year,
      final Long projectId,
      final Long branchCompanyId,
      final Integer productType,
      final String pricingName,
      final Integer pricingMannerEnum,
      final String name,
      final String serialNumber,
      final Integer auditStatus,
      final List<Long> projectIds
   ) {
      this.year = year;
      this.projectId = projectId;
      this.branchCompanyId = branchCompanyId;
      this.productType = productType;
      this.pricingName = pricingName;
      this.pricingMannerEnum = pricingMannerEnum;
      this.name = name;
      this.serialNumber = serialNumber;
      this.auditStatus = auditStatus;
      this.projectIds = projectIds;
   }

   public LocalDateTime getYear() {
      return this.year;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getPricingName() {
      return this.pricingName;
   }

   public Integer getPricingMannerEnum() {
      return this.pricingMannerEnum;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public void setYear(final LocalDateTime year) {
      this.year = year;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setPricingName(final String pricingName) {
      this.pricingName = pricingName;
   }

   public void setPricingMannerEnum(final Integer pricingMannerEnum) {
      this.pricingMannerEnum = pricingMannerEnum;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   @Override
   public String toString() {
      return "BusinessPriceQueryParam(year="
         + this.getYear()
         + ", projectId="
         + this.getProjectId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", productType="
         + this.getProductType()
         + ", pricingName="
         + this.getPricingName()
         + ", pricingMannerEnum="
         + this.getPricingMannerEnum()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", projectIds="
         + this.getProjectIds()
         + ")";
   }

   public static class BusinessPriceQueryParamBuilder {
      private LocalDateTime year;
      private Long projectId;
      private Long branchCompanyId;
      private Integer productType;
      private String pricingName;
      private Integer pricingMannerEnum;
      private String name;
      private String serialNumber;
      private Integer auditStatus;
      private List<Long> projectIds;

      BusinessPriceQueryParamBuilder() {
      }

      public BusinessPriceQueryParam.BusinessPriceQueryParamBuilder year(final LocalDateTime year) {
         this.year = year;
         return this;
      }

      public BusinessPriceQueryParam.BusinessPriceQueryParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessPriceQueryParam.BusinessPriceQueryParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public BusinessPriceQueryParam.BusinessPriceQueryParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public BusinessPriceQueryParam.BusinessPriceQueryParamBuilder pricingName(final String pricingName) {
         this.pricingName = pricingName;
         return this;
      }

      public BusinessPriceQueryParam.BusinessPriceQueryParamBuilder pricingMannerEnum(final Integer pricingMannerEnum) {
         this.pricingMannerEnum = pricingMannerEnum;
         return this;
      }

      public BusinessPriceQueryParam.BusinessPriceQueryParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessPriceQueryParam.BusinessPriceQueryParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BusinessPriceQueryParam.BusinessPriceQueryParamBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public BusinessPriceQueryParam.BusinessPriceQueryParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public BusinessPriceQueryParam build() {
         return new BusinessPriceQueryParam(
            this.year,
            this.projectId,
            this.branchCompanyId,
            this.productType,
            this.pricingName,
            this.pricingMannerEnum,
            this.name,
            this.serialNumber,
            this.auditStatus,
            this.projectIds
         );
      }

      @Override
      public String toString() {
         return "BusinessPriceQueryParam.BusinessPriceQueryParamBuilder(year="
            + this.year
            + ", projectId="
            + this.projectId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", productType="
            + this.productType
            + ", pricingName="
            + this.pricingName
            + ", pricingMannerEnum="
            + this.pricingMannerEnum
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", auditStatus="
            + this.auditStatus
            + ", projectIds="
            + this.projectIds
            + ")";
      }
   }
}
