package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessAndQuantityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingWIPStatisticsDTO", description = "在制品统计DTO")
public class MesBuildingWIPStatisticsDTO {
   @ApiModelProperty(name = "id")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "serialNumber", value = "项目编号")
   private String serialNumber;
   @ApiModelProperty(name = "workShopId")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "branchCompanyIds", value = "关联机构ids")
   private String branchCompanyIds;
   @ApiModelProperty(name = "processWipList", value = "工序在制品列表")
   @JsonProperty("processWipList")
   @JSONField(name = "processWipList")
   private List<ProcessAndQuantityDTO> processWipList;

   public static MesBuildingWIPStatisticsDTO.MesBuildingWIPStatisticsDTOBuilder builder() {
      return new MesBuildingWIPStatisticsDTO.MesBuildingWIPStatisticsDTOBuilder();
   }

   public MesBuildingWIPStatisticsDTO() {
   }

   public MesBuildingWIPStatisticsDTO(
      final Long projectId,
      final String projectName,
      final String serialNumber,
      final Long workShopId,
      final String branchCompanyIds,
      final List<ProcessAndQuantityDTO> processWipList
   ) {
      this.projectId = projectId;
      this.projectName = projectName;
      this.serialNumber = serialNumber;
      this.workShopId = workShopId;
      this.branchCompanyIds = branchCompanyIds;
      this.processWipList = processWipList;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getBranchCompanyIds() {
      return this.branchCompanyIds;
   }

   public List<ProcessAndQuantityDTO> getProcessWipList() {
      return this.processWipList;
   }

   public MesBuildingWIPStatisticsDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBuildingWIPStatisticsDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public MesBuildingWIPStatisticsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("workShopId")
   public MesBuildingWIPStatisticsDTO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   public MesBuildingWIPStatisticsDTO setBranchCompanyIds(final String branchCompanyIds) {
      this.branchCompanyIds = branchCompanyIds;
      return this;
   }

   @JsonProperty("processWipList")
   public MesBuildingWIPStatisticsDTO setProcessWipList(final List<ProcessAndQuantityDTO> processWipList) {
      this.processWipList = processWipList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWIPStatisticsDTO)) {
         return false;
      }

      MesBuildingWIPStatisticsDTO other = (MesBuildingWIPStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$workShopId = this.getWorkShopId();
         Object other$workShopId = other.getWorkShopId();
         if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$branchCompanyIds = this.getBranchCompanyIds();
                  Object other$branchCompanyIds = other.getBranchCompanyIds();
                  if (this$branchCompanyIds == null ? other$branchCompanyIds == null : this$branchCompanyIds.equals(other$branchCompanyIds)) {
                     Object this$processWipList = this.getProcessWipList();
                     Object other$processWipList = other.getProcessWipList();
                     return this$processWipList == null ? other$processWipList == null : this$processWipList.equals(other$processWipList);
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
      return other instanceof MesBuildingWIPStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $branchCompanyIds = this.getBranchCompanyIds();
      result = result * 59 + ($branchCompanyIds == null ? 43 : $branchCompanyIds.hashCode());
      Object $processWipList = this.getProcessWipList();
      return result * 59 + ($processWipList == null ? 43 : $processWipList.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingWIPStatisticsDTO(projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", workShopId="
         + this.getWorkShopId()
         + ", branchCompanyIds="
         + this.getBranchCompanyIds()
         + ", processWipList="
         + this.getProcessWipList()
         + ")";
   }

   public static class MesBuildingWIPStatisticsDTOBuilder {
      private Long projectId;
      private String projectName;
      private String serialNumber;
      private Long workShopId;
      private String branchCompanyIds;
      private List<ProcessAndQuantityDTO> processWipList;

      MesBuildingWIPStatisticsDTOBuilder() {
      }

      public MesBuildingWIPStatisticsDTO.MesBuildingWIPStatisticsDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingWIPStatisticsDTO.MesBuildingWIPStatisticsDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public MesBuildingWIPStatisticsDTO.MesBuildingWIPStatisticsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("workShopId")
      public MesBuildingWIPStatisticsDTO.MesBuildingWIPStatisticsDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      public MesBuildingWIPStatisticsDTO.MesBuildingWIPStatisticsDTOBuilder branchCompanyIds(final String branchCompanyIds) {
         this.branchCompanyIds = branchCompanyIds;
         return this;
      }

      @JsonProperty("processWipList")
      public MesBuildingWIPStatisticsDTO.MesBuildingWIPStatisticsDTOBuilder processWipList(final List<ProcessAndQuantityDTO> processWipList) {
         this.processWipList = processWipList;
         return this;
      }

      public MesBuildingWIPStatisticsDTO build() {
         return new MesBuildingWIPStatisticsDTO(
            this.projectId, this.projectName, this.serialNumber, this.workShopId, this.branchCompanyIds, this.processWipList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWIPStatisticsDTO.MesBuildingWIPStatisticsDTOBuilder(projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", serialNumber="
            + this.serialNumber
            + ", workShopId="
            + this.workShopId
            + ", branchCompanyIds="
            + this.branchCompanyIds
            + ", processWipList="
            + this.processWipList
            + ")";
      }
   }
}
