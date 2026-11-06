package com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TeamFormDO", description = "")
public class TeamFormAssembleDetailsDTO {
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
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
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
   @ApiModelProperty(name = "artifactSerialNumber", notes = "构件编号")
   @JsonProperty("artifactSerialNumber")
   @JSONField(name = "artifactSerialNumber")
   private String artifactSerialNumber;
   @ApiModelProperty(name = "taskLength", notes = "任务长度")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private BigDecimal taskLength;
   @ApiModelProperty(name = "completeLength", notes = "完成长度")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;

   public static TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder builder() {
      return new TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder();
   }

   public TeamFormAssembleDetailsDTO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO areaDetail,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final Integer productType,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final String artifactSerialNumber,
      final BigDecimal taskLength,
      final BigDecimal completeLength
   ) {
      this.project = project;
      this.monomer = monomer;
      this.areaDetail = areaDetail;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.productType = productType;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.artifactSerialNumber = artifactSerialNumber;
      this.taskLength = taskLength;
      this.completeLength = completeLength;
   }

   public TeamFormAssembleDetailsDTO() {
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

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
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

   public String getArtifactSerialNumber() {
      return this.artifactSerialNumber;
   }

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   @JsonProperty("project")
   public TeamFormAssembleDetailsDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public TeamFormAssembleDetailsDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("areaDetail")
   public TeamFormAssembleDetailsDTO setAreaDetail(final AreaDetailDO areaDetail) {
      this.areaDetail = areaDetail;
      return this;
   }

   @JsonProperty("factory")
   public TeamFormAssembleDetailsDTO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public TeamFormAssembleDetailsDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public TeamFormAssembleDetailsDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("productType")
   public TeamFormAssembleDetailsDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("taskQuantity")
   public TeamFormAssembleDetailsDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TeamFormAssembleDetailsDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("name")
   public TeamFormAssembleDetailsDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public TeamFormAssembleDetailsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TeamFormAssembleDetailsDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public TeamFormAssembleDetailsDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("artifactSerialNumber")
   public TeamFormAssembleDetailsDTO setArtifactSerialNumber(final String artifactSerialNumber) {
      this.artifactSerialNumber = artifactSerialNumber;
      return this;
   }

   @JsonProperty("taskLength")
   public TeamFormAssembleDetailsDTO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("completeLength")
   public TeamFormAssembleDetailsDTO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @Override
   public String toString() {
      return "TeamFormAssembleDetailsDTO(project="
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
         + ", productType="
         + this.getProductType()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", artifactSerialNumber="
         + this.getArtifactSerialNumber()
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

      if (!(o instanceof TeamFormAssembleDetailsDTO)) {
         return false;
      }

      TeamFormAssembleDetailsDTO other = (TeamFormAssembleDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
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
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$artifactSerialNumber = this.getArtifactSerialNumber();
                                             Object other$artifactSerialNumber = other.getArtifactSerialNumber();
                                             if (this$artifactSerialNumber == null
                                                ? other$artifactSerialNumber == null
                                                : this$artifactSerialNumber.equals(other$artifactSerialNumber)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TeamFormAssembleDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
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
      Object $artifactSerialNumber = this.getArtifactSerialNumber();
      result = result * 59 + ($artifactSerialNumber == null ? 43 : $artifactSerialNumber.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $completeLength = this.getCompleteLength();
      return result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
   }

   public static class TeamFormAssembleDetailsDTOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO areaDetail;
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private Integer productType;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private String artifactSerialNumber;
      private BigDecimal taskLength;
      private BigDecimal completeLength;

      TeamFormAssembleDetailsDTOBuilder() {
      }

      @JsonProperty("project")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("areaDetail")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder areaDetail(final AreaDetailDO areaDetail) {
         this.areaDetail = areaDetail;
         return this;
      }

      @JsonProperty("factory")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("productType")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("taskQuantity")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("name")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("artifactSerialNumber")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder artifactSerialNumber(final String artifactSerialNumber) {
         this.artifactSerialNumber = artifactSerialNumber;
         return this;
      }

      @JsonProperty("taskLength")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("completeLength")
      public TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      public TeamFormAssembleDetailsDTO build() {
         return new TeamFormAssembleDetailsDTO(
            this.project,
            this.monomer,
            this.areaDetail,
            this.factory,
            this.workshop,
            this.productionLine,
            this.productType,
            this.taskQuantity,
            this.completeQuantity,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.artifactSerialNumber,
            this.taskLength,
            this.completeLength
         );
      }

      @Override
      public String toString() {
         return "TeamFormAssembleDetailsDTO.TeamFormAssembleDetailsDTOBuilder(project="
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
            + ", productType="
            + this.productType
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", artifactSerialNumber="
            + this.artifactSerialNumber
            + ", taskLength="
            + this.taskLength
            + ", completeLength="
            + this.completeLength
            + ")";
      }
   }
}
