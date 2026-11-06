package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "部件一物一码详情列表", description = "部件一物一码西详情列表")
public class TechAssembleExtDetailDTO {
   @ApiModelProperty(name = "assembleId", value = "部件id")
   private Long assembleId;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "sortNumber", value = "序号", notes = "序号")
   private Integer sortNumber;
   @ApiModelProperty(name = "productionLine", value = "生产线", notes = "生产线")
   private NameInfo productionLine;
   @ApiModelProperty(name = "group", value = "生产班组", notes = "生产班组")
   private NameInfo groups;
   @ApiModelProperty(name = "status", value = "当前状态", notes = "当前状态")
   private String status;
   @ApiModelProperty(name = "status", value = "是否进入发运", notes = "是否进入发运")
   private Boolean boolCargo;

   public static TechAssembleExtDetailDTO.TechAssembleExtDetailDTOBuilder builder() {
      return new TechAssembleExtDetailDTO.TechAssembleExtDetailDTOBuilder();
   }

   public TechAssembleExtDetailDTO() {
   }

   public TechAssembleExtDetailDTO(
      final Long assembleId,
      final String serialNumber,
      final Integer sortNumber,
      final NameInfo productionLine,
      final NameInfo groups,
      final String status,
      final Boolean boolCargo
   ) {
      this.assembleId = assembleId;
      this.serialNumber = serialNumber;
      this.sortNumber = sortNumber;
      this.productionLine = productionLine;
      this.groups = groups;
      this.status = status;
      this.boolCargo = boolCargo;
   }

   public Long getAssembleId() {
      return this.assembleId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   public NameInfo getProductionLine() {
      return this.productionLine;
   }

   public NameInfo getGroups() {
      return this.groups;
   }

   public String getStatus() {
      return this.status;
   }

   public Boolean getBoolCargo() {
      return this.boolCargo;
   }

   public void setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
   }

   public void setProductionLine(final NameInfo productionLine) {
      this.productionLine = productionLine;
   }

   public void setGroups(final NameInfo groups) {
      this.groups = groups;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   public void setBoolCargo(final Boolean boolCargo) {
      this.boolCargo = boolCargo;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAssembleExtDetailDTO)) {
         return false;
      }

      TechAssembleExtDetailDTO other = (TechAssembleExtDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$assembleId = this.getAssembleId();
      Object other$assembleId = other.getAssembleId();
      if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
         Object this$sortNumber = this.getSortNumber();
         Object other$sortNumber = other.getSortNumber();
         if (this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber)) {
            Object this$boolCargo = this.getBoolCargo();
            Object other$boolCargo = other.getBoolCargo();
            if (this$boolCargo == null ? other$boolCargo == null : this$boolCargo.equals(other$boolCargo)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$productionLine = this.getProductionLine();
                  Object other$productionLine = other.getProductionLine();
                  if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                     Object this$groups = this.getGroups();
                     Object other$groups = other.getGroups();
                     if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        return this$status == null ? other$status == null : this$status.equals(other$status);
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
      return other instanceof TechAssembleExtDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $sortNumber = this.getSortNumber();
      result = result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
      Object $boolCargo = this.getBoolCargo();
      result = result * 59 + ($boolCargo == null ? 43 : $boolCargo.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $status = this.getStatus();
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   @Override
   public String toString() {
      return "TechAssembleExtDetailDTO(assembleId="
         + this.getAssembleId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", sortNumber="
         + this.getSortNumber()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", status="
         + this.getStatus()
         + ", boolCargo="
         + this.getBoolCargo()
         + ")";
   }

   public static class TechAssembleExtDetailDTOBuilder {
      private Long assembleId;
      private String serialNumber;
      private Integer sortNumber;
      private NameInfo productionLine;
      private NameInfo groups;
      private String status;
      private Boolean boolCargo;

      TechAssembleExtDetailDTOBuilder() {
      }

      public TechAssembleExtDetailDTO.TechAssembleExtDetailDTOBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      public TechAssembleExtDetailDTO.TechAssembleExtDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechAssembleExtDetailDTO.TechAssembleExtDetailDTOBuilder sortNumber(final Integer sortNumber) {
         this.sortNumber = sortNumber;
         return this;
      }

      public TechAssembleExtDetailDTO.TechAssembleExtDetailDTOBuilder productionLine(final NameInfo productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      public TechAssembleExtDetailDTO.TechAssembleExtDetailDTOBuilder groups(final NameInfo groups) {
         this.groups = groups;
         return this;
      }

      public TechAssembleExtDetailDTO.TechAssembleExtDetailDTOBuilder status(final String status) {
         this.status = status;
         return this;
      }

      public TechAssembleExtDetailDTO.TechAssembleExtDetailDTOBuilder boolCargo(final Boolean boolCargo) {
         this.boolCargo = boolCargo;
         return this;
      }

      public TechAssembleExtDetailDTO build() {
         return new TechAssembleExtDetailDTO(this.assembleId, this.serialNumber, this.sortNumber, this.productionLine, this.groups, this.status, this.boolCargo);
      }

      @Override
      public String toString() {
         return "TechAssembleExtDetailDTO.TechAssembleExtDetailDTOBuilder(assembleId="
            + this.assembleId
            + ", serialNumber="
            + this.serialNumber
            + ", sortNumber="
            + this.sortNumber
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", status="
            + this.status
            + ", boolCargo="
            + this.boolCargo
            + ")";
      }
   }
}
