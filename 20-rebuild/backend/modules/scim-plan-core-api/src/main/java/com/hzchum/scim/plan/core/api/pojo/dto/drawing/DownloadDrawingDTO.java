package com.hzchum.scim.plan.core.api.pojo.dto.drawing;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "DownloadDrawingDTO", description = "图纸下载对象")
public class DownloadDrawingDTO {
   @ApiModelProperty(name = "serialNumbers", value = "编号")
   @JsonProperty("serialNumbers")
   @JSONField(name = "serialNumbers")
   private List<String> serialNumbers;

   public static DownloadDrawingDTO.DownloadDrawingDTOBuilder builder() {
      return new DownloadDrawingDTO.DownloadDrawingDTOBuilder();
   }

   public DownloadDrawingDTO() {
   }

   public DownloadDrawingDTO(final List<String> serialNumbers) {
      this.serialNumbers = serialNumbers;
   }

   public List<String> getSerialNumbers() {
      return this.serialNumbers;
   }

   @JsonProperty("serialNumbers")
   public void setSerialNumbers(final List<String> serialNumbers) {
      this.serialNumbers = serialNumbers;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DownloadDrawingDTO)) {
         return false;
      }

      DownloadDrawingDTO other = (DownloadDrawingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$serialNumbers = this.getSerialNumbers();
      Object other$serialNumbers = other.getSerialNumbers();
      return this$serialNumbers == null ? other$serialNumbers == null : this$serialNumbers.equals(other$serialNumbers);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DownloadDrawingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $serialNumbers = this.getSerialNumbers();
      return result * 59 + ($serialNumbers == null ? 43 : $serialNumbers.hashCode());
   }

   @Override
   public String toString() {
      return "DownloadDrawingDTO(serialNumbers=" + this.getSerialNumbers() + ")";
   }

   public static class DownloadDrawingDTOBuilder {
      private List<String> serialNumbers;

      DownloadDrawingDTOBuilder() {
      }

      @JsonProperty("serialNumbers")
      public DownloadDrawingDTO.DownloadDrawingDTOBuilder serialNumbers(final List<String> serialNumbers) {
         this.serialNumbers = serialNumbers;
         return this;
      }

      public DownloadDrawingDTO build() {
         return new DownloadDrawingDTO(this.serialNumbers);
      }

      @Override
      public String toString() {
         return "DownloadDrawingDTO.DownloadDrawingDTOBuilder(serialNumbers=" + this.serialNumbers + ")";
      }
   }
}
