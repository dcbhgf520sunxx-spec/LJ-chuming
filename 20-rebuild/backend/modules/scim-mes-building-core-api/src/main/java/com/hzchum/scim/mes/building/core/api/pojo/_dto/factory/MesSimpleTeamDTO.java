package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesSimpleTeamDTO", description = "")
public class MesSimpleTeamDTO {
   @ApiModelProperty(name = "id", notes = "班组id", value = "班组id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "workshopId", notes = "车间id", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "name", notes = "班组长名", value = "班组长名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;

   public static MesSimpleTeamDTO.MesSimpleTeamDTOBuilder builder() {
      return new MesSimpleTeamDTO.MesSimpleTeamDTOBuilder();
   }

   public MesSimpleTeamDTO() {
   }

   public MesSimpleTeamDTO(final Long id, final Long workshopId, final String name) {
      this.id = id;
      this.workshopId = workshopId;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("id")
   public MesSimpleTeamDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("workshopId")
   public MesSimpleTeamDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("name")
   public MesSimpleTeamDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "MesSimpleTeamDTO(id=" + this.getId() + ", workshopId=" + this.getWorkshopId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSimpleTeamDTO)) {
         return false;
      }

      MesSimpleTeamDTO other = (MesSimpleTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesSimpleTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesSimpleTeamDTOBuilder {
      private Long id;
      private Long workshopId;
      private String name;

      MesSimpleTeamDTOBuilder() {
      }

      @JsonProperty("id")
      public MesSimpleTeamDTO.MesSimpleTeamDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("workshopId")
      public MesSimpleTeamDTO.MesSimpleTeamDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("name")
      public MesSimpleTeamDTO.MesSimpleTeamDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesSimpleTeamDTO build() {
         return new MesSimpleTeamDTO(this.id, this.workshopId, this.name);
      }

      @Override
      public String toString() {
         return "MesSimpleTeamDTO.MesSimpleTeamDTOBuilder(id=" + this.id + ", workshopId=" + this.workshopId + ", name=" + this.name + ")";
      }
   }
}
