package com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics;

import io.swagger.annotations.ApiModelProperty;

public class ProjectLossProcessProductionKanBanDTO {
   @ApiModelProperty(name = "id", notes = "工序id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工序名称")
   private String name;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;

   public static ProjectLossProcessProductionKanBanDTO.ProjectLossProcessProductionKanBanDTOBuilder builder() {
      return new ProjectLossProcessProductionKanBanDTO.ProjectLossProcessProductionKanBanDTOBuilder();
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

   public Integer getSort() {
      return this.sort;
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

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLossProcessProductionKanBanDTO)) {
         return false;
      }

      ProjectLossProcessProductionKanBanDTO other = (ProjectLossProcessProductionKanBanDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
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
      return other instanceof ProjectLossProcessProductionKanBanDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLossProcessProductionKanBanDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productType="
         + this.getProductType()
         + ", sort="
         + this.getSort()
         + ")";
   }

   public ProjectLossProcessProductionKanBanDTO(final Long id, final String name, final Integer productType, final Integer sort) {
      this.id = id;
      this.name = name;
      this.productType = productType;
      this.sort = sort;
   }

   public ProjectLossProcessProductionKanBanDTO() {
   }

   public static class ProjectLossProcessProductionKanBanDTOBuilder {
      private Long id;
      private String name;
      private Integer productType;
      private Integer sort;

      ProjectLossProcessProductionKanBanDTOBuilder() {
      }

      public ProjectLossProcessProductionKanBanDTO.ProjectLossProcessProductionKanBanDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectLossProcessProductionKanBanDTO.ProjectLossProcessProductionKanBanDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectLossProcessProductionKanBanDTO.ProjectLossProcessProductionKanBanDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectLossProcessProductionKanBanDTO.ProjectLossProcessProductionKanBanDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public ProjectLossProcessProductionKanBanDTO build() {
         return new ProjectLossProcessProductionKanBanDTO(this.id, this.name, this.productType, this.sort);
      }

      @Override
      public String toString() {
         return "ProjectLossProcessProductionKanBanDTO.ProjectLossProcessProductionKanBanDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", productType="
            + this.productType
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
