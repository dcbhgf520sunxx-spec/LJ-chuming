package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("OaPurchasePaymentDTOParam")
public class OaPurchasePaymentDTOParam {
   @ApiModelProperty(name = "title ", value = "标题")
   private String title;
   @ApiModelProperty(name = "requestName ", value = "OA审批流程")
   private String requestName;
   @ApiModelProperty(name = "purchaseContractNumber", value = "采购合同编号")
   private String purchaseContractNumber;
   @ApiModelProperty(name = "sqrq", value = "申请日期")
   private String sqrq;
   @ApiModelProperty(name = "sqr", value = "申请人")
   private String sqr;
   @ApiModelProperty(name = "szgs", value = "公司")
   private String szgs;
   @ApiModelProperty(name = "ssbm", value = "所属部门")
   private String ssbm;
   @ApiModelProperty(name = "htzt", value = "合同主体")
   private String htzt;
   @ApiModelProperty(name = "sfhtfk", value = "是否合同付款")
   private String sfhtfk;
   @ApiModelProperty(name = "szjg", value = "所属机构")
   private String szjg;
   @ApiModelProperty(name = "ywfp", value = "有无发票")
   private String ywfp;
   @ApiModelProperty(name = "fylx", value = "费用类型")
   private String fylx;
   @ApiModelProperty(name = "skdw", value = "收款单位")
   private String skdw;
   @ApiModelProperty(name = "khyx", value = "开户银行")
   private String khyx;
   @ApiModelProperty(name = "yxzh", value = "银行账号")
   private String yxzh;
   @ApiModelProperty(name = "htze", value = "合同总额")
   private String htze;
   @ApiModelProperty(name = "htyfje", value = "合同已付金额")
   private String htyfje;
   @ApiModelProperty(name = "fysm", value = "费用说明")
   private String fysm;
   @ApiModelProperty(name = "hkyt", value = "汇款用途")
   private String hkyt;
   @ApiModelProperty(name = "xglc", value = "相关流程")
   private String xglc;
   @ApiModelProperty(name = "hkje", value = "汇款金额")
   private String hkje;
   @ApiModelProperty(name = "xgfj", value = "附件")
   List<OaAttachmentsDTO> xgfj;
   @ApiModelProperty(name = "oaSupplierPaymentDTO", value = "采购付款合集")
   private List<OaSupplierPaymentDTO> oaSupplierPaymentDTO;

   public static OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder builder() {
      return new OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder();
   }

   public OaPurchasePaymentDTOParam(
      final String title,
      final String requestName,
      final String purchaseContractNumber,
      final String sqrq,
      final String sqr,
      final String szgs,
      final String ssbm,
      final String htzt,
      final String sfhtfk,
      final String szjg,
      final String ywfp,
      final String fylx,
      final String skdw,
      final String khyx,
      final String yxzh,
      final String htze,
      final String htyfje,
      final String fysm,
      final String hkyt,
      final String xglc,
      final String hkje,
      final List<OaAttachmentsDTO> xgfj,
      final List<OaSupplierPaymentDTO> oaSupplierPaymentDTO
   ) {
      this.title = title;
      this.requestName = requestName;
      this.purchaseContractNumber = purchaseContractNumber;
      this.sqrq = sqrq;
      this.sqr = sqr;
      this.szgs = szgs;
      this.ssbm = ssbm;
      this.htzt = htzt;
      this.sfhtfk = sfhtfk;
      this.szjg = szjg;
      this.ywfp = ywfp;
      this.fylx = fylx;
      this.skdw = skdw;
      this.khyx = khyx;
      this.yxzh = yxzh;
      this.htze = htze;
      this.htyfje = htyfje;
      this.fysm = fysm;
      this.hkyt = hkyt;
      this.xglc = xglc;
      this.hkje = hkje;
      this.xgfj = xgfj;
      this.oaSupplierPaymentDTO = oaSupplierPaymentDTO;
   }

   public OaPurchasePaymentDTOParam() {
   }

   public String getTitle() {
      return this.title;
   }

   public String getRequestName() {
      return this.requestName;
   }

   public String getPurchaseContractNumber() {
      return this.purchaseContractNumber;
   }

   public String getSqrq() {
      return this.sqrq;
   }

   public String getSqr() {
      return this.sqr;
   }

   public String getSzgs() {
      return this.szgs;
   }

   public String getSsbm() {
      return this.ssbm;
   }

   public String getHtzt() {
      return this.htzt;
   }

   public String getSfhtfk() {
      return this.sfhtfk;
   }

