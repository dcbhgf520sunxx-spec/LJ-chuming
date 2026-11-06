package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.dtoPatamUtils.IdsDtoParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureQhseDTOParam", description = "问题曝光 ")
public class MesEnclosureQhseDTOParam extends BaseEntity<Long> {
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
   @NotNull(message = "问题类型不能为空")
   private Integer type;
   @ApiModelProperty(name = "remark", value = "问题描述")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @NotNull(message = "问题类型不能为空")
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
   @ApiModelProperty(name = "userLink", value = "抄送人")
   @JsonProperty("userLink")
   @JSONField(name = "userLink")
   private IdsDtoParam userLink;
   @ApiModelProperty(name = "drawingIds", value = "问题上报图片ids")
   @JsonProperty("drawingIds")
   @JSONField(name = "drawingIds")
   private IdsDtoParam drawingIds;
   @ApiModelProperty(name = "qualityTypeValues", value = "问题类型")
   @JsonProperty("qualityTypeValues")
   @JSONField(name = "qualityTypeValues")
   private List<String> qualityTypeValues;
   @ApiModelProperty(name = "numberList", notes = "上报编号列表", value = "上报编号列表")
   @JsonProperty("numberList")
   @JSONField(name = "numberList")
   private List<Integer> numberList;

   public static MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder builder() {
      return new MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder();
   }

   public MesEnclosureQhseDTOParam() {
   }

