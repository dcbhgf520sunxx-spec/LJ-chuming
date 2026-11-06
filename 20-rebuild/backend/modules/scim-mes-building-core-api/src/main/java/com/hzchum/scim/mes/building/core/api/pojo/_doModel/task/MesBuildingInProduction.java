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

@ApiModel(value = "MesBuildingInProduction对象", description = "进入生产表 ")
@Entity
@TableName("mes_building_in_production")
@Table(name = "mes_building_in_production")
public class MesBuildingInProduction extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
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
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'")
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
   private Long areaBatchId;
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
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "teamReportId", value = "生产上报id", notes = "生产上报id")
   @JsonProperty("teamReportId")
   @JSONField(name = "teamReportId")
   @TableField("team_report_id")
   @Column(name = "team_report_id", columnDefinition = "bigint(20)  COMMENT '生产上报id'", nullable = false)
   private Long teamReportId;
   @ApiModelProperty(name = "teamId", value = "生产班组", notes = "生产班组")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '生产班组'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "number", value = "构件生产编号", notes = "构件生产编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(20)  COMMENT '构件生产编号'")
   private Integer number;

   public static MesBuildingInProduction.MesBuildingInProductionBuilder builder() {
      return new MesBuildingInProduction.MesBuildingInProductionBuilder();
   }

   public MesBuildingInProduction() {
   }

   public MesBuildingInProduction(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Long factoryId,
      final Long workshopId,
      final Long taskId,
      final Long productionLineId,
      final Long productId,
      final Integer productType,
      final Integer quantity,
      final Long teamReportId,
      final Long teamId,
      final Long userId,
      final Integer number
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.taskId = taskId;
      this.productionLineId = productionLineId;
      this.productId = productId;
      this.productType = productType;
      this.quantity = quantity;
      this.teamReportId = teamReportId;
      this.teamId = teamId;
      this.userId = userId;
      this.number = number;
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

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getTeamReportId() {
      return this.teamReportId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getNumber() {
      return this.number;
   }

   @JsonProperty("id")
   public MesBuildingInProduction setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingInProduction setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingInProduction setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingInProduction setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingInProduction setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingInProduction setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingInProduction setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingInProduction setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingInProduction setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingInProduction setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingInProduction setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingInProduction setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("teamReportId")
   public MesBuildingInProduction setTeamReportId(final Long teamReportId) {
      this.teamReportId = teamReportId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingInProduction setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingInProduction setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingInProduction setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingInProduction(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", taskId="
         + this.getTaskId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", teamReportId="
         + this.getTeamReportId()
         + ", teamId="
         + this.getTeamId()
         + ", userId="
         + this.getUserId()
         + ", number="
         + this.getNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingInProduction)) {
         return false;
      }

      MesBuildingInProduction other = (MesBuildingInProduction)o;
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
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                     Object this$factoryId = this.getFactoryId();
                     Object other$factoryId = other.getFactoryId();
                     if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                        Object this$workshopId = this.getWorkshopId();
                        Object other$workshopId = other.getWorkshopId();
                        if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                           Object this$taskId = this.getTaskId();
                           Object other$taskId = other.getTaskId();
                           if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                              Object this$productionLineId = this.getProductionLineId();
                              Object other$productionLineId = other.getProductionLineId();
                              if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                                 Object this$productId = this.getProductId();
                                 Object other$productId = other.getProductId();
                                 if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                    Object this$productType = this.getProductType();
                                    Object other$productType = other.getProductType();
                                    if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                       Object this$quantity = this.getQuantity();
                                       Object other$quantity = other.getQuantity();
                                       if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                          Object this$teamReportId = this.getTeamReportId();
                                          Object other$teamReportId = other.getTeamReportId();
                                          if (this$teamReportId == null ? other$teamReportId == null : this$teamReportId.equals(other$teamReportId)) {
                                             Object this$teamId = this.getTeamId();
                                             Object other$teamId = other.getTeamId();
                                             if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                                Object this$userId = this.getUserId();
                                                Object other$userId = other.getUserId();
                                                if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                   Object this$number = this.getNumber();
                                                   Object other$number = other.getNumber();
                                                   return this$number == null ? other$number == null : this$number.equals(other$number);
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
      return other instanceof MesBuildingInProduction;
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
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $teamReportId = this.getTeamReportId();
      result = result * 59 + ($teamReportId == null ? 43 : $teamReportId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $number = this.getNumber();
      return result * 59 + ($number == null ? 43 : $number.hashCode());
   }

   public static class MesBuildingInProductionBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Long factoryId;
      private Long workshopId;
      private Long taskId;
      private Long productionLineId;
      private Long productId;
      private Integer productType;
      private Integer quantity;
      private Long teamReportId;
      private Long teamId;
      private Long userId;
      private Integer number;

      MesBuildingInProductionBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingInProduction.MesBuildingInProductionBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingInProduction.MesBuildingInProductionBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingInProduction.MesBuildingInProductionBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingInProduction.MesBuildingInProductionBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingInProduction.MesBuildingInProductionBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingInProduction.MesBuildingInProductionBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingInProduction.MesBuildingInProductionBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingInProduction.MesBuildingInProductionBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingInProduction.MesBuildingInProductionBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingInProduction.MesBuildingInProductionBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingInProduction.MesBuildingInProductionBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingInProduction.MesBuildingInProductionBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("teamReportId")
      public MesBuildingInProduction.MesBuildingInProductionBuilder teamReportId(final Long teamReportId) {
         this.teamReportId = teamReportId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingInProduction.MesBuildingInProductionBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingInProduction.MesBuildingInProductionBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingInProduction.MesBuildingInProductionBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesBuildingInProduction build() {
         return new MesBuildingInProduction(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.factoryId,
            this.workshopId,
            this.taskId,
            this.productionLineId,
            this.productId,
            this.productType,
            this.quantity,
            this.teamReportId,
            this.teamId,
            this.userId,
            this.number
         );
      }

      @Override
      public String toString() {
         return "MesBuildingInProduction.MesBuildingInProductionBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", taskId="
            + this.taskId
            + ", productionLineId="
            + this.productionLineId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ", teamReportId="
            + this.teamReportId
            + ", teamId="
            + this.teamId
            + ", userId="
            + this.userId
            + ", number="
            + this.number
            + ")";
      }
   }
}
