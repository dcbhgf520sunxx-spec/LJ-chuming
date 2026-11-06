package com.hzchum.scim.mes.enclosure.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class MesEnclosureGroupsTreeDO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "teamList", value = "生产组名", notes = "生产组名")
   @JsonProperty("teamList")
   @JSONField(name = "teamList")
   private List<MesEnclosureTeamTreeDO> teamList;

   public static MesEnclosureGroupsTreeDO.MesEnclosureGroupsTreeDOBuilder builder() {
      return new MesEnclosureGroupsTreeDO.MesEnclosureGroupsTreeDOBuilder();
   }

   public MesEnclosureGroupsTreeDO() {
   }

   public MesEnclosureGroupsTreeDO(final Long id, final List<MesEnclosureTeamTreeDO> teamList) {
      this.id = id;
      this.teamList = teamList;
   }

   public Long getId() {
      return this.id;
   }

   public List<MesEnclosureTeamTreeDO> getTeamList() {
      return this.teamList;
   }

   @JsonProperty("id")
   public MesEnclosureGroupsTreeDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamList")
   public MesEnclosureGroupsTreeDO setTeamList(final List<MesEnclosureTeamTreeDO> teamList) {
      this.teamList = teamList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureGroupsTreeDO(id=" + this.getId() + ", teamList=" + this.getTeamList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesEnclosureGroupsTreeDO)) {
         return false;
      } else {
         MesEnclosureGroupsTreeDO other = (MesEnclosureGroupsTreeDO)o;
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
      return other instanceof MesEnclosureGroupsTreeDO;
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

   public static class MesEnclosureGroupsTreeDOBuilder {
      private Long id;
      private List<MesEnclosureTeamTreeDO> teamList;

      MesEnclosureGroupsTreeDOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureGroupsTreeDO.MesEnclosureGroupsTreeDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamList")
      public MesEnclosureGroupsTreeDO.MesEnclosureGroupsTreeDOBuilder teamList(final List<MesEnclosureTeamTreeDO> teamList) {
         this.teamList = teamList;
         return this;
      }

      public MesEnclosureGroupsTreeDO build() {
         return new MesEnclosureGroupsTreeDO(this.id, this.teamList);
      }

      @Override
      public String toString() {
         return "MesEnclosureGroupsTreeDO.MesEnclosureGroupsTreeDOBuilder(id=" + this.id + ", teamList=" + this.teamList + ")";
      }
   }
}
