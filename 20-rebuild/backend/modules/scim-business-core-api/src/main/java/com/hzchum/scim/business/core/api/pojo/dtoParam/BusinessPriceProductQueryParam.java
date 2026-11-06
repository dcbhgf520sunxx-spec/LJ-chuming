package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class BusinessPriceProductQueryParam {
   @NotNull(message = "未选择项目!")
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id", notes = "分支机构id")
   private Long branchCompanyId;
   @NotNull(message = "未传产品类型!")
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   private String material;
   @ApiModelProperty("是否项目签订主体")
   private Boolean boolContractSignBody;

   public static BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder builder() {
      return new BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPriceProductQueryParam)) {
         return false;
      }

      BusinessPriceProductQueryParam other = (BusinessPriceProductQueryParam)o;
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
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$boolContractSignBody = this.getBoolContractSignBody();
                     Object other$boolContractSignBody = other.getBoolContractSignBody();
                     if (this$boolContractSignBody == null ? other$boolContractSignBody == null : this$boolContractSignBody.equals(other$boolContractSignBody)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 return this$material == null ? other$material == null : this$material.equals(other$material);
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
      return other instanceof BusinessPriceProductQueryParam;
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
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $boolContractSignBody = this.getBoolContractSignBody();
      result = result * 59 + ($boolContractSignBody == null ? 43 : $boolContractSignBody.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   public BusinessPriceProductQueryParam() {
   }

   public BusinessPriceProductQueryParam(
      final Long projectId,
      final Long branchCompanyId,
      final Integer productType,
      final Long monomerId,
      final Long areaId,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Boolean boolContractSignBody
   ) {
      this.projectId = projectId;
      this.branchCompanyId = branchCompanyId;
      this.productType = productType;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.boolContractSignBody = boolContractSignBody;
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

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public Boolean getBoolContractSignBody() {
      return this.boolContractSignBody;
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

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setBoolContractSignBody(final Boolean boolContractSignBody) {
      this.boolContractSignBody = boolContractSignBody;
   }

   @Override
   public String toString() {
      return "BusinessPriceProductQueryParam(projectId="
         + this.getProjectId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", productType="
         + this.getProductType()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", boolContractSignBody="
         + this.getBoolContractSignBody()
         + ")";
   }

   public static class BusinessPriceProductQueryParamBuilder {
      private Long projectId;
      private Long branchCompanyId;
      private Integer productType;
      private Long monomerId;
      private Long areaId;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Boolean boolContractSignBody;

      BusinessPriceProductQueryParamBuilder() {
      }

      public BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder boolContractSignBody(final Boolean boolContractSignBody) {
         this.boolContractSignBody = boolContractSignBody;
         return this;
      }

      public BusinessPriceProductQueryParam build() {
         return new BusinessPriceProductQueryParam(
            this.projectId,
            this.branchCompanyId,
            this.productType,
            this.monomerId,
            this.areaId,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.boolContractSignBody
         );
      }

      @Override
      public String toString() {
         return "BusinessPriceProductQueryParam.BusinessPriceProductQueryParamBuilder(projectId="
            + this.projectId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", productType="
            + this.productType
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", boolContractSignBody="
            + this.boolContractSignBody
            + ")";
      }
   }
}
