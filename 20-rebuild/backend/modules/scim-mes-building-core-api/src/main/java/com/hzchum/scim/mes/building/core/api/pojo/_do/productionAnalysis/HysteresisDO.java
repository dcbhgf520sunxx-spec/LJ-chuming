package com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis;

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
import java.time.LocalDateTime;

@ApiModel(value = "HysteresisVORequest", description = "迟滞请求类")
public class HysteresisDO {
   @ApiModelProperty(name = "askCompleteTime", value = "时间")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "dateTime", value = "日期")
   @JsonProperty("dateTime")
   @JSONField(name = "dateTime")
   private String dateTime;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "taskLength", notes = "任务长度量")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private BigDecimal taskLength;
   @ApiModelProperty(name = "taskArea", notes = "任务面积量")
   @JsonProperty("taskArea")
   @JSONField(name = "taskArea")
   private BigDecimal taskArea;
   @ApiModelProperty(name = "completeLength", notes = "完成长度量")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;
   @ApiModelProperty(name = "completeArea", notes = "完成面积量")
   @JsonProperty("completeArea")
   @JSONField(name = "completeArea")
   private BigDecimal completeArea;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务净重量")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务毛重量")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成净重量")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "completeGrossWeight", notes = "完成毛重量")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
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
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;

   public static HysteresisDO.HysteresisDOBuilder builder() {
      return new HysteresisDO.HysteresisDOBuilder();
   }

   public HysteresisDO() {
   }

   public HysteresisDO(
      final LocalDateTime askCompleteTime,
      final String dateTime,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final BigDecimal taskLength,
      final BigDecimal taskArea,
      final BigDecimal completeLength,
      final BigDecimal completeArea,
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
      final String plate,
      final String color,
      final String specification,
      final String material
   ) {
      this.askCompleteTime = askCompleteTime;
      this.dateTime = dateTime;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.taskLength = taskLength;
      this.taskArea = taskArea;
      this.completeLength = completeLength;
      this.completeArea = completeArea;
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
      this.plate = plate;
      this.color = color;
      this.specification = specification;
      this.material = material;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getTaskArea() {
      return this.taskArea;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   public BigDecimal getCompleteArea() {
      return this.completeArea;
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

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   @JsonProperty("askCompleteTime")
   public HysteresisDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("dateTime")
   public HysteresisDO setDateTime(final String dateTime) {
      this.dateTime = dateTime;
      return this;
   }

   @JsonProperty("taskQuantity")
   public HysteresisDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public HysteresisDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("taskLength")
   public HysteresisDO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("taskArea")
   public HysteresisDO setTaskArea(final BigDecimal taskArea) {
      this.taskArea = taskArea;
      return this;
   }

   @JsonProperty("completeLength")
   public HysteresisDO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("completeArea")
   public HysteresisDO setCompleteArea(final BigDecimal completeArea) {
      this.completeArea = completeArea;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public HysteresisDO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public HysteresisDO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public HysteresisDO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public HysteresisDO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("project")
   public HysteresisDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public HysteresisDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("areaDetail")
   public HysteresisDO setAreaDetail(final AreaDetailDO areaDetail) {
      this.areaDetail = areaDetail;
      return this;
   }

   @JsonProperty("factory")
   public HysteresisDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public HysteresisDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public HysteresisDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("name")
   public HysteresisDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public HysteresisDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("plate")
   public HysteresisDO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public HysteresisDO setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("specification")
   public HysteresisDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public HysteresisDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @Override
   public String toString() {
      return "HysteresisDO(askCompleteTime="
         + this.getAskCompleteTime()
         + ", dateTime="
         + this.getDateTime()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", taskLength="
         + this.getTaskLength()
         + ", taskArea="
         + this.getTaskArea()
         + ", completeLength="
         + this.getCompleteLength()
         + ", completeArea="
         + this.getCompleteArea()
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
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof HysteresisDO)) {
         return false;
      }

      HysteresisDO other = (HysteresisDO)o;
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
               Object this$dateTime = this.getDateTime();
               Object other$dateTime = other.getDateTime();
               if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
                  Object this$taskLength = this.getTaskLength();
                  Object other$taskLength = other.getTaskLength();
                  if (this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength)) {
                     Object this$taskArea = this.getTaskArea();
                     Object other$taskArea = other.getTaskArea();
                     if (this$taskArea == null ? other$taskArea == null : this$taskArea.equals(other$taskArea)) {
                        Object this$completeLength = this.getCompleteLength();
                        Object other$completeLength = other.getCompleteLength();
                        if (this$completeLength == null ? other$completeLength == null : this$completeLength.equals(other$completeLength)) {
                           Object this$completeArea = this.getCompleteArea();
                           Object other$completeArea = other.getCompleteArea();
                           if (this$completeArea == null ? other$completeArea == null : this$completeArea.equals(other$completeArea)) {
                              Object this$taskNetWeight = this.getTaskNetWeight();
                              Object other$taskNetWeight = other.getTaskNetWeight();
                              if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                                 Object this$taskGrossWeight = this.getTaskGrossWeight();
                                 Object other$taskGrossWeight = other.getTaskGrossWeight();
                                 if (this$taskGrossWeight == null ? other$taskGrossWeight == null : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                                    Object this$completeNetWeight = this.getCompleteNetWeight();
                                    Object other$completeNetWeight = other.getCompleteNetWeight();
                                    if (this$completeNetWeight == null
                                       ? other$completeNetWeight == null
                                       : this$completeNetWeight.equals(other$completeNetWeight)) {
                                       Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                       Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                       if (this$completeGrossWeight == null
                                          ? other$completeGrossWeight == null
                                          : this$completeGrossWeight.equals(other$completeGrossWeight)) {
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
                                                         if (this$productionLine == null
                                                            ? other$productionLine == null
                                                            : this$productionLine.equals(other$productionLine)) {
                                                            Object this$name = this.getName();
                                                            Object other$name = other.getName();
                                                            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                               Object this$serialNumber = this.getSerialNumber();
                                                               Object other$serialNumber = other.getSerialNumber();
                                                               if (this$serialNumber == null
                                                                  ? other$serialNumber == null
                                                                  : this$serialNumber.equals(other$serialNumber)) {
                                                                  Object this$plate = this.getPlate();
                                                                  Object other$plate = other.getPlate();
                                                                  if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                                                     Object this$color = this.getColor();
                                                                     Object other$color = other.getColor();
                                                                     if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                        Object this$specification = this.getSpecification();
                                                                        Object other$specification = other.getSpecification();
                                                                        if (this$specification == null
                                                                           ? other$specification == null
                                                                           : this$specification.equals(other$specification)) {
                                                                           Object this$material = this.getMaterial();
                                                                           Object other$material = other.getMaterial();
                                                                           return this$material == null
                                                                              ? other$material == null
                                                                              : this$material.equals(other$material);
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
      return other instanceof HysteresisDO;
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
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $taskArea = this.getTaskArea();
      result = result * 59 + ($taskArea == null ? 43 : $taskArea.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $completeArea = this.getCompleteArea();
      result = result * 59 + ($completeArea == null ? 43 : $completeArea.hashCode());
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
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   public static class HysteresisDOBuilder {
      private LocalDateTime askCompleteTime;
      private String dateTime;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private BigDecimal taskLength;
      private BigDecimal taskArea;
      private BigDecimal completeLength;
      private BigDecimal completeArea;
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
      private String plate;
      private String color;
      private String specification;
      private String material;

      HysteresisDOBuilder() {
      }

      @JsonProperty("askCompleteTime")
      public HysteresisDO.HysteresisDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("dateTime")
      public HysteresisDO.HysteresisDOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      @JsonProperty("taskQuantity")
      public HysteresisDO.HysteresisDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public HysteresisDO.HysteresisDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("taskLength")
      public HysteresisDO.HysteresisDOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("taskArea")
      public HysteresisDO.HysteresisDOBuilder taskArea(final BigDecimal taskArea) {
         this.taskArea = taskArea;
         return this;
      }

      @JsonProperty("completeLength")
      public HysteresisDO.HysteresisDOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("completeArea")
      public HysteresisDO.HysteresisDOBuilder completeArea(final BigDecimal completeArea) {
         this.completeArea = completeArea;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public HysteresisDO.HysteresisDOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public HysteresisDO.HysteresisDOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public HysteresisDO.HysteresisDOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public HysteresisDO.HysteresisDOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("project")
      public HysteresisDO.HysteresisDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public HysteresisDO.HysteresisDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("areaDetail")
      public HysteresisDO.HysteresisDOBuilder areaDetail(final AreaDetailDO areaDetail) {
         this.areaDetail = areaDetail;
         return this;
      }

      @JsonProperty("factory")
      public HysteresisDO.HysteresisDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public HysteresisDO.HysteresisDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public HysteresisDO.HysteresisDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("name")
      public HysteresisDO.HysteresisDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public HysteresisDO.HysteresisDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("plate")
      public HysteresisDO.HysteresisDOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public HysteresisDO.HysteresisDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("specification")
      public HysteresisDO.HysteresisDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public HysteresisDO.HysteresisDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public HysteresisDO build() {
         return new HysteresisDO(
            this.askCompleteTime,
            this.dateTime,
            this.taskQuantity,
            this.completeQuantity,
            this.taskLength,
            this.taskArea,
            this.completeLength,
            this.completeArea,
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
            this.plate,
            this.color,
            this.specification,
            this.material
         );
      }

      @Override
      public String toString() {
         return "HysteresisDO.HysteresisDOBuilder(askCompleteTime="
            + this.askCompleteTime
            + ", dateTime="
            + this.dateTime
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", taskLength="
            + this.taskLength
            + ", taskArea="
            + this.taskArea
            + ", completeLength="
            + this.completeLength
            + ", completeArea="
            + this.completeArea
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
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ")";
      }
   }
}
