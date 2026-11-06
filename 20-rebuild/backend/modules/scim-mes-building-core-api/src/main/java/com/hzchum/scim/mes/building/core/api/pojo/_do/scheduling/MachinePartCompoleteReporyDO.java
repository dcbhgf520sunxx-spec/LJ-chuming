package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel(value = "MachinePartCompoleteReporyDO", description = "零件排产完成保存 ")
public class MachinePartCompoleteReporyDO {
   private MesBuildingTaskProcess mesBuildingTaskProcess;
   private Integer reportQuantity;
   private Long teamId;
   private List<Integer> numberList;

   public static MachinePartCompoleteReporyDO.MachinePartCompoleteReporyDOBuilder builder() {
      return new MachinePartCompoleteReporyDO.MachinePartCompoleteReporyDOBuilder();
   }

   public MachinePartCompoleteReporyDO() {
   }

   public MachinePartCompoleteReporyDO(
      final MesBuildingTaskProcess mesBuildingTaskProcess, final Integer reportQuantity, final Long teamId, final List<Integer> numberList
   ) {
      this.mesBuildingTaskProcess = mesBuildingTaskProcess;
      this.reportQuantity = reportQuantity;
      this.teamId = teamId;
      this.numberList = numberList;
   }

   public MesBuildingTaskProcess getMesBuildingTaskProcess() {
      return this.mesBuildingTaskProcess;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public MachinePartCompoleteReporyDO setMesBuildingTaskProcess(final MesBuildingTaskProcess mesBuildingTaskProcess) {
      this.mesBuildingTaskProcess = mesBuildingTaskProcess;
      return this;
   }

   public MachinePartCompoleteReporyDO setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   public MachinePartCompoleteReporyDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public MachinePartCompoleteReporyDO setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartCompoleteReporyDO(mesBuildingTaskProcess="
         + this.getMesBuildingTaskProcess()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", teamId="
         + this.getTeamId()
         + ", numberList="
         + this.getNumberList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartCompoleteReporyDO)) {
         return false;
      }

      MachinePartCompoleteReporyDO other = (MachinePartCompoleteReporyDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reportQuantity = this.getReportQuantity();
      Object other$reportQuantity = other.getReportQuantity();
      if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
         Object this$teamId = this.getTeamId();
         Object other$teamId = other.getTeamId();
         if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
            Object this$mesBuildingTaskProcess = this.getMesBuildingTaskProcess();
            Object other$mesBuildingTaskProcess = other.getMesBuildingTaskProcess();
            if (this$mesBuildingTaskProcess == null ? other$mesBuildingTaskProcess == null : this$mesBuildingTaskProcess.equals(other$mesBuildingTaskProcess)) {
               Object this$numberList = this.getNumberList();
               Object other$numberList = other.getNumberList();
               return this$numberList == null ? other$numberList == null : this$numberList.equals(other$numberList);
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
      return other instanceof MachinePartCompoleteReporyDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $mesBuildingTaskProcess = this.getMesBuildingTaskProcess();
      result = result * 59 + ($mesBuildingTaskProcess == null ? 43 : $mesBuildingTaskProcess.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   public static class MachinePartCompoleteReporyDOBuilder {
      private MesBuildingTaskProcess mesBuildingTaskProcess;
      private Integer reportQuantity;
      private Long teamId;
      private List<Integer> numberList;

      MachinePartCompoleteReporyDOBuilder() {
      }

      public MachinePartCompoleteReporyDO.MachinePartCompoleteReporyDOBuilder mesBuildingTaskProcess(final MesBuildingTaskProcess mesBuildingTaskProcess) {
         this.mesBuildingTaskProcess = mesBuildingTaskProcess;
         return this;
      }

      public MachinePartCompoleteReporyDO.MachinePartCompoleteReporyDOBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      public MachinePartCompoleteReporyDO.MachinePartCompoleteReporyDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MachinePartCompoleteReporyDO.MachinePartCompoleteReporyDOBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      public MachinePartCompoleteReporyDO build() {
         return new MachinePartCompoleteReporyDO(this.mesBuildingTaskProcess, this.reportQuantity, this.teamId, this.numberList);
      }

      @Override
      public String toString() {
         return "MachinePartCompoleteReporyDO.MachinePartCompoleteReporyDOBuilder(mesBuildingTaskProcess="
            + this.mesBuildingTaskProcess
            + ", reportQuantity="
            + this.reportQuantity
            + ", teamId="
            + this.teamId
            + ", numberList="
            + this.numberList
            + ")";
      }
   }
}
