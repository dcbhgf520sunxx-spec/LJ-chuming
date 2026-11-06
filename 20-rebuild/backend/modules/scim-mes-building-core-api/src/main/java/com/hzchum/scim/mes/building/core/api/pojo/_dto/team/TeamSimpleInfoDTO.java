package com.hzchum.scim.mes.building.core.api.pojo._dto.team;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TeamSimpleInfoDTO", description = "班组某工序下产量")
public class TeamSimpleInfoDTO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "姓名")
   private String name;
   @ApiModelProperty(name = "mete", value = "产量")
   private String mete;

   public static TeamSimpleInfoDTO.TeamSimpleInfoDTOBuilder builder() {
      return new TeamSimpleInfoDTO.TeamSimpleInfoDTOBuilder();
   }

   public TeamSimpleInfoDTO() {
   }

   public TeamSimpleInfoDTO(final Long id, final String name, final String mete) {
      this.id = id;
      this.name = name;
      this.mete = mete;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getMete() {
      return this.mete;
   }

   public TeamSimpleInfoDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public TeamSimpleInfoDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public TeamSimpleInfoDTO setMete(final String mete) {
      this.mete = mete;
      return this;
   }

   @Override
   public String toString() {
      return "TeamSimpleInfoDTO(id=" + this.getId() + ", name=" + this.getName() + ", mete=" + this.getMete() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamSimpleInfoDTO)) {
         return false;
      }

      TeamSimpleInfoDTO other = (TeamSimpleInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamSimpleInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   public static class TeamSimpleInfoDTOBuilder {
      private Long id;
      private String name;
      private String mete;

      TeamSimpleInfoDTOBuilder() {
      }

      public TeamSimpleInfoDTO.TeamSimpleInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TeamSimpleInfoDTO.TeamSimpleInfoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TeamSimpleInfoDTO.TeamSimpleInfoDTOBuilder mete(final String mete) {
         this.mete = mete;
         return this;
      }

      public TeamSimpleInfoDTO build() {
         return new TeamSimpleInfoDTO(this.id, this.name, this.mete);
      }

      @Override
      public String toString() {
         return "TeamSimpleInfoDTO.TeamSimpleInfoDTOBuilder(id=" + this.id + ", name=" + this.name + ", mete=" + this.mete + ")";
      }
   }
}
