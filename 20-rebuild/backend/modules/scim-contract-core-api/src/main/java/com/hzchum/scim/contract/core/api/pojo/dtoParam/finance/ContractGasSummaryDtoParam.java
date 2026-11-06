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

@ApiModel(value = "ContractGasSummary对象", description = "气体用量统计表 ")
public class ContractGasSummaryDtoParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "classifyId", value = "科目表ID", notes = "科目表ID")
   @NotNull(message = "气体类型不能为空")
   private Long classifyId;
   @ApiModelProperty(name = "year", value = "年度 (例:2022)", notes = "年度 (例:2022)")
   @NotNull(message = "年份不能为空")
   @Max(value = 2100L, message = "请您确认一下年份!")
   @Min(value = 1900L, message = "请您确认一下年份!")
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份(1~12)", notes = "月份(1~12)")
   @NotNull(message = "月份不能为空")
   @Max(value = 12L, message = "您认为有这个月份吗?")
   @Min(value = 1L, message = "您认为有这个月份吗")
   private Integer month;
   @ApiModelProperty(name = "usedMete", value = "使用量", notes = "使用量")
   @NotNull(message = "使用量不能为空")
   @DecimalMin(value = "0.0001", message = "使用量太少了!")
   private BigDecimal usedMete;
   @ApiModelProperty(name = "totalAmount", value = "总额(元)", notes = "总额(元)")
   @NotNull(message = "总额不能为空")
   @DecimalMin(value = "0.0001", message = "总额太小了!")
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID列表", notes = "附件ID列表")
   @Size(max = 50, message = "附件太多了!")
   private List<Long> attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Size(max = 1000, message = "备注字数太多了!")
   private String remark;

   public static ContractGasSummaryDtoParam.ContractGasSummaryDtoParamBuilder builder() {
      return new ContractGasSummaryDtoParam.ContractGasSummaryDtoParamBuilder();
   }

   public ContractGasSummaryDtoParam() {
   }

   public ContractGasSummaryDtoParam(
      final Long id,
      final Long classifyId,
      final Integer year,
      final Integer month,
      final BigDecimal usedMete,
      final BigDecimal totalAmount,
      final List<Long> attachmentIds,
      final String remark
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.year = year;
      this.month = month;
      this.usedMete = usedMete;
      this.totalAmount = totalAmount;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getUsedMete() {
      return this.usedMete;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
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

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setUsedMete(final BigDecimal usedMete) {
      this.usedMete = usedMete;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
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

      if (!(o instanceof ContractGasSummaryDtoParam)) {
         return false;
      }

      ContractGasSummaryDtoParam other = (ContractGasSummaryDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$year = this.getYear();
            Object other$year = other.getYear();
            if (this$year == null ? other$year == null : this$year.equals(other$year)) {
               Object this$month = this.getMonth();
               Object other$month = other.getMonth();
               if (this$month == null ? other$month == null : this$month.equals(other$month)) {
                  Object this$usedMete = this.getUsedMete();
                  Object other$usedMete = other.getUsedMete();
                  if (this$usedMete == null ? other$usedMete == null : this$usedMete.equals(other$usedMete)) {
                     Object this$totalAmount = this.getTotalAmount();
                     Object other$totalAmount = other.getTotalAmount();
                     if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
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
      return other instanceof ContractGasSummaryDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $usedMete = this.getUsedMete();
      result = result * 59 + ($usedMete == null ? 43 : $usedMete.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractGasSummaryDtoParam(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", usedMete="
         + this.getUsedMete()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ContractGasSummaryDtoParamBuilder {
      private Long id;
      private Long classifyId;
      private Integer year;
      private Integer month;
      private BigDecimal usedMete;
      private BigDecimal totalAmount;
      private List<Long> attachmentIds;
      private String remark;

      ContractGasSummaryDtoParamBuilder() {
      }

      public ContractGasSummaryDtoParam.ContractGasSummaryDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractGasSummaryDtoParam.ContractGasSummaryDtoParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ContractGasSummaryDtoParam.ContractGasSummaryDtoParamBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractGasSummaryDtoParam.ContractGasSummaryDtoParamBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractGasSummaryDtoParam.ContractGasSummaryDtoParamBuilder usedMete(final BigDecimal usedMete) {
         this.usedMete = usedMete;
         return this;
      }

      public ContractGasSummaryDtoParam.ContractGasSummaryDtoParamBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public ContractGasSummaryDtoParam.ContractGasSummaryDtoParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractGasSummaryDtoParam.ContractGasSummaryDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractGasSummaryDtoParam build() {
         return new ContractGasSummaryDtoParam(
            this.id, this.classifyId, this.year, this.month, this.usedMete, this.totalAmount, this.attachmentIds, this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractGasSummaryDtoParam.ContractGasSummaryDtoParamBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", usedMete="
            + this.usedMete
            + ", totalAmount="
            + this.totalAmount
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
