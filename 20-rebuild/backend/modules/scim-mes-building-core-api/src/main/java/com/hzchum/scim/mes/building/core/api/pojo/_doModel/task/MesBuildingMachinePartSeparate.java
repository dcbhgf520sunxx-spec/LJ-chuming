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

@ApiModel(value = "MesBuildingMachinePartSeparate对象", description = "零件分拣单")
@Entity
@TableName("mes_building_machine_part_separate")
@Table(name = "mes_building_machine_part_separate")
public class MesBuildingMachinePartSeparate extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "分配数量", notes = "分配数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '分配数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20)  COMMENT '排产id'", nullable = false)
   private Long schedulingId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20) default '0' COMMENT '任务工单id'")
   private Long taskOrderId;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'")
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20)  COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "cunQuantity", value = "统计数量", notes = "统计数量")
   @JsonProperty("cunQuantity")
   @JSONField(name = "cunQuantity")
   @TableField("cun_quantity")
   @Column(name = "cun_quantity", columnDefinition = "int(11) default '0' COMMENT '统计数量'", nullable = false)
   private Integer cunQuantity;

   public static MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder builder() {
      return new MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder();
   }

   public MesBuildingMachinePartSeparate() {
   }

   public MesBuildingMachinePartSeparate(
      final Long id,
      final Long productId,
      final Integer quantity,
      final Long schedulingId,
      final Long userId,
      final Long taskOrderId,
      final Long taskId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Integer cunQuantity
   ) {
      this.id = id;
      this.productId = productId;
      this.quantity = quantity;
      this.schedulingId = schedulingId;
      this.userId = userId;
      this.taskOrderId = taskOrderId;
      this.taskId = taskId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.cunQuantity = cunQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Integer getCunQuantity() {
      return this.cunQuantity;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartSeparate setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingMachinePartSeparate setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartSeparate setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingMachinePartSeparate setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingMachinePartSeparate setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingMachinePartSeparate setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingMachinePartSeparate setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingMachinePartSeparate setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingMachinePartSeparate setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingMachinePartSeparate setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("cunQuantity")
   public MesBuildingMachinePartSeparate setCunQuantity(final Integer cunQuantity) {
      this.cunQuantity = cunQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSeparate(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", userId="
         + this.getUserId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", taskId="
         + this.getTaskId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", cunQuantity="
         + this.getCunQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSeparate)) {
         return false;
      }

      MesBuildingMachinePartSeparate other = (MesBuildingMachinePartSeparate)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$schedulingId = this.getSchedulingId();
               Object other$schedulingId = other.getSchedulingId();
               if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$taskOrderId = this.getTaskOrderId();
                     Object other$taskOrderId = other.getTaskOrderId();
                     if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                        Object this$taskId = this.getTaskId();
                        Object other$taskId = other.getTaskId();
                        if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                           Object this$workshopId = this.getWorkshopId();
                           Object other$workshopId = other.getWorkshopId();
                           if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                              Object this$productionLineId = this.getProductionLineId();
                              Object other$productionLineId = other.getProductionLineId();
                              if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                                 Object this$groupsId = this.getGroupsId();
                                 Object other$groupsId = other.getGroupsId();
                                 if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                                    Object this$cunQuantity = this.getCunQuantity();
                                    Object other$cunQuantity = other.getCunQuantity();
                                    return this$cunQuantity == null ? other$cunQuantity == null : this$cunQuantity.equals(other$cunQuantity);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingMachinePartSeparate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $cunQuantity = this.getCunQuantity();
      return result * 59 + ($cunQuantity == null ? 43 : $cunQuantity.hashCode());
   }

   public static class MesBuildingMachinePartSeparateBuilder {
      private Long id;
      private Long productId;
      private Integer quantity;
      private Long schedulingId;
      private Long userId;
      private Long taskOrderId;
      private Long taskId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Integer cunQuantity;

      MesBuildingMachinePartSeparateBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("cunQuantity")
      public MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder cunQuantity(final Integer cunQuantity) {
         this.cunQuantity = cunQuantity;
         return this;
      }

      public MesBuildingMachinePartSeparate build() {
         return new MesBuildingMachinePartSeparate(
            this.id,
            this.productId,
            this.quantity,
            this.schedulingId,
            this.userId,
            this.taskOrderId,
            this.taskId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.cunQuantity
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSeparate.MesBuildingMachinePartSeparateBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", schedulingId="
            + this.schedulingId
            + ", userId="
            + this.userId
            + ", taskOrderId="
            + this.taskOrderId
            + ", taskId="
            + this.taskId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", cunQuantity="
            + this.cunQuantity
            + ")";
      }
   }
}
