package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReceiveOutboundDetailDTO {
   private Long id;
   private Long projectId;
   private BigDecimal mete;
   private String recipientName;
   private String workShop;
   private String applicantName;
   private LocalDateTime createTime;
   private Integer basicClass;
   private Integer classifyId;
   private String specification;
   private BigDecimal quantity;
   private String type;

   public static ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder builder() {
      return new ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder();
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

   public String getRecipientName() {
      return this.recipientName;
   }

   public String getWorkShop() {
      return this.workShop;
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

   public String getType() {
      return this.type;
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

   public void setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
   }

   public void setWorkShop(final String workShop) {
      this.workShop = workShop;
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

   public void setType(final String type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReceiveOutboundDetailDTO)) {
         return false;
      }

      ReceiveOutboundDetailDTO other = (ReceiveOutboundDetailDTO)o;
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
                     Object this$recipientName = this.getRecipientName();
                     Object other$recipientName = other.getRecipientName();
                     if (this$recipientName == null ? other$recipientName == null : this$recipientName.equals(other$recipientName)) {
                        Object this$workShop = this.getWorkShop();
                        Object other$workShop = other.getWorkShop();
                        if (this$workShop == null ? other$workShop == null : this$workShop.equals(other$workShop)) {
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
                                    if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                       Object this$type = this.getType();
                                       Object other$type = other.getType();
                                       return this$type == null ? other$type == null : this$type.equals(other$type);
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
      return other instanceof ReceiveOutboundDetailDTO;
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
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $workShop = this.getWorkShop();
      result = result * 59 + ($workShop == null ? 43 : $workShop.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "ReceiveOutboundDetailDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", mete="
         + this.getMete()
         + ", recipientName="
         + this.getRecipientName()
         + ", workShop="
         + this.getWorkShop()
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
         + ", type="
         + this.getType()
         + ")";
   }

   public ReceiveOutboundDetailDTO(
      final Long id,
      final Long projectId,
      final BigDecimal mete,
      final String recipientName,
      final String workShop,
      final String applicantName,
      final LocalDateTime createTime,
      final Integer basicClass,
      final Integer classifyId,
      final String specification,
      final BigDecimal quantity,
      final String type
   ) {
      this.id = id;
      this.projectId = projectId;
      this.mete = mete;
      this.recipientName = recipientName;
      this.workShop = workShop;
      this.applicantName = applicantName;
      this.createTime = createTime;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.specification = specification;
      this.quantity = quantity;
      this.type = type;
   }

   public ReceiveOutboundDetailDTO() {
   }

   public static class ReceiveOutboundDetailDTOBuilder {
      private Long id;
      private Long projectId;
      private BigDecimal mete;
      private String recipientName;
      private String workShop;
      private String applicantName;
      private LocalDateTime createTime;
      private Integer basicClass;
      private Integer classifyId;
      private String specification;
      private BigDecimal quantity;
      private String type;

      ReceiveOutboundDetailDTOBuilder() {
      }

      public ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      public ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder workShop(final String workShop) {
         this.workShop = workShop;
         return this;
      }

      public ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder classifyId(final Integer classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public ReceiveOutboundDetailDTO build() {
         return new ReceiveOutboundDetailDTO(
            this.id,
            this.projectId,
            this.mete,
            this.recipientName,
            this.workShop,
            this.applicantName,
            this.createTime,
            this.basicClass,
            this.classifyId,
            this.specification,
            this.quantity,
            this.type
         );
      }

      @Override
      public String toString() {
         return "ReceiveOutboundDetailDTO.ReceiveOutboundDetailDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", mete="
            + this.mete
            + ", recipientName="
            + this.recipientName
            + ", workShop="
            + this.workShop
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
            + ", type="
            + this.type
            + ")";
      }
   }
}
