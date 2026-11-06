package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("退货单查询类")
public class ProjectRejectQueryDTOParam {
   @ApiModelProperty(name = "createTime", value = "申请时间")
   List<LocalDateTime> createTime;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态")
   private Integer reviewStatus;
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "serialNumber", value = "外购退货单编号", notes = "外购退货单编号")
   private String serialNumber;
   @ApiModelProperty(name = "reviewerName", value = "审核人", notes = "审核人")
   private String reviewerName;
   @ApiModelProperty(name = "applicantName", value = "申请人", notes = "申请人")
   private String applicantName;
   private List<Long> projectIds;

   ProjectRejectQueryDTOParam(
      final List<LocalDateTime> createTime,
      final Integer reviewStatus,
      final Integer productType,
      final String projectName,
      final String serialNumber,
      final String reviewerName,
      final String applicantName,
      final List<Long> projectIds
   ) {
      this.createTime = createTime;
      this.reviewStatus = reviewStatus;
      this.productType = productType;
      this.projectName = projectName;
      this.serialNumber = serialNumber;
      this.reviewerName = reviewerName;
      this.applicantName = applicantName;
      this.projectIds = projectIds;
   }

   public static ProjectRejectQueryDTOParam.ProjectRejectQueryDTOParamBuilder builder() {
      return new ProjectRejectQueryDTOParam.ProjectRejectQueryDTOParamBuilder();
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectRejectQueryDTOParam)) {
         return false;
      }

      ProjectRejectQueryDTOParam other = (ProjectRejectQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reviewStatus = this.getReviewStatus();
      Object other$reviewStatus = other.getReviewStatus();
      if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$createTime = this.getCreateTime();
            Object other$createTime = other.getCreateTime();
            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$reviewerName = this.getReviewerName();
                     Object other$reviewerName = other.getReviewerName();
                     if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                        Object this$applicantName = this.getApplicantName();
                        Object other$applicantName = other.getApplicantName();
                        if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                           Object this$projectIds = this.getProjectIds();
                           Object other$projectIds = other.getProjectIds();
                           return this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds);
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
      return other instanceof ProjectRejectQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $projectIds = this.getProjectIds();
      return result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectRejectQueryDTOParam(createTime="
         + this.getCreateTime()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", productType="
         + this.getProductType()
         + ", projectName="
         + this.getProjectName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", reviewerName="
         + this.getReviewerName()
         + ", applicantName="
         + this.getApplicantName()
         + ", projectIds="
         + this.getProjectIds()
         + ")";
   }

   public static class ProjectRejectQueryDTOParamBuilder {
      private List<LocalDateTime> createTime;
      private Integer reviewStatus;
      private Integer productType;
      private String projectName;
      private String serialNumber;
      private String reviewerName;
      private String applicantName;
      private List<Long> projectIds;

      ProjectRejectQueryDTOParamBuilder() {
      }

      public ProjectRejectQueryDTOParam.ProjectRejectQueryDTOParamBuilder createTime(final List<LocalDateTime> createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectRejectQueryDTOParam.ProjectRejectQueryDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ProjectRejectQueryDTOParam.ProjectRejectQueryDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectRejectQueryDTOParam.ProjectRejectQueryDTOParamBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ProjectRejectQueryDTOParam.ProjectRejectQueryDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectRejectQueryDTOParam.ProjectRejectQueryDTOParamBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public ProjectRejectQueryDTOParam.ProjectRejectQueryDTOParamBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ProjectRejectQueryDTOParam.ProjectRejectQueryDTOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public ProjectRejectQueryDTOParam build() {
         return new ProjectRejectQueryDTOParam(
            this.createTime, this.reviewStatus, this.productType, this.projectName, this.serialNumber, this.reviewerName, this.applicantName, this.projectIds
         );
      }

      @Override
      public String toString() {
         return "ProjectRejectQueryDTOParam.ProjectRejectQueryDTOParamBuilder(createTime="
            + this.createTime
            + ", reviewStatus="
            + this.reviewStatus
            + ", productType="
            + this.productType
            + ", projectName="
            + this.projectName
            + ", serialNumber="
            + this.serialNumber
            + ", reviewerName="
            + this.reviewerName
            + ", applicantName="
            + this.applicantName
            + ", projectIds="
            + this.projectIds
            + ")";
      }
   }
}
