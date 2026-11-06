package com.hzchum.scim.common.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;

public class WmsApproveRecordDetailDTO implements Serializable {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "flowId", value = "流程ID", notes = "流程ID")
   private Long flowId;
   @ApiModelProperty(
      name = "flowType",
      value = "流程类型  1会签 2或签  3单签 4抄送 5发起申请 6质检 ApproveTemplateVersionsFlowEnum",
      notes = "流程类型  1会签 2或签  3单签 4抄送 5发起申请 6质检 ApproveTemplateVersionsFlowEnum"
   )
   private Integer flowType;
   @ApiModelProperty(name = "arrivalTime", value = "到达时间 流转到该节点的时间", notes = "到达时间 流转到该节点的时间")
   private LocalDateTime arrivalTime;
   @ApiModelProperty(name = "approveTime", value = "审批时间", notes = "审批时间")
   private LocalDateTime approveTime;
   @ApiModelProperty(name = "decision", value = "决策  1待决策  2通过 4 不通过 驳回 8撤销 CheckStatusEnum", notes = "决策  1待决策  2通过 4 不通过 驳回 8撤销 CheckStatusEnum")
   private Integer decision;
   @ApiModelProperty(name = "opinion", value = "意见", notes = "意见")
   private String opinion;
   @ApiModelProperty(name = "status", value = "状态 0未开始 1进行中  2结束 默认0 ApproveRecordStatusEnum", notes = "状态 0未开始 1进行中  2结束 默认0 ApproveRecordStatusEnum")
   private Integer status;
   @ApiModelProperty("审批人 或签和抄送的话多个人都需要展示出来  日志信息只有一条 但是需要生成多条返回对象")
   private UserSimpleResponseVO userSimpleResponseVOS;

   public Long getId() {
      return this.id;
   }

   public Long getFlowId() {
      return this.flowId;
   }

   public Integer getFlowType() {
      return this.flowType;
   }

   public LocalDateTime getArrivalTime() {
      return this.arrivalTime;
   }

   public LocalDateTime getApproveTime() {
      return this.approveTime;
   }

   public Integer getDecision() {
      return this.decision;
   }

   public String getOpinion() {
      return this.opinion;
   }

   public Integer getStatus() {
      return this.status;
   }

   public UserSimpleResponseVO getUserSimpleResponseVOS() {
      return this.userSimpleResponseVOS;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setFlowId(final Long flowId) {
      this.flowId = flowId;
   }

   public void setFlowType(final Integer flowType) {
      this.flowType = flowType;
   }

   public void setArrivalTime(final LocalDateTime arrivalTime) {
      this.arrivalTime = arrivalTime;
   }

   public void setApproveTime(final LocalDateTime approveTime) {
      this.approveTime = approveTime;
   }

   public void setDecision(final Integer decision) {
      this.decision = decision;
   }

   public void setOpinion(final String opinion) {
      this.opinion = opinion;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setUserSimpleResponseVOS(final UserSimpleResponseVO userSimpleResponseVOS) {
      this.userSimpleResponseVOS = userSimpleResponseVOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveRecordDetailDTO)) {
         return false;
      }

      WmsApproveRecordDetailDTO other = (WmsApproveRecordDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$flowId = this.getFlowId();
         Object other$flowId = other.getFlowId();
         if (this$flowId == null ? other$flowId == null : this$flowId.equals(other$flowId)) {
            Object this$flowType = this.getFlowType();
            Object other$flowType = other.getFlowType();
            if (this$flowType == null ? other$flowType == null : this$flowType.equals(other$flowType)) {
               Object this$decision = this.getDecision();
               Object other$decision = other.getDecision();
               if (this$decision == null ? other$decision == null : this$decision.equals(other$decision)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$arrivalTime = this.getArrivalTime();
                     Object other$arrivalTime = other.getArrivalTime();
                     if (this$arrivalTime == null ? other$arrivalTime == null : this$arrivalTime.equals(other$arrivalTime)) {
                        Object this$approveTime = this.getApproveTime();
                        Object other$approveTime = other.getApproveTime();
                        if (this$approveTime == null ? other$approveTime == null : this$approveTime.equals(other$approveTime)) {
                           Object this$opinion = this.getOpinion();
                           Object other$opinion = other.getOpinion();
                           if (this$opinion == null ? other$opinion == null : this$opinion.equals(other$opinion)) {
                              Object this$userSimpleResponseVOS = this.getUserSimpleResponseVOS();
                              Object other$userSimpleResponseVOS = other.getUserSimpleResponseVOS();
                              return this$userSimpleResponseVOS == null
                                 ? other$userSimpleResponseVOS == null
                                 : this$userSimpleResponseVOS.equals(other$userSimpleResponseVOS);
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
      return other instanceof WmsApproveRecordDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $flowId = this.getFlowId();
      result = result * 59 + ($flowId == null ? 43 : $flowId.hashCode());
      Object $flowType = this.getFlowType();
      result = result * 59 + ($flowType == null ? 43 : $flowType.hashCode());
      Object $decision = this.getDecision();
      result = result * 59 + ($decision == null ? 43 : $decision.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $arrivalTime = this.getArrivalTime();
      result = result * 59 + ($arrivalTime == null ? 43 : $arrivalTime.hashCode());
      Object $approveTime = this.getApproveTime();
      result = result * 59 + ($approveTime == null ? 43 : $approveTime.hashCode());
      Object $opinion = this.getOpinion();
      result = result * 59 + ($opinion == null ? 43 : $opinion.hashCode());
      Object $userSimpleResponseVOS = this.getUserSimpleResponseVOS();
      return result * 59 + ($userSimpleResponseVOS == null ? 43 : $userSimpleResponseVOS.hashCode());
   }

   @Override
   public String toString() {
      return "WmsApproveRecordDetailDTO(id="
         + this.getId()
         + ", flowId="
         + this.getFlowId()
         + ", flowType="
         + this.getFlowType()
         + ", arrivalTime="
         + this.getArrivalTime()
         + ", approveTime="
         + this.getApproveTime()
         + ", decision="
         + this.getDecision()
         + ", opinion="
         + this.getOpinion()
         + ", status="
         + this.getStatus()
         + ", userSimpleResponseVOS="
         + this.getUserSimpleResponseVOS()
         + ")";
   }
}
