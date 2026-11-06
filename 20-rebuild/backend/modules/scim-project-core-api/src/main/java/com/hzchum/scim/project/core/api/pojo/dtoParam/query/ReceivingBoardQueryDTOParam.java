package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("收货看板查询类")
public class ReceivingBoardQueryDTOParam extends ProjectBaseQueryDTOParam {
   @ApiModelProperty(name = "receivingStatus", value = "收货状态 1未收货 2部分收货 4完全收货", notes = "收货状态")
   private Integer receivingStatus;

   public Integer getReceivingStatus() {
      return this.receivingStatus;
   }

   public void setReceivingStatus(final Integer receivingStatus) {
      this.receivingStatus = receivingStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReceivingBoardQueryDTOParam)) {
         return false;
      }

      ReceivingBoardQueryDTOParam other = (ReceivingBoardQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$receivingStatus = this.getReceivingStatus();
      Object other$receivingStatus = other.getReceivingStatus();
      return this$receivingStatus == null ? other$receivingStatus == null : this$receivingStatus.equals(other$receivingStatus);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ReceivingBoardQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $receivingStatus = this.getReceivingStatus();
      return result * 59 + ($receivingStatus == null ? 43 : $receivingStatus.hashCode());
   }

   @Override
   public String toString() {
      return "ReceivingBoardQueryDTOParam(receivingStatus=" + this.getReceivingStatus() + ")";
   }
}
