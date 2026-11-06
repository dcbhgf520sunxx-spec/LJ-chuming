package com.hzchum.scim.iot.core.api.pojo.dto.equipment;

import java.util.Date;

public class EquimentrepVO<T> {
   private String code;
   private String msg;
   private Date time;
   private T data;

   public static <T> EquimentrepVO.EquimentrepVOBuilder<T> builder() {
      return new EquimentrepVO.EquimentrepVOBuilder<>();
   }

   public String getCode() {
      return this.code;
   }

   public String getMsg() {
      return this.msg;
   }

   public Date getTime() {
      return this.time;
   }

   public T getData() {
      return this.data;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setMsg(final String msg) {
      this.msg = msg;
   }

   public void setTime(final Date time) {
      this.time = time;
   }

   public void setData(final T data) {
      this.data = data;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EquimentrepVO)) {
         return false;
      }

      EquimentrepVO<?> other = (EquimentrepVO<?>)o;
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
      return other instanceof EquimentrepVO;
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

   @Override
   public String toString() {
      return "EquimentrepVO(code=" + this.getCode() + ", msg=" + this.getMsg() + ", time=" + this.getTime() + ", data=" + this.getData() + ")";
   }

   public EquimentrepVO(final String code, final String msg, final Date time, final T data) {
      this.code = code;
      this.msg = msg;
      this.time = time;
      this.data = data;
   }

   public EquimentrepVO() {
   }

   public static class EquimentrepVOBuilder<T> {
      private String code;
      private String msg;
      private Date time;
      private T data;

      EquimentrepVOBuilder() {
      }

      public EquimentrepVO.EquimentrepVOBuilder<T> code(final String code) {
         this.code = code;
         return this;
      }

      public EquimentrepVO.EquimentrepVOBuilder<T> msg(final String msg) {
         this.msg = msg;
         return this;
      }

      public EquimentrepVO.EquimentrepVOBuilder<T> time(final Date time) {
         this.time = time;
         return this;
      }

      public EquimentrepVO.EquimentrepVOBuilder<T> data(final T data) {
         this.data = data;
         return this;
      }

      public EquimentrepVO<T> build() {
         return new EquimentrepVO<>(this.code, this.msg, this.time, this.data);
      }

      @Override
      public String toString() {
         return "EquimentrepVO.EquimentrepVOBuilder(code=" + this.code + ", msg=" + this.msg + ", time=" + this.time + ", data=" + this.data + ")";
      }
   }
}
