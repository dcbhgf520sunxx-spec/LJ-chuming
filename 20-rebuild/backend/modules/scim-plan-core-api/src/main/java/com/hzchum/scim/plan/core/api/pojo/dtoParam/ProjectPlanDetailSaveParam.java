package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(description = "项目计划详情SaveParam类")
public class ProjectPlanDetailSaveParam {
   @Valid
   @ApiModelProperty("单体区域新增修改列表")
   private List<ProjectPlanDetailSaveParam.MonomerSaveParam> monomerSaveParams;
   @ApiModelProperty("单体删除ID列表")
   private List<Long> removeMonomerIds;
   @ApiModelProperty("区域删除ID列表")
   private List<Long> removeAreaIds;

   public List<ProjectPlanDetailSaveParam.MonomerSaveParam> getMonomerSaveParams() {
      return this.monomerSaveParams;
   }

   public List<Long> getRemoveMonomerIds() {
      return this.removeMonomerIds;
   }

   public List<Long> getRemoveAreaIds() {
      return this.removeAreaIds;
   }

   public void setMonomerSaveParams(final List<ProjectPlanDetailSaveParam.MonomerSaveParam> monomerSaveParams) {
      this.monomerSaveParams = monomerSaveParams;
   }

   public void setRemoveMonomerIds(final List<Long> removeMonomerIds) {
      this.removeMonomerIds = removeMonomerIds;
   }

