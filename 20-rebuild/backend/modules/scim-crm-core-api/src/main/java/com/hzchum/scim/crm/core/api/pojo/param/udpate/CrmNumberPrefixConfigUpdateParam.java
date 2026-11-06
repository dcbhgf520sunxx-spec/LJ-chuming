package com.hzchum.scim.crm.core.api.pojo.param.udpate;

import io.swagger.annotations.ApiModelProperty;

public class CrmNumberPrefixConfigUpdateParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "numberPrefixConfigEnum", value = "编号前缀配置所属类型", notes = "编号前缀配置所属类型")
   private Integer numberPrefixConfigEnum;
   @ApiModelProperty(name = "numberPrefixConfigEnumName", value = "编号前缀配置所属类型名称", notes = "编号前缀配置所属类型名称")
   private String numberPrefixConfigEnumName;
   @ApiModelProperty(name = "prefixNaming", value = "前缀命名", notes = "前缀命名")
   private String prefixNaming;

   public CrmNumberPrefixConfigUpdateParam(
      final Long id, final Integer numberPrefixConfigEnum, final String numberPrefixConfigEnumName, final String prefixNaming
   ) {
      this.id = id;
      this.numberPrefixConfigEnum = numberPrefixConfigEnum;
      this.numberPrefixConfigEnumName = numberPrefixConfigEnumName;
      this.prefixNaming = prefixNaming;
   }

   public CrmNumberPrefixConfigUpdateParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getNumberPrefixConfigEnum() {
      return this.numberPrefixConfigEnum;
   }

   public String getNumberPrefixConfigEnumName() {
      return this.numberPrefixConfigEnumName;
   }

   public String getPrefixNaming() {
      return this.prefixNaming;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setNumberPrefixConfigEnum(final Integer numberPrefixConfigEnum) {
      this.numberPrefixConfigEnum = numberPrefixConfigEnum;
   }

   public void setNumberPrefixConfigEnumName(final String numberPrefixConfigEnumName) {
      this.numberPrefixConfigEnumName = numberPrefixConfigEnumName;
   }

   public void setPrefixNaming(final String prefixNaming) {
      this.prefixNaming = prefixNaming;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmNumberPrefixConfigUpdateParam)) {
         return false;
      }

      CrmNumberPrefixConfigUpdateParam other = (CrmNumberPrefixConfigUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$numberPrefixConfigEnum = this.getNumberPrefixConfigEnum();
         Object other$numberPrefixConfigEnum = other.getNumberPrefixConfigEnum();
         if (this$numberPrefixConfigEnum == null ? other$numberPrefixConfigEnum == null : this$numberPrefixConfigEnum.equals(other$numberPrefixConfigEnum)) {
            Object this$numberPrefixConfigEnumName = this.getNumberPrefixConfigEnumName();
            Object other$numberPrefixConfigEnumName = other.getNumberPrefixConfigEnumName();
            if (this$numberPrefixConfigEnumName == null
               ? other$numberPrefixConfigEnumName == null
               : this$numberPrefixConfigEnumName.equals(other$numberPrefixConfigEnumName)) {
               Object this$prefixNaming = this.getPrefixNaming();
               Object other$prefixNaming = other.getPrefixNaming();
               return this$prefixNaming == null ? other$prefixNaming == null : this$prefixNaming.equals(other$prefixNaming);
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
      return other instanceof CrmNumberPrefixConfigUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $numberPrefixConfigEnum = this.getNumberPrefixConfigEnum();
      result = result * 59 + ($numberPrefixConfigEnum == null ? 43 : $numberPrefixConfigEnum.hashCode());
      Object $numberPrefixConfigEnumName = this.getNumberPrefixConfigEnumName();
      result = result * 59 + ($numberPrefixConfigEnumName == null ? 43 : $numberPrefixConfigEnumName.hashCode());
      Object $prefixNaming = this.getPrefixNaming();
      return result * 59 + ($prefixNaming == null ? 43 : $prefixNaming.hashCode());
   }

   @Override
   public String toString() {
      return "CrmNumberPrefixConfigUpdateParam(id="
         + this.getId()
         + ", numberPrefixConfigEnum="
         + this.getNumberPrefixConfigEnum()
         + ", numberPrefixConfigEnumName="
         + this.getNumberPrefixConfigEnumName()
         + ", prefixNaming="
         + this.getPrefixNaming()
         + ")";
   }
}
