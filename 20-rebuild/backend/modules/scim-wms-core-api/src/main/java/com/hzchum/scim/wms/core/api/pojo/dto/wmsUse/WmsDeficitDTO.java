package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;

public class WmsDeficitDTO {
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "盘亏单号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status")
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewTime", value = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time")
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "applicantId", value = "申请人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id")
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name")
   private String applicantName;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称")
   @JsonProperty("reviewerName")
   @JSONField(name = "reviewerName")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name")
   private String reviewerName;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID")
   @JsonProperty("reviewerId")
   @JSONField(name = "reviewerId")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id")
   private Long reviewerId;
   @ApiModelProperty(name = "deficitType", value = "盘亏成本归属 1公司 2项目")
   @JsonProperty("deficitType")
   @JSONField(name = "deficitType")
   @TableField("deficit_type")
   @Column(name = "deficit_type")
   private Integer deficitType;
   @ApiModelProperty(name = "basicClass", value = "物料基础分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int(2)  COMMENT '物料基础分类'", nullable = false)
   private Integer basicClass;
   @ApiModelProperty(name = "projectIds", value = "盘亏ID集")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField(value = "project_ids", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "project_ids")
   private String projectIds;
   private List<ProjectInfoDTO> projects;
   private LocalDateTime createTime;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public Integer getDeficitType() {
      return this.deficitType;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public List<ProjectInfoDTO> getProjects() {
      return this.projects;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("reviewStatus")
   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   @JsonProperty("reviewTime")
   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   @JsonProperty("applicantId")
   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   @JsonProperty("applicantName")
   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   @JsonProperty("reviewerName")
   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   @JsonProperty("reviewerId")
   public void setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
   }

   @JsonProperty("deficitType")
   public void setDeficitType(final Integer deficitType) {
      this.deficitType = deficitType;
   }

   @JsonProperty("basicClass")
   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   @JsonProperty("projectIds")
   public void setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
   }

   public void setProjects(final List<ProjectInfoDTO> projects) {
      this.projects = projects;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsDeficitDTO)) {
         return false;
      }

      WmsDeficitDTO other = (WmsDeficitDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reviewStatus = this.getReviewStatus();
         Object other$reviewStatus = other.getReviewStatus();
         if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
            Object this$applicantId = this.getApplicantId();
            Object other$applicantId = other.getApplicantId();
            if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
               Object this$reviewerId = this.getReviewerId();
               Object other$reviewerId = other.getReviewerId();
               if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                  Object this$deficitType = this.getDeficitType();
                  Object other$deficitType = other.getDeficitType();
                  if (this$deficitType == null ? other$deficitType == null : this$deficitType.equals(other$deficitType)) {
                     Object this$basicClass = this.getBasicClass();
                     Object other$basicClass = other.getBasicClass();
                     if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$reviewTime = this.getReviewTime();
                           Object other$reviewTime = other.getReviewTime();
                           if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                              Object this$applicantName = this.getApplicantName();
                              Object other$applicantName = other.getApplicantName();
                              if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                 Object this$reviewerName = this.getReviewerName();
                                 Object other$reviewerName = other.getReviewerName();
                                 if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                    Object this$projectIds = this.getProjectIds();
                                    Object other$projectIds = other.getProjectIds();
                                    if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                       Object this$projects = this.getProjects();
                                       Object other$projects = other.getProjects();
                                       if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                                          Object this$createTime = this.getCreateTime();
                                          Object other$createTime = other.getCreateTime();
                                          return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof WmsDeficitDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $deficitType = this.getDeficitType();
      result = result * 59 + ($deficitType == null ? 43 : $deficitType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "WmsDeficitDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewTime="
         + this.getReviewTime()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewerId="
         + this.getReviewerId()
         + ", deficitType="
         + this.getDeficitType()
         + ", basicClass="
         + this.getBasicClass()
         + ", projectIds="
         + this.getProjectIds()
         + ", projects="
         + this.getProjects()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }
}
