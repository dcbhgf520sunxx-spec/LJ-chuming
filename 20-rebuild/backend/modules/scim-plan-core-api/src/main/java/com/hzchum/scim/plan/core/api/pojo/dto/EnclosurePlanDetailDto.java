package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("围护计划响应类")
public class EnclosurePlanDetailDto {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "projectCode", value = "项目编号")
   private String projectCode;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "shortName", value = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "signerName", value = "销售负责人")
   private String signerName;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "projectContent", value = "合同内筒")
   private String projectContent;
   @ApiModelProperty(name = "createName", value = "创建人")
   private String createName;
   @ApiModelProperty(name = "type", value = "状态，0未创建，1已创建,2部分已创建")
   private Integer type;
   @ApiModelProperty(name = "startDate", value = "开始时间")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "结束时间")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "signingDate", value = "合同签订时间")
   private LocalDateTime signingDate;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectCode() {
      return this.projectCode;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getProjectContent() {
      return this.projectContent;
   }

   public String getCreateName() {
      return this.createName;
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public LocalDateTime getSigningDate() {
      return this.signingDate;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectCode(final String projectCode) {
      this.projectCode = projectCode;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setProjectContent(final String projectContent) {
      this.projectContent = projectContent;
   }

   public void setCreateName(final String createName) {
      this.createName = createName;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
   }

   public void setSigningDate(final LocalDateTime signingDate) {
      this.signingDate = signingDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosurePlanDetailDto)) {
         return false;
      }

      EnclosurePlanDetailDto other = (EnclosurePlanDetailDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$projectCode = this.getProjectCode();
            Object other$projectCode = other.getProjectCode();
            if (this$projectCode == null ? other$projectCode == null : this$projectCode.equals(other$projectCode)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$signerName = this.getSignerName();
                     Object other$signerName = other.getSignerName();
                     if (this$signerName == null ? other$signerName == null : this$signerName.equals(other$signerName)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$projectContent = this.getProjectContent();
                           Object other$projectContent = other.getProjectContent();
                           if (this$projectContent == null ? other$projectContent == null : this$projectContent.equals(other$projectContent)) {
                              Object this$createName = this.getCreateName();
                              Object other$createName = other.getCreateName();
                              if (this$createName == null ? other$createName == null : this$createName.equals(other$createName)) {
                                 Object this$startDate = this.getStartDate();
                                 Object other$startDate = other.getStartDate();
                                 if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                    Object this$endDate = this.getEndDate();
                                    Object other$endDate = other.getEndDate();
                                    if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                       Object this$signingDate = this.getSigningDate();
                                       Object other$signingDate = other.getSigningDate();
                                       return this$signingDate == null ? other$signingDate == null : this$signingDate.equals(other$signingDate);
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
      return other instanceof EnclosurePlanDetailDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $projectCode = this.getProjectCode();
      result = result * 59 + ($projectCode == null ? 43 : $projectCode.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $projectContent = this.getProjectContent();
      result = result * 59 + ($projectContent == null ? 43 : $projectContent.hashCode());
      Object $createName = this.getCreateName();
      result = result * 59 + ($createName == null ? 43 : $createName.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $signingDate = this.getSigningDate();
      return result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosurePlanDetailDto(projectId="
         + this.getProjectId()
         + ", projectCode="
         + this.getProjectCode()
         + ", projectName="
         + this.getProjectName()
         + ", shortName="
         + this.getShortName()
         + ", signerName="
         + this.getSignerName()
         + ", createTime="
         + this.getCreateTime()
         + ", projectContent="
         + this.getProjectContent()
         + ", createName="
         + this.getCreateName()
         + ", type="
         + this.getType()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", signingDate="
         + this.getSigningDate()
         + ")";
   }
}
