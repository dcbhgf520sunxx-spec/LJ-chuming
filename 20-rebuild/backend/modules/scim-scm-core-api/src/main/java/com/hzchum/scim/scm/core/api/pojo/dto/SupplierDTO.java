package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.scm.core.api.pojo.dto.scm.ScmSupplierConfigDTO;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;

public class SupplierDTO implements Serializable {
   private Long id;
   @ApiModelProperty(name = "name", notes = "供应商名称")
   private String name;
   private String shortName;
   @ApiModelProperty(name = "supplierCode", notes = "供应商编号")
   private String supplierNumber;
   @ApiModelProperty(name = "region", notes = "地区")
   private String area;
   @ApiModelProperty(name = "supplierClassification", notes = "供应商分类")
   private Integer supplierClassification;
   @ApiModelProperty(name = "enabled", notes = "是否隐藏")
   private Boolean enabled;
   private LocalDateTime createTime;
   @ApiModelProperty("分数评级")
   private String scoreRating;
   @ApiModelProperty("评价分类")
   ScmSupplierConfigDTO scmSupplierConfigDTO;

   public static SupplierDTO.SupplierDTOBuilder builder() {
      return new SupplierDTO.SupplierDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSupplierNumber() {
      return this.supplierNumber;
   }

   public String getArea() {
      return this.area;
   }

   public Integer getSupplierClassification() {
      return this.supplierClassification;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getScoreRating() {
      return this.scoreRating;
   }

   public ScmSupplierConfigDTO getScmSupplierConfigDTO() {
      return this.scmSupplierConfigDTO;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSupplierNumber(final String supplierNumber) {
      this.supplierNumber = supplierNumber;
   }

   public void setArea(final String area) {
      this.area = area;
   }

   public void setSupplierClassification(final Integer supplierClassification) {
      this.supplierClassification = supplierClassification;
   }

   public void setEnabled(final Boolean enabled) {
      this.enabled = enabled;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setScoreRating(final String scoreRating) {
      this.scoreRating = scoreRating;
   }

   public void setScmSupplierConfigDTO(final ScmSupplierConfigDTO scmSupplierConfigDTO) {
      this.scmSupplierConfigDTO = scmSupplierConfigDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierDTO)) {
         return false;
      }

      SupplierDTO other = (SupplierDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierClassification = this.getSupplierClassification();
         Object other$supplierClassification = other.getSupplierClassification();
         if (this$supplierClassification == null ? other$supplierClassification == null : this$supplierClassification.equals(other$supplierClassification)) {
            Object this$enabled = this.getEnabled();
            Object other$enabled = other.getEnabled();
            if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$supplierNumber = this.getSupplierNumber();
                     Object other$supplierNumber = other.getSupplierNumber();
                     if (this$supplierNumber == null ? other$supplierNumber == null : this$supplierNumber.equals(other$supplierNumber)) {
                        Object this$area = this.getArea();
                        Object other$area = other.getArea();
                        if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                           Object this$createTime = this.getCreateTime();
                           Object other$createTime = other.getCreateTime();
                           if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                              Object this$scoreRating = this.getScoreRating();
                              Object other$scoreRating = other.getScoreRating();
                              if (this$scoreRating == null ? other$scoreRating == null : this$scoreRating.equals(other$scoreRating)) {
                                 Object this$scmSupplierConfigDTO = this.getScmSupplierConfigDTO();
                                 Object other$scmSupplierConfigDTO = other.getScmSupplierConfigDTO();
                                 return this$scmSupplierConfigDTO == null
                                    ? other$scmSupplierConfigDTO == null
                                    : this$scmSupplierConfigDTO.equals(other$scmSupplierConfigDTO);
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
      return other instanceof SupplierDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierClassification = this.getSupplierClassification();
      result = result * 59 + ($supplierClassification == null ? 43 : $supplierClassification.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $supplierNumber = this.getSupplierNumber();
      result = result * 59 + ($supplierNumber == null ? 43 : $supplierNumber.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $scoreRating = this.getScoreRating();
      result = result * 59 + ($scoreRating == null ? 43 : $scoreRating.hashCode());
      Object $scmSupplierConfigDTO = this.getScmSupplierConfigDTO();
      return result * 59 + ($scmSupplierConfigDTO == null ? 43 : $scmSupplierConfigDTO.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", supplierNumber="
         + this.getSupplierNumber()
         + ", area="
         + this.getArea()
         + ", supplierClassification="
         + this.getSupplierClassification()
         + ", enabled="
         + this.getEnabled()
         + ", createTime="
         + this.getCreateTime()
         + ", scoreRating="
         + this.getScoreRating()
         + ", scmSupplierConfigDTO="
         + this.getScmSupplierConfigDTO()
         + ")";
   }

   public SupplierDTO(
      final Long id,
      final String name,
      final String shortName,
      final String supplierNumber,
      final String area,
      final Integer supplierClassification,
      final Boolean enabled,
      final LocalDateTime createTime,
      final String scoreRating,
      final ScmSupplierConfigDTO scmSupplierConfigDTO
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.supplierNumber = supplierNumber;
      this.area = area;
      this.supplierClassification = supplierClassification;
      this.enabled = enabled;
      this.createTime = createTime;
      this.scoreRating = scoreRating;
      this.scmSupplierConfigDTO = scmSupplierConfigDTO;
   }

   public SupplierDTO() {
   }

   public static class SupplierDTOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String supplierNumber;
      private String area;
      private Integer supplierClassification;
      private Boolean enabled;
      private LocalDateTime createTime;
      private String scoreRating;
      private ScmSupplierConfigDTO scmSupplierConfigDTO;

      SupplierDTOBuilder() {
      }

      public SupplierDTO.SupplierDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierDTO.SupplierDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SupplierDTO.SupplierDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public SupplierDTO.SupplierDTOBuilder supplierNumber(final String supplierNumber) {
         this.supplierNumber = supplierNumber;
         return this;
      }

      public SupplierDTO.SupplierDTOBuilder area(final String area) {
         this.area = area;
         return this;
      }

      public SupplierDTO.SupplierDTOBuilder supplierClassification(final Integer supplierClassification) {
         this.supplierClassification = supplierClassification;
         return this;
      }

      public SupplierDTO.SupplierDTOBuilder enabled(final Boolean enabled) {
         this.enabled = enabled;
         return this;
      }

      public SupplierDTO.SupplierDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public SupplierDTO.SupplierDTOBuilder scoreRating(final String scoreRating) {
         this.scoreRating = scoreRating;
         return this;
      }

      public SupplierDTO.SupplierDTOBuilder scmSupplierConfigDTO(final ScmSupplierConfigDTO scmSupplierConfigDTO) {
         this.scmSupplierConfigDTO = scmSupplierConfigDTO;
         return this;
      }

      public SupplierDTO build() {
         return new SupplierDTO(
            this.id,
            this.name,
            this.shortName,
            this.supplierNumber,
            this.area,
            this.supplierClassification,
            this.enabled,
            this.createTime,
            this.scoreRating,
            this.scmSupplierConfigDTO
         );
      }

      @Override
      public String toString() {
         return "SupplierDTO.SupplierDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", supplierNumber="
            + this.supplierNumber
            + ", area="
            + this.area
            + ", supplierClassification="
            + this.supplierClassification
            + ", enabled="
            + this.enabled
            + ", createTime="
            + this.createTime
            + ", scoreRating="
            + this.scoreRating
            + ", scmSupplierConfigDTO="
            + this.scmSupplierConfigDTO
            + ")";
      }
   }
}
