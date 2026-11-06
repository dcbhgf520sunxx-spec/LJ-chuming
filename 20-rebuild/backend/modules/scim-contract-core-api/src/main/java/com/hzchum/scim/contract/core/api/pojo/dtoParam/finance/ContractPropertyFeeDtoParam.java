package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "ContractPropertyFee对象", description = "物业费表 ")
public class ContractPropertyFeeDtoParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   @NotNull(message = "年份不能为空")
   @Max(value = 2100L, message = "你是未来穿越过来的吗")
   @Min(value = 1900L, message = "你是清朝人?")
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @NotNull(message = "月份不能为空")
   @Max(12L)
   @Min(1L)
   private Integer month;
   @ApiModelProperty(name = "feeAmount", value = "费用", notes = "费用")
   @NotNull(message = "费用不能为空")
   @DecimalMin(value = "0.0001", message = "费用太低了吧")
   private BigDecimal feeAmount;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID列表", notes = "附件ID列表")
   @Size(max = 100, message = "附件太多了吧")
   private List<Long> attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 1000, message = "字数太多了吧")
   private String remark;

   public static ContractPropertyFeeDtoParam.ContractPropertyFeeDtoParamBuilder builder() {
      return new ContractPropertyFeeDtoParam.ContractPropertyFeeDtoParamBuilder();
   }

   public ContractPropertyFeeDtoParam() {
   }

   public ContractPropertyFeeDtoParam(
      final Long id, final Integer year, final Integer month, final BigDecimal feeAmount, final List<Long> attachmentIds, final String remark
   ) {
      this.id = id;
      this.year = year;
      this.month = month;
      this.feeAmount = feeAmount;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getFeeAmount() {
      return this.feeAmount;
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

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setFeeAmount(final BigDecimal feeAmount) {
      this.feeAmount = feeAmount;
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

      if (!(o instanceof ContractPropertyFeeDtoParam)) {
         return false;
      }

      ContractPropertyFeeDtoParam other = (ContractPropertyFeeDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$year = this.getYear();
         Object other$year = other.getYear();
         if (this$year == null ? other$year == null : this$year.equals(other$year)) {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$feeAmount = this.getFeeAmount();
               Object other$feeAmount = other.getFeeAmount();
               if (this$feeAmount == null ? other$feeAmount == null : this$feeAmount.equals(other$feeAmount)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractPropertyFeeDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $feeAmount = this.getFeeAmount();
      result = result * 59 + ($feeAmount == null ? 43 : $feeAmount.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractPropertyFeeDtoParam(id="
         + this.getId()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", feeAmount="
         + this.getFeeAmount()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ContractPropertyFeeDtoParamBuilder {
      private Long id;
      private Integer year;
      private Integer month;
      private BigDecimal feeAmount;
      private List<Long> attachmentIds;
      private String remark;

      ContractPropertyFeeDtoParamBuilder() {
      }

      public ContractPropertyFeeDtoParam.ContractPropertyFeeDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractPropertyFeeDtoParam.ContractPropertyFeeDtoParamBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractPropertyFeeDtoParam.ContractPropertyFeeDtoParamBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractPropertyFeeDtoParam.ContractPropertyFeeDtoParamBuilder feeAmount(final BigDecimal feeAmount) {
         this.feeAmount = feeAmount;
         return this;
      }

      public ContractPropertyFeeDtoParam.ContractPropertyFeeDtoParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractPropertyFeeDtoParam.ContractPropertyFeeDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractPropertyFeeDtoParam build() {
         return new ContractPropertyFeeDtoParam(this.id, this.year, this.month, this.feeAmount, this.attachmentIds, this.remark);
      }

      @Override
      public String toString() {
         return "ContractPropertyFeeDtoParam.ContractPropertyFeeDtoParamBuilder(id="
            + this.id
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", feeAmount="
            + this.feeAmount
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
