package com.hzchum.scim.common.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.vo.UserSimpleResponseVO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class WmsApproveFlowDTO {
   @ApiModelProperty("该流程的状态 0未开始  1进行中 2 通过 4驳回 8 撤销")
   private Integer reviewStatus;
   @ApiModelProperty("该审批流程type类型对应typeName")
   private Integer type;
   @ApiModelProperty("该审批流程名称")
   private String typeName;
   @ApiModelProperty("用户信息集合")
   private List<UserSimpleResponseVO> userSimpleResponseVOS;
   @ApiModelProperty("审批日志详情信息")
   private List<WmsApproveRecordDetailDTO> wmsApproveRecordDetailDTOS;

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Integer getType() {
      return this.type;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public List<UserSimpleResponseVO> getUserSimpleResponseVOS() {
      return this.userSimpleResponseVOS;
   }

   public List<WmsApproveRecordDetailDTO> getWmsApproveRecordDetailDTOS() {
      return this.wmsApproveRecordDetailDTOS;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setUserSimpleResponseVOS(final List<UserSimpleResponseVO> userSimpleResponseVOS) {
      this.userSimpleResponseVOS = userSimpleResponseVOS;
   }

   public void setWmsApproveRecordDetailDTOS(final List<WmsApproveRecordDetailDTO> wmsApproveRecordDetailDTOS) {
      this.wmsApproveRecordDetailDTOS = wmsApproveRecordDetailDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveFlowDTO)) {
         return false;
      }

      WmsApproveFlowDTO other = (WmsApproveFlowDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reviewStatus = this.getReviewStatus();
      Object other$reviewStatus = other.getReviewStatus();
      if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$typeName = this.getTypeName();
            Object other$typeName = other.getTypeName();
            if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
               Object this$userSimpleResponseVOS = this.getUserSimpleResponseVOS();
               Object other$userSimpleResponseVOS = other.getUserSimpleResponseVOS();
               if (this$userSimpleResponseVOS == null ? other$userSimpleResponseVOS == null : this$userSimpleResponseVOS.equals(other$userSimpleResponseVOS)) {
                  Object this$wmsApproveRecordDetailDTOS = this.getWmsApproveRecordDetailDTOS();
                  Object other$wmsApproveRecordDetailDTOS = other.getWmsApproveRecordDetailDTOS();
                  return this$wmsApproveRecordDetailDTOS == null
                     ? other$wmsApproveRecordDetailDTOS == null
                     : this$wmsApproveRecordDetailDTOS.equals(other$wmsApproveRecordDetailDTOS);
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
      return other instanceof WmsApproveFlowDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $userSimpleResponseVOS = this.getUserSimpleResponseVOS();
      result = result * 59 + ($userSimpleResponseVOS == null ? 43 : $userSimpleResponseVOS.hashCode());
      Object $wmsApproveRecordDetailDTOS = this.getWmsApproveRecordDetailDTOS();
      return result * 59 + ($wmsApproveRecordDetailDTOS == null ? 43 : $wmsApproveRecordDetailDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "WmsApproveFlowDTO(reviewStatus="
         + this.getReviewStatus()
         + ", type="
         + this.getType()
         + ", typeName="
         + this.getTypeName()
         + ", userSimpleResponseVOS="
         + this.getUserSimpleResponseVOS()
         + ", wmsApproveRecordDetailDTOS="
         + this.getWmsApproveRecordDetailDTOS()
         + ")";
   }
}
