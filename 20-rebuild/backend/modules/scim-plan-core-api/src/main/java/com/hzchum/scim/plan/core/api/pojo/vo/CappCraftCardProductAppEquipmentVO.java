package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "CAPP app焊接设备详情 响应参数")
public class CappCraftCardProductAppEquipmentVO {
   @ApiModelProperty("设备id")
   private Long id;
   @ApiModelProperty("设备名称")
   private String name;
   @ApiModelProperty(name = "equimentCode", value = "设备code", notes = "设备code")
   private String equimentCode;
   @ApiModelProperty("设备编号")
   private String serialNumber;
   @ApiModelProperty("焊接枪编号")
   private List<String> weldingGunCodes;

   CappCraftCardProductAppEquipmentVO(
      final Long id, final String name, final String equimentCode, final String serialNumber, final List<String> weldingGunCodes
   ) {
      this.id = id;
      this.name = name;
      this.equimentCode = equimentCode;
      this.serialNumber = serialNumber;
      this.weldingGunCodes = weldingGunCodes;
   }

   public static CappCraftCardProductAppEquipmentVO.CappCraftCardProductAppEquipmentVOBuilder builder() {
      return new CappCraftCardProductAppEquipmentVO.CappCraftCardProductAppEquipmentVOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getEquimentCode() {
      return this.equimentCode;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<String> getWeldingGunCodes() {
      return this.weldingGunCodes;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setEquimentCode(final String equimentCode) {
      this.equimentCode = equimentCode;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setWeldingGunCodes(final List<String> weldingGunCodes) {
      this.weldingGunCodes = weldingGunCodes;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductAppEquipmentVO)) {
         return false;
      }

      CappCraftCardProductAppEquipmentVO other = (CappCraftCardProductAppEquipmentVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$equimentCode = this.getEquimentCode();
            Object other$equimentCode = other.getEquimentCode();
            if (this$equimentCode == null ? other$equimentCode == null : this$equimentCode.equals(other$equimentCode)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$weldingGunCodes = this.getWeldingGunCodes();
                  Object other$weldingGunCodes = other.getWeldingGunCodes();
                  return this$weldingGunCodes == null ? other$weldingGunCodes == null : this$weldingGunCodes.equals(other$weldingGunCodes);
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
      return other instanceof CappCraftCardProductAppEquipmentVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $equimentCode = this.getEquimentCode();
      result = result * 59 + ($equimentCode == null ? 43 : $equimentCode.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $weldingGunCodes = this.getWeldingGunCodes();
      return result * 59 + ($weldingGunCodes == null ? 43 : $weldingGunCodes.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductAppEquipmentVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", equimentCode="
         + this.getEquimentCode()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", weldingGunCodes="
         + this.getWeldingGunCodes()
         + ")";
   }

   public static class CappCraftCardProductAppEquipmentVOBuilder {
      private Long id;
      private String name;
      private String equimentCode;
      private String serialNumber;
      private List<String> weldingGunCodes;

      CappCraftCardProductAppEquipmentVOBuilder() {
      }

      public CappCraftCardProductAppEquipmentVO.CappCraftCardProductAppEquipmentVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CappCraftCardProductAppEquipmentVO.CappCraftCardProductAppEquipmentVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CappCraftCardProductAppEquipmentVO.CappCraftCardProductAppEquipmentVOBuilder equimentCode(final String equimentCode) {
         this.equimentCode = equimentCode;
         return this;
      }

      public CappCraftCardProductAppEquipmentVO.CappCraftCardProductAppEquipmentVOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CappCraftCardProductAppEquipmentVO.CappCraftCardProductAppEquipmentVOBuilder weldingGunCodes(final List<String> weldingGunCodes) {
         this.weldingGunCodes = weldingGunCodes;
         return this;
      }

      public CappCraftCardProductAppEquipmentVO build() {
         return new CappCraftCardProductAppEquipmentVO(this.id, this.name, this.equimentCode, this.serialNumber, this.weldingGunCodes);
      }

      @Override
      public String toString() {
         return "CappCraftCardProductAppEquipmentVO.CappCraftCardProductAppEquipmentVOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", equimentCode="
            + this.equimentCode
            + ", serialNumber="
            + this.serialNumber
            + ", weldingGunCodes="
            + this.weldingGunCodes
            + ")";
      }
   }
}
