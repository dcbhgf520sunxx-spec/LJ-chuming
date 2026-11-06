package com.hzchum.scim.mes.building.core.api.pojo._dto.abnormal;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingAbnormalDTO", description = "")
public class MesBuildingAbnormalDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "areaDetail", value = "区域")
   @JsonProperty("areaDetail")
   @JSONField(name = "areaDetail")
   private AreaDetailDO areaDetail;
   @ApiModelProperty(name = "productId", value = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "oldQuantity", value = "原清单数量")
   @JsonProperty("oldQuantity")
   @JSONField(name = "oldQuantity")
   private Integer oldQuantity;
   @ApiModelProperty(name = "taskQuantity", value = "任务下发数")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "newQuantity", value = "变更后数量")
   @JsonProperty("newQuantity")
   @JSONField(name = "newQuantity")
   private Integer newQuantity;
   @ApiModelProperty(name = "changeType", value = "变更原因")
   @JsonProperty("changeType")
   @JSONField(name = "changeType")
   private String changeType;
   @ApiModelProperty(name = "changeTypeLabel", value = "变更原因")
   @JsonProperty("changeTypeLabel")
   @JSONField(name = "changeTypeLabel")
   private String changeTypeLabel;
   @ApiModelProperty(name = "userId", value = "变更人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "变更人名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "status", value = "状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "totalTaskQuantity", value = "总任务数")
   @JsonProperty("totalTaskQuantity")
   @JSONField(name = "totalTaskQuantity")
   private Integer totalTaskQuantity;
   @ApiModelProperty(name = "totalInProductionQuantity", value = "总进入生产数")
   @JsonProperty("totalInProductionQuantity")
   @JSONField(name = "totalInProductionQuantity")
   private Integer totalInProductionQuantity;
   @ApiModelProperty(name = "usedQuantity", value = "使用量")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   private Integer usedQuantity;
   @ApiModelProperty(name = "producedQuantity", value = "已生产数")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "type", value = "类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "artifactSerialNumber", value = "构件编号")
   @JsonProperty("artifactSerialNumber")
   @JSONField(name = "artifactSerialNumber")
   private String artifactSerialNumber;
   @ApiModelProperty(name = "assembleSerialNumber", value = "组立编号")
   @JsonProperty("assembleSerialNumber")
   @JSONField(name = "assembleSerialNumber")
   private String assembleSerialNumber;

   public static MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder builder() {
      return new MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder();
   }

   public MesBuildingAbnormalDTO() {
   }

   public MesBuildingAbnormalDTO(
      final Long id,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO areaDetail,
      final Long productId,
      final Integer productType,
      final Integer oldQuantity,
      final Integer taskQuantity,
      final Integer newQuantity,
      final String changeType,
      final String changeTypeLabel,
      final Long userId,
      final String userName,
      final LocalDateTime createTime,
      final Integer status,
      final String serialNumber,
      final Integer totalTaskQuantity,
      final Integer totalInProductionQuantity,
      final Integer usedQuantity,
      final Integer producedQuantity,
      final Integer type,
      final String artifactSerialNumber,
      final String assembleSerialNumber
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.areaDetail = areaDetail;
      this.productId = productId;
      this.productType = productType;
      this.oldQuantity = oldQuantity;
      this.taskQuantity = taskQuantity;
      this.newQuantity = newQuantity;
      this.changeType = changeType;
      this.changeTypeLabel = changeTypeLabel;
      this.userId = userId;
      this.userName = userName;
      this.createTime = createTime;
      this.status = status;
      this.serialNumber = serialNumber;
      this.totalTaskQuantity = totalTaskQuantity;
      this.totalInProductionQuantity = totalInProductionQuantity;
      this.usedQuantity = usedQuantity;
      this.producedQuantity = producedQuantity;
      this.type = type;
      this.artifactSerialNumber = artifactSerialNumber;
      this.assembleSerialNumber = assembleSerialNumber;
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

   public AreaDetailDO getAreaDetail() {
      return this.areaDetail;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getOldQuantity() {
      return this.oldQuantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getNewQuantity() {
      return this.newQuantity;
   }

   public String getChangeType() {
      return this.changeType;
   }

   public String getChangeTypeLabel() {
      return this.changeTypeLabel;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public Integer getTotalInProductionQuantity() {
      return this.totalInProductionQuantity;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getType() {
      return this.type;
   }

   public String getArtifactSerialNumber() {
      return this.artifactSerialNumber;
   }

   public String getAssembleSerialNumber() {
      return this.assembleSerialNumber;
   }

   @JsonProperty("id")
   public MesBuildingAbnormalDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingAbnormalDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public MesBuildingAbnormalDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("areaDetail")
   public MesBuildingAbnormalDTO setAreaDetail(final AreaDetailDO areaDetail) {
      this.areaDetail = areaDetail;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingAbnormalDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingAbnormalDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("oldQuantity")
   public MesBuildingAbnormalDTO setOldQuantity(final Integer oldQuantity) {
      this.oldQuantity = oldQuantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingAbnormalDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("newQuantity")
   public MesBuildingAbnormalDTO setNewQuantity(final Integer newQuantity) {
      this.newQuantity = newQuantity;
      return this;
   }

   @JsonProperty("changeType")
   public MesBuildingAbnormalDTO setChangeType(final String changeType) {
      this.changeType = changeType;
      return this;
   }

   @JsonProperty("changeTypeLabel")
   public MesBuildingAbnormalDTO setChangeTypeLabel(final String changeTypeLabel) {
      this.changeTypeLabel = changeTypeLabel;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingAbnormalDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingAbnormalDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("createTime")
   public MesBuildingAbnormalDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingAbnormalDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingAbnormalDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("totalTaskQuantity")
   public MesBuildingAbnormalDTO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   @JsonProperty("totalInProductionQuantity")
   public MesBuildingAbnormalDTO setTotalInProductionQuantity(final Integer totalInProductionQuantity) {
      this.totalInProductionQuantity = totalInProductionQuantity;
      return this;
   }

   @JsonProperty("usedQuantity")
   public MesBuildingAbnormalDTO setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public MesBuildingAbnormalDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingAbnormalDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("artifactSerialNumber")
   public MesBuildingAbnormalDTO setArtifactSerialNumber(final String artifactSerialNumber) {
      this.artifactSerialNumber = artifactSerialNumber;
      return this;
   }

   @JsonProperty("assembleSerialNumber")
   public MesBuildingAbnormalDTO setAssembleSerialNumber(final String assembleSerialNumber) {
      this.assembleSerialNumber = assembleSerialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAbnormalDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", areaDetail="
         + this.getAreaDetail()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", oldQuantity="
         + this.getOldQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", newQuantity="
         + this.getNewQuantity()
         + ", changeType="
         + this.getChangeType()
         + ", changeTypeLabel="
         + this.getChangeTypeLabel()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", status="
         + this.getStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", totalInProductionQuantity="
         + this.getTotalInProductionQuantity()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", type="
         + this.getType()
         + ", artifactSerialNumber="
         + this.getArtifactSerialNumber()
         + ", assembleSerialNumber="
         + this.getAssembleSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAbnormalDTO)) {
         return false;
      }

      MesBuildingAbnormalDTO other = (MesBuildingAbnormalDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$oldQuantity = this.getOldQuantity();
               Object other$oldQuantity = other.getOldQuantity();
               if (this$oldQuantity == null ? other$oldQuantity == null : this$oldQuantity.equals(other$oldQuantity)) {
                  Object this$taskQuantity = this.getTaskQuantity();
                  Object other$taskQuantity = other.getTaskQuantity();
                  if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                     Object this$newQuantity = this.getNewQuantity();
                     Object other$newQuantity = other.getNewQuantity();
                     if (this$newQuantity == null ? other$newQuantity == null : this$newQuantity.equals(other$newQuantity)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$status = this.getStatus();
                           Object other$status = other.getStatus();
                           if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                              Object this$totalTaskQuantity = this.getTotalTaskQuantity();
                              Object other$totalTaskQuantity = other.getTotalTaskQuantity();
                              if (this$totalTaskQuantity == null ? other$totalTaskQuantity == null : this$totalTaskQuantity.equals(other$totalTaskQuantity)) {
                                 Object this$totalInProductionQuantity = this.getTotalInProductionQuantity();
                                 Object other$totalInProductionQuantity = other.getTotalInProductionQuantity();
                                 if (this$totalInProductionQuantity == null
                                    ? other$totalInProductionQuantity == null
                                    : this$totalInProductionQuantity.equals(other$totalInProductionQuantity)) {
                                    Object this$usedQuantity = this.getUsedQuantity();
                                    Object other$usedQuantity = other.getUsedQuantity();
                                    if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                                       Object this$producedQuantity = this.getProducedQuantity();
                                       Object other$producedQuantity = other.getProducedQuantity();
                                       if (this$producedQuantity == null
                                          ? other$producedQuantity == null
                                          : this$producedQuantity.equals(other$producedQuantity)) {
                                          Object this$type = this.getType();
                                          Object other$type = other.getType();
                                          if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                             Object this$project = this.getProject();
                                             Object other$project = other.getProject();
                                             if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                Object this$monomer = this.getMonomer();
                                                Object other$monomer = other.getMonomer();
                                                if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                   Object this$areaDetail = this.getAreaDetail();
                                                   Object other$areaDetail = other.getAreaDetail();
                                                   if (this$areaDetail == null ? other$areaDetail == null : this$areaDetail.equals(other$areaDetail)) {
                                                      Object this$changeType = this.getChangeType();
                                                      Object other$changeType = other.getChangeType();
                                                      if (this$changeType == null ? other$changeType == null : this$changeType.equals(other$changeType)) {
                                                         Object this$changeTypeLabel = this.getChangeTypeLabel();
                                                         Object other$changeTypeLabel = other.getChangeTypeLabel();
                                                         if (this$changeTypeLabel == null
                                                            ? other$changeTypeLabel == null
                                                            : this$changeTypeLabel.equals(other$changeTypeLabel)) {
                                                            Object this$userName = this.getUserName();
                                                            Object other$userName = other.getUserName();
                                                            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                               Object this$createTime = this.getCreateTime();
                                                               Object other$createTime = other.getCreateTime();
                                                               if (this$createTime == null
                                                                  ? other$createTime == null
                                                                  : this$createTime.equals(other$createTime)) {
                                                                  Object this$serialNumber = this.getSerialNumber();
                                                                  Object other$serialNumber = other.getSerialNumber();
                                                                  if (this$serialNumber == null
                                                                     ? other$serialNumber == null
                                                                     : this$serialNumber.equals(other$serialNumber)) {
                                                                     Object this$artifactSerialNumber = this.getArtifactSerialNumber();
                                                                     Object other$artifactSerialNumber = other.getArtifactSerialNumber();
                                                                     if (this$artifactSerialNumber == null
                                                                        ? other$artifactSerialNumber == null
                                                                        : this$artifactSerialNumber.equals(other$artifactSerialNumber)) {
                                                                        Object this$assembleSerialNumber = this.getAssembleSerialNumber();
                                                                        Object other$assembleSerialNumber = other.getAssembleSerialNumber();
                                                                        return this$assembleSerialNumber == null
                                                                           ? other$assembleSerialNumber == null
                                                                           : this$assembleSerialNumber.equals(other$assembleSerialNumber);
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
      return other instanceof MesBuildingAbnormalDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $oldQuantity = this.getOldQuantity();
      result = result * 59 + ($oldQuantity == null ? 43 : $oldQuantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $newQuantity = this.getNewQuantity();
      result = result * 59 + ($newQuantity == null ? 43 : $newQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $totalTaskQuantity = this.getTotalTaskQuantity();
      result = result * 59 + ($totalTaskQuantity == null ? 43 : $totalTaskQuantity.hashCode());
      Object $totalInProductionQuantity = this.getTotalInProductionQuantity();
      result = result * 59 + ($totalInProductionQuantity == null ? 43 : $totalInProductionQuantity.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $areaDetail = this.getAreaDetail();
      result = result * 59 + ($areaDetail == null ? 43 : $areaDetail.hashCode());
      Object $changeType = this.getChangeType();
      result = result * 59 + ($changeType == null ? 43 : $changeType.hashCode());
      Object $changeTypeLabel = this.getChangeTypeLabel();
      result = result * 59 + ($changeTypeLabel == null ? 43 : $changeTypeLabel.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $artifactSerialNumber = this.getArtifactSerialNumber();
      result = result * 59 + ($artifactSerialNumber == null ? 43 : $artifactSerialNumber.hashCode());
      Object $assembleSerialNumber = this.getAssembleSerialNumber();
      return result * 59 + ($assembleSerialNumber == null ? 43 : $assembleSerialNumber.hashCode());
   }

   public static class MesBuildingAbnormalDTOBuilder {
      private Long id;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO areaDetail;
      private Long productId;
      private Integer productType;
      private Integer oldQuantity;
      private Integer taskQuantity;
      private Integer newQuantity;
      private String changeType;
      private String changeTypeLabel;
      private Long userId;
      private String userName;
      private LocalDateTime createTime;
      private Integer status;
      private String serialNumber;
      private Integer totalTaskQuantity;
      private Integer totalInProductionQuantity;
      private Integer usedQuantity;
      private Integer producedQuantity;
      private Integer type;
      private String artifactSerialNumber;
      private String assembleSerialNumber;

      MesBuildingAbnormalDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("areaDetail")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder areaDetail(final AreaDetailDO areaDetail) {
         this.areaDetail = areaDetail;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("oldQuantity")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder oldQuantity(final Integer oldQuantity) {
         this.oldQuantity = oldQuantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("newQuantity")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder newQuantity(final Integer newQuantity) {
         this.newQuantity = newQuantity;
         return this;
      }

      @JsonProperty("changeType")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder changeType(final String changeType) {
         this.changeType = changeType;
         return this;
      }

      @JsonProperty("changeTypeLabel")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder changeTypeLabel(final String changeTypeLabel) {
         this.changeTypeLabel = changeTypeLabel;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("createTime")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("totalTaskQuantity")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      @JsonProperty("totalInProductionQuantity")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder totalInProductionQuantity(final Integer totalInProductionQuantity) {
         this.totalInProductionQuantity = totalInProductionQuantity;
         return this;
      }

      @JsonProperty("usedQuantity")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("artifactSerialNumber")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder artifactSerialNumber(final String artifactSerialNumber) {
         this.artifactSerialNumber = artifactSerialNumber;
         return this;
      }

      @JsonProperty("assembleSerialNumber")
      public MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder assembleSerialNumber(final String assembleSerialNumber) {
         this.assembleSerialNumber = assembleSerialNumber;
         return this;
      }

      public MesBuildingAbnormalDTO build() {
         return new MesBuildingAbnormalDTO(
            this.id,
            this.project,
            this.monomer,
            this.areaDetail,
            this.productId,
            this.productType,
            this.oldQuantity,
            this.taskQuantity,
            this.newQuantity,
            this.changeType,
            this.changeTypeLabel,
            this.userId,
            this.userName,
            this.createTime,
            this.status,
            this.serialNumber,
            this.totalTaskQuantity,
            this.totalInProductionQuantity,
            this.usedQuantity,
            this.producedQuantity,
            this.type,
            this.artifactSerialNumber,
            this.assembleSerialNumber
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAbnormalDTO.MesBuildingAbnormalDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", areaDetail="
            + this.areaDetail
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", oldQuantity="
            + this.oldQuantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", newQuantity="
            + this.newQuantity
            + ", changeType="
            + this.changeType
            + ", changeTypeLabel="
            + this.changeTypeLabel
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", createTime="
            + this.createTime
            + ", status="
            + this.status
            + ", serialNumber="
            + this.serialNumber
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", totalInProductionQuantity="
            + this.totalInProductionQuantity
            + ", usedQuantity="
            + this.usedQuantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", type="
            + this.type
            + ", artifactSerialNumber="
            + this.artifactSerialNumber
            + ", assembleSerialNumber="
            + this.assembleSerialNumber
            + ")";
      }
   }
}
