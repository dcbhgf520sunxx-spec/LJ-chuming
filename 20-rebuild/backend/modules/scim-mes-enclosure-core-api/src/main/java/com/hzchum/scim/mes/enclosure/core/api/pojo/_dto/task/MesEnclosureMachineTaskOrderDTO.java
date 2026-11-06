package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureCutConfigDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureMachineTaskOrderDTO", description = "零件工单 ")
public class MesEnclosureMachineTaskOrderDTO {
   @ApiModelProperty(name = "id", notes = "切割id", value = "切割id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "scheduleTime", notes = "排产日期", value = "排产日期")
   @JsonProperty("scheduleTime")
   @JSONField(name = "scheduleTime")
   private LocalDateTime scheduleTime;
   @ApiModelProperty(name = "cutNumber", notes = "切割单号", value = "切割单号")
   @JsonProperty("cutNumber")
   @JSONField(name = "cutNumber")
   private String cutNumber;
   @ApiModelProperty(name = "orderNumber", notes = "任务单号", value = "任务单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "userName", notes = "排产人", value = "排产人")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "userId", notes = "排产人id", value = "排产人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Integer userId;
   @ApiModelProperty(name = "workshop", notes = "车间", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "产线", value = "产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "config", notes = "下料方式", value = "下料方式")
   @JsonProperty("config")
   @JSONField(name = "config")
   private MesEnclosureCutConfigDO config;
   @ApiModelProperty(name = "group", notes = "生产组", value = "生产组")
   @JsonProperty("group")
   @JSONField(name = "group")
   private GroupsCurrencyDO group;
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
   @ApiModelProperty(name = "completeTime", notes = "完成时间", value = "完成时间")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "printQuantity", notes = "打印数量", value = "打印数量")
   @JsonProperty("printQuantity")
   @JSONField(name = "printQuantity")
   private Integer printQuantity;
   @ApiModelProperty(name = "boolNestCut", notes = "是否套料", value = "是否套料")
   @JsonProperty("boolNestCut")
   @JSONField(name = "boolNestCut")
   private Integer boolNestCut;
   @ApiModelProperty(name = "bool_off_line", value = "是否线下套料", notes = "是否线下套料")
   private Boolean boolOffLine;
   private Integer offLineType;

   public static MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder builder() {
      return new MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder();
   }

   public MesEnclosureMachineTaskOrderDTO() {
   }

   public MesEnclosureMachineTaskOrderDTO(
      final Long id,
      final LocalDateTime scheduleTime,
      final String cutNumber,
      final String orderNumber,
      final String userName,
      final Integer userId,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final MesEnclosureCutConfigDO config,
      final GroupsCurrencyDO group,
      final Integer taskQuantity,
      final BigDecimal taskNetWeight,
      final BigDecimal taskGrossWeight,
      final LocalDateTime completeTime,
      final Integer printQuantity,
      final Integer boolNestCut,
      final Boolean boolOffLine,
      final Integer offLineType
   ) {
      this.id = id;
      this.scheduleTime = scheduleTime;
      this.cutNumber = cutNumber;
      this.orderNumber = orderNumber;
      this.userName = userName;
      this.userId = userId;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.config = config;
      this.group = group;
      this.taskQuantity = taskQuantity;
      this.taskNetWeight = taskNetWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.completeTime = completeTime;
      this.printQuantity = printQuantity;
      this.boolNestCut = boolNestCut;
      this.boolOffLine = boolOffLine;
      this.offLineType = offLineType;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getScheduleTime() {
      return this.scheduleTime;
   }

   public String getCutNumber() {
      return this.cutNumber;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getUserId() {
      return this.userId;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public MesEnclosureCutConfigDO getConfig() {
      return this.config;
   }

   public GroupsCurrencyDO getGroup() {
      return this.group;
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

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public Integer getBoolNestCut() {
      return this.boolNestCut;
   }

   public Boolean getBoolOffLine() {
      return this.boolOffLine;
   }

   public Integer getOffLineType() {
      return this.offLineType;
   }

   @JsonProperty("id")
   public MesEnclosureMachineTaskOrderDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("scheduleTime")
   public MesEnclosureMachineTaskOrderDTO setScheduleTime(final LocalDateTime scheduleTime) {
      this.scheduleTime = scheduleTime;
      return this;
   }

   @JsonProperty("cutNumber")
   public MesEnclosureMachineTaskOrderDTO setCutNumber(final String cutNumber) {
      this.cutNumber = cutNumber;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesEnclosureMachineTaskOrderDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("userName")
   public MesEnclosureMachineTaskOrderDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureMachineTaskOrderDTO setUserId(final Integer userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("workshop")
   public MesEnclosureMachineTaskOrderDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesEnclosureMachineTaskOrderDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("config")
   public MesEnclosureMachineTaskOrderDTO setConfig(final MesEnclosureCutConfigDO config) {
      this.config = config;
      return this;
   }

   @JsonProperty("group")
   public MesEnclosureMachineTaskOrderDTO setGroup(final GroupsCurrencyDO group) {
      this.group = group;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesEnclosureMachineTaskOrderDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public MesEnclosureMachineTaskOrderDTO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public MesEnclosureMachineTaskOrderDTO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("completeTime")
   public MesEnclosureMachineTaskOrderDTO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesEnclosureMachineTaskOrderDTO setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @JsonProperty("boolNestCut")
   public MesEnclosureMachineTaskOrderDTO setBoolNestCut(final Integer boolNestCut) {
      this.boolNestCut = boolNestCut;
      return this;
   }

   public MesEnclosureMachineTaskOrderDTO setBoolOffLine(final Boolean boolOffLine) {
      this.boolOffLine = boolOffLine;
      return this;
   }

   public MesEnclosureMachineTaskOrderDTO setOffLineType(final Integer offLineType) {
      this.offLineType = offLineType;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureMachineTaskOrderDTO(id="
         + this.getId()
         + ", scheduleTime="
         + this.getScheduleTime()
         + ", cutNumber="
         + this.getCutNumber()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", userName="
         + this.getUserName()
         + ", userId="
         + this.getUserId()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", config="
         + this.getConfig()
         + ", group="
         + this.getGroup()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", completeTime="
         + this.getCompleteTime()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", boolNestCut="
         + this.getBoolNestCut()
         + ", boolOffLine="
         + this.getBoolOffLine()
         + ", offLineType="
         + this.getOffLineType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureMachineTaskOrderDTO)) {
         return false;
      }

      MesEnclosureMachineTaskOrderDTO other = (MesEnclosureMachineTaskOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$taskQuantity = this.getTaskQuantity();
            Object other$taskQuantity = other.getTaskQuantity();
            if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
               Object this$printQuantity = this.getPrintQuantity();
               Object other$printQuantity = other.getPrintQuantity();
               if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                  Object this$boolNestCut = this.getBoolNestCut();
                  Object other$boolNestCut = other.getBoolNestCut();
                  if (this$boolNestCut == null ? other$boolNestCut == null : this$boolNestCut.equals(other$boolNestCut)) {
                     Object this$boolOffLine = this.getBoolOffLine();
                     Object other$boolOffLine = other.getBoolOffLine();
                     if (this$boolOffLine == null ? other$boolOffLine == null : this$boolOffLine.equals(other$boolOffLine)) {
                        Object this$offLineType = this.getOffLineType();
                        Object other$offLineType = other.getOffLineType();
                        if (this$offLineType == null ? other$offLineType == null : this$offLineType.equals(other$offLineType)) {
                           Object this$scheduleTime = this.getScheduleTime();
                           Object other$scheduleTime = other.getScheduleTime();
                           if (this$scheduleTime == null ? other$scheduleTime == null : this$scheduleTime.equals(other$scheduleTime)) {
                              Object this$cutNumber = this.getCutNumber();
                              Object other$cutNumber = other.getCutNumber();
                              if (this$cutNumber == null ? other$cutNumber == null : this$cutNumber.equals(other$cutNumber)) {
                                 Object this$orderNumber = this.getOrderNumber();
                                 Object other$orderNumber = other.getOrderNumber();
                                 if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                    Object this$userName = this.getUserName();
                                    Object other$userName = other.getUserName();
                                    if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                       Object this$workshop = this.getWorkshop();
                                       Object other$workshop = other.getWorkshop();
                                       if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                          Object this$productionLine = this.getProductionLine();
                                          Object other$productionLine = other.getProductionLine();
                                          if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                             Object this$config = this.getConfig();
                                             Object other$config = other.getConfig();
                                             if (this$config == null ? other$config == null : this$config.equals(other$config)) {
                                                Object this$group = this.getGroup();
                                                Object other$group = other.getGroup();
                                                if (this$group == null ? other$group == null : this$group.equals(other$group)) {
                                                   Object this$taskNetWeight = this.getTaskNetWeight();
                                                   Object other$taskNetWeight = other.getTaskNetWeight();
                                                   if (this$taskNetWeight == null
                                                      ? other$taskNetWeight == null
                                                      : this$taskNetWeight.equals(other$taskNetWeight)) {
                                                      Object this$taskGrossWeight = this.getTaskGrossWeight();
                                                      Object other$taskGrossWeight = other.getTaskGrossWeight();
                                                      if (this$taskGrossWeight == null
                                                         ? other$taskGrossWeight == null
                                                         : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                                                         Object this$completeTime = this.getCompleteTime();
                                                         Object other$completeTime = other.getCompleteTime();
                                                         return this$completeTime == null
                                                            ? other$completeTime == null
                                                            : this$completeTime.equals(other$completeTime);
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
      return other instanceof MesEnclosureMachineTaskOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $boolNestCut = this.getBoolNestCut();
      result = result * 59 + ($boolNestCut == null ? 43 : $boolNestCut.hashCode());
      Object $boolOffLine = this.getBoolOffLine();
      result = result * 59 + ($boolOffLine == null ? 43 : $boolOffLine.hashCode());
      Object $offLineType = this.getOffLineType();
      result = result * 59 + ($offLineType == null ? 43 : $offLineType.hashCode());
      Object $scheduleTime = this.getScheduleTime();
      result = result * 59 + ($scheduleTime == null ? 43 : $scheduleTime.hashCode());
      Object $cutNumber = this.getCutNumber();
      result = result * 59 + ($cutNumber == null ? 43 : $cutNumber.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $config = this.getConfig();
      result = result * 59 + ($config == null ? 43 : $config.hashCode());
      Object $group = this.getGroup();
      result = result * 59 + ($group == null ? 43 : $group.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   public static class MesEnclosureMachineTaskOrderDTOBuilder {
      private Long id;
      private LocalDateTime scheduleTime;
      private String cutNumber;
      private String orderNumber;
      private String userName;
      private Integer userId;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private MesEnclosureCutConfigDO config;
      private GroupsCurrencyDO group;
      private Integer taskQuantity;
      private BigDecimal taskNetWeight;
      private BigDecimal taskGrossWeight;
      private LocalDateTime completeTime;
      private Integer printQuantity;
      private Integer boolNestCut;
      private Boolean boolOffLine;
      private Integer offLineType;

      MesEnclosureMachineTaskOrderDTOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("scheduleTime")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder scheduleTime(final LocalDateTime scheduleTime) {
         this.scheduleTime = scheduleTime;
         return this;
      }

      @JsonProperty("cutNumber")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder cutNumber(final String cutNumber) {
         this.cutNumber = cutNumber;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("userName")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder userId(final Integer userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("workshop")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("config")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder config(final MesEnclosureCutConfigDO config) {
         this.config = config;
         return this;
      }

      @JsonProperty("group")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder group(final GroupsCurrencyDO group) {
         this.group = group;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("completeTime")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("printQuantity")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      @JsonProperty("boolNestCut")
      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder boolNestCut(final Integer boolNestCut) {
         this.boolNestCut = boolNestCut;
         return this;
      }

      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder boolOffLine(final Boolean boolOffLine) {
         this.boolOffLine = boolOffLine;
         return this;
      }

      public MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder offLineType(final Integer offLineType) {
         this.offLineType = offLineType;
         return this;
      }

      public MesEnclosureMachineTaskOrderDTO build() {
         return new MesEnclosureMachineTaskOrderDTO(
            this.id,
            this.scheduleTime,
            this.cutNumber,
            this.orderNumber,
            this.userName,
            this.userId,
            this.workshop,
            this.productionLine,
            this.config,
            this.group,
            this.taskQuantity,
            this.taskNetWeight,
            this.taskGrossWeight,
            this.completeTime,
            this.printQuantity,
            this.boolNestCut,
            this.boolOffLine,
            this.offLineType
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureMachineTaskOrderDTO.MesEnclosureMachineTaskOrderDTOBuilder(id="
            + this.id
            + ", scheduleTime="
            + this.scheduleTime
            + ", cutNumber="
            + this.cutNumber
            + ", orderNumber="
            + this.orderNumber
            + ", userName="
            + this.userName
            + ", userId="
            + this.userId
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", config="
            + this.config
            + ", group="
            + this.group
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", completeTime="
            + this.completeTime
            + ", printQuantity="
            + this.printQuantity
            + ", boolNestCut="
            + this.boolNestCut
            + ", boolOffLine="
            + this.boolOffLine
            + ", offLineType="
            + this.offLineType
            + ")";
      }
   }
}
