package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP  app产品焊道绑定设备 请求参数")
public class CappCraftCardProductAppPassBindEquipmentDTO {
   @ApiModelProperty(name = "id", value = "产品焊道id", notes = "产品焊道id")
   private Long id;
   @ApiModelProperty(name = "equimentCode", value = "设备code", notes = "设备code")
   private String equimentCode;
   @ApiModelProperty(name = "equimentSerialNumber", value = "设备编号", notes = "设备编号")
   private String equimentSerialNumber;
   @ApiModelProperty(name = "equimentName", value = "设备名称", notes = "设备名称")
   private String equimentName;
   @ApiModelProperty(name = "weldUserId", value = "实际焊接人id", notes = "实际焊接人id")
   private Long weldUserId;
   @ApiModelProperty(name = "weldUserName", value = "实际焊接人名称", notes = "实际焊接人名称")
   private String weldUserName;
   @ApiModelProperty(name = "equimentId", value = "设备id", notes = "设备id")
   private String equimentId;
   @ApiModelProperty(name = "weldingGunCode", value = "焊枪编号", notes = "焊枪编号")
   private String weldingGunCode;

   public Long getId() {
      return this.id;
   }

   public String getEquimentCode() {
      return this.equimentCode;
   }

   public String getEquimentSerialNumber() {
      return this.equimentSerialNumber;
   }

   public String getEquimentName() {
      return this.equimentName;
   }

   public Long getWeldUserId() {
      return this.weldUserId;
   }

   public String getWeldUserName() {
      return this.weldUserName;
   }

   public String getEquimentId() {
      return this.equimentId;
   }

   public String getWeldingGunCode() {
      return this.weldingGunCode;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setEquimentCode(final String equimentCode) {
      this.equimentCode = equimentCode;
   }

   public void setEquimentSerialNumber(final String equimentSerialNumber) {
      this.equimentSerialNumber = equimentSerialNumber;
   }

   public void setEquimentName(final String equimentName) {
      this.equimentName = equimentName;
   }

   public void setWeldUserId(final Long weldUserId) {
      this.weldUserId = weldUserId;
   }

   public void setWeldUserName(final String weldUserName) {
      this.weldUserName = weldUserName;
   }

   public void setEquimentId(final String equimentId) {
      this.equimentId = equimentId;
   }

   public void setWeldingGunCode(final String weldingGunCode) {
      this.weldingGunCode = weldingGunCode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductAppPassBindEquipmentDTO)) {
         return false;
      }

      CappCraftCardProductAppPassBindEquipmentDTO other = (CappCraftCardProductAppPassBindEquipmentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$weldUserId = this.getWeldUserId();
         Object other$weldUserId = other.getWeldUserId();
         if (this$weldUserId == null ? other$weldUserId == null : this$weldUserId.equals(other$weldUserId)) {
            Object this$equimentCode = this.getEquimentCode();
            Object other$equimentCode = other.getEquimentCode();
            if (this$equimentCode == null ? other$equimentCode == null : this$equimentCode.equals(other$equimentCode)) {
               Object this$equimentSerialNumber = this.getEquimentSerialNumber();
               Object other$equimentSerialNumber = other.getEquimentSerialNumber();
               if (this$equimentSerialNumber == null ? other$equimentSerialNumber == null : this$equimentSerialNumber.equals(other$equimentSerialNumber)) {
                  Object this$equimentName = this.getEquimentName();
                  Object other$equimentName = other.getEquimentName();
                  if (this$equimentName == null ? other$equimentName == null : this$equimentName.equals(other$equimentName)) {
                     Object this$weldUserName = this.getWeldUserName();
                     Object other$weldUserName = other.getWeldUserName();
                     if (this$weldUserName == null ? other$weldUserName == null : this$weldUserName.equals(other$weldUserName)) {
                        Object this$equimentId = this.getEquimentId();
                        Object other$equimentId = other.getEquimentId();
                        if (this$equimentId == null ? other$equimentId == null : this$equimentId.equals(other$equimentId)) {
                           Object this$weldingGunCode = this.getWeldingGunCode();
                           Object other$weldingGunCode = other.getWeldingGunCode();
                           return this$weldingGunCode == null ? other$weldingGunCode == null : this$weldingGunCode.equals(other$weldingGunCode);
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
      return other instanceof CappCraftCardProductAppPassBindEquipmentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $weldUserId = this.getWeldUserId();
      result = result * 59 + ($weldUserId == null ? 43 : $weldUserId.hashCode());
      Object $equimentCode = this.getEquimentCode();
      result = result * 59 + ($equimentCode == null ? 43 : $equimentCode.hashCode());
      Object $equimentSerialNumber = this.getEquimentSerialNumber();
      result = result * 59 + ($equimentSerialNumber == null ? 43 : $equimentSerialNumber.hashCode());
      Object $equimentName = this.getEquimentName();
      result = result * 59 + ($equimentName == null ? 43 : $equimentName.hashCode());
      Object $weldUserName = this.getWeldUserName();
      result = result * 59 + ($weldUserName == null ? 43 : $weldUserName.hashCode());
      Object $equimentId = this.getEquimentId();
      result = result * 59 + ($equimentId == null ? 43 : $equimentId.hashCode());
      Object $weldingGunCode = this.getWeldingGunCode();
      return result * 59 + ($weldingGunCode == null ? 43 : $weldingGunCode.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductAppPassBindEquipmentDTO(id="
         + this.getId()
         + ", equimentCode="
         + this.getEquimentCode()
         + ", equimentSerialNumber="
         + this.getEquimentSerialNumber()
         + ", equimentName="
         + this.getEquimentName()
         + ", weldUserId="
         + this.getWeldUserId()
         + ", weldUserName="
         + this.getWeldUserName()
         + ", equimentId="
         + this.getEquimentId()
         + ", weldingGunCode="
         + this.getWeldingGunCode()
         + ")";
   }
}
