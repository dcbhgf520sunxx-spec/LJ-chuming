package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CrmPrequalificationRecordDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "文件受理截止日", notes = "文件受理截止日")
   private LocalDate deadlineForAcceptanceTime;
   @ApiModelProperty(name = "address", value = "文件受理地点", notes = "文件受理地点")
   private String address;
   @ApiModelProperty(name = "email", value = "文件受理邮箱", notes = "文件受理邮箱")
   private String email;
   @ApiModelProperty(name = "cost", value = "预审费用", notes = "预审费用")
   private BigDecimal cost;
   @ApiModelProperty(name = "attachmentList", value = "附件", notes = "附件")
   private List<AttachmentDTO> attachmentList;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   private Long approveRecordId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "crmProjectInformationWarehousingName", value = "项目备案名称", notes = "项目备案名称")
   private String crmProjectInformationWarehousingName;

   public static CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder builder() {
      return new CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder();
   }

   public CrmPrequalificationRecordDetailDTO() {
   }

   public CrmPrequalificationRecordDetailDTO(
      final Long id,
      final String createUserName,
      final LocalDate deadlineForAcceptanceTime,
      final String address,
      final String email,
      final BigDecimal cost,
      final List<AttachmentDTO> attachmentList,
      final Long approveRecordId,
      final String remark,
      final Long crmProjectInformationWarehousingId,
      final String crmProjectInformationWarehousingName
   ) {
      this.id = id;
      this.createUserName = createUserName;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.address = address;
      this.email = email;
      this.cost = cost;
      this.attachmentList = attachmentList;
      this.approveRecordId = approveRecordId;
      this.remark = remark;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
   }

   public Long getId() {
      return this.id;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDate getDeadlineForAcceptanceTime() {
      return this.deadlineForAcceptanceTime;
   }

   public String getAddress() {
      return this.address;
   }

   public String getEmail() {
      return this.email;
   }

   public BigDecimal getCost() {
      return this.cost;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public String getCrmProjectInformationWarehousingName() {
      return this.crmProjectInformationWarehousingName;
   }

   public CrmPrequalificationRecordDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmPrequalificationRecordDetailDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmPrequalificationRecordDetailDTO setDeadlineForAcceptanceTime(final LocalDate deadlineForAcceptanceTime) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      return this;
   }

   public CrmPrequalificationRecordDetailDTO setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmPrequalificationRecordDetailDTO setEmail(final String email) {
      this.email = email;
      return this;
   }

   public CrmPrequalificationRecordDetailDTO setCost(final BigDecimal cost) {
      this.cost = cost;
      return this;
   }

   public CrmPrequalificationRecordDetailDTO setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
      return this;
   }

   public CrmPrequalificationRecordDetailDTO setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmPrequalificationRecordDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmPrequalificationRecordDetailDTO setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmPrequalificationRecordDetailDTO setCrmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmPrequalificationRecordDetailDTO(id="
         + this.getId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", deadlineForAcceptanceTime="
         + this.getDeadlineForAcceptanceTime()
         + ", address="
         + this.getAddress()
         + ", email="
         + this.getEmail()
         + ", cost="
         + this.getCost()
         + ", attachmentList="
         + this.getAttachmentList()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", remark="
         + this.getRemark()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", crmProjectInformationWarehousingName="
         + this.getCrmProjectInformationWarehousingName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmPrequalificationRecordDetailDTO)) {
         return false;
      }

      CrmPrequalificationRecordDetailDTO other = (CrmPrequalificationRecordDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$approveRecordId = this.getApproveRecordId();
         Object other$approveRecordId = other.getApproveRecordId();
         if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
            Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
            Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
            if (this$crmProjectInformationWarehousingId == null
               ? other$crmProjectInformationWarehousingId == null
               : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
               Object this$createUserName = this.getCreateUserName();
               Object other$createUserName = other.getCreateUserName();
               if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                  Object this$deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
                  Object other$deadlineForAcceptanceTime = other.getDeadlineForAcceptanceTime();
                  if (this$deadlineForAcceptanceTime == null
                     ? other$deadlineForAcceptanceTime == null
                     : this$deadlineForAcceptanceTime.equals(other$deadlineForAcceptanceTime)) {
                     Object this$address = this.getAddress();
                     Object other$address = other.getAddress();
                     if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                        Object this$email = this.getEmail();
                        Object other$email = other.getEmail();
                        if (this$email == null ? other$email == null : this$email.equals(other$email)) {
                           Object this$cost = this.getCost();
                           Object other$cost = other.getCost();
                           if (this$cost == null ? other$cost == null : this$cost.equals(other$cost)) {
                              Object this$attachmentList = this.getAttachmentList();
                              Object other$attachmentList = other.getAttachmentList();
                              if (this$attachmentList == null ? other$attachmentList == null : this$attachmentList.equals(other$attachmentList)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
                                    Object other$crmProjectInformationWarehousingName = other.getCrmProjectInformationWarehousingName();
                                    return this$crmProjectInformationWarehousingName == null
                                       ? other$crmProjectInformationWarehousingName == null
                                       : this$crmProjectInformationWarehousingName.equals(other$crmProjectInformationWarehousingName);
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
      return other instanceof CrmPrequalificationRecordDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
      result = result * 59 + ($deadlineForAcceptanceTime == null ? 43 : $deadlineForAcceptanceTime.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $email = this.getEmail();
      result = result * 59 + ($email == null ? 43 : $email.hashCode());
      Object $cost = this.getCost();
      result = result * 59 + ($cost == null ? 43 : $cost.hashCode());
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
      return result * 59 + ($crmProjectInformationWarehousingName == null ? 43 : $crmProjectInformationWarehousingName.hashCode());
   }

   public static class CrmPrequalificationRecordDetailDTOBuilder {
      private Long id;
      private String createUserName;
      private LocalDate deadlineForAcceptanceTime;
      private String address;
      private String email;
      private BigDecimal cost;
      private List<AttachmentDTO> attachmentList;
      private Long approveRecordId;
      private String remark;
      private Long crmProjectInformationWarehousingId;
      private String crmProjectInformationWarehousingName;

      CrmPrequalificationRecordDetailDTOBuilder() {
      }

      public CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder deadlineForAcceptanceTime(final LocalDate deadlineForAcceptanceTime) {
         this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
         return this;
      }

      public CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder email(final String email) {
         this.email = email;
         return this;
      }

      public CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder cost(final BigDecimal cost) {
         this.cost = cost;
         return this;
      }

      public CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder crmProjectInformationWarehousingName(
         final String crmProjectInformationWarehousingName
      ) {
         this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
         return this;
      }

      public CrmPrequalificationRecordDetailDTO build() {
         return new CrmPrequalificationRecordDetailDTO(
            this.id,
            this.createUserName,
            this.deadlineForAcceptanceTime,
            this.address,
            this.email,
            this.cost,
            this.attachmentList,
            this.approveRecordId,
            this.remark,
            this.crmProjectInformationWarehousingId,
            this.crmProjectInformationWarehousingName
         );
      }

      @Override
      public String toString() {
         return "CrmPrequalificationRecordDetailDTO.CrmPrequalificationRecordDetailDTOBuilder(id="
            + this.id
            + ", createUserName="
            + this.createUserName
            + ", deadlineForAcceptanceTime="
            + this.deadlineForAcceptanceTime
            + ", address="
            + this.address
            + ", email="
            + this.email
            + ", cost="
            + this.cost
            + ", attachmentList="
            + this.attachmentList
            + ", approveRecordId="
            + this.approveRecordId
            + ", remark="
            + this.remark
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", crmProjectInformationWarehousingName="
            + this.crmProjectInformationWarehousingName
            + ")";
      }
   }
}
