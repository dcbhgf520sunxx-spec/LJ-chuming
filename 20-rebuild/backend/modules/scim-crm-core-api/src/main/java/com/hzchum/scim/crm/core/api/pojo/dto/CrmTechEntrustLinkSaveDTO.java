package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmTechEntrustLinkSaveDTO {
   private Long id;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "crmSettlementBusinessTypeEnum", value = "直营非直营类型", notes = "直营非直营类型")
   private Integer crmSettlementBusinessTypeEnum;
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   private Long userId;

   public Long getId() {
      return this.id;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public Integer getCrmSettlementBusinessTypeEnum() {
      return this.crmSettlementBusinessTypeEnum;
   }

   public Long getUserId() {
      return this.userId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public void setCrmSettlementBusinessTypeEnum(final Integer crmSettlementBusinessTypeEnum) {
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmTechEntrustLinkSaveDTO)) {
         return false;
      }

      CrmTechEntrustLinkSaveDTO other = (CrmTechEntrustLinkSaveDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
         Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
         if (this$crmProjectInformationWarehousingId == null
            ? other$crmProjectInformationWarehousingId == null
            : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
            Object this$crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
            Object other$crmSettlementBusinessTypeEnum = other.getCrmSettlementBusinessTypeEnum();
            if (this$crmSettlementBusinessTypeEnum == null
               ? other$crmSettlementBusinessTypeEnum == null
               : this$crmSettlementBusinessTypeEnum.equals(other$crmSettlementBusinessTypeEnum)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
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
      return other instanceof CrmTechEntrustLinkSaveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
      result = result * 59 + ($crmSettlementBusinessTypeEnum == null ? 43 : $crmSettlementBusinessTypeEnum.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   @Override
   public String toString() {
      return "CrmTechEntrustLinkSaveDTO(id="
         + this.getId()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", crmSettlementBusinessTypeEnum="
         + this.getCrmSettlementBusinessTypeEnum()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   public CrmTechEntrustLinkSaveDTO(
      final Long id, final Long crmProjectInformationWarehousingId, final Integer crmSettlementBusinessTypeEnum, final Long userId
   ) {
      this.id = id;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
      this.userId = userId;
   }

   public CrmTechEntrustLinkSaveDTO() {
   }
}
