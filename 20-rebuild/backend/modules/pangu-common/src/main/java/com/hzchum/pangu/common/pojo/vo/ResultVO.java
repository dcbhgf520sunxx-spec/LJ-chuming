package com.hzchum.pangu.common.pojo.vo;

import java.io.Serializable;

public class ResultVO<T> implements Serializable {
   private Long code;
   private String message;
   private T data;

   public static <T> ResultVO.ResultVOBuilder<T> builder() {
      return new ResultVO.ResultVOBuilder<>();
   }

   public ResultVO(final Long code, final String message, final T data) {
      this.code = code;
      this.message = message;
      this.data = data;
   }

   public Long getCode() {
      return this.code;
   }

   public String getMessage() {
      return this.message;
   }

   public T getData() {
      return this.data;
   }

   public void setCode(final Long code) {
      this.code = code;
   }

   public void setMessage(final String message) {
      this.message = message;
   }

   public void setData(final T data) {
      this.data = data;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ResultVO)) {
         return false;
      }

      ResultVO<?> other = (ResultVO<?>)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$code = this.getCode();
      Object other$code = other.getCode();
      if (this$code == null ? other$code == null : this$code.equals(other$code)) {
         Object this$message = this.getMessage();
         Object other$message = other.getMessage();
         if (this$message == null ? other$message == null : this$message.equals(other$message)) {
            Object this$data = this.getData();
            Object other$data = other.getData();
            return this$data == null ? other$data == null : this$data.equals(other$data);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ResultVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $message = this.getMessage();
      result = result * 59 + ($message == null ? 43 : $message.hashCode());
      Object $data = this.getData();
      return result * 59 + ($data == null ? 43 : $data.hashCode());
   }

   @Override
   public String toString() {
      return "ResultVO(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
   }

   public static class ResultVOBuilder<T> {
      private Long code;
      private String message;
      private T data;

      ResultVOBuilder() {
      }

      public ResultVO.ResultVOBuilder<T> code(final Long code) {
         this.code = code;
         return this;
      }

      public ResultVO.ResultVOBuilder<T> message(final String message) {
         this.message = message;
         return this;
      }

      public ResultVO.ResultVOBuilder<T> data(final T data) {
         this.data = data;
         return this;
      }

      public ResultVO<T> build() {
         return new ResultVO<>(this.code, this.message, this.data);
      }

      @Override
      public String toString() {
         return "ResultVO.ResultVOBuilder(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ")";
      }
   }
}
