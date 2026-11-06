import { p as O, a3 as r, bh as a, bn as l, bo as b, j as z } from "../shared/runtime.js";
import { l as u } from "./label-logo-8a01bd73.js";
import { c as m } from "./index-f09320a8.js";
import { computed as H } from "vue";
import { watch as _ } from "vue";
const y = { projectName: "项目名称", printTime: O((/* @__PURE__ */ new Date()).getTime(), "{y}/{m}/{d}"), monomerName: "单体名称", serialNumber: "编号", oneCode: "X/X", name: "XX", quantity: "XX", weight: "XX", length: "XX", thickness: "XX", plate: "XX", color: "XX", specification: "XX", areaName: "XX", productionLineName: "XX" }, x = function({ component: t = y, printConfig: e, manufacturerName: i = "制造商名称" }) {
  var s, $;
  const d = m(e);
  return `
  <div class="artifact-label">
    <table class="artifact-table">
      <tr>
        <td class="label-project-head" style="width:100%; font-size:${U(t.projectName.length + t.monomerName.length + t.areaName.length)}; font-weight: 600;">
          <span>${l(t.projectName)}</span>
          <span style="${e != null && e.showMonomer ? "" : "display:none;"}"> > </span>
          <span style="${e != null && e.showMonomer ? "" : "display:none;"}">${l(t.monomerName)}</span>
          <span style="${e != null && e.showArea ? "" : "display:none;"}"> > </span>
          <span style="${e != null && e.showArea ? "" : "display:none;"}">${l(t.areaName)}</span>
        </td>
      </tr>
    </table>
    <table class="artifact-table">
      <tr class="row-2">
        <td colspan="3" class="amplify-content">
          <span class="amplify-text" style="font-size:${E(t.serialNumber.length)};">${l(t.serialNumber)}</span>
          <div class="amplify-repair" style="${t != null && t.isReturnRepair ? "" : "display:none;"}">
            返厂维修
          </div>
          <span class="amplify-date" style="${e != null && e.dateInProduced ? "" : "display:none;"}">(${t.oneCode}) ${d("productionDate")}：${l(t.printTime)}</span>
        </td>
      </tr>
    </table>
    <table class="artifact-table">
      <tr>
        <td style="${(e == null ? void 0 : e.weight) !== b.NONE.V ? "width:20%;" : ""} font-weight: 700">${l(t.name)}</td>
        <td style="${(e == null ? void 0 : e.weight) !== b.NONE.V ? "width:30%;" : ""};">${d("length")}(mm)：${l(t.length)}</td>
        <td style="${(e == null ? void 0 : e.weight) !== b.NONE.V ? "width:20%;" : ""};${t != null && t.oneCode ? "display:none;" : ""}">${d("taskNum")}：${l(t.quantity)}</td>
        <td style="${(e == null ? void 0 : e.weight) !== b.NONE.V ? "width:30%;" : "display:none;"}">${d("SingleWeight")}(kg)：${l(t.weight)}</td>
      </tr>
    </table>
    <table class="artifact-table">
      <tr>
        <td style="width:66.66%">${d("Specifications")}：${l(t.specification)}</td>
        <td rowspan="3" class="qr-content"></td>
      </tr>
      <tr>
        <td style="font-size:${q((s = t.areaBatch) == null ? void 0 : s.name.length)}; font-weight: 600; width:66.66%">
          <span>${e != null && e.showBatch && l(($ = t.areaBatch) == null ? void 0 : $.name) || ""}</span>
        </td>
      </tr>
      <tr>
        <td style="width:66.66%">${l(i)}</td>
      </tr>
    </table>
  </div>
`;
}, T = function({ component: t = y, printConfig: e }) {
  const i = m(e);
  return `
  <div class="artifact-label">
    <table class="artifact-table">
      <tr>
        <td colspan="2" style="font-size: 40px; font-weight: 600;">${l(t.serialNumber)}</td>
      </tr>
      <tr>
        <td style="width:66.66%">
          <span style="${e != null && e.dateInProduced ? "" : "display:none;"}">
            ${i("productionDate")}：${l(t.printTime)}
          </span>
          <span style="${t != null && t.oneCode ? "" : "display:none;"}">
            ${i("code")}：${t.oneCode}
          </span>
        </td>
        <td class="qr-content"></td>
      </tr>
    </table>
  </div>
  `;
}, L = function({ component: t = y, printConfig: e, manufacturerName: i = "制造商名称", logo: d = u }) {
  const s = m(e);
  return `
  <div class="artifact-label">
    <table class="artifact-table">
      <tr>
        <td style="width:50%;"><img src="${d}" alt="logo" style="max-width: 96%;vertical-align: middle;display: block;margin: auto;" /></td>
        <td style="width:50%;font-size:10pt;">${l(i)}</td>
      </tr>
    </table>
    <table class="artifact-table">
      <tr class="row-2">
        <td colspan="3" class="amplify-content">
          <span class="amplify-no">NO:</span>
          <span class="amplify-text" style="font-size:${E(t.serialNumber.length)};">${l(t.serialNumber)}</span>
          <div class="amplify-repair" style="${t != null && t.isReturnRepair ? "" : "display:none;"}">
            返厂维修
          </div>   
          <span class="amplify-date" style="${e != null && e.dateInProduced ? "" : "display:none;"}">${s("productionDate")}：${l(t.printTime)}</span>
        </td>
      </tr>
    </table>
    <table class="artifact-table">
      <tr>
        <td style="width:50%;font-size:10pt;">${l(t.projectName)}</td>
        <td style="width:50%;font-size:10pt;${e != null && e.showMonomer ? "" : "display:none;"}">${l(t.monomerName)}</td>
      </tr>
    </table>
    <table class="artifact-table">
      <tr>
        <td colspan="${e != null && e.showArea && (t != null && t.oneCode) ? 1 : 2}" style="${e != null && e.showArea ? "" : "display:none;"}">${s("region")}：${l(t.areaName)}</td>
        <td colspan="${e != null && e.showArea && (t != null && t.oneCode) ? 1 : 2}" style="${t != null && t.oneCode ? "" : "display:none;"}">${s("code")}：${t.oneCode}</td>
        <td rowspan="3" class="qr-content"></td>
      </tr>
      <tr>
        <td colspan="2" style="font-size:0;padding:0px;border-bottom:none;${!(e != null && e.showArea) && !(t != null && t.oneCode) ? "border-top:1px solid #000;" : ""}">
          <table class="artifact-table">
            <tr>
              <td style="${(e == null ? void 0 : e.weight) !== b.NONE.V ? "" : "width:50%;"}">${s("taskNum")}：${l(t.quantity)}</td>
              <td style="${(e == null ? void 0 : e.weight) !== b.NONE.V ? "" : "width:50%;border-right:none;"}">${s("length")}(mm)：${l(t.length)}</td>
              <td style="${(e == null ? void 0 : e.weight) !== b.NONE.V ? "border-right:none;" : "display:none;"}">${s("SingleWeight")}(kg)：${l(t.weight)}</td>
            </tr>
          </table>
        </td>
      </tr>
      <tr>
        <td>${l(t.name)}</td>
        <td>${l(t.specification)}</td>
      </tr>
    </table>
  </div>
  `;
}, o = function({ fClass: t = "", colContent: e = "left", rowHeight: i = 60, colPadding: d = 10, unit: s = "px", flexLayout: $ = "", qrPosition: h = {} }) {
  return { fClass: t, qrPosition: h, style: `
    <style>
    .${t} .artifact-label {
      width: 100%;
      font-size: 0;
      border-top: 1px solid #000;
      border-left: 1px solid #000;
    }

    .${t} .artifact-table {
      font-family: "微软雅黑";
      font-size: 8pt;
      color: black;
      width: 100%;
      border-collapse:collapse;
      text-align: ${e};
      vertical-align:middle;
    }
    
    .${t} .artifact-label tr {
      width: 100%;
      height: ${i}${s};
    }

    .${t} .artifact-label img{
      height: ${i * 0.7}${s};
    }
    
    .${t} .artifact-label .row-2 {
      height: ${i * 2}${s};
    }
    
    .${t} .artifact-label .row-3 {
      height: ${i * 3}${s};
    }
  
    .${t} .artifact-label tr td{
      width: 33.333%;
      padding: 0 ${d}${s};
      word-break: break-all;
      border-right: 1px solid #000;
      border-bottom: 1px solid #000;
    }
  
    .${t} .artifact-label .amplify-content{
      position:relative;
      overflow: hidden;
    }
  
    .${t} .artifact-label .amplify-content .amplify-no{
      position: absolute; 
      top: 5px;
      font-size:7pt;
    }
  
    .${t} .artifact-label .amplify-content .amplify-text{
      font-size: 44px; 
      line-height: 22px;
      font-weight: 600; 
    }
  
    .${t} .artifact-label .amplify-content .amplify-repair{
      position: absolute; 
      top: 5px; 
      right: 10px;
      font-size:9pt;
      color: #909399;
      border-radius: 4px;
      border: 1px solid #909399;
      padding: 3px 6px;
      overflow: hidden;
    }

    .${t} .artifact-label .amplify-content .amplify-production-line {
      position: absolute; 
      bottom: 5px; 
      left: 10px;
      font-size:7pt;
    }
  
    .${t} .artifact-label .amplify-content .amplify-date{
      position: absolute; 
      bottom: 4px; 
      right: 8px;
      font-size: 8pt;
    }
    
    .${t} .artifact-label .label-project-head {
      height: ${i}${s};
      padding-top: 2pt;
      padding-bottom: 2pt;
      display: ${$}
    }

    ${t.indexOf("mini") > -1 ? `.${t} .artifact-label .label-project-head {
      white-space: nowrap;
    }` : ""}
    
    ${t.indexOf("mini") > -1 ? `.${t} .artifact-label .label-project-head {
      white-space: nowrap;
    }` : ""}
    </style>
    ` };
}, g = function({ component: t = y, printConfig: e, manufacturerName: i = "制造商名称" }) {
  return `
  <div>
    <table class="enclosure-label">
      <tr>
        <td rowspan="6" class="qr-content">
        </td>
      </tr>
      <tr>
        <td class="row">品名：${l(t.name)}</td>
        <td class="row">编号：${l(t.serialNumber)}</td>
      </tr>
      <tr>
        <td class="row">厚度(mm)：${l(t.thickness)}</td>
        <td class="row">总张数：${l(t.quantity)}</td>
      </tr>
      <tr>
      <tr>
        <td class="row">单长(mm)：${l(t.length)}</td>
        <td class="row">板型：${l(t.plate)}</td>
      </tr>
      <tr>
        <td class="row">颜色：${l(t.color)}</td>
        <td class="row" style="${e != null && e.dateInProduced ? "" : "display:none;"}">生产日期：${l(t.printTime)}</td>
      </tr>
    </table>
  </div>
`;
}, R = function({ component: t = y, printConfig: e, manufacturerName: i = "制造商名称", logo: d = u }) {
  const s = m(e);
  return `
  <div class="enclosure-label">
    <table>
      <tr class="company">
        <td style="width:35%;text-align: center;">
         <img src="${d}" alt="logo" style="height:70%;width:100%;vertical-align: middle;" />
        </td>
      <td style="width:63%; text-align:center;">${l(i)}</td>
    </tr>
    </table>
    <table>
    <tr>
      <td class="row">${s("name")}：${l(t.name)}</td>
      <td class="row">${s("code")}：${l(t.serialNumber)}</td>
    </tr>
    <tr>
      <td class="row">${s("thickness")}(mm)：${l(t.thickness)}</td>
      <td class="row">${s("qr_num")}：${l(t.quantity)}</td>
    </tr>
    <tr>
    <tr>
      <td class="row">${s("qr_len")}(mm)：${l(t.length)}</td>
      <td class="row">${s("plateType")}：${l(t.plate)}</td>
    </tr>
    <tr>
      <td class="row">${s("color")}：${l(t.color)}</td>
      <td class="row" style="${e != null && e.dateInProduced ? "" : "display:none;"}">${s("productionDate")}：${l(t.printTime)}</td>
    </tr>
    <tr>
      <td rowspan="8" class="qr-content">
        </td>
    </tr>
  </table>
  </div>
`;
}, w = function({ fClass: t = "", qrPosition: e = {}, rowHeight: i = 40, headerHeight: d = 180, padding: s = 15, border: $ = 1, unit: h = "px" }) {
  return { fClass: t, qrPosition: e, style: `
    <style>
    .${t} .enclosure-label {
      font-family: "微软雅黑";
      font-size: 9pt;
      color: black;
      width: 100%;
      height: 100%;
      box-sizing: border-box;
      padding: 0 ${s}${h};
      border:${$}px solid #000;
      border-radius: 15px;
    }

    .${t} .company{
      width: 100%;
      font-size: 25pt;
    }

    .${t} .enclosure-label tr {
      width: 33.333%;
    }

    .${t} .enclosure-label tr td {
      width: 33.333%;
      height: 25%
    }

    .${t} .enclosure-label .row {
      height: ${i}${h};
    } 
    </style>
    ` };
}, X = function({ component: t = y, printConfig: e }) {
  return `
  <div class="aux-mat-label">
    <div class="row">
      <div class="col col-center" style="font-size:10pt;">${l(t.projectSN)} ${l(t.projectName)}</div>
    </div>
    <div class="row">
      <div class="col" style="font-size:10pt;">单体：${l(t.monomerName)}</div>
      <div class="col" style="font-size:10pt;">区域：${l(t.areaName)}</div>
    </div>
    <div class="contains-rows">
      <div class="col" style="flex: 2">
        <div class="row row-3">
          <div class="col" style="font-size:20pt;text-align:center;font-weight: 600;">${l(t.name)}</div>
        </div>
        <div class="row">
          <div class="col">规格：${l(t.specification)}</div>
          <div class="col">总数：${l(t.quantity)}</div>
        </div>
        <div class="row">
          <div class="col">单位：${l(t.unit)}</div>
          <div class="col">使用范围：${l(t.useProperty)}</div>
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
}, n = function({ fClass: t = "", colContent: e = "start", rowHeight: i = 60, colPadding: d = 10, unit: s = "px", qrPosition: $ = {} }) {
  return { fClass: t, qrPosition: $, style: `
    <style>
    .${t} .aux-mat-label {
      font-family: "微软雅黑";
      font-size: 9pt;
      color: black;
      box-sizing: border-box;
      display: flex;
      flex-direction: column;
    }
    
    .${t} .aux-mat-label .row {
      display: flex;
      border: 1px solid #000;
      box-sizing: border-box;
      height: ${i}${s};
    }
    
    .${t} .aux-mat-label .row-2 {
      height: ${i * 2}${s};
    }
    
    .${t} .aux-mat-label .row-3 {
      height: ${i * 3}${s};
    }
    
    .${t} .aux-mat-label .row-5 {
      height: ${i * 5}${s};
    }
    
    .${t} .aux-mat-label .row:not(:last-child) {
      border-bottom: none;
    }
  
    .${t} .aux-mat-label .row > .col {
      height: 100%;
      padding: 0 ${d}${s};
      box-sizing: border-box;
      word-break: break-all;
      flex: 1;
      display: flex;
      align-items: center;
      justify-content: ${e};
    }
  
    .${t} .aux-mat-label .row > .col-center {
      justify-content: center;
    }
      
    .${t} .aux-mat-label .row > .col:not(:last-child) {
      border-right: 1px solid #000;
    }
    
    .${t} .aux-mat-label .contains-rows {
      display: flex;
      box-sizing: border-box;
      border-left: 1px solid #000;
    }
    
    .${t} .aux-mat-label .contains-rows .row {
      border-left: none;
    }
    .${t} .aux-mat-label .contains-rows .col {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: stretch;
    }
    </style>
    ` };
}, W = { [r.ARTIFACT.V]: { [a.COMMON.V]: x, [a.SIMPLE.V]: T, [a.CUSTOM.V]: L }, [r.MACHINE_PART.V | r.ASSEMBLE.V]: { [a.COMMON.V]: x, [a.SIMPLE.V]: T, [a.CUSTOM.V]: L }, [r.ENCLOSURE.V]: { [a.COMMON.V]: g, [a.SIMPLE.V]: "", [a.CUSTOM.V]: R }, [r.AUXILIARY_MATERIAL.V]: { [a.COMMON.V]: X, [a.SIMPLE.V]: "", [a.CUSTOM.V]: "" } }, G = { [r.ARTIFACT.V]: { [a.COMMON.V]: o({ fClass: "pre-com-al", qrPosition: { right: "18px", bottom: "8px", size: 160 }, rowHeight: 60 }), [a.SIMPLE.V]: o({ fClass: "pre-sim-al", qrPosition: { right: "18px", bottom: "8px", size: 160 }, rowHeight: 210, colContent: "center" }), [a.CUSTOM.V]: o({ fClass: "pre-cus-al", qrPosition: { right: "18px", bottom: "8px", size: 160 }, rowHeight: 60 }) }, [r.MACHINE_PART.V | r.ASSEMBLE.V]: { [a.COMMON.V]: o({ fClass: "pre-com-al", qrPosition: { right: "18px", bottom: "8px", size: 160 }, rowHeight: 60 }), [a.SIMPLE.V]: o({ fClass: "pre-sim-al", qrPosition: { right: "18px", bottom: "8px", size: 160 }, rowHeight: 210, colContent: "center" }), [a.CUSTOM.V]: o({ fClass: "pre-cus-al", qrPosition: { right: "18px", bottom: "8px", size: 160 }, rowHeight: 60 }) }, [r.ENCLOSURE.V]: { [a.COMMON.V]: w({ fClass: "pre-com-al", qrPosition: { top: "17px", left: "15px", size: 130 }, rowHeight: 40 }), [a.SIMPLE.V]: "", [a.CUSTOM.V]: w({ fClass: "pre-cus-al", qrPosition: { top: "75px", left: "", right: "15px", size: 130 }, rowHeight: 40 }) }, [r.AUXILIARY_MATERIAL.V]: { [a.COMMON.V]: n({ fClass: "pre-com-al", qrPosition: { right: "20px", bottom: "65px", size: 160 }, rowHeight: 60 }) } }, J = { [r.ARTIFACT.V]: { [a.COMMON.V]: o({ fClass: "mini-com-al", rowHeight: 40, flexLayout: "flex" }), [a.SIMPLE.V]: o({ fClass: "mini-sim-al", rowHeight: 140, colContent: "center" }), [a.CUSTOM.V]: o({ fClass: "mini-cus-al", rowHeight: 40 }) }, [r.MACHINE_PART.V | r.ASSEMBLE.V]: { [a.COMMON.V]: o({ fClass: "mini-com-al", rowHeight: 40 }), [a.SIMPLE.V]: o({ fClass: "mini-sim-al", rowHeight: 140, colContent: "center" }), [a.CUSTOM.V]: o({ fClass: "mini-cus-al", rowHeight: 40 }) }, [r.ENCLOSURE.V]: { [a.COMMON.V]: w({ fClass: "mini-com-al", rowHeight: 25 }), [a.SIMPLE.V]: "", [a.CUSTOM.V]: w({ fClass: "mini-cus-al", headerHeight: 25, rowHeight: 25 }) }, [r.AUXILIARY_MATERIAL.V]: { [a.COMMON.V]: n({ fClass: "mini-com-al", rowHeight: 40 }), [a.SIMPLE.V]: "", [a.CUSTOM.V]: "" } }, K = { [r.ARTIFACT.V]: { [a.COMMON.V]: o({ fClass: "print-com-al", rowHeight: 9, colPadding: 1, unit: "mm" }), [a.SIMPLE.V]: o({ fClass: "print-sim-al", rowHeight: 32, colPadding: 1, colContent: "center", unit: "mm" }), [a.CUSTOM.V]: o({ fClass: "print-cus-al", rowHeight: 9, colPadding: 1, unit: "mm" }) }, [r.MACHINE_PART.V | r.ASSEMBLE.V]: { [a.COMMON.V]: o({ fClass: "print-com-al", rowHeight: 9, colPadding: 1, unit: "mm" }), [a.SIMPLE.V]: o({ fClass: "print-sim-al", rowHeight: 32, colPadding: 1, colContent: "center", unit: "mm" }), [a.CUSTOM.V]: o({ fClass: "print-cus-al", rowHeight: 9, colPadding: 1, unit: "mm" }) }, [r.ENCLOSURE.V]: { [a.COMMON.V]: w({ fClass: "print-com-al", rowHeight: 7, padding: 1, border: 0, unit: "mm" }), [a.SIMPLE.V]: "", [a.CUSTOM.V]: w({ fClass: "print-cus-al", headerHeight: 14, padding: 1, rowHeight: 8, border: 0, unit: "mm" }) }, [r.AUXILIARY_MATERIAL.V]: { [a.COMMON.V]: n({ fClass: "print-com-al", rowHeight: 9, colPadding: 1, unit: "mm" }), [a.SIMPLE.V]: "", [a.CUSTOM.V]: "" } };
function U(t) {
  return t < 10 && t > 0 ? "20pt" : t < 20 && t >= 10 ? "12pt" : t < 30 && t >= 20 ? "10pt" : t < 40 && t >= 30 ? "8pt" : "6pt";
}
function E(t) {
  if (t <= 20 && t > 0) return "20pt";
  if (t > 20) return "12pt";
}
function q(t) {
  return t < 15 && t > 0 ? "18px" : t < 25 && t >= 15 ? "15px" : "11px";
}
const F = H(() => z.getters.user.productLabelLogoPath);
let A;
_(() => F.value, (t) => {
  A = t || u;
}, { deep: true, immediate: true });
const p = { projectName: "项目名称", printTime: O((/* @__PURE__ */ new Date()).getTime(), "{y}/{m}/{d}"), monomerName: "单体名称", serialNumber: "编号", oneCode: "X/X", name: "名称", quantity: "XX", weight: "XX", length: "XX", thickness: "XX", plate: "XX", color: "颜色", specification: "规格", areaName: "区域名称" }, S = function({ component: t = p, printConfig: e, manufacturerName: i = "制造商名称", quantityName: d = "任务数(件)" }) {
  const s = m(e);
  return `
  <div class="artifact-label">
    <table class="artifact-table">
      <tr>
        <td class="label-project-head" style="font-size:${j(t.projectName.length)}; font-weight: 600;">
          <span>${l(t.projectName)}</span>
        </td>
      </tr>
    </table>
    <table class="artifact-table">
      <tr class="row-2">
        <td colspan="4" class="amplify-content">
          <span class="amplify-text">${l(t.serialNumber)}</span>
          <span class="amplify-date" style="${e != null && e.dateInProduced ? "" : "display:none;"}">
            ${s("productionDate")}：${l(t.printTime)}
          </span>
        </td>
      </tr>
    </table>
    <table class="artifact-table">
      <tr>
        <td colspan="2">${s("name")}：${l(t.name)}</td>
        <td rowspan="4" class="qr-content"></td>
      </tr>
      <tr>
        <td colspan="${t != null && t.oneCode ? 1 : 2}">${s("num")}：${l(t.quantity)}</td>
        <td style="${t != null && t.oneCode ? "" : "display:none;"}">${s("code")}：${t.oneCode}</td>
      </tr>
      <tr>
        <td colspan="2">${l(t.specification)}</td>
      </tr>
      <tr>
        <td colspan="2">${l(t.monomerName)}>${l(t.areaName)}</td>
      </tr>
    </table>
  </div>
`;
}, V = function({ component: t = p, printConfig: e }) {
  const i = m(e);
  return `
  <div class="artifact-label">
    <table class="artifact-table">
      <tr class="amplify-row">
        <td class="amplify-content" colspan="2">
          <span class="amplify-text">${l(t.serialNumber)}</span>
        </td>
      </tr>
      <tr>
        <td>
          <div style="${e != null && e.dateInProduced ? "" : "display:none;"}">
            ${i("productionDate")}：${l(t.printTime)}
          </div>
          <div style="${t != null && t.oneCode ? "" : "display:none;"}">
            ${i("code")}：${t.oneCode}
          </div>
        </td>
        <td class="qr-content"></td>
      </tr>
    </table>
  </div>
  `;
}, N = function({ component: t = p, printConfig: e, manufacturerName: i = "制造商名称", logo: d = A }) {
  const s = m(e);
  return `
  <div class="artifact-label">
    <table class="artifact-table">
      <tr>
        <td style="width:50%;"><img src="${d}" alt="logo" style="max-width: 96%;vertical-align: middle;display: block;margin: auto;" /></td>
        <td style="width:50%;font-weight:600;">${l(t.projectName)}</td>
      </tr>
    </table>
    <table class="artifact-table">
      <tr class="row-2">
        <td colspan="4" class="amplify-content">
          <span class="amplify-no">NO:</span>
          <span class="amplify-text">${l(t.serialNumber)}</span>
          <span class="amplify-date" style="${e != null && e.dateInProduced ? "" : "display:none;"}">
            ${s("productionDate")}：${l(t.printTime)}
          </span>
        </td>
      </tr>
    </table>
    <table class="artifact-table">
      <tr>
        <td colspan="2">${l(t.monomerName)}</td>
        <td rowspan="4" class="qr-content"></td>
      </tr>
      <tr>
        <td colspan="${t != null && t.oneCode ? 1 : 2}">${l(t.name)}</td>
        <td style="${t != null && t.oneCode ? "" : "display:none;"}">${s("code")}：${t.oneCode}</td>
      </tr>
      <tr>
        <td colspan="2">${s("num")}：${l(t.quantity)}</td>
      </tr>
      <tr>
        <td colspan="2">${l(t.specification)}</td>
      </tr>
    </table>
  </div>
  `;
}, c = function({ fClass: t = "", colContent: e = "left", rowHeight: i = 60, colPadding: d = 10, unit: s = "px", qrPosition: $ = {}, commonFontSize: h = "9pt", noFontSize: M = "7pt", noTop: f = "5px", snFontSize: P = "30px", snLineHeight: I = "22px", isPrint: v = false }) {
  return { fClass: t, qrPosition: $, style: `
    <style>
    .${t} .artifact-label {
      width: 100%;
      font-size: 0;
      border-top: 1px solid #000;
      border-left: 1px solid #000;
    }

    .${t} .artifact-table {
      font-family: "微软雅黑";
      font-size: ${h};
      color: black;
      width: 100%;
      border-collapse:collapse;
      text-align: ${e};
      vertical-align:middle;
    }
    
    .${t} .artifact-label tr {
      width: 100%;
      height: ${i}${s};
    }

    .${t} .artifact-label img{
      // height: ${i * 0.7}${s};
      height: ${i}${s};
    }
    
    .${t} .artifact-label .row-2 {
      height: ${i * 2}${s};
    }
    
    .${t} .artifact-label .row-3 {
      height: ${i * 3}${s};
    }
  
    .${t} .artifact-label tr td{
      padding: 0 ${d}${s};
      word-break: break-all;
      border-right: 1px solid #000;
      border-bottom: 1px solid #000;
    }
  
    .${t} .artifact-label .amplify-content{
      position:relative;
    }
  
    .${t} .artifact-label .amplify-content .amplify-no{
      position: absolute; 
      top: ${f};
      font-size:${M};
    }
  
    .${t} .artifact-label .amplify-content .amplify-text{
      font-size: ${P}; 
      line-height: ${I};
      font-weight: 600; 
    }
  
    .${t} .artifact-label .amplify-content .amplify-date{
      position: absolute; 
      bottom: 5px; 
      right: 10px;
      font-size:${M};
    }

    .${t} .artifact-label .qr-content {
      width: 45%;
    }

    .${t} .artifact-label .label-project-head {
      font-size: ${v ? "7pt !important" : ""};
    }

    ${t.indexOf("mini") > -1 ? `.${t} .artifact-label .label-project-head {
      white-space: nowrap;
    }` : ""}

    ${t.indexOf("print-sim") > -1 ? `.${t} .artifact-label .amplify-row {
    height: 14mm !important;
    }` : ""}

    </style>
    ` };
};
function j(t) {
  return t < 10 && t > 0 ? "20pt" : t < 20 && t >= 10 ? "12pt" : t < 30 && t >= 20 ? "10pt" : t < 40 && t >= 30 ? "8pt" : "6pt";
}
const Q = { [r.ARTIFACT.V]: { [a.COMMON.V]: S, [a.SIMPLE.V]: V, [a.CUSTOM.V]: N }, [r.MACHINE_PART.V | r.ASSEMBLE.V]: { [a.COMMON.V]: S, [a.SIMPLE.V]: V, [a.CUSTOM.V]: N } }, Z = { [r.ARTIFACT.V]: { [a.COMMON.V]: c({ fClass: "pre-com-al", qrPosition: { right: "18px", bottom: "3px", size: 230 }, rowHeight: 60 }), [a.SIMPLE.V]: c({ fClass: "pre-sim-al", qrPosition: { right: "18px", bottom: "3px", size: 205 }, rowHeight: 210, colContent: "center" }), [a.CUSTOM.V]: c({ fClass: "pre-cus-al", qrPosition: { right: "18px", bottom: "3px", size: 230 }, rowHeight: 60 }) }, [r.MACHINE_PART.V | r.ASSEMBLE.V]: { [a.COMMON.V]: c({ fClass: "pre-com-al", qrPosition: { right: "18px", bottom: "3px", size: 230 }, rowHeight: 60 }), [a.SIMPLE.V]: c({ fClass: "pre-sim-al", qrPosition: { right: "18px", bottom: "3px", size: 205 }, rowHeight: 210, colContent: "center" }), [a.CUSTOM.V]: c({ fClass: "pre-cus-al", qrPosition: { right: "18px", bottom: "3px", size: 230 }, rowHeight: 60 }) } }, C = { [r.ARTIFACT.V]: { [a.COMMON.V]: c({ fClass: "mini-com-al", rowHeight: 40 }), [a.SIMPLE.V]: c({ fClass: "mini-sim-al", rowHeight: 140, colContent: "center" }), [a.CUSTOM.V]: c({ fClass: "mini-cus-al", rowHeight: 40 }) }, [r.MACHINE_PART.V | r.ASSEMBLE.V]: { [a.COMMON.V]: c({ fClass: "mini-com-al", rowHeight: 40 }), [a.SIMPLE.V]: c({ fClass: "mini-sim-al", rowHeight: 140, colContent: "center" }), [a.CUSTOM.V]: c({ fClass: "mini-cus-al", rowHeight: 40 }) } }, tt = { [r.ARTIFACT.V]: { [a.COMMON.V]: c({ fClass: "print-com-al", rowHeight: 5, colPadding: 0.5, unit: "mm", commonFontSize: "5pt", noFontSize: "4pt", noTop: "0.2mm", snFontSize: "7pt", snLineHeight: "3mm", isPrint: true }), [a.SIMPLE.V]: c({ fClass: "print-sim-al", rowHeight: 22, colPadding: 0.5, colContent: "center", unit: "mm", commonFontSize: "5pt", noFontSize: "4pt", noTop: "0.2mm", snFontSize: "7pt", snLineHeight: "3mm", isPrint: true }), [a.CUSTOM.V]: c({ fClass: "print-cus-al", rowHeight: 5, colPadding: 0.5, unit: "mm", commonFontSize: "5pt", noFontSize: "4pt", noTop: "0.2mm", snFontSize: "7pt", snLineHeight: "3mm", isPrint: true }) }, [r.MACHINE_PART.V | r.ASSEMBLE.V]: { [a.COMMON.V]: c({ fClass: "print-com-al", rowHeight: 5, colPadding: 0.5, unit: "mm", commonFontSize: "5pt", noFontSize: "4pt", noTop: "0.2mm", snFontSize: "7pt", snLineHeight: "3mm" }), [a.SIMPLE.V]: c({ fClass: "print-sim-al", rowHeight: 32, colPadding: 0.5, colContent: "center", unit: "mm", commonFontSize: "5pt", noFontSize: "4pt", noTop: "0.2mm", snFontSize: "7pt", snLineHeight: "3mm" }), [a.CUSTOM.V]: c({ fClass: "print-cus-al", rowHeight: 5, colPadding: 0.5, unit: "mm", commonFontSize: "5pt", noFontSize: "4pt", noTop: "0.2mm", snFontSize: "7pt", snLineHeight: "3mm" }) } };
export {
  W as L,
  J as M,
  G as P,
  Q as a,
  Z as b,
  C as c,
  K as d,
  tt as e
};