   public MesEnclosureQhseDTOParam(
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
      final Integer status,
      final IdsDtoParam userLink,
      final IdsDtoParam drawingIds,
      final List<String> qualityTypeValues,
      final List<Integer> numberList
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
      this.userLink = userLink;
      this.drawingIds = drawingIds;
      this.qualityTypeValues = qualityTypeValues;
      this.numberList = numberList;
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

   public IdsDtoParam getUserLink() {
      return this.userLink;
   }

   public IdsDtoParam getDrawingIds() {
      return this.drawingIds;
   }

   public List<String> getQualityTypeValues() {
      return this.qualityTypeValues;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   @JsonProperty("id")
   public MesEnclosureQhseDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureQhseDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureQhseDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public MesEnclosureQhseDTOParam setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureQhseDTOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureQhseDTOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureQhseDTOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("taskId")
   public MesEnclosureQhseDTOParam setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureQhseDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesEnclosureQhseDTOParam setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureQhseDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureQhseDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("problemQuantity")
   public MesEnclosureQhseDTOParam setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("problemDrawing")
   public MesEnclosureQhseDTOParam setProblemDrawing(final String problemDrawing) {
      this.problemDrawing = problemDrawing;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureQhseDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("dutyId")
   public MesEnclosureQhseDTOParam setDutyId(final Long dutyId) {
      this.dutyId = dutyId;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureQhseDTOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("type")
   public MesEnclosureQhseDTOParam setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("remark")
   public MesEnclosureQhseDTOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("qualityType")
   public MesEnclosureQhseDTOParam setQualityType(final String qualityType) {
      this.qualityType = qualityType;
      return this;
   }

   @JsonProperty("askRectifyTime")
   public MesEnclosureQhseDTOParam setAskRectifyTime(final LocalDateTime askRectifyTime) {
      this.askRectifyTime = askRectifyTime;
      return this;
   }

   @JsonProperty("forfeit")
   public MesEnclosureQhseDTOParam setForfeit(final BigDecimal forfeit) {
      this.forfeit = forfeit;
      return this;
   }

   @JsonProperty("status")
   public MesEnclosureQhseDTOParam setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userLink")
   public MesEnclosureQhseDTOParam setUserLink(final IdsDtoParam userLink) {
      this.userLink = userLink;
      return this;
   }

   @JsonProperty("drawingIds")
   public MesEnclosureQhseDTOParam setDrawingIds(final IdsDtoParam drawingIds) {
      this.drawingIds = drawingIds;
      return this;
   }

   @JsonProperty("qualityTypeValues")
   public MesEnclosureQhseDTOParam setQualityTypeValues(final List<String> qualityTypeValues) {
      this.qualityTypeValues = qualityTypeValues;
      return this;
   }

   @JsonProperty("numberList")
   public MesEnclosureQhseDTOParam setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureQhseDTOParam(id="
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
         + ", userLink="
         + this.getUserLink()
         + ", drawingIds="
         + this.getDrawingIds()
         + ", qualityTypeValues="
         + this.getQualityTypeValues()
         + ", numberList="
         + this.getNumberList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureQhseDTOParam)) {
         return false;
      }

      MesEnclosureQhseDTOParam other = (MesEnclosureQhseDTOParam)o;
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
                                                                        if (this$forfeit == null ? other$forfeit == null : this$forfeit.equals(other$forfeit)) {
                                                                           Object this$userLink = this.getUserLink();
                                                                           Object other$userLink = other.getUserLink();
                                                                           if (this$userLink == null
                                                                              ? other$userLink == null
                                                                              : this$userLink.equals(other$userLink)) {
                                                                              Object this$drawingIds = this.getDrawingIds();
                                                                              Object other$drawingIds = other.getDrawingIds();
                                                                              if (this$drawingIds == null
                                                                                 ? other$drawingIds == null
                                                                                 : this$drawingIds.equals(other$drawingIds)) {
                                                                                 Object this$qualityTypeValues = this.getQualityTypeValues();
                                                                                 Object other$qualityTypeValues = other.getQualityTypeValues();
                                                                                 if (this$qualityTypeValues == null
                                                                                    ? other$qualityTypeValues == null
                                                                                    : this$qualityTypeValues.equals(other$qualityTypeValues)) {
                                                                                    Object this$numberList = this.getNumberList();
                                                                                    Object other$numberList = other.getNumberList();
                                                                                    return this$numberList == null
                                                                                       ? other$numberList == null
                                                                                       : this$numberList.equals(other$numberList);
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
      return other instanceof MesEnclosureQhseDTOParam;
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
      result = result * 59 + ($forfeit == null ? 43 : $forfeit.hashCode());
      Object $userLink = this.getUserLink();
      result = result * 59 + ($userLink == null ? 43 : $userLink.hashCode());
      Object $drawingIds = this.getDrawingIds();
      result = result * 59 + ($drawingIds == null ? 43 : $drawingIds.hashCode());
      Object $qualityTypeValues = this.getQualityTypeValues();
      result = result * 59 + ($qualityTypeValues == null ? 43 : $qualityTypeValues.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   public static class MesEnclosureQhseDTOParamBuilder {
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
      private IdsDtoParam userLink;
      private IdsDtoParam drawingIds;
      private List<String> qualityTypeValues;
      private List<Integer> numberList;

      MesEnclosureQhseDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("taskId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("problemQuantity")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("problemDrawing")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder problemDrawing(final String problemDrawing) {
         this.problemDrawing = problemDrawing;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("dutyId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder dutyId(final Long dutyId) {
         this.dutyId = dutyId;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("type")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("remark")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("qualityType")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder qualityType(final String qualityType) {
         this.qualityType = qualityType;
         return this;
      }

      @JsonProperty("askRectifyTime")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder askRectifyTime(final LocalDateTime askRectifyTime) {
         this.askRectifyTime = askRectifyTime;
         return this;
      }

      @JsonProperty("forfeit")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder forfeit(final BigDecimal forfeit) {
         this.forfeit = forfeit;
         return this;
      }

      @JsonProperty("status")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("userLink")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder userLink(final IdsDtoParam userLink) {
         this.userLink = userLink;
         return this;
      }

      @JsonProperty("drawingIds")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder drawingIds(final IdsDtoParam drawingIds) {
         this.drawingIds = drawingIds;
         return this;
      }

      @JsonProperty("qualityTypeValues")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder qualityTypeValues(final List<String> qualityTypeValues) {
         this.qualityTypeValues = qualityTypeValues;
         return this;
      }

      @JsonProperty("numberList")
      public MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      public MesEnclosureQhseDTOParam build() {
         return new MesEnclosureQhseDTOParam(
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
            this.status,
            this.userLink,
            this.drawingIds,
            this.qualityTypeValues,
            this.numberList
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureQhseDTOParam.MesEnclosureQhseDTOParamBuilder(id="
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
            + ", userLink="
            + this.userLink
            + ", drawingIds="
            + this.drawingIds
            + ", qualityTypeValues="
            + this.qualityTypeValues
            + ", numberList="
            + this.numberList
            + ")";
      }
   }
}
