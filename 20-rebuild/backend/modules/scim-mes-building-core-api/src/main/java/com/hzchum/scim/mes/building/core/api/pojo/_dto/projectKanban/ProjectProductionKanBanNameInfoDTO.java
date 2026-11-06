package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import io.swagger.annotations.ApiModelProperty;

public class ProjectProductionKanBanNameInfoDTO {
   @ApiModelProperty(name = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工序名称")
   private String name;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "processType", notes = "工序类型")
   private Integer processType;

   public static ProjectProductionKanBanNameInfoDTO.ProjectProductionKanBanNameInfoDTOBuilder builder() {
      return new ProjectProductionKanBanNameInfoDTO.ProjectProductionKanBanNameInfoDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProcessType() {
      return this.processType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProcessType(final Integer processType) {
      this.processType = processType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionKanBanNameInfoDTO)) {
         return false;
      }

      ProjectProductionKanBanNameInfoDTO other = (ProjectProductionKanBanNameInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$processType = this.getProcessType();
            Object other$processType = other.getProcessType();
            if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof ProjectProductionKanBanNameInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductionKanBanNameInfoDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productType="
         + this.getProductType()
         + ", processType="
         + this.getProcessType()
         + ")";
   }

   public ProjectProductionKanBanNameInfoDTO(final Long id, final String name, final Integer productType, final Integer processType) {
      this.id = id;
      this.name = name;
      this.productType = productType;
      this.processType = processType;
   }

   public ProjectProductionKanBanNameInfoDTO() {
   }

   public static class ProjectProductionKanBanNameInfoDTOBuilder {
      private Long id;
      private String name;
      private Integer productType;
      private Integer processType;

      ProjectProductionKanBanNameInfoDTOBuilder() {
      }

      public ProjectProductionKanBanNameInfoDTO.ProjectProductionKanBanNameInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectProductionKanBanNameInfoDTO.ProjectProductionKanBanNameInfoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectProductionKanBanNameInfoDTO.ProjectProductionKanBanNameInfoDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectProductionKanBanNameInfoDTO.ProjectProductionKanBanNameInfoDTOBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      public ProjectProductionKanBanNameInfoDTO build() {
         return new ProjectProductionKanBanNameInfoDTO(this.id, this.name, this.productType, this.processType);
      }

      @Override
      public String toString() {
         return "ProjectProductionKanBanNameInfoDTO.ProjectProductionKanBanNameInfoDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", productType="
            + this.productType
            + ", processType="
            + this.processType
            + ")";
      }
   }
}
