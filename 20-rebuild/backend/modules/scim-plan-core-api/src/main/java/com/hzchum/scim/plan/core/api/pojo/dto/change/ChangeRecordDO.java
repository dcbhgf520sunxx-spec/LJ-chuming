package com.hzchum.scim.plan.core.api.pojo.dto.change;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class ChangeRecordDO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("单体信息")
   private NameInfo monomer;
   @ApiModelProperty("区域信息")
   private NameInfo area;
   @ApiModelProperty("变更原因")
   private String reason;
   @ApiModelProperty("变更用户id")
   private Long userId;
   @ApiModelProperty("变更用户id")
   private String userName;
   @ApiModelProperty("描述")
   private String describe;
   @ApiModelProperty("附件id字符串")
   private List<AttachmentDTO> attachments;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getReason() {
      return this.reason;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getDescribe() {
      return this.describe;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setReason(final String reason) {
      this.reason = reason;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setDescribe(final String describe) {
      this.describe = describe;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ChangeRecordDO)) {
         return false;
      }

      ChangeRecordDO other = (ChangeRecordDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$monomer = this.getMonomer();
               Object other$monomer = other.getMonomer();
               if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                  Object this$area = this.getArea();
                  Object other$area = other.getArea();
                  if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                     Object this$reason = this.getReason();
                     Object other$reason = other.getReason();
                     if (this$reason == null ? other$reason == null : this$reason.equals(other$reason)) {
                        Object this$userName = this.getUserName();
                        Object other$userName = other.getUserName();
                        if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                           Object this$describe = this.getDescribe();
                           Object other$describe = other.getDescribe();
                           if (this$describe == null ? other$describe == null : this$describe.equals(other$describe)) {
                              Object this$attachments = this.getAttachments();
                              Object other$attachments = other.getAttachments();
                              return this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments);
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
      return other instanceof ChangeRecordDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $reason = this.getReason();
      result = result * 59 + ($reason == null ? 43 : $reason.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $describe = this.getDescribe();
      result = result * 59 + ($describe == null ? 43 : $describe.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "ChangeRecordDO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", reason="
         + this.getReason()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", describe="
         + this.getDescribe()
         + ", attachments="
         + this.getAttachments()
         + ")";
   }
}
