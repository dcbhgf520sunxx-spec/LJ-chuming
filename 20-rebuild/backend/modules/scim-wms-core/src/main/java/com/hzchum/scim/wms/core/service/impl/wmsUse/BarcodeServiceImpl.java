package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialIsWholeEnum;
import com.hzchum.scim.wms.core.api.enums.PrintMaterialTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Barcode;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.service.wmsUse.BarcodeService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.mapper.wmsUse.BarcodeMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BarcodeServiceImpl extends ServiceImpl<BarcodeMapper, Barcode> implements BarcodeService {
   @Resource
   private BarcodeMapper barcodeMapper;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public String generateBarcodeByMaterial(MaterialInventory materialInventory) {
      if (materialInventory == null) {
         return null;
      }

      Integer materialIsWhole = materialInventory.getMaterialIsWhole();
      Barcode param = BeanUtil.copy(materialInventory, Barcode.class);
      if (BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass())) {
         param.setBasicClass(3);
      }

      if (materialInventory.getProjectId() != null) {
         int type;
         if (materialInventory.getBoolPartyA()) {
            type = MaterialIsWholeEnum.WHOLE.getType().equals(materialIsWhole)
               ? PrintMaterialTypeEnum.A_COMPLETE.getType()
               : PrintMaterialTypeEnum.A_SURPLUS.getType();
         } else {
            type = MaterialIsWholeEnum.WHOLE.getType().equals(materialIsWhole)
               ? PrintMaterialTypeEnum.PROJECT_COMPLETE.getType()
               : PrintMaterialTypeEnum.PROJECT_SURPLUS.getType();
         }

         param.setType(type);
         Barcode barcode = this.barcodeMapper.getByMaterial(param);
         if (barcode != null) {
            return barcode.getValue();
         }

         Barcode copy = BeanUtil.copy(materialInventory, Barcode.class);
         List<Barcode> bs = this.barcodeMapper
            .selectList(
               (Wrapper<Barcode>)(((Wrappers.<Barcode>lambdaQuery()
                           .eq(
                              Barcode::getBasicClass,
                              BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()) ? 3 : materialInventory.getBasicClass()
                           ))
                        .eq(Barcode::getType, type))
                     .eq(Barcode::getProjectId, materialInventory.getProjectId()))
                  .orderByDesc(Barcode::getAfterSerialNumber)
            );
         if (CollectionUtil.isNotEmpty(bs)) {
            copy.setAfterSerialNumber(bs.get(0).getAfterSerialNumber() + 1L);
            copy.setFrontSerialNumber(bs.get(0).getFrontSerialNumber());
         } else {
            List<Barcode> ps = this.barcodeMapper
               .selectList((Wrapper<Barcode>)Wrappers.<Barcode>lambdaQuery().eq(Barcode::getProjectId, materialInventory.getProjectId()));
            if (CollectionUtil.isNotEmpty(ps)) {
               copy.setFrontSerialNumber(ps.get(0).getFrontSerialNumber());
            } else {
               List<Barcode> barcodes = this.barcodeMapper
                  .selectList(
                     (Wrapper<Barcode>)(Wrappers.<Barcode>lambdaQuery().isNotNull(Barcode::getProjectId)).orderByDesc(Barcode::getFrontSerialNumber)
                  );
               copy.setFrontSerialNumber(CollectionUtil.isNotEmpty(barcodes) ? barcodes.get(0).getFrontSerialNumber() + 1L : 1L);
            }

            copy.setAfterSerialNumber(1L);
         }

         copy.setType(type);
         copy.setBasicClass(BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()) ? 3 : materialInventory.getBasicClass());
         copy.setValue(
            ""
               + copy.getBasicClass()
               + type
               + CommonUtil.getProjectZeroStr(copy.getFrontSerialNumber())
               + CommonUtil.getProjectZeroStr(copy.getAfterSerialNumber())
         );
         this.barcodeMapper.insert(copy);
         return copy.getValue();
      } else {
         int type = MaterialIsWholeEnum.WHOLE.getType().equals(materialIsWhole)
            ? PrintMaterialTypeEnum.PUBLIC_COMPLETE.getType()
            : PrintMaterialTypeEnum.PUBLIC_SURPLUS.getType();
         param.setType(type);
         Barcode barcode = this.barcodeMapper.getByMaterial(param);
         if (barcode != null) {
            return barcode.getValue();
         }

         Barcode copy = BeanUtil.copy(materialInventory, Barcode.class);
         List<Barcode> bs = this.barcodeMapper
            .selectList(
               (Wrapper<Barcode>)((Wrappers.<Barcode>lambdaQuery()
                        .eq(
                           Barcode::getBasicClass,
                           BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()) ? 3 : materialInventory.getBasicClass()
                        ))
                     .eq(Barcode::getType, type))
                  .orderByDesc(Barcode::getPublicSerialNumber)
            );
         if (CollectionUtil.isNotEmpty(bs)) {
            copy.setPublicSerialNumber(bs.get(0).getPublicSerialNumber() + 1L);
         } else {
            copy.setPublicSerialNumber(1L);
         }

         copy.setType(type);
         copy.setBasicClass(BasicClassEnum.COLOR_ROLL.getType().equals(materialInventory.getBasicClass()) ? 3 : materialInventory.getBasicClass());
         copy.setValue("" + copy.getBasicClass() + type + CommonUtil.getZeroStr(copy.getPublicSerialNumber()));
         this.barcodeMapper.insert(copy);
         return copy.getValue();
      }
   }
}
