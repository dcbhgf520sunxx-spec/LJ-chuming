package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "TaskTrackingProductionLineDO", description = "")
public class TaskTrackingProductionLineDO {
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
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
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "单体列表")
   private List<MonomerDetailDO> monomerDO;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "区域列表")
   private List<AreaDetailDO> areaDO;

   public static TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder builder() {
      return new TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder();
   }

   public TaskTrackingProductionLineDO() {
   }

   public TaskTrackingProductionLineDO(
      final ProjectDetailDO project,
      final Integer month,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final Integer completeQuantity,
      final BigDecimal completeNetWeight,
      final BigDecimal completeGrossWeight,
      final BigDecimal rate,
      final List<MonomerDetailDO> monomerDO,
      final List<AreaDetailDO> areaDO
   ) {
      this.project = project;
      this.month = month;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.completeQuantity = completeQuantity;
      this.completeNetWeight = completeNetWeight;
      this.completeGrossWeight = completeGrossWeight;
      this.rate = rate;
      this.monomerDO = monomerDO;
      this.areaDO = areaDO;
   }

   public ProjectDetailDO getProject() {
      return this.project;
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

   public List<MonomerDetailDO> getMonomerDO() {
      return this.monomerDO;
   }

   public List<AreaDetailDO> getAreaDO() {
      return this.areaDO;
   }

   @JsonProperty("project")
   public TaskTrackingProductionLineDO setProject(final ProjectDetailDO project) {
      this.project = project;
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

   public TaskTrackingProductionLineDO setMonomerDO(final List<MonomerDetailDO> monomerDO) {
      this.monomerDO = monomerDO;
      return this;
   }

   public TaskTrackingProductionLineDO setAreaDO(final List<AreaDetailDO> areaDO) {
      this.areaDO = areaDO;
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
                              if (this$rate == null ? other$rate == null : this$rate.equals(other$rate)) {
                                 Object this$monomerDO = this.getMonomerDO();
                                 Object other$monomerDO = other.getMonomerDO();
                                 if (this$monomerDO == null ? other$monomerDO == null : this$monomerDO.equals(other$monomerDO)) {
                                    Object this$areaDO = this.getAreaDO();
                                    Object other$areaDO = other.getAreaDO();
                                    return this$areaDO == null ? other$areaDO == null : this$areaDO.equals(other$areaDO);
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
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $rate = this.getRate();
      result = result * 59 + ($rate == null ? 43 : $rate.hashCode());
      Object $monomerDO = this.getMonomerDO();
      result = result * 59 + ($monomerDO == null ? 43 : $monomerDO.hashCode());
      Object $areaDO = this.getAreaDO();
      return result * 59 + ($areaDO == null ? 43 : $areaDO.hashCode());
   }

   @Override
   public String toString() {
      return "TaskTrackingProductionLineDO(project="
         + this.getProject()
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
         + ", monomerDO="
         + this.getMonomerDO()
         + ", areaDO="
         + this.getAreaDO()
         + ")";
   }

   public static class TaskTrackingProductionLineDOBuilder {
      private ProjectDetailDO project;
      private Integer month;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Integer completeQuantity;
      private BigDecimal completeNetWeight;
      private BigDecimal completeGrossWeight;
      private BigDecimal rate;
      private List<MonomerDetailDO> monomerDO;
      private List<AreaDetailDO> areaDO;

      TaskTrackingProductionLineDOBuilder() {
      }

      @JsonProperty("project")
      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
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

      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder monomerDO(final List<MonomerDetailDO> monomerDO) {
         this.monomerDO = monomerDO;
         return this;
      }

      public TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder areaDO(final List<AreaDetailDO> areaDO) {
         this.areaDO = areaDO;
         return this;
      }

      public TaskTrackingProductionLineDO build() {
         return new TaskTrackingProductionLineDO(
            this.project,
            this.month,
            this.quantity,
            this.netWeight,
            this.grossWeight,
            this.completeQuantity,
            this.completeNetWeight,
            this.completeGrossWeight,
            this.rate,
            this.monomerDO,
            this.areaDO
         );
      }

      @Override
      public String toString() {
         return "TaskTrackingProductionLineDO.TaskTrackingProductionLineDOBuilder(project="
            + this.project
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
            + ", monomerDO="
            + this.monomerDO
            + ", areaDO="
            + this.areaDO
            + ")";
      }
   }
}
