package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.util.ProjectDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureArtifactTaskOrderDO", description = "结构工单 ")
public class MesEnclosureArtifactTaskOrderDO {
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

   public static MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder builder() {
      return new MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder();
   }

   public MesEnclosureArtifactTaskOrderDO() {
   }

   public MesEnclosureArtifactTaskOrderDO(
      final Long orderId,
      final String scheduleOrder,
      final ProductionLineDetailDO productionLine,
      final WorkshopDetailDO workshop,
      final NameInfo group,
      final ProjectDetailDTO project,
      final LocalDateTime scheduleTime,
      final String userName,
      final Integer productType,
      final Integer taskQuantity,
      final BigDecimal taskNetWeight,
      final BigDecimal taskGrossWeight,
      final Integer printQuantity
   ) {
      this.orderId = orderId;
      this.scheduleOrder = scheduleOrder;
      this.productionLine = productionLine;
      this.workshop = workshop;
      this.group = group;
      this.project = project;
      this.scheduleTime = scheduleTime;
      this.userName = userName;
      this.productType = productType;
      this.taskQuantity = taskQuantity;
      this.taskNetWeight = taskNetWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.printQuantity = printQuantity;
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

   @JsonProperty("orderId")
   public MesEnclosureArtifactTaskOrderDO setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   @JsonProperty("scheduleOrder")
   public MesEnclosureArtifactTaskOrderDO setScheduleOrder(final String scheduleOrder) {
      this.scheduleOrder = scheduleOrder;
      return this;
   }

   @JsonProperty("productionLine")
   public MesEnclosureArtifactTaskOrderDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("workshop")
   public MesEnclosureArtifactTaskOrderDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("group")
   public MesEnclosureArtifactTaskOrderDO setGroup(final NameInfo group) {
      this.group = group;
      return this;
   }

   @JsonProperty("project")
   public MesEnclosureArtifactTaskOrderDO setProject(final ProjectDetailDTO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("scheduleTime")
   public MesEnclosureArtifactTaskOrderDO setScheduleTime(final LocalDateTime scheduleTime) {
      this.scheduleTime = scheduleTime;
      return this;
   }

   @JsonProperty("userName")
   public MesEnclosureArtifactTaskOrderDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureArtifactTaskOrderDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesEnclosureArtifactTaskOrderDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public MesEnclosureArtifactTaskOrderDO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public MesEnclosureArtifactTaskOrderDO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesEnclosureArtifactTaskOrderDO setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureArtifactTaskOrderDO(orderId="
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureArtifactTaskOrderDO)) {
         return false;
      }

      MesEnclosureArtifactTaskOrderDO other = (MesEnclosureArtifactTaskOrderDO)o;
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
                                    Object this$userName = this.getUserName();
                                    Object other$userName = other.getUserName();
                                    if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                       Object this$taskNetWeight = this.getTaskNetWeight();
                                       Object other$taskNetWeight = other.getTaskNetWeight();
                                       if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                                          Object this$taskGrossWeight = this.getTaskGrossWeight();
                                          Object other$taskGrossWeight = other.getTaskGrossWeight();
                                          return this$taskGrossWeight == null
                                             ? other$taskGrossWeight == null
                                             : this$taskGrossWeight.equals(other$taskGrossWeight);
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
      return other instanceof MesEnclosureArtifactTaskOrderDO;
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
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      return result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
   }

   public static class MesEnclosureArtifactTaskOrderDOBuilder {
      private Long orderId;
      private String scheduleOrder;
      private ProductionLineDetailDO productionLine;
      private WorkshopDetailDO workshop;
      private NameInfo group;
      private ProjectDetailDTO project;
      private LocalDateTime scheduleTime;
      private String userName;
      private Integer productType;
      private Integer taskQuantity;
      private BigDecimal taskNetWeight;
      private BigDecimal taskGrossWeight;
      private Integer printQuantity;

      MesEnclosureArtifactTaskOrderDOBuilder() {
      }

      @JsonProperty("orderId")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      @JsonProperty("scheduleOrder")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder scheduleOrder(final String scheduleOrder) {
         this.scheduleOrder = scheduleOrder;
         return this;
      }

      @JsonProperty("productionLine")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("workshop")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("group")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder group(final NameInfo group) {
         this.group = group;
         return this;
      }

      @JsonProperty("project")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder project(final ProjectDetailDTO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("scheduleTime")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder scheduleTime(final LocalDateTime scheduleTime) {
         this.scheduleTime = scheduleTime;
         return this;
      }

      @JsonProperty("userName")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("productType")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("printQuantity")
      public MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      public MesEnclosureArtifactTaskOrderDO build() {
         return new MesEnclosureArtifactTaskOrderDO(
            this.orderId,
            this.scheduleOrder,
            this.productionLine,
            this.workshop,
            this.group,
            this.project,
            this.scheduleTime,
            this.userName,
            this.productType,
            this.taskQuantity,
            this.taskNetWeight,
            this.taskGrossWeight,
            this.printQuantity
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureArtifactTaskOrderDO.MesEnclosureArtifactTaskOrderDOBuilder(orderId="
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
            + ")";
      }
   }
}
