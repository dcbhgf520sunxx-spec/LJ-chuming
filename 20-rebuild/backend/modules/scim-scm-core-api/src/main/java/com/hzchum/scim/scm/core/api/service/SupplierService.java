package com.hzchum.scim.scm.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierAllBriefDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierDetailDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.BatchSaveSupplierDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SupplierDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SupplierEvaluateQueryParam;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface SupplierService extends IService<Supplier> {
   PageVO<SupplierDTO> pageInfo(Integer pageNumber, Integer pageSize, List<String> sort, Boolean boolHide, String name);

   List<Supplier> listInfo(Boolean supplierStatus, String supplierName);

   SupplierDetailDTO listById(Long id);

   Boolean saveSupplier(SupplierDTOParam supplierDTOParam);

   Boolean batchSaveSupplier(List<BatchSaveSupplierDTOParam> dtoParams);

   Boolean updateSupplier(SupplierDTOParam supplierDTOParam);

   Boolean updateSupplier(Long id, Boolean boolHide);

   Boolean delete(List<Long> ids);

   ListVO<SupplierAllBriefDTO> getAllBrief();

   ListVO<SupplierAllBriefDTO> getByType(Integer basicClass);

   String getNameById(Long id);

   String getShortNameById(Long id);

   ListVO<SupplierAllBriefDTO> getBoolAnnual(Integer boolAnnual);

   List<SupplierAllBriefDTO> getListBriefByIds(List<Long> ids);

   void exportSupplierTemplate(HttpServletResponse response);

   void importSupplier(MultipartFile file, HttpServletResponse response);

   void supplierExcel(Boolean boolHide, String name, HttpServletResponse response);

   PageVO<SupplierAllBriefDTO> getEvaluateSupplierList(SupplierEvaluateQueryParam param);
}
