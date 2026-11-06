package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "OrderUncompletedDetailDTO", description = "未完成订单详情")
public class OrderArtifactDetailDTO {
   @ApiModelProperty(name = "orderId", notes = "订单ID")
   @JsonProperty("orderId")
   @JSONField(name = "orderId")
   private String orderId;
   @ApiModelProperty(name = "projectName", notes = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "projectSerialNumber", notes = "项目序列号")
   @JsonProperty("projectSerialNumber")
   @JSONField(name = "projectSerialNumber")
   private String projectSerialNumber;
   @ApiModelProperty(name = "monomerId", notes = " 单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", notes = " 单体名称")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaId", notes = " 区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "areaName", notes = " 区域名称")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "serialNumber", notes = " 序列号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = " 规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = " 材料")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "length", notes = " 长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private String length;
   @ApiModelProperty(name = "uncompletedQuantity", notes = " 未完成数量")
   @JsonProperty("uncompletedQuantity")
   @JSONField(name = "uncompletedQuantity")
   private BigDecimal uncompletedQuantity;
   @ApiModelProperty(name = "currentSchedulingQuantity", notes = " 此项目排产数量")
   @JsonProperty("currentSchedulingQuantity")
   @JSONField(name = "currentSchedulingQuantity")
   private BigDecimal currentSchedulingQuantity;
   @ApiModelProperty(name = "netWeight", notes = " 净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;

   public String getOrderId() {
      return this.orderId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getLength() {
      return this.length;
   }

   public BigDecimal getUncompletedQuantity() {
      return this.uncompletedQuantity;
   }

   public BigDecimal getCurrentSchedulingQuantity() {
      return this.currentSchedulingQuantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   @JsonProperty("orderId")
   public OrderArtifactDetailDTO setOrderId(final String orderId) {
      this.orderId = orderId;
      return this;
   }

   @JsonProperty("projectName")
   public OrderArtifactDetailDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("projectSerialNumber")
   public OrderArtifactDetailDTO setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
      return this;
   }

   @JsonProperty("monomerId")
   public OrderArtifactDetailDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("monomerName")
   public OrderArtifactDetailDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaId")
   public OrderArtifactDetailDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaName")
   public OrderArtifactDetailDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("serialNumber")
   public OrderArtifactDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public OrderArtifactDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public OrderArtifactDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("length")
   public OrderArtifactDetailDTO setLength(final String length) {
      this.length = length;
      return this;
   }

   @JsonProperty("uncompletedQuantity")
   public OrderArtifactDetailDTO setUncompletedQuantity(final BigDecimal uncompletedQuantity) {
      this.uncompletedQuantity = uncompletedQuantity;
      return this;
   }

   @JsonProperty("currentSchedulingQuantity")
   public OrderArtifactDetailDTO setCurrentSchedulingQuantity(final BigDecimal currentSchedulingQuantity) {
      this.currentSchedulingQuantity = currentSchedulingQuantity;
      return this;
   }

   @JsonProperty("netWeight")
   public OrderArtifactDetailDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @Override
   public String toString() {
      return "OrderArtifactDetailDTO(orderId="
         + this.getOrderId()
         + ", projectName="
         + this.getProjectName()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", uncompletedQuantity="
         + this.getUncompletedQuantity()
         + ", currentSchedulingQuantity="
         + this.getCurrentSchedulingQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OrderArtifactDetailDTO)) {
         return false;
      }

      OrderArtifactDetailDTO other = (OrderArtifactDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$orderId = this.getOrderId();
            Object other$orderId = other.getOrderId();
            if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$projectSerialNumber = this.getProjectSerialNumber();
                  Object other$projectSerialNumber = other.getProjectSerialNumber();
                  if (this$projectSerialNumber == null ? other$projectSerialNumber == null : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                     Object this$monomerName = this.getMonomerName();
                     Object other$monomerName = other.getMonomerName();
                     if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                        Object this$areaName = this.getAreaName();
                        Object other$areaName = other.getAreaName();
                        if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                    Object this$length = this.getLength();
                                    Object other$length = other.getLength();
                                    if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                       Object this$uncompletedQuantity = this.getUncompletedQuantity();
                                       Object other$uncompletedQuantity = other.getUncompletedQuantity();
                                       if (this$uncompletedQuantity == null
                                          ? other$uncompletedQuantity == null
                                          : this$uncompletedQuantity.equals(other$uncompletedQuantity)) {
                                          Object this$currentSchedulingQuantity = this.getCurrentSchedulingQuantity();
                                          Object other$currentSchedulingQuantity = other.getCurrentSchedulingQuantity();
                                          if (this$currentSchedulingQuantity == null
                                             ? other$currentSchedulingQuantity == null
                                             : this$currentSchedulingQuantity.equals(other$currentSchedulingQuantity)) {
                                             Object this$netWeight = this.getNetWeight();
                                             Object other$netWeight = other.getNetWeight();
                                             return this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight);
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
      return other instanceof OrderArtifactDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $uncompletedQuantity = this.getUncompletedQuantity();
      result = result * 59 + ($uncompletedQuantity == null ? 43 : $uncompletedQuantity.hashCode());
      Object $currentSchedulingQuantity = this.getCurrentSchedulingQuantity();
      result = result * 59 + ($currentSchedulingQuantity == null ? 43 : $currentSchedulingQuantity.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }
}
