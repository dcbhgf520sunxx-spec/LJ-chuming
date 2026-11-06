package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@ApiModel(value = "MesEnclosureProduceTeamReport对象", description = "班组生产上报记录表 ")
@Entity
@TableName("mes_enclosure_produce_team_report")
@Table(name = "mes_enclosure_produce_team_report")
public class MesEnclosureProduceTeamReport extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) comment '项目ID'")
   private Long projectId;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   @TableField("enclosure_plan_id")
   @Column(name = "enclosure_plan_id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @TableField("area_id")
   @Column(name = "area_id")
   private Long areaId;
   @ApiModelProperty(name = "task_order_id", value = "工单id", notes = "工单id")
   @JsonProperty("task_order_id")
   @JSONField(name = "task_order_id")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20)  COMMENT '工单id'", nullable = false)
   private Long taskOrderId;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "生产数量", notes = "生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '生产数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "price", value = "工价 每米")
   @JsonProperty("price")
   @JSONField(name = "price")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '工价 每米'")
   private BigDecimal price;

   public static MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder builder() {
      return new MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder();
   }

   public MesEnclosureProduceTeamReport() {
   }

   public MesEnclosureProduceTeamReport(
      final Long id,
      final Long projectId,
      final Long enclosurePlanId,
      final Long areaId,
      final Long taskOrderId,
      final Long taskId,
      final Long processId,
      final Long productId,
      final Integer quantity,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long teamId,
      final Long userId,
      final BigDecimal price
   ) {
      this.id = id;
      this.projectId = projectId;
      this.enclosurePlanId = enclosurePlanId;
      this.areaId = areaId;
      this.taskOrderId = taskOrderId;
      this.taskId = taskId;
      this.processId = processId;
      this.productId = productId;
      this.quantity = quantity;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.teamId = teamId;
      this.userId = userId;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
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

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("id")
   public MesEnclosureProduceTeamReport setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureProduceTeamReport setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesEnclosureProduceTeamReport setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
      return this;
   }

   public MesEnclosureProduceTeamReport setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("task_order_id")
   public MesEnclosureProduceTeamReport setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("taskId")
   public MesEnclosureProduceTeamReport setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureProduceTeamReport setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureProduceTeamReport setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureProduceTeamReport setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureProduceTeamReport setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureProduceTeamReport setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureProduceTeamReport setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureProduceTeamReport setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureProduceTeamReport setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("price")
   public MesEnclosureProduceTeamReport setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProduceTeamReport(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", areaId="
         + this.getAreaId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", taskId="
         + this.getTaskId()
         + ", processId="
         + this.getProcessId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", teamId="
         + this.getTeamId()
         + ", userId="
         + this.getUserId()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProduceTeamReport)) {
         return false;
      }

      MesEnclosureProduceTeamReport other = (MesEnclosureProduceTeamReport)o;
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
            Object this$enclosurePlanId = this.getEnclosurePlanId();
            Object other$enclosurePlanId = other.getEnclosurePlanId();
            if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$taskOrderId = this.getTaskOrderId();
                  Object other$taskOrderId = other.getTaskOrderId();
                  if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                     Object this$taskId = this.getTaskId();
                     Object other$taskId = other.getTaskId();
                     if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                        Object this$processId = this.getProcessId();
                        Object other$processId = other.getProcessId();
                        if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                           Object this$productId = this.getProductId();
                           Object other$productId = other.getProductId();
                           if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$factoryId = this.getFactoryId();
                                 Object other$factoryId = other.getFactoryId();
                                 if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                    Object this$workshopId = this.getWorkshopId();
                                    Object other$workshopId = other.getWorkshopId();
                                    if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                       Object this$productionLineId = this.getProductionLineId();
                                       Object other$productionLineId = other.getProductionLineId();
                                       if (this$productionLineId == null
                                          ? other$productionLineId == null
                                          : this$productionLineId.equals(other$productionLineId)) {
                                          Object this$teamId = this.getTeamId();
                                          Object other$teamId = other.getTeamId();
                                          if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                             Object this$userId = this.getUserId();
                                             Object other$userId = other.getUserId();
                                             if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                Object this$price = this.getPrice();
                                                Object other$price = other.getPrice();
                                                return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesEnclosureProduceTeamReport;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesEnclosureProduceTeamReportBuilder {
      private Long id;
      private Long projectId;
      private Long enclosurePlanId;
      private Long areaId;
      private Long taskOrderId;
      private Long taskId;
      private Long processId;
      private Long productId;
      private Integer quantity;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long teamId;
      private Long userId;
      private BigDecimal price;

      MesEnclosureProduceTeamReportBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("task_order_id")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("taskId")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("price")
      public MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesEnclosureProduceTeamReport build() {
         return new MesEnclosureProduceTeamReport(
            this.id,
            this.projectId,
            this.enclosurePlanId,
            this.areaId,
            this.taskOrderId,
            this.taskId,
            this.processId,
            this.productId,
            this.quantity,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.teamId,
            this.userId,
            this.price
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureProduceTeamReport.MesEnclosureProduceTeamReportBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", areaId="
            + this.areaId
            + ", taskOrderId="
            + this.taskOrderId
            + ", taskId="
            + this.taskId
            + ", processId="
            + this.processId
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", teamId="
            + this.teamId
            + ", userId="
            + this.userId
            + ", price="
            + this.price
            + ")";
      }
   }
}
