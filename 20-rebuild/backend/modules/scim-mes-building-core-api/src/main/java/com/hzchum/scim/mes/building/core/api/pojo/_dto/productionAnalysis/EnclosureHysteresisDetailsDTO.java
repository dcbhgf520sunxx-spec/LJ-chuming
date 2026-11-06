package com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis;

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

@ApiModel(value = "HysteresisVORequest", description = "围护迟滞返回类")
public class EnclosureHysteresisDetailsDTO {
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

   public static EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder builder() {
      return new EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder();
   }

   public EnclosureHysteresisDetailsDTO() {
   }

   public EnclosureHysteresisDetailsDTO(
      final LocalDateTime askCompleteTime,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final BigDecimal taskLength,
      final BigDecimal taskArea,
      final BigDecimal completeLength,
      final BigDecimal completeArea,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO areaDetail,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final String name,
      final String serialNumber,
      final String plate,
      final String color
   ) {
      this.askCompleteTime = askCompleteTime;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.taskLength = taskLength;
      this.taskArea = taskArea;
      this.completeLength = completeLength;
      this.completeArea = completeArea;
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

   @JsonProperty("askCompleteTime")
   public EnclosureHysteresisDetailsDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("taskQuantity")
   public EnclosureHysteresisDetailsDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public EnclosureHysteresisDetailsDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("taskLength")
   public EnclosureHysteresisDetailsDTO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("taskArea")
   public EnclosureHysteresisDetailsDTO setTaskArea(final BigDecimal taskArea) {
      this.taskArea = taskArea;
      return this;
   }

   @JsonProperty("completeLength")
   public EnclosureHysteresisDetailsDTO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("completeArea")
   public EnclosureHysteresisDetailsDTO setCompleteArea(final BigDecimal completeArea) {
      this.completeArea = completeArea;
      return this;
   }

   @JsonProperty("project")
   public EnclosureHysteresisDetailsDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public EnclosureHysteresisDetailsDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("areaDetail")
   public EnclosureHysteresisDetailsDTO setAreaDetail(final AreaDetailDO areaDetail) {
      this.areaDetail = areaDetail;
      return this;
   }

   @JsonProperty("factory")
   public EnclosureHysteresisDetailsDTO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public EnclosureHysteresisDetailsDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public EnclosureHysteresisDetailsDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("name")
   public EnclosureHysteresisDetailsDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public EnclosureHysteresisDetailsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("plate")
   public EnclosureHysteresisDetailsDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public EnclosureHysteresisDetailsDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @Override
   public String toString() {
      return "EnclosureHysteresisDetailsDTO(askCompleteTime="
         + this.getAskCompleteTime()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureHysteresisDetailsDTO)) {
         return false;
      }

      EnclosureHysteresisDetailsDTO other = (EnclosureHysteresisDetailsDTO)o;
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
                                                   Object this$plate = this.getPlate();
                                                   Object other$plate = other.getPlate();
                                                   if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                                      Object this$color = this.getColor();
                                                      Object other$color = other.getColor();
                                                      return this$color == null ? other$color == null : this$color.equals(other$color);
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
      return other instanceof EnclosureHysteresisDetailsDTO;
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
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $taskArea = this.getTaskArea();
      result = result * 59 + ($taskArea == null ? 43 : $taskArea.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $completeArea = this.getCompleteArea();
      result = result * 59 + ($completeArea == null ? 43 : $completeArea.hashCode());
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
      return result * 59 + ($color == null ? 43 : $color.hashCode());
   }

   public static class EnclosureHysteresisDetailsDTOBuilder {
      private LocalDateTime askCompleteTime;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private BigDecimal taskLength;
      private BigDecimal taskArea;
      private BigDecimal completeLength;
      private BigDecimal completeArea;
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

      EnclosureHysteresisDetailsDTOBuilder() {
      }

      @JsonProperty("askCompleteTime")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("taskQuantity")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("taskLength")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("taskArea")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder taskArea(final BigDecimal taskArea) {
         this.taskArea = taskArea;
         return this;
      }

      @JsonProperty("completeLength")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("completeArea")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder completeArea(final BigDecimal completeArea) {
         this.completeArea = completeArea;
         return this;
      }

      @JsonProperty("project")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("areaDetail")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder areaDetail(final AreaDetailDO areaDetail) {
         this.areaDetail = areaDetail;
         return this;
      }

      @JsonProperty("factory")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("name")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("plate")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public EnclosureHysteresisDetailsDTO build() {
         return new EnclosureHysteresisDetailsDTO(
            this.askCompleteTime,
            this.taskQuantity,
            this.completeQuantity,
            this.taskLength,
            this.taskArea,
            this.completeLength,
            this.completeArea,
            this.project,
            this.monomer,
            this.areaDetail,
            this.factory,
            this.workshop,
            this.productionLine,
            this.name,
            this.serialNumber,
            this.plate,
            this.color
         );
      }

      @Override
      public String toString() {
         return "EnclosureHysteresisDetailsDTO.EnclosureHysteresisDetailsDTOBuilder(askCompleteTime="
            + this.askCompleteTime
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
            + ")";
      }
   }
}
