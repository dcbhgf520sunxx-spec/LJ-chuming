package com.hzchum.scim.mes.building.core.api.pojo._dto.task.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "AssistTeamDTO", description = "添加任务协同生产线信息")
public class AssistProductionLineDTO {
   @ApiModelProperty(name = "id", notes = "生产线id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "生产线名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "teamList", notes = "班组列表")
   @JsonProperty("teamList")
   @JSONField(name = "teamList")
   private List<AssistTeamDTO> teamList;

   public static AssistProductionLineDTO.AssistProductionLineDTOBuilder builder() {
      return new AssistProductionLineDTO.AssistProductionLineDTOBuilder();
   }

   public AssistProductionLineDTO() {
   }

   public AssistProductionLineDTO(final Long id, final String name, final List<AssistTeamDTO> teamList) {
      this.id = id;
      this.name = name;
      this.teamList = teamList;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<AssistTeamDTO> getTeamList() {
      return this.teamList;
   }

   @JsonProperty("id")
   public AssistProductionLineDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public AssistProductionLineDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("teamList")
   public AssistProductionLineDTO setTeamList(final List<AssistTeamDTO> teamList) {
      this.teamList = teamList;
      return this;
   }

   @Override
   public String toString() {
      return "AssistProductionLineDTO(id=" + this.getId() + ", name=" + this.getName() + ", teamList=" + this.getTeamList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssistProductionLineDTO)) {
         return false;
      }

      AssistProductionLineDTO other = (AssistProductionLineDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$teamList = this.getTeamList();
            Object other$teamList = other.getTeamList();
            return this$teamList == null ? other$teamList == null : this$teamList.equals(other$teamList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssistProductionLineDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $teamList = this.getTeamList();
      return result * 59 + ($teamList == null ? 43 : $teamList.hashCode());
   }

   public static class AssistProductionLineDTOBuilder {
      private Long id;
      private String name;
      private List<AssistTeamDTO> teamList;

      AssistProductionLineDTOBuilder() {
      }

      @JsonProperty("id")
      public AssistProductionLineDTO.AssistProductionLineDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public AssistProductionLineDTO.AssistProductionLineDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("teamList")
      public AssistProductionLineDTO.AssistProductionLineDTOBuilder teamList(final List<AssistTeamDTO> teamList) {
         this.teamList = teamList;
         return this;
      }

      public AssistProductionLineDTO build() {
         return new AssistProductionLineDTO(this.id, this.name, this.teamList);
      }

      @Override
      public String toString() {
         return "AssistProductionLineDTO.AssistProductionLineDTOBuilder(id=" + this.id + ", name=" + this.name + ", teamList=" + this.teamList + ")";
      }
   }
}
