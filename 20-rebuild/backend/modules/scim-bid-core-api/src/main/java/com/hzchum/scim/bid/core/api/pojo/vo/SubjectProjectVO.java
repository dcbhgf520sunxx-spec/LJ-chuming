package com.hzchum.scim.bid.core.api.pojo.vo;

import java.math.BigDecimal;

public class SubjectProjectVO {
   private Long id;
   private Long subjectId;
   private String subjectNames;
   private String subjectName;
   private String unitName;
   private String specification;
   private String modelNumber;
   private Double mete;
   private String remark;
   private Integer round;
   private Long supplierId;
   private String supplierName;
   private String contactPerson;
   private String contactPhone;
   private BigDecimal unitPrice;
   private BigDecimal bidAmount;
   private Integer tickSizeNum;
   private Integer status;
   private BigDecimal contrastSubjectAmount;
   private BigDecimal previousRoundUnitPrice;
   private Integer isFollow;

   public Long getId() {
      return this.id;
   }

   public Long getSubjectId() {
      return this.subjectId;
   }

   public String getSubjectNames() {
      return this.subjectNames;
   }

   public String getSubjectName() {
      return this.subjectName;
   }

   public String getUnitName() {
      return this.unitName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getModelNumber() {
      return this.modelNumber;
   }

   public Double getMete() {
      return this.mete;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getRound() {
      return this.round;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getContactPerson() {
      return this.contactPerson;
   }

   public String getContactPhone() {
      return this.contactPhone;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getBidAmount() {
      return this.bidAmount;
   }

   public Integer getTickSizeNum() {
      return this.tickSizeNum;
   }

   public Integer getStatus() {
      return this.status;
   }

   public BigDecimal getContrastSubjectAmount() {
      return this.contrastSubjectAmount;
   }

   public BigDecimal getPreviousRoundUnitPrice() {
      return this.previousRoundUnitPrice;
   }

   public Integer getIsFollow() {
      return this.isFollow;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSubjectId(final Long subjectId) {
      this.subjectId = subjectId;
   }

   public void setSubjectNames(final String subjectNames) {
      this.subjectNames = subjectNames;
   }

   public void setSubjectName(final String subjectName) {
      this.subjectName = subjectName;
   }

   public void setUnitName(final String unitName) {
      this.unitName = unitName;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setModelNumber(final String modelNumber) {
      this.modelNumber = modelNumber;
   }

   public void setMete(final Double mete) {
      this.mete = mete;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setRound(final Integer round) {
      this.round = round;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setContactPerson(final String contactPerson) {
      this.contactPerson = contactPerson;
   }

   public void setContactPhone(final String contactPhone) {
      this.contactPhone = contactPhone;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setBidAmount(final BigDecimal bidAmount) {
      this.bidAmount = bidAmount;
   }

   public void setTickSizeNum(final Integer tickSizeNum) {
      this.tickSizeNum = tickSizeNum;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setContrastSubjectAmount(final BigDecimal contrastSubjectAmount) {
      this.contrastSubjectAmount = contrastSubjectAmount;
   }

   public void setPreviousRoundUnitPrice(final BigDecimal previousRoundUnitPrice) {
      this.previousRoundUnitPrice = previousRoundUnitPrice;
   }

   public void setIsFollow(final Integer isFollow) {
      this.isFollow = isFollow;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubjectProjectVO)) {
         return false;
      }

      SubjectProjectVO other = (SubjectProjectVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$subjectId = this.getSubjectId();
         Object other$subjectId = other.getSubjectId();
         if (this$subjectId == null ? other$subjectId == null : this$subjectId.equals(other$subjectId)) {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
               Object this$round = this.getRound();
               Object other$round = other.getRound();
               if (this$round == null ? other$round == null : this$round.equals(other$round)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$tickSizeNum = this.getTickSizeNum();
                     Object other$tickSizeNum = other.getTickSizeNum();
                     if (this$tickSizeNum == null ? other$tickSizeNum == null : this$tickSizeNum.equals(other$tickSizeNum)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$isFollow = this.getIsFollow();
                           Object other$isFollow = other.getIsFollow();
                           if (this$isFollow == null ? other$isFollow == null : this$isFollow.equals(other$isFollow)) {
                              Object this$subjectNames = this.getSubjectNames();
                              Object other$subjectNames = other.getSubjectNames();
                              if (this$subjectNames == null ? other$subjectNames == null : this$subjectNames.equals(other$subjectNames)) {
                                 Object this$subjectName = this.getSubjectName();
                                 Object other$subjectName = other.getSubjectName();
                                 if (this$subjectName == null ? other$subjectName == null : this$subjectName.equals(other$subjectName)) {
                                    Object this$unitName = this.getUnitName();
                                    Object other$unitName = other.getUnitName();
                                    if (this$unitName == null ? other$unitName == null : this$unitName.equals(other$unitName)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                          Object this$modelNumber = this.getModelNumber();
                                          Object other$modelNumber = other.getModelNumber();
                                          if (this$modelNumber == null ? other$modelNumber == null : this$modelNumber.equals(other$modelNumber)) {
                                             Object this$remark = this.getRemark();
                                             Object other$remark = other.getRemark();
                                             if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                Object this$supplierName = this.getSupplierName();
                                                Object other$supplierName = other.getSupplierName();
                                                if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                                   Object this$contactPerson = this.getContactPerson();
                                                   Object other$contactPerson = other.getContactPerson();
                                                   if (this$contactPerson == null
                                                      ? other$contactPerson == null
                                                      : this$contactPerson.equals(other$contactPerson)) {
                                                      Object this$contactPhone = this.getContactPhone();
                                                      Object other$contactPhone = other.getContactPhone();
                                                      if (this$contactPhone == null ? other$contactPhone == null : this$contactPhone.equals(other$contactPhone)
                                                         )
                                                       {
                                                         Object this$unitPrice = this.getUnitPrice();
                                                         Object other$unitPrice = other.getUnitPrice();
                                                         if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                            Object this$bidAmount = this.getBidAmount();
                                                            Object other$bidAmount = other.getBidAmount();
                                                            if (this$bidAmount == null ? other$bidAmount == null : this$bidAmount.equals(other$bidAmount)) {
                                                               Object this$contrastSubjectAmount = this.getContrastSubjectAmount();
                                                               Object other$contrastSubjectAmount = other.getContrastSubjectAmount();
                                                               if (this$contrastSubjectAmount == null
                                                                  ? other$contrastSubjectAmount == null
                                                                  : this$contrastSubjectAmount.equals(other$contrastSubjectAmount)) {
                                                                  Object this$previousRoundUnitPrice = this.getPreviousRoundUnitPrice();
                                                                  Object other$previousRoundUnitPrice = other.getPreviousRoundUnitPrice();
                                                                  return this$previousRoundUnitPrice == null
                                                                     ? other$previousRoundUnitPrice == null
                                                                     : this$previousRoundUnitPrice.equals(other$previousRoundUnitPrice);
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
      return other instanceof SubjectProjectVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $subjectId = this.getSubjectId();
      result = result * 59 + ($subjectId == null ? 43 : $subjectId.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $round = this.getRound();
      result = result * 59 + ($round == null ? 43 : $round.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $tickSizeNum = this.getTickSizeNum();
      result = result * 59 + ($tickSizeNum == null ? 43 : $tickSizeNum.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $isFollow = this.getIsFollow();
      result = result * 59 + ($isFollow == null ? 43 : $isFollow.hashCode());
      Object $subjectNames = this.getSubjectNames();
      result = result * 59 + ($subjectNames == null ? 43 : $subjectNames.hashCode());
      Object $subjectName = this.getSubjectName();
      result = result * 59 + ($subjectName == null ? 43 : $subjectName.hashCode());
      Object $unitName = this.getUnitName();
      result = result * 59 + ($unitName == null ? 43 : $unitName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $modelNumber = this.getModelNumber();
      result = result * 59 + ($modelNumber == null ? 43 : $modelNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $contactPerson = this.getContactPerson();
      result = result * 59 + ($contactPerson == null ? 43 : $contactPerson.hashCode());
      Object $contactPhone = this.getContactPhone();
      result = result * 59 + ($contactPhone == null ? 43 : $contactPhone.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $bidAmount = this.getBidAmount();
      result = result * 59 + ($bidAmount == null ? 43 : $bidAmount.hashCode());
      Object $contrastSubjectAmount = this.getContrastSubjectAmount();
      result = result * 59 + ($contrastSubjectAmount == null ? 43 : $contrastSubjectAmount.hashCode());
      Object $previousRoundUnitPrice = this.getPreviousRoundUnitPrice();
      return result * 59 + ($previousRoundUnitPrice == null ? 43 : $previousRoundUnitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "SubjectProjectVO(id="
         + this.getId()
         + ", subjectId="
         + this.getSubjectId()
         + ", subjectNames="
         + this.getSubjectNames()
         + ", subjectName="
         + this.getSubjectName()
         + ", unitName="
         + this.getUnitName()
         + ", specification="
         + this.getSpecification()
         + ", modelNumber="
         + this.getModelNumber()
         + ", mete="
         + this.getMete()
         + ", remark="
         + this.getRemark()
         + ", round="
         + this.getRound()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", contactPerson="
         + this.getContactPerson()
         + ", contactPhone="
         + this.getContactPhone()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", bidAmount="
         + this.getBidAmount()
         + ", tickSizeNum="
         + this.getTickSizeNum()
         + ", status="
         + this.getStatus()
         + ", contrastSubjectAmount="
         + this.getContrastSubjectAmount()
         + ", previousRoundUnitPrice="
         + this.getPreviousRoundUnitPrice()
         + ", isFollow="
         + this.getIsFollow()
         + ")";
   }
}
