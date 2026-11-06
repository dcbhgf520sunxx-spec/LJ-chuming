package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("收安报表查询类")
public class ReceivingInstallQueryDTOParam extends ProjectBaseQueryDTOParam {
   @ApiModelProperty(name = "queryType", value = "查询类型 1收安报表 2安装填报")
   @NotNull(message = "查询类型不能为空")
   private Integer queryType;

   public Integer getQueryType() {
      return this.queryType;
   }

   public void setQueryType(final Integer queryType) {
      this.queryType = queryType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReceivingInstallQueryDTOParam)) {
         return false;
      }

      ReceivingInstallQueryDTOParam other = (ReceivingInstallQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$queryType = this.getQueryType();
      Object other$queryType = other.getQueryType();
      return this$queryType == null ? other$queryType == null : this$queryType.equals(other$queryType);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ReceivingInstallQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $queryType = this.getQueryType();
      return result * 59 + ($queryType == null ? 43 : $queryType.hashCode());
   }

   @Override
   public String toString() {
      return "ReceivingInstallQueryDTOParam(queryType=" + this.getQueryType() + ")";
   }
}
