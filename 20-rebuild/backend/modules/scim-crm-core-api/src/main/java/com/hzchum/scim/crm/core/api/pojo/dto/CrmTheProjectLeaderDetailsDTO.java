package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class CrmTheProjectLeaderDetailsDTO {
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

   public static CrmTheProjectLeaderDetailsDTO.CrmTheProjectLeaderDetailsDTOBuilder builder() {
      return new CrmTheProjectLeaderDetailsDTO.CrmTheProjectLeaderDetailsDTOBuilder();
   }

   public CrmTheProjectLeaderDetailsDTO() {
   }

   public CrmTheProjectLeaderDetailsDTO(
      final Long crmProjectInformationWarehousingId,
      final Integer crmTenderRequirementTypeEnum,
      final Long projectBidManagerUserId,
      final List<Long> projectBidManagerUserIdList,
      final String projectBidManagerUserName,
      final LocalDateTime projectBidManagerFinishDate,
      final Long difficultyFactorId,
      final String difficultyFactorName,
      final List<AttachmentDTO> bidManagerAttachments
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

   public CrmTheProjectLeaderDetailsDTO setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTO setCrmTenderRequirementTypeEnum(final Integer crmTenderRequirementTypeEnum) {
      this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTO setProjectBidManagerUserId(final Long projectBidManagerUserId) {
      this.projectBidManagerUserId = projectBidManagerUserId;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTO setProjectBidManagerUserIdList(final List<Long> projectBidManagerUserIdList) {
      this.projectBidManagerUserIdList = projectBidManagerUserIdList;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTO setProjectBidManagerUserName(final String projectBidManagerUserName) {
      this.projectBidManagerUserName = projectBidManagerUserName;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTO setProjectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTO setDifficultyFactorId(final Long difficultyFactorId) {
      this.difficultyFactorId = difficultyFactorId;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTO setDifficultyFactorName(final String difficultyFactorName) {
      this.difficultyFactorName = difficultyFactorName;
      return this;
   }

   public CrmTheProjectLeaderDetailsDTO setBidManagerAttachments(final List<AttachmentDTO> bidManagerAttachments) {
      this.bidManagerAttachments = bidManagerAttachments;
      return this;
   }

   @Override
   public String toString() {
      return "CrmTheProjectLeaderDetailsDTO(crmProjectInformationWarehousingId="
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmTheProjectLeaderDetailsDTO)) {
         return false;
      }

      CrmTheProjectLeaderDetailsDTO other = (CrmTheProjectLeaderDetailsDTO)o;
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
                              return this$bidManagerAttachments == null
                                 ? other$bidManagerAttachments == null
                                 : this$bidManagerAttachments.equals(other$bidManagerAttachments);
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
      return other instanceof CrmTheProjectLeaderDetailsDTO;
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
      Object $projectBidManagerUserIdList = this.getProjectBidManagerUserIdList();
      result = result * 59 + ($projectBidManagerUserIdList == null ? 43 : $projectBidManagerUserIdList.hashCode());
      Object $projectBidManagerUserName = this.getProjectBidManagerUserName();
      result = result * 59 + ($projectBidManagerUserName == null ? 43 : $projectBidManagerUserName.hashCode());
      Object $projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
      result = result * 59 + ($projectBidManagerFinishDate == null ? 43 : $projectBidManagerFinishDate.hashCode());
      Object $difficultyFactorName = this.getDifficultyFactorName();
      result = result * 59 + ($difficultyFactorName == null ? 43 : $difficultyFactorName.hashCode());
      Object $bidManagerAttachments = this.getBidManagerAttachments();
      return result * 59 + ($bidManagerAttachments == null ? 43 : $bidManagerAttachments.hashCode());
   }

   public static class CrmTheProjectLeaderDetailsDTOBuilder {
      private Long crmProjectInformationWarehousingId;
      private Integer crmTenderRequirementTypeEnum;
      private Long projectBidManagerUserId;
      private List<Long> projectBidManagerUserIdList;
      private String projectBidManagerUserName;
      private LocalDateTime projectBidManagerFinishDate;
      private Long difficultyFactorId;
      private String difficultyFactorName;
      private List<AttachmentDTO> bidManagerAttachments;

      CrmTheProjectLeaderDetailsDTOBuilder() {
      }

      public CrmTheProjectLeaderDetailsDTO.CrmTheProjectLeaderDetailsDTOBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTO.CrmTheProjectLeaderDetailsDTOBuilder crmTenderRequirementTypeEnum(final Integer crmTenderRequirementTypeEnum) {
         this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTO.CrmTheProjectLeaderDetailsDTOBuilder projectBidManagerUserId(final Long projectBidManagerUserId) {
         this.projectBidManagerUserId = projectBidManagerUserId;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTO.CrmTheProjectLeaderDetailsDTOBuilder projectBidManagerUserIdList(final List<Long> projectBidManagerUserIdList) {
         this.projectBidManagerUserIdList = projectBidManagerUserIdList;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTO.CrmTheProjectLeaderDetailsDTOBuilder projectBidManagerUserName(final String projectBidManagerUserName) {
         this.projectBidManagerUserName = projectBidManagerUserName;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTO.CrmTheProjectLeaderDetailsDTOBuilder projectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
         this.projectBidManagerFinishDate = projectBidManagerFinishDate;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTO.CrmTheProjectLeaderDetailsDTOBuilder difficultyFactorId(final Long difficultyFactorId) {
         this.difficultyFactorId = difficultyFactorId;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTO.CrmTheProjectLeaderDetailsDTOBuilder difficultyFactorName(final String difficultyFactorName) {
         this.difficultyFactorName = difficultyFactorName;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTO.CrmTheProjectLeaderDetailsDTOBuilder bidManagerAttachments(final List<AttachmentDTO> bidManagerAttachments) {
         this.bidManagerAttachments = bidManagerAttachments;
         return this;
      }

      public CrmTheProjectLeaderDetailsDTO build() {
         return new CrmTheProjectLeaderDetailsDTO(
            this.crmProjectInformationWarehousingId,
            this.crmTenderRequirementTypeEnum,
            this.projectBidManagerUserId,
            this.projectBidManagerUserIdList,
            this.projectBidManagerUserName,
            this.projectBidManagerFinishDate,
            this.difficultyFactorId,
            this.difficultyFactorName,
            this.bidManagerAttachments
         );
      }

      @Override
      public String toString() {
         return "CrmTheProjectLeaderDetailsDTO.CrmTheProjectLeaderDetailsDTOBuilder(crmProjectInformationWarehousingId="
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
            + ")";
      }
   }
}
