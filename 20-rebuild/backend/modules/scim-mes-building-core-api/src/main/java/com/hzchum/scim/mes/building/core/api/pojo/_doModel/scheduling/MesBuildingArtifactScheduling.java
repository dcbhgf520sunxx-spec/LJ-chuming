package com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingArtifactScheduling对象", description = "构件排产分配表 ")
@Entity
@TableName("mes_building_artifact_scheduling")
@Table(
   name = "mes_building_artifact_scheduling",
   indexes = {@Index(name = "productId_index", columnList = "product_id"), @Index(name = "project_id_index", columnList = "project_id,monomer_id,area_id")}
)
public class MesBuildingArtifactScheduling extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
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
   @TableField(value = "groups_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "groups_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'")
   private Long groupsId;
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
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'", nullable = false)
   private Long areaBatchId;
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
   @ApiModelProperty(name = "taskQuantity", value = "下发数量", notes = "下发数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   @TableField("task_quantity")
   @Column(name = "task_quantity", columnDefinition = "int(11) default '0' COMMENT '排产数量'", nullable = false)
   private Integer taskQuantity;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @TableField("ask_complete_time")
   @Column(name = "ask_complete_time", columnDefinition = "datetime  COMMENT '要求完成日期'", nullable = true)
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "status", value = "状态 [0 暂停, 1 正常]", notes = "状态 [0 暂停, 1 正常]")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '1' COMMENT '状态 [0 暂停, 1 正常]'", nullable = false)
   private Boolean status;
   @ApiModelProperty(name = "issueStatus", value = "下发状态 [0 未下发 1 已下发]", notes = "下发状态 [0 未下发 1 已下发]")
   @JsonProperty("issueStatus")
   @JSONField(name = "issueStatus")
   @TableField("issue_status")
   @Column(name = "issue_status", columnDefinition = "tinyint(1) default '0' COMMENT '下发状态 [0 未下发 1 已下发]'", nullable = false)
   private Boolean issueStatus;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default 1  COMMENT '生产线类型 1传统线 2智能线'", nullable = false)
   private Integer productionLineTypeEnum;

   public static MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder builder() {
      return new MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder();
   }

   public MesBuildingArtifactScheduling() {
   }

   public MesBuildingArtifactScheduling(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Long productId,
      final Integer quantity,
      final Integer taskQuantity,
      final LocalDateTime askCompleteTime,
      final Boolean status,
      final Boolean issueStatus,
      final Long userId,
      final Integer productionLineTypeEnum
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.productId = productId;
      this.quantity = quantity;
      this.taskQuantity = taskQuantity;
      this.askCompleteTime = askCompleteTime;
      this.status = status;
      this.issueStatus = issueStatus;
      this.userId = userId;
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
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

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Boolean getIssueStatus() {
      return this.issueStatus;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   @JsonProperty("id")
   public MesBuildingArtifactScheduling setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingArtifactScheduling setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingArtifactScheduling setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingArtifactScheduling setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingArtifactScheduling setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingArtifactScheduling setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingArtifactScheduling setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingArtifactScheduling setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingArtifactScheduling setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingArtifactScheduling setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingArtifactScheduling setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingArtifactScheduling setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingArtifactScheduling setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingArtifactScheduling setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("issueStatus")
   public MesBuildingArtifactScheduling setIssueStatus(final Boolean issueStatus) {
      this.issueStatus = issueStatus;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingArtifactScheduling setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingArtifactScheduling setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactScheduling(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", status="
         + this.getStatus()
         + ", issueStatus="
         + this.getIssueStatus()
         + ", userId="
         + this.getUserId()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactScheduling)) {
         return false;
      }

      MesBuildingArtifactScheduling other = (MesBuildingArtifactScheduling)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$groupsId = this.getGroupsId();
                  Object other$groupsId = other.getGroupsId();
                  if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$monomerId = this.getMonomerId();
                        Object other$monomerId = other.getMonomerId();
                        if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                           Object this$areaId = this.getAreaId();
                           Object other$areaId = other.getAreaId();
                           if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                              Object this$areaBatchId = this.getAreaBatchId();
                              Object other$areaBatchId = other.getAreaBatchId();
                              if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                                 Object this$productId = this.getProductId();
                                 Object other$productId = other.getProductId();
                                 if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                    Object this$quantity = this.getQuantity();
                                    Object other$quantity = other.getQuantity();
                                    if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                       Object this$taskQuantity = this.getTaskQuantity();
                                       Object other$taskQuantity = other.getTaskQuantity();
                                       if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                                          Object this$status = this.getStatus();
                                          Object other$status = other.getStatus();
                                          if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                             Object this$issueStatus = this.getIssueStatus();
                                             Object other$issueStatus = other.getIssueStatus();
                                             if (this$issueStatus == null ? other$issueStatus == null : this$issueStatus.equals(other$issueStatus)) {
                                                Object this$userId = this.getUserId();
                                                Object other$userId = other.getUserId();
                                                if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                   Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                                                   Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                                                   if (this$productionLineTypeEnum == null
                                                      ? other$productionLineTypeEnum == null
                                                      : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                                                      Object this$askCompleteTime = this.getAskCompleteTime();
                                                      Object other$askCompleteTime = other.getAskCompleteTime();
                                                      return this$askCompleteTime == null
                                                         ? other$askCompleteTime == null
                                                         : this$askCompleteTime.equals(other$askCompleteTime);
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
      return other instanceof MesBuildingArtifactScheduling;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $issueStatus = this.getIssueStatus();
      result = result * 59 + ($issueStatus == null ? 43 : $issueStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   public static class MesBuildingArtifactSchedulingBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Long productId;
      private Integer quantity;
      private Integer taskQuantity;
      private LocalDateTime askCompleteTime;
      private Boolean status;
      private Boolean issueStatus;
      private Long userId;
      private Integer productionLineTypeEnum;

      MesBuildingArtifactSchedulingBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("issueStatus")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder issueStatus(final Boolean issueStatus) {
         this.issueStatus = issueStatus;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public MesBuildingArtifactScheduling build() {
         return new MesBuildingArtifactScheduling(
            this.id,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.productId,
            this.quantity,
            this.taskQuantity,
            this.askCompleteTime,
            this.status,
            this.issueStatus,
            this.userId,
            this.productionLineTypeEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactScheduling.MesBuildingArtifactSchedulingBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", status="
            + this.status
            + ", issueStatus="
            + this.issueStatus
            + ", userId="
            + this.userId
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ")";
      }
   }
}
