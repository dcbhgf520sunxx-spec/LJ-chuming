package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingSchedulingDOParam对象", description = "")
public class MesBuildingSchedulingDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "factoryName", notes = "工厂名")
   @JsonProperty("factoryName")
   @JSONField(name = "factoryName")
   private String factoryName;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", notes = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", notes = "生产线名")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "projectName", notes = "项目名")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", notes = "单体名")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaId", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "areaName", notes = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productName", notes = "产品名")
   @JsonProperty("productName")
   @JSONField(name = "productName")
   private String productName;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Long productType;
   @ApiModelProperty(name = "schedulingQuantity", notes = "排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "taskQuantity", notes = "已下发数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "completeTime", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "status", notes = "状态 [0 暂停, 1 正常]")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Boolean status;
   @ApiModelProperty(name = "issueStatus", notes = "状态 [0 未下发, 1 已下发]")
   @JsonProperty("issueStatus")
   @JSONField(name = "issueStatus")
   private Boolean issueStatus;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "productProcessId", notes = "总工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "plate", notes = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;

   public static MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder builder() {
      return new MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder();
   }

   public MesBuildingSchedulingDTO() {
   }

   public MesBuildingSchedulingDTO(
      final Long id,
      final Long factoryId,
      final String factoryName,
      final Long workshopId,
      final String workshopName,
      final Long productionLineId,
      final String productionLineName,
      final Long projectId,
      final String projectName,
      final Long monomerId,
      final String monomerName,
      final Long areaId,
      final String areaName,
      final Long productId,
      final String productName,
      final String serialNumber,
      final String specification,
      final Long productType,
      final Integer schedulingQuantity,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime,
      final Boolean status,
      final Boolean issueStatus,
      final Long userId,
      final Long productProcessId,
      final String name,
      final String plate
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.factoryName = factoryName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.projectId = projectId;
      this.projectName = projectName;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.productId = productId;
      this.productName = productName;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.productType = productType;
      this.schedulingQuantity = schedulingQuantity;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.status = status;
      this.issueStatus = issueStatus;
      this.userId = userId;
      this.productProcessId = productProcessId;
      this.name = name;
      this.plate = plate;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Long getProductType() {
      return this.productType;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Boolean getIssueStatus() {
      return this.issueStatus;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public String getName() {
      return this.name;
   }

   public String getPlate() {
      return this.plate;
   }

   @JsonProperty("id")
   public MesBuildingSchedulingDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingSchedulingDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("factoryName")
   public MesBuildingSchedulingDTO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingSchedulingDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("workshopName")
   public MesBuildingSchedulingDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingSchedulingDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productionLineName")
   public MesBuildingSchedulingDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingSchedulingDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("projectName")
   public MesBuildingSchedulingDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingSchedulingDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("monomerName")
   public MesBuildingSchedulingDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingSchedulingDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaName")
   public MesBuildingSchedulingDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingSchedulingDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productName")
   public MesBuildingSchedulingDTO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingSchedulingDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingSchedulingDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingSchedulingDTO setProductType(final Long productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public MesBuildingSchedulingDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingSchedulingDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingSchedulingDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingSchedulingDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingSchedulingDTO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingSchedulingDTO setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("issueStatus")
   public MesBuildingSchedulingDTO setIssueStatus(final Boolean issueStatus) {
      this.issueStatus = issueStatus;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingSchedulingDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesBuildingSchedulingDTO setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingSchedulingDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("plate")
   public MesBuildingSchedulingDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSchedulingDTO(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", factoryName="
         + this.getFactoryName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", productId="
         + this.getProductId()
         + ", productName="
         + this.getProductName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", productType="
         + this.getProductType()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", status="
         + this.getStatus()
         + ", issueStatus="
         + this.getIssueStatus()
         + ", userId="
         + this.getUserId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", name="
         + this.getName()
         + ", plate="
         + this.getPlate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSchedulingDTO)) {
         return false;
      }

      MesBuildingSchedulingDTO other = (MesBuildingSchedulingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$monomerId = this.getMonomerId();
                     Object other$monomerId = other.getMonomerId();
                     if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                        Object this$areaId = this.getAreaId();
                        Object other$areaId = other.getAreaId();
                        if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                           Object this$productId = this.getProductId();
                           Object other$productId = other.getProductId();
                           if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                              Object this$productType = this.getProductType();
                              Object other$productType = other.getProductType();
                              if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                 Object this$schedulingQuantity = this.getSchedulingQuantity();
                                 Object other$schedulingQuantity = other.getSchedulingQuantity();
                                 if (this$schedulingQuantity == null
                                    ? other$schedulingQuantity == null
                                    : this$schedulingQuantity.equals(other$schedulingQuantity)) {
                                    Object this$taskQuantity = this.getTaskQuantity();
                                    Object other$taskQuantity = other.getTaskQuantity();
                                    if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                                       Object this$completeQuantity = this.getCompleteQuantity();
                                       Object other$completeQuantity = other.getCompleteQuantity();
                                       if (this$completeQuantity == null
                                          ? other$completeQuantity == null
                                          : this$completeQuantity.equals(other$completeQuantity)) {
                                          Object this$status = this.getStatus();
                                          Object other$status = other.getStatus();
                                          if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                             Object this$issueStatus = this.getIssueStatus();
                                             Object other$issueStatus = other.getIssueStatus();
                                             if (this$issueStatus == null ? other$issueStatus == null : this$issueStatus.equals(other$issueStatus)) {
                                                Object this$userId = this.getUserId();
                                                Object other$userId = other.getUserId();
                                                if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                   Object this$productProcessId = this.getProductProcessId();
                                                   Object other$productProcessId = other.getProductProcessId();
                                                   if (this$productProcessId == null
                                                      ? other$productProcessId == null
                                                      : this$productProcessId.equals(other$productProcessId)) {
                                                      Object this$factoryName = this.getFactoryName();
                                                      Object other$factoryName = other.getFactoryName();
                                                      if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                                                         Object this$workshopName = this.getWorkshopName();
                                                         Object other$workshopName = other.getWorkshopName();
                                                         if (this$workshopName == null
                                                            ? other$workshopName == null
                                                            : this$workshopName.equals(other$workshopName)) {
                                                            Object this$productionLineName = this.getProductionLineName();
                                                            Object other$productionLineName = other.getProductionLineName();
                                                            if (this$productionLineName == null
                                                               ? other$productionLineName == null
                                                               : this$productionLineName.equals(other$productionLineName)) {
                                                               Object this$projectName = this.getProjectName();
                                                               Object other$projectName = other.getProjectName();
                                                               if (this$projectName == null
                                                                  ? other$projectName == null
                                                                  : this$projectName.equals(other$projectName)) {
                                                                  Object this$monomerName = this.getMonomerName();
                                                                  Object other$monomerName = other.getMonomerName();
                                                                  if (this$monomerName == null
                                                                     ? other$monomerName == null
                                                                     : this$monomerName.equals(other$monomerName)) {
                                                                     Object this$areaName = this.getAreaName();
                                                                     Object other$areaName = other.getAreaName();
                                                                     if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                                                        Object this$productName = this.getProductName();
                                                                        Object other$productName = other.getProductName();
                                                                        if (this$productName == null
                                                                           ? other$productName == null
                                                                           : this$productName.equals(other$productName)) {
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
                                                                                 Object this$askCompleteTime = this.getAskCompleteTime();
                                                                                 Object other$askCompleteTime = other.getAskCompleteTime();
                                                                                 if (this$askCompleteTime == null
                                                                                    ? other$askCompleteTime == null
                                                                                    : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                                    Object this$completeTime = this.getCompleteTime();
                                                                                    Object other$completeTime = other.getCompleteTime();
                                                                                    if (this$completeTime == null
                                                                                       ? other$completeTime == null
                                                                                       : this$completeTime.equals(other$completeTime)) {
                                                                                       Object this$name = this.getName();
                                                                                       Object other$name = other.getName();
                                                                                       if (this$name == null
                                                                                          ? other$name == null
                                                                                          : this$name.equals(other$name)) {
                                                                                          Object this$plate = this.getPlate();
                                                                                          Object other$plate = other.getPlate();
                                                                                          return this$plate == null
                                                                                             ? other$plate == null
                                                                                             : this$plate.equals(other$plate);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingSchedulingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $issueStatus = this.getIssueStatus();
      result = result * 59 + ($issueStatus == null ? 43 : $issueStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $plate = this.getPlate();
      return result * 59 + ($plate == null ? 43 : $plate.hashCode());
   }

   public static class MesBuildingSchedulingDTOBuilder {
      private Long id;
      private Long factoryId;
      private String factoryName;
      private Long workshopId;
      private String workshopName;
      private Long productionLineId;
      private String productionLineName;
      private Long projectId;
      private String projectName;
      private Long monomerId;
      private String monomerName;
      private Long areaId;
      private String areaName;
      private Long productId;
      private String productName;
      private String serialNumber;
      private String specification;
      private Long productType;
      private Integer schedulingQuantity;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;
      private Boolean status;
      private Boolean issueStatus;
      private Long userId;
      private Long productProcessId;
      private String name;
      private String plate;

      MesBuildingSchedulingDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("factoryName")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("workshopName")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineName")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("projectName")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("monomerName")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaName")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productName")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder productType(final Long productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("issueStatus")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder issueStatus(final Boolean issueStatus) {
         this.issueStatus = issueStatus;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("plate")
      public MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public MesBuildingSchedulingDTO build() {
         return new MesBuildingSchedulingDTO(
            this.id,
            this.factoryId,
            this.factoryName,
            this.workshopId,
            this.workshopName,
            this.productionLineId,
            this.productionLineName,
            this.projectId,
            this.projectName,
            this.monomerId,
            this.monomerName,
            this.areaId,
            this.areaName,
            this.productId,
            this.productName,
            this.serialNumber,
            this.specification,
            this.productType,
            this.schedulingQuantity,
            this.taskQuantity,
            this.completeQuantity,
            this.askCompleteTime,
            this.completeTime,
            this.status,
            this.issueStatus,
            this.userId,
            this.productProcessId,
            this.name,
            this.plate
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSchedulingDTO.MesBuildingSchedulingDTOBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", factoryName="
            + this.factoryName
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", productId="
            + this.productId
            + ", productName="
            + this.productName
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", productType="
            + this.productType
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ", status="
            + this.status
            + ", issueStatus="
            + this.issueStatus
            + ", userId="
            + this.userId
            + ", productProcessId="
            + this.productProcessId
            + ", name="
            + this.name
            + ", plate="
            + this.plate
            + ")";
      }
   }
}
