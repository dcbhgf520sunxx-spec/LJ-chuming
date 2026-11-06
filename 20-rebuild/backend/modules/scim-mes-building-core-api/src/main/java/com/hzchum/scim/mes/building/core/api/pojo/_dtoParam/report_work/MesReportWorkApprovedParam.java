package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("报工审核通过新增修改Param")
public class MesReportWorkApprovedParam {
   @ApiModelProperty("产品类型")
   @NotNull(message = "产品类型不能为空")
   private Integer productTypeEnum;
   @ApiModelProperty("班组生产上报记录ID")
   @NotNull(message = "班组生产上报记录id不能为空")
   private Long produceTeamReportId;
   @ApiModelProperty("报工日期")
   @NotNull(message = "报工日期不能为空")
   private LocalDateTime reportTime;
   @ApiModelProperty("车间ID")
   @NotNull(message = "车间不能为空")
   private Long workshopId;
   @ApiModelProperty("项目ID")
   @NotNull(message = "项目不能为空")
   private Long projectId;
   @ApiModelProperty("单体id")
   @NotNull(message = "单体不能为空")
   private Long monomerId;
   @ApiModelProperty("工序id")
   @NotNull(message = "工序不能为空")
   private Long processId;
   @ApiModelProperty("班组ID")
   @NotNull(message = "班组不能为空")
   private Long teamId;
   @ApiModelProperty("产品ID")
   @NotNull(message = "产品不能为空")
   private Long productId;
   @ApiModelProperty("产品编号")
   @NotBlank(message = "产品编号不能为空")
   private String productSerialNumber;
   @ApiModelProperty("单位")
   @NotBlank(message = "单位不能为空")
   private String unit;
   @ApiModelProperty("核算量")
   @NotNull(message = "核算量不能为空")
   private BigDecimal accountingQuantity;
   @ApiModelProperty("定额配置ID")
   @NotNull(message = "定额配置不能为空")
   private Long quotaConfigId;
   @ApiModelProperty("定额配置编号")
   @NotBlank(message = "定额配置不能为空")
   private String quotaConfigNumber;
   @ApiModelProperty("单价(元)")
   @NotNull(message = "单价不能为空")
   private BigDecimal price;
   @ApiModelProperty("总价(元)")
   @NotNull(message = "总价不能为空")
   private BigDecimal totalPrice;
   @ApiModelProperty("总重(kg)")
   private BigDecimal totalWeight;
   @ApiModelProperty("定义类型")
   private String defineType;

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Long getProduceTeamReportId() {
      return this.produceTeamReportId;
   }

