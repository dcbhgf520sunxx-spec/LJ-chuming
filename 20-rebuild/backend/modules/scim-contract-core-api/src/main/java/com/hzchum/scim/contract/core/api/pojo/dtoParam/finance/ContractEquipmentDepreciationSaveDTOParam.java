package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@ApiModel(description = "设备折旧新增修改DTOParam类")
public class ContractEquipmentDepreciationSaveDTOParam {
   @ApiModelProperty(name = "id")
   @NotNull(groups = Update.class, message = "ID不能为空")
   private Long id;
   @ApiModelProperty(name = "classificationName", value = "分类名称")
   @NotNull(groups = {Add.class, Update.class}, message = "分类不能为空")
   private String classificationName;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID")
   @NotNull(groups = {Add.class, Update.class}, message = "费用归属不能为空")
   private Long branchCompanyId;
   @ApiModelProperty(name = "equipmentName", value = "设备名称")
   @NotNull(groups = {Add.class, Update.class}, message = "设备名称不能为空")
   private String equipmentName;
   @ApiModelProperty(name = "originalValue", value = "原值(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "原值不能为空")
   private BigDecimal originalValue;
   @ApiModelProperty(name = "depreciationYear", value = "折旧年限")
   @NotNull(groups = {Add.class, Update.class}, message = "折旧年限不能为空")
   @DecimalMin(groups = {Add.class, Update.class}, value = "0.1", message = "折旧年限太小了")
   @DecimalMax(groups = {Add.class, Update.class}, value = "1000", message = "折旧年限太大了")
   private BigDecimal depreciationYear;
   @ApiModelProperty(name = "startDate", value = "开始计算折旧日期")
   @NotNull(groups = {Add.class, Update.class}, message = "开始折旧计算日期不能为空")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "结束计算折旧日期")
   @NotNull(groups = {Add.class, Update.class}, message = "结束折旧计算日期不能为空")
   private LocalDate endDate;
   @ApiModelProperty(name = "residualValueRate", value = "残值率")
   @DecimalMin(value = "0.0", message = "报废残值率最小为0")
   @NotNull(groups = {Add.class, Update.class}, message = "报废残值率不能为空")
   private BigDecimal residualValueRate;

   public Long getId() {
      return this.id;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getEquipmentName() {
      return this.equipmentName;
   }

   public BigDecimal getOriginalValue() {
      return this.originalValue;
   }

   public BigDecimal getDepreciationYear() {
      return this.depreciationYear;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public BigDecimal getResidualValueRate() {
      return this.residualValueRate;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setEquipmentName(final String equipmentName) {
      this.equipmentName = equipmentName;
   }

   public void setOriginalValue(final BigDecimal originalValue) {
      this.originalValue = originalValue;
   }

   public void setDepreciationYear(final BigDecimal depreciationYear) {
      this.depreciationYear = depreciationYear;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setResidualValueRate(final BigDecimal residualValueRate) {
      this.residualValueRate = residualValueRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractEquipmentDepreciationSaveDTOParam)) {
         return false;
      }

      ContractEquipmentDepreciationSaveDTOParam other = (ContractEquipmentDepreciationSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$classificationName = this.getClassificationName();
            Object other$classificationName = other.getClassificationName();
            if (this$classificationName == null ? other$classificationName == null : this$classificationName.equals(other$classificationName)) {
               Object this$equipmentName = this.getEquipmentName();
               Object other$equipmentName = other.getEquipmentName();
               if (this$equipmentName == null ? other$equipmentName == null : this$equipmentName.equals(other$equipmentName)) {
                  Object this$originalValue = this.getOriginalValue();
                  Object other$originalValue = other.getOriginalValue();
                  if (this$originalValue == null ? other$originalValue == null : this$originalValue.equals(other$originalValue)) {
                     Object this$depreciationYear = this.getDepreciationYear();
                     Object other$depreciationYear = other.getDepreciationYear();
                     if (this$depreciationYear == null ? other$depreciationYear == null : this$depreciationYear.equals(other$depreciationYear)) {
                        Object this$startDate = this.getStartDate();
                        Object other$startDate = other.getStartDate();
                        if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                           Object this$endDate = this.getEndDate();
                           Object other$endDate = other.getEndDate();
                           if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                              Object this$residualValueRate = this.getResidualValueRate();
                              Object other$residualValueRate = other.getResidualValueRate();
                              return this$residualValueRate == null ? other$residualValueRate == null : this$residualValueRate.equals(other$residualValueRate);
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
      return other instanceof ContractEquipmentDepreciationSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $equipmentName = this.getEquipmentName();
      result = result * 59 + ($equipmentName == null ? 43 : $equipmentName.hashCode());
      Object $originalValue = this.getOriginalValue();
      result = result * 59 + ($originalValue == null ? 43 : $originalValue.hashCode());
      Object $depreciationYear = this.getDepreciationYear();
      result = result * 59 + ($depreciationYear == null ? 43 : $depreciationYear.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $residualValueRate = this.getResidualValueRate();
      return result * 59 + ($residualValueRate == null ? 43 : $residualValueRate.hashCode());
   }

   @Override
   public String toString() {
      return "ContractEquipmentDepreciationSaveDTOParam(id="
         + this.getId()
         + ", classificationName="
         + this.getClassificationName()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", equipmentName="
         + this.getEquipmentName()
         + ", originalValue="
         + this.getOriginalValue()
         + ", depreciationYear="
         + this.getDepreciationYear()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", residualValueRate="
         + this.getResidualValueRate()
         + ")";
   }
}
