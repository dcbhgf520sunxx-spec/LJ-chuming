package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运量-围护")
public class ProjectCargoListEnclosureDetailDTO {
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划id", notes = "围护计划id")
   @JsonProperty("enclosurePlanId")
   @JSONField(name = "enclosurePlanId")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "areaName", value = "围护计划名", notes = "围护计划名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String enclosurePlanName;
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
   @ApiModelProperty(name = "plate", notes = "版型", value = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "length", value = "单长度", notes = "单长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "surfaceArea", value = "单面积", notes = "单面积")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   private Integer surfaceArea;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "totalLength", value = "总长度", notes = "总长度")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积", notes = "总面积")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;
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
   @ApiModelProperty(name = "cargoTotalLength", value = "发运总长度", notes = "发运总长度")
   @JsonProperty("cargoTotalLength")
   @JSONField(name = "cargoTotalLength")
   private BigDecimal cargoTotalLength;
   @ApiModelProperty(name = "cargoTotalArea", value = "发运总面积", notes = "发运总面积")
   @JsonProperty("cargoTotalArea")
   @JSONField(name = "cargoTotalArea")
   private BigDecimal cargoTotalArea;

   public static ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder builder() {
      return new ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder();
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public String getEnclosurePlanName() {
      return this.enclosurePlanName;
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

   public String getPlate() {
      return this.plate;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
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

   public BigDecimal getCargoTotalLength() {
      return this.cargoTotalLength;
   }

   public BigDecimal getCargoTotalArea() {
      return this.cargoTotalArea;
   }

   @JsonProperty("enclosurePlanId")
   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   @JsonProperty("areaName")
   public void setEnclosurePlanName(final String enclosurePlanName) {
      this.enclosurePlanName = enclosurePlanName;
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

   @JsonProperty("plate")
   public void setPlate(final String plate) {
      this.plate = plate;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("surfaceArea")
   public void setSurfaceArea(final Integer surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("totalLength")
   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   @JsonProperty("totalArea")
   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
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

   @JsonProperty("cargoTotalLength")
   public void setCargoTotalLength(final BigDecimal cargoTotalLength) {
      this.cargoTotalLength = cargoTotalLength;
   }

   @JsonProperty("cargoTotalArea")
   public void setCargoTotalArea(final BigDecimal cargoTotalArea) {
      this.cargoTotalArea = cargoTotalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCargoListEnclosureDetailDTO)) {
         return false;
      }

      ProjectCargoListEnclosureDetailDTO other = (ProjectCargoListEnclosureDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$enclosurePlanId = this.getEnclosurePlanId();
      Object other$enclosurePlanId = other.getEnclosurePlanId();
      if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$surfaceArea = this.getSurfaceArea();
            Object other$surfaceArea = other.getSurfaceArea();
            if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$inboundQuantity = this.getInboundQuantity();
                  Object other$inboundQuantity = other.getInboundQuantity();
                  if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
                     Object this$cargoQuantity = this.getCargoQuantity();
                     Object other$cargoQuantity = other.getCargoQuantity();
                     if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
                        Object this$enclosurePlanName = this.getEnclosurePlanName();
                        Object other$enclosurePlanName = other.getEnclosurePlanName();
                        if (this$enclosurePlanName == null ? other$enclosurePlanName == null : this$enclosurePlanName.equals(other$enclosurePlanName)) {
                           Object this$workshopName = this.getWorkshopName();
                           Object other$workshopName = other.getWorkshopName();
                           if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$plate = this.getPlate();
                                    Object other$plate = other.getPlate();
                                    if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                             Object this$totalLength = this.getTotalLength();
                                             Object other$totalLength = other.getTotalLength();
                                             if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                                Object this$totalArea = this.getTotalArea();
                                                Object other$totalArea = other.getTotalArea();
                                                if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                                   Object this$cargoTotalLength = this.getCargoTotalLength();
                                                   Object other$cargoTotalLength = other.getCargoTotalLength();
                                                   if (this$cargoTotalLength == null
                                                      ? other$cargoTotalLength == null
                                                      : this$cargoTotalLength.equals(other$cargoTotalLength)) {
                                                      Object this$cargoTotalArea = this.getCargoTotalArea();
                                                      Object other$cargoTotalArea = other.getCargoTotalArea();
                                                      return this$cargoTotalArea == null
                                                         ? other$cargoTotalArea == null
                                                         : this$cargoTotalArea.equals(other$cargoTotalArea);
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
      return other instanceof ProjectCargoListEnclosureDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $enclosurePlanName = this.getEnclosurePlanName();
      result = result * 59 + ($enclosurePlanName == null ? 43 : $enclosurePlanName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $cargoTotalLength = this.getCargoTotalLength();
      result = result * 59 + ($cargoTotalLength == null ? 43 : $cargoTotalLength.hashCode());
      Object $cargoTotalArea = this.getCargoTotalArea();
      return result * 59 + ($cargoTotalArea == null ? 43 : $cargoTotalArea.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCargoListEnclosureDetailDTO(enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", enclosurePlanName="
         + this.getEnclosurePlanName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", plate="
         + this.getPlate()
         + ", length="
         + this.getLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", remark="
         + this.getRemark()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", quantity="
         + this.getQuantity()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ", cargoTotalLength="
         + this.getCargoTotalLength()
         + ", cargoTotalArea="
         + this.getCargoTotalArea()
         + ")";
   }

   public ProjectCargoListEnclosureDetailDTO() {
   }

   public ProjectCargoListEnclosureDetailDTO(
      final Long enclosurePlanId,
      final String enclosurePlanName,
      final Long workshopId,
      final String workshopName,
      final String serialNumber,
      final String name,
      final String plate,
      final BigDecimal length,
      final Integer surfaceArea,
      final String remark,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final Integer quantity,
      final Integer inboundQuantity,
      final Integer cargoQuantity,
      final BigDecimal cargoTotalLength,
      final BigDecimal cargoTotalArea
   ) {
      this.enclosurePlanId = enclosurePlanId;
      this.enclosurePlanName = enclosurePlanName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.serialNumber = serialNumber;
      this.name = name;
      this.plate = plate;
      this.length = length;
      this.surfaceArea = surfaceArea;
      this.remark = remark;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.quantity = quantity;
      this.inboundQuantity = inboundQuantity;
      this.cargoQuantity = cargoQuantity;
      this.cargoTotalLength = cargoTotalLength;
      this.cargoTotalArea = cargoTotalArea;
   }

   public static class ProjectCargoListEnclosureDetailDTOBuilder {
      private Long enclosurePlanId;
      private String enclosurePlanName;
      private Long workshopId;
      private String workshopName;
      private String serialNumber;
      private String name;
      private String plate;
      private BigDecimal length;
      private Integer surfaceArea;
      private String remark;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private Integer quantity;
      private Integer inboundQuantity;
      private Integer cargoQuantity;
      private BigDecimal cargoTotalLength;
      private BigDecimal cargoTotalArea;

      ProjectCargoListEnclosureDetailDTOBuilder() {
      }

      @JsonProperty("enclosurePlanId")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      @JsonProperty("areaName")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder enclosurePlanName(final String enclosurePlanName) {
         this.enclosurePlanName = enclosurePlanName;
         return this;
      }

      @JsonProperty("workshopId")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("name")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("plate")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("length")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("surfaceArea")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder surfaceArea(final Integer surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("remark")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("totalLength")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("inboundQuantity")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder inboundQuantity(final Integer inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      @JsonProperty("cargoQuantity")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      @JsonProperty("cargoTotalLength")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder cargoTotalLength(final BigDecimal cargoTotalLength) {
         this.cargoTotalLength = cargoTotalLength;
         return this;
      }

      @JsonProperty("cargoTotalArea")
      public ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder cargoTotalArea(final BigDecimal cargoTotalArea) {
         this.cargoTotalArea = cargoTotalArea;
         return this;
      }

      public ProjectCargoListEnclosureDetailDTO build() {
         return new ProjectCargoListEnclosureDetailDTO(
            this.enclosurePlanId,
            this.enclosurePlanName,
            this.workshopId,
            this.workshopName,
            this.serialNumber,
            this.name,
            this.plate,
            this.length,
            this.surfaceArea,
            this.remark,
            this.totalLength,
            this.totalArea,
            this.quantity,
            this.inboundQuantity,
            this.cargoQuantity,
            this.cargoTotalLength,
            this.cargoTotalArea
         );
      }

      @Override
      public String toString() {
         return "ProjectCargoListEnclosureDetailDTO.ProjectCargoListEnclosureDetailDTOBuilder(enclosurePlanId="
            + this.enclosurePlanId
            + ", enclosurePlanName="
            + this.enclosurePlanName
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", plate="
            + this.plate
            + ", length="
            + this.length
            + ", surfaceArea="
            + this.surfaceArea
            + ", remark="
            + this.remark
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", quantity="
            + this.quantity
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", cargoQuantity="
            + this.cargoQuantity
            + ", cargoTotalLength="
            + this.cargoTotalLength
            + ", cargoTotalArea="
            + this.cargoTotalArea
            + ")";
      }
   }
}
