package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "BusinessPrice对象", description = "产品计价-新增")
public class BusinessPriceAddParam {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "boolAddEnum", value = "是否追加", notes = "是否追加")
   private Boolean boolAddEnum;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @NotNull(message = "未选择项目!")
   private Long projectId;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id", notes = "分支机构id")
   private Long branchCompanyId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @NotNull(message = "未选择产品类型!")
   private Integer productType;
   @ApiModelProperty(name = "pricingName", value = "计价名称", notes = "计价名称")
   private String pricingName;
   @ApiModelProperty(name = "pricingMannerEnum", value = "计价类型", notes = "计价类型")
   private Integer pricingMannerEnum;
   @ApiModelProperty(name = "pricingUnitTypeEnum", value = "计价单位类型", notes = "计价单位类型")
   private Integer pricingUnitTypeEnum;
   @ApiModelProperty(name = "pricingWeightTypeEnum", value = "(构件)计价重量类型 1净重 2毛重 4图纸重'", notes = "(构件)计价重量类型 1净重 2毛重 4图纸重'")
   private Integer pricingWeightTypeEnum;
   @ApiModelProperty(name = "unitPrice", value = "单价(元)", notes = "单价(元)")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @Valid
   @NotEmpty(message = "计价产品不能为空!")
   @ApiModelProperty(name = "businessPriceDetailList", value = "计价产品列表", notes = "计价产品列表")
   private List<BusinessPriceDetailParam> businessPriceDetailList;

   public static BusinessPriceAddParam.BusinessPriceAddParamBuilder builder() {
      return new BusinessPriceAddParam.BusinessPriceAddParamBuilder();
   }

   public BusinessPriceAddParam() {
   }

   public BusinessPriceAddParam(
      final Long id,
      final Boolean boolAddEnum,
      final Long projectId,
      final Long branchCompanyId,
      final Integer productType,
      final String pricingName,
      final Integer pricingMannerEnum,
      final Integer pricingUnitTypeEnum,
      final Integer pricingWeightTypeEnum,
      final BigDecimal unitPrice,
      final String remark,
      final List<BusinessPriceDetailParam> businessPriceDetailList
   ) {
      this.id = id;
      this.boolAddEnum = boolAddEnum;
      this.projectId = projectId;
      this.branchCompanyId = branchCompanyId;
      this.productType = productType;
      this.pricingName = pricingName;
      this.pricingMannerEnum = pricingMannerEnum;
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
      this.unitPrice = unitPrice;
      this.remark = remark;
      this.businessPriceDetailList = businessPriceDetailList;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolAddEnum() {
      return this.boolAddEnum;
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

   public Integer getPricingUnitTypeEnum() {
      return this.pricingUnitTypeEnum;
   }

   public Integer getPricingWeightTypeEnum() {
      return this.pricingWeightTypeEnum;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<BusinessPriceDetailParam> getBusinessPriceDetailList() {
      return this.businessPriceDetailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBoolAddEnum(final Boolean boolAddEnum) {
      this.boolAddEnum = boolAddEnum;
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

   public void setPricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
   }

   public void setPricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBusinessPriceDetailList(final List<BusinessPriceDetailParam> businessPriceDetailList) {
      this.businessPriceDetailList = businessPriceDetailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPriceAddParam)) {
         return false;
      }

      BusinessPriceAddParam other = (BusinessPriceAddParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolAddEnum = this.getBoolAddEnum();
         Object other$boolAddEnum = other.getBoolAddEnum();
         if (this$boolAddEnum == null ? other$boolAddEnum == null : this$boolAddEnum.equals(other$boolAddEnum)) {
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
                        Object this$pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
                        Object other$pricingUnitTypeEnum = other.getPricingUnitTypeEnum();
                        if (this$pricingUnitTypeEnum == null ? other$pricingUnitTypeEnum == null : this$pricingUnitTypeEnum.equals(other$pricingUnitTypeEnum)) {
                           Object this$pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
                           Object other$pricingWeightTypeEnum = other.getPricingWeightTypeEnum();
                           if (this$pricingWeightTypeEnum == null
                              ? other$pricingWeightTypeEnum == null
                              : this$pricingWeightTypeEnum.equals(other$pricingWeightTypeEnum)) {
                              Object this$pricingName = this.getPricingName();
                              Object other$pricingName = other.getPricingName();
                              if (this$pricingName == null ? other$pricingName == null : this$pricingName.equals(other$pricingName)) {
                                 Object this$unitPrice = this.getUnitPrice();
                                 Object other$unitPrice = other.getUnitPrice();
                                 if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$businessPriceDetailList = this.getBusinessPriceDetailList();
                                       Object other$businessPriceDetailList = other.getBusinessPriceDetailList();
                                       return this$businessPriceDetailList == null
                                          ? other$businessPriceDetailList == null
                                          : this$businessPriceDetailList.equals(other$businessPriceDetailList);
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
      return other instanceof BusinessPriceAddParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolAddEnum = this.getBoolAddEnum();
      result = result * 59 + ($boolAddEnum == null ? 43 : $boolAddEnum.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $pricingMannerEnum = this.getPricingMannerEnum();
      result = result * 59 + ($pricingMannerEnum == null ? 43 : $pricingMannerEnum.hashCode());
      Object $pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
      result = result * 59 + ($pricingUnitTypeEnum == null ? 43 : $pricingUnitTypeEnum.hashCode());
      Object $pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
      result = result * 59 + ($pricingWeightTypeEnum == null ? 43 : $pricingWeightTypeEnum.hashCode());
      Object $pricingName = this.getPricingName();
      result = result * 59 + ($pricingName == null ? 43 : $pricingName.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $businessPriceDetailList = this.getBusinessPriceDetailList();
      return result * 59 + ($businessPriceDetailList == null ? 43 : $businessPriceDetailList.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessPriceAddParam(id="
         + this.getId()
         + ", boolAddEnum="
         + this.getBoolAddEnum()
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
         + ", pricingUnitTypeEnum="
         + this.getPricingUnitTypeEnum()
         + ", pricingWeightTypeEnum="
         + this.getPricingWeightTypeEnum()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", remark="
         + this.getRemark()
         + ", businessPriceDetailList="
         + this.getBusinessPriceDetailList()
         + ")";
   }

   public static class BusinessPriceAddParamBuilder {
      private Long id;
      private Boolean boolAddEnum;
      private Long projectId;
      private Long branchCompanyId;
      private Integer productType;
      private String pricingName;
      private Integer pricingMannerEnum;
      private Integer pricingUnitTypeEnum;
      private Integer pricingWeightTypeEnum;
      private BigDecimal unitPrice;
      private String remark;
      private List<BusinessPriceDetailParam> businessPriceDetailList;

      BusinessPriceAddParamBuilder() {
      }

      public BusinessPriceAddParam.BusinessPriceAddParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessPriceAddParam.BusinessPriceAddParamBuilder boolAddEnum(final Boolean boolAddEnum) {
         this.boolAddEnum = boolAddEnum;
         return this;
      }

      public BusinessPriceAddParam.BusinessPriceAddParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessPriceAddParam.BusinessPriceAddParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public BusinessPriceAddParam.BusinessPriceAddParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public BusinessPriceAddParam.BusinessPriceAddParamBuilder pricingName(final String pricingName) {
         this.pricingName = pricingName;
         return this;
      }

      public BusinessPriceAddParam.BusinessPriceAddParamBuilder pricingMannerEnum(final Integer pricingMannerEnum) {
         this.pricingMannerEnum = pricingMannerEnum;
         return this;
      }

      public BusinessPriceAddParam.BusinessPriceAddParamBuilder pricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
         this.pricingUnitTypeEnum = pricingUnitTypeEnum;
         return this;
      }

      public BusinessPriceAddParam.BusinessPriceAddParamBuilder pricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
         this.pricingWeightTypeEnum = pricingWeightTypeEnum;
         return this;
      }

      public BusinessPriceAddParam.BusinessPriceAddParamBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessPriceAddParam.BusinessPriceAddParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public BusinessPriceAddParam.BusinessPriceAddParamBuilder businessPriceDetailList(final List<BusinessPriceDetailParam> businessPriceDetailList) {
         this.businessPriceDetailList = businessPriceDetailList;
         return this;
      }

      public BusinessPriceAddParam build() {
         return new BusinessPriceAddParam(
            this.id,
            this.boolAddEnum,
            this.projectId,
            this.branchCompanyId,
            this.productType,
            this.pricingName,
            this.pricingMannerEnum,
            this.pricingUnitTypeEnum,
            this.pricingWeightTypeEnum,
            this.unitPrice,
            this.remark,
            this.businessPriceDetailList
         );
      }

      @Override
      public String toString() {
         return "BusinessPriceAddParam.BusinessPriceAddParamBuilder(id="
            + this.id
            + ", boolAddEnum="
            + this.boolAddEnum
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
            + ", pricingUnitTypeEnum="
            + this.pricingUnitTypeEnum
            + ", pricingWeightTypeEnum="
            + this.pricingWeightTypeEnum
            + ", unitPrice="
            + this.unitPrice
            + ", remark="
            + this.remark
            + ", businessPriceDetailList="
            + this.businessPriceDetailList
            + ")";
      }
   }
}
