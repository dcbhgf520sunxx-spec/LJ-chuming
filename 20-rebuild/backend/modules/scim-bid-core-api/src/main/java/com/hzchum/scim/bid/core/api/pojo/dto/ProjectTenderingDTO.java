package com.hzchum.scim.bid.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.UpdateBatch;
import com.hzchum.scim.bid.core.api.enums.BiddingTypeEnum;
import com.hzchum.scim.bid.core.api.enums.CommonEnum;
import com.hzchum.scim.bid.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.bid.core.api.enums.OrderTransportTypeEnum;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class ProjectTenderingDTO {
   @NotNull(message = "项目id不能为空", groups = UpdateBatch.class)
   private Long id;
   @NotBlank(message = "项目名称不能为空", groups = {Add.class, UpdateBatch.class})
   @Length(max = 100, message = "账户账号最大长度为100个字")
   private String name;
   @NotNull(message = "项目类型不能为空", groups = {Add.class, UpdateBatch.class})
   private Integer projectType;
   @NotBlank(message = "合同编号不能为空", groups = UpdateBatch.class)
   private String contractNo;
   @EnumValidator(value = BiddingTypeEnum.class, message = "招采方式错误", groups = {Add.class, UpdateBatch.class})
   private Integer biddingType;
   @EnumValidator(value = CommonEnum.class, message = "是否需要保证金异常", groups = {Add.class, UpdateBatch.class})
   private Integer isCashDeposit;
   private BigDecimal cashDeposit;
   private String bankAccountName;
   @Length(max = 20, message = "账户账号最大长度为64个字", groups = {Add.class, UpdateBatch.class})
   private String bankAccount;
   private String depositBank;
   @NotBlank(message = "联系人不能为空", groups = {Add.class, UpdateBatch.class})
   private String contactPerson;
   @NotNull(message = "联系人电话不能为空", groups = {Add.class, UpdateBatch.class})
   private String phone;
   private String deliveryAddress;
   @NotNull(message = "交货时间不能为空", groups = {Add.class, UpdateBatch.class})
   @Future(message = "交货时间必须是未来的时间", groups = {Add.class, UpdateBatch.class})
   private Date deliveryTime;
   @EnumValidator(value = OrderTransportTypeEnum.class, message = "交货方式错误", groups = {Add.class, UpdateBatch.class})
   private Integer deliveryType;
   @EnumValidator(value = InvoiceTypeEnum.class, message = "发票类型错误", groups = {Add.class, UpdateBatch.class})
   private Integer invoiceType;
   private Double taxRate;
   @NotNull(message = "投标时间不能为空", groups = {Add.class, UpdateBatch.class})
   @Future(message = "投标时间必须是未来的时间", groups = {Add.class, UpdateBatch.class})
   private Date bidDeadline;
   @NotNull(message = "投标时间不能为空", groups = {Add.class, UpdateBatch.class})
   @Future(message = "开标时间必须是未来的时间", groups = {Add.class, UpdateBatch.class})
   private Date bidOpeningTime;
   private List<Long> supplierIds;
   @NotEmpty(message = "科目不能为空", groups = {Add.class, UpdateBatch.class})
   @Valid
   private List<SubjectProjectDTO> subjectProjectDTOS;
   private String remark;
   private TenderNoticeDTO tenderNoticeDTO;

   public static ProjectTenderingDTO.ProjectTenderingDTOBuilder builder() {
      return new ProjectTenderingDTO.ProjectTenderingDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public String getContractNo() {
      return this.contractNo;
   }

   public Integer getBiddingType() {
      return this.biddingType;
   }

   public Integer getIsCashDeposit() {
      return this.isCashDeposit;
   }

   public BigDecimal getCashDeposit() {
      return this.cashDeposit;
   }

   public String getBankAccountName() {
      return this.bankAccountName;
   }

   public String getBankAccount() {
      return this.bankAccount;
   }

   public String getDepositBank() {
      return this.depositBank;
   }

   public String getContactPerson() {
      return this.contactPerson;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getDeliveryAddress() {
      return this.deliveryAddress;
   }

   public Date getDeliveryTime() {
      return this.deliveryTime;
   }

   public Integer getDeliveryType() {
      return this.deliveryType;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Double getTaxRate() {
      return this.taxRate;
   }

   public Date getBidDeadline() {
      return this.bidDeadline;
   }

   public Date getBidOpeningTime() {
      return this.bidOpeningTime;
   }

   public List<Long> getSupplierIds() {
      return this.supplierIds;
   }

   public List<SubjectProjectDTO> getSubjectProjectDTOS() {
      return this.subjectProjectDTOS;
   }

   public String getRemark() {
      return this.remark;
   }

   public TenderNoticeDTO getTenderNoticeDTO() {
      return this.tenderNoticeDTO;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setContractNo(final String contractNo) {
      this.contractNo = contractNo;
   }

   public void setBiddingType(final Integer biddingType) {
      this.biddingType = biddingType;
   }

   public void setIsCashDeposit(final Integer isCashDeposit) {
      this.isCashDeposit = isCashDeposit;
   }

   public void setCashDeposit(final BigDecimal cashDeposit) {
      this.cashDeposit = cashDeposit;
   }

   public void setBankAccountName(final String bankAccountName) {
      this.bankAccountName = bankAccountName;
   }

   public void setBankAccount(final String bankAccount) {
      this.bankAccount = bankAccount;
   }

   public void setDepositBank(final String depositBank) {
      this.depositBank = depositBank;
   }

   public void setContactPerson(final String contactPerson) {
      this.contactPerson = contactPerson;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setDeliveryAddress(final String deliveryAddress) {
      this.deliveryAddress = deliveryAddress;
   }

   public void setDeliveryTime(final Date deliveryTime) {
      this.deliveryTime = deliveryTime;
   }

   public void setDeliveryType(final Integer deliveryType) {
      this.deliveryType = deliveryType;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final Double taxRate) {
      this.taxRate = taxRate;
   }

   public void setBidDeadline(final Date bidDeadline) {
      this.bidDeadline = bidDeadline;
   }

   public void setBidOpeningTime(final Date bidOpeningTime) {
      this.bidOpeningTime = bidOpeningTime;
   }

   public void setSupplierIds(final List<Long> supplierIds) {
      this.supplierIds = supplierIds;
   }

   public void setSubjectProjectDTOS(final List<SubjectProjectDTO> subjectProjectDTOS) {
      this.subjectProjectDTOS = subjectProjectDTOS;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setTenderNoticeDTO(final TenderNoticeDTO tenderNoticeDTO) {
      this.tenderNoticeDTO = tenderNoticeDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectTenderingDTO)) {
         return false;
      }

      ProjectTenderingDTO other = (ProjectTenderingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectType = this.getProjectType();
         Object other$projectType = other.getProjectType();
         if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
            Object this$biddingType = this.getBiddingType();
            Object other$biddingType = other.getBiddingType();
            if (this$biddingType == null ? other$biddingType == null : this$biddingType.equals(other$biddingType)) {
               Object this$isCashDeposit = this.getIsCashDeposit();
               Object other$isCashDeposit = other.getIsCashDeposit();
               if (this$isCashDeposit == null ? other$isCashDeposit == null : this$isCashDeposit.equals(other$isCashDeposit)) {
                  Object this$deliveryType = this.getDeliveryType();
                  Object other$deliveryType = other.getDeliveryType();
                  if (this$deliveryType == null ? other$deliveryType == null : this$deliveryType.equals(other$deliveryType)) {
                     Object this$invoiceType = this.getInvoiceType();
                     Object other$invoiceType = other.getInvoiceType();
                     if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                        Object this$taxRate = this.getTaxRate();
                        Object other$taxRate = other.getTaxRate();
                        if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$contractNo = this.getContractNo();
                              Object other$contractNo = other.getContractNo();
                              if (this$contractNo == null ? other$contractNo == null : this$contractNo.equals(other$contractNo)) {
                                 Object this$cashDeposit = this.getCashDeposit();
                                 Object other$cashDeposit = other.getCashDeposit();
                                 if (this$cashDeposit == null ? other$cashDeposit == null : this$cashDeposit.equals(other$cashDeposit)) {
                                    Object this$bankAccountName = this.getBankAccountName();
                                    Object other$bankAccountName = other.getBankAccountName();
                                    if (this$bankAccountName == null ? other$bankAccountName == null : this$bankAccountName.equals(other$bankAccountName)) {
                                       Object this$bankAccount = this.getBankAccount();
                                       Object other$bankAccount = other.getBankAccount();
                                       if (this$bankAccount == null ? other$bankAccount == null : this$bankAccount.equals(other$bankAccount)) {
                                          Object this$depositBank = this.getDepositBank();
                                          Object other$depositBank = other.getDepositBank();
                                          if (this$depositBank == null ? other$depositBank == null : this$depositBank.equals(other$depositBank)) {
                                             Object this$contactPerson = this.getContactPerson();
                                             Object other$contactPerson = other.getContactPerson();
                                             if (this$contactPerson == null ? other$contactPerson == null : this$contactPerson.equals(other$contactPerson)) {
                                                Object this$phone = this.getPhone();
                                                Object other$phone = other.getPhone();
                                                if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
                                                   Object this$deliveryAddress = this.getDeliveryAddress();
                                                   Object other$deliveryAddress = other.getDeliveryAddress();
                                                   if (this$deliveryAddress == null
                                                      ? other$deliveryAddress == null
                                                      : this$deliveryAddress.equals(other$deliveryAddress)) {
                                                      Object this$deliveryTime = this.getDeliveryTime();
                                                      Object other$deliveryTime = other.getDeliveryTime();
                                                      if (this$deliveryTime == null ? other$deliveryTime == null : this$deliveryTime.equals(other$deliveryTime)
                                                         )
                                                       {
                                                         Object this$bidDeadline = this.getBidDeadline();
                                                         Object other$bidDeadline = other.getBidDeadline();
                                                         if (this$bidDeadline == null ? other$bidDeadline == null : this$bidDeadline.equals(other$bidDeadline)) {
                                                            Object this$bidOpeningTime = this.getBidOpeningTime();
                                                            Object other$bidOpeningTime = other.getBidOpeningTime();
                                                            if (this$bidOpeningTime == null
                                                               ? other$bidOpeningTime == null
                                                               : this$bidOpeningTime.equals(other$bidOpeningTime)) {
                                                               Object this$supplierIds = this.getSupplierIds();
                                                               Object other$supplierIds = other.getSupplierIds();
                                                               if (this$supplierIds == null
                                                                  ? other$supplierIds == null
                                                                  : this$supplierIds.equals(other$supplierIds)) {
                                                                  Object this$subjectProjectDTOS = this.getSubjectProjectDTOS();
                                                                  Object other$subjectProjectDTOS = other.getSubjectProjectDTOS();
                                                                  if (this$subjectProjectDTOS == null
                                                                     ? other$subjectProjectDTOS == null
                                                                     : this$subjectProjectDTOS.equals(other$subjectProjectDTOS)) {
                                                                     Object this$remark = this.getRemark();
                                                                     Object other$remark = other.getRemark();
                                                                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                        Object this$tenderNoticeDTO = this.getTenderNoticeDTO();
                                                                        Object other$tenderNoticeDTO = other.getTenderNoticeDTO();
                                                                        return this$tenderNoticeDTO == null
                                                                           ? other$tenderNoticeDTO == null
                                                                           : this$tenderNoticeDTO.equals(other$tenderNoticeDTO);
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
      return other instanceof ProjectTenderingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $biddingType = this.getBiddingType();
      result = result * 59 + ($biddingType == null ? 43 : $biddingType.hashCode());
      Object $isCashDeposit = this.getIsCashDeposit();
      result = result * 59 + ($isCashDeposit == null ? 43 : $isCashDeposit.hashCode());
      Object $deliveryType = this.getDeliveryType();
      result = result * 59 + ($deliveryType == null ? 43 : $deliveryType.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $contractNo = this.getContractNo();
      result = result * 59 + ($contractNo == null ? 43 : $contractNo.hashCode());
      Object $cashDeposit = this.getCashDeposit();
      result = result * 59 + ($cashDeposit == null ? 43 : $cashDeposit.hashCode());
      Object $bankAccountName = this.getBankAccountName();
      result = result * 59 + ($bankAccountName == null ? 43 : $bankAccountName.hashCode());
      Object $bankAccount = this.getBankAccount();
      result = result * 59 + ($bankAccount == null ? 43 : $bankAccount.hashCode());
      Object $depositBank = this.getDepositBank();
      result = result * 59 + ($depositBank == null ? 43 : $depositBank.hashCode());
      Object $contactPerson = this.getContactPerson();
      result = result * 59 + ($contactPerson == null ? 43 : $contactPerson.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $deliveryAddress = this.getDeliveryAddress();
      result = result * 59 + ($deliveryAddress == null ? 43 : $deliveryAddress.hashCode());
      Object $deliveryTime = this.getDeliveryTime();
      result = result * 59 + ($deliveryTime == null ? 43 : $deliveryTime.hashCode());
      Object $bidDeadline = this.getBidDeadline();
      result = result * 59 + ($bidDeadline == null ? 43 : $bidDeadline.hashCode());
      Object $bidOpeningTime = this.getBidOpeningTime();
      result = result * 59 + ($bidOpeningTime == null ? 43 : $bidOpeningTime.hashCode());
      Object $supplierIds = this.getSupplierIds();
      result = result * 59 + ($supplierIds == null ? 43 : $supplierIds.hashCode());
      Object $subjectProjectDTOS = this.getSubjectProjectDTOS();
      result = result * 59 + ($subjectProjectDTOS == null ? 43 : $subjectProjectDTOS.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $tenderNoticeDTO = this.getTenderNoticeDTO();
      return result * 59 + ($tenderNoticeDTO == null ? 43 : $tenderNoticeDTO.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectTenderingDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", projectType="
         + this.getProjectType()
         + ", contractNo="
         + this.getContractNo()
         + ", biddingType="
         + this.getBiddingType()
         + ", isCashDeposit="
         + this.getIsCashDeposit()
         + ", cashDeposit="
         + this.getCashDeposit()
         + ", bankAccountName="
         + this.getBankAccountName()
         + ", bankAccount="
         + this.getBankAccount()
         + ", depositBank="
         + this.getDepositBank()
         + ", contactPerson="
         + this.getContactPerson()
         + ", phone="
         + this.getPhone()
         + ", deliveryAddress="
         + this.getDeliveryAddress()
         + ", deliveryTime="
         + this.getDeliveryTime()
         + ", deliveryType="
         + this.getDeliveryType()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", bidDeadline="
         + this.getBidDeadline()
         + ", bidOpeningTime="
         + this.getBidOpeningTime()
         + ", supplierIds="
         + this.getSupplierIds()
         + ", subjectProjectDTOS="
         + this.getSubjectProjectDTOS()
         + ", remark="
         + this.getRemark()
         + ", tenderNoticeDTO="
         + this.getTenderNoticeDTO()
         + ")";
   }

   public ProjectTenderingDTO() {
   }

   public ProjectTenderingDTO(
      final Long id,
      final String name,
      final Integer projectType,
      final String contractNo,
      final Integer biddingType,
      final Integer isCashDeposit,
      final BigDecimal cashDeposit,
      final String bankAccountName,
      final String bankAccount,
      final String depositBank,
      final String contactPerson,
      final String phone,
      final String deliveryAddress,
      final Date deliveryTime,
      final Integer deliveryType,
      final Integer invoiceType,
      final Double taxRate,
      final Date bidDeadline,
      final Date bidOpeningTime,
      final List<Long> supplierIds,
      final List<SubjectProjectDTO> subjectProjectDTOS,
      final String remark,
      final TenderNoticeDTO tenderNoticeDTO
   ) {
      this.id = id;
      this.name = name;
      this.projectType = projectType;
      this.contractNo = contractNo;
      this.biddingType = biddingType;
      this.isCashDeposit = isCashDeposit;
      this.cashDeposit = cashDeposit;
      this.bankAccountName = bankAccountName;
      this.bankAccount = bankAccount;
      this.depositBank = depositBank;
      this.contactPerson = contactPerson;
      this.phone = phone;
      this.deliveryAddress = deliveryAddress;
      this.deliveryTime = deliveryTime;
      this.deliveryType = deliveryType;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.bidDeadline = bidDeadline;
      this.bidOpeningTime = bidOpeningTime;
      this.supplierIds = supplierIds;
      this.subjectProjectDTOS = subjectProjectDTOS;
      this.remark = remark;
      this.tenderNoticeDTO = tenderNoticeDTO;
   }

   public static class ProjectTenderingDTOBuilder {
      private Long id;
      private String name;
      private Integer projectType;
      private String contractNo;
      private Integer biddingType;
      private Integer isCashDeposit;
      private BigDecimal cashDeposit;
      private String bankAccountName;
      private String bankAccount;
      private String depositBank;
      private String contactPerson;
      private String phone;
      private String deliveryAddress;
      private Date deliveryTime;
      private Integer deliveryType;
      private Integer invoiceType;
      private Double taxRate;
      private Date bidDeadline;
      private Date bidOpeningTime;
      private List<Long> supplierIds;
      private List<SubjectProjectDTO> subjectProjectDTOS;
      private String remark;
      private TenderNoticeDTO tenderNoticeDTO;

      ProjectTenderingDTOBuilder() {
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder contractNo(final String contractNo) {
         this.contractNo = contractNo;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder biddingType(final Integer biddingType) {
         this.biddingType = biddingType;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder isCashDeposit(final Integer isCashDeposit) {
         this.isCashDeposit = isCashDeposit;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder cashDeposit(final BigDecimal cashDeposit) {
         this.cashDeposit = cashDeposit;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder bankAccountName(final String bankAccountName) {
         this.bankAccountName = bankAccountName;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder bankAccount(final String bankAccount) {
         this.bankAccount = bankAccount;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder depositBank(final String depositBank) {
         this.depositBank = depositBank;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder contactPerson(final String contactPerson) {
         this.contactPerson = contactPerson;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder deliveryAddress(final String deliveryAddress) {
         this.deliveryAddress = deliveryAddress;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder deliveryTime(final Date deliveryTime) {
         this.deliveryTime = deliveryTime;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder deliveryType(final Integer deliveryType) {
         this.deliveryType = deliveryType;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder taxRate(final Double taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder bidDeadline(final Date bidDeadline) {
         this.bidDeadline = bidDeadline;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder bidOpeningTime(final Date bidOpeningTime) {
         this.bidOpeningTime = bidOpeningTime;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder supplierIds(final List<Long> supplierIds) {
         this.supplierIds = supplierIds;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder subjectProjectDTOS(final List<SubjectProjectDTO> subjectProjectDTOS) {
         this.subjectProjectDTOS = subjectProjectDTOS;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectTenderingDTO.ProjectTenderingDTOBuilder tenderNoticeDTO(final TenderNoticeDTO tenderNoticeDTO) {
         this.tenderNoticeDTO = tenderNoticeDTO;
         return this;
      }

      public ProjectTenderingDTO build() {
         return new ProjectTenderingDTO(
            this.id,
            this.name,
            this.projectType,
            this.contractNo,
            this.biddingType,
            this.isCashDeposit,
            this.cashDeposit,
            this.bankAccountName,
            this.bankAccount,
            this.depositBank,
            this.contactPerson,
            this.phone,
            this.deliveryAddress,
            this.deliveryTime,
            this.deliveryType,
            this.invoiceType,
            this.taxRate,
            this.bidDeadline,
            this.bidOpeningTime,
            this.supplierIds,
            this.subjectProjectDTOS,
            this.remark,
            this.tenderNoticeDTO
         );
      }

      @Override
      public String toString() {
         return "ProjectTenderingDTO.ProjectTenderingDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", projectType="
            + this.projectType
            + ", contractNo="
            + this.contractNo
            + ", biddingType="
            + this.biddingType
            + ", isCashDeposit="
            + this.isCashDeposit
            + ", cashDeposit="
            + this.cashDeposit
            + ", bankAccountName="
            + this.bankAccountName
            + ", bankAccount="
            + this.bankAccount
            + ", depositBank="
            + this.depositBank
            + ", contactPerson="
            + this.contactPerson
            + ", phone="
            + this.phone
            + ", deliveryAddress="
            + this.deliveryAddress
            + ", deliveryTime="
            + this.deliveryTime
            + ", deliveryType="
            + this.deliveryType
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", bidDeadline="
            + this.bidDeadline
            + ", bidOpeningTime="
            + this.bidOpeningTime
            + ", supplierIds="
            + this.supplierIds
            + ", subjectProjectDTOS="
            + this.subjectProjectDTOS
            + ", remark="
            + this.remark
            + ", tenderNoticeDTO="
            + this.tenderNoticeDTO
            + ")";
      }
   }
}
