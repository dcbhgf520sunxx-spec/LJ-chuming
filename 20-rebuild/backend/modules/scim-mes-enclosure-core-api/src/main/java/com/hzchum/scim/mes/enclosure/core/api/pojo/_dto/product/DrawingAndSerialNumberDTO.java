package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("零构件清单列表 返回构件类")
public class DrawingAndSerialNumberDTO {
   @ApiModelProperty("产品序列号")
   private Integer number;
   @ApiModelProperty("图号")
   private String dwgNum;

   public Integer getNumber() {
      return this.number;
   }

   public String getDwgNum() {
      return this.dwgNum;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setDwgNum(final String dwgNum) {
      this.dwgNum = dwgNum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DrawingAndSerialNumberDTO)) {
         return false;
      } else {
         DrawingAndSerialNumberDTO other = (DrawingAndSerialNumberDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$number = this.getNumber();
            Object other$number = other.getNumber();
            if (this$number == null ? other$number == null : this$number.equals(other$number)) {
               Object this$dwgNum = this.getDwgNum();
               Object other$dwgNum = other.getDwgNum();
               return this$dwgNum == null ? other$dwgNum == null : this$dwgNum.equals(other$dwgNum);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DrawingAndSerialNumberDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $dwgNum = this.getDwgNum();
      return result * 59 + ($dwgNum == null ? 43 : $dwgNum.hashCode());
   }

   @Override
   public String toString() {
      return "DrawingAndSerialNumberDTO(number=" + this.getNumber() + ", dwgNum=" + this.getDwgNum() + ")";
   }
}
