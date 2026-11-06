package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SurplusDetailDTO {
   private Long id;
   private String workNumber;
   private Long workId;
   private String specification;
   private BigDecimal thickness;
   private BigDecimal area;
   private BigDecimal mete;
   private LocalDateTime createTime;
   private String workshopName;
   private Long workshopId;
   private String nestSurplusCode;
   private String imgUrl;
   private Boolean marking;

   public static SurplusDetailDTO.SurplusDetailDTOBuilder builder() {
      return new SurplusDetailDTO.SurplusDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getWorkNumber() {
      return this.workNumber;
   }

   public Long getWorkId() {
      return this.workId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public BigDecimal getMete() {
      return this.mete;
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

   public String getImgUrl() {
      return this.imgUrl;
   }

   public Boolean getMarking() {
      return this.marking;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setWorkNumber(final String workNumber) {
      this.workNumber = workNumber;
   }

   public void setWorkId(final Long workId) {
      this.workId = workId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setArea(final BigDecimal area) {
      this.area = area;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
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

   public void setImgUrl(final String imgUrl) {
      this.imgUrl = imgUrl;
   }

   public void setMarking(final Boolean marking) {
      this.marking = marking;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SurplusDetailDTO)) {
         return false;
      }

      SurplusDetailDTO other = (SurplusDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workId = this.getWorkId();
         Object other$workId = other.getWorkId();
         if (this$workId == null ? other$workId == null : this$workId.equals(other$workId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$marking = this.getMarking();
               Object other$marking = other.getMarking();
               if (this$marking == null ? other$marking == null : this$marking.equals(other$marking)) {
                  Object this$workNumber = this.getWorkNumber();
                  Object other$workNumber = other.getWorkNumber();
                  if (this$workNumber == null ? other$workNumber == null : this$workNumber.equals(other$workNumber)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$thickness = this.getThickness();
                        Object other$thickness = other.getThickness();
                        if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$mete = this.getMete();
                              Object other$mete = other.getMete();
                              if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                 Object this$createTime = this.getCreateTime();
                                 Object other$createTime = other.getCreateTime();
                                 if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                    Object this$workshopName = this.getWorkshopName();
                                    Object other$workshopName = other.getWorkshopName();
                                    if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                       Object this$nestSurplusCode = this.getNestSurplusCode();
                                       Object other$nestSurplusCode = other.getNestSurplusCode();
                                       if (this$nestSurplusCode == null ? other$nestSurplusCode == null : this$nestSurplusCode.equals(other$nestSurplusCode)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SurplusDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workId = this.getWorkId();
      result = result * 59 + ($workId == null ? 43 : $workId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $marking = this.getMarking();
      result = result * 59 + ($marking == null ? 43 : $marking.hashCode());
      Object $workNumber = this.getWorkNumber();
      result = result * 59 + ($workNumber == null ? 43 : $workNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $nestSurplusCode = this.getNestSurplusCode();
      result = result * 59 + ($nestSurplusCode == null ? 43 : $nestSurplusCode.hashCode());
      Object $imgUrl = this.getImgUrl();
      return result * 59 + ($imgUrl == null ? 43 : $imgUrl.hashCode());
   }

   @Override
   public String toString() {
      return "SurplusDetailDTO(id="
         + this.getId()
         + ", workNumber="
         + this.getWorkNumber()
         + ", workId="
         + this.getWorkId()
         + ", specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", area="
         + this.getArea()
         + ", mete="
         + this.getMete()
         + ", createTime="
         + this.getCreateTime()
         + ", workshopName="
         + this.getWorkshopName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", nestSurplusCode="
         + this.getNestSurplusCode()
         + ", imgUrl="
         + this.getImgUrl()
         + ", marking="
         + this.getMarking()
         + ")";
   }

   public SurplusDetailDTO(
      final Long id,
      final String workNumber,
      final Long workId,
      final String specification,
      final BigDecimal thickness,
      final BigDecimal area,
      final BigDecimal mete,
      final LocalDateTime createTime,
      final String workshopName,
      final Long workshopId,
      final String nestSurplusCode,
      final String imgUrl,
      final Boolean marking
   ) {
      this.id = id;
      this.workNumber = workNumber;
      this.workId = workId;
      this.specification = specification;
      this.thickness = thickness;
      this.area = area;
      this.mete = mete;
      this.createTime = createTime;
      this.workshopName = workshopName;
      this.workshopId = workshopId;
      this.nestSurplusCode = nestSurplusCode;
      this.imgUrl = imgUrl;
      this.marking = marking;
   }

   public SurplusDetailDTO() {
   }

   public static class SurplusDetailDTOBuilder {
      private Long id;
      private String workNumber;
      private Long workId;
      private String specification;
      private BigDecimal thickness;
      private BigDecimal area;
      private BigDecimal mete;
      private LocalDateTime createTime;
      private String workshopName;
      private Long workshopId;
      private String nestSurplusCode;
      private String imgUrl;
      private Boolean marking;

      SurplusDetailDTOBuilder() {
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder workNumber(final String workNumber) {
         this.workNumber = workNumber;
         return this;
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder workId(final Long workId) {
         this.workId = workId;
         return this;
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder nestSurplusCode(final String nestSurplusCode) {
         this.nestSurplusCode = nestSurplusCode;
         return this;
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder imgUrl(final String imgUrl) {
         this.imgUrl = imgUrl;
         return this;
      }

      public SurplusDetailDTO.SurplusDetailDTOBuilder marking(final Boolean marking) {
         this.marking = marking;
         return this;
      }

      public SurplusDetailDTO build() {
         return new SurplusDetailDTO(
            this.id,
            this.workNumber,
            this.workId,
            this.specification,
            this.thickness,
            this.area,
            this.mete,
            this.createTime,
            this.workshopName,
            this.workshopId,
            this.nestSurplusCode,
            this.imgUrl,
            this.marking
         );
      }

      @Override
      public String toString() {
         return "SurplusDetailDTO.SurplusDetailDTOBuilder(id="
            + this.id
            + ", workNumber="
            + this.workNumber
            + ", workId="
            + this.workId
            + ", specification="
            + this.specification
            + ", thickness="
            + this.thickness
            + ", area="
            + this.area
            + ", mete="
            + this.mete
            + ", createTime="
            + this.createTime
            + ", workshopName="
            + this.workshopName
            + ", workshopId="
            + this.workshopId
            + ", nestSurplusCode="
            + this.nestSurplusCode
            + ", imgUrl="
            + this.imgUrl
            + ", marking="
            + this.marking
            + ")";
      }
   }
}
