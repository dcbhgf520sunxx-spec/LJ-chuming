package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("产量确认表新增类")
public class MesYieldConfirmSaveDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   private Long id;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @NotNull(groups = {Add.class, Update.class}, message = "车间ID不能为空")
   private Long workshopId;
   @ApiModelProperty(name = "processId", value = "工序ID", notes = "工序ID")
   @NotNull(groups = {Add.class, Update.class}, message = "工序ID不能为空")
   private Long processId;
   @ApiModelProperty(name = "teamId", value = "班组ID", notes = "班组ID")
   @NotNull(groups = {Add.class, Update.class}, message = "班组ID不能为空")
   private Long teamId;
   @ApiModelProperty(name = "produceTeamReportId", value = "班组生产上报记录ID", notes = "班组生产上报记录ID")
   @NotNull(groups = {Add.class, Update.class}, message = "班组生产上报记录ID不能为空")
   private Long produceTeamReportId;
   @ApiModelProperty(name = "reportingTime", value = "报工时间", notes = "报工时间")
   @NotNull(groups = {Add.class, Update.class}, message = "报工时间不能为空")
   private LocalDateTime reportingTime;
   @ApiModelProperty(name = "contractProjectId", value = "合同项目ID", notes = "合同项目ID")
   @NotNull(groups = {Add.class, Update.class}, message = "合同项目ID不能为空")
   private Long contractProjectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @NotNull(groups = {Add.class, Update.class}, message = "单体ID不能为空")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @NotNull(groups = {Add.class, Update.class}, message = "区域ID不能为空")
   private Long areaId;
   @ApiModelProperty(name = "productType", value = "产品类型(ProductTypeEnum)", notes = "产品类型(ProductTypeEnum)")
   @NotNull(groups = {Add.class, Update.class}, message = "产品类型(ProductTypeEnum)不能为空")
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品ID", notes = "产品ID")
   @NotNull(groups = {Add.class, Update.class}, message = "产品ID不能为空")
   private Long productId;
   @ApiModelProperty(name = "number", value = "一物一码序号", notes = "一物一码序号")
   @NotNull(groups = {Add.class, Update.class}, message = "一物一码序号不能为空")
   private Integer number;
   @ApiModelProperty(name = "contractProjectWageConfigId", value = "项目工价配置ID", notes = "项目工价配置ID")
   @NotNull(groups = {Add.class, Update.class}, message = "项目工价配置ID不能为空")
   private Long contractProjectWageConfigId;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @NotBlank(groups = {Add.class, Update.class}, message = "计量单位不能为空")
   private String measureUnit;
   @ApiModelProperty(name = "oldMeasureQuantity", value = "旧计量量", notes = "旧计量量")
   private BigDecimal oldMeasureQuantity;
   @ApiModelProperty(name = "newMeasureQuantity", value = "新计量量", notes = "新计量量")
   private BigDecimal newMeasureQuantity;
   @ApiModelProperty(name = "oldQuotaPrice", value = "旧定额单价(元)", notes = "旧定额单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "旧定额单价(元)不能为空")
   private BigDecimal oldQuotaPrice;
   @ApiModelProperty(name = "newQuotaPrice", value = "新定额单价(元)", notes = "新定额单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "新定额单价(元)不能为空")
   private BigDecimal newQuotaPrice;
   @ApiModelProperty(name = "wage", value = "工价(元)", notes = "工价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "工价(元)不能为空")
   private BigDecimal wage;
   @ApiModelProperty(name = "operatorId", value = "操作人ID", notes = "操作人ID")
   private Long operatorId;
   @ApiModelProperty(name = "operatorName", value = "操作人名称", notes = "操作人名称")
   private String operatorName;
   @ApiModelProperty(name = "operateDate", value = "操作日期", notes = "操作日期")
   private LocalDateTime operateDate;
   @ApiModelProperty(name = "inspectionQuantity", value = "质检通过数量", notes = "质检通过数量")
   @NotNull(groups = {Add.class, Update.class}, message = "质检通过数量不能为空")
   private Integer inspectionQuantity;

   public static MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder builder() {
      return new MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder();
   }

   public MesYieldConfirmSaveDTOParam() {
   }

   public MesYieldConfirmSaveDTOParam(
      final Long id,
      final Long workshopId,
      final Long processId,
      final Long teamId,
      final Long produceTeamReportId,
      final LocalDateTime reportingTime,
      final Long contractProjectId,
      final Long monomerId,
      final Long areaId,
      final Integer productType,
      final Long productId,
      final Integer number,
      final Long contractProjectWageConfigId,
      final String measureUnit,
      final BigDecimal oldMeasureQuantity,
      final BigDecimal newMeasureQuantity,
      final BigDecimal oldQuotaPrice,
      final BigDecimal newQuotaPrice,
      final BigDecimal wage,
      final Long operatorId,
      final String operatorName,
      final LocalDateTime operateDate,
      final Integer inspectionQuantity
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.processId = processId;
      this.teamId = teamId;
      this.produceTeamReportId = produceTeamReportId;
      this.reportingTime = reportingTime;
      this.contractProjectId = contractProjectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productType = productType;
      this.productId = productId;
      this.number = number;
      this.contractProjectWageConfigId = contractProjectWageConfigId;
      this.measureUnit = measureUnit;
      this.oldMeasureQuantity = oldMeasureQuantity;
      this.newMeasureQuantity = newMeasureQuantity;
      this.oldQuotaPrice = oldQuotaPrice;
      this.newQuotaPrice = newQuotaPrice;
      this.wage = wage;
      this.operatorId = operatorId;
      this.operatorName = operatorName;
      this.operateDate = operateDate;
      this.inspectionQuantity = inspectionQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getProduceTeamReportId() {
      return this.produceTeamReportId;
   }

   public LocalDateTime getReportingTime() {
      return this.reportingTime;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getContractProjectWageConfigId() {
      return this.contractProjectWageConfigId;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getOldMeasureQuantity() {
      return this.oldMeasureQuantity;
   }

   public BigDecimal getNewMeasureQuantity() {
      return this.newMeasureQuantity;
   }

   public BigDecimal getOldQuotaPrice() {
      return this.oldQuotaPrice;
   }

   public BigDecimal getNewQuotaPrice() {
      return this.newQuotaPrice;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public Long getOperatorId() {
      return this.operatorId;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public LocalDateTime getOperateDate() {
      return this.operateDate;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setProduceTeamReportId(final Long produceTeamReportId) {
      this.produceTeamReportId = produceTeamReportId;
   }

   public void setReportingTime(final LocalDateTime reportingTime) {
      this.reportingTime = reportingTime;
   }

   public void setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setContractProjectWageConfigId(final Long contractProjectWageConfigId) {
      this.contractProjectWageConfigId = contractProjectWageConfigId;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setOldMeasureQuantity(final BigDecimal oldMeasureQuantity) {
      this.oldMeasureQuantity = oldMeasureQuantity;
   }

   public void setNewMeasureQuantity(final BigDecimal newMeasureQuantity) {
      this.newMeasureQuantity = newMeasureQuantity;
   }

   public void setOldQuotaPrice(final BigDecimal oldQuotaPrice) {
      this.oldQuotaPrice = oldQuotaPrice;
   }

   public void setNewQuotaPrice(final BigDecimal newQuotaPrice) {
      this.newQuotaPrice = newQuotaPrice;
   }

   public void setWage(final BigDecimal wage) {
      this.wage = wage;
   }

   public void setOperatorId(final Long operatorId) {
      this.operatorId = operatorId;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setOperateDate(final LocalDateTime operateDate) {
      this.operateDate = operateDate;
   }

   public void setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesYieldConfirmSaveDTOParam)) {
         return false;
      }

      MesYieldConfirmSaveDTOParam other = (MesYieldConfirmSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$produceTeamReportId = this.getProduceTeamReportId();
                  Object other$produceTeamReportId = other.getProduceTeamReportId();
                  if (this$produceTeamReportId == null ? other$produceTeamReportId == null : this$produceTeamReportId.equals(other$produceTeamReportId)) {
                     Object this$contractProjectId = this.getContractProjectId();
                     Object other$contractProjectId = other.getContractProjectId();
                     if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
                        Object this$monomerId = this.getMonomerId();
                        Object other$monomerId = other.getMonomerId();
                        if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                           Object this$areaId = this.getAreaId();
                           Object other$areaId = other.getAreaId();
                           if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                              Object this$productType = this.getProductType();
                              Object other$productType = other.getProductType();
                              if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                 Object this$productId = this.getProductId();
                                 Object other$productId = other.getProductId();
                                 if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                    Object this$number = this.getNumber();
                                    Object other$number = other.getNumber();
                                    if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                       Object this$contractProjectWageConfigId = this.getContractProjectWageConfigId();
                                       Object other$contractProjectWageConfigId = other.getContractProjectWageConfigId();
                                       if (this$contractProjectWageConfigId == null
                                          ? other$contractProjectWageConfigId == null
                                          : this$contractProjectWageConfigId.equals(other$contractProjectWageConfigId)) {
                                          Object this$operatorId = this.getOperatorId();
                                          Object other$operatorId = other.getOperatorId();
                                          if (this$operatorId == null ? other$operatorId == null : this$operatorId.equals(other$operatorId)) {
                                             Object this$inspectionQuantity = this.getInspectionQuantity();
                                             Object other$inspectionQuantity = other.getInspectionQuantity();
                                             if (this$inspectionQuantity == null
                                                ? other$inspectionQuantity == null
                                                : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                                                Object this$reportingTime = this.getReportingTime();
                                                Object other$reportingTime = other.getReportingTime();
                                                if (this$reportingTime == null ? other$reportingTime == null : this$reportingTime.equals(other$reportingTime)) {
                                                   Object this$measureUnit = this.getMeasureUnit();
                                                   Object other$measureUnit = other.getMeasureUnit();
                                                   if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                      Object this$oldMeasureQuantity = this.getOldMeasureQuantity();
                                                      Object other$oldMeasureQuantity = other.getOldMeasureQuantity();
                                                      if (this$oldMeasureQuantity == null
                                                         ? other$oldMeasureQuantity == null
                                                         : this$oldMeasureQuantity.equals(other$oldMeasureQuantity)) {
                                                         Object this$newMeasureQuantity = this.getNewMeasureQuantity();
                                                         Object other$newMeasureQuantity = other.getNewMeasureQuantity();
                                                         if (this$newMeasureQuantity == null
                                                            ? other$newMeasureQuantity == null
                                                            : this$newMeasureQuantity.equals(other$newMeasureQuantity)) {
                                                            Object this$oldQuotaPrice = this.getOldQuotaPrice();
                                                            Object other$oldQuotaPrice = other.getOldQuotaPrice();
                                                            if (this$oldQuotaPrice == null
                                                               ? other$oldQuotaPrice == null
                                                               : this$oldQuotaPrice.equals(other$oldQuotaPrice)) {
                                                               Object this$newQuotaPrice = this.getNewQuotaPrice();
                                                               Object other$newQuotaPrice = other.getNewQuotaPrice();
                                                               if (this$newQuotaPrice == null
                                                                  ? other$newQuotaPrice == null
                                                                  : this$newQuotaPrice.equals(other$newQuotaPrice)) {
                                                                  Object this$wage = this.getWage();
                                                                  Object other$wage = other.getWage();
                                                                  if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                                                                     Object this$operatorName = this.getOperatorName();
                                                                     Object other$operatorName = other.getOperatorName();
                                                                     if (this$operatorName == null
                                                                        ? other$operatorName == null
                                                                        : this$operatorName.equals(other$operatorName)) {
                                                                        Object this$operateDate = this.getOperateDate();
                                                                        Object other$operateDate = other.getOperateDate();
                                                                        return this$operateDate == null
                                                                           ? other$operateDate == null
                                                                           : this$operateDate.equals(other$operateDate);
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
      return other instanceof MesYieldConfirmSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $produceTeamReportId = this.getProduceTeamReportId();
      result = result * 59 + ($produceTeamReportId == null ? 43 : $produceTeamReportId.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $contractProjectWageConfigId = this.getContractProjectWageConfigId();
      result = result * 59 + ($contractProjectWageConfigId == null ? 43 : $contractProjectWageConfigId.hashCode());
      Object $operatorId = this.getOperatorId();
      result = result * 59 + ($operatorId == null ? 43 : $operatorId.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $reportingTime = this.getReportingTime();
      result = result * 59 + ($reportingTime == null ? 43 : $reportingTime.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $oldMeasureQuantity = this.getOldMeasureQuantity();
      result = result * 59 + ($oldMeasureQuantity == null ? 43 : $oldMeasureQuantity.hashCode());
      Object $newMeasureQuantity = this.getNewMeasureQuantity();
      result = result * 59 + ($newMeasureQuantity == null ? 43 : $newMeasureQuantity.hashCode());
      Object $oldQuotaPrice = this.getOldQuotaPrice();
      result = result * 59 + ($oldQuotaPrice == null ? 43 : $oldQuotaPrice.hashCode());
      Object $newQuotaPrice = this.getNewQuotaPrice();
      result = result * 59 + ($newQuotaPrice == null ? 43 : $newQuotaPrice.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $operateDate = this.getOperateDate();
      return result * 59 + ($operateDate == null ? 43 : $operateDate.hashCode());
   }

   @Override
   public String toString() {
      return "MesYieldConfirmSaveDTOParam(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", produceTeamReportId="
         + this.getProduceTeamReportId()
         + ", reportingTime="
         + this.getReportingTime()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", number="
         + this.getNumber()
         + ", contractProjectWageConfigId="
         + this.getContractProjectWageConfigId()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", oldMeasureQuantity="
         + this.getOldMeasureQuantity()
         + ", newMeasureQuantity="
         + this.getNewMeasureQuantity()
         + ", oldQuotaPrice="
         + this.getOldQuotaPrice()
         + ", newQuotaPrice="
         + this.getNewQuotaPrice()
         + ", wage="
         + this.getWage()
         + ", operatorId="
         + this.getOperatorId()
         + ", operatorName="
         + this.getOperatorName()
         + ", operateDate="
         + this.getOperateDate()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ")";
   }

   public static class MesYieldConfirmSaveDTOParamBuilder {
      private Long id;
      private Long workshopId;
      private Long processId;
      private Long teamId;
      private Long produceTeamReportId;
      private LocalDateTime reportingTime;
      private Long contractProjectId;
      private Long monomerId;
      private Long areaId;
      private Integer productType;
      private Long productId;
      private Integer number;
      private Long contractProjectWageConfigId;
      private String measureUnit;
      private BigDecimal oldMeasureQuantity;
      private BigDecimal newMeasureQuantity;
      private BigDecimal oldQuotaPrice;
      private BigDecimal newQuotaPrice;
      private BigDecimal wage;
      private Long operatorId;
      private String operatorName;
      private LocalDateTime operateDate;
      private Integer inspectionQuantity;

      MesYieldConfirmSaveDTOParamBuilder() {
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder produceTeamReportId(final Long produceTeamReportId) {
         this.produceTeamReportId = produceTeamReportId;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder reportingTime(final LocalDateTime reportingTime) {
         this.reportingTime = reportingTime;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder contractProjectId(final Long contractProjectId) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder contractProjectWageConfigId(final Long contractProjectWageConfigId) {
         this.contractProjectWageConfigId = contractProjectWageConfigId;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder oldMeasureQuantity(final BigDecimal oldMeasureQuantity) {
         this.oldMeasureQuantity = oldMeasureQuantity;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder newMeasureQuantity(final BigDecimal newMeasureQuantity) {
         this.newMeasureQuantity = newMeasureQuantity;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder oldQuotaPrice(final BigDecimal oldQuotaPrice) {
         this.oldQuotaPrice = oldQuotaPrice;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder newQuotaPrice(final BigDecimal newQuotaPrice) {
         this.newQuotaPrice = newQuotaPrice;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder operatorId(final Long operatorId) {
         this.operatorId = operatorId;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder operateDate(final LocalDateTime operateDate) {
         this.operateDate = operateDate;
         return this;
      }

      public MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public MesYieldConfirmSaveDTOParam build() {
         return new MesYieldConfirmSaveDTOParam(
            this.id,
            this.workshopId,
            this.processId,
            this.teamId,
            this.produceTeamReportId,
            this.reportingTime,
            this.contractProjectId,
            this.monomerId,
            this.areaId,
            this.productType,
            this.productId,
            this.number,
            this.contractProjectWageConfigId,
            this.measureUnit,
            this.oldMeasureQuantity,
            this.newMeasureQuantity,
            this.oldQuotaPrice,
            this.newQuotaPrice,
            this.wage,
            this.operatorId,
            this.operatorName,
            this.operateDate,
            this.inspectionQuantity
         );
      }

      @Override
      public String toString() {
         return "MesYieldConfirmSaveDTOParam.MesYieldConfirmSaveDTOParamBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", processId="
            + this.processId
            + ", teamId="
            + this.teamId
            + ", produceTeamReportId="
            + this.produceTeamReportId
            + ", reportingTime="
            + this.reportingTime
            + ", contractProjectId="
            + this.contractProjectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", number="
            + this.number
            + ", contractProjectWageConfigId="
            + this.contractProjectWageConfigId
            + ", measureUnit="
            + this.measureUnit
            + ", oldMeasureQuantity="
            + this.oldMeasureQuantity
            + ", newMeasureQuantity="
            + this.newMeasureQuantity
            + ", oldQuotaPrice="
            + this.oldQuotaPrice
            + ", newQuotaPrice="
            + this.newQuotaPrice
            + ", wage="
            + this.wage
            + ", operatorId="
            + this.operatorId
            + ", operatorName="
            + this.operatorName
            + ", operateDate="
            + this.operateDate
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ")";
      }
   }
}
