package com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "OutStaffSummaryDO", description = "")
public class OutStaffDetailsDO {
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成重量")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务净重")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskLength", notes = "任务长度")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private BigDecimal taskLength;
   @ApiModelProperty(name = "completeLength", notes = "完成长度")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;
   @ApiModelProperty(name = "completeGrossWeight", notes = "完成毛重")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务毛重")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(name = "mate", notes = "核算量")
   @JsonProperty("mate")
   @JSONField(name = "mate")
   private BigDecimal mate;
   @ApiModelProperty(name = "price", notes = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "wage", notes = "工价")
   @JsonProperty("wage")
   @JSONField(name = "wage")
   private BigDecimal wage;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;

   public static OutStaffDetailsDO.OutStaffDetailsDOBuilder builder() {
      return new OutStaffDetailsDO.OutStaffDetailsDOBuilder();
   }

   public OutStaffDetailsDO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final Integer completeQuantity,
      final Integer taskQuantity,
      final BigDecimal completeNetWeight,
      final BigDecimal taskNetWeight,
      final BigDecimal taskLength,
      final BigDecimal completeLength,
      final BigDecimal completeGrossWeight,
      final BigDecimal taskGrossWeight,
      final BigDecimal mate,
      final BigDecimal price,
      final String serialNumber,
      final BigDecimal wage,
      final Integer wageQuotaType,
      final String name,
      final String specification
   ) {
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.completeQuantity = completeQuantity;
      this.taskQuantity = taskQuantity;
      this.completeNetWeight = completeNetWeight;
      this.taskNetWeight = taskNetWeight;
      this.taskLength = taskLength;
      this.completeLength = completeLength;
      this.completeGrossWeight = completeGrossWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.mate = mate;
      this.price = price;
      this.serialNumber = serialNumber;
      this.wage = wage;
      this.wageQuotaType = wageQuotaType;
      this.name = name;
      this.specification = specification;
   }

   public OutStaffDetailsDO() {
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

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public BigDecimal getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public BigDecimal getMate() {
      return this.mate;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   @JsonProperty("project")
   public OutStaffDetailsDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public OutStaffDetailsDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public OutStaffDetailsDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("completeQuantity")
   public OutStaffDetailsDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public OutStaffDetailsDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public OutStaffDetailsDO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public OutStaffDetailsDO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskLength")
   public OutStaffDetailsDO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("completeLength")
   public OutStaffDetailsDO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public OutStaffDetailsDO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public OutStaffDetailsDO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("mate")
   public OutStaffDetailsDO setMate(final BigDecimal mate) {
      this.mate = mate;
      return this;
   }

   @JsonProperty("price")
   public OutStaffDetailsDO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("serialNumber")
   public OutStaffDetailsDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("wage")
   public OutStaffDetailsDO setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public OutStaffDetailsDO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("name")
   public OutStaffDetailsDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("specification")
   public OutStaffDetailsDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @Override
   public String toString() {
      return "OutStaffDetailsDO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskLength="
         + this.getTaskLength()
         + ", completeLength="
         + this.getCompleteLength()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", mate="
         + this.getMate()
         + ", price="
         + this.getPrice()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", wage="
         + this.getWage()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutStaffDetailsDO)) {
         return false;
      }

      OutStaffDetailsDO other = (OutStaffDetailsDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$completeQuantity = this.getCompleteQuantity();
      Object other$completeQuantity = other.getCompleteQuantity();
      if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$wageQuotaType = this.getWageQuotaType();
            Object other$wageQuotaType = other.getWageQuotaType();
            if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$monomer = this.getMonomer();
                  Object other$monomer = other.getMonomer();
                  if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                     Object this$area = this.getArea();
                     Object other$area = other.getArea();
                     if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                        Object this$completeNetWeight = this.getCompleteNetWeight();
                        Object other$completeNetWeight = other.getCompleteNetWeight();
                        if (this$completeNetWeight == null ? other$completeNetWeight == null : this$completeNetWeight.equals(other$completeNetWeight)) {
                           Object this$taskNetWeight = this.getTaskNetWeight();
                           Object other$taskNetWeight = other.getTaskNetWeight();
                           if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                              Object this$taskLength = this.getTaskLength();
                              Object other$taskLength = other.getTaskLength();
                              if (this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength)) {
                                 Object this$completeLength = this.getCompleteLength();
                                 Object other$completeLength = other.getCompleteLength();
                                 if (this$completeLength == null ? other$completeLength == null : this$completeLength.equals(other$completeLength)) {
                                    Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                    Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                    if (this$completeGrossWeight == null
                                       ? other$completeGrossWeight == null
                                       : this$completeGrossWeight.equals(other$completeGrossWeight)) {
                                       Object this$taskGrossWeight = this.getTaskGrossWeight();
                                       Object other$taskGrossWeight = other.getTaskGrossWeight();
                                       if (this$taskGrossWeight == null ? other$taskGrossWeight == null : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                                          Object this$mate = this.getMate();
                                          Object other$mate = other.getMate();
                                          if (this$mate == null ? other$mate == null : this$mate.equals(other$mate)) {
                                             Object this$price = this.getPrice();
                                             Object other$price = other.getPrice();
                                             if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$wage = this.getWage();
                                                   Object other$wage = other.getWage();
                                                   if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                                                      Object this$name = this.getName();
                                                      Object other$name = other.getName();
                                                      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                         Object this$specification = this.getSpecification();
                                                         Object other$specification = other.getSpecification();
                                                         return this$specification == null
                                                            ? other$specification == null
                                                            : this$specification.equals(other$specification);
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
      return other instanceof OutStaffDetailsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $mate = this.getMate();
      result = result * 59 + ($mate == null ? 43 : $mate.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      return result * 59 + ($specification == null ? 43 : $specification.hashCode());
   }

   public static class OutStaffDetailsDOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private Integer completeQuantity;
      private Integer taskQuantity;
      private BigDecimal completeNetWeight;
      private BigDecimal taskNetWeight;
      private BigDecimal taskLength;
      private BigDecimal completeLength;
      private BigDecimal completeGrossWeight;
      private BigDecimal taskGrossWeight;
      private BigDecimal mate;
      private BigDecimal price;
      private String serialNumber;
      private BigDecimal wage;
      private Integer wageQuotaType;
      private String name;
      private String specification;

      OutStaffDetailsDOBuilder() {
      }

      @JsonProperty("project")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("completeQuantity")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskLength")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("completeLength")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("mate")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder mate(final BigDecimal mate) {
         this.mate = mate;
         return this;
      }

      @JsonProperty("price")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("serialNumber")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("wage")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("name")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("specification")
      public OutStaffDetailsDO.OutStaffDetailsDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public OutStaffDetailsDO build() {
         return new OutStaffDetailsDO(
            this.project,
            this.monomer,
            this.area,
            this.completeQuantity,
            this.taskQuantity,
            this.completeNetWeight,
            this.taskNetWeight,
            this.taskLength,
            this.completeLength,
            this.completeGrossWeight,
            this.taskGrossWeight,
            this.mate,
            this.price,
            this.serialNumber,
            this.wage,
            this.wageQuotaType,
            this.name,
            this.specification
         );
      }

      @Override
      public String toString() {
         return "OutStaffDetailsDO.OutStaffDetailsDOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", completeQuantity="
            + this.completeQuantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskLength="
            + this.taskLength
            + ", completeLength="
            + this.completeLength
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", mate="
            + this.mate
            + ", price="
            + this.price
            + ", serialNumber="
            + this.serialNumber
            + ", wage="
            + this.wage
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ")";
      }
   }
}
