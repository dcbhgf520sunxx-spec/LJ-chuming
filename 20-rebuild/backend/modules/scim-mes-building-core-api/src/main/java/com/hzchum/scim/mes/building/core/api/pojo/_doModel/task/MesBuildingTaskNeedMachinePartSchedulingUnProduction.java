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

@ApiModel(value = "MesBuildingTaskNeedMachinePartSchedulingUnProduction对象", description = "")
@Entity
@TableName("mes_building_task_need_machine_part_scheduling_un_production")
@Table(name = "mes_building_task_need_machine_part_scheduling_un_production")
public class MesBuildingTaskNeedMachinePartSchedulingUnProduction extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '需要排产关联表id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20)  COMMENT '任务工单id'", nullable = true)
   private Long taskOrderId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'", nullable = false)
   private Long groupsId;
   @ApiModelProperty(name = "needId")
   @JsonProperty("needId")
   @JSONField(name = "needId")
   @TableField("need_id")
   @Column(name = "need_id", columnDefinition = "bigint(20)  COMMENT ''", nullable = false)
   private Long needId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20) default '1' COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "取消生产数量", notes = "取消生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '取消生产数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "useId", value = "用户id", notes = "用户id")
   @JsonProperty("useId")
   @JSONField(name = "useId")
   @TableField("use_id")
   @Column(name = "use_id", columnDefinition = "bigint(20)  COMMENT '用户id'", nullable = false)
   private Long useId;

   public static MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder builder() {
      return new MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder();
   }

   public MesBuildingTaskNeedMachinePartSchedulingUnProduction() {
   }

   public MesBuildingTaskNeedMachinePartSchedulingUnProduction(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long taskId,
      final Long taskOrderId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Long needId,
      final Long productId,
      final Integer quantity,
      final Long useId
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.taskId = taskId;
      this.taskOrderId = taskOrderId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.needId = needId;
      this.productId = productId;
      this.quantity = quantity;
      this.useId = useId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getTaskId() {
      return this.taskId;
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

   public Long getNeedId() {
      return this.needId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getUseId() {
      return this.useId;
   }

   @JsonProperty("id")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("needId")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setNeedId(final Long needId) {
      this.needId = needId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("useId")
   public MesBuildingTaskNeedMachinePartSchedulingUnProduction setUseId(final Long useId) {
      this.useId = useId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskNeedMachinePartSchedulingUnProduction(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", taskId="
         + this.getTaskId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", needId="
         + this.getNeedId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", useId="
         + this.getUseId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskNeedMachinePartSchedulingUnProduction)) {
         return false;
      }

      MesBuildingTaskNeedMachinePartSchedulingUnProduction other = (MesBuildingTaskNeedMachinePartSchedulingUnProduction)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$taskId = this.getTaskId();
                  Object other$taskId = other.getTaskId();
                  if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
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
                                 Object this$needId = this.getNeedId();
                                 Object other$needId = other.getNeedId();
                                 if (this$needId == null ? other$needId == null : this$needId.equals(other$needId)) {
                                    Object this$productId = this.getProductId();
                                    Object other$productId = other.getProductId();
                                    if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                       Object this$quantity = this.getQuantity();
                                       Object other$quantity = other.getQuantity();
                                       if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                          Object this$useId = this.getUseId();
                                          Object other$useId = other.getUseId();
                                          return this$useId == null ? other$useId == null : this$useId.equals(other$useId);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskNeedMachinePartSchedulingUnProduction;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $needId = this.getNeedId();
      result = result * 59 + ($needId == null ? 43 : $needId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $useId = this.getUseId();
      return result * 59 + ($useId == null ? 43 : $useId.hashCode());
   }

   public static class MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long taskId;
      private Long taskOrderId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Long needId;
      private Long productId;
      private Integer quantity;
      private Long useId;

      MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder taskOrderId(
         final Long taskOrderId
      ) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder productionLineId(
         final Long productionLineId
      ) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("needId")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder needId(final Long needId) {
         this.needId = needId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("useId")
      public MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder useId(final Long useId) {
         this.useId = useId;
         return this;
      }

      public MesBuildingTaskNeedMachinePartSchedulingUnProduction build() {
         return new MesBuildingTaskNeedMachinePartSchedulingUnProduction(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.taskId,
            this.taskOrderId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.needId,
            this.productId,
            this.quantity,
            this.useId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskNeedMachinePartSchedulingUnProduction.MesBuildingTaskNeedMachinePartSchedulingUnProductionBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", taskId="
            + this.taskId
            + ", taskOrderId="
            + this.taskOrderId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", needId="
            + this.needId
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", useId="
            + this.useId
            + ")";
      }
   }
}
