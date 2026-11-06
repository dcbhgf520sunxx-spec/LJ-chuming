package com.hzchum.scim.contract.core.api.pojo.dto.audit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("审计信息")
public class AuditUserDTOExcel {
   @ApiModelProperty("用户ID")
   private Long userId;
   @ApiModelProperty("用户名")
   private String userName;
   @ApiModelProperty("到达时间")
   private String arriveTime;
   @ApiModelProperty("审批时间")
   private String approveTime;
   @ApiModelProperty("审批结果")
   private Integer approveResult;
   @ApiModelProperty("审批类型")
   private String approveType;
   @ApiModelProperty("审批意见")
   private String approveOpinion;

   public static AuditUserDTOExcel.AuditUserDTOExcelBuilder builder() {
      return new AuditUserDTOExcel.AuditUserDTOExcelBuilder();
   }

   public AuditUserDTOExcel(
      final Long userId,
      final String userName,
      final String arriveTime,
      final String approveTime,
      final Integer approveResult,
      final String approveType,
      final String approveOpinion
   ) {
      this.userId = userId;
      this.userName = userName;
      this.arriveTime = arriveTime;
      this.approveTime = approveTime;
      this.approveResult = approveResult;
      this.approveType = approveType;
      this.approveOpinion = approveOpinion;
   }

   public AuditUserDTOExcel() {
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getArriveTime() {
      return this.arriveTime;
   }

   public String getApproveTime() {
      return this.approveTime;
   }

   public Integer getApproveResult() {
      return this.approveResult;
   }

   public String getApproveType() {
      return this.approveType;
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

   public void setArriveTime(final String arriveTime) {
      this.arriveTime = arriveTime;
   }

   public void setApproveTime(final String approveTime) {
      this.approveTime = approveTime;
   }

   public void setApproveResult(final Integer approveResult) {
      this.approveResult = approveResult;
   }

   public void setApproveType(final String approveType) {
      this.approveType = approveType;
   }

   public void setApproveOpinion(final String approveOpinion) {
      this.approveOpinion = approveOpinion;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuditUserDTOExcel)) {
         return false;
      }

      AuditUserDTOExcel other = (AuditUserDTOExcel)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$approveResult = this.getApproveResult();
         Object other$approveResult = other.getApproveResult();
         if (this$approveResult == null ? other$approveResult == null : this$approveResult.equals(other$approveResult)) {
            Object this$userName = this.getUserName();
            Object other$userName = other.getUserName();
            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
               Object this$arriveTime = this.getArriveTime();
               Object other$arriveTime = other.getArriveTime();
               if (this$arriveTime == null ? other$arriveTime == null : this$arriveTime.equals(other$arriveTime)) {
                  Object this$approveTime = this.getApproveTime();
                  Object other$approveTime = other.getApproveTime();
                  if (this$approveTime == null ? other$approveTime == null : this$approveTime.equals(other$approveTime)) {
                     Object this$approveType = this.getApproveType();
                     Object other$approveType = other.getApproveType();
                     if (this$approveType == null ? other$approveType == null : this$approveType.equals(other$approveType)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AuditUserDTOExcel;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $approveResult = this.getApproveResult();
      result = result * 59 + ($approveResult == null ? 43 : $approveResult.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $arriveTime = this.getArriveTime();
      result = result * 59 + ($arriveTime == null ? 43 : $arriveTime.hashCode());
      Object $approveTime = this.getApproveTime();
      result = result * 59 + ($approveTime == null ? 43 : $approveTime.hashCode());
      Object $approveType = this.getApproveType();
      result = result * 59 + ($approveType == null ? 43 : $approveType.hashCode());
      Object $approveOpinion = this.getApproveOpinion();
      return result * 59 + ($approveOpinion == null ? 43 : $approveOpinion.hashCode());
   }

   @Override
   public String toString() {
      return "AuditUserDTOExcel(userId="
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
         + ", approveOpinion="
         + this.getApproveOpinion()
         + ")";
   }

   public static class AuditUserDTOExcelBuilder {
      private Long userId;
      private String userName;
      private String arriveTime;
      private String approveTime;
      private Integer approveResult;
      private String approveType;
      private String approveOpinion;

      AuditUserDTOExcelBuilder() {
      }

      public AuditUserDTOExcel.AuditUserDTOExcelBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public AuditUserDTOExcel.AuditUserDTOExcelBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public AuditUserDTOExcel.AuditUserDTOExcelBuilder arriveTime(final String arriveTime) {
         this.arriveTime = arriveTime;
         return this;
      }

      public AuditUserDTOExcel.AuditUserDTOExcelBuilder approveTime(final String approveTime) {
         this.approveTime = approveTime;
         return this;
      }

      public AuditUserDTOExcel.AuditUserDTOExcelBuilder approveResult(final Integer approveResult) {
         this.approveResult = approveResult;
         return this;
      }

      public AuditUserDTOExcel.AuditUserDTOExcelBuilder approveType(final String approveType) {
         this.approveType = approveType;
         return this;
      }

      public AuditUserDTOExcel.AuditUserDTOExcelBuilder approveOpinion(final String approveOpinion) {
         this.approveOpinion = approveOpinion;
         return this;
      }

      public AuditUserDTOExcel build() {
         return new AuditUserDTOExcel(this.userId, this.userName, this.arriveTime, this.approveTime, this.approveResult, this.approveType, this.approveOpinion);
      }

      @Override
      public String toString() {
         return "AuditUserDTOExcel.AuditUserDTOExcelBuilder(userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", arriveTime="
            + this.arriveTime
            + ", approveTime="
            + this.approveTime
            + ", approveResult="
            + this.approveResult
            + ", approveType="
            + this.approveType
            + ", approveOpinion="
            + this.approveOpinion
            + ")";
      }
   }
}
