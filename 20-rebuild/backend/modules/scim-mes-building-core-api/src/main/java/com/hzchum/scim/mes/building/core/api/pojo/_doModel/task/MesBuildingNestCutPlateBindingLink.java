package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

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

@ApiModel(value = "MesBuildingNestCutPlateBindingLink对象", description = "")
@Entity
@TableName("mes_building_nest_cut_plate_binding_link")
@Table(name = "mes_building_nest_cut_plate_binding_link")
public class MesBuildingNestCutPlateBindingLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "machinePartSchedulingId", value = "零件工单id", notes = "零件工单id")
   @JsonProperty("machinePartSchedulingId")
   @JSONField(name = "machinePartSchedulingId")
   @TableField("machine_part_scheduling_id")
   @Column(name = "machine_part_scheduling_id", columnDefinition = "bigint(20)  COMMENT '零件工单id'", nullable = false)
   private Long machinePartSchedulingId;
   @ApiModelProperty(name = "nestCutPlateId", value = "切割指令id", notes = "切割指令id")
   @JsonProperty("nestCutPlateId")
   @JSONField(name = "nestCutPlateId")
   @TableField("nest_cut_plate_id")
   @Column(name = "nest_cut_plate_id", columnDefinition = "bigint(20)  COMMENT '切割指令id'", nullable = true)
   private Long nestCutPlateId;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20) default '0' COMMENT '任务工单id'", nullable = true)
   private Long taskOrderId;
   @ApiModelProperty(name = "plateNo", value = "钢板编号", notes = "钢板编号")
   @JsonProperty("plateNo")
   @JSONField(name = "plateNo")
   @TableField("plate_no")
   @Column(name = "plate_no", columnDefinition = "varchar(255)  COMMENT '钢板编号'", nullable = true)
   private String plateNo;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = true)
   private Long userId;

   public static MesBuildingNestCutPlateBindingLink.MesBuildingNestCutPlateBindingLinkBuilder builder() {
      return new MesBuildingNestCutPlateBindingLink.MesBuildingNestCutPlateBindingLinkBuilder();
   }

   public MesBuildingNestCutPlateBindingLink() {
   }

   public MesBuildingNestCutPlateBindingLink(
      final Long id,
      final Long machinePartSchedulingId,
      final Long nestCutPlateId,
      final Long taskOrderId,
      final String plateNo,
      final Integer quantity,
      final Long userId
   ) {
      this.id = id;
      this.machinePartSchedulingId = machinePartSchedulingId;
      this.nestCutPlateId = nestCutPlateId;
      this.taskOrderId = taskOrderId;
      this.plateNo = plateNo;
      this.quantity = quantity;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMachinePartSchedulingId() {
      return this.machinePartSchedulingId;
   }

   public Long getNestCutPlateId() {
      return this.nestCutPlateId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getPlateNo() {
      return this.plateNo;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesBuildingNestCutPlateBindingLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("machinePartSchedulingId")
   public MesBuildingNestCutPlateBindingLink setMachinePartSchedulingId(final Long machinePartSchedulingId) {
      this.machinePartSchedulingId = machinePartSchedulingId;
      return this;
   }

   @JsonProperty("nestCutPlateId")
   public MesBuildingNestCutPlateBindingLink setNestCutPlateId(final Long nestCutPlateId) {
      this.nestCutPlateId = nestCutPlateId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingNestCutPlateBindingLink setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("plateNo")
   public MesBuildingNestCutPlateBindingLink setPlateNo(final String plateNo) {
      this.plateNo = plateNo;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingNestCutPlateBindingLink setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingNestCutPlateBindingLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestCutPlateBindingLink(id="
         + this.getId()
         + ", machinePartSchedulingId="
         + this.getMachinePartSchedulingId()
         + ", nestCutPlateId="
         + this.getNestCutPlateId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", plateNo="
         + this.getPlateNo()
         + ", quantity="
         + this.getQuantity()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestCutPlateBindingLink)) {
         return false;
      }

      MesBuildingNestCutPlateBindingLink other = (MesBuildingNestCutPlateBindingLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$machinePartSchedulingId = this.getMachinePartSchedulingId();
         Object other$machinePartSchedulingId = other.getMachinePartSchedulingId();
         if (this$machinePartSchedulingId == null ? other$machinePartSchedulingId == null : this$machinePartSchedulingId.equals(other$machinePartSchedulingId)) {
            Object this$nestCutPlateId = this.getNestCutPlateId();
            Object other$nestCutPlateId = other.getNestCutPlateId();
            if (this$nestCutPlateId == null ? other$nestCutPlateId == null : this$nestCutPlateId.equals(other$nestCutPlateId)) {
               Object this$taskOrderId = this.getTaskOrderId();
               Object other$taskOrderId = other.getTaskOrderId();
               if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$plateNo = this.getPlateNo();
                        Object other$plateNo = other.getPlateNo();
                        return this$plateNo == null ? other$plateNo == null : this$plateNo.equals(other$plateNo);
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
      return other instanceof MesBuildingNestCutPlateBindingLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $machinePartSchedulingId = this.getMachinePartSchedulingId();
      result = result * 59 + ($machinePartSchedulingId == null ? 43 : $machinePartSchedulingId.hashCode());
      Object $nestCutPlateId = this.getNestCutPlateId();
      result = result * 59 + ($nestCutPlateId == null ? 43 : $nestCutPlateId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $plateNo = this.getPlateNo();
      return result * 59 + ($plateNo == null ? 43 : $plateNo.hashCode());
   }

   public static class MesBuildingNestCutPlateBindingLinkBuilder {
      private Long id;
      private Long machinePartSchedulingId;
      private Long nestCutPlateId;
      private Long taskOrderId;
      private String plateNo;
      private Integer quantity;
      private Long userId;

      MesBuildingNestCutPlateBindingLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNestCutPlateBindingLink.MesBuildingNestCutPlateBindingLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("machinePartSchedulingId")
      public MesBuildingNestCutPlateBindingLink.MesBuildingNestCutPlateBindingLinkBuilder machinePartSchedulingId(final Long machinePartSchedulingId) {
         this.machinePartSchedulingId = machinePartSchedulingId;
         return this;
      }

      @JsonProperty("nestCutPlateId")
      public MesBuildingNestCutPlateBindingLink.MesBuildingNestCutPlateBindingLinkBuilder nestCutPlateId(final Long nestCutPlateId) {
         this.nestCutPlateId = nestCutPlateId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingNestCutPlateBindingLink.MesBuildingNestCutPlateBindingLinkBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("plateNo")
      public MesBuildingNestCutPlateBindingLink.MesBuildingNestCutPlateBindingLinkBuilder plateNo(final String plateNo) {
         this.plateNo = plateNo;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingNestCutPlateBindingLink.MesBuildingNestCutPlateBindingLinkBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingNestCutPlateBindingLink.MesBuildingNestCutPlateBindingLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingNestCutPlateBindingLink build() {
         return new MesBuildingNestCutPlateBindingLink(
            this.id, this.machinePartSchedulingId, this.nestCutPlateId, this.taskOrderId, this.plateNo, this.quantity, this.userId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNestCutPlateBindingLink.MesBuildingNestCutPlateBindingLinkBuilder(id="
            + this.id
            + ", machinePartSchedulingId="
            + this.machinePartSchedulingId
            + ", nestCutPlateId="
            + this.nestCutPlateId
            + ", taskOrderId="
            + this.taskOrderId
            + ", plateNo="
            + this.plateNo
            + ", quantity="
            + this.quantity
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
