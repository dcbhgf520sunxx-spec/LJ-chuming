package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefDeptAndNameDTO;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class OutboundDTO {
   private Long id;
   private LocalDateTime userUpdateTime;
   private LocalDateTime createTime;
   private LocalDateTime reviewTime;
   private BriefDeptAndNameDTO applicant;
   private Integer basicClass;
   private Integer reviewStatus;
   private String serialNumber;
   private String applicantSN;
   private Boolean boolPartyA;
   private Integer outboundTypeSelection;
   private Long approveRecordId;
   private String taskOrderNumber;
   private String reviewerName;
   private Integer orderSupplyType;
   private String remark;
   private List<OutboundDetailDTO> list;
   @ApiModelProperty(name = "wmsApproveRecordFlowDTO", value = "审批日志信息", notes = "审批日志信息")
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS;

   public static OutboundDTO.OutboundDTOBuilder builder() {
      return new OutboundDTO.OutboundDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public BriefDeptAndNameDTO getApplicant() {
      return this.applicant;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getApplicantSN() {
      return this.applicantSN;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public Integer getOrderSupplyType() {
      return this.orderSupplyType;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<OutboundDetailDTO> getList() {
      return this.list;
   }

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTOS() {
      return this.wmsApproveRecordFlowDTOS;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setApplicant(final BriefDeptAndNameDTO applicant) {
      this.applicant = applicant;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setApplicantSN(final String applicantSN) {
      this.applicantSN = applicantSN;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setOrderSupplyType(final Integer orderSupplyType) {
      this.orderSupplyType = orderSupplyType;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setList(final List<OutboundDetailDTO> list) {
      this.list = list;
   }

   public void setWmsApproveRecordFlowDTOS(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS) {
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundDTO)) {
         return false;
      }

      OutboundDTO other = (OutboundDTO)o;
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
               Object this$boolPartyA = this.getBoolPartyA();
               Object other$boolPartyA = other.getBoolPartyA();
               if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                  Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                  Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                  if (this$outboundTypeSelection == null ? other$outboundTypeSelection == null : this$outboundTypeSelection.equals(other$outboundTypeSelection)
                     )
                   {
                     Object this$approveRecordId = this.getApproveRecordId();
                     Object other$approveRecordId = other.getApproveRecordId();
                     if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                        Object this$orderSupplyType = this.getOrderSupplyType();
                        Object other$orderSupplyType = other.getOrderSupplyType();
                        if (this$orderSupplyType == null ? other$orderSupplyType == null : this$orderSupplyType.equals(other$orderSupplyType)) {
                           Object this$userUpdateTime = this.getUserUpdateTime();
                           Object other$userUpdateTime = other.getUserUpdateTime();
                           if (this$userUpdateTime == null ? other$userUpdateTime == null : this$userUpdateTime.equals(other$userUpdateTime)) {
                              Object this$createTime = this.getCreateTime();
                              Object other$createTime = other.getCreateTime();
                              if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                 Object this$reviewTime = this.getReviewTime();
                                 Object other$reviewTime = other.getReviewTime();
                                 if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                                    Object this$applicant = this.getApplicant();
                                    Object other$applicant = other.getApplicant();
                                    if (this$applicant == null ? other$applicant == null : this$applicant.equals(other$applicant)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$applicantSN = this.getApplicantSN();
                                          Object other$applicantSN = other.getApplicantSN();
                                          if (this$applicantSN == null ? other$applicantSN == null : this$applicantSN.equals(other$applicantSN)) {
                                             Object this$taskOrderNumber = this.getTaskOrderNumber();
                                             Object other$taskOrderNumber = other.getTaskOrderNumber();
                                             if (this$taskOrderNumber == null
                                                ? other$taskOrderNumber == null
                                                : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                                                Object this$reviewerName = this.getReviewerName();
                                                Object other$reviewerName = other.getReviewerName();
                                                if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                      Object this$list = this.getList();
                                                      Object other$list = other.getList();
                                                      if (this$list == null ? other$list == null : this$list.equals(other$list)) {
                                                         Object this$wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
                                                         Object other$wmsApproveRecordFlowDTOS = other.getWmsApproveRecordFlowDTOS();
                                                         return this$wmsApproveRecordFlowDTOS == null
                                                            ? other$wmsApproveRecordFlowDTOS == null
                                                            : this$wmsApproveRecordFlowDTOS.equals(other$wmsApproveRecordFlowDTOS);
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
      return other instanceof OutboundDTO;
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
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $orderSupplyType = this.getOrderSupplyType();
      result = result * 59 + ($orderSupplyType == null ? 43 : $orderSupplyType.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $applicant = this.getApplicant();
      result = result * 59 + ($applicant == null ? 43 : $applicant.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantSN = this.getApplicantSN();
      result = result * 59 + ($applicantSN == null ? 43 : $applicantSN.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
      return result * 59 + ($wmsApproveRecordFlowDTOS == null ? 43 : $wmsApproveRecordFlowDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundDTO(id="
         + this.getId()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", createTime="
         + this.getCreateTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", applicant="
         + this.getApplicant()
         + ", basicClass="
         + this.getBasicClass()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicantSN="
         + this.getApplicantSN()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", reviewerName="
         + this.getReviewerName()
         + ", orderSupplyType="
         + this.getOrderSupplyType()
         + ", remark="
         + this.getRemark()
         + ", list="
         + this.getList()
         + ", wmsApproveRecordFlowDTOS="
         + this.getWmsApproveRecordFlowDTOS()
         + ")";
   }

   public OutboundDTO(
      final Long id,
      final LocalDateTime userUpdateTime,
      final LocalDateTime createTime,
      final LocalDateTime reviewTime,
      final BriefDeptAndNameDTO applicant,
      final Integer basicClass,
      final Integer reviewStatus,
      final String serialNumber,
      final String applicantSN,
      final Boolean boolPartyA,
      final Integer outboundTypeSelection,
      final Long approveRecordId,
      final String taskOrderNumber,
      final String reviewerName,
      final Integer orderSupplyType,
      final String remark,
      final List<OutboundDetailDTO> list,
      final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS
   ) {
      this.id = id;
      this.userUpdateTime = userUpdateTime;
      this.createTime = createTime;
      this.reviewTime = reviewTime;
      this.applicant = applicant;
      this.basicClass = basicClass;
      this.reviewStatus = reviewStatus;
      this.serialNumber = serialNumber;
      this.applicantSN = applicantSN;
      this.boolPartyA = boolPartyA;
      this.outboundTypeSelection = outboundTypeSelection;
      this.approveRecordId = approveRecordId;
      this.taskOrderNumber = taskOrderNumber;
      this.reviewerName = reviewerName;
      this.orderSupplyType = orderSupplyType;
      this.remark = remark;
      this.list = list;
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
   }

   public OutboundDTO() {
   }

   public static class OutboundDTOBuilder {
      private Long id;
      private LocalDateTime userUpdateTime;
      private LocalDateTime createTime;
      private LocalDateTime reviewTime;
      private BriefDeptAndNameDTO applicant;
      private Integer basicClass;
      private Integer reviewStatus;
      private String serialNumber;
      private String applicantSN;
      private Boolean boolPartyA;
      private Integer outboundTypeSelection;
      private Long approveRecordId;
      private String taskOrderNumber;
      private String reviewerName;
      private Integer orderSupplyType;
      private String remark;
      private List<OutboundDetailDTO> list;
      private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS;

      OutboundDTOBuilder() {
      }

      public OutboundDTO.OutboundDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder applicant(final BriefDeptAndNameDTO applicant) {
         this.applicant = applicant;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder applicantSN(final String applicantSN) {
         this.applicantSN = applicantSN;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder orderSupplyType(final Integer orderSupplyType) {
         this.orderSupplyType = orderSupplyType;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder list(final List<OutboundDetailDTO> list) {
         this.list = list;
         return this;
      }

      public OutboundDTO.OutboundDTOBuilder wmsApproveRecordFlowDTOS(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS) {
         this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
         return this;
      }

      public OutboundDTO build() {
         return new OutboundDTO(
            this.id,
            this.userUpdateTime,
            this.createTime,
            this.reviewTime,
            this.applicant,
            this.basicClass,
            this.reviewStatus,
            this.serialNumber,
            this.applicantSN,
            this.boolPartyA,
            this.outboundTypeSelection,
            this.approveRecordId,
            this.taskOrderNumber,
            this.reviewerName,
            this.orderSupplyType,
            this.remark,
            this.list,
            this.wmsApproveRecordFlowDTOS
         );
      }

      @Override
      public String toString() {
         return "OutboundDTO.OutboundDTOBuilder(id="
            + this.id
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", createTime="
            + this.createTime
            + ", reviewTime="
            + this.reviewTime
            + ", applicant="
            + this.applicant
            + ", basicClass="
            + this.basicClass
            + ", reviewStatus="
            + this.reviewStatus
            + ", serialNumber="
            + this.serialNumber
            + ", applicantSN="
            + this.applicantSN
            + ", boolPartyA="
            + this.boolPartyA
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", approveRecordId="
            + this.approveRecordId
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", reviewerName="
            + this.reviewerName
            + ", orderSupplyType="
            + this.orderSupplyType
            + ", remark="
            + this.remark
            + ", list="
            + this.list
            + ", wmsApproveRecordFlowDTOS="
            + this.wmsApproveRecordFlowDTOS
            + ")";
      }
   }
}
