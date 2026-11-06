package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(description = "发运量")
public class ProjectCargoListMeteDetailDTO {
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名", notes = "单体名")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名", notes = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "workshopName", value = "车间名", notes = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "id", value = "产品id", notes = "产品id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（m²）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalArea", value = "清单总面积（m²）")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "grossWeight", value = "单毛重", notes = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "netWeight", value = "单净重", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "quantity", value = "清单数", notes = "清单数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "inboundQuantity", value = "入库数", notes = "入库数")
   @JsonProperty("inboundQuantity")
   @JSONField(name = "inboundQuantity")
   private Integer inboundQuantity;
   @ApiModelProperty(name = "cargoQuantity", value = "发运数", notes = "发运数")
   @JsonProperty("cargoQuantity")
   @JSONField(name = "cargoQuantity")
   private Integer cargoQuantity;
   @ApiModelProperty(name = "inventory", value = "库存数", notes = "库存数")
   @JsonProperty("inventory")
   @JSONField(name = "inventory")
   private Integer inventory;
   @ApiModelProperty(name = "inventoryNetWeight", value = "库存净重", notes = "库存净重")
   @JsonProperty("inventoryNetWeight")
   @JSONField(name = "inventoryNetWeight")
   private BigDecimal inventoryNetWeight;
   @ApiModelProperty(name = "inventoryGrossWeight", value = "库存毛重", notes = "库存毛重")
   @JsonProperty("inventoryGrossWeight")
   @JSONField(name = "inventoryGrossWeight")
   private BigDecimal inventoryGrossWeight;
   @ApiModelProperty(name = "cargoGrossWeight", value = "发运量(毛重)", notes = "发运量(毛重)")
   @JsonProperty("cargoGrossWeight")
   @JSONField(name = "cargoGrossWeight")
   private BigDecimal cargoGrossWeight;
   @ApiModelProperty(name = "cargoNetWeight", value = "发运量(净重)", notes = "发运量(净重)")
   @JsonProperty("cargoNetWeight")
   @JSONField(name = "cargoNetWeight")
   private BigDecimal cargoNetWeight;
   @ApiModelProperty(name = "cargoDate", value = "发运时间", notes = "发运时间")
   @JsonProperty("cargoDate")
   @JSONField(name = "cargoDate")
   private LocalDateTime cargoDate;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   @TableField("bool_all_part_send_directly")
   private Boolean boolAllPartSendDirectly;

   public static ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder builder() {
      return new ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder();
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getInboundQuantity() {
      return this.inboundQuantity;
   }

   public Integer getCargoQuantity() {
      return this.cargoQuantity;
   }

   public Integer getInventory() {
      return this.inventory;
   }

   public BigDecimal getInventoryNetWeight() {
      return this.inventoryNetWeight;
   }

   public BigDecimal getInventoryGrossWeight() {
      return this.inventoryGrossWeight;
   }

   public BigDecimal getCargoGrossWeight() {
      return this.cargoGrossWeight;
   }

   public BigDecimal getCargoNetWeight() {
      return this.cargoNetWeight;
   }

   public LocalDateTime getCargoDate() {
      return this.cargoDate;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   @JsonProperty("monomerId")
   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   @JsonProperty("monomerName")
   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   @JsonProperty("areaId")
   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   @JsonProperty("areaName")
   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   @JsonProperty("workshopName")
   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   @JsonProperty("grossWeight")
   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   @JsonProperty("netWeight")
   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   @JsonProperty("totalGrossWeight")
   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   @JsonProperty("totalNetWeight")
   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("inboundQuantity")
   public void setInboundQuantity(final Integer inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
   }

   @JsonProperty("cargoQuantity")
   public void setCargoQuantity(final Integer cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
   }

   @JsonProperty("inventory")
   public void setInventory(final Integer inventory) {
      this.inventory = inventory;
   }

   @JsonProperty("inventoryNetWeight")
   public void setInventoryNetWeight(final BigDecimal inventoryNetWeight) {
      this.inventoryNetWeight = inventoryNetWeight;
   }

   @JsonProperty("inventoryGrossWeight")
   public void setInventoryGrossWeight(final BigDecimal inventoryGrossWeight) {
      this.inventoryGrossWeight = inventoryGrossWeight;
   }

   @JsonProperty("cargoGrossWeight")
   public void setCargoGrossWeight(final BigDecimal cargoGrossWeight) {
      this.cargoGrossWeight = cargoGrossWeight;
   }

   @JsonProperty("cargoNetWeight")
   public void setCargoNetWeight(final BigDecimal cargoNetWeight) {
      this.cargoNetWeight = cargoNetWeight;
   }

   @JsonProperty("cargoDate")
   public void setCargoDate(final LocalDateTime cargoDate) {
      this.cargoDate = cargoDate;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCargoListMeteDetailDTO)) {
         return false;
      }

      ProjectCargoListMeteDetailDTO other = (ProjectCargoListMeteDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$inboundQuantity = this.getInboundQuantity();
                  Object other$inboundQuantity = other.getInboundQuantity();
                  if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
                     Object this$cargoQuantity = this.getCargoQuantity();
                     Object other$cargoQuantity = other.getCargoQuantity();
                     if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
                        Object this$inventory = this.getInventory();
                        Object other$inventory = other.getInventory();
                        if (this$inventory == null ? other$inventory == null : this$inventory.equals(other$inventory)) {
                           Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                           Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                           if (this$boolAllPartSendDirectly == null
                              ? other$boolAllPartSendDirectly == null
                              : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                              Object this$monomerName = this.getMonomerName();
                              Object other$monomerName = other.getMonomerName();
                              if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                 Object this$areaName = this.getAreaName();
                                 Object other$areaName = other.getAreaName();
                                 if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                    Object this$workshopName = this.getWorkshopName();
                                    Object other$workshopName = other.getWorkshopName();
                                    if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$name = this.getName();
                                          Object other$name = other.getName();
                                          if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                             Object this$material = this.getMaterial();
                                             Object other$material = other.getMaterial();
                                             if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                Object this$remark = this.getRemark();
                                                Object other$remark = other.getRemark();
                                                if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$length = this.getLength();
                                                      Object other$length = other.getLength();
                                                      if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                         Object this$surfaceArea = this.getSurfaceArea();
                                                         Object other$surfaceArea = other.getSurfaceArea();
                                                         if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                            Object this$totalArea = this.getTotalArea();
                                                            Object other$totalArea = other.getTotalArea();
                                                            if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                                               Object this$grossWeight = this.getGrossWeight();
                                                               Object other$grossWeight = other.getGrossWeight();
                                                               if (this$grossWeight == null
                                                                  ? other$grossWeight == null
                                                                  : this$grossWeight.equals(other$grossWeight)) {
                                                                  Object this$netWeight = this.getNetWeight();
                                                                  Object other$netWeight = other.getNetWeight();
                                                                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)
                                                                     )
                                                                   {
                                                                     Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                     Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                     if (this$totalGrossWeight == null
                                                                        ? other$totalGrossWeight == null
                                                                        : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                        Object this$totalNetWeight = this.getTotalNetWeight();
                                                                        Object other$totalNetWeight = other.getTotalNetWeight();
                                                                        if (this$totalNetWeight == null
                                                                           ? other$totalNetWeight == null
                                                                           : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                           Object this$inventoryNetWeight = this.getInventoryNetWeight();
                                                                           Object other$inventoryNetWeight = other.getInventoryNetWeight();
                                                                           if (this$inventoryNetWeight == null
                                                                              ? other$inventoryNetWeight == null
                                                                              : this$inventoryNetWeight.equals(other$inventoryNetWeight)) {
                                                                              Object this$inventoryGrossWeight = this.getInventoryGrossWeight();
                                                                              Object other$inventoryGrossWeight = other.getInventoryGrossWeight();
                                                                              if (this$inventoryGrossWeight == null
                                                                                 ? other$inventoryGrossWeight == null
                                                                                 : this$inventoryGrossWeight.equals(other$inventoryGrossWeight)) {
                                                                                 Object this$cargoGrossWeight = this.getCargoGrossWeight();
                                                                                 Object other$cargoGrossWeight = other.getCargoGrossWeight();
                                                                                 if (this$cargoGrossWeight == null
                                                                                    ? other$cargoGrossWeight == null
                                                                                    : this$cargoGrossWeight.equals(other$cargoGrossWeight)) {
                                                                                    Object this$cargoNetWeight = this.getCargoNetWeight();
                                                                                    Object other$cargoNetWeight = other.getCargoNetWeight();
                                                                                    if (this$cargoNetWeight == null
                                                                                       ? other$cargoNetWeight == null
                                                                                       : this$cargoNetWeight.equals(other$cargoNetWeight)) {
                                                                                       Object this$cargoDate = this.getCargoDate();
                                                                                       Object other$cargoDate = other.getCargoDate();
                                                                                       return this$cargoDate == null
                                                                                          ? other$cargoDate == null
                                                                                          : this$cargoDate.equals(other$cargoDate);
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
      return other instanceof ProjectCargoListMeteDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $inventory = this.getInventory();
      result = result * 59 + ($inventory == null ? 43 : $inventory.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $inventoryNetWeight = this.getInventoryNetWeight();
      result = result * 59 + ($inventoryNetWeight == null ? 43 : $inventoryNetWeight.hashCode());
      Object $inventoryGrossWeight = this.getInventoryGrossWeight();
      result = result * 59 + ($inventoryGrossWeight == null ? 43 : $inventoryGrossWeight.hashCode());
      Object $cargoGrossWeight = this.getCargoGrossWeight();
      result = result * 59 + ($cargoGrossWeight == null ? 43 : $cargoGrossWeight.hashCode());
      Object $cargoNetWeight = this.getCargoNetWeight();
      result = result * 59 + ($cargoNetWeight == null ? 43 : $cargoNetWeight.hashCode());
      Object $cargoDate = this.getCargoDate();
      return result * 59 + ($cargoDate == null ? 43 : $cargoDate.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCargoListMeteDetailDTO(monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", workshopName="
         + this.getWorkshopName()
         + ", id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", remark="
         + this.getRemark()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalArea="
         + this.getTotalArea()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", quantity="
         + this.getQuantity()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ", inventory="
         + this.getInventory()
         + ", inventoryNetWeight="
         + this.getInventoryNetWeight()
         + ", inventoryGrossWeight="
         + this.getInventoryGrossWeight()
         + ", cargoGrossWeight="
         + this.getCargoGrossWeight()
         + ", cargoNetWeight="
         + this.getCargoNetWeight()
         + ", cargoDate="
         + this.getCargoDate()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ")";
   }

   public ProjectCargoListMeteDetailDTO(
      final Long monomerId,
      final String monomerName,
      final Long areaId,
      final String areaName,
      final String workshopName,
      final Long id,
      final String serialNumber,
      final String name,
      final String material,
      final String remark,
      final String specification,
      final BigDecimal length,
      final BigDecimal surfaceArea,
      final BigDecimal totalArea,
      final BigDecimal grossWeight,
      final BigDecimal netWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal totalNetWeight,
      final Integer quantity,
      final Integer inboundQuantity,
      final Integer cargoQuantity,
      final Integer inventory,
      final BigDecimal inventoryNetWeight,
      final BigDecimal inventoryGrossWeight,
      final BigDecimal cargoGrossWeight,
      final BigDecimal cargoNetWeight,
      final LocalDateTime cargoDate,
      final Boolean boolAllPartSendDirectly
   ) {
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.workshopName = workshopName;
      this.id = id;
      this.serialNumber = serialNumber;
      this.name = name;
      this.material = material;
      this.remark = remark;
      this.specification = specification;
      this.length = length;
      this.surfaceArea = surfaceArea;
      this.totalArea = totalArea;
      this.grossWeight = grossWeight;
      this.netWeight = netWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.totalNetWeight = totalNetWeight;
      this.quantity = quantity;
      this.inboundQuantity = inboundQuantity;
      this.cargoQuantity = cargoQuantity;
      this.inventory = inventory;
      this.inventoryNetWeight = inventoryNetWeight;
      this.inventoryGrossWeight = inventoryGrossWeight;
      this.cargoGrossWeight = cargoGrossWeight;
      this.cargoNetWeight = cargoNetWeight;
      this.cargoDate = cargoDate;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public ProjectCargoListMeteDetailDTO() {
   }

   public static class ProjectCargoListMeteDetailDTOBuilder {
      private Long monomerId;
      private String monomerName;
      private Long areaId;
      private String areaName;
      private String workshopName;
      private Long id;
      private String serialNumber;
      private String name;
      private String material;
      private String remark;
      private String specification;
      private BigDecimal length;
      private BigDecimal surfaceArea;
      private BigDecimal totalArea;
      private BigDecimal grossWeight;
      private BigDecimal netWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal totalNetWeight;
      private Integer quantity;
      private Integer inboundQuantity;
      private Integer cargoQuantity;
      private Integer inventory;
      private BigDecimal inventoryNetWeight;
      private BigDecimal inventoryGrossWeight;
      private BigDecimal cargoGrossWeight;
      private BigDecimal cargoNetWeight;
      private LocalDateTime cargoDate;
      private Boolean boolAllPartSendDirectly;

      ProjectCargoListMeteDetailDTOBuilder() {
      }

      @JsonProperty("monomerId")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("monomerName")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaId")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaName")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("workshopName")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("grossWeight")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("netWeight")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("inboundQuantity")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder inboundQuantity(final Integer inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      @JsonProperty("cargoQuantity")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      @JsonProperty("inventory")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder inventory(final Integer inventory) {
         this.inventory = inventory;
         return this;
      }

      @JsonProperty("inventoryNetWeight")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder inventoryNetWeight(final BigDecimal inventoryNetWeight) {
         this.inventoryNetWeight = inventoryNetWeight;
         return this;
      }

      @JsonProperty("inventoryGrossWeight")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder inventoryGrossWeight(final BigDecimal inventoryGrossWeight) {
         this.inventoryGrossWeight = inventoryGrossWeight;
         return this;
      }

      @JsonProperty("cargoGrossWeight")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder cargoGrossWeight(final BigDecimal cargoGrossWeight) {
         this.cargoGrossWeight = cargoGrossWeight;
         return this;
      }

      @JsonProperty("cargoNetWeight")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder cargoNetWeight(final BigDecimal cargoNetWeight) {
         this.cargoNetWeight = cargoNetWeight;
         return this;
      }

      @JsonProperty("cargoDate")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder cargoDate(final LocalDateTime cargoDate) {
         this.cargoDate = cargoDate;
         return this;
      }

      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public ProjectCargoListMeteDetailDTO build() {
         return new ProjectCargoListMeteDetailDTO(
            this.monomerId,
            this.monomerName,
            this.areaId,
            this.areaName,
            this.workshopName,
            this.id,
            this.serialNumber,
            this.name,
            this.material,
            this.remark,
            this.specification,
            this.length,
            this.surfaceArea,
            this.totalArea,
            this.grossWeight,
            this.netWeight,
            this.totalGrossWeight,
            this.totalNetWeight,
            this.quantity,
            this.inboundQuantity,
            this.cargoQuantity,
            this.inventory,
            this.inventoryNetWeight,
            this.inventoryGrossWeight,
            this.cargoGrossWeight,
            this.cargoNetWeight,
            this.cargoDate,
            this.boolAllPartSendDirectly
         );
      }

      @Override
      public String toString() {
         return "ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder(monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", workshopName="
            + this.workshopName
            + ", id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", remark="
            + this.remark
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalArea="
            + this.totalArea
            + ", grossWeight="
            + this.grossWeight
            + ", netWeight="
            + this.netWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", quantity="
            + this.quantity
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", cargoQuantity="
            + this.cargoQuantity
            + ", inventory="
            + this.inventory
            + ", inventoryNetWeight="
            + this.inventoryNetWeight
            + ", inventoryGrossWeight="
            + this.inventoryGrossWeight
            + ", cargoGrossWeight="
            + this.cargoGrossWeight
            + ", cargoNetWeight="
            + this.cargoNetWeight
            + ", cargoDate="
            + this.cargoDate
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ")";
      }
   }
}
