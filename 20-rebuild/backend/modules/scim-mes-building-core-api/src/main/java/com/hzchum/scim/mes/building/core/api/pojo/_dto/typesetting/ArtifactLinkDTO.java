package com.hzchum.scim.mes.building.core.api.pojo._dto.typesetting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ArtifactLinkDTO", description = "关联构件信息 ")
public class ArtifactLinkDTO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", notes = "构件编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;

   public static ArtifactLinkDTO.ArtifactLinkDTOBuilder builder() {
      return new ArtifactLinkDTO.ArtifactLinkDTOBuilder();
   }

   public ArtifactLinkDTO() {
   }

   public ArtifactLinkDTO(final Long id, final String serialNumber, final String specification) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.specification = specification;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   @JsonProperty("id")
   public ArtifactLinkDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public ArtifactLinkDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ArtifactLinkDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactLinkDTO(id=" + this.getId() + ", serialNumber=" + this.getSerialNumber() + ", specification=" + this.getSpecification() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactLinkDTO)) {
         return false;
      }

      ArtifactLinkDTO other = (ArtifactLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$specification = this.getSpecification();
            Object other$specification = other.getSpecification();
            return this$specification == null ? other$specification == null : this$specification.equals(other$specification);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      return result * 59 + ($specification == null ? 43 : $specification.hashCode());
   }

   public static class ArtifactLinkDTOBuilder {
      private Long id;
      private String serialNumber;
      private String specification;

      ArtifactLinkDTOBuilder() {
      }

      @JsonProperty("id")
      public ArtifactLinkDTO.ArtifactLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public ArtifactLinkDTO.ArtifactLinkDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ArtifactLinkDTO.ArtifactLinkDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ArtifactLinkDTO build() {
         return new ArtifactLinkDTO(this.id, this.serialNumber, this.specification);
      }

      @Override
      public String toString() {
         return "ArtifactLinkDTO.ArtifactLinkDTOBuilder(id=" + this.id + ", serialNumber=" + this.serialNumber + ", specification=" + this.specification + ")";
      }
   }
}
