package com.hzchum.scim.mes.enclosure.core.api.pojo._do.productionStatements;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ArtifactProductionStatementsDO", description = "构件生产报表")
public class EnclosureProductionStatementsDO {
   @ApiModelProperty(name = "project", notes = "项目单体区域")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "district", notes = "区域")
   @JsonProperty("district")
   @JSONField(name = "district")
   private AreaDetailDO district;
   @ApiModelProperty(name = "productionline", notes = "生产线")
   @JsonProperty("productionline")
   @JSONField(name = "productionline")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "factory", value = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "plate", notes = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "color", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "weight", notes = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;
   @ApiModelProperty(name = "thickness", notes = "厚度（mm）")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", notes = "宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalLength", notes = "总长度（m）")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", notes = "总面积（㎡）")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "date", value = "生产日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;

   public static EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder builder() {
      return new EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder();
   }

   public EnclosureProductionStatementsDO() {
   }

   public EnclosureProductionStatementsDO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO district,
      final ProductionLineDetailDO productionLine,
      final WorkshopDetailDO workshop,
      final FactoryDetailDO factory,
      final Integer category,
      final String name,
      final String serialNumber,
      final String plate,
      final String color,
      final String material,
      final BigDecimal weight,
      final BigDecimal thickness,
      final BigDecimal width,
      final BigDecimal length,
      final Integer quantity,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final String date
   ) {
      this.project = project;
      this.monomer = monomer;
      this.district = district;
      this.productionLine = productionLine;
      this.workshop = workshop;
      this.factory = factory;
      this.category = category;
      this.name = name;
      this.serialNumber = serialNumber;
      this.plate = plate;
      this.color = color;
      this.material = material;
      this.weight = weight;
      this.thickness = thickness;
      this.width = width;
      this.length = length;
      this.quantity = quantity;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.date = date;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getDistrict() {
      return this.district;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public String getDate() {
      return this.date;
   }

   @JsonProperty("project")
   public EnclosureProductionStatementsDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public EnclosureProductionStatementsDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("district")
   public EnclosureProductionStatementsDO setDistrict(final AreaDetailDO district) {
      this.district = district;
      return this;
   }

   @JsonProperty("productionline")
   public EnclosureProductionStatementsDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("workshop")
   public EnclosureProductionStatementsDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("factory")
   public EnclosureProductionStatementsDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("category")
   public EnclosureProductionStatementsDO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("name")
   public EnclosureProductionStatementsDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public EnclosureProductionStatementsDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("plate")
   public EnclosureProductionStatementsDO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public EnclosureProductionStatementsDO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("material")
   public EnclosureProductionStatementsDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("weight")
   public EnclosureProductionStatementsDO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("thickness")
   public EnclosureProductionStatementsDO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("width")
   public EnclosureProductionStatementsDO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("length")
   public EnclosureProductionStatementsDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("quantity")
   public EnclosureProductionStatementsDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalLength")
   public EnclosureProductionStatementsDO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalArea")
   public EnclosureProductionStatementsDO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("date")
   public EnclosureProductionStatementsDO setDate(final String date) {
      this.date = date;
      return this;
   }

   @Override
   public String toString() {
      return "EnclosureProductionStatementsDO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", district="
         + this.getDistrict()
         + ", productionLine="
         + this.getProductionLine()
         + ", workshop="
         + this.getWorkshop()
         + ", factory="
         + this.getFactory()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", weight="
         + this.getWeight()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", date="
         + this.getDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureProductionStatementsDO)) {
         return false;
      }

      EnclosureProductionStatementsDO other = (EnclosureProductionStatementsDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$category = this.getCategory();
      Object other$category = other.getCategory();
      if (this$category == null ? other$category == null : this$category.equals(other$category)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$monomer = this.getMonomer();
               Object other$monomer = other.getMonomer();
               if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                  Object this$district = this.getDistrict();
                  Object other$district = other.getDistrict();
                  if (this$district == null ? other$district == null : this$district.equals(other$district)) {
                     Object this$productionLine = this.getProductionLine();
                     Object other$productionLine = other.getProductionLine();
                     if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                        Object this$workshop = this.getWorkshop();
                        Object other$workshop = other.getWorkshop();
                        if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                           Object this$factory = this.getFactory();
                           Object other$factory = other.getFactory();
                           if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$plate = this.getPlate();
                                    Object other$plate = other.getPlate();
                                    if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                       Object this$color = this.getColor();
                                       Object other$color = other.getColor();
                                       if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$weight = this.getWeight();
                                             Object other$weight = other.getWeight();
                                             if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                Object this$thickness = this.getThickness();
                                                Object other$thickness = other.getThickness();
                                                if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                   Object this$width = this.getWidth();
                                                   Object other$width = other.getWidth();
                                                   if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                      Object this$length = this.getLength();
                                                      Object other$length = other.getLength();
                                                      if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                         Object this$totalLength = this.getTotalLength();
                                                         Object other$totalLength = other.getTotalLength();
                                                         if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                                            Object this$totalArea = this.getTotalArea();
                                                            Object other$totalArea = other.getTotalArea();
                                                            if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                                               Object this$date = this.getDate();
                                                               Object other$date = other.getDate();
                                                               return this$date == null ? other$date == null : this$date.equals(other$date);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureProductionStatementsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $district = this.getDistrict();
      result = result * 59 + ($district == null ? 43 : $district.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   public static class EnclosureProductionStatementsDOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO district;
      private ProductionLineDetailDO productionLine;
      private WorkshopDetailDO workshop;
      private FactoryDetailDO factory;
      private Integer category;
      private String name;
      private String serialNumber;
      private String plate;
      private String color;
      private String material;
      private BigDecimal weight;
      private BigDecimal thickness;
      private BigDecimal width;
      private BigDecimal length;
      private Integer quantity;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private String date;

      EnclosureProductionStatementsDOBuilder() {
      }

      @JsonProperty("project")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("district")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder district(final AreaDetailDO district) {
         this.district = district;
         return this;
      }

      @JsonProperty("productionline")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("workshop")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("factory")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("category")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("name")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("plate")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("material")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("weight")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("thickness")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("width")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("length")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("quantity")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalLength")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("date")
      public EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      public EnclosureProductionStatementsDO build() {
         return new EnclosureProductionStatementsDO(
            this.project,
            this.monomer,
            this.district,
            this.productionLine,
            this.workshop,
            this.factory,
            this.category,
            this.name,
            this.serialNumber,
            this.plate,
            this.color,
            this.material,
            this.weight,
            this.thickness,
            this.width,
            this.length,
            this.quantity,
            this.totalLength,
            this.totalArea,
            this.date
         );
      }

      @Override
      public String toString() {
         return "EnclosureProductionStatementsDO.EnclosureProductionStatementsDOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", district="
            + this.district
            + ", productionLine="
            + this.productionLine
            + ", workshop="
            + this.workshop
            + ", factory="
            + this.factory
            + ", category="
            + this.category
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", material="
            + this.material
            + ", weight="
            + this.weight
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", date="
            + this.date
            + ")";
      }
   }
}
