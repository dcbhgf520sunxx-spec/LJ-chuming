package com.hzchum.scim.mes.enclosure.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
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
import java.time.LocalDateTime;
import javax.persistence.Column;

@ApiModel(value = "AreaSchedulingDO", description = "项目排期信息 ")
public class AreaSchedulingDO {
   @ApiModelProperty(name = "project", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体信息")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", value = "区域信息")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "factory", value = "工厂信息")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "workshop", value = "车间信息")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "生产线信息")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "startDate", value = "开始时间", notes = "开始时间")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   @TableField("start_date")
   @Column(name = "start_date", columnDefinition = "datetime  COMMENT '开始时间'", nullable = false)
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "结束时间", notes = "结束时间")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   @TableField("end_date")
   @Column(name = "end_date", columnDefinition = "datetime  COMMENT '结束时间'", nullable = false)
   private LocalDateTime endDate;
   @ApiModelProperty(name = "quantity", notes = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", notes = "清单量")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "closingDate", notes = "截止日期")
   @JsonProperty("closingDate")
   @JSONField(name = "closingDate")
   private LocalDateTime closingDate;
   @ApiModelProperty(name = "constructionDay", notes = "工期")
   @JsonProperty("constructionDay")
   @JSONField(name = "constructionDay")
   private Integer constructionDay;

   public static AreaSchedulingDO.AreaSchedulingDOBuilder builder() {
      return new AreaSchedulingDO.AreaSchedulingDOBuilder();
   }

   public AreaSchedulingDO() {
   }

   public AreaSchedulingDO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final LocalDateTime closingDate,
      final Integer constructionDay
   ) {
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.startDate = startDate;
      this.endDate = endDate;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.closingDate = closingDate;
      this.constructionDay = constructionDay;
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

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public LocalDateTime getClosingDate() {
      return this.closingDate;
   }

   public Integer getConstructionDay() {
      return this.constructionDay;
   }

   @JsonProperty("project")
   public AreaSchedulingDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public AreaSchedulingDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public AreaSchedulingDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("factory")
   public AreaSchedulingDO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public AreaSchedulingDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public AreaSchedulingDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("startDate")
   public AreaSchedulingDO setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public AreaSchedulingDO setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @JsonProperty("quantity")
   public AreaSchedulingDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public AreaSchedulingDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("closingDate")
   public AreaSchedulingDO setClosingDate(final LocalDateTime closingDate) {
      this.closingDate = closingDate;
      return this;
   }

   @JsonProperty("constructionDay")
   public AreaSchedulingDO setConstructionDay(final Integer constructionDay) {
      this.constructionDay = constructionDay;
      return this;
   }

   @Override
   public String toString() {
      return "AreaSchedulingDO(project="
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
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", closingDate="
         + this.getClosingDate()
         + ", constructionDay="
         + this.getConstructionDay()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AreaSchedulingDO)) {
         return false;
      }

      AreaSchedulingDO other = (AreaSchedulingDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$constructionDay = this.getConstructionDay();
         Object other$constructionDay = other.getConstructionDay();
         if (this$constructionDay == null ? other$constructionDay == null : this$constructionDay.equals(other$constructionDay)) {
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
                              Object this$startDate = this.getStartDate();
                              Object other$startDate = other.getStartDate();
                              if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                 Object this$endDate = this.getEndDate();
                                 Object other$endDate = other.getEndDate();
                                 if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                    Object this$totalNetWeight = this.getTotalNetWeight();
                                    Object other$totalNetWeight = other.getTotalNetWeight();
                                    if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                       Object this$closingDate = this.getClosingDate();
                                       Object other$closingDate = other.getClosingDate();
                                       return this$closingDate == null ? other$closingDate == null : this$closingDate.equals(other$closingDate);
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
      return other instanceof AreaSchedulingDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $constructionDay = this.getConstructionDay();
      result = result * 59 + ($constructionDay == null ? 43 : $constructionDay.hashCode());
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
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $closingDate = this.getClosingDate();
      return result * 59 + ($closingDate == null ? 43 : $closingDate.hashCode());
   }

   public static class AreaSchedulingDOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private LocalDateTime closingDate;
      private Integer constructionDay;

      AreaSchedulingDOBuilder() {
      }

      @JsonProperty("project")
      public AreaSchedulingDO.AreaSchedulingDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public AreaSchedulingDO.AreaSchedulingDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public AreaSchedulingDO.AreaSchedulingDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("factory")
      public AreaSchedulingDO.AreaSchedulingDOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public AreaSchedulingDO.AreaSchedulingDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public AreaSchedulingDO.AreaSchedulingDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("startDate")
      public AreaSchedulingDO.AreaSchedulingDOBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public AreaSchedulingDO.AreaSchedulingDOBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      @JsonProperty("quantity")
      public AreaSchedulingDO.AreaSchedulingDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public AreaSchedulingDO.AreaSchedulingDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("closingDate")
      public AreaSchedulingDO.AreaSchedulingDOBuilder closingDate(final LocalDateTime closingDate) {
         this.closingDate = closingDate;
         return this;
      }

      @JsonProperty("constructionDay")
      public AreaSchedulingDO.AreaSchedulingDOBuilder constructionDay(final Integer constructionDay) {
         this.constructionDay = constructionDay;
         return this;
      }

      public AreaSchedulingDO build() {
         return new AreaSchedulingDO(
            this.project,
            this.monomer,
            this.area,
            this.factory,
            this.workshop,
            this.productionLine,
            this.startDate,
            this.endDate,
            this.quantity,
            this.totalNetWeight,
            this.closingDate,
            this.constructionDay
         );
      }

      @Override
      public String toString() {
         return "AreaSchedulingDO.AreaSchedulingDOBuilder(project="
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
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", closingDate="
            + this.closingDate
            + ", constructionDay="
            + this.constructionDay
            + ")";
      }
   }
}
