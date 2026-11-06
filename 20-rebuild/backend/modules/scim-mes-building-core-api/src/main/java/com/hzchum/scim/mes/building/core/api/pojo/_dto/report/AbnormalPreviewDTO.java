package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbnormalPreviewDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "AbnormalPreviewDTO", description = "异常处理排产预览")
public class AbnormalPreviewDTO {
   @ApiModelProperty(name = "preview", notes = "预览信息")
   @JsonProperty("preview")
   @JSONField(name = "preview")
   private List<AbnormalPreviewDO> preview;
   @ApiModelProperty(name = "type", notes = "异常类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;

   public static AbnormalPreviewDTO.AbnormalPreviewDTOBuilder builder() {
      return new AbnormalPreviewDTO.AbnormalPreviewDTOBuilder();
   }

   public AbnormalPreviewDTO() {
   }

   public AbnormalPreviewDTO(final List<AbnormalPreviewDO> preview, final Integer type) {
      this.preview = preview;
      this.type = type;
   }

   public List<AbnormalPreviewDO> getPreview() {
      return this.preview;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("preview")
   public AbnormalPreviewDTO setPreview(final List<AbnormalPreviewDO> preview) {
      this.preview = preview;
      return this;
   }

   @JsonProperty("type")
   public AbnormalPreviewDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalPreviewDTO(preview=" + this.getPreview() + ", type=" + this.getType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AbnormalPreviewDTO)) {
         return false;
      } else {
         AbnormalPreviewDTO other = (AbnormalPreviewDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$preview = this.getPreview();
               Object other$preview = other.getPreview();
               return this$preview == null ? other$preview == null : this$preview.equals(other$preview);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AbnormalPreviewDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $preview = this.getPreview();
      return result * 59 + ($preview == null ? 43 : $preview.hashCode());
   }

   public static class AbnormalPreviewDTOBuilder {
      private List<AbnormalPreviewDO> preview;
      private Integer type;

      AbnormalPreviewDTOBuilder() {
      }

      @JsonProperty("preview")
      public AbnormalPreviewDTO.AbnormalPreviewDTOBuilder preview(final List<AbnormalPreviewDO> preview) {
         this.preview = preview;
         return this;
      }

      @JsonProperty("type")
      public AbnormalPreviewDTO.AbnormalPreviewDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public AbnormalPreviewDTO build() {
         return new AbnormalPreviewDTO(this.preview, this.type);
      }

      @Override
      public String toString() {
         return "AbnormalPreviewDTO.AbnormalPreviewDTOBuilder(preview=" + this.preview + ", type=" + this.type + ")";
      }
   }
}
