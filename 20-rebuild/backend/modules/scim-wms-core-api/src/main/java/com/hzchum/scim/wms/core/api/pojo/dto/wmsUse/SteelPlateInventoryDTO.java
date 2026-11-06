package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.math.BigDecimal;

public class SteelPlateInventoryDTO {
   private Long id;
   private String plateNo;
   private String specification;
   private BigDecimal thickness;
   private BigDecimal width;
   private BigDecimal length;
   private BigDecimal quantity;
   private Integer IsRemnant;
   private String userdata1;
   private String heatNoAndBatchNo;
   private String warehouseName;
   private Long plateId;
   private String dxfUrl;
   private String imgUrl;
   private Boolean boolNestVirtual;
   private Long materialId;
   private Boolean boolPartyA;

   public static SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder builder() {
      return new SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getPlateNo() {
      return this.plateNo;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Integer getIsRemnant() {
      return this.IsRemnant;
   }

   public String getUserdata1() {
      return this.userdata1;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getWarehouseName() {
      return this.warehouseName;
   }

   public Long getPlateId() {
      return this.plateId;
   }

   public String getDxfUrl() {
      return this.dxfUrl;
   }

   public String getImgUrl() {
      return this.imgUrl;
   }

   public Boolean getBoolNestVirtual() {
      return this.boolNestVirtual;
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPlateNo(final String plateNo) {
      this.plateNo = plateNo;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setIsRemnant(final Integer IsRemnant) {
      this.IsRemnant = IsRemnant;
   }

   public void setUserdata1(final String userdata1) {
      this.userdata1 = userdata1;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setWarehouseName(final String warehouseName) {
      this.warehouseName = warehouseName;
   }

   public void setPlateId(final Long plateId) {
      this.plateId = plateId;
   }

   public void setDxfUrl(final String dxfUrl) {
      this.dxfUrl = dxfUrl;
   }

   public void setImgUrl(final String imgUrl) {
      this.imgUrl = imgUrl;
   }

   public void setBoolNestVirtual(final Boolean boolNestVirtual) {
      this.boolNestVirtual = boolNestVirtual;
   }

   public void setMaterialId(final Long materialId) {
      this.materialId = materialId;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelPlateInventoryDTO)) {
         return false;
      }

      SteelPlateInventoryDTO other = (SteelPlateInventoryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$IsRemnant = this.getIsRemnant();
         Object other$IsRemnant = other.getIsRemnant();
         if (this$IsRemnant == null ? other$IsRemnant == null : this$IsRemnant.equals(other$IsRemnant)) {
            Object this$plateId = this.getPlateId();
            Object other$plateId = other.getPlateId();
            if (this$plateId == null ? other$plateId == null : this$plateId.equals(other$plateId)) {
               Object this$boolNestVirtual = this.getBoolNestVirtual();
               Object other$boolNestVirtual = other.getBoolNestVirtual();
               if (this$boolNestVirtual == null ? other$boolNestVirtual == null : this$boolNestVirtual.equals(other$boolNestVirtual)) {
                  Object this$materialId = this.getMaterialId();
                  Object other$materialId = other.getMaterialId();
                  if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
                     Object this$boolPartyA = this.getBoolPartyA();
                     Object other$boolPartyA = other.getBoolPartyA();
                     if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                        Object this$plateNo = this.getPlateNo();
                        Object other$plateNo = other.getPlateNo();
                        if (this$plateNo == null ? other$plateNo == null : this$plateNo.equals(other$plateNo)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$thickness = this.getThickness();
                              Object other$thickness = other.getThickness();
                              if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                 Object this$width = this.getWidth();
                                 Object other$width = other.getWidth();
                                 if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                    Object this$length = this.getLength();
                                    Object other$length = other.getLength();
                                    if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                       Object this$quantity = this.getQuantity();
                                       Object other$quantity = other.getQuantity();
                                       if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                          Object this$userdata1 = this.getUserdata1();
                                          Object other$userdata1 = other.getUserdata1();
                                          if (this$userdata1 == null ? other$userdata1 == null : this$userdata1.equals(other$userdata1)) {
                                             Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                             Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                             if (this$heatNoAndBatchNo == null
                                                ? other$heatNoAndBatchNo == null
                                                : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                Object this$warehouseName = this.getWarehouseName();
                                                Object other$warehouseName = other.getWarehouseName();
                                                if (this$warehouseName == null ? other$warehouseName == null : this$warehouseName.equals(other$warehouseName)) {
                                                   Object this$dxfUrl = this.getDxfUrl();
                                                   Object other$dxfUrl = other.getDxfUrl();
                                                   if (this$dxfUrl == null ? other$dxfUrl == null : this$dxfUrl.equals(other$dxfUrl)) {
                                                      Object this$imgUrl = this.getImgUrl();
                                                      Object other$imgUrl = other.getImgUrl();
                                                      return this$imgUrl == null ? other$imgUrl == null : this$imgUrl.equals(other$imgUrl);
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
      return other instanceof SteelPlateInventoryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $IsRemnant = this.getIsRemnant();
      result = result * 59 + ($IsRemnant == null ? 43 : $IsRemnant.hashCode());
      Object $plateId = this.getPlateId();
      result = result * 59 + ($plateId == null ? 43 : $plateId.hashCode());
      Object $boolNestVirtual = this.getBoolNestVirtual();
      result = result * 59 + ($boolNestVirtual == null ? 43 : $boolNestVirtual.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $plateNo = this.getPlateNo();
      result = result * 59 + ($plateNo == null ? 43 : $plateNo.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userdata1 = this.getUserdata1();
      result = result * 59 + ($userdata1 == null ? 43 : $userdata1.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $warehouseName = this.getWarehouseName();
      result = result * 59 + ($warehouseName == null ? 43 : $warehouseName.hashCode());
      Object $dxfUrl = this.getDxfUrl();
      result = result * 59 + ($dxfUrl == null ? 43 : $dxfUrl.hashCode());
      Object $imgUrl = this.getImgUrl();
      return result * 59 + ($imgUrl == null ? 43 : $imgUrl.hashCode());
   }

   @Override
   public String toString() {
      return "SteelPlateInventoryDTO(id="
         + this.getId()
         + ", plateNo="
         + this.getPlateNo()
         + ", specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", IsRemnant="
         + this.getIsRemnant()
         + ", userdata1="
         + this.getUserdata1()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", warehouseName="
         + this.getWarehouseName()
         + ", plateId="
         + this.getPlateId()
         + ", dxfUrl="
         + this.getDxfUrl()
         + ", imgUrl="
         + this.getImgUrl()
         + ", boolNestVirtual="
         + this.getBoolNestVirtual()
         + ", materialId="
         + this.getMaterialId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ")";
   }

   public SteelPlateInventoryDTO(
      final Long id,
      final String plateNo,
      final String specification,
      final BigDecimal thickness,
      final BigDecimal width,
      final BigDecimal length,
      final BigDecimal quantity,
      final Integer IsRemnant,
      final String userdata1,
      final String heatNoAndBatchNo,
      final String warehouseName,
      final Long plateId,
      final String dxfUrl,
      final String imgUrl,
      final Boolean boolNestVirtual,
      final Long materialId,
      final Boolean boolPartyA
   ) {
      this.id = id;
      this.plateNo = plateNo;
      this.specification = specification;
      this.thickness = thickness;
      this.width = width;
      this.length = length;
      this.quantity = quantity;
      this.IsRemnant = IsRemnant;
      this.userdata1 = userdata1;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.warehouseName = warehouseName;
      this.plateId = plateId;
      this.dxfUrl = dxfUrl;
      this.imgUrl = imgUrl;
      this.boolNestVirtual = boolNestVirtual;
      this.materialId = materialId;
      this.boolPartyA = boolPartyA;
   }

   public SteelPlateInventoryDTO() {
   }

   public static class SteelPlateInventoryDTOBuilder {
      private Long id;
      private String plateNo;
      private String specification;
      private BigDecimal thickness;
      private BigDecimal width;
      private BigDecimal length;
      private BigDecimal quantity;
      private Integer IsRemnant;
      private String userdata1;
      private String heatNoAndBatchNo;
      private String warehouseName;
      private Long plateId;
      private String dxfUrl;
      private String imgUrl;
      private Boolean boolNestVirtual;
      private Long materialId;
      private Boolean boolPartyA;

      SteelPlateInventoryDTOBuilder() {
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder plateNo(final String plateNo) {
         this.plateNo = plateNo;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder IsRemnant(final Integer IsRemnant) {
         this.IsRemnant = IsRemnant;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder userdata1(final String userdata1) {
         this.userdata1 = userdata1;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder warehouseName(final String warehouseName) {
         this.warehouseName = warehouseName;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder plateId(final Long plateId) {
         this.plateId = plateId;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder dxfUrl(final String dxfUrl) {
         this.dxfUrl = dxfUrl;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder imgUrl(final String imgUrl) {
         this.imgUrl = imgUrl;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder boolNestVirtual(final Boolean boolNestVirtual) {
         this.boolNestVirtual = boolNestVirtual;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      public SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public SteelPlateInventoryDTO build() {
         return new SteelPlateInventoryDTO(
            this.id,
            this.plateNo,
            this.specification,
            this.thickness,
            this.width,
            this.length,
            this.quantity,
            this.IsRemnant,
            this.userdata1,
            this.heatNoAndBatchNo,
            this.warehouseName,
            this.plateId,
            this.dxfUrl,
            this.imgUrl,
            this.boolNestVirtual,
            this.materialId,
            this.boolPartyA
         );
      }

      @Override
      public String toString() {
         return "SteelPlateInventoryDTO.SteelPlateInventoryDTOBuilder(id="
            + this.id
            + ", plateNo="
            + this.plateNo
            + ", specification="
            + this.specification
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", IsRemnant="
            + this.IsRemnant
            + ", userdata1="
            + this.userdata1
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", warehouseName="
            + this.warehouseName
            + ", plateId="
            + this.plateId
            + ", dxfUrl="
            + this.dxfUrl
            + ", imgUrl="
            + this.imgUrl
            + ", boolNestVirtual="
            + this.boolNestVirtual
            + ", materialId="
            + this.materialId
            + ", boolPartyA="
            + this.boolPartyA
            + ")";
      }
   }
}
