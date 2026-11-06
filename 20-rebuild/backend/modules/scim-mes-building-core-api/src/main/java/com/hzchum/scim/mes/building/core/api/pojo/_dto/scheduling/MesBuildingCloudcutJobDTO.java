package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingCloudcutJobDTO", description = "云切助手作业")
public class MesBuildingCloudcutJobDTO {
   private Long id;
   private String cloudcutName;
   private Long workshopId;
   private Long parentId;
   private Integer jobType;

   public static MesBuildingCloudcutJobDTO.MesBuildingCloudcutJobDTOBuilder builder() {
      return new MesBuildingCloudcutJobDTO.MesBuildingCloudcutJobDTOBuilder();
   }

   public MesBuildingCloudcutJobDTO() {
   }

   public MesBuildingCloudcutJobDTO(final Long id, final String cloudcutName, final Long workshopId, final Long parentId, final Integer jobType) {
      this.id = id;
      this.cloudcutName = cloudcutName;
      this.workshopId = workshopId;
      this.parentId = parentId;
      this.jobType = jobType;
   }

   public Long getId() {
      return this.id;
   }

   public String getCloudcutName() {
      return this.cloudcutName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public Integer getJobType() {
      return this.jobType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCloudcutName(final String cloudcutName) {
      this.cloudcutName = cloudcutName;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setParentId(final Long parentId) {
      this.parentId = parentId;
   }

   public void setJobType(final Integer jobType) {
      this.jobType = jobType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCloudcutJobDTO)) {
         return false;
      }

      MesBuildingCloudcutJobDTO other = (MesBuildingCloudcutJobDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$parentId = this.getParentId();
            Object other$parentId = other.getParentId();
            if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
               Object this$jobType = this.getJobType();
               Object other$jobType = other.getJobType();
               if (this$jobType == null ? other$jobType == null : this$jobType.equals(other$jobType)) {
                  Object this$cloudcutName = this.getCloudcutName();
                  Object other$cloudcutName = other.getCloudcutName();
                  return this$cloudcutName == null ? other$cloudcutName == null : this$cloudcutName.equals(other$cloudcutName);
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
      return other instanceof MesBuildingCloudcutJobDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $jobType = this.getJobType();
      result = result * 59 + ($jobType == null ? 43 : $jobType.hashCode());
      Object $cloudcutName = this.getCloudcutName();
      return result * 59 + ($cloudcutName == null ? 43 : $cloudcutName.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingCloudcutJobDTO(id="
         + this.getId()
         + ", cloudcutName="
         + this.getCloudcutName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", parentId="
         + this.getParentId()
         + ", jobType="
         + this.getJobType()
         + ")";
   }

   public static class MesBuildingCloudcutJobDTOBuilder {
      private Long id;
      private String cloudcutName;
      private Long workshopId;
      private Long parentId;
      private Integer jobType;

      MesBuildingCloudcutJobDTOBuilder() {
      }

      public MesBuildingCloudcutJobDTO.MesBuildingCloudcutJobDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingCloudcutJobDTO.MesBuildingCloudcutJobDTOBuilder cloudcutName(final String cloudcutName) {
         this.cloudcutName = cloudcutName;
         return this;
      }

      public MesBuildingCloudcutJobDTO.MesBuildingCloudcutJobDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingCloudcutJobDTO.MesBuildingCloudcutJobDTOBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      public MesBuildingCloudcutJobDTO.MesBuildingCloudcutJobDTOBuilder jobType(final Integer jobType) {
         this.jobType = jobType;
         return this;
      }

      public MesBuildingCloudcutJobDTO build() {
         return new MesBuildingCloudcutJobDTO(this.id, this.cloudcutName, this.workshopId, this.parentId, this.jobType);
      }

      @Override
      public String toString() {
         return "MesBuildingCloudcutJobDTO.MesBuildingCloudcutJobDTOBuilder(id="
            + this.id
            + ", cloudcutName="
            + this.cloudcutName
            + ", workshopId="
            + this.workshopId
            + ", parentId="
            + this.parentId
            + ", jobType="
            + this.jobType
            + ")";
      }
   }
}
