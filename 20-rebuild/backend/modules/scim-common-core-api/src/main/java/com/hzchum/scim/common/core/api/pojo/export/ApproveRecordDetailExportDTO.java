package com.hzchum.scim.common.core.api.pojo.export;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.io.Serializable;

public class ApproveRecordDetailExportDTO implements Serializable {
   @Excel(name = "节点", orderNum = "0")
   private String flowTypeName;
   @Excel(name = "审批人", orderNum = "1")
   private String checkUserName;
   @Excel(name = "到达时间", orderNum = "2")
   private String arrivalTimeStr;
   @Excel(name = "审批时间", orderNum = "3")
   private String approveTimeStr;
   @Excel(name = "审批结果", orderNum = "4")
   private String decisionStr;
   @Excel(name = "审批意见", orderNum = "5")
   private String opinion;
   private Integer flowType;
   private Long flowId;

   public String getFlowTypeName() {
      return this.flowTypeName;
   }

   public String getCheckUserName() {
      return this.checkUserName;
   }

   public String getArrivalTimeStr() {
      return this.arrivalTimeStr;
   }

   public String getApproveTimeStr() {
      return this.approveTimeStr;
   }

   public String getDecisionStr() {
      return this.decisionStr;
   }

   public String getOpinion() {
      return this.opinion;
   }

   public Integer getFlowType() {
      return this.flowType;
   }

   public Long getFlowId() {
      return this.flowId;
   }

   public void setFlowTypeName(final String flowTypeName) {
      this.flowTypeName = flowTypeName;
   }

   public void setCheckUserName(final String checkUserName) {
      this.checkUserName = checkUserName;
   }

   public void setArrivalTimeStr(final String arrivalTimeStr) {
      this.arrivalTimeStr = arrivalTimeStr;
   }

   public void setApproveTimeStr(final String approveTimeStr) {
      this.approveTimeStr = approveTimeStr;
   }

   public void setDecisionStr(final String decisionStr) {
      this.decisionStr = decisionStr;
   }

   public void setOpinion(final String opinion) {
      this.opinion = opinion;
   }

   public void setFlowType(final Integer flowType) {
      this.flowType = flowType;
   }

   public void setFlowId(final Long flowId) {
      this.flowId = flowId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApproveRecordDetailExportDTO)) {
         return false;
      }

      ApproveRecordDetailExportDTO other = (ApproveRecordDetailExportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$flowType = this.getFlowType();
      Object other$flowType = other.getFlowType();
      if (this$flowType == null ? other$flowType == null : this$flowType.equals(other$flowType)) {
         Object this$flowId = this.getFlowId();
         Object other$flowId = other.getFlowId();
         if (this$flowId == null ? other$flowId == null : this$flowId.equals(other$flowId)) {
            Object this$flowTypeName = this.getFlowTypeName();
            Object other$flowTypeName = other.getFlowTypeName();
            if (this$flowTypeName == null ? other$flowTypeName == null : this$flowTypeName.equals(other$flowTypeName)) {
               Object this$checkUserName = this.getCheckUserName();
               Object other$checkUserName = other.getCheckUserName();
               if (this$checkUserName == null ? other$checkUserName == null : this$checkUserName.equals(other$checkUserName)) {
                  Object this$arrivalTimeStr = this.getArrivalTimeStr();
                  Object other$arrivalTimeStr = other.getArrivalTimeStr();
                  if (this$arrivalTimeStr == null ? other$arrivalTimeStr == null : this$arrivalTimeStr.equals(other$arrivalTimeStr)) {
                     Object this$approveTimeStr = this.getApproveTimeStr();
                     Object other$approveTimeStr = other.getApproveTimeStr();
                     if (this$approveTimeStr == null ? other$approveTimeStr == null : this$approveTimeStr.equals(other$approveTimeStr)) {
                        Object this$decisionStr = this.getDecisionStr();
                        Object other$decisionStr = other.getDecisionStr();
                        if (this$decisionStr == null ? other$decisionStr == null : this$decisionStr.equals(other$decisionStr)) {
                           Object this$opinion = this.getOpinion();
                           Object other$opinion = other.getOpinion();
                           return this$opinion == null ? other$opinion == null : this$opinion.equals(other$opinion);
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
      return other instanceof ApproveRecordDetailExportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $flowType = this.getFlowType();
      result = result * 59 + ($flowType == null ? 43 : $flowType.hashCode());
      Object $flowId = this.getFlowId();
      result = result * 59 + ($flowId == null ? 43 : $flowId.hashCode());
      Object $flowTypeName = this.getFlowTypeName();
      result = result * 59 + ($flowTypeName == null ? 43 : $flowTypeName.hashCode());
      Object $checkUserName = this.getCheckUserName();
      result = result * 59 + ($checkUserName == null ? 43 : $checkUserName.hashCode());
      Object $arrivalTimeStr = this.getArrivalTimeStr();
      result = result * 59 + ($arrivalTimeStr == null ? 43 : $arrivalTimeStr.hashCode());
      Object $approveTimeStr = this.getApproveTimeStr();
      result = result * 59 + ($approveTimeStr == null ? 43 : $approveTimeStr.hashCode());
      Object $decisionStr = this.getDecisionStr();
      result = result * 59 + ($decisionStr == null ? 43 : $decisionStr.hashCode());
      Object $opinion = this.getOpinion();
      return result * 59 + ($opinion == null ? 43 : $opinion.hashCode());
   }

   @Override
   public String toString() {
      return "ApproveRecordDetailExportDTO(flowTypeName="
         + this.getFlowTypeName()
         + ", checkUserName="
         + this.getCheckUserName()
         + ", arrivalTimeStr="
         + this.getArrivalTimeStr()
         + ", approveTimeStr="
         + this.getApproveTimeStr()
         + ", decisionStr="
         + this.getDecisionStr()
         + ", opinion="
         + this.getOpinion()
         + ", flowType="
         + this.getFlowType()
         + ", flowId="
         + this.getFlowId()
         + ")";
   }
}
