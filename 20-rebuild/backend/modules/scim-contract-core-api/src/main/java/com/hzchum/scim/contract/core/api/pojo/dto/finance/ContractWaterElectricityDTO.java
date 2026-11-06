package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ContractWaterElectricity对象", description = "水电费用表 ")
public class ContractWaterElectricityDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "type", value = "类型 1水费 2电费", notes = "类型 1水费 2电费")
   private Integer type;
   @ApiModelProperty(name = "year", value = "年度 (例:2022)", notes = "年度 (例:2022)")
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份(1~12)", notes = "月份(1~12)")
   private Integer month;
   @ApiModelProperty(name = "yearMonthValue", value = "年月(格式 202208)", notes = "年月(格式 202208)")
   private Integer yearMonthValue;
   @ApiModelProperty(name = "childType", value = "子分类 水费:暂不分类(默认0); 电费:1工业用电 2民用用电;", notes = "子分类 水费:暂不分类(默认0); 电费:1工业用电 2民用用电;")
   private Integer childType;
   @ApiModelProperty(name = "usedMete", value = "用量 单位(水:吨; 电:kw/h-度)", notes = "用量 单位(水:吨; 电:kw/h-度)")
   private BigDecimal usedMete;
   @ApiModelProperty(name = "totalAmount", value = "费用总额(元)", notes = "费用总额(元)")
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "userId", value = "录入人ID", notes = "录入人ID")
   private Long userId;

   public static ContractWaterElectricityDTO.ContractWaterElectricityDTOBuilder builder() {
      return new ContractWaterElectricityDTO.ContractWaterElectricityDTOBuilder();
   }

   public ContractWaterElectricityDTO() {
   }

   public ContractWaterElectricityDTO(
      final Long id,
      final Integer type,
      final Integer year,
      final Integer month,
      final Integer yearMonthValue,
      final Integer childType,
      final BigDecimal usedMete,
      final BigDecimal totalAmount,
      final Long userId
   ) {
      this.id = id;
      this.type = type;
      this.year = year;
      this.month = month;
      this.yearMonthValue = yearMonthValue;
      this.childType = childType;
      this.usedMete = usedMete;
      this.totalAmount = totalAmount;
      this.userId = userId;
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

   public Integer getYearMonthValue() {
      return this.yearMonthValue;
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

   public Long getUserId() {
      return this.userId;
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

   public void setYearMonthValue(final Integer yearMonthValue) {
      this.yearMonthValue = yearMonthValue;
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

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWaterElectricityDTO)) {
         return false;
      }

      ContractWaterElectricityDTO other = (ContractWaterElectricityDTO)o;
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
                  Object this$yearMonthValue = this.getYearMonthValue();
                  Object other$yearMonthValue = other.getYearMonthValue();
                  if (this$yearMonthValue == null ? other$yearMonthValue == null : this$yearMonthValue.equals(other$yearMonthValue)) {
                     Object this$childType = this.getChildType();
                     Object other$childType = other.getChildType();
                     if (this$childType == null ? other$childType == null : this$childType.equals(other$childType)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractWaterElectricityDTO;
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
      Object $yearMonthValue = this.getYearMonthValue();
      result = result * 59 + ($yearMonthValue == null ? 43 : $yearMonthValue.hashCode());
      Object $childType = this.getChildType();
      result = result * 59 + ($childType == null ? 43 : $childType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $usedMete = this.getUsedMete();
      result = result * 59 + ($usedMete == null ? 43 : $usedMete.hashCode());
      Object $totalAmount = this.getTotalAmount();
      return result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWaterElectricityDTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", yearMonthValue="
         + this.getYearMonthValue()
         + ", childType="
         + this.getChildType()
         + ", usedMete="
         + this.getUsedMete()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   public static class ContractWaterElectricityDTOBuilder {
      private Long id;
      private Integer type;
      private Integer year;
      private Integer month;
      private Integer yearMonthValue;
      private Integer childType;
      private BigDecimal usedMete;
      private BigDecimal totalAmount;
      private Long userId;

      ContractWaterElectricityDTOBuilder() {
      }

      public ContractWaterElectricityDTO.ContractWaterElectricityDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWaterElectricityDTO.ContractWaterElectricityDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractWaterElectricityDTO.ContractWaterElectricityDTOBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractWaterElectricityDTO.ContractWaterElectricityDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractWaterElectricityDTO.ContractWaterElectricityDTOBuilder yearMonthValue(final Integer yearMonthValue) {
         this.yearMonthValue = yearMonthValue;
         return this;
      }

      public ContractWaterElectricityDTO.ContractWaterElectricityDTOBuilder childType(final Integer childType) {
         this.childType = childType;
         return this;
      }

      public ContractWaterElectricityDTO.ContractWaterElectricityDTOBuilder usedMete(final BigDecimal usedMete) {
         this.usedMete = usedMete;
         return this;
      }

      public ContractWaterElectricityDTO.ContractWaterElectricityDTOBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public ContractWaterElectricityDTO.ContractWaterElectricityDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractWaterElectricityDTO build() {
         return new ContractWaterElectricityDTO(
            this.id, this.type, this.year, this.month, this.yearMonthValue, this.childType, this.usedMete, this.totalAmount, this.userId
         );
      }

      @Override
      public String toString() {
         return "ContractWaterElectricityDTO.ContractWaterElectricityDTOBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", year="
            + this.year
            + ", month="
            + this.month
            + ", yearMonthValue="
            + this.yearMonthValue
            + ", childType="
            + this.childType
            + ", usedMete="
            + this.usedMete
            + ", totalAmount="
            + this.totalAmount
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
