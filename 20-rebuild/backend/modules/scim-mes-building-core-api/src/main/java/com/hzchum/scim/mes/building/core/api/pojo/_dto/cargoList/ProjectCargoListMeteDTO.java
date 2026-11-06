package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运量")
public class ProjectCargoListMeteDTO {
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "quantity", value = "清单数量", notes = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "mete", value = "清单净重", notes = "清单净重")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
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
   @ApiModelProperty(name = "grossMete", value = "清单毛重量", notes = "清单毛重量")
   @JsonProperty("grossMete")
   @JSONField(name = "grossMete")
   private BigDecimal grossMete;
   @ApiModelProperty(name = "sendGrossMete", value = "发运毛重量", notes = "发运毛重量")
   @JsonProperty("sendGrossMete")
   @JSONField(name = "sendGrossMete")
   private BigDecimal sendGrossMete;
   @ApiModelProperty(name = "sendMete", value = "发运净重", notes = "发运净重")
   @JsonProperty("sendMete")
   @JSONField(name = "sendMete")
   private BigDecimal sendMete;
   @ApiModelProperty(name = "ratio", value = "比率", notes = "比率")
   @JsonProperty("ratio")
   @JSONField(name = "ratio")
   private BigDecimal ratio;
   @ApiModelProperty(name = "cargoQuantity", value = "车次", notes = "车次")
   @JsonProperty("cargoQuantity")
   @JSONField(name = "cargoQuantity")
   private Integer cargoQuantity;
   @ApiModelProperty(name = "sendInventoryQuantityRatio", value = "发运数/清单数", notes = "发运数/清单数")
   private BigDecimal sendInventoryQuantityRatio;
   @ApiModelProperty(name = "sendInventoryWeightRatio", value = "发运重量/清单重量", notes = "发运重量/清单重量")
   private BigDecimal sendInventoryWeightRatio;
   @ApiModelProperty(name = "sendWarehouseQuantityRatio", value = "发运数/入库数", notes = "发运数/入库数")
   private BigDecimal sendWarehouseQuantityRatio;
   @ApiModelProperty(name = "sendWarehouseWeightRatio", value = "发运重量/入库重量", notes = "发运重量/入库重量")
   private BigDecimal sendWarehouseWeightRatio;

   public static ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder builder() {
      return new ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder();
   }

   public ProjectCargoListMeteDTO(
      final ProjectDetailDO project,
      final Integer quantity,
      final BigDecimal mete,
      final Integer warehouseQuantity,
      final BigDecimal warehouseMete,
      final BigDecimal warehouseGrossMete,
      final Integer sendQuantity,
      final BigDecimal grossMete,
      final BigDecimal sendGrossMete,
      final BigDecimal sendMete,
      final BigDecimal ratio,
      final Integer cargoQuantity,
      final BigDecimal sendInventoryQuantityRatio,
      final BigDecimal sendInventoryWeightRatio,
      final BigDecimal sendWarehouseQuantityRatio,
      final BigDecimal sendWarehouseWeightRatio
   ) {
      this.project = project;
      this.quantity = quantity;
      this.mete = mete;
      this.warehouseQuantity = warehouseQuantity;
      this.warehouseMete = warehouseMete;
      this.warehouseGrossMete = warehouseGrossMete;
      this.sendQuantity = sendQuantity;
      this.grossMete = grossMete;
      this.sendGrossMete = sendGrossMete;
      this.sendMete = sendMete;
      this.ratio = ratio;
      this.cargoQuantity = cargoQuantity;
      this.sendInventoryQuantityRatio = sendInventoryQuantityRatio;
      this.sendInventoryWeightRatio = sendInventoryWeightRatio;
      this.sendWarehouseQuantityRatio = sendWarehouseQuantityRatio;
      this.sendWarehouseWeightRatio = sendWarehouseWeightRatio;
   }

   public ProjectCargoListMeteDTO() {
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

   public BigDecimal getGrossMete() {
      return this.grossMete;
   }

   public BigDecimal getSendGrossMete() {
      return this.sendGrossMete;
   }

   public BigDecimal getSendMete() {
      return this.sendMete;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   public Integer getCargoQuantity() {
      return this.cargoQuantity;
   }

   public BigDecimal getSendInventoryQuantityRatio() {
      return this.sendInventoryQuantityRatio;
   }

   public BigDecimal getSendInventoryWeightRatio() {
      return this.sendInventoryWeightRatio;
   }

   public BigDecimal getSendWarehouseQuantityRatio() {
      return this.sendWarehouseQuantityRatio;
   }

   public BigDecimal getSendWarehouseWeightRatio() {
      return this.sendWarehouseWeightRatio;
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

   @JsonProperty("grossMete")
   public void setGrossMete(final BigDecimal grossMete) {
      this.grossMete = grossMete;
   }

   @JsonProperty("sendGrossMete")
   public void setSendGrossMete(final BigDecimal sendGrossMete) {
      this.sendGrossMete = sendGrossMete;
   }

   @JsonProperty("sendMete")
   public void setSendMete(final BigDecimal sendMete) {
      this.sendMete = sendMete;
   }

   @JsonProperty("ratio")
   public void setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
   }

   @JsonProperty("cargoQuantity")
   public void setCargoQuantity(final Integer cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
   }

   public void setSendInventoryQuantityRatio(final BigDecimal sendInventoryQuantityRatio) {
      this.sendInventoryQuantityRatio = sendInventoryQuantityRatio;
   }

   public void setSendInventoryWeightRatio(final BigDecimal sendInventoryWeightRatio) {
      this.sendInventoryWeightRatio = sendInventoryWeightRatio;
   }

   public void setSendWarehouseQuantityRatio(final BigDecimal sendWarehouseQuantityRatio) {
      this.sendWarehouseQuantityRatio = sendWarehouseQuantityRatio;
   }

   public void setSendWarehouseWeightRatio(final BigDecimal sendWarehouseWeightRatio) {
      this.sendWarehouseWeightRatio = sendWarehouseWeightRatio;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCargoListMeteDTO)) {
         return false;
      }

      ProjectCargoListMeteDTO other = (ProjectCargoListMeteDTO)o;
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
               Object this$cargoQuantity = this.getCargoQuantity();
               Object other$cargoQuantity = other.getCargoQuantity();
               if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$mete = this.getMete();
                     Object other$mete = other.getMete();
                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                        Object this$warehouseMete = this.getWarehouseMete();
                        Object other$warehouseMete = other.getWarehouseMete();
                        if (this$warehouseMete == null ? other$warehouseMete == null : this$warehouseMete.equals(other$warehouseMete)) {
                           Object this$warehouseGrossMete = this.getWarehouseGrossMete();
                           Object other$warehouseGrossMete = other.getWarehouseGrossMete();
                           if (this$warehouseGrossMete == null ? other$warehouseGrossMete == null : this$warehouseGrossMete.equals(other$warehouseGrossMete)) {
                              Object this$grossMete = this.getGrossMete();
                              Object other$grossMete = other.getGrossMete();
                              if (this$grossMete == null ? other$grossMete == null : this$grossMete.equals(other$grossMete)) {
                                 Object this$sendGrossMete = this.getSendGrossMete();
                                 Object other$sendGrossMete = other.getSendGrossMete();
                                 if (this$sendGrossMete == null ? other$sendGrossMete == null : this$sendGrossMete.equals(other$sendGrossMete)) {
                                    Object this$sendMete = this.getSendMete();
                                    Object other$sendMete = other.getSendMete();
                                    if (this$sendMete == null ? other$sendMete == null : this$sendMete.equals(other$sendMete)) {
                                       Object this$ratio = this.getRatio();
                                       Object other$ratio = other.getRatio();
                                       if (this$ratio == null ? other$ratio == null : this$ratio.equals(other$ratio)) {
                                          Object this$sendInventoryQuantityRatio = this.getSendInventoryQuantityRatio();
                                          Object other$sendInventoryQuantityRatio = other.getSendInventoryQuantityRatio();
                                          if (this$sendInventoryQuantityRatio == null
                                             ? other$sendInventoryQuantityRatio == null
                                             : this$sendInventoryQuantityRatio.equals(other$sendInventoryQuantityRatio)) {
                                             Object this$sendInventoryWeightRatio = this.getSendInventoryWeightRatio();
                                             Object other$sendInventoryWeightRatio = other.getSendInventoryWeightRatio();
                                             if (this$sendInventoryWeightRatio == null
                                                ? other$sendInventoryWeightRatio == null
                                                : this$sendInventoryWeightRatio.equals(other$sendInventoryWeightRatio)) {
                                                Object this$sendWarehouseQuantityRatio = this.getSendWarehouseQuantityRatio();
                                                Object other$sendWarehouseQuantityRatio = other.getSendWarehouseQuantityRatio();
                                                if (this$sendWarehouseQuantityRatio == null
                                                   ? other$sendWarehouseQuantityRatio == null
                                                   : this$sendWarehouseQuantityRatio.equals(other$sendWarehouseQuantityRatio)) {
                                                   Object this$sendWarehouseWeightRatio = this.getSendWarehouseWeightRatio();
                                                   Object other$sendWarehouseWeightRatio = other.getSendWarehouseWeightRatio();
                                                   return this$sendWarehouseWeightRatio == null
                                                      ? other$sendWarehouseWeightRatio == null
                                                      : this$sendWarehouseWeightRatio.equals(other$sendWarehouseWeightRatio);
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
      return other instanceof ProjectCargoListMeteDTO;
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
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $warehouseMete = this.getWarehouseMete();
      result = result * 59 + ($warehouseMete == null ? 43 : $warehouseMete.hashCode());
      Object $warehouseGrossMete = this.getWarehouseGrossMete();
      result = result * 59 + ($warehouseGrossMete == null ? 43 : $warehouseGrossMete.hashCode());
      Object $grossMete = this.getGrossMete();
      result = result * 59 + ($grossMete == null ? 43 : $grossMete.hashCode());
      Object $sendGrossMete = this.getSendGrossMete();
      result = result * 59 + ($sendGrossMete == null ? 43 : $sendGrossMete.hashCode());
      Object $sendMete = this.getSendMete();
      result = result * 59 + ($sendMete == null ? 43 : $sendMete.hashCode());
      Object $ratio = this.getRatio();
      result = result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
      Object $sendInventoryQuantityRatio = this.getSendInventoryQuantityRatio();
      result = result * 59 + ($sendInventoryQuantityRatio == null ? 43 : $sendInventoryQuantityRatio.hashCode());
      Object $sendInventoryWeightRatio = this.getSendInventoryWeightRatio();
      result = result * 59 + ($sendInventoryWeightRatio == null ? 43 : $sendInventoryWeightRatio.hashCode());
      Object $sendWarehouseQuantityRatio = this.getSendWarehouseQuantityRatio();
      result = result * 59 + ($sendWarehouseQuantityRatio == null ? 43 : $sendWarehouseQuantityRatio.hashCode());
      Object $sendWarehouseWeightRatio = this.getSendWarehouseWeightRatio();
      return result * 59 + ($sendWarehouseWeightRatio == null ? 43 : $sendWarehouseWeightRatio.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCargoListMeteDTO(project="
         + this.getProject()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", warehouseQuantity="
         + this.getWarehouseQuantity()
         + ", warehouseMete="
         + this.getWarehouseMete()
         + ", warehouseGrossMete="
         + this.getWarehouseGrossMete()
         + ", sendQuantity="
         + this.getSendQuantity()
         + ", grossMete="
         + this.getGrossMete()
         + ", sendGrossMete="
         + this.getSendGrossMete()
         + ", sendMete="
         + this.getSendMete()
         + ", ratio="
         + this.getRatio()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ", sendInventoryQuantityRatio="
         + this.getSendInventoryQuantityRatio()
         + ", sendInventoryWeightRatio="
         + this.getSendInventoryWeightRatio()
         + ", sendWarehouseQuantityRatio="
         + this.getSendWarehouseQuantityRatio()
         + ", sendWarehouseWeightRatio="
         + this.getSendWarehouseWeightRatio()
         + ")";
   }

   public static class ProjectCargoListMeteDTOBuilder {
      private ProjectDetailDO project;
      private Integer quantity;
      private BigDecimal mete;
      private Integer warehouseQuantity;
      private BigDecimal warehouseMete;
      private BigDecimal warehouseGrossMete;
      private Integer sendQuantity;
      private BigDecimal grossMete;
      private BigDecimal sendGrossMete;
      private BigDecimal sendMete;
      private BigDecimal ratio;
      private Integer cargoQuantity;
      private BigDecimal sendInventoryQuantityRatio;
      private BigDecimal sendInventoryWeightRatio;
      private BigDecimal sendWarehouseQuantityRatio;
      private BigDecimal sendWarehouseWeightRatio;

      ProjectCargoListMeteDTOBuilder() {
      }

      @JsonProperty("project")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder warehouseQuantity(final Integer warehouseQuantity) {
         this.warehouseQuantity = warehouseQuantity;
         return this;
      }

      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder warehouseMete(final BigDecimal warehouseMete) {
         this.warehouseMete = warehouseMete;
         return this;
      }

      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder warehouseGrossMete(final BigDecimal warehouseGrossMete) {
         this.warehouseGrossMete = warehouseGrossMete;
         return this;
      }

      @JsonProperty("sendQuantity")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder sendQuantity(final Integer sendQuantity) {
         this.sendQuantity = sendQuantity;
         return this;
      }

      @JsonProperty("grossMete")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder grossMete(final BigDecimal grossMete) {
         this.grossMete = grossMete;
         return this;
      }

      @JsonProperty("sendGrossMete")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder sendGrossMete(final BigDecimal sendGrossMete) {
         this.sendGrossMete = sendGrossMete;
         return this;
      }

      @JsonProperty("sendMete")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder sendMete(final BigDecimal sendMete) {
         this.sendMete = sendMete;
         return this;
      }

      @JsonProperty("ratio")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      @JsonProperty("cargoQuantity")
      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder sendInventoryQuantityRatio(final BigDecimal sendInventoryQuantityRatio) {
         this.sendInventoryQuantityRatio = sendInventoryQuantityRatio;
         return this;
      }

      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder sendInventoryWeightRatio(final BigDecimal sendInventoryWeightRatio) {
         this.sendInventoryWeightRatio = sendInventoryWeightRatio;
         return this;
      }

      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder sendWarehouseQuantityRatio(final BigDecimal sendWarehouseQuantityRatio) {
         this.sendWarehouseQuantityRatio = sendWarehouseQuantityRatio;
         return this;
      }

      public ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder sendWarehouseWeightRatio(final BigDecimal sendWarehouseWeightRatio) {
         this.sendWarehouseWeightRatio = sendWarehouseWeightRatio;
         return this;
      }

      public ProjectCargoListMeteDTO build() {
         return new ProjectCargoListMeteDTO(
            this.project,
            this.quantity,
            this.mete,
            this.warehouseQuantity,
            this.warehouseMete,
            this.warehouseGrossMete,
            this.sendQuantity,
            this.grossMete,
            this.sendGrossMete,
            this.sendMete,
            this.ratio,
            this.cargoQuantity,
            this.sendInventoryQuantityRatio,
            this.sendInventoryWeightRatio,
            this.sendWarehouseQuantityRatio,
            this.sendWarehouseWeightRatio
         );
      }

      @Override
      public String toString() {
         return "ProjectCargoListMeteDTO.ProjectCargoListMeteDTOBuilder(project="
            + this.project
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", warehouseQuantity="
            + this.warehouseQuantity
            + ", warehouseMete="
            + this.warehouseMete
            + ", warehouseGrossMete="
            + this.warehouseGrossMete
            + ", sendQuantity="
            + this.sendQuantity
            + ", grossMete="
            + this.grossMete
            + ", sendGrossMete="
            + this.sendGrossMete
            + ", sendMete="
            + this.sendMete
            + ", ratio="
            + this.ratio
            + ", cargoQuantity="
            + this.cargoQuantity
            + ", sendInventoryQuantityRatio="
            + this.sendInventoryQuantityRatio
            + ", sendInventoryWeightRatio="
            + this.sendInventoryWeightRatio
            + ", sendWarehouseQuantityRatio="
            + this.sendWarehouseQuantityRatio
            + ", sendWarehouseWeightRatio="
            + this.sendWarehouseWeightRatio
            + ")";
      }
   }
}
