package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class CrmTheProjectLeaderDetailsDTOV2 {
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", notes = "项目信息id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "crmTenderRequirementTypeEnum", notes = "标类型")
   private Integer crmTenderRequirementTypeEnum;
   @ApiModelProperty(name = "projectBidManagerUserId", notes = "投标负责人")
   private Long projectBidManagerUserId;
   @ApiModelProperty(name = "projectBidManagerUserIdList", notes = "投标负责人id列表")
   private List<Long> projectBidManagerUserIdList;
   @ApiModelProperty(name = "projectBidManagerUserName", notes = "投标负责人名称")
   private String projectBidManagerUserName;
   @ApiModelProperty(name = "projectBidManagerFinishDate", notes = "投标完成日期")
   private LocalDateTime projectBidManagerFinishDate;
   @ApiModelProperty(name = "difficultyFactorId", notes = "难度系数")
   private Long difficultyFactorId;
   @ApiModelProperty(name = "difficultyFactorName", notes = "难度系数名称")
   private String difficultyFactorName;
   @ApiModelProperty(name = "bidManagerAttachments", value = "投标附件", notes = "投标附件")
   private List<AttachmentDTO> bidManagerAttachments;
   @ApiModelProperty(name = "isNeedFill", notes = "是否需要填写")
   private Boolean isNeedFill;
   @ApiModelProperty(name = "businessEssentials", value = "业务要点", notes = "业务要点")
   private String businessEssentials;

   public static CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder builder() {
      return new CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder();
   }

   public CrmTheProjectLeaderDetailsDTOV2() {
   }

   public CrmTheProjectLeaderDetailsDTOV2(
      final Long crmProjectInformationWarehousingId,
      final Integer crmTenderRequirementTypeEnum,
      final Long projectBidManagerUserId,
      final List<Long> projectBidManagerUserIdList,
      final String projectBidManagerUserName,
      final LocalDateTime projectBidManagerFinishDate,
      final Long difficultyFactorId,
      final String difficultyFactorName,
      final List<AttachmentDTO> bidManagerAttachments,
      final Boolean isNeedFill,
      final String businessEssentials
   ) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
      this.projectBidManagerUserId = projectBidManagerUserId;
      this.projectBidManagerUserIdList = projectBidManagerUserIdList;
      this.projectBidManagerUserName = projectBidManagerUserName;
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      this.difficultyFactorId = difficultyFactorId;
      this.difficultyFactorName = difficultyFactorName;
      this.bidManagerAttachments = bidManagerAttachments;
      this.isNeedFill = isNeedFill;
      this.businessEssentials = businessEssentials;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public Integer getCrmTenderRequirementTypeEnum() {
      return this.crmTenderRequirementTypeEnum;
   }

   public Long getProjectBidManagerUserId() {
      return this.projectBidManagerUserId;
   }

   public List<Long> getProjectBidManagerUserIdList() {
      return this.projectBidManagerUserIdList;
   }

   public String getProjectBidManagerUserName() {
      return this.projectBidManagerUserName;
   }

   public LocalDateTime getProjectBidManagerFinishDate() {
      return this.projectBidManagerFinishDate;
   }

   public Long getDifficultyFactorId() {
      return this.difficultyFactorId;
   }

   public String getDifficultyFactorName() {
      return this.difficultyFactorName;
   }

   public List<AttachmentDTO> getBidManagerAttachments() {
      return this.bidManagerAttachments;
   }

   public Boolean getIsNeedFill() {
      return this.isNeedFill;
   }

   public String getBusinessEssentials() {
      return this.businessEssentials;
   }

   public CrmTheProjectLeaderDetailsDTOV2 setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTOV2 setCrmTenderRequirementTypeEnum(final Integer crmTenderRequirementTypeEnum) {
      this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTOV2 setProjectBidManagerUserId(final Long projectBidManagerUserId) {
      this.projectBidManagerUserId = projectBidManagerUserId;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTOV2 setProjectBidManagerUserIdList(final List<Long> projectBidManagerUserIdList) {
      this.projectBidManagerUserIdList = projectBidManagerUserIdList;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTOV2 setProjectBidManagerUserName(final String projectBidManagerUserName) {
      this.projectBidManagerUserName = projectBidManagerUserName;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTOV2 setProjectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTOV2 setDifficultyFactorId(final Long difficultyFactorId) {
      this.difficultyFactorId = difficultyFactorId;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTOV2 setDifficultyFactorName(final String difficultyFactorName) {
      this.difficultyFactorName = difficultyFactorName;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTOV2 setBidManagerAttachments(final List<AttachmentDTO> bidManagerAttachments) {
      this.bidManagerAttachments = bidManagerAttachments;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTOV2 setIsNeedFill(final Boolean isNeedFill) {
      this.isNeedFill = isNeedFill;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTOV2 setBusinessEssentials(final String businessEssentials) {
      this.businessEssentials = businessEssentials;
      return this;
   }

   @Override
   public String toString() {
      return "CrmTheProjectLeaderDetailsDTOV2(crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", crmTenderRequirementTypeEnum="
         + this.getCrmTenderRequirementTypeEnum()
         + ", projectBidManagerUserId="
         + this.getProjectBidManagerUserId()
         + ", projectBidManagerUserIdList="
         + this.getProjectBidManagerUserIdList()
         + ", projectBidManagerUserName="
         + this.getProjectBidManagerUserName()
         + ", projectBidManagerFinishDate="
         + this.getProjectBidManagerFinishDate()
         + ", difficultyFactorId="
         + this.getDifficultyFactorId()
         + ", difficultyFactorName="
         + this.getDifficultyFactorName()
         + ", bidManagerAttachments="
         + this.getBidManagerAttachments()
         + ", isNeedFill="
         + this.getIsNeedFill()
         + ", businessEssentials="
         + this.getBusinessEssentials()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmTheProjectLeaderDetailsDTOV2)) {
         return false;
      }

      CrmTheProjectLeaderDetailsDTOV2 other = (CrmTheProjectLeaderDetailsDTOV2)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
      if (this$crmProjectInformationWarehousingId == null
         ? other$crmProjectInformationWarehousingId == null
         : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
         Object this$crmTenderRequirementTypeEnum = this.getCrmTenderRequirementTypeEnum();
         Object other$crmTenderRequirementTypeEnum = other.getCrmTenderRequirementTypeEnum();
         if (this$crmTenderRequirementTypeEnum == null
            ? other$crmTenderRequirementTypeEnum == null
            : this$crmTenderRequirementTypeEnum.equals(other$crmTenderRequirementTypeEnum)) {
            Object this$projectBidManagerUserId = this.getProjectBidManagerUserId();
            Object other$projectBidManagerUserId = other.getProjectBidManagerUserId();
            if (this$projectBidManagerUserId == null
               ? other$projectBidManagerUserId == null
               : this$projectBidManagerUserId.equals(other$projectBidManagerUserId)) {
               Object this$difficultyFactorId = this.getDifficultyFactorId();
               Object other$difficultyFactorId = other.getDifficultyFactorId();
               if (this$difficultyFactorId == null ? other$difficultyFactorId == null : this$difficultyFactorId.equals(other$difficultyFactorId)) {
                  Object this$isNeedFill = this.getIsNeedFill();
                  Object other$isNeedFill = other.getIsNeedFill();
                  if (this$isNeedFill == null ? other$isNeedFill == null : this$isNeedFill.equals(other$isNeedFill)) {
                     Object this$projectBidManagerUserIdList = this.getProjectBidManagerUserIdList();
                     Object other$projectBidManagerUserIdList = other.getProjectBidManagerUserIdList();
                     if (this$projectBidManagerUserIdList == null
                        ? other$projectBidManagerUserIdList == null
                        : this$projectBidManagerUserIdList.equals(other$projectBidManagerUserIdList)) {
                        Object this$projectBidManagerUserName = this.getProjectBidManagerUserName();
                        Object other$projectBidManagerUserName = other.getProjectBidManagerUserName();
                        if (this$projectBidManagerUserName == null
                           ? other$projectBidManagerUserName == null
                           : this$projectBidManagerUserName.equals(other$projectBidManagerUserName)) {
                           Object this$projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
                           Object other$projectBidManagerFinishDate = other.getProjectBidManagerFinishDate();
                           if (this$projectBidManagerFinishDate == null
                              ? other$projectBidManagerFinishDate == null
                              : this$projectBidManagerFinishDate.equals(other$projectBidManagerFinishDate)) {
                              Object this$difficultyFactorName = this.getDifficultyFactorName();
                              Object other$difficultyFactorName = other.getDifficultyFactorName();
                              if (this$difficultyFactorName == null
                                 ? other$difficultyFactorName == null
                                 : this$difficultyFactorName.equals(other$difficultyFactorName)) {
                                 Object this$bidManagerAttachments = this.getBidManagerAttachments();
                                 Object other$bidManagerAttachments = other.getBidManagerAttachments();
                                 if (this$bidManagerAttachments == null
                                    ? other$bidManagerAttachments == null
                                    : this$bidManagerAttachments.equals(other$bidManagerAttachments)) {
                                    Object this$businessEssentials = this.getBusinessEssentials();
                                    Object other$businessEssentials = other.getBusinessEssentials();
                                    return this$businessEssentials == null
                                       ? other$businessEssentials == null
                                       : this$businessEssentials.equals(other$businessEssentials);
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
      return other instanceof CrmTheProjectLeaderDetailsDTOV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $crmTenderRequirementTypeEnum = this.getCrmTenderRequirementTypeEnum();
      result = result * 59 + ($crmTenderRequirementTypeEnum == null ? 43 : $crmTenderRequirementTypeEnum.hashCode());
      Object $projectBidManagerUserId = this.getProjectBidManagerUserId();
      result = result * 59 + ($projectBidManagerUserId == null ? 43 : $projectBidManagerUserId.hashCode());
      Object $difficultyFactorId = this.getDifficultyFactorId();
      result = result * 59 + ($difficultyFactorId == null ? 43 : $difficultyFactorId.hashCode());
      Object $isNeedFill = this.getIsNeedFill();
      result = result * 59 + ($isNeedFill == null ? 43 : $isNeedFill.hashCode());
      Object $projectBidManagerUserIdList = this.getProjectBidManagerUserIdList();
      result = result * 59 + ($projectBidManagerUserIdList == null ? 43 : $projectBidManagerUserIdList.hashCode());
      Object $projectBidManagerUserName = this.getProjectBidManagerUserName();
      result = result * 59 + ($projectBidManagerUserName == null ? 43 : $projectBidManagerUserName.hashCode());
      Object $projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
      result = result * 59 + ($projectBidManagerFinishDate == null ? 43 : $projectBidManagerFinishDate.hashCode());
      Object $difficultyFactorName = this.getDifficultyFactorName();
      result = result * 59 + ($difficultyFactorName == null ? 43 : $difficultyFactorName.hashCode());
      Object $bidManagerAttachments = this.getBidManagerAttachments();
      result = result * 59 + ($bidManagerAttachments == null ? 43 : $bidManagerAttachments.hashCode());
      Object $businessEssentials = this.getBusinessEssentials();
      return result * 59 + ($businessEssentials == null ? 43 : $businessEssentials.hashCode());
   }

   public static class CrmTheProjectLeaderDetailsDTOV2Builder {
      private Long crmProjectInformationWarehousingId;
      private Integer crmTenderRequirementTypeEnum;
      private Long projectBidManagerUserId;
      private List<Long> projectBidManagerUserIdList;
      private String projectBidManagerUserName;
      private LocalDateTime projectBidManagerFinishDate;
      private Long difficultyFactorId;
      private String difficultyFactorName;
      private List<AttachmentDTO> bidManagerAttachments;
      private Boolean isNeedFill;
      private String businessEssentials;

      CrmTheProjectLeaderDetailsDTOV2Builder() {
      }

      public CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder crmTenderRequirementTypeEnum(final Integer crmTenderRequirementTypeEnum) {
         this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder projectBidManagerUserId(final Long projectBidManagerUserId) {
         this.projectBidManagerUserId = projectBidManagerUserId;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder projectBidManagerUserIdList(final List<Long> projectBidManagerUserIdList) {
         this.projectBidManagerUserIdList = projectBidManagerUserIdList;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder projectBidManagerUserName(final String projectBidManagerUserName) {
         this.projectBidManagerUserName = projectBidManagerUserName;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder projectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
         this.projectBidManagerFinishDate = projectBidManagerFinishDate;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder difficultyFactorId(final Long difficultyFactorId) {
         this.difficultyFactorId = difficultyFactorId;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder difficultyFactorName(final String difficultyFactorName) {
         this.difficultyFactorName = difficultyFactorName;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder bidManagerAttachments(final List<AttachmentDTO> bidManagerAttachments) {
         this.bidManagerAttachments = bidManagerAttachments;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder isNeedFill(final Boolean isNeedFill) {
         this.isNeedFill = isNeedFill;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder businessEssentials(final String businessEssentials) {
         this.businessEssentials = businessEssentials;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTOV2 build() {
         return new CrmTheProjectLeaderDetailsDTOV2(
            this.crmProjectInformationWarehousingId,
            this.crmTenderRequirementTypeEnum,
            this.projectBidManagerUserId,
            this.projectBidManagerUserIdList,
            this.projectBidManagerUserName,
            this.projectBidManagerFinishDate,
            this.difficultyFactorId,
            this.difficultyFactorName,
            this.bidManagerAttachments,
            this.isNeedFill,
            this.businessEssentials
         );
      }

      @Override
      public String toString() {
         return "CrmTheProjectLeaderDetailsDTOV2.CrmTheProjectLeaderDetailsDTOV2Builder(crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", crmTenderRequirementTypeEnum="
            + this.crmTenderRequirementTypeEnum
            + ", projectBidManagerUserId="
            + this.projectBidManagerUserId
            + ", projectBidManagerUserIdList="
            + this.projectBidManagerUserIdList
            + ", projectBidManagerUserName="
            + this.projectBidManagerUserName
            + ", projectBidManagerFinishDate="
            + this.projectBidManagerFinishDate
            + ", difficultyFactorId="
            + this.difficultyFactorId
            + ", difficultyFactorName="
            + this.difficultyFactorName
            + ", bidManagerAttachments="
            + this.bidManagerAttachments
            + ", isNeedFill="
            + this.isNeedFill
            + ", businessEssentials="
            + this.businessEssentials
            + ")";
      }
   }
}
