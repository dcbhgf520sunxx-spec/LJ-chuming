package com.hzchum.scim.crm.core.biz.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.utils.HttpUtils;
import com.hzchum.scim.crm.core.api.biz.CrmBusinessLicenseInformationBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBusinessLicenseQueryConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBusinessLicenseQueryLogBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseinquiriesConfigBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBusinessLicenseInformation;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBusinessLicenseQueryLog;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseinquiriesConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBusinessLicenseInformationDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBusinessLicenseInformationPageDTO;
import com.hzchum.scim.crm.core.api.service.CrmBusinessLicenseInformationService;
import com.hzchum.scim.crm.core.mapper.CrmBusinessLicenseInformationMapper;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysCity;
import com.hzchum.scim.system.core.api.pojo._do.SysProvince;
import com.hzchum.scim.system.core.api.pojo._do.SysRegion;
import com.hzchum.scim.system.core.api.service.SysCityService;
import com.hzchum.scim.system.core.api.service.SysProvinceService;
import com.hzchum.scim.system.core.api.service.SysRegionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import jodd.util.StringUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmBusinessLicenseInformationBizImpl
   extends IBizImpl<CrmBusinessLicenseInformationService, CrmBusinessLicenseInformationMapper, CrmBusinessLicenseInformation>
   implements CrmBusinessLicenseInformationBiz {
   @Value("${enterpriseInquiries.host}")
   private String host;
   @Value("${enterpriseInquiries.path}")
   private String path;
   @Resource
   private CrmBusinessLicenseQueryLogBiz crmBusinessLicenseQueryLogBiz;
   @Resource
   private CrmBusinessLicenseQueryConfigBiz crmBusinessLicenseQueryConfigBiz;
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private SysProvinceService sysProvinceService;
   @Resource
   private SysCityService sysCityService;
   @Resource
   private SysRegionService sysRegionService;
   @Resource
   private CrmEnterpriseinquiriesConfigBiz crmEnterpriseinquiriesConfigBiz;
   @Resource
   private RedisUtils redisUtils;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public CrmBusinessLicenseInformationDetailDTO queryBusinessLicenseInformation(String companyNameOrCreditCode) {
      try {
         List<CrmBusinessLicenseInformation> list = this.baseService
            .list(
               Wrappers.lambdaQuery(CrmBusinessLicenseInformation.class)
                  .eq(CrmBusinessLicenseInformation::getCompanyName, companyNameOrCreditCode)
                  .or()
                  .eq(CrmBusinessLicenseInformation::getCreditCode, companyNameOrCreditCode)
            );
         boolean isFilingRecord = false;
         CrmEnterpriseinquiriesConfig crmEnterpriseinquiriesConfig = this.crmEnterpriseinquiriesConfigBiz
            .getOne(Wrappers.lambdaQuery(CrmEnterpriseinquiriesConfig.class));
         Preconditions.checkArgument(crmEnterpriseinquiriesConfig != null && StringUtil.isNotBlank(crmEnterpriseinquiriesConfig.getAppCode()), "当前暂未配置工商密钥");
         if (CollectionUtil.isNotEmpty(list)) {
            Preconditions.checkArgument(list.size() == 1, "在我方商务库存中查询到多个数据请重新填写");
            CrmBusinessLicenseInformationDetailDTO crmBusinessLicenseInformationDetailDTO = BeanUtil.copy(
               list.get(0), CrmBusinessLicenseInformationDetailDTO.class
            );
            CrmEnterpriseWarehousing crmEnterpriseWarehousingBizOne = this.crmEnterpriseWarehousingBiz
               .getOne(
                  Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
                     .eq(CrmEnterpriseWarehousing::getCreditCode, crmBusinessLicenseInformationDetailDTO.getCreditCode())
               );
            isFilingRecord = crmEnterpriseWarehousingBizOne != null;
            crmBusinessLicenseInformationDetailDTO.setIsFilingRecord(isFilingRecord);
            return crmBusinessLicenseInformationDetailDTO;
         } else {
            Object o = this.redisUtils.get("CRM_INQUIRE_INTERVAL:");
            Preconditions.checkArgument(o == null, "短时间内多人使用,请在5秒后重试!!!!!!");
            Boolean aBoolean = this.crmBusinessLicenseQueryConfigBiz.whetherItIsCappedOrNot();
            Preconditions.checkArgument(aBoolean, "今日查询次数超过配置次数");
            Map<String, String> headers = new HashMap<>();
            headers.put("Authorization", "APPCODE " + crmEnterpriseinquiriesConfig.getAppCode());
            Map<String, String> querys = new HashMap<>();
            querys.put("keyword", companyNameOrCreditCode);
            HttpResponse response = null;
            response = HttpUtils.doGet(this.host, this.path, "GET", headers, querys);
            Preconditions.checkArgument(response.getStatusLine().getStatusCode() != 403, "三方API欠费请充值");
            String content = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = JSON.parseObject(content);
            Preconditions.checkArgument(jsonObject != null, "查询失败,请检验code码是否正确!!!");
            this.checkArg(jsonObject.getString("code"));
            JSONObject data = JSON.parseObject(jsonObject.getString("data"));
            String info = data.getString("info");
            CrmBusinessLicenseInformationDetailDTO crmBusinessLicenseInformationDetailDTO1 = this.setIndustryAndContacts(
               JSONObject.parseObject(info, CrmBusinessLicenseInformationDetailDTO.class), info
            );
            CrmEnterpriseWarehousing crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz
               .getOne(
                  Wrappers.lambdaQuery(CrmEnterpriseWarehousing.class)
                     .eq(CrmEnterpriseWarehousing::getCreditCode, crmBusinessLicenseInformationDetailDTO1.getCreditCode())
               );
            isFilingRecord = crmEnterpriseWarehousing != null;
            crmBusinessLicenseInformationDetailDTO1.setIsFilingRecord(isFilingRecord);
            Preconditions.checkArgument(StringUtil.isNotBlank(crmBusinessLicenseInformationDetailDTO1.getCreditCode()), "当前企业缺少统一社会信用代码不可使用!!!");
            this.baseService.save(BeanUtil.copy(crmBusinessLicenseInformationDetailDTO1, CrmBusinessLicenseInformation.class));
            this.crmBusinessLicenseQueryLogBiz
               .save(CrmBusinessLicenseQueryLog.builder().userId(UserUtil.getCurrentUserId()).type("查询").queryArg(companyNameOrCreditCode).build());
            this.redisUtils.set("CRM_INQUIRE_INTERVAL:", "", 5L);
            return crmBusinessLicenseInformationDetailDTO1;
         }
      } catch (Throwable $ex) {
         throw CrmBusinessLicenseInformationBizImpl.<RuntimeException>rethrow($ex);
      }
   }

   @Override
   public PageVO<CrmBusinessLicenseInformationPageDTO> pageList(String companyName, String creditCode, Integer pageNumber, Integer pageSize) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<CrmBusinessLicenseInformation> crmBusinessLicenseInformations = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmBusinessLicenseInformation.class)
               .like(StringUtil.isNotBlank(companyName), CrmBusinessLicenseInformation::getCompanyName, companyName)
               .like(StringUtil.isNotBlank(creditCode), CrmBusinessLicenseInformation::getCreditCode, creditCode)
               .orderByDesc(BaseEntity::getUpdateTime)
         );
      return new PageVO<>(
         objects,
         crmBusinessLicenseInformations.stream().map(item -> BeanUtil.copy(item, CrmBusinessLicenseInformationPageDTO.class)).collect(Collectors.toList())
      );
   }

   private CrmBusinessLicenseInformationDetailDTO setIndustryAndContacts(
      CrmBusinessLicenseInformationDetailDTO crmBusinessLicenseInformationDetailDTO, String info
   ) {
      try {
         JSONObject jsonObject = JSONObject.parseObject(info);
         JSONObject industry = JSONObject.parseObject(jsonObject.getString("industry"));
         crmBusinessLicenseInformationDetailDTO.setIndustry(industry.getString("industry"));
         crmBusinessLicenseInformationDetailDTO.setSubIndustry(industry.getString("subIndustry"));
         crmBusinessLicenseInformationDetailDTO.setMiddleCategory(industry.getString("middleCategory"));
         crmBusinessLicenseInformationDetailDTO.setSmallCategory(industry.getString("smallCategory"));
         Map<String, List> data = new ObjectMapper().readValue(jsonObject.getString("contacts"), Map.class);
         if (data != null) {
            List addressArray = data.get("address");
            if (addressArray != null && addressArray.size() > 0) {
               Map<String, String> addressMap = (Map<String, String>)addressArray.get(0);
               String addressValue = addressMap.get("value");
               crmBusinessLicenseInformationDetailDTO.setAddress(addressValue);
            }

            List phoneNumberArray = data.get("phoneNumber");
            if (phoneNumberArray != null && phoneNumberArray.size() > 0) {
               Map<String, String> phoneNumberMap = (Map<String, String>)phoneNumberArray.get(0);
               String phoneNumberValue = phoneNumberMap.get("value");
               crmBusinessLicenseInformationDetailDTO.setPhoneNumber(phoneNumberValue);
            }

            List emailArray = data.get("email");
            if (emailArray != null && emailArray.size() > 0) {
               Map<String, String> emailMap = (Map<String, String>)emailArray.get(0);
               String emailValue = emailMap.get("value");
               crmBusinessLicenseInformationDetailDTO.setEmail(emailValue);
            }
         }

         if (StringUtil.isNotBlank(crmBusinessLicenseInformationDetailDTO.getProvinceCode())) {
            SysProvince provinceServiceOne = this.sysProvinceService
               .getOne(Wrappers.lambdaQuery(SysProvince.class).eq(SysProvince::getCode, crmBusinessLicenseInformationDetailDTO.getProvinceCode()));
            if (provinceServiceOne != null) {
               crmBusinessLicenseInformationDetailDTO.setProvinceId(provinceServiceOne.getId());
            }
         }

         if (StringUtil.isNotBlank(crmBusinessLicenseInformationDetailDTO.getCity())) {
            SysCity city = this.sysCityService
               .getOne(Wrappers.lambdaQuery(SysCity.class).eq(SysCity::getCode, crmBusinessLicenseInformationDetailDTO.getCity()));
            if (city != null) {
               crmBusinessLicenseInformationDetailDTO.setCityId(city.getId());
            }
         }

         if (StringUtil.isNotBlank(crmBusinessLicenseInformationDetailDTO.getDistrictCode())) {
            SysRegion region = this.sysRegionService
               .getOne(Wrappers.lambdaQuery(SysRegion.class).eq(SysRegion::getCode, crmBusinessLicenseInformationDetailDTO.getDistrictCode()));
            if (region != null) {
               crmBusinessLicenseInformationDetailDTO.setDistrictId(region.getId());
            }
         }

         return crmBusinessLicenseInformationDetailDTO;
      } catch (Throwable $ex) {
         throw CrmBusinessLicenseInformationBizImpl.<RuntimeException>rethrow($ex);
      }
   }

   public void checkArg(String code) {
      if ("2".equals(code)) {
         Preconditions.checkArgument(false, "三方查询结果为空，请重新确认信用代码以及公司名称");
      }

      if ("1".equals(code)) {
         Preconditions.checkArgument(false, "三方查询参数错误，请联系管理人员");
      }

      if ("3".equals(code)) {
         Preconditions.checkArgument(false, "三方服务异常，请联系管理人员");
      }

      if ("6".equals(code)) {
         Preconditions.checkArgument(false, "三方服务调用频率超限");
      }

      if ("11".equals(code)) {
         Preconditions.checkArgument(false, "三方服务系统异常");
      }
   }

   @Transactional
   @Override
   public Boolean updateInfo(Long id) throws Exception {
      Object o = this.redisUtils.get("CRM_INQUIRE_INTERVAL:");
      Preconditions.checkArgument(o == null, "短时间内多人使用,请在5秒后重试!!!!!!");
      CrmBusinessLicenseInformation licenseInformation = this.baseService.getById(id);
      Preconditions.checkArgument(licenseInformation != null, "工商信息不存在");
      CrmEnterpriseinquiriesConfig crmEnterpriseinquiriesConfig = this.crmEnterpriseinquiriesConfigBiz
         .getOne(Wrappers.lambdaQuery(CrmEnterpriseinquiriesConfig.class));
      Preconditions.checkArgument(crmEnterpriseinquiriesConfig != null && StringUtil.isNotBlank(crmEnterpriseinquiriesConfig.getAppCode()), "当前暂未配置工商密钥");
      Boolean aBoolean = this.crmBusinessLicenseQueryConfigBiz.whetherItIsCappedOrNot();
      Preconditions.checkArgument(aBoolean, "今日查询次数超过配置次数");
      Map<String, String> headers = new HashMap<>();
      headers.put("Authorization", "APPCODE " + crmEnterpriseinquiriesConfig.getAppCode());
      Map<String, String> querys = new HashMap<>();
      querys.put("keyword", licenseInformation.getCreditCode());
      HttpResponse response = HttpUtils.doGet(this.host, this.path, "GET", headers, querys);
      Preconditions.checkArgument(response != null && response.getStatusLine().getStatusCode() == 200, "三方API异常请联系管理人员");
      String content = EntityUtils.toString(response.getEntity());
      JSONObject jsonObject = JSON.parseObject(content);
      this.checkArg(jsonObject.getString("code"));
      JSONObject data = JSON.parseObject(jsonObject.getString("data"));
      String info = data.getString("info");
      CrmBusinessLicenseInformationDetailDTO crmBusinessLicenseInformationDetailDTO = this.setIndustryAndContacts(
         JSONObject.parseObject(info, CrmBusinessLicenseInformationDetailDTO.class), info
      );
      this.crmBusinessLicenseQueryLogBiz
         .save(CrmBusinessLicenseQueryLog.builder().userId(UserUtil.getCurrentUserId()).type("查询").queryArg(licenseInformation.getCreditCode()).build());
      Integer version = licenseInformation.getVersion();
      BeanUtil.copy(crmBusinessLicenseInformationDetailDTO, licenseInformation);
      licenseInformation.setVersion(version);
      licenseInformation.setId(id);
      this.redisUtils.set("CRM_INQUIRE_INTERVAL:", "", 5L);
      return this.baseService.updateById(licenseInformation);
   }
   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }
}
