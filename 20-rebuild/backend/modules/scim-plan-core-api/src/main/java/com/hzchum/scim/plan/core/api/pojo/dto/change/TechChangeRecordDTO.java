package com.hzchum.scim.plan.core.api.pojo.dto.change;

import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Transient;

@ApiModel(value = "TechChangeRecord对象", description = "构件变更记录表 ")
public class TechChangeRecordDTO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty(name = "changeScopeEnum", value = "变更范围 1区域 2单体", notes = "变更范围 1当前区域 2当前单体")
   private Integer changeScopeEnum;
   @ApiModelProperty(name = "serialNumber", value = "变更编号", notes = "变更编号")
   private String serialNumber;
   @ApiModelProperty(name = "changeReasonId", value = "变更原因", notes = "变更原因")
   private NameInfo changeReason;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "user", value = "变更人", notes = "变更人")
   private NameInfo user;
   @Transient
   @ApiModelProperty(name = "changeAttachmentIds", value = "变更图纸ID字符串", notes = "变更图纸ID字符串")
   private String changeAttachmentIds;
   @ApiModelProperty(name = "changeAttachmentList", value = "变更图纸列表", notes = "变更图纸列表")
   private List<AttachmentDTO> changeAttachmentList;
   @ApiModelProperty(name = "checkStatus", value = "审核状态", notes = "审核状态")
   private Integer checkStatus;
   @ApiModelProperty(name = "checkUserId", value = "审核人ID", notes = "审核人ID")
   private Long checkUserId;
   @ApiModelProperty(name = "checkUserName", value = "审核人名称", notes = "审核人名称")
   private String checkUserName;
   @ApiModelProperty(name = "checkTime", value = "审核时间", notes = "审核时间")
   private LocalDateTime checkTime;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "type", value = "构件变更类型 1修改(二次利用) 2删除 4变更(基础信息)", notes = "构件变更类型 1修改(二次利用) 2删除  4变更(基础信息)")
   private Integer type;
   @ApiModelProperty(name = "updateArtifactList", value = "变更修改(二次利用)构件列表")
   private List<TechChangeArtifactUpdateDTO> updateArtifactList;
   @ApiModelProperty(name = "delArtifactList", value = "变更删除构件列表")
   private List<TechChangeArtifactDelDTO> delArtifactList;
   @ApiModelProperty(name = "artifactBasicUpdateDTOList", value = "变更修改(基础信息)")
   private List<TechChangeArtifactBasicUpdateDTO> artifactBasicUpdateDTOList;

   public static TechChangeRecordDTO.TechChangeRecordDTOBuilder builder() {
      return new TechChangeRecordDTO.TechChangeRecordDTOBuilder();
   }

   public TechChangeRecordDTO() {
   }

   public TechChangeRecordDTO(
      final Long id,
      final ProjectInfo project,
      final NameInfo monomer,
      final Long areaId,
      final Integer changeScopeEnum,
      final String serialNumber,
      final NameInfo changeReason,
      final String remark,
      final NameInfo user,
      final String changeAttachmentIds,
      final List<AttachmentDTO> changeAttachmentList,
      final Integer checkStatus,
      final Long checkUserId,
      final String checkUserName,
      final LocalDateTime checkTime,
      final LocalDateTime createTime,
      final Integer type,
      final List<TechChangeArtifactUpdateDTO> updateArtifactList,
      final List<TechChangeArtifactDelDTO> delArtifactList,
      final List<TechChangeArtifactBasicUpdateDTO> artifactBasicUpdateDTOList
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.areaId = areaId;
      this.changeScopeEnum = changeScopeEnum;
      this.serialNumber = serialNumber;
      this.changeReason = changeReason;
      this.remark = remark;
      this.user = user;
      this.changeAttachmentIds = changeAttachmentIds;
      this.changeAttachmentList = changeAttachmentList;
      this.checkStatus = checkStatus;
      this.checkUserId = checkUserId;
      this.checkUserName = checkUserName;
      this.checkTime = checkTime;
      this.createTime = createTime;
      this.type = type;
      this.updateArtifactList = updateArtifactList;
      this.delArtifactList = delArtifactList;
      this.artifactBasicUpdateDTOList = artifactBasicUpdateDTOList;
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

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getChangeScopeEnum() {
      return this.changeScopeEnum;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public NameInfo getChangeReason() {
      return this.changeReason;
   }

   public String getRemark() {
      return this.remark;
   }

   public NameInfo getUser() {
      return this.user;
   }

   public String getChangeAttachmentIds() {
      return this.changeAttachmentIds;
   }

   public List<AttachmentDTO> getChangeAttachmentList() {
      return this.changeAttachmentList;
   }

   public Integer getCheckStatus() {
      return this.checkStatus;
   }

   public Long getCheckUserId() {
      return this.checkUserId;
   }

   public String getCheckUserName() {
      return this.checkUserName;
   }

   public LocalDateTime getCheckTime() {
      return this.checkTime;
   }

   @Override
   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getType() {
      return this.type;
   }

   public List<TechChangeArtifactUpdateDTO> getUpdateArtifactList() {
      return this.updateArtifactList;
   }

   public List<TechChangeArtifactDelDTO> getDelArtifactList() {
      return this.delArtifactList;
   }

   public List<TechChangeArtifactBasicUpdateDTO> getArtifactBasicUpdateDTOList() {
      return this.artifactBasicUpdateDTOList;
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

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setChangeScopeEnum(final Integer changeScopeEnum) {
      this.changeScopeEnum = changeScopeEnum;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setChangeReason(final NameInfo changeReason) {
      this.changeReason = changeReason;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setUser(final NameInfo user) {
      this.user = user;
   }

   public void setChangeAttachmentIds(final String changeAttachmentIds) {
      this.changeAttachmentIds = changeAttachmentIds;
   }

   public void setChangeAttachmentList(final List<AttachmentDTO> changeAttachmentList) {
      this.changeAttachmentList = changeAttachmentList;
   }

   public void setCheckStatus(final Integer checkStatus) {
      this.checkStatus = checkStatus;
   }

   public void setCheckUserId(final Long checkUserId) {
      this.checkUserId = checkUserId;
   }

   public void setCheckUserName(final String checkUserName) {
      this.checkUserName = checkUserName;
   }

   public void setCheckTime(final LocalDateTime checkTime) {
      this.checkTime = checkTime;
   }

   @Override
   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setUpdateArtifactList(final List<TechChangeArtifactUpdateDTO> updateArtifactList) {
      this.updateArtifactList = updateArtifactList;
   }

   public void setDelArtifactList(final List<TechChangeArtifactDelDTO> delArtifactList) {
      this.delArtifactList = delArtifactList;
   }

   public void setArtifactBasicUpdateDTOList(final List<TechChangeArtifactBasicUpdateDTO> artifactBasicUpdateDTOList) {
      this.artifactBasicUpdateDTOList = artifactBasicUpdateDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeRecordDTO)) {
         return false;
      }

      TechChangeRecordDTO other = (TechChangeRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$changeScopeEnum = this.getChangeScopeEnum();
            Object other$changeScopeEnum = other.getChangeScopeEnum();
            if (this$changeScopeEnum == null ? other$changeScopeEnum == null : this$changeScopeEnum.equals(other$changeScopeEnum)) {
               Object this$checkStatus = this.getCheckStatus();
               Object other$checkStatus = other.getCheckStatus();
               if (this$checkStatus == null ? other$checkStatus == null : this$checkStatus.equals(other$checkStatus)) {
                  Object this$checkUserId = this.getCheckUserId();
                  Object other$checkUserId = other.getCheckUserId();
                  if (this$checkUserId == null ? other$checkUserId == null : this$checkUserId.equals(other$checkUserId)) {
                     Object this$type = this.getType();
                     Object other$type = other.getType();
                     if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$monomer = this.getMonomer();
                           Object other$monomer = other.getMonomer();
                           if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$changeReason = this.getChangeReason();
                                 Object other$changeReason = other.getChangeReason();
                                 if (this$changeReason == null ? other$changeReason == null : this$changeReason.equals(other$changeReason)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$user = this.getUser();
                                       Object other$user = other.getUser();
                                       if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                                          Object this$changeAttachmentIds = this.getChangeAttachmentIds();
                                          Object other$changeAttachmentIds = other.getChangeAttachmentIds();
                                          if (this$changeAttachmentIds == null
                                             ? other$changeAttachmentIds == null
                                             : this$changeAttachmentIds.equals(other$changeAttachmentIds)) {
                                             Object this$changeAttachmentList = this.getChangeAttachmentList();
                                             Object other$changeAttachmentList = other.getChangeAttachmentList();
                                             if (this$changeAttachmentList == null
                                                ? other$changeAttachmentList == null
                                                : this$changeAttachmentList.equals(other$changeAttachmentList)) {
                                                Object this$checkUserName = this.getCheckUserName();
                                                Object other$checkUserName = other.getCheckUserName();
                                                if (this$checkUserName == null ? other$checkUserName == null : this$checkUserName.equals(other$checkUserName)) {
                                                   Object this$checkTime = this.getCheckTime();
                                                   Object other$checkTime = other.getCheckTime();
                                                   if (this$checkTime == null ? other$checkTime == null : this$checkTime.equals(other$checkTime)) {
                                                      Object this$createTime = this.getCreateTime();
                                                      Object other$createTime = other.getCreateTime();
                                                      if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                         Object this$updateArtifactList = this.getUpdateArtifactList();
                                                         Object other$updateArtifactList = other.getUpdateArtifactList();
                                                         if (this$updateArtifactList == null
                                                            ? other$updateArtifactList == null
                                                            : this$updateArtifactList.equals(other$updateArtifactList)) {
                                                            Object this$delArtifactList = this.getDelArtifactList();
                                                            Object other$delArtifactList = other.getDelArtifactList();
                                                            if (this$delArtifactList == null
                                                               ? other$delArtifactList == null
                                                               : this$delArtifactList.equals(other$delArtifactList)) {
                                                               Object this$artifactBasicUpdateDTOList = this.getArtifactBasicUpdateDTOList();
                                                               Object other$artifactBasicUpdateDTOList = other.getArtifactBasicUpdateDTOList();
                                                               return this$artifactBasicUpdateDTOList == null
                                                                  ? other$artifactBasicUpdateDTOList == null
                                                                  : this$artifactBasicUpdateDTOList.equals(other$artifactBasicUpdateDTOList);
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
      return other instanceof TechChangeRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $changeScopeEnum = this.getChangeScopeEnum();
      result = result * 59 + ($changeScopeEnum == null ? 43 : $changeScopeEnum.hashCode());
      Object $checkStatus = this.getCheckStatus();
      result = result * 59 + ($checkStatus == null ? 43 : $checkStatus.hashCode());
      Object $checkUserId = this.getCheckUserId();
      result = result * 59 + ($checkUserId == null ? 43 : $checkUserId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $changeReason = this.getChangeReason();
      result = result * 59 + ($changeReason == null ? 43 : $changeReason.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $changeAttachmentIds = this.getChangeAttachmentIds();
      result = result * 59 + ($changeAttachmentIds == null ? 43 : $changeAttachmentIds.hashCode());
      Object $changeAttachmentList = this.getChangeAttachmentList();
      result = result * 59 + ($changeAttachmentList == null ? 43 : $changeAttachmentList.hashCode());
      Object $checkUserName = this.getCheckUserName();
      result = result * 59 + ($checkUserName == null ? 43 : $checkUserName.hashCode());
      Object $checkTime = this.getCheckTime();
      result = result * 59 + ($checkTime == null ? 43 : $checkTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateArtifactList = this.getUpdateArtifactList();
      result = result * 59 + ($updateArtifactList == null ? 43 : $updateArtifactList.hashCode());
      Object $delArtifactList = this.getDelArtifactList();
      result = result * 59 + ($delArtifactList == null ? 43 : $delArtifactList.hashCode());
      Object $artifactBasicUpdateDTOList = this.getArtifactBasicUpdateDTOList();
      return result * 59 + ($artifactBasicUpdateDTOList == null ? 43 : $artifactBasicUpdateDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeRecordDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", areaId="
         + this.getAreaId()
         + ", changeScopeEnum="
         + this.getChangeScopeEnum()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", changeReason="
         + this.getChangeReason()
         + ", remark="
         + this.getRemark()
         + ", user="
         + this.getUser()
         + ", changeAttachmentIds="
         + this.getChangeAttachmentIds()
         + ", changeAttachmentList="
         + this.getChangeAttachmentList()
         + ", checkStatus="
         + this.getCheckStatus()
         + ", checkUserId="
         + this.getCheckUserId()
         + ", checkUserName="
         + this.getCheckUserName()
         + ", checkTime="
         + this.getCheckTime()
         + ", createTime="
         + this.getCreateTime()
         + ", type="
         + this.getType()
         + ", updateArtifactList="
         + this.getUpdateArtifactList()
         + ", delArtifactList="
         + this.getDelArtifactList()
         + ", artifactBasicUpdateDTOList="
         + this.getArtifactBasicUpdateDTOList()
         + ")";
   }

   public static class TechChangeRecordDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private NameInfo monomer;
      private Long areaId;
      private Integer changeScopeEnum;
      private String serialNumber;
      private NameInfo changeReason;
      private String remark;
      private NameInfo user;
      private String changeAttachmentIds;
      private List<AttachmentDTO> changeAttachmentList;
      private Integer checkStatus;
      private Long checkUserId;
      private String checkUserName;
      private LocalDateTime checkTime;
      private LocalDateTime createTime;
      private Integer type;
      private List<TechChangeArtifactUpdateDTO> updateArtifactList;
      private List<TechChangeArtifactDelDTO> delArtifactList;
      private List<TechChangeArtifactBasicUpdateDTO> artifactBasicUpdateDTOList;

      TechChangeRecordDTOBuilder() {
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder changeScopeEnum(final Integer changeScopeEnum) {
         this.changeScopeEnum = changeScopeEnum;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder changeReason(final NameInfo changeReason) {
         this.changeReason = changeReason;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder user(final NameInfo user) {
         this.user = user;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder changeAttachmentIds(final String changeAttachmentIds) {
         this.changeAttachmentIds = changeAttachmentIds;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder changeAttachmentList(final List<AttachmentDTO> changeAttachmentList) {
         this.changeAttachmentList = changeAttachmentList;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder checkStatus(final Integer checkStatus) {
         this.checkStatus = checkStatus;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder checkUserId(final Long checkUserId) {
         this.checkUserId = checkUserId;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder checkUserName(final String checkUserName) {
         this.checkUserName = checkUserName;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder checkTime(final LocalDateTime checkTime) {
         this.checkTime = checkTime;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder updateArtifactList(final List<TechChangeArtifactUpdateDTO> updateArtifactList) {
         this.updateArtifactList = updateArtifactList;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder delArtifactList(final List<TechChangeArtifactDelDTO> delArtifactList) {
         this.delArtifactList = delArtifactList;
         return this;
      }

      public TechChangeRecordDTO.TechChangeRecordDTOBuilder artifactBasicUpdateDTOList(final List<TechChangeArtifactBasicUpdateDTO> artifactBasicUpdateDTOList) {
         this.artifactBasicUpdateDTOList = artifactBasicUpdateDTOList;
         return this;
      }

      public TechChangeRecordDTO build() {
         return new TechChangeRecordDTO(
            this.id,
            this.project,
            this.monomer,
            this.areaId,
            this.changeScopeEnum,
            this.serialNumber,
            this.changeReason,
            this.remark,
            this.user,
            this.changeAttachmentIds,
            this.changeAttachmentList,
            this.checkStatus,
            this.checkUserId,
            this.checkUserName,
            this.checkTime,
            this.createTime,
            this.type,
            this.updateArtifactList,
            this.delArtifactList,
            this.artifactBasicUpdateDTOList
         );
      }

      @Override
      public String toString() {
         return "TechChangeRecordDTO.TechChangeRecordDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", areaId="
            + this.areaId
            + ", changeScopeEnum="
            + this.changeScopeEnum
            + ", serialNumber="
            + this.serialNumber
            + ", changeReason="
            + this.changeReason
            + ", remark="
            + this.remark
            + ", user="
            + this.user
            + ", changeAttachmentIds="
            + this.changeAttachmentIds
            + ", changeAttachmentList="
            + this.changeAttachmentList
            + ", checkStatus="
            + this.checkStatus
            + ", checkUserId="
            + this.checkUserId
            + ", checkUserName="
            + this.checkUserName
            + ", checkTime="
            + this.checkTime
            + ", createTime="
            + this.createTime
            + ", type="
            + this.type
            + ", updateArtifactList="
            + this.updateArtifactList
            + ", delArtifactList="
            + this.delArtifactList
            + ", artifactBasicUpdateDTOList="
            + this.artifactBasicUpdateDTOList
            + ")";
      }
   }
}
