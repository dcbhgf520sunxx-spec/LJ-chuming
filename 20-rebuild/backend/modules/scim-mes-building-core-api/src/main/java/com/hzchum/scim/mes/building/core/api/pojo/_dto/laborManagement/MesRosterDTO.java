package com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@ApiModel("花名册DTO类")
public class MesRosterDTO extends MesRoster {
   @ApiModelProperty("编号")
   private String username;
   @ApiModelProperty("联系方式")
   private String phone;
   @ApiModelProperty("考勤天数")
   private Integer attendanceDays;
   @ApiModelProperty("已扣行为分")
   private Integer deductedBehaviorScore;
   @ApiModelProperty("剩余行为分")
   private Integer remainingBehaviorScore;
   @ApiModelProperty("累计处罚(元)")
   private BigDecimal cumulativePenalty;
   @ApiModelProperty("所属单位名称(供应商名称)")
   private String supplierName;
   @ApiModelProperty("证书信息列表")
   private List<MesRosterCertDTO> certs;
   @ApiModelProperty("头像附件")
   private AttachmentDTO avatarAttachment;
   @ApiModelProperty("证书附件ID列表")
   private List<Long> certAttachmentIdList;
   @ApiModelProperty("证书附件列表")
   private List<AttachmentDTO> certAttachments;
   @ApiModelProperty("体检附件ID列表")
   private List<Long> physicalExaminationAttachmentIdList;
   @ApiModelProperty("体检附件列表")
   private List<AttachmentDTO> physicalExaminationAttachment;

   public List<Long> getCertAttachmentIdList() {
      return CollUtil.isEmpty(this.certAttachmentIdList) && StrUtil.isNotBlank(super.getCertAttachmentIds())
         ? StrUtil.split(super.getCertAttachmentIds(), ",").stream().map(Long::valueOf).collect(Collectors.toList())
         : this.certAttachmentIdList;
   }

   public List<Long> getPhysicalExaminationAttachmentIdList() {
      return CollUtil.isEmpty(this.physicalExaminationAttachmentIdList) && StrUtil.isNotBlank(super.getPhysicalExaminationAttachmentIds())
         ? StrUtil.split(super.getPhysicalExaminationAttachmentIds(), ",").stream().map(Long::valueOf).collect(Collectors.toList())
         : this.physicalExaminationAttachmentIdList;
   }

   public String getUsername() {
      return this.username;
   }

   public String getPhone() {
      return this.phone;
   }

   public Integer getAttendanceDays() {
      return this.attendanceDays;
   }

   public Integer getDeductedBehaviorScore() {
      return this.deductedBehaviorScore;
   }

   public Integer getRemainingBehaviorScore() {
      return this.remainingBehaviorScore;
   }

