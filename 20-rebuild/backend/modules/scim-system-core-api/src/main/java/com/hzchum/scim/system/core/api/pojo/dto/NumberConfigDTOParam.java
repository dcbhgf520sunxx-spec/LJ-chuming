package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class NumberConfigDTOParam {
   private Long id;
   @NotNull(message = "类型不能为空")
   @EnumValidator(value = NumberTypeEnum.class, message = "编号类型错误")
   private Integer type;
   @NotEmpty(message = "代号不能为空")
   private String code;
   @NotNull(message = "流水号不能为空")
   @Range(min = 1L, message = "流水号最小为1")
   private Integer number;

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public String getCode() {
      return this.code;
   }

   public Integer getNumber() {
      return this.number;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NumberConfigDTOParam)) {
         return false;
      }

      NumberConfigDTOParam other = (NumberConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$number = this.getNumber();
            Object other$number = other.getNumber();
            if (this$number == null ? other$number == null : this$number.equals(other$number)) {
               Object this$code = this.getCode();
               Object other$code = other.getCode();
               return this$code == null ? other$code == null : this$code.equals(other$code);
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
      return other instanceof NumberConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   @Override
   public String toString() {
      return "NumberConfigDTOParam(id=" + this.getId() + ", type=" + this.getType() + ", code=" + this.getCode() + ", number=" + this.getNumber() + ")";
   }
}
