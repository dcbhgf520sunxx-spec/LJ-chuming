package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "项目发运分类信息详情")
public class CargoListArtifactTypeDTO {
   @ApiModelProperty(name = "projectInfo", value = "项目基础信息", notes = "项目基础信息")
   @JsonProperty("projectInfo")
   @JSONField(name = "projectInfo")
   private ProjectInfo projectInfo;
   @ApiModelProperty(name = "monomer", value = "单体基础信息", notes = "单体基础信息")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private PlanMonomer monomer;
   @ApiModelProperty(name = "area", value = "区域基础信息", notes = "区域基础信息")
   @JsonProperty("area")
   @JSONField(name = "area")
   private PlanArea area;
   @ApiModelProperty(name = "workshop", value = "车间基础信息", notes = "车间基础信息")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "length", value = "长度", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "netWeight", value = "单净重", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重", notes = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   @JsonProperty("boolAllPartSendDirectly")
   @JSONField(name = "boolAllPartSendDirectly")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossNetWeight", value = "总毛重", notes = "总毛重")
   @JsonProperty("totalGrossNetWeight")
   @JSONField(name = "totalGrossNetWeight")
   private BigDecimal totalGrossNetWeight;
   @ApiModelProperty(name = "productSourceType", value = "1自制 2内协 4外协", notes = "1自制 2内协 4外协")
   private Integer productSourceType;

   public static CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder builder() {
      return new CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder();
   }

   public CargoListArtifactTypeDTO(
      final ProjectInfo projectInfo,
      final PlanMonomer monomer,
      final PlanArea area,
      final WorkshopDetailDO workshop,
      final Long productId,
      final Integer productType,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal length,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final Integer quantity,
      final Boolean boolAllPartSendDirectly,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossNetWeight,
      final Integer productSourceType
   ) {
      this.projectInfo = projectInfo;
      this.monomer = monomer;
      this.area = area;
      this.workshop = workshop;
      this.productId = productId;
      this.productType = productType;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.quantity = quantity;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossNetWeight = totalGrossNetWeight;
      this.productSourceType = productSourceType;
   }

   public CargoListArtifactTypeDTO() {
   }

   public ProjectInfo getProjectInfo() {
      return this.projectInfo;
   }

   public PlanMonomer getMonomer() {
      return this.monomer;
   }

   public PlanArea getArea() {
      return this.area;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossNetWeight() {
      return this.totalGrossNetWeight;
   }

   public Integer getProductSourceType() {
      return this.productSourceType;
   }

   @JsonProperty("projectInfo")
   public void setProjectInfo(final ProjectInfo projectInfo) {
      this.projectInfo = projectInfo;
   }

   @JsonProperty("monomer")
   public void setMonomer(final PlanMonomer monomer) {
      this.monomer = monomer;
   }

   @JsonProperty("area")
   public void setArea(final PlanArea area) {
      this.area = area;
   }

   @JsonProperty("workshop")
   public void setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
   }

   @JsonProperty("productId")
   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   @JsonProperty("productType")
   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("material")
   public void setMaterial(final String material) {
      this.material = material;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("netWeight")
   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   @JsonProperty("grossWeight")
   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("boolAllPartSendDirectly")
   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   @JsonProperty("totalNetWeight")
   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   @JsonProperty("totalGrossNetWeight")
   public void setTotalGrossNetWeight(final BigDecimal totalGrossNetWeight) {
      this.totalGrossNetWeight = totalGrossNetWeight;
   }

   public void setProductSourceType(final Integer productSourceType) {
      this.productSourceType = productSourceType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListArtifactTypeDTO)) {
         return false;
      }