   public BigDecimal getCumulativePenalty() {
      return this.cumulativePenalty;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public List<MesRosterCertDTO> getCerts() {
      return this.certs;
   }

   public AttachmentDTO getAvatarAttachment() {
      return this.avatarAttachment;
   }

   public List<AttachmentDTO> getCertAttachments() {
      return this.certAttachments;
   }

   public List<AttachmentDTO> getPhysicalExaminationAttachment() {
      return this.physicalExaminationAttachment;
   }

   public void setUsername(final String username) {
      this.username = username;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setAttendanceDays(final Integer attendanceDays) {
      this.attendanceDays = attendanceDays;
   }

   public void setDeductedBehaviorScore(final Integer deductedBehaviorScore) {
      this.deductedBehaviorScore = deductedBehaviorScore;
   }

   public void setRemainingBehaviorScore(final Integer remainingBehaviorScore) {
      this.remainingBehaviorScore = remainingBehaviorScore;
   }

   public void setCumulativePenalty(final BigDecimal cumulativePenalty) {
      this.cumulativePenalty = cumulativePenalty;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setCerts(final List<MesRosterCertDTO> certs) {
      this.certs = certs;
   }

   public void setAvatarAttachment(final AttachmentDTO avatarAttachment) {
      this.avatarAttachment = avatarAttachment;
   }

   public void setCertAttachmentIdList(final List<Long> certAttachmentIdList) {
      this.certAttachmentIdList = certAttachmentIdList;
   }

   public void setCertAttachments(final List<AttachmentDTO> certAttachments) {
      this.certAttachments = certAttachments;
   }

   public void setPhysicalExaminationAttachmentIdList(final List<Long> physicalExaminationAttachmentIdList) {
      this.physicalExaminationAttachmentIdList = physicalExaminationAttachmentIdList;
   }

   public void setPhysicalExaminationAttachment(final List<AttachmentDTO> physicalExaminationAttachment) {
      this.physicalExaminationAttachment = physicalExaminationAttachment;
   }

   @Override
   public String toString() {
      return "MesRosterDTO(super="
         + super.toString()
         + ", username="
         + this.getUsername()
         + ", phone="
         + this.getPhone()
         + ", attendanceDays="
         + this.getAttendanceDays()
         + ", deductedBehaviorScore="
         + this.getDeductedBehaviorScore()
         + ", remainingBehaviorScore="
         + this.getRemainingBehaviorScore()
         + ", cumulativePenalty="
         + this.getCumulativePenalty()
         + ", supplierName="
         + this.getSupplierName()
         + ", certs="
         + this.getCerts()
         + ", avatarAttachment="
         + this.getAvatarAttachment()
         + ", certAttachmentIdList="
         + this.getCertAttachmentIdList()
         + ", certAttachments="
         + this.getCertAttachments()
         + ", physicalExaminationAttachmentIdList="
         + this.getPhysicalExaminationAttachmentIdList()
         + ", physicalExaminationAttachment="
         + this.getPhysicalExaminationAttachment()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesRosterDTO)) {
         return false;
      }

      MesRosterDTO other = (MesRosterDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$attendanceDays = this.getAttendanceDays();
      Object other$attendanceDays = other.getAttendanceDays();
      if (this$attendanceDays == null ? other$attendanceDays == null : this$attendanceDays.equals(other$attendanceDays)) {
         Object this$deductedBehaviorScore = this.getDeductedBehaviorScore();
         Object other$deductedBehaviorScore = other.getDeductedBehaviorScore();
         if (this$deductedBehaviorScore == null ? other$deductedBehaviorScore == null : this$deductedBehaviorScore.equals(other$deductedBehaviorScore)) {
            Object this$remainingBehaviorScore = this.getRemainingBehaviorScore();
            Object other$remainingBehaviorScore = other.getRemainingBehaviorScore();
            if (this$remainingBehaviorScore == null ? other$remainingBehaviorScore == null : this$remainingBehaviorScore.equals(other$remainingBehaviorScore)) {
               Object this$username = this.getUsername();
               Object other$username = other.getUsername();
               if (this$username == null ? other$username == null : this$username.equals(other$username)) {
                  Object this$phone = this.getPhone();
                  Object other$phone = other.getPhone();
                  if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                     Object this$cumulativePenalty = this.getCumulativePenalty();
                     Object other$cumulativePenalty = other.getCumulativePenalty();
                     if (this$cumulativePenalty == null ? other$cumulativePenalty == null : this$cumulativePenalty.equals(other$cumulativePenalty)) {
                        Object this$supplierName = this.getSupplierName();
                        Object other$supplierName = other.getSupplierName();
                        if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                           Object this$certs = this.getCerts();
                           Object other$certs = other.getCerts();
                           if (this$certs == null ? other$certs == null : this$certs.equals(other$certs)) {
                              Object this$avatarAttachment = this.getAvatarAttachment();
                              Object other$avatarAttachment = other.getAvatarAttachment();
                              if (this$avatarAttachment == null ? other$avatarAttachment == null : this$avatarAttachment.equals(other$avatarAttachment)) {
                                 Object this$certAttachmentIdList = this.getCertAttachmentIdList();
                                 Object other$certAttachmentIdList = other.getCertAttachmentIdList();
                                 if (this$certAttachmentIdList == null
                                    ? other$certAttachmentIdList == null
                                    : this$certAttachmentIdList.equals(other$certAttachmentIdList)) {
                                    Object this$certAttachments = this.getCertAttachments();
                                    Object other$certAttachments = other.getCertAttachments();
                                    if (this$certAttachments == null ? other$certAttachments == null : this$certAttachments.equals(other$certAttachments)) {
                                       Object this$physicalExaminationAttachmentIdList = this.getPhysicalExaminationAttachmentIdList();
                                       Object other$physicalExaminationAttachmentIdList = other.getPhysicalExaminationAttachmentIdList();
                                       if (this$physicalExaminationAttachmentIdList == null
                                          ? other$physicalExaminationAttachmentIdList == null
                                          : this$physicalExaminationAttachmentIdList.equals(other$physicalExaminationAttachmentIdList)) {
                                          Object this$physicalExaminationAttachment = this.getPhysicalExaminationAttachment();
                                          Object other$physicalExaminationAttachment = other.getPhysicalExaminationAttachment();
                                          return this$physicalExaminationAttachment == null
                                             ? other$physicalExaminationAttachment == null
                                             : this$physicalExaminationAttachment.equals(other$physicalExaminationAttachment);
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
      return other instanceof MesRosterDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $attendanceDays = this.getAttendanceDays();
      result = result * 59 + ($attendanceDays == null ? 43 : $attendanceDays.hashCode());
      Object $deductedBehaviorScore = this.getDeductedBehaviorScore();
      result = result * 59 + ($deductedBehaviorScore == null ? 43 : $deductedBehaviorScore.hashCode());
      Object $remainingBehaviorScore = this.getRemainingBehaviorScore();
      result = result * 59 + ($remainingBehaviorScore == null ? 43 : $remainingBehaviorScore.hashCode());
      Object $username = this.getUsername();
      result = result * 59 + ($username == null ? 43 : $username.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $cumulativePenalty = this.getCumulativePenalty();
      result = result * 59 + ($cumulativePenalty == null ? 43 : $cumulativePenalty.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $certs = this.getCerts();
      result = result * 59 + ($certs == null ? 43 : $certs.hashCode());
      Object $avatarAttachment = this.getAvatarAttachment();
      result = result * 59 + ($avatarAttachment == null ? 43 : $avatarAttachment.hashCode());
      Object $certAttachmentIdList = this.getCertAttachmentIdList();
      result = result * 59 + ($certAttachmentIdList == null ? 43 : $certAttachmentIdList.hashCode());
      Object $certAttachments = this.getCertAttachments();
      result = result * 59 + ($certAttachments == null ? 43 : $certAttachments.hashCode());
      Object $physicalExaminationAttachmentIdList = this.getPhysicalExaminationAttachmentIdList();
      result = result * 59 + ($physicalExaminationAttachmentIdList == null ? 43 : $physicalExaminationAttachmentIdList.hashCode());
      Object $physicalExaminationAttachment = this.getPhysicalExaminationAttachment();
      return result * 59 + ($physicalExaminationAttachment == null ? 43 : $physicalExaminationAttachment.hashCode());
   }
}
