package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingBoChuJobDirectoryDTO", description = "柏楚作业目录记录表")
public class MesBuildingBoChuJobDirectoryDTO {
   private Long id;
   @ApiModelProperty(name = "jobId")
   private Integer jobId;
   @ApiModelProperty(name = "parentId")
   private Integer parentId;
   @ApiModelProperty(name = "jobName")
   private String jobName;
   @ApiModelProperty(name = "jobType")
   private Integer jobType;
   @ApiModelProperty(name = "projectId")
   private String projectId;
   @ApiModelProperty(name = "workshopId")
   private String workshopId;
   @ApiModelProperty(name = "partSchedulingStatus")
   private Integer partSchedulingStatus;
   @ApiModelProperty(name = "children")
   private List<MesBuildingBoChuJobDirectoryDTO> children;

   public static MesBuildingBoChuJobDirectoryDTO.MesBuildingBoChuJobDirectoryDTOBuilder builder() {
      return new MesBuildingBoChuJobDirectoryDTO.MesBuildingBoChuJobDirectoryDTOBuilder();
   }

   public MesBuildingBoChuJobDirectoryDTO() {
   }

   public MesBuildingBoChuJobDirectoryDTO(
      final Long id,
      final Integer jobId,
      final Integer parentId,
      final String jobName,
      final Integer jobType,
      final String projectId,
      final String workshopId,
      final Integer partSchedulingStatus,
      final List<MesBuildingBoChuJobDirectoryDTO> children
   ) {
      this.id = id;
      this.jobId = jobId;
      this.parentId = parentId;
      this.jobName = jobName;
      this.jobType = jobType;
      this.projectId = projectId;
      this.workshopId = workshopId;
      this.partSchedulingStatus = partSchedulingStatus;
      this.children = children;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public Integer getParentId() {
      return this.parentId;
   }

   public String getJobName() {
      return this.jobName;
   }

   public Integer getJobType() {
      return this.jobType;
   }

   public String getProjectId() {
      return this.projectId;
   }

   public String getWorkshopId() {
      return this.workshopId;
   }

   public Integer getPartSchedulingStatus() {
      return this.partSchedulingStatus;
   }

   public List<MesBuildingBoChuJobDirectoryDTO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setJobId(final Integer jobId) {
      this.jobId = jobId;
   }

   public void setParentId(final Integer parentId) {
      this.parentId = parentId;
   }

   public void setJobName(final String jobName) {
      this.jobName = jobName;
   }

   public void setJobType(final Integer jobType) {
      this.jobType = jobType;
   }

   public void setProjectId(final String projectId) {
      this.projectId = projectId;
   }

   public void setWorkshopId(final String workshopId) {
      this.workshopId = workshopId;
   }

   public void setPartSchedulingStatus(final Integer partSchedulingStatus) {
      this.partSchedulingStatus = partSchedulingStatus;
   }

   public void setChildren(final List<MesBuildingBoChuJobDirectoryDTO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBoChuJobDirectoryDTO)) {
         return false;
      }

