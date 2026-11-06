package com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesTeamReportProductStaticsDTO", description = "上报记录DTO")
public class MesTeamReportProductStaticsDTO {
   @ApiModelProperty(name = "id", notes = "上报记录id")
   private Long id;
   @ApiModelProperty(name = "workshopName", notes = "车间名称")
   private String workshopName;
   @ApiModelProperty(name = "productionLineName", notes = "生产线名称")
   private String productionLineName;
   @ApiModelProperty(name = "teamUserName", notes = "班组名称")
   private String teamUserName;
   @ApiModelProperty(name = "processName", notes = "工序名称")
   private String processName;
   @ApiModelProperty(name = "projectName", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "projectSerialNumber", notes = "项目编号")
   private String projectSerialNumber;
   @ApiModelProperty(name = "monomerName", notes = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "areaName", notes = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "areaBatchName", notes = "批次名称")
   private String areaBatchName;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "quantity", notes = "清单数量")
   private Integer quantity;
   @ApiModelProperty(name = "reportQuantity", notes = "上报数量")
   private Integer reportQuantity;
   @ApiModelProperty(name = "inspectionQuantity", notes = "质检通过数量")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "problemQuantity", notes = "问题数量")
   private Integer problemQuantity;
   @ApiModelProperty(name = "number", notes = "一物一码号")
   private Integer number;
   @ApiModelProperty(name = "reportTime", notes = "上报时间")
   private String reportTime;

   public static MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder builder() {
      return new MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder();
   }

   public MesTeamReportProductStaticsDTO() {
   }

   public MesTeamReportProductStaticsDTO(
      final Long id,
      final String workshopName,
      final String productionLineName,
      final String teamUserName,
      final String processName,
      final String projectName,
      final String projectSerialNumber,
      final String monomerName,
      final String areaName,
      final String areaBatchName,
      final String serialNumber,
      final Integer quantity,
      final Integer reportQuantity,
      final Integer inspectionQuantity,
      final Integer problemQuantity,
      final Integer number,
      final String reportTime
   ) {
      this.id = id;
      this.workshopName = workshopName;
      this.productionLineName = productionLineName;
      this.teamUserName = teamUserName;
      this.processName = processName;
      this.projectName = projectName;
      this.projectSerialNumber = projectSerialNumber;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.areaBatchName = areaBatchName;
      this.serialNumber = serialNumber;
      this.quantity = quantity;
      this.reportQuantity = reportQuantity;
      this.inspectionQuantity = inspectionQuantity;
      this.problemQuantity = problemQuantity;
      this.number = number;
      this.reportTime = reportTime;
   }

   public Long getId() {
      return this.id;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public String getTeamUserName() {
      return this.teamUserName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getAreaBatchName() {
      return this.areaBatchName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
   }

   public Integer getNumber() {
      return this.number;
   }

   public String getReportTime() {
      return this.reportTime;
   }

   public MesTeamReportProductStaticsDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesTeamReportProductStaticsDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public MesTeamReportProductStaticsDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   public MesTeamReportProductStaticsDTO setTeamUserName(final String teamUserName) {
      this.teamUserName = teamUserName;
      return this;
   }

   public MesTeamReportProductStaticsDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   public MesTeamReportProductStaticsDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public MesTeamReportProductStaticsDTO setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
      return this;
   }

   public MesTeamReportProductStaticsDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   public MesTeamReportProductStaticsDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   public MesTeamReportProductStaticsDTO setAreaBatchName(final String areaBatchName) {
      this.areaBatchName = areaBatchName;
      return this;
   }

   public MesTeamReportProductStaticsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesTeamReportProductStaticsDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesTeamReportProductStaticsDTO setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   public MesTeamReportProductStaticsDTO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   public MesTeamReportProductStaticsDTO setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   public MesTeamReportProductStaticsDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public MesTeamReportProductStaticsDTO setReportTime(final String reportTime) {
      this.reportTime = reportTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesTeamReportProductStaticsDTO(id="
         + this.getId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", teamUserName="
         + this.getTeamUserName()
         + ", processName="
         + this.getProcessName()
         + ", projectName="
         + this.getProjectName()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ", number="
         + this.getNumber()
         + ", reportTime="
         + this.getReportTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTeamReportProductStaticsDTO)) {
         return false;
      }

      MesTeamReportProductStaticsDTO other = (MesTeamReportProductStaticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$reportQuantity = this.getReportQuantity();
            Object other$reportQuantity = other.getReportQuantity();
            if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
               Object this$inspectionQuantity = this.getInspectionQuantity();
               Object other$inspectionQuantity = other.getInspectionQuantity();
               if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                  Object this$problemQuantity = this.getProblemQuantity();
                  Object other$problemQuantity = other.getProblemQuantity();
                  if (this$problemQuantity == null ? other$problemQuantity == null : this$problemQuantity.equals(other$problemQuantity)) {
                     Object this$number = this.getNumber();
                     Object other$number = other.getNumber();
                     if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                        Object this$workshopName = this.getWorkshopName();
                        Object other$workshopName = other.getWorkshopName();
                        if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                           Object this$productionLineName = this.getProductionLineName();
                           Object other$productionLineName = other.getProductionLineName();
                           if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                              Object this$teamUserName = this.getTeamUserName();
                              Object other$teamUserName = other.getTeamUserName();
                              if (this$teamUserName == null ? other$teamUserName == null : this$teamUserName.equals(other$teamUserName)) {
                                 Object this$processName = this.getProcessName();
                                 Object other$processName = other.getProcessName();
                                 if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                    Object this$projectName = this.getProjectName();
                                    Object other$projectName = other.getProjectName();
                                    if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                       Object this$projectSerialNumber = this.getProjectSerialNumber();
                                       Object other$projectSerialNumber = other.getProjectSerialNumber();
                                       if (this$projectSerialNumber == null
                                          ? other$projectSerialNumber == null
                                          : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                                          Object this$monomerName = this.getMonomerName();
                                          Object other$monomerName = other.getMonomerName();
                                          if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                             Object this$areaName = this.getAreaName();
                                             Object other$areaName = other.getAreaName();
                                             if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                                Object this$areaBatchName = this.getAreaBatchName();
                                                Object other$areaBatchName = other.getAreaBatchName();
                                                if (this$areaBatchName == null ? other$areaBatchName == null : this$areaBatchName.equals(other$areaBatchName)) {
                                                   Object this$serialNumber = this.getSerialNumber();
                                                   Object other$serialNumber = other.getSerialNumber();
                                                   if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                      Object this$reportTime = this.getReportTime();
                                                      Object other$reportTime = other.getReportTime();
                                                      return this$reportTime == null ? other$reportTime == null : this$reportTime.equals(other$reportTime);
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
      return other instanceof MesTeamReportProductStaticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      result = result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $teamUserName = this.getTeamUserName();
      result = result * 59 + ($teamUserName == null ? 43 : $teamUserName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $reportTime = this.getReportTime();
      return result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
   }

   public static class MesTeamReportProductStaticsDTOBuilder {
      private Long id;
      private String workshopName;
      private String productionLineName;
      private String teamUserName;
      private String processName;
      private String projectName;
      private String projectSerialNumber;
      private String monomerName;
      private String areaName;
      private String areaBatchName;
      private String serialNumber;
      private Integer quantity;
      private Integer reportQuantity;
      private Integer inspectionQuantity;
      private Integer problemQuantity;
      private Integer number;
      private String reportTime;

      MesTeamReportProductStaticsDTOBuilder() {
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder teamUserName(final String teamUserName) {
         this.teamUserName = teamUserName;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder projectSerialNumber(final String projectSerialNumber) {
         this.projectSerialNumber = projectSerialNumber;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder areaBatchName(final String areaBatchName) {
         this.areaBatchName = areaBatchName;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder reportTime(final String reportTime) {
         this.reportTime = reportTime;
         return this;
      }

      public MesTeamReportProductStaticsDTO build() {
         return new MesTeamReportProductStaticsDTO(
            this.id,
            this.workshopName,
            this.productionLineName,
            this.teamUserName,
            this.processName,
            this.projectName,
            this.projectSerialNumber,
            this.monomerName,
            this.areaName,
            this.areaBatchName,
            this.serialNumber,
            this.quantity,
            this.reportQuantity,
            this.inspectionQuantity,
            this.problemQuantity,
            this.number,
            this.reportTime
         );
      }

      @Override
      public String toString() {
         return "MesTeamReportProductStaticsDTO.MesTeamReportProductStaticsDTOBuilder(id="
            + this.id
            + ", workshopName="
            + this.workshopName
            + ", productionLineName="
            + this.productionLineName
            + ", teamUserName="
            + this.teamUserName
            + ", processName="
            + this.processName
            + ", projectName="
            + this.projectName
            + ", projectSerialNumber="
            + this.projectSerialNumber
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", areaBatchName="
            + this.areaBatchName
            + ", serialNumber="
            + this.serialNumber
            + ", quantity="
            + this.quantity
            + ", reportQuantity="
            + this.reportQuantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", problemQuantity="
            + this.problemQuantity
            + ", number="
            + this.number
            + ", reportTime="
            + this.reportTime
            + ")";
      }
   }
}
