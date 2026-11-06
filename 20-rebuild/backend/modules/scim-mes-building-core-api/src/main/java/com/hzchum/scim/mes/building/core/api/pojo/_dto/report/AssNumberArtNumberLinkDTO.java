package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssNumberArtNumberLinkDTO", description = "部件码号关联构件码号信息 ")
public class AssNumberArtNumberLinkDTO {
   @ApiModelProperty(name = "assId", value = "主键ID")
   private Long assId;
   @ApiModelProperty(name = "assNumber", value = "部件码号")
   private Integer assNumber;
   @ApiModelProperty(name = "artId", value = "构件id")
   private Long artId;
   @ApiModelProperty(name = "artNumber", value = "构件码号")
   private Integer artNumber;
   @ApiModelProperty(name = "artSerialNumber", value = "构件编号")
   private String artSerialNumber;

   public static AssNumberArtNumberLinkDTO.AssNumberArtNumberLinkDTOBuilder builder() {
      return new AssNumberArtNumberLinkDTO.AssNumberArtNumberLinkDTOBuilder();
   }

   public AssNumberArtNumberLinkDTO() {
   }

   public AssNumberArtNumberLinkDTO(final Long assId, final Integer assNumber, final Long artId, final Integer artNumber, final String artSerialNumber) {
      this.assId = assId;
      this.assNumber = assNumber;
      this.artId = artId;
      this.artNumber = artNumber;
      this.artSerialNumber = artSerialNumber;
   }

   public Long getAssId() {
      return this.assId;
   }

   public Integer getAssNumber() {
      return this.assNumber;
   }

   public Long getArtId() {
      return this.artId;
   }

   public Integer getArtNumber() {
      return this.artNumber;
   }

   public String getArtSerialNumber() {
      return this.artSerialNumber;
   }

   public AssNumberArtNumberLinkDTO setAssId(final Long assId) {
      this.assId = assId;
      return this;
   }

   public AssNumberArtNumberLinkDTO setAssNumber(final Integer assNumber) {
      this.assNumber = assNumber;
      return this;
   }

   public AssNumberArtNumberLinkDTO setArtId(final Long artId) {
      this.artId = artId;
      return this;
   }

   public AssNumberArtNumberLinkDTO setArtNumber(final Integer artNumber) {
      this.artNumber = artNumber;
      return this;
   }

   public AssNumberArtNumberLinkDTO setArtSerialNumber(final String artSerialNumber) {
      this.artSerialNumber = artSerialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "AssNumberArtNumberLinkDTO(assId="
         + this.getAssId()
         + ", assNumber="
         + this.getAssNumber()
         + ", artId="
         + this.getArtId()
         + ", artNumber="
         + this.getArtNumber()
         + ", artSerialNumber="
         + this.getArtSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssNumberArtNumberLinkDTO)) {
         return false;
      }

      AssNumberArtNumberLinkDTO other = (AssNumberArtNumberLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$assId = this.getAssId();
      Object other$assId = other.getAssId();
      if (this$assId == null ? other$assId == null : this$assId.equals(other$assId)) {
         Object this$assNumber = this.getAssNumber();
         Object other$assNumber = other.getAssNumber();
         if (this$assNumber == null ? other$assNumber == null : this$assNumber.equals(other$assNumber)) {
            Object this$artId = this.getArtId();
            Object other$artId = other.getArtId();
            if (this$artId == null ? other$artId == null : this$artId.equals(other$artId)) {
               Object this$artNumber = this.getArtNumber();
               Object other$artNumber = other.getArtNumber();
               if (this$artNumber == null ? other$artNumber == null : this$artNumber.equals(other$artNumber)) {
                  Object this$artSerialNumber = this.getArtSerialNumber();
                  Object other$artSerialNumber = other.getArtSerialNumber();
                  return this$artSerialNumber == null ? other$artSerialNumber == null : this$artSerialNumber.equals(other$artSerialNumber);
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
      return other instanceof AssNumberArtNumberLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $assId = this.getAssId();
      result = result * 59 + ($assId == null ? 43 : $assId.hashCode());
      Object $assNumber = this.getAssNumber();
      result = result * 59 + ($assNumber == null ? 43 : $assNumber.hashCode());
      Object $artId = this.getArtId();
      result = result * 59 + ($artId == null ? 43 : $artId.hashCode());
      Object $artNumber = this.getArtNumber();
      result = result * 59 + ($artNumber == null ? 43 : $artNumber.hashCode());
      Object $artSerialNumber = this.getArtSerialNumber();
      return result * 59 + ($artSerialNumber == null ? 43 : $artSerialNumber.hashCode());
   }

   public static class AssNumberArtNumberLinkDTOBuilder {
      private Long assId;
      private Integer assNumber;
      private Long artId;
      private Integer artNumber;
      private String artSerialNumber;

      AssNumberArtNumberLinkDTOBuilder() {
      }

      public AssNumberArtNumberLinkDTO.AssNumberArtNumberLinkDTOBuilder assId(final Long assId) {
         this.assId = assId;
         return this;
      }

      public AssNumberArtNumberLinkDTO.AssNumberArtNumberLinkDTOBuilder assNumber(final Integer assNumber) {
         this.assNumber = assNumber;
         return this;
      }

      public AssNumberArtNumberLinkDTO.AssNumberArtNumberLinkDTOBuilder artId(final Long artId) {
         this.artId = artId;
         return this;
      }

      public AssNumberArtNumberLinkDTO.AssNumberArtNumberLinkDTOBuilder artNumber(final Integer artNumber) {
         this.artNumber = artNumber;
         return this;
      }

      public AssNumberArtNumberLinkDTO.AssNumberArtNumberLinkDTOBuilder artSerialNumber(final String artSerialNumber) {
         this.artSerialNumber = artSerialNumber;
         return this;
      }

      public AssNumberArtNumberLinkDTO build() {
         return new AssNumberArtNumberLinkDTO(this.assId, this.assNumber, this.artId, this.artNumber, this.artSerialNumber);
      }

      @Override
      public String toString() {
         return "AssNumberArtNumberLinkDTO.AssNumberArtNumberLinkDTOBuilder(assId="
            + this.assId
            + ", assNumber="
            + this.assNumber
            + ", artId="
            + this.artId
            + ", artNumber="
            + this.artNumber
            + ", artSerialNumber="
            + this.artSerialNumber
            + ")";
      }
   }
}
