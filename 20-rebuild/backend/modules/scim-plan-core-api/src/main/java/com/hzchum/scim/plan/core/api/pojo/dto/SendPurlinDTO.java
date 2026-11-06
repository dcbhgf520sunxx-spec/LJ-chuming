package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("外协可入库详细信息")
public class SendPurlinDTO {
   @ApiModelProperty(name = "ataskId", value = "构件任务id")
   private Long ataskId;
   @ApiModelProperty(name = "id", value = "构件id")
   private Long artifactId;
   @ApiModelProperty(name = "assembleOrPartTaskId", value = "部件或零件任务id")
   private Long assembleOrPartTaskId;
   @ApiModelProperty(name = "assembleOrPartid", value = "部件或零件id")
   private Long assembleOrPartid;
   @ApiModelProperty(name = "scale", value = "比例")
   private Integer scale;
   @ApiModelProperty(name = "completeQuantity", value = "完成生产数")
   private Integer completeQuantity;
   @ApiModelProperty(name = "useQuantity", value = "使用数")
   private Integer useQuantity;

   public static SendPurlinDTO.SendPurlinDTOBuilder builder() {
      return new SendPurlinDTO.SendPurlinDTOBuilder();
   }

   public SendPurlinDTO() {
   }

   public SendPurlinDTO(
      final Long ataskId,
      final Long artifactId,
      final Long assembleOrPartTaskId,
      final Long assembleOrPartid,
      final Integer scale,
      final Integer completeQuantity,
      final Integer useQuantity
   ) {
      this.ataskId = ataskId;
      this.artifactId = artifactId;
      this.assembleOrPartTaskId = assembleOrPartTaskId;
      this.assembleOrPartid = assembleOrPartid;
      this.scale = scale;
      this.completeQuantity = completeQuantity;
      this.useQuantity = useQuantity;
   }

   public Long getAtaskId() {
      return this.ataskId;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Long getAssembleOrPartTaskId() {
      return this.assembleOrPartTaskId;
   }

   public Long getAssembleOrPartid() {
      return this.assembleOrPartid;
   }

   public Integer getScale() {
      return this.scale;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getUseQuantity() {
      return this.useQuantity;
   }

   public void setAtaskId(final Long ataskId) {
      this.ataskId = ataskId;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setAssembleOrPartTaskId(final Long assembleOrPartTaskId) {
      this.assembleOrPartTaskId = assembleOrPartTaskId;
   }

   public void setAssembleOrPartid(final Long assembleOrPartid) {
      this.assembleOrPartid = assembleOrPartid;
   }

   public void setScale(final Integer scale) {
      this.scale = scale;
   }

   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   public void setUseQuantity(final Integer useQuantity) {
      this.useQuantity = useQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SendPurlinDTO)) {
         return false;
      }

      SendPurlinDTO other = (SendPurlinDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$ataskId = this.getAtaskId();
      Object other$ataskId = other.getAtaskId();
      if (this$ataskId == null ? other$ataskId == null : this$ataskId.equals(other$ataskId)) {
         Object this$artifactId = this.getArtifactId();
         Object other$artifactId = other.getArtifactId();
         if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
            Object this$assembleOrPartTaskId = this.getAssembleOrPartTaskId();
            Object other$assembleOrPartTaskId = other.getAssembleOrPartTaskId();
            if (this$assembleOrPartTaskId == null ? other$assembleOrPartTaskId == null : this$assembleOrPartTaskId.equals(other$assembleOrPartTaskId)) {
               Object this$assembleOrPartid = this.getAssembleOrPartid();
               Object other$assembleOrPartid = other.getAssembleOrPartid();
               if (this$assembleOrPartid == null ? other$assembleOrPartid == null : this$assembleOrPartid.equals(other$assembleOrPartid)) {
                  Object this$scale = this.getScale();
                  Object other$scale = other.getScale();
                  if (this$scale == null ? other$scale == null : this$scale.equals(other$scale)) {
                     Object this$completeQuantity = this.getCompleteQuantity();
                     Object other$completeQuantity = other.getCompleteQuantity();
                     if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                        Object this$useQuantity = this.getUseQuantity();
                        Object other$useQuantity = other.getUseQuantity();
                        return this$useQuantity == null ? other$useQuantity == null : this$useQuantity.equals(other$useQuantity);
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
      return other instanceof SendPurlinDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $ataskId = this.getAtaskId();
      result = result * 59 + ($ataskId == null ? 43 : $ataskId.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $assembleOrPartTaskId = this.getAssembleOrPartTaskId();
      result = result * 59 + ($assembleOrPartTaskId == null ? 43 : $assembleOrPartTaskId.hashCode());
      Object $assembleOrPartid = this.getAssembleOrPartid();
      result = result * 59 + ($assembleOrPartid == null ? 43 : $assembleOrPartid.hashCode());
      Object $scale = this.getScale();
      result = result * 59 + ($scale == null ? 43 : $scale.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $useQuantity = this.getUseQuantity();
      return result * 59 + ($useQuantity == null ? 43 : $useQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "SendPurlinDTO(ataskId="
         + this.getAtaskId()
         + ", artifactId="
         + this.getArtifactId()
         + ", assembleOrPartTaskId="
         + this.getAssembleOrPartTaskId()
         + ", assembleOrPartid="
         + this.getAssembleOrPartid()
         + ", scale="
         + this.getScale()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", useQuantity="
         + this.getUseQuantity()
         + ")";
   }

   public static class SendPurlinDTOBuilder {
      private Long ataskId;
      private Long artifactId;
      private Long assembleOrPartTaskId;
      private Long assembleOrPartid;
      private Integer scale;
      private Integer completeQuantity;
      private Integer useQuantity;

      SendPurlinDTOBuilder() {
      }

      public SendPurlinDTO.SendPurlinDTOBuilder ataskId(final Long ataskId) {
         this.ataskId = ataskId;
         return this;
      }

      public SendPurlinDTO.SendPurlinDTOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public SendPurlinDTO.SendPurlinDTOBuilder assembleOrPartTaskId(final Long assembleOrPartTaskId) {
         this.assembleOrPartTaskId = assembleOrPartTaskId;
         return this;
      }

      public SendPurlinDTO.SendPurlinDTOBuilder assembleOrPartid(final Long assembleOrPartid) {
         this.assembleOrPartid = assembleOrPartid;
         return this;
      }

      public SendPurlinDTO.SendPurlinDTOBuilder scale(final Integer scale) {
         this.scale = scale;
         return this;
      }

      public SendPurlinDTO.SendPurlinDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public SendPurlinDTO.SendPurlinDTOBuilder useQuantity(final Integer useQuantity) {
         this.useQuantity = useQuantity;
         return this;
      }

      public SendPurlinDTO build() {
         return new SendPurlinDTO(
            this.ataskId, this.artifactId, this.assembleOrPartTaskId, this.assembleOrPartid, this.scale, this.completeQuantity, this.useQuantity
         );
      }

      @Override
      public String toString() {
         return "SendPurlinDTO.SendPurlinDTOBuilder(ataskId="
            + this.ataskId
            + ", artifactId="
            + this.artifactId
            + ", assembleOrPartTaskId="
            + this.assembleOrPartTaskId
            + ", assembleOrPartid="
            + this.assembleOrPartid
            + ", scale="
            + this.scale
            + ", completeQuantity="
            + this.completeQuantity
            + ", useQuantity="
            + this.useQuantity
            + ")";
      }
   }
}
