package com.hzchum.scim.contract.core.api.pojo._do.finance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractWaterElectricity对象", description = "水电费用表 ")
@Entity
@TableName("contract_water_electricity")
@Table(name = "contract_water_electricity")
@org.hibernate.annotations.Table(appliesTo = "contract_water_electricity", comment = "水电费用表 ")
public class ContractWaterElectricity extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "type", value = "类型 1水费 2电费", notes = "类型 1水费 2电费")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '类型 1水费 2电费'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "year", value = "年度 (例:2022)", notes = "年度 (例:2022)")
   @TableField("year")
   @Column(name = "year", columnDefinition = "int(11)  COMMENT '年度 (例:2022)'", nullable = false)
   private Integer year;
   @ApiModelProperty(name = "month", value = "月份(1~12)", notes = "月份(1~12)")
   @TableField("month")
   @Column(name = "month", columnDefinition = "int(11)  COMMENT '月份(1~12)'", nullable = false)
   private Integer month;
   @ApiModelProperty(name = "yearMonthValue", value = "年月(格式 202208)", notes = "年月(格式 202208)")
   @TableField("year_month_value")
   @Column(name = "year_month_value", columnDefinition = "int(11)  COMMENT '年月(格式 202208)'", nullable = false)
   private Integer yearMonthValue;
   @ApiModelProperty(name = "childType", value = "子分类 水费:暂不分类(默认0); 电费:1工业用电 2民用用电;", notes = "子分类 水费:暂不分类(默认0); 电费:1工业用电 2民用用电;")
   @TableField("child_type")
   @Column(name = "child_type", columnDefinition = "int(11) default '0' COMMENT '子分类 水费:暂不分类(默认0); 电费:1工业用电 2民用用电;'", nullable = false)
   private Integer childType;
   @ApiModelProperty(name = "usedMete", value = "用量 单位(水:吨; 电:kw/h-度)", notes = "用量 单位(水:吨; 电:kw/h-度)")
   @TableField("used_mete")
   @Column(name = "used_mete", columnDefinition = "decimal(32,8)  COMMENT '用量 单位(水:吨; 电:kw/h-度)'", nullable = false)
   private BigDecimal usedMete;
   @ApiModelProperty(name = "totalAmount", value = "费用总额(元)", notes = "费用总额(元)")
   @TableField("total_amount")
   @Column(name = "total_amount", columnDefinition = "decimal(32,8)  COMMENT '费用总额(元)'", nullable = false)
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "userId", value = "录入人ID", notes = "录入人ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '录入人ID'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "boolConfirmStatus", value = "确认状态 0未确认 1已确认", notes = "确认状态 0未确认 1已确认")
   @TableField("bool_confirm_status")
   @Column(name = "bool_confirm_status", columnDefinition = "tinyint(1) default '0' COMMENT '确认状态 0未确认 1已确认'", nullable = false)
   private Boolean boolConfirmStatus;

   public static ContractWaterElectricity.ContractWaterElectricityBuilder builder() {
      return new ContractWaterElectricity.ContractWaterElectricityBuilder();
   }

   public ContractWaterElectricity() {
   }

   public ContractWaterElectricity(
      final Long id,
      final Integer type,
      final Integer year,
      final Integer month,
      final Integer yearMonthValue,
      final Integer childType,
      final BigDecimal usedMete,
      final BigDecimal totalAmount,
      final Long userId,
      final Boolean boolConfirmStatus
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
      this.boolConfirmStatus = boolConfirmStatus;
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

   public Boolean getBoolConfirmStatus() {
      return this.boolConfirmStatus;
   }

   public ContractWaterElectricity setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractWaterElectricity setType(final Integer type) {
      this.type = type;
      return this;
   }

   public ContractWaterElectricity setYear(final Integer year) {
      this.year = year;
      return this;
   }

   public ContractWaterElectricity setMonth(final Integer month) {
      this.month = month;
      return this;
   }

   public ContractWaterElectricity setYearMonthValue(final Integer yearMonthValue) {
      this.yearMonthValue = yearMonthValue;
      return this;
   }

   public ContractWaterElectricity setChildType(final Integer childType) {
      this.childType = childType;
      return this;
   }

   public ContractWaterElectricity setUsedMete(final BigDecimal usedMete) {
      this.usedMete = usedMete;
      return this;
   }

   public ContractWaterElectricity setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
      return this;
   }

   public ContractWaterElectricity setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractWaterElectricity setBoolConfirmStatus(final Boolean boolConfirmStatus) {
      this.boolConfirmStatus = boolConfirmStatus;
      return this;
   }

   @Override
   public String toString() {
      return "ContractWaterElectricity(id="
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
         + ", boolConfirmStatus="
         + this.getBoolConfirmStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWaterElectricity)) {
         return false;
      }

      ContractWaterElectricity other = (ContractWaterElectricity)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                           Object this$boolConfirmStatus = this.getBoolConfirmStatus();
                           Object other$boolConfirmStatus = other.getBoolConfirmStatus();
                           if (this$boolConfirmStatus == null ? other$boolConfirmStatus == null : this$boolConfirmStatus.equals(other$boolConfirmStatus)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractWaterElectricity;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      Object $boolConfirmStatus = this.getBoolConfirmStatus();
      result = result * 59 + ($boolConfirmStatus == null ? 43 : $boolConfirmStatus.hashCode());
      Object $usedMete = this.getUsedMete();
      result = result * 59 + ($usedMete == null ? 43 : $usedMete.hashCode());
      Object $totalAmount = this.getTotalAmount();
      return result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
   }

   public static class ContractWaterElectricityBuilder {
      private Long id;
      private Integer type;
      private Integer year;
      private Integer month;
      private Integer yearMonthValue;
      private Integer childType;
      private BigDecimal usedMete;
      private BigDecimal totalAmount;
      private Long userId;
      private Boolean boolConfirmStatus;

      ContractWaterElectricityBuilder() {
      }

      public ContractWaterElectricity.ContractWaterElectricityBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractWaterElectricity.ContractWaterElectricityBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractWaterElectricity.ContractWaterElectricityBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ContractWaterElectricity.ContractWaterElectricityBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ContractWaterElectricity.ContractWaterElectricityBuilder yearMonthValue(final Integer yearMonthValue) {
         this.yearMonthValue = yearMonthValue;
         return this;
      }

      public ContractWaterElectricity.ContractWaterElectricityBuilder childType(final Integer childType) {
         this.childType = childType;
         return this;
      }

      public ContractWaterElectricity.ContractWaterElectricityBuilder usedMete(final BigDecimal usedMete) {
         this.usedMete = usedMete;
         return this;
      }

      public ContractWaterElectricity.ContractWaterElectricityBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public ContractWaterElectricity.ContractWaterElectricityBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractWaterElectricity.ContractWaterElectricityBuilder boolConfirmStatus(final Boolean boolConfirmStatus) {
         this.boolConfirmStatus = boolConfirmStatus;
         return this;
      }

      public ContractWaterElectricity build() {
         return new ContractWaterElectricity(
            this.id,
            this.type,
            this.year,
            this.month,
            this.yearMonthValue,
            this.childType,
            this.usedMete,
            this.totalAmount,
            this.userId,
            this.boolConfirmStatus
         );
      }

      @Override
      public String toString() {
         return "ContractWaterElectricity.ContractWaterElectricityBuilder(id="
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
            + ", boolConfirmStatus="
            + this.boolConfirmStatus
            + ")";
      }
   }
}
