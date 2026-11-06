package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("OaProjectInformationRegistrationDTOParam")
public class OaProjectInformationRegistrationDTOParam {
   private String requestName;
   private String title;
   @ApiModelProperty("申请日期")
   private String sqrq;
   @ApiModelProperty("申请人")
   private String sqr;
   @ApiModelProperty("附件")
   private List<OaAttachmentsDTO> fj;
   @ApiModelProperty("备注")
   private String bz;
   @ApiModelProperty("申请人所属公司")
   private String sqrszgs;
   @ApiModelProperty("申请人所属部门")
   private String sqrszbm;
   @ApiModelProperty("项目名称")
   private String xmmc;
   @ApiModelProperty("项目类别")
   private String xmlb;
   @ApiModelProperty("项目归属地")
   private String xmgzd;
   @ApiModelProperty("重点项目")
   private String zdxm;
   @ApiModelProperty("国省市区")
   private String gssq;
   @ApiModelProperty("详细地址")
   private String xxdz;
   @ApiModelProperty("项目概况")
   private String xmgk;
   @ApiModelProperty("预估工程量（吨）")
   private String yggcld;
   @ApiModelProperty("建筑面积（平方米）")
   private String jzmjpfm;
   @ApiModelProperty("预计造价（万元）")
   private String ygzjwy;
   @ApiModelProperty("承建类别")
   private String cjlb;
   @ApiModelProperty("结构类型")
   private String jglx;
   @ApiModelProperty("建筑形式")
   private String jzxs;
   @ApiModelProperty("所属行业")
   private String szxy;
   @ApiModelProperty("项目信息来源")
   private String xmxxly;
   @ApiModelProperty("相关单位")
   private String xgdw;
   @ApiModelProperty("是否项目经理配合")
   private String sfxmjlph;
   @ApiModelProperty("项目经理名称")
   private String xmjlmc;
   @ApiModelProperty("招标方式")
   private String zbfs;
   @ApiModelProperty("建设单位/设计单位/总包单位")
   private String jsdwsjdwzbdw;
   @ApiModelProperty("联系人名称")
   private String lxrmc;
   @ApiModelProperty("联系人职务")
   private String lxrzw;
   @ApiModelProperty("联系人电话")
   private String lxrdh;

