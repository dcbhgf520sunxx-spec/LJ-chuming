package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingTaskProduceTeamReportDTOParam", description = "")
public class MesBuildingProduceTeamReportDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   private Long taskId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id", notes = "任务工序id")
   private Long taskProcessId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   private Long processId;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   private Long schedulingId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "quantity", value = "生产数量", notes = "生产数量")
   private Integer quantity;
   @ApiModelProperty(name = "inspectionQuantity", value = "质检通过数量", notes = "质检通过数量")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   private Long teamId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   private Long userId;
   @ApiModelProperty(name = "reportType", value = "上报类型 [0 正常上报, 1 异常上报]", notes = "上报类型 [0 正常上报, 1 异常上报]")
   private Integer reportType;
   @ApiModelProperty(name = "boolHandleEnum", value = "是否被处理 [0 未处理, 1 已处理]", notes = "是否被处理 [0 未处理, 1 已处理]")
   private Boolean boolHandleEnum;
   @ApiModelProperty(name = "number", value = "构件生产编号", notes = "构件生产编号")
   private Integer number;
   @ApiModelProperty(name = "prodLineId", value = "生产线id", notes = "生产线id")
   private Long prodLineId;
   @ApiModelProperty(name = "assistId", value = "协同任务id", notes = "协同任务id")
   private Long assistId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "orderNumber", value = "工单编号", notes = "工单编号")
   private String orderNumber;
   @ApiModelProperty(name = "groupsName", value = "生产组名", notes = "生产组名")
   private String prodLineName;
   @ApiModelProperty(name = "teamLeaderName", value = "班组长名", notes = "班组长名")
   private String teamLeaderName;

   public static MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder builder() {
      return new MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder();
   }

   public MesBuildingProduceTeamReportDTO(
      final Long id,
      final Long taskId,
      final Long taskProcessId,
      final Long processId,
      final Long schedulingId,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer quantity,
      final Integer inspectionQuantity,
      final Long teamId,
      final Long userId,
      final Integer reportType,
      final Boolean boolHandleEnum,
      final Integer number,
      final Long prodLineId,
      final Long assistId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String orderNumber,
      final String prodLineName,
      final String teamLeaderName
   ) {
      this.id = id;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.processId = processId;
      this.schedulingId = schedulingId;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.inspectionQuantity = inspectionQuantity;
      this.teamId = teamId;
      this.userId = userId;
      this.reportType = reportType;
      this.boolHandleEnum = boolHandleEnum;
      this.number = number;
      this.prodLineId = prodLineId;
      this.assistId = assistId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.orderNumber = orderNumber;
      this.prodLineName = prodLineName;
      this.teamLeaderName = teamLeaderName;
   }

   public MesBuildingProduceTeamReportDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public Boolean getBoolHandleEnum() {
      return this.boolHandleEnum;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getProdLineId() {
      return this.prodLineId;
   }

   public Long getAssistId() {
      return this.assistId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getProdLineName() {
      return this.prodLineName;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public MesBuildingProduceTeamReportDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setBoolHandleEnum(final Boolean boolHandleEnum) {
      this.boolHandleEnum = boolHandleEnum;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setProdLineId(final Long prodLineId) {
      this.prodLineId = prodLineId;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setAssistId(final Long assistId) {
      this.assistId = assistId;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setProdLineName(final String prodLineName) {
      this.prodLineName = prodLineName;
      return this;
   }

   public MesBuildingProduceTeamReportDTO setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProduceTeamReportDTO(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", processId="
         + this.getProcessId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", productId="
         + this.getProductId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", teamId="
         + this.getTeamId()
         + ", userId="
         + this.getUserId()
         + ", reportType="
         + this.getReportType()
         + ", boolHandleEnum="
         + this.getBoolHandleEnum()
         + ", number="
         + this.getNumber()
         + ", prodLineId="
         + this.getProdLineId()
         + ", assistId="
         + this.getAssistId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", prodLineName="
         + this.getProdLineName()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProduceTeamReportDTO)) {
         return false;
      }

      MesBuildingProduceTeamReportDTO other = (MesBuildingProduceTeamReportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$taskProcessId = this.getTaskProcessId();
            Object other$taskProcessId = other.getTaskProcessId();
            if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$schedulingId = this.getSchedulingId();
                  Object other$schedulingId = other.getSchedulingId();
                  if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$taskTypeEnum = this.getTaskTypeEnum();
                        Object other$taskTypeEnum = other.getTaskTypeEnum();
                        if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$inspectionQuantity = this.getInspectionQuantity();
                              Object other$inspectionQuantity = other.getInspectionQuantity();
                              if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)
                                 )
                               {
                                 Object this$teamId = this.getTeamId();
                                 Object other$teamId = other.getTeamId();
                                 if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$reportType = this.getReportType();
                                       Object other$reportType = other.getReportType();
                                       if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                                          Object this$boolHandleEnum = this.getBoolHandleEnum();
                                          Object other$boolHandleEnum = other.getBoolHandleEnum();
                                          if (this$boolHandleEnum == null ? other$boolHandleEnum == null : this$boolHandleEnum.equals(other$boolHandleEnum)) {
                                             Object this$number = this.getNumber();
                                             Object other$number = other.getNumber();
                                             if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                                Object this$prodLineId = this.getProdLineId();
                                                Object other$prodLineId = other.getProdLineId();
                                                if (this$prodLineId == null ? other$prodLineId == null : this$prodLineId.equals(other$prodLineId)) {
                                                   Object this$assistId = this.getAssistId();
                                                   Object other$assistId = other.getAssistId();
                                                   if (this$assistId == null ? other$assistId == null : this$assistId.equals(other$assistId)) {
                                                      Object this$projectId = this.getProjectId();
                                                      Object other$projectId = other.getProjectId();
                                                      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                                         Object this$monomerId = this.getMonomerId();
                                                         Object other$monomerId = other.getMonomerId();
                                                         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                                            Object this$areaId = this.getAreaId();
                                                            Object other$areaId = other.getAreaId();
                                                            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                                               Object this$orderNumber = this.getOrderNumber();
                                                               Object other$orderNumber = other.getOrderNumber();
                                                               if (this$orderNumber == null
                                                                  ? other$orderNumber == null
                                                                  : this$orderNumber.equals(other$orderNumber)) {
                                                                  Object this$prodLineName = this.getProdLineName();
                                                                  Object other$prodLineName = other.getProdLineName();
                                                                  if (this$prodLineName == null
                                                                     ? other$prodLineName == null
                                                                     : this$prodLineName.equals(other$prodLineName)) {
                                                                     Object this$teamLeaderName = this.getTeamLeaderName();
                                                                     Object other$teamLeaderName = other.getTeamLeaderName();
                                                                     return this$teamLeaderName == null
                                                                        ? other$teamLeaderName == null
                                                                        : this$teamLeaderName.equals(other$teamLeaderName);
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
      return other instanceof MesBuildingProduceTeamReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $boolHandleEnum = this.getBoolHandleEnum();
      result = result * 59 + ($boolHandleEnum == null ? 43 : $boolHandleEnum.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $prodLineId = this.getProdLineId();
      result = result * 59 + ($prodLineId == null ? 43 : $prodLineId.hashCode());
      Object $assistId = this.getAssistId();
      result = result * 59 + ($assistId == null ? 43 : $assistId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $prodLineName = this.getProdLineName();
      result = result * 59 + ($prodLineName == null ? 43 : $prodLineName.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      return result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
   }

   public static class MesBuildingProduceTeamReportDTOBuilder {
      private Long id;
      private Long taskId;
      private Long taskProcessId;
      private Long processId;
      private Long schedulingId;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer quantity;
      private Integer inspectionQuantity;
      private Long teamId;
      private Long userId;
      private Integer reportType;
      private Boolean boolHandleEnum;
      private Integer number;
      private Long prodLineId;
      private Long assistId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String orderNumber;
      private String prodLineName;
      private String teamLeaderName;

      MesBuildingProduceTeamReportDTOBuilder() {
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder boolHandleEnum(final Boolean boolHandleEnum) {
         this.boolHandleEnum = boolHandleEnum;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder prodLineId(final Long prodLineId) {
         this.prodLineId = prodLineId;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder assistId(final Long assistId) {
         this.assistId = assistId;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder prodLineName(final String prodLineName) {
         this.prodLineName = prodLineName;
         return this;
      }

      public MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      public MesBuildingProduceTeamReportDTO build() {
         return new MesBuildingProduceTeamReportDTO(
            this.id,
            this.taskId,
            this.taskProcessId,
            this.processId,
            this.schedulingId,
            this.productId,
            this.taskTypeEnum,
            this.quantity,
            this.inspectionQuantity,
            this.teamId,
            this.userId,
            this.reportType,
            this.boolHandleEnum,
            this.number,
            this.prodLineId,
            this.assistId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.orderNumber,
            this.prodLineName,
            this.teamLeaderName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProduceTeamReportDTO.MesBuildingProduceTeamReportDTOBuilder(id="
            + this.id
            + ", taskId="
            + this.taskId
            + ", taskProcessId="
            + this.taskProcessId
            + ", processId="
            + this.processId
            + ", schedulingId="
            + this.schedulingId
            + ", productId="
            + this.productId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", teamId="
            + this.teamId
            + ", userId="
            + this.userId
            + ", reportType="
            + this.reportType
            + ", boolHandleEnum="
            + this.boolHandleEnum
            + ", number="
            + this.number
            + ", prodLineId="
            + this.prodLineId
            + ", assistId="
            + this.assistId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", orderNumber="
            + this.orderNumber
            + ", prodLineName="
            + this.prodLineName
            + ", teamLeaderName="
            + this.teamLeaderName
            + ")";
      }
   }
}
