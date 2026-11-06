package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.ProjectDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingArtifactTaskOrderDO", description = "结构工单 ")
public class MesBuildingArtifactTaskOrderDO {
   @ApiModelProperty(name = "orderId", notes = "任务工单id", value = "任务工单id")
   @JsonProperty("orderId")
   @JSONField(name = "orderId")
   private Long orderId;
   @ApiModelProperty(name = "scheduleOrder", notes = "任务工单号", value = "任务工单号")
   @JsonProperty("scheduleOrder")
   @JSONField(name = "scheduleOrder")
   private String scheduleOrder;
   @ApiModelProperty(name = "productionLine", notes = "生产线", value = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "workshop", notes = "车间", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "group", notes = "生产组", value = "生产组")
   @JsonProperty("group")
   @JSONField(name = "group")
   private NameInfo group;
   @ApiModelProperty(name = "project", notes = "项目", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDTO project;
   @ApiModelProperty(name = "scheduleTime", notes = "排产日期", value = "排产日期")
   @JsonProperty("scheduleTime")
   @JSONField(name = "scheduleTime")
   private LocalDateTime scheduleTime;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成时间")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private String askCompleteTime;
   @ApiModelProperty(name = "userName", notes = "排产人", value = "排产人")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "productType", notes = "产品类型", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数", value = "任务数")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务量(净重)", value = "任务量(净重)")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务量(毛重)", value = "任务量(毛重)")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(name = "printQuantity", notes = "打印数量", value = "打印数量")
   @JsonProperty("printQuantity")
   @JSONField(name = "printQuantity")
   private Integer printQuantity;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;

   public static MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder builder() {
      return new MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder();
   }

   public MesBuildingArtifactTaskOrderDO() {
   }

