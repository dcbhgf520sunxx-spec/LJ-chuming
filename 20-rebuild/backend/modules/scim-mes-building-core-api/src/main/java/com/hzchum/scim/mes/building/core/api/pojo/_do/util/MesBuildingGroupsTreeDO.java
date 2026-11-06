package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class MesBuildingGroupsTreeDO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "teamList", value = "生产组名", notes = "生产组名")
   @JsonProperty("teamList")
   @JSONField(name = "teamList")
   private List<MesBuildingTeamTreeDO> teamList;

   public static MesBuildingGroupsTreeDO.MesBuildingGroupsTreeDOBuilder builder() {
      return new MesBuildingGroupsTreeDO.MesBuildingGroupsTreeDOBuilder();
   }

   public MesBuildingGroupsTreeDO() {
   }

   public MesBuildingGroupsTreeDO(final Long id, final List<MesBuildingTeamTreeDO> teamList) {
      this.id = id;
      this.teamList = teamList;
   }

   public Long getId() {
      return this.id;
   }

   public List<MesBuildingTeamTreeDO> getTeamList() {
      return this.teamList;
   }

   @JsonProperty("id")
   public MesBuildingGroupsTreeDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamList")
   public MesBuildingGroupsTreeDO setTeamList(final List<MesBuildingTeamTreeDO> teamList) {
      this.teamList = teamList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingGroupsTreeDO(id=" + this.getId() + ", teamList=" + this.getTeamList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingGroupsTreeDO)) {
         return false;
      } else {
         MesBuildingGroupsTreeDO other = (MesBuildingGroupsTreeDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$teamList = this.getTeamList();
               Object other$teamList = other.getTeamList();
               return this$teamList == null ? other$teamList == null : this$teamList.equals(other$teamList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingGroupsTreeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamList = this.getTeamList();
      return result * 59 + ($teamList == null ? 43 : $teamList.hashCode());
   }

   public static class MesBuildingGroupsTreeDOBuilder {
      private Long id;
      private List<MesBuildingTeamTreeDO> teamList;

      MesBuildingGroupsTreeDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingGroupsTreeDO.MesBuildingGroupsTreeDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamList")
      public MesBuildingGroupsTreeDO.MesBuildingGroupsTreeDOBuilder teamList(final List<MesBuildingTeamTreeDO> teamList) {
         this.teamList = teamList;
         return this;
      }

      public MesBuildingGroupsTreeDO build() {
         return new MesBuildingGroupsTreeDO(this.id, this.teamList);
      }

      @Override
      public String toString() {
         return "MesBuildingGroupsTreeDO.MesBuildingGroupsTreeDOBuilder(id=" + this.id + ", teamList=" + this.teamList + ")";
      }
   }
}
