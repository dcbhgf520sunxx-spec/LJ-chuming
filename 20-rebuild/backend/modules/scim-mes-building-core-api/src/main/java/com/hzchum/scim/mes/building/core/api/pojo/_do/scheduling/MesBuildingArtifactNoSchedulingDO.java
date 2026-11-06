package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingArtifactSchedulingDO", description = "构件未排产信息")
public class MesBuildingArtifactNoSchedulingDO {
   @ApiModelProperty(name = "productId", value = "构件id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "area", value = "区域信息")
   @JsonProperty("area")
   @JSONField(name = "area")
   private NameInfo area;
   @ApiModelProperty(name = "monomer", value = "单体信息")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private NameInfo monomer;
   @ApiModelProperty(name = "project", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private NameInfo project;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "artifactType", value = "构件类型 1普通构件 2次构件")
   @JsonProperty("artifactType")
   @JSONField(name = "artifactType")
   private Integer artifactType;
   @ApiModelProperty(name = "structureClassId", value = "构件种类表id")
   @JsonProperty("structureClassId")
   @JSONField(name = "structureClassId")
   private Long structureClassId;
   @ApiModelProperty("构件产品序列号集合")
   private List<Integer> numbers;
   @ApiModelProperty("构件产品序列号和图号")
   private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;

   public static MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder builder() {
      return new MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder();
   }

   public MesBuildingArtifactNoSchedulingDO(
      final Long productId,
      final String name,
      final NameInfo area,
      final NameInfo monomer,
      final NameInfo project,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final Integer artifactType,
      final Long structureClassId,
      final List<Integer> numbers,
      final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber
   ) {
      this.productId = productId;
      this.name = name;
      this.area = area;
      this.monomer = monomer;
      this.project = project;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.artifactType = artifactType;
      this.structureClassId = structureClassId;
      this.numbers = numbers;
      this.drawingAndSerialNumber = drawingAndSerialNumber;
   }

   public MesBuildingArtifactNoSchedulingDO() {
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getName() {
      return this.name;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getProject() {
      return this.project;
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

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<DrawingAndSerialNumberDTO> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   @JsonProperty("productId")
   public MesBuildingArtifactNoSchedulingDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingArtifactNoSchedulingDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("area")
   public MesBuildingArtifactNoSchedulingDO setArea(final NameInfo area) {
      this.area = area;
      return this;
   }

   @JsonProperty("monomer")
   public MesBuildingArtifactNoSchedulingDO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingArtifactNoSchedulingDO setProject(final NameInfo project) {
      this.project = project;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingArtifactNoSchedulingDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingArtifactNoSchedulingDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingArtifactNoSchedulingDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingArtifactNoSchedulingDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingArtifactNoSchedulingDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingArtifactNoSchedulingDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingArtifactNoSchedulingDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesBuildingArtifactNoSchedulingDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesBuildingArtifactNoSchedulingDO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("artifactType")
   public MesBuildingArtifactNoSchedulingDO setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   @JsonProperty("structureClassId")
   public MesBuildingArtifactNoSchedulingDO setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   public MesBuildingArtifactNoSchedulingDO setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
      return this;
   }

   public MesBuildingArtifactNoSchedulingDO setDrawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactNoSchedulingDO(productId="
         + this.getProductId()
         + ", name="
         + this.getName()
         + ", area="
         + this.getArea()
         + ", monomer="
         + this.getMonomer()
         + ", project="
         + this.getProject()
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
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", artifactType="
         + this.getArtifactType()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", numbers="
         + this.getNumbers()
         + ", drawingAndSerialNumber="
         + this.getDrawingAndSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactNoSchedulingDO)) {
         return false;
      }

      MesBuildingArtifactNoSchedulingDO other = (MesBuildingArtifactNoSchedulingDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$artifactType = this.getArtifactType();
            Object other$artifactType = other.getArtifactType();
            if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
               Object this$structureClassId = this.getStructureClassId();
               Object other$structureClassId = other.getStructureClassId();
               if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$area = this.getArea();
                     Object other$area = other.getArea();
                     if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
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
                                             if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                Object this$grossWeight = this.getGrossWeight();
                                                Object other$grossWeight = other.getGrossWeight();
                                                if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                   Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                   Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                   if (this$totalGrossWeight == null
                                                      ? other$totalGrossWeight == null
                                                      : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                      Object this$numbers = this.getNumbers();
                                                      Object other$numbers = other.getNumbers();
                                                      if (this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers)) {
                                                         Object this$drawingAndSerialNumber = this.getDrawingAndSerialNumber();
                                                         Object other$drawingAndSerialNumber = other.getDrawingAndSerialNumber();
                                                         return this$drawingAndSerialNumber == null
                                                            ? other$drawingAndSerialNumber == null
                                                            : this$drawingAndSerialNumber.equals(other$drawingAndSerialNumber);
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
      return other instanceof MesBuildingArtifactNoSchedulingDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
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
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      return result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
   }

   public static class MesBuildingArtifactNoSchedulingDOBuilder {
      private Long productId;
      private String name;
      private NameInfo area;
      private NameInfo monomer;
      private NameInfo project;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private Integer artifactType;
      private Long structureClassId;
      private List<Integer> numbers;
      private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;

      MesBuildingArtifactNoSchedulingDOBuilder() {
      }

      @JsonProperty("productId")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("area")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      @JsonProperty("monomer")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder project(final NameInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("artifactType")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      @JsonProperty("structureClassId")
      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder numbers(final List<Integer> numbers) {
         this.numbers = numbers;
         return this;
      }

      public MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder drawingAndSerialNumber(
         final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber
      ) {
         this.drawingAndSerialNumber = drawingAndSerialNumber;
         return this;
      }

      public MesBuildingArtifactNoSchedulingDO build() {
         return new MesBuildingArtifactNoSchedulingDO(
            this.productId,
            this.name,
            this.area,
            this.monomer,
            this.project,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.artifactType,
            this.structureClassId,
            this.numbers,
            this.drawingAndSerialNumber
         );
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactNoSchedulingDO.MesBuildingArtifactNoSchedulingDOBuilder(productId="
            + this.productId
            + ", name="
            + this.name
            + ", area="
            + this.area
            + ", monomer="
            + this.monomer
            + ", project="
            + this.project
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
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", artifactType="
            + this.artifactType
            + ", structureClassId="
            + this.structureClassId
            + ", numbers="
            + this.numbers
            + ", drawingAndSerialNumber="
            + this.drawingAndSerialNumber
            + ")";
      }
   }
}
