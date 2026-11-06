import { p as P, F as r, bc as a, bn as i, bo as $, bk as T } from "../shared/runtime.js";
import { l as n } from "./label-logo-8a01bd73.js";
const b = { projectName: "项目名称", printTime: P((/* @__PURE__ */ new Date()).getTime(), "{y}/{m}/{d}"), monomerName: "单体名称", serialNumber: "编号", oneCode: "X/X", name: "XX", quantity: "XX", weight: "XX", length: "XX", thickness: "XX", plate: "XX", color: "XX", specification: "XX", areaName: "XX" }, w = function({ component: l = b, productionLineName: s, logo: d = n, manufacturerPhone: c, manufacturerURL: o, printConfig: e, manufacturerName: v = "制造商名称" }) {
  return `
<div class="box-label">
<div class="row row-3">
  <div class="col" style="flex: 2;border:none;">
    <img src="${d}" style="height:70%;max-width: 96%;vertical-align: middle;">
  </div>
  <div class="col qr-content" style="flex: 1">
  </div>
</div>
<div class="row">
  <div class="col">项目：${i(l.projectName)}</div>
</div>
<div class="row" style="${e != null && e.showMonomer ? "" : "display:none;"}">
  <div class="col" style="${e != null && e.showMonomer ? "" : "display:none;"}">区域：${i(l.monomerName)}-${i(l.areaName)}</div>
</div>
<div class="row">
  <div class="col" style="font-size:18pt;">编号：${i(l.serialNumber)}</div>
</div>
<div class="row" style="font-weight:bold;font-size:14pt;">
  <div class="col">长度(mm)：</div>
  <div class="col">宽度(mm)：</div>
  <div class="col">高度(mm)：</div>
</div>
<div class="row" style="font-weight:bold;">
  <div class="col">${i(l.length)}</div>
  <div class="col">${i(l.width)}</div>
  <div class="col">${i(l.thickness)}</div>
</div>
<div class="row" style="${(e == null ? void 0 : e.weight) !== $.NONE.V || l != null && l.oneCode ? "" : "display:none;"}">
 <div class="col" style="${(e == null ? void 0 : e.weight) !== $.NONE.V ? "" : "display:none;"};${l != null && l.oneCode ? "" : "border:none;"}">单重(kg)：${i(l.weight)}</div>
 <div class="col" style="${l != null && l.oneCode ? "" : "display:none;"}">编码：${l.oneCode}</div>
</div>
<div class="row" style="${e != null && e.dateInProduced ? "" : "display:none;"}">
  <div class="col" style="${e != null && e.dateInProduced ? "" : "display:none;"}">生产日期：${i(l.printTime)}</div>
</div>
<div class="row" style="${e != null && e.showProductionLine ? "" : "display:none;"}">
  <div class="col" style="${e != null && e.showProductionLine ? "" : "display:none;"}">生产线：${i(s)}</div>
</div>
<div class="row">
  <div class="col">${i(v)}</div>
</div>
<div class="row">
  <div class="col" style="display:flex;">
    <span style="flex:1">${i(o)}</span>
    <span style="flex:1">${i(c)}</span>
 </div>
</div>
</div>
`;
}, y = function({ component: l = b, printConfig: s }) {
  return `
<div class="box-label">
<div class="row">
  <div class="col">
    <span style="font-size: 60px; font-weight: 600;">${i(l.serialNumber)}</span>
  </div>
</div>
<div class="row">
  <div class="col" style="flex:2;flex-direction:column;">
    <span style="${s != null && s.dateInProduced ? "" : "display:none;"}">
      生产日期：${i(l.printTime)}
    </span>
    <span style="${l != null && l.oneCode ? "" : "display:none;"}">
      编码：${l.oneCode}
    </span>
  </div>
  <div class="col qr-content" style="flex:1;">
  </div>
</div>
</div>
`;
}, h = function({ component: l = b, printConfig: s, manufacturerName: d = "制造商名称", logo: c = n }) {
  return `
  <div class="box-label">
  <div class="row">
    <div class="col" style="justify-content:center;">
      <img src="${c}" alt="logo" style="height:70%;max-width: 96%;vertical-align: middle;">
    </div>
    <div class="col" style="font-size:10pt;">${i(d)}</div>
  </div>
  <div class="row row-2">
    <div class="col amplify-content">
      <span class="amplify-no">NO:</span>
      <span class="amplify-text">${i(l.serialNumber)}</span>
      <span class="amplify-date" style="${s != null && s.dateInProduced ? "" : "display:none;"}">生产日期：${i(l.printTime)}</span>
    </div>
  </div>
  <div class="row">
    <div class="col" style="${s != null && s.showMonomer ? "" : "border:none;"}">${i(l.projectName)}</div>
    <div class="col" style="${s != null && s.showMonomer ? "" : "display:none;"}">${i(l.monomerName)}</div>
  </div>
  <div class="contains-rows">
    <div class="col" style="flex: 2">
      <div class="row">
        <div class="col" style="${s != null && s.showArea ? "" : "display:none;"}">区域：${i(l.areaName)}</div>
        <div class="col" style="${l != null && l.oneCode ? "" : "display:none;"}">编码：${l.oneCode}</div>
      </div>
      <div class="row">
        <div class="col">任务数(件)：${i(l.quantity)}</div>
        <div class="col">长度(mm)：${i(l.length)}</div>
        <div class="col" style="${(s == null ? void 0 : s.weight) !== $.NONE.V ? "" : "display:none;"}">单重(kg)：${i(l.weight)}</div>
      </div>
      <div class="row">
        <div class="col">${i(l.name)}</div>
        <div class="col">${i(l.specification)}</div>
      </div>
    </div>
    <div class="col" style="flex: 1">
      <div class="row row-3">
        <div class="col qr-content">
        </div>
      </div>
    </div>
  </div>
  </div>
  `;
}, t = function({ fClass: l = "", colContent: s = "start", rowHeight: d = 60, colPadding: c = 10, unit: o = "px", qrPosition: e = {} }) {
  return { fClass: l, qrPosition: e, style: `
    <style>
    .${l} .box-label {
      font-family: "微软雅黑";
      font-size: 15pt;
      color: black;
      box-sizing: border-box;
      display: flex;
      flex-direction: column;
    }
    
    .${l} .box-label .row {
      display: flex;
      border: 1px solid #000;
      box-sizing: border-box;
      height: ${d}${o};
    }
    
    .${l} .box-label .row-2 {
      height: ${d * 2}${o};
    }
    
    .${l} .box-label .row-3 {
      height: ${d * 3}${o};
    }
    
    .${l} .box-label .row:not(:last-child) {
      border-bottom: none;
    }
  
    .${l} .box-label .row > .col {
      height: 100%;
      padding: 0 ${c}${o};
      box-sizing: border-box;
      word-break: break-all;
      flex: 1;
      display: flex;
      align-items: center;
      justify-content: ${s};
    }
      
    .${l} .box-label .row > .col:not(:last-child) {
      border-right: 1px solid #000;
    }
  
    .${l} .box-label .amplify-content{
      position:relative;
    }
  
    .${l} .box-label .amplify-content .amplify-no{
      position: absolute; 
      top: 5px;
      font-size:7pt;
    }
  
    .${l} .box-label .amplify-content .amplify-text{
      font-size: 40px; 
      line-height: 36px;
      font-weight: 600; 
    }
  
    .${l} .box-label .amplify-content .amplify-date{
      position: absolute; 
      bottom: 5px; 
      right: 10px;
      font-size:7pt;
    }
    
    .${l} .box-label .contains-rows {
      display: flex;
      box-sizing: border-box;
      border-left: 1px solid #000;
    }
    
    .${l} .box-label .contains-rows .row {
      border-left: none;
    }
    .${l} .box-label .contains-rows .col {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: stretch;
    }
    </style>
    ` };
}, E = function({ component: l = b, printConfig: s }) {
  return `
  <div class="aux-mat-label">
    <div class="row">
      <div class="col col-center" style="font-size:10pt;">${i(l.projectName)}</div>
    </div>
    <div class="row">
      <div class="col col-center" style="font-size:10pt;">${i(l.monomerName)}</div>
    </div>
    <div class="contains-rows">
      <div class="col" style="flex: 2">
        <div class="row row-3">
          <div class="col" style="font-size:20pt;text-align:center;font-weight: 600;">${i(l.name)}</div>
        </div>
        <div class="row">
          <div class="col">规格：${i(l.specification)}</div>
          <div class="col">总数：${i(l.quantity)}</div>
        </div>
        <div class="row">
          <div class="col">颜色：${i(l.color)}</div>
          <div class="col">品牌：${i(l.brand)}</div>
        </div>
      </div>
      <div class="col" style="flex: 1">
        <div class="row row-5">
          <div class="col qr-content">
          </div>
        </div>
      </div>
    </div>
  </div>
  `;
}, M = function({ fClass: l = "", colContent: s = "start", rowHeight: d = 60, colPadding: c = 10, unit: o = "px", qrPosition: e = {} }) {
  return { fClass: l, qrPosition: e, style: `
    <style>
    .${l} .aux-mat-label {
      font-family: "微软雅黑";
      font-size: 9pt;
      color: black;
      box-sizing: border-box;
      display: flex;
      flex-direction: column;
    }
    
    .${l} .aux-mat-label .row {
      display: flex;
      border: 1px solid #000;
      box-sizing: border-box;
      height: ${d}${o};
    }
    
    .${l} .aux-mat-label .row-2 {
      height: ${d * 2}${o};
    }
    
    .${l} .aux-mat-label .row-3 {
      height: ${d * 3}${o};
    }
    
    .${l} .aux-mat-label .row-5 {
      height: ${d * 5}${o};
    }
    
    .${l} .aux-mat-label .row:not(:last-child) {
      border-bottom: none;
    }
  
    .${l} .aux-mat-label .row > .col {
      height: 100%;
      padding: 0 ${c}${o};
      box-sizing: border-box;
      word-break: break-all;
      flex: 1;
      display: flex;
      align-items: center;
      justify-content: ${s};
    }
  
    .${l} .aux-mat-label .row > .col-center {
      justify-content: center;
    }
      
    .${l} .aux-mat-label .row > .col:not(:last-child) {
      border-right: 1px solid #000;
    }
    
    .${l} .aux-mat-label .contains-rows {
      display: flex;
      box-sizing: border-box;
      border-left: 1px solid #000;
    }
    
    .${l} .aux-mat-label .contains-rows .row {
      border-left: none;
    }
    .${l} .aux-mat-label .contains-rows .col {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: stretch;
    }
    </style>
    ` };
}, x = { [r.BOX.V]: { [a.COMMON.V]: w, [a.SIMPLE.V]: y, [a.CUSTOM.V]: h }, [r.MACHINE_PART.V]: { [a.COMMON.V]: w, [a.SIMPLE.V]: y, [a.CUSTOM.V]: h }, [r.AUXILIARY_MATERIAL.V]: { [a.COMMON.V]: E, [a.SIMPLE.V]: "", [a.CUSTOM.V]: "" } }, X = { [r.BOX.V]: { [a.COMMON.V]: t({ fClass: "pre-com-al", qrPosition: { right: "18px", top: "6px", size: 140 }, rowHeight: 50 }), [a.SIMPLE.V]: t({ fClass: "pre-sim-al", qrPosition: { right: "18px", bottom: "8px", size: 160 }, rowHeight: 210, colContent: "center" }), [a.CUSTOM.V]: t({ fClass: "pre-cus-al", qrPosition: { right: "18px", bottom: "8px", size: 160 }, rowHeight: 60 }) }, [r.MACHINE_PART.V]: { [a.COMMON.V]: t({ fClass: "pre-com-al", qrPosition: { right: "18px", bottom: "8px", size: 160 }, rowHeight: 60 }), [a.SIMPLE.V]: t({ fClass: "pre-sim-al", qrPosition: { right: "18px", bottom: "8px", size: 160 }, rowHeight: 210, colContent: "center" }), [a.CUSTOM.V]: t({ fClass: "pre-cus-al", qrPosition: { right: "18px", bottom: "8px", size: 160 }, rowHeight: 60 }) }, [r.AUXILIARY_MATERIAL.V]: { [a.COMMON.V]: M({ fClass: "pre-com-al", qrPosition: { right: "20px", bottom: "65px", size: 160 }, rowHeight: 60 }) } }, I = { [r.BOX.V]: { [a.COMMON.V]: t({ fClass: "mini-com-al", rowHeight: 30 }), [a.SIMPLE.V]: t({ fClass: "mini-sim-al", rowHeight: 140, colContent: "center" }), [a.CUSTOM.V]: t({ fClass: "mini-cus-al", rowHeight: 40 }) }, [r.MACHINE_PART.V]: { [a.COMMON.V]: t({ fClass: "mini-com-al", rowHeight: 40 }), [a.SIMPLE.V]: t({ fClass: "mini-sim-al", rowHeight: 140, colContent: "center" }), [a.CUSTOM.V]: t({ fClass: "mini-cus-al", rowHeight: 40 }) } }, H = { [r.BOX.V]: { [a.COMMON.V]: t({ fClass: "print-com-al", rowHeight: 14, colPadding: 1, unit: "mm" }), [a.SIMPLE.V]: t({ fClass: "print-sim-al", rowHeight: 32, colPadding: 1, colContent: "center", unit: "mm" }), [a.CUSTOM.V]: t({ fClass: "print-cus-al", rowHeight: 9, colPadding: 1, unit: "mm" }) }, [r.MACHINE_PART.V]: { [a.COMMON.V]: t({ fClass: "print-com-al", rowHeight: 9, colPadding: 1, unit: "mm" }), [a.SIMPLE.V]: t({ fClass: "print-sim-al", rowHeight: 32, colPadding: 1, colContent: "center", unit: "mm" }), [a.CUSTOM.V]: t({ fClass: "print-cus-al", rowHeight: 9, colPadding: 1, unit: "mm" }) }, [r.AUXILIARY_MATERIAL.V]: { [a.COMMON.V]: M({ fClass: "print-com-al", rowHeight: 9, colPadding: 1, unit: "mm" }), [a.SIMPLE.V]: "", [a.CUSTOM.V]: "" } };
function z({ productType: l, labelType: s, labelData: d }) {
  const c = x[l][s]({ ...d }), { style: o, fClass: e, qrPosition: v } = X[l][s];
  return { showHtml: `
    <div class="${e}">
      ${c}
    </div>
    ${o}
  `, qrPosition: v };
}
function S({ productType: l, labelType: s, labelData: d }) {
  const c = x[l][s]({ ...d }), { style: o, fClass: e } = I[l][s];
  return `
    <div class="${e}">
     ${c}
    </div>
    ${o}
  `;
}
function g({ productType: l, labelType: s, component: d, productionLineName: c, logo: o, manufacturerPhone: e, manufacturerURL: v, manufacturerName: m, printConfig: u }) {
  const O = x[l][s]({ component: d, productionLineName: c, logo: o, manufacturerPhone: e, manufacturerURL: v, manufacturerName: m, printConfig: u }), { style: L, fClass: V } = H[l][s], N = `
    <div class="${V}">
      ${O}
    </div>`;
  return T(L, N);
}
export {
  z as a,
  S as b,
  g
};
