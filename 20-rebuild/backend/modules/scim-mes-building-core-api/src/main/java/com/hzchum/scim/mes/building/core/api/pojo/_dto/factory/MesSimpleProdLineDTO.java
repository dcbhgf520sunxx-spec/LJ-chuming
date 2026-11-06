package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesSimpleProdLineDTO", description = "")
public class MesSimpleProdLineDTO {
   @ApiModelProperty(name = "id", notes = "产线id", value = "产线id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "产线名称", value = "产线名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "teamInfo", notes = "班组信息", value = "班组信息")
   private List<MesSimpleTeamDTO> teamInfo;

   public static MesSimpleProdLineDTO.MesSimpleProdLineDTOBuilder builder() {
      return new MesSimpleProdLineDTO.MesSimpleProdLineDTOBuilder();
   }

   public MesSimpleProdLineDTO() {
   }

   public MesSimpleProdLineDTO(final Long id, final String name, final List<MesSimpleTeamDTO> teamInfo) {
      this.id = id;
      this.name = name;
      this.teamInfo = teamInfo;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<MesSimpleTeamDTO> getTeamInfo() {
      return this.teamInfo;
   }

   @JsonProperty("id")
   public MesSimpleProdLineDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesSimpleProdLineDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public MesSimpleProdLineDTO setTeamInfo(final List<MesSimpleTeamDTO> teamInfo) {
      this.teamInfo = teamInfo;
      return this;
   }

   @Override
   public String toString() {
      return "MesSimpleProdLineDTO(id=" + this.getId() + ", name=" + this.getName() + ", teamInfo=" + this.getTeamInfo() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSimpleProdLineDTO)) {
         return false;
      }

      MesSimpleProdLineDTO other = (MesSimpleProdLineDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$teamInfo = this.getTeamInfo();
            Object other$teamInfo = other.getTeamInfo();
            return this$teamInfo == null ? other$teamInfo == null : this$teamInfo.equals(other$teamInfo);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesSimpleProdLineDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $teamInfo = this.getTeamInfo();
      return result * 59 + ($teamInfo == null ? 43 : $teamInfo.hashCode());
   }

   public static class MesSimpleProdLineDTOBuilder {
      private Long id;
      private String name;
      private List<MesSimpleTeamDTO> teamInfo;

      MesSimpleProdLineDTOBuilder() {
      }

      @JsonProperty("id")
      public MesSimpleProdLineDTO.MesSimpleProdLineDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesSimpleProdLineDTO.MesSimpleProdLineDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesSimpleProdLineDTO.MesSimpleProdLineDTOBuilder teamInfo(final List<MesSimpleTeamDTO> teamInfo) {
         this.teamInfo = teamInfo;
         return this;
      }

      public MesSimpleProdLineDTO build() {
         return new MesSimpleProdLineDTO(this.id, this.name, this.teamInfo);
      }

      @Override
      public String toString() {
         return "MesSimpleProdLineDTO.MesSimpleProdLineDTOBuilder(id=" + this.id + ", name=" + this.name + ", teamInfo=" + this.teamInfo + ")";
      }
   }
}