      MesBuildingBoChuJobDirectoryDTO other = (MesBuildingBoChuJobDirectoryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$jobId = this.getJobId();
         Object other$jobId = other.getJobId();
         if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
            Object this$parentId = this.getParentId();
            Object other$parentId = other.getParentId();
            if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
               Object this$jobType = this.getJobType();
               Object other$jobType = other.getJobType();
               if (this$jobType == null ? other$jobType == null : this$jobType.equals(other$jobType)) {
                  Object this$partSchedulingStatus = this.getPartSchedulingStatus();
                  Object other$partSchedulingStatus = other.getPartSchedulingStatus();
                  if (this$partSchedulingStatus == null ? other$partSchedulingStatus == null : this$partSchedulingStatus.equals(other$partSchedulingStatus)) {
                     Object this$jobName = this.getJobName();
                     Object other$jobName = other.getJobName();
                     if (this$jobName == null ? other$jobName == null : this$jobName.equals(other$jobName)) {
                        Object this$projectId = this.getProjectId();
                        Object other$projectId = other.getProjectId();
                        if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                           Object this$workshopId = this.getWorkshopId();
                           Object other$workshopId = other.getWorkshopId();
                           if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                              Object this$children = this.getChildren();
                              Object other$children = other.getChildren();
                              return this$children == null ? other$children == null : this$children.equals(other$children);
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
      return other instanceof MesBuildingBoChuJobDirectoryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $jobType = this.getJobType();
      result = result * 59 + ($jobType == null ? 43 : $jobType.hashCode());
      Object $partSchedulingStatus = this.getPartSchedulingStatus();
      result = result * 59 + ($partSchedulingStatus == null ? 43 : $partSchedulingStatus.hashCode());
      Object $jobName = this.getJobName();
      result = result * 59 + ($jobName == null ? 43 : $jobName.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingBoChuJobDirectoryDTO(id="
         + this.getId()
         + ", jobId="
         + this.getJobId()
         + ", parentId="
         + this.getParentId()
         + ", jobName="
         + this.getJobName()
         + ", jobType="
         + this.getJobType()
         + ", projectId="
         + this.getProjectId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", partSchedulingStatus="
         + this.getPartSchedulingStatus()
         + ", children="
         + this.getChildren()
         + ")";
   }

   public static class MesBuildingBoChuJobDirectoryDTOBuilder {
      private Long id;
      private Integer jobId;
      private Integer parentId;
      private String jobName;
      private Integer jobType;
      private String projectId;
      private String workshopId;
      private Integer partSchedulingStatus;
      private List<MesBuildingBoChuJobDirectoryDTO> children;

      MesBuildingBoChuJobDirectoryDTOBuilder() {
      }

      public MesBuildingBoChuJobDirectoryDTO.MesBuildingBoChuJobDirectoryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingBoChuJobDirectoryDTO.MesBuildingBoChuJobDirectoryDTOBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public MesBuildingBoChuJobDirectoryDTO.MesBuildingBoChuJobDirectoryDTOBuilder parentId(final Integer parentId) {
         this.parentId = parentId;
         return this;
      }

      public MesBuildingBoChuJobDirectoryDTO.MesBuildingBoChuJobDirectoryDTOBuilder jobName(final String jobName) {
         this.jobName = jobName;
         return this;
      }

      public MesBuildingBoChuJobDirectoryDTO.MesBuildingBoChuJobDirectoryDTOBuilder jobType(final Integer jobType) {
         this.jobType = jobType;
         return this;
      }

      public MesBuildingBoChuJobDirectoryDTO.MesBuildingBoChuJobDirectoryDTOBuilder projectId(final String projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingBoChuJobDirectoryDTO.MesBuildingBoChuJobDirectoryDTOBuilder workshopId(final String workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingBoChuJobDirectoryDTO.MesBuildingBoChuJobDirectoryDTOBuilder partSchedulingStatus(final Integer partSchedulingStatus) {
         this.partSchedulingStatus = partSchedulingStatus;
         return this;
      }

      public MesBuildingBoChuJobDirectoryDTO.MesBuildingBoChuJobDirectoryDTOBuilder children(final List<MesBuildingBoChuJobDirectoryDTO> children) {
         this.children = children;
         return this;
      }

      public MesBuildingBoChuJobDirectoryDTO build() {
         return new MesBuildingBoChuJobDirectoryDTO(
            this.id, this.jobId, this.parentId, this.jobName, this.jobType, this.projectId, this.workshopId, this.partSchedulingStatus, this.children
         );
      }

      @Override
      public String toString() {
         return "MesBuildingBoChuJobDirectoryDTO.MesBuildingBoChuJobDirectoryDTOBuilder(id="
            + this.id
            + ", jobId="
            + this.jobId
            + ", parentId="
            + this.parentId
            + ", jobName="
            + this.jobName
            + ", jobType="
            + this.jobType
            + ", projectId="
            + this.projectId
            + ", workshopId="
            + this.workshopId
            + ", partSchedulingStatus="
            + this.partSchedulingStatus
            + ", children="
            + this.children
            + ")";
      }
   }
}
