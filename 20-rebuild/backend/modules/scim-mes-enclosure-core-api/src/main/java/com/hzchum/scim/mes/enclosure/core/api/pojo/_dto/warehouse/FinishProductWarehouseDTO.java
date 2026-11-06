package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.warehouse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.util.ProjectDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "FinishProductWarehouseDTO", description = "制成品入发存 ")
public class FinishProductWarehouseDTO {
   @ApiModelProperty(name = "project", notes = "项目基础信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDTO project;
   @ApiModelProperty(name = "monomerName", value = "单体名")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaName", value = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "workshopName", notes = "车间名", value = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "name", value = "产品名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", value = "清单数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "mete", value = "清单总重")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "totalNetWeight", value = "清单总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "清单总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "inboundQuantity", value = "入库数量")
   @JsonProperty("inboundQuantity")
   @JSONField(name = "inboundQuantity")
   private Integer inboundQuantity;
   @ApiModelProperty(name = "outboundQuantity", value = "出库数量")
   @JsonProperty("outboundQuantity")
   @JSONField(name = "outboundQuantity")
   private Integer outboundQuantity;
   @ApiModelProperty(name = "stockQuantity", value = "库存数量")
   @JsonProperty("stockQuantity")
   @JSONField(name = "stockQuantity")
   private Integer stockQuantity;
   @ApiModelProperty(name = "inboundMete", value = "入库总重")
   @JsonProperty("inboundMete")
   @JSONField(name = "inboundMete")
   private BigDecimal inboundMete;
   @ApiModelProperty(name = "inboundNetWeight", value = "入库总净重")
   @JsonProperty("inboundNetWeight")
   @JSONField(name = "inboundNetWeight")
   private BigDecimal inboundNetWeight;
   @ApiModelProperty(name = "inboundGrossWeight", value = "入库总毛重")
   @JsonProperty("inboundGrossWeight")
   @JSONField(name = "inboundGrossWeight")
   private BigDecimal inboundGrossWeight;
   @ApiModelProperty(name = "outboundMete", value = "出库总重")
   @JsonProperty("outboundMete")
   @JSONField(name = "outboundMete")
   private BigDecimal outboundMete;
   @ApiModelProperty(name = "outboundNetWeight", value = "出库总净重")
   @JsonProperty("outboundNetWeight")
   @JSONField(name = "outboundNetWeight")
   private BigDecimal outboundNetWeight;
   @ApiModelProperty(name = "outboundGrossWeight", value = "出库总毛重")
   @JsonProperty("outboundGrossWeight")
   @JSONField(name = "outboundGrossWeight")
   private BigDecimal outboundGrossWeight;
   @ApiModelProperty(name = "stockMete", value = "库存总重")
   @JsonProperty("stockMete")
   @JSONField(name = "stockMete")
   private BigDecimal stockMete;
   @ApiModelProperty(name = "stockNetWeight", value = "库存总净重")
   @JsonProperty("stockNetWeight")
   @JSONField(name = "stockNetWeight")
   private BigDecimal stockNetWeight;
   @ApiModelProperty(name = "stockGrossWeight", value = "库存总毛重")
   @JsonProperty("stockGrossWeight")
   @JSONField(name = "stockGrossWeight")
   private BigDecimal stockGrossWeight;

   public static FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder builder() {
      return new FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder();
   }

   public FinishProductWarehouseDTO() {
   }

   public FinishProductWarehouseDTO(
      final ProjectDetailDTO project,
      final String monomerName,
      final String areaName,
      final String workshopName,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final Integer quantity,
      final BigDecimal mete,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final Integer inboundQuantity,
      final Integer outboundQuantity,
      final Integer stockQuantity,
      final BigDecimal inboundMete,
      final BigDecimal inboundNetWeight,
      final BigDecimal inboundGrossWeight,
      final BigDecimal outboundMete,
      final BigDecimal outboundNetWeight,
      final BigDecimal outboundGrossWeight,
      final BigDecimal stockMete,
      final BigDecimal stockNetWeight,
      final BigDecimal stockGrossWeight
   ) {
      this.project = project;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.workshopName = workshopName;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.quantity = quantity;
      this.mete = mete;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.inboundQuantity = inboundQuantity;
      this.outboundQuantity = outboundQuantity;
      this.stockQuantity = stockQuantity;
      this.inboundMete = inboundMete;
      this.inboundNetWeight = inboundNetWeight;
      this.inboundGrossWeight = inboundGrossWeight;
      this.outboundMete = outboundMete;
      this.outboundNetWeight = outboundNetWeight;
      this.outboundGrossWeight = outboundGrossWeight;
      this.stockMete = stockMete;
      this.stockNetWeight = stockNetWeight;
      this.stockGrossWeight = stockGrossWeight;
   }

   public ProjectDetailDTO getProject() {
      return this.project;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getWorkshopName() {
      return this.workshopName;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public Integer getInboundQuantity() {
      return this.inboundQuantity;
   }

   public Integer getOutboundQuantity() {
      return this.outboundQuantity;
   }

   public Integer getStockQuantity() {
      return this.stockQuantity;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public BigDecimal getInboundNetWeight() {
      return this.inboundNetWeight;
   }

   public BigDecimal getInboundGrossWeight() {
      return this.inboundGrossWeight;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public BigDecimal getOutboundNetWeight() {
      return this.outboundNetWeight;
   }

   public BigDecimal getOutboundGrossWeight() {
      return this.outboundGrossWeight;
   }

   public BigDecimal getStockMete() {
      return this.stockMete;
   }

   public BigDecimal getStockNetWeight() {
      return this.stockNetWeight;
   }

   public BigDecimal getStockGrossWeight() {
      return this.stockGrossWeight;
   }

   @JsonProperty("project")
   public FinishProductWarehouseDTO setProject(final ProjectDetailDTO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomerName")
   public FinishProductWarehouseDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaName")
   public FinishProductWarehouseDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("workshopName")
   public FinishProductWarehouseDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("name")
   public FinishProductWarehouseDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public FinishProductWarehouseDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public FinishProductWarehouseDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public FinishProductWarehouseDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("quantity")
   public FinishProductWarehouseDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("mete")
   public FinishProductWarehouseDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public FinishProductWarehouseDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public FinishProductWarehouseDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("inboundQuantity")
   public FinishProductWarehouseDTO setInboundQuantity(final Integer inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
      return this;
   }

   @JsonProperty("outboundQuantity")
   public FinishProductWarehouseDTO setOutboundQuantity(final Integer outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
      return this;
   }

   @JsonProperty("stockQuantity")
   public FinishProductWarehouseDTO setStockQuantity(final Integer stockQuantity) {
      this.stockQuantity = stockQuantity;
      return this;
   }

   @JsonProperty("inboundMete")
   public FinishProductWarehouseDTO setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
      return this;
   }

   @JsonProperty("inboundNetWeight")
   public FinishProductWarehouseDTO setInboundNetWeight(final BigDecimal inboundNetWeight) {
      this.inboundNetWeight = inboundNetWeight;
      return this;
   }

   @JsonProperty("inboundGrossWeight")
   public FinishProductWarehouseDTO setInboundGrossWeight(final BigDecimal inboundGrossWeight) {
      this.inboundGrossWeight = inboundGrossWeight;
      return this;
   }

   @JsonProperty("outboundMete")
   public FinishProductWarehouseDTO setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
      return this;
   }

   @JsonProperty("outboundNetWeight")
   public FinishProductWarehouseDTO setOutboundNetWeight(final BigDecimal outboundNetWeight) {
      this.outboundNetWeight = outboundNetWeight;
      return this;
   }

   @JsonProperty("outboundGrossWeight")
   public FinishProductWarehouseDTO setOutboundGrossWeight(final BigDecimal outboundGrossWeight) {
      this.outboundGrossWeight = outboundGrossWeight;
      return this;
   }

   @JsonProperty("stockMete")
   public FinishProductWarehouseDTO setStockMete(final BigDecimal stockMete) {
      this.stockMete = stockMete;
      return this;
   }

   @JsonProperty("stockNetWeight")
   public FinishProductWarehouseDTO setStockNetWeight(final BigDecimal stockNetWeight) {
      this.stockNetWeight = stockNetWeight;
      return this;
   }

   @JsonProperty("stockGrossWeight")
   public FinishProductWarehouseDTO setStockGrossWeight(final BigDecimal stockGrossWeight) {
      this.stockGrossWeight = stockGrossWeight;
      return this;
   }

   @Override
   public String toString() {
      return "FinishProductWarehouseDTO(project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", workshopName="
         + this.getWorkshopName()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", outboundQuantity="
         + this.getOutboundQuantity()
         + ", stockQuantity="
         + this.getStockQuantity()
         + ", inboundMete="
         + this.getInboundMete()
         + ", inboundNetWeight="
         + this.getInboundNetWeight()
         + ", inboundGrossWeight="
         + this.getInboundGrossWeight()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", outboundNetWeight="
         + this.getOutboundNetWeight()
         + ", outboundGrossWeight="
         + this.getOutboundGrossWeight()
         + ", stockMete="
         + this.getStockMete()
         + ", stockNetWeight="
         + this.getStockNetWeight()
         + ", stockGrossWeight="
         + this.getStockGrossWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FinishProductWarehouseDTO)) {
         return false;
      }

      FinishProductWarehouseDTO other = (FinishProductWarehouseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$inboundQuantity = this.getInboundQuantity();
         Object other$inboundQuantity = other.getInboundQuantity();
         if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
            Object this$outboundQuantity = this.getOutboundQuantity();
            Object other$outboundQuantity = other.getOutboundQuantity();
            if (this$outboundQuantity == null ? other$outboundQuantity == null : this$outboundQuantity.equals(other$outboundQuantity)) {
               Object this$stockQuantity = this.getStockQuantity();
               Object other$stockQuantity = other.getStockQuantity();
               if (this$stockQuantity == null ? other$stockQuantity == null : this$stockQuantity.equals(other$stockQuantity)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$monomerName = this.getMonomerName();
                     Object other$monomerName = other.getMonomerName();
                     if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                        Object this$areaName = this.getAreaName();
                        Object other$areaName = other.getAreaName();
                        if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                           Object this$workshopName = this.getWorkshopName();
                           Object other$workshopName = other.getWorkshopName();
                           if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$mete = this.getMete();
                                          Object other$mete = other.getMete();
                                          if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                             Object this$totalNetWeight = this.getTotalNetWeight();
                                             Object other$totalNetWeight = other.getTotalNetWeight();
                                             if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                if (this$totalGrossWeight == null
                                                   ? other$totalGrossWeight == null
                                                   : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                   Object this$inboundMete = this.getInboundMete();
                                                   Object other$inboundMete = other.getInboundMete();
                                                   if (this$inboundMete == null ? other$inboundMete == null : this$inboundMete.equals(other$inboundMete)) {
                                                      Object this$inboundNetWeight = this.getInboundNetWeight();
                                                      Object other$inboundNetWeight = other.getInboundNetWeight();
                                                      if (this$inboundNetWeight == null
                                                         ? other$inboundNetWeight == null
                                                         : this$inboundNetWeight.equals(other$inboundNetWeight)) {
                                                         Object this$inboundGrossWeight = this.getInboundGrossWeight();
                                                         Object other$inboundGrossWeight = other.getInboundGrossWeight();
                                                         if (this$inboundGrossWeight == null
                                                            ? other$inboundGrossWeight == null
                                                            : this$inboundGrossWeight.equals(other$inboundGrossWeight)) {
                                                            Object this$outboundMete = this.getOutboundMete();
                                                            Object other$outboundMete = other.getOutboundMete();
                                                            if (this$outboundMete == null
                                                               ? other$outboundMete == null
                                                               : this$outboundMete.equals(other$outboundMete)) {
                                                               Object this$outboundNetWeight = this.getOutboundNetWeight();
                                                               Object other$outboundNetWeight = other.getOutboundNetWeight();
                                                               if (this$outboundNetWeight == null
                                                                  ? other$outboundNetWeight == null
                                                                  : this$outboundNetWeight.equals(other$outboundNetWeight)) {
                                                                  Object this$outboundGrossWeight = this.getOutboundGrossWeight();
                                                                  Object other$outboundGrossWeight = other.getOutboundGrossWeight();
                                                                  if (this$outboundGrossWeight == null
                                                                     ? other$outboundGrossWeight == null
                                                                     : this$outboundGrossWeight.equals(other$outboundGrossWeight)) {
                                                                     Object this$stockMete = this.getStockMete();
                                                                     Object other$stockMete = other.getStockMete();
                                                                     if (this$stockMete == null
                                                                        ? other$stockMete == null
                                                                        : this$stockMete.equals(other$stockMete)) {
                                                                        Object this$stockNetWeight = this.getStockNetWeight();
                                                                        Object other$stockNetWeight = other.getStockNetWeight();
                                                                        if (this$stockNetWeight == null
                                                                           ? other$stockNetWeight == null
                                                                           : this$stockNetWeight.equals(other$stockNetWeight)) {
                                                                           Object this$stockGrossWeight = this.getStockGrossWeight();
                                                                           Object other$stockGrossWeight = other.getStockGrossWeight();
                                                                           return this$stockGrossWeight == null
                                                                              ? other$stockGrossWeight == null
                                                                              : this$stockGrossWeight.equals(other$stockGrossWeight);
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
      return other instanceof FinishProductWarehouseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
      Object $stockQuantity = this.getStockQuantity();
      result = result * 59 + ($stockQuantity == null ? 43 : $stockQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $inboundNetWeight = this.getInboundNetWeight();
      result = result * 59 + ($inboundNetWeight == null ? 43 : $inboundNetWeight.hashCode());
      Object $inboundGrossWeight = this.getInboundGrossWeight();
      result = result * 59 + ($inboundGrossWeight == null ? 43 : $inboundGrossWeight.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $outboundNetWeight = this.getOutboundNetWeight();
      result = result * 59 + ($outboundNetWeight == null ? 43 : $outboundNetWeight.hashCode());
      Object $outboundGrossWeight = this.getOutboundGrossWeight();
      result = result * 59 + ($outboundGrossWeight == null ? 43 : $outboundGrossWeight.hashCode());
      Object $stockMete = this.getStockMete();
      result = result * 59 + ($stockMete == null ? 43 : $stockMete.hashCode());
      Object $stockNetWeight = this.getStockNetWeight();
      result = result * 59 + ($stockNetWeight == null ? 43 : $stockNetWeight.hashCode());
      Object $stockGrossWeight = this.getStockGrossWeight();
      return result * 59 + ($stockGrossWeight == null ? 43 : $stockGrossWeight.hashCode());
   }

   public static class FinishProductWarehouseDTOBuilder {
      private ProjectDetailDTO project;
      private String monomerName;
      private String areaName;
      private String workshopName;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private Integer quantity;
      private BigDecimal mete;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private Integer inboundQuantity;
      private Integer outboundQuantity;
      private Integer stockQuantity;
      private BigDecimal inboundMete;
      private BigDecimal inboundNetWeight;
      private BigDecimal inboundGrossWeight;
      private BigDecimal outboundMete;
      private BigDecimal outboundNetWeight;
      private BigDecimal outboundGrossWeight;
      private BigDecimal stockMete;
      private BigDecimal stockNetWeight;
      private BigDecimal stockGrossWeight;

      FinishProductWarehouseDTOBuilder() {
      }

      @JsonProperty("project")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder project(final ProjectDetailDTO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomerName")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaName")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("workshopName")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("name")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("quantity")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("inboundQuantity")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder inboundQuantity(final Integer inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      @JsonProperty("outboundQuantity")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder outboundQuantity(final Integer outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      @JsonProperty("stockQuantity")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder stockQuantity(final Integer stockQuantity) {
         this.stockQuantity = stockQuantity;
         return this;
      }

      @JsonProperty("inboundMete")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      @JsonProperty("inboundNetWeight")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder inboundNetWeight(final BigDecimal inboundNetWeight) {
         this.inboundNetWeight = inboundNetWeight;
         return this;
      }

      @JsonProperty("inboundGrossWeight")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder inboundGrossWeight(final BigDecimal inboundGrossWeight) {
         this.inboundGrossWeight = inboundGrossWeight;
         return this;
      }

      @JsonProperty("outboundMete")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      @JsonProperty("outboundNetWeight")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder outboundNetWeight(final BigDecimal outboundNetWeight) {
         this.outboundNetWeight = outboundNetWeight;
         return this;
      }

      @JsonProperty("outboundGrossWeight")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder outboundGrossWeight(final BigDecimal outboundGrossWeight) {
         this.outboundGrossWeight = outboundGrossWeight;
         return this;
      }

      @JsonProperty("stockMete")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder stockMete(final BigDecimal stockMete) {
         this.stockMete = stockMete;
         return this;
      }

      @JsonProperty("stockNetWeight")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder stockNetWeight(final BigDecimal stockNetWeight) {
         this.stockNetWeight = stockNetWeight;
         return this;
      }

      @JsonProperty("stockGrossWeight")
      public FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder stockGrossWeight(final BigDecimal stockGrossWeight) {
         this.stockGrossWeight = stockGrossWeight;
         return this;
      }

      public FinishProductWarehouseDTO build() {
         return new FinishProductWarehouseDTO(
            this.project,
            this.monomerName,
            this.areaName,
            this.workshopName,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.quantity,
            this.mete,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.inboundQuantity,
            this.outboundQuantity,
            this.stockQuantity,
            this.inboundMete,
            this.inboundNetWeight,
            this.inboundGrossWeight,
            this.outboundMete,
            this.outboundNetWeight,
            this.outboundGrossWeight,
            this.stockMete,
            this.stockNetWeight,
            this.stockGrossWeight
         );
      }

      @Override
      public String toString() {
         return "FinishProductWarehouseDTO.FinishProductWarehouseDTOBuilder(project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", workshopName="
            + this.workshopName
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", outboundQuantity="
            + this.outboundQuantity
            + ", stockQuantity="
            + this.stockQuantity
            + ", inboundMete="
            + this.inboundMete
            + ", inboundNetWeight="
            + this.inboundNetWeight
            + ", inboundGrossWeight="
            + this.inboundGrossWeight
            + ", outboundMete="
            + this.outboundMete
            + ", outboundNetWeight="
            + this.outboundNetWeight
            + ", outboundGrossWeight="
            + this.outboundGrossWeight
            + ", stockMete="
            + this.stockMete
            + ", stockNetWeight="
            + this.stockNetWeight
            + ", stockGrossWeight="
            + this.stockGrossWeight
            + ")";
      }
   }
}
