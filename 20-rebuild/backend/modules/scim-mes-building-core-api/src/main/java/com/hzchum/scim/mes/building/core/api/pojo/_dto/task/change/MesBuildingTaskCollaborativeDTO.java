package com.hzchum.scim.mes.building.core.api.pojo._dto.task.change;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesBuildingTaskChangeDTO", description = "协同页面获取任务列表")
public class MesBuildingTaskCollaborativeDTO {
   @ApiModelProperty(name = "taskId", value = "任务id")
   private Long taskId;
   @ApiModelProperty(name = "taskOrderId", value = "工单id")
   private Long taskOrderId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名")
   private String areaName;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名")
   private String monomerName;
   @ApiModelProperty(name = "productId", value = "产品id")
   private Long productId;
   @ApiModelProperty(name = "structureClassId", value = "产品配置id")
   private Long structureClassId;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "netWeight", value = "净重")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grocessWeight", value = "毛重")
   private BigDecimal grocessWeight;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "taskQuantity", value = "任务数")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", value = "任务完成数")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeQuantity", value = "可以协同数")
   private Integer canCollaborativeQuantity;
   @ApiModelProperty(name = "numbers", value = "可协同编号")
   private List<Integer> numbers;
   @ApiModelProperty(name = "workShopId", value = "车间id")
   private Long workShopId;
   @ApiModelProperty(name = "workShopName", value = "车间名")
   private String workShopName;
   @ApiModelProperty(name = "workShopId", value = "产线id")
   private Long lineId;
   @ApiModelProperty(name = "workShopName", value = "产线名")
   private String lineName;
   @ApiModelProperty(name = "groupId", value = "生产组id")
   private Long groupId;
   @ApiModelProperty(name = "groupName", value = "生产组名")
   private String groupName;
   @ApiModelProperty(name = "factoryId", value = "工厂id")
   private Long factoryId;
   @ApiModelProperty(name = "factoryName", value = "工厂名")
   private String factoryName;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成时间")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "boolOneCode", value = "是否一物一码")
   private Boolean boolOneCode;

   public static MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder builder() {
      return new MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder();
   }

   public MesBuildingTaskCollaborativeDTO() {
   }

   public MesBuildingTaskCollaborativeDTO(
      final Long taskId,
      final Long taskOrderId,
      final Long areaId,
      final String areaName,
      final Long monomerId,
      final String monomerName,
      final Long productId,
      final Long structureClassId,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final BigDecimal netWeight,
      final BigDecimal grocessWeight,
      final String material,
      final Integer quantity,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final Integer canCollaborativeQuantity,
      final List<Integer> numbers,
      final Long workShopId,
      final String workShopName,
      final Long lineId,
      final String lineName,
      final Long groupId,
      final String groupName,
      final Long factoryId,
      final String factoryName,
      final LocalDateTime askCompleteTime,
      final Boolean boolOneCode
   ) {
      this.taskId = taskId;
      this.taskOrderId = taskOrderId;
      this.areaId = areaId;
      this.areaName = areaName;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.productId = productId;
      this.structureClassId = structureClassId;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.netWeight = netWeight;
      this.grocessWeight = grocessWeight;
      this.material = material;
      this.quantity = quantity;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.canCollaborativeQuantity = canCollaborativeQuantity;
      this.numbers = numbers;
      this.workShopId = workShopId;
      this.workShopName = workShopName;
      this.lineId = lineId;
      this.lineName = lineName;
      this.groupId = groupId;
      this.groupName = groupName;
      this.factoryId = factoryId;
      this.factoryName = factoryName;
      this.askCompleteTime = askCompleteTime;
      this.boolOneCode = boolOneCode;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrocessWeight() {
      return this.grocessWeight;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getCanCollaborativeQuantity() {
      return this.canCollaborativeQuantity;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public String getLineName() {
      return this.lineName;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public String getGroupName() {
      return this.groupName;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public MesBuildingTaskCollaborativeDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setGrocessWeight(final BigDecimal grocessWeight) {
      this.grocessWeight = grocessWeight;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setCanCollaborativeQuantity(final Integer canCollaborativeQuantity) {
      this.canCollaborativeQuantity = canCollaborativeQuantity;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setLineId(final Long lineId) {
      this.lineId = lineId;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setLineName(final String lineName) {
      this.lineName = lineName;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setGroupId(final Long groupId) {
      this.groupId = groupId;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setGroupName(final String groupName) {
      this.groupName = groupName;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   public MesBuildingTaskCollaborativeDTO setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskCollaborativeDTO(taskId="
         + this.getTaskId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", productId="
         + this.getProductId()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", grocessWeight="
         + this.getGrocessWeight()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", canCollaborativeQuantity="
         + this.getCanCollaborativeQuantity()
         + ", numbers="
         + this.getNumbers()
         + ", workShopId="
         + this.getWorkShopId()
         + ", workShopName="
         + this.getWorkShopName()
         + ", lineId="
         + this.getLineId()
         + ", lineName="
         + this.getLineName()
         + ", groupId="
         + this.getGroupId()
         + ", groupName="
         + this.getGroupName()
         + ", factoryId="
         + this.getFactoryId()
         + ", factoryName="
         + this.getFactoryName()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskCollaborativeDTO)) {
         return false;
      }

      MesBuildingTaskCollaborativeDTO other = (MesBuildingTaskCollaborativeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskId = this.getTaskId();
      Object other$taskId = other.getTaskId();
      if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
         Object this$taskOrderId = this.getTaskOrderId();
         Object other$taskOrderId = other.getTaskOrderId();
         if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                     Object this$structureClassId = this.getStructureClassId();
                     Object other$structureClassId = other.getStructureClassId();
                     if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$taskQuantity = this.getTaskQuantity();
                           Object other$taskQuantity = other.getTaskQuantity();
                           if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                              Object this$completeQuantity = this.getCompleteQuantity();
                              Object other$completeQuantity = other.getCompleteQuantity();
                              if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                                 Object this$canCollaborativeQuantity = this.getCanCollaborativeQuantity();
                                 Object other$canCollaborativeQuantity = other.getCanCollaborativeQuantity();
                                 if (this$canCollaborativeQuantity == null
                                    ? other$canCollaborativeQuantity == null
                                    : this$canCollaborativeQuantity.equals(other$canCollaborativeQuantity)) {
                                    Object this$workShopId = this.getWorkShopId();
                                    Object other$workShopId = other.getWorkShopId();
                                    if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
                                       Object this$lineId = this.getLineId();
                                       Object other$lineId = other.getLineId();
                                       if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
                                          Object this$groupId = this.getGroupId();
                                          Object other$groupId = other.getGroupId();
                                          if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
                                             Object this$factoryId = this.getFactoryId();
                                             Object other$factoryId = other.getFactoryId();
                                             if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                                Object this$boolOneCode = this.getBoolOneCode();
                                                Object other$boolOneCode = other.getBoolOneCode();
                                                if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
                                                   Object this$areaName = this.getAreaName();
                                                   Object other$areaName = other.getAreaName();
                                                   if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                                      Object this$monomerName = this.getMonomerName();
                                                      Object other$monomerName = other.getMonomerName();
                                                      if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$specification = this.getSpecification();
                                                            Object other$specification = other.getSpecification();
                                                            if (this$specification == null
                                                               ? other$specification == null
                                                               : this$specification.equals(other$specification)) {
                                                               Object this$length = this.getLength();
                                                               Object other$length = other.getLength();
                                                               if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                  Object this$netWeight = this.getNetWeight();
                                                                  Object other$netWeight = other.getNetWeight();
                                                                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)
                                                                     )
                                                                   {
                                                                     Object this$grocessWeight = this.getGrocessWeight();
                                                                     Object other$grocessWeight = other.getGrocessWeight();
                                                                     if (this$grocessWeight == null
                                                                        ? other$grocessWeight == null
                                                                        : this$grocessWeight.equals(other$grocessWeight)) {
                                                                        Object this$material = this.getMaterial();
                                                                        Object other$material = other.getMaterial();
                                                                        if (this$material == null
                                                                           ? other$material == null
                                                                           : this$material.equals(other$material)) {
                                                                           Object this$numbers = this.getNumbers();
                                                                           Object other$numbers = other.getNumbers();
                                                                           if (this$numbers == null
                                                                              ? other$numbers == null
                                                                              : this$numbers.equals(other$numbers)) {
                                                                              Object this$workShopName = this.getWorkShopName();
                                                                              Object other$workShopName = other.getWorkShopName();
                                                                              if (this$workShopName == null
                                                                                 ? other$workShopName == null
                                                                                 : this$workShopName.equals(other$workShopName)) {
                                                                                 Object this$lineName = this.getLineName();
                                                                                 Object other$lineName = other.getLineName();
                                                                                 if (this$lineName == null
                                                                                    ? other$lineName == null
                                                                                    : this$lineName.equals(other$lineName)) {
                                                                                    Object this$groupName = this.getGroupName();
                                                                                    Object other$groupName = other.getGroupName();
                                                                                    if (this$groupName == null
                                                                                       ? other$groupName == null
                                                                                       : this$groupName.equals(other$groupName)) {
                                                                                       Object this$factoryName = this.getFactoryName();
                                                                                       Object other$factoryName = other.getFactoryName();
                                                                                       if (this$factoryName == null
                                                                                          ? other$factoryName == null
                                                                                          : this$factoryName.equals(other$factoryName)) {
                                                                                          Object this$askCompleteTime = this.getAskCompleteTime();
                                                                                          Object other$askCompleteTime = other.getAskCompleteTime();
                                                                                          return this$askCompleteTime == null
                                                                                             ? other$askCompleteTime == null
                                                                                             : this$askCompleteTime.equals(other$askCompleteTime);
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
      return other instanceof MesBuildingTaskCollaborativeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $canCollaborativeQuantity = this.getCanCollaborativeQuantity();
      result = result * 59 + ($canCollaborativeQuantity == null ? 43 : $canCollaborativeQuantity.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grocessWeight = this.getGrocessWeight();
      result = result * 59 + ($grocessWeight == null ? 43 : $grocessWeight.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $lineName = this.getLineName();
      result = result * 59 + ($lineName == null ? 43 : $lineName.hashCode());
      Object $groupName = this.getGroupName();
      result = result * 59 + ($groupName == null ? 43 : $groupName.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   public static class MesBuildingTaskCollaborativeDTOBuilder {
      private Long taskId;
      private Long taskOrderId;
      private Long areaId;
      private String areaName;
      private Long monomerId;
      private String monomerName;
      private Long productId;
      private Long structureClassId;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private BigDecimal netWeight;
      private BigDecimal grocessWeight;
      private String material;
      private Integer quantity;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private Integer canCollaborativeQuantity;
      private List<Integer> numbers;
      private Long workShopId;
      private String workShopName;
      private Long lineId;
      private String lineName;
      private Long groupId;
      private String groupName;
      private Long factoryId;
      private String factoryName;
      private LocalDateTime askCompleteTime;
      private Boolean boolOneCode;

      MesBuildingTaskCollaborativeDTOBuilder() {
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder grocessWeight(final BigDecimal grocessWeight) {
         this.grocessWeight = grocessWeight;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder canCollaborativeQuantity(final Integer canCollaborativeQuantity) {
         this.canCollaborativeQuantity = canCollaborativeQuantity;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder numbers(final List<Integer> numbers) {
         this.numbers = numbers;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder workShopName(final String workShopName) {
         this.workShopName = workShopName;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder lineName(final String lineName) {
         this.lineName = lineName;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder groupName(final String groupName) {
         this.groupName = groupName;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder boolOneCode(final Boolean boolOneCode) {
         this.boolOneCode = boolOneCode;
         return this;
      }

      public MesBuildingTaskCollaborativeDTO build() {
         return new MesBuildingTaskCollaborativeDTO(
            this.taskId,
            this.taskOrderId,
            this.areaId,
            this.areaName,
            this.monomerId,
            this.monomerName,
            this.productId,
            this.structureClassId,
            this.serialNumber,
            this.specification,
            this.length,
            this.netWeight,
            this.grocessWeight,
            this.material,
            this.quantity,
            this.taskQuantity,
            this.completeQuantity,
            this.canCollaborativeQuantity,
            this.numbers,
            this.workShopId,
            this.workShopName,
            this.lineId,
            this.lineName,
            this.groupId,
            this.groupName,
            this.factoryId,
            this.factoryName,
            this.askCompleteTime,
            this.boolOneCode
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskCollaborativeDTO.MesBuildingTaskCollaborativeDTOBuilder(taskId="
            + this.taskId
            + ", taskOrderId="
            + this.taskOrderId
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", productId="
            + this.productId
            + ", structureClassId="
            + this.structureClassId
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", netWeight="
            + this.netWeight
            + ", grocessWeight="
            + this.grocessWeight
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", canCollaborativeQuantity="
            + this.canCollaborativeQuantity
            + ", numbers="
            + this.numbers
            + ", workShopId="
            + this.workShopId
            + ", workShopName="
            + this.workShopName
            + ", lineId="
            + this.lineId
            + ", lineName="
            + this.lineName
            + ", groupId="
            + this.groupId
            + ", groupName="
            + this.groupName
            + ", factoryId="
            + this.factoryId
            + ", factoryName="
            + this.factoryName
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", boolOneCode="
            + this.boolOneCode
            + ")";
      }
   }
}
