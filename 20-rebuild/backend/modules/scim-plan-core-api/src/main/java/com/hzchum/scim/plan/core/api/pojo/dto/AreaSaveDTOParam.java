package com.hzchum.scim.plan.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@ApiModel("新增区域 请求类")
public class AreaSaveDTOParam {
   @ApiModelProperty(name = "id", notes = "区域id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @NotNull(message = "产品类型不能为空")
   @ApiModelProperty(name = "productType", value = "产品类型: 主构件 夹芯板 压型板 折边件 压型楼承板 桁架楼承板")
   private Integer productType;
   @ApiModelProperty(name = "startDate")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "计划结束日期", notes = "计划结束日期")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   private LocalDate endDate;
   @ApiModelProperty(name = "projectId")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "sort")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "remark")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "deepenStartDate", value = "深化开始日期", notes = "深化开始日期")
   @JsonProperty("deepenStartDate")
   @JSONField(name = "deepenStartDate")
   private LocalDate deepenStartDate;
   @ApiModelProperty(name = "deepenEndDate", value = "深化结束日期", notes = "深化结束日期")
   @JsonProperty("deepenEndDate")
   @JSONField(name = "deepenEndDate")
   private LocalDate deepenEndDate;
   @ApiModelProperty(name = "purchaseStartDate", value = "采购开始日期", notes = "采购开始日期")
   @JsonProperty("purchaseStartDate")
   @JSONField(name = "purchaseStartDate")
   private LocalDate purchaseStartDate;
   @ApiModelProperty(name = "purchaseEndDate", value = "采购结束日期", notes = "采购结束日期")
   @JsonProperty("purchaseEndDate")
   @JSONField(name = "purchaseEndDate")
   private LocalDate purchaseEndDate;
   @ApiModelProperty(name = "processStartDate", value = "加工开始日期", notes = "加工开始日期")
   @JsonProperty("processStartDate")
   @JSONField(name = "processStartDate")
   private LocalDate processStartDate;
   @ApiModelProperty(name = "processEndDate", value = "加工结束日期", notes = "加工结束日期")
   @JsonProperty("processEndDate")
   @JSONField(name = "processEndDate")
   private LocalDate processEndDate;
   @ApiModelProperty(name = "shippingStartDate", value = "发运开始时间", notes = "发运开始时间")
   @JsonProperty("shippingStartDate")
   @JSONField(name = "shippingStartDate")
   private LocalDate shippingStartDate;
   @ApiModelProperty(name = "shippingEndDate", value = "发运结束时间", notes = "发运结束时间")
   @JsonProperty("shippingEndDate")
   @JSONField(name = "shippingEndDate")
   private LocalDate shippingEndDate;
   @ApiModelProperty(name = "installStartDate", value = "安装开始日期", notes = "安装开始日期")
   @JsonProperty("installStartDate")
   @JSONField(name = "installStartDate")
   private LocalDate installStartDate;
   @ApiModelProperty(name = "installEndDate", value = "安装结束日期", notes = "安装结束日期")
   @JsonProperty("installEndDate")
   @JSONField(name = "installEndDate")
   private LocalDate installEndDate;
   @ApiModelProperty(name = "itemizedType", notes = "分项类型")
   @JsonProperty("itemizedType")
   @JSONField(name = "itemizedType")
   private Integer itemizedType;
   @ApiModelProperty(name = "unitName", notes = "单位名称")
   @JsonProperty("unitName")
   @JSONField(name = "unitName")
   private String unitName;
   @ApiModelProperty(name = "type", notes = "制造方式 0：自制，1：外协 参考枚举 ：AreaTypeEnum")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "mete", value = "工程量", notes = "工程量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "allDays", notes = "工期")
   @JsonProperty("allDays")
   @JSONField(name = "allDays")
   private Integer allDays;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
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

   public Integer getItemizedType() {
      return this.itemizedType;
   }

   public String getUnitName() {
      return this.unitName;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getAllDays() {
      return this.allDays;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @JsonProperty("startDate")
   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   @JsonProperty("endDate")
   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   @JsonProperty("projectId")
   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @JsonProperty("monomerId")
   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   @JsonProperty("sort")
   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("deepenStartDate")
   public void setDeepenStartDate(final LocalDate deepenStartDate) {
      this.deepenStartDate = deepenStartDate;
   }

   @JsonProperty("deepenEndDate")
   public void setDeepenEndDate(final LocalDate deepenEndDate) {
      this.deepenEndDate = deepenEndDate;
   }

   @JsonProperty("purchaseStartDate")
   public void setPurchaseStartDate(final LocalDate purchaseStartDate) {
      this.purchaseStartDate = purchaseStartDate;
   }

   @JsonProperty("purchaseEndDate")
   public void setPurchaseEndDate(final LocalDate purchaseEndDate) {
      this.purchaseEndDate = purchaseEndDate;
   }

   @JsonProperty("processStartDate")
   public void setProcessStartDate(final LocalDate processStartDate) {
      this.processStartDate = processStartDate;
   }

   @JsonProperty("processEndDate")
   public void setProcessEndDate(final LocalDate processEndDate) {
      this.processEndDate = processEndDate;
   }

   @JsonProperty("shippingStartDate")
   public void setShippingStartDate(final LocalDate shippingStartDate) {
      this.shippingStartDate = shippingStartDate;
   }

   @JsonProperty("shippingEndDate")
   public void setShippingEndDate(final LocalDate shippingEndDate) {
      this.shippingEndDate = shippingEndDate;
   }

   @JsonProperty("installStartDate")
   public void setInstallStartDate(final LocalDate installStartDate) {
      this.installStartDate = installStartDate;
   }

   @JsonProperty("installEndDate")
   public void setInstallEndDate(final LocalDate installEndDate) {
      this.installEndDate = installEndDate;
   }

   @JsonProperty("itemizedType")
   public void setItemizedType(final Integer itemizedType) {
      this.itemizedType = itemizedType;
   }

   @JsonProperty("unitName")
   public void setUnitName(final String unitName) {
      this.unitName = unitName;
   }

   @JsonProperty("type")
   public void setType(final Integer type) {
      this.type = type;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("allDays")
   public void setAllDays(final Integer allDays) {
      this.allDays = allDays;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AreaSaveDTOParam)) {
         return false;
      }

      AreaSaveDTOParam other = (AreaSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$sort = this.getSort();
                  Object other$sort = other.getSort();
                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                     Object this$itemizedType = this.getItemizedType();
                     Object other$itemizedType = other.getItemizedType();
                     if (this$itemizedType == null ? other$itemizedType == null : this$itemizedType.equals(other$itemizedType)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$allDays = this.getAllDays();
                           Object other$allDays = other.getAllDays();
                           if (this$allDays == null ? other$allDays == null : this$allDays.equals(other$allDays)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$startDate = this.getStartDate();
                                 Object other$startDate = other.getStartDate();
                                 if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                    Object this$endDate = this.getEndDate();
                                    Object other$endDate = other.getEndDate();
                                    if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                          Object this$deepenStartDate = this.getDeepenStartDate();
                                          Object other$deepenStartDate = other.getDeepenStartDate();
                                          if (this$deepenStartDate == null ? other$deepenStartDate == null : this$deepenStartDate.equals(other$deepenStartDate)
                                             )
                                           {
                                             Object this$deepenEndDate = this.getDeepenEndDate();
                                             Object other$deepenEndDate = other.getDeepenEndDate();
                                             if (this$deepenEndDate == null ? other$deepenEndDate == null : this$deepenEndDate.equals(other$deepenEndDate)) {
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
                                                                           return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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
      return other instanceof AreaSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $itemizedType = this.getItemizedType();
      result = result * 59 + ($itemizedType == null ? 43 : $itemizedType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
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
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "AreaSaveDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productType="
         + this.getProductType()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
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
         + ", itemizedType="
         + this.getItemizedType()
         + ", unitName="
         + this.getUnitName()
         + ", type="
         + this.getType()
         + ", mete="
         + this.getMete()
         + ", allDays="
         + this.getAllDays()
         + ")";
   }
}
