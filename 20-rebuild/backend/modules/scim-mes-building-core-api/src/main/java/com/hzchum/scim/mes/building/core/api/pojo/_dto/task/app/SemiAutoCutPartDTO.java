package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "APPQuantityAndMeteDTO", description = "半自动切割任务详情")
public class SemiAutoCutPartDTO {
   private Long id;
   private Long partId;
   private String partNumber;
   private String specification;
   private Integer quantity;
   private Integer completeQuantity;
   private String thumbnail;
   private String thick;
   @ApiModelProperty("长度")
   private BigDecimal length;
   private BigDecimal netWeight;
   private String material;
   @ApiModelProperty(name = "boolLayoffCompleteEnum", value = "下料是否完成", notes = "下料是否完成")
   @JsonProperty("boolLayoffCompleteEnum")
   @JSONField(name = "boolLayoffCompleteEnum")
   private Boolean boolLayoffCompleteEnum;
   @ApiModelProperty(name = "boolCompleteEnum", value = "是否完成", notes = "是否完成")
   @JsonProperty("boolCompleteEnum")
   @JSONField(name = "boolCompleteEnum")
   private Boolean boolCompleteEnum;
   @ApiModelProperty(name = "labelStatus", value = "打标状态", notes = "打标状态")
   @JsonProperty("labelStatus")
   @JSONField(name = "labelStatus")
   private Integer labelStatus;
   @ApiModelProperty(name = "monomerName", value = "单体名称", notes = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "monomerId", value = "单体Id", notes = "单体Id")
   private Long monomerId;

   public static SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder builder() {
      return new SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder();
   }

   public SemiAutoCutPartDTO() {
   }

