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

@ApiModel(value = "MesBuildingProduceQhseTeamReport对象", description = "质检上报记录表 ")
@Entity
@TableName("mes_building_produce_qhse_team_report")
@Table(name = "mes_building_produce_qhse_team_report")
public class MesBuildingProduceQhseTeamReport extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id", notes = "任务工序id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   @TableField("task_process_id")
   @Column(name = "task_process_id", columnDefinition = "bigint(20)  COMMENT '任务工序id'", nullable = false)
   private Long taskProcessId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20)  COMMENT '排产id'")
   private Long schedulingId;
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
   @ApiModelProperty(name = "inspectionQuantity", value = "质检数量", notes = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   @TableField("inspection_quantity")
   @Column(name = "inspection_quantity", columnDefinition = "int(11) default '0' COMMENT '质检数量'", nullable = false)
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "teamId", value = "生产班组id", notes = "生产班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '生产班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "inspectionTeamId", value = "质检班组id", notes = "质检班组id")
   @JsonProperty("inspectionTeamId")
   @JSONField(name = "inspectionTeamId")
   @TableField("inspection_team_id")
   @Column(name = "inspection_team_id", columnDefinition = "bigint(20)  COMMENT '质检班组id'")
   private Long inspectionTeamId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "boolAdoptEnum", value = "是否通过质检 [0 未通过, 1 已通过]", notes = "是否通过质检 [0 未通过, 1 已通过]")
   @JsonProperty("boolAdoptEnum")
   @JSONField(name = "boolAdoptEnum")
   @TableField("bool_adopt_enum")
   @Column(name = "bool_adopt_enum", columnDefinition = "tinyint(1) default '1' COMMENT '是否通过质检 [0 未通过, 1 已通过]'", nullable = false)
   private Boolean boolAdoptEnum;
   @ApiModelProperty(name = "inspectionTeamReportId")
   @JsonProperty("inspectionTeamReportId")
   @JSONField(name = "inspectionTeamReportId")
   @TableField("inspection_team_report_id")
   @Column(name = "inspection_team_report_id", columnDefinition = "bigint(20)  COMMENT ''")
   private Long inspectionTeamReportId;
   @ApiModelProperty(name = "qhseQuantity")
   @JsonProperty("qhseQuantity")
   @JSONField(name = "qhseQuantity")
   @TableField("qhse_quantity")
   @Column(name = "qhse_quantity", columnDefinition = "int(11)  COMMENT ''")
   private Integer qhseQuantity;

   public static MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder builder() {
      return new MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder();
   }

   public MesBuildingProduceQhseTeamReport() {
   }

   public MesBuildingProduceQhseTeamReport(
      final Long id,
      final Long taskId,
      final Long taskProcessId,
      final Long processId,
      final Long schedulingId,
      final Long productId,
      final Integer productType,
      final Integer inspectionQuantity,
      final Long teamId,
      final Long inspectionTeamId,
      final Long userId,
      final Boolean boolAdoptEnum,
      final Long inspectionTeamReportId,
      final Integer qhseQuantity
   ) {
      this.id = id;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.processId = processId;
      this.schedulingId = schedulingId;
      this.productId = productId;
      this.productType = productType;
      this.inspectionQuantity = inspectionQuantity;
      this.teamId = teamId;
      this.inspectionTeamId = inspectionTeamId;
      this.userId = userId;
      this.boolAdoptEnum = boolAdoptEnum;
      this.inspectionTeamReportId = inspectionTeamReportId;
      this.qhseQuantity = qhseQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getInspectionTeamId() {
      return this.inspectionTeamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getBoolAdoptEnum() {
      return this.boolAdoptEnum;
   }

   public Long getInspectionTeamReportId() {
      return this.inspectionTeamReportId;
   }

   public Integer getQhseQuantity() {
      return this.qhseQuantity;
   }

   @JsonProperty("id")
   public MesBuildingProduceQhseTeamReport setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingProduceQhseTeamReport setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesBuildingProduceQhseTeamReport setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingProduceQhseTeamReport setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingProduceQhseTeamReport setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingProduceQhseTeamReport setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProduceQhseTeamReport setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public MesBuildingProduceQhseTeamReport setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingProduceQhseTeamReport setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("inspectionTeamId")
   public MesBuildingProduceQhseTeamReport setInspectionTeamId(final Long inspectionTeamId) {
      this.inspectionTeamId = inspectionTeamId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProduceQhseTeamReport setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("boolAdoptEnum")
   public MesBuildingProduceQhseTeamReport setBoolAdoptEnum(final Boolean boolAdoptEnum) {
      this.boolAdoptEnum = boolAdoptEnum;
      return this;
   }

   @JsonProperty("inspectionTeamReportId")
   public MesBuildingProduceQhseTeamReport setInspectionTeamReportId(final Long inspectionTeamReportId) {
      this.inspectionTeamReportId = inspectionTeamReportId;
      return this;
   }

   @JsonProperty("qhseQuantity")
   public MesBuildingProduceQhseTeamReport setQhseQuantity(final Integer qhseQuantity) {
      this.qhseQuantity = qhseQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProduceQhseTeamReport(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", processId="
         + this.getProcessId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", teamId="
         + this.getTeamId()
         + ", inspectionTeamId="
         + this.getInspectionTeamId()
         + ", userId="
         + this.getUserId()
         + ", boolAdoptEnum="
         + this.getBoolAdoptEnum()
         + ", inspectionTeamReportId="
         + this.getInspectionTeamReportId()
         + ", qhseQuantity="
         + this.getQhseQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProduceQhseTeamReport)) {
         return false;
      }

      MesBuildingProduceQhseTeamReport other = (MesBuildingProduceQhseTeamReport)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$taskProcessId = this.getTaskProcessId();
            Object other$taskProcessId = other.getTaskProcessId();
            if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$schedulingId = this.getSchedulingId();
                  Object other$schedulingId = other.getSchedulingId();
                  if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$inspectionQuantity = this.getInspectionQuantity();
                           Object other$inspectionQuantity = other.getInspectionQuantity();
                           if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                              Object this$teamId = this.getTeamId();
                              Object other$teamId = other.getTeamId();
                              if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                 Object this$inspectionTeamId = this.getInspectionTeamId();
                                 Object other$inspectionTeamId = other.getInspectionTeamId();
                                 if (this$inspectionTeamId == null ? other$inspectionTeamId == null : this$inspectionTeamId.equals(other$inspectionTeamId)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$boolAdoptEnum = this.getBoolAdoptEnum();
                                       Object other$boolAdoptEnum = other.getBoolAdoptEnum();
                                       if (this$boolAdoptEnum == null ? other$boolAdoptEnum == null : this$boolAdoptEnum.equals(other$boolAdoptEnum)) {
                                          Object this$inspectionTeamReportId = this.getInspectionTeamReportId();
                                          Object other$inspectionTeamReportId = other.getInspectionTeamReportId();
                                          if (this$inspectionTeamReportId == null
                                             ? other$inspectionTeamReportId == null
                                             : this$inspectionTeamReportId.equals(other$inspectionTeamReportId)) {
                                             Object this$qhseQuantity = this.getQhseQuantity();
                                             Object other$qhseQuantity = other.getQhseQuantity();
                                             return this$qhseQuantity == null ? other$qhseQuantity == null : this$qhseQuantity.equals(other$qhseQuantity);
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
      return other instanceof MesBuildingProduceQhseTeamReport;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $inspectionTeamId = this.getInspectionTeamId();
      result = result * 59 + ($inspectionTeamId == null ? 43 : $inspectionTeamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolAdoptEnum = this.getBoolAdoptEnum();
      result = result * 59 + ($boolAdoptEnum == null ? 43 : $boolAdoptEnum.hashCode());
      Object $inspectionTeamReportId = this.getInspectionTeamReportId();
      result = result * 59 + ($inspectionTeamReportId == null ? 43 : $inspectionTeamReportId.hashCode());
      Object $qhseQuantity = this.getQhseQuantity();
      return result * 59 + ($qhseQuantity == null ? 43 : $qhseQuantity.hashCode());
   }

   public static class MesBuildingProduceQhseTeamReportBuilder {
      private Long id;
      private Long taskId;
      private Long taskProcessId;
      private Long processId;
      private Long schedulingId;
      private Long productId;
      private Integer productType;
      private Integer inspectionQuantity;
      private Long teamId;
      private Long inspectionTeamId;
      private Long userId;
      private Boolean boolAdoptEnum;
      private Long inspectionTeamReportId;
      private Integer qhseQuantity;

      MesBuildingProduceQhseTeamReportBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("inspectionTeamId")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder inspectionTeamId(final Long inspectionTeamId) {
         this.inspectionTeamId = inspectionTeamId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("boolAdoptEnum")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder boolAdoptEnum(final Boolean boolAdoptEnum) {
         this.boolAdoptEnum = boolAdoptEnum;
         return this;
      }

      @JsonProperty("inspectionTeamReportId")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder inspectionTeamReportId(final Long inspectionTeamReportId) {
         this.inspectionTeamReportId = inspectionTeamReportId;
         return this;
      }

      @JsonProperty("qhseQuantity")
      public MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder qhseQuantity(final Integer qhseQuantity) {
         this.qhseQuantity = qhseQuantity;
         return this;
      }

      public MesBuildingProduceQhseTeamReport build() {
         return new MesBuildingProduceQhseTeamReport(
            this.id,
            this.taskId,
            this.taskProcessId,
            this.processId,
            this.schedulingId,
            this.productId,
            this.productType,
            this.inspectionQuantity,
            this.teamId,
            this.inspectionTeamId,
            this.userId,
            this.boolAdoptEnum,
            this.inspectionTeamReportId,
            this.qhseQuantity
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProduceQhseTeamReport.MesBuildingProduceQhseTeamReportBuilder(id="
            + this.id
            + ", taskId="
            + this.taskId
            + ", taskProcessId="
            + this.taskProcessId
            + ", processId="
            + this.processId
            + ", schedulingId="
            + this.schedulingId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", teamId="
            + this.teamId
            + ", inspectionTeamId="
            + this.inspectionTeamId
            + ", userId="
            + this.userId
            + ", boolAdoptEnum="
            + this.boolAdoptEnum
            + ", inspectionTeamReportId="
            + this.inspectionTeamReportId
            + ", qhseQuantity="
            + this.qhseQuantity
            + ")";
      }
   }
}
