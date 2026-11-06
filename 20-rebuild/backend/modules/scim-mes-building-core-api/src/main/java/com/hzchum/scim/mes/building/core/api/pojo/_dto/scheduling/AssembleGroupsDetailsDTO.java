package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "AssembleGroupsDetailsDTO", description = "构件信息和分组数量")
public class AssembleGroupsDetailsDTO {
   @ApiModelProperty(name = "groupsId", notes = "分组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "quantity", value = "组立分配数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "artifactList", value = "每个构件所需数量")
   @JsonProperty("artifactList")
   @JSONField(name = "artifactList")
   private List<ArtifactGroupsDetailsDTO> artifactList;

   protected AssembleGroupsDetailsDTO(final AssembleGroupsDetailsDTO.AssembleGroupsDetailsDTOBuilder<?, ?> b) {
      this.groupsId = b.groupsId;
      this.quantity = b.quantity;
      this.artifactList = b.artifactList;
   }

   public static AssembleGroupsDetailsDTO.AssembleGroupsDetailsDTOBuilder<?, ?> builder() {
      return new AssembleGroupsDetailsDTO.AssembleGroupsDetailsDTOBuilderImpl();
   }

   public AssembleGroupsDetailsDTO() {
   }

   public AssembleGroupsDetailsDTO(final Long groupsId, final Integer quantity, final List<ArtifactGroupsDetailsDTO> artifactList) {
      this.groupsId = groupsId;
      this.quantity = quantity;
      this.artifactList = artifactList;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public List<ArtifactGroupsDetailsDTO> getArtifactList() {
      return this.artifactList;
   }

   @JsonProperty("groupsId")
   public AssembleGroupsDetailsDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("quantity")
   public AssembleGroupsDetailsDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("artifactList")
   public AssembleGroupsDetailsDTO setArtifactList(final List<ArtifactGroupsDetailsDTO> artifactList) {
      this.artifactList = artifactList;
      return this;
   }

   @Override
   public String toString() {
      return "AssembleGroupsDetailsDTO(groupsId=" + this.getGroupsId() + ", quantity=" + this.getQuantity() + ", artifactList=" + this.getArtifactList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleGroupsDetailsDTO)) {
         return false;
      }

      AssembleGroupsDetailsDTO other = (AssembleGroupsDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$groupsId = this.getGroupsId();
      Object other$groupsId = other.getGroupsId();
      if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$artifactList = this.getArtifactList();
            Object other$artifactList = other.getArtifactList();
            return this$artifactList == null ? other$artifactList == null : this$artifactList.equals(other$artifactList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleGroupsDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $artifactList = this.getArtifactList();
      return result * 59 + ($artifactList == null ? 43 : $artifactList.hashCode());
   }

   public abstract static class AssembleGroupsDetailsDTOBuilder<C extends AssembleGroupsDetailsDTO, B extends AssembleGroupsDetailsDTO.AssembleGroupsDetailsDTOBuilder<C, B>> {
      private Long groupsId;
      private Integer quantity;
      private List<ArtifactGroupsDetailsDTO> artifactList;

      protected abstract B self();

      public abstract C build();

      @JsonProperty("groupsId")
      public B groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this.self();
      }

      @JsonProperty("quantity")
      public B quantity(final Integer quantity) {
         this.quantity = quantity;
         return this.self();
      }

      @JsonProperty("artifactList")
      public B artifactList(final List<ArtifactGroupsDetailsDTO> artifactList) {
         this.artifactList = artifactList;
         return this.self();
      }

      @Override
      public String toString() {
         return "AssembleGroupsDetailsDTO.AssembleGroupsDetailsDTOBuilder(groupsId="
            + this.groupsId
            + ", quantity="
            + this.quantity
            + ", artifactList="
            + this.artifactList
            + ")";
      }
   }

   private static final class AssembleGroupsDetailsDTOBuilderImpl
      extends AssembleGroupsDetailsDTO.AssembleGroupsDetailsDTOBuilder<AssembleGroupsDetailsDTO, AssembleGroupsDetailsDTO.AssembleGroupsDetailsDTOBuilderImpl> {
      private AssembleGroupsDetailsDTOBuilderImpl() {
      }

      protected AssembleGroupsDetailsDTO.AssembleGroupsDetailsDTOBuilderImpl self() {
         return this;
      }

      @Override
      public AssembleGroupsDetailsDTO build() {
         return new AssembleGroupsDetailsDTO(this);
      }
   }
}
