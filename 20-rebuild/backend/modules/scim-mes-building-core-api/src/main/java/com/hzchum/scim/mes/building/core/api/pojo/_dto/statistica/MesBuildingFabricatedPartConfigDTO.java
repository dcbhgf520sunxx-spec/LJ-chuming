package com.hzchum.scim.mes.building.core.api.pojo._dto.statistica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingFabricatedPartConfigDTO", description = "配套件单价配置DTO ")
public class MesBuildingFabricatedPartConfigDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "steelId", value = "配套件种类id")
   private Long auxiliaryId;
   @ApiModelProperty(name = "steelName", value = "配套件种类名称")
   private String auxiliaryName;
   @ApiModelProperty(name = "basicClass", value = "物料基础分类")
   private Integer basicClass;
   @ApiModelProperty(name = "unitPrice", value = "单价")
   private BigDecimal unitPrice;

   public static MesBuildingFabricatedPartConfigDTO.MesBuildingFabricatedPartConfigDTOBuilder builder() {
      return new MesBuildingFabricatedPartConfigDTO.MesBuildingFabricatedPartConfigDTOBuilder();
   }

   public MesBuildingFabricatedPartConfigDTO() {
   }

   public MesBuildingFabricatedPartConfigDTO(
      final Long id, final Long auxiliaryId, final String auxiliaryName, final Integer basicClass, final BigDecimal unitPrice
   ) {
      this.id = id;
      this.auxiliaryId = auxiliaryId;
      this.auxiliaryName = auxiliaryName;
      this.basicClass = basicClass;
      this.unitPrice = unitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAuxiliaryId() {
      return this.auxiliaryId;
   }

   public String getAuxiliaryName() {
      return this.auxiliaryName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public MesBuildingFabricatedPartConfigDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingFabricatedPartConfigDTO setAuxiliaryId(final Long auxiliaryId) {
      this.auxiliaryId = auxiliaryId;
      return this;
   }

   public MesBuildingFabricatedPartConfigDTO setAuxiliaryName(final String auxiliaryName) {
      this.auxiliaryName = auxiliaryName;
      return this;
   }

   public MesBuildingFabricatedPartConfigDTO setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public MesBuildingFabricatedPartConfigDTO setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingFabricatedPartConfigDTO(id="
         + this.getId()
         + ", auxiliaryId="
         + this.getAuxiliaryId()
         + ", auxiliaryName="
         + this.getAuxiliaryName()
         + ", basicClass="
         + this.getBasicClass()
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingFabricatedPartConfigDTO)) {
         return false;
      }

      MesBuildingFabricatedPartConfigDTO other = (MesBuildingFabricatedPartConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auxiliaryId = this.getAuxiliaryId();
         Object other$auxiliaryId = other.getAuxiliaryId();
         if (this$auxiliaryId == null ? other$auxiliaryId == null : this$auxiliaryId.equals(other$auxiliaryId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$auxiliaryName = this.getAuxiliaryName();
               Object other$auxiliaryName = other.getAuxiliaryName();
               if (this$auxiliaryName == null ? other$auxiliaryName == null : this$auxiliaryName.equals(other$auxiliaryName)) {
                  Object this$unitPrice = this.getUnitPrice();
                  Object other$unitPrice = other.getUnitPrice();
                  return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
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
      return other instanceof MesBuildingFabricatedPartConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auxiliaryId = this.getAuxiliaryId();
      result = result * 59 + ($auxiliaryId == null ? 43 : $auxiliaryId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $auxiliaryName = this.getAuxiliaryName();
      result = result * 59 + ($auxiliaryName == null ? 43 : $auxiliaryName.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   public static class MesBuildingFabricatedPartConfigDTOBuilder {
      private Long id;
      private Long auxiliaryId;
      private String auxiliaryName;
      private Integer basicClass;
      private BigDecimal unitPrice;

      MesBuildingFabricatedPartConfigDTOBuilder() {
      }

      public MesBuildingFabricatedPartConfigDTO.MesBuildingFabricatedPartConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingFabricatedPartConfigDTO.MesBuildingFabricatedPartConfigDTOBuilder auxiliaryId(final Long auxiliaryId) {
         this.auxiliaryId = auxiliaryId;
         return this;
      }

      public MesBuildingFabricatedPartConfigDTO.MesBuildingFabricatedPartConfigDTOBuilder auxiliaryName(final String auxiliaryName) {
         this.auxiliaryName = auxiliaryName;
         return this;
      }

      public MesBuildingFabricatedPartConfigDTO.MesBuildingFabricatedPartConfigDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MesBuildingFabricatedPartConfigDTO.MesBuildingFabricatedPartConfigDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesBuildingFabricatedPartConfigDTO build() {
         return new MesBuildingFabricatedPartConfigDTO(this.id, this.auxiliaryId, this.auxiliaryName, this.basicClass, this.unitPrice);
      }

      @Override
      public String toString() {
         return "MesBuildingFabricatedPartConfigDTO.MesBuildingFabricatedPartConfigDTOBuilder(id="
            + this.id
            + ", auxiliaryId="
            + this.auxiliaryId
            + ", auxiliaryName="
            + this.auxiliaryName
            + ", basicClass="
            + this.basicClass
            + ", unitPrice="
            + this.unitPrice
            + ")";
      }
   }
}
