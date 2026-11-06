package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.ProjectDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "TaskOrderTrackingDO", description = "工单跟踪列表")
public class TaskOrderTrackingDO {
   @ApiModelProperty(name = "taskOrderId", notes = "顶级任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
   @ApiModelProperty(name = "orderNumber", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "productionLineTypeEnum", notes = "生产线类型")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDTO project;
   @ApiModelProperty(name = "workshop", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", value = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private NameInfo groups;
   @ApiModelProperty(name = "completeTime", notes = "计划完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "scheduleTime", notes = "排产时间")
   @JsonProperty("scheduleTime")
   @JSONField(name = "scheduleTime")
   private LocalDateTime scheduleTime;
   @ApiModelProperty(name = "totalQuantity", notes = "总数量")
   @JsonProperty("totalQuantity")
   @JSONField(name = "totalQuantity")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalMete", notes = "总重量")
   @JsonProperty("totalMete")
   @JSONField(name = "totalMete")
   private BigDecimal totalMete;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeMete", notes = "已完成的重量")
   @JsonProperty("completeMete")
   @JSONField(name = "completeMete")
   private BigDecimal completeMete;
   @ApiModelProperty(name = "completeGrossWeight", notes = "已完成重量(毛重)")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "completeNetWeight", notes = "已完成重量(净重)")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "unQuantity", notes = "未完成")
   @JsonProperty("unQuantity")
   @JSONField(name = "unQuantity")
   private Integer unQuantity;
   @ApiModelProperty(name = "userName", notes = "用户名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "rate", notes = "完成率")
   @JsonProperty("rate")
   @JSONField(name = "rate")
   private BigDecimal rate;

   public static TaskOrderTrackingDO.TaskOrderTrackingDOBuilder builder() {
      return new TaskOrderTrackingDO.TaskOrderTrackingDOBuilder();
   }

   public TaskOrderTrackingDO() {
   }

   public TaskOrderTrackingDO(
      final Long taskOrderId,
      final String orderNumber,
      final Integer productType,
      final Integer productionLineTypeEnum,
      final ProjectDetailDTO project,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final NameInfo groups,
      final LocalDateTime completeTime,
      final LocalDateTime scheduleTime,
      final Integer totalQuantity,
      final BigDecimal totalMete,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final Integer completeQuantity,
      final BigDecimal completeMete,
      final BigDecimal completeGrossWeight,
      final BigDecimal completeNetWeight,
      final Integer unQuantity,
      final String userName,
      final BigDecimal rate
   ) {
      this.taskOrderId = taskOrderId;
      this.orderNumber = orderNumber;
      this.productType = productType;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.project = project;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.completeTime = completeTime;
      this.scheduleTime = scheduleTime;
      this.totalQuantity = totalQuantity;
      this.totalMete = totalMete;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.completeQuantity = completeQuantity;
      this.completeMete = completeMete;
      this.completeGrossWeight = completeGrossWeight;
      this.completeNetWeight = completeNetWeight;
      this.unQuantity = unQuantity;
      this.userName = userName;
      this.rate = rate;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public ProjectDetailDTO getProject() {
      return this.project;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public NameInfo getGroups() {
      return this.groups;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public LocalDateTime getScheduleTime() {
      return this.scheduleTime;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteMete() {
      return this.completeMete;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public Integer getUnQuantity() {
      return this.unQuantity;
   }

   public String getUserName() {
      return this.userName;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   @JsonProperty("taskOrderId")
   public TaskOrderTrackingDO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("orderNumber")
   public TaskOrderTrackingDO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("productType")
   public TaskOrderTrackingDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public TaskOrderTrackingDO setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("project")
   public TaskOrderTrackingDO setProject(final ProjectDetailDTO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("workshop")
   public TaskOrderTrackingDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public TaskOrderTrackingDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public TaskOrderTrackingDO setGroups(final NameInfo groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("completeTime")
   public TaskOrderTrackingDO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("scheduleTime")
   public TaskOrderTrackingDO setScheduleTime(final LocalDateTime scheduleTime) {
      this.scheduleTime = scheduleTime;
      return this;
   }

   @JsonProperty("totalQuantity")
   public TaskOrderTrackingDO setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   @JsonProperty("totalMete")
   public TaskOrderTrackingDO setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TaskOrderTrackingDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public TaskOrderTrackingDO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TaskOrderTrackingDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeMete")
   public TaskOrderTrackingDO setCompleteMete(final BigDecimal completeMete) {
      this.completeMete = completeMete;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public TaskOrderTrackingDO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public TaskOrderTrackingDO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("unQuantity")
   public TaskOrderTrackingDO setUnQuantity(final Integer unQuantity) {
      this.unQuantity = unQuantity;
      return this;
   }

   @JsonProperty("userName")
   public TaskOrderTrackingDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("rate")
   public TaskOrderTrackingDO setRate(final BigDecimal rate) {
      this.rate = rate;
      return this;
   }

   @Override
   public String toString() {
      return "TaskOrderTrackingDO(taskOrderId="
         + this.getTaskOrderId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", productType="
         + this.getProductType()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", project="
         + this.getProject()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", completeTime="
         + this.getCompleteTime()
         + ", scheduleTime="
         + this.getScheduleTime()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalMete="
         + this.getTotalMete()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeMete="
         + this.getCompleteMete()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", unQuantity="
         + this.getUnQuantity()
         + ", userName="
         + this.getUserName()
         + ", rate="
         + this.getRate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskOrderTrackingDO)) {
         return false;
      }

      TaskOrderTrackingDO other = (TaskOrderTrackingDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskOrderId = this.getTaskOrderId();
      Object other$taskOrderId = other.getTaskOrderId();
      if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
            Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
            if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
               Object this$totalQuantity = this.getTotalQuantity();
               Object other$totalQuantity = other.getTotalQuantity();
               if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
                  Object this$completeQuantity = this.getCompleteQuantity();
                  Object other$completeQuantity = other.getCompleteQuantity();
                  if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                     Object this$unQuantity = this.getUnQuantity();
                     Object other$unQuantity = other.getUnQuantity();
                     if (this$unQuantity == null ? other$unQuantity == null : this$unQuantity.equals(other$unQuantity)) {
                        Object this$orderNumber = this.getOrderNumber();
                        Object other$orderNumber = other.getOrderNumber();
                        if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$workshop = this.getWorkshop();
                              Object other$workshop = other.getWorkshop();
                              if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                 Object this$productionLine = this.getProductionLine();
                                 Object other$productionLine = other.getProductionLine();
                                 if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                    Object this$groups = this.getGroups();
                                    Object other$groups = other.getGroups();
                                    if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                                       Object this$completeTime = this.getCompleteTime();
                                       Object other$completeTime = other.getCompleteTime();
                                       if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
                                          Object this$scheduleTime = this.getScheduleTime();
                                          Object other$scheduleTime = other.getScheduleTime();
                                          if (this$scheduleTime == null ? other$scheduleTime == null : this$scheduleTime.equals(other$scheduleTime)) {
                                             Object this$totalMete = this.getTotalMete();
                                             Object other$totalMete = other.getTotalMete();
                                             if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
                                                Object this$totalNetWeight = this.getTotalNetWeight();
                                                Object other$totalNetWeight = other.getTotalNetWeight();
                                                if (this$totalNetWeight == null
                                                   ? other$totalNetWeight == null
                                                   : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                   Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                   Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                   if (this$totalGrossWeight == null
                                                      ? other$totalGrossWeight == null
                                                      : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                      Object this$completeMete = this.getCompleteMete();
                                                      Object other$completeMete = other.getCompleteMete();
                                                      if (this$completeMete == null ? other$completeMete == null : this$completeMete.equals(other$completeMete)
                                                         )
                                                       {
                                                         Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                                         Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                                         if (this$completeGrossWeight == null
                                                            ? other$completeGrossWeight == null
                                                            : this$completeGrossWeight.equals(other$completeGrossWeight)) {
                                                            Object this$completeNetWeight = this.getCompleteNetWeight();
                                                            Object other$completeNetWeight = other.getCompleteNetWeight();
                                                            if (this$completeNetWeight == null
                                                               ? other$completeNetWeight == null
                                                               : this$completeNetWeight.equals(other$completeNetWeight)) {
                                                               Object this$userName = this.getUserName();
                                                               Object other$userName = other.getUserName();
                                                               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                                  Object this$rate = this.getRate();
                                                                  Object other$rate = other.getRate();
                                                                  return this$rate == null ? other$rate == null : this$rate.equals(other$rate);
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
      return other instanceof TaskOrderTrackingDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $unQuantity = this.getUnQuantity();
      result = result * 59 + ($unQuantity == null ? 43 : $unQuantity.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $scheduleTime = this.getScheduleTime();
      result = result * 59 + ($scheduleTime == null ? 43 : $scheduleTime.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $completeMete = this.getCompleteMete();
      result = result * 59 + ($completeMete == null ? 43 : $completeMete.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $rate = this.getRate();
      return result * 59 + ($rate == null ? 43 : $rate.hashCode());
   }

   public static class TaskOrderTrackingDOBuilder {
      private Long taskOrderId;
      private String orderNumber;
      private Integer productType;
      private Integer productionLineTypeEnum;
      private ProjectDetailDTO project;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private NameInfo groups;
      private LocalDateTime completeTime;
      private LocalDateTime scheduleTime;
      private Integer totalQuantity;
      private BigDecimal totalMete;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private Integer completeQuantity;
      private BigDecimal completeMete;
      private BigDecimal completeGrossWeight;
      private BigDecimal completeNetWeight;
      private Integer unQuantity;
      private String userName;
      private BigDecimal rate;

      TaskOrderTrackingDOBuilder() {
      }

      @JsonProperty("taskOrderId")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("orderNumber")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("productType")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("project")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder project(final ProjectDetailDTO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("workshop")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder groups(final NameInfo groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("completeTime")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("scheduleTime")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder scheduleTime(final LocalDateTime scheduleTime) {
         this.scheduleTime = scheduleTime;
         return this;
      }

      @JsonProperty("totalQuantity")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      @JsonProperty("totalMete")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeMete")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder completeMete(final BigDecimal completeMete) {
         this.completeMete = completeMete;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("unQuantity")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder unQuantity(final Integer unQuantity) {
         this.unQuantity = unQuantity;
         return this;
      }

      @JsonProperty("userName")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("rate")
      public TaskOrderTrackingDO.TaskOrderTrackingDOBuilder rate(final BigDecimal rate) {
         this.rate = rate;
         return this;
      }

      public TaskOrderTrackingDO build() {
         return new TaskOrderTrackingDO(
            this.taskOrderId,
            this.orderNumber,
            this.productType,
            this.productionLineTypeEnum,
            this.project,
            this.workshop,
            this.productionLine,
            this.groups,
            this.completeTime,
            this.scheduleTime,
            this.totalQuantity,
            this.totalMete,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.completeQuantity,
            this.completeMete,
            this.completeGrossWeight,
            this.completeNetWeight,
            this.unQuantity,
            this.userName,
            this.rate
         );
      }

      @Override
      public String toString() {
         return "TaskOrderTrackingDO.TaskOrderTrackingDOBuilder(taskOrderId="
            + this.taskOrderId
            + ", orderNumber="
            + this.orderNumber
            + ", productType="
            + this.productType
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", project="
            + this.project
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", completeTime="
            + this.completeTime
            + ", scheduleTime="
            + this.scheduleTime
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalMete="
            + this.totalMete
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeMete="
            + this.completeMete
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", unQuantity="
            + this.unQuantity
            + ", userName="
            + this.userName
            + ", rate="
            + this.rate
            + ")";
      }
   }
}
