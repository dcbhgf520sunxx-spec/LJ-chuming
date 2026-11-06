package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.contract.core.api.enums.finance.WageTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "ContractWageSummary对象", description = "员工工资统计表 ")
public class ContractWageSummaryDtoParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "wageType", value = "工资类型 1管理人员工资 2生产人员工资", notes = "工资类型 1管理人员工资 2生产人员工资")
   @NotNull(message = "公司类型不能为空")
   @EnumValidator(value = WageTypeEnum.class, groups = {Add.class, Update.class})
   private Integer wageType;
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   @NotNull(message = "年份不能为空")
   @Max(value = 2100L, message = "年份太大")
   @Min(value = 1900L, message = "年份太小")
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份(1~12)", notes = "月份(1~12)")
   @NotNull(message = "月份不能为空")
   @Max(value = 12L, message = "月份错误,请输入1~12之间的数字")
   @Min(value = 1L, message = "月份错误,请输入1~12之间的数字`")
   private Integer month;
   @ApiModelProperty(name = "employeeQuantity", value = "员工数量", notes = "员工数量")
   @NotNull(message = "员工数量不能为空")
   @Min(1L)
   private Integer employeeQuantity;
   @ApiModelProperty(name = "totalWage", value = "工资总额", notes = "工资总额")
   @NotNull(message = "工资总额不能为空")
   @DecimalMin(value = "0.0001", message = "工资这么低,你干啊!")
   private BigDecimal totalWage;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID列表", notes = "附件ID列表")
   private List<Long> attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 1000, message = "备注字数超出限制")
   private String remark;

   public static ContractWageSummaryDtoParam.ContractWageSummaryDtoParamBuilder builder() {
      return new ContractWageSummaryDtoParam.ContractWageSummaryDtoParamBuilder();
   }

   public ContractWageSummaryDtoParam() {
   }

   public ContractWageSummaryDtoParam(
      final Long id,
      final Integer wageType,
      final Integer year,
      final Integer month,
      final Integer employeeQuantity,
      final BigDecimal totalWage,
      final List<Long> attachmentIds,
      final String remark
   ) {
      this.id = id;
      this.wageType = wageType;
      this.year = year;
      this.month = month;
      this.employeeQuantity = employeeQuantity;
      this.totalWage = totalWage;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getWageType() {
      return this.wageType;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getMonth() {
      return this.month;
   }

   public Integer getEmployeeQuantity() {
      return this.employeeQuantity;
   }

   public BigDecimal getTotalWage() {
      return this.totalWage;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWageType(final Integer wageType) {
      this.wageType = wageType;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setEmployeeQuantity(final Integer employeeQuantity) {
      this.employeeQuantity = employeeQuantity;
   }

   public void setTotalWage(final BigDecimal totalWage) {
      this.totalWage = totalWage;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWageSummaryDtoParam)) {
         return false;
      }

      ContractWageSummaryDtoParam other = (ContractWageSummaryDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$wageType = this.getWageType();
         Object other$wageType = other.getWageType();
         if (this$wageType == null ? other$wageType == null : this$wageType.equals(other$wageType)) {
            Object this$year = this.getYear();
            Object other$year = other.getYear();
            if (this$year == null ? other$year == null : this$year.equals(other$year)) {
               Object this$month = this.getMonth();
               Object other$month = other.getMonth();
               if (this$month == null ? other$month == null : this$month.equals(other$month)) {
                  Object this$employeeQuantity = this.getEmployeeQuantity();
                  Object other$employeeQuantity = other.getEmployeeQuantity();
                  if (this$employeeQuantity == null ? other$employeeQuantity == null : this$employeeQuantity.equals(other$employeeQuantity)) {
                     Object this$totalWage = this.getTotalWage();
                     Object other$totalWage = other.getTotalWage();
                     if (this$totalWage == null ? other$totalWage == null : this$totalWage.equals(other$totalWage)) {
                        Object this$attachmentIds = this.getAttachmentIds();
                        Object other$attachmentIds = other.getAttachmentIds();
                        if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractWageSummaryDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $wageType = this.getWageType();
      result = result * 59 + ($wageType == null ? 43 : $wageType.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $employeeQuantity = this.getEmployeeQuantity();
      result = result * 59 + ($employeeQuantity == null ? 43 : $employeeQuantity.hashCode());
      Object $totalWage = this.getTotalWage();
      result = result * 59 + ($totalWage == null ? 43 : $totalWage.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWageSummaryDtoParam(id="
         + this.getId()
         + ", wageType="
         + this.getWageType()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", employeeQuantity="
         + this.getEmployeeQuantity()
         + ", totalWage="
         + this.getTotalWage()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ContractWageSummaryDtoParamBuilder {
      private Long id;
      private Integer wageType;
      private Integer year;
      private Integer month;
      private Integer employeeQuantity;
      private BigDecimal totalWage;
      private List<Long> attachmentIds;
      private String remark;

      ContractWageSummaryDtoParamBuilder() {
      }

      public ContractWageSummaryDtoParam.ContractWageSummaryDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWageSummaryDtoParam.ContractWageSummaryDtoParamBuilder wageType(final Integer wageType) {
         this.wageType = wageType;
         return this;
      }

      public ContractWageSummaryDtoParam.ContractWageSummaryDtoParamBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractWageSummaryDtoParam.ContractWageSummaryDtoParamBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractWageSummaryDtoParam.ContractWageSummaryDtoParamBuilder employeeQuantity(final Integer employeeQuantity) {
         this.employeeQuantity = employeeQuantity;
         return this;
      }

      public ContractWageSummaryDtoParam.ContractWageSummaryDtoParamBuilder totalWage(final BigDecimal totalWage) {
         this.totalWage = totalWage;
         return this;
      }

      public ContractWageSummaryDtoParam.ContractWageSummaryDtoParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractWageSummaryDtoParam.ContractWageSummaryDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractWageSummaryDtoParam build() {
         return new ContractWageSummaryDtoParam(
            this.id, this.wageType, this.year, this.month, this.employeeQuantity, this.totalWage, this.attachmentIds, this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractWageSummaryDtoParam.ContractWageSummaryDtoParamBuilder(id="
            + this.id
            + ", wageType="
            + this.wageType
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", employeeQuantity="
            + this.employeeQuantity
            + ", totalWage="
            + this.totalWage
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
