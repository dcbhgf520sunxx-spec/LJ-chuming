package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "MesBuildingTaskNumberLink", description = "构件部件码号任务关联关系表")
@Entity
@TableName("mes_building_task_number_link")
@Table(
   name = "mes_building_task_number_link",
   indexes = {
         @Index(name = "art_id_number", columnList = "artifact_id,artifact_number"),
         @Index(name = "ass_id_number", columnList = "assemble_id,assemble_number"),
         @Index(name = "processIdAndArtifactNumber", columnList = "artifact_task_process_id,artifact_number"),
         @Index(name = "processIdAndAssembleNumber", columnList = "assemble_task_process_id,assemble_number")
   }
)
@org.hibernate.annotations.Table(appliesTo = "mes_building_task_number_link", comment = "构件部件码号任务关联关系表")
public class MesBuildingTaskNumberLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "artifactId", value = "构件id", notes = "构件id")
   @TableField("artifact_id")
   @Column(name = "artifact_id", columnDefinition = "bigint(20)  COMMENT '构件id'", nullable = false)
   private Long artifactId;
   @ApiModelProperty(name = "artifactTaskId", value = "构件任务id", notes = "构件任务id")
   @TableField("artifact_task_id")
   @Column(name = "artifact_task_id", columnDefinition = "bigint(20)  COMMENT '构件任务id'", nullable = false)
   private Long artifactTaskId;
   @ApiModelProperty(name = "artifactTaskProcessId", value = "本码号构件任务所处工序", notes = "本码号构件任务所处工序")
   @TableField("artifact_task_process_id")
   @Column(name = "artifact_task_process_id", columnDefinition = "bigint(20)   COMMENT '本码号构件任务所处工序'")
   private Long artifactTaskProcessId;
   @ApiModelProperty(name = "artifactNumber", value = "构件一物一码号", notes = "构件一物一码号")
   @TableField("artifact_number")
   @Column(name = "artifact_number", columnDefinition = "int(11)  COMMENT '构件一物一码号'", nullable = false)
   private Integer artifactNumber;
   @ApiModelProperty(name = "artifactNextProcessId", value = "本码号构件任务所选下一道工序", notes = "本码号构件任务所选下一道工序")
   @TableField(value = "artifact_next_process_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "artifact_next_process_id", columnDefinition = "bigint(20)   COMMENT '本码号构件任务所选下一道工序'")
   private Long artifactNextProcessId;
   @ApiModelProperty(name = "boolArtifactReport", value = "本码号构件当前工序是否上报", notes = "本码号构件当前工序是否上报")
   @TableField("bool_artifact_report")
   @Column(name = "bool_artifact_report", columnDefinition = "tinyint(1) default '0' COMMENT '本码号构件是否上报'", nullable = false)
   private Boolean boolArtifactReport;
   @ApiModelProperty(name = "boolArtifactInspection", value = "本码号构件当前工序是否质检", notes = "本码号构件当前工序是否质检")
   @TableField("bool_artifact_inspection")
   @Column(name = "bool_artifact_inspection", columnDefinition = "tinyint(1) default '0' COMMENT '本码号构件当前工序是否质检'", nullable = false)
   private Boolean boolArtifactInspection;
   @ApiModelProperty(name = "boolArtifactComplete", value = "本码号构件是否完成", notes = "本码号构件是否完成")
   @TableField("bool_artifact_complete")
   @Column(name = "bool_artifact_complete", columnDefinition = "tinyint(1) default '0' COMMENT '本码号构件是否完成'", nullable = false)
   private Boolean boolArtifactComplete;
   @ApiModelProperty(name = "boolArtifactInproduce", value = "本码号构件是否进入生产", notes = "本码号构件是否进入生产")
   @TableField("bool_artifact_inproduce")
   @Column(name = "bool_artifact_inproduce", columnDefinition = "tinyint(1) default '0' COMMENT '本码号构件是否进入生产'", nullable = false)
   private Boolean boolArtifactInproduce;
   @ApiModelProperty(name = "assembleId", value = "部件id", notes = "部件id")
   @TableField(value = "assemble_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "assemble_id", columnDefinition = "bigint(20)  COMMENT '部件id'")
   private Long assembleId;
   @ApiModelProperty(name = "assembleTaskId", value = "部件任务id", notes = "部件任务id")
   @TableField(value = "assemble_task_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "assemble_task_id", columnDefinition = "bigint(20)  COMMENT '部件任务id'")
   private Long assembleTaskId;
   @ApiModelProperty(name = "assembleTaskProcessId", value = "本码号部件任务所处工序", notes = "本码号部件任务所处工序")
   @TableField(value = "assemble_task_process_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "assemble_task_process_id", columnDefinition = "bigint(20)   COMMENT '本码号部件任务所处工序'")
   private Long assembleTaskProcessId;
   @ApiModelProperty(name = "assembleNextProcessId", value = "本码号部件任务所选下一道工序", notes = "本码号部件任务所选下一道工序")
   @TableField(value = "assemble_next_process_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "assemble_next_process_id", columnDefinition = "bigint(20)   COMMENT '本码号部件任务所选下一道工序'")
   private Long assembleNextProcessId;
   @ApiModelProperty(name = "assembleNumber", value = "部件一物一码号", notes = "部件一物一码号")
   @TableField(value = "assemble_number", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "assemble_number", columnDefinition = "int(11)  COMMENT '部件一物一码号'")
   private Integer assembleNumber;
   @ApiModelProperty(name = "boolAssembleReport", value = "本码号部件当前工序是否上报", notes = "本码号部件当前工序是否上报")
   @TableField("bool_assemble_report")
   @Column(name = "bool_assemble_report", columnDefinition = "tinyint(1) default '0' COMMENT '本码号部件是否上报'")
   private Boolean boolAssembleReport;
   @ApiModelProperty(name = "boolAssembleInspection", value = "本码号部件当前工序是否质检", notes = "本码号部件当前工序是否质检")
   @TableField("bool_assemble_inspection")
   @Column(name = "bool_assemble_inspection", columnDefinition = "tinyint(1) default '0' COMMENT '本码号部件当前工序是否质检'")
   private Boolean boolAssembleInspection;
   @ApiModelProperty(name = "boolAssembleComplete", value = "本码号部件是否完成", notes = "本码号部件是否完成")
   @TableField("bool_assemble_complete")
   @Column(name = "bool_assemble_complete", columnDefinition = "tinyint(1) default '0' COMMENT '本码号部件是否完成'")
   private Boolean boolAssembleComplete;
   @ApiModelProperty(name = "boolAssembleInproduce", value = "本码号部件是否进入生产", notes = "本码号部件是否进入生产")
   @TableField("bool_assemble_inproduce")
   @Column(name = "bool_assemble_inproduce", columnDefinition = "tinyint(1) default '0' COMMENT '本码号部件是否进入生产'")
   private Boolean boolAssembleInproduce;
   @ApiModelProperty(name = "boolOneCode", value = "构件是否是一物一码", notes = "构件是否是一物一码")
   @TableField("bool_one_code")
   @Column(name = "bool_one_code", columnDefinition = "tinyint(1) default '1' COMMENT '构件是否是一物一码'", nullable = true)
   private Boolean boolOneCode;
   @ApiModelProperty(name = "boolSecondUse", value = "是否是二次利用", notes = "是否是二次利用")
   @TableField("bool_second_use")
   @Column(name = "bool_second_use", columnDefinition = "tinyint(1) default '0' COMMENT '是否是二次利用'", nullable = false)
   private Boolean boolSecondUse;

   public static MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder builder() {
      return new MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder();
   }

   public MesBuildingTaskNumberLink() {
   }

   public MesBuildingTaskNumberLink(
      final Long id,
      final Long artifactId,
      final Long artifactTaskId,
      final Long artifactTaskProcessId,
      final Integer artifactNumber,
      final Long artifactNextProcessId,
      final Boolean boolArtifactReport,
      final Boolean boolArtifactInspection,
      final Boolean boolArtifactComplete,
      final Boolean boolArtifactInproduce,
      final Long assembleId,
      final Long assembleTaskId,
      final Long assembleTaskProcessId,
      final Long assembleNextProcessId,
      final Integer assembleNumber,
      final Boolean boolAssembleReport,
      final Boolean boolAssembleInspection,
      final Boolean boolAssembleComplete,
      final Boolean boolAssembleInproduce,
      final Boolean boolOneCode,
      final Boolean boolSecondUse
   ) {
      this.id = id;
      this.artifactId = artifactId;
      this.artifactTaskId = artifactTaskId;
      this.artifactTaskProcessId = artifactTaskProcessId;
      this.artifactNumber = artifactNumber;
      this.artifactNextProcessId = artifactNextProcessId;
      this.boolArtifactReport = boolArtifactReport;
      this.boolArtifactInspection = boolArtifactInspection;
      this.boolArtifactComplete = boolArtifactComplete;
      this.boolArtifactInproduce = boolArtifactInproduce;
      this.assembleId = assembleId;
      this.assembleTaskId = assembleTaskId;
      this.assembleTaskProcessId = assembleTaskProcessId;
      this.assembleNextProcessId = assembleNextProcessId;
      this.assembleNumber = assembleNumber;
      this.boolAssembleReport = boolAssembleReport;
      this.boolAssembleInspection = boolAssembleInspection;
      this.boolAssembleComplete = boolAssembleComplete;
      this.boolAssembleInproduce = boolAssembleInproduce;
      this.boolOneCode = boolOneCode;
      this.boolSecondUse = boolSecondUse;
   }

   public Long getId() {
      return this.id;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   public Long getArtifactTaskProcessId() {
      return this.artifactTaskProcessId;
   }

   public Integer getArtifactNumber() {
      return this.artifactNumber;
   }

   public Long getArtifactNextProcessId() {
      return this.artifactNextProcessId;
   }

   public Boolean getBoolArtifactReport() {
      return this.boolArtifactReport;
   }

   public Boolean getBoolArtifactInspection() {
      return this.boolArtifactInspection;
   }

   public Boolean getBoolArtifactComplete() {
      return this.boolArtifactComplete;
   }

   public Boolean getBoolArtifactInproduce() {
      return this.boolArtifactInproduce;
   }

   public Long getAssembleId() {
      return this.assembleId;
   }

   public Long getAssembleTaskId() {
      return this.assembleTaskId;
   }

   public Long getAssembleTaskProcessId() {
      return this.assembleTaskProcessId;
   }

   public Long getAssembleNextProcessId() {
      return this.assembleNextProcessId;
   }

   public Integer getAssembleNumber() {
      return this.assembleNumber;
   }

   public Boolean getBoolAssembleReport() {
      return this.boolAssembleReport;
   }

   public Boolean getBoolAssembleInspection() {
      return this.boolAssembleInspection;
   }

   public Boolean getBoolAssembleComplete() {
      return this.boolAssembleComplete;
   }

   public Boolean getBoolAssembleInproduce() {
      return this.boolAssembleInproduce;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public Boolean getBoolSecondUse() {
      return this.boolSecondUse;
   }

   public MesBuildingTaskNumberLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingTaskNumberLink setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   public MesBuildingTaskNumberLink setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
      return this;
   }

   public MesBuildingTaskNumberLink setArtifactTaskProcessId(final Long artifactTaskProcessId) {
      this.artifactTaskProcessId = artifactTaskProcessId;
      return this;
   }

   public MesBuildingTaskNumberLink setArtifactNumber(final Integer artifactNumber) {
      this.artifactNumber = artifactNumber;
      return this;
   }

   public MesBuildingTaskNumberLink setArtifactNextProcessId(final Long artifactNextProcessId) {
      this.artifactNextProcessId = artifactNextProcessId;
      return this;
   }

   public MesBuildingTaskNumberLink setBoolArtifactReport(final Boolean boolArtifactReport) {
      this.boolArtifactReport = boolArtifactReport;
      return this;
   }

   public MesBuildingTaskNumberLink setBoolArtifactInspection(final Boolean boolArtifactInspection) {
      this.boolArtifactInspection = boolArtifactInspection;
      return this;
   }

   public MesBuildingTaskNumberLink setBoolArtifactComplete(final Boolean boolArtifactComplete) {
      this.boolArtifactComplete = boolArtifactComplete;
      return this;
   }

   public MesBuildingTaskNumberLink setBoolArtifactInproduce(final Boolean boolArtifactInproduce) {
      this.boolArtifactInproduce = boolArtifactInproduce;
      return this;
   }

   public MesBuildingTaskNumberLink setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   public MesBuildingTaskNumberLink setAssembleTaskId(final Long assembleTaskId) {
      this.assembleTaskId = assembleTaskId;
      return this;
   }

   public MesBuildingTaskNumberLink setAssembleTaskProcessId(final Long assembleTaskProcessId) {
      this.assembleTaskProcessId = assembleTaskProcessId;
      return this;
   }

   public MesBuildingTaskNumberLink setAssembleNextProcessId(final Long assembleNextProcessId) {
      this.assembleNextProcessId = assembleNextProcessId;
      return this;
   }

   public MesBuildingTaskNumberLink setAssembleNumber(final Integer assembleNumber) {
      this.assembleNumber = assembleNumber;
      return this;
   }

   public MesBuildingTaskNumberLink setBoolAssembleReport(final Boolean boolAssembleReport) {
      this.boolAssembleReport = boolAssembleReport;
      return this;
   }

   public MesBuildingTaskNumberLink setBoolAssembleInspection(final Boolean boolAssembleInspection) {
      this.boolAssembleInspection = boolAssembleInspection;
      return this;
   }

   public MesBuildingTaskNumberLink setBoolAssembleComplete(final Boolean boolAssembleComplete) {
      this.boolAssembleComplete = boolAssembleComplete;
      return this;
   }

   public MesBuildingTaskNumberLink setBoolAssembleInproduce(final Boolean boolAssembleInproduce) {
      this.boolAssembleInproduce = boolAssembleInproduce;
      return this;
   }

   public MesBuildingTaskNumberLink setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
      return this;
   }

   public MesBuildingTaskNumberLink setBoolSecondUse(final Boolean boolSecondUse) {
      this.boolSecondUse = boolSecondUse;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskNumberLink(id="
         + this.getId()
         + ", artifactId="
         + this.getArtifactId()
         + ", artifactTaskId="
         + this.getArtifactTaskId()
         + ", artifactTaskProcessId="
         + this.getArtifactTaskProcessId()
         + ", artifactNumber="
         + this.getArtifactNumber()
         + ", artifactNextProcessId="
         + this.getArtifactNextProcessId()
         + ", boolArtifactReport="
         + this.getBoolArtifactReport()
         + ", boolArtifactInspection="
         + this.getBoolArtifactInspection()
         + ", boolArtifactComplete="
         + this.getBoolArtifactComplete()
         + ", boolArtifactInproduce="
         + this.getBoolArtifactInproduce()
         + ", assembleId="
         + this.getAssembleId()
         + ", assembleTaskId="
         + this.getAssembleTaskId()
         + ", assembleTaskProcessId="
         + this.getAssembleTaskProcessId()
         + ", assembleNextProcessId="
         + this.getAssembleNextProcessId()
         + ", assembleNumber="
         + this.getAssembleNumber()
         + ", boolAssembleReport="
         + this.getBoolAssembleReport()
         + ", boolAssembleInspection="
         + this.getBoolAssembleInspection()
         + ", boolAssembleComplete="
         + this.getBoolAssembleComplete()
         + ", boolAssembleInproduce="
         + this.getBoolAssembleInproduce()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", boolSecondUse="
         + this.getBoolSecondUse()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskNumberLink)) {
         return false;
      }

      MesBuildingTaskNumberLink other = (MesBuildingTaskNumberLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactId = this.getArtifactId();
         Object other$artifactId = other.getArtifactId();
         if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
            Object this$artifactTaskId = this.getArtifactTaskId();
            Object other$artifactTaskId = other.getArtifactTaskId();
            if (this$artifactTaskId == null ? other$artifactTaskId == null : this$artifactTaskId.equals(other$artifactTaskId)) {
               Object this$artifactTaskProcessId = this.getArtifactTaskProcessId();
               Object other$artifactTaskProcessId = other.getArtifactTaskProcessId();
               if (this$artifactTaskProcessId == null ? other$artifactTaskProcessId == null : this$artifactTaskProcessId.equals(other$artifactTaskProcessId)) {
                  Object this$artifactNumber = this.getArtifactNumber();
                  Object other$artifactNumber = other.getArtifactNumber();
                  if (this$artifactNumber == null ? other$artifactNumber == null : this$artifactNumber.equals(other$artifactNumber)) {
                     Object this$artifactNextProcessId = this.getArtifactNextProcessId();
                     Object other$artifactNextProcessId = other.getArtifactNextProcessId();
                     if (this$artifactNextProcessId == null
                        ? other$artifactNextProcessId == null
                        : this$artifactNextProcessId.equals(other$artifactNextProcessId)) {
                        Object this$boolArtifactReport = this.getBoolArtifactReport();
                        Object other$boolArtifactReport = other.getBoolArtifactReport();
                        if (this$boolArtifactReport == null ? other$boolArtifactReport == null : this$boolArtifactReport.equals(other$boolArtifactReport)) {
                           Object this$boolArtifactInspection = this.getBoolArtifactInspection();
                           Object other$boolArtifactInspection = other.getBoolArtifactInspection();
                           if (this$boolArtifactInspection == null
                              ? other$boolArtifactInspection == null
                              : this$boolArtifactInspection.equals(other$boolArtifactInspection)) {
                              Object this$boolArtifactComplete = this.getBoolArtifactComplete();
                              Object other$boolArtifactComplete = other.getBoolArtifactComplete();
                              if (this$boolArtifactComplete == null
                                 ? other$boolArtifactComplete == null
                                 : this$boolArtifactComplete.equals(other$boolArtifactComplete)) {
                                 Object this$boolArtifactInproduce = this.getBoolArtifactInproduce();
                                 Object other$boolArtifactInproduce = other.getBoolArtifactInproduce();
                                 if (this$boolArtifactInproduce == null
                                    ? other$boolArtifactInproduce == null
                                    : this$boolArtifactInproduce.equals(other$boolArtifactInproduce)) {
                                    Object this$assembleId = this.getAssembleId();
                                    Object other$assembleId = other.getAssembleId();
                                    if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
                                       Object this$assembleTaskId = this.getAssembleTaskId();
                                       Object other$assembleTaskId = other.getAssembleTaskId();
                                       if (this$assembleTaskId == null ? other$assembleTaskId == null : this$assembleTaskId.equals(other$assembleTaskId)) {
                                          Object this$assembleTaskProcessId = this.getAssembleTaskProcessId();
                                          Object other$assembleTaskProcessId = other.getAssembleTaskProcessId();
                                          if (this$assembleTaskProcessId == null
                                             ? other$assembleTaskProcessId == null
                                             : this$assembleTaskProcessId.equals(other$assembleTaskProcessId)) {
                                             Object this$assembleNextProcessId = this.getAssembleNextProcessId();
                                             Object other$assembleNextProcessId = other.getAssembleNextProcessId();
                                             if (this$assembleNextProcessId == null
                                                ? other$assembleNextProcessId == null
                                                : this$assembleNextProcessId.equals(other$assembleNextProcessId)) {
                                                Object this$assembleNumber = this.getAssembleNumber();
                                                Object other$assembleNumber = other.getAssembleNumber();
                                                if (this$assembleNumber == null
                                                   ? other$assembleNumber == null
                                                   : this$assembleNumber.equals(other$assembleNumber)) {
                                                   Object this$boolAssembleReport = this.getBoolAssembleReport();
                                                   Object other$boolAssembleReport = other.getBoolAssembleReport();
                                                   if (this$boolAssembleReport == null
                                                      ? other$boolAssembleReport == null
                                                      : this$boolAssembleReport.equals(other$boolAssembleReport)) {
                                                      Object this$boolAssembleInspection = this.getBoolAssembleInspection();
                                                      Object other$boolAssembleInspection = other.getBoolAssembleInspection();
                                                      if (this$boolAssembleInspection == null
                                                         ? other$boolAssembleInspection == null
                                                         : this$boolAssembleInspection.equals(other$boolAssembleInspection)) {
                                                         Object this$boolAssembleComplete = this.getBoolAssembleComplete();
                                                         Object other$boolAssembleComplete = other.getBoolAssembleComplete();
                                                         if (this$boolAssembleComplete == null
                                                            ? other$boolAssembleComplete == null
                                                            : this$boolAssembleComplete.equals(other$boolAssembleComplete)) {
                                                            Object this$boolAssembleInproduce = this.getBoolAssembleInproduce();
                                                            Object other$boolAssembleInproduce = other.getBoolAssembleInproduce();
                                                            if (this$boolAssembleInproduce == null
                                                               ? other$boolAssembleInproduce == null
                                                               : this$boolAssembleInproduce.equals(other$boolAssembleInproduce)) {
                                                               Object this$boolOneCode = this.getBoolOneCode();
                                                               Object other$boolOneCode = other.getBoolOneCode();
                                                               if (this$boolOneCode == null
                                                                  ? other$boolOneCode == null
                                                                  : this$boolOneCode.equals(other$boolOneCode)) {
                                                                  Object this$boolSecondUse = this.getBoolSecondUse();
                                                                  Object other$boolSecondUse = other.getBoolSecondUse();
                                                                  return this$boolSecondUse == null
                                                                     ? other$boolSecondUse == null
                                                                     : this$boolSecondUse.equals(other$boolSecondUse);
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
      return other instanceof MesBuildingTaskNumberLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $artifactTaskId = this.getArtifactTaskId();
      result = result * 59 + ($artifactTaskId == null ? 43 : $artifactTaskId.hashCode());
      Object $artifactTaskProcessId = this.getArtifactTaskProcessId();
      result = result * 59 + ($artifactTaskProcessId == null ? 43 : $artifactTaskProcessId.hashCode());
      Object $artifactNumber = this.getArtifactNumber();
      result = result * 59 + ($artifactNumber == null ? 43 : $artifactNumber.hashCode());
      Object $artifactNextProcessId = this.getArtifactNextProcessId();
      result = result * 59 + ($artifactNextProcessId == null ? 43 : $artifactNextProcessId.hashCode());
      Object $boolArtifactReport = this.getBoolArtifactReport();
      result = result * 59 + ($boolArtifactReport == null ? 43 : $boolArtifactReport.hashCode());
      Object $boolArtifactInspection = this.getBoolArtifactInspection();
      result = result * 59 + ($boolArtifactInspection == null ? 43 : $boolArtifactInspection.hashCode());
      Object $boolArtifactComplete = this.getBoolArtifactComplete();
      result = result * 59 + ($boolArtifactComplete == null ? 43 : $boolArtifactComplete.hashCode());
      Object $boolArtifactInproduce = this.getBoolArtifactInproduce();
      result = result * 59 + ($boolArtifactInproduce == null ? 43 : $boolArtifactInproduce.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $assembleTaskId = this.getAssembleTaskId();
      result = result * 59 + ($assembleTaskId == null ? 43 : $assembleTaskId.hashCode());
      Object $assembleTaskProcessId = this.getAssembleTaskProcessId();
      result = result * 59 + ($assembleTaskProcessId == null ? 43 : $assembleTaskProcessId.hashCode());
      Object $assembleNextProcessId = this.getAssembleNextProcessId();
      result = result * 59 + ($assembleNextProcessId == null ? 43 : $assembleNextProcessId.hashCode());
      Object $assembleNumber = this.getAssembleNumber();
      result = result * 59 + ($assembleNumber == null ? 43 : $assembleNumber.hashCode());
      Object $boolAssembleReport = this.getBoolAssembleReport();
      result = result * 59 + ($boolAssembleReport == null ? 43 : $boolAssembleReport.hashCode());
      Object $boolAssembleInspection = this.getBoolAssembleInspection();
      result = result * 59 + ($boolAssembleInspection == null ? 43 : $boolAssembleInspection.hashCode());
      Object $boolAssembleComplete = this.getBoolAssembleComplete();
      result = result * 59 + ($boolAssembleComplete == null ? 43 : $boolAssembleComplete.hashCode());
      Object $boolAssembleInproduce = this.getBoolAssembleInproduce();
      result = result * 59 + ($boolAssembleInproduce == null ? 43 : $boolAssembleInproduce.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $boolSecondUse = this.getBoolSecondUse();
      return result * 59 + ($boolSecondUse == null ? 43 : $boolSecondUse.hashCode());
   }

   public static class MesBuildingTaskNumberLinkBuilder {
      private Long id;
      private Long artifactId;
      private Long artifactTaskId;
      private Long artifactTaskProcessId;
      private Integer artifactNumber;
      private Long artifactNextProcessId;
      private Boolean boolArtifactReport;
      private Boolean boolArtifactInspection;
      private Boolean boolArtifactComplete;
      private Boolean boolArtifactInproduce;
      private Long assembleId;
      private Long assembleTaskId;
      private Long assembleTaskProcessId;
      private Long assembleNextProcessId;
      private Integer assembleNumber;
      private Boolean boolAssembleReport;
      private Boolean boolAssembleInspection;
      private Boolean boolAssembleComplete;
      private Boolean boolAssembleInproduce;
      private Boolean boolOneCode;
      private Boolean boolSecondUse;

      MesBuildingTaskNumberLinkBuilder() {
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder artifactTaskId(final Long artifactTaskId) {
         this.artifactTaskId = artifactTaskId;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder artifactTaskProcessId(final Long artifactTaskProcessId) {
         this.artifactTaskProcessId = artifactTaskProcessId;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder artifactNumber(final Integer artifactNumber) {
         this.artifactNumber = artifactNumber;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder artifactNextProcessId(final Long artifactNextProcessId) {
         this.artifactNextProcessId = artifactNextProcessId;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder boolArtifactReport(final Boolean boolArtifactReport) {
         this.boolArtifactReport = boolArtifactReport;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder boolArtifactInspection(final Boolean boolArtifactInspection) {
         this.boolArtifactInspection = boolArtifactInspection;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder boolArtifactComplete(final Boolean boolArtifactComplete) {
         this.boolArtifactComplete = boolArtifactComplete;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder boolArtifactInproduce(final Boolean boolArtifactInproduce) {
         this.boolArtifactInproduce = boolArtifactInproduce;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder assembleTaskId(final Long assembleTaskId) {
         this.assembleTaskId = assembleTaskId;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder assembleTaskProcessId(final Long assembleTaskProcessId) {
         this.assembleTaskProcessId = assembleTaskProcessId;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder assembleNextProcessId(final Long assembleNextProcessId) {
         this.assembleNextProcessId = assembleNextProcessId;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder assembleNumber(final Integer assembleNumber) {
         this.assembleNumber = assembleNumber;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder boolAssembleReport(final Boolean boolAssembleReport) {
         this.boolAssembleReport = boolAssembleReport;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder boolAssembleInspection(final Boolean boolAssembleInspection) {
         this.boolAssembleInspection = boolAssembleInspection;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder boolAssembleComplete(final Boolean boolAssembleComplete) {
         this.boolAssembleComplete = boolAssembleComplete;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder boolAssembleInproduce(final Boolean boolAssembleInproduce) {
         this.boolAssembleInproduce = boolAssembleInproduce;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder boolOneCode(final Boolean boolOneCode) {
         this.boolOneCode = boolOneCode;
         return this;
      }

      public MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder boolSecondUse(final Boolean boolSecondUse) {
         this.boolSecondUse = boolSecondUse;
         return this;
      }

      public MesBuildingTaskNumberLink build() {
         return new MesBuildingTaskNumberLink(
            this.id,
            this.artifactId,
            this.artifactTaskId,
            this.artifactTaskProcessId,
            this.artifactNumber,
            this.artifactNextProcessId,
            this.boolArtifactReport,
            this.boolArtifactInspection,
            this.boolArtifactComplete,
            this.boolArtifactInproduce,
            this.assembleId,
            this.assembleTaskId,
            this.assembleTaskProcessId,
            this.assembleNextProcessId,
            this.assembleNumber,
            this.boolAssembleReport,
            this.boolAssembleInspection,
            this.boolAssembleComplete,
            this.boolAssembleInproduce,
            this.boolOneCode,
            this.boolSecondUse
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskNumberLink.MesBuildingTaskNumberLinkBuilder(id="
            + this.id
            + ", artifactId="
            + this.artifactId
            + ", artifactTaskId="
            + this.artifactTaskId
            + ", artifactTaskProcessId="
            + this.artifactTaskProcessId
            + ", artifactNumber="
            + this.artifactNumber
            + ", artifactNextProcessId="
            + this.artifactNextProcessId
            + ", boolArtifactReport="
            + this.boolArtifactReport
            + ", boolArtifactInspection="
            + this.boolArtifactInspection
            + ", boolArtifactComplete="
            + this.boolArtifactComplete
            + ", boolArtifactInproduce="
            + this.boolArtifactInproduce
            + ", assembleId="
            + this.assembleId
            + ", assembleTaskId="
            + this.assembleTaskId
            + ", assembleTaskProcessId="
            + this.assembleTaskProcessId
            + ", assembleNextProcessId="
            + this.assembleNextProcessId
            + ", assembleNumber="
            + this.assembleNumber
            + ", boolAssembleReport="
            + this.boolAssembleReport
            + ", boolAssembleInspection="
            + this.boolAssembleInspection
            + ", boolAssembleComplete="
            + this.boolAssembleComplete
            + ", boolAssembleInproduce="
            + this.boolAssembleInproduce
            + ", boolOneCode="
            + this.boolOneCode
            + ", boolSecondUse="
            + this.boolSecondUse
            + ")";
      }
   }
}
