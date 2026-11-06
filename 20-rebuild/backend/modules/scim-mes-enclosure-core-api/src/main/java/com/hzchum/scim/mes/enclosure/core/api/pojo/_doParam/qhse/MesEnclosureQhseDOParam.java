package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;

@ApiModel(value = "MesEnclosureQhseDOParam对象", description = "问题曝光 ")
public class MesEnclosureQhseDOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "planId", value = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "factoryId", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "taskId", value = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "processId", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   @TableField("task_process_id ")
   @Column(name = "task_process_id ")
   private Long taskProcessId;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "problemQuantity", notes = "问题上报数量")
   @JsonProperty("problemQuantity")
   @JSONField(name = "problemQuantity")
   private Integer problemQuantity;
   @ApiModelProperty(name = "problemDrawing", notes = "问题上报图片ids")
   @JsonProperty("problemDrawing")
   @JSONField(name = "problemDrawing")
   private String problemDrawing;
   @ApiModelProperty(name = "userId", value = "申请人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "dutyId", value = "责任人id")
   @JsonProperty("dutyId")
   @JSONField(name = "dutyId")
   private Long dutyId;
   @ApiModelProperty(name = "teamId", value = "责任人班组")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "type", value = "问题类型 [1质量问题2安全问题3环境问题]")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "remark", value = "问题描述")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "qualityType", value = "质量问题类型")
   @JsonProperty("qualityType")
   @JSONField(name = "qualityType")
   private String qualityType;
   @ApiModelProperty(name = "askRectifyTime", value = "要求整改日期")
   @JsonProperty("askRectifyTime")
   @JSONField(name = "askRectifyTime")
   private LocalDateTime askRectifyTime;
   @ApiModelProperty(name = "forfeit", value = "罚金")
   @JsonProperty("forfeit")
   @JSONField(name = "forfeit")
   private BigDecimal forfeit;
   @ApiModelProperty(name = "status", value = "状态 [1待整改2已整改4已关闭]")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;

   public static MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder builder() {
      return new MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder();
   }

   public MesEnclosureQhseDOParam() {
   }

   public MesEnclosureQhseDOParam(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long taskId,
      final Long processId,
      final Long taskProcessId,
      final Long productId,
      final Integer productType,
      final Integer problemQuantity,
      final String problemDrawing,
      final Long userId,
      final Long dutyId,
      final Long teamId,
      final Integer type,
      final String remark,
      final String qualityType,
      final LocalDateTime askRectifyTime,
      final BigDecimal forfeit,
      final Integer status
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.taskId = taskId;
      this.processId = processId;
      this.taskProcessId = taskProcessId;
      this.productId = productId;
      this.productType = productType;
      this.problemQuantity = problemQuantity;
      this.problemDrawing = problemDrawing;
      this.userId = userId;
      this.dutyId = dutyId;
      this.teamId = teamId;
      this.type = type;
      this.remark = remark;
      this.qualityType = qualityType;
      this.askRectifyTime = askRectifyTime;
      this.forfeit = forfeit;
      this.status = status;
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

   public Long getPlanId() {
      return this.planId;
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

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
   }

   public String getProblemDrawing() {
      return this.problemDrawing;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getDutyId() {
      return this.dutyId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getType() {
      return this.type;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getQualityType() {
      return this.qualityType;
   }

   public LocalDateTime getAskRectifyTime() {
      return this.askRectifyTime;
   }

   public BigDecimal getForfeit() {
      return this.forfeit;
   }

   public Integer getStatus() {
      return this.status;
   }

   @JsonProperty("id")
   public MesEnclosureQhseDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureQhseDOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureQhseDOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public MesEnclosureQhseDOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureQhseDOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureQhseDOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureQhseDOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("taskId")
   public MesEnclosureQhseDOParam setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureQhseDOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesEnclosureQhseDOParam setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureQhseDOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureQhseDOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("problemQuantity")
   public MesEnclosureQhseDOParam setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("problemDrawing")
   public MesEnclosureQhseDOParam setProblemDrawing(final String problemDrawing) {
      this.problemDrawing = problemDrawing;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureQhseDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("dutyId")
   public MesEnclosureQhseDOParam setDutyId(final Long dutyId) {
      this.dutyId = dutyId;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureQhseDOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("type")
   public MesEnclosureQhseDOParam setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("remark")
   public MesEnclosureQhseDOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("qualityType")
   public MesEnclosureQhseDOParam setQualityType(final String qualityType) {
      this.qualityType = qualityType;
      return this;
   }

   @JsonProperty("askRectifyTime")
   public MesEnclosureQhseDOParam setAskRectifyTime(final LocalDateTime askRectifyTime) {
      this.askRectifyTime = askRectifyTime;
      return this;
   }

   @JsonProperty("forfeit")
   public MesEnclosureQhseDOParam setForfeit(final BigDecimal forfeit) {
      this.forfeit = forfeit;
      return this;
   }

   @JsonProperty("status")
   public MesEnclosureQhseDOParam setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureQhseDOParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", taskId="
         + this.getTaskId()
         + ", processId="
         + this.getProcessId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ", problemDrawing="
         + this.getProblemDrawing()
         + ", userId="
         + this.getUserId()
         + ", dutyId="
         + this.getDutyId()
         + ", teamId="
         + this.getTeamId()
         + ", type="
         + this.getType()
         + ", remark="
         + this.getRemark()
         + ", qualityType="
         + this.getQualityType()
         + ", askRectifyTime="
         + this.getAskRectifyTime()
         + ", forfeit="
         + this.getForfeit()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureQhseDOParam)) {
         return false;
      }

      MesEnclosureQhseDOParam other = (MesEnclosureQhseDOParam)o;
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
               Object this$planId = this.getPlanId();
               Object other$planId = other.getPlanId();
               if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$workshopId = this.getWorkshopId();
                     Object other$workshopId = other.getWorkshopId();
                     if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                        Object this$productionLineId = this.getProductionLineId();
                        Object other$productionLineId = other.getProductionLineId();
                        if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                           Object this$taskId = this.getTaskId();
                           Object other$taskId = other.getTaskId();
                           if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                              Object this$processId = this.getProcessId();
                              Object other$processId = other.getProcessId();
                              if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                 Object this$taskProcessId = this.getTaskProcessId();
                                 Object other$taskProcessId = other.getTaskProcessId();
                                 if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
                                    Object this$productId = this.getProductId();
                                    Object other$productId = other.getProductId();
                                    if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                       Object this$productType = this.getProductType();
                                       Object other$productType = other.getProductType();
                                       if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                          Object this$problemQuantity = this.getProblemQuantity();
                                          Object other$problemQuantity = other.getProblemQuantity();
                                          if (this$problemQuantity == null ? other$problemQuantity == null : this$problemQuantity.equals(other$problemQuantity)
                                             )
                                           {
                                             Object this$userId = this.getUserId();
                                             Object other$userId = other.getUserId();
                                             if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                Object this$dutyId = this.getDutyId();
                                                Object other$dutyId = other.getDutyId();
                                                if (this$dutyId == null ? other$dutyId == null : this$dutyId.equals(other$dutyId)) {
                                                   Object this$teamId = this.getTeamId();
                                                   Object other$teamId = other.getTeamId();
                                                   if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                                      Object this$type = this.getType();
                                                      Object other$type = other.getType();
                                                      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                                         Object this$status = this.getStatus();
                                                         Object other$status = other.getStatus();
                                                         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                                            Object this$problemDrawing = this.getProblemDrawing();
                                                            Object other$problemDrawing = other.getProblemDrawing();
                                                            if (this$problemDrawing == null
                                                               ? other$problemDrawing == null
                                                               : this$problemDrawing.equals(other$problemDrawing)) {
                                                               Object this$remark = this.getRemark();
                                                               Object other$remark = other.getRemark();
                                                               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                  Object this$qualityType = this.getQualityType();
                                                                  Object other$qualityType = other.getQualityType();
                                                                  if (this$qualityType == null
                                                                     ? other$qualityType == null
                                                                     : this$qualityType.equals(other$qualityType)) {
                                                                     Object this$askRectifyTime = this.getAskRectifyTime();
                                                                     Object other$askRectifyTime = other.getAskRectifyTime();
                                                                     if (this$askRectifyTime == null
                                                                        ? other$askRectifyTime == null
                                                                        : this$askRectifyTime.equals(other$askRectifyTime)) {
                                                                        Object this$forfeit = this.getForfeit();
                                                                        Object other$forfeit = other.getForfeit();
                                                                        return this$forfeit == null
                                                                           ? other$forfeit == null
                                                                           : this$forfeit.equals(other$forfeit);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureQhseDOParam;
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
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      result = result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $dutyId = this.getDutyId();
      result = result * 59 + ($dutyId == null ? 43 : $dutyId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $problemDrawing = this.getProblemDrawing();
      result = result * 59 + ($problemDrawing == null ? 43 : $problemDrawing.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $qualityType = this.getQualityType();
      result = result * 59 + ($qualityType == null ? 43 : $qualityType.hashCode());
      Object $askRectifyTime = this.getAskRectifyTime();
      result = result * 59 + ($askRectifyTime == null ? 43 : $askRectifyTime.hashCode());
      Object $forfeit = this.getForfeit();
      return result * 59 + ($forfeit == null ? 43 : $forfeit.hashCode());
   }

   public static class MesEnclosureQhseDOParamBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long taskId;
      private Long processId;
      private Long taskProcessId;
      private Long productId;
      private Integer productType;
      private Integer problemQuantity;
      private String problemDrawing;
      private Long userId;
      private Long dutyId;
      private Long teamId;
      private Integer type;
      private String remark;
      private String qualityType;
      private LocalDateTime askRectifyTime;
      private BigDecimal forfeit;
      private Integer status;

      MesEnclosureQhseDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("taskId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("problemQuantity")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("problemDrawing")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder problemDrawing(final String problemDrawing) {
         this.problemDrawing = problemDrawing;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("dutyId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder dutyId(final Long dutyId) {
         this.dutyId = dutyId;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("type")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("remark")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("qualityType")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder qualityType(final String qualityType) {
         this.qualityType = qualityType;
         return this;
      }

      @JsonProperty("askRectifyTime")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder askRectifyTime(final LocalDateTime askRectifyTime) {
         this.askRectifyTime = askRectifyTime;
         return this;
      }

      @JsonProperty("forfeit")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder forfeit(final BigDecimal forfeit) {
         this.forfeit = forfeit;
         return this;
      }

      @JsonProperty("status")
      public MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public MesEnclosureQhseDOParam build() {
         return new MesEnclosureQhseDOParam(
            this.id,
            this.projectId,
            this.monomerId,
            this.planId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.taskId,
            this.processId,
            this.taskProcessId,
            this.productId,
            this.productType,
            this.problemQuantity,
            this.problemDrawing,
            this.userId,
            this.dutyId,
            this.teamId,
            this.type,
            this.remark,
            this.qualityType,
            this.askRectifyTime,
            this.forfeit,
            this.status
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureQhseDOParam.MesEnclosureQhseDOParamBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", taskId="
            + this.taskId
            + ", processId="
            + this.processId
            + ", taskProcessId="
            + this.taskProcessId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", problemQuantity="
            + this.problemQuantity
            + ", problemDrawing="
            + this.problemDrawing
            + ", userId="
            + this.userId
            + ", dutyId="
            + this.dutyId
            + ", teamId="
            + this.teamId
            + ", type="
            + this.type
            + ", remark="
            + this.remark
            + ", qualityType="
            + this.qualityType
            + ", askRectifyTime="
            + this.askRectifyTime
            + ", forfeit="
            + this.forfeit
            + ", status="
            + this.status
            + ")";
      }
   }
}