   public void setRemoveAreaIds(final List<Long> removeAreaIds) {
      this.removeAreaIds = removeAreaIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPlanDetailSaveParam)) {
         return false;
      }

      ProjectPlanDetailSaveParam other = (ProjectPlanDetailSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerSaveParams = this.getMonomerSaveParams();
      Object other$monomerSaveParams = other.getMonomerSaveParams();
      if (this$monomerSaveParams == null ? other$monomerSaveParams == null : this$monomerSaveParams.equals(other$monomerSaveParams)) {
         Object this$removeMonomerIds = this.getRemoveMonomerIds();
         Object other$removeMonomerIds = other.getRemoveMonomerIds();
         if (this$removeMonomerIds == null ? other$removeMonomerIds == null : this$removeMonomerIds.equals(other$removeMonomerIds)) {
            Object this$removeAreaIds = this.getRemoveAreaIds();
            Object other$removeAreaIds = other.getRemoveAreaIds();
            return this$removeAreaIds == null ? other$removeAreaIds == null : this$removeAreaIds.equals(other$removeAreaIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectPlanDetailSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerSaveParams = this.getMonomerSaveParams();
      result = result * 59 + ($monomerSaveParams == null ? 43 : $monomerSaveParams.hashCode());
      Object $removeMonomerIds = this.getRemoveMonomerIds();
      result = result * 59 + ($removeMonomerIds == null ? 43 : $removeMonomerIds.hashCode());
      Object $removeAreaIds = this.getRemoveAreaIds();
      return result * 59 + ($removeAreaIds == null ? 43 : $removeAreaIds.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPlanDetailSaveParam(monomerSaveParams="
         + this.getMonomerSaveParams()
         + ", removeMonomerIds="
         + this.getRemoveMonomerIds()
         + ", removeAreaIds="
         + this.getRemoveAreaIds()
         + ")";
   }

   @ApiModel("项目计划详情区域SaveParam类")
   public static class AreaSaveParam {
      @ApiModelProperty("id")
      private Long id;
      @NotNull(message = "项目不能为空")
      @ApiModelProperty("项目ID")
      private Long projectId;
      @NotNull(message = "名称不能为空")
      @ApiModelProperty("名称")
      private String name;
      @NotNull(message = "制品类别不能为空")
      @ApiModelProperty("项目计划制品类别")
      private Integer projectPlanProductCategory;
      @ApiModelProperty("单位")
      private String unit;
      @NotNull(message = "预算量不能为空")
      @ApiModelProperty("预算量")
      private BigDecimal budgetVolume;
      @NotNull(message = "生产方式不能为空")
      @ApiModelProperty("生产方式")
      private Integer productionWay;
      @ApiModelProperty("备注")
      private String remark;
      @ApiModelProperty("排序")
      private Integer sort;
      @NotNull(message = "交货开始日期不能为空")
      @ApiModelProperty("交货开始日期")
      private LocalDate deliveryStartDate;
      @NotNull(message = "交货结束日期不能为空")
      @ApiModelProperty("交货结束日期")
      private LocalDate deliveryEndDate;
      @ApiModelProperty("交货工期(天)")
      private Integer deliveryDuration;
      @ApiModelProperty("深化开始日期")
      private LocalDate deepenStartDate;
      @ApiModelProperty("深化结束日期")
      private LocalDate deepenEndDate;
      @ApiModelProperty("深化工期(天)")
      private Integer deepenDuration;
      @ApiModelProperty("采购开始日期")
      private LocalDate purchaseStartDate;
      @ApiModelProperty("采购结束日期")
      private LocalDate purchaseEndDate;
      @ApiModelProperty("采购工期(天)")
      private Integer purchaseDuration;
      @ApiModelProperty("加工开始日期")
      private LocalDate processStartDate;
      @ApiModelProperty("加工结束日期")
      private LocalDate processEndDate;
      @ApiModelProperty("加工工期(天)")
      private Integer processDuration;
      @ApiModelProperty("发运开始日期")
      private LocalDate shippedStartDate;
      @ApiModelProperty("发运结束日期")
      private LocalDate shippedEndDate;
      @ApiModelProperty("发运工期(天)")
      private Integer shippedDuration;
      @ApiModelProperty("安装开始日期")
      private LocalDate installStartDate;
      @ApiModelProperty("安装结束日期")
      private LocalDate installEndDate;
      @ApiModelProperty("安装工期(天)")
      private Integer installDuration;

      public Long getId() {
         return this.id;
      }

      public Long getProjectId() {
         return this.projectId;
      }

      public String getName() {
         return this.name;
      }

      public Integer getProjectPlanProductCategory() {
         return this.projectPlanProductCategory;
      }

      public String getUnit() {
         return this.unit;
      }

      public BigDecimal getBudgetVolume() {
         return this.budgetVolume;
      }

      public Integer getProductionWay() {
         return this.productionWay;
      }

      public String getRemark() {
         return this.remark;
      }

      public Integer getSort() {
         return this.sort;
      }

      public LocalDate getDeliveryStartDate() {
         return this.deliveryStartDate;
      }

      public LocalDate getDeliveryEndDate() {
         return this.deliveryEndDate;
      }

      public Integer getDeliveryDuration() {
         return this.deliveryDuration;
      }

      public LocalDate getDeepenStartDate() {
         return this.deepenStartDate;
      }

      public LocalDate getDeepenEndDate() {
         return this.deepenEndDate;
      }

      public Integer getDeepenDuration() {
         return this.deepenDuration;
      }

      public LocalDate getPurchaseStartDate() {
         return this.purchaseStartDate;
      }

      public LocalDate getPurchaseEndDate() {
         return this.purchaseEndDate;
      }

      public Integer getPurchaseDuration() {
         return this.purchaseDuration;
      }

      public LocalDate getProcessStartDate() {
         return this.processStartDate;
      }

      public LocalDate getProcessEndDate() {
         return this.processEndDate;
      }

      public Integer getProcessDuration() {
         return this.processDuration;
      }

      public LocalDate getShippedStartDate() {
         return this.shippedStartDate;
      }

      public LocalDate getShippedEndDate() {
         return this.shippedEndDate;
      }

      public Integer getShippedDuration() {
         return this.shippedDuration;
      }

      public LocalDate getInstallStartDate() {
         return this.installStartDate;
      }

      public LocalDate getInstallEndDate() {
         return this.installEndDate;
      }

      public Integer getInstallDuration() {
         return this.installDuration;
      }

      public void setId(final Long id) {
         this.id = id;
      }

      public void setProjectId(final Long projectId) {
         this.projectId = projectId;
      }

      public void setName(final String name) {
         this.name = name;
      }

      public void setProjectPlanProductCategory(final Integer projectPlanProductCategory) {
         this.projectPlanProductCategory = projectPlanProductCategory;
      }

      public void setUnit(final String unit) {
         this.unit = unit;
      }

      public void setBudgetVolume(final BigDecimal budgetVolume) {
         this.budgetVolume = budgetVolume;
      }

      public void setProductionWay(final Integer productionWay) {
         this.productionWay = productionWay;
      }

      public void setRemark(final String remark) {
         this.remark = remark;
      }

      public void setSort(final Integer sort) {
         this.sort = sort;
      }

      public void setDeliveryStartDate(final LocalDate deliveryStartDate) {
         this.deliveryStartDate = deliveryStartDate;
      }

      public void setDeliveryEndDate(final LocalDate deliveryEndDate) {
         this.deliveryEndDate = deliveryEndDate;
      }

      public void setDeliveryDuration(final Integer deliveryDuration) {
         this.deliveryDuration = deliveryDuration;
      }

      public void setDeepenStartDate(final LocalDate deepenStartDate) {
         this.deepenStartDate = deepenStartDate;
      }

      public void setDeepenEndDate(final LocalDate deepenEndDate) {
         this.deepenEndDate = deepenEndDate;
      }

      public void setDeepenDuration(final Integer deepenDuration) {
         this.deepenDuration = deepenDuration;
      }

      public void setPurchaseStartDate(final LocalDate purchaseStartDate) {
         this.purchaseStartDate = purchaseStartDate;
      }

      public void setPurchaseEndDate(final LocalDate purchaseEndDate) {
         this.purchaseEndDate = purchaseEndDate;
      }

      public void setPurchaseDuration(final Integer purchaseDuration) {
         this.purchaseDuration = purchaseDuration;
      }

      public void setProcessStartDate(final LocalDate processStartDate) {
         this.processStartDate = processStartDate;
      }

      public void setProcessEndDate(final LocalDate processEndDate) {
         this.processEndDate = processEndDate;
      }

      public void setProcessDuration(final Integer processDuration) {
         this.processDuration = processDuration;
      }

      public void setShippedStartDate(final LocalDate shippedStartDate) {
         this.shippedStartDate = shippedStartDate;
      }

      public void setShippedEndDate(final LocalDate shippedEndDate) {
         this.shippedEndDate = shippedEndDate;
      }

      public void setShippedDuration(final Integer shippedDuration) {
         this.shippedDuration = shippedDuration;
      }

      public void setInstallStartDate(final LocalDate installStartDate) {
         this.installStartDate = installStartDate;
      }

      public void setInstallEndDate(final LocalDate installEndDate) {
         this.installEndDate = installEndDate;
      }

      public void setInstallDuration(final Integer installDuration) {
         this.installDuration = installDuration;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof ProjectPlanDetailSaveParam.AreaSaveParam)) {
            return false;
         }

         ProjectPlanDetailSaveParam.AreaSaveParam other = (ProjectPlanDetailSaveParam.AreaSaveParam)o;
         if (!other.canEqual(this)) {
            return false;
         }

         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$projectPlanProductCategory = this.getProjectPlanProductCategory();
               Object other$projectPlanProductCategory = other.getProjectPlanProductCategory();
               if (this$projectPlanProductCategory == null
                  ? other$projectPlanProductCategory == null
                  : this$projectPlanProductCategory.equals(other$projectPlanProductCategory)) {
                  Object this$productionWay = this.getProductionWay();
                  Object other$productionWay = other.getProductionWay();
                  if (this$productionWay == null ? other$productionWay == null : this$productionWay.equals(other$productionWay)) {
                     Object this$sort = this.getSort();
                     Object other$sort = other.getSort();
                     if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                        Object this$deliveryDuration = this.getDeliveryDuration();
                        Object other$deliveryDuration = other.getDeliveryDuration();
                        if (this$deliveryDuration == null ? other$deliveryDuration == null : this$deliveryDuration.equals(other$deliveryDuration)) {
                           Object this$deepenDuration = this.getDeepenDuration();
                           Object other$deepenDuration = other.getDeepenDuration();
                           if (this$deepenDuration == null ? other$deepenDuration == null : this$deepenDuration.equals(other$deepenDuration)) {
                              Object this$purchaseDuration = this.getPurchaseDuration();
                              Object other$purchaseDuration = other.getPurchaseDuration();
                              if (this$purchaseDuration == null ? other$purchaseDuration == null : this$purchaseDuration.equals(other$purchaseDuration)) {
                                 Object this$processDuration = this.getProcessDuration();
                                 Object other$processDuration = other.getProcessDuration();
                                 if (this$processDuration == null ? other$processDuration == null : this$processDuration.equals(other$processDuration)) {
                                    Object this$shippedDuration = this.getShippedDuration();
                                    Object other$shippedDuration = other.getShippedDuration();
                                    if (this$shippedDuration == null ? other$shippedDuration == null : this$shippedDuration.equals(other$shippedDuration)) {
                                       Object this$installDuration = this.getInstallDuration();
                                       Object other$installDuration = other.getInstallDuration();
                                       if (this$installDuration == null ? other$installDuration == null : this$installDuration.equals(other$installDuration)) {
                                          Object this$name = this.getName();
                                          Object other$name = other.getName();
                                          if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                             Object this$unit = this.getUnit();
                                             Object other$unit = other.getUnit();
                                             if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                                Object this$budgetVolume = this.getBudgetVolume();
                                                Object other$budgetVolume = other.getBudgetVolume();
                                                if (this$budgetVolume == null ? other$budgetVolume == null : this$budgetVolume.equals(other$budgetVolume)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                      Object this$deliveryStartDate = this.getDeliveryStartDate();
                                                      Object other$deliveryStartDate = other.getDeliveryStartDate();
                                                      if (this$deliveryStartDate == null
                                                         ? other$deliveryStartDate == null
                                                         : this$deliveryStartDate.equals(other$deliveryStartDate)) {
                                                         Object this$deliveryEndDate = this.getDeliveryEndDate();
                                                         Object other$deliveryEndDate = other.getDeliveryEndDate();
                                                         if (this$deliveryEndDate == null
                                                            ? other$deliveryEndDate == null
                                                            : this$deliveryEndDate.equals(other$deliveryEndDate)) {
                                                            Object this$deepenStartDate = this.getDeepenStartDate();
                                                            Object other$deepenStartDate = other.getDeepenStartDate();
                                                            if (this$deepenStartDate == null
                                                               ? other$deepenStartDate == null
                                                               : this$deepenStartDate.equals(other$deepenStartDate)) {
                                                               Object this$deepenEndDate = this.getDeepenEndDate();
                                                               Object other$deepenEndDate = other.getDeepenEndDate();
                                                               if (this$deepenEndDate == null
                                                                  ? other$deepenEndDate == null
                                                                  : this$deepenEndDate.equals(other$deepenEndDate)) {
                                                                  Object this$purchaseStartDate = this.getPurchaseStartDate();
                                                                  Object other$purchaseStartDate = other.getPurchaseStartDate();
                                                                  if (this$purchaseStartDate == null
                                                                     ? other$purchaseStartDate == null
                                                                     : this$purchaseStartDate.equals(other$purchaseStartDate)) {
                                                                     Object this$purchaseEndDate = this.getPurchaseEndDate();
                                                                     Object other$purchaseEndDate = other.getPurchaseEndDate();
                                                                     if (this$purchaseEndDate == null
                                                                        ? other$purchaseEndDate == null
                                                                        : this$purchaseEndDate.equals(other$purchaseEndDate)) {
                                                                        Object this$processStartDate = this.getProcessStartDate();
                                                                        Object other$processStartDate = other.getProcessStartDate();
                                                                        if (this$processStartDate == null
                                                                           ? other$processStartDate == null
                                                                           : this$processStartDate.equals(other$processStartDate)) {
                                                                           Object this$processEndDate = this.getProcessEndDate();
                                                                           Object other$processEndDate = other.getProcessEndDate();
                                                                           if (this$processEndDate == null
                                                                              ? other$processEndDate == null
                                                                              : this$processEndDate.equals(other$processEndDate)) {
                                                                              Object this$shippedStartDate = this.getShippedStartDate();
                                                                              Object other$shippedStartDate = other.getShippedStartDate();
                                                                              if (this$shippedStartDate == null
                                                                                 ? other$shippedStartDate == null
                                                                                 : this$shippedStartDate.equals(other$shippedStartDate)) {
                                                                                 Object this$shippedEndDate = this.getShippedEndDate();
                                                                                 Object other$shippedEndDate = other.getShippedEndDate();
                                                                                 if (this$shippedEndDate == null
                                                                                    ? other$shippedEndDate == null
                                                                                    : this$shippedEndDate.equals(other$shippedEndDate)) {
                                                                                    Object this$installStartDate = this.getInstallStartDate();
                                                                                    Object other$installStartDate = other.getInstallStartDate();
                                                                                    if (this$installStartDate == null
                                                                                       ? other$installStartDate == null
                                                                                       : this$installStartDate.equals(other$installStartDate)) {
                                                                                       Object this$installEndDate = this.getInstallEndDate();
                                                                                       Object other$installEndDate = other.getInstallEndDate();
                                                                                       return this$installEndDate == null
                                                                                          ? other$installEndDate == null
                                                                                          : this$installEndDate.equals(other$installEndDate);
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
            } else {
               return false;
            }
         } else {
            return false;
         }
      }

      protected boolean canEqual(final Object other) {
         return other instanceof ProjectPlanDetailSaveParam.AreaSaveParam;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $id = this.getId();
         result = result * 59 + ($id == null ? 43 : $id.hashCode());
         Object $projectId = this.getProjectId();
         result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
         Object $projectPlanProductCategory = this.getProjectPlanProductCategory();
         result = result * 59 + ($projectPlanProductCategory == null ? 43 : $projectPlanProductCategory.hashCode());
         Object $productionWay = this.getProductionWay();
         result = result * 59 + ($productionWay == null ? 43 : $productionWay.hashCode());
         Object $sort = this.getSort();
         result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
         Object $deliveryDuration = this.getDeliveryDuration();
         result = result * 59 + ($deliveryDuration == null ? 43 : $deliveryDuration.hashCode());
         Object $deepenDuration = this.getDeepenDuration();
         result = result * 59 + ($deepenDuration == null ? 43 : $deepenDuration.hashCode());
         Object $purchaseDuration = this.getPurchaseDuration();
         result = result * 59 + ($purchaseDuration == null ? 43 : $purchaseDuration.hashCode());
         Object $processDuration = this.getProcessDuration();
         result = result * 59 + ($processDuration == null ? 43 : $processDuration.hashCode());
         Object $shippedDuration = this.getShippedDuration();
         result = result * 59 + ($shippedDuration == null ? 43 : $shippedDuration.hashCode());
         Object $installDuration = this.getInstallDuration();
         result = result * 59 + ($installDuration == null ? 43 : $installDuration.hashCode());
         Object $name = this.getName();
         result = result * 59 + ($name == null ? 43 : $name.hashCode());
         Object $unit = this.getUnit();
         result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
         Object $budgetVolume = this.getBudgetVolume();
         result = result * 59 + ($budgetVolume == null ? 43 : $budgetVolume.hashCode());
         Object $remark = this.getRemark();
         result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
         Object $deliveryStartDate = this.getDeliveryStartDate();
         result = result * 59 + ($deliveryStartDate == null ? 43 : $deliveryStartDate.hashCode());
         Object $deliveryEndDate = this.getDeliveryEndDate();
         result = result * 59 + ($deliveryEndDate == null ? 43 : $deliveryEndDate.hashCode());
         Object $deepenStartDate = this.getDeepenStartDate();
         result = result * 59 + ($deepenStartDate == null ? 43 : $deepenStartDate.hashCode());
         Object $deepenEndDate = this.getDeepenEndDate();
         result = result * 59 + ($deepenEndDate == null ? 43 : $deepenEndDate.hashCode());
         Object $purchaseStartDate = this.getPurchaseStartDate();
         result = result * 59 + ($purchaseStartDate == null ? 43 : $purchaseStartDate.hashCode());
         Object $purchaseEndDate = this.getPurchaseEndDate();
         result = result * 59 + ($purchaseEndDate == null ? 43 : $purchaseEndDate.hashCode());
         Object $processStartDate = this.getProcessStartDate();
         result = result * 59 + ($processStartDate == null ? 43 : $processStartDate.hashCode());
         Object $processEndDate = this.getProcessEndDate();
         result = result * 59 + ($processEndDate == null ? 43 : $processEndDate.hashCode());
         Object $shippedStartDate = this.getShippedStartDate();
         result = result * 59 + ($shippedStartDate == null ? 43 : $shippedStartDate.hashCode());
         Object $shippedEndDate = this.getShippedEndDate();
         result = result * 59 + ($shippedEndDate == null ? 43 : $shippedEndDate.hashCode());
         Object $installStartDate = this.getInstallStartDate();
         result = result * 59 + ($installStartDate == null ? 43 : $installStartDate.hashCode());
         Object $installEndDate = this.getInstallEndDate();
         return result * 59 + ($installEndDate == null ? 43 : $installEndDate.hashCode());
      }

      @Override
      public String toString() {
         return "ProjectPlanDetailSaveParam.AreaSaveParam(id="
            + this.getId()
            + ", projectId="
            + this.getProjectId()
            + ", name="
            + this.getName()
            + ", projectPlanProductCategory="
            + this.getProjectPlanProductCategory()
            + ", unit="
            + this.getUnit()
            + ", budgetVolume="
            + this.getBudgetVolume()
            + ", productionWay="
            + this.getProductionWay()
            + ", remark="
            + this.getRemark()
            + ", sort="
            + this.getSort()
            + ", deliveryStartDate="
            + this.getDeliveryStartDate()
            + ", deliveryEndDate="
            + this.getDeliveryEndDate()
            + ", deliveryDuration="
            + this.getDeliveryDuration()
            + ", deepenStartDate="
            + this.getDeepenStartDate()
            + ", deepenEndDate="
            + this.getDeepenEndDate()
            + ", deepenDuration="
            + this.getDeepenDuration()
            + ", purchaseStartDate="
            + this.getPurchaseStartDate()
            + ", purchaseEndDate="
            + this.getPurchaseEndDate()
            + ", purchaseDuration="
            + this.getPurchaseDuration()
            + ", processStartDate="
            + this.getProcessStartDate()
            + ", processEndDate="
            + this.getProcessEndDate()
            + ", processDuration="
            + this.getProcessDuration()
            + ", shippedStartDate="
            + this.getShippedStartDate()
            + ", shippedEndDate="
            + this.getShippedEndDate()
            + ", shippedDuration="
            + this.getShippedDuration()
            + ", installStartDate="
            + this.getInstallStartDate()
            + ", installEndDate="
            + this.getInstallEndDate()
            + ", installDuration="
            + this.getInstallDuration()
            + ")";
      }
   }

   @ApiModel("项目计划详情单体SaveParam类")
   public static class MonomerSaveParam {
      @ApiModelProperty("id")
      private Long id;
      @NotNull(message = "项目不能为空")
      @ApiModelProperty("项目ID")
      private Long projectId;
      @NotNull(message = "名称不能为空")
      @ApiModelProperty("名称")
      private String name;
      @ApiModelProperty("备注")
      private String remark;
      @ApiModelProperty("排序")
      private Integer sort;
      @ApiModelProperty("交货开始日期")
      private LocalDate deliveryStartDate;
      @ApiModelProperty("交货结束日期")
      private LocalDate deliveryEndDate;
      @ApiModelProperty("交货工期(天)")
      private Integer deliveryDuration;
      @ApiModelProperty("深化开始日期")
      private LocalDate deepenStartDate;
      @ApiModelProperty("深化结束日期")
      private LocalDate deepenEndDate;
      @ApiModelProperty("深化工期(天)")
      private Integer deepenDuration;
      @ApiModelProperty("采购开始日期")
      private LocalDate purchaseStartDate;
      @ApiModelProperty("采购结束日期")
      private LocalDate purchaseEndDate;
      @ApiModelProperty("采购工期(天)")
      private Integer purchaseDuration;
      @ApiModelProperty("加工开始日期")
      private LocalDate processStartDate;
      @ApiModelProperty("加工结束日期")
      private LocalDate processEndDate;
      @ApiModelProperty("加工工期(天)")
      private Integer processDuration;
      @ApiModelProperty("发运开始日期")
      private LocalDate shippedStartDate;
      @ApiModelProperty("发运结束日期")
      private LocalDate shippedEndDate;
      @ApiModelProperty("发运工期(天)")
      private Integer shippedDuration;
      @ApiModelProperty("安装开始日期")
      private LocalDate installStartDate;
      @ApiModelProperty("安装结束日期")
      private LocalDate installEndDate;
      @ApiModelProperty("安装工期(天)")
      private Integer installDuration;
      @Valid
      @ApiModelProperty("区域列表")
      private List<ProjectPlanDetailSaveParam.AreaSaveParam> areaList;

      public Long getId() {
         return this.id;
      }

      public Long getProjectId() {
         return this.projectId;
      }

      public String getName() {
         return this.name;
      }

      public String getRemark() {
         return this.remark;
      }

      public Integer getSort() {
         return this.sort;
      }

      public LocalDate getDeliveryStartDate() {
         return this.deliveryStartDate;
      }

      public LocalDate getDeliveryEndDate() {
         return this.deliveryEndDate;
      }

      public Integer getDeliveryDuration() {
         return this.deliveryDuration;
      }

      public LocalDate getDeepenStartDate() {
         return this.deepenStartDate;
      }

      public LocalDate getDeepenEndDate() {
         return this.deepenEndDate;
      }

      public Integer getDeepenDuration() {
         return this.deepenDuration;
      }

      public LocalDate getPurchaseStartDate() {
         return this.purchaseStartDate;
      }

      public LocalDate getPurchaseEndDate() {
         return this.purchaseEndDate;
      }

      public Integer getPurchaseDuration() {
         return this.purchaseDuration;
      }

      public LocalDate getProcessStartDate() {
         return this.processStartDate;
      }

      public LocalDate getProcessEndDate() {
         return this.processEndDate;
      }

      public Integer getProcessDuration() {
         return this.processDuration;
      }

      public LocalDate getShippedStartDate() {
         return this.shippedStartDate;
      }

      public LocalDate getShippedEndDate() {
         return this.shippedEndDate;
      }

      public Integer getShippedDuration() {
         return this.shippedDuration;
      }

      public LocalDate getInstallStartDate() {
         return this.installStartDate;
      }

      public LocalDate getInstallEndDate() {
         return this.installEndDate;
      }

      public Integer getInstallDuration() {
         return this.installDuration;
      }

      public List<ProjectPlanDetailSaveParam.AreaSaveParam> getAreaList() {
         return this.areaList;
      }

      public void setId(final Long id) {
         this.id = id;
      }

      public void setProjectId(final Long projectId) {
         this.projectId = projectId;
      }

      public void setName(final String name) {
         this.name = name;
      }

      public void setRemark(final String remark) {
         this.remark = remark;
      }

      public void setSort(final Integer sort) {
         this.sort = sort;
      }

      public void setDeliveryStartDate(final LocalDate deliveryStartDate) {
         this.deliveryStartDate = deliveryStartDate;
      }

      public void setDeliveryEndDate(final LocalDate deliveryEndDate) {
         this.deliveryEndDate = deliveryEndDate;
      }

      public void setDeliveryDuration(final Integer deliveryDuration) {
         this.deliveryDuration = deliveryDuration;
      }

      public void setDeepenStartDate(final LocalDate deepenStartDate) {
         this.deepenStartDate = deepenStartDate;
      }

      public void setDeepenEndDate(final LocalDate deepenEndDate) {
         this.deepenEndDate = deepenEndDate;
      }

      public void setDeepenDuration(final Integer deepenDuration) {
         this.deepenDuration = deepenDuration;
      }

      public void setPurchaseStartDate(final LocalDate purchaseStartDate) {
         this.purchaseStartDate = purchaseStartDate;
      }

      public void setPurchaseEndDate(final LocalDate purchaseEndDate) {
         this.purchaseEndDate = purchaseEndDate;
      }

      public void setPurchaseDuration(final Integer purchaseDuration) {
         this.purchaseDuration = purchaseDuration;
      }

      public void setProcessStartDate(final LocalDate processStartDate) {
         this.processStartDate = processStartDate;
      }

      public void setProcessEndDate(final LocalDate processEndDate) {
         this.processEndDate = processEndDate;
      }

      public void setProcessDuration(final Integer processDuration) {
         this.processDuration = processDuration;
      }

      public void setShippedStartDate(final LocalDate shippedStartDate) {
         this.shippedStartDate = shippedStartDate;
      }

      public void setShippedEndDate(final LocalDate shippedEndDate) {
         this.shippedEndDate = shippedEndDate;
      }

      public void setShippedDuration(final Integer shippedDuration) {
         this.shippedDuration = shippedDuration;
      }

      public void setInstallStartDate(final LocalDate installStartDate) {
         this.installStartDate = installStartDate;
      }

      public void setInstallEndDate(final LocalDate installEndDate) {
         this.installEndDate = installEndDate;
      }

      public void setInstallDuration(final Integer installDuration) {
         this.installDuration = installDuration;
      }

      public void setAreaList(final List<ProjectPlanDetailSaveParam.AreaSaveParam> areaList) {
         this.areaList = areaList;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof ProjectPlanDetailSaveParam.MonomerSaveParam)) {
            return false;
         }

         ProjectPlanDetailSaveParam.MonomerSaveParam other = (ProjectPlanDetailSaveParam.MonomerSaveParam)o;
         if (!other.canEqual(this)) {
            return false;
         }

         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$deliveryDuration = this.getDeliveryDuration();
                  Object other$deliveryDuration = other.getDeliveryDuration();
                  if (this$deliveryDuration == null ? other$deliveryDuration == null : this$deliveryDuration.equals(other$deliveryDuration)) {
                     Object this$deepenDuration = this.getDeepenDuration();
                     Object other$deepenDuration = other.getDeepenDuration();
                     if (this$deepenDuration == null ? other$deepenDuration == null : this$deepenDuration.equals(other$deepenDuration)) {
                        Object this$purchaseDuration = this.getPurchaseDuration();
                        Object other$purchaseDuration = other.getPurchaseDuration();
                        if (this$purchaseDuration == null ? other$purchaseDuration == null : this$purchaseDuration.equals(other$purchaseDuration)) {
                           Object this$processDuration = this.getProcessDuration();
                           Object other$processDuration = other.getProcessDuration();
                           if (this$processDuration == null ? other$processDuration == null : this$processDuration.equals(other$processDuration)) {
                              Object this$shippedDuration = this.getShippedDuration();
                              Object other$shippedDuration = other.getShippedDuration();
                              if (this$shippedDuration == null ? other$shippedDuration == null : this$shippedDuration.equals(other$shippedDuration)) {
                                 Object this$installDuration = this.getInstallDuration();
                                 Object other$installDuration = other.getInstallDuration();
                                 if (this$installDuration == null ? other$installDuration == null : this$installDuration.equals(other$installDuration)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                          Object this$deliveryStartDate = this.getDeliveryStartDate();
                                          Object other$deliveryStartDate = other.getDeliveryStartDate();
                                          if (this$deliveryStartDate == null
                                             ? other$deliveryStartDate == null
                                             : this$deliveryStartDate.equals(other$deliveryStartDate)) {
                                             Object this$deliveryEndDate = this.getDeliveryEndDate();
                                             Object other$deliveryEndDate = other.getDeliveryEndDate();
                                             if (this$deliveryEndDate == null
                                                ? other$deliveryEndDate == null
                                                : this$deliveryEndDate.equals(other$deliveryEndDate)) {
                                                Object this$deepenStartDate = this.getDeepenStartDate();
                                                Object other$deepenStartDate = other.getDeepenStartDate();
                                                if (this$deepenStartDate == null
                                                   ? other$deepenStartDate == null
                                                   : this$deepenStartDate.equals(other$deepenStartDate)) {
                                                   Object this$deepenEndDate = this.getDeepenEndDate();
                                                   Object other$deepenEndDate = other.getDeepenEndDate();
                                                   if (this$deepenEndDate == null
                                                      ? other$deepenEndDate == null
                                                      : this$deepenEndDate.equals(other$deepenEndDate)) {
                                                      Object this$purchaseStartDate = this.getPurchaseStartDate();
                                                      Object other$purchaseStartDate = other.getPurchaseStartDate();
                                                      if (this$purchaseStartDate == null
                                                         ? other$purchaseStartDate == null
                                                         : this$purchaseStartDate.equals(other$purchaseStartDate)) {
                                                         Object this$purchaseEndDate = this.getPurchaseEndDate();
                                                         Object other$purchaseEndDate = other.getPurchaseEndDate();
                                                         if (this$purchaseEndDate == null
                                                            ? other$purchaseEndDate == null
                                                            : this$purchaseEndDate.equals(other$purchaseEndDate)) {
                                                            Object this$processStartDate = this.getProcessStartDate();
                                                            Object other$processStartDate = other.getProcessStartDate();
                                                            if (this$processStartDate == null
                                                               ? other$processStartDate == null
                                                               : this$processStartDate.equals(other$processStartDate)) {
                                                               Object this$processEndDate = this.getProcessEndDate();
                                                               Object other$processEndDate = other.getProcessEndDate();
                                                               if (this$processEndDate == null
                                                                  ? other$processEndDate == null
                                                                  : this$processEndDate.equals(other$processEndDate)) {
                                                                  Object this$shippedStartDate = this.getShippedStartDate();
                                                                  Object other$shippedStartDate = other.getShippedStartDate();
                                                                  if (this$shippedStartDate == null
                                                                     ? other$shippedStartDate == null
                                                                     : this$shippedStartDate.equals(other$shippedStartDate)) {
                                                                     Object this$shippedEndDate = this.getShippedEndDate();
                                                                     Object other$shippedEndDate = other.getShippedEndDate();
                                                                     if (this$shippedEndDate == null
                                                                        ? other$shippedEndDate == null
                                                                        : this$shippedEndDate.equals(other$shippedEndDate)) {
                                                                        Object this$installStartDate = this.getInstallStartDate();
                                                                        Object other$installStartDate = other.getInstallStartDate();
                                                                        if (this$installStartDate == null
                                                                           ? other$installStartDate == null
                                                                           : this$installStartDate.equals(other$installStartDate)) {
                                                                           Object this$installEndDate = this.getInstallEndDate();
                                                                           Object other$installEndDate = other.getInstallEndDate();
                                                                           if (this$installEndDate == null
                                                                              ? other$installEndDate == null
                                                                              : this$installEndDate.equals(other$installEndDate)) {
                                                                              Object this$areaList = this.getAreaList();
                                                                              Object other$areaList = other.getAreaList();
                                                                              return this$areaList == null
                                                                                 ? other$areaList == null
                                                                                 : this$areaList.equals(other$areaList);
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
         return other instanceof ProjectPlanDetailSaveParam.MonomerSaveParam;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $id = this.getId();
         result = result * 59 + ($id == null ? 43 : $id.hashCode());
         Object $projectId = this.getProjectId();
         result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
         Object $sort = this.getSort();
         result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
         Object $deliveryDuration = this.getDeliveryDuration();
         result = result * 59 + ($deliveryDuration == null ? 43 : $deliveryDuration.hashCode());
         Object $deepenDuration = this.getDeepenDuration();
         result = result * 59 + ($deepenDuration == null ? 43 : $deepenDuration.hashCode());
         Object $purchaseDuration = this.getPurchaseDuration();
         result = result * 59 + ($purchaseDuration == null ? 43 : $purchaseDuration.hashCode());
         Object $processDuration = this.getProcessDuration();
         result = result * 59 + ($processDuration == null ? 43 : $processDuration.hashCode());
         Object $shippedDuration = this.getShippedDuration();
         result = result * 59 + ($shippedDuration == null ? 43 : $shippedDuration.hashCode());
         Object $installDuration = this.getInstallDuration();
         result = result * 59 + ($installDuration == null ? 43 : $installDuration.hashCode());
         Object $name = this.getName();
         result = result * 59 + ($name == null ? 43 : $name.hashCode());
         Object $remark = this.getRemark();
         result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
         Object $deliveryStartDate = this.getDeliveryStartDate();
         result = result * 59 + ($deliveryStartDate == null ? 43 : $deliveryStartDate.hashCode());
         Object $deliveryEndDate = this.getDeliveryEndDate();
         result = result * 59 + ($deliveryEndDate == null ? 43 : $deliveryEndDate.hashCode());
         Object $deepenStartDate = this.getDeepenStartDate();
         result = result * 59 + ($deepenStartDate == null ? 43 : $deepenStartDate.hashCode());
         Object $deepenEndDate = this.getDeepenEndDate();
         result = result * 59 + ($deepenEndDate == null ? 43 : $deepenEndDate.hashCode());
         Object $purchaseStartDate = this.getPurchaseStartDate();
         result = result * 59 + ($purchaseStartDate == null ? 43 : $purchaseStartDate.hashCode());
         Object $purchaseEndDate = this.getPurchaseEndDate();
         result = result * 59 + ($purchaseEndDate == null ? 43 : $purchaseEndDate.hashCode());
         Object $processStartDate = this.getProcessStartDate();
         result = result * 59 + ($processStartDate == null ? 43 : $processStartDate.hashCode());
         Object $processEndDate = this.getProcessEndDate();
         result = result * 59 + ($processEndDate == null ? 43 : $processEndDate.hashCode());
         Object $shippedStartDate = this.getShippedStartDate();
         result = result * 59 + ($shippedStartDate == null ? 43 : $shippedStartDate.hashCode());
         Object $shippedEndDate = this.getShippedEndDate();
         result = result * 59 + ($shippedEndDate == null ? 43 : $shippedEndDate.hashCode());
         Object $installStartDate = this.getInstallStartDate();
         result = result * 59 + ($installStartDate == null ? 43 : $installStartDate.hashCode());
         Object $installEndDate = this.getInstallEndDate();
         result = result * 59 + ($installEndDate == null ? 43 : $installEndDate.hashCode());
         Object $areaList = this.getAreaList();
         return result * 59 + ($areaList == null ? 43 : $areaList.hashCode());
      }

      @Override
      public String toString() {
         return "ProjectPlanDetailSaveParam.MonomerSaveParam(id="
            + this.getId()
            + ", projectId="
            + this.getProjectId()
            + ", name="
            + this.getName()
            + ", remark="
            + this.getRemark()
            + ", sort="
            + this.getSort()
            + ", deliveryStartDate="
            + this.getDeliveryStartDate()
            + ", deliveryEndDate="
            + this.getDeliveryEndDate()
            + ", deliveryDuration="
            + this.getDeliveryDuration()
            + ", deepenStartDate="
            + this.getDeepenStartDate()
            + ", deepenEndDate="
            + this.getDeepenEndDate()
            + ", deepenDuration="
            + this.getDeepenDuration()
            + ", purchaseStartDate="
            + this.getPurchaseStartDate()
            + ", purchaseEndDate="
            + this.getPurchaseEndDate()
            + ", purchaseDuration="
            + this.getPurchaseDuration()
            + ", processStartDate="
            + this.getProcessStartDate()
            + ", processEndDate="
            + this.getProcessEndDate()
            + ", processDuration="
            + this.getProcessDuration()
            + ", shippedStartDate="
            + this.getShippedStartDate()
            + ", shippedEndDate="
            + this.getShippedEndDate()
            + ", shippedDuration="
            + this.getShippedDuration()
            + ", installStartDate="
            + this.getInstallStartDate()
            + ", installEndDate="
            + this.getInstallEndDate()
            + ", installDuration="
            + this.getInstallDuration()
            + ", areaList="
            + this.getAreaList()
            + ")";
      }
   }
}
