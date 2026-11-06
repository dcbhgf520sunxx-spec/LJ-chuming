package com.hzchum.scim.project.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class ProjectRejectDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "外购退货单号", notes = "外购退货单号")
   private String serialNumber;
   @ApiModelProperty(name = "projectId", value = "退货项目", notes = "退货项目")
   private Long projectId;
   private ProjectInfo project;
   @ApiModelProperty(name = "productType", value = "包含材料类型", notes = "包含材料类型")
   private Integer productType;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   private String applicantName;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态", notes = "审核状态")
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID", notes = "审核人ID")
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称", notes = "审核人名称")
   private String reviewerName;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "dtoList", value = "外购退货详情", notes = "外购退货详情")
   List<ProjectRejectDetailDTO> dtoList;

   public static ProjectRejectDTO.ProjectRejectDTOBuilder builder() {
      return new ProjectRejectDTO.ProjectRejectDTOBuilder();
   }

   public ProjectRejectDTO() {
   }

   public ProjectRejectDTO(
      final Long id,
      final String serialNumber,
      final Long projectId,
      final ProjectInfo project,
      final Integer productType,
      final Long applicantId,
      final String applicantName,
      final Integer reviewStatus,
      final Long reviewerId,
      final String reviewerName,
      final LocalDateTime reviewTime,
      final LocalDateTime createTime,
      final List<ProjectRejectDetailDTO> dtoList
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.project = project;
      this.productType = productType;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewStatus = reviewStatus;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.reviewTime = reviewTime;
      this.createTime = createTime;
      this.dtoList = dtoList;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public List<ProjectRejectDetailDTO> getDtoList() {
      return this.dtoList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setDtoList(final List<ProjectRejectDetailDTO> dtoList) {
      this.dtoList = dtoList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectRejectDTO)) {
         return false;
      }

      ProjectRejectDTO other = (ProjectRejectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$applicantId = this.getApplicantId();
               Object other$applicantId = other.getApplicantId();
               if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                  Object this$reviewStatus = this.getReviewStatus();
                  Object other$reviewStatus = other.getReviewStatus();
                  if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                     Object this$reviewerId = this.getReviewerId();
                     Object other$reviewerId = other.getReviewerId();
                     if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$applicantName = this.getApplicantName();
                              Object other$applicantName = other.getApplicantName();
                              if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                 Object this$reviewerName = this.getReviewerName();
                                 Object other$reviewerName = other.getReviewerName();
                                 if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                    Object this$reviewTime = this.getReviewTime();
                                    Object other$reviewTime = other.getReviewTime();
                                    if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                                       Object this$createTime = this.getCreateTime();
                                       Object other$createTime = other.getCreateTime();
                                       if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                          Object this$dtoList = this.getDtoList();
                                          Object other$dtoList = other.getDtoList();
                                          return this$dtoList == null ? other$dtoList == null : this$dtoList.equals(other$dtoList);
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
      return other instanceof ProjectRejectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $dtoList = this.getDtoList();
      return result * 59 + ($dtoList == null ? 43 : $dtoList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectRejectDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", productType="
         + this.getProductType()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewTime="
         + this.getReviewTime()
         + ", createTime="
         + this.getCreateTime()
         + ", dtoList="
         + this.getDtoList()
         + ")";
   }

   public static class ProjectRejectDTOBuilder {
      private Long id;
      private String serialNumber;
      private Long projectId;
      private ProjectInfo project;
      private Integer productType;
      private Long applicantId;
      private String applicantName;
      private Integer reviewStatus;
      private Long reviewerId;
      private String reviewerName;
      private LocalDateTime reviewTime;
      private LocalDateTime createTime;
      private List<ProjectRejectDetailDTO> dtoList;

      ProjectRejectDTOBuilder() {
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectRejectDTO.ProjectRejectDTOBuilder dtoList(final List<ProjectRejectDetailDTO> dtoList) {
         this.dtoList = dtoList;
         return this;
      }

      public ProjectRejectDTO build() {
         return new ProjectRejectDTO(
            this.id,
            this.serialNumber,
            this.projectId,
            this.project,
            this.productType,
            this.applicantId,
            this.applicantName,
            this.reviewStatus,
            this.reviewerId,
            this.reviewerName,
            this.reviewTime,
            this.createTime,
            this.dtoList
         );
      }

      @Override
      public String toString() {
         return "ProjectRejectDTO.ProjectRejectDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", project="
            + this.project
            + ", productType="
            + this.productType
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", reviewTime="
            + this.reviewTime
            + ", createTime="
            + this.createTime
            + ", dtoList="
            + this.dtoList
            + ")";
      }
   }
}
