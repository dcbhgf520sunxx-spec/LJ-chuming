package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(description = "库存信息")
public class CargoListProductDTOParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("出入库id")
   @NotNull(message = "出入库id不能为空")
   private Long id;
   @ApiModelProperty("装车数量")
   @NotNull(message = "装车数量不能为空")
   @Min(value = 1L, message = "装车数最小为1")
   private Integer quantity;
   @ApiModelProperty("构件序号列表")
   private List<Integer> numberList;

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListProductDTOParam)) {
         return false;
      }

      CargoListProductDTOParam other = (CargoListProductDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$numberList = this.getNumberList();
            Object other$numberList = other.getNumberList();
            return this$numberList == null ? other$numberList == null : this$numberList.equals(other$numberList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CargoListProductDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListProductDTOParam(id=" + this.getId() + ", quantity=" + this.getQuantity() + ", numberList=" + this.getNumberList() + ")";
   }
}
