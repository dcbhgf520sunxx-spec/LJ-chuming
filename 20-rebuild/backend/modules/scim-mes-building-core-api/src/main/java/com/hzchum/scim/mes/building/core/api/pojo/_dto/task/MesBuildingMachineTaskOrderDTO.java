package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingCutConfigDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingMachineTaskOrderDTO", description = "零件工单 ")
public class MesBuildingMachineTaskOrderDTO {
   @ApiModelProperty(name = "id", notes = "切割id", value = "切割id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "taskOrderId", notes = "工单id", value = "工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
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
   private Long userId;
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
   private MesBuildingCutConfigDO config;
   @ApiModelProperty(name = "cutType", notes = "切割方式", value = "切割方式")
   @JsonProperty("cutType")
   @JSONField(name = "cutType")
   private Integer cutType;
   @ApiModelProperty(name = "cutTypeName", notes = "切割方式", value = "切割方式")
   @JsonProperty("cutTypeName")
   @JSONField(name = "cutTypeName")
   private String cutTypeName;
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

   public static MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder builder() {
      return new MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder();
   }

   public MesBuildingMachineTaskOrderDTO() {
   }

   public MesBuildingMachineTaskOrderDTO(
      final Long id,
      final Long taskOrderId,
      final LocalDateTime scheduleTime,
      final String cutNumber,
      final String orderNumber,
      final String userName,
      final Long userId,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final MesBuildingCutConfigDO config,
      final Integer cutType,
      final String cutTypeName,
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
      this.taskOrderId = taskOrderId;
      this.scheduleTime = scheduleTime;
      this.cutNumber = cutNumber;
      this.orderNumber = orderNumber;
      this.userName = userName;
      this.userId = userId;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.config = config;
      this.cutType = cutType;
      this.cutTypeName = cutTypeName;
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

   public Long getTaskOrderId() {
      return this.taskOrderId;
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

   public Long getUserId() {
      return this.userId;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public MesBuildingCutConfigDO getConfig() {
      return this.config;
   }

   public Integer getCutType() {
      return this.cutType;
   }

   public String getCutTypeName() {
      return this.cutTypeName;
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
   public MesBuildingMachineTaskOrderDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingMachineTaskOrderDTO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("scheduleTime")
   public MesBuildingMachineTaskOrderDTO setScheduleTime(final LocalDateTime scheduleTime) {
      this.scheduleTime = scheduleTime;
      return this;
   }

   @JsonProperty("cutNumber")
   public MesBuildingMachineTaskOrderDTO setCutNumber(final String cutNumber) {
      this.cutNumber = cutNumber;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesBuildingMachineTaskOrderDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingMachineTaskOrderDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingMachineTaskOrderDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("workshop")
   public MesBuildingMachineTaskOrderDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesBuildingMachineTaskOrderDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("config")
   public MesBuildingMachineTaskOrderDTO setConfig(final MesBuildingCutConfigDO config) {
      this.config = config;
      return this;
   }

   @JsonProperty("cutType")
   public MesBuildingMachineTaskOrderDTO setCutType(final Integer cutType) {
      this.cutType = cutType;
      return this;
   }

   @JsonProperty("cutTypeName")
   public MesBuildingMachineTaskOrderDTO setCutTypeName(final String cutTypeName) {
      this.cutTypeName = cutTypeName;
      return this;
   }

   @JsonProperty("group")
   public MesBuildingMachineTaskOrderDTO setGroup(final GroupsCurrencyDO group) {
      this.group = group;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingMachineTaskOrderDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public MesBuildingMachineTaskOrderDTO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public MesBuildingMachineTaskOrderDTO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingMachineTaskOrderDTO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesBuildingMachineTaskOrderDTO setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @JsonProperty("boolNestCut")
   public MesBuildingMachineTaskOrderDTO setBoolNestCut(final Integer boolNestCut) {
      this.boolNestCut = boolNestCut;
      return this;
   }

   public MesBuildingMachineTaskOrderDTO setBoolOffLine(final Boolean boolOffLine) {
      this.boolOffLine = boolOffLine;
      return this;
   }

   public MesBuildingMachineTaskOrderDTO setOffLineType(final Integer offLineType) {
      this.offLineType = offLineType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachineTaskOrderDTO(id="
         + this.getId()
         + ", taskOrderId="
         + this.getTaskOrderId()
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
         + ", cutType="
         + this.getCutType()
         + ", cutTypeName="
         + this.getCutTypeName()
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

      if (!(o instanceof MesBuildingMachineTaskOrderDTO)) {
         return false;
      }

      MesBuildingMachineTaskOrderDTO other = (MesBuildingMachineTaskOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskOrderId = this.getTaskOrderId();
         Object other$taskOrderId = other.getTaskOrderId();
         if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$cutType = this.getCutType();
               Object other$cutType = other.getCutType();
               if (this$cutType == null ? other$cutType == null : this$cutType.equals(other$cutType)) {
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
                                                if (this$productionLine == null
                                                   ? other$productionLine == null
                                                   : this$productionLine.equals(other$productionLine)) {
                                                   Object this$config = this.getConfig();
                                                   Object other$config = other.getConfig();
                                                   if (this$config == null ? other$config == null : this$config.equals(other$config)) {
                                                      Object this$cutTypeName = this.getCutTypeName();
                                                      Object other$cutTypeName = other.getCutTypeName();
                                                      if (this$cutTypeName == null ? other$cutTypeName == null : this$cutTypeName.equals(other$cutTypeName)) {
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
      return other instanceof MesBuildingMachineTaskOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $cutType = this.getCutType();
      result = result * 59 + ($cutType == null ? 43 : $cutType.hashCode());
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
      Object $cutTypeName = this.getCutTypeName();
      result = result * 59 + ($cutTypeName == null ? 43 : $cutTypeName.hashCode());
      Object $group = this.getGroup();
      result = result * 59 + ($group == null ? 43 : $group.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   public static class MesBuildingMachineTaskOrderDTOBuilder {
      private Long id;
      private Long taskOrderId;
      private LocalDateTime scheduleTime;
      private String cutNumber;
      private String orderNumber;
      private String userName;
      private Long userId;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private MesBuildingCutConfigDO config;
      private Integer cutType;
      private String cutTypeName;
      private GroupsCurrencyDO group;
      private Integer taskQuantity;
      private BigDecimal taskNetWeight;
      private BigDecimal taskGrossWeight;
      private LocalDateTime completeTime;
      private Integer printQuantity;
      private Integer boolNestCut;
      private Boolean boolOffLine;
      private Integer offLineType;

      MesBuildingMachineTaskOrderDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("scheduleTime")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder scheduleTime(final LocalDateTime scheduleTime) {
         this.scheduleTime = scheduleTime;
         return this;
      }

      @JsonProperty("cutNumber")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder cutNumber(final String cutNumber) {
         this.cutNumber = cutNumber;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("workshop")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("config")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder config(final MesBuildingCutConfigDO config) {
         this.config = config;
         return this;
      }

      @JsonProperty("cutType")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder cutType(final Integer cutType) {
         this.cutType = cutType;
         return this;
      }

      @JsonProperty("cutTypeName")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder cutTypeName(final String cutTypeName) {
         this.cutTypeName = cutTypeName;
         return this;
      }

      @JsonProperty("group")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder group(final GroupsCurrencyDO group) {
         this.group = group;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("printQuantity")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      @JsonProperty("boolNestCut")
      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder boolNestCut(final Integer boolNestCut) {
         this.boolNestCut = boolNestCut;
         return this;
      }

      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder boolOffLine(final Boolean boolOffLine) {
         this.boolOffLine = boolOffLine;
         return this;
      }

      public MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder offLineType(final Integer offLineType) {
         this.offLineType = offLineType;
         return this;
      }

      public MesBuildingMachineTaskOrderDTO build() {
         return new MesBuildingMachineTaskOrderDTO(
            this.id,
            this.taskOrderId,
            this.scheduleTime,
            this.cutNumber,
            this.orderNumber,
            this.userName,
            this.userId,
            this.workshop,
            this.productionLine,
            this.config,
            this.cutType,
            this.cutTypeName,
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
         return "MesBuildingMachineTaskOrderDTO.MesBuildingMachineTaskOrderDTOBuilder(id="
            + this.id
            + ", taskOrderId="
            + this.taskOrderId
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
            + ", cutType="
            + this.cutType
            + ", cutTypeName="
            + this.cutTypeName
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
