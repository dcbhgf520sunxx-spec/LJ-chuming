package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.qhse.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.dtoPatamUtils.IdsDtoParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "QhseSaveRequest", description = "问题曝光 ")
public class QhseSaveRequest {
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
   @NotNull(message = "责任人不能为空")
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
   @ApiModelProperty(name = "processId", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "taskId", value = "任务Id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;

   public static QhseSaveRequest.QhseSaveRequestBuilder builder() {
      return new QhseSaveRequest.QhseSaveRequestBuilder();
   }

   public QhseSaveRequest() {
   }

   public QhseSaveRequest(
      final Long taskProcessId,
      final Integer problemQuantity,
      final Long dutyId,
      final Long teamId,
      final Integer type,
      final String remark,
      final LocalDateTime askRectifyTime,
      final BigDecimal forfeit,
      final IdsDtoParam userLink,
      final IdsDtoParam drawingIds,
      final List<String> qualityTypeValues,
      final List<Integer> numberList,
      final Long processId,
      final Long taskId
   ) {
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
      this.numberList = numberList;
      this.processId = processId;
      this.taskId = taskId;
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

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   @JsonProperty("taskProcessId")
   public QhseSaveRequest setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("problemQuantity")
   public QhseSaveRequest setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("dutyId")
   public QhseSaveRequest setDutyId(final Long dutyId) {
      this.dutyId = dutyId;
      return this;
   }

   @JsonProperty("teamId")
   public QhseSaveRequest setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("type")
   public QhseSaveRequest setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("remark")
   public QhseSaveRequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("askRectifyTime")
   public QhseSaveRequest setAskRectifyTime(final LocalDateTime askRectifyTime) {
      this.askRectifyTime = askRectifyTime;
      return this;
   }

   @JsonProperty("forfeit")
   public QhseSaveRequest setForfeit(final BigDecimal forfeit) {
      this.forfeit = forfeit;
      return this;
   }

   @JsonProperty("userLink")
   public QhseSaveRequest setUserLink(final IdsDtoParam userLink) {
      this.userLink = userLink;
      return this;
   }

   @JsonProperty("drawingIds")
   public QhseSaveRequest setDrawingIds(final IdsDtoParam drawingIds) {
      this.drawingIds = drawingIds;
      return this;
   }

   @JsonProperty("qualityTypeValues")
   public QhseSaveRequest setQualityTypeValues(final List<String> qualityTypeValues) {
      this.qualityTypeValues = qualityTypeValues;
      return this;
   }

   @JsonProperty("numberList")
   public QhseSaveRequest setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @JsonProperty("processId")
   public QhseSaveRequest setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("taskId")
   public QhseSaveRequest setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @Override
   public String toString() {
      return "QhseSaveRequest(taskProcessId="
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
         + ", numberList="
         + this.getNumberList()
         + ", processId="
         + this.getProcessId()
         + ", taskId="
         + this.getTaskId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseSaveRequest)) {
         return false;
      }

      QhseSaveRequest other = (QhseSaveRequest)o;
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
                     Object this$processId = this.getProcessId();
                     Object other$processId = other.getProcessId();
                     if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                        Object this$taskId = this.getTaskId();
                        Object other$taskId = other.getTaskId();
                        if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$askRectifyTime = this.getAskRectifyTime();
                              Object other$askRectifyTime = other.getAskRectifyTime();
                              if (this$askRectifyTime == null ? other$askRectifyTime == null : this$askRectifyTime.equals(other$askRectifyTime)) {
                                 Object this$forfeit = this.getForfeit();
                                 Object other$forfeit = other.getForfeit();
                                 if (this$forfeit == null ? other$forfeit == null : this$forfeit.equals(other$forfeit)) {
                                    Object this$userLink = this.getUserLink();
                                    Object other$userLink = other.getUserLink();
                                    if (this$userLink == null ? other$userLink == null : this$userLink.equals(other$userLink)) {
                                       Object this$drawingIds = this.getDrawingIds();
                                       Object other$drawingIds = other.getDrawingIds();
                                       if (this$drawingIds == null ? other$drawingIds == null : this$drawingIds.equals(other$drawingIds)) {
                                          Object this$qualityTypeValues = this.getQualityTypeValues();
                                          Object other$qualityTypeValues = other.getQualityTypeValues();
                                          if (this$qualityTypeValues == null
                                             ? other$qualityTypeValues == null
                                             : this$qualityTypeValues.equals(other$qualityTypeValues)) {
                                             Object this$numberList = this.getNumberList();
                                             Object other$numberList = other.getNumberList();
                                             return this$numberList == null ? other$numberList == null : this$numberList.equals(other$numberList);
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
      return other instanceof QhseSaveRequest;
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
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
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
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   public static class QhseSaveRequestBuilder {
      private Long taskProcessId;
      private Integer problemQuantity;
      private Long dutyId;
      private Long teamId;
      private Integer type;
      private String remark;
      private LocalDateTime askRectifyTime;
      private BigDecimal forfeit;
      private IdsDtoParam userLink;
      private IdsDtoParam drawingIds;
      private List<String> qualityTypeValues;
      private List<Integer> numberList;
      private Long processId;
      private Long taskId;

      QhseSaveRequestBuilder() {
      }

      @JsonProperty("taskProcessId")
      public QhseSaveRequest.QhseSaveRequestBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("problemQuantity")
      public QhseSaveRequest.QhseSaveRequestBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("dutyId")
      public QhseSaveRequest.QhseSaveRequestBuilder dutyId(final Long dutyId) {
         this.dutyId = dutyId;
         return this;
      }

      @JsonProperty("teamId")
      public QhseSaveRequest.QhseSaveRequestBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("type")
      public QhseSaveRequest.QhseSaveRequestBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("remark")
      public QhseSaveRequest.QhseSaveRequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("askRectifyTime")
      public QhseSaveRequest.QhseSaveRequestBuilder askRectifyTime(final LocalDateTime askRectifyTime) {
         this.askRectifyTime = askRectifyTime;
         return this;
      }

      @JsonProperty("forfeit")
      public QhseSaveRequest.QhseSaveRequestBuilder forfeit(final BigDecimal forfeit) {
         this.forfeit = forfeit;
         return this;
      }

      @JsonProperty("userLink")
      public QhseSaveRequest.QhseSaveRequestBuilder userLink(final IdsDtoParam userLink) {
         this.userLink = userLink;
         return this;
      }

      @JsonProperty("drawingIds")
      public QhseSaveRequest.QhseSaveRequestBuilder drawingIds(final IdsDtoParam drawingIds) {
         this.drawingIds = drawingIds;
         return this;
      }

      @JsonProperty("qualityTypeValues")
      public QhseSaveRequest.QhseSaveRequestBuilder qualityTypeValues(final List<String> qualityTypeValues) {
         this.qualityTypeValues = qualityTypeValues;
         return this;
      }

      @JsonProperty("numberList")
      public QhseSaveRequest.QhseSaveRequestBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      @JsonProperty("processId")
      public QhseSaveRequest.QhseSaveRequestBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("taskId")
      public QhseSaveRequest.QhseSaveRequestBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public QhseSaveRequest build() {
         return new QhseSaveRequest(
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
            this.numberList,
            this.processId,
            this.taskId
         );
      }

      @Override
      public String toString() {
         return "QhseSaveRequest.QhseSaveRequestBuilder(taskProcessId="
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
            + ", numberList="
            + this.numberList
            + ", processId="
            + this.processId
            + ", taskId="
            + this.taskId
            + ")";
      }
   }
}
