package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.contract.core.api.enums.finance.WaterElectricityPropertyFeeTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@ApiModel(description = "水、电、物业费新增修改param类")
public class ContractWaterElectricityPropertyFeeSaveParam {
   @ApiModelProperty(name = "id")
   @NotNull(groups = Update.class, message = "ID不能为空")
   private Long id;
   @ApiModelProperty(name = "type", value = "类型(1: 水, 2: 电, 3: 物业)", notes = "类型(1: 水, 2: 电, 3: 物业)")
   @NotNull(groups = {Add.class, Update.class}, message = "类型不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = WaterElectricityPropertyFeeTypeEnum.class, message = "类型不存在")
   private Integer type;
   @ApiModelProperty(name = "yearMonthDate", value = "年月日期", notes = "年月日期")
   @NotNull(groups = {Add.class, Update.class}, message = "月份不能为空")
   private LocalDate yearMonthDate;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID", notes = "分支机构ID")
   @NotNull(groups = {Add.class, Update.class}, message = "费用归属不能为空")
   private Long branchCompanyId;
   @ApiModelProperty(name = "consumption", value = "消耗量(水: 吨, 电: kw/h=度)", notes = "消耗量(水: 吨, 电: kw/h=度)")
   @Positive(groups = {Add.class, Update.class}, message = "消耗量不能小于等于0")
   private BigDecimal consumption;
   @ApiModelProperty(name = "totalFee", value = "费用总额(元)", notes = "费用总额(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "费用总额不能为空")
   @Positive(groups = {Add.class, Update.class}, message = "费用总额不能小于等于0")
   private BigDecimal totalFee;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(groups = {Add.class, Update.class}, max = 500, message = "最多500个字符")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDate getYearMonthDate() {
      return this.yearMonthDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public BigDecimal getConsumption() {
      return this.consumption;
   }

   public BigDecimal getTotalFee() {
      return this.totalFee;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setYearMonthDate(final LocalDate yearMonthDate) {
      this.yearMonthDate = yearMonthDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setConsumption(final BigDecimal consumption) {
      this.consumption = consumption;
   }

   public void setTotalFee(final BigDecimal totalFee) {
      this.totalFee = totalFee;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWaterElectricityPropertyFeeSaveParam)) {
         return false;
      }

      ContractWaterElectricityPropertyFeeSaveParam other = (ContractWaterElectricityPropertyFeeSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$branchCompanyId = this.getBranchCompanyId();
            Object other$branchCompanyId = other.getBranchCompanyId();
            if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
               Object this$yearMonthDate = this.getYearMonthDate();
               Object other$yearMonthDate = other.getYearMonthDate();
               if (this$yearMonthDate == null ? other$yearMonthDate == null : this$yearMonthDate.equals(other$yearMonthDate)) {
                  Object this$consumption = this.getConsumption();
                  Object other$consumption = other.getConsumption();
                  if (this$consumption == null ? other$consumption == null : this$consumption.equals(other$consumption)) {
                     Object this$totalFee = this.getTotalFee();
                     Object other$totalFee = other.getTotalFee();
                     if (this$totalFee == null ? other$totalFee == null : this$totalFee.equals(other$totalFee)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ContractWaterElectricityPropertyFeeSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $yearMonthDate = this.getYearMonthDate();
      result = result * 59 + ($yearMonthDate == null ? 43 : $yearMonthDate.hashCode());
      Object $consumption = this.getConsumption();
      result = result * 59 + ($consumption == null ? 43 : $consumption.hashCode());
      Object $totalFee = this.getTotalFee();
      result = result * 59 + ($totalFee == null ? 43 : $totalFee.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWaterElectricityPropertyFeeSaveParam(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", yearMonthDate="
         + this.getYearMonthDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", consumption="
         + this.getConsumption()
         + ", totalFee="
         + this.getTotalFee()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
