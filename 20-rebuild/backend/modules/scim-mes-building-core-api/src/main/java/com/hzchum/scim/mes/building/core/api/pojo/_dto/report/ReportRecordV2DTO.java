package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class ReportRecordV2DTO {
   @ApiModelProperty(name = "taskProcessId", value = "工序详情表id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   private Long taskProcessId;
   @ApiModelProperty(name = "productId", value = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "reprotQuantity", value = "上报数量")
   @JsonProperty("reprotQuantity")
   @JSONField(name = "reprotQuantity")
   private Integer reprotQuantity;
   @ApiModelProperty(name = "inspectionQuantity", value = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "canInspectQuantity", value = "可质检数")
   @JsonProperty("canInspectQuantity")
   @JSONField(name = "canInspectQuantity")
   private Integer canInspectQuantity;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "productName", notes = "产品名称")
   @JsonProperty("productName")
   @JSONField(name = "productName")
   private String productName;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "areaBatch", notes = "批次")
   @JsonProperty("areaBatch")
   @JSONField(name = "areaBatch")
   private NameInfo areaBatch;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "team", notes = "生产班组")
   @JsonProperty("team")
   @JSONField(name = "team")
   private NameInfo team;
   @ApiModelProperty(name = "reportTime", notes = "上报时间")
   @JsonProperty("reportTime")
   @JSONField(name = "reportTime")
   private LocalDateTime reportTime;
   @ApiModelProperty(name = "reportNumberId", notes = "上报的次数Id")
   @JsonProperty("reportNumberId")
   @JSONField(name = "reportNumberId")
   private Long reportNumberId;
   @ApiModelProperty(name = "reportType", notes = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "user", notes = "上报人")
   @JsonProperty("user")
   @JSONField(name = "user")
   private IdAndNameDO user;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "booleOneCode", notes = "是否一物一码")
   @JsonProperty("booleOneCode")
   @JSONField(name = "booleOneCode")
   private Boolean booleOneCode;
   @ApiModelProperty(name = "unInspectNumbers", notes = "需要质检的一物一码")
   @JsonProperty("unInspectNumbers")
   @JSONField(name = "unInspectNumbers")
   private List<Integer> unInspectNumbers;
   @ApiModelProperty(name = "nextProcess", notes = "下一道工序")
   @JsonProperty("nextProcess")
   @JSONField(name = "nextProcess")
   private IdAndNameDO nextProcess;
   @ApiModelProperty(name = "inspectNumbers", notes = "质检通过的一物一码")
   @JsonProperty("inspectNumbers")
   @JSONField(name = "inspectNumbers")
   private List<Integer> inspectNumbers;
   @ApiModelProperty(name = "number", notes = "一物一码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;

   public static ReportRecordV2DTO.ReportRecordV2DTOBuilder builder() {
      return new ReportRecordV2DTO.ReportRecordV2DTOBuilder();
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getReprotQuantity() {
      return this.reprotQuantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Integer getCanInspectQuantity() {
      return this.canInspectQuantity;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProductName() {
      return this.productName;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public NameInfo getAreaBatch() {
      return this.areaBatch;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   public NameInfo getTeam() {
      return this.team;
   }

   public LocalDateTime getReportTime() {
      return this.reportTime;
   }

   public Long getReportNumberId() {
      return this.reportNumberId;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public IdAndNameDO getUser() {
      return this.user;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Boolean getBooleOneCode() {
      return this.booleOneCode;
   }

   public List<Integer> getUnInspectNumbers() {
      return this.unInspectNumbers;
   }

   public IdAndNameDO getNextProcess() {
      return this.nextProcess;
   }

   public List<Integer> getInspectNumbers() {
      return this.inspectNumbers;
   }

   public Integer getNumber() {
      return this.number;
   }

   @JsonProperty("taskProcessId")
   public void setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
   }

   @JsonProperty("productId")
   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   @JsonProperty("reprotQuantity")
   public void setReprotQuantity(final Integer reprotQuantity) {
      this.reprotQuantity = reprotQuantity;
   }

   @JsonProperty("inspectionQuantity")
   public void setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
   }

   @JsonProperty("canInspectQuantity")
   public void setCanInspectQuantity(final Integer canInspectQuantity) {
      this.canInspectQuantity = canInspectQuantity;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("productName")
   public void setProductName(final String productName) {
      this.productName = productName;
   }

   @JsonProperty("project")
   public void setProject(final ProjectDetailDO project) {
      this.project = project;
   }

   @JsonProperty("monomer")
   public void setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
   }

   @JsonProperty("area")
   public void setArea(final AreaDetailDO area) {
      this.area = area;
   }

   @JsonProperty("areaBatch")
   public void setAreaBatch(final NameInfo areaBatch) {
      this.areaBatch = areaBatch;
   }

   @JsonProperty("workshop")
   public void setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
   }

   @JsonProperty("productionLine")
   public void setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
   }

   @JsonProperty("groups")
   public void setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
   }

   @JsonProperty("team")
   public void setTeam(final NameInfo team) {
      this.team = team;
   }

   @JsonProperty("reportTime")
   public void setReportTime(final LocalDateTime reportTime) {
      this.reportTime = reportTime;
   }

   @JsonProperty("reportNumberId")
   public void setReportNumberId(final Long reportNumberId) {
      this.reportNumberId = reportNumberId;
   }

   @JsonProperty("reportType")
   public void setReportType(final Integer reportType) {
      this.reportType = reportType;
   }

   @JsonProperty("process")
   public void setProcess(final IdAndNameDO process) {
      this.process = process;
   }

   @JsonProperty("user")
   public void setUser(final IdAndNameDO user) {
      this.user = user;
   }

   @JsonProperty("taskTypeEnum")
   public void setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
   }

   @JsonProperty("booleOneCode")
   public void setBooleOneCode(final Boolean booleOneCode) {
      this.booleOneCode = booleOneCode;
   }

   @JsonProperty("unInspectNumbers")
   public void setUnInspectNumbers(final List<Integer> unInspectNumbers) {
      this.unInspectNumbers = unInspectNumbers;
   }

   @JsonProperty("nextProcess")
   public void setNextProcess(final IdAndNameDO nextProcess) {
      this.nextProcess = nextProcess;
   }

   @JsonProperty("inspectNumbers")
   public void setInspectNumbers(final List<Integer> inspectNumbers) {
      this.inspectNumbers = inspectNumbers;
   }

   @JsonProperty("number")
   public void setNumber(final Integer number) {
      this.number = number;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReportRecordV2DTO)) {
         return false;
      }

      ReportRecordV2DTO other = (ReportRecordV2DTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskProcessId = this.getTaskProcessId();
      Object other$taskProcessId = other.getTaskProcessId();
      if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$reprotQuantity = this.getReprotQuantity();
            Object other$reprotQuantity = other.getReprotQuantity();
            if (this$reprotQuantity == null ? other$reprotQuantity == null : this$reprotQuantity.equals(other$reprotQuantity)) {
               Object this$inspectionQuantity = this.getInspectionQuantity();
               Object other$inspectionQuantity = other.getInspectionQuantity();
               if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                  Object this$canInspectQuantity = this.getCanInspectQuantity();
                  Object other$canInspectQuantity = other.getCanInspectQuantity();
                  if (this$canInspectQuantity == null ? other$canInspectQuantity == null : this$canInspectQuantity.equals(other$canInspectQuantity)) {
                     Object this$reportNumberId = this.getReportNumberId();
                     Object other$reportNumberId = other.getReportNumberId();
                     if (this$reportNumberId == null ? other$reportNumberId == null : this$reportNumberId.equals(other$reportNumberId)) {
                        Object this$reportType = this.getReportType();
                        Object other$reportType = other.getReportType();
                        if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                           Object this$taskTypeEnum = this.getTaskTypeEnum();
                           Object other$taskTypeEnum = other.getTaskTypeEnum();
                           if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                              Object this$booleOneCode = this.getBooleOneCode();
                              Object other$booleOneCode = other.getBooleOneCode();
                              if (this$booleOneCode == null ? other$booleOneCode == null : this$booleOneCode.equals(other$booleOneCode)) {
                                 Object this$number = this.getNumber();
                                 Object other$number = other.getNumber();
                                 if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$productName = this.getProductName();
                                       Object other$productName = other.getProductName();
                                       if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                                          Object this$project = this.getProject();
                                          Object other$project = other.getProject();
                                          if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                             Object this$monomer = this.getMonomer();
                                             Object other$monomer = other.getMonomer();
                                             if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                Object this$area = this.getArea();
                                                Object other$area = other.getArea();
                                                if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                   Object this$areaBatch = this.getAreaBatch();
                                                   Object other$areaBatch = other.getAreaBatch();
                                                   if (this$areaBatch == null ? other$areaBatch == null : this$areaBatch.equals(other$areaBatch)) {
                                                      Object this$workshop = this.getWorkshop();
                                                      Object other$workshop = other.getWorkshop();
                                                      if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                         Object this$productionLine = this.getProductionLine();
                                                         Object other$productionLine = other.getProductionLine();
                                                         if (this$productionLine == null
                                                            ? other$productionLine == null
                                                            : this$productionLine.equals(other$productionLine)) {
                                                            Object this$groups = this.getGroups();
                                                            Object other$groups = other.getGroups();
                                                            if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                                                               Object this$team = this.getTeam();
                                                               Object other$team = other.getTeam();
                                                               if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                                                                  Object this$reportTime = this.getReportTime();
                                                                  Object other$reportTime = other.getReportTime();
                                                                  if (this$reportTime == null
                                                                     ? other$reportTime == null
                                                                     : this$reportTime.equals(other$reportTime)) {
                                                                     Object this$process = this.getProcess();
                                                                     Object other$process = other.getProcess();
                                                                     if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                                                        Object this$user = this.getUser();
                                                                        Object other$user = other.getUser();
                                                                        if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                                                                           Object this$unInspectNumbers = this.getUnInspectNumbers();
                                                                           Object other$unInspectNumbers = other.getUnInspectNumbers();
                                                                           if (this$unInspectNumbers == null
                                                                              ? other$unInspectNumbers == null
                                                                              : this$unInspectNumbers.equals(other$unInspectNumbers)) {
                                                                              Object this$nextProcess = this.getNextProcess();
                                                                              Object other$nextProcess = other.getNextProcess();
                                                                              if (this$nextProcess == null
                                                                                 ? other$nextProcess == null
                                                                                 : this$nextProcess.equals(other$nextProcess)) {
                                                                                 Object this$inspectNumbers = this.getInspectNumbers();
                                                                                 Object other$inspectNumbers = other.getInspectNumbers();
                                                                                 return this$inspectNumbers == null
                                                                                    ? other$inspectNumbers == null
                                                                                    : this$inspectNumbers.equals(other$inspectNumbers);
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
      return other instanceof ReportRecordV2DTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $reprotQuantity = this.getReprotQuantity();
      result = result * 59 + ($reprotQuantity == null ? 43 : $reprotQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $canInspectQuantity = this.getCanInspectQuantity();
      result = result * 59 + ($canInspectQuantity == null ? 43 : $canInspectQuantity.hashCode());
      Object $reportNumberId = this.getReportNumberId();
      result = result * 59 + ($reportNumberId == null ? 43 : $reportNumberId.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $booleOneCode = this.getBooleOneCode();
      result = result * 59 + ($booleOneCode == null ? 43 : $booleOneCode.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatch = this.getAreaBatch();
      result = result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $reportTime = this.getReportTime();
      result = result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $unInspectNumbers = this.getUnInspectNumbers();
      result = result * 59 + ($unInspectNumbers == null ? 43 : $unInspectNumbers.hashCode());
      Object $nextProcess = this.getNextProcess();
      result = result * 59 + ($nextProcess == null ? 43 : $nextProcess.hashCode());
      Object $inspectNumbers = this.getInspectNumbers();
      return result * 59 + ($inspectNumbers == null ? 43 : $inspectNumbers.hashCode());
   }

   @Override
   public String toString() {
      return "ReportRecordV2DTO(taskProcessId="
         + this.getTaskProcessId()
         + ", productId="
         + this.getProductId()
         + ", reprotQuantity="
         + this.getReprotQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", canInspectQuantity="
         + this.getCanInspectQuantity()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productName="
         + this.getProductName()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", areaBatch="
         + this.getAreaBatch()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", team="
         + this.getTeam()
         + ", reportTime="
         + this.getReportTime()
         + ", reportNumberId="
         + this.getReportNumberId()
         + ", reportType="
         + this.getReportType()
         + ", process="
         + this.getProcess()
         + ", user="
         + this.getUser()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", booleOneCode="
         + this.getBooleOneCode()
         + ", unInspectNumbers="
         + this.getUnInspectNumbers()
         + ", nextProcess="
         + this.getNextProcess()
         + ", inspectNumbers="
         + this.getInspectNumbers()
         + ", number="
         + this.getNumber()
         + ")";
   }

   public ReportRecordV2DTO(
      final Long taskProcessId,
      final Long productId,
      final Integer reprotQuantity,
      final Integer inspectionQuantity,
      final Integer canInspectQuantity,
      final String serialNumber,
      final String productName,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final NameInfo areaBatch,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO groups,
      final NameInfo team,
      final LocalDateTime reportTime,
      final Long reportNumberId,
      final Integer reportType,
      final IdAndNameDO process,
      final IdAndNameDO user,
      final Integer taskTypeEnum,
      final Boolean booleOneCode,
      final List<Integer> unInspectNumbers,
      final IdAndNameDO nextProcess,
      final List<Integer> inspectNumbers,
      final Integer number
   ) {
      this.taskProcessId = taskProcessId;
      this.productId = productId;
      this.reprotQuantity = reprotQuantity;
      this.inspectionQuantity = inspectionQuantity;
      this.canInspectQuantity = canInspectQuantity;
      this.serialNumber = serialNumber;
      this.productName = productName;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.areaBatch = areaBatch;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.team = team;
      this.reportTime = reportTime;
      this.reportNumberId = reportNumberId;
      this.reportType = reportType;
      this.process = process;
      this.user = user;
      this.taskTypeEnum = taskTypeEnum;
      this.booleOneCode = booleOneCode;
      this.unInspectNumbers = unInspectNumbers;
      this.nextProcess = nextProcess;
      this.inspectNumbers = inspectNumbers;
      this.number = number;
   }

   public ReportRecordV2DTO() {
   }

   public static class ReportRecordV2DTOBuilder {
      private Long taskProcessId;
      private Long productId;
      private Integer reprotQuantity;
      private Integer inspectionQuantity;
      private Integer canInspectQuantity;
      private String serialNumber;
      private String productName;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private NameInfo areaBatch;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;
      private NameInfo team;
      private LocalDateTime reportTime;
      private Long reportNumberId;
      private Integer reportType;
      private IdAndNameDO process;
      private IdAndNameDO user;
      private Integer taskTypeEnum;
      private Boolean booleOneCode;
      private List<Integer> unInspectNumbers;
      private IdAndNameDO nextProcess;
      private List<Integer> inspectNumbers;
      private Integer number;

      ReportRecordV2DTOBuilder() {
      }

      @JsonProperty("taskProcessId")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("productId")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("reprotQuantity")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder reprotQuantity(final Integer reprotQuantity) {
         this.reprotQuantity = reprotQuantity;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("canInspectQuantity")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder canInspectQuantity(final Integer canInspectQuantity) {
         this.canInspectQuantity = canInspectQuantity;
         return this;
      }

      @JsonProperty("serialNumber")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("productName")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("project")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("areaBatch")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder areaBatch(final NameInfo areaBatch) {
         this.areaBatch = areaBatch;
         return this;
      }

      @JsonProperty("workshop")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("team")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder team(final NameInfo team) {
         this.team = team;
         return this;
      }

      @JsonProperty("reportTime")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder reportTime(final LocalDateTime reportTime) {
         this.reportTime = reportTime;
         return this;
      }

      @JsonProperty("reportNumberId")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder reportNumberId(final Long reportNumberId) {
         this.reportNumberId = reportNumberId;
         return this;
      }

      @JsonProperty("reportType")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("process")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("user")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder user(final IdAndNameDO user) {
         this.user = user;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("booleOneCode")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder booleOneCode(final Boolean booleOneCode) {
         this.booleOneCode = booleOneCode;
         return this;
      }

      @JsonProperty("unInspectNumbers")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder unInspectNumbers(final List<Integer> unInspectNumbers) {
         this.unInspectNumbers = unInspectNumbers;
         return this;
      }

      @JsonProperty("nextProcess")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder nextProcess(final IdAndNameDO nextProcess) {
         this.nextProcess = nextProcess;
         return this;
      }

      @JsonProperty("inspectNumbers")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder inspectNumbers(final List<Integer> inspectNumbers) {
         this.inspectNumbers = inspectNumbers;
         return this;
      }

      @JsonProperty("number")
      public ReportRecordV2DTO.ReportRecordV2DTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public ReportRecordV2DTO build() {
         return new ReportRecordV2DTO(
            this.taskProcessId,
            this.productId,
            this.reprotQuantity,
            this.inspectionQuantity,
            this.canInspectQuantity,
            this.serialNumber,
            this.productName,
            this.project,
            this.monomer,
            this.area,
            this.areaBatch,
            this.workshop,
            this.productionLine,
            this.groups,
            this.team,
            this.reportTime,
            this.reportNumberId,
            this.reportType,
            this.process,
            this.user,
            this.taskTypeEnum,
            this.booleOneCode,
            this.unInspectNumbers,
            this.nextProcess,
            this.inspectNumbers,
            this.number
         );
      }

      @Override
      public String toString() {
         return "ReportRecordV2DTO.ReportRecordV2DTOBuilder(taskProcessId="
            + this.taskProcessId
            + ", productId="
            + this.productId
            + ", reprotQuantity="
            + this.reprotQuantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", canInspectQuantity="
            + this.canInspectQuantity
            + ", serialNumber="
            + this.serialNumber
            + ", productName="
            + this.productName
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", areaBatch="
            + this.areaBatch
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", team="
            + this.team
            + ", reportTime="
            + this.reportTime
            + ", reportNumberId="
            + this.reportNumberId
            + ", reportType="
            + this.reportType
            + ", process="
            + this.process
            + ", user="
            + this.user
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", booleOneCode="
            + this.booleOneCode
            + ", unInspectNumbers="
            + this.unInspectNumbers
            + ", nextProcess="
            + this.nextProcess
            + ", inspectNumbers="
            + this.inspectNumbers
            + ", number="
            + this.number
            + ")";
      }
   }
}
