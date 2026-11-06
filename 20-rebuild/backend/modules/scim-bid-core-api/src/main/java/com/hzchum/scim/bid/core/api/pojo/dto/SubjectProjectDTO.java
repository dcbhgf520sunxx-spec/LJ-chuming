package com.hzchum.scim.bid.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.UpdateBatch;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SubjectProjectDTO {
   @NotNull(message = "科目id不能为空", groups = {Add.class, UpdateBatch.class})
   private Long subjectId;
   @NotBlank(message = "科目单位不能为空", groups = {Add.class, UpdateBatch.class})
   private String unitName;
   @NotBlank(message = "规格不能为空", groups = {Add.class, UpdateBatch.class})
   private String specification;
   @NotBlank(message = "型号不能为空", groups = {Add.class, UpdateBatch.class})
   private String modelNumber;
   @NotNull(message = "采购量不能为空", groups = {Add.class, UpdateBatch.class})
   @Min(value = 1L, message = "采购量不能小于等于0", groups = {Add.class, UpdateBatch.class})
   private Double mete;
   private String remark;

   public Long getSubjectId() {
      return this.subjectId;
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

   public void setSubjectId(final Long subjectId) {
      this.subjectId = subjectId;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubjectProjectDTO)) {
         return false;
      }

      SubjectProjectDTO other = (SubjectProjectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$subjectId = this.getSubjectId();
      Object other$subjectId = other.getSubjectId();
      if (this$subjectId == null ? other$subjectId == null : this$subjectId.equals(other$subjectId)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
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
                     return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof SubjectProjectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $subjectId = this.getSubjectId();
      result = result * 59 + ($subjectId == null ? 43 : $subjectId.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitName = this.getUnitName();
      result = result * 59 + ($unitName == null ? 43 : $unitName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $modelNumber = this.getModelNumber();
      result = result * 59 + ($modelNumber == null ? 43 : $modelNumber.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SubjectProjectDTO(subjectId="
         + this.getSubjectId()
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
         + ")";
   }
}
