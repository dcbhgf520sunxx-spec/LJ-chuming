package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AppInboundDetailDTO {
   private Long id;
   private Long inboundId;
   private String specification;
   private BigDecimal thickness;
   private String applicantName;
   private BigDecimal area;
   private Integer nestType;
   private LocalDateTime createTime;
   private String workshopName;
   private Long workshopId;
   private String nestSurplusCode;
   private Long classifyId;
   private String classifyName;
   private String mete;
   private Integer reviewStatus;
   private String dxfUrl;
   private String imgUrl;

   public static AppInboundDetailDTO.AppInboundDetailDTOBuilder builder() {
      return new AppInboundDetailDTO.AppInboundDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public Integer getNestType() {
      return this.nestType;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getNestSurplusCode() {
      return this.nestSurplusCode;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getMete() {
      return this.mete;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getDxfUrl() {
      return this.dxfUrl;
   }

   public String getImgUrl() {
      return this.imgUrl;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setArea(final BigDecimal area) {
      this.area = area;
   }

   public void setNestType(final Integer nestType) {
      this.nestType = nestType;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setNestSurplusCode(final String nestSurplusCode) {
      this.nestSurplusCode = nestSurplusCode;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setMete(final String mete) {
      this.mete = mete;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setDxfUrl(final String dxfUrl) {
      this.dxfUrl = dxfUrl;
   }

   public void setImgUrl(final String imgUrl) {
      this.imgUrl = imgUrl;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppInboundDetailDTO)) {
         return false;
      }

      AppInboundDetailDTO other = (AppInboundDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inboundId = this.getInboundId();
         Object other$inboundId = other.getInboundId();
         if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
            Object this$nestType = this.getNestType();
            Object other$nestType = other.getNestType();
            if (this$nestType == null ? other$nestType == null : this$nestType.equals(other$nestType)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$classifyId = this.getClassifyId();
                  Object other$classifyId = other.getClassifyId();
                  if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                     Object this$reviewStatus = this.getReviewStatus();
                     Object other$reviewStatus = other.getReviewStatus();
                     if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$thickness = this.getThickness();
                           Object other$thickness = other.getThickness();
                           if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                              Object this$applicantName = this.getApplicantName();
                              Object other$applicantName = other.getApplicantName();
                              if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                 Object this$area = this.getArea();
                                 Object other$area = other.getArea();
                                 if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                    Object this$createTime = this.getCreateTime();
                                    Object other$createTime = other.getCreateTime();
                                    if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                       Object this$workshopName = this.getWorkshopName();
                                       Object other$workshopName = other.getWorkshopName();
                                       if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                          Object this$nestSurplusCode = this.getNestSurplusCode();
                                          Object other$nestSurplusCode = other.getNestSurplusCode();
                                          if (this$nestSurplusCode == null ? other$nestSurplusCode == null : this$nestSurplusCode.equals(other$nestSurplusCode)
                                             )
                                           {
                                             Object this$classifyName = this.getClassifyName();
                                             Object other$classifyName = other.getClassifyName();
                                             if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                                Object this$mete = this.getMete();
                                                Object other$mete = other.getMete();
                                                if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                   Object this$dxfUrl = this.getDxfUrl();
                                                   Object other$dxfUrl = other.getDxfUrl();
                                                   if (this$dxfUrl == null ? other$dxfUrl == null : this$dxfUrl.equals(other$dxfUrl)) {
                                                      Object this$imgUrl = this.getImgUrl();
                                                      Object other$imgUrl = other.getImgUrl();
                                                      return this$imgUrl == null ? other$imgUrl == null : this$imgUrl.equals(other$imgUrl);
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
      return other instanceof AppInboundDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $nestType = this.getNestType();
      result = result * 59 + ($nestType == null ? 43 : $nestType.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $nestSurplusCode = this.getNestSurplusCode();
      result = result * 59 + ($nestSurplusCode == null ? 43 : $nestSurplusCode.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $dxfUrl = this.getDxfUrl();
      result = result * 59 + ($dxfUrl == null ? 43 : $dxfUrl.hashCode());
      Object $imgUrl = this.getImgUrl();
      return result * 59 + ($imgUrl == null ? 43 : $imgUrl.hashCode());
   }

   @Override
   public String toString() {
      return "AppInboundDetailDTO(id="
         + this.getId()
         + ", inboundId="
         + this.getInboundId()
         + ", specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", applicantName="
         + this.getApplicantName()
         + ", area="
         + this.getArea()
         + ", nestType="
         + this.getNestType()
         + ", createTime="
         + this.getCreateTime()
         + ", workshopName="
         + this.getWorkshopName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", nestSurplusCode="
         + this.getNestSurplusCode()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", mete="
         + this.getMete()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", dxfUrl="
         + this.getDxfUrl()
         + ", imgUrl="
         + this.getImgUrl()
         + ")";
   }

   public AppInboundDetailDTO(
      final Long id,
      final Long inboundId,
      final String specification,
      final BigDecimal thickness,
      final String applicantName,
      final BigDecimal area,
      final Integer nestType,
      final LocalDateTime createTime,
      final String workshopName,
      final Long workshopId,
      final String nestSurplusCode,
      final Long classifyId,
      final String classifyName,
      final String mete,
      final Integer reviewStatus,
      final String dxfUrl,
      final String imgUrl
   ) {
      this.id = id;
      this.inboundId = inboundId;
      this.specification = specification;
      this.thickness = thickness;
      this.applicantName = applicantName;
      this.area = area;
      this.nestType = nestType;
      this.createTime = createTime;
      this.workshopName = workshopName;
      this.workshopId = workshopId;
      this.nestSurplusCode = nestSurplusCode;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.mete = mete;
      this.reviewStatus = reviewStatus;
      this.dxfUrl = dxfUrl;
      this.imgUrl = imgUrl;
   }

   public AppInboundDetailDTO() {
   }

   public static class AppInboundDetailDTOBuilder {
      private Long id;
      private Long inboundId;
      private String specification;
      private BigDecimal thickness;
      private String applicantName;
      private BigDecimal area;
      private Integer nestType;
      private LocalDateTime createTime;
      private String workshopName;
      private Long workshopId;
      private String nestSurplusCode;
      private Long classifyId;
      private String classifyName;
      private String mete;
      private Integer reviewStatus;
      private String dxfUrl;
      private String imgUrl;

      AppInboundDetailDTOBuilder() {
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder nestType(final Integer nestType) {
         this.nestType = nestType;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder nestSurplusCode(final String nestSurplusCode) {
         this.nestSurplusCode = nestSurplusCode;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder mete(final String mete) {
         this.mete = mete;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder dxfUrl(final String dxfUrl) {
         this.dxfUrl = dxfUrl;
         return this;
      }

      public AppInboundDetailDTO.AppInboundDetailDTOBuilder imgUrl(final String imgUrl) {
         this.imgUrl = imgUrl;
         return this;
      }

      public AppInboundDetailDTO build() {
         return new AppInboundDetailDTO(
            this.id,
            this.inboundId,
            this.specification,
            this.thickness,
            this.applicantName,
            this.area,
            this.nestType,
            this.createTime,
            this.workshopName,
            this.workshopId,
            this.nestSurplusCode,
            this.classifyId,
            this.classifyName,
            this.mete,
            this.reviewStatus,
            this.dxfUrl,
            this.imgUrl
         );
      }

      @Override
      public String toString() {
         return "AppInboundDetailDTO.AppInboundDetailDTOBuilder(id="
            + this.id
            + ", inboundId="
            + this.inboundId
            + ", specification="
            + this.specification
            + ", thickness="
            + this.thickness
            + ", applicantName="
            + this.applicantName
            + ", area="
            + this.area
            + ", nestType="
            + this.nestType
            + ", createTime="
            + this.createTime
            + ", workshopName="
            + this.workshopName
            + ", workshopId="
            + this.workshopId
            + ", nestSurplusCode="
            + this.nestSurplusCode
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", mete="
            + this.mete
            + ", reviewStatus="
            + this.reviewStatus
            + ", dxfUrl="
            + this.dxfUrl
            + ", imgUrl="
            + this.imgUrl
            + ")";
      }
   }
}
