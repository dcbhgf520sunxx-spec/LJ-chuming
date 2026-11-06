package com.hzchum.scim.project.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

public class QhseDTO {
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private ProjectInfo project;
   @ApiModelProperty(name = "category", value = "问题类别 1质量问题2安全问题3环境问题")
   private Integer category;
   @ApiModelProperty(name = "type", value = "问题类型")
   private String type;
   @ApiModelProperty(name = "status", value = "状态")
   private Integer status;
   @ApiModelProperty(name = "applicant", value = "申请人id")
   private Long applicant;
   @ApiModelProperty(name = "applicantName", value = "申请人")
   private String applicantName;
   @ApiModelProperty(name = "responsibleUserId", value = "主送人id")
   private Long responsibleUserId;
   @ApiModelProperty(name = "responsibleUserName", value = "主送人")
   private String responsibleUserName;
   @ApiModelProperty(name = "ccUserIds", value = "抄送人id")
   private List<Object> ccUser;
   @ApiModelProperty(name = "attachments", value = "问题图片")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "description", value = "描述")
   private String description;
   @ApiModelProperty(name = "rectifyOpinion", value = "整改意见")
   private String rectifyOpinion;
   @ApiModelProperty(name = "rectifyDate", value = "整改时间")
   private LocalDate rectifyDate;
   @ApiModelProperty(name = "rectifyAttachments", value = "整改图片")
   private List<AttachmentDTO> rectifyAttachments;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getType() {
      return this.type;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getApplicant() {
      return this.applicant;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getResponsibleUserId() {
      return this.responsibleUserId;
   }

   public String getResponsibleUserName() {
      return this.responsibleUserName;
   }

   public List<Object> getCcUser() {
      return this.ccUser;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getDescription() {
      return this.description;
   }

   public String getRectifyOpinion() {
      return this.rectifyOpinion;
   }

   public LocalDate getRectifyDate() {
      return this.rectifyDate;
   }

   public List<AttachmentDTO> getRectifyAttachments() {
      return this.rectifyAttachments;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setApplicant(final Long applicant) {
      this.applicant = applicant;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setResponsibleUserId(final Long responsibleUserId) {
      this.responsibleUserId = responsibleUserId;
   }

   public void setResponsibleUserName(final String responsibleUserName) {
      this.responsibleUserName = responsibleUserName;
   }

   public void setCcUser(final List<Object> ccUser) {
      this.ccUser = ccUser;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setDescription(final String description) {
      this.description = description;
   }

   public void setRectifyOpinion(final String rectifyOpinion) {
      this.rectifyOpinion = rectifyOpinion;
   }

   public void setRectifyDate(final LocalDate rectifyDate) {
      this.rectifyDate = rectifyDate;
   }

   public void setRectifyAttachments(final List<AttachmentDTO> rectifyAttachments) {
      this.rectifyAttachments = rectifyAttachments;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseDTO)) {
         return false;
      }

      QhseDTO other = (QhseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$applicant = this.getApplicant();
               Object other$applicant = other.getApplicant();
               if (this$applicant == null ? other$applicant == null : this$applicant.equals(other$applicant)) {
                  Object this$responsibleUserId = this.getResponsibleUserId();
                  Object other$responsibleUserId = other.getResponsibleUserId();
                  if (this$responsibleUserId == null ? other$responsibleUserId == null : this$responsibleUserId.equals(other$responsibleUserId)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$applicantName = this.getApplicantName();
                           Object other$applicantName = other.getApplicantName();
                           if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                              Object this$responsibleUserName = this.getResponsibleUserName();
                              Object other$responsibleUserName = other.getResponsibleUserName();
                              if (this$responsibleUserName == null
                                 ? other$responsibleUserName == null
                                 : this$responsibleUserName.equals(other$responsibleUserName)) {
                                 Object this$ccUser = this.getCcUser();
                                 Object other$ccUser = other.getCcUser();
                                 if (this$ccUser == null ? other$ccUser == null : this$ccUser.equals(other$ccUser)) {
                                    Object this$attachments = this.getAttachments();
                                    Object other$attachments = other.getAttachments();
                                    if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
                                       Object this$description = this.getDescription();
                                       Object other$description = other.getDescription();
                                       if (this$description == null ? other$description == null : this$description.equals(other$description)) {
                                          Object this$rectifyOpinion = this.getRectifyOpinion();
                                          Object other$rectifyOpinion = other.getRectifyOpinion();
                                          if (this$rectifyOpinion == null ? other$rectifyOpinion == null : this$rectifyOpinion.equals(other$rectifyOpinion)) {
                                             Object this$rectifyDate = this.getRectifyDate();
                                             Object other$rectifyDate = other.getRectifyDate();
                                             if (this$rectifyDate == null ? other$rectifyDate == null : this$rectifyDate.equals(other$rectifyDate)) {
                                                Object this$rectifyAttachments = this.getRectifyAttachments();
                                                Object other$rectifyAttachments = other.getRectifyAttachments();
                                                return this$rectifyAttachments == null
                                                   ? other$rectifyAttachments == null
                                                   : this$rectifyAttachments.equals(other$rectifyAttachments);
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
      return other instanceof QhseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $applicant = this.getApplicant();
      result = result * 59 + ($applicant == null ? 43 : $applicant.hashCode());
      Object $responsibleUserId = this.getResponsibleUserId();
      result = result * 59 + ($responsibleUserId == null ? 43 : $responsibleUserId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $responsibleUserName = this.getResponsibleUserName();
      result = result * 59 + ($responsibleUserName == null ? 43 : $responsibleUserName.hashCode());
      Object $ccUser = this.getCcUser();
      result = result * 59 + ($ccUser == null ? 43 : $ccUser.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $description = this.getDescription();
      result = result * 59 + ($description == null ? 43 : $description.hashCode());
      Object $rectifyOpinion = this.getRectifyOpinion();
      result = result * 59 + ($rectifyOpinion == null ? 43 : $rectifyOpinion.hashCode());
      Object $rectifyDate = this.getRectifyDate();
      result = result * 59 + ($rectifyDate == null ? 43 : $rectifyDate.hashCode());
      Object $rectifyAttachments = this.getRectifyAttachments();
      return result * 59 + ($rectifyAttachments == null ? 43 : $rectifyAttachments.hashCode());
   }

   @Override
   public String toString() {
      return "QhseDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", category="
         + this.getCategory()
         + ", type="
         + this.getType()
         + ", status="
         + this.getStatus()
         + ", applicant="
         + this.getApplicant()
         + ", applicantName="
         + this.getApplicantName()
         + ", responsibleUserId="
         + this.getResponsibleUserId()
         + ", responsibleUserName="
         + this.getResponsibleUserName()
         + ", ccUser="
         + this.getCcUser()
         + ", attachments="
         + this.getAttachments()
         + ", description="
         + this.getDescription()
         + ", rectifyOpinion="
         + this.getRectifyOpinion()
         + ", rectifyDate="
         + this.getRectifyDate()
         + ", rectifyAttachments="
         + this.getRectifyAttachments()
         + ")";
   }
}
