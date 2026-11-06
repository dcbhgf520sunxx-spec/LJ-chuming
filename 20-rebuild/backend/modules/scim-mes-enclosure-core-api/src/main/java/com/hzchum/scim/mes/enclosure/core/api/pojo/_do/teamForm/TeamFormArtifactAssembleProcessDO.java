package com.hzchum.scim.mes.enclosure.core.api.pojo._do.teamForm;

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

@ApiModel(value = "TeamFormArtifactAssembleProcessDTO", description = "")
public class TeamFormArtifactAssembleProcessDO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "productId", notes = "产id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Integer productId;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "areaDetail", notes = "区域")
   @JsonProperty("areaDetail")
   @JSONField(name = "areaDetail")
   private AreaDetailDO areaDetail;
   @ApiModelProperty(name = "factory", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务净重量")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务毛重量")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
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
   @ApiModelProperty(name = "netWeight", notes = "净重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "productProcessId", notes = "产品工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "assembleSerialNumber", notes = "组立编号")
   @JsonProperty("assembleSerialNumber")
   @JSONField(name = "assembleSerialNumber")
   private String assembleSerialNumber;

   public static TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder builder() {
      return new TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder();
   }

   public TeamFormArtifactAssembleProcessDO(
      final Long id,
      final ProjectDetailDO project,
      final Integer productId,
      final MonomerDetailDO monomer,
      final AreaDetailDO areaDetail,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final Integer productType,
      final Integer taskQuantity,
      final BigDecimal taskNetWeight,
      final BigDecimal taskGrossWeight,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal netWeight,
      final Long productProcessId,
      final String assembleSerialNumber
   ) {
      this.id = id;
      this.project = project;
      this.productId = productId;
      this.monomer = monomer;
      this.areaDetail = areaDetail;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.productType = productType;
      this.taskQuantity = taskQuantity;
      this.taskNetWeight = taskNetWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.netWeight = netWeight;
      this.productProcessId = productProcessId;
      this.assembleSerialNumber = assembleSerialNumber;
   }

   public TeamFormArtifactAssembleProcessDO() {
   }

   public Long getId() {
      return this.id;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public Integer getProductId() {
      return this.productId;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getAreaDetail() {
      return this.areaDetail;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskGrossWeight() {
      return this.taskGrossWeight;
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

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public String getAssembleSerialNumber() {
      return this.assembleSerialNumber;
   }

   @JsonProperty("id")
   public TeamFormArtifactAssembleProcessDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public TeamFormArtifactAssembleProcessDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("productId")
   public TeamFormArtifactAssembleProcessDO setProductId(final Integer productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("monomer")
   public TeamFormArtifactAssembleProcessDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("areaDetail")
   public TeamFormArtifactAssembleProcessDO setAreaDetail(final AreaDetailDO areaDetail) {
      this.areaDetail = areaDetail;
      return this;
   }

   @JsonProperty("factory")
   public TeamFormArtifactAssembleProcessDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public TeamFormArtifactAssembleProcessDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public TeamFormArtifactAssembleProcessDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("productType")
   public TeamFormArtifactAssembleProcessDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("taskQuantity")
   public TeamFormArtifactAssembleProcessDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public TeamFormArtifactAssembleProcessDO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public TeamFormArtifactAssembleProcessDO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("name")
   public TeamFormArtifactAssembleProcessDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public TeamFormArtifactAssembleProcessDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TeamFormArtifactAssembleProcessDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public TeamFormArtifactAssembleProcessDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("netWeight")
   public TeamFormArtifactAssembleProcessDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("productProcessId")
   public TeamFormArtifactAssembleProcessDO setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("assembleSerialNumber")
   public TeamFormArtifactAssembleProcessDO setAssembleSerialNumber(final String assembleSerialNumber) {
      this.assembleSerialNumber = assembleSerialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "TeamFormArtifactAssembleProcessDO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", productId="
         + this.getProductId()
         + ", monomer="
         + this.getMonomer()
         + ", areaDetail="
         + this.getAreaDetail()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", productType="
         + this.getProductType()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", assembleSerialNumber="
         + this.getAssembleSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamFormArtifactAssembleProcessDO)) {
         return false;
      }

      TeamFormArtifactAssembleProcessDO other = (TeamFormArtifactAssembleProcessDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$taskQuantity = this.getTaskQuantity();
               Object other$taskQuantity = other.getTaskQuantity();
               if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                  Object this$productProcessId = this.getProductProcessId();
                  Object other$productProcessId = other.getProductProcessId();
                  if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$areaDetail = this.getAreaDetail();
                           Object other$areaDetail = other.getAreaDetail();
                           if (this$areaDetail == null ? other$areaDetail == null : this$areaDetail.equals(other$areaDetail)) {
                              Object this$factory = this.getFactory();
                              Object other$factory = other.getFactory();
                              if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                                 Object this$workshop = this.getWorkshop();
                                 Object other$workshop = other.getWorkshop();
                                 if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                    Object this$productionLine = this.getProductionLine();
                                    Object other$productionLine = other.getProductionLine();
                                    if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                       Object this$taskNetWeight = this.getTaskNetWeight();
                                       Object other$taskNetWeight = other.getTaskNetWeight();
                                       if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                                          Object this$taskGrossWeight = this.getTaskGrossWeight();
                                          Object other$taskGrossWeight = other.getTaskGrossWeight();
                                          if (this$taskGrossWeight == null ? other$taskGrossWeight == null : this$taskGrossWeight.equals(other$taskGrossWeight)
                                             )
                                           {
                                             Object this$name = this.getName();
                                             Object other$name = other.getName();
                                             if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$netWeight = this.getNetWeight();
                                                         Object other$netWeight = other.getNetWeight();
                                                         if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                            Object this$assembleSerialNumber = this.getAssembleSerialNumber();
                                                            Object other$assembleSerialNumber = other.getAssembleSerialNumber();
                                                            return this$assembleSerialNumber == null
                                                               ? other$assembleSerialNumber == null
                                                               : this$assembleSerialNumber.equals(other$assembleSerialNumber);
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
      return other instanceof TeamFormArtifactAssembleProcessDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $areaDetail = this.getAreaDetail();
      result = result * 59 + ($areaDetail == null ? 43 : $areaDetail.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $assembleSerialNumber = this.getAssembleSerialNumber();
      return result * 59 + ($assembleSerialNumber == null ? 43 : $assembleSerialNumber.hashCode());
   }

   public static class TeamFormArtifactAssembleProcessDOBuilder {
      private Long id;
      private ProjectDetailDO project;
      private Integer productId;
      private MonomerDetailDO monomer;
      private AreaDetailDO areaDetail;
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private Integer productType;
      private Integer taskQuantity;
      private BigDecimal taskNetWeight;
      private BigDecimal taskGrossWeight;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal netWeight;
      private Long productProcessId;
      private String assembleSerialNumber;

      TeamFormArtifactAssembleProcessDOBuilder() {
      }

      @JsonProperty("id")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("productId")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder productId(final Integer productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("monomer")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("areaDetail")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder areaDetail(final AreaDetailDO areaDetail) {
         this.areaDetail = areaDetail;
         return this;
      }

      @JsonProperty("factory")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("productType")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("taskQuantity")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("name")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("netWeight")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("productProcessId")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("assembleSerialNumber")
      public TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder assembleSerialNumber(final String assembleSerialNumber) {
         this.assembleSerialNumber = assembleSerialNumber;
         return this;
      }

      public TeamFormArtifactAssembleProcessDO build() {
         return new TeamFormArtifactAssembleProcessDO(
            this.id,
            this.project,
            this.productId,
            this.monomer,
            this.areaDetail,
            this.factory,
            this.workshop,
            this.productionLine,
            this.productType,
            this.taskQuantity,
            this.taskNetWeight,
            this.taskGrossWeight,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.netWeight,
            this.productProcessId,
            this.assembleSerialNumber
         );
      }

      @Override
      public String toString() {
         return "TeamFormArtifactAssembleProcessDO.TeamFormArtifactAssembleProcessDOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", productId="
            + this.productId
            + ", monomer="
            + this.monomer
            + ", areaDetail="
            + this.areaDetail
            + ", factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", productType="
            + this.productType
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", netWeight="
            + this.netWeight
            + ", productProcessId="
            + this.productProcessId
            + ", assembleSerialNumber="
            + this.assembleSerialNumber
            + ")";
      }
   }
}
