package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import java.util.Objects;

@ApiModel(value = "SendMsgToWxUserBaseInfoDTOParam", description = "劳务个人发送信息类")
public class SendMsgToWxUserBaseInfoDTOParam {
   private String touser;
   private Object data;
   private String page;

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         SendMsgToWxUserBaseInfoDTOParam that = (SendMsgToWxUserBaseInfoDTOParam)o;
         return Objects.equals(this.touser, that.touser);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.touser);
   }

   public String getTouser() {
      return this.touser;
   }

   public Object getData() {
      return this.data;
   }

   public String getPage() {
      return this.page;
   }

   public void setTouser(final String touser) {
      this.touser = touser;
   }

   public void setData(final Object data) {
      this.data = data;
   }

   public void setPage(final String page) {
      this.page = page;
   }

   @Override
   public String toString() {
      return "SendMsgToWxUserBaseInfoDTOParam(touser=" + this.getTouser() + ", data=" + this.getData() + ", page=" + this.getPage() + ")";
   }

   public SendMsgToWxUserBaseInfoDTOParam() {
   }

   public SendMsgToWxUserBaseInfoDTOParam(final String touser, final Object data, final String page) {
      this.touser = touser;
      this.data = data;
      this.page = page;
   }
}
