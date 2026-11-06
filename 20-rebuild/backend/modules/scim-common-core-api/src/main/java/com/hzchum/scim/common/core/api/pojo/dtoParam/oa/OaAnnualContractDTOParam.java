package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("OaAnnualContractDTOParam")
public class OaAnnualContractDTOParam {
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
   @ApiModelProperty(name = "jyfs", value = "经营方式")
   private String jyfs;
   @ApiModelProperty(name = "jtjbr", value = "具体经办人")
   private String jtjbr;
   @ApiModelProperty(name = "yyfs", value = "用印份数")
   private String yyfs;
   @ApiModelProperty(name = "yzlx", value = "用章类型")
   private String yzlx;
   @ApiModelProperty(name = "hthqyj", value = "合同会签意见")
   private String hthqyj;
   @ApiModelProperty(name = "jf", value = "甲方")
   private String jf;
   @ApiModelProperty(name = "cbrj", value = "甲方承办人")
   private String cbrj;
   @ApiModelProperty(name = "yf", value = "乙方")
   private String yf;
   @ApiModelProperty(name = "cbry", value = "乙方承办人")
   private String cbry;
   @ApiModelProperty(name = "bf", value = "丙方")
   private String bf;
   @ApiModelProperty(name = "cbrb", value = "丙方承办人")
   private String cbrb;
   @ApiModelProperty(name = "df", value = "丁方")
   private String df;
   @ApiModelProperty(name = "cbrd", value = "丁方承办人")
   private String cbrd;
   @ApiModelProperty(name = "htzynr", value = "合同主要内容")
   private String htzynr;
   @ApiModelProperty(name = "htzj", value = "合同总价")
   private String htzj;
   @ApiModelProperty(name = "qqsjjs", value = "起时间")
   private String qqsjjs;
   @ApiModelProperty(name = "qqsjks", value = "讫时间")
   private String qqsjks;
   @ApiModelProperty(name = "bz", value = "备注")
   private String bz;
   @ApiModelProperty(name = "htfj", value = "附件")
   List<OaAttachmentsDTO> htfj;

   public static OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder builder() {
      return new OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder();
   }

   public OaAnnualContractDTOParam(
      final String title,
      final String requestName,
      final String sqrq,
      final String sqr,
      final String ssbm,
      final String szgs,
      final String xmmc,
      final String htzt,
      final String jyfs,
      final String jtjbr,
      final String yyfs,
      final String yzlx,
      final String hthqyj,
      final String jf,
      final String cbrj,
      final String yf,
      final String cbry,
      final String bf,
      final String cbrb,
      final String df,
      final String cbrd,
      final String htzynr,
      final String htzj,
      final String qqsjjs,
      final String qqsjks,
      final String bz,
      final List<OaAttachmentsDTO> htfj
   ) {
      this.title = title;
      this.requestName = requestName;
      this.sqrq = sqrq;
      this.sqr = sqr;
      this.ssbm = ssbm;
      this.szgs = szgs;
      this.xmmc = xmmc;
      this.htzt = htzt;
      this.jyfs = jyfs;
      this.jtjbr = jtjbr;
      this.yyfs = yyfs;
      this.yzlx = yzlx;
      this.hthqyj = hthqyj;
      this.jf = jf;
      this.cbrj = cbrj;
      this.yf = yf;
      this.cbry = cbry;
      this.bf = bf;
      this.cbrb = cbrb;
      this.df = df;
      this.cbrd = cbrd;
      this.htzynr = htzynr;
      this.htzj = htzj;
      this.qqsjjs = qqsjjs;
      this.qqsjks = qqsjks;
      this.bz = bz;
      this.htfj = htfj;
   }

