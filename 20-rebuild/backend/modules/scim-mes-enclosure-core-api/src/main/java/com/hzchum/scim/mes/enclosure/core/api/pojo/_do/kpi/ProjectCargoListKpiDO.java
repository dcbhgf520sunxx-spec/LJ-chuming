package com.hzchum.scim.mes.enclosure.core.api.pojo._do.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectCargoListKpiDTO", description = "项目年度发运信息")
public class ProjectCargoListKpiDO {
   @ApiModelProperty(name = "project", notes = "项目信息", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "totalNetWeight", notes = "清单量", value = "清单量")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "cargoAmount", notes = "出库量", value = "出库量")
   @JsonProperty("cargoAmount")
   @JSONField(name = "cargoAmount")
   private BigDecimal cargoAmount;
   @ApiModelProperty(name = "inWarehousingAmount", notes = "入库量", value = "入库量")
   @JsonProperty("inWarehousingAmount")
   @JSONField(name = "inWarehousingAmount")
   private BigDecimal inWarehousingAmount;
   @ApiModelProperty(name = "stock", notes = "库存", value = "库存")
   @JsonProperty("stock")
   @JSONField(name = "stock")
   private BigDecimal stock;
   @ApiModelProperty(name = "cargoQuantity", notes = "发运车次", value = "发运车次")
   @JsonProperty("cargoQuantity")
   @JSONField(name = "cargoQuantity")
   private Integer cargoQuantity;

   public static ProjectCargoListKpiDO.ProjectCargoListKpiDOBuilder builder() {
      return new ProjectCargoListKpiDO.ProjectCargoListKpiDOBuilder();
   }

   public ProjectCargoListKpiDO(
      final ProjectDetailDO project,
      final BigDecimal totalNetWeight,
      final BigDecimal cargoAmount,
      final BigDecimal inWarehousingAmount,
      final BigDecimal stock,
      final Integer cargoQuantity
   ) {
      this.project = project;
      this.totalNetWeight = totalNetWeight;
      this.cargoAmount = cargoAmount;
      this.inWarehousingAmount = inWarehousingAmount;
      this.stock = stock;
      this.cargoQuantity = cargoQuantity;
   }

   public ProjectCargoListKpiDO() {
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getCargoAmount() {
      return this.cargoAmount;
   }

   public BigDecimal getInWarehousingAmount() {
      return this.inWarehousingAmount;
   }

   public BigDecimal getStock() {
      return this.stock;
   }

   public Integer getCargoQuantity() {
      return this.cargoQuantity;
   }

   @JsonProperty("project")
   public ProjectCargoListKpiDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ProjectCargoListKpiDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("cargoAmount")
   public ProjectCargoListKpiDO setCargoAmount(final BigDecimal cargoAmount) {
      this.cargoAmount = cargoAmount;
      return this;
   }

   @JsonProperty("inWarehousingAmount")
   public ProjectCargoListKpiDO setInWarehousingAmount(final BigDecimal inWarehousingAmount) {
      this.inWarehousingAmount = inWarehousingAmount;
      return this;
   }

   @JsonProperty("stock")
   public ProjectCargoListKpiDO setStock(final BigDecimal stock) {
      this.stock = stock;
      return this;
   }

   @JsonProperty("cargoQuantity")
   public ProjectCargoListKpiDO setCargoQuantity(final Integer cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectCargoListKpiDO(project="
         + this.getProject()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", cargoAmount="
         + this.getCargoAmount()
         + ", inWarehousingAmount="
         + this.getInWarehousingAmount()
         + ", stock="
         + this.getStock()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCargoListKpiDO)) {
         return false;
      }

      ProjectCargoListKpiDO other = (ProjectCargoListKpiDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$cargoQuantity = this.getCargoQuantity();
      Object other$cargoQuantity = other.getCargoQuantity();
      if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$totalNetWeight = this.getTotalNetWeight();
            Object other$totalNetWeight = other.getTotalNetWeight();
            if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
               Object this$cargoAmount = this.getCargoAmount();
               Object other$cargoAmount = other.getCargoAmount();
               if (this$cargoAmount == null ? other$cargoAmount == null : this$cargoAmount.equals(other$cargoAmount)) {
                  Object this$inWarehousingAmount = this.getInWarehousingAmount();
                  Object other$inWarehousingAmount = other.getInWarehousingAmount();
                  if (this$inWarehousingAmount == null ? other$inWarehousingAmount == null : this$inWarehousingAmount.equals(other$inWarehousingAmount)) {
                     Object this$stock = this.getStock();
                     Object other$stock = other.getStock();
                     return this$stock == null ? other$stock == null : this$stock.equals(other$stock);
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
      return other instanceof ProjectCargoListKpiDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $cargoAmount = this.getCargoAmount();
      result = result * 59 + ($cargoAmount == null ? 43 : $cargoAmount.hashCode());
      Object $inWarehousingAmount = this.getInWarehousingAmount();
      result = result * 59 + ($inWarehousingAmount == null ? 43 : $inWarehousingAmount.hashCode());
      Object $stock = this.getStock();
      return result * 59 + ($stock == null ? 43 : $stock.hashCode());
   }

   public static class ProjectCargoListKpiDOBuilder {
      private ProjectDetailDO project;
      private BigDecimal totalNetWeight;
      private BigDecimal cargoAmount;
      private BigDecimal inWarehousingAmount;
      private BigDecimal stock;
      private Integer cargoQuantity;

      ProjectCargoListKpiDOBuilder() {
      }

      @JsonProperty("project")
      public ProjectCargoListKpiDO.ProjectCargoListKpiDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ProjectCargoListKpiDO.ProjectCargoListKpiDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("cargoAmount")
      public ProjectCargoListKpiDO.ProjectCargoListKpiDOBuilder cargoAmount(final BigDecimal cargoAmount) {
         this.cargoAmount = cargoAmount;
         return this;
      }

      @JsonProperty("inWarehousingAmount")
      public ProjectCargoListKpiDO.ProjectCargoListKpiDOBuilder inWarehousingAmount(final BigDecimal inWarehousingAmount) {
         this.inWarehousingAmount = inWarehousingAmount;
         return this;
      }

      @JsonProperty("stock")
      public ProjectCargoListKpiDO.ProjectCargoListKpiDOBuilder stock(final BigDecimal stock) {
         this.stock = stock;
         return this;
      }

      @JsonProperty("cargoQuantity")
      public ProjectCargoListKpiDO.ProjectCargoListKpiDOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      public ProjectCargoListKpiDO build() {
         return new ProjectCargoListKpiDO(this.project, this.totalNetWeight, this.cargoAmount, this.inWarehousingAmount, this.stock, this.cargoQuantity);
      }

      @Override
      public String toString() {
         return "ProjectCargoListKpiDO.ProjectCargoListKpiDOBuilder(project="
            + this.project
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", cargoAmount="
            + this.cargoAmount
            + ", inWarehousingAmount="
            + this.inWarehousingAmount
            + ", stock="
            + this.stock
            + ", cargoQuantity="
            + this.cargoQuantity
            + ")";
      }
   }
}
