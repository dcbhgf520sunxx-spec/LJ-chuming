package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingTaskNeedMachinePartScheduling对象", description = "")
public class MesBuildingTaskNeedMachinePartSchedulingDO extends BaseEntity<Long> {
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

   public static MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder builder() {
      return new MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder();
   }

   public MesBuildingTaskNeedMachinePartSchedulingDO() {
   }

   public MesBuildingTaskNeedMachinePartSchedulingDO(
      final Long id,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO groups,
      final Long artifactTaskId,
      final Long taskOrderId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final LocalDateTime askCompleteTime,
      final Long productId,
      final Integer needQuantity,
      final Integer schedulingQuantity,
      final Integer quantity,
      final String serialNumber,
      final Long useId
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.artifactTaskId = artifactTaskId;
      this.taskOrderId = taskOrderId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.askCompleteTime = askCompleteTime;
      this.productId = productId;
      this.needQuantity = needQuantity;
      this.schedulingQuantity = schedulingQuantity;
      this.quantity = quantity;
      this.serialNumber = serialNumber;
      this.useId = useId;
   }

   public Long getId() {
      return this.id;
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

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getUseId() {
      return this.useId;
   }

   @JsonProperty("id")
   public MesBuildingTaskNeedMachinePartSchedulingDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingTaskNeedMachinePartSchedulingDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public MesBuildingTaskNeedMachinePartSchedulingDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public MesBuildingTaskNeedMachinePartSchedulingDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("workshop")
   public MesBuildingTaskNeedMachinePartSchedulingDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesBuildingTaskNeedMachinePartSchedulingDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public MesBuildingTaskNeedMachinePartSchedulingDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("artifactTaskId")
   public MesBuildingTaskNeedMachinePartSchedulingDO setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingTaskNeedMachinePartSchedulingDO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTaskNeedMachinePartSchedulingDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTaskNeedMachinePartSchedulingDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTaskNeedMachinePartSchedulingDO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTaskNeedMachinePartSchedulingDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingTaskNeedMachinePartSchedulingDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("needQuantity")
   public MesBuildingTaskNeedMachinePartSchedulingDO setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public MesBuildingTaskNeedMachinePartSchedulingDO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingTaskNeedMachinePartSchedulingDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingTaskNeedMachinePartSchedulingDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("useId")
   public MesBuildingTaskNeedMachinePartSchedulingDO setUseId(final Long useId) {
      this.useId = useId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskNeedMachinePartSchedulingDO(id="
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

      if (!(o instanceof MesBuildingTaskNeedMachinePartSchedulingDO)) {
         return false;
      }

      MesBuildingTaskNeedMachinePartSchedulingDO other = (MesBuildingTaskNeedMachinePartSchedulingDO)o;
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
      return other instanceof MesBuildingTaskNeedMachinePartSchedulingDO;
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

   public static class MesBuildingTaskNeedMachinePartSchedulingDOBuilder {
      private Long id;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;
      private Long artifactTaskId;
      private Long taskOrderId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private LocalDateTime askCompleteTime;
      private Long productId;
      private Integer needQuantity;
      private Integer schedulingQuantity;
      private Integer quantity;
      private String serialNumber;
      private Long useId;

      MesBuildingTaskNeedMachinePartSchedulingDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("workshop")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder productionLine(
         final ProductionLineDetailDO productionLine
      ) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("artifactTaskId")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder artifactTaskId(final Long artifactTaskId) {
         this.artifactTaskId = artifactTaskId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("needQuantity")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("useId")
      public MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder useId(final Long useId) {
         this.useId = useId;
         return this;
      }

      public MesBuildingTaskNeedMachinePartSchedulingDO build() {
         return new MesBuildingTaskNeedMachinePartSchedulingDO(
            this.id,
            this.project,
            this.monomer,
            this.area,
            this.workshop,
            this.productionLine,
            this.groups,
            this.artifactTaskId,
            this.taskOrderId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.askCompleteTime,
            this.productId,
            this.needQuantity,
            this.schedulingQuantity,
            this.quantity,
            this.serialNumber,
            this.useId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskNeedMachinePartSchedulingDO.MesBuildingTaskNeedMachinePartSchedulingDOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", artifactTaskId="
            + this.artifactTaskId
            + ", taskOrderId="
            + this.taskOrderId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", productId="
            + this.productId
            + ", needQuantity="
            + this.needQuantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", quantity="
            + this.quantity
            + ", serialNumber="
            + this.serialNumber
            + ", useId="
            + this.useId
            + ")";
      }
   }
}
