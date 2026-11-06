package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("报工审核通过新增修改Param")
public class MesProductionReportingApprovalPassedParam {
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("车间id")
   @NotNull(groups = {TechEnclosureService.class, Add.class}, message = "车间不能为空")
   private Long workshopId;
   @ApiModelProperty("项目id")
   @NotNull(groups = {TechEnclosureService.class, Add.class}, message = "项目不能为空")
   private Long projectId;
   @ApiModelProperty("单体id")
   @NotNull(groups = Add.class, message = "单体不能为空")
   private Long monomerId;
   @ApiModelProperty("区域id")
   @NotNull(groups = Add.class, message = "区域不能为空")
   private Long areaId;
   @ApiModelProperty("产品类型")
   @NotNull(groups = {TechEnclosureService.class, Add.class}, message = "产品类型不能为空")
   private Integer productTypeEnum;
   @ApiModelProperty("产品分类")
   private Integer productClassificationEnum;
   @ApiModelProperty("产品类型id")
   @NotNull(groups = Add.class, message = "产品种类不能为空")
   private Long productClassId;
   @ApiModelProperty("围护类型字典id")
   @NotNull(groups = TechEnclosureService.class, message = "围护类型不能为空")
   private Long dictionaryId;
   @ApiModelProperty("产品id")
   @NotNull(groups = Add.class, message = "产品不能为空")
   private Long productId;
   @ApiModelProperty("工序id")
   @NotNull(groups = {TechEnclosureService.class, Add.class}, message = "工序不能为空")
   private Long processId;
   @ApiModelProperty("班组id")
   @NotNull(groups = {TechEnclosureService.class, Add.class}, message = "班组不能为空")
   private Long teamId;
   @ApiModelProperty("上报数量")
   @NotNull(groups = {TechEnclosureService.class, Add.class}, message = "上报数量不能为空")
   private BigDecimal reportQuantity;
   @ApiModelProperty("上报日期")
   @NotNull(groups = {TechEnclosureService.class, Add.class}, message = "上报日期不能为空")
   private LocalDate reportDate;
   @ApiModelProperty("定额配置id")
   @NotNull(groups = {TechEnclosureService.class, Add.class}, message = "定额不能为空")
   private Long quotaConfigId;
   @ApiModelProperty("定额配置编号")
   @NotBlank(groups = {TechEnclosureService.class, Add.class}, message = "定额编号不能为空")
   private String quotaConfigSerialNumber;
   @ApiModelProperty("定额匹配条件")
   private String quotaMatchingCondition;
   @ApiModelProperty("计量单位")
   @NotBlank(groups = {TechEnclosureService.class, Add.class}, message = "计量单位不能为空")
   private String measureUnit;
   @ApiModelProperty("计量量")
   @NotNull(groups = {TechEnclosureService.class, Add.class}, message = "核算量不能为空")
   private BigDecimal measurementQuantity;
   @ApiModelProperty("单价(元)")
   @NotNull(groups = {TechEnclosureService.class, Add.class}, message = "单价不能为空")
   private BigDecimal price;
   @ApiModelProperty("金额(元)")
   @NotNull(groups = {TechEnclosureService.class, Add.class}, message = "单价不能为空")
   private BigDecimal amount;
   @ApiModelProperty("班组生产上报记录ids")
   @NotBlank(groups = {TechEnclosureService.class, Add.class}, message = "班组生产上报记录不能为空")
   private String produceTeamReportIds;
   @ApiModelProperty("班组生产上报记录idList")
   private List<Long> produceTeamReportIdList;
   @ApiModelProperty("是否自动审批(1:是, 0:否)")
   private Boolean boolAutomaticApproval;
   @ApiModelProperty("上报人id")
   private Long reportPersonId;

   public List<Long> getProduceTeamReportIdList() {
      return CollUtil.isEmpty(this.produceTeamReportIdList) && StrUtil.isNotBlank(this.getProduceTeamReportIds())
         ? Convert.toList(Long.class, this.getProduceTeamReportIds().split(","))
         : this.produceTeamReportIdList;
   }

