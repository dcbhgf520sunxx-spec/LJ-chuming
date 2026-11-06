package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("OaProjectTrackingDTOParam")
public class OaProjectTrackingDTOParam {
   private String requestName;
   private String title;
   @ApiModelProperty("申请日期")
   private String sqrq;
   @ApiModelProperty("申请人")
   private String sqr;
   @ApiModelProperty("备注")
   private String bz;
   @ApiModelProperty("申请人所属公司")
   private String sqrszgs;
   @ApiModelProperty("申请人所属部门")
   private String sqrszbm;
   @ApiModelProperty("项目名称")
   private String xmmc;
   @ApiModelProperty("跟进方式")
   private String gjfs;
   @ApiModelProperty("有效期剩余（天）")
   private String yxqsyt;
   @ApiModelProperty("跟进证明")
   private List<OaAttachmentsDTO> gjzm;

   public static OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder builder() {
      return new OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder();
   }

   public String getRequestName() {
      return this.requestName;
   }

   public String getTitle() {
      return this.title;
   }

   public String getSqrq() {
      return this.sqrq;
   }

   public String getSqr() {
      return this.sqr;
   }

   public String getBz() {
      return this.bz;
   }

   public String getSqrszgs() {
      return this.sqrszgs;
   }

   public String getSqrszbm() {
      return this.sqrszbm;
   }

   public String getXmmc() {
      return this.xmmc;
   }

   public String getGjfs() {
      return this.gjfs;
   }

   public String getYxqsyt() {
      return this.yxqsyt;
   }

   public List<OaAttachmentsDTO> getGjzm() {
      return this.gjzm;
   }

   public void setRequestName(final String requestName) {
      this.requestName = requestName;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public void setSqrq(final String sqrq) {
      this.sqrq = sqrq;
   }

   public void setSqr(final String sqr) {
      this.sqr = sqr;
   }

   public void setBz(final String bz) {
      this.bz = bz;
   }

   public void setSqrszgs(final String sqrszgs) {
      this.sqrszgs = sqrszgs;
   }

   public void setSqrszbm(final String sqrszbm) {
      this.sqrszbm = sqrszbm;
   }

   public void setXmmc(final String xmmc) {
      this.xmmc = xmmc;
   }

   public void setGjfs(final String gjfs) {
      this.gjfs = gjfs;
   }

   public void setYxqsyt(final String yxqsyt) {
      this.yxqsyt = yxqsyt;
   }

   public void setGjzm(final List<OaAttachmentsDTO> gjzm) {
      this.gjzm = gjzm;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaProjectTrackingDTOParam)) {
         return false;
      }

