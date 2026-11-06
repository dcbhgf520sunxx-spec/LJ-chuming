package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;

@ApiModel("班组Query")
public class MesBuildingTeamQuery {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("idList")
   private Collection<Long> idList;
   @ApiModelProperty("工序id")
   private Long processId;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("车间id")
   private Long workshopId;

   public static MesBuildingTeamQuery.MesBuildingTeamQueryBuilder builder() {
      return new MesBuildingTeamQuery.MesBuildingTeamQueryBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Collection<Long> getIdList() {
      return this.idList;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getName() {
      return this.name;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setIdList(final Collection<Long> idList) {
      this.idList = idList;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTeamQuery)) {
         return false;
      }

      MesBuildingTeamQuery other = (MesBuildingTeamQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$idList = this.getIdList();
               Object other$idList = other.getIdList();
               if (this$idList == null ? other$idList == null : this$idList.equals(other$idList)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof MesBuildingTeamQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $idList = this.getIdList();
      result = result * 59 + ($idList == null ? 43 : $idList.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingTeamQuery(id="
         + this.getId()
         + ", idList="
         + this.getIdList()
         + ", processId="
         + this.getProcessId()
         + ", name="
         + this.getName()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }

   public MesBuildingTeamQuery() {
   }

   public MesBuildingTeamQuery(final Long id, final Collection<Long> idList, final Long processId, final String name, final Long workshopId) {
      this.id = id;
      this.idList = idList;
      this.processId = processId;
      this.name = name;
      this.workshopId = workshopId;
   }

   public static class MesBuildingTeamQueryBuilder {
      private Long id;
      private Collection<Long> idList;
      private Long processId;
      private String name;
      private Long workshopId;

      MesBuildingTeamQueryBuilder() {
      }

      public MesBuildingTeamQuery.MesBuildingTeamQueryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingTeamQuery.MesBuildingTeamQueryBuilder idList(final Collection<Long> idList) {
         this.idList = idList;
         return this;
      }

      public MesBuildingTeamQuery.MesBuildingTeamQueryBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBuildingTeamQuery.MesBuildingTeamQueryBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingTeamQuery.MesBuildingTeamQueryBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingTeamQuery build() {
         return new MesBuildingTeamQuery(this.id, this.idList, this.processId, this.name, this.workshopId);
      }

      @Override
      public String toString() {
         return "MesBuildingTeamQuery.MesBuildingTeamQueryBuilder(id="
            + this.id
            + ", idList="
            + this.idList
            + ", processId="
            + this.processId
            + ", name="
            + this.name
            + ", workshopId="
            + this.workshopId
            + ")";
      }
   }
}
