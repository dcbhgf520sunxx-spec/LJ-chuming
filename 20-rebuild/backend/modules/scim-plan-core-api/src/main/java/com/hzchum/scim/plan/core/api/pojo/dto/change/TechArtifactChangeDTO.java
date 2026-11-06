package com.hzchum.scim.plan.core.api.pojo.dto.change;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "TechArtifactChange对象", description = "构件变更表 ")
public class TechArtifactChangeDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "artifactId", value = "构件id", notes = "构件id")
   private Long artifactId;
   @ApiModelProperty(name = "oldQuantity", value = "原数量", notes = "原数量")
   private Integer oldQuantity;
   @ApiModelProperty(name = "newQuantity", value = "变更后数量", notes = "变更后数量")
   private Integer newQuantity;
   @ApiModelProperty(name = "material", value = "原材质")
   private String material;
   @ApiModelProperty(name = "length", value = "长度")
   private String length;
   @ApiModelProperty(name = "newMaterial", value = "新材质")
   private String newMaterial;
   @ApiModelProperty(name = "newLength", value = "新长度")
   private String newLength;
   @ApiModelProperty(name = "oldNetWeight", value = "原单净重（kg）")
   private BigDecimal oldNetWeight;
   @ApiModelProperty(name = "newNetWeight", value = "变更单净重（kg）")
   private BigDecimal newNetWeight;
   @ApiModelProperty(name = "oldGrossWeight", value = "原单毛重（kg）")
   private BigDecimal oldGrossWeight;
   @ApiModelProperty(name = "newGrossWeight", value = "变更单毛重（kg）")
   private BigDecimal newGrossWeight;
   @ApiModelProperty(name = "newGrossWeight", value = "原总重（kg）")
   private BigDecimal totalOldNetWeight;
   @ApiModelProperty(name = "newGrossWeight", value = "变更总重（kg）")
   private BigDecimal totalNewNetWeight;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "newName", value = "新名称")
   private String newName;
   @ApiModelProperty(name = "newSerialNumber", value = "新编号")
   private String newSerialNumber;
   @ApiModelProperty(name = "newSpecification", value = "新规格")
   private String newSpecification;
   @ApiModelProperty(name = "userId", value = "变更提交人id", notes = "变更提交人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "变更提交人", notes = "变更提交人")
   private String userName;
   @ApiModelProperty(name = "handleStatusEnum", value = "处理状态 1未处理 2处理通过 4驳回 HandleStatusEnum", notes = "处理状态 1未处理 2处理通过 4驳回")
   private Integer handleStatusEnum;
   @ApiModelProperty(name = "handleUserId", value = "处理人id", notes = "处理人id")
   private Long handleUserId;
   @ApiModelProperty(name = "handleUserName", value = "处理人", notes = "处理人")
   private String handleUserName;
   @ApiModelProperty(name = "handleTime", value = "处理时间", notes = "处理时间")
   private LocalDateTime handleTime;
   @ApiModelProperty(name = "reasonId", value = "变更原因id", notes = "变更原因id")
   private Long reasonId;
   @ApiModelProperty(name = "reasonName", value = "变更原因", notes = "变更原因")
   private String reasonName;
   @ApiModelProperty(name = "change_remark", value = "备注", notes = "备注")
   private String changeRemark;
   @ApiModelProperty(name = "attachmentIds", value = "附件id字符串", notes = "附件id字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "createTime", value = "变更时间", notes = "变更时间")
   private LocalDateTime createTime;

   public static TechArtifactChangeDTO.TechArtifactChangeDTOBuilder builder() {
      return new TechArtifactChangeDTO.TechArtifactChangeDTOBuilder();
   }

   public TechArtifactChangeDTO() {
   }

   public TechArtifactChangeDTO(
      final Long id,
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final Long artifactId,
      final Integer oldQuantity,
      final Integer newQuantity,
      final String material,
      final String length,
      final String newMaterial,
      final String newLength,
      final BigDecimal oldNetWeight,
      final BigDecimal newNetWeight,
      final BigDecimal oldGrossWeight,
      final BigDecimal newGrossWeight,
      final BigDecimal totalOldNetWeight,
      final BigDecimal totalNewNetWeight,
      final String name,
      final String serialNumber,
      final String specification,
      final String newName,
      final String newSerialNumber,
      final String newSpecification,
      final Long userId,
      final String userName,
      final Integer handleStatusEnum,
      final Long handleUserId,
      final String handleUserName,
      final LocalDateTime handleTime,
      final Long reasonId,
      final String reasonName,
      final String changeRemark,
      final String attachmentIds,
      final LocalDateTime createTime
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.artifactId = artifactId;
      this.oldQuantity = oldQuantity;
      this.newQuantity = newQuantity;
      this.material = material;
      this.length = length;
      this.newMaterial = newMaterial;
      this.newLength = newLength;
      this.oldNetWeight = oldNetWeight;
      this.newNetWeight = newNetWeight;
      this.oldGrossWeight = oldGrossWeight;
      this.newGrossWeight = newGrossWeight;
      this.totalOldNetWeight = totalOldNetWeight;
      this.totalNewNetWeight = totalNewNetWeight;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.newName = newName;
      this.newSerialNumber = newSerialNumber;
      this.newSpecification = newSpecification;
      this.userId = userId;
      this.userName = userName;
      this.handleStatusEnum = handleStatusEnum;
      this.handleUserId = handleUserId;
      this.handleUserName = handleUserName;
      this.handleTime = handleTime;
      this.reasonId = reasonId;
      this.reasonName = reasonName;
      this.changeRemark = changeRemark;
      this.attachmentIds = attachmentIds;
      this.createTime = createTime;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Integer getOldQuantity() {
      return this.oldQuantity;
   }

   public Integer getNewQuantity() {
      return this.newQuantity;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getLength() {
      return this.length;
   }

   public String getNewMaterial() {
      return this.newMaterial;
   }

   public String getNewLength() {
      return this.newLength;
   }

   public BigDecimal getOldNetWeight() {
      return this.oldNetWeight;
   }

   public BigDecimal getNewNetWeight() {
      return this.newNetWeight;
   }

   public BigDecimal getOldGrossWeight() {
      return this.oldGrossWeight;
   }

   public BigDecimal getNewGrossWeight() {
      return this.newGrossWeight;
   }

   public BigDecimal getTotalOldNetWeight() {
      return this.totalOldNetWeight;
   }

   public BigDecimal getTotalNewNetWeight() {
      return this.totalNewNetWeight;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getNewName() {
      return this.newName;
   }

   public String getNewSerialNumber() {
      return this.newSerialNumber;
   }

   public String getNewSpecification() {
      return this.newSpecification;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getHandleStatusEnum() {
      return this.handleStatusEnum;
   }

   public Long getHandleUserId() {
      return this.handleUserId;
   }

   public String getHandleUserName() {
      return this.handleUserName;
   }

   public LocalDateTime getHandleTime() {
      return this.handleTime;
   }

   public Long getReasonId() {
      return this.reasonId;
   }

   public String getReasonName() {
      return this.reasonName;
   }

   public String getChangeRemark() {
      return this.changeRemark;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setOldQuantity(final Integer oldQuantity) {
      this.oldQuantity = oldQuantity;
   }

   public void setNewQuantity(final Integer newQuantity) {
      this.newQuantity = newQuantity;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setLength(final String length) {
      this.length = length;
   }

   public void setNewMaterial(final String newMaterial) {
      this.newMaterial = newMaterial;
   }

   public void setNewLength(final String newLength) {
      this.newLength = newLength;
   }

   public void setOldNetWeight(final BigDecimal oldNetWeight) {
      this.oldNetWeight = oldNetWeight;
   }

   public void setNewNetWeight(final BigDecimal newNetWeight) {
      this.newNetWeight = newNetWeight;
   }

   public void setOldGrossWeight(final BigDecimal oldGrossWeight) {
      this.oldGrossWeight = oldGrossWeight;
   }

   public void setNewGrossWeight(final BigDecimal newGrossWeight) {
      this.newGrossWeight = newGrossWeight;
   }

   public void setTotalOldNetWeight(final BigDecimal totalOldNetWeight) {
      this.totalOldNetWeight = totalOldNetWeight;
   }

   public void setTotalNewNetWeight(final BigDecimal totalNewNetWeight) {
      this.totalNewNetWeight = totalNewNetWeight;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setNewName(final String newName) {
      this.newName = newName;
   }

   public void setNewSerialNumber(final String newSerialNumber) {
      this.newSerialNumber = newSerialNumber;
   }

   public void setNewSpecification(final String newSpecification) {
      this.newSpecification = newSpecification;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setHandleStatusEnum(final Integer handleStatusEnum) {
      this.handleStatusEnum = handleStatusEnum;
   }

   public void setHandleUserId(final Long handleUserId) {
      this.handleUserId = handleUserId;
   }

   public void setHandleUserName(final String handleUserName) {
      this.handleUserName = handleUserName;
   }

   public void setHandleTime(final LocalDateTime handleTime) {
      this.handleTime = handleTime;
   }

   public void setReasonId(final Long reasonId) {
      this.reasonId = reasonId;
   }

   public void setReasonName(final String reasonName) {
      this.reasonName = reasonName;
   }

   public void setChangeRemark(final String changeRemark) {
      this.changeRemark = changeRemark;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactChangeDTO)) {
         return false;
      }

      TechArtifactChangeDTO other = (TechArtifactChangeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactId = this.getArtifactId();
         Object other$artifactId = other.getArtifactId();
         if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
            Object this$oldQuantity = this.getOldQuantity();
            Object other$oldQuantity = other.getOldQuantity();
            if (this$oldQuantity == null ? other$oldQuantity == null : this$oldQuantity.equals(other$oldQuantity)) {
               Object this$newQuantity = this.getNewQuantity();
               Object other$newQuantity = other.getNewQuantity();
               if (this$newQuantity == null ? other$newQuantity == null : this$newQuantity.equals(other$newQuantity)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$handleStatusEnum = this.getHandleStatusEnum();
                     Object other$handleStatusEnum = other.getHandleStatusEnum();
                     if (this$handleStatusEnum == null ? other$handleStatusEnum == null : this$handleStatusEnum.equals(other$handleStatusEnum)) {
                        Object this$handleUserId = this.getHandleUserId();
                        Object other$handleUserId = other.getHandleUserId();
                        if (this$handleUserId == null ? other$handleUserId == null : this$handleUserId.equals(other$handleUserId)) {
                           Object this$reasonId = this.getReasonId();
                           Object other$reasonId = other.getReasonId();
                           if (this$reasonId == null ? other$reasonId == null : this$reasonId.equals(other$reasonId)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                 Object this$monomer = this.getMonomer();
                                 Object other$monomer = other.getMonomer();
                                 if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                    Object this$area = this.getArea();
                                    Object other$area = other.getArea();
                                    if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                       Object this$material = this.getMaterial();
                                       Object other$material = other.getMaterial();
                                       if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$newMaterial = this.getNewMaterial();
                                             Object other$newMaterial = other.getNewMaterial();
                                             if (this$newMaterial == null ? other$newMaterial == null : this$newMaterial.equals(other$newMaterial)) {
                                                Object this$newLength = this.getNewLength();
                                                Object other$newLength = other.getNewLength();
                                                if (this$newLength == null ? other$newLength == null : this$newLength.equals(other$newLength)) {
                                                   Object this$oldNetWeight = this.getOldNetWeight();
                                                   Object other$oldNetWeight = other.getOldNetWeight();
                                                   if (this$oldNetWeight == null ? other$oldNetWeight == null : this$oldNetWeight.equals(other$oldNetWeight)) {
                                                      Object this$newNetWeight = this.getNewNetWeight();
                                                      Object other$newNetWeight = other.getNewNetWeight();
                                                      if (this$newNetWeight == null ? other$newNetWeight == null : this$newNetWeight.equals(other$newNetWeight)
                                                         )
                                                       {
                                                         Object this$oldGrossWeight = this.getOldGrossWeight();
                                                         Object other$oldGrossWeight = other.getOldGrossWeight();
                                                         if (this$oldGrossWeight == null
                                                            ? other$oldGrossWeight == null
                                                            : this$oldGrossWeight.equals(other$oldGrossWeight)) {
                                                            Object this$newGrossWeight = this.getNewGrossWeight();
                                                            Object other$newGrossWeight = other.getNewGrossWeight();
                                                            if (this$newGrossWeight == null
                                                               ? other$newGrossWeight == null
                                                               : this$newGrossWeight.equals(other$newGrossWeight)) {
                                                               Object this$totalOldNetWeight = this.getTotalOldNetWeight();
                                                               Object other$totalOldNetWeight = other.getTotalOldNetWeight();
                                                               if (this$totalOldNetWeight == null
                                                                  ? other$totalOldNetWeight == null
                                                                  : this$totalOldNetWeight.equals(other$totalOldNetWeight)) {
                                                                  Object this$totalNewNetWeight = this.getTotalNewNetWeight();
                                                                  Object other$totalNewNetWeight = other.getTotalNewNetWeight();
                                                                  if (this$totalNewNetWeight == null
                                                                     ? other$totalNewNetWeight == null
                                                                     : this$totalNewNetWeight.equals(other$totalNewNetWeight)) {
                                                                     Object this$name = this.getName();
                                                                     Object other$name = other.getName();
                                                                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
                                                                              Object this$newName = this.getNewName();
                                                                              Object other$newName = other.getNewName();
                                                                              if (this$newName == null
                                                                                 ? other$newName == null
                                                                                 : this$newName.equals(other$newName)) {
                                                                                 Object this$newSerialNumber = this.getNewSerialNumber();
                                                                                 Object other$newSerialNumber = other.getNewSerialNumber();
                                                                                 if (this$newSerialNumber == null
                                                                                    ? other$newSerialNumber == null
                                                                                    : this$newSerialNumber.equals(other$newSerialNumber)) {
                                                                                    Object this$newSpecification = this.getNewSpecification();
                                                                                    Object other$newSpecification = other.getNewSpecification();
                                                                                    if (this$newSpecification == null
                                                                                       ? other$newSpecification == null
                                                                                       : this$newSpecification.equals(other$newSpecification)) {
                                                                                       Object this$userName = this.getUserName();
                                                                                       Object other$userName = other.getUserName();
                                                                                       if (this$userName == null
                                                                                          ? other$userName == null
                                                                                          : this$userName.equals(other$userName)) {
                                                                                          Object this$handleUserName = this.getHandleUserName();
                                                                                          Object other$handleUserName = other.getHandleUserName();
                                                                                          if (this$handleUserName == null
                                                                                             ? other$handleUserName == null
                                                                                             : this$handleUserName.equals(other$handleUserName)) {
                                                                                             Object this$handleTime = this.getHandleTime();
                                                                                             Object other$handleTime = other.getHandleTime();
                                                                                             if (this$handleTime == null
                                                                                                ? other$handleTime == null
                                                                                                : this$handleTime.equals(other$handleTime)) {
                                                                                                Object this$reasonName = this.getReasonName();
                                                                                                Object other$reasonName = other.getReasonName();
                                                                                                if (this$reasonName == null
                                                                                                   ? other$reasonName == null
                                                                                                   : this$reasonName.equals(other$reasonName)) {
                                                                                                   Object this$changeRemark = this.getChangeRemark();
                                                                                                   Object other$changeRemark = other.getChangeRemark();
                                                                                                   if (this$changeRemark == null
                                                                                                      ? other$changeRemark == null
                                                                                                      : this$changeRemark.equals(other$changeRemark)) {
                                                                                                      Object this$attachmentIds = this.getAttachmentIds();
                                                                                                      Object other$attachmentIds = other.getAttachmentIds();
                                                                                                      if (this$attachmentIds == null
                                                                                                         ? other$attachmentIds == null
                                                                                                         : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                                         Object this$createTime = this.getCreateTime();
                                                                                                         Object other$createTime = other.getCreateTime();
                                                                                                         return this$createTime == null
                                                                                                            ? other$createTime == null
                                                                                                            : this$createTime.equals(other$createTime);
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
      return other instanceof TechArtifactChangeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $oldQuantity = this.getOldQuantity();
      result = result * 59 + ($oldQuantity == null ? 43 : $oldQuantity.hashCode());
      Object $newQuantity = this.getNewQuantity();
      result = result * 59 + ($newQuantity == null ? 43 : $newQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $handleStatusEnum = this.getHandleStatusEnum();
      result = result * 59 + ($handleStatusEnum == null ? 43 : $handleStatusEnum.hashCode());
      Object $handleUserId = this.getHandleUserId();
      result = result * 59 + ($handleUserId == null ? 43 : $handleUserId.hashCode());
      Object $reasonId = this.getReasonId();
      result = result * 59 + ($reasonId == null ? 43 : $reasonId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $newMaterial = this.getNewMaterial();
      result = result * 59 + ($newMaterial == null ? 43 : $newMaterial.hashCode());
      Object $newLength = this.getNewLength();
      result = result * 59 + ($newLength == null ? 43 : $newLength.hashCode());
      Object $oldNetWeight = this.getOldNetWeight();
      result = result * 59 + ($oldNetWeight == null ? 43 : $oldNetWeight.hashCode());
      Object $newNetWeight = this.getNewNetWeight();
      result = result * 59 + ($newNetWeight == null ? 43 : $newNetWeight.hashCode());
      Object $oldGrossWeight = this.getOldGrossWeight();
      result = result * 59 + ($oldGrossWeight == null ? 43 : $oldGrossWeight.hashCode());
      Object $newGrossWeight = this.getNewGrossWeight();
      result = result * 59 + ($newGrossWeight == null ? 43 : $newGrossWeight.hashCode());
      Object $totalOldNetWeight = this.getTotalOldNetWeight();
      result = result * 59 + ($totalOldNetWeight == null ? 43 : $totalOldNetWeight.hashCode());
      Object $totalNewNetWeight = this.getTotalNewNetWeight();
      result = result * 59 + ($totalNewNetWeight == null ? 43 : $totalNewNetWeight.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $newName = this.getNewName();
      result = result * 59 + ($newName == null ? 43 : $newName.hashCode());
      Object $newSerialNumber = this.getNewSerialNumber();
      result = result * 59 + ($newSerialNumber == null ? 43 : $newSerialNumber.hashCode());
      Object $newSpecification = this.getNewSpecification();
      result = result * 59 + ($newSpecification == null ? 43 : $newSpecification.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $handleUserName = this.getHandleUserName();
      result = result * 59 + ($handleUserName == null ? 43 : $handleUserName.hashCode());
      Object $handleTime = this.getHandleTime();
      result = result * 59 + ($handleTime == null ? 43 : $handleTime.hashCode());
      Object $reasonName = this.getReasonName();
      result = result * 59 + ($reasonName == null ? 43 : $reasonName.hashCode());
      Object $changeRemark = this.getChangeRemark();
      result = result * 59 + ($changeRemark == null ? 43 : $changeRemark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactChangeDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", artifactId="
         + this.getArtifactId()
         + ", oldQuantity="
         + this.getOldQuantity()
         + ", newQuantity="
         + this.getNewQuantity()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", newMaterial="
         + this.getNewMaterial()
         + ", newLength="
         + this.getNewLength()
         + ", oldNetWeight="
         + this.getOldNetWeight()
         + ", newNetWeight="
         + this.getNewNetWeight()
         + ", oldGrossWeight="
         + this.getOldGrossWeight()
         + ", newGrossWeight="
         + this.getNewGrossWeight()
         + ", totalOldNetWeight="
         + this.getTotalOldNetWeight()
         + ", totalNewNetWeight="
         + this.getTotalNewNetWeight()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", newName="
         + this.getNewName()
         + ", newSerialNumber="
         + this.getNewSerialNumber()
         + ", newSpecification="
         + this.getNewSpecification()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", handleStatusEnum="
         + this.getHandleStatusEnum()
         + ", handleUserId="
         + this.getHandleUserId()
         + ", handleUserName="
         + this.getHandleUserName()
         + ", handleTime="
         + this.getHandleTime()
         + ", reasonId="
         + this.getReasonId()
         + ", reasonName="
         + this.getReasonName()
         + ", changeRemark="
         + this.getChangeRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public static class TechArtifactChangeDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private Long artifactId;
      private Integer oldQuantity;
      private Integer newQuantity;
      private String material;
      private String length;
      private String newMaterial;
      private String newLength;
      private BigDecimal oldNetWeight;
      private BigDecimal newNetWeight;
      private BigDecimal oldGrossWeight;
      private BigDecimal newGrossWeight;
      private BigDecimal totalOldNetWeight;
      private BigDecimal totalNewNetWeight;
      private String name;
      private String serialNumber;
      private String specification;
      private String newName;
      private String newSerialNumber;
      private String newSpecification;
      private Long userId;
      private String userName;
      private Integer handleStatusEnum;
      private Long handleUserId;
      private String handleUserName;
      private LocalDateTime handleTime;
      private Long reasonId;
      private String reasonName;
      private String changeRemark;
      private String attachmentIds;
      private LocalDateTime createTime;

      TechArtifactChangeDTOBuilder() {
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder oldQuantity(final Integer oldQuantity) {
         this.oldQuantity = oldQuantity;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder newQuantity(final Integer newQuantity) {
         this.newQuantity = newQuantity;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder length(final String length) {
         this.length = length;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder newMaterial(final String newMaterial) {
         this.newMaterial = newMaterial;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder newLength(final String newLength) {
         this.newLength = newLength;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder oldNetWeight(final BigDecimal oldNetWeight) {
         this.oldNetWeight = oldNetWeight;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder newNetWeight(final BigDecimal newNetWeight) {
         this.newNetWeight = newNetWeight;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder oldGrossWeight(final BigDecimal oldGrossWeight) {
         this.oldGrossWeight = oldGrossWeight;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder newGrossWeight(final BigDecimal newGrossWeight) {
         this.newGrossWeight = newGrossWeight;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder totalOldNetWeight(final BigDecimal totalOldNetWeight) {
         this.totalOldNetWeight = totalOldNetWeight;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder totalNewNetWeight(final BigDecimal totalNewNetWeight) {
         this.totalNewNetWeight = totalNewNetWeight;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder newName(final String newName) {
         this.newName = newName;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder newSerialNumber(final String newSerialNumber) {
         this.newSerialNumber = newSerialNumber;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder newSpecification(final String newSpecification) {
         this.newSpecification = newSpecification;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder handleStatusEnum(final Integer handleStatusEnum) {
         this.handleStatusEnum = handleStatusEnum;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder handleUserId(final Long handleUserId) {
         this.handleUserId = handleUserId;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder handleUserName(final String handleUserName) {
         this.handleUserName = handleUserName;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder handleTime(final LocalDateTime handleTime) {
         this.handleTime = handleTime;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder reasonId(final Long reasonId) {
         this.reasonId = reasonId;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder reasonName(final String reasonName) {
         this.reasonName = reasonName;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder changeRemark(final String changeRemark) {
         this.changeRemark = changeRemark;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public TechArtifactChangeDTO.TechArtifactChangeDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TechArtifactChangeDTO build() {
         return new TechArtifactChangeDTO(
            this.id,
            this.project,
            this.monomer,
            this.area,
            this.artifactId,
            this.oldQuantity,
            this.newQuantity,
            this.material,
            this.length,
            this.newMaterial,
            this.newLength,
            this.oldNetWeight,
            this.newNetWeight,
            this.oldGrossWeight,
            this.newGrossWeight,
            this.totalOldNetWeight,
            this.totalNewNetWeight,
            this.name,
            this.serialNumber,
            this.specification,
            this.newName,
            this.newSerialNumber,
            this.newSpecification,
            this.userId,
            this.userName,
            this.handleStatusEnum,
            this.handleUserId,
            this.handleUserName,
            this.handleTime,
            this.reasonId,
            this.reasonName,
            this.changeRemark,
            this.attachmentIds,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "TechArtifactChangeDTO.TechArtifactChangeDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", artifactId="
            + this.artifactId
            + ", oldQuantity="
            + this.oldQuantity
            + ", newQuantity="
            + this.newQuantity
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", newMaterial="
            + this.newMaterial
            + ", newLength="
            + this.newLength
            + ", oldNetWeight="
            + this.oldNetWeight
            + ", newNetWeight="
            + this.newNetWeight
            + ", oldGrossWeight="
            + this.oldGrossWeight
            + ", newGrossWeight="
            + this.newGrossWeight
            + ", totalOldNetWeight="
            + this.totalOldNetWeight
            + ", totalNewNetWeight="
            + this.totalNewNetWeight
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", newName="
            + this.newName
            + ", newSerialNumber="
            + this.newSerialNumber
            + ", newSpecification="
            + this.newSpecification
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", handleStatusEnum="
            + this.handleStatusEnum
            + ", handleUserId="
            + this.handleUserId
            + ", handleUserName="
            + this.handleUserName
            + ", handleTime="
            + this.handleTime
            + ", reasonId="
            + this.reasonId
            + ", reasonName="
            + this.reasonName
            + ", changeRemark="
            + this.changeRemark
            + ", attachmentIds="
            + this.attachmentIds
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
