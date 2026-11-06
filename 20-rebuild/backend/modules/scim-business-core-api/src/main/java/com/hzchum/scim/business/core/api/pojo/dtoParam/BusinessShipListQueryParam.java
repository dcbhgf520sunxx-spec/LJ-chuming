package com.hzchum.scim.business.core.api.pojo.dtoParam;

public class BusinessShipListQueryParam {
   private Long branchCompanyId;
   private Long projectId;
   private Long monomerId;
   private Long areaId;
   private Integer handleMethod;
   private Integer category;
   private Long enclosurePlanId;
   private Integer monthType;
   private Integer productType;
   private String name;
   private String serialNumber;
   private String specification;
   private String material;

   public static BusinessShipListQueryParam.BusinessShipListQueryParamBuilder builder() {
      return new BusinessShipListQueryParam.BusinessShipListQueryParamBuilder();
   }

   public BusinessShipListQueryParam(
      final Long branchCompanyId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer handleMethod,
      final Integer category,
      final Long enclosurePlanId,
      final Integer monthType,
      final Integer productType,
      final String name,
      final String serialNumber,
      final String specification,
      final String material
   ) {
      this.branchCompanyId = branchCompanyId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.handleMethod = handleMethod;
      this.category = category;
      this.enclosurePlanId = enclosurePlanId;
      this.monthType = monthType;
      this.productType = productType;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
   }

   public BusinessShipListQueryParam() {
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getHandleMethod() {
      return this.handleMethod;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Integer getMonthType() {
      return this.monthType;
   }

   public Integer getProductType() {
      return this.productType;
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

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setHandleMethod(final Integer handleMethod) {
      this.handleMethod = handleMethod;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   public void setMonthType(final Integer monthType) {
      this.monthType = monthType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessShipListQueryParam)) {
         return false;
      }

      BusinessShipListQueryParam other = (BusinessShipListQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$branchCompanyId = this.getBranchCompanyId();
      Object other$branchCompanyId = other.getBranchCompanyId();
      if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$handleMethod = this.getHandleMethod();
                  Object other$handleMethod = other.getHandleMethod();
                  if (this$handleMethod == null ? other$handleMethod == null : this$handleMethod.equals(other$handleMethod)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$enclosurePlanId = this.getEnclosurePlanId();
                        Object other$enclosurePlanId = other.getEnclosurePlanId();
                        if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                           Object this$monthType = this.getMonthType();
                           Object other$monthType = other.getMonthType();
                           if (this$monthType == null ? other$monthType == null : this$monthType.equals(other$monthType)) {
                              Object this$productType = this.getProductType();
                              Object other$productType = other.getProductType();
                              if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
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
      return other instanceof BusinessShipListQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $handleMethod = this.getHandleMethod();
      result = result * 59 + ($handleMethod == null ? 43 : $handleMethod.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $monthType = this.getMonthType();
      result = result * 59 + ($monthType == null ? 43 : $monthType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessShipListQueryParam(branchCompanyId="
         + this.getBranchCompanyId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", handleMethod="
         + this.getHandleMethod()
         + ", category="
         + this.getCategory()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", monthType="
         + this.getMonthType()
         + ", productType="
         + this.getProductType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ")";
   }

   public static class BusinessShipListQueryParamBuilder {
      private Long branchCompanyId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer handleMethod;
      private Integer category;
      private Long enclosurePlanId;
      private Integer monthType;
      private Integer productType;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;

      BusinessShipListQueryParamBuilder() {
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder handleMethod(final Integer handleMethod) {
         this.handleMethod = handleMethod;
         return this;
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder monthType(final Integer monthType) {
         this.monthType = monthType;
         return this;
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessShipListQueryParam.BusinessShipListQueryParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BusinessShipListQueryParam build() {
         return new BusinessShipListQueryParam(
            this.branchCompanyId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.handleMethod,
            this.category,
            this.enclosurePlanId,
            this.monthType,
            this.productType,
            this.name,
            this.serialNumber,
            this.specification,
            this.material
         );
      }

      @Override
      public String toString() {
         return "BusinessShipListQueryParam.BusinessShipListQueryParamBuilder(branchCompanyId="
            + this.branchCompanyId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", handleMethod="
            + this.handleMethod
            + ", category="
            + this.category
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", monthType="
            + this.monthType
            + ", productType="
            + this.productType
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ")";
      }
   }
}