   public static OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder builder() {
      return new OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder();
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

   public List<OaAttachmentsDTO> getFj() {
      return this.fj;
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

   public String getXmlb() {
      return this.xmlb;
   }

   public String getXmgzd() {
      return this.xmgzd;
   }

   public String getZdxm() {
      return this.zdxm;
   }

   public String getGssq() {
      return this.gssq;
   }

   public String getXxdz() {
      return this.xxdz;
   }

   public String getXmgk() {
      return this.xmgk;
   }

   public String getYggcld() {
      return this.yggcld;
   }

   public String getJzmjpfm() {
      return this.jzmjpfm;
   }

   public String getYgzjwy() {
      return this.ygzjwy;
   }

   public String getCjlb() {
      return this.cjlb;
   }

   public String getJglx() {
      return this.jglx;
   }

   public String getJzxs() {
      return this.jzxs;
   }

   public String getSzxy() {
      return this.szxy;
   }

   public String getXmxxly() {
      return this.xmxxly;
   }

   public String getXgdw() {
      return this.xgdw;
   }

   public String getSfxmjlph() {
      return this.sfxmjlph;
   }

   public String getXmjlmc() {
      return this.xmjlmc;
   }

   public String getZbfs() {
      return this.zbfs;
   }

   public String getJsdwsjdwzbdw() {
      return this.jsdwsjdwzbdw;
   }

   public String getLxrmc() {
      return this.lxrmc;
   }

   public String getLxrzw() {
      return this.lxrzw;
   }

   public String getLxrdh() {
      return this.lxrdh;
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

   public void setFj(final List<OaAttachmentsDTO> fj) {
      this.fj = fj;
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

   public void setXmlb(final String xmlb) {
      this.xmlb = xmlb;
   }

   public void setXmgzd(final String xmgzd) {
      this.xmgzd = xmgzd;
   }

   public void setZdxm(final String zdxm) {
      this.zdxm = zdxm;
   }

   public void setGssq(final String gssq) {
      this.gssq = gssq;
   }

   public void setXxdz(final String xxdz) {
      this.xxdz = xxdz;
   }

   public void setXmgk(final String xmgk) {
      this.xmgk = xmgk;
   }

   public void setYggcld(final String yggcld) {
      this.yggcld = yggcld;
   }

   public void setJzmjpfm(final String jzmjpfm) {
      this.jzmjpfm = jzmjpfm;
   }

   public void setYgzjwy(final String ygzjwy) {
      this.ygzjwy = ygzjwy;
   }

   public void setCjlb(final String cjlb) {
      this.cjlb = cjlb;
   }

   public void setJglx(final String jglx) {
      this.jglx = jglx;
   }

   public void setJzxs(final String jzxs) {
      this.jzxs = jzxs;
   }

   public void setSzxy(final String szxy) {
      this.szxy = szxy;
   }

   public void setXmxxly(final String xmxxly) {
      this.xmxxly = xmxxly;
   }

   public void setXgdw(final String xgdw) {
      this.xgdw = xgdw;
   }

   public void setSfxmjlph(final String sfxmjlph) {
      this.sfxmjlph = sfxmjlph;
   }

   public void setXmjlmc(final String xmjlmc) {
      this.xmjlmc = xmjlmc;
   }

   public void setZbfs(final String zbfs) {
      this.zbfs = zbfs;
   }

   public void setJsdwsjdwzbdw(final String jsdwsjdwzbdw) {
      this.jsdwsjdwzbdw = jsdwsjdwzbdw;
   }

   public void setLxrmc(final String lxrmc) {
      this.lxrmc = lxrmc;
   }

   public void setLxrzw(final String lxrzw) {
      this.lxrzw = lxrzw;
   }

   public void setLxrdh(final String lxrdh) {
      this.lxrdh = lxrdh;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaProjectInformationRegistrationDTOParam)) {
         return false;
      }

      OaProjectInformationRegistrationDTOParam other = (OaProjectInformationRegistrationDTOParam)o;
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
                  Object this$fj = this.getFj();
                  Object other$fj = other.getFj();
                  if (this$fj == null ? other$fj == null : this$fj.equals(other$fj)) {
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
                                 Object this$xmlb = this.getXmlb();
                                 Object other$xmlb = other.getXmlb();
                                 if (this$xmlb == null ? other$xmlb == null : this$xmlb.equals(other$xmlb)) {
                                    Object this$xmgzd = this.getXmgzd();
                                    Object other$xmgzd = other.getXmgzd();
                                    if (this$xmgzd == null ? other$xmgzd == null : this$xmgzd.equals(other$xmgzd)) {
                                       Object this$zdxm = this.getZdxm();
                                       Object other$zdxm = other.getZdxm();
                                       if (this$zdxm == null ? other$zdxm == null : this$zdxm.equals(other$zdxm)) {
                                          Object this$gssq = this.getGssq();
                                          Object other$gssq = other.getGssq();
                                          if (this$gssq == null ? other$gssq == null : this$gssq.equals(other$gssq)) {
                                             Object this$xxdz = this.getXxdz();
                                             Object other$xxdz = other.getXxdz();
                                             if (this$xxdz == null ? other$xxdz == null : this$xxdz.equals(other$xxdz)) {
                                                Object this$xmgk = this.getXmgk();
                                                Object other$xmgk = other.getXmgk();
                                                if (this$xmgk == null ? other$xmgk == null : this$xmgk.equals(other$xmgk)) {
                                                   Object this$yggcld = this.getYggcld();
                                                   Object other$yggcld = other.getYggcld();
                                                   if (this$yggcld == null ? other$yggcld == null : this$yggcld.equals(other$yggcld)) {
                                                      Object this$jzmjpfm = this.getJzmjpfm();
                                                      Object other$jzmjpfm = other.getJzmjpfm();
                                                      if (this$jzmjpfm == null ? other$jzmjpfm == null : this$jzmjpfm.equals(other$jzmjpfm)) {
                                                         Object this$ygzjwy = this.getYgzjwy();
                                                         Object other$ygzjwy = other.getYgzjwy();
                                                         if (this$ygzjwy == null ? other$ygzjwy == null : this$ygzjwy.equals(other$ygzjwy)) {
                                                            Object this$cjlb = this.getCjlb();
                                                            Object other$cjlb = other.getCjlb();
                                                            if (this$cjlb == null ? other$cjlb == null : this$cjlb.equals(other$cjlb)) {
                                                               Object this$jglx = this.getJglx();
                                                               Object other$jglx = other.getJglx();
                                                               if (this$jglx == null ? other$jglx == null : this$jglx.equals(other$jglx)) {
                                                                  Object this$jzxs = this.getJzxs();
                                                                  Object other$jzxs = other.getJzxs();
                                                                  if (this$jzxs == null ? other$jzxs == null : this$jzxs.equals(other$jzxs)) {
                                                                     Object this$szxy = this.getSzxy();
                                                                     Object other$szxy = other.getSzxy();
                                                                     if (this$szxy == null ? other$szxy == null : this$szxy.equals(other$szxy)) {
                                                                        Object this$xmxxly = this.getXmxxly();
                                                                        Object other$xmxxly = other.getXmxxly();
                                                                        if (this$xmxxly == null ? other$xmxxly == null : this$xmxxly.equals(other$xmxxly)) {
                                                                           Object this$xgdw = this.getXgdw();
                                                                           Object other$xgdw = other.getXgdw();
                                                                           if (this$xgdw == null ? other$xgdw == null : this$xgdw.equals(other$xgdw)) {
                                                                              Object this$sfxmjlph = this.getSfxmjlph();
                                                                              Object other$sfxmjlph = other.getSfxmjlph();
                                                                              if (this$sfxmjlph == null
                                                                                 ? other$sfxmjlph == null
                                                                                 : this$sfxmjlph.equals(other$sfxmjlph)) {
                                                                                 Object this$xmjlmc = this.getXmjlmc();
                                                                                 Object other$xmjlmc = other.getXmjlmc();
                                                                                 if (this$xmjlmc == null
                                                                                    ? other$xmjlmc == null
                                                                                    : this$xmjlmc.equals(other$xmjlmc)) {
                                                                                    Object this$zbfs = this.getZbfs();
                                                                                    Object other$zbfs = other.getZbfs();
                                                                                    if (this$zbfs == null ? other$zbfs == null : this$zbfs.equals(other$zbfs)) {
                                                                                       Object this$jsdwsjdwzbdw = this.getJsdwsjdwzbdw();
                                                                                       Object other$jsdwsjdwzbdw = other.getJsdwsjdwzbdw();
                                                                                       if (this$jsdwsjdwzbdw == null
                                                                                          ? other$jsdwsjdwzbdw == null
                                                                                          : this$jsdwsjdwzbdw.equals(other$jsdwsjdwzbdw)) {
                                                                                          Object this$lxrmc = this.getLxrmc();
                                                                                          Object other$lxrmc = other.getLxrmc();
                                                                                          if (this$lxrmc == null
                                                                                             ? other$lxrmc == null
                                                                                             : this$lxrmc.equals(other$lxrmc)) {
                                                                                             Object this$lxrzw = this.getLxrzw();
                                                                                             Object other$lxrzw = other.getLxrzw();
                                                                                             if (this$lxrzw == null
                                                                                                ? other$lxrzw == null
                                                                                                : this$lxrzw.equals(other$lxrzw)) {
                                                                                                Object this$lxrdh = this.getLxrdh();
                                                                                                Object other$lxrdh = other.getLxrdh();
                                                                                                return this$lxrdh == null
                                                                                                   ? other$lxrdh == null
                                                                                                   : this$lxrdh.equals(other$lxrdh);
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
      return other instanceof OaProjectInformationRegistrationDTOParam;
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
      Object $fj = this.getFj();
      result = result * 59 + ($fj == null ? 43 : $fj.hashCode());
      Object $bz = this.getBz();
      result = result * 59 + ($bz == null ? 43 : $bz.hashCode());
      Object $sqrszgs = this.getSqrszgs();
      result = result * 59 + ($sqrszgs == null ? 43 : $sqrszgs.hashCode());
      Object $sqrszbm = this.getSqrszbm();
      result = result * 59 + ($sqrszbm == null ? 43 : $sqrszbm.hashCode());
      Object $xmmc = this.getXmmc();
      result = result * 59 + ($xmmc == null ? 43 : $xmmc.hashCode());
      Object $xmlb = this.getXmlb();
      result = result * 59 + ($xmlb == null ? 43 : $xmlb.hashCode());
      Object $xmgzd = this.getXmgzd();
      result = result * 59 + ($xmgzd == null ? 43 : $xmgzd.hashCode());
      Object $zdxm = this.getZdxm();
      result = result * 59 + ($zdxm == null ? 43 : $zdxm.hashCode());
      Object $gssq = this.getGssq();
      result = result * 59 + ($gssq == null ? 43 : $gssq.hashCode());
      Object $xxdz = this.getXxdz();
      result = result * 59 + ($xxdz == null ? 43 : $xxdz.hashCode());
      Object $xmgk = this.getXmgk();
      result = result * 59 + ($xmgk == null ? 43 : $xmgk.hashCode());
      Object $yggcld = this.getYggcld();
      result = result * 59 + ($yggcld == null ? 43 : $yggcld.hashCode());
      Object $jzmjpfm = this.getJzmjpfm();
      result = result * 59 + ($jzmjpfm == null ? 43 : $jzmjpfm.hashCode());
      Object $ygzjwy = this.getYgzjwy();
      result = result * 59 + ($ygzjwy == null ? 43 : $ygzjwy.hashCode());
      Object $cjlb = this.getCjlb();
      result = result * 59 + ($cjlb == null ? 43 : $cjlb.hashCode());
      Object $jglx = this.getJglx();
      result = result * 59 + ($jglx == null ? 43 : $jglx.hashCode());
      Object $jzxs = this.getJzxs();
      result = result * 59 + ($jzxs == null ? 43 : $jzxs.hashCode());
      Object $szxy = this.getSzxy();
      result = result * 59 + ($szxy == null ? 43 : $szxy.hashCode());
      Object $xmxxly = this.getXmxxly();
      result = result * 59 + ($xmxxly == null ? 43 : $xmxxly.hashCode());
      Object $xgdw = this.getXgdw();
      result = result * 59 + ($xgdw == null ? 43 : $xgdw.hashCode());
      Object $sfxmjlph = this.getSfxmjlph();
      result = result * 59 + ($sfxmjlph == null ? 43 : $sfxmjlph.hashCode());
      Object $xmjlmc = this.getXmjlmc();
      result = result * 59 + ($xmjlmc == null ? 43 : $xmjlmc.hashCode());
      Object $zbfs = this.getZbfs();
      result = result * 59 + ($zbfs == null ? 43 : $zbfs.hashCode());
      Object $jsdwsjdwzbdw = this.getJsdwsjdwzbdw();
      result = result * 59 + ($jsdwsjdwzbdw == null ? 43 : $jsdwsjdwzbdw.hashCode());
      Object $lxrmc = this.getLxrmc();
      result = result * 59 + ($lxrmc == null ? 43 : $lxrmc.hashCode());
      Object $lxrzw = this.getLxrzw();
      result = result * 59 + ($lxrzw == null ? 43 : $lxrzw.hashCode());
      Object $lxrdh = this.getLxrdh();
      return result * 59 + ($lxrdh == null ? 43 : $lxrdh.hashCode());
   }

   @Override
   public String toString() {
      return "OaProjectInformationRegistrationDTOParam(requestName="
         + this.getRequestName()
         + ", title="
         + this.getTitle()
         + ", sqrq="
         + this.getSqrq()
         + ", sqr="
         + this.getSqr()
         + ", fj="
         + this.getFj()
         + ", bz="
         + this.getBz()
         + ", sqrszgs="
         + this.getSqrszgs()
         + ", sqrszbm="
         + this.getSqrszbm()
         + ", xmmc="
         + this.getXmmc()
         + ", xmlb="
         + this.getXmlb()
         + ", xmgzd="
         + this.getXmgzd()
         + ", zdxm="
         + this.getZdxm()
         + ", gssq="
         + this.getGssq()
         + ", xxdz="
         + this.getXxdz()
         + ", xmgk="
         + this.getXmgk()
         + ", yggcld="
         + this.getYggcld()
         + ", jzmjpfm="
         + this.getJzmjpfm()
         + ", ygzjwy="
         + this.getYgzjwy()
         + ", cjlb="
         + this.getCjlb()
         + ", jglx="
         + this.getJglx()
         + ", jzxs="
         + this.getJzxs()
         + ", szxy="
         + this.getSzxy()
         + ", xmxxly="
         + this.getXmxxly()
         + ", xgdw="
         + this.getXgdw()
         + ", sfxmjlph="
         + this.getSfxmjlph()
         + ", xmjlmc="
         + this.getXmjlmc()
         + ", zbfs="
         + this.getZbfs()
         + ", jsdwsjdwzbdw="
         + this.getJsdwsjdwzbdw()
         + ", lxrmc="
         + this.getLxrmc()
         + ", lxrzw="
         + this.getLxrzw()
         + ", lxrdh="
         + this.getLxrdh()
         + ")";
   }

   public OaProjectInformationRegistrationDTOParam() {
   }

   public OaProjectInformationRegistrationDTOParam(
      final String requestName,
      final String title,
      final String sqrq,
      final String sqr,
      final List<OaAttachmentsDTO> fj,
      final String bz,
      final String sqrszgs,
      final String sqrszbm,
      final String xmmc,
      final String xmlb,
      final String xmgzd,
      final String zdxm,
      final String gssq,
      final String xxdz,
      final String xmgk,
      final String yggcld,
      final String jzmjpfm,
      final String ygzjwy,
      final String cjlb,
      final String jglx,
      final String jzxs,
      final String szxy,
      final String xmxxly,
      final String xgdw,
      final String sfxmjlph,
      final String xmjlmc,
      final String zbfs,
      final String jsdwsjdwzbdw,
      final String lxrmc,
      final String lxrzw,
      final String lxrdh
   ) {
      this.requestName = requestName;
      this.title = title;
      this.sqrq = sqrq;
      this.sqr = sqr;
      this.fj = fj;
      this.bz = bz;
      this.sqrszgs = sqrszgs;
      this.sqrszbm = sqrszbm;
      this.xmmc = xmmc;
      this.xmlb = xmlb;
      this.xmgzd = xmgzd;
      this.zdxm = zdxm;
      this.gssq = gssq;
      this.xxdz = xxdz;
      this.xmgk = xmgk;
      this.yggcld = yggcld;
      this.jzmjpfm = jzmjpfm;
      this.ygzjwy = ygzjwy;
      this.cjlb = cjlb;
      this.jglx = jglx;
      this.jzxs = jzxs;
      this.szxy = szxy;
      this.xmxxly = xmxxly;
      this.xgdw = xgdw;
      this.sfxmjlph = sfxmjlph;
      this.xmjlmc = xmjlmc;
      this.zbfs = zbfs;
      this.jsdwsjdwzbdw = jsdwsjdwzbdw;
      this.lxrmc = lxrmc;
      this.lxrzw = lxrzw;
      this.lxrdh = lxrdh;
   }

   public static class OaProjectInformationRegistrationDTOParamBuilder {
      private String requestName;
      private String title;
      private String sqrq;
      private String sqr;
      private List<OaAttachmentsDTO> fj;
      private String bz;
      private String sqrszgs;
      private String sqrszbm;
      private String xmmc;
      private String xmlb;
      private String xmgzd;
      private String zdxm;
      private String gssq;
      private String xxdz;
      private String xmgk;
      private String yggcld;
      private String jzmjpfm;
      private String ygzjwy;
      private String cjlb;
      private String jglx;
      private String jzxs;
      private String szxy;
      private String xmxxly;
      private String xgdw;
      private String sfxmjlph;
      private String xmjlmc;
      private String zbfs;
      private String jsdwsjdwzbdw;
      private String lxrmc;
      private String lxrzw;
      private String lxrdh;

      OaProjectInformationRegistrationDTOParamBuilder() {
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder requestName(final String requestName) {
         this.requestName = requestName;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder sqrq(final String sqrq) {
         this.sqrq = sqrq;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder sqr(final String sqr) {
         this.sqr = sqr;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder fj(final List<OaAttachmentsDTO> fj) {
         this.fj = fj;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder bz(final String bz) {
         this.bz = bz;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder sqrszgs(final String sqrszgs) {
         this.sqrszgs = sqrszgs;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder sqrszbm(final String sqrszbm) {
         this.sqrszbm = sqrszbm;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder xmmc(final String xmmc) {
         this.xmmc = xmmc;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder xmlb(final String xmlb) {
         this.xmlb = xmlb;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder xmgzd(final String xmgzd) {
         this.xmgzd = xmgzd;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder zdxm(final String zdxm) {
         this.zdxm = zdxm;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder gssq(final String gssq) {
         this.gssq = gssq;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder xxdz(final String xxdz) {
         this.xxdz = xxdz;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder xmgk(final String xmgk) {
         this.xmgk = xmgk;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder yggcld(final String yggcld) {
         this.yggcld = yggcld;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder jzmjpfm(final String jzmjpfm) {
         this.jzmjpfm = jzmjpfm;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder ygzjwy(final String ygzjwy) {
         this.ygzjwy = ygzjwy;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder cjlb(final String cjlb) {
         this.cjlb = cjlb;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder jglx(final String jglx) {
         this.jglx = jglx;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder jzxs(final String jzxs) {
         this.jzxs = jzxs;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder szxy(final String szxy) {
         this.szxy = szxy;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder xmxxly(final String xmxxly) {
         this.xmxxly = xmxxly;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder xgdw(final String xgdw) {
         this.xgdw = xgdw;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder sfxmjlph(final String sfxmjlph) {
         this.sfxmjlph = sfxmjlph;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder xmjlmc(final String xmjlmc) {
         this.xmjlmc = xmjlmc;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder zbfs(final String zbfs) {
         this.zbfs = zbfs;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder jsdwsjdwzbdw(final String jsdwsjdwzbdw) {
         this.jsdwsjdwzbdw = jsdwsjdwzbdw;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder lxrmc(final String lxrmc) {
         this.lxrmc = lxrmc;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder lxrzw(final String lxrzw) {
         this.lxrzw = lxrzw;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder lxrdh(final String lxrdh) {
         this.lxrdh = lxrdh;
         return this;
      }

      public OaProjectInformationRegistrationDTOParam build() {
         return new OaProjectInformationRegistrationDTOParam(
            this.requestName,
            this.title,
            this.sqrq,
            this.sqr,
            this.fj,
            this.bz,
            this.sqrszgs,
            this.sqrszbm,
            this.xmmc,
            this.xmlb,
            this.xmgzd,
            this.zdxm,
            this.gssq,
            this.xxdz,
            this.xmgk,
            this.yggcld,
            this.jzmjpfm,
            this.ygzjwy,
            this.cjlb,
            this.jglx,
            this.jzxs,
            this.szxy,
            this.xmxxly,
            this.xgdw,
            this.sfxmjlph,
            this.xmjlmc,
            this.zbfs,
            this.jsdwsjdwzbdw,
            this.lxrmc,
            this.lxrzw,
            this.lxrdh
         );
      }

      @Override
      public String toString() {
         return "OaProjectInformationRegistrationDTOParam.OaProjectInformationRegistrationDTOParamBuilder(requestName="
            + this.requestName
            + ", title="
            + this.title
            + ", sqrq="
            + this.sqrq
            + ", sqr="
            + this.sqr
            + ", fj="
            + this.fj
            + ", bz="
            + this.bz
            + ", sqrszgs="
            + this.sqrszgs
            + ", sqrszbm="
            + this.sqrszbm
            + ", xmmc="
            + this.xmmc
            + ", xmlb="
            + this.xmlb
            + ", xmgzd="
            + this.xmgzd
            + ", zdxm="
            + this.zdxm
            + ", gssq="
            + this.gssq
            + ", xxdz="
            + this.xxdz
            + ", xmgk="
            + this.xmgk
            + ", yggcld="
            + this.yggcld
            + ", jzmjpfm="
            + this.jzmjpfm
            + ", ygzjwy="
            + this.ygzjwy
            + ", cjlb="
            + this.cjlb
            + ", jglx="
            + this.jglx
            + ", jzxs="
            + this.jzxs
            + ", szxy="
            + this.szxy
            + ", xmxxly="
            + this.xmxxly
            + ", xgdw="
            + this.xgdw
            + ", sfxmjlph="
            + this.sfxmjlph
            + ", xmjlmc="
            + this.xmjlmc
            + ", zbfs="
            + this.zbfs
            + ", jsdwsjdwzbdw="
            + this.jsdwsjdwzbdw
            + ", lxrmc="
            + this.lxrmc
            + ", lxrzw="
            + this.lxrzw
            + ", lxrdh="
            + this.lxrdh
            + ")";
      }
   }
}
