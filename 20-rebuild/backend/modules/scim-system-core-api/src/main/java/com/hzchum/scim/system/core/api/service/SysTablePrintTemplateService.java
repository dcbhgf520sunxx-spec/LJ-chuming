package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.SysTablePrintTemplate;
import com.hzchum.scim.system.core.api.pojo.dto.TablePrintTemplateRequestDTOParam;
import java.util.List;

public interface SysTablePrintTemplateService extends IService<SysTablePrintTemplate> {
   PageVO<SysTablePrintTemplate> list(String name, String type, Boolean enabled, Integer pageNumber, Integer pageSize);

   Boolean save(TablePrintTemplateRequestDTOParam requestVO);

   Boolean update(Long id, TablePrintTemplateRequestDTOParam requestVO);

   Boolean updateEnabled(Long id, Boolean enabled);

   Boolean delete(List<Long> ids);

   ListVO<SysTablePrintTemplate> listByType(String type);

   Boolean setDefault(Integer id, Boolean isDefault);

   ListVO<SysTablePrintTemplate> listByTypes(List<String> types);
}
