package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import io.swagger.annotations.ApiModelProperty;

public class MesBuildingProjectProcessDTO {
   @ApiModelProperty(name = "id", value = "工序Id", notes = "工序Id")
   private Long id;
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   private String processName;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;

   public static MesBuildingProjectProcessDTO.MesBuildingProjectProcessDTOBuilder builder() {
      return new MesBuildingProjectProcessDTO.MesBuildingProjectProcessDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProjectProcessDTO)) {
         return false;
      }

      MesBuildingProjectProcessDTO other = (MesBuildingProjectProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$processName = this.getProcessName();
            Object other$processName = other.getProcessName();
            return this$processName == null ? other$processName == null : this$processName.equals(other$processName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProjectProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingProjectProcessDTO(id=" + this.getId() + ", processName=" + this.getProcessName() + ", productType=" + this.getProductType() + ")";
   }

   public MesBuildingProjectProcessDTO() {
   }

   public MesBuildingProjectProcessDTO(final Long id, final String processName, final Integer productType) {
      this.id = id;
      this.processName = processName;
      this.productType = productType;
   }

   public static class MesBuildingProjectProcessDTOBuilder {
      private Long id;
      private String processName;
      private Integer productType;

      MesBuildingProjectProcessDTOBuilder() {
      }

      public MesBuildingProjectProcessDTO.MesBuildingProjectProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingProjectProcessDTO.MesBuildingProjectProcessDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public MesBuildingProjectProcessDTO.MesBuildingProjectProcessDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesBuildingProjectProcessDTO build() {
         return new MesBuildingProjectProcessDTO(this.id, this.processName, this.productType);
      }

      @Override
      public String toString() {
         return "MesBuildingProjectProcessDTO.MesBuildingProjectProcessDTOBuilder(id="
            + this.id
            + ", processName="
            + this.processName
            + ", productType="
            + this.productType
            + ")";
      }
   }
}
