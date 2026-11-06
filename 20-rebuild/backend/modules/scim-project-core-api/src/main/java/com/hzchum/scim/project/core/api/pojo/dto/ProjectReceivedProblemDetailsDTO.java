package com.hzchum.scim.project.core.api.pojo.dto;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.project.core.api.pojo.dto.mes.ProjectCargoListProductDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("收货问题记录详情返回类")
public class ProjectReceivedProblemDetailsDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "userName", value = "收货人", notes = "收货人")
   private String userName;
   @ApiModelProperty(name = "shippingTime", value = "发运日期", notes = "发运日期")
   private LocalDateTime shippingTime;
   @ApiModelProperty(name = "receivedTime", value = "收货日期", notes = "收货日期")
   private LocalDateTime receivedTime;
   @ApiModelProperty(name = "attachmentDTOList", value = "附件", notes = "附件")
   private List<AttachmentDTO> attachmentDTOList;
   @ApiModelProperty(name = "问题产品", value = "问题产品", notes = "问题产品")
   private ListVO<ProjectCargoListProductDTO> problemProductList;
   @ApiModelProperty(name = "remark", value = "关闭原因", notes = "关闭原因")
   private String remark;

   public static ProjectReceivedProblemDetailsDTO.ProjectReceivedProblemDetailsDTOBuilder builder() {
      return new ProjectReceivedProblemDetailsDTO.ProjectReceivedProblemDetailsDTOBuilder();
   }

   public ProjectReceivedProblemDetailsDTO() {
   }

   public ProjectReceivedProblemDetailsDTO(
      final Long id,
      final ProjectInfo project,
      final String userName,
      final LocalDateTime shippingTime,
      final LocalDateTime receivedTime,
      final List<AttachmentDTO> attachmentDTOList,
      final ListVO<ProjectCargoListProductDTO> problemProductList,
      final String remark
   ) {
      this.id = id;
      this.project = project;
      this.userName = userName;
      this.shippingTime = shippingTime;
      this.receivedTime = receivedTime;
      this.attachmentDTOList = attachmentDTOList;
      this.problemProductList = problemProductList;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getShippingTime() {
      return this.shippingTime;
   }

   public LocalDateTime getReceivedTime() {
      return this.receivedTime;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public ListVO<ProjectCargoListProductDTO> getProblemProductList() {
      return this.problemProductList;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setShippingTime(final LocalDateTime shippingTime) {
      this.shippingTime = shippingTime;
   }

   public void setReceivedTime(final LocalDateTime receivedTime) {
      this.receivedTime = receivedTime;
   }

   public void setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
   }

   public void setProblemProductList(final ListVO<ProjectCargoListProductDTO> problemProductList) {
      this.problemProductList = problemProductList;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivedProblemDetailsDTO)) {
         return false;
      }

      ProjectReceivedProblemDetailsDTO other = (ProjectReceivedProblemDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$userName = this.getUserName();
            Object other$userName = other.getUserName();
            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
               Object this$shippingTime = this.getShippingTime();
               Object other$shippingTime = other.getShippingTime();
               if (this$shippingTime == null ? other$shippingTime == null : this$shippingTime.equals(other$shippingTime)) {
                  Object this$receivedTime = this.getReceivedTime();
                  Object other$receivedTime = other.getReceivedTime();
                  if (this$receivedTime == null ? other$receivedTime == null : this$receivedTime.equals(other$receivedTime)) {
                     Object this$attachmentDTOList = this.getAttachmentDTOList();
                     Object other$attachmentDTOList = other.getAttachmentDTOList();
                     if (this$attachmentDTOList == null ? other$attachmentDTOList == null : this$attachmentDTOList.equals(other$attachmentDTOList)) {
                        Object this$problemProductList = this.getProblemProductList();
                        Object other$problemProductList = other.getProblemProductList();
                        if (this$problemProductList == null ? other$problemProductList == null : this$problemProductList.equals(other$problemProductList)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ProjectReceivedProblemDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $shippingTime = this.getShippingTime();
      result = result * 59 + ($shippingTime == null ? 43 : $shippingTime.hashCode());
      Object $receivedTime = this.getReceivedTime();
      result = result * 59 + ($receivedTime == null ? 43 : $receivedTime.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      result = result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
      Object $problemProductList = this.getProblemProductList();
      result = result * 59 + ($problemProductList == null ? 43 : $problemProductList.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceivedProblemDetailsDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", userName="
         + this.getUserName()
         + ", shippingTime="
         + this.getShippingTime()
         + ", receivedTime="
         + this.getReceivedTime()
         + ", attachmentDTOList="
         + this.getAttachmentDTOList()
         + ", problemProductList="
         + this.getProblemProductList()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ProjectReceivedProblemDetailsDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private String userName;
      private LocalDateTime shippingTime;
      private LocalDateTime receivedTime;
      private List<AttachmentDTO> attachmentDTOList;
      private ListVO<ProjectCargoListProductDTO> problemProductList;
      private String remark;

      ProjectReceivedProblemDetailsDTOBuilder() {
      }

      public ProjectReceivedProblemDetailsDTO.ProjectReceivedProblemDetailsDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectReceivedProblemDetailsDTO.ProjectReceivedProblemDetailsDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectReceivedProblemDetailsDTO.ProjectReceivedProblemDetailsDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectReceivedProblemDetailsDTO.ProjectReceivedProblemDetailsDTOBuilder shippingTime(final LocalDateTime shippingTime) {
         this.shippingTime = shippingTime;
         return this;
      }

      public ProjectReceivedProblemDetailsDTO.ProjectReceivedProblemDetailsDTOBuilder receivedTime(final LocalDateTime receivedTime) {
         this.receivedTime = receivedTime;
         return this;
      }

      public ProjectReceivedProblemDetailsDTO.ProjectReceivedProblemDetailsDTOBuilder attachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public ProjectReceivedProblemDetailsDTO.ProjectReceivedProblemDetailsDTOBuilder problemProductList(
         final ListVO<ProjectCargoListProductDTO> problemProductList
      ) {
         this.problemProductList = problemProductList;
         return this;
      }

      public ProjectReceivedProblemDetailsDTO.ProjectReceivedProblemDetailsDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectReceivedProblemDetailsDTO build() {
         return new ProjectReceivedProblemDetailsDTO(
            this.id, this.project, this.userName, this.shippingTime, this.receivedTime, this.attachmentDTOList, this.problemProductList, this.remark
         );
      }

      @Override
      public String toString() {
         return "ProjectReceivedProblemDetailsDTO.ProjectReceivedProblemDetailsDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", userName="
            + this.userName
            + ", shippingTime="
            + this.shippingTime
            + ", receivedTime="
            + this.receivedTime
            + ", attachmentDTOList="
            + this.attachmentDTOList
            + ", problemProductList="
            + this.problemProductList
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
