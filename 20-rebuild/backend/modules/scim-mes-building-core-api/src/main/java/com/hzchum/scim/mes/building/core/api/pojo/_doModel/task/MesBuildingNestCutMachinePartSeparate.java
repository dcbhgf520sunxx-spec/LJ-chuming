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

@ApiModel(value = "MesBuildingNestCutMachinePartSeparate对象", description = "")
@Entity
@TableName("mes_building_nest_cut_machine_part_separate")
@Table(name = "mes_building_nest_cut_machine_part_separate")
public class MesBuildingNestCutMachinePartSeparate extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '排产数量'", nullable = false)
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
   @Column(name = "task_order_id", columnDefinition = "bigint(20)  COMMENT '任务工单id'", nullable = false)
   private Long taskOrderId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = true)
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20)  COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "nestCutId", value = "切割指令id", notes = "切割指令id")
   @JsonProperty("nestCutId")
   @JSONField(name = "nestCutId")
   @TableField("nest_cut_id")
   @Column(name = "nest_cut_id", columnDefinition = "bigint(20)  COMMENT '切割指令id'", nullable = true)
   private Long nestCutId;
   @ApiModelProperty(name = "processType", value = "工序类型", notes = "工序类型")
   @JsonProperty("processType")
   @JSONField(name = "processType")
   @TableField("process_type")
   @Column(name = "process_type", columnDefinition = "int(11)  COMMENT '工序类型'")
   private Integer processType;

   public static MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder builder() {
      return new MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder();
   }

   public MesBuildingNestCutMachinePartSeparate() {
   }

   public MesBuildingNestCutMachinePartSeparate(
      final Long id,
      final Long productId,
      final Integer quantity,
      final Long schedulingId,
      final Long userId,
      final Long taskOrderId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Long nestCutId,
      final Integer processType
   ) {
      this.id = id;
      this.productId = productId;
      this.quantity = quantity;
      this.schedulingId = schedulingId;
      this.userId = userId;
      this.taskOrderId = taskOrderId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.nestCutId = nestCutId;
      this.processType = processType;
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

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getNestCutId() {
      return this.nestCutId;
   }

   public Integer getProcessType() {
      return this.processType;
   }

   @JsonProperty("id")
   public MesBuildingNestCutMachinePartSeparate setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingNestCutMachinePartSeparate setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingNestCutMachinePartSeparate setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingNestCutMachinePartSeparate setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingNestCutMachinePartSeparate setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingNestCutMachinePartSeparate setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingNestCutMachinePartSeparate setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingNestCutMachinePartSeparate setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingNestCutMachinePartSeparate setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("nestCutId")
   public MesBuildingNestCutMachinePartSeparate setNestCutId(final Long nestCutId) {
      this.nestCutId = nestCutId;
      return this;
   }

   @JsonProperty("processType")
   public MesBuildingNestCutMachinePartSeparate setProcessType(final Integer processType) {
      this.processType = processType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestCutMachinePartSeparate(id="
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
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", nestCutId="
         + this.getNestCutId()
         + ", processType="
         + this.getProcessType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestCutMachinePartSeparate)) {
         return false;
      }

      MesBuildingNestCutMachinePartSeparate other = (MesBuildingNestCutMachinePartSeparate)o;
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
                        Object this$workshopId = this.getWorkshopId();
                        Object other$workshopId = other.getWorkshopId();
                        if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                           Object this$productionLineId = this.getProductionLineId();
                           Object other$productionLineId = other.getProductionLineId();
                           if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                              Object this$groupsId = this.getGroupsId();
                              Object other$groupsId = other.getGroupsId();
                              if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                                 Object this$nestCutId = this.getNestCutId();
                                 Object other$nestCutId = other.getNestCutId();
                                 if (this$nestCutId == null ? other$nestCutId == null : this$nestCutId.equals(other$nestCutId)) {
                                    Object this$processType = this.getProcessType();
                                    Object other$processType = other.getProcessType();
                                    return this$processType == null ? other$processType == null : this$processType.equals(other$processType);
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
      return other instanceof MesBuildingNestCutMachinePartSeparate;
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
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $nestCutId = this.getNestCutId();
      result = result * 59 + ($nestCutId == null ? 43 : $nestCutId.hashCode());
      Object $processType = this.getProcessType();
      return result * 59 + ($processType == null ? 43 : $processType.hashCode());
   }

   public static class MesBuildingNestCutMachinePartSeparateBuilder {
      private Long id;
      private Long productId;
      private Integer quantity;
      private Long schedulingId;
      private Long userId;
      private Long taskOrderId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Long nestCutId;
      private Integer processType;

      MesBuildingNestCutMachinePartSeparateBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("nestCutId")
      public MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder nestCutId(final Long nestCutId) {
         this.nestCutId = nestCutId;
         return this;
      }

      @JsonProperty("processType")
      public MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      public MesBuildingNestCutMachinePartSeparate build() {
         return new MesBuildingNestCutMachinePartSeparate(
            this.id,
            this.productId,
            this.quantity,
            this.schedulingId,
            this.userId,
            this.taskOrderId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.nestCutId,
            this.processType
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNestCutMachinePartSeparate.MesBuildingNestCutMachinePartSeparateBuilder(id="
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
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", nestCutId="
            + this.nestCutId
            + ", processType="
            + this.processType
            + ")";
      }
   }
}
