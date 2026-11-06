package com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingMachinePartSchedulingLinkMonth对象", description = "")
@Entity
@TableName("mes_building_machine_part_scheduling_link_month")
@Table(name = "mes_building_machine_part_scheduling_link_month")
public class MesBuildingMachinePartSchedulingLinkMonth extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20)  COMMENT '排产id'", nullable = false)
   private Long schedulingId;
   @ApiModelProperty(name = "schedulingLinkId", value = "零件排产关联表id", notes = "零件排产关联表id")
   @JsonProperty("schedulingLinkId")
   @JSONField(name = "schedulingLinkId")
   @TableField("scheduling_link_id")
   @Column(name = "scheduling_link_id", columnDefinition = "bigint(20)  COMMENT '零件排产关联表id'", nullable = false)
   private Long schedulingLinkId;
   @ApiModelProperty(name = "needLinkId", value = "需要排产关联表id", notes = "需要排产关联表id")
   @JsonProperty("needLinkId")
   @JSONField(name = "needLinkId")
   @TableField("need_link_id")
   @Column(name = "need_link_id", columnDefinition = "bigint(20)  COMMENT '需要排产关联表id'", nullable = false)
   private Long needLinkId;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '排产数量'", nullable = false)
   private Integer quantity;

   public static MesBuildingMachinePartSchedulingLinkMonth.MesBuildingMachinePartSchedulingLinkMonthBuilder builder() {
      return new MesBuildingMachinePartSchedulingLinkMonth.MesBuildingMachinePartSchedulingLinkMonthBuilder();
   }

   public MesBuildingMachinePartSchedulingLinkMonth() {
   }

   public MesBuildingMachinePartSchedulingLinkMonth(
      final Long id, final Long schedulingId, final Long schedulingLinkId, final Long needLinkId, final Integer quantity
   ) {
      this.id = id;
      this.schedulingId = schedulingId;
      this.schedulingLinkId = schedulingLinkId;
      this.needLinkId = needLinkId;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getSchedulingLinkId() {
      return this.schedulingLinkId;
   }

   public Long getNeedLinkId() {
      return this.needLinkId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartSchedulingLinkMonth setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingMachinePartSchedulingLinkMonth setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("schedulingLinkId")
   public MesBuildingMachinePartSchedulingLinkMonth setSchedulingLinkId(final Long schedulingLinkId) {
      this.schedulingLinkId = schedulingLinkId;
      return this;
   }

   @JsonProperty("needLinkId")
   public MesBuildingMachinePartSchedulingLinkMonth setNeedLinkId(final Long needLinkId) {
      this.needLinkId = needLinkId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartSchedulingLinkMonth setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSchedulingLinkMonth(id="
         + this.getId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", schedulingLinkId="
         + this.getSchedulingLinkId()
         + ", needLinkId="
         + this.getNeedLinkId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSchedulingLinkMonth)) {
         return false;
      }

      MesBuildingMachinePartSchedulingLinkMonth other = (MesBuildingMachinePartSchedulingLinkMonth)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$schedulingId = this.getSchedulingId();
         Object other$schedulingId = other.getSchedulingId();
         if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
            Object this$schedulingLinkId = this.getSchedulingLinkId();
            Object other$schedulingLinkId = other.getSchedulingLinkId();
            if (this$schedulingLinkId == null ? other$schedulingLinkId == null : this$schedulingLinkId.equals(other$schedulingLinkId)) {
               Object this$needLinkId = this.getNeedLinkId();
               Object other$needLinkId = other.getNeedLinkId();
               if (this$needLinkId == null ? other$needLinkId == null : this$needLinkId.equals(other$needLinkId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof MesBuildingMachinePartSchedulingLinkMonth;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $schedulingLinkId = this.getSchedulingLinkId();
      result = result * 59 + ($schedulingLinkId == null ? 43 : $schedulingLinkId.hashCode());
      Object $needLinkId = this.getNeedLinkId();
      result = result * 59 + ($needLinkId == null ? 43 : $needLinkId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class MesBuildingMachinePartSchedulingLinkMonthBuilder {
      private Long id;
      private Long schedulingId;
      private Long schedulingLinkId;
      private Long needLinkId;
      private Integer quantity;

      MesBuildingMachinePartSchedulingLinkMonthBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartSchedulingLinkMonth.MesBuildingMachinePartSchedulingLinkMonthBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingMachinePartSchedulingLinkMonth.MesBuildingMachinePartSchedulingLinkMonthBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("schedulingLinkId")
      public MesBuildingMachinePartSchedulingLinkMonth.MesBuildingMachinePartSchedulingLinkMonthBuilder schedulingLinkId(final Long schedulingLinkId) {
         this.schedulingLinkId = schedulingLinkId;
         return this;
      }

      @JsonProperty("needLinkId")
      public MesBuildingMachinePartSchedulingLinkMonth.MesBuildingMachinePartSchedulingLinkMonthBuilder needLinkId(final Long needLinkId) {
         this.needLinkId = needLinkId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartSchedulingLinkMonth.MesBuildingMachinePartSchedulingLinkMonthBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingMachinePartSchedulingLinkMonth build() {
         return new MesBuildingMachinePartSchedulingLinkMonth(this.id, this.schedulingId, this.schedulingLinkId, this.needLinkId, this.quantity);
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSchedulingLinkMonth.MesBuildingMachinePartSchedulingLinkMonthBuilder(id="
            + this.id
            + ", schedulingId="
            + this.schedulingId
            + ", schedulingLinkId="
            + this.schedulingLinkId
            + ", needLinkId="
            + this.needLinkId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