      CargoListArtifactTypeDTO other = (CargoListArtifactTypeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
               Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
               if (this$boolAllPartSendDirectly == null
                  ? other$boolAllPartSendDirectly == null
                  : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                  Object this$productSourceType = this.getProductSourceType();
                  Object other$productSourceType = other.getProductSourceType();
                  if (this$productSourceType == null ? other$productSourceType == null : this$productSourceType.equals(other$productSourceType)) {
                     Object this$projectInfo = this.getProjectInfo();
                     Object other$projectInfo = other.getProjectInfo();
                     if (this$projectInfo == null ? other$projectInfo == null : this$projectInfo.equals(other$projectInfo)) {
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
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$length = this.getLength();
                                             Object other$length = other.getLength();
                                             if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                Object this$netWeight = this.getNetWeight();
                                                Object other$netWeight = other.getNetWeight();
                                                if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                   Object this$grossWeight = this.getGrossWeight();
                                                   Object other$grossWeight = other.getGrossWeight();
                                                   if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                      Object this$totalNetWeight = this.getTotalNetWeight();
                                                      Object other$totalNetWeight = other.getTotalNetWeight();
                                                      if (this$totalNetWeight == null
                                                         ? other$totalNetWeight == null
                                                         : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                         Object this$totalGrossNetWeight = this.getTotalGrossNetWeight();
                                                         Object other$totalGrossNetWeight = other.getTotalGrossNetWeight();
                                                         return this$totalGrossNetWeight == null
                                                            ? other$totalGrossNetWeight == null
                                                            : this$totalGrossNetWeight.equals(other$totalGrossNetWeight);
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
      return other instanceof CargoListArtifactTypeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $productSourceType = this.getProductSourceType();
      result = result * 59 + ($productSourceType == null ? 43 : $productSourceType.hashCode());
      Object $projectInfo = this.getProjectInfo();
      result = result * 59 + ($projectInfo == null ? 43 : $projectInfo.hashCode());
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
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossNetWeight = this.getTotalGrossNetWeight();
      return result * 59 + ($totalGrossNetWeight == null ? 43 : $totalGrossNetWeight.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListArtifactTypeDTO(projectInfo="
         + this.getProjectInfo()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", workshop="
         + this.getWorkshop()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", quantity="
         + this.getQuantity()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossNetWeight="
         + this.getTotalGrossNetWeight()
         + ", productSourceType="
         + this.getProductSourceType()
         + ")";
   }

   public static class CargoListArtifactTypeDTOBuilder {
      private ProjectInfo projectInfo;
      private PlanMonomer monomer;
      private PlanArea area;
      private WorkshopDetailDO workshop;
      private Long productId;
      private Integer productType;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal length;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Integer quantity;
      private Boolean boolAllPartSendDirectly;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossNetWeight;
      private Integer productSourceType;

      CargoListArtifactTypeDTOBuilder() {
      }

      @JsonProperty("projectInfo")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder projectInfo(final ProjectInfo projectInfo) {
         this.projectInfo = projectInfo;
         return this;
      }

      @JsonProperty("monomer")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder monomer(final PlanMonomer monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder area(final PlanArea area) {
         this.area = area;
         return this;
      }

      @JsonProperty("workshop")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productId")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("name")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("length")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("netWeight")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("quantity")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("boolAllPartSendDirectly")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossNetWeight")
      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder totalGrossNetWeight(final BigDecimal totalGrossNetWeight) {
         this.totalGrossNetWeight = totalGrossNetWeight;
         return this;
      }

      public CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder productSourceType(final Integer productSourceType) {
         this.productSourceType = productSourceType;
         return this;
      }

      public CargoListArtifactTypeDTO build() {
         return new CargoListArtifactTypeDTO(
            this.projectInfo,
            this.monomer,
            this.area,
            this.workshop,
            this.productId,
            this.productType,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.length,
            this.netWeight,
            this.grossWeight,
            this.quantity,
            this.boolAllPartSendDirectly,
            this.totalNetWeight,
            this.totalGrossNetWeight,
            this.productSourceType
         );
      }

      @Override
      public String toString() {
         return "CargoListArtifactTypeDTO.CargoListArtifactTypeDTOBuilder(projectInfo="
            + this.projectInfo
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", workshop="
            + this.workshop
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", quantity="
            + this.quantity
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossNetWeight="
            + this.totalGrossNetWeight
            + ", productSourceType="
            + this.productSourceType
            + ")";
      }
   }
}
