package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value = "WarehouseDTO对象", description = "仓库位置返回类-配置 ")
public class WarehouseDTO extends Warehouse implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "ifExist", value = "是否被使用", notes = "是否被使用")
   private Boolean ifExist;
   private String workShopName;

   public Boolean getIfExist() {
      return this.ifExist;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public void setIfExist(final Boolean ifExist) {
      this.ifExist = ifExist;
   }

   public void setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof WarehouseDTO)) {
         return false;
      } else {
         WarehouseDTO other = (WarehouseDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$ifExist = this.getIfExist();
            Object other$ifExist = other.getIfExist();
            if (this$ifExist == null ? other$ifExist == null : this$ifExist.equals(other$ifExist)) {
               Object this$workShopName = this.getWorkShopName();
               Object other$workShopName = other.getWorkShopName();
               return this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WarehouseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $ifExist = this.getIfExist();
      result = result * 59 + ($ifExist == null ? 43 : $ifExist.hashCode());
      Object $workShopName = this.getWorkShopName();
      return result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseDTO(ifExist=" + this.getIfExist() + ", workShopName=" + this.getWorkShopName() + ")";
   }
}
