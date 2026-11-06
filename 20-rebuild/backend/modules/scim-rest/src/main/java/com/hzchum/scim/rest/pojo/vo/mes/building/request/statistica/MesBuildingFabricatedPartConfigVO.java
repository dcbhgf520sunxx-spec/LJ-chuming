package com.hzchum.scim.rest.pojo.vo.mes.building.request.statistica;

import com.hzchum.pangu.common.valid.Delete;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingFabricatedPartConfigVO", description = "配套件配置DTO ")
public class MesBuildingFabricatedPartConfigVO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "auxiliaryId", value = "配套件种类id")
   @NotNull(message = "配套件种类id不能为空", groups = {Delete.class, Update.class})
   private Long auxiliaryId;
   @ApiModelProperty(name = "auxiliaryName", value = "配套件种类名称")
   @NotNull(message = "配套件种类名称不能为空", groups = Update.class)
   private String auxiliaryName;
   @ApiModelProperty(name = "basicClass", value = "物料基础分类")
   @NotNull(message = "物料基础分类不能为空", groups = Update.class)
   private Integer basicClass;
   @ApiModelProperty(name = "unitPrice", value = "单价")
   @NotNull(message = "单价不能为空", groups = Update.class)
   @Min(value = 0L, message = "单价不能小于0")
   private BigDecimal unitPrice;

   public static MesBuildingFabricatedPartConfigVO.MesBuildingFabricatedPartConfigVOBuilder builder() {
      return new MesBuildingFabricatedPartConfigVO.MesBuildingFabricatedPartConfigVOBuilder();
   }

   public MesBuildingFabricatedPartConfigVO() {
   }

   public MesBuildingFabricatedPartConfigVO(
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuxiliaryId(final Long auxiliaryId) {
      this.auxiliaryId = auxiliaryId;
   }

   public void setAuxiliaryName(final String auxiliaryName) {
      this.auxiliaryName = auxiliaryName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @Override
   public String toString() {
      return "MesBuildingFabricatedPartConfigVO(id="
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

      if (!(o instanceof MesBuildingFabricatedPartConfigVO)) {
         return false;
      }

      MesBuildingFabricatedPartConfigVO other = (MesBuildingFabricatedPartConfigVO)o;
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
      return other instanceof MesBuildingFabricatedPartConfigVO;
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

   public static class MesBuildingFabricatedPartConfigVOBuilder {
      private Long id;
      private Long auxiliaryId;
      private String auxiliaryName;
      private Integer basicClass;
      private BigDecimal unitPrice;

      MesBuildingFabricatedPartConfigVOBuilder() {
      }

      public MesBuildingFabricatedPartConfigVO.MesBuildingFabricatedPartConfigVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingFabricatedPartConfigVO.MesBuildingFabricatedPartConfigVOBuilder auxiliaryId(final Long auxiliaryId) {
         this.auxiliaryId = auxiliaryId;
         return this;
      }

      public MesBuildingFabricatedPartConfigVO.MesBuildingFabricatedPartConfigVOBuilder auxiliaryName(final String auxiliaryName) {
         this.auxiliaryName = auxiliaryName;
         return this;
      }

      public MesBuildingFabricatedPartConfigVO.MesBuildingFabricatedPartConfigVOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MesBuildingFabricatedPartConfigVO.MesBuildingFabricatedPartConfigVOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesBuildingFabricatedPartConfigVO build() {
         return new MesBuildingFabricatedPartConfigVO(this.id, this.auxiliaryId, this.auxiliaryName, this.basicClass, this.unitPrice);
      }

      @Override
      public String toString() {
         return "MesBuildingFabricatedPartConfigVO.MesBuildingFabricatedPartConfigVOBuilder(id="
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
