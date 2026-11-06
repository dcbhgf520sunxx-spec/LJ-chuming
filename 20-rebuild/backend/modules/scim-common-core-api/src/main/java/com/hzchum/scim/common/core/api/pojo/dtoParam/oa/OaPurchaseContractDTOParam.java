package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("OaPurchaseContractDTOParam")
public class OaPurchaseContractDTOParam {
   @ApiModelProperty(name = "purchaseContractNumber", value = "采购合同编号")
   private String purchaseContractNumber;
   @ApiModelProperty(name = "title ", value = "标题")
   private String title;
   @ApiModelProperty(name = "requestName ", value = "OA审批流程")
   private String requestName;
   @ApiModelProperty(name = "sqrq", value = "申请日期")
   private String sqrq;
   @ApiModelProperty(name = "sqr", value = "申请人")
   private String sqr;
   @ApiModelProperty(name = "ssbm", value = "申请人部门")
   private String ssbm;
   @ApiModelProperty(name = "szgs", value = "申请人分部")
   private String szgs;
   @ApiModelProperty(name = "xmmc", value = "项目名称")
   private String xmmc;
   @ApiModelProperty(name = "htzt", value = "合同主体")
   private String htzt;
   @ApiModelProperty(name = "htzt1", value = "合同状态")
   private String htzt1;
   @ApiModelProperty(name = "jtjbr", value = "具体经办人")
   private String jtjbr;
   @ApiModelProperty(name = "yyfs", value = "用印份数")
   private String yyfs;
   @ApiModelProperty(name = "yynr", value = "用印内容")
   private String yynr;
   @ApiModelProperty(name = "yzlx", value = "用章类型")
   private String yzlx;
   @ApiModelProperty(name = "hthqyj", value = "合同会签意见")
   private String hthqyj;
   @ApiModelProperty(name = "jf", value = "甲方")
   private String jf;
   @ApiModelProperty(name = "yf", value = "乙方")
   private String yf;
   @ApiModelProperty(name = "bf", value = "丙方")
   private String bf;
   @ApiModelProperty(name = "df", value = "丁方")
   private String df;
   @ApiModelProperty(name = "htzynr", value = "合同主要内容")
   private String htzynr;
   @ApiModelProperty(name = "htzj", value = "合同总价")
   private String htzj;
   @ApiModelProperty(name = "qqsjjs", value = "起时间")
   private String qqsjjs;
   @ApiModelProperty(name = "qqsjks", value = "讫时间")
   private String qqsjks;
   @ApiModelProperty(name = "jsje", value = "结算金额")
   private String jsje;
   @ApiModelProperty(name = "bz", value = "备注")
   private String bz;
   @ApiModelProperty(name = "htfj", value = "附件")
   List<OaAttachmentsDTO> htfj;

   public static OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder builder() {
      return new OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder();
   }

   public OaPurchaseContractDTOParam(
      final String purchaseContractNumber,
      final String title,
      final String requestName,
      final String sqrq,
      final String sqr,
      final String ssbm,
      final String szgs,
      final String xmmc,
      final String htzt,
      final String htzt1,
      final String jtjbr,
      final String yyfs,
      final String yynr,
      final String yzlx,
      final String hthqyj,
      final String jf,
      final String yf,
      final String bf,
      final String df,
      final String htzynr,
      final String htzj,
      final String qqsjjs,
      final String qqsjks,
      final String jsje,
      final String bz,
      final List<OaAttachmentsDTO> htfj
   ) {
      this.purchaseContractNumber = purchaseContractNumber;
      this.title = title;
      this.requestName = requestName;
      this.sqrq = sqrq;
      this.sqr = sqr;
      this.ssbm = ssbm;
      this.szgs = szgs;
      this.xmmc = xmmc;
      this.htzt = htzt;
      this.htzt1 = htzt1;
      this.jtjbr = jtjbr;
      this.yyfs = yyfs;
      this.yynr = yynr;
      this.yzlx = yzlx;
      this.hthqyj = hthqyj;
      this.jf = jf;
      this.yf = yf;
      this.bf = bf;
      this.df = df;
      this.htzynr = htzynr;
      this.htzj = htzj;
      this.qqsjjs = qqsjjs;
      this.qqsjks = qqsjks;
      this.jsje = jsje;
      this.bz = bz;
      this.htfj = htfj;
   }

