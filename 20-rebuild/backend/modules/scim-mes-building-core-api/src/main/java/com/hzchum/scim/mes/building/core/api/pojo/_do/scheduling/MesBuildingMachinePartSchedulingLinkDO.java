package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingMachinePartSchedulingLinkDO", description = "零件信息")
public class MesBuildingMachinePartSchedulingLinkDO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "name", value = "零件名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", value = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
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
   @ApiModelProperty(name = "picturePath", notes = "图片路径")
   @JsonProperty("picturePath")
   @JSONField(name = "picturePath")
   private String picturePath;
   @ApiModelProperty(name = "thick", value = "厚度")
   private BigDecimal thick;
   @ApiModelProperty(name = "schThickness", value = "套料厚度")
   private BigDecimal schThick;
   @ApiModelProperty(name = "schMaterial", value = "套料材质")
   private String schMaterial;

   public static MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder builder() {
      return new MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder();
   }

   public MesBuildingMachinePartSchedulingLinkDO(
      final Long id,
      final Long productId,
      final String name,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final String picturePath,
      final BigDecimal thick,
      final BigDecimal schThick,
      final String schMaterial
   ) {
      this.id = id;
      this.productId = productId;
      this.name = name;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.picturePath = picturePath;
      this.thick = thick;
      this.schThick = schThick;
      this.schMaterial = schMaterial;
   }

   public MesBuildingMachinePartSchedulingLinkDO() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getName() {
      return this.name;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
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

   public String getPicturePath() {
      return this.picturePath;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public BigDecimal getSchThick() {
      return this.schThick;
   }

   public String getSchMaterial() {
      return this.schMaterial;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartSchedulingLinkDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingMachinePartSchedulingLinkDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingMachinePartSchedulingLinkDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingMachinePartSchedulingLinkDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public MesBuildingMachinePartSchedulingLinkDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public MesBuildingMachinePartSchedulingLinkDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingMachinePartSchedulingLinkDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingMachinePartSchedulingLinkDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingMachinePartSchedulingLinkDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingMachinePartSchedulingLinkDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartSchedulingLinkDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingMachinePartSchedulingLinkDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingMachinePartSchedulingLinkDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesBuildingMachinePartSchedulingLinkDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesBuildingMachinePartSchedulingLinkDO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("picturePath")
   public MesBuildingMachinePartSchedulingLinkDO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   public MesBuildingMachinePartSchedulingLinkDO setThick(final BigDecimal thick) {
      this.thick = thick;
      return this;
   }

   public MesBuildingMachinePartSchedulingLinkDO setSchThick(final BigDecimal schThick) {
      this.schThick = schThick;
      return this;
   }

   public MesBuildingMachinePartSchedulingLinkDO setSchMaterial(final String schMaterial) {
      this.schMaterial = schMaterial;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSchedulingLinkDO(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", name="
         + this.getName()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
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
         + ", picturePath="
         + this.getPicturePath()
         + ", thick="
         + this.getThick()
         + ", schThick="
         + this.getSchThick()
         + ", schMaterial="
         + this.getSchMaterial()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSchedulingLinkDO)) {
         return false;
      }

      MesBuildingMachinePartSchedulingLinkDO other = (MesBuildingMachinePartSchedulingLinkDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$monomer = this.getMonomer();
                     Object other$monomer = other.getMonomer();
                     if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                        Object this$area = this.getArea();
                        Object other$area = other.getArea();
                        if (this$area == null ? other$area == null : this$area.equals(other$area)) {
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
                                                   Object this$picturePath = this.getPicturePath();
                                                   Object other$picturePath = other.getPicturePath();
                                                   if (this$picturePath == null ? other$picturePath == null : this$picturePath.equals(other$picturePath)) {
                                                      Object this$thick = this.getThick();
                                                      Object other$thick = other.getThick();
                                                      if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                         Object this$schThick = this.getSchThick();
                                                         Object other$schThick = other.getSchThick();
                                                         if (this$schThick == null ? other$schThick == null : this$schThick.equals(other$schThick)) {
                                                            Object this$schMaterial = this.getSchMaterial();
                                                            Object other$schMaterial = other.getSchMaterial();
                                                            return this$schMaterial == null
                                                               ? other$schMaterial == null
                                                               : this$schMaterial.equals(other$schMaterial);
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
      return other instanceof MesBuildingMachinePartSchedulingLinkDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
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
      Object $picturePath = this.getPicturePath();
      result = result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $schThick = this.getSchThick();
      result = result * 59 + ($schThick == null ? 43 : $schThick.hashCode());
      Object $schMaterial = this.getSchMaterial();
      return result * 59 + ($schMaterial == null ? 43 : $schMaterial.hashCode());
   }

   public static class MesBuildingMachinePartSchedulingLinkDOBuilder {
      private Long id;
      private Long productId;
      private String name;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private String picturePath;
      private BigDecimal thick;
      private BigDecimal schThick;
      private String schMaterial;

      MesBuildingMachinePartSchedulingLinkDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("picturePath")
      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder schThick(final BigDecimal schThick) {
         this.schThick = schThick;
         return this;
      }

      public MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder schMaterial(final String schMaterial) {
         this.schMaterial = schMaterial;
         return this;
      }

      public MesBuildingMachinePartSchedulingLinkDO build() {
         return new MesBuildingMachinePartSchedulingLinkDO(
            this.id,
            this.productId,
            this.name,
            this.project,
            this.monomer,
            this.area,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.picturePath,
            this.thick,
            this.schThick,
            this.schMaterial
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSchedulingLinkDO.MesBuildingMachinePartSchedulingLinkDOBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", name="
            + this.name
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
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
            + ", picturePath="
            + this.picturePath
            + ", thick="
            + this.thick
            + ", schThick="
            + this.schThick
            + ", schMaterial="
            + this.schMaterial
            + ")";
      }
   }
}
