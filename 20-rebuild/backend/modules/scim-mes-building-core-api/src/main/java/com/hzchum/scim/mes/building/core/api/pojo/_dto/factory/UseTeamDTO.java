package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.FactoryDetailDO;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class UseTeamDTO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factory", notes = "工厂", value = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名", value = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]", value = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   @NotNull(message = "编制属性不能为空")
   private Boolean organizationType;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式 [1 重量, 2 长度，4 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "leaderName", value = "班组长")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   private Long productionLineId;
   @ApiModelProperty("生产线名称")
   private String productionLineName;

   public static UseTeamDTO.UseTeamDTOBuilder builder() {
      return new UseTeamDTO.UseTeamDTOBuilder();
   }

   public UseTeamDTO() {
   }

   public UseTeamDTO(
      final Long id,
      final FactoryDetailDO factory,
      final Long processId,
      final String processName,
      final Boolean organizationType,
      final Integer wageQuotaType,
      final String leaderName,
      final Long productionLineId,
      final String productionLineName
   ) {
      this.id = id;
      this.factory = factory;
      this.processId = processId;
      this.processName = processName;
      this.organizationType = organizationType;
      this.wageQuotaType = wageQuotaType;
      this.leaderName = leaderName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
   }

   public Long getId() {
      return this.id;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   @JsonProperty("id")
   public UseTeamDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factory")
   public UseTeamDTO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("processId")
   public UseTeamDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public UseTeamDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("organizationType")
   public UseTeamDTO setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public UseTeamDTO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("leaderName")
   public UseTeamDTO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   public UseTeamDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   public UseTeamDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @Override
   public String toString() {
      return "UseTeamDTO(id="
         + this.getId()
         + ", factory="
         + this.getFactory()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", organizationType="
         + this.getOrganizationType()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", leaderName="
         + this.getLeaderName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UseTeamDTO)) {
         return false;
      }

      UseTeamDTO other = (UseTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$organizationType = this.getOrganizationType();
            Object other$organizationType = other.getOrganizationType();
            if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
               Object this$wageQuotaType = this.getWageQuotaType();
               Object other$wageQuotaType = other.getWageQuotaType();
               if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                  Object this$productionLineId = this.getProductionLineId();
                  Object other$productionLineId = other.getProductionLineId();
                  if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                     Object this$factory = this.getFactory();
                     Object other$factory = other.getFactory();
                     if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                        Object this$processName = this.getProcessName();
                        Object other$processName = other.getProcessName();
                        if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                           Object this$leaderName = this.getLeaderName();
                           Object other$leaderName = other.getLeaderName();
                           if (this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName)) {
                              Object this$productionLineName = this.getProductionLineName();
                              Object other$productionLineName = other.getProductionLineName();
                              return this$productionLineName == null
                                 ? other$productionLineName == null
                                 : this$productionLineName.equals(other$productionLineName);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof UseTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $leaderName = this.getLeaderName();
      result = result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      return result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
   }

   public static class UseTeamDTOBuilder {
      private Long id;
      private FactoryDetailDO factory;
      private Long processId;
      private String processName;
      private Boolean organizationType;
      private Integer wageQuotaType;
      private String leaderName;
      private Long productionLineId;
      private String productionLineName;

      UseTeamDTOBuilder() {
      }

      @JsonProperty("id")
      public UseTeamDTO.UseTeamDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factory")
      public UseTeamDTO.UseTeamDTOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("processId")
      public UseTeamDTO.UseTeamDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public UseTeamDTO.UseTeamDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("organizationType")
      public UseTeamDTO.UseTeamDTOBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public UseTeamDTO.UseTeamDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("leaderName")
      public UseTeamDTO.UseTeamDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      public UseTeamDTO.UseTeamDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public UseTeamDTO.UseTeamDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      public UseTeamDTO build() {
         return new UseTeamDTO(
            this.id,
            this.factory,
            this.processId,
            this.processName,
            this.organizationType,
            this.wageQuotaType,
            this.leaderName,
            this.productionLineId,
            this.productionLineName
         );
      }

      @Override
      public String toString() {
         return "UseTeamDTO.UseTeamDTOBuilder(id="
            + this.id
            + ", factory="
            + this.factory
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", organizationType="
            + this.organizationType
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", leaderName="
            + this.leaderName
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ")";
      }
   }
}