   public OaAnnualContractDTOParam() {
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

   public String getJyfs() {
      return this.jyfs;
   }

   public String getJtjbr() {
      return this.jtjbr;
   }

   public String getYyfs() {
      return this.yyfs;
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

   public String getCbrj() {
      return this.cbrj;
   }

   public String getYf() {
      return this.yf;
   }

   public String getCbry() {
      return this.cbry;
   }

   public String getBf() {
      return this.bf;
   }

   public String getCbrb() {
      return this.cbrb;
   }

   public String getDf() {
      return this.df;
   }

   public String getCbrd() {
      return this.cbrd;
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

   public String getBz() {
      return this.bz;
   }

   public List<OaAttachmentsDTO> getHtfj() {
      return this.htfj;
   }

   public OaAnnualContractDTOParam setTitle(final String title) {
      this.title = title;
      return this;
   }

   public OaAnnualContractDTOParam setRequestName(final String requestName) {
      this.requestName = requestName;
      return this;
   }

   public OaAnnualContractDTOParam setSqrq(final String sqrq) {
      this.sqrq = sqrq;
      return this;
   }

   public OaAnnualContractDTOParam setSqr(final String sqr) {
      this.sqr = sqr;
      return this;
   }

   public OaAnnualContractDTOParam setSsbm(final String ssbm) {
      this.ssbm = ssbm;
      return this;
   }

   public OaAnnualContractDTOParam setSzgs(final String szgs) {
      this.szgs = szgs;
      return this;
   }

   public OaAnnualContractDTOParam setXmmc(final String xmmc) {
      this.xmmc = xmmc;
      return this;
   }

   public OaAnnualContractDTOParam setHtzt(final String htzt) {
      this.htzt = htzt;
      return this;
   }

   public OaAnnualContractDTOParam setJyfs(final String jyfs) {
      this.jyfs = jyfs;
      return this;
   }

   public OaAnnualContractDTOParam setJtjbr(final String jtjbr) {
      this.jtjbr = jtjbr;
      return this;
   }

   public OaAnnualContractDTOParam setYyfs(final String yyfs) {
      this.yyfs = yyfs;
      return this;
   }

   public OaAnnualContractDTOParam setYzlx(final String yzlx) {
      this.yzlx = yzlx;
      return this;
   }

   public OaAnnualContractDTOParam setHthqyj(final String hthqyj) {
      this.hthqyj = hthqyj;
      return this;
   }

   public OaAnnualContractDTOParam setJf(final String jf) {
      this.jf = jf;
      return this;
   }

   public OaAnnualContractDTOParam setCbrj(final String cbrj) {
      this.cbrj = cbrj;
      return this;
   }

   public OaAnnualContractDTOParam setYf(final String yf) {
      this.yf = yf;
      return this;
   }

   public OaAnnualContractDTOParam setCbry(final String cbry) {
      this.cbry = cbry;
      return this;
   }

   public OaAnnualContractDTOParam setBf(final String bf) {
      this.bf = bf;
      return this;
   }

   public OaAnnualContractDTOParam setCbrb(final String cbrb) {
      this.cbrb = cbrb;
      return this;
   }

   public OaAnnualContractDTOParam setDf(final String df) {
      this.df = df;
      return this;
   }

   public OaAnnualContractDTOParam setCbrd(final String cbrd) {
      this.cbrd = cbrd;
      return this;
   }

   public OaAnnualContractDTOParam setHtzynr(final String htzynr) {
      this.htzynr = htzynr;
      return this;
   }

   public OaAnnualContractDTOParam setHtzj(final String htzj) {
      this.htzj = htzj;
      return this;
   }

   public OaAnnualContractDTOParam setQqsjjs(final String qqsjjs) {
      this.qqsjjs = qqsjjs;
      return this;
   }

   public OaAnnualContractDTOParam setQqsjks(final String qqsjks) {
      this.qqsjks = qqsjks;
      return this;
   }

   public OaAnnualContractDTOParam setBz(final String bz) {
      this.bz = bz;
      return this;
   }

   public OaAnnualContractDTOParam setHtfj(final List<OaAttachmentsDTO> htfj) {
      this.htfj = htfj;
      return this;
   }

   @Override
   public String toString() {
      return "OaAnnualContractDTOParam(title="
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
         + ", jyfs="
         + this.getJyfs()
         + ", jtjbr="
         + this.getJtjbr()
         + ", yyfs="
         + this.getYyfs()
         + ", yzlx="
         + this.getYzlx()
         + ", hthqyj="
         + this.getHthqyj()
         + ", jf="
         + this.getJf()
         + ", cbrj="
         + this.getCbrj()
         + ", yf="
         + this.getYf()
         + ", cbry="
         + this.getCbry()
         + ", bf="
         + this.getBf()
         + ", cbrb="
         + this.getCbrb()
         + ", df="
         + this.getDf()
         + ", cbrd="
         + this.getCbrd()
         + ", htzynr="
         + this.getHtzynr()
         + ", htzj="
         + this.getHtzj()
         + ", qqsjjs="
         + this.getQqsjjs()
         + ", qqsjks="
         + this.getQqsjks()
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

      if (!(o instanceof OaAnnualContractDTOParam)) {
         return false;
      }

      OaAnnualContractDTOParam other = (OaAnnualContractDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

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
                              Object this$jyfs = this.getJyfs();
                              Object other$jyfs = other.getJyfs();
                              if (this$jyfs == null ? other$jyfs == null : this$jyfs.equals(other$jyfs)) {
                                 Object this$jtjbr = this.getJtjbr();
                                 Object other$jtjbr = other.getJtjbr();
                                 if (this$jtjbr == null ? other$jtjbr == null : this$jtjbr.equals(other$jtjbr)) {
                                    Object this$yyfs = this.getYyfs();
                                    Object other$yyfs = other.getYyfs();
                                    if (this$yyfs == null ? other$yyfs == null : this$yyfs.equals(other$yyfs)) {
                                       Object this$yzlx = this.getYzlx();
                                       Object other$yzlx = other.getYzlx();
                                       if (this$yzlx == null ? other$yzlx == null : this$yzlx.equals(other$yzlx)) {
                                          Object this$hthqyj = this.getHthqyj();
                                          Object other$hthqyj = other.getHthqyj();
                                          if (this$hthqyj == null ? other$hthqyj == null : this$hthqyj.equals(other$hthqyj)) {
                                             Object this$jf = this.getJf();
                                             Object other$jf = other.getJf();
                                             if (this$jf == null ? other$jf == null : this$jf.equals(other$jf)) {
                                                Object this$cbrj = this.getCbrj();
                                                Object other$cbrj = other.getCbrj();
                                                if (this$cbrj == null ? other$cbrj == null : this$cbrj.equals(other$cbrj)) {
                                                   Object this$yf = this.getYf();
                                                   Object other$yf = other.getYf();
                                                   if (this$yf == null ? other$yf == null : this$yf.equals(other$yf)) {
                                                      Object this$cbry = this.getCbry();
                                                      Object other$cbry = other.getCbry();
                                                      if (this$cbry == null ? other$cbry == null : this$cbry.equals(other$cbry)) {
                                                         Object this$bf = this.getBf();
                                                         Object other$bf = other.getBf();
                                                         if (this$bf == null ? other$bf == null : this$bf.equals(other$bf)) {
                                                            Object this$cbrb = this.getCbrb();
                                                            Object other$cbrb = other.getCbrb();
                                                            if (this$cbrb == null ? other$cbrb == null : this$cbrb.equals(other$cbrb)) {
                                                               Object this$df = this.getDf();
                                                               Object other$df = other.getDf();
                                                               if (this$df == null ? other$df == null : this$df.equals(other$df)) {
                                                                  Object this$cbrd = this.getCbrd();
                                                                  Object other$cbrd = other.getCbrd();
                                                                  if (this$cbrd == null ? other$cbrd == null : this$cbrd.equals(other$cbrd)) {
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
                                                                              if (this$qqsjks == null ? other$qqsjks == null : this$qqsjks.equals(other$qqsjks)
                                                                                 )
                                                                               {
                                                                                 Object this$bz = this.getBz();
                                                                                 Object other$bz = other.getBz();
                                                                                 if (this$bz == null ? other$bz == null : this$bz.equals(other$bz)) {
                                                                                    Object this$htfj = this.getHtfj();
                                                                                    Object other$htfj = other.getHtfj();
                                                                                    return this$htfj == null
                                                                                       ? other$htfj == null
                                                                                       : this$htfj.equals(other$htfj);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OaAnnualContractDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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
      Object $jyfs = this.getJyfs();
      result = result * 59 + ($jyfs == null ? 43 : $jyfs.hashCode());
      Object $jtjbr = this.getJtjbr();
      result = result * 59 + ($jtjbr == null ? 43 : $jtjbr.hashCode());
      Object $yyfs = this.getYyfs();
      result = result * 59 + ($yyfs == null ? 43 : $yyfs.hashCode());
      Object $yzlx = this.getYzlx();
      result = result * 59 + ($yzlx == null ? 43 : $yzlx.hashCode());
      Object $hthqyj = this.getHthqyj();
      result = result * 59 + ($hthqyj == null ? 43 : $hthqyj.hashCode());
      Object $jf = this.getJf();
      result = result * 59 + ($jf == null ? 43 : $jf.hashCode());
      Object $cbrj = this.getCbrj();
      result = result * 59 + ($cbrj == null ? 43 : $cbrj.hashCode());
      Object $yf = this.getYf();
      result = result * 59 + ($yf == null ? 43 : $yf.hashCode());
      Object $cbry = this.getCbry();
      result = result * 59 + ($cbry == null ? 43 : $cbry.hashCode());
      Object $bf = this.getBf();
      result = result * 59 + ($bf == null ? 43 : $bf.hashCode());
      Object $cbrb = this.getCbrb();
      result = result * 59 + ($cbrb == null ? 43 : $cbrb.hashCode());
      Object $df = this.getDf();
      result = result * 59 + ($df == null ? 43 : $df.hashCode());
      Object $cbrd = this.getCbrd();
      result = result * 59 + ($cbrd == null ? 43 : $cbrd.hashCode());
      Object $htzynr = this.getHtzynr();
      result = result * 59 + ($htzynr == null ? 43 : $htzynr.hashCode());
      Object $htzj = this.getHtzj();
      result = result * 59 + ($htzj == null ? 43 : $htzj.hashCode());
      Object $qqsjjs = this.getQqsjjs();
      result = result * 59 + ($qqsjjs == null ? 43 : $qqsjjs.hashCode());
      Object $qqsjks = this.getQqsjks();
      result = result * 59 + ($qqsjks == null ? 43 : $qqsjks.hashCode());
      Object $bz = this.getBz();
      result = result * 59 + ($bz == null ? 43 : $bz.hashCode());
      Object $htfj = this.getHtfj();
      return result * 59 + ($htfj == null ? 43 : $htfj.hashCode());
   }

   public static class OaAnnualContractDTOParamBuilder {
      private String title;
      private String requestName;
      private String sqrq;
      private String sqr;
      private String ssbm;
      private String szgs;
      private String xmmc;
      private String htzt;
      private String jyfs;
      private String jtjbr;
      private String yyfs;
      private String yzlx;
      private String hthqyj;
      private String jf;
      private String cbrj;
      private String yf;
      private String cbry;
      private String bf;
      private String cbrb;
      private String df;
      private String cbrd;
      private String htzynr;
      private String htzj;
      private String qqsjjs;
      private String qqsjks;
      private String bz;
      private List<OaAttachmentsDTO> htfj;

      OaAnnualContractDTOParamBuilder() {
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder requestName(final String requestName) {
         this.requestName = requestName;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder sqrq(final String sqrq) {
         this.sqrq = sqrq;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder sqr(final String sqr) {
         this.sqr = sqr;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder ssbm(final String ssbm) {
         this.ssbm = ssbm;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder szgs(final String szgs) {
         this.szgs = szgs;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder xmmc(final String xmmc) {
         this.xmmc = xmmc;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder htzt(final String htzt) {
         this.htzt = htzt;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder jyfs(final String jyfs) {
         this.jyfs = jyfs;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder jtjbr(final String jtjbr) {
         this.jtjbr = jtjbr;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder yyfs(final String yyfs) {
         this.yyfs = yyfs;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder yzlx(final String yzlx) {
         this.yzlx = yzlx;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder hthqyj(final String hthqyj) {
         this.hthqyj = hthqyj;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder jf(final String jf) {
         this.jf = jf;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder cbrj(final String cbrj) {
         this.cbrj = cbrj;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder yf(final String yf) {
         this.yf = yf;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder cbry(final String cbry) {
         this.cbry = cbry;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder bf(final String bf) {
         this.bf = bf;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder cbrb(final String cbrb) {
         this.cbrb = cbrb;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder df(final String df) {
         this.df = df;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder cbrd(final String cbrd) {
         this.cbrd = cbrd;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder htzynr(final String htzynr) {
         this.htzynr = htzynr;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder htzj(final String htzj) {
         this.htzj = htzj;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder qqsjjs(final String qqsjjs) {
         this.qqsjjs = qqsjjs;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder qqsjks(final String qqsjks) {
         this.qqsjks = qqsjks;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder bz(final String bz) {
         this.bz = bz;
         return this;
      }

      public OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder htfj(final List<OaAttachmentsDTO> htfj) {
         this.htfj = htfj;
         return this;
      }

      public OaAnnualContractDTOParam build() {
         return new OaAnnualContractDTOParam(
            this.title,
            this.requestName,
            this.sqrq,
            this.sqr,
            this.ssbm,
            this.szgs,
            this.xmmc,
            this.htzt,
            this.jyfs,
            this.jtjbr,
            this.yyfs,
            this.yzlx,
            this.hthqyj,
            this.jf,
            this.cbrj,
            this.yf,
            this.cbry,
            this.bf,
            this.cbrb,
            this.df,
            this.cbrd,
            this.htzynr,
            this.htzj,
            this.qqsjjs,
            this.qqsjks,
            this.bz,
            this.htfj
         );
      }

      @Override
      public String toString() {
         return "OaAnnualContractDTOParam.OaAnnualContractDTOParamBuilder(title="
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
            + ", jyfs="
            + this.jyfs
            + ", jtjbr="
            + this.jtjbr
            + ", yyfs="
            + this.yyfs
            + ", yzlx="
            + this.yzlx
            + ", hthqyj="
            + this.hthqyj
            + ", jf="
            + this.jf
            + ", cbrj="
            + this.cbrj
            + ", yf="
            + this.yf
            + ", cbry="
            + this.cbry
            + ", bf="
            + this.bf
            + ", cbrb="
            + this.cbrb
            + ", df="
            + this.df
            + ", cbrd="
            + this.cbrd
            + ", htzynr="
            + this.htzynr
            + ", htzj="
            + this.htzj
            + ", qqsjjs="
            + this.qqsjjs
            + ", qqsjks="
            + this.qqsjks
            + ", bz="
            + this.bz
            + ", htfj="
            + this.htfj
            + ")";
      }
   }
}
