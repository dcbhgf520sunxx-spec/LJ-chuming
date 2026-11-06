package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;

@ApiModel("任务工序Query")
public class MesBuildingTaskProcessQuery {
   @ApiModelProperty("项目idList")
   private Collection<Long> projectIdList;
   @ApiModelProperty("车间id")
   private Long workshopId;

   public static MesBuildingTaskProcessQuery.MesBuildingTaskProcessQueryBuilder builder() {
      return new MesBuildingTaskProcessQuery.MesBuildingTaskProcessQueryBuilder();
   }

   public Collection<Long> getProjectIdList() {
      return this.projectIdList;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public void setProjectIdList(final Collection<Long> projectIdList) {
      this.projectIdList = projectIdList;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingTaskProcessQuery)) {
         return false;
      } else {
         MesBuildingTaskProcessQuery other = (MesBuildingTaskProcessQuery)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$projectIdList = this.getProjectIdList();
               Object other$projectIdList = other.getProjectIdList();
               return this$projectIdList == null ? other$projectIdList == null : this$projectIdList.equals(other$projectIdList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskProcessQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectIdList = this.getProjectIdList();
      return result * 59 + ($projectIdList == null ? 43 : $projectIdList.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingTaskProcessQuery(projectIdList=" + this.getProjectIdList() + ", workshopId=" + this.getWorkshopId() + ")";
   }

   public MesBuildingTaskProcessQuery() {
   }

   public MesBuildingTaskProcessQuery(final Collection<Long> projectIdList, final Long workshopId) {
      this.projectIdList = projectIdList;
      this.workshopId = workshopId;
   }

   public static class MesBuildingTaskProcessQueryBuilder {
      private Collection<Long> projectIdList;
      private Long workshopId;

      MesBuildingTaskProcessQueryBuilder() {
      }

      public MesBuildingTaskProcessQuery.MesBuildingTaskProcessQueryBuilder projectIdList(final Collection<Long> projectIdList) {
         this.projectIdList = projectIdList;
         return this;
      }

      public MesBuildingTaskProcessQuery.MesBuildingTaskProcessQueryBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingTaskProcessQuery build() {
         return new MesBuildingTaskProcessQuery(this.projectIdList, this.workshopId);
      }

      @Override
      public String toString() {
         return "MesBuildingTaskProcessQuery.MesBuildingTaskProcessQueryBuilder(projectIdList=" + this.projectIdList + ", workshopId=" + this.workshopId + ")";
      }
   }
}
