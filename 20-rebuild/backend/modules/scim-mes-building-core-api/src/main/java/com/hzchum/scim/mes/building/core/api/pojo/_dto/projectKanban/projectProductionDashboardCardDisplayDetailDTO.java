package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class projectProductionDashboardCardDisplayDetailDTO {
   @ApiModelProperty(name = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "artifactId", notes = "构件Id")
   private Long artifactId;
   @ApiModelProperty(name = "name", notes = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "清单数量")
   private Integer quantity;
   @ApiModelProperty(name = "taskQuantity", value = "任务数量")
   private Integer taskQuantity;
   @ApiModelProperty(name = "companyQuantity", value = "完成数")
   private Integer companyQuantity;
   @ApiModelProperty(name = "companyQuantity", value = "是否完成")
   private Boolean boolCompany;
   @ApiModelProperty(name = "assembleList", value = "部件列表")
   private List<projectProductionDashboardCardDisplayDetailDTO> assembleList;
   @ApiModelProperty(name = "machinePartList", value = "零件列表")
   private List<projectProductionDashboardCardDisplayDetailDTO> machinePartList;

   public static projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder builder() {
      return new projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompanyQuantity() {
      return this.companyQuantity;
   }

   public Boolean getBoolCompany() {
      return this.boolCompany;
   }

   public List<projectProductionDashboardCardDisplayDetailDTO> getAssembleList() {
      return this.assembleList;
   }

   public List<projectProductionDashboardCardDisplayDetailDTO> getMachinePartList() {
      return this.machinePartList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setCompanyQuantity(final Integer companyQuantity) {
      this.companyQuantity = companyQuantity;
   }

   public void setBoolCompany(final Boolean boolCompany) {
      this.boolCompany = boolCompany;
   }

   public void setAssembleList(final List<projectProductionDashboardCardDisplayDetailDTO> assembleList) {
      this.assembleList = assembleList;
   }

   public void setMachinePartList(final List<projectProductionDashboardCardDisplayDetailDTO> machinePartList) {
      this.machinePartList = machinePartList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof projectProductionDashboardCardDisplayDetailDTO)) {
         return false;
      }

      projectProductionDashboardCardDisplayDetailDTO other = (projectProductionDashboardCardDisplayDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$artifactId = this.getArtifactId();
            Object other$artifactId = other.getArtifactId();
            if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$taskQuantity = this.getTaskQuantity();
                  Object other$taskQuantity = other.getTaskQuantity();
                  if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                     Object this$companyQuantity = this.getCompanyQuantity();
                     Object other$companyQuantity = other.getCompanyQuantity();
                     if (this$companyQuantity == null ? other$companyQuantity == null : this$companyQuantity.equals(other$companyQuantity)) {
                        Object this$boolCompany = this.getBoolCompany();
                        Object other$boolCompany = other.getBoolCompany();
                        if (this$boolCompany == null ? other$boolCompany == null : this$boolCompany.equals(other$boolCompany)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$material = this.getMaterial();
                                    Object other$material = other.getMaterial();
                                    if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                       Object this$assembleList = this.getAssembleList();
                                       Object other$assembleList = other.getAssembleList();
                                       if (this$assembleList == null ? other$assembleList == null : this$assembleList.equals(other$assembleList)) {
                                          Object this$machinePartList = this.getMachinePartList();
                                          Object other$machinePartList = other.getMachinePartList();
                                          return this$machinePartList == null
                                             ? other$machinePartList == null
                                             : this$machinePartList.equals(other$machinePartList);
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
      return other instanceof projectProductionDashboardCardDisplayDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $companyQuantity = this.getCompanyQuantity();
      result = result * 59 + ($companyQuantity == null ? 43 : $companyQuantity.hashCode());
      Object $boolCompany = this.getBoolCompany();
      result = result * 59 + ($boolCompany == null ? 43 : $boolCompany.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $assembleList = this.getAssembleList();
      result = result * 59 + ($assembleList == null ? 43 : $assembleList.hashCode());
      Object $machinePartList = this.getMachinePartList();
      return result * 59 + ($machinePartList == null ? 43 : $machinePartList.hashCode());
   }

   @Override
   public String toString() {
      return "projectProductionDashboardCardDisplayDetailDTO(id="
         + this.getId()
         + ", productType="
         + this.getProductType()
         + ", artifactId="
         + this.getArtifactId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", companyQuantity="
         + this.getCompanyQuantity()
         + ", boolCompany="
         + this.getBoolCompany()
         + ", assembleList="
         + this.getAssembleList()
         + ", machinePartList="
         + this.getMachinePartList()
         + ")";
   }

   public projectProductionDashboardCardDisplayDetailDTO(
      final Long id,
      final Integer productType,
      final Long artifactId,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Integer quantity,
      final Integer taskQuantity,
      final Integer companyQuantity,
      final Boolean boolCompany,
      final List<projectProductionDashboardCardDisplayDetailDTO> assembleList,
      final List<projectProductionDashboardCardDisplayDetailDTO> machinePartList
   ) {
      this.id = id;
      this.productType = productType;
      this.artifactId = artifactId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.quantity = quantity;
      this.taskQuantity = taskQuantity;
      this.companyQuantity = companyQuantity;
      this.boolCompany = boolCompany;
      this.assembleList = assembleList;
      this.machinePartList = machinePartList;
   }

   public projectProductionDashboardCardDisplayDetailDTO() {
   }

   public static class projectProductionDashboardCardDisplayDetailDTOBuilder {
      private Long id;
      private Integer productType;
      private Long artifactId;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Integer quantity;
      private Integer taskQuantity;
      private Integer companyQuantity;
      private Boolean boolCompany;
      private List<projectProductionDashboardCardDisplayDetailDTO> assembleList;
      private List<projectProductionDashboardCardDisplayDetailDTO> machinePartList;

      projectProductionDashboardCardDisplayDetailDTOBuilder() {
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder companyQuantity(final Integer companyQuantity) {
         this.companyQuantity = companyQuantity;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder boolCompany(final Boolean boolCompany) {
         this.boolCompany = boolCompany;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder assembleList(
         final List<projectProductionDashboardCardDisplayDetailDTO> assembleList
      ) {
         this.assembleList = assembleList;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder machinePartList(
         final List<projectProductionDashboardCardDisplayDetailDTO> machinePartList
      ) {
         this.machinePartList = machinePartList;
         return this;
      }

      public projectProductionDashboardCardDisplayDetailDTO build() {
         return new projectProductionDashboardCardDisplayDetailDTO(
            this.id,
            this.productType,
            this.artifactId,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.quantity,
            this.taskQuantity,
            this.companyQuantity,
            this.boolCompany,
            this.assembleList,
            this.machinePartList
         );
      }

      @Override
      public String toString() {
         return "projectProductionDashboardCardDisplayDetailDTO.projectProductionDashboardCardDisplayDetailDTOBuilder(id="
            + this.id
            + ", productType="
            + this.productType
            + ", artifactId="
            + this.artifactId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", companyQuantity="
            + this.companyQuantity
            + ", boolCompany="
            + this.boolCompany
            + ", assembleList="
            + this.assembleList
            + ", machinePartList="
            + this.machinePartList
            + ")";
      }
   }
}
