package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("OaProjectPrequalificationDTOParam")
public class OaProjectPrequalificationDTOParam {
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
   @ApiModelProperty("有效期剩余（天）")
   private String yxqsyt;
   @ApiModelProperty("受理截止日")
   private String sljzr;
   @ApiModelProperty("受理地点")
   private String sldd;
   @ApiModelProperty("资格预审通知文件")
   private List<OaAttachmentsDTO> zgystzwj;
   @ApiModelProperty("资格预审费（元）")
   private String zgysfy;

   public static OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder builder() {
      return new OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder();
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

   public String getYxqsyt() {
      return this.yxqsyt;
   }

   public String getSljzr() {
      return this.sljzr;
   }

   public String getSldd() {
      return this.sldd;
   }

   public List<OaAttachmentsDTO> getZgystzwj() {
      return this.zgystzwj;
   }

   public String getZgysfy() {
      return this.zgysfy;
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

   public void setYxqsyt(final String yxqsyt) {
      this.yxqsyt = yxqsyt;
   }

   public void setSljzr(final String sljzr) {
      this.sljzr = sljzr;
   }

   public void setSldd(final String sldd) {
      this.sldd = sldd;
   }

   public void setZgystzwj(final List<OaAttachmentsDTO> zgystzwj) {
      this.zgystzwj = zgystzwj;
   }

   public void setZgysfy(final String zgysfy) {
      this.zgysfy = zgysfy;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaProjectPrequalificationDTOParam)) {
         return false;
      }

      OaProjectPrequalificationDTOParam other = (OaProjectPrequalificationDTOParam)o;
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
                              Object this$yxqsyt = this.getYxqsyt();
                              Object other$yxqsyt = other.getYxqsyt();
                              if (this$yxqsyt == null ? other$yxqsyt == null : this$yxqsyt.equals(other$yxqsyt)) {
                                 Object this$sljzr = this.getSljzr();
                                 Object other$sljzr = other.getSljzr();
                                 if (this$sljzr == null ? other$sljzr == null : this$sljzr.equals(other$sljzr)) {
                                    Object this$sldd = this.getSldd();
                                    Object other$sldd = other.getSldd();
                                    if (this$sldd == null ? other$sldd == null : this$sldd.equals(other$sldd)) {
                                       Object this$zgystzwj = this.getZgystzwj();
                                       Object other$zgystzwj = other.getZgystzwj();
                                       if (this$zgystzwj == null ? other$zgystzwj == null : this$zgystzwj.equals(other$zgystzwj)) {
                                          Object this$zgysfy = this.getZgysfy();
                                          Object other$zgysfy = other.getZgysfy();
                                          return this$zgysfy == null ? other$zgysfy == null : this$zgysfy.equals(other$zgysfy);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OaProjectPrequalificationDTOParam;
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
      Object $yxqsyt = this.getYxqsyt();
      result = result * 59 + ($yxqsyt == null ? 43 : $yxqsyt.hashCode());
      Object $sljzr = this.getSljzr();
      result = result * 59 + ($sljzr == null ? 43 : $sljzr.hashCode());
      Object $sldd = this.getSldd();
      result = result * 59 + ($sldd == null ? 43 : $sldd.hashCode());
      Object $zgystzwj = this.getZgystzwj();
      result = result * 59 + ($zgystzwj == null ? 43 : $zgystzwj.hashCode());
      Object $zgysfy = this.getZgysfy();
      return result * 59 + ($zgysfy == null ? 43 : $zgysfy.hashCode());
   }

   @Override
   public String toString() {
      return "OaProjectPrequalificationDTOParam(requestName="
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
         + ", yxqsyt="
         + this.getYxqsyt()
         + ", sljzr="
         + this.getSljzr()
         + ", sldd="
         + this.getSldd()
         + ", zgystzwj="
         + this.getZgystzwj()
         + ", zgysfy="
         + this.getZgysfy()
         + ")";
   }

   public OaProjectPrequalificationDTOParam() {
   }

   public OaProjectPrequalificationDTOParam(
      final String requestName,
      final String title,
      final String sqrq,
      final String sqr,
      final String bz,
      final String sqrszgs,
      final String sqrszbm,
      final String xmmc,
      final String yxqsyt,
      final String sljzr,
      final String sldd,
      final List<OaAttachmentsDTO> zgystzwj,
      final String zgysfy
   ) {
      this.requestName = requestName;
      this.title = title;
      this.sqrq = sqrq;
      this.sqr = sqr;
      this.bz = bz;
      this.sqrszgs = sqrszgs;
      this.sqrszbm = sqrszbm;
      this.xmmc = xmmc;
      this.yxqsyt = yxqsyt;
      this.sljzr = sljzr;
      this.sldd = sldd;
      this.zgystzwj = zgystzwj;
      this.zgysfy = zgysfy;
   }

   public static class OaProjectPrequalificationDTOParamBuilder {
      private String requestName;
      private String title;
      private String sqrq;
      private String sqr;
      private String bz;
      private String sqrszgs;
      private String sqrszbm;
      private String xmmc;
      private String yxqsyt;
      private String sljzr;
      private String sldd;
      private List<OaAttachmentsDTO> zgystzwj;
      private String zgysfy;

      OaProjectPrequalificationDTOParamBuilder() {
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder requestName(final String requestName) {
         this.requestName = requestName;
         return this;
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder sqrq(final String sqrq) {
         this.sqrq = sqrq;
         return this;
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder sqr(final String sqr) {
         this.sqr = sqr;
         return this;
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder bz(final String bz) {
         this.bz = bz;
         return this;
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder sqrszgs(final String sqrszgs) {
         this.sqrszgs = sqrszgs;
         return this;
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder sqrszbm(final String sqrszbm) {
         this.sqrszbm = sqrszbm;
         return this;
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder xmmc(final String xmmc) {
         this.xmmc = xmmc;
         return this;
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder yxqsyt(final String yxqsyt) {
         this.yxqsyt = yxqsyt;
         return this;
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder sljzr(final String sljzr) {
         this.sljzr = sljzr;
         return this;
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder sldd(final String sldd) {
         this.sldd = sldd;
         return this;
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder zgystzwj(final List<OaAttachmentsDTO> zgystzwj) {
         this.zgystzwj = zgystzwj;
         return this;
      }

      public OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder zgysfy(final String zgysfy) {
         this.zgysfy = zgysfy;
         return this;
      }

      public OaProjectPrequalificationDTOParam build() {
         return new OaProjectPrequalificationDTOParam(
            this.requestName,
            this.title,
            this.sqrq,
            this.sqr,
            this.bz,
            this.sqrszgs,
            this.sqrszbm,
            this.xmmc,
            this.yxqsyt,
            this.sljzr,
            this.sldd,
            this.zgystzwj,
            this.zgysfy
         );
      }

      @Override
      public String toString() {
         return "OaProjectPrequalificationDTOParam.OaProjectPrequalificationDTOParamBuilder(requestName="
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
            + ", yxqsyt="
            + this.yxqsyt
            + ", sljzr="
            + this.sljzr
            + ", sldd="
            + this.sldd
            + ", zgystzwj="
            + this.zgystzwj
            + ", zgysfy="
            + this.zgysfy
            + ")";
      }
   }
}
