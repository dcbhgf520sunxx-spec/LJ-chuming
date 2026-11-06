package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingTaskNeedMachinePartSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingTaskNeedMachinePartSchedulingDTO", description = "")
public class MesBuildingTaskNeedMachinePartSchedulingDTO extends MesBuildingTaskNeedMachinePartSchedulingDO {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "单体id", notes = "单体id")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", value = "区域", notes = "区域")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "artifactTaskId", value = "需要排产关联表id", notes = "需要排产关联表id")
   @JsonProperty("artifactTaskId")
   @JSONField(name = "artifactTaskId")
   private Long artifactTaskId;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "needQuantity", value = "需要排产数量", notes = "需要排产数量")
   @JsonProperty("needQuantity")
   @JSONField(name = "needQuantity")
   private Integer needQuantity;
   @ApiModelProperty(name = "schedulingQuantity", value = "已排产数量", notes = "已排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "useId", value = "用户id", notes = "用户id")
   @JsonProperty("useId")
   @JSONField(name = "useId")
   private Long useId;

   @Override
   public Long getId() {
      return this.id;
   }

   @Override
   public ProjectDetailDO getProject() {
      return this.project;
   }

   @Override
   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   @Override
   public AreaDetailDO getArea() {
      return this.area;
   }

   @Override
   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   @Override
   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   @Override
   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   @Override
   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   @Override
   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   @Override
   public Long getWorkshopId() {
      return this.workshopId;
   }

   @Override
   public Long getProductionLineId() {
      return this.productionLineId;
   }

   @Override
   public Long getGroupsId() {
      return this.groupsId;
   }

   @Override
   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   @Override
   public Long getProductId() {
      return this.productId;
   }

   @Override
   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   @Override
   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   @Override
   public Integer getQuantity() {
      return this.quantity;
   }

   @Override
   public String getSerialNumber() {
      return this.serialNumber;
   }

   @Override
   public Long getUseId() {
      return this.useId;
   }

   @JsonProperty("id")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("workshop")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("artifactTaskId")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("needQuantity")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("useId")
   public MesBuildingTaskNeedMachinePartSchedulingDTO setUseId(final Long useId) {
      this.useId = useId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskNeedMachinePartSchedulingDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", artifactTaskId="
         + this.getArtifactTaskId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", productId="
         + this.getProductId()
         + ", needQuantity="
         + this.getNeedQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", quantity="
         + this.getQuantity()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", useId="
         + this.getUseId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskNeedMachinePartSchedulingDTO)) {
         return false;
      }

      MesBuildingTaskNeedMachinePartSchedulingDTO other = (MesBuildingTaskNeedMachinePartSchedulingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactTaskId = this.getArtifactTaskId();
         Object other$artifactTaskId = other.getArtifactTaskId();
         if (this$artifactTaskId == null ? other$artifactTaskId == null : this$artifactTaskId.equals(other$artifactTaskId)) {
            Object this$taskOrderId = this.getTaskOrderId();
            Object other$taskOrderId = other.getTaskOrderId();
            if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$productionLineId = this.getProductionLineId();
                  Object other$productionLineId = other.getProductionLineId();
                  if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                     Object this$groupsId = this.getGroupsId();
                     Object other$groupsId = other.getGroupsId();
                     if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                        Object this$productId = this.getProductId();
                        Object other$productId = other.getProductId();
                        if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                           Object this$needQuantity = this.getNeedQuantity();
                           Object other$needQuantity = other.getNeedQuantity();
                           if (this$needQuantity == null ? other$needQuantity == null : this$needQuantity.equals(other$needQuantity)) {
                              Object this$schedulingQuantity = this.getSchedulingQuantity();
                              Object other$schedulingQuantity = other.getSchedulingQuantity();
                              if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)
                                 )
                               {
                                 Object this$quantity = this.getQuantity();
                                 Object other$quantity = other.getQuantity();
                                 if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                    Object this$useId = this.getUseId();
                                    Object other$useId = other.getUseId();
                                    if (this$useId == null ? other$useId == null : this$useId.equals(other$useId)) {
                                       Object this$project = this.getProject();
                                       Object other$project = other.getProject();
                                       if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                          Object this$monomer = this.getMonomer();
                                          Object other$monomer = other.getMonomer();
                                          if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                             Object this$area = this.getArea();
                                             Object other$area = other.getArea();
                                             if (this$area == null ? other$area == null : this$area.equals(other$area)) {
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
                                                         Object this$askCompleteTime = this.getAskCompleteTime();
                                                         Object other$askCompleteTime = other.getAskCompleteTime();
                                                         if (this$askCompleteTime == null
                                                            ? other$askCompleteTime == null
                                                            : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                            Object this$serialNumber = this.getSerialNumber();
                                                            Object other$serialNumber = other.getSerialNumber();
                                                            return this$serialNumber == null
                                                               ? other$serialNumber == null
                                                               : this$serialNumber.equals(other$serialNumber);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskNeedMachinePartSchedulingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactTaskId = this.getArtifactTaskId();
      result = result * 59 + ($artifactTaskId == null ? 43 : $artifactTaskId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $needQuantity = this.getNeedQuantity();
      result = result * 59 + ($needQuantity == null ? 43 : $needQuantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $useId = this.getUseId();
      result = result * 59 + ($useId == null ? 43 : $useId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }
}
