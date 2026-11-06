package com.hzchum.scim.mes.building.core.api.pojo._dto.typesetting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "AssembleLinkDTO", description = "母件关联部件信息 ")
public class AssembleLinkDTO {
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
   @ApiModelProperty(name = "quantity", notes = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "artifactLinkList", notes = "关联构件信息")
   @JsonProperty("artifactLinkList")
   @JSONField(name = "artifactLinkList")
   private List<ArtifactLinkDTO> artifactLinkList;

   public static AssembleLinkDTO.AssembleLinkDTOBuilder builder() {
      return new AssembleLinkDTO.AssembleLinkDTOBuilder();
   }

   public AssembleLinkDTO() {
   }

   public AssembleLinkDTO(
      final Long id, final String serialNumber, final String specification, final Integer quantity, final List<ArtifactLinkDTO> artifactLinkList
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.artifactLinkList = artifactLinkList;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public List<ArtifactLinkDTO> getArtifactLinkList() {
      return this.artifactLinkList;
   }

   @JsonProperty("id")
   public AssembleLinkDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public AssembleLinkDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public AssembleLinkDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public AssembleLinkDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("artifactLinkList")
   public AssembleLinkDTO setArtifactLinkList(final List<ArtifactLinkDTO> artifactLinkList) {
      this.artifactLinkList = artifactLinkList;
      return this;
   }

   @Override
   public String toString() {
      return "AssembleLinkDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", artifactLinkList="
         + this.getArtifactLinkList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleLinkDTO)) {
         return false;
      }

      AssembleLinkDTO other = (AssembleLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$artifactLinkList = this.getArtifactLinkList();
                  Object other$artifactLinkList = other.getArtifactLinkList();
                  return this$artifactLinkList == null ? other$artifactLinkList == null : this$artifactLinkList.equals(other$artifactLinkList);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $artifactLinkList = this.getArtifactLinkList();
      return result * 59 + ($artifactLinkList == null ? 43 : $artifactLinkList.hashCode());
   }

   public static class AssembleLinkDTOBuilder {
      private Long id;
      private String serialNumber;
      private String specification;
      private Integer quantity;
      private List<ArtifactLinkDTO> artifactLinkList;

      AssembleLinkDTOBuilder() {
      }

      @JsonProperty("id")
      public AssembleLinkDTO.AssembleLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public AssembleLinkDTO.AssembleLinkDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public AssembleLinkDTO.AssembleLinkDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public AssembleLinkDTO.AssembleLinkDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("artifactLinkList")
      public AssembleLinkDTO.AssembleLinkDTOBuilder artifactLinkList(final List<ArtifactLinkDTO> artifactLinkList) {
         this.artifactLinkList = artifactLinkList;
         return this;
      }

      public AssembleLinkDTO build() {
         return new AssembleLinkDTO(this.id, this.serialNumber, this.specification, this.quantity, this.artifactLinkList);
      }

      @Override
      public String toString() {
         return "AssembleLinkDTO.AssembleLinkDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", artifactLinkList="
            + this.artifactLinkList
            + ")";
      }
   }
}
