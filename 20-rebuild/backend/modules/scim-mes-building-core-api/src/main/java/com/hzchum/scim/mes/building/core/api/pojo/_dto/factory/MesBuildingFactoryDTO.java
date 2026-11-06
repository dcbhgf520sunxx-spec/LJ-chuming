package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingFactoryDO;
import io.swagger.annotations.ApiModelProperty;

public class MesBuildingFactoryDTO extends MesBuildingFactoryDO {
   @ApiModelProperty(name = "branchCompanyName", value = "分支机构名称", notes = "分支机构名称")
   @JsonProperty("branchCompanyName")
   @JSONField(name = "branchCompanyName")
   private String branchCompanyName;
   @ApiModelProperty(name = "boolDeviceConfigure", notes = "是否配置地磅0否 1是")
   @JsonProperty("boolDeviceConfigure")
   @JSONField(name = "boolDeviceConfigure")
   private Boolean boolDeviceConfigure;

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public Boolean getBoolDeviceConfigure() {
      return this.boolDeviceConfigure;
   }

   @JsonProperty("branchCompanyName")
   public MesBuildingFactoryDTO setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
      return this;
   }

   @JsonProperty("boolDeviceConfigure")
   public MesBuildingFactoryDTO setBoolDeviceConfigure(final Boolean boolDeviceConfigure) {
      this.boolDeviceConfigure = boolDeviceConfigure;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingFactoryDTO(branchCompanyName=" + this.getBranchCompanyName() + ", boolDeviceConfigure=" + this.getBoolDeviceConfigure() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingFactoryDTO)) {
         return false;
      } else {
         MesBuildingFactoryDTO other = (MesBuildingFactoryDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$boolDeviceConfigure = this.getBoolDeviceConfigure();
            Object other$boolDeviceConfigure = other.getBoolDeviceConfigure();
            if (this$boolDeviceConfigure == null ? other$boolDeviceConfigure == null : this$boolDeviceConfigure.equals(other$boolDeviceConfigure)) {
               Object this$branchCompanyName = this.getBranchCompanyName();
               Object other$branchCompanyName = other.getBranchCompanyName();
               return this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingFactoryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolDeviceConfigure = this.getBoolDeviceConfigure();
      result = result * 59 + ($boolDeviceConfigure == null ? 43 : $boolDeviceConfigure.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      return result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
   }
}
