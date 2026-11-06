package com.hzchum.scim.plan.core.api.biz.check;

import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechEnclosureChangeRecordDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "TechChangeRecord对象", description = "构件变更记录表 ")
public class TechEnclosureChangeRecordDTO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty(name = "serialNumber", value = "变更编号", notes = "变更编号")
   private String serialNumber;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "user", value = "变更人", notes = "变更人")
   private NameInfo user;
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
   @ApiModelProperty(name = "changeRecordDetail", value = "详情变更", notes = "详情变更")
   private TechEnclosureChangeRecordDetailDTO changeRecordDetail;

   public static TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder builder() {
      return new TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder();
   }

   public TechEnclosureChangeRecordDTO() {
   }

   public TechEnclosureChangeRecordDTO(
      final Long id,
      final ProjectInfo project,
      final NameInfo monomer,
      final Long areaId,
      final String serialNumber,
      final String remark,
      final NameInfo user,
      final Integer checkStatus,
      final Long checkUserId,
      final String checkUserName,
      final LocalDateTime checkTime,
      final LocalDateTime createTime,
      final TechEnclosureChangeRecordDetailDTO changeRecordDetail
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.areaId = areaId;
      this.serialNumber = serialNumber;
      this.remark = remark;
      this.user = user;
      this.checkStatus = checkStatus;
      this.checkUserId = checkUserId;
      this.checkUserName = checkUserName;
      this.checkTime = checkTime;
      this.createTime = createTime;
      this.changeRecordDetail = changeRecordDetail;
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public NameInfo getUser() {
      return this.user;
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

   public TechEnclosureChangeRecordDetailDTO getChangeRecordDetail() {
      return this.changeRecordDetail;
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

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setUser(final NameInfo user) {
      this.user = user;
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

   public void setChangeRecordDetail(final TechEnclosureChangeRecordDetailDTO changeRecordDetail) {
      this.changeRecordDetail = changeRecordDetail;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechEnclosureChangeRecordDTO)) {
         return false;
      }

      TechEnclosureChangeRecordDTO other = (TechEnclosureChangeRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$checkStatus = this.getCheckStatus();
            Object other$checkStatus = other.getCheckStatus();
            if (this$checkStatus == null ? other$checkStatus == null : this$checkStatus.equals(other$checkStatus)) {
               Object this$checkUserId = this.getCheckUserId();
               Object other$checkUserId = other.getCheckUserId();
               if (this$checkUserId == null ? other$checkUserId == null : this$checkUserId.equals(other$checkUserId)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$monomer = this.getMonomer();
                     Object other$monomer = other.getMonomer();
                     if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$user = this.getUser();
                              Object other$user = other.getUser();
                              if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                                 Object this$checkUserName = this.getCheckUserName();
                                 Object other$checkUserName = other.getCheckUserName();
                                 if (this$checkUserName == null ? other$checkUserName == null : this$checkUserName.equals(other$checkUserName)) {
                                    Object this$checkTime = this.getCheckTime();
                                    Object other$checkTime = other.getCheckTime();
                                    if (this$checkTime == null ? other$checkTime == null : this$checkTime.equals(other$checkTime)) {
                                       Object this$createTime = this.getCreateTime();
                                       Object other$createTime = other.getCreateTime();
                                       if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                          Object this$changeRecordDetail = this.getChangeRecordDetail();
                                          Object other$changeRecordDetail = other.getChangeRecordDetail();
                                          return this$changeRecordDetail == null
                                             ? other$changeRecordDetail == null
                                             : this$changeRecordDetail.equals(other$changeRecordDetail);
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
      return other instanceof TechEnclosureChangeRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $checkStatus = this.getCheckStatus();
      result = result * 59 + ($checkStatus == null ? 43 : $checkStatus.hashCode());
      Object $checkUserId = this.getCheckUserId();
      result = result * 59 + ($checkUserId == null ? 43 : $checkUserId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $checkUserName = this.getCheckUserName();
      result = result * 59 + ($checkUserName == null ? 43 : $checkUserName.hashCode());
      Object $checkTime = this.getCheckTime();
      result = result * 59 + ($checkTime == null ? 43 : $checkTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $changeRecordDetail = this.getChangeRecordDetail();
      return result * 59 + ($changeRecordDetail == null ? 43 : $changeRecordDetail.hashCode());
   }

   @Override
   public String toString() {
      return "TechEnclosureChangeRecordDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", areaId="
         + this.getAreaId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", remark="
         + this.getRemark()
         + ", user="
         + this.getUser()
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
         + ", changeRecordDetail="
         + this.getChangeRecordDetail()
         + ")";
   }

   public static class TechEnclosureChangeRecordDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private NameInfo monomer;
      private Long areaId;
      private String serialNumber;
      private String remark;
      private NameInfo user;
      private Integer checkStatus;
      private Long checkUserId;
      private String checkUserName;
      private LocalDateTime checkTime;
      private LocalDateTime createTime;
      private TechEnclosureChangeRecordDetailDTO changeRecordDetail;

      TechEnclosureChangeRecordDTOBuilder() {
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder user(final NameInfo user) {
         this.user = user;
         return this;
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder checkStatus(final Integer checkStatus) {
         this.checkStatus = checkStatus;
         return this;
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder checkUserId(final Long checkUserId) {
         this.checkUserId = checkUserId;
         return this;
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder checkUserName(final String checkUserName) {
         this.checkUserName = checkUserName;
         return this;
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder checkTime(final LocalDateTime checkTime) {
         this.checkTime = checkTime;
         return this;
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder changeRecordDetail(final TechEnclosureChangeRecordDetailDTO changeRecordDetail) {
         this.changeRecordDetail = changeRecordDetail;
         return this;
      }

      public TechEnclosureChangeRecordDTO build() {
         return new TechEnclosureChangeRecordDTO(
            this.id,
            this.project,
            this.monomer,
            this.areaId,
            this.serialNumber,
            this.remark,
            this.user,
            this.checkStatus,
            this.checkUserId,
            this.checkUserName,
            this.checkTime,
            this.createTime,
            this.changeRecordDetail
         );
      }

      @Override
      public String toString() {
         return "TechEnclosureChangeRecordDTO.TechEnclosureChangeRecordDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", areaId="
            + this.areaId
            + ", serialNumber="
            + this.serialNumber
            + ", remark="
            + this.remark
            + ", user="
            + this.user
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
            + ", changeRecordDetail="
            + this.changeRecordDetail
            + ")";
      }
   }
}
