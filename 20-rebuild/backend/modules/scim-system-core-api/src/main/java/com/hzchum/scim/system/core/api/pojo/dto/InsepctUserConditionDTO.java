package com.hzchum.scim.system.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class InsepctUserConditionDTO {
   @ApiModelProperty(name = "id", value = "insepctConfigIds", notes = "质检基础配置id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "teamIds", value = "生产组名", notes = "生产组名")
   @JsonProperty("teamIds")
   @JSONField(name = "teamIds")
   private List<TeamInfoDTO> teamList;
   @ApiModelProperty(name = "classIds", value = "种类id", notes = "种类id")
   @JsonProperty("classIds")
   @JSONField(name = "classIds")
   private List<Long> classIds;

   public static InsepctUserConditionDTO.InsepctUserConditionDTOBuilder builder() {
      return new InsepctUserConditionDTO.InsepctUserConditionDTOBuilder();
   }

   public InsepctUserConditionDTO() {
   }

   public InsepctUserConditionDTO(final Long id, final List<TeamInfoDTO> teamList, final List<Long> classIds) {
      this.id = id;
      this.teamList = teamList;
      this.classIds = classIds;
   }

   public Long getId() {
      return this.id;
   }

   public List<TeamInfoDTO> getTeamList() {
      return this.teamList;
   }

   public List<Long> getClassIds() {
      return this.classIds;
   }

   @JsonProperty("id")
   public InsepctUserConditionDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamIds")
   public InsepctUserConditionDTO setTeamList(final List<TeamInfoDTO> teamList) {
      this.teamList = teamList;
      return this;
   }

   @JsonProperty("classIds")
   public InsepctUserConditionDTO setClassIds(final List<Long> classIds) {
      this.classIds = classIds;
      return this;
   }

   @Override
   public String toString() {
      return "InsepctUserConditionDTO(id=" + this.getId() + ", teamList=" + this.getTeamList() + ", classIds=" + this.getClassIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InsepctUserConditionDTO)) {
         return false;
      }

      InsepctUserConditionDTO other = (InsepctUserConditionDTO)o;
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
      return other instanceof InsepctUserConditionDTO;
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

   public static class InsepctUserConditionDTOBuilder {
      private Long id;
      private List<TeamInfoDTO> teamList;
      private List<Long> classIds;

      InsepctUserConditionDTOBuilder() {
      }

      @JsonProperty("id")
      public InsepctUserConditionDTO.InsepctUserConditionDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamIds")
      public InsepctUserConditionDTO.InsepctUserConditionDTOBuilder teamList(final List<TeamInfoDTO> teamList) {
         this.teamList = teamList;
         return this;
      }

      @JsonProperty("classIds")
      public InsepctUserConditionDTO.InsepctUserConditionDTOBuilder classIds(final List<Long> classIds) {
         this.classIds = classIds;
         return this;
      }

      public InsepctUserConditionDTO build() {
         return new InsepctUserConditionDTO(this.id, this.teamList, this.classIds);
      }

      @Override
      public String toString() {
         return "InsepctUserConditionDTO.InsepctUserConditionDTOBuilder(id=" + this.id + ", teamList=" + this.teamList + ", classIds=" + this.classIds + ")";
      }
   }
}
