package com.hzchum.scim.mes.building.core.api.pojo._do.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class MesBuildingTeamTreeDO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;

   public static MesBuildingTeamTreeDO.MesBuildingTeamTreeDOBuilder builder() {
      return new MesBuildingTeamTreeDO.MesBuildingTeamTreeDOBuilder();
   }

   public MesBuildingTeamTreeDO() {
   }

   public MesBuildingTeamTreeDO(final Long id, final Long processId) {
      this.id = id;
      this.processId = processId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   @JsonProperty("id")
   public MesBuildingTeamTreeDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingTeamTreeDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTeamTreeDO(id=" + this.getId() + ", processId=" + this.getProcessId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingTeamTreeDO)) {
         return false;
      } else {
         MesBuildingTeamTreeDO other = (MesBuildingTeamTreeDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               return this$processId == null ? other$processId == null : this$processId.equals(other$processId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTeamTreeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      return result * 59 + ($processId == null ? 43 : $processId.hashCode());
   }

   public static class MesBuildingTeamTreeDOBuilder {
      private Long id;
      private Long processId;

      MesBuildingTeamTreeDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTeamTreeDO.MesBuildingTeamTreeDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingTeamTreeDO.MesBuildingTeamTreeDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBuildingTeamTreeDO build() {
         return new MesBuildingTeamTreeDO(this.id, this.processId);
      }

      @Override
      public String toString() {
         return "MesBuildingTeamTreeDO.MesBuildingTeamTreeDOBuilder(id=" + this.id + ", processId=" + this.processId + ")";
      }
   }
}
