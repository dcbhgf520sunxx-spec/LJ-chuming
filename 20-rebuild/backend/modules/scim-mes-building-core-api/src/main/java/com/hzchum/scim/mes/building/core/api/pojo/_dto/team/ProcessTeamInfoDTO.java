package com.hzchum.scim.mes.building.core.api.pojo._dto.team;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Arrays;

@ApiModel(value = "ProcessTeamInfoDTO", description = "工序下各班组产量")
public class ProcessTeamInfoDTO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工序名称", value = "工序名称")
   private String name;
   private TeamSimpleInfoDTO[] teamSimpleInfoDTOArray;

   public static ProcessTeamInfoDTO.ProcessTeamInfoDTOBuilder builder() {
      return new ProcessTeamInfoDTO.ProcessTeamInfoDTOBuilder();
   }

   public ProcessTeamInfoDTO() {
   }

   public ProcessTeamInfoDTO(final Long id, final String name, final TeamSimpleInfoDTO[] teamSimpleInfoDTOArray) {
      this.id = id;
      this.name = name;
      this.teamSimpleInfoDTOArray = teamSimpleInfoDTOArray;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public TeamSimpleInfoDTO[] getTeamSimpleInfoDTOArray() {
      return this.teamSimpleInfoDTOArray;
   }

   public ProcessTeamInfoDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProcessTeamInfoDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public ProcessTeamInfoDTO setTeamSimpleInfoDTOArray(final TeamSimpleInfoDTO[] teamSimpleInfoDTOArray) {
      this.teamSimpleInfoDTOArray = teamSimpleInfoDTOArray;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessTeamInfoDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", teamSimpleInfoDTOArray="
         + Arrays.deepToString(this.getTeamSimpleInfoDTOArray())
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProcessTeamInfoDTO)) {
         return false;
      } else {
         ProcessTeamInfoDTO other = (ProcessTeamInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return (this$name == null ? other$name == null : this$name.equals(other$name))
                  ? Arrays.deepEquals(this.getTeamSimpleInfoDTOArray(), other.getTeamSimpleInfoDTOArray())
                  : false;
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessTeamInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      return result * 59 + Arrays.deepHashCode(this.getTeamSimpleInfoDTOArray());
   }

   public static class ProcessTeamInfoDTOBuilder {
      private Long id;
      private String name;
      private TeamSimpleInfoDTO[] teamSimpleInfoDTOArray;

      ProcessTeamInfoDTOBuilder() {
      }

      public ProcessTeamInfoDTO.ProcessTeamInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProcessTeamInfoDTO.ProcessTeamInfoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProcessTeamInfoDTO.ProcessTeamInfoDTOBuilder teamSimpleInfoDTOArray(final TeamSimpleInfoDTO[] teamSimpleInfoDTOArray) {
         this.teamSimpleInfoDTOArray = teamSimpleInfoDTOArray;
         return this;
      }

      public ProcessTeamInfoDTO build() {
         return new ProcessTeamInfoDTO(this.id, this.name, this.teamSimpleInfoDTOArray);
      }

      @Override
      public String toString() {
         return "ProcessTeamInfoDTO.ProcessTeamInfoDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", teamSimpleInfoDTOArray="
            + Arrays.deepToString(this.teamSimpleInfoDTOArray)
            + ")";
      }
   }
}
