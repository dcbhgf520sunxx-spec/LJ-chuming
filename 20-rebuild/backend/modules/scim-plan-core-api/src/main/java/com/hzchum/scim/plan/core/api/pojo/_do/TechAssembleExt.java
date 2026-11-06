package com.hzchum.scim.plan.core.api.pojo._do;

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
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@ApiModel(value = "TechAssembleExt对象", description = "部件扩展表 ")
@Entity
@TableName("tech_assemble_ext")
@Table(
   name = "tech_assemble_ext",
   indexes = @Index(name = "assemble_id", columnList = "assemble_id"),
   uniqueConstraints = @UniqueConstraint(columnNames = {"serial_number", "sort_number", "monomer_id"})
)
@org.hibernate.annotations.Table(appliesTo = "tech_assemble_ext", comment = "部件扩展表 ")
public class TechAssembleExt extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'", nullable = false)
   private Long areaBatchId;
   @ApiModelProperty(name = "assembleId", value = "部件ID", notes = "部件ID")
   @TableField("assemble_id")
   @Column(name = "assemble_id", columnDefinition = "bigint(20)  COMMENT '部件ID'", nullable = false)
   private Long assembleId;
   @ApiModelProperty(name = "serialNumber", value = "部件编号", notes = "部件编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '部件编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "sortNumber", value = "序号", notes = "序号")
   @TableField("sort_number")
   @Column(name = "sort_number", columnDefinition = "int(11) default '1' COMMENT '序号'", nullable = false)
   private Integer sortNumber;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 false暂停 true进行中")
   @TableField("bool_status_enum")
   @Column(name = "bool_status_enum", columnDefinition = "tinyint(1) DEFAULT 1 COMMENT '状态 0暂停 1进行中'", nullable = false)
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "boolTask", value = "是否排产")
   @TableField("bool_task")
   @Column(name = "bool_task", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否排产'", nullable = false)
   private Boolean boolTask;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '任务id'")
   private Long taskId;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default 1 COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "batchNumber", value = "导入批次编号", notes = "导入批次编号")
   @JsonProperty("batchNumber")
   @JSONField(name = "batchNumber")
   @TableField("batch_number")
   @Column(name = "batch_number", columnDefinition = "varchar(255)  COMMENT '导入批次编号'", nullable = true)
   private String batchNumber;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20)  COMMENT '排产id'")
   private Long schedulingId;

   public static TechAssembleExt.TechAssembleExtBuilder builder() {
      return new TechAssembleExt.TechAssembleExtBuilder();
   }

   public TechAssembleExt() {
   }

   public TechAssembleExt(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Long assembleId,
      final String serialNumber,
      final Integer sortNumber,
      final Boolean boolStatusEnum,
      final Boolean boolTask,
      final Long taskId,
      final Integer quantity,
      final String batchNumber,
      final Long schedulingId
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.assembleId = assembleId;
      this.serialNumber = serialNumber;
      this.sortNumber = sortNumber;
      this.boolStatusEnum = boolStatusEnum;
      this.boolTask = boolTask;
      this.taskId = taskId;
      this.quantity = quantity;
      this.batchNumber = batchNumber;
      this.schedulingId = schedulingId;
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

   public Long getAssembleId() {
      return this.assembleId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Boolean getBoolTask() {
      return this.boolTask;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getBatchNumber() {
      return this.batchNumber;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public TechAssembleExt setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechAssembleExt setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechAssembleExt setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechAssembleExt setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechAssembleExt setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   public TechAssembleExt setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   public TechAssembleExt setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechAssembleExt setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
      return this;
   }

   public TechAssembleExt setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   public TechAssembleExt setBoolTask(final Boolean boolTask) {
      this.boolTask = boolTask;
      return this;
   }

   public TechAssembleExt setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public TechAssembleExt setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("batchNumber")
   public TechAssembleExt setBatchNumber(final String batchNumber) {
      this.batchNumber = batchNumber;
      return this;
   }

   public TechAssembleExt setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @Override
   public String toString() {
      return "TechAssembleExt(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", assembleId="
         + this.getAssembleId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", sortNumber="
         + this.getSortNumber()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", boolTask="
         + this.getBoolTask()
         + ", taskId="
         + this.getTaskId()
         + ", quantity="
         + this.getQuantity()
         + ", batchNumber="
         + this.getBatchNumber()
         + ", schedulingId="
         + this.getSchedulingId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAssembleExt)) {
         return false;
      }

      TechAssembleExt other = (TechAssembleExt)o;
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
                     Object this$assembleId = this.getAssembleId();
                     Object other$assembleId = other.getAssembleId();
                     if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
                        Object this$sortNumber = this.getSortNumber();
                        Object other$sortNumber = other.getSortNumber();
                        if (this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber)) {
                           Object this$boolStatusEnum = this.getBoolStatusEnum();
                           Object other$boolStatusEnum = other.getBoolStatusEnum();
                           if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                              Object this$boolTask = this.getBoolTask();
                              Object other$boolTask = other.getBoolTask();
                              if (this$boolTask == null ? other$boolTask == null : this$boolTask.equals(other$boolTask)) {
                                 Object this$taskId = this.getTaskId();
                                 Object other$taskId = other.getTaskId();
                                 if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                                    Object this$quantity = this.getQuantity();
                                    Object other$quantity = other.getQuantity();
                                    if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                       Object this$schedulingId = this.getSchedulingId();
                                       Object other$schedulingId = other.getSchedulingId();
                                       if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$batchNumber = this.getBatchNumber();
                                             Object other$batchNumber = other.getBatchNumber();
                                             return this$batchNumber == null ? other$batchNumber == null : this$batchNumber.equals(other$batchNumber);
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
      return other instanceof TechAssembleExt;
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
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $sortNumber = this.getSortNumber();
      result = result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $boolTask = this.getBoolTask();
      result = result * 59 + ($boolTask == null ? 43 : $boolTask.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $batchNumber = this.getBatchNumber();
      return result * 59 + ($batchNumber == null ? 43 : $batchNumber.hashCode());
   }

   public static class TechAssembleExtBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Long assembleId;
      private String serialNumber;
      private Integer sortNumber;
      private Boolean boolStatusEnum;
      private Boolean boolTask;
      private Long taskId;
      private Integer quantity;
      private String batchNumber;
      private Long schedulingId;

      TechAssembleExtBuilder() {
      }

      public TechAssembleExt.TechAssembleExtBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechAssembleExt.TechAssembleExtBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechAssembleExt.TechAssembleExtBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechAssembleExt.TechAssembleExtBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechAssembleExt.TechAssembleExtBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public TechAssembleExt.TechAssembleExtBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      public TechAssembleExt.TechAssembleExtBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechAssembleExt.TechAssembleExtBuilder sortNumber(final Integer sortNumber) {
         this.sortNumber = sortNumber;
         return this;
      }

      public TechAssembleExt.TechAssembleExtBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      public TechAssembleExt.TechAssembleExtBuilder boolTask(final Boolean boolTask) {
         this.boolTask = boolTask;
         return this;
      }

      public TechAssembleExt.TechAssembleExtBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public TechAssembleExt.TechAssembleExtBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("batchNumber")
      public TechAssembleExt.TechAssembleExtBuilder batchNumber(final String batchNumber) {
         this.batchNumber = batchNumber;
         return this;
      }

      public TechAssembleExt.TechAssembleExtBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      public TechAssembleExt build() {
         return new TechAssembleExt(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.assembleId,
            this.serialNumber,
            this.sortNumber,
            this.boolStatusEnum,
            this.boolTask,
            this.taskId,
            this.quantity,
            this.batchNumber,
            this.schedulingId
         );
      }

      @Override
      public String toString() {
         return "TechAssembleExt.TechAssembleExtBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", assembleId="
            + this.assembleId
            + ", serialNumber="
            + this.serialNumber
            + ", sortNumber="
            + this.sortNumber
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", boolTask="
            + this.boolTask
            + ", taskId="
            + this.taskId
            + ", quantity="
            + this.quantity
            + ", batchNumber="
            + this.batchNumber
            + ", schedulingId="
            + this.schedulingId
            + ")";
      }
   }
}
