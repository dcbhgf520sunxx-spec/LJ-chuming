package com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "HysteresisVORequest", description = "构件组立迟滞返回类")
public class ArtifactAssembleHysteresisDetailsDTO {
   @ApiModelProperty(name = "askCompleteTime", value = "时间")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务净重量")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务毛重量")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成净重量")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "completeGrossWeight", notes = "完成毛重量")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
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
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @JsonInclude(Include.NON_NULL)
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
   @ApiModelProperty(name = "taskLength", notes = "任务长度量")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private BigDecimal taskLength;
   @ApiModelProperty(name = "completeLength", notes = "完成长度量")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;

   public static ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder builder() {
      return new ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder();
   }

   public ArtifactAssembleHysteresisDetailsDTO() {
   }

   public ArtifactAssembleHysteresisDetailsDTO(
      final LocalDateTime askCompleteTime,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final BigDecimal taskNetWeight,
      final BigDecimal taskGrossWeight,
      final BigDecimal completeNetWeight,
      final BigDecimal completeGrossWeight,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO areaDetail,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal taskLength,
      final BigDecimal completeLength
   ) {
      this.askCompleteTime = askCompleteTime;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.taskNetWeight = taskNetWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.completeNetWeight = completeNetWeight;
      this.completeGrossWeight = completeGrossWeight;
      this.project = project;
      this.monomer = monomer;
      this.areaDetail = areaDetail;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.taskLength = taskLength;
      this.completeLength = completeLength;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public ProjectDetailDO getProject() {
      return this.project;
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

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   @JsonProperty("askCompleteTime")
   public ArtifactAssembleHysteresisDetailsDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("taskQuantity")
   public ArtifactAssembleHysteresisDetailsDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ArtifactAssembleHysteresisDetailsDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public ArtifactAssembleHysteresisDetailsDTO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public ArtifactAssembleHysteresisDetailsDTO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public ArtifactAssembleHysteresisDetailsDTO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public ArtifactAssembleHysteresisDetailsDTO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("project")
   public ArtifactAssembleHysteresisDetailsDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public ArtifactAssembleHysteresisDetailsDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("areaDetail")
   public ArtifactAssembleHysteresisDetailsDTO setAreaDetail(final AreaDetailDO areaDetail) {
      this.areaDetail = areaDetail;
      return this;
   }

   @JsonProperty("factory")
   public ArtifactAssembleHysteresisDetailsDTO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public ArtifactAssembleHysteresisDetailsDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public ArtifactAssembleHysteresisDetailsDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("name")
   public ArtifactAssembleHysteresisDetailsDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ArtifactAssembleHysteresisDetailsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ArtifactAssembleHysteresisDetailsDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public ArtifactAssembleHysteresisDetailsDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("taskLength")
   public ArtifactAssembleHysteresisDetailsDTO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("completeLength")
   public ArtifactAssembleHysteresisDetailsDTO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactAssembleHysteresisDetailsDTO(askCompleteTime="
         + this.getAskCompleteTime()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", project="
         + this.getProject()
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
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", taskLength="
         + this.getTaskLength()
         + ", completeLength="
         + this.getCompleteLength()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactAssembleHysteresisDetailsDTO)) {
         return false;
      }

      ArtifactAssembleHysteresisDetailsDTO other = (ArtifactAssembleHysteresisDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskQuantity = this.getTaskQuantity();
      Object other$taskQuantity = other.getTaskQuantity();
      if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$askCompleteTime = this.getAskCompleteTime();
            Object other$askCompleteTime = other.getAskCompleteTime();
            if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
               Object this$taskNetWeight = this.getTaskNetWeight();
               Object other$taskNetWeight = other.getTaskNetWeight();
               if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                  Object this$taskGrossWeight = this.getTaskGrossWeight();
                  Object other$taskGrossWeight = other.getTaskGrossWeight();
                  if (this$taskGrossWeight == null ? other$taskGrossWeight == null : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                     Object this$completeNetWeight = this.getCompleteNetWeight();
                     Object other$completeNetWeight = other.getCompleteNetWeight();
                     if (this$completeNetWeight == null ? other$completeNetWeight == null : this$completeNetWeight.equals(other$completeNetWeight)) {
                        Object this$completeGrossWeight = this.getCompleteGrossWeight();
                        Object other$completeGrossWeight = other.getCompleteGrossWeight();
                        if (this$completeGrossWeight == null ? other$completeGrossWeight == null : this$completeGrossWeight.equals(other$completeGrossWeight)) {
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
                                                         Object this$taskLength = this.getTaskLength();
                                                         Object other$taskLength = other.getTaskLength();
                                                         if (this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength)) {
                                                            Object this$completeLength = this.getCompleteLength();
                                                            Object other$completeLength = other.getCompleteLength();
                                                            return this$completeLength == null
                                                               ? other$completeLength == null
                                                               : this$completeLength.equals(other$completeLength);
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
      return other instanceof ArtifactAssembleHysteresisDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
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
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $completeLength = this.getCompleteLength();
      return result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
   }

   public static class ArtifactAssembleHysteresisDetailsDTOBuilder {
      private LocalDateTime askCompleteTime;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private BigDecimal taskNetWeight;
      private BigDecimal taskGrossWeight;
      private BigDecimal completeNetWeight;
      private BigDecimal completeGrossWeight;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO areaDetail;
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal taskLength;
      private BigDecimal completeLength;

      ArtifactAssembleHysteresisDetailsDTOBuilder() {
      }

      @JsonProperty("askCompleteTime")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("taskQuantity")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("project")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("areaDetail")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder areaDetail(final AreaDetailDO areaDetail) {
         this.areaDetail = areaDetail;
         return this;
      }

      @JsonProperty("factory")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("name")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("taskLength")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("completeLength")
      public ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      public ArtifactAssembleHysteresisDetailsDTO build() {
         return new ArtifactAssembleHysteresisDetailsDTO(
            this.askCompleteTime,
            this.taskQuantity,
            this.completeQuantity,
            this.taskNetWeight,
            this.taskGrossWeight,
            this.completeNetWeight,
            this.completeGrossWeight,
            this.project,
            this.monomer,
            this.areaDetail,
            this.factory,
            this.workshop,
            this.productionLine,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.taskLength,
            this.completeLength
         );
      }

      @Override
      public String toString() {
         return "ArtifactAssembleHysteresisDetailsDTO.ArtifactAssembleHysteresisDetailsDTOBuilder(askCompleteTime="
            + this.askCompleteTime
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", project="
            + this.project
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
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", taskLength="
            + this.taskLength
            + ", completeLength="
            + this.completeLength
            + ")";
      }
   }
}
