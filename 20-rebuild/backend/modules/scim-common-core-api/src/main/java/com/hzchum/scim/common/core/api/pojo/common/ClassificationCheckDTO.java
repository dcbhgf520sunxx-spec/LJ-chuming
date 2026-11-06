package com.hzchum.scim.common.core.api.pojo.common;

import java.util.Objects;

public class ClassificationCheckDTO {
   private Long classifyId;
   private String classifyName;
   private String classifySerialNumber;

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         ClassificationCheckDTO checkDTO = (ClassificationCheckDTO)o;
         return Objects.equals(this.classifyId, checkDTO.classifyId);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.classifyId);
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getClassifySerialNumber() {
      return this.classifySerialNumber;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setClassifySerialNumber(final String classifySerialNumber) {
      this.classifySerialNumber = classifySerialNumber;
   }

   @Override
   public String toString() {
      return "ClassificationCheckDTO(classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", classifySerialNumber="
         + this.getClassifySerialNumber()
         + ")";
   }
}
