package com.hzchum.scim.rest.pojo.vo.mes.building.request.qhse.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.InspectionReportSavedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.ArtifactNumberQualifiedQuantityDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "QhseSaveCheckRequest", description = "抽检 ")
public class QhseSaveCheckRequest {
   @ApiModelProperty(name = "reportList", value = "问题上报关联的上报记录")
   @JsonProperty("reportList")
   @JSONField(name = "reportList")
   List<InspectionReportSavedDTO> reportList;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   private Long taskProcessId;
   @ApiModelProperty(name = "problemQuantity", notes = "问题上报数量")
   @JsonProperty("problemQuantity")
   @JSONField(name = "problemQuantity")
   private Integer problemQuantity;
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
   @ApiModelProperty(name = "askRectifyTime", value = "要求整改日期")
   @JsonProperty("askRectifyTime")
   @JSONField(name = "askRectifyTime")
   private LocalDateTime askRectifyTime;
   @ApiModelProperty(name = "forfeit", value = "罚金")
   @JsonProperty("forfeit")
   @JSONField(name = "forfeit")
   private BigDecimal forfeit;
   @ApiModelProperty(name = "userLink", value = "抄送人")
   @JsonProperty("userLink")
   @JSONField(name = "userLink")
   private List<Long> userLink;
   @ApiModelProperty(name = "drawingIds", value = "问题上报图片ids")
   @JsonProperty("drawingIds")
   @JSONField(name = "drawingIds")
   private List<Long> drawingIds;
   @ApiModelProperty(name = "qualityTypeValues", value = "问题类型")
   @JsonProperty("qualityTypeValues")
   @JSONField(name = "qualityTypeValues")
   private List<String> qualityTypeValues;
   @ApiModelProperty(name = "levelOneType", value = "一级分类id")
   @JsonProperty("levelOneType")
   @JSONField(name = "levelOneType")
   private Long levelOneType;
   @ApiModelProperty(name = "levelTwoType", value = "二级分类id")
   @JsonProperty("levelTwoType")
   @JSONField(name = "levelTwoType")
   private Long levelTwoType;
   @ApiModelProperty(name = "numberList", notes = "上报编号列表", value = "上报编号列表")
   @JsonProperty("numberList")
   @JSONField(name = "numberList")
   private List<Integer> numberList;
   @ApiModelProperty(name = "processId", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "taskId", value = "任务Id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "submitRemark", value = "让步接收理由")
   @JsonProperty("submitRemark")
   @JSONField(name = "submitRemark")
   private String submitRemark;
   @ApiModelProperty(name = "boolConcessionAcceptance", value = "是否让步接收")
   @JsonProperty("boolConcessionAcceptance")
   @JSONField(name = "boolConcessionAcceptance")
   private Boolean boolConcessionAcceptance;
   @ApiModelProperty(name = "boolNeedReply", value = "是否需要回复[0:无需1:需要]", notes = "是否需要回复[0:无需1:需要]")
   @JsonProperty("boolNeedReply")
   @JSONField(name = "boolNeedReply")
   private Boolean boolNeedReply;
   @ApiModelProperty(name = "drawingLabel", notes = "图纸标注")
   @JsonProperty("drawingLabel")
   @JSONField(name = "drawingLabel")
   private Long drawingLabel;
   @ApiModelProperty(name = "numberQualifiedList", value = "码号合格列表")
   @JsonProperty("numberQualifiedList")
   @JSONField(name = "numberQualifiedList")
   private List<ArtifactNumberQualifiedQuantityDTOParam> numberQualifiedList;
   @ApiModelProperty(name = "qualifiedQuantity", value = "合格数")
   @JsonProperty("qualifiedQuantity")
   @JSONField(name = "qualifiedQuantity")
   private Integer qualifiedQuantity;
   @ApiModelProperty(name = "unQualifiedQuantity", value = "不合格数")
   @JsonProperty("unQualifiedQuantity")
   @JSONField(name = "unQualifiedQuantity")
   private Integer unQualifiedQuantity;

   public static QhseSaveCheckRequest.QhseSaveCheckRequestBuilder builder() {
      return new QhseSaveCheckRequest.QhseSaveCheckRequestBuilder();
   }

   public QhseSaveCheckRequest() {
   }

   public QhseSaveCheckRequest(
      final List<InspectionReportSavedDTO> reportList,
      final Long taskProcessId,
      final Integer problemQuantity,
      final Long dutyId,
      final Long teamId,
      final Integer type,
      final String remark,
      final LocalDateTime askRectifyTime,
      final BigDecimal forfeit,
      final List<Long> userLink,
      final List<Long> drawingIds,
      final List<String> qualityTypeValues,
      final Long levelOneType,
      final Long levelTwoType,
      final List<Integer> numberList,
      final Long processId,
      final Long taskId,
      final String submitRemark,
      final Boolean boolConcessionAcceptance,
      final Boolean boolNeedReply,
      final Long drawingLabel,
      final List<ArtifactNumberQualifiedQuantityDTOParam> numberQualifiedList,
      final Integer qualifiedQuantity,
      final Integer unQualifiedQuantity
   ) {
      this.reportList = reportList;
      this.taskProcessId = taskProcessId;
      this.problemQuantity = problemQuantity;
      this.dutyId = dutyId;
      this.teamId = teamId;
      this.type = type;
      this.remark = remark;
      this.askRectifyTime = askRectifyTime;
      this.forfeit = forfeit;
      this.userLink = userLink;
      this.drawingIds = drawingIds;
      this.qualityTypeValues = qualityTypeValues;
      this.levelOneType = levelOneType;
      this.levelTwoType = levelTwoType;
      this.numberList = numberList;
      this.processId = processId;
      this.taskId = taskId;
      this.submitRemark = submitRemark;
      this.boolConcessionAcceptance = boolConcessionAcceptance;
      this.boolNeedReply = boolNeedReply;
      this.drawingLabel = drawingLabel;
      this.numberQualifiedList = numberQualifiedList;
      this.qualifiedQuantity = qualifiedQuantity;
      this.unQualifiedQuantity = unQualifiedQuantity;
   }

   public List<InspectionReportSavedDTO> getReportList() {
      return this.reportList;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
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

   public LocalDateTime getAskRectifyTime() {
      return this.askRectifyTime;
   }

   public BigDecimal getForfeit() {
      return this.forfeit;
   }

   public List<Long> getUserLink() {
      return this.userLink;
   }

   public List<Long> getDrawingIds() {
      return this.drawingIds;
   }

   public List<String> getQualityTypeValues() {
      return this.qualityTypeValues;
   }

   public Long getLevelOneType() {
      return this.levelOneType;
   }

   public Long getLevelTwoType() {
      return this.levelTwoType;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public String getSubmitRemark() {
      return this.submitRemark;
   }

   public Boolean getBoolConcessionAcceptance() {
      return this.boolConcessionAcceptance;
   }

   public Boolean getBoolNeedReply() {
      return this.boolNeedReply;
   }

   public Long getDrawingLabel() {
      return this.drawingLabel;
   }

   public List<ArtifactNumberQualifiedQuantityDTOParam> getNumberQualifiedList() {
      return this.numberQualifiedList;
   }

   public Integer getQualifiedQuantity() {
      return this.qualifiedQuantity;
   }

   public Integer getUnQualifiedQuantity() {
      return this.unQualifiedQuantity;
   }

   @JsonProperty("reportList")
   public QhseSaveCheckRequest setReportList(final List<InspectionReportSavedDTO> reportList) {
      this.reportList = reportList;
      return this;
   }

   @JsonProperty("taskProcessId")
   public QhseSaveCheckRequest setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("problemQuantity")
   public QhseSaveCheckRequest setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("dutyId")
   public QhseSaveCheckRequest setDutyId(final Long dutyId) {
      this.dutyId = dutyId;
      return this;
   }

   @JsonProperty("teamId")
   public QhseSaveCheckRequest setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("type")
   public QhseSaveCheckRequest setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("remark")
   public QhseSaveCheckRequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("askRectifyTime")
   public QhseSaveCheckRequest setAskRectifyTime(final LocalDateTime askRectifyTime) {
      this.askRectifyTime = askRectifyTime;
      return this;
   }

   @JsonProperty("forfeit")
   public QhseSaveCheckRequest setForfeit(final BigDecimal forfeit) {
      this.forfeit = forfeit;
      return this;
   }

   @JsonProperty("userLink")
   public QhseSaveCheckRequest setUserLink(final List<Long> userLink) {
      this.userLink = userLink;
      return this;
   }

   @JsonProperty("drawingIds")
   public QhseSaveCheckRequest setDrawingIds(final List<Long> drawingIds) {
      this.drawingIds = drawingIds;
      return this;
   }

   @JsonProperty("qualityTypeValues")
   public QhseSaveCheckRequest setQualityTypeValues(final List<String> qualityTypeValues) {
      this.qualityTypeValues = qualityTypeValues;
      return this;
   }

   @JsonProperty("levelOneType")
   public QhseSaveCheckRequest setLevelOneType(final Long levelOneType) {
      this.levelOneType = levelOneType;
      return this;
   }

   @JsonProperty("levelTwoType")
   public QhseSaveCheckRequest setLevelTwoType(final Long levelTwoType) {
      this.levelTwoType = levelTwoType;
      return this;
   }

   @JsonProperty("numberList")
   public QhseSaveCheckRequest setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @JsonProperty("processId")
   public QhseSaveCheckRequest setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("taskId")
   public QhseSaveCheckRequest setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("submitRemark")
   public QhseSaveCheckRequest setSubmitRemark(final String submitRemark) {
      this.submitRemark = submitRemark;
      return this;
   }

   @JsonProperty("boolConcessionAcceptance")
   public QhseSaveCheckRequest setBoolConcessionAcceptance(final Boolean boolConcessionAcceptance) {
      this.boolConcessionAcceptance = boolConcessionAcceptance;
      return this;
   }

   @JsonProperty("boolNeedReply")
   public QhseSaveCheckRequest setBoolNeedReply(final Boolean boolNeedReply) {
      this.boolNeedReply = boolNeedReply;
      return this;
   }

   @JsonProperty("drawingLabel")
   public QhseSaveCheckRequest setDrawingLabel(final Long drawingLabel) {
      this.drawingLabel = drawingLabel;
      return this;
   }

   @JsonProperty("numberQualifiedList")
   public QhseSaveCheckRequest setNumberQualifiedList(final List<ArtifactNumberQualifiedQuantityDTOParam> numberQualifiedList) {
      this.numberQualifiedList = numberQualifiedList;
      return this;
   }

   @JsonProperty("qualifiedQuantity")
   public QhseSaveCheckRequest setQualifiedQuantity(final Integer qualifiedQuantity) {
      this.qualifiedQuantity = qualifiedQuantity;
      return this;
   }

   @JsonProperty("unQualifiedQuantity")
   public QhseSaveCheckRequest setUnQualifiedQuantity(final Integer unQualifiedQuantity) {
      this.unQualifiedQuantity = unQualifiedQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "QhseSaveCheckRequest(reportList="
         + this.getReportList()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ", dutyId="
         + this.getDutyId()
         + ", teamId="
         + this.getTeamId()
         + ", type="
         + this.getType()
         + ", remark="
         + this.getRemark()
         + ", askRectifyTime="
         + this.getAskRectifyTime()
         + ", forfeit="
         + this.getForfeit()
         + ", userLink="
         + this.getUserLink()
         + ", drawingIds="
         + this.getDrawingIds()
         + ", qualityTypeValues="
         + this.getQualityTypeValues()
         + ", levelOneType="
         + this.getLevelOneType()
         + ", levelTwoType="
         + this.getLevelTwoType()
         + ", numberList="
         + this.getNumberList()
         + ", processId="
         + this.getProcessId()
         + ", taskId="
         + this.getTaskId()
         + ", submitRemark="
         + this.getSubmitRemark()
         + ", boolConcessionAcceptance="
         + this.getBoolConcessionAcceptance()
         + ", boolNeedReply="
         + this.getBoolNeedReply()
         + ", drawingLabel="
         + this.getDrawingLabel()
         + ", numberQualifiedList="
         + this.getNumberQualifiedList()
         + ", qualifiedQuantity="
         + this.getQualifiedQuantity()
         + ", unQualifiedQuantity="
         + this.getUnQualifiedQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseSaveCheckRequest)) {
         return false;
      }

      QhseSaveCheckRequest other = (QhseSaveCheckRequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskProcessId = this.getTaskProcessId();
      Object other$taskProcessId = other.getTaskProcessId();
      if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
         Object this$problemQuantity = this.getProblemQuantity();
         Object other$problemQuantity = other.getProblemQuantity();
         if (this$problemQuantity == null ? other$problemQuantity == null : this$problemQuantity.equals(other$problemQuantity)) {
            Object this$dutyId = this.getDutyId();
            Object other$dutyId = other.getDutyId();
            if (this$dutyId == null ? other$dutyId == null : this$dutyId.equals(other$dutyId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                     Object this$levelOneType = this.getLevelOneType();
                     Object other$levelOneType = other.getLevelOneType();
                     if (this$levelOneType == null ? other$levelOneType == null : this$levelOneType.equals(other$levelOneType)) {
                        Object this$levelTwoType = this.getLevelTwoType();
                        Object other$levelTwoType = other.getLevelTwoType();
                        if (this$levelTwoType == null ? other$levelTwoType == null : this$levelTwoType.equals(other$levelTwoType)) {
                           Object this$processId = this.getProcessId();
                           Object other$processId = other.getProcessId();
                           if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                              Object this$taskId = this.getTaskId();
                              Object other$taskId = other.getTaskId();
                              if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                                 Object this$boolConcessionAcceptance = this.getBoolConcessionAcceptance();
                                 Object other$boolConcessionAcceptance = other.getBoolConcessionAcceptance();
                                 if (this$boolConcessionAcceptance == null
                                    ? other$boolConcessionAcceptance == null
                                    : this$boolConcessionAcceptance.equals(other$boolConcessionAcceptance)) {
                                    Object this$boolNeedReply = this.getBoolNeedReply();
                                    Object other$boolNeedReply = other.getBoolNeedReply();
                                    if (this$boolNeedReply == null ? other$boolNeedReply == null : this$boolNeedReply.equals(other$boolNeedReply)) {
                                       Object this$drawingLabel = this.getDrawingLabel();
                                       Object other$drawingLabel = other.getDrawingLabel();
                                       if (this$drawingLabel == null ? other$drawingLabel == null : this$drawingLabel.equals(other$drawingLabel)) {
                                          Object this$qualifiedQuantity = this.getQualifiedQuantity();
                                          Object other$qualifiedQuantity = other.getQualifiedQuantity();
                                          if (this$qualifiedQuantity == null
                                             ? other$qualifiedQuantity == null
                                             : this$qualifiedQuantity.equals(other$qualifiedQuantity)) {
                                             Object this$unQualifiedQuantity = this.getUnQualifiedQuantity();
                                             Object other$unQualifiedQuantity = other.getUnQualifiedQuantity();
                                             if (this$unQualifiedQuantity == null
                                                ? other$unQualifiedQuantity == null
                                                : this$unQualifiedQuantity.equals(other$unQualifiedQuantity)) {
                                                Object this$reportList = this.getReportList();
                                                Object other$reportList = other.getReportList();
                                                if (this$reportList == null ? other$reportList == null : this$reportList.equals(other$reportList)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
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
                                                            if (this$userLink == null ? other$userLink == null : this$userLink.equals(other$userLink)) {
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
                                                                     if (this$numberList == null
                                                                        ? other$numberList == null
                                                                        : this$numberList.equals(other$numberList)) {
                                                                        Object this$submitRemark = this.getSubmitRemark();
                                                                        Object other$submitRemark = other.getSubmitRemark();
                                                                        if (this$submitRemark == null
                                                                           ? other$submitRemark == null
                                                                           : this$submitRemark.equals(other$submitRemark)) {
                                                                           Object this$numberQualifiedList = this.getNumberQualifiedList();
                                                                           Object other$numberQualifiedList = other.getNumberQualifiedList();
                                                                           return this$numberQualifiedList == null
                                                                              ? other$numberQualifiedList == null
                                                                              : this$numberQualifiedList.equals(other$numberQualifiedList);
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

   protected boolean canEqual(final Object other) {
      return other instanceof QhseSaveCheckRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      result = result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
      Object $dutyId = this.getDutyId();
      result = result * 59 + ($dutyId == null ? 43 : $dutyId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $levelOneType = this.getLevelOneType();
      result = result * 59 + ($levelOneType == null ? 43 : $levelOneType.hashCode());
      Object $levelTwoType = this.getLevelTwoType();
      result = result * 59 + ($levelTwoType == null ? 43 : $levelTwoType.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $boolConcessionAcceptance = this.getBoolConcessionAcceptance();
      result = result * 59 + ($boolConcessionAcceptance == null ? 43 : $boolConcessionAcceptance.hashCode());
      Object $boolNeedReply = this.getBoolNeedReply();
      result = result * 59 + ($boolNeedReply == null ? 43 : $boolNeedReply.hashCode());
      Object $drawingLabel = this.getDrawingLabel();
      result = result * 59 + ($drawingLabel == null ? 43 : $drawingLabel.hashCode());
      Object $qualifiedQuantity = this.getQualifiedQuantity();
      result = result * 59 + ($qualifiedQuantity == null ? 43 : $qualifiedQuantity.hashCode());
      Object $unQualifiedQuantity = this.getUnQualifiedQuantity();
      result = result * 59 + ($unQualifiedQuantity == null ? 43 : $unQualifiedQuantity.hashCode());
      Object $reportList = this.getReportList();
      result = result * 59 + ($reportList == null ? 43 : $reportList.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
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
      result = result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
      Object $submitRemark = this.getSubmitRemark();
      result = result * 59 + ($submitRemark == null ? 43 : $submitRemark.hashCode());
      Object $numberQualifiedList = this.getNumberQualifiedList();
      return result * 59 + ($numberQualifiedList == null ? 43 : $numberQualifiedList.hashCode());
   }

   public static class QhseSaveCheckRequestBuilder {
      private List<InspectionReportSavedDTO> reportList;
      private Long taskProcessId;
      private Integer problemQuantity;
      private Long dutyId;
      private Long teamId;
      private Integer type;
      private String remark;
      private LocalDateTime askRectifyTime;
      private BigDecimal forfeit;
      private List<Long> userLink;
      private List<Long> drawingIds;
      private List<String> qualityTypeValues;
      private Long levelOneType;
      private Long levelTwoType;
      private List<Integer> numberList;
      private Long processId;
      private Long taskId;
      private String submitRemark;
      private Boolean boolConcessionAcceptance;
      private Boolean boolNeedReply;
      private Long drawingLabel;
      private List<ArtifactNumberQualifiedQuantityDTOParam> numberQualifiedList;
      private Integer qualifiedQuantity;
      private Integer unQualifiedQuantity;

      QhseSaveCheckRequestBuilder() {
      }

      @JsonProperty("reportList")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder reportList(final List<InspectionReportSavedDTO> reportList) {
         this.reportList = reportList;
         return this;
      }

      @JsonProperty("taskProcessId")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("problemQuantity")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("dutyId")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder dutyId(final Long dutyId) {
         this.dutyId = dutyId;
         return this;
      }

      @JsonProperty("teamId")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("type")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("remark")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("askRectifyTime")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder askRectifyTime(final LocalDateTime askRectifyTime) {
         this.askRectifyTime = askRectifyTime;
         return this;
      }

      @JsonProperty("forfeit")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder forfeit(final BigDecimal forfeit) {
         this.forfeit = forfeit;
         return this;
      }

      @JsonProperty("userLink")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder userLink(final List<Long> userLink) {
         this.userLink = userLink;
         return this;
      }

      @JsonProperty("drawingIds")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder drawingIds(final List<Long> drawingIds) {
         this.drawingIds = drawingIds;
         return this;
      }

      @JsonProperty("qualityTypeValues")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder qualityTypeValues(final List<String> qualityTypeValues) {
         this.qualityTypeValues = qualityTypeValues;
         return this;
      }

      @JsonProperty("levelOneType")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder levelOneType(final Long levelOneType) {
         this.levelOneType = levelOneType;
         return this;
      }

      @JsonProperty("levelTwoType")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder levelTwoType(final Long levelTwoType) {
         this.levelTwoType = levelTwoType;
         return this;
      }

      @JsonProperty("numberList")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      @JsonProperty("processId")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("taskId")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("submitRemark")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder submitRemark(final String submitRemark) {
         this.submitRemark = submitRemark;
         return this;
      }

      @JsonProperty("boolConcessionAcceptance")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder boolConcessionAcceptance(final Boolean boolConcessionAcceptance) {
         this.boolConcessionAcceptance = boolConcessionAcceptance;
         return this;
      }

      @JsonProperty("boolNeedReply")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder boolNeedReply(final Boolean boolNeedReply) {
         this.boolNeedReply = boolNeedReply;
         return this;
      }

      @JsonProperty("drawingLabel")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder drawingLabel(final Long drawingLabel) {
         this.drawingLabel = drawingLabel;
         return this;
      }

      @JsonProperty("numberQualifiedList")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder numberQualifiedList(final List<ArtifactNumberQualifiedQuantityDTOParam> numberQualifiedList) {
         this.numberQualifiedList = numberQualifiedList;
         return this;
      }

      @JsonProperty("qualifiedQuantity")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder qualifiedQuantity(final Integer qualifiedQuantity) {
         this.qualifiedQuantity = qualifiedQuantity;
         return this;
      }

      @JsonProperty("unQualifiedQuantity")
      public QhseSaveCheckRequest.QhseSaveCheckRequestBuilder unQualifiedQuantity(final Integer unQualifiedQuantity) {
         this.unQualifiedQuantity = unQualifiedQuantity;
         return this;
      }

      public QhseSaveCheckRequest build() {
         return new QhseSaveCheckRequest(
            this.reportList,
            this.taskProcessId,
            this.problemQuantity,
            this.dutyId,
            this.teamId,
            this.type,
            this.remark,
            this.askRectifyTime,
            this.forfeit,
            this.userLink,
            this.drawingIds,
            this.qualityTypeValues,
            this.levelOneType,
            this.levelTwoType,
            this.numberList,
            this.processId,
            this.taskId,
            this.submitRemark,
            this.boolConcessionAcceptance,
            this.boolNeedReply,
            this.drawingLabel,
            this.numberQualifiedList,
            this.qualifiedQuantity,
            this.unQualifiedQuantity
         );
      }

      @Override
      public String toString() {
         return "QhseSaveCheckRequest.QhseSaveCheckRequestBuilder(reportList="
            + this.reportList
            + ", taskProcessId="
            + this.taskProcessId
            + ", problemQuantity="
            + this.problemQuantity
            + ", dutyId="
            + this.dutyId
            + ", teamId="
            + this.teamId
            + ", type="
            + this.type
            + ", remark="
            + this.remark
            + ", askRectifyTime="
            + this.askRectifyTime
            + ", forfeit="
            + this.forfeit
            + ", userLink="
            + this.userLink
            + ", drawingIds="
            + this.drawingIds
            + ", qualityTypeValues="
            + this.qualityTypeValues
            + ", levelOneType="
            + this.levelOneType
            + ", levelTwoType="
            + this.levelTwoType
            + ", numberList="
            + this.numberList
            + ", processId="
            + this.processId
            + ", taskId="
            + this.taskId
            + ", submitRemark="
            + this.submitRemark
            + ", boolConcessionAcceptance="
            + this.boolConcessionAcceptance
            + ", boolNeedReply="
            + this.boolNeedReply
            + ", drawingLabel="
            + this.drawingLabel
            + ", numberQualifiedList="
            + this.numberQualifiedList
            + ", qualifiedQuantity="
            + this.qualifiedQuantity
            + ", unQualifiedQuantity="
            + this.unQualifiedQuantity
            + ")";
      }
   }
}
