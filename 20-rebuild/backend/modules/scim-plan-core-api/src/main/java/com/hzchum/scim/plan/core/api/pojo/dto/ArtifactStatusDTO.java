package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class ArtifactStatusDTO {
   private Long productId;
   @ApiModelProperty(name = "serialNumber", value = "构件编号", notes = "构件编号")
   private String serialNumber;
   private Integer number;
   private Long taskProcessId;
   private Long processId;
   private Long taskId;
   private String processName;
   private Boolean boolReport;
   private Boolean boolInspection;
   private Boolean boolCargo;
   private Boolean boolComplete;
   private Long workshopId;
   private String workshopName;
   private Long lineId;
   private String lineName;
   private Long groupId;
   private String groupName;
   private Long reportId;
   private Long teamId;
   private String leaderName;

   public static ArtifactStatusDTO.ArtifactStatusDTOBuilder builder() {
      return new ArtifactStatusDTO.ArtifactStatusDTOBuilder();
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Boolean getBoolReport() {
      return this.boolReport;
   }

   public Boolean getBoolInspection() {
      return this.boolInspection;
   }

   public Boolean getBoolCargo() {
      return this.boolCargo;
   }

   public Boolean getBoolComplete() {
      return this.boolComplete;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public String getLineName() {
      return this.lineName;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public String getGroupName() {
      return this.groupName;
   }

   public Long getReportId() {
      return this.reportId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setBoolReport(final Boolean boolReport) {
      this.boolReport = boolReport;
   }

   public void setBoolInspection(final Boolean boolInspection) {
      this.boolInspection = boolInspection;
   }

   public void setBoolCargo(final Boolean boolCargo) {
      this.boolCargo = boolCargo;
   }

   public void setBoolComplete(final Boolean boolComplete) {
      this.boolComplete = boolComplete;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setLineId(final Long lineId) {
      this.lineId = lineId;
   }

   public void setLineName(final String lineName) {
      this.lineName = lineName;
   }

   public void setGroupId(final Long groupId) {
      this.groupId = groupId;
   }

   public void setGroupName(final String groupName) {
      this.groupName = groupName;
   }

   public void setReportId(final Long reportId) {
      this.reportId = reportId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactStatusDTO)) {
         return false;
      }

      ArtifactStatusDTO other = (ArtifactStatusDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$taskProcessId = this.getTaskProcessId();
            Object other$taskProcessId = other.getTaskProcessId();
            if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$taskId = this.getTaskId();
                  Object other$taskId = other.getTaskId();
                  if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                     Object this$boolReport = this.getBoolReport();
                     Object other$boolReport = other.getBoolReport();
                     if (this$boolReport == null ? other$boolReport == null : this$boolReport.equals(other$boolReport)) {
                        Object this$boolInspection = this.getBoolInspection();
                        Object other$boolInspection = other.getBoolInspection();
                        if (this$boolInspection == null ? other$boolInspection == null : this$boolInspection.equals(other$boolInspection)) {
                           Object this$boolCargo = this.getBoolCargo();
                           Object other$boolCargo = other.getBoolCargo();
                           if (this$boolCargo == null ? other$boolCargo == null : this$boolCargo.equals(other$boolCargo)) {
                              Object this$boolComplete = this.getBoolComplete();
                              Object other$boolComplete = other.getBoolComplete();
                              if (this$boolComplete == null ? other$boolComplete == null : this$boolComplete.equals(other$boolComplete)) {
                                 Object this$workshopId = this.getWorkshopId();
                                 Object other$workshopId = other.getWorkshopId();
                                 if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                    Object this$lineId = this.getLineId();
                                    Object other$lineId = other.getLineId();
                                    if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
                                       Object this$groupId = this.getGroupId();
                                       Object other$groupId = other.getGroupId();
                                       if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
                                          Object this$reportId = this.getReportId();
                                          Object other$reportId = other.getReportId();
                                          if (this$reportId == null ? other$reportId == null : this$reportId.equals(other$reportId)) {
                                             Object this$teamId = this.getTeamId();
                                             Object other$teamId = other.getTeamId();
                                             if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$processName = this.getProcessName();
                                                   Object other$processName = other.getProcessName();
                                                   if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                                      Object this$workshopName = this.getWorkshopName();
                                                      Object other$workshopName = other.getWorkshopName();
                                                      if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)
                                                         )
                                                       {
                                                         Object this$lineName = this.getLineName();
                                                         Object other$lineName = other.getLineName();
                                                         if (this$lineName == null ? other$lineName == null : this$lineName.equals(other$lineName)) {
                                                            Object this$groupName = this.getGroupName();
                                                            Object other$groupName = other.getGroupName();
                                                            if (this$groupName == null ? other$groupName == null : this$groupName.equals(other$groupName)) {
                                                               Object this$leaderName = this.getLeaderName();
                                                               Object other$leaderName = other.getLeaderName();
                                                               return this$leaderName == null
                                                                  ? other$leaderName == null
                                                                  : this$leaderName.equals(other$leaderName);
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
      return other instanceof ArtifactStatusDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $boolReport = this.getBoolReport();
      result = result * 59 + ($boolReport == null ? 43 : $boolReport.hashCode());
      Object $boolInspection = this.getBoolInspection();
      result = result * 59 + ($boolInspection == null ? 43 : $boolInspection.hashCode());
      Object $boolCargo = this.getBoolCargo();
      result = result * 59 + ($boolCargo == null ? 43 : $boolCargo.hashCode());
      Object $boolComplete = this.getBoolComplete();
      result = result * 59 + ($boolComplete == null ? 43 : $boolComplete.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $reportId = this.getReportId();
      result = result * 59 + ($reportId == null ? 43 : $reportId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $lineName = this.getLineName();
      result = result * 59 + ($lineName == null ? 43 : $lineName.hashCode());
      Object $groupName = this.getGroupName();
      result = result * 59 + ($groupName == null ? 43 : $groupName.hashCode());
      Object $leaderName = this.getLeaderName();
      return result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactStatusDTO(productId="
         + this.getProductId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", number="
         + this.getNumber()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", processId="
         + this.getProcessId()
         + ", taskId="
         + this.getTaskId()
         + ", processName="
         + this.getProcessName()
         + ", boolReport="
         + this.getBoolReport()
         + ", boolInspection="
         + this.getBoolInspection()
         + ", boolCargo="
         + this.getBoolCargo()
         + ", boolComplete="
         + this.getBoolComplete()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", lineId="
         + this.getLineId()
         + ", lineName="
         + this.getLineName()
         + ", groupId="
         + this.getGroupId()
         + ", groupName="
         + this.getGroupName()
         + ", reportId="
         + this.getReportId()
         + ", teamId="
         + this.getTeamId()
         + ", leaderName="
         + this.getLeaderName()
         + ")";
   }

   public ArtifactStatusDTO(
      final Long productId,
      final String serialNumber,
      final Integer number,
      final Long taskProcessId,
      final Long processId,
      final Long taskId,
      final String processName,
      final Boolean boolReport,
      final Boolean boolInspection,
      final Boolean boolCargo,
      final Boolean boolComplete,
      final Long workshopId,
      final String workshopName,
      final Long lineId,
      final String lineName,
      final Long groupId,
      final String groupName,
      final Long reportId,
      final Long teamId,
      final String leaderName
   ) {
      this.productId = productId;
      this.serialNumber = serialNumber;
      this.number = number;
      this.taskProcessId = taskProcessId;
      this.processId = processId;
      this.taskId = taskId;
      this.processName = processName;
      this.boolReport = boolReport;
      this.boolInspection = boolInspection;
      this.boolCargo = boolCargo;
      this.boolComplete = boolComplete;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.lineId = lineId;
      this.lineName = lineName;
      this.groupId = groupId;
      this.groupName = groupName;
      this.reportId = reportId;
      this.teamId = teamId;
      this.leaderName = leaderName;
   }

   public ArtifactStatusDTO() {
   }

   public static class ArtifactStatusDTOBuilder {
      private Long productId;
      private String serialNumber;
      private Integer number;
      private Long taskProcessId;
      private Long processId;
      private Long taskId;
      private String processName;
      private Boolean boolReport;
      private Boolean boolInspection;
      private Boolean boolCargo;
      private Boolean boolComplete;
      private Long workshopId;
      private String workshopName;
      private Long lineId;
      private String lineName;
      private Long groupId;
      private String groupName;
      private Long reportId;
      private Long teamId;
      private String leaderName;

      ArtifactStatusDTOBuilder() {
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder boolReport(final Boolean boolReport) {
         this.boolReport = boolReport;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder boolInspection(final Boolean boolInspection) {
         this.boolInspection = boolInspection;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder boolCargo(final Boolean boolCargo) {
         this.boolCargo = boolCargo;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder boolComplete(final Boolean boolComplete) {
         this.boolComplete = boolComplete;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder lineName(final String lineName) {
         this.lineName = lineName;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder groupName(final String groupName) {
         this.groupName = groupName;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder reportId(final Long reportId) {
         this.reportId = reportId;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public ArtifactStatusDTO.ArtifactStatusDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      public ArtifactStatusDTO build() {
         return new ArtifactStatusDTO(
            this.productId,
            this.serialNumber,
            this.number,
            this.taskProcessId,
            this.processId,
            this.taskId,
            this.processName,
            this.boolReport,
            this.boolInspection,
            this.boolCargo,
            this.boolComplete,
            this.workshopId,
            this.workshopName,
            this.lineId,
            this.lineName,
            this.groupId,
            this.groupName,
            this.reportId,
            this.teamId,
            this.leaderName
         );
      }

      @Override
      public String toString() {
         return "ArtifactStatusDTO.ArtifactStatusDTOBuilder(productId="
            + this.productId
            + ", serialNumber="
            + this.serialNumber
            + ", number="
            + this.number
            + ", taskProcessId="
            + this.taskProcessId
            + ", processId="
            + this.processId
            + ", taskId="
            + this.taskId
            + ", processName="
            + this.processName
            + ", boolReport="
            + this.boolReport
            + ", boolInspection="
            + this.boolInspection
            + ", boolCargo="
            + this.boolCargo
            + ", boolComplete="
            + this.boolComplete
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", lineId="
            + this.lineId
            + ", lineName="
            + this.lineName
            + ", groupId="
            + this.groupId
            + ", groupName="
            + this.groupName
            + ", reportId="
            + this.reportId
            + ", teamId="
            + this.teamId
            + ", leaderName="
            + this.leaderName
            + ")";
      }
   }
}
