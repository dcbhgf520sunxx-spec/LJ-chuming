package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("审计信息")
public class AuditUserDTO {
   @ApiModelProperty("用户ID")
   private Long userId;
   @ApiModelProperty("用户名")
   private String userName;
   @ApiModelProperty("到达时间")
   private LocalDateTime arriveTime;
   @ApiModelProperty("审批时间")
   private LocalDateTime approveTime;
   @ApiModelProperty("审批结果")
   private Integer approveResult;
   @ApiModelProperty("审批类型")
   private Integer approveType;
   @ApiModelProperty("审批类型")
   private String approveTypeName;
   @ApiModelProperty("审批意见")
   private String approveOpinion;

   public AuditUserDTO(
      final Long userId,
      final String userName,
      final LocalDateTime arriveTime,
      final LocalDateTime approveTime,
      final Integer approveResult,
      final Integer approveType,
      final String approveTypeName,
      final String approveOpinion
   ) {
      this.userId = userId;
      this.userName = userName;
      this.arriveTime = arriveTime;
      this.approveTime = approveTime;
      this.approveResult = approveResult;
      this.approveType = approveType;
      this.approveTypeName = approveTypeName;
      this.approveOpinion = approveOpinion;
   }

   public AuditUserDTO() {
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getArriveTime() {
      return this.arriveTime;
   }

   public LocalDateTime getApproveTime() {
      return this.approveTime;
   }

   public Integer getApproveResult() {
      return this.approveResult;
   }

   public Integer getApproveType() {
      return this.approveType;
   }

   public String getApproveTypeName() {
      return this.approveTypeName;
   }

   public String getApproveOpinion() {
      return this.approveOpinion;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setArriveTime(final LocalDateTime arriveTime) {
      this.arriveTime = arriveTime;
   }

   public void setApproveTime(final LocalDateTime approveTime) {
      this.approveTime = approveTime;
   }

   public void setApproveResult(final Integer approveResult) {
      this.approveResult = approveResult;
   }

   public void setApproveType(final Integer approveType) {
      this.approveType = approveType;
   }

   public void setApproveTypeName(final String approveTypeName) {
      this.approveTypeName = approveTypeName;
   }

   public void setApproveOpinion(final String approveOpinion) {
      this.approveOpinion = approveOpinion;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuditUserDTO)) {
         return false;
      }

      AuditUserDTO other = (AuditUserDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$approveResult = this.getApproveResult();
         Object other$approveResult = other.getApproveResult();
         if (this$approveResult == null ? other$approveResult == null : this$approveResult.equals(other$approveResult)) {
            Object this$approveType = this.getApproveType();
            Object other$approveType = other.getApproveType();
            if (this$approveType == null ? other$approveType == null : this$approveType.equals(other$approveType)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                  Object this$arriveTime = this.getArriveTime();
                  Object other$arriveTime = other.getArriveTime();
                  if (this$arriveTime == null ? other$arriveTime == null : this$arriveTime.equals(other$arriveTime)) {
                     Object this$approveTime = this.getApproveTime();
                     Object other$approveTime = other.getApproveTime();
                     if (this$approveTime == null ? other$approveTime == null : this$approveTime.equals(other$approveTime)) {
                        Object this$approveTypeName = this.getApproveTypeName();
                        Object other$approveTypeName = other.getApproveTypeName();
                        if (this$approveTypeName == null ? other$approveTypeName == null : this$approveTypeName.equals(other$approveTypeName)) {
                           Object this$approveOpinion = this.getApproveOpinion();
                           Object other$approveOpinion = other.getApproveOpinion();
                           return this$approveOpinion == null ? other$approveOpinion == null : this$approveOpinion.equals(other$approveOpinion);
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
      return other instanceof AuditUserDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $approveResult = this.getApproveResult();
      result = result * 59 + ($approveResult == null ? 43 : $approveResult.hashCode());
      Object $approveType = this.getApproveType();
      result = result * 59 + ($approveType == null ? 43 : $approveType.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $arriveTime = this.getArriveTime();
      result = result * 59 + ($arriveTime == null ? 43 : $arriveTime.hashCode());
      Object $approveTime = this.getApproveTime();
      result = result * 59 + ($approveTime == null ? 43 : $approveTime.hashCode());
      Object $approveTypeName = this.getApproveTypeName();
      result = result * 59 + ($approveTypeName == null ? 43 : $approveTypeName.hashCode());
      Object $approveOpinion = this.getApproveOpinion();
      return result * 59 + ($approveOpinion == null ? 43 : $approveOpinion.hashCode());
   }

   @Override
   public String toString() {
      return "AuditUserDTO(userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", arriveTime="
         + this.getArriveTime()
         + ", approveTime="
         + this.getApproveTime()
         + ", approveResult="
         + this.getApproveResult()
         + ", approveType="
         + this.getApproveType()
         + ", approveTypeName="
         + this.getApproveTypeName()
         + ", approveOpinion="
         + this.getApproveOpinion()
         + ")";
   }
}