      OaProjectTrackingDTOParam other = (OaProjectTrackingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$requestName = this.getRequestName();
      Object other$requestName = other.getRequestName();
      if (this$requestName == null ? other$requestName == null : this$requestName.equals(other$requestName)) {
         Object this$title = this.getTitle();
         Object other$title = other.getTitle();
         if (this$title == null ? other$title == null : this$title.equals(other$title)) {
            Object this$sqrq = this.getSqrq();
            Object other$sqrq = other.getSqrq();
            if (this$sqrq == null ? other$sqrq == null : this$sqrq.equals(other$sqrq)) {
               Object this$sqr = this.getSqr();
               Object other$sqr = other.getSqr();
               if (this$sqr == null ? other$sqr == null : this$sqr.equals(other$sqr)) {
                  Object this$bz = this.getBz();
                  Object other$bz = other.getBz();
                  if (this$bz == null ? other$bz == null : this$bz.equals(other$bz)) {
                     Object this$sqrszgs = this.getSqrszgs();
                     Object other$sqrszgs = other.getSqrszgs();
                     if (this$sqrszgs == null ? other$sqrszgs == null : this$sqrszgs.equals(other$sqrszgs)) {
                        Object this$sqrszbm = this.getSqrszbm();
                        Object other$sqrszbm = other.getSqrszbm();
                        if (this$sqrszbm == null ? other$sqrszbm == null : this$sqrszbm.equals(other$sqrszbm)) {
                           Object this$xmmc = this.getXmmc();
                           Object other$xmmc = other.getXmmc();
                           if (this$xmmc == null ? other$xmmc == null : this$xmmc.equals(other$xmmc)) {
                              Object this$gjfs = this.getGjfs();
                              Object other$gjfs = other.getGjfs();
                              if (this$gjfs == null ? other$gjfs == null : this$gjfs.equals(other$gjfs)) {
                                 Object this$yxqsyt = this.getYxqsyt();
                                 Object other$yxqsyt = other.getYxqsyt();
                                 if (this$yxqsyt == null ? other$yxqsyt == null : this$yxqsyt.equals(other$yxqsyt)) {
                                    Object this$gjzm = this.getGjzm();
                                    Object other$gjzm = other.getGjzm();
                                    return this$gjzm == null ? other$gjzm == null : this$gjzm.equals(other$gjzm);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OaProjectTrackingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $requestName = this.getRequestName();
      result = result * 59 + ($requestName == null ? 43 : $requestName.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $sqrq = this.getSqrq();
      result = result * 59 + ($sqrq == null ? 43 : $sqrq.hashCode());
      Object $sqr = this.getSqr();
      result = result * 59 + ($sqr == null ? 43 : $sqr.hashCode());
      Object $bz = this.getBz();
      result = result * 59 + ($bz == null ? 43 : $bz.hashCode());
      Object $sqrszgs = this.getSqrszgs();
      result = result * 59 + ($sqrszgs == null ? 43 : $sqrszgs.hashCode());
      Object $sqrszbm = this.getSqrszbm();
      result = result * 59 + ($sqrszbm == null ? 43 : $sqrszbm.hashCode());
      Object $xmmc = this.getXmmc();
      result = result * 59 + ($xmmc == null ? 43 : $xmmc.hashCode());
      Object $gjfs = this.getGjfs();
      result = result * 59 + ($gjfs == null ? 43 : $gjfs.hashCode());
      Object $yxqsyt = this.getYxqsyt();
      result = result * 59 + ($yxqsyt == null ? 43 : $yxqsyt.hashCode());
      Object $gjzm = this.getGjzm();
      return result * 59 + ($gjzm == null ? 43 : $gjzm.hashCode());
   }

   @Override
   public String toString() {
      return "OaProjectTrackingDTOParam(requestName="
         + this.getRequestName()
         + ", title="
         + this.getTitle()
         + ", sqrq="
         + this.getSqrq()
         + ", sqr="
         + this.getSqr()
         + ", bz="
         + this.getBz()
         + ", sqrszgs="
         + this.getSqrszgs()
         + ", sqrszbm="
         + this.getSqrszbm()
         + ", xmmc="
         + this.getXmmc()
         + ", gjfs="
         + this.getGjfs()
         + ", yxqsyt="
         + this.getYxqsyt()
         + ", gjzm="
         + this.getGjzm()
         + ")";
   }

   public OaProjectTrackingDTOParam() {
   }

   public OaProjectTrackingDTOParam(
      final String requestName,
      final String title,
      final String sqrq,
      final String sqr,
      final String bz,
      final String sqrszgs,
      final String sqrszbm,
      final String xmmc,
      final String gjfs,
      final String yxqsyt,
      final List<OaAttachmentsDTO> gjzm
   ) {
      this.requestName = requestName;
      this.title = title;
      this.sqrq = sqrq;
      this.sqr = sqr;
      this.bz = bz;
      this.sqrszgs = sqrszgs;
      this.sqrszbm = sqrszbm;
      this.xmmc = xmmc;
      this.gjfs = gjfs;
      this.yxqsyt = yxqsyt;
      this.gjzm = gjzm;
   }

   public static class OaProjectTrackingDTOParamBuilder {
      private String requestName;
      private String title;
      private String sqrq;
      private String sqr;
      private String bz;
      private String sqrszgs;
      private String sqrszbm;
      private String xmmc;
      private String gjfs;
      private String yxqsyt;
      private List<OaAttachmentsDTO> gjzm;

      OaProjectTrackingDTOParamBuilder() {
      }

      public OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder requestName(final String requestName) {
         this.requestName = requestName;
         return this;
      }

      public OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder sqrq(final String sqrq) {
         this.sqrq = sqrq;
         return this;
      }

      public OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder sqr(final String sqr) {
         this.sqr = sqr;
         return this;
      }

      public OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder bz(final String bz) {
         this.bz = bz;
         return this;
      }

      public OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder sqrszgs(final String sqrszgs) {
         this.sqrszgs = sqrszgs;
         return this;
      }

      public OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder sqrszbm(final String sqrszbm) {
         this.sqrszbm = sqrszbm;
         return this;
      }

      public OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder xmmc(final String xmmc) {
         this.xmmc = xmmc;
         return this;
      }

      public OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder gjfs(final String gjfs) {
         this.gjfs = gjfs;
         return this;
      }

      public OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder yxqsyt(final String yxqsyt) {
         this.yxqsyt = yxqsyt;
         return this;
      }

      public OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder gjzm(final List<OaAttachmentsDTO> gjzm) {
         this.gjzm = gjzm;
         return this;
      }

      public OaProjectTrackingDTOParam build() {
         return new OaProjectTrackingDTOParam(
            this.requestName, this.title, this.sqrq, this.sqr, this.bz, this.sqrszgs, this.sqrszbm, this.xmmc, this.gjfs, this.yxqsyt, this.gjzm
         );
      }

      @Override
      public String toString() {
         return "OaProjectTrackingDTOParam.OaProjectTrackingDTOParamBuilder(requestName="
            + this.requestName
            + ", title="
            + this.title
            + ", sqrq="
            + this.sqrq
            + ", sqr="
            + this.sqr
            + ", bz="
            + this.bz
            + ", sqrszgs="
            + this.sqrszgs
            + ", sqrszbm="
            + this.sqrszbm
            + ", xmmc="
            + this.xmmc
            + ", gjfs="
            + this.gjfs
            + ", yxqsyt="
            + this.yxqsyt
            + ", gjzm="
            + this.gjzm
            + ")";
      }
   }
}
