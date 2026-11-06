package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectSimpleDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesSimpleTeamDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.Map;

@ApiModel(value = "MesBuildingInspectCountDTO对象", description = "质检统计 ")
public class MesBuildingInspectCountDTO {
   @ApiModelProperty(name = "orderNumber", value = "序号")
   private int orderNumber;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", notes = "项目", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectSimpleDTO project;
   @ApiModelProperty(notes = "单体")
   private String monomerName;
   @ApiModelProperty(notes = "区域/围护计划")
   private String areaName;
   @ApiModelProperty(notes = "项目/单体/区域")
   private String projectMonomerArea;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "workshopName", notes = "车间名称", value = "车间名称")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "processName", notes = "工序", value = "工序")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "serialNumber", notes = "编号", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "team", notes = "班组", value = "班组")
   @JsonProperty("team")
   @JSONField(name = "team")
   private MesSimpleTeamDTO team;
   @ApiModelProperty(name = "reportDate", notes = "上报日期", value = "上报日期")
   @JsonProperty("reportDate")
   @JSONField(name = "reportDate")
   private LocalDateTime reportDate;
   @ApiModelProperty(name = "reportDateStr", notes = "上报日期", value = "上报日期")
   @JsonProperty("reportDateStr")
   @JSONField(name = "reportDateStr")
   private String reportDateStr;
   @ApiModelProperty(name = "taskProcessId", value = "任务", notes = "主键ID")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   private Long taskProcessId;
   @ApiModelProperty(name = "inspectionQuantity", notes = "质检数量", value = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "inspectUserName", notes = "质检用户", value = "质检用户")
   @JsonProperty("inspectUserName")
   @JSONField(name = "inspectUserName")
   private String inspectUserName;
   @ApiModelProperty(name = "passageTime", notes = "通过时间", value = "通过时间")
   @JsonProperty("passageTime")
   @JSONField(name = "passageTime")
   private LocalDateTime passageTime;
   @ApiModelProperty(name = "passageTimeStr", notes = "通过时间", value = "通过时间")
   @JsonProperty("passageTimeStr")
   @JSONField(name = "passageTimeStr")
   private String passageTimeStr;
   @ApiModelProperty(name = "number", notes = "码号", value = "码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "qhseMap", value = "问题集合", notes = "问题集合")
   @JsonProperty("qhseMap")
   @JSONField(name = "qhseMap")
   private Map<Long, String> qhseMap;
   @ApiModelProperty(name = "assMap", value = "部件集合", notes = "部件集合")
   @JsonProperty("assMap")
   @JSONField(name = "assMap")
   private Map<Long, String> assMap;

   public static MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder builder() {
      return new MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder();
   }

   public MesBuildingInspectCountDTO() {
   }

   public MesBuildingInspectCountDTO(
      final int orderNumber,
      final Long id,
      final ProjectSimpleDTO project,
      final String monomerName,
      final String areaName,
      final String projectMonomerArea,
      final Integer taskTypeEnum,
      final String workshopName,
      final Long productId,
      final String processName,
      final String serialNumber,
      final MesSimpleTeamDTO team,
      final LocalDateTime reportDate,
      final String reportDateStr,
      final Long taskProcessId,
      final Integer inspectionQuantity,
      final String inspectUserName,
      final LocalDateTime passageTime,
      final String passageTimeStr,
      final Integer number,
      final Map<Long, String> qhseMap,
      final Map<Long, String> assMap
   ) {
      this.orderNumber = orderNumber;
      this.id = id;
      this.project = project;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.projectMonomerArea = projectMonomerArea;
      this.taskTypeEnum = taskTypeEnum;
      this.workshopName = workshopName;
      this.productId = productId;
      this.processName = processName;
      this.serialNumber = serialNumber;
      this.team = team;
      this.reportDate = reportDate;
      this.reportDateStr = reportDateStr;
      this.taskProcessId = taskProcessId;
      this.inspectionQuantity = inspectionQuantity;
      this.inspectUserName = inspectUserName;
      this.passageTime = passageTime;
      this.passageTimeStr = passageTimeStr;
      this.number = number;
      this.qhseMap = qhseMap;
      this.assMap = assMap;
   }

   public int getOrderNumber() {
      return this.orderNumber;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectSimpleDTO getProject() {
      return this.project;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getProjectMonomerArea() {
      return this.projectMonomerArea;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public MesSimpleTeamDTO getTeam() {
      return this.team;
   }

   public LocalDateTime getReportDate() {
      return this.reportDate;
   }

   public String getReportDateStr() {
      return this.reportDateStr;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public String getInspectUserName() {
      return this.inspectUserName;
   }

   public LocalDateTime getPassageTime() {
      return this.passageTime;
   }

   public String getPassageTimeStr() {
      return this.passageTimeStr;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Map<Long, String> getQhseMap() {
      return this.qhseMap;
   }

   public Map<Long, String> getAssMap() {
      return this.assMap;
   }

   public MesBuildingInspectCountDTO setOrderNumber(final int orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("id")
   public MesBuildingInspectCountDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingInspectCountDTO setProject(final ProjectSimpleDTO project) {
      this.project = project;
      return this;
   }

   public MesBuildingInspectCountDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   public MesBuildingInspectCountDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   public MesBuildingInspectCountDTO setProjectMonomerArea(final String projectMonomerArea) {
      this.projectMonomerArea = projectMonomerArea;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingInspectCountDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("workshopName")
   public MesBuildingInspectCountDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingInspectCountDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("processName")
   public MesBuildingInspectCountDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingInspectCountDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("team")
   public MesBuildingInspectCountDTO setTeam(final MesSimpleTeamDTO team) {
      this.team = team;
      return this;
   }

   @JsonProperty("reportDate")
   public MesBuildingInspectCountDTO setReportDate(final LocalDateTime reportDate) {
      this.reportDate = reportDate;
      return this;
   }

   @JsonProperty("reportDateStr")
   public MesBuildingInspectCountDTO setReportDateStr(final String reportDateStr) {
      this.reportDateStr = reportDateStr;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesBuildingInspectCountDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public MesBuildingInspectCountDTO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("inspectUserName")
   public MesBuildingInspectCountDTO setInspectUserName(final String inspectUserName) {
      this.inspectUserName = inspectUserName;
      return this;
   }

   @JsonProperty("passageTime")
   public MesBuildingInspectCountDTO setPassageTime(final LocalDateTime passageTime) {
      this.passageTime = passageTime;
      return this;
   }

   @JsonProperty("passageTimeStr")
   public MesBuildingInspectCountDTO setPassageTimeStr(final String passageTimeStr) {
      this.passageTimeStr = passageTimeStr;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingInspectCountDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("qhseMap")
   public MesBuildingInspectCountDTO setQhseMap(final Map<Long, String> qhseMap) {
      this.qhseMap = qhseMap;
      return this;
   }

   @JsonProperty("assMap")
   public MesBuildingInspectCountDTO setAssMap(final Map<Long, String> assMap) {
      this.assMap = assMap;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingInspectCountDTO)) {
         return false;
      }

      MesBuildingInspectCountDTO other = (MesBuildingInspectCountDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getOrderNumber() != other.getOrderNumber()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskTypeEnum = this.getTaskTypeEnum();
         Object other$taskTypeEnum = other.getTaskTypeEnum();
         if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$taskProcessId = this.getTaskProcessId();
               Object other$taskProcessId = other.getTaskProcessId();
               if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
                  Object this$inspectionQuantity = this.getInspectionQuantity();
                  Object other$inspectionQuantity = other.getInspectionQuantity();
                  if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                     Object this$number = this.getNumber();
                     Object other$number = other.getNumber();
                     if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$monomerName = this.getMonomerName();
                           Object other$monomerName = other.getMonomerName();
                           if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                              Object this$areaName = this.getAreaName();
                              Object other$areaName = other.getAreaName();
                              if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                 Object this$projectMonomerArea = this.getProjectMonomerArea();
                                 Object other$projectMonomerArea = other.getProjectMonomerArea();
                                 if (this$projectMonomerArea == null
                                    ? other$projectMonomerArea == null
                                    : this$projectMonomerArea.equals(other$projectMonomerArea)) {
                                    Object this$workshopName = this.getWorkshopName();
                                    Object other$workshopName = other.getWorkshopName();
                                    if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                       Object this$processName = this.getProcessName();
                                       Object other$processName = other.getProcessName();
                                       if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$team = this.getTeam();
                                             Object other$team = other.getTeam();
                                             if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                                                Object this$reportDate = this.getReportDate();
                                                Object other$reportDate = other.getReportDate();
                                                if (this$reportDate == null ? other$reportDate == null : this$reportDate.equals(other$reportDate)) {
                                                   Object this$reportDateStr = this.getReportDateStr();
                                                   Object other$reportDateStr = other.getReportDateStr();
                                                   if (this$reportDateStr == null
                                                      ? other$reportDateStr == null
                                                      : this$reportDateStr.equals(other$reportDateStr)) {
                                                      Object this$inspectUserName = this.getInspectUserName();
                                                      Object other$inspectUserName = other.getInspectUserName();
                                                      if (this$inspectUserName == null
                                                         ? other$inspectUserName == null
                                                         : this$inspectUserName.equals(other$inspectUserName)) {
                                                         Object this$passageTime = this.getPassageTime();
                                                         Object other$passageTime = other.getPassageTime();
                                                         if (this$passageTime == null ? other$passageTime == null : this$passageTime.equals(other$passageTime)) {
                                                            Object this$passageTimeStr = this.getPassageTimeStr();
                                                            Object other$passageTimeStr = other.getPassageTimeStr();
                                                            if (this$passageTimeStr == null
                                                               ? other$passageTimeStr == null
                                                               : this$passageTimeStr.equals(other$passageTimeStr)) {
                                                               Object this$qhseMap = this.getQhseMap();
                                                               Object other$qhseMap = other.getQhseMap();
                                                               if (this$qhseMap == null ? other$qhseMap == null : this$qhseMap.equals(other$qhseMap)) {
                                                                  Object this$assMap = this.getAssMap();
                                                                  Object other$assMap = other.getAssMap();
                                                                  return this$assMap == null ? other$assMap == null : this$assMap.equals(other$assMap);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingInspectCountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getOrderNumber();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $projectMonomerArea = this.getProjectMonomerArea();
      result = result * 59 + ($projectMonomerArea == null ? 43 : $projectMonomerArea.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $reportDateStr = this.getReportDateStr();
      result = result * 59 + ($reportDateStr == null ? 43 : $reportDateStr.hashCode());
      Object $inspectUserName = this.getInspectUserName();
      result = result * 59 + ($inspectUserName == null ? 43 : $inspectUserName.hashCode());
      Object $passageTime = this.getPassageTime();
      result = result * 59 + ($passageTime == null ? 43 : $passageTime.hashCode());
      Object $passageTimeStr = this.getPassageTimeStr();
      result = result * 59 + ($passageTimeStr == null ? 43 : $passageTimeStr.hashCode());
      Object $qhseMap = this.getQhseMap();
      result = result * 59 + ($qhseMap == null ? 43 : $qhseMap.hashCode());
      Object $assMap = this.getAssMap();
      return result * 59 + ($assMap == null ? 43 : $assMap.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingInspectCountDTO(orderNumber="
         + this.getOrderNumber()
         + ", id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", projectMonomerArea="
         + this.getProjectMonomerArea()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productId="
         + this.getProductId()
         + ", processName="
         + this.getProcessName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", team="
         + this.getTeam()
         + ", reportDate="
         + this.getReportDate()
         + ", reportDateStr="
         + this.getReportDateStr()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", inspectUserName="
         + this.getInspectUserName()
         + ", passageTime="
         + this.getPassageTime()
         + ", passageTimeStr="
         + this.getPassageTimeStr()
         + ", number="
         + this.getNumber()
         + ", qhseMap="
         + this.getQhseMap()
         + ", assMap="
         + this.getAssMap()
         + ")";
   }

   public static class MesBuildingInspectCountDTOBuilder {
      private int orderNumber;
      private Long id;
      private ProjectSimpleDTO project;
      private String monomerName;
      private String areaName;
      private String projectMonomerArea;
      private Integer taskTypeEnum;
      private String workshopName;
      private Long productId;
      private String processName;
      private String serialNumber;
      private MesSimpleTeamDTO team;
      private LocalDateTime reportDate;
      private String reportDateStr;
      private Long taskProcessId;
      private Integer inspectionQuantity;
      private String inspectUserName;
      private LocalDateTime passageTime;
      private String passageTimeStr;
      private Integer number;
      private Map<Long, String> qhseMap;
      private Map<Long, String> assMap;

      MesBuildingInspectCountDTOBuilder() {
      }

      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder orderNumber(final int orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("id")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder project(final ProjectSimpleDTO project) {
         this.project = project;
         return this;
      }

      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder projectMonomerArea(final String projectMonomerArea) {
         this.projectMonomerArea = projectMonomerArea;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("workshopName")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("processName")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("team")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder team(final MesSimpleTeamDTO team) {
         this.team = team;
         return this;
      }

      @JsonProperty("reportDate")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder reportDate(final LocalDateTime reportDate) {
         this.reportDate = reportDate;
         return this;
      }

      @JsonProperty("reportDateStr")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder reportDateStr(final String reportDateStr) {
         this.reportDateStr = reportDateStr;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("inspectUserName")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder inspectUserName(final String inspectUserName) {
         this.inspectUserName = inspectUserName;
         return this;
      }

      @JsonProperty("passageTime")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder passageTime(final LocalDateTime passageTime) {
         this.passageTime = passageTime;
         return this;
      }

      @JsonProperty("passageTimeStr")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder passageTimeStr(final String passageTimeStr) {
         this.passageTimeStr = passageTimeStr;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("qhseMap")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder qhseMap(final Map<Long, String> qhseMap) {
         this.qhseMap = qhseMap;
         return this;
      }

      @JsonProperty("assMap")
      public MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder assMap(final Map<Long, String> assMap) {
         this.assMap = assMap;
         return this;
      }

      public MesBuildingInspectCountDTO build() {
         return new MesBuildingInspectCountDTO(
            this.orderNumber,
            this.id,
            this.project,
            this.monomerName,
            this.areaName,
            this.projectMonomerArea,
            this.taskTypeEnum,
            this.workshopName,
            this.productId,
            this.processName,
            this.serialNumber,
            this.team,
            this.reportDate,
            this.reportDateStr,
            this.taskProcessId,
            this.inspectionQuantity,
            this.inspectUserName,
            this.passageTime,
            this.passageTimeStr,
            this.number,
            this.qhseMap,
            this.assMap
         );
      }

      @Override
      public String toString() {
         return "MesBuildingInspectCountDTO.MesBuildingInspectCountDTOBuilder(orderNumber="
            + this.orderNumber
            + ", id="
            + this.id
            + ", project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", projectMonomerArea="
            + this.projectMonomerArea
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", workshopName="
            + this.workshopName
            + ", productId="
            + this.productId
            + ", processName="
            + this.processName
            + ", serialNumber="
            + this.serialNumber
            + ", team="
            + this.team
            + ", reportDate="
            + this.reportDate
            + ", reportDateStr="
            + this.reportDateStr
            + ", taskProcessId="
            + this.taskProcessId
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", inspectUserName="
            + this.inspectUserName
            + ", passageTime="
            + this.passageTime
            + ", passageTimeStr="
            + this.passageTimeStr
            + ", number="
            + this.number
            + ", qhseMap="
            + this.qhseMap
            + ", assMap="
            + this.assMap
            + ")";
      }
   }
}
