package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;

@ApiModel("我的项目信息返回类")
public class ContractProjectInfoDTO {
   @ApiModelProperty(name = "quantity", notes = "全部项目数量")
   private Integer quantity;
   @ApiModelProperty(name = "processingQuantity", notes = "进行中数量")
   private Integer processingQuantity;
   @ApiModelProperty(name = "completedQuantity", notes = "已完成数量")
   private Integer completedQuantity;
   @ApiModelProperty(name = "monthNewQuantity", notes = "本月新增数量")
   private Integer monthNewQuantity;
   @ApiModelProperty(name = "provinceList", notes = "每省项目数量列表")
   private List<Map<String, Object>> provinceList;
   @ApiModelProperty(name = "selfSupportQuantity", notes = "自营项目数量")
   private Integer selfSupportQuantity;
   @ApiModelProperty(name = "jointVentureQuantity", notes = "合营项目数量")
   private Integer jointVentureQuantity;
   @ApiModelProperty(name = "lumpSumSystemQuantity", notes = "包干制项目数量")
   private Integer lumpSumSystemQuantity;
   @ApiModelProperty(name = "annualCompletedProjectsQuantity", notes = "年度已完工项目数量")
   private Integer annualCompletedProjectsQuantity;
   @ApiModelProperty(name = "annualSettledItemsQuantity", notes = "年度已结算项目数量")
   private Integer annualSettledItemsQuantity;
   @ApiModelProperty(name = "newItemsThisMonthQuantity", notes = "本月新增项目数量")
   private Integer newItemsThisMonthQuantity;
   @ApiModelProperty(name = "uncreatedPlanQuantity", notes = "未创建计划数量")
   private Integer uncreatedPlanQuantity;
   @ApiModelProperty(name = "uncreatedPersonQuantity", notes = "未创建深化负责人项目数量")
   private Integer uncreatedPersonQuantity;

   public static ContractProjectInfoDTO.ContractProjectInfoDTOBuilder builder() {
      return new ContractProjectInfoDTO.ContractProjectInfoDTOBuilder();
   }

   public ContractProjectInfoDTO() {
   }