   public LocalDateTime getReportTime() {
      return this.reportTime;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getAccountingQuantity() {
      return this.accountingQuantity;
   }

   public Long getQuotaConfigId() {
      return this.quotaConfigId;
   }

   public String getQuotaConfigNumber() {
      return this.quotaConfigNumber;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public String getDefineType() {
      return this.defineType;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setProduceTeamReportId(final Long produceTeamReportId) {
      this.produceTeamReportId = produceTeamReportId;
   }

   public void setReportTime(final LocalDateTime reportTime) {
      this.reportTime = reportTime;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setAccountingQuantity(final BigDecimal accountingQuantity) {
      this.accountingQuantity = accountingQuantity;
   }

   public void setQuotaConfigId(final Long quotaConfigId) {
      this.quotaConfigId = quotaConfigId;
   }

   public void setQuotaConfigNumber(final String quotaConfigNumber) {
      this.quotaConfigNumber = quotaConfigNumber;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setDefineType(final String defineType) {
      this.defineType = defineType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesReportWorkApprovedParam)) {
         return false;
      }

      MesReportWorkApprovedParam other = (MesReportWorkApprovedParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productTypeEnum = this.getProductTypeEnum();
      Object other$productTypeEnum = other.getProductTypeEnum();
      if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
         Object this$produceTeamReportId = this.getProduceTeamReportId();
         Object other$produceTeamReportId = other.getProduceTeamReportId();
         if (this$produceTeamReportId == null ? other$produceTeamReportId == null : this$produceTeamReportId.equals(other$produceTeamReportId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$processId = this.getProcessId();
                     Object other$processId = other.getProcessId();
                     if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                        Object this$teamId = this.getTeamId();
                        Object other$teamId = other.getTeamId();
                        if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                           Object this$productId = this.getProductId();
                           Object other$productId = other.getProductId();
                           if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                              Object this$quotaConfigId = this.getQuotaConfigId();
                              Object other$quotaConfigId = other.getQuotaConfigId();
                              if (this$quotaConfigId == null ? other$quotaConfigId == null : this$quotaConfigId.equals(other$quotaConfigId)) {
                                 Object this$reportTime = this.getReportTime();
                                 Object other$reportTime = other.getReportTime();
                                 if (this$reportTime == null ? other$reportTime == null : this$reportTime.equals(other$reportTime)) {
                                    Object this$productSerialNumber = this.getProductSerialNumber();
                                    Object other$productSerialNumber = other.getProductSerialNumber();
                                    if (this$productSerialNumber == null
                                       ? other$productSerialNumber == null
                                       : this$productSerialNumber.equals(other$productSerialNumber)) {
                                       Object this$unit = this.getUnit();
                                       Object other$unit = other.getUnit();
                                       if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                          Object this$accountingQuantity = this.getAccountingQuantity();
                                          Object other$accountingQuantity = other.getAccountingQuantity();
                                          if (this$accountingQuantity == null
                                             ? other$accountingQuantity == null
                                             : this$accountingQuantity.equals(other$accountingQuantity)) {
                                             Object this$quotaConfigNumber = this.getQuotaConfigNumber();
                                             Object other$quotaConfigNumber = other.getQuotaConfigNumber();
                                             if (this$quotaConfigNumber == null
                                                ? other$quotaConfigNumber == null
                                                : this$quotaConfigNumber.equals(other$quotaConfigNumber)) {
                                                Object this$price = this.getPrice();
                                                Object other$price = other.getPrice();
                                                if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                   Object this$totalPrice = this.getTotalPrice();
                                                   Object other$totalPrice = other.getTotalPrice();
                                                   if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                                                      Object this$totalWeight = this.getTotalWeight();
                                                      Object other$totalWeight = other.getTotalWeight();
                                                      if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                                                         Object this$defineType = this.getDefineType();
                                                         Object other$defineType = other.getDefineType();
                                                         return this$defineType == null ? other$defineType == null : this$defineType.equals(other$defineType);
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
      return other instanceof MesReportWorkApprovedParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $produceTeamReportId = this.getProduceTeamReportId();
      result = result * 59 + ($produceTeamReportId == null ? 43 : $produceTeamReportId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quotaConfigId = this.getQuotaConfigId();
      result = result * 59 + ($quotaConfigId == null ? 43 : $quotaConfigId.hashCode());
      Object $reportTime = this.getReportTime();
      result = result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $accountingQuantity = this.getAccountingQuantity();
      result = result * 59 + ($accountingQuantity == null ? 43 : $accountingQuantity.hashCode());
      Object $quotaConfigNumber = this.getQuotaConfigNumber();
      result = result * 59 + ($quotaConfigNumber == null ? 43 : $quotaConfigNumber.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $defineType = this.getDefineType();
      return result * 59 + ($defineType == null ? 43 : $defineType.hashCode());
   }

   @Override
   public String toString() {
      return "MesReportWorkApprovedParam(productTypeEnum="
         + this.getProductTypeEnum()
         + ", produceTeamReportId="
         + this.getProduceTeamReportId()
         + ", reportTime="
         + this.getReportTime()
         + ", workshopId="
         + this.getWorkshopId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", productId="
         + this.getProductId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", unit="
         + this.getUnit()
         + ", accountingQuantity="
         + this.getAccountingQuantity()
         + ", quotaConfigId="
         + this.getQuotaConfigId()
         + ", quotaConfigNumber="
         + this.getQuotaConfigNumber()
         + ", price="
         + this.getPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", defineType="
         + this.getDefineType()
         + ")";
   }
}