   public Long getId() {
      return this.id;
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

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Long getProductClassId() {
      return this.productClassId;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public BigDecimal getReportQuantity() {
      return this.reportQuantity;
   }

   public LocalDate getReportDate() {
      return this.reportDate;
   }

   public Long getQuotaConfigId() {
      return this.quotaConfigId;
   }

   public String getQuotaConfigSerialNumber() {
      return this.quotaConfigSerialNumber;
   }

   public String getQuotaMatchingCondition() {
      return this.quotaMatchingCondition;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMeasurementQuantity() {
      return this.measurementQuantity;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getProduceTeamReportIds() {
      return this.produceTeamReportIds;
   }

   public Boolean getBoolAutomaticApproval() {
      return this.boolAutomaticApproval;
   }

   public Long getReportPersonId() {
      return this.reportPersonId;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   public void setProductClassId(final Long productClassId) {
      this.productClassId = productClassId;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setReportQuantity(final BigDecimal reportQuantity) {
      this.reportQuantity = reportQuantity;
   }

   public void setReportDate(final LocalDate reportDate) {
      this.reportDate = reportDate;
   }

   public void setQuotaConfigId(final Long quotaConfigId) {
      this.quotaConfigId = quotaConfigId;
   }

   public void setQuotaConfigSerialNumber(final String quotaConfigSerialNumber) {
      this.quotaConfigSerialNumber = quotaConfigSerialNumber;
   }

   public void setQuotaMatchingCondition(final String quotaMatchingCondition) {
      this.quotaMatchingCondition = quotaMatchingCondition;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasurementQuantity(final BigDecimal measurementQuantity) {
      this.measurementQuantity = measurementQuantity;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setProduceTeamReportIds(final String produceTeamReportIds) {
      this.produceTeamReportIds = produceTeamReportIds;
   }

   public void setProduceTeamReportIdList(final List<Long> produceTeamReportIdList) {
      this.produceTeamReportIdList = produceTeamReportIdList;
   }

   public void setBoolAutomaticApproval(final Boolean boolAutomaticApproval) {
      this.boolAutomaticApproval = boolAutomaticApproval;
   }

   public void setReportPersonId(final Long reportPersonId) {
      this.reportPersonId = reportPersonId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionReportingApprovalPassedParam)) {
         return false;
      }

      MesProductionReportingApprovalPassedParam other = (MesProductionReportingApprovalPassedParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$productTypeEnum = this.getProductTypeEnum();
                     Object other$productTypeEnum = other.getProductTypeEnum();
                     if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
                        Object this$productClassificationEnum = this.getProductClassificationEnum();
                        Object other$productClassificationEnum = other.getProductClassificationEnum();
                        if (this$productClassificationEnum == null
                           ? other$productClassificationEnum == null
                           : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                           Object this$productClassId = this.getProductClassId();
                           Object other$productClassId = other.getProductClassId();
                           if (this$productClassId == null ? other$productClassId == null : this$productClassId.equals(other$productClassId)) {
                              Object this$dictionaryId = this.getDictionaryId();
                              Object other$dictionaryId = other.getDictionaryId();
                              if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                                 Object this$productId = this.getProductId();
                                 Object other$productId = other.getProductId();
                                 if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                    Object this$processId = this.getProcessId();
                                    Object other$processId = other.getProcessId();
                                    if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                       Object this$teamId = this.getTeamId();
                                       Object other$teamId = other.getTeamId();
                                       if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                          Object this$quotaConfigId = this.getQuotaConfigId();
                                          Object other$quotaConfigId = other.getQuotaConfigId();
                                          if (this$quotaConfigId == null ? other$quotaConfigId == null : this$quotaConfigId.equals(other$quotaConfigId)) {
                                             Object this$boolAutomaticApproval = this.getBoolAutomaticApproval();
                                             Object other$boolAutomaticApproval = other.getBoolAutomaticApproval();
                                             if (this$boolAutomaticApproval == null
                                                ? other$boolAutomaticApproval == null
                                                : this$boolAutomaticApproval.equals(other$boolAutomaticApproval)) {
                                                Object this$reportPersonId = this.getReportPersonId();
                                                Object other$reportPersonId = other.getReportPersonId();
                                                if (this$reportPersonId == null
                                                   ? other$reportPersonId == null
                                                   : this$reportPersonId.equals(other$reportPersonId)) {
                                                   Object this$reportQuantity = this.getReportQuantity();
                                                   Object other$reportQuantity = other.getReportQuantity();
                                                   if (this$reportQuantity == null
                                                      ? other$reportQuantity == null
                                                      : this$reportQuantity.equals(other$reportQuantity)) {
                                                      Object this$reportDate = this.getReportDate();
                                                      Object other$reportDate = other.getReportDate();
                                                      if (this$reportDate == null ? other$reportDate == null : this$reportDate.equals(other$reportDate)) {
                                                         Object this$quotaConfigSerialNumber = this.getQuotaConfigSerialNumber();
                                                         Object other$quotaConfigSerialNumber = other.getQuotaConfigSerialNumber();
                                                         if (this$quotaConfigSerialNumber == null
                                                            ? other$quotaConfigSerialNumber == null
                                                            : this$quotaConfigSerialNumber.equals(other$quotaConfigSerialNumber)) {
                                                            Object this$quotaMatchingCondition = this.getQuotaMatchingCondition();
                                                            Object other$quotaMatchingCondition = other.getQuotaMatchingCondition();
                                                            if (this$quotaMatchingCondition == null
                                                               ? other$quotaMatchingCondition == null
                                                               : this$quotaMatchingCondition.equals(other$quotaMatchingCondition)) {
                                                               Object this$measureUnit = this.getMeasureUnit();
                                                               Object other$measureUnit = other.getMeasureUnit();
                                                               if (this$measureUnit == null
                                                                  ? other$measureUnit == null
                                                                  : this$measureUnit.equals(other$measureUnit)) {
                                                                  Object this$measurementQuantity = this.getMeasurementQuantity();
                                                                  Object other$measurementQuantity = other.getMeasurementQuantity();
                                                                  if (this$measurementQuantity == null
                                                                     ? other$measurementQuantity == null
                                                                     : this$measurementQuantity.equals(other$measurementQuantity)) {
                                                                     Object this$price = this.getPrice();
                                                                     Object other$price = other.getPrice();
                                                                     if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                                        Object this$amount = this.getAmount();
                                                                        Object other$amount = other.getAmount();
                                                                        if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                           Object this$produceTeamReportIds = this.getProduceTeamReportIds();
                                                                           Object other$produceTeamReportIds = other.getProduceTeamReportIds();
                                                                           if (this$produceTeamReportIds == null
                                                                              ? other$produceTeamReportIds == null
                                                                              : this$produceTeamReportIds.equals(other$produceTeamReportIds)) {
                                                                              Object this$produceTeamReportIdList = this.getProduceTeamReportIdList();
                                                                              Object other$produceTeamReportIdList = other.getProduceTeamReportIdList();
                                                                              return this$produceTeamReportIdList == null
                                                                                 ? other$produceTeamReportIdList == null
                                                                                 : this$produceTeamReportIdList.equals(other$produceTeamReportIdList);
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
      return other instanceof MesProductionReportingApprovalPassedParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $productClassId = this.getProductClassId();
      result = result * 59 + ($productClassId == null ? 43 : $productClassId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $quotaConfigId = this.getQuotaConfigId();
      result = result * 59 + ($quotaConfigId == null ? 43 : $quotaConfigId.hashCode());
      Object $boolAutomaticApproval = this.getBoolAutomaticApproval();
      result = result * 59 + ($boolAutomaticApproval == null ? 43 : $boolAutomaticApproval.hashCode());
      Object $reportPersonId = this.getReportPersonId();
      result = result * 59 + ($reportPersonId == null ? 43 : $reportPersonId.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $quotaConfigSerialNumber = this.getQuotaConfigSerialNumber();
      result = result * 59 + ($quotaConfigSerialNumber == null ? 43 : $quotaConfigSerialNumber.hashCode());
      Object $quotaMatchingCondition = this.getQuotaMatchingCondition();
      result = result * 59 + ($quotaMatchingCondition == null ? 43 : $quotaMatchingCondition.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $measurementQuantity = this.getMeasurementQuantity();
      result = result * 59 + ($measurementQuantity == null ? 43 : $measurementQuantity.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $produceTeamReportIds = this.getProduceTeamReportIds();
      result = result * 59 + ($produceTeamReportIds == null ? 43 : $produceTeamReportIds.hashCode());
      Object $produceTeamReportIdList = this.getProduceTeamReportIdList();
      return result * 59 + ($produceTeamReportIdList == null ? 43 : $produceTeamReportIdList.hashCode());
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovalPassedParam(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", productClassId="
         + this.getProductClassId()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", productId="
         + this.getProductId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportDate="
         + this.getReportDate()
         + ", quotaConfigId="
         + this.getQuotaConfigId()
         + ", quotaConfigSerialNumber="
         + this.getQuotaConfigSerialNumber()
         + ", quotaMatchingCondition="
         + this.getQuotaMatchingCondition()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurementQuantity="
         + this.getMeasurementQuantity()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", produceTeamReportIds="
         + this.getProduceTeamReportIds()
         + ", produceTeamReportIdList="
         + this.getProduceTeamReportIdList()
         + ", boolAutomaticApproval="
         + this.getBoolAutomaticApproval()
         + ", reportPersonId="
         + this.getReportPersonId()
         + ")";
   }
}
