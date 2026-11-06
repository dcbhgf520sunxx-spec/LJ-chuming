package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OutboundDO {
   private Long id;
   private String serialNumber;
   private String applicantName;
   private String basicClass;
   private String projectIds;
   private List<ProjectInfoDTO> projects;
   private BigDecimal amount;
   private BigDecimal amountExcludingVAT;
   private String outboundTime;
   private LocalDateTime reviewTime;
   private LocalDateTime applicantTime;
   private Long wapId;
   private BigDecimal mete;

   public static OutboundDO.OutboundDOBuilder builder() {
      return new OutboundDO.OutboundDOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getBasicClass() {
      return this.basicClass;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public List<ProjectInfoDTO> getProjects() {
      return this.projects;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public String getOutboundTime() {
      return this.outboundTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public LocalDateTime getApplicantTime() {
      return this.applicantTime;
   }

   public Long getWapId() {
      return this.wapId;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setBasicClass(final String basicClass) {
      this.basicClass = basicClass;
   }

   public void setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
   }

   public void setProjects(final List<ProjectInfoDTO> projects) {
      this.projects = projects;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setOutboundTime(final String outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setApplicantTime(final LocalDateTime applicantTime) {
      this.applicantTime = applicantTime;
   }

   public void setWapId(final Long wapId) {
      this.wapId = wapId;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundDO)) {
         return false;
      }

      OutboundDO other = (OutboundDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$wapId = this.getWapId();
         Object other$wapId = other.getWapId();
         if (this$wapId == null ? other$wapId == null : this$wapId.equals(other$wapId)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$applicantName = this.getApplicantName();
               Object other$applicantName = other.getApplicantName();
               if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$projectIds = this.getProjectIds();
                     Object other$projectIds = other.getProjectIds();
                     if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                        Object this$projects = this.getProjects();
                        Object other$projects = other.getProjects();
                        if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                           Object this$amount = this.getAmount();
                           Object other$amount = other.getAmount();
                           if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                              Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                              Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                              if (this$amountExcludingVAT == null ? other$amountExcludingVAT == null : this$amountExcludingVAT.equals(other$amountExcludingVAT)
                                 )
                               {
                                 Object this$outboundTime = this.getOutboundTime();
                                 Object other$outboundTime = other.getOutboundTime();
                                 if (this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime)) {
                                    Object this$reviewTime = this.getReviewTime();
                                    Object other$reviewTime = other.getReviewTime();
                                    if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                                       Object this$applicantTime = this.getApplicantTime();
                                       Object other$applicantTime = other.getApplicantTime();
                                       if (this$applicantTime == null ? other$applicantTime == null : this$applicantTime.equals(other$applicantTime)) {
                                          Object this$mete = this.getMete();
                                          Object other$mete = other.getMete();
                                          return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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
      return other instanceof OutboundDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $wapId = this.getWapId();
      result = result * 59 + ($wapId == null ? 43 : $wapId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $applicantTime = this.getApplicantTime();
      result = result * 59 + ($applicantTime == null ? 43 : $applicantTime.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundDO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicantName="
         + this.getApplicantName()
         + ", basicClass="
         + this.getBasicClass()
         + ", projectIds="
         + this.getProjectIds()
         + ", projects="
         + this.getProjects()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", applicantTime="
         + this.getApplicantTime()
         + ", wapId="
         + this.getWapId()
         + ", mete="
         + this.getMete()
         + ")";
   }

   public OutboundDO(
      final Long id,
      final String serialNumber,
      final String applicantName,
      final String basicClass,
      final String projectIds,
      final List<ProjectInfoDTO> projects,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final String outboundTime,
      final LocalDateTime reviewTime,
      final LocalDateTime applicantTime,
      final Long wapId,
      final BigDecimal mete
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.applicantName = applicantName;
      this.basicClass = basicClass;
      this.projectIds = projectIds;
      this.projects = projects;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.outboundTime = outboundTime;
      this.reviewTime = reviewTime;
      this.applicantTime = applicantTime;
      this.wapId = wapId;
      this.mete = mete;
   }

   public OutboundDO() {
   }

   public static class OutboundDOBuilder {
      private Long id;
      private String serialNumber;
      private String applicantName;
      private String basicClass;
      private String projectIds;
      private List<ProjectInfoDTO> projects;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private String outboundTime;
      private LocalDateTime reviewTime;
      private LocalDateTime applicantTime;
      private Long wapId;
      private BigDecimal mete;

      OutboundDOBuilder() {
      }

      public OutboundDO.OutboundDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OutboundDO.OutboundDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public OutboundDO.OutboundDOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public OutboundDO.OutboundDOBuilder basicClass(final String basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public OutboundDO.OutboundDOBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public OutboundDO.OutboundDOBuilder projects(final List<ProjectInfoDTO> projects) {
         this.projects = projects;
         return this;
      }

      public OutboundDO.OutboundDOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public OutboundDO.OutboundDOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public OutboundDO.OutboundDOBuilder outboundTime(final String outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public OutboundDO.OutboundDOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public OutboundDO.OutboundDOBuilder applicantTime(final LocalDateTime applicantTime) {
         this.applicantTime = applicantTime;
         return this;
      }

      public OutboundDO.OutboundDOBuilder wapId(final Long wapId) {
         this.wapId = wapId;
         return this;
      }

      public OutboundDO.OutboundDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public OutboundDO build() {
         return new OutboundDO(
            this.id,
            this.serialNumber,
            this.applicantName,
            this.basicClass,
            this.projectIds,
            this.projects,
            this.amount,
            this.amountExcludingVAT,
            this.outboundTime,
            this.reviewTime,
            this.applicantTime,
            this.wapId,
            this.mete
         );
      }

      @Override
      public String toString() {
         return "OutboundDO.OutboundDOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", applicantName="
            + this.applicantName
            + ", basicClass="
            + this.basicClass
            + ", projectIds="
            + this.projectIds
            + ", projects="
            + this.projects
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", outboundTime="
            + this.outboundTime
            + ", reviewTime="
            + this.reviewTime
            + ", applicantTime="
            + this.applicantTime
            + ", wapId="
            + this.wapId
            + ", mete="
            + this.mete
            + ")";
      }
   }
}
