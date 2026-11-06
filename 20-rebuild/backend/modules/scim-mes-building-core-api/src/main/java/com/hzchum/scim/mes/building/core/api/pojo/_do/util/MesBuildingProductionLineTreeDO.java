package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class MesBuildingProductionLineTreeDO {
   @ApiModelProperty(name = "id", value = "insepctConfigIds", notes = "质检基础配置id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "teamIds", value = "生产组名", notes = "生产组名")
   @JsonProperty("teamIds")
   @JSONField(name = "teamIds")
   private List<MesBuildingTeamTreeDO> teamList;
   @ApiModelProperty(name = "classIds", value = "种类id", notes = "种类id")
   @JsonProperty("classIds")
   @JSONField(name = "classIds")
   private List<Long> classIds;

   public static MesBuildingProductionLineTreeDO.MesBuildingProductionLineTreeDOBuilder builder() {
      return new MesBuildingProductionLineTreeDO.MesBuildingProductionLineTreeDOBuilder();
   }

   public MesBuildingProductionLineTreeDO() {
   }

   public MesBuildingProductionLineTreeDO(final Long id, final List<MesBuildingTeamTreeDO> teamList, final List<Long> classIds) {
      this.id = id;
      this.teamList = teamList;
      this.classIds = classIds;
   }

   public Long getId() {
      return this.id;
   }

   public List<MesBuildingTeamTreeDO> getTeamList() {
      return this.teamList;
   }

   public List<Long> getClassIds() {
      return this.classIds;
   }

   @JsonProperty("id")
   public MesBuildingProductionLineTreeDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamIds")
   public MesBuildingProductionLineTreeDO setTeamList(final List<MesBuildingTeamTreeDO> teamList) {
      this.teamList = teamList;
      return this;
   }

   @JsonProperty("classIds")
   public MesBuildingProductionLineTreeDO setClassIds(final List<Long> classIds) {
      this.classIds = classIds;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductionLineTreeDO(id=" + this.getId() + ", teamList=" + this.getTeamList() + ", classIds=" + this.getClassIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductionLineTreeDO)) {
         return false;
      }

      MesBuildingProductionLineTreeDO other = (MesBuildingProductionLineTreeDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$teamList = this.getTeamList();
         Object other$teamList = other.getTeamList();
         if (this$teamList == null ? other$teamList == null : this$teamList.equals(other$teamList)) {
            Object this$classIds = this.getClassIds();
            Object other$classIds = other.getClassIds();
            return this$classIds == null ? other$classIds == null : this$classIds.equals(other$classIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProductionLineTreeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamList = this.getTeamList();
      result = result * 59 + ($teamList == null ? 43 : $teamList.hashCode());
      Object $classIds = this.getClassIds();
      return result * 59 + ($classIds == null ? 43 : $classIds.hashCode());
   }

   public static class MesBuildingProductionLineTreeDOBuilder {
      private Long id;
      private List<MesBuildingTeamTreeDO> teamList;
      private List<Long> classIds;

      MesBuildingProductionLineTreeDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductionLineTreeDO.MesBuildingProductionLineTreeDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamIds")
      public MesBuildingProductionLineTreeDO.MesBuildingProductionLineTreeDOBuilder teamList(final List<MesBuildingTeamTreeDO> teamList) {
         this.teamList = teamList;
         return this;
      }

      @JsonProperty("classIds")
      public MesBuildingProductionLineTreeDO.MesBuildingProductionLineTreeDOBuilder classIds(final List<Long> classIds) {
         this.classIds = classIds;
         return this;
      }

      public MesBuildingProductionLineTreeDO build() {
         return new MesBuildingProductionLineTreeDO(this.id, this.teamList, this.classIds);
      }

      @Override
      public String toString() {
         return "MesBuildingProductionLineTreeDO.MesBuildingProductionLineTreeDOBuilder(id="
            + this.id
            + ", teamList="
            + this.teamList
            + ", classIds="
            + this.classIds
            + ")";
      }
   }
}
