package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingReportNumberStatusDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class ProjectReturnRepairArtifactDTO {
   @ApiModelProperty("产品id")
   private Long productId;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("入库汇总表id")
   private Long warehouseId;
   @ApiModelProperty(notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域")
   private NameInfo area;
   @ApiModelProperty(notes = "车间")
   private NameInfo workshop;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("长度（mm）")
   private BigDecimal length;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty("返修数量")
   private Integer returnQuantity;
   @ApiModelProperty("发运数量")
   private Integer shipQuantity;
   @ApiModelProperty("打印数量")
   private Integer printQuantity;
   @ApiModelProperty("是否打印")
   private Boolean boolPrinted;
   @ApiModelProperty("是否一物一码")
   private Boolean boolOneCode;
   @ApiModelProperty("一物一码序号及关联信息")
   private List<MesBuildingReportNumberStatusDTO> numberStatusDTOS;

   public static ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder builder() {
      return new ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder();
   }

   public ProjectReturnRepairArtifactDTO() {
   }

   public ProjectReturnRepairArtifactDTO(
      final Long productId,
      final Integer productType,
      final Long warehouseId,
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final NameInfo workshop,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final BigDecimal netWeight,
      final Integer returnQuantity,
      final Integer shipQuantity,
      final Integer printQuantity,
      final Boolean boolPrinted,
      final Boolean boolOneCode,
      final List<MesBuildingReportNumberStatusDTO> numberStatusDTOS
   ) {
      this.productId = productId;
      this.productType = productType;
      this.warehouseId = warehouseId;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.workshop = workshop;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.netWeight = netWeight;
      this.returnQuantity = returnQuantity;
      this.shipQuantity = shipQuantity;
      this.printQuantity = printQuantity;
      this.boolPrinted = boolPrinted;
      this.boolOneCode = boolOneCode;
      this.numberStatusDTOS = numberStatusDTOS;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public NameInfo getWorkshop() {
      return this.workshop;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Integer getReturnQuantity() {
      return this.returnQuantity;
   }

   public Integer getShipQuantity() {
      return this.shipQuantity;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public List<MesBuildingReportNumberStatusDTO> getNumberStatusDTOS() {
      return this.numberStatusDTOS;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
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

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setReturnQuantity(final Integer returnQuantity) {
      this.returnQuantity = returnQuantity;
   }

   public void setShipQuantity(final Integer shipQuantity) {
      this.shipQuantity = shipQuantity;
   }

   public void setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
   }

   public void setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
   }

   public void setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
   }

   public void setNumberStatusDTOS(final List<MesBuildingReportNumberStatusDTO> numberStatusDTOS) {
      this.numberStatusDTOS = numberStatusDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReturnRepairArtifactDTO)) {
         return false;
      }

      ProjectReturnRepairArtifactDTO other = (ProjectReturnRepairArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$warehouseId = this.getWarehouseId();
            Object other$warehouseId = other.getWarehouseId();
            if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
               Object this$returnQuantity = this.getReturnQuantity();
               Object other$returnQuantity = other.getReturnQuantity();
               if (this$returnQuantity == null ? other$returnQuantity == null : this$returnQuantity.equals(other$returnQuantity)) {
                  Object this$shipQuantity = this.getShipQuantity();
                  Object other$shipQuantity = other.getShipQuantity();
                  if (this$shipQuantity == null ? other$shipQuantity == null : this$shipQuantity.equals(other$shipQuantity)) {
                     Object this$printQuantity = this.getPrintQuantity();
                     Object other$printQuantity = other.getPrintQuantity();
                     if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                        Object this$boolPrinted = this.getBoolPrinted();
                        Object other$boolPrinted = other.getBoolPrinted();
                        if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                           Object this$boolOneCode = this.getBoolOneCode();
                           Object other$boolOneCode = other.getBoolOneCode();
                           if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                 Object this$monomer = this.getMonomer();
                                 Object other$monomer = other.getMonomer();
                                 if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                    Object this$area = this.getArea();
                                    Object other$area = other.getArea();
                                    if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                       Object this$workshop = this.getWorkshop();
                                       Object other$workshop = other.getWorkshop();
                                       if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                          Object this$name = this.getName();
                                          Object other$name = other.getName();
                                          if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$length = this.getLength();
                                                   Object other$length = other.getLength();
                                                   if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$netWeight = this.getNetWeight();
                                                         Object other$netWeight = other.getNetWeight();
                                                         if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                            Object this$numberStatusDTOS = this.getNumberStatusDTOS();
                                                            Object other$numberStatusDTOS = other.getNumberStatusDTOS();
                                                            return this$numberStatusDTOS == null
                                                               ? other$numberStatusDTOS == null
                                                               : this$numberStatusDTOS.equals(other$numberStatusDTOS);
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
      return other instanceof ProjectReturnRepairArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $returnQuantity = this.getReturnQuantity();
      result = result * 59 + ($returnQuantity == null ? 43 : $returnQuantity.hashCode());
      Object $shipQuantity = this.getShipQuantity();
      result = result * 59 + ($shipQuantity == null ? 43 : $shipQuantity.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $numberStatusDTOS = this.getNumberStatusDTOS();
      return result * 59 + ($numberStatusDTOS == null ? 43 : $numberStatusDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReturnRepairArtifactDTO(productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", workshop="
         + this.getWorkshop()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", returnQuantity="
         + this.getReturnQuantity()
         + ", shipQuantity="
         + this.getShipQuantity()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", numberStatusDTOS="
         + this.getNumberStatusDTOS()
         + ")";
   }

   public static class ProjectReturnRepairArtifactDTOBuilder {
      private Long productId;
      private Integer productType;
      private Long warehouseId;
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private NameInfo workshop;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private BigDecimal netWeight;
      private Integer returnQuantity;
      private Integer shipQuantity;
      private Integer printQuantity;
      private Boolean boolPrinted;
      private Boolean boolOneCode;
      private List<MesBuildingReportNumberStatusDTO> numberStatusDTOS;

      ProjectReturnRepairArtifactDTOBuilder() {
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder workshop(final NameInfo workshop) {
         this.workshop = workshop;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder returnQuantity(final Integer returnQuantity) {
         this.returnQuantity = returnQuantity;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder shipQuantity(final Integer shipQuantity) {
         this.shipQuantity = shipQuantity;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder boolOneCode(final Boolean boolOneCode) {
         this.boolOneCode = boolOneCode;
         return this;
      }

      public ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder numberStatusDTOS(
         final List<MesBuildingReportNumberStatusDTO> numberStatusDTOS
      ) {
         this.numberStatusDTOS = numberStatusDTOS;
         return this;
      }

      public ProjectReturnRepairArtifactDTO build() {
         return new ProjectReturnRepairArtifactDTO(
            this.productId,
            this.productType,
            this.warehouseId,
            this.project,
            this.monomer,
            this.area,
            this.workshop,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.netWeight,
            this.returnQuantity,
            this.shipQuantity,
            this.printQuantity,
            this.boolPrinted,
            this.boolOneCode,
            this.numberStatusDTOS
         );
      }

      @Override
      public String toString() {
         return "ProjectReturnRepairArtifactDTO.ProjectReturnRepairArtifactDTOBuilder(productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", warehouseId="
            + this.warehouseId
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", workshop="
            + this.workshop
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", netWeight="
            + this.netWeight
            + ", returnQuantity="
            + this.returnQuantity
            + ", shipQuantity="
            + this.shipQuantity
            + ", printQuantity="
            + this.printQuantity
            + ", boolPrinted="
            + this.boolPrinted
            + ", boolOneCode="
            + this.boolOneCode
            + ", numberStatusDTOS="
            + this.numberStatusDTOS
            + ")";
      }
   }
}
