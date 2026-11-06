package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

public class ProjectStandingBookDto {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDate createTime;
   @ApiModelProperty(name = "projectAttribute", notes = "项目属性: 1.自营 2.合营 3.包干制 枚举:ProjectAttributeEnum")
   private Integer projectAttribute;
   @ApiModelProperty(name = "status", value = "项目状态  1：进行中，2：已暂停，4：已完工")
   private Integer status;
   private ProjectLedgerDTO projectLedgerDTO;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public LocalDate getCreateTime() {
      return this.createTime;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getStatus() {
      return this.status;
   }

   public ProjectLedgerDTO getProjectLedgerDTO() {
      return this.projectLedgerDTO;
   }

   public ProjectStandingBookDto setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectStandingBookDto setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ProjectStandingBookDto setCreateTime(final LocalDate createTime) {
      this.createTime = createTime;
      return this;
   }

   public ProjectStandingBookDto setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   public ProjectStandingBookDto setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public ProjectStandingBookDto setProjectLedgerDTO(final ProjectLedgerDTO projectLedgerDTO) {
      this.projectLedgerDTO = projectLedgerDTO;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectStandingBookDto)) {
         return false;
      }

      ProjectStandingBookDto other = (ProjectStandingBookDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$projectAttribute = this.getProjectAttribute();
         Object other$projectAttribute = other.getProjectAttribute();
         if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$createTime = this.getCreateTime();
                  Object other$createTime = other.getCreateTime();
                  if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                     Object this$projectLedgerDTO = this.getProjectLedgerDTO();
                     Object other$projectLedgerDTO = other.getProjectLedgerDTO();
                     return this$projectLedgerDTO == null ? other$projectLedgerDTO == null : this$projectLedgerDTO.equals(other$projectLedgerDTO);
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
      return other instanceof ProjectStandingBookDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $projectLedgerDTO = this.getProjectLedgerDTO();
      return result * 59 + ($projectLedgerDTO == null ? 43 : $projectLedgerDTO.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectStandingBookDto(projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", createTime="
         + this.getCreateTime()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", status="
         + this.getStatus()
         + ", projectLedgerDTO="
         + this.getProjectLedgerDTO()
         + ")";
   }

   public ProjectStandingBookDto() {
   }

   public ProjectStandingBookDto(
      final Long projectId,
      final String projectName,
      final LocalDate createTime,
      final Integer projectAttribute,
      final Integer status,
      final ProjectLedgerDTO projectLedgerDTO
   ) {
      this.projectId = projectId;
      this.projectName = projectName;
      this.createTime = createTime;
      this.projectAttribute = projectAttribute;
      this.status = status;
      this.projectLedgerDTO = projectLedgerDTO;
   }
}
