package com.hzchum.scim.crm.core.api.pojo.param.udpate;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class CrmPersonTemplateConfigUpdateParam {
   @ApiModelProperty(name = "crmPersonTemplateEnum", value = "负责人类型枚举", notes = "负责人类型枚举")
   private Integer crmPersonTemplateEnum;
   @ApiModelProperty(name = "userIds", value = "人员id集合", notes = "人员id集合")
   private List<Long> userIds;
   @ApiModelProperty(name = "crmPersonOperateTypeEnum", value = "操作类型", notes = "操作类型")
   private Integer crmPersonOperateTypeEnum;

   public CrmPersonTemplateConfigUpdateParam(final Integer crmPersonTemplateEnum, final List<Long> userIds, final Integer crmPersonOperateTypeEnum) {
      this.crmPersonTemplateEnum = crmPersonTemplateEnum;
      this.userIds = userIds;
      this.crmPersonOperateTypeEnum = crmPersonOperateTypeEnum;
   }

   public CrmPersonTemplateConfigUpdateParam() {
   }

   public Integer getCrmPersonTemplateEnum() {
      return this.crmPersonTemplateEnum;
   }

   public List<Long> getUserIds() {
      return this.userIds;
   }

   public Integer getCrmPersonOperateTypeEnum() {
      return this.crmPersonOperateTypeEnum;
   }

   public void setCrmPersonTemplateEnum(final Integer crmPersonTemplateEnum) {
      this.crmPersonTemplateEnum = crmPersonTemplateEnum;
   }

   public void setUserIds(final List<Long> userIds) {
      this.userIds = userIds;
   }

   public void setCrmPersonOperateTypeEnum(final Integer crmPersonOperateTypeEnum) {
      this.crmPersonOperateTypeEnum = crmPersonOperateTypeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmPersonTemplateConfigUpdateParam)) {
         return false;
      }

      CrmPersonTemplateConfigUpdateParam other = (CrmPersonTemplateConfigUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmPersonTemplateEnum = this.getCrmPersonTemplateEnum();
      Object other$crmPersonTemplateEnum = other.getCrmPersonTemplateEnum();
      if (this$crmPersonTemplateEnum == null ? other$crmPersonTemplateEnum == null : this$crmPersonTemplateEnum.equals(other$crmPersonTemplateEnum)) {
         Object this$crmPersonOperateTypeEnum = this.getCrmPersonOperateTypeEnum();
         Object other$crmPersonOperateTypeEnum = other.getCrmPersonOperateTypeEnum();
         if (this$crmPersonOperateTypeEnum == null
            ? other$crmPersonOperateTypeEnum == null
            : this$crmPersonOperateTypeEnum.equals(other$crmPersonOperateTypeEnum)) {
            Object this$userIds = this.getUserIds();
            Object other$userIds = other.getUserIds();
            return this$userIds == null ? other$userIds == null : this$userIds.equals(other$userIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmPersonTemplateConfigUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmPersonTemplateEnum = this.getCrmPersonTemplateEnum();
      result = result * 59 + ($crmPersonTemplateEnum == null ? 43 : $crmPersonTemplateEnum.hashCode());
      Object $crmPersonOperateTypeEnum = this.getCrmPersonOperateTypeEnum();
      result = result * 59 + ($crmPersonOperateTypeEnum == null ? 43 : $crmPersonOperateTypeEnum.hashCode());
      Object $userIds = this.getUserIds();
      return result * 59 + ($userIds == null ? 43 : $userIds.hashCode());
   }

   @Override
   public String toString() {
      return "CrmPersonTemplateConfigUpdateParam(crmPersonTemplateEnum="
         + this.getCrmPersonTemplateEnum()
         + ", userIds="
         + this.getUserIds()
         + ", crmPersonOperateTypeEnum="
         + this.getCrmPersonOperateTypeEnum()
         + ")";
   }
}