   public String getSzjg() {
      return this.szjg;
   }

   public String getYwfp() {
      return this.ywfp;
   }

   public String getFylx() {
      return this.fylx;
   }

   public String getSkdw() {
      return this.skdw;
   }

   public String getKhyx() {
      return this.khyx;
   }

   public String getYxzh() {
      return this.yxzh;
   }

   public String getHtze() {
      return this.htze;
   }

   public String getHtyfje() {
      return this.htyfje;
   }

   public String getFysm() {
      return this.fysm;
   }

   public String getHkyt() {
      return this.hkyt;
   }

   public String getXglc() {
      return this.xglc;
   }

   public String getHkje() {
      return this.hkje;
   }

   public List<OaAttachmentsDTO> getXgfj() {
      return this.xgfj;
   }

   public List<OaSupplierPaymentDTO> getOaSupplierPaymentDTO() {
      return this.oaSupplierPaymentDTO;
   }

   public OaPurchasePaymentDTOParam setTitle(final String title) {
      this.title = title;
      return this;
   }

   public OaPurchasePaymentDTOParam setRequestName(final String requestName) {
      this.requestName = requestName;
      return this;
   }

   public OaPurchasePaymentDTOParam setPurchaseContractNumber(final String purchaseContractNumber) {
      this.purchaseContractNumber = purchaseContractNumber;
      return this;
   }

   public OaPurchasePaymentDTOParam setSqrq(final String sqrq) {
      this.sqrq = sqrq;
      return this;
   }

   public OaPurchasePaymentDTOParam setSqr(final String sqr) {
      this.sqr = sqr;
      return this;
   }

   public OaPurchasePaymentDTOParam setSzgs(final String szgs) {
      this.szgs = szgs;
      return this;
   }

   public OaPurchasePaymentDTOParam setSsbm(final String ssbm) {
      this.ssbm = ssbm;
      return this;
   }

   public OaPurchasePaymentDTOParam setHtzt(final String htzt) {
      this.htzt = htzt;
      return this;
   }

   public OaPurchasePaymentDTOParam setSfhtfk(final String sfhtfk) {
      this.sfhtfk = sfhtfk;
      return this;
   }

   public OaPurchasePaymentDTOParam setSzjg(final String szjg) {
      this.szjg = szjg;
      return this;
   }

   public OaPurchasePaymentDTOParam setYwfp(final String ywfp) {
      this.ywfp = ywfp;
      return this;
   }

   public OaPurchasePaymentDTOParam setFylx(final String fylx) {
      this.fylx = fylx;
      return this;
   }

   public OaPurchasePaymentDTOParam setSkdw(final String skdw) {
      this.skdw = skdw;
      return this;
   }

   public OaPurchasePaymentDTOParam setKhyx(final String khyx) {
      this.khyx = khyx;
      return this;
   }

   public OaPurchasePaymentDTOParam setYxzh(final String yxzh) {
      this.yxzh = yxzh;
      return this;
   }

   public OaPurchasePaymentDTOParam setHtze(final String htze) {
      this.htze = htze;
      return this;
   }

   public OaPurchasePaymentDTOParam setHtyfje(final String htyfje) {
      this.htyfje = htyfje;
      return this;
   }

   public OaPurchasePaymentDTOParam setFysm(final String fysm) {
      this.fysm = fysm;
      return this;
   }

   public OaPurchasePaymentDTOParam setHkyt(final String hkyt) {
      this.hkyt = hkyt;
      return this;
   }

   public OaPurchasePaymentDTOParam setXglc(final String xglc) {
      this.xglc = xglc;
      return this;
   }

   public OaPurchasePaymentDTOParam setHkje(final String hkje) {
      this.hkje = hkje;
      return this;
   }

   public OaPurchasePaymentDTOParam setXgfj(final List<OaAttachmentsDTO> xgfj) {
      this.xgfj = xgfj;
      return this;
   }

   public OaPurchasePaymentDTOParam setOaSupplierPaymentDTO(final List<OaSupplierPaymentDTO> oaSupplierPaymentDTO) {
      this.oaSupplierPaymentDTO = oaSupplierPaymentDTO;
      return this;
   }

