package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("仓库产品")
public class WarehouseProductDTO {
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(notes = "生产车间")
   private NameInfo workshop;
   @ApiModelProperty(notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域")
   private NameInfo area;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("产品id")
   private Long productId;
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
   @ApiModelProperty("数量")
   private Integer quantity;
   @ApiModelProperty("清单数量")
   private Integer listQuantity;
   @ApiModelProperty("单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty("总净重（kg）")
   private BigDecimal totalNetWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("仓库id")
   private Long warehouseId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("仓库")
   private NameInfo warehouse;
   @ApiModelProperty("码号列表")
   private List<Integer> numberList;
   @ApiModelProperty(name = "warehouseNumberModeEnum", value = "入库码号选择方式 1自动选择 2手动选择")
   private Integer warehouseNumberModeEnum;

   public static WarehouseProductDTO.WarehouseProductDTOBuilder builder() {
      return new WarehouseProductDTO.WarehouseProductDTOBuilder();
   }

   public WarehouseProductDTO() {
   }

   public WarehouseProductDTO(
      final NameInfo workshop,
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final Integer productType,
      final Long productId,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final Integer listQuantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final Long warehouseId,
      final NameInfo warehouse,
      final List<Integer> numberList,
      final Integer warehouseNumberModeEnum
   ) {
      this.workshop = workshop;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.productType = productType;
      this.productId = productId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.listQuantity = listQuantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.warehouseId = warehouseId;
      this.warehouse = warehouse;
      this.numberList = numberList;
      this.warehouseNumberModeEnum = warehouseNumberModeEnum;
   }

   public NameInfo getWorkshop() {
      return this.workshop;
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

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getListQuantity() {
      return this.listQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public NameInfo getWarehouse() {
      return this.warehouse;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public Integer getWarehouseNumberModeEnum() {
      return this.warehouseNumberModeEnum;
   }

   public void setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
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

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
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

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setListQuantity(final Integer listQuantity) {
      this.listQuantity = listQuantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setWarehouse(final NameInfo warehouse) {
      this.warehouse = warehouse;
   }

   public void setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
   }

   public void setWarehouseNumberModeEnum(final Integer warehouseNumberModeEnum) {
      this.warehouseNumberModeEnum = warehouseNumberModeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseProductDTO)) {
         return false;
      }

      WarehouseProductDTO other = (WarehouseProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$listQuantity = this.getListQuantity();
               Object other$listQuantity = other.getListQuantity();
               if (this$listQuantity == null ? other$listQuantity == null : this$listQuantity.equals(other$listQuantity)) {
                  Object this$warehouseId = this.getWarehouseId();
                  Object other$warehouseId = other.getWarehouseId();
                  if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                     Object this$warehouseNumberModeEnum = this.getWarehouseNumberModeEnum();
                     Object other$warehouseNumberModeEnum = other.getWarehouseNumberModeEnum();
                     if (this$warehouseNumberModeEnum == null
                        ? other$warehouseNumberModeEnum == null
                        : this$warehouseNumberModeEnum.equals(other$warehouseNumberModeEnum)) {
                        Object this$workshop = this.getWorkshop();
                        Object other$workshop = other.getWorkshop();
                        if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$monomer = this.getMonomer();
                              Object other$monomer = other.getMonomer();
                              if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                 Object this$area = this.getArea();
                                 Object other$area = other.getArea();
                                 if (this$area == null ? other$area == null : this$area.equals(other$area)) {
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
                                                      Object this$totalNetWeight = this.getTotalNetWeight();
                                                      Object other$totalNetWeight = other.getTotalNetWeight();
                                                      if (this$totalNetWeight == null
                                                         ? other$totalNetWeight == null
                                                         : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                         Object this$warehouse = this.getWarehouse();
                                                         Object other$warehouse = other.getWarehouse();
                                                         if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)) {
                                                            Object this$numberList = this.getNumberList();
                                                            Object other$numberList = other.getNumberList();
                                                            return this$numberList == null
                                                               ? other$numberList == null
                                                               : this$numberList.equals(other$numberList);
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
      return other instanceof WarehouseProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $listQuantity = this.getListQuantity();
      result = result * 59 + ($listQuantity == null ? 43 : $listQuantity.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $warehouseNumberModeEnum = this.getWarehouseNumberModeEnum();
      result = result * 59 + ($warehouseNumberModeEnum == null ? 43 : $warehouseNumberModeEnum.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
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
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseProductDTO(workshop="
         + this.getWorkshop()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
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
         + ", quantity="
         + this.getQuantity()
         + ", listQuantity="
         + this.getListQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", warehouse="
         + this.getWarehouse()
         + ", numberList="
         + this.getNumberList()
         + ", warehouseNumberModeEnum="
         + this.getWarehouseNumberModeEnum()
         + ")";
   }

   public static class WarehouseProductDTOBuilder {
      private NameInfo workshop;
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private Integer productType;
      private Long productId;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private Integer listQuantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private Long warehouseId;
      private NameInfo warehouse;
      private List<Integer> numberList;
      private Integer warehouseNumberModeEnum;

      WarehouseProductDTOBuilder() {
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder workshop(final NameInfo workshop) {
         this.workshop = workshop;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder listQuantity(final Integer listQuantity) {
         this.listQuantity = listQuantity;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder warehouse(final NameInfo warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      public WarehouseProductDTO.WarehouseProductDTOBuilder warehouseNumberModeEnum(final Integer warehouseNumberModeEnum) {
         this.warehouseNumberModeEnum = warehouseNumberModeEnum;
         return this;
      }

      public WarehouseProductDTO build() {
         return new WarehouseProductDTO(
            this.workshop,
            this.project,
            this.monomer,
            this.area,
            this.productType,
            this.productId,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.listQuantity,
            this.netWeight,
            this.totalNetWeight,
            this.warehouseId,
            this.warehouse,
            this.numberList,
            this.warehouseNumberModeEnum
         );
      }

      @Override
      public String toString() {
         return "WarehouseProductDTO.WarehouseProductDTOBuilder(workshop="
            + this.workshop
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
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
            + ", quantity="
            + this.quantity
            + ", listQuantity="
            + this.listQuantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", warehouseId="
            + this.warehouseId
            + ", warehouse="
            + this.warehouse
            + ", numberList="
            + this.numberList
            + ", warehouseNumberModeEnum="
            + this.warehouseNumberModeEnum
            + ")";
      }
   }
}
