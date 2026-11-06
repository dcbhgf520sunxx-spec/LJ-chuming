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
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@ApiModel(value = "ContractFixedAssetsDepreciationSaveDtoParam对象", description = "固定资产折旧表新增修改dto类 ")
public class ContractFixedAssetsDepreciationSaveDtoParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(message = "id不能为空", groups = Update.class)
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @NotNull(groups = {Add.class, Update.class}, message = "名称不能为空")
   @Size(groups = {Add.class, Update.class}, min = 1, max = 128, message = "名称字数超出限制!")
   private String name;
   @ApiModelProperty(name = "originalValue", value = "原值(元)", notes = "原值(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "原值不能为空")
   private BigDecimal originalValue;
   @ApiModelProperty(name = "depreciationYear", value = "折旧年限", notes = "折旧年限")
   @NotNull(groups = {Add.class, Update.class}, message = "折旧年限不能为空")
   @DecimalMin(groups = {Add.class, Update.class}, value = "0.1", message = "折旧年限太小了")
   @DecimalMax(groups = {Add.class, Update.class}, value = "1000", message = "折旧年限太大了")
   private BigDecimal depreciationYear;
   @ApiModelProperty(name = "startDate", value = "开始计算折旧日期", notes = "开始计算折旧日期")
   @NotNull(groups = {Add.class, Update.class}, message = "折旧开始计算日期不能为空")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "结束计算折旧日期", notes = "结束计算折旧日期")
   @NotNull(groups = {Add.class, Update.class}, message = "折旧结束计算日期不能为空")
   private LocalDate endDate;
   @ApiModelProperty(name = "residualValueRate", value = "残值率 (残值/原值)", notes = "残值率 (残值/原值)")
   @DecimalMin(groups = {Add.class, Update.class}, value = "0.0", message = "报废残值率最小为0")
   @NotNull(groups = {Add.class, Update.class}, message = "报废残值率不能为空")
   private BigDecimal residualValueRate;
   @ApiModelProperty(name = "grossFloorArea", value = "建筑面积(㎡)", notes = "建筑面积(㎡)")
   @NotNull(groups = {Add.class, Update.class}, message = "建筑面积不能为空")
   @Positive(groups = {Add.class, Update.class}, message = "建筑面积不能小于等于0")
   private BigDecimal grossFloorArea;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构ID", notes = "分支机构ID")
   @NotNull(groups = {Add.class, Update.class}, message = "费用归属不能为空")
   private Long branchCompanyId;

   public static ContractFixedAssetsDepreciationSaveDtoParam.ContractFixedAssetsDepreciationSaveDtoParamBuilder builder() {
      return new ContractFixedAssetsDepreciationSaveDtoParam.ContractFixedAssetsDepreciationSaveDtoParamBuilder();
   }

   public ContractFixedAssetsDepreciationSaveDtoParam() {
   }

   public ContractFixedAssetsDepreciationSaveDtoParam(
      final Long id,
      final String name,
      final BigDecimal originalValue,
      final BigDecimal depreciationYear,
      final LocalDate startDate,
      final LocalDate endDate,
      final BigDecimal residualValueRate,
      final BigDecimal grossFloorArea,
      final Long branchCompanyId
   ) {
      this.id = id;
      this.name = name;
      this.originalValue = originalValue;
      this.depreciationYear = depreciationYear;
      this.startDate = startDate;
      this.endDate = endDate;
      this.residualValueRate = residualValueRate;
      this.grossFloorArea = grossFloorArea;
      this.branchCompanyId = branchCompanyId;
   }

   public Long getId() {
      return this.id;
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

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public BigDecimal getResidualValueRate() {
      return this.residualValueRate;
   }

   public BigDecimal getGrossFloorArea() {
      return this.grossFloorArea;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setResidualValueRate(final BigDecimal residualValueRate) {
      this.residualValueRate = residualValueRate;
   }

   public void setGrossFloorArea(final BigDecimal grossFloorArea) {
      this.grossFloorArea = grossFloorArea;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractFixedAssetsDepreciationSaveDtoParam)) {
         return false;
      }

      ContractFixedAssetsDepreciationSaveDtoParam other = (ContractFixedAssetsDepreciationSaveDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
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
                        Object this$endDate = this.getEndDate();
                        Object other$endDate = other.getEndDate();
                        if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                           Object this$residualValueRate = this.getResidualValueRate();
                           Object other$residualValueRate = other.getResidualValueRate();
                           if (this$residualValueRate == null ? other$residualValueRate == null : this$residualValueRate.equals(other$residualValueRate)) {
                              Object this$grossFloorArea = this.getGrossFloorArea();
                              Object other$grossFloorArea = other.getGrossFloorArea();
                              return this$grossFloorArea == null ? other$grossFloorArea == null : this$grossFloorArea.equals(other$grossFloorArea);
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
      return other instanceof ContractFixedAssetsDepreciationSaveDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $originalValue = this.getOriginalValue();
      result = result * 59 + ($originalValue == null ? 43 : $originalValue.hashCode());
      Object $depreciationYear = this.getDepreciationYear();
      result = result * 59 + ($depreciationYear == null ? 43 : $depreciationYear.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $residualValueRate = this.getResidualValueRate();
      result = result * 59 + ($residualValueRate == null ? 43 : $residualValueRate.hashCode());
      Object $grossFloorArea = this.getGrossFloorArea();
      return result * 59 + ($grossFloorArea == null ? 43 : $grossFloorArea.hashCode());
   }

   @Override
   public String toString() {
      return "ContractFixedAssetsDepreciationSaveDtoParam(id="
         + this.getId()
         + ", name="
         + this.getName()
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
         + ", grossFloorArea="
         + this.getGrossFloorArea()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ")";
   }

   public static class ContractFixedAssetsDepreciationSaveDtoParamBuilder {
      private Long id;
      private String name;
      private BigDecimal originalValue;
      private BigDecimal depreciationYear;
      private LocalDate startDate;
      private LocalDate endDate;
      private BigDecimal residualValueRate;
      private BigDecimal grossFloorArea;
      private Long branchCompanyId;

      ContractFixedAssetsDepreciationSaveDtoParamBuilder() {
      }

      public ContractFixedAssetsDepreciationSaveDtoParam.ContractFixedAssetsDepreciationSaveDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractFixedAssetsDepreciationSaveDtoParam.ContractFixedAssetsDepreciationSaveDtoParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ContractFixedAssetsDepreciationSaveDtoParam.ContractFixedAssetsDepreciationSaveDtoParamBuilder originalValue(final BigDecimal originalValue) {
         this.originalValue = originalValue;
         return this;
      }

      public ContractFixedAssetsDepreciationSaveDtoParam.ContractFixedAssetsDepreciationSaveDtoParamBuilder depreciationYear(final BigDecimal depreciationYear) {
         this.depreciationYear = depreciationYear;
         return this;
      }

      public ContractFixedAssetsDepreciationSaveDtoParam.ContractFixedAssetsDepreciationSaveDtoParamBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public ContractFixedAssetsDepreciationSaveDtoParam.ContractFixedAssetsDepreciationSaveDtoParamBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public ContractFixedAssetsDepreciationSaveDtoParam.ContractFixedAssetsDepreciationSaveDtoParamBuilder residualValueRate(
         final BigDecimal residualValueRate
      ) {
         this.residualValueRate = residualValueRate;
         return this;
      }

      public ContractFixedAssetsDepreciationSaveDtoParam.ContractFixedAssetsDepreciationSaveDtoParamBuilder grossFloorArea(final BigDecimal grossFloorArea) {
         this.grossFloorArea = grossFloorArea;
         return this;
      }

      public ContractFixedAssetsDepreciationSaveDtoParam.ContractFixedAssetsDepreciationSaveDtoParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ContractFixedAssetsDepreciationSaveDtoParam build() {
         return new ContractFixedAssetsDepreciationSaveDtoParam(
            this.id,
            this.name,
            this.originalValue,
            this.depreciationYear,
            this.startDate,
            this.endDate,
            this.residualValueRate,
            this.grossFloorArea,
            this.branchCompanyId
         );
      }

      @Override
      public String toString() {
         return "ContractFixedAssetsDepreciationSaveDtoParam.ContractFixedAssetsDepreciationSaveDtoParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", originalValue="
            + this.originalValue
            + ", depreciationYear="
            + this.depreciationYear
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", residualValueRate="
            + this.residualValueRate
            + ", grossFloorArea="
            + this.grossFloorArea
            + ", branchCompanyId="
            + this.branchCompanyId
            + ")";
      }
   }
}