   public MesBuildingArtifactTaskOrderDO(
      final Long orderId,
      final String scheduleOrder,
      final ProductionLineDetailDO productionLine,
      final WorkshopDetailDO workshop,
      final NameInfo group,
      final ProjectDetailDTO project,
      final LocalDateTime scheduleTime,
      final String askCompleteTime,
      final String userName,
      final Integer productType,
      final Integer taskQuantity,
      final BigDecimal taskNetWeight,
      final BigDecimal taskGrossWeight,
      final Integer printQuantity,
      final MonomerDetailDO monomer,
      final AreaDetailDO area
   ) {
      this.orderId = orderId;
      this.scheduleOrder = scheduleOrder;
      this.productionLine = productionLine;
      this.workshop = workshop;
      this.group = group;
      this.project = project;
      this.scheduleTime = scheduleTime;
      this.askCompleteTime = askCompleteTime;
      this.userName = userName;
      this.productType = productType;
      this.taskQuantity = taskQuantity;
      this.taskNetWeight = taskNetWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.printQuantity = printQuantity;
      this.monomer = monomer;
      this.area = area;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public String getScheduleOrder() {
      return this.scheduleOrder;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public NameInfo getGroup() {
      return this.group;
   }

   public ProjectDetailDTO getProject() {
      return this.project;
   }

   public LocalDateTime getScheduleTime() {
      return this.scheduleTime;
   }

   public String getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   @JsonProperty("orderId")
   public MesBuildingArtifactTaskOrderDO setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   @JsonProperty("scheduleOrder")
   public MesBuildingArtifactTaskOrderDO setScheduleOrder(final String scheduleOrder) {
      this.scheduleOrder = scheduleOrder;
      return this;
   }

   @JsonProperty("productionLine")
   public MesBuildingArtifactTaskOrderDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("workshop")
   public MesBuildingArtifactTaskOrderDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("group")
   public MesBuildingArtifactTaskOrderDO setGroup(final NameInfo group) {
      this.group = group;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingArtifactTaskOrderDO setProject(final ProjectDetailDTO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("scheduleTime")
   public MesBuildingArtifactTaskOrderDO setScheduleTime(final LocalDateTime scheduleTime) {
      this.scheduleTime = scheduleTime;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingArtifactTaskOrderDO setAskCompleteTime(final String askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingArtifactTaskOrderDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingArtifactTaskOrderDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingArtifactTaskOrderDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public MesBuildingArtifactTaskOrderDO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public MesBuildingArtifactTaskOrderDO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesBuildingArtifactTaskOrderDO setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @JsonProperty("monomer")
   public MesBuildingArtifactTaskOrderDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public MesBuildingArtifactTaskOrderDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactTaskOrderDO(orderId="
         + this.getOrderId()
         + ", scheduleOrder="
         + this.getScheduleOrder()
         + ", productionLine="
         + this.getProductionLine()
         + ", workshop="
         + this.getWorkshop()
         + ", group="
         + this.getGroup()
         + ", project="
         + this.getProject()
         + ", scheduleTime="
         + this.getScheduleTime()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", userName="
         + this.getUserName()
         + ", productType="
         + this.getProductType()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactTaskOrderDO)) {
         return false;
      }

      MesBuildingArtifactTaskOrderDO other = (MesBuildingArtifactTaskOrderDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderId = this.getOrderId();
      Object other$orderId = other.getOrderId();
      if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$taskQuantity = this.getTaskQuantity();
            Object other$taskQuantity = other.getTaskQuantity();
            if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
               Object this$printQuantity = this.getPrintQuantity();
               Object other$printQuantity = other.getPrintQuantity();
               if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                  Object this$scheduleOrder = this.getScheduleOrder();
                  Object other$scheduleOrder = other.getScheduleOrder();
                  if (this$scheduleOrder == null ? other$scheduleOrder == null : this$scheduleOrder.equals(other$scheduleOrder)) {
                     Object this$productionLine = this.getProductionLine();
                     Object other$productionLine = other.getProductionLine();
                     if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                        Object this$workshop = this.getWorkshop();
                        Object other$workshop = other.getWorkshop();
                        if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                           Object this$group = this.getGroup();
                           Object other$group = other.getGroup();
                           if (this$group == null ? other$group == null : this$group.equals(other$group)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                 Object this$scheduleTime = this.getScheduleTime();
                                 Object other$scheduleTime = other.getScheduleTime();
                                 if (this$scheduleTime == null ? other$scheduleTime == null : this$scheduleTime.equals(other$scheduleTime)) {
                                    Object this$askCompleteTime = this.getAskCompleteTime();
                                    Object other$askCompleteTime = other.getAskCompleteTime();
                                    if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                                       Object this$userName = this.getUserName();
                                       Object other$userName = other.getUserName();
                                       if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                          Object this$taskNetWeight = this.getTaskNetWeight();
                                          Object other$taskNetWeight = other.getTaskNetWeight();
                                          if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                                             Object this$taskGrossWeight = this.getTaskGrossWeight();
                                             Object other$taskGrossWeight = other.getTaskGrossWeight();
                                             if (this$taskGrossWeight == null
                                                ? other$taskGrossWeight == null
                                                : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                                                Object this$monomer = this.getMonomer();
                                                Object other$monomer = other.getMonomer();
                                                if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                   Object this$area = this.getArea();
                                                   Object other$area = other.getArea();
                                                   return this$area == null ? other$area == null : this$area.equals(other$area);
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
      return other instanceof MesBuildingArtifactTaskOrderDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $scheduleOrder = this.getScheduleOrder();
      result = result * 59 + ($scheduleOrder == null ? 43 : $scheduleOrder.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $group = this.getGroup();
      result = result * 59 + ($group == null ? 43 : $group.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $scheduleTime = this.getScheduleTime();
      result = result * 59 + ($scheduleTime == null ? 43 : $scheduleTime.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      return result * 59 + ($area == null ? 43 : $area.hashCode());
   }

   public static class MesBuildingArtifactTaskOrderDOBuilder {
      private Long orderId;
      private String scheduleOrder;
      private ProductionLineDetailDO productionLine;
      private WorkshopDetailDO workshop;
      private NameInfo group;
      private ProjectDetailDTO project;
      private LocalDateTime scheduleTime;
      private String askCompleteTime;
      private String userName;
      private Integer productType;
      private Integer taskQuantity;
      private BigDecimal taskNetWeight;
      private BigDecimal taskGrossWeight;
      private Integer printQuantity;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;

      MesBuildingArtifactTaskOrderDOBuilder() {
      }

      @JsonProperty("orderId")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      @JsonProperty("scheduleOrder")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder scheduleOrder(final String scheduleOrder) {
         this.scheduleOrder = scheduleOrder;
         return this;
      }

      @JsonProperty("productionLine")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("workshop")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("group")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder group(final NameInfo group) {
         this.group = group;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder project(final ProjectDetailDTO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("scheduleTime")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder scheduleTime(final LocalDateTime scheduleTime) {
         this.scheduleTime = scheduleTime;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder askCompleteTime(final String askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("printQuantity")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      @JsonProperty("monomer")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      public MesBuildingArtifactTaskOrderDO build() {
         return new MesBuildingArtifactTaskOrderDO(
            this.orderId,
            this.scheduleOrder,
            this.productionLine,
            this.workshop,
            this.group,
            this.project,
            this.scheduleTime,
            this.askCompleteTime,
            this.userName,
            this.productType,
            this.taskQuantity,
            this.taskNetWeight,
            this.taskGrossWeight,
            this.printQuantity,
            this.monomer,
            this.area
         );
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactTaskOrderDO.MesBuildingArtifactTaskOrderDOBuilder(orderId="
            + this.orderId
            + ", scheduleOrder="
            + this.scheduleOrder
            + ", productionLine="
            + this.productionLine
            + ", workshop="
            + this.workshop
            + ", group="
            + this.group
            + ", project="
            + this.project
            + ", scheduleTime="
            + this.scheduleTime
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", userName="
            + this.userName
            + ", productType="
            + this.productType
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", printQuantity="
            + this.printQuantity
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ")";
      }
   }
}