   public OaPurchaseContractDTOParam() {
   }

   public String getPurchaseContractNumber() {
      return this.purchaseContractNumber;
   }

   public String getTitle() {
      return this.title;
   }

   public String getRequestName() {
      return this.requestName;
   }

   public String getSqrq() {
      return this.sqrq;
   }

   public String getSqr() {
      return this.sqr;
   }

   public String getSsbm() {
      return this.ssbm;
   }

   public String getSzgs() {
      return this.szgs;
   }

   public String getXmmc() {
      return this.xmmc;
   }

   public String getHtzt() {
      return this.htzt;
   }

   public String getHtzt1() {
      return this.htzt1;
   }

   public String getJtjbr() {
      return this.jtjbr;
   }

   public String getYyfs() {
      return this.yyfs;
   }

   public String getYynr() {
      return this.yynr;
   }

   public String getYzlx() {
      return this.yzlx;
   }

   public String getHthqyj() {
      return this.hthqyj;
   }

   public String getJf() {
      return this.jf;
   }

   public String getYf() {
      return this.yf;
   }

   public String getBf() {
      return this.bf;
   }

   public String getDf() {
      return this.df;
   }

   public String getHtzynr() {
      return this.htzynr;
   }

   public String getHtzj() {
      return this.htzj;
   }

   public String getQqsjjs() {
      return this.qqsjjs;
   }

   public String getQqsjks() {
      return this.qqsjks;
   }

   public String getJsje() {
      return this.jsje;
   }

   public String getBz() {
      return this.bz;
   }

   public List<OaAttachmentsDTO> getHtfj() {
      return this.htfj;
   }

   public OaPurchaseContractDTOParam setPurchaseContractNumber(final String purchaseContractNumber) {
      this.purchaseContractNumber = purchaseContractNumber;
      return this;
   }

   public OaPurchaseContractDTOParam setTitle(final String title) {
      this.title = title;
      return this;
   }

   public OaPurchaseContractDTOParam setRequestName(final String requestName) {
      this.requestName = requestName;
      return this;
   }

   public OaPurchaseContractDTOParam setSqrq(final String sqrq) {
      this.sqrq = sqrq;
      return this;
   }

   public OaPurchaseContractDTOParam setSqr(final String sqr) {
      this.sqr = sqr;
      return this;
   }

   public OaPurchaseContractDTOParam setSsbm(final String ssbm) {
      this.ssbm = ssbm;
      return this;
   }

   public OaPurchaseContractDTOParam setSzgs(final String szgs) {
      this.szgs = szgs;
      return this;
   }

   public OaPurchaseContractDTOParam setXmmc(final String xmmc) {
      this.xmmc = xmmc;
      return this;
   }

   public OaPurchaseContractDTOParam setHtzt(final String htzt) {
      this.htzt = htzt;
      return this;
   }

   public OaPurchaseContractDTOParam setHtzt1(final String htzt1) {
      this.htzt1 = htzt1;
      return this;
   }

   public OaPurchaseContractDTOParam setJtjbr(final String jtjbr) {
      this.jtjbr = jtjbr;
      return this;
   }

   public OaPurchaseContractDTOParam setYyfs(final String yyfs) {
      this.yyfs = yyfs;
      return this;
   }

   public OaPurchaseContractDTOParam setYynr(final String yynr) {
      this.yynr = yynr;
      return this;
   }

   public OaPurchaseContractDTOParam setYzlx(final String yzlx) {
      this.yzlx = yzlx;
      return this;
   }

   public OaPurchaseContractDTOParam setHthqyj(final String hthqyj) {
      this.hthqyj = hthqyj;
      return this;
   }

   public OaPurchaseContractDTOParam setJf(final String jf) {
      this.jf = jf;
      return this;
   }

