package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingParNeedSchedulingDTO", description = "零件待排产数据统计返回值")
public class MesBuildingParNeedSchedulingDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "monomer", value = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "factory", value = "工厂", notes = "工厂")
   private NameInfo factory;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   private NameInfo workshop;
   @ApiModelProperty(name = "productionLine", value = "产线", notes = "产线")
   private NameInfo productionLine;
   @ApiModelProperty(name = "group", value = "生产组", notes = "生产组")
   private NameInfo group;
   @ApiModelProperty(name = "group", value = "数量", notes = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "净重", notes = "净重")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重", notes = "总净重")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "毛重", notes = "毛重")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重", notes = "总毛重")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "picturePath", value = "图片路径(DXF:记录转换后的.sug位置  部件(主部件):记录导入的原构件NC1的图纸位子)")
   private String picturePath;
   @ApiModelProperty(name = "relationType", value = "关联产品类型 2关联构件 16关联组立 18组立 枚举:MachinePartRelationTypeEnum")
   private Integer relationType;
   @ApiModelProperty(notes = "材质")
   private String material;
   @ApiModelProperty(notes = "编号")
   private String serialNumber;
   @ApiModelProperty(notes = "名称")
   private String name;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "thick", value = "厚度", notes = "厚度")
   private String thick;
   @ApiModelProperty(name = "bool_drawing", value = "是否是有图纸下发", notes = "是否是有图纸下发")
   private Integer boolDrawing;
   @ApiModelProperty(name = "maxAskCompleteTime", value = "最大要求完成时间")
   private LocalDateTime maxAskCompleteTime;
   @ApiModelProperty(name = "minAskCompleteTime", value = "最小要求完成时间")
   private LocalDateTime minAskCompleteTime;

   public static MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder builder() {
      return new MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder();
   }

   public MesBuildingParNeedSchedulingDTO() {
   }

   public MesBuildingParNeedSchedulingDTO(
      final Long id,
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final NameInfo factory,
      final NameInfo workshop,
      final NameInfo productionLine,
      final NameInfo group,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final String picturePath,
      final Integer relationType,
      final String material,
      final String serialNumber,
      final String name,
      final String specification,
      final BigDecimal length,
      final String thick,
      final Integer boolDrawing,
      final LocalDateTime maxAskCompleteTime,
      final LocalDateTime minAskCompleteTime
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.group = group;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.picturePath = picturePath;
      this.relationType = relationType;
      this.material = material;
      this.serialNumber = serialNumber;
      this.name = name;
      this.specification = specification;
      this.length = length;
      this.thick = thick;
      this.boolDrawing = boolDrawing;
      this.maxAskCompleteTime = maxAskCompleteTime;
      this.minAskCompleteTime = minAskCompleteTime;
   }

   public Long getId() {
      return this.id;
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

   public NameInfo getFactory() {
      return this.factory;
   }

   public NameInfo getWorkshop() {
      return this.workshop;
   }

   public NameInfo getProductionLine() {
      return this.productionLine;
   }

   public NameInfo getGroup() {
      return this.group;
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

   public Integer getRelationType() {
      return this.relationType;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getThick() {
      return this.thick;
   }

   public Integer getBoolDrawing() {
      return this.boolDrawing;
   }

   public LocalDateTime getMaxAskCompleteTime() {
      return this.maxAskCompleteTime;
   }

   public LocalDateTime getMinAskCompleteTime() {
      return this.minAskCompleteTime;
   }

   public MesBuildingParNeedSchedulingDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setArea(final NameInfo area) {
      this.area = area;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setFactory(final NameInfo factory) {
      this.factory = factory;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setProductionLine(final NameInfo productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setGroup(final NameInfo group) {
      this.group = group;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setBoolDrawing(final Integer boolDrawing) {
      this.boolDrawing = boolDrawing;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setMaxAskCompleteTime(final LocalDateTime maxAskCompleteTime) {
      this.maxAskCompleteTime = maxAskCompleteTime;
      return this;
   }

   public MesBuildingParNeedSchedulingDTO setMinAskCompleteTime(final LocalDateTime minAskCompleteTime) {
      this.minAskCompleteTime = minAskCompleteTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingParNeedSchedulingDTO)) {
         return false;
      }

      MesBuildingParNeedSchedulingDTO other = (MesBuildingParNeedSchedulingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$relationType = this.getRelationType();
            Object other$relationType = other.getRelationType();
            if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
               Object this$boolDrawing = this.getBoolDrawing();
               Object other$boolDrawing = other.getBoolDrawing();
               if (this$boolDrawing == null ? other$boolDrawing == null : this$boolDrawing.equals(other$boolDrawing)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$monomer = this.getMonomer();
                     Object other$monomer = other.getMonomer();
                     if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                        Object this$area = this.getArea();
                        Object other$area = other.getArea();
                        if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                           Object this$factory = this.getFactory();
                           Object other$factory = other.getFactory();
                           if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                              Object this$workshop = this.getWorkshop();
                              Object other$workshop = other.getWorkshop();
                              if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                 Object this$productionLine = this.getProductionLine();
                                 Object other$productionLine = other.getProductionLine();
                                 if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                    Object this$group = this.getGroup();
                                    Object other$group = other.getGroup();
                                    if (this$group == null ? other$group == null : this$group.equals(other$group)) {
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
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$name = this.getName();
                                                            Object other$name = other.getName();
                                                            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                               Object this$specification = this.getSpecification();
                                                               Object other$specification = other.getSpecification();
                                                               if (this$specification == null
                                                                  ? other$specification == null
                                                                  : this$specification.equals(other$specification)) {
                                                                  Object this$length = this.getLength();
                                                                  Object other$length = other.getLength();
                                                                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                     Object this$thick = this.getThick();
                                                                     Object other$thick = other.getThick();
                                                                     if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                                        Object this$maxAskCompleteTime = this.getMaxAskCompleteTime();
                                                                        Object other$maxAskCompleteTime = other.getMaxAskCompleteTime();
                                                                        if (this$maxAskCompleteTime == null
                                                                           ? other$maxAskCompleteTime == null
                                                                           : this$maxAskCompleteTime.equals(other$maxAskCompleteTime)) {
                                                                           Object this$minAskCompleteTime = this.getMinAskCompleteTime();
                                                                           Object other$minAskCompleteTime = other.getMinAskCompleteTime();
                                                                           return this$minAskCompleteTime == null
                                                                              ? other$minAskCompleteTime == null
                                                                              : this$minAskCompleteTime.equals(other$minAskCompleteTime);
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
      return other instanceof MesBuildingParNeedSchedulingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $boolDrawing = this.getBoolDrawing();
      result = result * 59 + ($boolDrawing == null ? 43 : $boolDrawing.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $group = this.getGroup();
      result = result * 59 + ($group == null ? 43 : $group.hashCode());
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
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $maxAskCompleteTime = this.getMaxAskCompleteTime();
      result = result * 59 + ($maxAskCompleteTime == null ? 43 : $maxAskCompleteTime.hashCode());
      Object $minAskCompleteTime = this.getMinAskCompleteTime();
      return result * 59 + ($minAskCompleteTime == null ? 43 : $minAskCompleteTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingParNeedSchedulingDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", group="
         + this.getGroup()
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
         + ", relationType="
         + this.getRelationType()
         + ", material="
         + this.getMaterial()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", thick="
         + this.getThick()
         + ", boolDrawing="
         + this.getBoolDrawing()
         + ", maxAskCompleteTime="
         + this.getMaxAskCompleteTime()
         + ", minAskCompleteTime="
         + this.getMinAskCompleteTime()
         + ")";
   }

   public static class MesBuildingParNeedSchedulingDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private NameInfo factory;
      private NameInfo workshop;
      private NameInfo productionLine;
      private NameInfo group;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private String picturePath;
      private Integer relationType;
      private String material;
      private String serialNumber;
      private String name;
      private String specification;
      private BigDecimal length;
      private String thick;
      private Integer boolDrawing;
      private LocalDateTime maxAskCompleteTime;
      private LocalDateTime minAskCompleteTime;

      MesBuildingParNeedSchedulingDTOBuilder() {
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder factory(final NameInfo factory) {
         this.factory = factory;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder workshop(final NameInfo workshop) {
         this.workshop = workshop;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder productionLine(final NameInfo productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder group(final NameInfo group) {
         this.group = group;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder boolDrawing(final Integer boolDrawing) {
         this.boolDrawing = boolDrawing;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder maxAskCompleteTime(final LocalDateTime maxAskCompleteTime) {
         this.maxAskCompleteTime = maxAskCompleteTime;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder minAskCompleteTime(final LocalDateTime minAskCompleteTime) {
         this.minAskCompleteTime = minAskCompleteTime;
         return this;
      }

      public MesBuildingParNeedSchedulingDTO build() {
         return new MesBuildingParNeedSchedulingDTO(
            this.id,
            this.project,
            this.monomer,
            this.area,
            this.factory,
            this.workshop,
            this.productionLine,
            this.group,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.picturePath,
            this.relationType,
            this.material,
            this.serialNumber,
            this.name,
            this.specification,
            this.length,
            this.thick,
            this.boolDrawing,
            this.maxAskCompleteTime,
            this.minAskCompleteTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingParNeedSchedulingDTO.MesBuildingParNeedSchedulingDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", group="
            + this.group
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
            + ", relationType="
            + this.relationType
            + ", material="
            + this.material
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", thick="
            + this.thick
            + ", boolDrawing="
            + this.boolDrawing
            + ", maxAskCompleteTime="
            + this.maxAskCompleteTime
            + ", minAskCompleteTime="
            + this.minAskCompleteTime
            + ")";
      }
   }
}
