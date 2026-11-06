package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

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
   @ApiModelProperty(name = "planId", value = "区域id", notes = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
   @ApiModelProperty(name = "areaName", value = "区域名", notes = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", value = "车间名", notes = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
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
   @ApiModelProperty(name = "cargoGrossWeight", value = "发运量(毛重)", notes = "发运量(毛重)")
   @JsonProperty("cargoGrossWeight")
   @JSONField(name = "cargoGrossWeight")
   private BigDecimal cargoGrossWeight;
   @ApiModelProperty(name = "cargoNetWeight", value = "发运量(净重)", notes = "发运量(净重)")
   @JsonProperty("cargoNetWeight")
   @JSONField(name = "cargoNetWeight")
   private BigDecimal cargoNetWeight;

   ProjectCargoListMeteDetailDTO(
      final Long monomerId,
      final String monomerName,
      final Long planId,
      final String areaName,
      final Long workshopId,
      final String workshopName,
      final String serialNumber,
      final String name,
      final BigDecimal grossWeight,
      final BigDecimal netWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal totalNetWeight,
      final Integer quantity,
      final Integer inboundQuantity,
      final Integer cargoQuantity,
      final BigDecimal cargoGrossWeight,
      final BigDecimal cargoNetWeight
   ) {
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.planId = planId;
      this.areaName = areaName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.serialNumber = serialNumber;
      this.name = name;
      this.grossWeight = grossWeight;
      this.netWeight = netWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.totalNetWeight = totalNetWeight;
      this.quantity = quantity;
      this.inboundQuantity = inboundQuantity;
      this.cargoQuantity = cargoQuantity;
      this.cargoGrossWeight = cargoGrossWeight;
      this.cargoNetWeight = cargoNetWeight;
   }

   public static ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder builder() {
      return new ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder();
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
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

   public BigDecimal getCargoGrossWeight() {
      return this.cargoGrossWeight;
   }

   public BigDecimal getCargoNetWeight() {
      return this.cargoNetWeight;
   }

   @JsonProperty("monomerId")
   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   @JsonProperty("monomerName")
   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   @JsonProperty("planId")
   public void setPlanId(final Long planId) {
      this.planId = planId;
   }

   @JsonProperty("areaName")
   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   @JsonProperty("workshopId")
   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   @JsonProperty("workshopName")
   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
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

   @JsonProperty("cargoGrossWeight")
   public void setCargoGrossWeight(final BigDecimal cargoGrossWeight) {
      this.cargoGrossWeight = cargoGrossWeight;
   }

   @JsonProperty("cargoNetWeight")
   public void setCargoNetWeight(final BigDecimal cargoNetWeight) {
      this.cargoNetWeight = cargoNetWeight;
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
         Object this$planId = this.getPlanId();
         Object other$planId = other.getPlanId();
         if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$inboundQuantity = this.getInboundQuantity();
                  Object other$inboundQuantity = other.getInboundQuantity();
                  if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
                     Object this$cargoQuantity = this.getCargoQuantity();
                     Object other$cargoQuantity = other.getCargoQuantity();
                     if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
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
                                       Object this$grossWeight = this.getGrossWeight();
                                       Object other$grossWeight = other.getGrossWeight();
                                       if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                          Object this$netWeight = this.getNetWeight();
                                          Object other$netWeight = other.getNetWeight();
                                          if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
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
                                                   Object this$cargoGrossWeight = this.getCargoGrossWeight();
                                                   Object other$cargoGrossWeight = other.getCargoGrossWeight();
                                                   if (this$cargoGrossWeight == null
                                                      ? other$cargoGrossWeight == null
                                                      : this$cargoGrossWeight.equals(other$cargoGrossWeight)) {
                                                      Object this$cargoNetWeight = this.getCargoNetWeight();
                                                      Object other$cargoNetWeight = other.getCargoNetWeight();
                                                      return this$cargoNetWeight == null
                                                         ? other$cargoNetWeight == null
                                                         : this$cargoNetWeight.equals(other$cargoNetWeight);
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
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
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
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $cargoGrossWeight = this.getCargoGrossWeight();
      result = result * 59 + ($cargoGrossWeight == null ? 43 : $cargoGrossWeight.hashCode());
      Object $cargoNetWeight = this.getCargoNetWeight();
      return result * 59 + ($cargoNetWeight == null ? 43 : $cargoNetWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCargoListMeteDetailDTO(monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", planId="
         + this.getPlanId()
         + ", areaName="
         + this.getAreaName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
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
         + ", cargoGrossWeight="
         + this.getCargoGrossWeight()
         + ", cargoNetWeight="
         + this.getCargoNetWeight()
         + ")";
   }

   public static class ProjectCargoListMeteDetailDTOBuilder {
      private Long monomerId;
      private String monomerName;
      private Long planId;
      private String areaName;
      private Long workshopId;
      private String workshopName;
      private String serialNumber;
      private String name;
      private BigDecimal grossWeight;
      private BigDecimal netWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal totalNetWeight;
      private Integer quantity;
      private Integer inboundQuantity;
      private Integer cargoQuantity;
      private BigDecimal cargoGrossWeight;
      private BigDecimal cargoNetWeight;

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

      @JsonProperty("planId")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("areaName")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("workshopId")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
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

      public ProjectCargoListMeteDetailDTO build() {
         return new ProjectCargoListMeteDetailDTO(
            this.monomerId,
            this.monomerName,
            this.planId,
            this.areaName,
            this.workshopId,
            this.workshopName,
            this.serialNumber,
            this.name,
            this.grossWeight,
            this.netWeight,
            this.totalGrossWeight,
            this.totalNetWeight,
            this.quantity,
            this.inboundQuantity,
            this.cargoQuantity,
            this.cargoGrossWeight,
            this.cargoNetWeight
         );
      }

      @Override
      public String toString() {
         return "ProjectCargoListMeteDetailDTO.ProjectCargoListMeteDetailDTOBuilder(monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", planId="
            + this.planId
            + ", areaName="
            + this.areaName
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
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
            + ", cargoGrossWeight="
            + this.cargoGrossWeight
            + ", cargoNetWeight="
            + this.cargoNetWeight
            + ")";
      }
   }
}
