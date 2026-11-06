package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SteelDensityDTO {
   private Long id;
   @ApiModelProperty("基础分类")
   private Integer basicClass;
   @ApiModelProperty("科目ID")
   private Long classifyId;
   @ApiModelProperty("科目名称->全路径")
   private String classifyName;
   @ApiModelProperty("密度")
   private BigDecimal density;
   @ApiModelProperty("创建人")
   private String createBy;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty("更新人")
   private String updateBy;
   @ApiModelProperty("更新时间")
   private LocalDateTime updateTime;

   public static SteelDensityDTO.SteelDensityDTOBuilder builder() {
      return new SteelDensityDTO.SteelDensityDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public BigDecimal getDensity() {
      return this.density;
   }

   public String getCreateBy() {
      return this.createBy;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getUpdateBy() {
      return this.updateBy;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setDensity(final BigDecimal density) {
      this.density = density;
   }

   public void setCreateBy(final String createBy) {
      this.createBy = createBy;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateBy(final String updateBy) {
      this.updateBy = updateBy;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelDensityDTO)) {
         return false;
      }

      SteelDensityDTO other = (SteelDensityDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$classifyName = this.getClassifyName();
               Object other$classifyName = other.getClassifyName();
               if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                  Object this$density = this.getDensity();
                  Object other$density = other.getDensity();
                  if (this$density == null ? other$density == null : this$density.equals(other$density)) {
                     Object this$createBy = this.getCreateBy();
                     Object other$createBy = other.getCreateBy();
                     if (this$createBy == null ? other$createBy == null : this$createBy.equals(other$createBy)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$updateBy = this.getUpdateBy();
                           Object other$updateBy = other.getUpdateBy();
                           if (this$updateBy == null ? other$updateBy == null : this$updateBy.equals(other$updateBy)) {
                              Object this$updateTime = this.getUpdateTime();
                              Object other$updateTime = other.getUpdateTime();
                              return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
      return other instanceof SteelDensityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $density = this.getDensity();
      result = result * 59 + ($density == null ? 43 : $density.hashCode());
      Object $createBy = this.getCreateBy();
      result = result * 59 + ($createBy == null ? 43 : $createBy.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateBy = this.getUpdateBy();
      result = result * 59 + ($updateBy == null ? 43 : $updateBy.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "SteelDensityDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", density="
         + this.getDensity()
         + ", createBy="
         + this.getCreateBy()
         + ", createTime="
         + this.getCreateTime()
         + ", updateBy="
         + this.getUpdateBy()
         + ", updateTime="
         + this.getUpdateTime()
         + ")";
   }

   public SteelDensityDTO(
      final Long id,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final BigDecimal density,
      final String createBy,
      final LocalDateTime createTime,
      final String updateBy,
      final LocalDateTime updateTime
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.density = density;
      this.createBy = createBy;
      this.createTime = createTime;
      this.updateBy = updateBy;
      this.updateTime = updateTime;
   }

   public SteelDensityDTO() {
   }

   public static class SteelDensityDTOBuilder {
      private Long id;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private BigDecimal density;
      private String createBy;
      private LocalDateTime createTime;
      private String updateBy;
      private LocalDateTime updateTime;

      SteelDensityDTOBuilder() {
      }

      public SteelDensityDTO.SteelDensityDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SteelDensityDTO.SteelDensityDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SteelDensityDTO.SteelDensityDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public SteelDensityDTO.SteelDensityDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public SteelDensityDTO.SteelDensityDTOBuilder density(final BigDecimal density) {
         this.density = density;
         return this;
      }

      public SteelDensityDTO.SteelDensityDTOBuilder createBy(final String createBy) {
         this.createBy = createBy;
         return this;
      }

      public SteelDensityDTO.SteelDensityDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public SteelDensityDTO.SteelDensityDTOBuilder updateBy(final String updateBy) {
         this.updateBy = updateBy;
         return this;
      }

      public SteelDensityDTO.SteelDensityDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public SteelDensityDTO build() {
         return new SteelDensityDTO(
            this.id, this.basicClass, this.classifyId, this.classifyName, this.density, this.createBy, this.createTime, this.updateBy, this.updateTime
         );
      }

      @Override
      public String toString() {
         return "SteelDensityDTO.SteelDensityDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", density="
            + this.density
            + ", createBy="
            + this.createBy
            + ", createTime="
            + this.createTime
            + ", updateBy="
            + this.updateBy
            + ", updateTime="
            + this.updateTime
            + ")";
      }
   }
}
