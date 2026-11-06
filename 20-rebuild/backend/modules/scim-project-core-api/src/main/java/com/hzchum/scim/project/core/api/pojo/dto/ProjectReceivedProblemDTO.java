package com.hzchum.scim.project.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("收货问题记录返回类")
public class ProjectReceivedProblemDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "supplier", value = "供应商", notes = "供应商")
   private NameInfo supplier;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   private String licensePlate;
   @ApiModelProperty(name = "userId", value = "收货人", notes = "收货人")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "收货人", notes = "收货人")
   private String userName;
   @ApiModelProperty(name = "state", value = "是否关闭", notes = "是否关闭")
   private Integer state;
   @ApiModelProperty(name = "createTime", value = "日期", notes = "日期")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "attachmentDTOList", value = "附件", notes = "附件")
   private List<AttachmentDTO> attachmentDTOList;

   public static ProjectReceivedProblemDTO.ProjectReceivedProblemDTOBuilder builder() {
      return new ProjectReceivedProblemDTO.ProjectReceivedProblemDTOBuilder();
   }

   public ProjectReceivedProblemDTO() {
   }

   public ProjectReceivedProblemDTO(
      final Long id,
      final NameInfo supplier,
      final String licensePlate,
      final Long userId,
      final String userName,
      final Integer state,
      final LocalDateTime createTime,
      final List<AttachmentDTO> attachmentDTOList
   ) {
      this.id = id;
      this.supplier = supplier;
      this.licensePlate = licensePlate;
      this.userId = userId;
      this.userName = userName;
      this.state = state;
      this.createTime = createTime;
      this.attachmentDTOList = attachmentDTOList;
   }

   public Long getId() {
      return this.id;
   }

   public NameInfo getSupplier() {
      return this.supplier;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getState() {
      return this.state;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSupplier(final NameInfo supplier) {
      this.supplier = supplier;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setState(final Integer state) {
      this.state = state;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivedProblemDTO)) {
         return false;
      }

      ProjectReceivedProblemDTO other = (ProjectReceivedProblemDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$state = this.getState();
            Object other$state = other.getState();
            if (this$state == null ? other$state == null : this$state.equals(other$state)) {
               Object this$supplier = this.getSupplier();
               Object other$supplier = other.getSupplier();
               if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                  Object this$licensePlate = this.getLicensePlate();
                  Object other$licensePlate = other.getLicensePlate();
                  if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                     Object this$userName = this.getUserName();
                     Object other$userName = other.getUserName();
                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$attachmentDTOList = this.getAttachmentDTOList();
                           Object other$attachmentDTOList = other.getAttachmentDTOList();
                           return this$attachmentDTOList == null ? other$attachmentDTOList == null : this$attachmentDTOList.equals(other$attachmentDTOList);
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
      return other instanceof ProjectReceivedProblemDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $state = this.getState();
      result = result * 59 + ($state == null ? 43 : $state.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      return result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceivedProblemDTO(id="
         + this.getId()
         + ", supplier="
         + this.getSupplier()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", state="
         + this.getState()
         + ", createTime="
         + this.getCreateTime()
         + ", attachmentDTOList="
         + this.getAttachmentDTOList()
         + ")";
   }

   public static class ProjectReceivedProblemDTOBuilder {
      private Long id;
      private NameInfo supplier;
      private String licensePlate;
      private Long userId;
      private String userName;
      private Integer state;
      private LocalDateTime createTime;
      private List<AttachmentDTO> attachmentDTOList;

      ProjectReceivedProblemDTOBuilder() {
      }

      public ProjectReceivedProblemDTO.ProjectReceivedProblemDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectReceivedProblemDTO.ProjectReceivedProblemDTOBuilder supplier(final NameInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public ProjectReceivedProblemDTO.ProjectReceivedProblemDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public ProjectReceivedProblemDTO.ProjectReceivedProblemDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectReceivedProblemDTO.ProjectReceivedProblemDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectReceivedProblemDTO.ProjectReceivedProblemDTOBuilder state(final Integer state) {
         this.state = state;
         return this;
      }

      public ProjectReceivedProblemDTO.ProjectReceivedProblemDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectReceivedProblemDTO.ProjectReceivedProblemDTOBuilder attachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public ProjectReceivedProblemDTO build() {
         return new ProjectReceivedProblemDTO(
            this.id, this.supplier, this.licensePlate, this.userId, this.userName, this.state, this.createTime, this.attachmentDTOList
         );
      }

      @Override
      public String toString() {
         return "ProjectReceivedProblemDTO.ProjectReceivedProblemDTOBuilder(id="
            + this.id
            + ", supplier="
            + this.supplier
            + ", licensePlate="
            + this.licensePlate
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", state="
            + this.state
            + ", createTime="
            + this.createTime
            + ", attachmentDTOList="
            + this.attachmentDTOList
            + ")";
      }
   }
}
