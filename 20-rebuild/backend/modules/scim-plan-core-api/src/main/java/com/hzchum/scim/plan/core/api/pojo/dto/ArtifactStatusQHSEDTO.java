package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;

public class ArtifactStatusQHSEDTO {
   private Long productId;
   private Integer number;
   private Long processId;
   private Long taskId;
   private Integer quantity;
   private Boolean boolOneCode;
   private String processName;
   private Boolean boolCargo;
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long artifactId;
   @ApiModelProperty(name = "name", value = "名称")
   private String artifactName;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;

   public static ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder builder() {
      return new ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder();
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Boolean getBoolCargo() {
      return this.boolCargo;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public String getArtifactName() {
      return this.artifactName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setBoolCargo(final Boolean boolCargo) {
      this.boolCargo = boolCargo;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setArtifactName(final String artifactName) {
      this.artifactName = artifactName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactStatusQHSEDTO)) {
         return false;
      }

      ArtifactStatusQHSEDTO other = (ArtifactStatusQHSEDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$taskId = this.getTaskId();
               Object other$taskId = other.getTaskId();
               if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$boolOneCode = this.getBoolOneCode();
                     Object other$boolOneCode = other.getBoolOneCode();
                     if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
                        Object this$boolCargo = this.getBoolCargo();
                        Object other$boolCargo = other.getBoolCargo();
                        if (this$boolCargo == null ? other$boolCargo == null : this$boolCargo.equals(other$boolCargo)) {
                           Object this$artifactId = this.getArtifactId();
                           Object other$artifactId = other.getArtifactId();
                           if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                              Object this$processName = this.getProcessName();
                              Object other$processName = other.getProcessName();
                              if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                 Object this$artifactName = this.getArtifactName();
                                 Object other$artifactName = other.getArtifactName();
                                 if (this$artifactName == null ? other$artifactName == null : this$artifactName.equals(other$artifactName)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                          Object this$project = this.getProject();
                                          Object other$project = other.getProject();
                                          if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                             Object this$area = this.getArea();
                                             Object other$area = other.getArea();
                                             if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                Object this$monomer = this.getMonomer();
                                                Object other$monomer = other.getMonomer();
                                                return this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactStatusQHSEDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $boolCargo = this.getBoolCargo();
      result = result * 59 + ($boolCargo == null ? 43 : $boolCargo.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $artifactName = this.getArtifactName();
      result = result * 59 + ($artifactName == null ? 43 : $artifactName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $monomer = this.getMonomer();
      return result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactStatusQHSEDTO(productId="
         + this.getProductId()
         + ", number="
         + this.getNumber()
         + ", processId="
         + this.getProcessId()
         + ", taskId="
         + this.getTaskId()
         + ", quantity="
         + this.getQuantity()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", processName="
         + this.getProcessName()
         + ", boolCargo="
         + this.getBoolCargo()
         + ", artifactId="
         + this.getArtifactId()
         + ", artifactName="
         + this.getArtifactName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", project="
         + this.getProject()
         + ", area="
         + this.getArea()
         + ", monomer="
         + this.getMonomer()
         + ")";
   }

   public ArtifactStatusQHSEDTO(
      final Long productId,
      final Integer number,
      final Long processId,
      final Long taskId,
      final Integer quantity,
      final Boolean boolOneCode,
      final String processName,
      final Boolean boolCargo,
      final Long artifactId,
      final String artifactName,
      final String serialNumber,
      final String specification,
      final ProjectInfo project,
      final NameInfo area,
      final NameInfo monomer
   ) {
      this.productId = productId;
      this.number = number;
      this.processId = processId;
      this.taskId = taskId;
      this.quantity = quantity;
      this.boolOneCode = boolOneCode;
      this.processName = processName;
      this.boolCargo = boolCargo;
      this.artifactId = artifactId;
      this.artifactName = artifactName;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.project = project;
      this.area = area;
      this.monomer = monomer;
   }

   public ArtifactStatusQHSEDTO() {
   }

   public static class ArtifactStatusQHSEDTOBuilder {
      private Long productId;
      private Integer number;
      private Long processId;
      private Long taskId;
      private Integer quantity;
      private Boolean boolOneCode;
      private String processName;
      private Boolean boolCargo;
      private Long artifactId;
      private String artifactName;
      private String serialNumber;
      private String specification;
      private ProjectInfo project;
      private NameInfo area;
      private NameInfo monomer;

      ArtifactStatusQHSEDTOBuilder() {
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder boolOneCode(final Boolean boolOneCode) {
         this.boolOneCode = boolOneCode;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder boolCargo(final Boolean boolCargo) {
         this.boolCargo = boolCargo;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder artifactName(final String artifactName) {
         this.artifactName = artifactName;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ArtifactStatusQHSEDTO build() {
         return new ArtifactStatusQHSEDTO(
            this.productId,
            this.number,
            this.processId,
            this.taskId,
            this.quantity,
            this.boolOneCode,
            this.processName,
            this.boolCargo,
            this.artifactId,
            this.artifactName,
            this.serialNumber,
            this.specification,
            this.project,
            this.area,
            this.monomer
         );
      }

      @Override
      public String toString() {
         return "ArtifactStatusQHSEDTO.ArtifactStatusQHSEDTOBuilder(productId="
            + this.productId
            + ", number="
            + this.number
            + ", processId="
            + this.processId
            + ", taskId="
            + this.taskId
            + ", quantity="
            + this.quantity
            + ", boolOneCode="
            + this.boolOneCode
            + ", processName="
            + this.processName
            + ", boolCargo="
            + this.boolCargo
            + ", artifactId="
            + this.artifactId
            + ", artifactName="
            + this.artifactName
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", project="
            + this.project
            + ", area="
            + this.area
            + ", monomer="
            + this.monomer
            + ")";
      }
   }
}
