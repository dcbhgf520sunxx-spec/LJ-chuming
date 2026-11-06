package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel("批次响应类")
public class PlanAreaBatchDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   private String name;
   @ApiModelProperty(name = "areaId", notes = "区域Id")
   private Long areaId;
   @ApiModelProperty(name = "date", notes = "区域完成日期")
   private LocalDate date;
   @ApiModelProperty(name = "axis", notes = "轴线或标高")
   private String axis;
   @ApiModelProperty(name = "type", notes = "制造方式 0：自制，1：外协 参考枚举：AreaTypeEnum")
   private Integer type;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "supplier", notes = "供应商(外包时才有)")
   private String supplier;
   @ApiModelProperty(name = "productType", notes = "区域产品类型 1结构件")
   private Integer productType;
   @ApiModelProperty(name = "productCategory", notes = "产品大类 2构件 16箱体件 ")
   private Integer productCategory;
   @ApiModelProperty(name = "sort", notes = "排序")
   private Integer sort;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "remark", notes = "备注")
   private String remark;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "计划详情列表")
   private List<PlanDetailDTO> planDetailList;
   @ApiModelProperty(name = "itemizedType", notes = "分项类型 参考枚举itemizedType：1.其他分类 2.结构分项 4.围护分项 8.涂装分项 16.门窗分项")
   private Integer itemizedType;
   @ApiModelProperty(name = "deepenStartDate", notes = "深化开始时间")
   private LocalDate deepenStartDate;
   @ApiModelProperty(name = "deepenEndDate", notes = "深化结束时间")
   private LocalDate deepenEndDate;
   @ApiModelProperty(name = "purchaseStartDate", value = "采购开始日期", notes = "采购开始日期")
   private LocalDate purchaseStartDate;
   @ApiModelProperty(name = "purchaseEndDate", value = "采购结束日期", notes = "采购结束日期")
   private LocalDate purchaseEndDate;
   @ApiModelProperty(name = "processStartDate", value = "加工开始日期", notes = "加工开始日期")
   private LocalDate processStartDate;
   @ApiModelProperty(name = "processEndDate", value = "加工结束日期", notes = "加工结束日期")
   private LocalDate processEndDate;
   @ApiModelProperty(name = "shippingStartDate", value = "发运开始时间", notes = "发运开始时间")
   private LocalDate shippingStartDate;
   @ApiModelProperty(name = "shippingEndDate", value = "发运结束时间", notes = "发运结束时间")
   private LocalDate shippingEndDate;
   @ApiModelProperty(name = "installStartDate", value = "安装开始日期", notes = "安装开始日期")
   private LocalDate installStartDate;
   @ApiModelProperty(name = "installEndDate", value = "安装结束日期", notes = "安装结束日期")
   private LocalDate installEndDate;
   @ApiModelProperty(name = "unitName", notes = "单位名称")
   private String unitName;
   @ApiModelProperty(name = "mete", value = "工程量", notes = "工程量")
   private BigDecimal mete;
   @ApiModelProperty(name = "allDays", notes = "工期")
   private Integer allDays;
   @ApiModelProperty(name = "usedDays", notes = "已用时")
   private Long usedDays;
   @ApiModelProperty(name = "haveDetailedList", notes = "是否已有清单 1.有 2.没有")
   private Integer haveDetailedList;
   @ApiModelProperty(name = "actualCompletion", notes = "实际完成量")
   private BigDecimal actualCompletion;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public String getAxis() {
      return this.axis;
   }

   public Integer getType() {
      return this.type;
   }

   public String getSupplier() {
      return this.supplier;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductCategory() {
      return this.productCategory;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<PlanDetailDTO> getPlanDetailList() {
      return this.planDetailList;
   }

   public Integer getItemizedType() {
      return this.itemizedType;
   }

   public LocalDate getDeepenStartDate() {
      return this.deepenStartDate;
   }

   public LocalDate getDeepenEndDate() {
      return this.deepenEndDate;
   }

   public LocalDate getPurchaseStartDate() {
      return this.purchaseStartDate;
   }

   public LocalDate getPurchaseEndDate() {
      return this.purchaseEndDate;
   }

   public LocalDate getProcessStartDate() {
      return this.processStartDate;
   }

   public LocalDate getProcessEndDate() {
      return this.processEndDate;
   }

   public LocalDate getShippingStartDate() {
      return this.shippingStartDate;
   }

   public LocalDate getShippingEndDate() {
      return this.shippingEndDate;
   }

   public LocalDate getInstallStartDate() {
      return this.installStartDate;
   }

   public LocalDate getInstallEndDate() {
      return this.installEndDate;
   }

   public String getUnitName() {
      return this.unitName;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getAllDays() {
      return this.allDays;
   }

   public Long getUsedDays() {
      return this.usedDays;
   }

   public Integer getHaveDetailedList() {
      return this.haveDetailedList;
   }

   public BigDecimal getActualCompletion() {
      return this.actualCompletion;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setAxis(final String axis) {
      this.axis = axis;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setSupplier(final String supplier) {
      this.supplier = supplier;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductCategory(final Integer productCategory) {
      this.productCategory = productCategory;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setPlanDetailList(final List<PlanDetailDTO> planDetailList) {
      this.planDetailList = planDetailList;
   }

   public void setItemizedType(final Integer itemizedType) {
      this.itemizedType = itemizedType;
   }

   public void setDeepenStartDate(final LocalDate deepenStartDate) {
      this.deepenStartDate = deepenStartDate;
   }

   public void setDeepenEndDate(final LocalDate deepenEndDate) {
      this.deepenEndDate = deepenEndDate;
   }

   public void setPurchaseStartDate(final LocalDate purchaseStartDate) {
      this.purchaseStartDate = purchaseStartDate;
   }

   public void setPurchaseEndDate(final LocalDate purchaseEndDate) {
      this.purchaseEndDate = purchaseEndDate;
   }

   public void setProcessStartDate(final LocalDate processStartDate) {
      this.processStartDate = processStartDate;
   }

   public void setProcessEndDate(final LocalDate processEndDate) {
      this.processEndDate = processEndDate;
   }

   public void setShippingStartDate(final LocalDate shippingStartDate) {
      this.shippingStartDate = shippingStartDate;
   }

   public void setShippingEndDate(final LocalDate shippingEndDate) {
      this.shippingEndDate = shippingEndDate;
   }

   public void setInstallStartDate(final LocalDate installStartDate) {
      this.installStartDate = installStartDate;
   }

   public void setInstallEndDate(final LocalDate installEndDate) {
      this.installEndDate = installEndDate;
   }

   public void setUnitName(final String unitName) {
      this.unitName = unitName;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAllDays(final Integer allDays) {
      this.allDays = allDays;
   }

   public void setUsedDays(final Long usedDays) {
      this.usedDays = usedDays;
   }

   public void setHaveDetailedList(final Integer haveDetailedList) {
      this.haveDetailedList = haveDetailedList;
   }

   public void setActualCompletion(final BigDecimal actualCompletion) {
      this.actualCompletion = actualCompletion;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanAreaBatchDTO)) {
         return false;
      }

      PlanAreaBatchDTO other = (PlanAreaBatchDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$productCategory = this.getProductCategory();
                  Object other$productCategory = other.getProductCategory();
                  if (this$productCategory == null ? other$productCategory == null : this$productCategory.equals(other$productCategory)) {
                     Object this$sort = this.getSort();
                     Object other$sort = other.getSort();
                     if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                        Object this$itemizedType = this.getItemizedType();
                        Object other$itemizedType = other.getItemizedType();
                        if (this$itemizedType == null ? other$itemizedType == null : this$itemizedType.equals(other$itemizedType)) {
                           Object this$allDays = this.getAllDays();
                           Object other$allDays = other.getAllDays();
                           if (this$allDays == null ? other$allDays == null : this$allDays.equals(other$allDays)) {
                              Object this$usedDays = this.getUsedDays();
                              Object other$usedDays = other.getUsedDays();
                              if (this$usedDays == null ? other$usedDays == null : this$usedDays.equals(other$usedDays)) {
                                 Object this$haveDetailedList = this.getHaveDetailedList();
                                 Object other$haveDetailedList = other.getHaveDetailedList();
                                 if (this$haveDetailedList == null ? other$haveDetailedList == null : this$haveDetailedList.equals(other$haveDetailedList)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$date = this.getDate();
                                       Object other$date = other.getDate();
                                       if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                                          Object this$axis = this.getAxis();
                                          Object other$axis = other.getAxis();
                                          if (this$axis == null ? other$axis == null : this$axis.equals(other$axis)) {
                                             Object this$supplier = this.getSupplier();
                                             Object other$supplier = other.getSupplier();
                                             if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                                                Object this$remark = this.getRemark();
                                                Object other$remark = other.getRemark();
                                                if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                   Object this$planDetailList = this.getPlanDetailList();
                                                   Object other$planDetailList = other.getPlanDetailList();
                                                   if (this$planDetailList == null
                                                      ? other$planDetailList == null
                                                      : this$planDetailList.equals(other$planDetailList)) {
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
                                                                        Object this$shippingStartDate = this.getShippingStartDate();
                                                                        Object other$shippingStartDate = other.getShippingStartDate();
                                                                        if (this$shippingStartDate == null
                                                                           ? other$shippingStartDate == null
                                                                           : this$shippingStartDate.equals(other$shippingStartDate)) {
                                                                           Object this$shippingEndDate = this.getShippingEndDate();
                                                                           Object other$shippingEndDate = other.getShippingEndDate();
                                                                           if (this$shippingEndDate == null
                                                                              ? other$shippingEndDate == null
                                                                              : this$shippingEndDate.equals(other$shippingEndDate)) {
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
                                                                                    Object this$unitName = this.getUnitName();
                                                                                    Object other$unitName = other.getUnitName();
                                                                                    if (this$unitName == null
                                                                                       ? other$unitName == null
                                                                                       : this$unitName.equals(other$unitName)) {
                                                                                       Object this$mete = this.getMete();
                                                                                       Object other$mete = other.getMete();
                                                                                       if (this$mete == null
                                                                                          ? other$mete == null
                                                                                          : this$mete.equals(other$mete)) {
                                                                                          Object this$actualCompletion = this.getActualCompletion();
                                                                                          Object other$actualCompletion = other.getActualCompletion();
                                                                                          return this$actualCompletion == null
                                                                                             ? other$actualCompletion == null
                                                                                             : this$actualCompletion.equals(other$actualCompletion);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlanAreaBatchDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productCategory = this.getProductCategory();
      result = result * 59 + ($productCategory == null ? 43 : $productCategory.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $itemizedType = this.getItemizedType();
      result = result * 59 + ($itemizedType == null ? 43 : $itemizedType.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $usedDays = this.getUsedDays();
      result = result * 59 + ($usedDays == null ? 43 : $usedDays.hashCode());
      Object $haveDetailedList = this.getHaveDetailedList();
      result = result * 59 + ($haveDetailedList == null ? 43 : $haveDetailedList.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $axis = this.getAxis();
      result = result * 59 + ($axis == null ? 43 : $axis.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $planDetailList = this.getPlanDetailList();
      result = result * 59 + ($planDetailList == null ? 43 : $planDetailList.hashCode());
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
      Object $shippingStartDate = this.getShippingStartDate();
      result = result * 59 + ($shippingStartDate == null ? 43 : $shippingStartDate.hashCode());
      Object $shippingEndDate = this.getShippingEndDate();
      result = result * 59 + ($shippingEndDate == null ? 43 : $shippingEndDate.hashCode());
      Object $installStartDate = this.getInstallStartDate();
      result = result * 59 + ($installStartDate == null ? 43 : $installStartDate.hashCode());
      Object $installEndDate = this.getInstallEndDate();
      result = result * 59 + ($installEndDate == null ? 43 : $installEndDate.hashCode());
      Object $unitName = this.getUnitName();
      result = result * 59 + ($unitName == null ? 43 : $unitName.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $actualCompletion = this.getActualCompletion();
      return result * 59 + ($actualCompletion == null ? 43 : $actualCompletion.hashCode());
   }

   @Override
   public String toString() {
      return "PlanAreaBatchDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", areaId="
         + this.getAreaId()
         + ", date="
         + this.getDate()
         + ", axis="
         + this.getAxis()
         + ", type="
         + this.getType()
         + ", supplier="
         + this.getSupplier()
         + ", productType="
         + this.getProductType()
         + ", productCategory="
         + this.getProductCategory()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", planDetailList="
         + this.getPlanDetailList()
         + ", itemizedType="
         + this.getItemizedType()
         + ", deepenStartDate="
         + this.getDeepenStartDate()
         + ", deepenEndDate="
         + this.getDeepenEndDate()
         + ", purchaseStartDate="
         + this.getPurchaseStartDate()
         + ", purchaseEndDate="
         + this.getPurchaseEndDate()
         + ", processStartDate="
         + this.getProcessStartDate()
         + ", processEndDate="
         + this.getProcessEndDate()
         + ", shippingStartDate="
         + this.getShippingStartDate()
         + ", shippingEndDate="
         + this.getShippingEndDate()
         + ", installStartDate="
         + this.getInstallStartDate()
         + ", installEndDate="
         + this.getInstallEndDate()
         + ", unitName="
         + this.getUnitName()
         + ", mete="
         + this.getMete()
         + ", allDays="
         + this.getAllDays()
         + ", usedDays="
         + this.getUsedDays()
         + ", haveDetailedList="
         + this.getHaveDetailedList()
         + ", actualCompletion="
         + this.getActualCompletion()
         + ")";
   }
}
