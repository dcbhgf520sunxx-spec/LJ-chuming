package com.hzchum.scim.contract.core.api.pojo.voParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("收款台帐-收款列表-查询类")
public class CollectionLedgerQueryVoParam {
   @ApiModelProperty(name = "type", value = "1项目收款 2废料收款")
   private Integer type;
   @ApiModelProperty(name = "startDate", value = "开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "截止日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同ID", notes = "废料合同ID")
   private Long contractWasteId;
   @ApiModelProperty(name = "name", value = "项目名称")
   private String name;
   @ApiModelProperty(name = "contractSignBodyName", value = "合同签订主体")
   private String contractSignBodyName;
   @ApiModelProperty(name = "businessType", value = "业务类型 加工承揽 2项目承包 ")
   private Integer businessType;

   public static CollectionLedgerQueryVoParam.CollectionLedgerQueryVoParamBuilder builder() {
      return new CollectionLedgerQueryVoParam.CollectionLedgerQueryVoParamBuilder();
   }

   public CollectionLedgerQueryVoParam() {
   }

   public CollectionLedgerQueryVoParam(
      final Integer type,
      final LocalDate startDate,
      final LocalDate endDate,
      final Long projectId,
      final Long contractWasteId,
      final String name,
      final String contractSignBodyName,
      final Integer businessType
   ) {
      this.type = type;
      this.startDate = startDate;
      this.endDate = endDate;
      this.projectId = projectId;
      this.contractWasteId = contractWasteId;
      this.name = name;
      this.contractSignBodyName = contractSignBodyName;
      this.businessType = businessType;
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public String getName() {
      return this.name;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CollectionLedgerQueryVoParam)) {
         return false;
      }

      CollectionLedgerQueryVoParam other = (CollectionLedgerQueryVoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$contractWasteId = this.getContractWasteId();
            Object other$contractWasteId = other.getContractWasteId();
            if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
               Object this$businessType = this.getBusinessType();
               Object other$businessType = other.getBusinessType();
               if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$endDate = this.getEndDate();
                     Object other$endDate = other.getEndDate();
                     if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$contractSignBodyName = this.getContractSignBodyName();
                           Object other$contractSignBodyName = other.getContractSignBodyName();
                           return this$contractSignBodyName == null
                              ? other$contractSignBodyName == null
                              : this$contractSignBodyName.equals(other$contractSignBodyName);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CollectionLedgerQueryVoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      return result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
   }

   @Override
   public String toString() {
      return "CollectionLedgerQueryVoParam(type="
         + this.getType()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectId="
         + this.getProjectId()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", name="
         + this.getName()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", businessType="
         + this.getBusinessType()
         + ")";
   }

   public static class CollectionLedgerQueryVoParamBuilder {
      private Integer type;
      private LocalDate startDate;
      private LocalDate endDate;
      private Long projectId;
      private Long contractWasteId;
      private String name;
      private String contractSignBodyName;
      private Integer businessType;

      CollectionLedgerQueryVoParamBuilder() {
      }

      public CollectionLedgerQueryVoParam.CollectionLedgerQueryVoParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public CollectionLedgerQueryVoParam.CollectionLedgerQueryVoParamBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public CollectionLedgerQueryVoParam.CollectionLedgerQueryVoParamBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public CollectionLedgerQueryVoParam.CollectionLedgerQueryVoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public CollectionLedgerQueryVoParam.CollectionLedgerQueryVoParamBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public CollectionLedgerQueryVoParam.CollectionLedgerQueryVoParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CollectionLedgerQueryVoParam.CollectionLedgerQueryVoParamBuilder contractSignBodyName(final String contractSignBodyName) {
         this.contractSignBodyName = contractSignBodyName;
         return this;
      }

      public CollectionLedgerQueryVoParam.CollectionLedgerQueryVoParamBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public CollectionLedgerQueryVoParam build() {
         return new CollectionLedgerQueryVoParam(
            this.type, this.startDate, this.endDate, this.projectId, this.contractWasteId, this.name, this.contractSignBodyName, this.businessType
         );
      }

      @Override
      public String toString() {
         return "CollectionLedgerQueryVoParam.CollectionLedgerQueryVoParamBuilder(type="
            + this.type
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", projectId="
            + this.projectId
            + ", contractWasteId="
            + this.contractWasteId
            + ", name="
            + this.name
            + ", contractSignBodyName="
            + this.contractSignBodyName
            + ", businessType="
            + this.businessType
            + ")";
      }
   }
}
