package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReceiveReturnDetailDTO {
   private Long id;
   private Long projectId;
   private BigDecimal mete;
   private String applicantName;
   private LocalDateTime createTime;
   private Integer basicClass;
   private Integer classifyId;
   private String specification;
   private BigDecimal quantity;

   public static ReceiveReturnDetailDTO.ReceiveReturnDetailDTOBuilder builder() {
      return new ReceiveReturnDetailDTO.ReceiveReturnDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getClassifyId() {
      return this.classifyId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final Integer classifyId) {
      this.classifyId = classifyId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReceiveReturnDetailDTO)) {
         return false;
      }

      ReceiveReturnDetailDTO other = (ReceiveReturnDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$applicantName = this.getApplicantName();
                     Object other$applicantName = other.getApplicantName();
                     if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof ReceiveReturnDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "ReceiveReturnDetailDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", mete="
         + this.getMete()
         + ", applicantName="
         + this.getApplicantName()
         + ", createTime="
         + this.getCreateTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   public ReceiveReturnDetailDTO(
      final Long id,
      final Long projectId,
      final BigDecimal mete,
      final String applicantName,
      final LocalDateTime createTime,
      final Integer basicClass,
      final Integer classifyId,
      final String specification,
      final BigDecimal quantity
   ) {
      this.id = id;
      this.projectId = projectId;
      this.mete = mete;
      this.applicantName = applicantName;
      this.createTime = createTime;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.specification = specification;
      this.quantity = quantity;
   }

   public ReceiveReturnDetailDTO() {
   }

   public static class ReceiveReturnDetailDTOBuilder {
      private Long id;
      private Long projectId;
      private BigDecimal mete;
      private String applicantName;
      private LocalDateTime createTime;
      private Integer basicClass;
      private Integer classifyId;
      private String specification;
      private BigDecimal quantity;

      ReceiveReturnDetailDTOBuilder() {
      }

      public ReceiveReturnDetailDTO.ReceiveReturnDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReceiveReturnDetailDTO.ReceiveReturnDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ReceiveReturnDetailDTO.ReceiveReturnDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ReceiveReturnDetailDTO.ReceiveReturnDetailDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ReceiveReturnDetailDTO.ReceiveReturnDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ReceiveReturnDetailDTO.ReceiveReturnDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ReceiveReturnDetailDTO.ReceiveReturnDetailDTOBuilder classifyId(final Integer classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ReceiveReturnDetailDTO.ReceiveReturnDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ReceiveReturnDetailDTO.ReceiveReturnDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ReceiveReturnDetailDTO build() {
         return new ReceiveReturnDetailDTO(
            this.id, this.projectId, this.mete, this.applicantName, this.createTime, this.basicClass, this.classifyId, this.specification, this.quantity
         );
      }

      @Override
      public String toString() {
         return "ReceiveReturnDetailDTO.ReceiveReturnDetailDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", mete="
            + this.mete
            + ", applicantName="
            + this.applicantName
            + ", createTime="
            + this.createTime
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
