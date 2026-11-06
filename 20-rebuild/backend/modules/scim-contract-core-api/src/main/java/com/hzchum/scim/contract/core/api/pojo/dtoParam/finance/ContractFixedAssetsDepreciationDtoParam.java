package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "ContractFixedAssetsDepreciation对象", description = "固定资产折旧表dto ")
public class ContractFixedAssetsDepreciationDtoParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(message = "id不能为空", groups = Update.class)
   private Long id;
   @ApiModelProperty(name = "type", value = "类型 (1厂房折旧 2以后添加)", notes = "类型 (1厂房折旧 2以后添加)")
   @NotNull(message = "类型不能为空")
   private Integer type;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @NotNull(message = "名称不能为空")
   @Size(min = 1, max = 128, message = "名称字数超出限制!")
   private String name;
   @ApiModelProperty(name = "originalValue", value = "原值(元)", notes = "原值(元)")
   @NotNull(message = "原值不能为空")
   private BigDecimal originalValue;
   @ApiModelProperty(name = "depreciationYear", value = "折旧年限", notes = "折旧年限")
   @NotNull(message = "折旧年限不能为空")
   @DecimalMin(value = "0.1", message = "折旧年限太小了")
   @DecimalMax(value = "1000", message = "折旧年限太大了")
   private BigDecimal depreciationYear;
   @ApiModelProperty(name = "startDate", value = "开始计算折旧日期", notes = "开始计算折旧日期")
   @NotNull(message = "折旧开始计算日期不能为空")
   private LocalDate startDate;
   @ApiModelProperty(name = "residualValueRate", value = "残值率 (残值/原值)", notes = "残值率 (残值/原值)")
   @DecimalMin(value = "0.0", message = "报废残值率最小为0")
   @NotNull(message = "报废残值率不能为空")
   private BigDecimal residualValueRate;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID列表", notes = "附件ID列表")
   @Size(max = 50, message = "附件不能太多")
   private List<Long> attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @Max(value = 1000L, message = "字数不能太多")
   private String remark;

   public static ContractFixedAssetsDepreciationDtoParam.ContractFixedAssetsDepreciationDtoParamBuilder builder() {
      return new ContractFixedAssetsDepreciationDtoParam.ContractFixedAssetsDepreciationDtoParamBuilder();
   }

   public ContractFixedAssetsDepreciationDtoParam() {
   }

   public ContractFixedAssetsDepreciationDtoParam(
      final Long id,
      final Integer type,
      final String name,
      final BigDecimal originalValue,
      final BigDecimal depreciationYear,
      final LocalDate startDate,
      final BigDecimal residualValueRate,
      final List<Long> attachmentIds,
      final String remark
   ) {
      this.id = id;
      this.type = type;
      this.name = name;
      this.originalValue = originalValue;
      this.depreciationYear = depreciationYear;
      this.startDate = startDate;
      this.residualValueRate = residualValueRate;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
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

   public BigDecimal getResidualValueRate() {
      return this.residualValueRate;
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

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setName(final String name) {
      this.name = name;
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

   public void setResidualValueRate(final BigDecimal residualValueRate) {
      this.residualValueRate = residualValueRate;
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

      if (!(o instanceof ContractFixedAssetsDepreciationDtoParam)) {
         return false;
      }

      ContractFixedAssetsDepreciationDtoParam other = (ContractFixedAssetsDepreciationDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$originalValue = this.getOriginalValue();
               Object other$originalValue = other.getOriginalValue();
               if (this$originalValue == null ? other$originalValue == null : this$originalValue.equals(other$originalValue)) {
                  Object this$depreciationYear = this.getDepreciationYear();
                  Object other$depreciationYear = other.getDepreciationYear();
                  if (this$depreciationYear == null ? other$depreciationYear == null : this$depreciationYear.equals(other$depreciationYear)) {
                     Object this$startDate = this.getStartDate();
                     Object other$startDate = other.getStartDate();
                     if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                        Object this$residualValueRate = this.getResidualValueRate();
                        Object other$residualValueRate = other.getResidualValueRate();
                        if (this$residualValueRate == null ? other$residualValueRate == null : this$residualValueRate.equals(other$residualValueRate)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractFixedAssetsDepreciationDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $originalValue = this.getOriginalValue();
      result = result * 59 + ($originalValue == null ? 43 : $originalValue.hashCode());
      Object $depreciationYear = this.getDepreciationYear();
      result = result * 59 + ($depreciationYear == null ? 43 : $depreciationYear.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $residualValueRate = this.getResidualValueRate();
      result = result * 59 + ($residualValueRate == null ? 43 : $residualValueRate.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractFixedAssetsDepreciationDtoParam(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", name="
         + this.getName()
         + ", originalValue="
         + this.getOriginalValue()
         + ", depreciationYear="
         + this.getDepreciationYear()
         + ", startDate="
         + this.getStartDate()
         + ", residualValueRate="
         + this.getResidualValueRate()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ContractFixedAssetsDepreciationDtoParamBuilder {
      private Long id;
      private Integer type;
      private String name;
      private BigDecimal originalValue;
      private BigDecimal depreciationYear;
      private LocalDate startDate;
      private BigDecimal residualValueRate;
      private List<Long> attachmentIds;
      private String remark;

      ContractFixedAssetsDepreciationDtoParamBuilder() {
      }

      public ContractFixedAssetsDepreciationDtoParam.ContractFixedAssetsDepreciationDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractFixedAssetsDepreciationDtoParam.ContractFixedAssetsDepreciationDtoParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractFixedAssetsDepreciationDtoParam.ContractFixedAssetsDepreciationDtoParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ContractFixedAssetsDepreciationDtoParam.ContractFixedAssetsDepreciationDtoParamBuilder originalValue(final BigDecimal originalValue) {
         this.originalValue = originalValue;
         return this;
      }

      public ContractFixedAssetsDepreciationDtoParam.ContractFixedAssetsDepreciationDtoParamBuilder depreciationYear(final BigDecimal depreciationYear) {
         this.depreciationYear = depreciationYear;
         return this;
      }

      public ContractFixedAssetsDepreciationDtoParam.ContractFixedAssetsDepreciationDtoParamBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public ContractFixedAssetsDepreciationDtoParam.ContractFixedAssetsDepreciationDtoParamBuilder residualValueRate(final BigDecimal residualValueRate) {
         this.residualValueRate = residualValueRate;
         return this;
      }

      public ContractFixedAssetsDepreciationDtoParam.ContractFixedAssetsDepreciationDtoParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractFixedAssetsDepreciationDtoParam.ContractFixedAssetsDepreciationDtoParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractFixedAssetsDepreciationDtoParam build() {
         return new ContractFixedAssetsDepreciationDtoParam(
            this.id, this.type, this.name, this.originalValue, this.depreciationYear, this.startDate, this.residualValueRate, this.attachmentIds, this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractFixedAssetsDepreciationDtoParam.ContractFixedAssetsDepreciationDtoParamBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", name="
            + this.name
            + ", originalValue="
            + this.originalValue
            + ", depreciationYear="
            + this.depreciationYear
            + ", startDate="
            + this.startDate
            + ", residualValueRate="
            + this.residualValueRate
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
