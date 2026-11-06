package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "InventoryUseStatisticsDate对象", description = "库存使用统计时间段")
@Entity
@TableName("wms_inventory_use_statistics_date")
@Table(name = "wms_inventory_use_statistics_date")
public class InventoryUseStatisticsDate extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "本次结存名称", notes = "本次结存名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '本次结存名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "startTime", value = "开始时间", notes = "开始时间")
   @JsonProperty("startTime")
   @JSONField(name = "startTime")
   @TableField("start_time")
   @Column(name = "start_time", columnDefinition = "datetime(6)  COMMENT '开始时间'", nullable = true)
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "结束时间", notes = "结束时间")
   @JsonProperty("endTime")
   @JSONField(name = "endTime")
   @TableField("end_time")
   @Column(name = "end_time", columnDefinition = "datetime(6)  COMMENT '结束时间'", nullable = true)
   private LocalDateTime endTime;
   @ApiModelProperty(name = "boolBalance", value = "是否结存", notes = "是否结存")
   @JsonProperty("boolBalance")
   @JSONField(name = "boolBalance")
   @TableField("bool_balance")
   @Column(name = "bool_balance", columnDefinition = "tinyint(1) default'0' COMMENT '是否结存'", nullable = true)
   private Boolean boolBalance;

   public static InventoryUseStatisticsDate.InventoryUseStatisticsDateBuilder builder() {
      return new InventoryUseStatisticsDate.InventoryUseStatisticsDateBuilder();
   }

   public InventoryUseStatisticsDate() {
   }

   public InventoryUseStatisticsDate(final Long id, final String name, final LocalDateTime startTime, final LocalDateTime endTime, final Boolean boolBalance) {
      this.id = id;
      this.name = name;
      this.startTime = startTime;
      this.endTime = endTime;
      this.boolBalance = boolBalance;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public Boolean getBoolBalance() {
      return this.boolBalance;
   }

   @JsonProperty("id")
   public InventoryUseStatisticsDate setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public InventoryUseStatisticsDate setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("startTime")
   public InventoryUseStatisticsDate setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   @JsonProperty("endTime")
   public InventoryUseStatisticsDate setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
      return this;
   }

   @JsonProperty("boolBalance")
   public InventoryUseStatisticsDate setBoolBalance(final Boolean boolBalance) {
      this.boolBalance = boolBalance;
      return this;
   }

   @Override
   public String toString() {
      return "InventoryUseStatisticsDate(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", boolBalance="
         + this.getBoolBalance()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryUseStatisticsDate)) {
         return false;
      }

      InventoryUseStatisticsDate other = (InventoryUseStatisticsDate)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolBalance = this.getBoolBalance();
         Object other$boolBalance = other.getBoolBalance();
         if (this$boolBalance == null ? other$boolBalance == null : this$boolBalance.equals(other$boolBalance)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$startTime = this.getStartTime();
               Object other$startTime = other.getStartTime();
               if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                  Object this$endTime = this.getEndTime();
                  Object other$endTime = other.getEndTime();
                  return this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime);
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
      return other instanceof InventoryUseStatisticsDate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolBalance = this.getBoolBalance();
      result = result * 59 + ($boolBalance == null ? 43 : $boolBalance.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   public static class InventoryUseStatisticsDateBuilder {
      private Long id;
      private String name;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private Boolean boolBalance;

      InventoryUseStatisticsDateBuilder() {
      }

      @JsonProperty("id")
      public InventoryUseStatisticsDate.InventoryUseStatisticsDateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public InventoryUseStatisticsDate.InventoryUseStatisticsDateBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("startTime")
      public InventoryUseStatisticsDate.InventoryUseStatisticsDateBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      @JsonProperty("endTime")
      public InventoryUseStatisticsDate.InventoryUseStatisticsDateBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      @JsonProperty("boolBalance")
      public InventoryUseStatisticsDate.InventoryUseStatisticsDateBuilder boolBalance(final Boolean boolBalance) {
         this.boolBalance = boolBalance;
         return this;
      }

      public InventoryUseStatisticsDate build() {
         return new InventoryUseStatisticsDate(this.id, this.name, this.startTime, this.endTime, this.boolBalance);
      }

      @Override
      public String toString() {
         return "InventoryUseStatisticsDate.InventoryUseStatisticsDateBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", boolBalance="
            + this.boolBalance
            + ")";
      }
   }
}