   public OaPurchaseContractDTOParam setYf(final String yf) {
      this.yf = yf;
      return this;
   }

   public OaPurchaseContractDTOParam setBf(final String bf) {
      this.bf = bf;
      return this;
   }

   public OaPurchaseContractDTOParam setDf(final String df) {
      this.df = df;
      return this;
   }

   public OaPurchaseContractDTOParam setHtzynr(final String htzynr) {
      this.htzynr = htzynr;
      return this;
   }

   public OaPurchaseContractDTOParam setHtzj(final String htzj) {
      this.htzj = htzj;
      return this;
   }

   public OaPurchaseContractDTOParam setQqsjjs(final String qqsjjs) {
      this.qqsjjs = qqsjjs;
      return this;
   }

   public OaPurchaseContractDTOParam setQqsjks(final String qqsjks) {
      this.qqsjks = qqsjks;
      return this;
   }

   public OaPurchaseContractDTOParam setJsje(final String jsje) {
      this.jsje = jsje;
      return this;
   }

   public OaPurchaseContractDTOParam setBz(final String bz) {
      this.bz = bz;
      return this;
   }

   public OaPurchaseContractDTOParam setHtfj(final List<OaAttachmentsDTO> htfj) {
      this.htfj = htfj;
      return this;
   }

   @Override
   public String toString() {
      return "OaPurchaseContractDTOParam(purchaseContractNumber="
         + this.getPurchaseContractNumber()
         + ", title="
         + this.getTitle()
         + ", requestName="
         + this.getRequestName()
         + ", sqrq="
         + this.getSqrq()
         + ", sqr="
         + this.getSqr()
         + ", ssbm="
         + this.getSsbm()
         + ", szgs="
         + this.getSzgs()
         + ", xmmc="
         + this.getXmmc()
         + ", htzt="
         + this.getHtzt()
         + ", htzt1="
         + this.getHtzt1()
         + ", jtjbr="
         + this.getJtjbr()
         + ", yyfs="
         + this.getYyfs()
         + ", yynr="
         + this.getYynr()
         + ", yzlx="
         + this.getYzlx()
         + ", hthqyj="
         + this.getHthqyj()
         + ", jf="
         + this.getJf()
         + ", yf="
         + this.getYf()
         + ", bf="
         + this.getBf()
         + ", df="
         + this.getDf()
         + ", htzynr="
         + this.getHtzynr()
         + ", htzj="
         + this.getHtzj()
         + ", qqsjjs="
         + this.getQqsjjs()
         + ", qqsjks="
         + this.getQqsjks()
         + ", jsje="
         + this.getJsje()
         + ", bz="
         + this.getBz()
         + ", htfj="
         + this.getHtfj()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaPurchaseContractDTOParam)) {
         return false;
      }

      OaPurchaseContractDTOParam other = (OaPurchaseContractDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$purchaseContractNumber = this.getPurchaseContractNumber();
      Object other$purchaseContractNumber = other.getPurchaseContractNumber();
      if (this$purchaseContractNumber == null ? other$purchaseContractNumber == null : this$purchaseContractNumber.equals(other$purchaseContractNumber)) {
         Object this$title = this.getTitle();
         Object other$title = other.getTitle();
         if (this$title == null ? other$title == null : this$title.equals(other$title)) {
            Object this$requestName = this.getRequestName();
            Object other$requestName = other.getRequestName();
            if (this$requestName == null ? other$requestName == null : this$requestName.equals(other$requestName)) {
               Object this$sqrq = this.getSqrq();
               Object other$sqrq = other.getSqrq();
               if (this$sqrq == null ? other$sqrq == null : this$sqrq.equals(other$sqrq)) {
                  Object this$sqr = this.getSqr();
                  Object other$sqr = other.getSqr();
                  if (this$sqr == null ? other$sqr == null : this$sqr.equals(other$sqr)) {
                     Object this$ssbm = this.getSsbm();
                     Object other$ssbm = other.getSsbm();
                     if (this$ssbm == null ? other$ssbm == null : this$ssbm.equals(other$ssbm)) {
                        Object this$szgs = this.getSzgs();
                        Object other$szgs = other.getSzgs();
                        if (this$szgs == null ? other$szgs == null : this$szgs.equals(other$szgs)) {
                           Object this$xmmc = this.getXmmc();
                           Object other$xmmc = other.getXmmc();
                           if (this$xmmc == null ? other$xmmc == null : this$xmmc.equals(other$xmmc)) {
                              Object this$htzt = this.getHtzt();
                              Object other$htzt = other.getHtzt();
                              if (this$htzt == null ? other$htzt == null : this$htzt.equals(other$htzt)) {
                                 Object this$htzt1 = this.getHtzt1();
                                 Object other$htzt1 = other.getHtzt1();
                                 if (this$htzt1 == null ? other$htzt1 == null : this$htzt1.equals(other$htzt1)) {
                                    Object this$jtjbr = this.getJtjbr();
                                    Object other$jtjbr = other.getJtjbr();
                                    if (this$jtjbr == null ? other$jtjbr == null : this$jtjbr.equals(other$jtjbr)) {
                                       Object this$yyfs = this.getYyfs();
                                       Object other$yyfs = other.getYyfs();
                                       if (this$yyfs == null ? other$yyfs == null : this$yyfs.equals(other$yyfs)) {
                                          Object this$yynr = this.getYynr();
                                          Object other$yynr = other.getYynr();
                                          if (this$yynr == null ? other$yynr == null : this$yynr.equals(other$yynr)) {
                                             Object this$yzlx = this.getYzlx();
                                             Object other$yzlx = other.getYzlx();
                                             if (this$yzlx == null ? other$yzlx == null : this$yzlx.equals(other$yzlx)) {
                                                Object this$hthqyj = this.getHthqyj();
                                                Object other$hthqyj = other.getHthqyj();
                                                if (this$hthqyj == null ? other$hthqyj == null : this$hthqyj.equals(other$hthqyj)) {
                                                   Object this$jf = this.getJf();
                                                   Object other$jf = other.getJf();
                                                   if (this$jf == null ? other$jf == null : this$jf.equals(other$jf)) {
                                                      Object this$yf = this.getYf();
                                                      Object other$yf = other.getYf();
                                                      if (this$yf == null ? other$yf == null : this$yf.equals(other$yf)) {
                                                         Object this$bf = this.getBf();
                                                         Object other$bf = other.getBf();
                                                         if (this$bf == null ? other$bf == null : this$bf.equals(other$bf)) {
                                                            Object this$df = this.getDf();
                                                            Object other$df = other.getDf();
                                                            if (this$df == null ? other$df == null : this$df.equals(other$df)) {
                                                               Object this$htzynr = this.getHtzynr();
                                                               Object other$htzynr = other.getHtzynr();
                                                               if (this$htzynr == null ? other$htzynr == null : this$htzynr.equals(other$htzynr)) {
                                                                  Object this$htzj = this.getHtzj();
                                                                  Object other$htzj = other.getHtzj();
                                                                  if (this$htzj == null ? other$htzj == null : this$htzj.equals(other$htzj)) {
                                                                     Object this$qqsjjs = this.getQqsjjs();
                                                                     Object other$qqsjjs = other.getQqsjjs();
                                                                     if (this$qqsjjs == null ? other$qqsjjs == null : this$qqsjjs.equals(other$qqsjjs)) {
                                                                        Object this$qqsjks = this.getQqsjks();
                                                                        Object other$qqsjks = other.getQqsjks();
                                                                        if (this$qqsjks == null ? other$qqsjks == null : this$qqsjks.equals(other$qqsjks)) {
                                                                           Object this$jsje = this.getJsje();
                                                                           Object other$jsje = other.getJsje();
                                                                           if (this$jsje == null ? other$jsje == null : this$jsje.equals(other$jsje)) {
                                                                              Object this$bz = this.getBz();
                                                                              Object other$bz = other.getBz();
                                                                              if (this$bz == null ? other$bz == null : this$bz.equals(other$bz)) {
                                                                                 Object this$htfj = this.getHtfj();
                                                                                 Object other$htfj = other.getHtfj();
                                                                                 return this$htfj == null ? other$htfj == null : this$htfj.equals(other$htfj);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OaPurchaseContractDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $purchaseContractNumber = this.getPurchaseContractNumber();
      result = result * 59 + ($purchaseContractNumber == null ? 43 : $purchaseContractNumber.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $requestName = this.getRequestName();
      result = result * 59 + ($requestName == null ? 43 : $requestName.hashCode());
      Object $sqrq = this.getSqrq();
      result = result * 59 + ($sqrq == null ? 43 : $sqrq.hashCode());
      Object $sqr = this.getSqr();
      result = result * 59 + ($sqr == null ? 43 : $sqr.hashCode());
      Object $ssbm = this.getSsbm();
      result = result * 59 + ($ssbm == null ? 43 : $ssbm.hashCode());
      Object $szgs = this.getSzgs();
      result = result * 59 + ($szgs == null ? 43 : $szgs.hashCode());
      Object $xmmc = this.getXmmc();
      result = result * 59 + ($xmmc == null ? 43 : $xmmc.hashCode());
      Object $htzt = this.getHtzt();
      result = result * 59 + ($htzt == null ? 43 : $htzt.hashCode());
      Object $htzt1 = this.getHtzt1();
      result = result * 59 + ($htzt1 == null ? 43 : $htzt1.hashCode());
      Object $jtjbr = this.getJtjbr();
      result = result * 59 + ($jtjbr == null ? 43 : $jtjbr.hashCode());
      Object $yyfs = this.getYyfs();
      result = result * 59 + ($yyfs == null ? 43 : $yyfs.hashCode());
      Object $yynr = this.getYynr();
      result = result * 59 + ($yynr == null ? 43 : $yynr.hashCode());
      Object $yzlx = this.getYzlx();
      result = result * 59 + ($yzlx == null ? 43 : $yzlx.hashCode());
      Object $hthqyj = this.getHthqyj();
      result = result * 59 + ($hthqyj == null ? 43 : $hthqyj.hashCode());
      Object $jf = this.getJf();
      result = result * 59 + ($jf == null ? 43 : $jf.hashCode());
      Object $yf = this.getYf();
      result = result * 59 + ($yf == null ? 43 : $yf.hashCode());
      Object $bf = this.getBf();
      result = result * 59 + ($bf == null ? 43 : $bf.hashCode());
      Object $df = this.getDf();
      result = result * 59 + ($df == null ? 43 : $df.hashCode());
      Object $htzynr = this.getHtzynr();
      result = result * 59 + ($htzynr == null ? 43 : $htzynr.hashCode());
      Object $htzj = this.getHtzj();
      result = result * 59 + ($htzj == null ? 43 : $htzj.hashCode());
      Object $qqsjjs = this.getQqsjjs();
      result = result * 59 + ($qqsjjs == null ? 43 : $qqsjjs.hashCode());
      Object $qqsjks = this.getQqsjks();
      result = result * 59 + ($qqsjks == null ? 43 : $qqsjks.hashCode());
      Object $jsje = this.getJsje();
      result = result * 59 + ($jsje == null ? 43 : $jsje.hashCode());
      Object $bz = this.getBz();
      result = result * 59 + ($bz == null ? 43 : $bz.hashCode());
      Object $htfj = this.getHtfj();
      return result * 59 + ($htfj == null ? 43 : $htfj.hashCode());
   }

   public static class OaPurchaseContractDTOParamBuilder {
      private String purchaseContractNumber;
      private String title;
      private String requestName;
      private String sqrq;
      private String sqr;
      private String ssbm;
      private String szgs;
      private String xmmc;
      private String htzt;
      private String htzt1;
      private String jtjbr;
      private String yyfs;
      private String yynr;
      private String yzlx;
      private String hthqyj;
      private String jf;
      private String yf;
      private String bf;
      private String df;
      private String htzynr;
      private String htzj;
      private String qqsjjs;
      private String qqsjks;
      private String jsje;
      private String bz;
      private List<OaAttachmentsDTO> htfj;

      OaPurchaseContractDTOParamBuilder() {
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder purchaseContractNumber(final String purchaseContractNumber) {
         this.purchaseContractNumber = purchaseContractNumber;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder requestName(final String requestName) {
         this.requestName = requestName;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder sqrq(final String sqrq) {
         this.sqrq = sqrq;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder sqr(final String sqr) {
         this.sqr = sqr;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder ssbm(final String ssbm) {
         this.ssbm = ssbm;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder szgs(final String szgs) {
         this.szgs = szgs;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder xmmc(final String xmmc) {
         this.xmmc = xmmc;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder htzt(final String htzt) {
         this.htzt = htzt;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder htzt1(final String htzt1) {
         this.htzt1 = htzt1;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder jtjbr(final String jtjbr) {
         this.jtjbr = jtjbr;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder yyfs(final String yyfs) {
         this.yyfs = yyfs;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder yynr(final String yynr) {
         this.yynr = yynr;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder yzlx(final String yzlx) {
         this.yzlx = yzlx;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder hthqyj(final String hthqyj) {
         this.hthqyj = hthqyj;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder jf(final String jf) {
         this.jf = jf;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder yf(final String yf) {
         this.yf = yf;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder bf(final String bf) {
         this.bf = bf;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder df(final String df) {
         this.df = df;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder htzynr(final String htzynr) {
         this.htzynr = htzynr;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder htzj(final String htzj) {
         this.htzj = htzj;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder qqsjjs(final String qqsjjs) {
         this.qqsjjs = qqsjjs;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder qqsjks(final String qqsjks) {
         this.qqsjks = qqsjks;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder jsje(final String jsje) {
         this.jsje = jsje;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder bz(final String bz) {
         this.bz = bz;
         return this;
      }

      public OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder htfj(final List<OaAttachmentsDTO> htfj) {
         this.htfj = htfj;
         return this;
      }

      public OaPurchaseContractDTOParam build() {
         return new OaPurchaseContractDTOParam(
            this.purchaseContractNumber,
            this.title,
            this.requestName,
            this.sqrq,
            this.sqr,
            this.ssbm,
            this.szgs,
            this.xmmc,
            this.htzt,
            this.htzt1,
            this.jtjbr,
            this.yyfs,
            this.yynr,
            this.yzlx,
            this.hthqyj,
            this.jf,
            this.yf,
            this.bf,
            this.df,
            this.htzynr,
            this.htzj,
            this.qqsjjs,
            this.qqsjks,
            this.jsje,
            this.bz,
            this.htfj
         );
      }

      @Override
      public String toString() {
         return "OaPurchaseContractDTOParam.OaPurchaseContractDTOParamBuilder(purchaseContractNumber="
            + this.purchaseContractNumber
            + ", title="
            + this.title
            + ", requestName="
            + this.requestName
            + ", sqrq="
            + this.sqrq
            + ", sqr="
            + this.sqr
            + ", ssbm="
            + this.ssbm
            + ", szgs="
            + this.szgs
            + ", xmmc="
            + this.xmmc
            + ", htzt="
            + this.htzt
            + ", htzt1="
            + this.htzt1
            + ", jtjbr="
            + this.jtjbr
            + ", yyfs="
            + this.yyfs
            + ", yynr="
            + this.yynr
            + ", yzlx="
            + this.yzlx
            + ", hthqyj="
            + this.hthqyj
            + ", jf="
            + this.jf
            + ", yf="
            + this.yf
            + ", bf="
            + this.bf
            + ", df="
            + this.df
            + ", htzynr="
            + this.htzynr
            + ", htzj="
            + this.htzj
            + ", qqsjjs="
            + this.qqsjjs
            + ", qqsjks="
            + this.qqsjks
            + ", jsje="
            + this.jsje
            + ", bz="
            + this.bz
            + ", htfj="
            + this.htfj
            + ")";
      }
   }
}
