package com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InspectionTeamReportSummaryByteamDO", description = "")
public class InspectionTeamReportSummaryByteamDO {
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   private Long factoryId;
   @ApiModelProperty(name = "factoryName", value = "工厂名", notes = "工厂名")
   private String factoryName;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", value = "车间名", notes = "车间名")
   private String workshopName;
   @ApiModelProperty(name = "productionLineId", value = "产线id", notes = "产线id")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", value = "产线名", notes = "产线名")
   private String productionLineName;
   @ApiModelProperty(name = "groupId", notes = "生产组")
   @JsonProperty("groupId")
   @JSONField(name = "groupId")
   private Long groupId;
   @ApiModelProperty(name = "processId", notes = "质检信息")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "teamid", notes = "质检队id")
   @JsonProperty("teamid")
   @JSONField(name = "teamid")
   private Long teamid;
   @ApiModelProperty(name = "inspectionQuantity", notes = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "qhseQuantity", notes = "问题数量")
   @JsonProperty("qhseQuantity")
   @JSONField(name = "qhseQuantity")
   private Integer qhseQuantity;

   public static InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder builder() {
      return new InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder();
   }

   public InspectionTeamReportSummaryByteamDO(
      final Long factoryId,
      final String factoryName,
      final Long workshopId,
      final String workshopName,
      final Long productionLineId,
      final String productionLineName,
      final Long groupId,
      final Long processId,
      final Long teamid,
      final Integer inspectionQuantity,
      final Integer qhseQuantity
   ) {
      this.factoryId = factoryId;
      this.factoryName = factoryName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.groupId = groupId;
      this.processId = processId;
      this.teamid = teamid;
      this.inspectionQuantity = inspectionQuantity;
      this.qhseQuantity = qhseQuantity;
   }

   public InspectionTeamReportSummaryByteamDO() {
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamid() {
      return this.teamid;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Integer getQhseQuantity() {
      return this.qhseQuantity;
   }

   public InspectionTeamReportSummaryByteamDO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public InspectionTeamReportSummaryByteamDO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   public InspectionTeamReportSummaryByteamDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public InspectionTeamReportSummaryByteamDO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public InspectionTeamReportSummaryByteamDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   public InspectionTeamReportSummaryByteamDO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("groupId")
   public InspectionTeamReportSummaryByteamDO setGroupId(final Long groupId) {
      this.groupId = groupId;
      return this;
   }

   @JsonProperty("processId")
   public InspectionTeamReportSummaryByteamDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("teamid")
   public InspectionTeamReportSummaryByteamDO setTeamid(final Long teamid) {
      this.teamid = teamid;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public InspectionTeamReportSummaryByteamDO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("qhseQuantity")
   public InspectionTeamReportSummaryByteamDO setQhseQuantity(final Integer qhseQuantity) {
      this.qhseQuantity = qhseQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "InspectionTeamReportSummaryByteamDO(factoryId="
         + this.getFactoryId()
         + ", factoryName="
         + this.getFactoryName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", groupId="
         + this.getGroupId()
         + ", processId="
         + this.getProcessId()
         + ", teamid="
         + this.getTeamid()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", qhseQuantity="
         + this.getQhseQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionTeamReportSummaryByteamDO)) {
         return false;
      }

      InspectionTeamReportSummaryByteamDO other = (InspectionTeamReportSummaryByteamDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$factoryId = this.getFactoryId();
      Object other$factoryId = other.getFactoryId();
      if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$productionLineId = this.getProductionLineId();
            Object other$productionLineId = other.getProductionLineId();
            if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
               Object this$groupId = this.getGroupId();
               Object other$groupId = other.getGroupId();
               if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$teamid = this.getTeamid();
                     Object other$teamid = other.getTeamid();
                     if (this$teamid == null ? other$teamid == null : this$teamid.equals(other$teamid)) {
                        Object this$inspectionQuantity = this.getInspectionQuantity();
                        Object other$inspectionQuantity = other.getInspectionQuantity();
                        if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                           Object this$qhseQuantity = this.getQhseQuantity();
                           Object other$qhseQuantity = other.getQhseQuantity();
                           if (this$qhseQuantity == null ? other$qhseQuantity == null : this$qhseQuantity.equals(other$qhseQuantity)) {
                              Object this$factoryName = this.getFactoryName();
                              Object other$factoryName = other.getFactoryName();
                              if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                                 Object this$workshopName = this.getWorkshopName();
                                 Object other$workshopName = other.getWorkshopName();
                                 if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InspectionTeamReportSummaryByteamDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamid = this.getTeamid();
      result = result * 59 + ($teamid == null ? 43 : $teamid.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $qhseQuantity = this.getQhseQuantity();
      result = result * 59 + ($qhseQuantity == null ? 43 : $qhseQuantity.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      return result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
   }

   public static class InspectionTeamReportSummaryByteamDOBuilder {
      private Long factoryId;
      private String factoryName;
      private Long workshopId;
      private String workshopName;
      private Long productionLineId;
      private String productionLineName;
      private Long groupId;
      private Long processId;
      private Long teamid;
      private Integer inspectionQuantity;
      private Integer qhseQuantity;

      InspectionTeamReportSummaryByteamDOBuilder() {
      }

      public InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      public InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("groupId")
      public InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      @JsonProperty("processId")
      public InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("teamid")
      public InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder teamid(final Long teamid) {
         this.teamid = teamid;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("qhseQuantity")
      public InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder qhseQuantity(final Integer qhseQuantity) {
         this.qhseQuantity = qhseQuantity;
         return this;
      }

      public InspectionTeamReportSummaryByteamDO build() {
         return new InspectionTeamReportSummaryByteamDO(
            this.factoryId,
            this.factoryName,
            this.workshopId,
            this.workshopName,
            this.productionLineId,
            this.productionLineName,
            this.groupId,
            this.processId,
            this.teamid,
            this.inspectionQuantity,
            this.qhseQuantity
         );
      }

      @Override
      public String toString() {
         return "InspectionTeamReportSummaryByteamDO.InspectionTeamReportSummaryByteamDOBuilder(factoryId="
            + this.factoryId
            + ", factoryName="
            + this.factoryName
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ", groupId="
            + this.groupId
            + ", processId="
            + this.processId
            + ", teamid="
            + this.teamid
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", qhseQuantity="
            + this.qhseQuantity
            + ")";
      }
   }
}
