package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TaskTrackingProductionLineDO", description = "")
public class TaskTrackingProductionLineDO {
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
   @ApiModelProperty(name = "month", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private Integer month;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeNetWeight", notes = "已完成重量(净重)")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "completeGrossWeight", notes = "已完成重量(毛重)")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "rate", notes = "达成率")
   @JsonProperty("rate")
   @JSONField(name = "rate")
   private BigDecimal rate;

   public static TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder builder() {
      return new TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder();
   }

   public TaskTrackingProductionLineDO() {
   }

   public TaskTrackingProductionLineDO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final Integer month,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final Integer completeQuantity,
      final BigDecimal completeNetWeight,
      final BigDecimal completeGrossWeight,
      final BigDecimal rate
   ) {
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.month = month;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.completeQuantity = completeQuantity;
      this.completeNetWeight = completeNetWeight;
      this.completeGrossWeight = completeGrossWeight;
      this.rate = rate;
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

   public Integer getMonth() {
      return this.month;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   @JsonProperty("project")
   public TaskTrackingProductionLineDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public TaskTrackingProductionLineDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public TaskTrackingProductionLineDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("month")
   public TaskTrackingProductionLineDO setMonth(final Integer month) {
      this.month = month;
      return this;
   }

   @JsonProperty("quantity")
   public TaskTrackingProductionLineDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public TaskTrackingProductionLineDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public TaskTrackingProductionLineDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TaskTrackingProductionLineDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public TaskTrackingProductionLineDO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public TaskTrackingProductionLineDO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("rate")
   public TaskTrackingProductionLineDO setRate(final BigDecimal rate) {
      this.rate = rate;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskTrackingProductionLineDO)) {
         return false;
      }

      TaskTrackingProductionLineDO other = (TaskTrackingProductionLineDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$monomer = this.getMonomer();
                  Object other$monomer = other.getMonomer();
                  if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                     Object this$area = this.getArea();
                     Object other$area = other.getArea();
                     if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                        Object this$netWeight = this.getNetWeight();
                        Object other$netWeight = other.getNetWeight();
                        if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                           Object this$grossWeight = this.getGrossWeight();
                           Object other$grossWeight = other.getGrossWeight();
                           if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                              Object this$completeNetWeight = this.getCompleteNetWeight();
                              Object other$completeNetWeight = other.getCompleteNetWeight();
                              if (this$completeNetWeight == null ? other$completeNetWeight == null : this$completeNetWeight.equals(other$completeNetWeight)) {
                                 Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                 Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                 if (this$completeGrossWeight == null
                                    ? other$completeGrossWeight == null
                                    : this$completeGrossWeight.equals(other$completeGrossWeight)) {
                                    Object this$rate = this.getRate();
                                    Object other$rate = other.getRate();
                                    return this$rate == null ? other$rate == null : this$rate.equals(other$rate);
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
      return other instanceof TaskTrackingProductionLineDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $rate = this.getRate();
      return result * 59 + ($rate == null ? 43 : $rate.hashCode());
   }

   @Override
   public String toString() {
      return "TaskTrackingProductionLineDO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", month="
         + this.getMonth()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", rate="
         + this.getRate()
         + ")";
   }

   public static class TaskTrackingProductionLineDOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private Integer month;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Integer completeQuantity;
      private BigDecimal completeNetWeight;
      private BigDecimal completeGrossWeight;
      private BigDecimal rate;

      TaskTrackingProductionLineDOBuilder() {
      }

      @JsonProperty("project")
      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("month")
      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      @JsonProperty("quantity")
      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("rate")
      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder rate(final BigDecimal rate) {
         this.rate = rate;
         return this;
      }

      public TaskTrackingProductionLineDO build() {
         return new TaskTrackingProductionLineDO(
            this.project,
            this.monomer,
            this.area,
            this.month,
            this.quantity,
            this.netWeight,
            this.grossWeight,
            this.completeQuantity,
            this.completeNetWeight,
            this.completeGrossWeight,
            this.rate
         );
      }

      @Override
      public String toString() {
         return "TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", month="
            + this.month
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", rate="
            + this.rate
            + ")";
      }
   }
}
