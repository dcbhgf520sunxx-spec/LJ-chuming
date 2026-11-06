package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.plan.core.api.enums.CappCraftCardDictEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

@ApiModel(description = "CAPP 工艺卡字典项 列表查询 请求参数")
public class CappCraftCardDictItemListDTO {
   @ApiModelProperty(name = "dictType", value = "字典类型", notes = "字典类型")
   @NotBlank(message = "字典类型不能为空")
   @EnumValidator(value = CappCraftCardDictEnum.class, message = "字典类型不在有效范围内")
   private String dictType;
   @ApiModelProperty(name = "dictValue", value = "字典值", notes = "字典值")
   private String dictValue;
   @ApiModelProperty(name = "enabledFlag", value = "是否启用：0 未启用；1 启用", notes = "是否启用：0 未启用；1 启用")
   private Boolean enabledFlag;
   @ApiModelProperty(name = "userName", value = "创建人名称|编辑人名称", notes = "创建人名称|编辑人名称")
   private String userName;

   public String getDictType() {
      return this.dictType;
   }

   public String getDictValue() {
      return this.dictValue;
   }

   public Boolean getEnabledFlag() {
      return this.enabledFlag;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setDictType(final String dictType) {
      this.dictType = dictType;
   }

   public void setDictValue(final String dictValue) {
      this.dictValue = dictValue;
   }

   public void setEnabledFlag(final Boolean enabledFlag) {
      this.enabledFlag = enabledFlag;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardDictItemListDTO)) {
         return false;
      }

      CappCraftCardDictItemListDTO other = (CappCraftCardDictItemListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$enabledFlag = this.getEnabledFlag();
      Object other$enabledFlag = other.getEnabledFlag();
      if (this$enabledFlag == null ? other$enabledFlag == null : this$enabledFlag.equals(other$enabledFlag)) {
         Object this$dictType = this.getDictType();
         Object other$dictType = other.getDictType();
         if (this$dictType == null ? other$dictType == null : this$dictType.equals(other$dictType)) {
            Object this$dictValue = this.getDictValue();
            Object other$dictValue = other.getDictValue();
            if (this$dictValue == null ? other$dictValue == null : this$dictValue.equals(other$dictValue)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof CappCraftCardDictItemListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $enabledFlag = this.getEnabledFlag();
      result = result * 59 + ($enabledFlag == null ? 43 : $enabledFlag.hashCode());
      Object $dictType = this.getDictType();
      result = result * 59 + ($dictType == null ? 43 : $dictType.hashCode());
      Object $dictValue = this.getDictValue();
      result = result * 59 + ($dictValue == null ? 43 : $dictValue.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardDictItemListDTO(dictType="
         + this.getDictType()
         + ", dictValue="
         + this.getDictValue()
         + ", enabledFlag="
         + this.getEnabledFlag()
         + ", userName="
         + this.getUserName()
         + ")";
   }
}
