package com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics;

import java.util.List;

public class CappEquipmentInfo {
   private Long id;
   private String name;
   private String code;
   private List<String> weldingGunCodes;

   public static CappEquipmentInfo.CappEquipmentInfoBuilder builder() {
      return new CappEquipmentInfo.CappEquipmentInfoBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getCode() {
      return this.code;
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

   public void setCode(final String code) {
      this.code = code;
   }

   public void setWeldingGunCodes(final List<String> weldingGunCodes) {
      this.weldingGunCodes = weldingGunCodes;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappEquipmentInfo)) {
         return false;
      }

      CappEquipmentInfo other = (CappEquipmentInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$code = this.getCode();
            Object other$code = other.getCode();
            if (this$code == null ? other$code == null : this$code.equals(other$code)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappEquipmentInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $weldingGunCodes = this.getWeldingGunCodes();
      return result * 59 + ($weldingGunCodes == null ? 43 : $weldingGunCodes.hashCode());
   }

   @Override
   public String toString() {
      return "CappEquipmentInfo(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", code="
         + this.getCode()
         + ", weldingGunCodes="
         + this.getWeldingGunCodes()
         + ")";
   }

   public CappEquipmentInfo(final Long id, final String name, final String code, final List<String> weldingGunCodes) {
      this.id = id;
      this.name = name;
      this.code = code;
      this.weldingGunCodes = weldingGunCodes;
   }

   public CappEquipmentInfo() {
   }

   public static class CappEquipmentInfoBuilder {
      private Long id;
      private String name;
      private String code;
      private List<String> weldingGunCodes;

      CappEquipmentInfoBuilder() {
      }

      public CappEquipmentInfo.CappEquipmentInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CappEquipmentInfo.CappEquipmentInfoBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CappEquipmentInfo.CappEquipmentInfoBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public CappEquipmentInfo.CappEquipmentInfoBuilder weldingGunCodes(final List<String> weldingGunCodes) {
         this.weldingGunCodes = weldingGunCodes;
         return this;
      }

      public CappEquipmentInfo build() {
         return new CappEquipmentInfo(this.id, this.name, this.code, this.weldingGunCodes);
      }

      @Override
      public String toString() {
         return "CappEquipmentInfo.CappEquipmentInfoBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", code="
            + this.code
            + ", weldingGunCodes="
            + this.weldingGunCodes
            + ")";
      }
   }
}
