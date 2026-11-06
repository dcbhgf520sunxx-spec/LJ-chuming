package com.hzchum.scim.wms.core.service.impl.wmsUse;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Supplement;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.SupplementDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsUse.SupplementService;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsUse.SupplementMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SupplementServiceImpl extends ServiceImpl<SupplementMapper, Supplement> implements SupplementService {
   @Resource
   SupplementMapper supplementMapper;
   @Resource
   ClassificationService classificationService;
   @Resource
   QueryUtilService queryUtilService;

   @Override
   public PageVO<SupplementDTO> pageInfo(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.queryUtilService.getLateClassificationList(param.getClassifyId()));
      String s = StringUtils.analyzeSortConditions(sort);
      Page<SupplementDTO> page = PageHelper.startPage(pageNumber, pageSize, s);
      return new PageVO<>(page, this.supplementMapper.list(param));
   }

   @Override
   public SupplementDTO selectById(Long id) {
      return this.supplementMapper.getById(id);
   }
}
