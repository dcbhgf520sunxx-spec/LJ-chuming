package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.finance.WaterElectricityEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ContractWaterElectricity对象", description = "水电费用表 ")
public class ContractWaterElectricityDtoParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "type", value = "类型 1水费 2电费", notes = "类型 1水费 2电费")
   @NotNull(message = "费用类型不能为空")
   @EnumValidator(value = WaterElectricityEnum.class, message = "水电费类型错误")
   private Integer type;
   @ApiModelProperty(name = "year", value = "年度 (例:2022)", notes = "年度 (例:2022)")
   @NotNull(message = "年份不能为空")
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份(1~12)", notes = "月份(1~12)")
   @NotNull(message = "月份不能为空")
   @Max(12L)
   @Min(1L)
   private Integer month;
   @ApiModelProperty(name = "childType", value = "子分类 水费:暂不分类(默认0); 电费:1工业用电 2民用用电;", notes = "子分类 水费:暂不分类(默认0); 电费:1工业用电 2民用用电;")
   private Integer childType;
   @ApiModelProperty(name = "usedMete", value = "用量 单位(水:吨; 电:kw/h-度)", notes = "用量 单位(水:吨; 电:kw/h-度)")
   @NotNull(message = "使用量不能为空")
   @Min(0L)
   private BigDecimal usedMete;
   @ApiModelProperty(name = "totalAmount", value = "费用总额(元)", notes = "费用总额(元)")
   @NotNull(message = "费用总额不能为空")
   @Min(0L)
   private BigDecimal totalAmount;

   public static ContractWaterElectricityDtoParam.ContractWaterElectricityDtoParamBuilder builder() {
      return new ContractWaterElectricityDtoParam.ContractWaterElectricityDtoParamBuilder();
   }

   public ContractWaterElectricityDtoParam() {
   }

   public ContractWaterElectricityDtoParam(
      final Long id,
      final Integer type,
      final Integer year,
      final Integer month,
      final Integer childType,
      final BigDecimal usedMete,
      final BigDecimal totalAmount
   ) {
      this.id = id;
      this.type = type;
      this.year = year;
      this.month = month;
      this.childType = childType;
      this.usedMete = usedMete;
      this.totalAmount = totalAmount;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getMonth() {
      return this.month;
   }

   public Integer getChildType() {
      return this.childType;
   }

   public BigDecimal getUsedMete() {
      return this.usedMete;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setChildType(final Integer childType) {
      this.childType = childType;
   }

   public void setUsedMete(final BigDecimal usedMete) {
      this.usedMete = usedMete;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWaterElectricityDtoParam)) {
         return false;
      }

      ContractWaterElectricityDtoParam other = (ContractWaterElectricityDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$year = this.getYear();
            Object other$year = other.getYear();
            if (this$year == null ? other$year == null : this$year.equals(other$year)) {
               Object this$month = this.getMonth();
               Object other$month = other.getMonth();
               if (this$month == null ? other$month == null : this$month.equals(other$month)) {
                  Object this$childType = this.getChildType();
                  Object other$childType = other.getChildType();
                  if (this$childType == null ? other$childType == null : this$childType.equals(other$childType)) {
                     Object this$usedMete = this.getUsedMete();
                     Object other$usedMete = other.getUsedMete();
                     if (this$usedMete == null ? other$usedMete == null : this$usedMete.equals(other$usedMete)) {
                        Object this$totalAmount = this.getTotalAmount();
                        Object other$totalAmount = other.getTotalAmount();
                        return this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount);
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
      return other instanceof ContractWaterElectricityDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $childType = this.getChildType();
      result = result * 59 + ($childType == null ? 43 : $childType.hashCode());
      Object $usedMete = this.getUsedMete();
      result = result * 59 + ($usedMete == null ? 43 : $usedMete.hashCode());
      Object $totalAmount = this.getTotalAmount();
      return result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWaterElectricityDtoParam(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", childType="
         + this.getChildType()
         + ", usedMete="
         + this.getUsedMete()
         + ", totalAmount="
         + this.getTotalAmount()
         + ")";
   }

   public static class ContractWaterElectricityDtoParamBuilder {
      private Long id;
      private Integer type;
      private Integer year;
      private Integer month;
      private Integer childType;
      private BigDecimal usedMete;
      private BigDecimal totalAmount;

      ContractWaterElectricityDtoParamBuilder() {
      }

      public ContractWaterElectricityDtoParam.ContractWaterElectricityDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWaterElectricityDtoParam.ContractWaterElectricityDtoParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractWaterElectricityDtoParam.ContractWaterElectricityDtoParamBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractWaterElectricityDtoParam.ContractWaterElectricityDtoParamBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractWaterElectricityDtoParam.ContractWaterElectricityDtoParamBuilder childType(final Integer childType) {
         this.childType = childType;
         return this;
      }

      public ContractWaterElectricityDtoParam.ContractWaterElectricityDtoParamBuilder usedMete(final BigDecimal usedMete) {
         this.usedMete = usedMete;
         return this;
      }

      public ContractWaterElectricityDtoParam.ContractWaterElectricityDtoParamBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public ContractWaterElectricityDtoParam build() {
         return new ContractWaterElectricityDtoParam(this.id, this.type, this.year, this.month, this.childType, this.usedMete, this.totalAmount);
      }

      @Override
      public String toString() {
         return "ContractWaterElectricityDtoParam.ContractWaterElectricityDtoParamBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", childType="
            + this.childType
            + ", usedMete="
            + this.usedMete
            + ", totalAmount="
            + this.totalAmount
            + ")";
      }
   }
}