   public ContractProjectInfoDTO(
      final Integer quantity,
      final Integer processingQuantity,
      final Integer completedQuantity,
      final Integer monthNewQuantity,
      final List<Map<String, Object>> provinceList,
      final Integer selfSupportQuantity,
      final Integer jointVentureQuantity,
      final Integer lumpSumSystemQuantity,
      final Integer annualCompletedProjectsQuantity,
      final Integer annualSettledItemsQuantity,
      final Integer newItemsThisMonthQuantity,
      final Integer uncreatedPlanQuantity,
      final Integer uncreatedPersonQuantity
   ) {
      this.quantity = quantity;
      this.processingQuantity = processingQuantity;
      this.completedQuantity = completedQuantity;
      this.monthNewQuantity = monthNewQuantity;
      this.provinceList = provinceList;
      this.selfSupportQuantity = selfSupportQuantity;
      this.jointVentureQuantity = jointVentureQuantity;
      this.lumpSumSystemQuantity = lumpSumSystemQuantity;
      this.annualCompletedProjectsQuantity = annualCompletedProjectsQuantity;
      this.annualSettledItemsQuantity = annualSettledItemsQuantity;
      this.newItemsThisMonthQuantity = newItemsThisMonthQuantity;
      this.uncreatedPlanQuantity = uncreatedPlanQuantity;
      this.uncreatedPersonQuantity = uncreatedPersonQuantity;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProcessingQuantity() {
      return this.processingQuantity;
   }

   public Integer getCompletedQuantity() {
      return this.completedQuantity;
   }

   public Integer getMonthNewQuantity() {
      return this.monthNewQuantity;
   }

   public List<Map<String, Object>> getProvinceList() {
      return this.provinceList;
   }

   public Integer getSelfSupportQuantity() {
      return this.selfSupportQuantity;
   }

   public Integer getJointVentureQuantity() {
      return this.jointVentureQuantity;
   }

   public Integer getLumpSumSystemQuantity() {
      return this.lumpSumSystemQuantity;
   }

   public Integer getAnnualCompletedProjectsQuantity() {
      return this.annualCompletedProjectsQuantity;
   }

   public Integer getAnnualSettledItemsQuantity() {
      return this.annualSettledItemsQuantity;
   }

   public Integer getNewItemsThisMonthQuantity() {
      return this.newItemsThisMonthQuantity;
   }

   public Integer getUncreatedPlanQuantity() {
      return this.uncreatedPlanQuantity;
   }

   public Integer getUncreatedPersonQuantity() {
      return this.uncreatedPersonQuantity;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setProcessingQuantity(final Integer processingQuantity) {
      this.processingQuantity = processingQuantity;
   }

   public void setCompletedQuantity(final Integer completedQuantity) {
      this.completedQuantity = completedQuantity;
   }

   public void setMonthNewQuantity(final Integer monthNewQuantity) {
      this.monthNewQuantity = monthNewQuantity;
   }

   public void setProvinceList(final List<Map<String, Object>> provinceList) {
      this.provinceList = provinceList;
   }

   public void setSelfSupportQuantity(final Integer selfSupportQuantity) {
      this.selfSupportQuantity = selfSupportQuantity;
   }

   public void setJointVentureQuantity(final Integer jointVentureQuantity) {
      this.jointVentureQuantity = jointVentureQuantity;
   }

   public void setLumpSumSystemQuantity(final Integer lumpSumSystemQuantity) {
      this.lumpSumSystemQuantity = lumpSumSystemQuantity;
   }

   public void setAnnualCompletedProjectsQuantity(final Integer annualCompletedProjectsQuantity) {
      this.annualCompletedProjectsQuantity = annualCompletedProjectsQuantity;
   }

   public void setAnnualSettledItemsQuantity(final Integer annualSettledItemsQuantity) {
      this.annualSettledItemsQuantity = annualSettledItemsQuantity;
   }

   public void setNewItemsThisMonthQuantity(final Integer newItemsThisMonthQuantity) {
      this.newItemsThisMonthQuantity = newItemsThisMonthQuantity;
   }

   public void setUncreatedPlanQuantity(final Integer uncreatedPlanQuantity) {
      this.uncreatedPlanQuantity = uncreatedPlanQuantity;
   }

   public void setUncreatedPersonQuantity(final Integer uncreatedPersonQuantity) {
      this.uncreatedPersonQuantity = uncreatedPersonQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectInfoDTO)) {
         return false;
      }

      ContractProjectInfoDTO other = (ContractProjectInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$processingQuantity = this.getProcessingQuantity();
         Object other$processingQuantity = other.getProcessingQuantity();
         if (this$processingQuantity == null ? other$processingQuantity == null : this$processingQuantity.equals(other$processingQuantity)) {
            Object this$completedQuantity = this.getCompletedQuantity();
            Object other$completedQuantity = other.getCompletedQuantity();
            if (this$completedQuantity == null ? other$completedQuantity == null : this$completedQuantity.equals(other$completedQuantity)) {
               Object this$monthNewQuantity = this.getMonthNewQuantity();
               Object other$monthNewQuantity = other.getMonthNewQuantity();
               if (this$monthNewQuantity == null ? other$monthNewQuantity == null : this$monthNewQuantity.equals(other$monthNewQuantity)) {
                  Object this$selfSupportQuantity = this.getSelfSupportQuantity();
                  Object other$selfSupportQuantity = other.getSelfSupportQuantity();
                  if (this$selfSupportQuantity == null ? other$selfSupportQuantity == null : this$selfSupportQuantity.equals(other$selfSupportQuantity)) {
                     Object this$jointVentureQuantity = this.getJointVentureQuantity();
                     Object other$jointVentureQuantity = other.getJointVentureQuantity();
                     if (this$jointVentureQuantity == null ? other$jointVentureQuantity == null : this$jointVentureQuantity.equals(other$jointVentureQuantity)) {
                        Object this$lumpSumSystemQuantity = this.getLumpSumSystemQuantity();
                        Object other$lumpSumSystemQuantity = other.getLumpSumSystemQuantity();
                        if (this$lumpSumSystemQuantity == null
                           ? other$lumpSumSystemQuantity == null
                           : this$lumpSumSystemQuantity.equals(other$lumpSumSystemQuantity)) {
                           Object this$annualCompletedProjectsQuantity = this.getAnnualCompletedProjectsQuantity();
                           Object other$annualCompletedProjectsQuantity = other.getAnnualCompletedProjectsQuantity();
                           if (this$annualCompletedProjectsQuantity == null
                              ? other$annualCompletedProjectsQuantity == null
                              : this$annualCompletedProjectsQuantity.equals(other$annualCompletedProjectsQuantity)) {
                              Object this$annualSettledItemsQuantity = this.getAnnualSettledItemsQuantity();
                              Object other$annualSettledItemsQuantity = other.getAnnualSettledItemsQuantity();
                              if (this$annualSettledItemsQuantity == null
                                 ? other$annualSettledItemsQuantity == null
                                 : this$annualSettledItemsQuantity.equals(other$annualSettledItemsQuantity)) {
                                 Object this$newItemsThisMonthQuantity = this.getNewItemsThisMonthQuantity();
                                 Object other$newItemsThisMonthQuantity = other.getNewItemsThisMonthQuantity();
                                 if (this$newItemsThisMonthQuantity == null
                                    ? other$newItemsThisMonthQuantity == null
                                    : this$newItemsThisMonthQuantity.equals(other$newItemsThisMonthQuantity)) {
                                    Object this$uncreatedPlanQuantity = this.getUncreatedPlanQuantity();
                                    Object other$uncreatedPlanQuantity = other.getUncreatedPlanQuantity();
                                    if (this$uncreatedPlanQuantity == null
                                       ? other$uncreatedPlanQuantity == null
                                       : this$uncreatedPlanQuantity.equals(other$uncreatedPlanQuantity)) {
                                       Object this$uncreatedPersonQuantity = this.getUncreatedPersonQuantity();
                                       Object other$uncreatedPersonQuantity = other.getUncreatedPersonQuantity();
                                       if (this$uncreatedPersonQuantity == null
                                          ? other$uncreatedPersonQuantity == null
                                          : this$uncreatedPersonQuantity.equals(other$uncreatedPersonQuantity)) {
                                          Object this$provinceList = this.getProvinceList();
                                          Object other$provinceList = other.getProvinceList();
                                          return this$provinceList == null ? other$provinceList == null : this$provinceList.equals(other$provinceList);
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
      return other instanceof ContractProjectInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $processingQuantity = this.getProcessingQuantity();
      result = result * 59 + ($processingQuantity == null ? 43 : $processingQuantity.hashCode());
      Object $completedQuantity = this.getCompletedQuantity();
      result = result * 59 + ($completedQuantity == null ? 43 : $completedQuantity.hashCode());
      Object $monthNewQuantity = this.getMonthNewQuantity();
      result = result * 59 + ($monthNewQuantity == null ? 43 : $monthNewQuantity.hashCode());
      Object $selfSupportQuantity = this.getSelfSupportQuantity();
      result = result * 59 + ($selfSupportQuantity == null ? 43 : $selfSupportQuantity.hashCode());
      Object $jointVentureQuantity = this.getJointVentureQuantity();
      result = result * 59 + ($jointVentureQuantity == null ? 43 : $jointVentureQuantity.hashCode());
      Object $lumpSumSystemQuantity = this.getLumpSumSystemQuantity();
      result = result * 59 + ($lumpSumSystemQuantity == null ? 43 : $lumpSumSystemQuantity.hashCode());
      Object $annualCompletedProjectsQuantity = this.getAnnualCompletedProjectsQuantity();
      result = result * 59 + ($annualCompletedProjectsQuantity == null ? 43 : $annualCompletedProjectsQuantity.hashCode());
      Object $annualSettledItemsQuantity = this.getAnnualSettledItemsQuantity();
      result = result * 59 + ($annualSettledItemsQuantity == null ? 43 : $annualSettledItemsQuantity.hashCode());
      Object $newItemsThisMonthQuantity = this.getNewItemsThisMonthQuantity();
      result = result * 59 + ($newItemsThisMonthQuantity == null ? 43 : $newItemsThisMonthQuantity.hashCode());
      Object $uncreatedPlanQuantity = this.getUncreatedPlanQuantity();
      result = result * 59 + ($uncreatedPlanQuantity == null ? 43 : $uncreatedPlanQuantity.hashCode());
      Object $uncreatedPersonQuantity = this.getUncreatedPersonQuantity();
      result = result * 59 + ($uncreatedPersonQuantity == null ? 43 : $uncreatedPersonQuantity.hashCode());
      Object $provinceList = this.getProvinceList();
      return result * 59 + ($provinceList == null ? 43 : $provinceList.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectInfoDTO(quantity="
         + this.getQuantity()
         + ", processingQuantity="
         + this.getProcessingQuantity()
         + ", completedQuantity="
         + this.getCompletedQuantity()
         + ", monthNewQuantity="
         + this.getMonthNewQuantity()
         + ", provinceList="
         + this.getProvinceList()
         + ", selfSupportQuantity="
         + this.getSelfSupportQuantity()
         + ", jointVentureQuantity="
         + this.getJointVentureQuantity()
         + ", lumpSumSystemQuantity="
         + this.getLumpSumSystemQuantity()
         + ", annualCompletedProjectsQuantity="
         + this.getAnnualCompletedProjectsQuantity()
         + ", annualSettledItemsQuantity="
         + this.getAnnualSettledItemsQuantity()
         + ", newItemsThisMonthQuantity="
         + this.getNewItemsThisMonthQuantity()
         + ", uncreatedPlanQuantity="
         + this.getUncreatedPlanQuantity()
         + ", uncreatedPersonQuantity="
         + this.getUncreatedPersonQuantity()
         + ")";
   }

   public static class ContractProjectInfoDTOBuilder {
      private Integer quantity;
      private Integer processingQuantity;
      private Integer completedQuantity;
      private Integer monthNewQuantity;
      private List<Map<String, Object>> provinceList;
      private Integer selfSupportQuantity;
      private Integer jointVentureQuantity;
      private Integer lumpSumSystemQuantity;
      private Integer annualCompletedProjectsQuantity;
      private Integer annualSettledItemsQuantity;
      private Integer newItemsThisMonthQuantity;
      private Integer uncreatedPlanQuantity;
      private Integer uncreatedPersonQuantity;

      ContractProjectInfoDTOBuilder() {
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder processingQuantity(final Integer processingQuantity) {
         this.processingQuantity = processingQuantity;
         return this;
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder completedQuantity(final Integer completedQuantity) {
         this.completedQuantity = completedQuantity;
         return this;
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder monthNewQuantity(final Integer monthNewQuantity) {
         this.monthNewQuantity = monthNewQuantity;
         return this;
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder provinceList(final List<Map<String, Object>> provinceList) {
         this.provinceList = provinceList;
         return this;
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder selfSupportQuantity(final Integer selfSupportQuantity) {
         this.selfSupportQuantity = selfSupportQuantity;
         return this;
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder jointVentureQuantity(final Integer jointVentureQuantity) {
         this.jointVentureQuantity = jointVentureQuantity;
         return this;
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder lumpSumSystemQuantity(final Integer lumpSumSystemQuantity) {
         this.lumpSumSystemQuantity = lumpSumSystemQuantity;
         return this;
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder annualCompletedProjectsQuantity(final Integer annualCompletedProjectsQuantity) {
         this.annualCompletedProjectsQuantity = annualCompletedProjectsQuantity;
         return this;
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder annualSettledItemsQuantity(final Integer annualSettledItemsQuantity) {
         this.annualSettledItemsQuantity = annualSettledItemsQuantity;
         return this;
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder newItemsThisMonthQuantity(final Integer newItemsThisMonthQuantity) {
         this.newItemsThisMonthQuantity = newItemsThisMonthQuantity;
         return this;
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder uncreatedPlanQuantity(final Integer uncreatedPlanQuantity) {
         this.uncreatedPlanQuantity = uncreatedPlanQuantity;
         return this;
      }

      public ContractProjectInfoDTO.ContractProjectInfoDTOBuilder uncreatedPersonQuantity(final Integer uncreatedPersonQuantity) {
         this.uncreatedPersonQuantity = uncreatedPersonQuantity;
         return this;
      }

      public ContractProjectInfoDTO build() {
         return new ContractProjectInfoDTO(
            this.quantity,
            this.processingQuantity,
            this.completedQuantity,
            this.monthNewQuantity,
            this.provinceList,
            this.selfSupportQuantity,
            this.jointVentureQuantity,
            this.lumpSumSystemQuantity,
            this.annualCompletedProjectsQuantity,
            this.annualSettledItemsQuantity,
            this.newItemsThisMonthQuantity,
            this.uncreatedPlanQuantity,
            this.uncreatedPersonQuantity
         );
      }

      @Override
      public String toString() {
         return "ContractProjectInfoDTO.ContractProjectInfoDTOBuilder(quantity="
            + this.quantity
            + ", processingQuantity="
            + this.processingQuantity
            + ", completedQuantity="
            + this.completedQuantity
            + ", monthNewQuantity="
            + this.monthNewQuantity
            + ", provinceList="
            + this.provinceList
            + ", selfSupportQuantity="
            + this.selfSupportQuantity
            + ", jointVentureQuantity="
            + this.jointVentureQuantity
            + ", lumpSumSystemQuantity="
            + this.lumpSumSystemQuantity
            + ", annualCompletedProjectsQuantity="
            + this.annualCompletedProjectsQuantity
            + ", annualSettledItemsQuantity="
            + this.annualSettledItemsQuantity
            + ", newItemsThisMonthQuantity="
            + this.newItemsThisMonthQuantity
            + ", uncreatedPlanQuantity="
            + this.uncreatedPlanQuantity
            + ", uncreatedPersonQuantity="
            + this.uncreatedPersonQuantity
            + ")";
      }
   }
}
