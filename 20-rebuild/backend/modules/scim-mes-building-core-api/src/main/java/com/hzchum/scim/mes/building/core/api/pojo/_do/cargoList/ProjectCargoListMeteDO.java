package com.hzchum.scim.mes.building.core.api.pojo._do.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运量")
public class ProjectCargoListMeteDO {
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "quantity", value = "清单数量", notes = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "mete", value = "清单净重量", notes = "清单净重量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "grossMete", value = "清单毛重量", notes = "清单毛重量")
   @JsonProperty("grossMete")
   @JSONField(name = "grossMete")
   private BigDecimal grossMete;
   @ApiModelProperty(name = "warehouseQuantity", value = "入库数量", notes = "入库数量")
   private Integer warehouseQuantity;
   @ApiModelProperty(name = "warehouseMete", value = "入库净重量", notes = "入库净重量")
   private BigDecimal warehouseMete;
   @ApiModelProperty(name = "warehouseGrossMete", value = "入库毛重量", notes = "入库毛重量")
   private BigDecimal warehouseGrossMete;
   @ApiModelProperty(name = "sendQuantity", value = "发运数量", notes = "发运数量")
   @JsonProperty("sendQuantity")
   @JSONField(name = "sendQuantity")
   private Integer sendQuantity;
   @ApiModelProperty(name = "sendMete", value = "发运净重量", notes = "发运重量")
   @JsonProperty("sendMete")
   @JSONField(name = "sendMete")
   private BigDecimal sendMete;
   @ApiModelProperty(name = "sendGrossMete", value = "发运毛重量", notes = "发运毛重量")
   @JsonProperty("sendGrossMete")
   @JSONField(name = "sendGrossMete")
   private BigDecimal sendGrossMete;
   @ApiModelProperty(name = "ratio", value = "净重比率", notes = "净重比率")
   @JsonProperty("ratio")
   @JSONField(name = "ratio")
   private BigDecimal ratio;

   public static ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder builder() {
      return new ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder();
   }

   public ProjectCargoListMeteDO(
      final ProjectDetailDO project,
      final Integer quantity,
      final BigDecimal mete,
      final BigDecimal grossMete,
      final Integer warehouseQuantity,
      final BigDecimal warehouseMete,
      final BigDecimal warehouseGrossMete,
      final Integer sendQuantity,
      final BigDecimal sendMete,
      final BigDecimal sendGrossMete,
      final BigDecimal ratio
   ) {
      this.project = project;
      this.quantity = quantity;
      this.mete = mete;
      this.grossMete = grossMete;
      this.warehouseQuantity = warehouseQuantity;
      this.warehouseMete = warehouseMete;
      this.warehouseGrossMete = warehouseGrossMete;
      this.sendQuantity = sendQuantity;
      this.sendMete = sendMete;
      this.sendGrossMete = sendGrossMete;
      this.ratio = ratio;
   }