   public SemiAutoCutPartDTO(
      final Long id,
      final Long partId,
      final String partNumber,
      final String specification,
      final Integer quantity,
      final Integer completeQuantity,
      final String thumbnail,
      final String thick,
      final BigDecimal length,
      final BigDecimal netWeight,
      final String material,
      final Boolean boolLayoffCompleteEnum,
      final Boolean boolCompleteEnum,
      final Integer labelStatus,
      final String monomerName,
      final Long monomerId
   ) {
      this.id = id;
      this.partId = partId;
      this.partNumber = partNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.completeQuantity = completeQuantity;
      this.thumbnail = thumbnail;
      this.thick = thick;
      this.length = length;
      this.netWeight = netWeight;
      this.material = material;
      this.boolLayoffCompleteEnum = boolLayoffCompleteEnum;
      this.boolCompleteEnum = boolCompleteEnum;
      this.labelStatus = labelStatus;
      this.monomerName = monomerName;
      this.monomerId = monomerId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPartId() {
      return this.partId;
   }

   public String getPartNumber() {
      return this.partNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public String getThumbnail() {
      return this.thumbnail;
   }

   public String getThick() {
      return this.thick;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public String getMaterial() {
      return this.material;
   }

   public Boolean getBoolLayoffCompleteEnum() {
      return this.boolLayoffCompleteEnum;
   }

   public Boolean getBoolCompleteEnum() {
      return this.boolCompleteEnum;
   }

   public Integer getLabelStatus() {
      return this.labelStatus;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public SemiAutoCutPartDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public SemiAutoCutPartDTO setPartId(final Long partId) {
      this.partId = partId;
      return this;
   }

   public SemiAutoCutPartDTO setPartNumber(final String partNumber) {
      this.partNumber = partNumber;
      return this;
   }

   public SemiAutoCutPartDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public SemiAutoCutPartDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public SemiAutoCutPartDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   public SemiAutoCutPartDTO setThumbnail(final String thumbnail) {
      this.thumbnail = thumbnail;
      return this;
   }

   public SemiAutoCutPartDTO setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   public SemiAutoCutPartDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public SemiAutoCutPartDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public SemiAutoCutPartDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("boolLayoffCompleteEnum")
   public SemiAutoCutPartDTO setBoolLayoffCompleteEnum(final Boolean boolLayoffCompleteEnum) {
      this.boolLayoffCompleteEnum = boolLayoffCompleteEnum;
      return this;
   }

   @JsonProperty("boolCompleteEnum")
   public SemiAutoCutPartDTO setBoolCompleteEnum(final Boolean boolCompleteEnum) {
      this.boolCompleteEnum = boolCompleteEnum;
      return this;
   }

   @JsonProperty("labelStatus")
   public SemiAutoCutPartDTO setLabelStatus(final Integer labelStatus) {
      this.labelStatus = labelStatus;
      return this;
   }

   public SemiAutoCutPartDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   public SemiAutoCutPartDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @Override
   public String toString() {
      return "SemiAutoCutPartDTO(id="
         + this.getId()
         + ", partId="
         + this.getPartId()
         + ", partNumber="
         + this.getPartNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", thumbnail="
         + this.getThumbnail()
         + ", thick="
         + this.getThick()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", material="
         + this.getMaterial()
         + ", boolLayoffCompleteEnum="
         + this.getBoolLayoffCompleteEnum()
         + ", boolCompleteEnum="
         + this.getBoolCompleteEnum()
         + ", labelStatus="
         + this.getLabelStatus()
         + ", monomerName="
         + this.getMonomerName()
         + ", monomerId="
         + this.getMonomerId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SemiAutoCutPartDTO)) {
         return false;
      }

      SemiAutoCutPartDTO other = (SemiAutoCutPartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$partId = this.getPartId();
         Object other$partId = other.getPartId();
         if (this$partId == null ? other$partId == null : this$partId.equals(other$partId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$completeQuantity = this.getCompleteQuantity();
               Object other$completeQuantity = other.getCompleteQuantity();
               if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                  Object this$boolLayoffCompleteEnum = this.getBoolLayoffCompleteEnum();
                  Object other$boolLayoffCompleteEnum = other.getBoolLayoffCompleteEnum();
                  if (this$boolLayoffCompleteEnum == null
                     ? other$boolLayoffCompleteEnum == null
                     : this$boolLayoffCompleteEnum.equals(other$boolLayoffCompleteEnum)) {
                     Object this$boolCompleteEnum = this.getBoolCompleteEnum();
                     Object other$boolCompleteEnum = other.getBoolCompleteEnum();
                     if (this$boolCompleteEnum == null ? other$boolCompleteEnum == null : this$boolCompleteEnum.equals(other$boolCompleteEnum)) {
                        Object this$labelStatus = this.getLabelStatus();
                        Object other$labelStatus = other.getLabelStatus();
                        if (this$labelStatus == null ? other$labelStatus == null : this$labelStatus.equals(other$labelStatus)) {
                           Object this$monomerId = this.getMonomerId();
                           Object other$monomerId = other.getMonomerId();
                           if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                              Object this$partNumber = this.getPartNumber();
                              Object other$partNumber = other.getPartNumber();
                              if (this$partNumber == null ? other$partNumber == null : this$partNumber.equals(other$partNumber)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$thumbnail = this.getThumbnail();
                                    Object other$thumbnail = other.getThumbnail();
                                    if (this$thumbnail == null ? other$thumbnail == null : this$thumbnail.equals(other$thumbnail)) {
                                       Object this$thick = this.getThick();
                                       Object other$thick = other.getThick();
                                       if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$netWeight = this.getNetWeight();
                                             Object other$netWeight = other.getNetWeight();
                                             if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                Object this$material = this.getMaterial();
                                                Object other$material = other.getMaterial();
                                                if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                   Object this$monomerName = this.getMonomerName();
                                                   Object other$monomerName = other.getMonomerName();
                                                   return this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName);
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
      return other instanceof SemiAutoCutPartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $partId = this.getPartId();
      result = result * 59 + ($partId == null ? 43 : $partId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $boolLayoffCompleteEnum = this.getBoolLayoffCompleteEnum();
      result = result * 59 + ($boolLayoffCompleteEnum == null ? 43 : $boolLayoffCompleteEnum.hashCode());
      Object $boolCompleteEnum = this.getBoolCompleteEnum();
      result = result * 59 + ($boolCompleteEnum == null ? 43 : $boolCompleteEnum.hashCode());
      Object $labelStatus = this.getLabelStatus();
      result = result * 59 + ($labelStatus == null ? 43 : $labelStatus.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $partNumber = this.getPartNumber();
      result = result * 59 + ($partNumber == null ? 43 : $partNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thumbnail = this.getThumbnail();
      result = result * 59 + ($thumbnail == null ? 43 : $thumbnail.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $monomerName = this.getMonomerName();
      return result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
   }

   public static class SemiAutoCutPartDTOBuilder {
      private Long id;
      private Long partId;
      private String partNumber;
      private String specification;
      private Integer quantity;
      private Integer completeQuantity;
      private String thumbnail;
      private String thick;
      private BigDecimal length;
      private BigDecimal netWeight;
      private String material;
      private Boolean boolLayoffCompleteEnum;
      private Boolean boolCompleteEnum;
      private Integer labelStatus;
      private String monomerName;
      private Long monomerId;

      SemiAutoCutPartDTOBuilder() {
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder partId(final Long partId) {
         this.partId = partId;
         return this;
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder partNumber(final String partNumber) {
         this.partNumber = partNumber;
         return this;
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder thumbnail(final String thumbnail) {
         this.thumbnail = thumbnail;
         return this;
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("boolLayoffCompleteEnum")
      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder boolLayoffCompleteEnum(final Boolean boolLayoffCompleteEnum) {
         this.boolLayoffCompleteEnum = boolLayoffCompleteEnum;
         return this;
      }

      @JsonProperty("boolCompleteEnum")
      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder boolCompleteEnum(final Boolean boolCompleteEnum) {
         this.boolCompleteEnum = boolCompleteEnum;
         return this;
      }

      @JsonProperty("labelStatus")
      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder labelStatus(final Integer labelStatus) {
         this.labelStatus = labelStatus;
         return this;
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public SemiAutoCutPartDTO build() {
         return new SemiAutoCutPartDTO(
            this.id,
            this.partId,
            this.partNumber,
            this.specification,
            this.quantity,
            this.completeQuantity,
            this.thumbnail,
            this.thick,
            this.length,
            this.netWeight,
            this.material,
            this.boolLayoffCompleteEnum,
            this.boolCompleteEnum,
            this.labelStatus,
            this.monomerName,
            this.monomerId
         );
      }

      @Override
      public String toString() {
         return "SemiAutoCutPartDTO.SemiAutoCutPartDTOBuilder(id="
            + this.id
            + ", partId="
            + this.partId
            + ", partNumber="
            + this.partNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", thumbnail="
            + this.thumbnail
            + ", thick="
            + this.thick
            + ", length="
            + this.length
            + ", netWeight="
            + this.netWeight
            + ", material="
            + this.material
            + ", boolLayoffCompleteEnum="
            + this.boolLayoffCompleteEnum
            + ", boolCompleteEnum="
            + this.boolCompleteEnum
            + ", labelStatus="
            + this.labelStatus
            + ", monomerName="
            + this.monomerName
            + ", monomerId="
            + this.monomerId
            + ")";
      }
   }
}
