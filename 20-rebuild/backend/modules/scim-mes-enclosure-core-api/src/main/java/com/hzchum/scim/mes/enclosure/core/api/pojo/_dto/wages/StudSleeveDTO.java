package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "StudSleeveDTO", description = "栓钉套筒统计")
public class StudSleeveDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "productionLine", value = "生产线", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "netWeight", notes = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "completeTime", notes = "生产日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private String completeTime;
   @ApiModelProperty(name = "auxiliarySpecification", notes = "配套件规格")
   @JsonProperty("auxiliarySpecification")
   @JSONField(name = "auxiliarySpecification")
   private String auxiliarySpecification;
   @ApiModelProperty(name = "auxiliaryMaterial", notes = "配套件材质")
   @JsonProperty("auxiliaryMaterial")
   @JSONField(name = "auxiliaryMaterial")
   private String auxiliaryMaterial;
   @ApiModelProperty(name = "auxiliaryQuantity", notes = "配套件数量")
   @JsonProperty("auxiliaryQuantity")
   @JSONField(name = "auxiliaryQuantity")
   private Integer auxiliaryQuantity;
   @ApiModelProperty(name = "auxiliaryTypeName", notes = "配套件名称")
   @JsonProperty("auxiliaryTypeName")
   @JSONField(name = "auxiliaryTypeName")
   private String auxiliaryTypeName;
   @ApiModelProperty(name = "price", value = "单价", notes = "单价")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;
   @ApiModelProperty(name = "wages", value = "总价", notes = "总价")
   @JsonProperty("wages")
   @JSONField(name = "wages")
   private BigDecimal wages;

   public static StudSleeveDTO.StudSleeveDTOBuilder builder() {
      return new StudSleeveDTO.StudSleeveDTOBuilder();
   }

   public StudSleeveDTO(
      final Long id,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final ProductionLineDetailDO productionLine,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal netWeight,
      final String completeTime,
      final String auxiliarySpecification,
      final String auxiliaryMaterial,
      final Integer auxiliaryQuantity,
      final String auxiliaryTypeName,
      final BigDecimal price,
      final BigDecimal wages
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.productionLine = productionLine;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.netWeight = netWeight;
      this.completeTime = completeTime;
      this.auxiliarySpecification = auxiliarySpecification;
      this.auxiliaryMaterial = auxiliaryMaterial;
      this.auxiliaryQuantity = auxiliaryQuantity;
      this.auxiliaryTypeName = auxiliaryTypeName;
      this.price = price;
      this.wages = wages;
   }

   public StudSleeveDTO() {
   }

   public Long getId() {
      return this.id;
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

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
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

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public String getCompleteTime() {
      return this.completeTime;
   }

   public String getAuxiliarySpecification() {
      return this.auxiliarySpecification;
   }

   public String getAuxiliaryMaterial() {
      return this.auxiliaryMaterial;
   }

   public Integer getAuxiliaryQuantity() {
      return this.auxiliaryQuantity;
   }

   public String getAuxiliaryTypeName() {
      return this.auxiliaryTypeName;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getWages() {
      return this.wages;
   }

   @JsonProperty("id")
   public StudSleeveDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public StudSleeveDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public StudSleeveDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public StudSleeveDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("productionLine")
   public StudSleeveDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("serialNumber")
   public StudSleeveDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public StudSleeveDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public StudSleeveDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("netWeight")
   public StudSleeveDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("completeTime")
   public StudSleeveDTO setCompleteTime(final String completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("auxiliarySpecification")
   public StudSleeveDTO setAuxiliarySpecification(final String auxiliarySpecification) {
      this.auxiliarySpecification = auxiliarySpecification;
      return this;
   }

   @JsonProperty("auxiliaryMaterial")
   public StudSleeveDTO setAuxiliaryMaterial(final String auxiliaryMaterial) {
      this.auxiliaryMaterial = auxiliaryMaterial;
      return this;
   }

   @JsonProperty("auxiliaryQuantity")
   public StudSleeveDTO setAuxiliaryQuantity(final Integer auxiliaryQuantity) {
      this.auxiliaryQuantity = auxiliaryQuantity;
      return this;
   }

   @JsonProperty("auxiliaryTypeName")
   public StudSleeveDTO setAuxiliaryTypeName(final String auxiliaryTypeName) {
      this.auxiliaryTypeName = auxiliaryTypeName;
      return this;
   }

   @JsonProperty("price")
   public StudSleeveDTO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("wages")
   public StudSleeveDTO setWages(final BigDecimal wages) {
      this.wages = wages;
      return this;
   }

   @Override
   public String toString() {
      return "StudSleeveDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", productionLine="
         + this.getProductionLine()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", completeTime="
         + this.getCompleteTime()
         + ", auxiliarySpecification="
         + this.getAuxiliarySpecification()
         + ", auxiliaryMaterial="
         + this.getAuxiliaryMaterial()
         + ", auxiliaryQuantity="
         + this.getAuxiliaryQuantity()
         + ", auxiliaryTypeName="
         + this.getAuxiliaryTypeName()
         + ", price="
         + this.getPrice()
         + ", wages="
         + this.getWages()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StudSleeveDTO)) {
         return false;
      }

      StudSleeveDTO other = (StudSleeveDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auxiliaryQuantity = this.getAuxiliaryQuantity();
         Object other$auxiliaryQuantity = other.getAuxiliaryQuantity();
         if (this$auxiliaryQuantity == null ? other$auxiliaryQuantity == null : this$auxiliaryQuantity.equals(other$auxiliaryQuantity)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$monomer = this.getMonomer();
               Object other$monomer = other.getMonomer();
               if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                  Object this$area = this.getArea();
                  Object other$area = other.getArea();
                  if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                     Object this$productionLine = this.getProductionLine();
                     Object other$productionLine = other.getProductionLine();
                     if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$netWeight = this.getNetWeight();
                                 Object other$netWeight = other.getNetWeight();
                                 if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                    Object this$completeTime = this.getCompleteTime();
                                    Object other$completeTime = other.getCompleteTime();
                                    if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
                                       Object this$auxiliarySpecification = this.getAuxiliarySpecification();
                                       Object other$auxiliarySpecification = other.getAuxiliarySpecification();
                                       if (this$auxiliarySpecification == null
                                          ? other$auxiliarySpecification == null
                                          : this$auxiliarySpecification.equals(other$auxiliarySpecification)) {
                                          Object this$auxiliaryMaterial = this.getAuxiliaryMaterial();
                                          Object other$auxiliaryMaterial = other.getAuxiliaryMaterial();
                                          if (this$auxiliaryMaterial == null
                                             ? other$auxiliaryMaterial == null
                                             : this$auxiliaryMaterial.equals(other$auxiliaryMaterial)) {
                                             Object this$auxiliaryTypeName = this.getAuxiliaryTypeName();
                                             Object other$auxiliaryTypeName = other.getAuxiliaryTypeName();
                                             if (this$auxiliaryTypeName == null
                                                ? other$auxiliaryTypeName == null
                                                : this$auxiliaryTypeName.equals(other$auxiliaryTypeName)) {
                                                Object this$price = this.getPrice();
                                                Object other$price = other.getPrice();
                                                if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                   Object this$wages = this.getWages();
                                                   Object other$wages = other.getWages();
                                                   return this$wages == null ? other$wages == null : this$wages.equals(other$wages);
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
      return other instanceof StudSleeveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auxiliaryQuantity = this.getAuxiliaryQuantity();
      result = result * 59 + ($auxiliaryQuantity == null ? 43 : $auxiliaryQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $auxiliarySpecification = this.getAuxiliarySpecification();
      result = result * 59 + ($auxiliarySpecification == null ? 43 : $auxiliarySpecification.hashCode());
      Object $auxiliaryMaterial = this.getAuxiliaryMaterial();
      result = result * 59 + ($auxiliaryMaterial == null ? 43 : $auxiliaryMaterial.hashCode());
      Object $auxiliaryTypeName = this.getAuxiliaryTypeName();
      result = result * 59 + ($auxiliaryTypeName == null ? 43 : $auxiliaryTypeName.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $wages = this.getWages();
      return result * 59 + ($wages == null ? 43 : $wages.hashCode());
   }

   public static class StudSleeveDTOBuilder {
      private Long id;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private ProductionLineDetailDO productionLine;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal netWeight;
      private String completeTime;
      private String auxiliarySpecification;
      private String auxiliaryMaterial;
      private Integer auxiliaryQuantity;
      private String auxiliaryTypeName;
      private BigDecimal price;
      private BigDecimal wages;

      StudSleeveDTOBuilder() {
      }

      @JsonProperty("id")
      public StudSleeveDTO.StudSleeveDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public StudSleeveDTO.StudSleeveDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public StudSleeveDTO.StudSleeveDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public StudSleeveDTO.StudSleeveDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("productionLine")
      public StudSleeveDTO.StudSleeveDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("serialNumber")
      public StudSleeveDTO.StudSleeveDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public StudSleeveDTO.StudSleeveDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public StudSleeveDTO.StudSleeveDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("netWeight")
      public StudSleeveDTO.StudSleeveDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("completeTime")
      public StudSleeveDTO.StudSleeveDTOBuilder completeTime(final String completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("auxiliarySpecification")
      public StudSleeveDTO.StudSleeveDTOBuilder auxiliarySpecification(final String auxiliarySpecification) {
         this.auxiliarySpecification = auxiliarySpecification;
         return this;
      }

      @JsonProperty("auxiliaryMaterial")
      public StudSleeveDTO.StudSleeveDTOBuilder auxiliaryMaterial(final String auxiliaryMaterial) {
         this.auxiliaryMaterial = auxiliaryMaterial;
         return this;
      }

      @JsonProperty("auxiliaryQuantity")
      public StudSleeveDTO.StudSleeveDTOBuilder auxiliaryQuantity(final Integer auxiliaryQuantity) {
         this.auxiliaryQuantity = auxiliaryQuantity;
         return this;
      }

      @JsonProperty("auxiliaryTypeName")
      public StudSleeveDTO.StudSleeveDTOBuilder auxiliaryTypeName(final String auxiliaryTypeName) {
         this.auxiliaryTypeName = auxiliaryTypeName;
         return this;
      }

      @JsonProperty("price")
      public StudSleeveDTO.StudSleeveDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("wages")
      public StudSleeveDTO.StudSleeveDTOBuilder wages(final BigDecimal wages) {
         this.wages = wages;
         return this;
      }

      public StudSleeveDTO build() {
         return new StudSleeveDTO(
            this.id,
            this.project,
            this.monomer,
            this.area,
            this.productionLine,
            this.serialNumber,
            this.specification,
            this.material,
            this.netWeight,
            this.completeTime,
            this.auxiliarySpecification,
            this.auxiliaryMaterial,
            this.auxiliaryQuantity,
            this.auxiliaryTypeName,
            this.price,
            this.wages
         );
      }

      @Override
      public String toString() {
         return "StudSleeveDTO.StudSleeveDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", productionLine="
            + this.productionLine
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", netWeight="
            + this.netWeight
            + ", completeTime="
            + this.completeTime
            + ", auxiliarySpecification="
            + this.auxiliarySpecification
            + ", auxiliaryMaterial="
            + this.auxiliaryMaterial
            + ", auxiliaryQuantity="
            + this.auxiliaryQuantity
            + ", auxiliaryTypeName="
            + this.auxiliaryTypeName
            + ", price="
            + this.price
            + ", wages="
            + this.wages
            + ")";
      }
   }
}
