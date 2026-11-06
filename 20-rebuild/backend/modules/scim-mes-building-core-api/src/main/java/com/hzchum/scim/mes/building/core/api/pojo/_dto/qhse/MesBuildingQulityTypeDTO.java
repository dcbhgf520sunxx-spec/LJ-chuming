package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingQhseDTO对象", description = "问题曝光 ")
public class MesBuildingQulityTypeDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;

   public static MesBuildingQulityTypeDTO.MesBuildingQulityTypeDTOBuilder builder() {
      return new MesBuildingQulityTypeDTO.MesBuildingQulityTypeDTOBuilder();
   }

   public MesBuildingQulityTypeDTO() {
   }

   public MesBuildingQulityTypeDTO(final Long id, final Long projectId, final Long monomerId) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   @JsonProperty("id")
   public MesBuildingQulityTypeDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingQulityTypeDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingQulityTypeDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQulityTypeDTO(id=" + this.getId() + ", projectId=" + this.getProjectId() + ", monomerId=" + this.getMonomerId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQulityTypeDTO)) {
         return false;
      }

      MesBuildingQulityTypeDTO other = (MesBuildingQulityTypeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            return this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingQulityTypeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      return result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
   }

   public static class MesBuildingQulityTypeDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;

      MesBuildingQulityTypeDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingQulityTypeDTO.MesBuildingQulityTypeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingQulityTypeDTO.MesBuildingQulityTypeDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingQulityTypeDTO.MesBuildingQulityTypeDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesBuildingQulityTypeDTO build() {
         return new MesBuildingQulityTypeDTO(this.id, this.projectId, this.monomerId);
      }

      @Override
      public String toString() {
         return "MesBuildingQulityTypeDTO.MesBuildingQulityTypeDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ")";
      }
   }
}
