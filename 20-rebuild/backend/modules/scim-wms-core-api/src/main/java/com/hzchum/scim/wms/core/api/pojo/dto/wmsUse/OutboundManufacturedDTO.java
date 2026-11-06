package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class OutboundManufacturedDTO {
   @ApiModelProperty("制成品出库单ID")
   private Long id;
   @ApiModelProperty("物料基础类型")
   private Integer basicClass;
   @ApiModelProperty("制成品出库单号")
   private String serialNumber;
   @ApiModelProperty("审核状态")
   private Integer reviewStatus;
   @ApiModelProperty("申请人名称")
   private String applicantName;
   @ApiModelProperty("出库单创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty("出库单提交申请时间")
   private LocalDateTime applicationTime;
   @ApiModelProperty("出库单审核通过时间")
   private LocalDateTime reviewPassTime;
   @ApiModelProperty("审批日志ID")
   private Long approveRecordId;
   @ApiModelProperty(name = "wmsApproveRecordFlowDTO", value = "审批日志信息", notes = "审批日志信息")
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS;
   @ApiModelProperty("项目信息")
   private List<ProjectInfo> projects;
   @ApiModelProperty("出库详情")
   private List<OutboundDetailManufacturedDTO> list;

   public static OutboundManufacturedDTO.OutboundManufacturedDTOBuilder builder() {
      return new OutboundManufacturedDTO.OutboundManufacturedDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getApplicationTime() {
      return this.applicationTime;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTOS() {
      return this.wmsApproveRecordFlowDTOS;
   }

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public List<OutboundDetailManufacturedDTO> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setApplicationTime(final LocalDateTime applicationTime) {
      this.applicationTime = applicationTime;
   }

   public void setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setWmsApproveRecordFlowDTOS(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS) {
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
   }

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setList(final List<OutboundDetailManufacturedDTO> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundManufacturedDTO)) {
         return false;
      }

      OutboundManufacturedDTO other = (OutboundManufacturedDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$approveRecordId = this.getApproveRecordId();
               Object other$approveRecordId = other.getApproveRecordId();
               if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$applicantName = this.getApplicantName();
                     Object other$applicantName = other.getApplicantName();
                     if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$applicationTime = this.getApplicationTime();
                           Object other$applicationTime = other.getApplicationTime();
                           if (this$applicationTime == null ? other$applicationTime == null : this$applicationTime.equals(other$applicationTime)) {
                              Object this$reviewPassTime = this.getReviewPassTime();
                              Object other$reviewPassTime = other.getReviewPassTime();
                              if (this$reviewPassTime == null ? other$reviewPassTime == null : this$reviewPassTime.equals(other$reviewPassTime)) {
                                 Object this$wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
                                 Object other$wmsApproveRecordFlowDTOS = other.getWmsApproveRecordFlowDTOS();
                                 if (this$wmsApproveRecordFlowDTOS == null
                                    ? other$wmsApproveRecordFlowDTOS == null
                                    : this$wmsApproveRecordFlowDTOS.equals(other$wmsApproveRecordFlowDTOS)) {
                                    Object this$projects = this.getProjects();
                                    Object other$projects = other.getProjects();
                                    if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                                       Object this$list = this.getList();
                                       Object other$list = other.getList();
                                       return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof OutboundManufacturedDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $applicationTime = this.getApplicationTime();
      result = result * 59 + ($applicationTime == null ? 43 : $applicationTime.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
      result = result * 59 + ($wmsApproveRecordFlowDTOS == null ? 43 : $wmsApproveRecordFlowDTOS.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundManufacturedDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", applicantName="
         + this.getApplicantName()
         + ", createTime="
         + this.getCreateTime()
         + ", applicationTime="
         + this.getApplicationTime()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", wmsApproveRecordFlowDTOS="
         + this.getWmsApproveRecordFlowDTOS()
         + ", projects="
         + this.getProjects()
         + ", list="
         + this.getList()
         + ")";
   }

   public OutboundManufacturedDTO(
      final Long id,
      final Integer basicClass,
      final String serialNumber,
      final Integer reviewStatus,
      final String applicantName,
      final LocalDateTime createTime,
      final LocalDateTime applicationTime,
      final LocalDateTime reviewPassTime,
      final Long approveRecordId,
      final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS,
      final List<ProjectInfo> projects,
      final List<OutboundDetailManufacturedDTO> list
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.reviewStatus = reviewStatus;
      this.applicantName = applicantName;
      this.createTime = createTime;
      this.applicationTime = applicationTime;
      this.reviewPassTime = reviewPassTime;
      this.approveRecordId = approveRecordId;
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
      this.projects = projects;
      this.list = list;
   }

   public OutboundManufacturedDTO() {
   }

   public static class OutboundManufacturedDTOBuilder {
      private Long id;
      private Integer basicClass;
      private String serialNumber;
      private Integer reviewStatus;
      private String applicantName;
      private LocalDateTime createTime;
      private LocalDateTime applicationTime;
      private LocalDateTime reviewPassTime;
      private Long approveRecordId;
      private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS;
      private List<ProjectInfo> projects;
      private List<OutboundDetailManufacturedDTO> list;

      OutboundManufacturedDTOBuilder() {
      }

      public OutboundManufacturedDTO.OutboundManufacturedDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OutboundManufacturedDTO.OutboundManufacturedDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public OutboundManufacturedDTO.OutboundManufacturedDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public OutboundManufacturedDTO.OutboundManufacturedDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public OutboundManufacturedDTO.OutboundManufacturedDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public OutboundManufacturedDTO.OutboundManufacturedDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public OutboundManufacturedDTO.OutboundManufacturedDTOBuilder applicationTime(final LocalDateTime applicationTime) {
         this.applicationTime = applicationTime;
         return this;
      }

      public OutboundManufacturedDTO.OutboundManufacturedDTOBuilder reviewPassTime(final LocalDateTime reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      public OutboundManufacturedDTO.OutboundManufacturedDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public OutboundManufacturedDTO.OutboundManufacturedDTOBuilder wmsApproveRecordFlowDTOS(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS) {
         this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
         return this;
      }

      public OutboundManufacturedDTO.OutboundManufacturedDTOBuilder projects(final List<ProjectInfo> projects) {
         this.projects = projects;
         return this;
      }

      public OutboundManufacturedDTO.OutboundManufacturedDTOBuilder list(final List<OutboundDetailManufacturedDTO> list) {
         this.list = list;
         return this;
      }

      public OutboundManufacturedDTO build() {
         return new OutboundManufacturedDTO(
            this.id,
            this.basicClass,
            this.serialNumber,
            this.reviewStatus,
            this.applicantName,
            this.createTime,
            this.applicationTime,
            this.reviewPassTime,
            this.approveRecordId,
            this.wmsApproveRecordFlowDTOS,
            this.projects,
            this.list
         );
      }

      @Override
      public String toString() {
         return "OutboundManufacturedDTO.OutboundManufacturedDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", reviewStatus="
            + this.reviewStatus
            + ", applicantName="
            + this.applicantName
            + ", createTime="
            + this.createTime
            + ", applicationTime="
            + this.applicationTime
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", approveRecordId="
            + this.approveRecordId
            + ", wmsApproveRecordFlowDTOS="
            + this.wmsApproveRecordFlowDTOS
            + ", projects="
            + this.projects
            + ", list="
            + this.list
            + ")";
      }
   }
}