   public ProjectCargoListMeteDO() {
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getGrossMete() {
      return this.grossMete;
   }

   public Integer getWarehouseQuantity() {
      return this.warehouseQuantity;
   }

   public BigDecimal getWarehouseMete() {
      return this.warehouseMete;
   }

   public BigDecimal getWarehouseGrossMete() {
      return this.warehouseGrossMete;
   }

   public Integer getSendQuantity() {
      return this.sendQuantity;
   }

   public BigDecimal getSendMete() {
      return this.sendMete;
   }

   public BigDecimal getSendGrossMete() {
      return this.sendGrossMete;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   @JsonProperty("project")
   public void setProject(final ProjectDetailDO project) {
      this.project = project;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("grossMete")
   public void setGrossMete(final BigDecimal grossMete) {
      this.grossMete = grossMete;
   }

   public void setWarehouseQuantity(final Integer warehouseQuantity) {
      this.warehouseQuantity = warehouseQuantity;
   }

   public void setWarehouseMete(final BigDecimal warehouseMete) {
      this.warehouseMete = warehouseMete;
   }

   public void setWarehouseGrossMete(final BigDecimal warehouseGrossMete) {
      this.warehouseGrossMete = warehouseGrossMete;
   }

   @JsonProperty("sendQuantity")
   public void setSendQuantity(final Integer sendQuantity) {
      this.sendQuantity = sendQuantity;
   }

   @JsonProperty("sendMete")
   public void setSendMete(final BigDecimal sendMete) {
      this.sendMete = sendMete;
   }

   @JsonProperty("sendGrossMete")
   public void setSendGrossMete(final BigDecimal sendGrossMete) {
      this.sendGrossMete = sendGrossMete;
   }

   @JsonProperty("ratio")
   public void setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCargoListMeteDO)) {
         return false;
      }

      ProjectCargoListMeteDO other = (ProjectCargoListMeteDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$warehouseQuantity = this.getWarehouseQuantity();
         Object other$warehouseQuantity = other.getWarehouseQuantity();
         if (this$warehouseQuantity == null ? other$warehouseQuantity == null : this$warehouseQuantity.equals(other$warehouseQuantity)) {
            Object this$sendQuantity = this.getSendQuantity();
            Object other$sendQuantity = other.getSendQuantity();
            if (this$sendQuantity == null ? other$sendQuantity == null : this$sendQuantity.equals(other$sendQuantity)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$grossMete = this.getGrossMete();
                     Object other$grossMete = other.getGrossMete();
                     if (this$grossMete == null ? other$grossMete == null : this$grossMete.equals(other$grossMete)) {
                        Object this$warehouseMete = this.getWarehouseMete();
                        Object other$warehouseMete = other.getWarehouseMete();
                        if (this$warehouseMete == null ? other$warehouseMete == null : this$warehouseMete.equals(other$warehouseMete)) {
                           Object this$warehouseGrossMete = this.getWarehouseGrossMete();
                           Object other$warehouseGrossMete = other.getWarehouseGrossMete();
                           if (this$warehouseGrossMete == null ? other$warehouseGrossMete == null : this$warehouseGrossMete.equals(other$warehouseGrossMete)) {
                              Object this$sendMete = this.getSendMete();
                              Object other$sendMete = other.getSendMete();
                              if (this$sendMete == null ? other$sendMete == null : this$sendMete.equals(other$sendMete)) {
                                 Object this$sendGrossMete = this.getSendGrossMete();
                                 Object other$sendGrossMete = other.getSendGrossMete();
                                 if (this$sendGrossMete == null ? other$sendGrossMete == null : this$sendGrossMete.equals(other$sendGrossMete)) {
                                    Object this$ratio = this.getRatio();
                                    Object other$ratio = other.getRatio();
                                    return this$ratio == null ? other$ratio == null : this$ratio.equals(other$ratio);
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
      return other instanceof ProjectCargoListMeteDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $warehouseQuantity = this.getWarehouseQuantity();
      result = result * 59 + ($warehouseQuantity == null ? 43 : $warehouseQuantity.hashCode());
      Object $sendQuantity = this.getSendQuantity();
      result = result * 59 + ($sendQuantity == null ? 43 : $sendQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $grossMete = this.getGrossMete();
      result = result * 59 + ($grossMete == null ? 43 : $grossMete.hashCode());
      Object $warehouseMete = this.getWarehouseMete();
      result = result * 59 + ($warehouseMete == null ? 43 : $warehouseMete.hashCode());
      Object $warehouseGrossMete = this.getWarehouseGrossMete();
      result = result * 59 + ($warehouseGrossMete == null ? 43 : $warehouseGrossMete.hashCode());
      Object $sendMete = this.getSendMete();
      result = result * 59 + ($sendMete == null ? 43 : $sendMete.hashCode());
      Object $sendGrossMete = this.getSendGrossMete();
      result = result * 59 + ($sendGrossMete == null ? 43 : $sendGrossMete.hashCode());
      Object $ratio = this.getRatio();
      return result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCargoListMeteDO(project="
         + this.getProject()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", grossMete="
         + this.getGrossMete()
         + ", warehouseQuantity="
         + this.getWarehouseQuantity()
         + ", warehouseMete="
         + this.getWarehouseMete()
         + ", warehouseGrossMete="
         + this.getWarehouseGrossMete()
         + ", sendQuantity="
         + this.getSendQuantity()
         + ", sendMete="
         + this.getSendMete()
         + ", sendGrossMete="
         + this.getSendGrossMete()
         + ", ratio="
         + this.getRatio()
         + ")";
   }

   public static class ProjectCargoListMeteDOBuilder {
      private ProjectDetailDO project;
      private Integer quantity;
      private BigDecimal mete;
      private BigDecimal grossMete;
      private Integer warehouseQuantity;
      private BigDecimal warehouseMete;
      private BigDecimal warehouseGrossMete;
      private Integer sendQuantity;
      private BigDecimal sendMete;
      private BigDecimal sendGrossMete;
      private BigDecimal ratio;

      ProjectCargoListMeteDOBuilder() {
      }

      @JsonProperty("project")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("grossMete")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder grossMete(final BigDecimal grossMete) {
         this.grossMete = grossMete;
         return this;
      }

      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder warehouseQuantity(final Integer warehouseQuantity) {
         this.warehouseQuantity = warehouseQuantity;
         return this;
      }

      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder warehouseMete(final BigDecimal warehouseMete) {
         this.warehouseMete = warehouseMete;
         return this;
      }

      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder warehouseGrossMete(final BigDecimal warehouseGrossMete) {
         this.warehouseGrossMete = warehouseGrossMete;
         return this;
      }

      @JsonProperty("sendQuantity")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder sendQuantity(final Integer sendQuantity) {
         this.sendQuantity = sendQuantity;
         return this;
      }

      @JsonProperty("sendMete")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder sendMete(final BigDecimal sendMete) {
         this.sendMete = sendMete;
         return this;
      }

      @JsonProperty("sendGrossMete")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder sendGrossMete(final BigDecimal sendGrossMete) {
         this.sendGrossMete = sendGrossMete;
         return this;
      }

      @JsonProperty("ratio")
      public ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      public ProjectCargoListMeteDO build() {
         return new ProjectCargoListMeteDO(
            this.project,
            this.quantity,
            this.mete,
            this.grossMete,
            this.warehouseQuantity,
            this.warehouseMete,
            this.warehouseGrossMete,
            this.sendQuantity,
            this.sendMete,
            this.sendGrossMete,
            this.ratio
         );
      }

      @Override
      public String toString() {
         return "ProjectCargoListMeteDO.ProjectCargoListMeteDOBuilder(project="
            + this.project
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", grossMete="
            + this.grossMete
            + ", warehouseQuantity="
            + this.warehouseQuantity
            + ", warehouseMete="
            + this.warehouseMete
            + ", warehouseGrossMete="
            + this.warehouseGrossMete
            + ", sendQuantity="
            + this.sendQuantity
            + ", sendMete="
            + this.sendMete
            + ", sendGrossMete="
            + this.sendGrossMete
            + ", ratio="
            + this.ratio
            + ")";
      }
   }
}