   @Override
   public String toString() {
      return "OaPurchasePaymentDTOParam(title="
         + this.getTitle()
         + ", requestName="
         + this.getRequestName()
         + ", purchaseContractNumber="
         + this.getPurchaseContractNumber()
         + ", sqrq="
         + this.getSqrq()
         + ", sqr="
         + this.getSqr()
         + ", szgs="
         + this.getSzgs()
         + ", ssbm="
         + this.getSsbm()
         + ", htzt="
         + this.getHtzt()
         + ", sfhtfk="
         + this.getSfhtfk()
         + ", szjg="
         + this.getSzjg()
         + ", ywfp="
         + this.getYwfp()
         + ", fylx="
         + this.getFylx()
         + ", skdw="
         + this.getSkdw()
         + ", khyx="
         + this.getKhyx()
         + ", yxzh="
         + this.getYxzh()
         + ", htze="
         + this.getHtze()
         + ", htyfje="
         + this.getHtyfje()
         + ", fysm="
         + this.getFysm()
         + ", hkyt="
         + this.getHkyt()
         + ", xglc="
         + this.getXglc()
         + ", hkje="
         + this.getHkje()
         + ", xgfj="
         + this.getXgfj()
         + ", oaSupplierPaymentDTO="
         + this.getOaSupplierPaymentDTO()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaPurchasePaymentDTOParam)) {
         return false;
      }

      OaPurchasePaymentDTOParam other = (OaPurchasePaymentDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$title = this.getTitle();
      Object other$title = other.getTitle();
      if (this$title == null ? other$title == null : this$title.equals(other$title)) {
         Object this$requestName = this.getRequestName();
         Object other$requestName = other.getRequestName();
         if (this$requestName == null ? other$requestName == null : this$requestName.equals(other$requestName)) {
            Object this$purchaseContractNumber = this.getPurchaseContractNumber();
            Object other$purchaseContractNumber = other.getPurchaseContractNumber();
            if (this$purchaseContractNumber == null ? other$purchaseContractNumber == null : this$purchaseContractNumber.equals(other$purchaseContractNumber)) {
               Object this$sqrq = this.getSqrq();
               Object other$sqrq = other.getSqrq();
               if (this$sqrq == null ? other$sqrq == null : this$sqrq.equals(other$sqrq)) {
                  Object this$sqr = this.getSqr();
                  Object other$sqr = other.getSqr();
                  if (this$sqr == null ? other$sqr == null : this$sqr.equals(other$sqr)) {
                     Object this$szgs = this.getSzgs();
                     Object other$szgs = other.getSzgs();
                     if (this$szgs == null ? other$szgs == null : this$szgs.equals(other$szgs)) {
                        Object this$ssbm = this.getSsbm();
                        Object other$ssbm = other.getSsbm();
                        if (this$ssbm == null ? other$ssbm == null : this$ssbm.equals(other$ssbm)) {
                           Object this$htzt = this.getHtzt();
                           Object other$htzt = other.getHtzt();
                           if (this$htzt == null ? other$htzt == null : this$htzt.equals(other$htzt)) {
                              Object this$sfhtfk = this.getSfhtfk();
                              Object other$sfhtfk = other.getSfhtfk();
                              if (this$sfhtfk == null ? other$sfhtfk == null : this$sfhtfk.equals(other$sfhtfk)) {
                                 Object this$szjg = this.getSzjg();
                                 Object other$szjg = other.getSzjg();
                                 if (this$szjg == null ? other$szjg == null : this$szjg.equals(other$szjg)) {
                                    Object this$ywfp = this.getYwfp();
                                    Object other$ywfp = other.getYwfp();
                                    if (this$ywfp == null ? other$ywfp == null : this$ywfp.equals(other$ywfp)) {
                                       Object this$fylx = this.getFylx();
                                       Object other$fylx = other.getFylx();
                                       if (this$fylx == null ? other$fylx == null : this$fylx.equals(other$fylx)) {
                                          Object this$skdw = this.getSkdw();
                                          Object other$skdw = other.getSkdw();
                                          if (this$skdw == null ? other$skdw == null : this$skdw.equals(other$skdw)) {
                                             Object this$khyx = this.getKhyx();
                                             Object other$khyx = other.getKhyx();
                                             if (this$khyx == null ? other$khyx == null : this$khyx.equals(other$khyx)) {
                                                Object this$yxzh = this.getYxzh();
                                                Object other$yxzh = other.getYxzh();
                                                if (this$yxzh == null ? other$yxzh == null : this$yxzh.equals(other$yxzh)) {
                                                   Object this$htze = this.getHtze();
                                                   Object other$htze = other.getHtze();
                                                   if (this$htze == null ? other$htze == null : this$htze.equals(other$htze)) {
                                                      Object this$htyfje = this.getHtyfje();
                                                      Object other$htyfje = other.getHtyfje();
                                                      if (this$htyfje == null ? other$htyfje == null : this$htyfje.equals(other$htyfje)) {
                                                         Object this$fysm = this.getFysm();
                                                         Object other$fysm = other.getFysm();
                                                         if (this$fysm == null ? other$fysm == null : this$fysm.equals(other$fysm)) {
                                                            Object this$hkyt = this.getHkyt();
                                                            Object other$hkyt = other.getHkyt();
                                                            if (this$hkyt == null ? other$hkyt == null : this$hkyt.equals(other$hkyt)) {
                                                               Object this$xglc = this.getXglc();
                                                               Object other$xglc = other.getXglc();
                                                               if (this$xglc == null ? other$xglc == null : this$xglc.equals(other$xglc)) {
                                                                  Object this$hkje = this.getHkje();
                                                                  Object other$hkje = other.getHkje();
                                                                  if (this$hkje == null ? other$hkje == null : this$hkje.equals(other$hkje)) {
                                                                     Object this$xgfj = this.getXgfj();
                                                                     Object other$xgfj = other.getXgfj();
                                                                     if (this$xgfj == null ? other$xgfj == null : this$xgfj.equals(other$xgfj)) {
                                                                        Object this$oaSupplierPaymentDTO = this.getOaSupplierPaymentDTO();
                                                                        Object other$oaSupplierPaymentDTO = other.getOaSupplierPaymentDTO();
                                                                        return this$oaSupplierPaymentDTO == null
                                                                           ? other$oaSupplierPaymentDTO == null
                                                                           : this$oaSupplierPaymentDTO.equals(other$oaSupplierPaymentDTO);
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
      return other instanceof OaPurchasePaymentDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $requestName = this.getRequestName();
      result = result * 59 + ($requestName == null ? 43 : $requestName.hashCode());
      Object $purchaseContractNumber = this.getPurchaseContractNumber();
      result = result * 59 + ($purchaseContractNumber == null ? 43 : $purchaseContractNumber.hashCode());
      Object $sqrq = this.getSqrq();
      result = result * 59 + ($sqrq == null ? 43 : $sqrq.hashCode());
      Object $sqr = this.getSqr();
      result = result * 59 + ($sqr == null ? 43 : $sqr.hashCode());
      Object $szgs = this.getSzgs();
      result = result * 59 + ($szgs == null ? 43 : $szgs.hashCode());
      Object $ssbm = this.getSsbm();
      result = result * 59 + ($ssbm == null ? 43 : $ssbm.hashCode());
      Object $htzt = this.getHtzt();
      result = result * 59 + ($htzt == null ? 43 : $htzt.hashCode());
      Object $sfhtfk = this.getSfhtfk();
      result = result * 59 + ($sfhtfk == null ? 43 : $sfhtfk.hashCode());
      Object $szjg = this.getSzjg();
      result = result * 59 + ($szjg == null ? 43 : $szjg.hashCode());
      Object $ywfp = this.getYwfp();
      result = result * 59 + ($ywfp == null ? 43 : $ywfp.hashCode());
      Object $fylx = this.getFylx();
      result = result * 59 + ($fylx == null ? 43 : $fylx.hashCode());
      Object $skdw = this.getSkdw();
      result = result * 59 + ($skdw == null ? 43 : $skdw.hashCode());
      Object $khyx = this.getKhyx();
      result = result * 59 + ($khyx == null ? 43 : $khyx.hashCode());
      Object $yxzh = this.getYxzh();
      result = result * 59 + ($yxzh == null ? 43 : $yxzh.hashCode());
      Object $htze = this.getHtze();
      result = result * 59 + ($htze == null ? 43 : $htze.hashCode());
      Object $htyfje = this.getHtyfje();
      result = result * 59 + ($htyfje == null ? 43 : $htyfje.hashCode());
      Object $fysm = this.getFysm();
      result = result * 59 + ($fysm == null ? 43 : $fysm.hashCode());
      Object $hkyt = this.getHkyt();
      result = result * 59 + ($hkyt == null ? 43 : $hkyt.hashCode());
      Object $xglc = this.getXglc();
      result = result * 59 + ($xglc == null ? 43 : $xglc.hashCode());
      Object $hkje = this.getHkje();
      result = result * 59 + ($hkje == null ? 43 : $hkje.hashCode());
      Object $xgfj = this.getXgfj();
      result = result * 59 + ($xgfj == null ? 43 : $xgfj.hashCode());
      Object $oaSupplierPaymentDTO = this.getOaSupplierPaymentDTO();
      return result * 59 + ($oaSupplierPaymentDTO == null ? 43 : $oaSupplierPaymentDTO.hashCode());
   }

   public static class OaPurchasePaymentDTOParamBuilder {
      private String title;
      private String requestName;
      private String purchaseContractNumber;
      private String sqrq;
      private String sqr;
      private String szgs;
      private String ssbm;
      private String htzt;
      private String sfhtfk;
      private String szjg;
      private String ywfp;
      private String fylx;
      private String skdw;
      private String khyx;
      private String yxzh;
      private String htze;
      private String htyfje;
      private String fysm;
      private String hkyt;
      private String xglc;
      private String hkje;
      private List<OaAttachmentsDTO> xgfj;
      private List<OaSupplierPaymentDTO> oaSupplierPaymentDTO;

      OaPurchasePaymentDTOParamBuilder() {
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder requestName(final String requestName) {
         this.requestName = requestName;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder purchaseContractNumber(final String purchaseContractNumber) {
         this.purchaseContractNumber = purchaseContractNumber;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder sqrq(final String sqrq) {
         this.sqrq = sqrq;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder sqr(final String sqr) {
         this.sqr = sqr;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder szgs(final String szgs) {
         this.szgs = szgs;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder ssbm(final String ssbm) {
         this.ssbm = ssbm;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder htzt(final String htzt) {
         this.htzt = htzt;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder sfhtfk(final String sfhtfk) {
         this.sfhtfk = sfhtfk;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder szjg(final String szjg) {
         this.szjg = szjg;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder ywfp(final String ywfp) {
         this.ywfp = ywfp;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder fylx(final String fylx) {
         this.fylx = fylx;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder skdw(final String skdw) {
         this.skdw = skdw;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder khyx(final String khyx) {
         this.khyx = khyx;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder yxzh(final String yxzh) {
         this.yxzh = yxzh;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder htze(final String htze) {
         this.htze = htze;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder htyfje(final String htyfje) {
         this.htyfje = htyfje;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder fysm(final String fysm) {
         this.fysm = fysm;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder hkyt(final String hkyt) {
         this.hkyt = hkyt;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder xglc(final String xglc) {
         this.xglc = xglc;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder hkje(final String hkje) {
         this.hkje = hkje;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder xgfj(final List<OaAttachmentsDTO> xgfj) {
         this.xgfj = xgfj;
         return this;
      }

      public OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder oaSupplierPaymentDTO(final List<OaSupplierPaymentDTO> oaSupplierPaymentDTO) {
         this.oaSupplierPaymentDTO = oaSupplierPaymentDTO;
         return this;
      }

      public OaPurchasePaymentDTOParam build() {
         return new OaPurchasePaymentDTOParam(
            this.title,
            this.requestName,
            this.purchaseContractNumber,
            this.sqrq,
            this.sqr,
            this.szgs,
            this.ssbm,
            this.htzt,
            this.sfhtfk,
            this.szjg,
            this.ywfp,
            this.fylx,
            this.skdw,
            this.khyx,
            this.yxzh,
            this.htze,
            this.htyfje,
            this.fysm,
            this.hkyt,
            this.xglc,
            this.hkje,
            this.xgfj,
            this.oaSupplierPaymentDTO
         );
      }

      @Override
      public String toString() {
         return "OaPurchasePaymentDTOParam.OaPurchasePaymentDTOParamBuilder(title="
            + this.title
            + ", requestName="
            + this.requestName
            + ", purchaseContractNumber="
            + this.purchaseContractNumber
            + ", sqrq="
            + this.sqrq
            + ", sqr="
            + this.sqr
            + ", szgs="
            + this.szgs
            + ", ssbm="
            + this.ssbm
            + ", htzt="
            + this.htzt
            + ", sfhtfk="
            + this.sfhtfk
            + ", szjg="
            + this.szjg
            + ", ywfp="
            + this.ywfp
            + ", fylx="
            + this.fylx
            + ", skdw="
            + this.skdw
            + ", khyx="
            + this.khyx
            + ", yxzh="
            + this.yxzh
            + ", htze="
            + this.htze
            + ", htyfje="
            + this.htyfje
            + ", fysm="
            + this.fysm
            + ", hkyt="
            + this.hkyt
            + ", xglc="
            + this.xglc
            + ", hkje="
            + this.hkje
            + ", xgfj="
            + this.xgfj
            + ", oaSupplierPaymentDTO="
            + this.oaSupplierPaymentDTO
            + ")";
      }
   }
}
