package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.statistica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesEnclosureFabricatedPartConfigDTOParam", description = "配套件单价配置DTOParam ")
public class MesEnclosureFabricatedPartConfigDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "auxiliaryId", value = "配套件分类id")
   private Long auxiliaryId;
   @ApiModelProperty(name = "auxiliaryName", value = "配套件种类名称")
   private String auxiliaryName;
   @ApiModelProperty(name = "basicClass", value = "物料基础分类")
   private Integer basicClass;
   @ApiModelProperty(name = "unitPrice", value = "单价")
   private BigDecimal unitPrice;

   public static MesEnclosureFabricatedPartConfigDTOParam.MesEnclosureFabricatedPartConfigDTOParamBuilder builder() {
      return new MesEnclosureFabricatedPartConfigDTOParam.MesEnclosureFabricatedPartConfigDTOParamBuilder();
   }

   public MesEnclosureFabricatedPartConfigDTOParam() {
   }

   public MesEnclosureFabricatedPartConfigDTOParam(
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

   public MesEnclosureFabricatedPartConfigDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesEnclosureFabricatedPartConfigDTOParam setAuxiliaryId(final Long auxiliaryId) {
      this.auxiliaryId = auxiliaryId;
      return this;
   }

   public MesEnclosureFabricatedPartConfigDTOParam setAuxiliaryName(final String auxiliaryName) {
      this.auxiliaryName = auxiliaryName;
      return this;
   }

   public MesEnclosureFabricatedPartConfigDTOParam setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public MesEnclosureFabricatedPartConfigDTOParam setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureFabricatedPartConfigDTOParam(id="
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

      if (!(o instanceof MesEnclosureFabricatedPartConfigDTOParam)) {
         return false;
      }

      MesEnclosureFabricatedPartConfigDTOParam other = (MesEnclosureFabricatedPartConfigDTOParam)o;
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
      return other instanceof MesEnclosureFabricatedPartConfigDTOParam;
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

   public static class MesEnclosureFabricatedPartConfigDTOParamBuilder {
      private Long id;
      private Long auxiliaryId;
      private String auxiliaryName;
      private Integer basicClass;
      private BigDecimal unitPrice;

      MesEnclosureFabricatedPartConfigDTOParamBuilder() {
      }

      public MesEnclosureFabricatedPartConfigDTOParam.MesEnclosureFabricatedPartConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureFabricatedPartConfigDTOParam.MesEnclosureFabricatedPartConfigDTOParamBuilder auxiliaryId(final Long auxiliaryId) {
         this.auxiliaryId = auxiliaryId;
         return this;
      }

      public MesEnclosureFabricatedPartConfigDTOParam.MesEnclosureFabricatedPartConfigDTOParamBuilder auxiliaryName(final String auxiliaryName) {
         this.auxiliaryName = auxiliaryName;
         return this;
      }

      public MesEnclosureFabricatedPartConfigDTOParam.MesEnclosureFabricatedPartConfigDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MesEnclosureFabricatedPartConfigDTOParam.MesEnclosureFabricatedPartConfigDTOParamBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesEnclosureFabricatedPartConfigDTOParam build() {
         return new MesEnclosureFabricatedPartConfigDTOParam(this.id, this.auxiliaryId, this.auxiliaryName, this.basicClass, this.unitPrice);
      }

      @Override
      public String toString() {
         return "MesEnclosureFabricatedPartConfigDTOParam.MesEnclosureFabricatedPartConfigDTOParamBuilder(id="
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
