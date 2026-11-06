package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("定额配置条件Query")
public class MesQuotaConfigConditionQuery {
   @ApiModelProperty("机构id")
   private Long branchCompanyId;
   @ApiModelProperty("机构idList")
   private List<Long> branchCompanyIdList;
   @ApiModelProperty("车间id")
   private Long workshopId;
   @ApiModelProperty("车间idList")
   private List<Long> workshopIdList;
   @ApiModelProperty("产品分类")
   private Integer productClassificationEnum;
   @ApiModelProperty("产品分类")
   private List<Integer> productClassificationEnumList;
   @ApiModelProperty("产品类别id")
   private Long productClassId;
   @ApiModelProperty("产品类别idList")
   private List<Long> productClassIdList;
   @ApiModelProperty("工序id")
   private Long processId;
   @ApiModelProperty("工序idList")
   private List<Long> processIdList;
   @ApiModelProperty("类型名称")
   private String typeName;
   @ApiModelProperty("围护类型字典id")
   private Long enclosureTypeDictionaryId;

   public static MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder builder() {
      return new MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder();
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public List<Long> getBranchCompanyIdList() {
      return this.branchCompanyIdList;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public List<Long> getWorkshopIdList() {
      return this.workshopIdList;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public List<Integer> getProductClassificationEnumList() {
      return this.productClassificationEnumList;
   }

   public Long getProductClassId() {
      return this.productClassId;
   }

   public List<Long> getProductClassIdList() {
      return this.productClassIdList;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public List<Long> getProcessIdList() {
      return this.processIdList;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public Long getEnclosureTypeDictionaryId() {
      return this.enclosureTypeDictionaryId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyIdList(final List<Long> branchCompanyIdList) {
      this.branchCompanyIdList = branchCompanyIdList;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   public void setProductClassificationEnumList(final List<Integer> productClassificationEnumList) {
      this.productClassificationEnumList = productClassificationEnumList;
   }

   public void setProductClassId(final Long productClassId) {
      this.productClassId = productClassId;
   }

   public void setProductClassIdList(final List<Long> productClassIdList) {
      this.productClassIdList = productClassIdList;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProcessIdList(final List<Long> processIdList) {
      this.processIdList = processIdList;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setEnclosureTypeDictionaryId(final Long enclosureTypeDictionaryId) {
      this.enclosureTypeDictionaryId = enclosureTypeDictionaryId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigConditionQuery)) {
         return false;
      }

      MesQuotaConfigConditionQuery other = (MesQuotaConfigConditionQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$branchCompanyId = this.getBranchCompanyId();
      Object other$branchCompanyId = other.getBranchCompanyId();
      if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$productClassificationEnum = this.getProductClassificationEnum();
            Object other$productClassificationEnum = other.getProductClassificationEnum();
            if (this$productClassificationEnum == null
               ? other$productClassificationEnum == null
               : this$productClassificationEnum.equals(other$productClassificationEnum)) {
               Object this$productClassId = this.getProductClassId();
               Object other$productClassId = other.getProductClassId();
               if (this$productClassId == null ? other$productClassId == null : this$productClassId.equals(other$productClassId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$enclosureTypeDictionaryId = this.getEnclosureTypeDictionaryId();
                     Object other$enclosureTypeDictionaryId = other.getEnclosureTypeDictionaryId();
                     if (this$enclosureTypeDictionaryId == null
                        ? other$enclosureTypeDictionaryId == null
                        : this$enclosureTypeDictionaryId.equals(other$enclosureTypeDictionaryId)) {
                        Object this$branchCompanyIdList = this.getBranchCompanyIdList();
                        Object other$branchCompanyIdList = other.getBranchCompanyIdList();
                        if (this$branchCompanyIdList == null ? other$branchCompanyIdList == null : this$branchCompanyIdList.equals(other$branchCompanyIdList)) {
                           Object this$workshopIdList = this.getWorkshopIdList();
                           Object other$workshopIdList = other.getWorkshopIdList();
                           if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
                              Object this$productClassificationEnumList = this.getProductClassificationEnumList();
                              Object other$productClassificationEnumList = other.getProductClassificationEnumList();
                              if (this$productClassificationEnumList == null
                                 ? other$productClassificationEnumList == null
                                 : this$productClassificationEnumList.equals(other$productClassificationEnumList)) {
                                 Object this$productClassIdList = this.getProductClassIdList();
                                 Object other$productClassIdList = other.getProductClassIdList();
                                 if (this$productClassIdList == null
                                    ? other$productClassIdList == null
                                    : this$productClassIdList.equals(other$productClassIdList)) {
                                    Object this$processIdList = this.getProcessIdList();
                                    Object other$processIdList = other.getProcessIdList();
                                    if (this$processIdList == null ? other$processIdList == null : this$processIdList.equals(other$processIdList)) {
                                       Object this$typeName = this.getTypeName();
                                       Object other$typeName = other.getTypeName();
                                       return this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName);
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
      return other instanceof MesQuotaConfigConditionQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $productClassId = this.getProductClassId();
      result = result * 59 + ($productClassId == null ? 43 : $productClassId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $enclosureTypeDictionaryId = this.getEnclosureTypeDictionaryId();
      result = result * 59 + ($enclosureTypeDictionaryId == null ? 43 : $enclosureTypeDictionaryId.hashCode());
      Object $branchCompanyIdList = this.getBranchCompanyIdList();
      result = result * 59 + ($branchCompanyIdList == null ? 43 : $branchCompanyIdList.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $productClassificationEnumList = this.getProductClassificationEnumList();
      result = result * 59 + ($productClassificationEnumList == null ? 43 : $productClassificationEnumList.hashCode());
      Object $productClassIdList = this.getProductClassIdList();
      result = result * 59 + ($productClassIdList == null ? 43 : $productClassIdList.hashCode());
      Object $processIdList = this.getProcessIdList();
      result = result * 59 + ($processIdList == null ? 43 : $processIdList.hashCode());
      Object $typeName = this.getTypeName();
      return result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
   }

   @Override
   public String toString() {
      return "MesQuotaConfigConditionQuery(branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyIdList="
         + this.getBranchCompanyIdList()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", productClassificationEnumList="
         + this.getProductClassificationEnumList()
         + ", productClassId="
         + this.getProductClassId()
         + ", productClassIdList="
         + this.getProductClassIdList()
         + ", processId="
         + this.getProcessId()
         + ", processIdList="
         + this.getProcessIdList()
         + ", typeName="
         + this.getTypeName()
         + ", enclosureTypeDictionaryId="
         + this.getEnclosureTypeDictionaryId()
         + ")";
   }

   public MesQuotaConfigConditionQuery() {
   }

   public MesQuotaConfigConditionQuery(
      final Long branchCompanyId,
      final List<Long> branchCompanyIdList,
      final Long workshopId,
      final List<Long> workshopIdList,
      final Integer productClassificationEnum,
      final List<Integer> productClassificationEnumList,
      final Long productClassId,
      final List<Long> productClassIdList,
      final Long processId,
      final List<Long> processIdList,
      final String typeName,
      final Long enclosureTypeDictionaryId
   ) {
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyIdList = branchCompanyIdList;
      this.workshopId = workshopId;
      this.workshopIdList = workshopIdList;
      this.productClassificationEnum = productClassificationEnum;
      this.productClassificationEnumList = productClassificationEnumList;
      this.productClassId = productClassId;
      this.productClassIdList = productClassIdList;
      this.processId = processId;
      this.processIdList = processIdList;
      this.typeName = typeName;
      this.enclosureTypeDictionaryId = enclosureTypeDictionaryId;
   }

   public static class MesQuotaConfigConditionQueryBuilder {
      private Long branchCompanyId;
      private List<Long> branchCompanyIdList;
      private Long workshopId;
      private List<Long> workshopIdList;
      private Integer productClassificationEnum;
      private List<Integer> productClassificationEnumList;
      private Long productClassId;
      private List<Long> productClassIdList;
      private Long processId;
      private List<Long> processIdList;
      private String typeName;
      private Long enclosureTypeDictionaryId;

      MesQuotaConfigConditionQueryBuilder() {
      }

      public MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder branchCompanyIdList(final List<Long> branchCompanyIdList) {
         this.branchCompanyIdList = branchCompanyIdList;
         return this;
      }

      public MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder workshopIdList(final List<Long> workshopIdList) {
         this.workshopIdList = workshopIdList;
         return this;
      }

      public MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      public MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder productClassificationEnumList(final List<Integer> productClassificationEnumList) {
         this.productClassificationEnumList = productClassificationEnumList;
         return this;
      }

      public MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder productClassId(final Long productClassId) {
         this.productClassId = productClassId;
         return this;
      }

      public MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder productClassIdList(final List<Long> productClassIdList) {
         this.productClassIdList = productClassIdList;
         return this;
      }

      public MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder processIdList(final List<Long> processIdList) {
         this.processIdList = processIdList;
         return this;
      }

      public MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder typeName(final String typeName) {
         this.typeName = typeName;
         return this;
      }

      public MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder enclosureTypeDictionaryId(final Long enclosureTypeDictionaryId) {
         this.enclosureTypeDictionaryId = enclosureTypeDictionaryId;
         return this;
      }

      public MesQuotaConfigConditionQuery build() {
         return new MesQuotaConfigConditionQuery(
            this.branchCompanyId,
            this.branchCompanyIdList,
            this.workshopId,
            this.workshopIdList,
            this.productClassificationEnum,
            this.productClassificationEnumList,
            this.productClassId,
            this.productClassIdList,
            this.processId,
            this.processIdList,
            this.typeName,
            this.enclosureTypeDictionaryId
         );
      }

      @Override
      public String toString() {
         return "MesQuotaConfigConditionQuery.MesQuotaConfigConditionQueryBuilder(branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyIdList="
            + this.branchCompanyIdList
            + ", workshopId="
            + this.workshopId
            + ", workshopIdList="
            + this.workshopIdList
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", productClassificationEnumList="
            + this.productClassificationEnumList
            + ", productClassId="
            + this.productClassId
            + ", productClassIdList="
            + this.productClassIdList
            + ", processId="
            + this.processId
            + ", processIdList="
            + this.processIdList
            + ", typeName="
            + this.typeName
            + ", enclosureTypeDictionaryId="
            + this.enclosureTypeDictionaryId
            + ")";
      }
   }
}
