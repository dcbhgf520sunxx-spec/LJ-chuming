package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("定额配置Query")
public class MesQuotaConfigQuery {
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("车间ID")
   private Long workshopId;
   @ApiModelProperty("类型ID")
   private Long classId;
   @ApiModelProperty("定额编号")
   private String quotaNumber;
   @ApiModelProperty("工序ID")
   private Long processId;
   @ApiModelProperty("零件类型")
   private Integer machinePartType;
   @ApiModelProperty("状态")
   private Boolean status;

   MesQuotaConfigQuery(
      final Long id,
      final Long workshopId,
      final Long classId,
      final String quotaNumber,
      final Long processId,
      final Integer machinePartType,
      final Boolean status
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.classId = classId;
      this.quotaNumber = quotaNumber;
      this.processId = processId;
      this.machinePartType = machinePartType;
      this.status = status;
   }

   public static MesQuotaConfigQuery.MesQuotaConfigQueryBuilder builder() {
      return new MesQuotaConfigQuery.MesQuotaConfigQueryBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getClassId() {
      return this.classId;
   }

   public String getQuotaNumber() {
      return this.quotaNumber;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getMachinePartType() {
      return this.machinePartType;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setClassId(final Long classId) {
      this.classId = classId;
   }

   public void setQuotaNumber(final String quotaNumber) {
      this.quotaNumber = quotaNumber;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setMachinePartType(final Integer machinePartType) {
      this.machinePartType = machinePartType;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigQuery)) {
         return false;
      }

      MesQuotaConfigQuery other = (MesQuotaConfigQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$classId = this.getClassId();
            Object other$classId = other.getClassId();
            if (this$classId == null ? other$classId == null : this$classId.equals(other$classId)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$machinePartType = this.getMachinePartType();
                  Object other$machinePartType = other.getMachinePartType();
                  if (this$machinePartType == null ? other$machinePartType == null : this$machinePartType.equals(other$machinePartType)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$quotaNumber = this.getQuotaNumber();
                        Object other$quotaNumber = other.getQuotaNumber();
                        return this$quotaNumber == null ? other$quotaNumber == null : this$quotaNumber.equals(other$quotaNumber);
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesQuotaConfigQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $classId = this.getClassId();
      result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $machinePartType = this.getMachinePartType();
      result = result * 59 + ($machinePartType == null ? 43 : $machinePartType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $quotaNumber = this.getQuotaNumber();
      return result * 59 + ($quotaNumber == null ? 43 : $quotaNumber.hashCode());
   }

   @Override
   public String toString() {
      return "MesQuotaConfigQuery(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", classId="
         + this.getClassId()
         + ", quotaNumber="
         + this.getQuotaNumber()
         + ", processId="
         + this.getProcessId()
         + ", machinePartType="
         + this.getMachinePartType()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class MesQuotaConfigQueryBuilder {
      private Long id;
      private Long workshopId;
      private Long classId;
      private String quotaNumber;
      private Long processId;
      private Integer machinePartType;
      private Boolean status;

      MesQuotaConfigQueryBuilder() {
      }

      public MesQuotaConfigQuery.MesQuotaConfigQueryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesQuotaConfigQuery.MesQuotaConfigQueryBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesQuotaConfigQuery.MesQuotaConfigQueryBuilder classId(final Long classId) {
         this.classId = classId;
         return this;
      }

      public MesQuotaConfigQuery.MesQuotaConfigQueryBuilder quotaNumber(final String quotaNumber) {
         this.quotaNumber = quotaNumber;
         return this;
      }

      public MesQuotaConfigQuery.MesQuotaConfigQueryBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesQuotaConfigQuery.MesQuotaConfigQueryBuilder machinePartType(final Integer machinePartType) {
         this.machinePartType = machinePartType;
         return this;
      }

      public MesQuotaConfigQuery.MesQuotaConfigQueryBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesQuotaConfigQuery build() {
         return new MesQuotaConfigQuery(this.id, this.workshopId, this.classId, this.quotaNumber, this.processId, this.machinePartType, this.status);
      }

      @Override
      public String toString() {
         return "MesQuotaConfigQuery.MesQuotaConfigQueryBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", classId="
            + this.classId
            + ", quotaNumber="
            + this.quotaNumber
            + ", processId="
            + this.processId
            + ", machinePartType="
            + this.machinePartType
            + ", status="
            + this.status
            + ")";
      }
   }
}
