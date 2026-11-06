package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.MonomerAndArea;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.TaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.WorkshopTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.YearMonthDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MachinePartNestingTeamDTO", description = "")
public class MachinePartNestingTeamDTO {
   @ApiModelProperty("项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectInfo project;
   @ApiModelProperty("项目数")
   @JsonProperty("projectCount")
   @JSONField(name = "projectCount")
   private Integer projectCount;
   @ApiModelProperty("排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty("排产件数")
   @JsonProperty("needSchedulingQuantity")
   @JSONField(name = "needSchedulingQuantity")
   private Integer needSchedulingQuantity;
   @ApiModelProperty("已排产数量")
   @JsonProperty("scheduledQuantity")
   @JSONField(name = "scheduledQuantity")
   private Integer scheduledQuantity;
   @ApiModelProperty("已排产重量")
   @JsonProperty("scheduledWeight")
   @JSONField(name = "scheduledWeight")
   private BigDecimal scheduledWeight;
   @ApiModelProperty("排产重量")
   @JsonProperty("schedulingWeight")
   @JSONField(name = "schedulingWeight")
   private BigDecimal schedulingWeight;
   @ApiModelProperty("年月")
   @JsonProperty("yearMonthDTO")
   @JSONField(name = "yearMonthDTO")
   private YearMonthDTO yearMonthDTO;
   @ApiModelProperty("车间班组信息")
   @JsonProperty("workshopTeamDTO")
   @JSONField(name = "workshopTeamDTO")
   private WorkshopTeamDTO workshopTeamDTO;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private String taskOrderId;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty("工单信息")
   @JsonProperty("taskOrderDTO")
   @JSONField(name = "taskOrderDTO")
   private TaskOrderDTO taskOrderDTO;
   @ApiModelProperty("工单集合")
   @JsonProperty("taskOrderDTOList")
   @JSONField(name = "taskOrderDTOList")
   private List<TaskOrderDTO> taskOrderDTOList;
   @ApiModelProperty("车间班组信息集合")
   @JsonProperty("workshopTeamDTOList")
   @JSONField(name = "workshopTeamDTOList")
   private List<WorkshopTeamDTO> workshopTeamDTOList;
   @ApiModelProperty("单体区域Ids")
   private String monomerAndAreaIds;
   @ApiModelProperty(name = "单体区域List")
   private List<MonomerAndArea> monomerAndAreaList;

   public static MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder builder() {
      return new MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder();
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getProjectCount() {
      return this.projectCount;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Integer getNeedSchedulingQuantity() {
      return this.needSchedulingQuantity;
   }

   public Integer getScheduledQuantity() {
      return this.scheduledQuantity;
   }

   public BigDecimal getScheduledWeight() {
      return this.scheduledWeight;
   }

   public BigDecimal getSchedulingWeight() {
      return this.schedulingWeight;
   }

   public YearMonthDTO getYearMonthDTO() {
      return this.yearMonthDTO;
   }

   public WorkshopTeamDTO getWorkshopTeamDTO() {
      return this.workshopTeamDTO;
   }

   public String getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public TaskOrderDTO getTaskOrderDTO() {
      return this.taskOrderDTO;
   }

   public List<TaskOrderDTO> getTaskOrderDTOList() {
      return this.taskOrderDTOList;
   }

   public List<WorkshopTeamDTO> getWorkshopTeamDTOList() {
      return this.workshopTeamDTOList;
   }

   public String getMonomerAndAreaIds() {
      return this.monomerAndAreaIds;
   }

   public List<MonomerAndArea> getMonomerAndAreaList() {
      return this.monomerAndAreaList;
   }

   @JsonProperty("project")
   public MachinePartNestingTeamDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   @JsonProperty("projectCount")
   public MachinePartNestingTeamDTO setProjectCount(final Integer projectCount) {
      this.projectCount = projectCount;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public MachinePartNestingTeamDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("needSchedulingQuantity")
   public MachinePartNestingTeamDTO setNeedSchedulingQuantity(final Integer needSchedulingQuantity) {
      this.needSchedulingQuantity = needSchedulingQuantity;
      return this;
   }

   @JsonProperty("scheduledQuantity")
   public MachinePartNestingTeamDTO setScheduledQuantity(final Integer scheduledQuantity) {
      this.scheduledQuantity = scheduledQuantity;
      return this;
   }

   @JsonProperty("scheduledWeight")
   public MachinePartNestingTeamDTO setScheduledWeight(final BigDecimal scheduledWeight) {
      this.scheduledWeight = scheduledWeight;
      return this;
   }

   @JsonProperty("schedulingWeight")
   public MachinePartNestingTeamDTO setSchedulingWeight(final BigDecimal schedulingWeight) {
      this.schedulingWeight = schedulingWeight;
      return this;
   }

   @JsonProperty("yearMonthDTO")
   public MachinePartNestingTeamDTO setYearMonthDTO(final YearMonthDTO yearMonthDTO) {
      this.yearMonthDTO = yearMonthDTO;
      return this;
   }

   @JsonProperty("workshopTeamDTO")
   public MachinePartNestingTeamDTO setWorkshopTeamDTO(final WorkshopTeamDTO workshopTeamDTO) {
      this.workshopTeamDTO = workshopTeamDTO;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MachinePartNestingTeamDTO setTaskOrderId(final String taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("orderNumber")
   public MachinePartNestingTeamDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("taskOrderDTO")
   public MachinePartNestingTeamDTO setTaskOrderDTO(final TaskOrderDTO taskOrderDTO) {
      this.taskOrderDTO = taskOrderDTO;
      return this;
   }

   @JsonProperty("taskOrderDTOList")
   public MachinePartNestingTeamDTO setTaskOrderDTOList(final List<TaskOrderDTO> taskOrderDTOList) {
      this.taskOrderDTOList = taskOrderDTOList;
      return this;
   }

   @JsonProperty("workshopTeamDTOList")
   public MachinePartNestingTeamDTO setWorkshopTeamDTOList(final List<WorkshopTeamDTO> workshopTeamDTOList) {
      this.workshopTeamDTOList = workshopTeamDTOList;
      return this;
   }

   public MachinePartNestingTeamDTO setMonomerAndAreaIds(final String monomerAndAreaIds) {
      this.monomerAndAreaIds = monomerAndAreaIds;
      return this;
   }

   public MachinePartNestingTeamDTO setMonomerAndAreaList(final List<MonomerAndArea> monomerAndAreaList) {
      this.monomerAndAreaList = monomerAndAreaList;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartNestingTeamDTO(project="
         + this.getProject()
         + ", projectCount="
         + this.getProjectCount()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", needSchedulingQuantity="
         + this.getNeedSchedulingQuantity()
         + ", scheduledQuantity="
         + this.getScheduledQuantity()
         + ", scheduledWeight="
         + this.getScheduledWeight()
         + ", schedulingWeight="
         + this.getSchedulingWeight()
         + ", yearMonthDTO="
         + this.getYearMonthDTO()
         + ", workshopTeamDTO="
         + this.getWorkshopTeamDTO()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", taskOrderDTO="
         + this.getTaskOrderDTO()
         + ", taskOrderDTOList="
         + this.getTaskOrderDTOList()
         + ", workshopTeamDTOList="
         + this.getWorkshopTeamDTOList()
         + ", monomerAndAreaIds="
         + this.getMonomerAndAreaIds()
         + ", monomerAndAreaList="
         + this.getMonomerAndAreaList()
         + ")";
   }

   public MachinePartNestingTeamDTO() {
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartNestingTeamDTO)) {
         return false;
      }

      MachinePartNestingTeamDTO other = (MachinePartNestingTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectCount = this.getProjectCount();
      Object other$projectCount = other.getProjectCount();
      if (this$projectCount == null ? other$projectCount == null : this$projectCount.equals(other$projectCount)) {
         Object this$schedulingQuantity = this.getSchedulingQuantity();
         Object other$schedulingQuantity = other.getSchedulingQuantity();
         if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
            Object this$needSchedulingQuantity = this.getNeedSchedulingQuantity();
            Object other$needSchedulingQuantity = other.getNeedSchedulingQuantity();
            if (this$needSchedulingQuantity == null ? other$needSchedulingQuantity == null : this$needSchedulingQuantity.equals(other$needSchedulingQuantity)) {
               Object this$scheduledQuantity = this.getScheduledQuantity();
               Object other$scheduledQuantity = other.getScheduledQuantity();
               if (this$scheduledQuantity == null ? other$scheduledQuantity == null : this$scheduledQuantity.equals(other$scheduledQuantity)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$scheduledWeight = this.getScheduledWeight();
                     Object other$scheduledWeight = other.getScheduledWeight();
                     if (this$scheduledWeight == null ? other$scheduledWeight == null : this$scheduledWeight.equals(other$scheduledWeight)) {
                        Object this$schedulingWeight = this.getSchedulingWeight();
                        Object other$schedulingWeight = other.getSchedulingWeight();
                        if (this$schedulingWeight == null ? other$schedulingWeight == null : this$schedulingWeight.equals(other$schedulingWeight)) {
                           Object this$yearMonthDTO = this.getYearMonthDTO();
                           Object other$yearMonthDTO = other.getYearMonthDTO();
                           if (this$yearMonthDTO == null ? other$yearMonthDTO == null : this$yearMonthDTO.equals(other$yearMonthDTO)) {
                              Object this$workshopTeamDTO = this.getWorkshopTeamDTO();
                              Object other$workshopTeamDTO = other.getWorkshopTeamDTO();
                              if (this$workshopTeamDTO == null ? other$workshopTeamDTO == null : this$workshopTeamDTO.equals(other$workshopTeamDTO)) {
                                 Object this$taskOrderId = this.getTaskOrderId();
                                 Object other$taskOrderId = other.getTaskOrderId();
                                 if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                                    Object this$orderNumber = this.getOrderNumber();
                                    Object other$orderNumber = other.getOrderNumber();
                                    if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                       Object this$taskOrderDTO = this.getTaskOrderDTO();
                                       Object other$taskOrderDTO = other.getTaskOrderDTO();
                                       if (this$taskOrderDTO == null ? other$taskOrderDTO == null : this$taskOrderDTO.equals(other$taskOrderDTO)) {
                                          Object this$taskOrderDTOList = this.getTaskOrderDTOList();
                                          Object other$taskOrderDTOList = other.getTaskOrderDTOList();
                                          if (this$taskOrderDTOList == null
                                             ? other$taskOrderDTOList == null
                                             : this$taskOrderDTOList.equals(other$taskOrderDTOList)) {
                                             Object this$workshopTeamDTOList = this.getWorkshopTeamDTOList();
                                             Object other$workshopTeamDTOList = other.getWorkshopTeamDTOList();
                                             if (this$workshopTeamDTOList == null
                                                ? other$workshopTeamDTOList == null
                                                : this$workshopTeamDTOList.equals(other$workshopTeamDTOList)) {
                                                Object this$monomerAndAreaIds = this.getMonomerAndAreaIds();
                                                Object other$monomerAndAreaIds = other.getMonomerAndAreaIds();
                                                if (this$monomerAndAreaIds == null
                                                   ? other$monomerAndAreaIds == null
                                                   : this$monomerAndAreaIds.equals(other$monomerAndAreaIds)) {
                                                   Object this$monomerAndAreaList = this.getMonomerAndAreaList();
                                                   Object other$monomerAndAreaList = other.getMonomerAndAreaList();
                                                   return this$monomerAndAreaList == null
                                                      ? other$monomerAndAreaList == null
                                                      : this$monomerAndAreaList.equals(other$monomerAndAreaList);
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
      return other instanceof MachinePartNestingTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectCount = this.getProjectCount();
      result = result * 59 + ($projectCount == null ? 43 : $projectCount.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $needSchedulingQuantity = this.getNeedSchedulingQuantity();
      result = result * 59 + ($needSchedulingQuantity == null ? 43 : $needSchedulingQuantity.hashCode());
      Object $scheduledQuantity = this.getScheduledQuantity();
      result = result * 59 + ($scheduledQuantity == null ? 43 : $scheduledQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $scheduledWeight = this.getScheduledWeight();
      result = result * 59 + ($scheduledWeight == null ? 43 : $scheduledWeight.hashCode());
      Object $schedulingWeight = this.getSchedulingWeight();
      result = result * 59 + ($schedulingWeight == null ? 43 : $schedulingWeight.hashCode());
      Object $yearMonthDTO = this.getYearMonthDTO();
      result = result * 59 + ($yearMonthDTO == null ? 43 : $yearMonthDTO.hashCode());
      Object $workshopTeamDTO = this.getWorkshopTeamDTO();
      result = result * 59 + ($workshopTeamDTO == null ? 43 : $workshopTeamDTO.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $taskOrderDTO = this.getTaskOrderDTO();
      result = result * 59 + ($taskOrderDTO == null ? 43 : $taskOrderDTO.hashCode());
      Object $taskOrderDTOList = this.getTaskOrderDTOList();
      result = result * 59 + ($taskOrderDTOList == null ? 43 : $taskOrderDTOList.hashCode());
      Object $workshopTeamDTOList = this.getWorkshopTeamDTOList();
      result = result * 59 + ($workshopTeamDTOList == null ? 43 : $workshopTeamDTOList.hashCode());
      Object $monomerAndAreaIds = this.getMonomerAndAreaIds();
      result = result * 59 + ($monomerAndAreaIds == null ? 43 : $monomerAndAreaIds.hashCode());
      Object $monomerAndAreaList = this.getMonomerAndAreaList();
      return result * 59 + ($monomerAndAreaList == null ? 43 : $monomerAndAreaList.hashCode());
   }

   public MachinePartNestingTeamDTO(
      final ProjectInfo project,
      final Integer projectCount,
      final Integer schedulingQuantity,
      final Integer needSchedulingQuantity,
      final Integer scheduledQuantity,
      final BigDecimal scheduledWeight,
      final BigDecimal schedulingWeight,
      final YearMonthDTO yearMonthDTO,
      final WorkshopTeamDTO workshopTeamDTO,
      final String taskOrderId,
      final String orderNumber,
      final TaskOrderDTO taskOrderDTO,
      final List<TaskOrderDTO> taskOrderDTOList,
      final List<WorkshopTeamDTO> workshopTeamDTOList,
      final String monomerAndAreaIds,
      final List<MonomerAndArea> monomerAndAreaList
   ) {
      this.project = project;
      this.projectCount = projectCount;
      this.schedulingQuantity = schedulingQuantity;
      this.needSchedulingQuantity = needSchedulingQuantity;
      this.scheduledQuantity = scheduledQuantity;
      this.scheduledWeight = scheduledWeight;
      this.schedulingWeight = schedulingWeight;
      this.yearMonthDTO = yearMonthDTO;
      this.workshopTeamDTO = workshopTeamDTO;
      this.taskOrderId = taskOrderId;
      this.orderNumber = orderNumber;
      this.taskOrderDTO = taskOrderDTO;
      this.taskOrderDTOList = taskOrderDTOList;
      this.workshopTeamDTOList = workshopTeamDTOList;
      this.monomerAndAreaIds = monomerAndAreaIds;
      this.monomerAndAreaList = monomerAndAreaList;
   }

   public static class MachinePartNestingTeamDTOBuilder {
      private ProjectInfo project;
      private Integer projectCount;
      private Integer schedulingQuantity;
      private Integer needSchedulingQuantity;
      private Integer scheduledQuantity;
      private BigDecimal scheduledWeight;
      private BigDecimal schedulingWeight;
      private YearMonthDTO yearMonthDTO;
      private WorkshopTeamDTO workshopTeamDTO;
      private String taskOrderId;
      private String orderNumber;
      private TaskOrderDTO taskOrderDTO;
      private List<TaskOrderDTO> taskOrderDTOList;
      private List<WorkshopTeamDTO> workshopTeamDTOList;
      private String monomerAndAreaIds;
      private List<MonomerAndArea> monomerAndAreaList;

      MachinePartNestingTeamDTOBuilder() {
      }

      @JsonProperty("project")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("projectCount")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder projectCount(final Integer projectCount) {
         this.projectCount = projectCount;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("needSchedulingQuantity")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder needSchedulingQuantity(final Integer needSchedulingQuantity) {
         this.needSchedulingQuantity = needSchedulingQuantity;
         return this;
      }

      @JsonProperty("scheduledQuantity")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder scheduledQuantity(final Integer scheduledQuantity) {
         this.scheduledQuantity = scheduledQuantity;
         return this;
      }

      @JsonProperty("scheduledWeight")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder scheduledWeight(final BigDecimal scheduledWeight) {
         this.scheduledWeight = scheduledWeight;
         return this;
      }

      @JsonProperty("schedulingWeight")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder schedulingWeight(final BigDecimal schedulingWeight) {
         this.schedulingWeight = schedulingWeight;
         return this;
      }

      @JsonProperty("yearMonthDTO")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder yearMonthDTO(final YearMonthDTO yearMonthDTO) {
         this.yearMonthDTO = yearMonthDTO;
         return this;
      }

      @JsonProperty("workshopTeamDTO")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder workshopTeamDTO(final WorkshopTeamDTO workshopTeamDTO) {
         this.workshopTeamDTO = workshopTeamDTO;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder taskOrderId(final String taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("orderNumber")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("taskOrderDTO")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder taskOrderDTO(final TaskOrderDTO taskOrderDTO) {
         this.taskOrderDTO = taskOrderDTO;
         return this;
      }

      @JsonProperty("taskOrderDTOList")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder taskOrderDTOList(final List<TaskOrderDTO> taskOrderDTOList) {
         this.taskOrderDTOList = taskOrderDTOList;
         return this;
      }

      @JsonProperty("workshopTeamDTOList")
      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder workshopTeamDTOList(final List<WorkshopTeamDTO> workshopTeamDTOList) {
         this.workshopTeamDTOList = workshopTeamDTOList;
         return this;
      }

      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder monomerAndAreaIds(final String monomerAndAreaIds) {
         this.monomerAndAreaIds = monomerAndAreaIds;
         return this;
      }

      public MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder monomerAndAreaList(final List<MonomerAndArea> monomerAndAreaList) {
         this.monomerAndAreaList = monomerAndAreaList;
         return this;
      }

      public MachinePartNestingTeamDTO build() {
         return new MachinePartNestingTeamDTO(
            this.project,
            this.projectCount,
            this.schedulingQuantity,
            this.needSchedulingQuantity,
            this.scheduledQuantity,
            this.scheduledWeight,
            this.schedulingWeight,
            this.yearMonthDTO,
            this.workshopTeamDTO,
            this.taskOrderId,
            this.orderNumber,
            this.taskOrderDTO,
            this.taskOrderDTOList,
            this.workshopTeamDTOList,
            this.monomerAndAreaIds,
            this.monomerAndAreaList
         );
      }

      @Override
      public String toString() {
         return "MachinePartNestingTeamDTO.MachinePartNestingTeamDTOBuilder(project="
            + this.project
            + ", projectCount="
            + this.projectCount
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", needSchedulingQuantity="
            + this.needSchedulingQuantity
            + ", scheduledQuantity="
            + this.scheduledQuantity
            + ", scheduledWeight="
            + this.scheduledWeight
            + ", schedulingWeight="
            + this.schedulingWeight
            + ", yearMonthDTO="
            + this.yearMonthDTO
            + ", workshopTeamDTO="
            + this.workshopTeamDTO
            + ", taskOrderId="
            + this.taskOrderId
            + ", orderNumber="
            + this.orderNumber
            + ", taskOrderDTO="
            + this.taskOrderDTO
            + ", taskOrderDTOList="
            + this.taskOrderDTOList
            + ", workshopTeamDTOList="
            + this.workshopTeamDTOList
            + ", monomerAndAreaIds="
            + this.monomerAndAreaIds
            + ", monomerAndAreaList="
            + this.monomerAndAreaList
            + ")";
      }
   }
}
