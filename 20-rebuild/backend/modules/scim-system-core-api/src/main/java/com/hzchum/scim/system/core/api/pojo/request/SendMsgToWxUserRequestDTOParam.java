package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "SendMsgToWxUserRequestDTOParam", description = "微信发送接口请求类")
public class SendMsgToWxUserRequestDTOParam extends SendMsgToWxUserBaseInfoDTOParam {
   private String miniprogram_state = "formal";
   private String template_id = "fjUgPW-FatlgXmdniOUux4N6JpB4zDSaC-kKxifz1PQ";
   private String lang = "zh_CN";

   public String getMiniprogram_state() {
      return this.miniprogram_state;
   }

   public String getTemplate_id() {
      return this.template_id;
   }

   public String getLang() {
      return this.lang;
   }

   public void setMiniprogram_state(final String miniprogram_state) {
      this.miniprogram_state = miniprogram_state;
   }

   public void setTemplate_id(final String template_id) {
      this.template_id = template_id;
   }

   public void setLang(final String lang) {
      this.lang = lang;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SendMsgToWxUserRequestDTOParam)) {
         return false;
      }

      SendMsgToWxUserRequestDTOParam other = (SendMsgToWxUserRequestDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$miniprogram_state = this.getMiniprogram_state();
      Object other$miniprogram_state = other.getMiniprogram_state();
      if (this$miniprogram_state == null ? other$miniprogram_state == null : this$miniprogram_state.equals(other$miniprogram_state)) {
         Object this$template_id = this.getTemplate_id();
         Object other$template_id = other.getTemplate_id();
         if (this$template_id == null ? other$template_id == null : this$template_id.equals(other$template_id)) {
            Object this$lang = this.getLang();
            Object other$lang = other.getLang();
            return this$lang == null ? other$lang == null : this$lang.equals(other$lang);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SendMsgToWxUserRequestDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $miniprogram_state = this.getMiniprogram_state();
      result = result * 59 + ($miniprogram_state == null ? 43 : $miniprogram_state.hashCode());
      Object $template_id = this.getTemplate_id();
      result = result * 59 + ($template_id == null ? 43 : $template_id.hashCode());
      Object $lang = this.getLang();
      return result * 59 + ($lang == null ? 43 : $lang.hashCode());
   }

   @Override
   public String toString() {
      return "SendMsgToWxUserRequestDTOParam(miniprogram_state="
         + this.getMiniprogram_state()
         + ", template_id="
         + this.getTemplate_id()
         + ", lang="
         + this.getLang()
         + ")";
   }

   public SendMsgToWxUserRequestDTOParam() {
   }

   public SendMsgToWxUserRequestDTOParam(final String miniprogram_state, final String template_id, final String lang) {
      this.miniprogram_state = miniprogram_state;
      this.template_id = template_id;
      this.lang = lang;
   }
}
