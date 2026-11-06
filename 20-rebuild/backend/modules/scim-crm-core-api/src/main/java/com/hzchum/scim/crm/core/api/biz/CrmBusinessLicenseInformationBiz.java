package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBusinessLicenseInformation;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBusinessLicenseInformationDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmBusinessLicenseInformationPageDTO;

public interface CrmBusinessLicenseInformationBiz extends IBiz<CrmBusinessLicenseInformation> {
   CrmBusinessLicenseInformationDetailDTO queryBusinessLicenseInformation(String companyNameOrCreditCode);

   PageVO<CrmBusinessLicenseInformationPageDTO> pageList(String companyName, String creditCode, Integer pageNumber, Integer pageSize);

   Boolean updateInfo(Long id) throws Exception;
}
