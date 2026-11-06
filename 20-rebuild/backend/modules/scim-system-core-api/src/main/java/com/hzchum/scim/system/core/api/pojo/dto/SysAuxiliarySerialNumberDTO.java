package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysAuxiliarySerialNumber对象", description = "配套件编号表 ")
public class SysAuxiliarySerialNumberDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "auxiliaryClassId", value = "配套件类型ID", notes = "配套件类型ID")
   private Long auxiliaryClassId;

   public static SysAuxiliarySerialNumberDTO.SysAuxiliarySerialNumberDTOBuilder builder() {
      return new SysAuxiliarySerialNumberDTO.SysAuxiliarySerialNumberDTOBuilder();
   }

   public SysAuxiliarySerialNumberDTO() {
   }

   public SysAuxiliarySerialNumberDTO(final Long id, final String serialNumber, final Long auxiliaryClassId) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.auxiliaryClassId = auxiliaryClassId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getAuxiliaryClassId() {
      return this.auxiliaryClassId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setAuxiliaryClassId(final Long auxiliaryClassId) {
      this.auxiliaryClassId = auxiliaryClassId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysAuxiliarySerialNumberDTO)) {
         return false;
      }

      SysAuxiliarySerialNumberDTO other = (SysAuxiliarySerialNumberDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auxiliaryClassId = this.getAuxiliaryClassId();
         Object other$auxiliaryClassId = other.getAuxiliaryClassId();
         if (this$auxiliaryClassId == null ? other$auxiliaryClassId == null : this$auxiliaryClassId.equals(other$auxiliaryClassId)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysAuxiliarySerialNumberDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auxiliaryClassId = this.getAuxiliaryClassId();
      result = result * 59 + ($auxiliaryClassId == null ? 43 : $auxiliaryClassId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "SysAuxiliarySerialNumberDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", auxiliaryClassId="
         + this.getAuxiliaryClassId()
         + ")";
   }

   public static class SysAuxiliarySerialNumberDTOBuilder {
      private Long id;
      private String serialNumber;
      private Long auxiliaryClassId;

      SysAuxiliarySerialNumberDTOBuilder() {
      }

      public SysAuxiliarySerialNumberDTO.SysAuxiliarySerialNumberDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysAuxiliarySerialNumberDTO.SysAuxiliarySerialNumberDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SysAuxiliarySerialNumberDTO.SysAuxiliarySerialNumberDTOBuilder auxiliaryClassId(final Long auxiliaryClassId) {
         this.auxiliaryClassId = auxiliaryClassId;
         return this;
      }

      public SysAuxiliarySerialNumberDTO build() {
         return new SysAuxiliarySerialNumberDTO(this.id, this.serialNumber, this.auxiliaryClassId);
      }

      @Override
      public String toString() {
         return "SysAuxiliarySerialNumberDTO.SysAuxiliarySerialNumberDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", auxiliaryClassId="
            + this.auxiliaryClassId
            + ")";
      }
   }
}
