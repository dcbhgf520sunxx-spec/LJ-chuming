package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.Instant;
import org.apache.poi.ss.formula.functions.T;

@ApiModel(value = "NestResultDTO", description = "物联返回结果 ")
public class NestResultDTO {
   @ApiModelProperty(value = "处理结果code", required = true)
   private String code;
   @ApiModelProperty("处理结果描述信息")
   private String msg;
   @ApiModelProperty("请求结果生成时间戳")
   private Instant time;
   @ApiModelProperty("处理结果数据信息")
   private T data;

   public static NestResultDTO.NestResultDTOBuilder builder() {
      return new NestResultDTO.NestResultDTOBuilder();
   }

   public NestResultDTO() {
   }

   public NestResultDTO(final String code, final String msg, final Instant time, final T data) {
      this.code = code;
      this.msg = msg;
      this.time = time;
      this.data = data;
   }

   public String getCode() {
      return this.code;
   }

   public String getMsg() {
      return this.msg;
   }

   public Instant getTime() {
      return this.time;
   }

   public T getData() {
      return this.data;
   }

   public NestResultDTO setCode(final String code) {
      this.code = code;
      return this;
   }

   public NestResultDTO setMsg(final String msg) {
      this.msg = msg;
      return this;
   }

   public NestResultDTO setTime(final Instant time) {
      this.time = time;
      return this;
   }

   public NestResultDTO setData(final T data) {
      this.data = data;
      return this;
   }

   @Override
   public String toString() {
      return "NestResultDTO(code=" + this.getCode() + ", msg=" + this.getMsg() + ", time=" + this.getTime() + ", data=" + this.getData() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestResultDTO)) {
         return false;
      }

      NestResultDTO other = (NestResultDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$code = this.getCode();
      Object other$code = other.getCode();
      if (this$code == null ? other$code == null : this$code.equals(other$code)) {
         Object this$msg = this.getMsg();
         Object other$msg = other.getMsg();
         if (this$msg == null ? other$msg == null : this$msg.equals(other$msg)) {
            Object this$time = this.getTime();
            Object other$time = other.getTime();
            if (this$time == null ? other$time == null : this$time.equals(other$time)) {
               Object this$data = this.getData();
               Object other$data = other.getData();
               return this$data == null ? other$data == null : this$data.equals(other$data);
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
      return other instanceof NestResultDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $msg = this.getMsg();
      result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
      Object $time = this.getTime();
      result = result * 59 + ($time == null ? 43 : $time.hashCode());
      Object $data = this.getData();
      return result * 59 + ($data == null ? 43 : $data.hashCode());
   }

   public static class NestResultDTOBuilder {
      private String code;
      private String msg;
      private Instant time;
      private T data;

      NestResultDTOBuilder() {
      }

      public NestResultDTO.NestResultDTOBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public NestResultDTO.NestResultDTOBuilder msg(final String msg) {
         this.msg = msg;
         return this;
      }

      public NestResultDTO.NestResultDTOBuilder time(final Instant time) {
         this.time = time;
         return this;
      }

      public NestResultDTO.NestResultDTOBuilder data(final T data) {
         this.data = data;
         return this;
      }

      public NestResultDTO build() {
         return new NestResultDTO(this.code, this.msg, this.time, this.data);
      }

      @Override
      public String toString() {
         return "NestResultDTO.NestResultDTOBuilder(code=" + this.code + ", msg=" + this.msg + ", time=" + this.time + ", data=" + this.data + ")";
      }
   }
}
