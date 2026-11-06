import { ElNotification as v } from "element-plus";
import { ref as Q } from "vue";
import { inject as he } from "vue";
import { computed as X } from "vue";
import { reactive as ye } from "vue";
import { provide as ge } from "vue";
import { watch as te } from "vue";
import { nextTick as ie } from "vue";
import { resolveComponent as le } from "vue";
import { openBlock as re } from "vue";
import { createElementBlock as xe } from "vue";
import { createElementVNode as Z } from "vue";
import { renderSlot as _e } from "vue";
import { createVNode as k } from "vue";
import { withCtx as ee } from "vue";
import { createTextVNode as ne } from "vue";
import { unref as U } from "vue";
import { toDisplayString as Ne } from "vue";
import { createBlock as be } from "vue";
import { resolveDynamicComponent as Pe } from "vue";
import { normalizeStyle as Ie } from "vue";
import { Fragment as we } from "vue";
import { ElForm as Ee } from "element-plus";
import { vP as O, j as a, cP as A, V as R, ku as B, z as H, vR as W, i as w, b as K, f3 as D, xy as G, vT as S, aI as z, iX as $, vS as ae, xz as J, am as se, o as ce, cJ as T, vv as Ue, xO as Me, L as Te, cQ as Ve, D as Ce } from "../../../../../../../../shared/runtime.js";
import Le from "./module/other-table.vue.js";
import Fe from "./module/auxiliary-material-table.vue.js";
import $e from "./module/gas-table.vue.js";
import "../price-set-columns.vue.js";
import "../../../../../../../../modules/supplier-select-0ce6adf5.js";
const { handleMeteChangeCalcPrice: Se } = ae("mete");
function Ye(y, E) {
  return Number(y) >= 0;
}
function Ae(y, E) {
  const _ = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], g = y.map((n) => ({ rowIndex: n.rowIndex, error: n.error }));
  v({ type: "error", title: "导入失败,请查看错误清单" }), J({ headers: _, data: g, filename: "辅材盘盈清单-错误清单", sheetName: "错误清单" });
}
const fe = { title: "辅材盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "供应商", field: "supplierName", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], unitPrice: [{ required: true, message: "含税单价不能为空" }, { validator: Ye, message: "含税单价不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (y) => {
  var I;
  if (!O(y, fe.rules)) return;
  a.state.config.loaded.matClsTree || await a.dispatch("config/fetchMatClsTree");
  const _ = a.state.config.rawMatClsList.filter((e) => e.basicClass === A.MATERIAL.V), g = a.state.config.rawMatClsKV, n = R(y), f = [];
  let u = [];
  const b = [], p = [], l = [];
  a.state.config.loaded.workshopNameV2 || await a.dispatch("config/fetchWorkshopNameV2"), a.state.config.loaded.warehouseV2 || await a.dispatch("config/fetchWarehouseV2"), a.state.project.loaded || await a.dispatch("project/fetchUserProjects"), a.state.config.loaded.suppliers || a.dispatch("config/fetchSuppliers");
  const V = a.state.config.workshopNameV2, C = a.state.config.warehouseV2, L = a.state.project.userProjectsMap[B].map((e) => (e.fullName = H(e, null, false), e)), F = a.state.config.suppliers;
  n.forEach((e, c) => {
    let s = false;
    const d = W(e.classifyName.split("/"));
    if (d.length === 1) {
      const i = _.filter((o) => o.name === e.classifyName) || [];
      if (w(i)) if (i.length === 1) s = true, e.classifyId = i[0].id, f.push(i[0].id);
      else {
        const o = [];
        for (const t of i) if (t.isLeaf) for (let r = 0; r < t.fullPathId.length; r++) t.id !== t.fullPathId[r] && o.push(t.fullPathId[r]);
        const h = i.find((t) => K(t.parent) && !o.includes(t.id));
        if (w(h)) s = true, e.classifyId = h.id, f.push(h.id);
        else {
          const t = i.filter((r) => r.isLeaf) || [];
          if (t.length === 1) {
            let r = true;
            i.forEach((M) => {
              t[0].fullPathId.includes(M.id) || (r = false);
            }), r && (s = true, e.classifyId = t[0].id, f.push(t[0].id));
          } else for (const r of i) w(r.parent) && !o.includes(r.id) && b.push(r);
        }
      }
      b.length > 1 && l.push({ rowIndex: c + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const i of _) if (i.fullPathName.length >= d.length && D(i.fullPathName.slice(-d.length), d)) {
      s = true, e.classifyId = i.id, f.push(i.id);
      break;
    }
    s || (u.push(e.classifyName), p.some((i) => i.classifyName === e.classifyName) || p.push({ rowIndex: c + 1, classifyName: e.classifyName }));
    const m = A.MATERIAL.V;
    G(e, c, { workshopNameV2List: V, warehouseV2List: C, arr: L, errorList: l, supplierList: F, basicClass: m });
  }), u = Array.from(new Set(u)), u.length > 0 && (l.push({ rowIndex: p[0].rowIndex, error: `${p.map((e) => `"${e.classifyName}"`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在` }), p.shift());
  const N = a.state.config.classifySpec, x = [];
  for (let e = 0; e < f.length; e++) N[f[e]] === void 0 && !x.includes(f[e]) && x.push(f[e]);
  x.length > 0 && (x.forEach((e) => {
    N[e] = {};
  }), await a.dispatch("config/fetchMarClsSpec", x));
  for (const e of n) {
    if (((I = g == null ? void 0 : g[e.classifyId]) == null ? void 0 : I.isLeaf) === false) {
      l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const c = N[e.classifyId];
    if ((c == null ? void 0 : c.hasUnitConfig) === false) {
      l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let s;
    const d = e.specification ?? "";
    if (c && Array.isArray(c.specList)) {
      for (const m of c.specList) if (d === m.spec) {
        s = m, e.measureUnit && (s.classify.measureUnit || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` }), await S(s.classify.measureUnit, e.measureUnit) || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${s.classify.measureUnit}”` })), e.accountingUnit && (await S(s.classify.accountingUnit, e.accountingUnit) || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${s.classify.accountingUnit}”` }));
        break;
      }
    }
    if (s) e.uid = z(), e.sn = s.sn, e.specificationLabels = s.specificationLabels, e.serialNumber = s.serialNumber, e.classifySerialNumber = s.classify.serialNumber, e.classifyId = s.classify.id, e.classifyFullPathId = s.classify.fullPathId, e.classifyFullName = s.classify.fullName, e.classifyName = s.classify.name, e.classifyParentFullName = s.classify.parentFullName, e.basicClass = s.classify.basicClass, e.specification = s.spec, e.specificationMap = s.specKV, e.measureUnit = s.classify.measureUnit, e.accountingUnit = s.classify.accountingUnit, e.accountingPrecision = s.classify.accountingPrecision, e.measurePrecision = s.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = $(e.quantity, e.measurePrecision)), e.mete && (e.mete = $(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0), (!e.unitPrice || !e.amount) && Se(e);
    else {
      const m = `${e.classifyName}下不存在规格为"${d}"的材料，请联系管理员/仓库人员添加`;
      l.some((i) => i.error === m) || l.push({ rowIndex: n.indexOf(e) + 1, error: m });
    }
  }
  if (l.length > 0) Ae(l);
  else return n;
} }, { handleMeteChangeCalcPrice: qe } = ae("mete");
function je(y, E) {
  return Number(y) > 0;
}
function ke(y, E) {
  const _ = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], g = y.map((n) => ({ rowIndex: n.rowIndex, error: n.error }));
  v({ type: "error", title: "导入失败,请查看错误清单" }), J({ headers: _, data: g, filename: "气体盘盈清单-错误清单", sheetName: "错误清单" });
}
const oe = { title: "气体盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "供应商", field: "supplierName", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], unitPrice: [{ required: true, message: "含税单价不能为空" }, { validator: je, message: "含税单价不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (y) => {
  var I;
  if (!O(y, oe.rules)) return;
  a.state.config.loaded.matClsTree || await a.dispatch("config/fetchMatClsTree");
  const _ = a.state.config.rawMatClsList.filter((e) => e.basicClass === A.GAS.V), g = a.state.config.rawMatClsKV, n = R(y), f = [];
  let u = [];
  const b = [], p = [], l = [];
  a.state.config.loaded.workshopNameV2 || await a.dispatch("config/fetchWorkshopNameV2"), a.state.config.loaded.warehouseV2 || await a.dispatch("config/fetchWarehouseV2"), a.state.project.loaded || await a.dispatch("project/fetchUserProjects"), a.state.config.loaded.suppliers || a.dispatch("config/fetchSuppliers");
  const V = a.state.config.workshopNameV2, C = a.state.config.warehouseV2, L = a.state.project.userProjectsMap[B].map((e) => (e.fullName = H(e, null, false), e)), F = a.state.config.suppliers;
  n.forEach((e, c) => {
    let s = false;
    const d = W(e.classifyName.split("/"));
    if (d.length === 1) {
      const i = _.filter((o) => o.name === e.classifyName) || [];
      if (w(i)) if (i.length === 1) s = true, e.classifyId = i[0].id, f.push(i[0].id);
      else {
        const o = [];
        for (const t of i) if (t.isLeaf) for (let r = 0; r < t.fullPathId.length; r++) t.id !== t.fullPathId[r] && o.push(t.fullPathId[r]);
        const h = i.find((t) => K(t.parent) && !o.includes(t.id));
        if (w(h)) s = true, e.classifyId = h.id, f.push(h.id);
        else {
          const t = i.filter((r) => r.isLeaf) || [];
          if (t.length === 1) {
            let r = true;
            i.forEach((M) => {
              t[0].fullPathId.includes(M.id) || (r = false);
            }), r && (s = true, e.classifyId = t[0].id, f.push(t[0].id));
          } else for (const r of i) w(r.parent) && !o.includes(r.id) && b.push(r);
        }
      }
      b.length > 1 && l.push({ rowIndex: c + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const i of _) if (i.fullPathName.length >= d.length && D(i.fullPathName.slice(-d.length), d)) {
      s = true, e.classifyId = i.id, f.push(i.id);
      break;
    }
    s || (u.push(e.classifyName), p.some((i) => i.classifyName === e.classifyName) || p.push({ rowIndex: c + 1, classifyName: e.classifyName }));
    const m = A.GAS.V;
    G(e, c, { workshopNameV2List: V, warehouseV2List: C, arr: L, errorList: l, supplierList: F, basicClass: m });
  }), u = Array.from(new Set(u)), u.length > 0 && (l.push({ rowIndex: p[0].rowIndex, error: `${p.map((e) => `"${e.classifyName}"`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在` }), p.shift());
  const N = a.state.config.classifySpec, x = [];
  for (let e = 0; e < f.length; e++) N[f[e]] === void 0 && !x.includes(f[e]) && x.push(f[e]);
  x.length > 0 && (x.forEach((e) => {
    N[e] = {};
  }), await a.dispatch("config/fetchMarClsSpec", x));
  for (const e of n) {
    if (((I = g == null ? void 0 : g[e.classifyId]) == null ? void 0 : I.isLeaf) === false) {
      l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const c = N[e.classifyId];
    if ((c == null ? void 0 : c.hasUnitConfig) === false) {
      l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let s;
    const d = e.specification ?? "";
    if (c && Array.isArray(c.specList)) {
      for (const m of c.specList) if (d === m.spec) {
        if (s = m, e.measureUnit && e.measureUnit !== "-") {
          if (!s.classify.measureUnit) {
            l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` });
            continue;
          }
          await S(s.classify.measureUnit, e.measureUnit) || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${s.classify.measureUnit}”` });
        }
        e.accountingUnit && (await S(s.classify.accountingUnit, e.accountingUnit) || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${s.classify.accountingUnit}”` }));
        break;
      }
    }
    if (s) e.uid = z(), e.sn = s.sn, e.specificationLabels = s.specificationLabels, e.serialNumber = s.serialNumber, e.classifySerialNumber = s.classify.serialNumber, e.classifyId = s.classify.id, e.classifyFullPathId = s.classify.fullPathId, e.classifyFullName = s.classify.fullName, e.classifyName = s.classify.name, e.classifyParentFullName = s.classify.parentFullName, e.basicClass = s.classify.basicClass, e.specification = s.spec, e.specificationMap = s.specKV, e.measureUnit = s.classify.measureUnit, e.accountingUnit = s.classify.accountingUnit, e.accountingPrecision = s.classify.accountingPrecision, e.measurePrecision = s.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = $(e.quantity, e.measurePrecision)), e.mete && (e.mete = $(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0), (!e.unitPrice || !e.amount) && qe(e);
    else {
      const m = `${e.classifyName}下不存在规格为"${d}"的材料，请联系管理员/仓库人员添加`;
      l.some((i) => i.error === m) || l.push({ rowIndex: n.indexOf(e) + 1, error: m });
    }
  }
  if (l.length > 0) ke(l);
  else return n;
} }, { handleMeteChangeCalcPrice: ve } = ae("mete");
function Oe(y, E) {
  return Number(y) >= 0;
}
function Re(y, E) {
  const _ = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], g = y.map((n) => ({ rowIndex: n.rowIndex, error: n.error }));
  v({ type: "error", title: "导入失败,请查看错误清单" }), J({ headers: _, data: g, filename: "办公用品盘盈清单-错误清单", sheetName: "错误清单" });
}
const ue = { title: "办公用品盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "供应商", field: "supplierName", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], unitPrice: [{ required: true, message: "含税单价不能为空" }, { validator: Oe, message: "含税单价不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (y) => {
  var I;
  if (!O(y, ue.rules)) return;
  a.state.config.loaded.matClsTree || await a.dispatch("config/fetchMatClsTree");
  const _ = a.state.config.rawMatClsList.filter((e) => e.basicClass === se.OTHER.V), g = a.state.config.rawMatClsKV, n = R(y), f = [];
  let u = [];
  const b = [], p = [], l = [];
  a.state.config.loaded.workshopNameV2 || await a.dispatch("config/fetchWorkshopNameV2"), a.state.config.loaded.warehouseV2 || await a.dispatch("config/fetchWarehouseV2"), a.state.project.loaded || await a.dispatch("project/fetchUserProjects"), a.state.config.loaded.suppliers || a.dispatch("config/fetchSuppliers");
  const V = a.state.config.workshopNameV2, C = a.state.config.warehouseV2, L = a.state.project.userProjectsMap[B].map((e) => (e.fullName = H(e, null, false), e)), F = a.state.config.suppliers;
  n.forEach((e, c) => {
    let s = false;
    const d = W(e.classifyName.split("/"));
    if (d.length === 1) {
      const i = _.filter((o) => o.name === e.classifyName) || [];
      if (w(i)) if (i.length === 1) s = true, e.classifyId = i[0].id, f.push(i[0].id);
      else {
        const o = [];
        for (const t of i) if (t.isLeaf) for (let r = 0; r < t.fullPathId.length; r++) t.id !== t.fullPathId[r] && o.push(t.fullPathId[r]);
        const h = i.find((t) => K(t.parent) && !o.includes(t.id));
        if (w(h)) s = true, e.classifyId = h.id, f.push(h.id);
        else {
          const t = i.filter((r) => r.isLeaf) || [];
          if (t.length === 1) {
            let r = true;
            i.forEach((M) => {
              t[0].fullPathId.includes(M.id) || (r = false);
            }), r && (s = true, e.classifyId = t[0].id, f.push(t[0].id));
          } else for (const r of i) w(r.parent) && !o.includes(r.id) && b.push(r);
        }
      }
      b.length > 1 && l.push({ rowIndex: c + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const i of _) if (i.fullPathName.length >= d.length && D(i.fullPathName.slice(-d.length), d)) {
      s = true, e.classifyId = i.id, f.push(i.id);
      break;
    }
    s || (u.push(e.classifyName), p.some((i) => i.classifyName === e.classifyName) || p.push({ rowIndex: c + 1, classifyName: e.classifyName }));
    const m = se.OTHER.V;
    G(e, c, { workshopNameV2List: V, warehouseV2List: C, arr: L, errorList: l, supplierList: F, basicClass: m });
  }), u = Array.from(new Set(u)), u.length > 0 && (l.push({ rowIndex: p[0].rowIndex, error: `${p.map((e) => `"${e.classifyName}"`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在` }), p.shift());
  const N = a.state.config.classifySpec, x = [];
  for (let e = 0; e < f.length; e++) N[f[e]] === void 0 && !x.includes(f[e]) && x.push(f[e]);
  x.length > 0 && (x.forEach((e) => {
    N[e] = {};
  }), await a.dispatch("config/fetchMarClsSpec", x));
  for (const e of n) {
    if (((I = g == null ? void 0 : g[e.classifyId]) == null ? void 0 : I.isLeaf) === false) {
      l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const c = N[e.classifyId];
    if ((c == null ? void 0 : c.hasUnitConfig) === false) {
      l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let s;
    const d = e.specification ?? "";
    if (c && Array.isArray(c.specList)) {
      for (const m of c.specList) if (d === m.spec) {
        s = m, e.measureUnit && (s.classify.measureUnit || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` }), await S(s.classify.measureUnit, e.measureUnit) || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${s.classify.measureUnit}”` })), e.accountingUnit && (await S(s.classify.accountingUnit, e.accountingUnit) || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${s.classify.accountingUnit}”` }));
        break;
      }
    }
    if (s) e.uid = z(), e.sn = s.sn, e.specificationLabels = s.specificationLabels, e.serialNumber = s.serialNumber, e.classifySerialNumber = s.classify.serialNumber, e.classifyId = s.classify.id, e.classifyFullPathId = s.classify.fullPathId, e.classifyFullName = s.classify.fullName, e.classifyName = s.classify.name, e.classifyParentFullName = s.classify.parentFullName, e.basicClass = s.classify.basicClass, e.specification = s.spec, e.specificationMap = s.specKV, e.measureUnit = s.classify.measureUnit, e.accountingUnit = s.classify.accountingUnit, e.accountingPrecision = s.classify.accountingPrecision, e.measurePrecision = s.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = $(e.quantity, e.measurePrecision)), e.mete && (e.mete = $(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0), (!e.unitPrice || !e.amount) && ve(e);
    else {
      const m = `${e.classifyName}下不存在规格为"${d}"的材料，请联系管理员/仓库人员添加`;
      l.some((i) => i.error === m) || l.push({ rowIndex: n.indexOf(e) + 1, error: m });
    }
  }
  if (l.length > 0) Re(l);
  else return n;
} };
function Be(y, E) {
  const _ = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], g = y.map((n) => ({ rowIndex: n.rowIndex, error: n.error }));
  v({ type: "error", title: "导入失败,请查看错误清单" }), J({ headers: _, data: g, filename: "辅材盘盈清单-错误清单", sheetName: "错误清单" });
}
const de = { title: "辅材盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_8" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_9" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (y) => {
  var I;
  if (!O(y, de.rules)) return;
  a.state.config.loaded.matClsTree || await a.dispatch("config/fetchMatClsTree");
  const _ = a.state.config.rawMatClsList.filter((e) => e.basicClass === A.MATERIAL.V), g = a.state.config.rawMatClsKV, n = R(y), f = [];
  let u = [];
  const b = [], p = [], l = [];
  a.state.config.loaded.workshopNameV2 || await a.dispatch("config/fetchWorkshopNameV2"), a.state.config.loaded.warehouseV2 || await a.dispatch("config/fetchWarehouseV2"), a.state.project.loaded || await a.dispatch("project/fetchUserProjects"), a.state.config.loaded.suppliers || a.dispatch("config/fetchSuppliers");
  const V = a.state.config.workshopNameV2, C = a.state.config.warehouseV2, L = a.state.project.userProjectsMap[B].map((e) => (e.fullName = H(e, null, false), e)), F = a.state.config.suppliers;
  n.forEach((e, c) => {
    let s = false;
    const d = W(e.classifyName.split("/"));
    if (d.length === 1) {
      const i = _.filter((o) => o.name === e.classifyName) || [];
      if (w(i)) if (i.length === 1) s = true, e.classifyId = i[0].id, f.push(i[0].id);
      else {
        const o = [];
        for (const t of i) if (t.isLeaf) for (let r = 0; r < t.fullPathId.length; r++) t.id !== t.fullPathId[r] && o.push(t.fullPathId[r]);
        const h = i.find((t) => K(t.parent) && !o.includes(t.id));
        if (w(h)) s = true, e.classifyId = h.id, f.push(h.id);
        else {
          const t = i.filter((r) => r.isLeaf) || [];
          if (t.length === 1) {
            let r = true;
            i.forEach((M) => {
              t[0].fullPathId.includes(M.id) || (r = false);
            }), r && (s = true, e.classifyId = t[0].id, f.push(t[0].id));
          } else for (const r of i) w(r.parent) && !o.includes(r.id) && b.push(r);
        }
      }
      b.length > 1 && l.push({ rowIndex: c + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const i of _) if (i.fullPathName.length >= d.length && D(i.fullPathName.slice(-d.length), d)) {
      s = true, e.classifyId = i.id, f.push(i.id);
      break;
    }
    s || (u.push(e.classifyName), p.some((i) => i.classifyName === e.classifyName) || p.push({ rowIndex: c + 1, classifyName: e.classifyName }));
    const m = A.MATERIAL.V;
    G(e, c, { workshopNameV2List: V, warehouseV2List: C, arr: L, errorList: l, supplierList: F, basicClass: m });
  }), u = Array.from(new Set(u)), u.length > 0 && (l.push({ rowIndex: p[0].rowIndex, error: `${p.map((e) => `"${e.classifyName}"`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在` }), p.shift());
  const N = a.state.config.classifySpec, x = [];
  for (let e = 0; e < f.length; e++) N[f[e]] === void 0 && !x.includes(f[e]) && x.push(f[e]);
  x.length > 0 && (x.forEach((e) => {
    N[e] = {};
  }), await a.dispatch("config/fetchMarClsSpec", x));
  for (const e of n) {
    if (((I = g == null ? void 0 : g[e.classifyId]) == null ? void 0 : I.isLeaf) === false) {
      l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const c = N[e.classifyId];
    if ((c == null ? void 0 : c.hasUnitConfig) === false) {
      l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let s;
    const d = e.specification ?? "";
    if (c && Array.isArray(c.specList)) {
      for (const m of c.specList) if (d === m.spec) {
        s = m, e.measureUnit && (s.classify.measureUnit || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` }), await S(s.classify.measureUnit, e.measureUnit) || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${s.classify.measureUnit}”` })), e.accountingUnit && (await S(s.classify.accountingUnit, e.accountingUnit) || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${s.classify.accountingUnit}”` }));
        break;
      }
    }
    if (s) e.uid = z(), e.sn = s.sn, e.specificationLabels = s.specificationLabels, e.serialNumber = s.serialNumber, e.classifySerialNumber = s.classify.serialNumber, e.classifyId = s.classify.id, e.classifyFullPathId = s.classify.fullPathId, e.classifyFullName = s.classify.fullName, e.classifyName = s.classify.name, e.classifyParentFullName = s.classify.parentFullName, e.basicClass = s.classify.basicClass, e.specification = s.spec, e.specificationMap = s.specKV, e.measureUnit = s.classify.measureUnit, e.accountingUnit = s.classify.accountingUnit, e.accountingPrecision = s.classify.accountingPrecision, e.measurePrecision = s.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = $(e.quantity, e.measurePrecision)), e.mete && (e.mete = $(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0);
    else {
      const m = `${e.classifyName}下不存在规格为"${d}"的材料，请联系管理员/仓库人员添加`;
      l.some((i) => i.error === m) || l.push({ rowIndex: n.indexOf(e) + 1, error: m });
    }
  }
  if (l.length > 0) Be(l);
  else return n;
} };
function He(y, E) {
  const _ = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], g = y.map((n) => ({ rowIndex: n.rowIndex, error: n.error }));
  v({ type: "error", title: "导入失败,请查看错误清单" }), J({ headers: _, data: g, filename: "气体盘盈清单-错误清单", sheetName: "错误清单" });
}
const me = { title: "气体盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_8" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_9" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (y) => {
  var I;
  if (!O(y, me.rules)) return;
  a.state.config.loaded.matClsTree || await a.dispatch("config/fetchMatClsTree");
  const _ = a.state.config.rawMatClsList.filter((e) => e.basicClass === A.GAS.V), g = a.state.config.rawMatClsKV, n = R(y), f = [];
  let u = [];
  const b = [], p = [], l = [];
  a.state.config.loaded.workshopNameV2 || await a.dispatch("config/fetchWorkshopNameV2"), a.state.config.loaded.warehouseV2 || await a.dispatch("config/fetchWarehouseV2"), a.state.project.loaded || await a.dispatch("project/fetchUserProjects"), a.state.config.loaded.suppliers || a.dispatch("config/fetchSuppliers");
  const V = a.state.config.workshopNameV2, C = a.state.config.warehouseV2, L = a.state.project.userProjectsMap[B].map((e) => (e.fullName = H(e, null, false), e)), F = a.state.config.suppliers;
  n.forEach((e, c) => {
    let s = false;
    const d = W(e.classifyName.split("/"));
    if (d.length === 1) {
      const i = _.filter((o) => o.name === e.classifyName) || [];
      if (w(i)) if (i.length === 1) s = true, e.classifyId = i[0].id, f.push(i[0].id);
      else {
        const o = [];
        for (const t of i) if (t.isLeaf) for (let r = 0; r < t.fullPathId.length; r++) t.id !== t.fullPathId[r] && o.push(t.fullPathId[r]);
        const h = i.find((t) => K(t.parent) && !o.includes(t.id));
        if (w(h)) s = true, e.classifyId = h.id, f.push(h.id);
        else {
          const t = i.filter((r) => r.isLeaf) || [];
          if (t.length === 1) {
            let r = true;
            i.forEach((M) => {
              t[0].fullPathId.includes(M.id) || (r = false);
            }), r && (s = true, e.classifyId = t[0].id, f.push(t[0].id));
          } else for (const r of i) w(r.parent) && !o.includes(r.id) && b.push(r);
        }
      }
      b.length > 1 && l.push({ rowIndex: c + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const i of _) if (i.fullPathName.length >= d.length && D(i.fullPathName.slice(-d.length), d)) {
      s = true, e.classifyId = i.id, f.push(i.id);
      break;
    }
    s || (u.push(e.classifyName), p.some((i) => i.classifyName === e.classifyName) || p.push({ rowIndex: c + 1, classifyName: e.classifyName }));
    const m = A.GAS.V;
    G(e, c, { workshopNameV2List: V, warehouseV2List: C, arr: L, errorList: l, supplierList: F, basicClass: m });
  }), u = Array.from(new Set(u)), u.length > 0 && (l.push({ rowIndex: p[0].rowIndex, error: `${p.map((e) => `"${e.classifyName}"`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在` }), p.shift());
  const N = a.state.config.classifySpec, x = [];
  for (let e = 0; e < f.length; e++) N[f[e]] === void 0 && !x.includes(f[e]) && x.push(f[e]);
  x.length > 0 && (x.forEach((e) => {
    N[e] = {};
  }), await a.dispatch("config/fetchMarClsSpec", x));
  for (const e of n) {
    if (((I = g == null ? void 0 : g[e.classifyId]) == null ? void 0 : I.isLeaf) === false) {
      l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const c = N[e.classifyId];
    if ((c == null ? void 0 : c.hasUnitConfig) === false) {
      l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let s;
    const d = e.specification ?? "";
    if (c && Array.isArray(c.specList)) {
      for (const m of c.specList) if (d === m.spec) {
        if (s = m, e.measureUnit && e.measureUnit !== "-") {
          if (!s.classify.measureUnit) {
            l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` });
            continue;
          }
          await S(s.classify.measureUnit, e.measureUnit) || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${s.classify.measureUnit}”` });
        }
        e.accountingUnit && (await S(s.classify.accountingUnit, e.accountingUnit) || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${s.classify.accountingUnit}”` }));
        break;
      }
    }
    if (s) e.uid = z(), e.sn = s.sn, e.specificationLabels = s.specificationLabels, e.serialNumber = s.serialNumber, e.classifySerialNumber = s.classify.serialNumber, e.classifyId = s.classify.id, e.classifyFullPathId = s.classify.fullPathId, e.classifyFullName = s.classify.fullName, e.classifyName = s.classify.name, e.classifyParentFullName = s.classify.parentFullName, e.basicClass = s.classify.basicClass, e.specification = s.spec, e.specificationMap = s.specKV, e.measureUnit = s.classify.measureUnit, e.accountingUnit = s.classify.accountingUnit, e.accountingPrecision = s.classify.accountingPrecision, e.measurePrecision = s.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = $(e.quantity, e.measurePrecision)), e.mete && (e.mete = $(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0);
    else {
      const m = `${e.classifyName}下不存在规格为"${d}"的材料，请联系管理员/仓库人员添加`;
      l.some((i) => i.error === m) || l.push({ rowIndex: n.indexOf(e) + 1, error: m });
    }
  }
  if (l.length > 0) He(l);
  else return n;
} };
function We(y, E) {
  const _ = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], g = y.map((n) => ({ rowIndex: n.rowIndex, error: n.error }));
  v({ type: "error", title: "导入失败,请查看错误清单" }), J({ headers: _, data: g, filename: "办公用品盘盈清单-错误清单", sheetName: "错误清单" });
}
const pe = { title: "办公用品盘盈清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_8" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_9" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (y) => {
  var I;
  if (!O(y, pe.rules)) return;
  a.state.config.loaded.matClsTree || await a.dispatch("config/fetchMatClsTree");
  const _ = a.state.config.rawMatClsList.filter((e) => e.basicClass === se.OTHER.V), g = a.state.config.rawMatClsKV, n = R(y), f = [];
  let u = [];
  const b = [], p = [], l = [];
  a.state.config.loaded.workshopNameV2 || await a.dispatch("config/fetchWorkshopNameV2"), a.state.config.loaded.warehouseV2 || await a.dispatch("config/fetchWarehouseV2"), a.state.project.loaded || await a.dispatch("project/fetchUserProjects"), a.state.config.loaded.suppliers || a.dispatch("config/fetchSuppliers");
  const V = a.state.config.workshopNameV2, C = a.state.config.warehouseV2, L = a.state.project.userProjectsMap[B].map((e) => (e.fullName = H(e, null, false), e)), F = a.state.config.suppliers;
  n.forEach((e, c) => {
    let s = false;
    const d = W(e.classifyName.split("/"));
    if (d.length === 1) {
      const i = _.filter((o) => o.name === e.classifyName) || [];
      if (w(i)) if (i.length === 1) s = true, e.classifyId = i[0].id, f.push(i[0].id);
      else {
        const o = [];
        for (const t of i) if (t.isLeaf) for (let r = 0; r < t.fullPathId.length; r++) t.id !== t.fullPathId[r] && o.push(t.fullPathId[r]);
        const h = i.find((t) => K(t.parent) && !o.includes(t.id));
        if (w(h)) s = true, e.classifyId = h.id, f.push(h.id);
        else {
          const t = i.filter((r) => r.isLeaf) || [];
          if (t.length === 1) {
            let r = true;
            i.forEach((M) => {
              t[0].fullPathId.includes(M.id) || (r = false);
            }), r && (s = true, e.classifyId = t[0].id, f.push(t[0].id));
          } else for (const r of i) w(r.parent) && !o.includes(r.id) && b.push(r);
        }
      }
      b.length > 1 && l.push({ rowIndex: c + 1, error: `科目名称"${e.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const i of _) if (i.fullPathName.length >= d.length && D(i.fullPathName.slice(-d.length), d)) {
      s = true, e.classifyId = i.id, f.push(i.id);
      break;
    }
    s || (u.push(e.classifyName), p.some((i) => i.classifyName === e.classifyName) || p.push({ rowIndex: c + 1, classifyName: e.classifyName }));
    const m = se.OTHER.V;
    G(e, c, { workshopNameV2List: V, warehouseV2List: C, arr: L, errorList: l, supplierList: F, basicClass: m });
  }), u = Array.from(new Set(u)), u.length > 0 && (l.push({ rowIndex: p[0].rowIndex, error: `${p.map((e) => `"${e.classifyName}"`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在` }), p.shift());
  const N = a.state.config.classifySpec, x = [];
  for (let e = 0; e < f.length; e++) N[f[e]] === void 0 && !x.includes(f[e]) && x.push(f[e]);
  x.length > 0 && (x.forEach((e) => {
    N[e] = {};
  }), await a.dispatch("config/fetchMarClsSpec", x));
  for (const e of n) {
    if (((I = g == null ? void 0 : g[e.classifyId]) == null ? void 0 : I.isLeaf) === false) {
      l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}不是末级科目` });
      continue;
    }
    const c = N[e.classifyId];
    if ((c == null ? void 0 : c.hasUnitConfig) === false) {
      l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}未配置核算单位` });
      continue;
    }
    let s;
    const d = e.specification ?? "";
    if (c && Array.isArray(c.specList)) {
      for (const m of c.specList) if (d === m.spec) {
        s = m, e.measureUnit && (s.classify.measureUnit || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}不存在计量单位` }), await S(s.classify.measureUnit, e.measureUnit) || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}填写的计量单位错误，单位应为：“${s.classify.measureUnit}”` })), e.accountingUnit && (await S(s.classify.accountingUnit, e.accountingUnit) || l.push({ rowIndex: n.indexOf(e) + 1, error: `${e.classifyName}填写的核算单位错误，单位应为：“${s.classify.accountingUnit}”` }));
        break;
      }
    }
    if (s) e.uid = z(), e.sn = s.sn, e.specificationLabels = s.specificationLabels, e.serialNumber = s.serialNumber, e.classifySerialNumber = s.classify.serialNumber, e.classifyId = s.classify.id, e.classifyFullPathId = s.classify.fullPathId, e.classifyFullName = s.classify.fullName, e.classifyName = s.classify.name, e.classifyParentFullName = s.classify.parentFullName, e.basicClass = s.classify.basicClass, e.specification = s.spec, e.specificationMap = s.specKV, e.measureUnit = s.classify.measureUnit, e.accountingUnit = s.classify.accountingUnit, e.accountingPrecision = s.classify.accountingPrecision, e.measurePrecision = s.classify.measurePrecision, e.measureUnit || (e.quantity = void 0), e.quantity && (e.quantity = $(e.quantity, e.measurePrecision)), e.mete && (e.mete = $(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0);
    else {
      const m = `${e.classifyName}下不存在规格为"${d}"的材料，请联系管理员/仓库人员添加`;
      l.some((i) => i.error === m) || l.push({ rowIndex: n.indexOf(e) + 1, error: m });
    }
  }
  if (l.length > 0) We(l);
  else return n;
} }, Ke = { class: "filter-container" }, De = { class: "filter-left-box" }, Ge = { class: "filter-right-box" }, is = { __name: "index", props: { repeatList: { type: Array, default: () => [] } }, setup(y, { expose: E }) {
  var i;
  const _ = Q(), g = Q(), n = Q(), f = Q(), u = (i = he("crud")) == null ? void 0 : i.form, b = X(() => u.materialType), p = Q(), l = ye({ auxiliaryMaterialList: null, otherList: null, gasList: null });
  ge("matSpecRef", f);
  const { maxHeight: V, maxHeightStyle: C } = ce({ mainBox: ".profit-application-record-form", extraBox: [".el-drawer__header", ".filter-container"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 210 }), { maxHeight: q } = ce({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => n.value.loaded), L = X(() => {
    switch (u.materialType) {
      case T.MATERIAL.V:
        return Fe;
      case T.GAS.V:
        return $e;
      case T.OTHER.V:
        return Le;
      default:
        return null;
    }
  }), F = X(() => {
    switch (u.materialType) {
      case T.MATERIAL.V:
        return "auxiliaryMaterialList";
      case T.GAS.V:
        return "gasList";
      case T.OTHER.V:
        return "otherList";
      default:
        return null;
    }
  }), N = X(() => {
    if (u.boolPartyA) switch (u.materialType) {
      case T.MATERIAL.V:
        return de;
      case T.GAS.V:
        return me;
      case T.OTHER.V:
        return pe;
      default:
        return null;
    }
    else switch (u.materialType) {
      case T.MATERIAL.V:
        return fe;
      case T.GAS.V:
        return oe;
      case T.OTHER.V:
        return ue;
      default:
        return null;
    }
  });
  te(b, (o) => {
    o && (u.currentBasicClass = o, ie(() => {
      l[o] || (l[o] = _.value);
    }));
  }, { immediate: true });
  function x() {
    ie(() => {
      l.auxiliaryMaterialList = null, l.otherList = null, l.gasList = null, f.value && f.value.clear();
    });
  }
  function I(o) {
    f.value && f.value.clearByBasicClass(o);
  }
  function e(o) {
    var h;
    return (h = _.value) == null ? void 0 : h.rowInit(o);
  }
  function c() {
    p.value = true;
  }
  function s() {
    return Object.keys(l).every((o) => l[o] ? l[o].validate() : true);
  }
  function d() {
    return s();
  }
  x();
  function m(o) {
    var j;
    const h = F.value, t = u[h].length;
    o.map((P, Y) => {
      P.rowIndex = (u[h].length || 0) + Y, P.projectId = P.projectId || (Y > 0 || t > 0 ? -1 : void 0), P.workshopId = P.workshopId || (Y > 0 || t > 0 ? -1 : void 0), P.warehouseId = P.warehouseId || (Y > 0 || t > 0 ? -1 : void 0), P.supplierId = P.supplierId || (Y > 0 || t > 0 ? -1 : void 0);
    }), u[h].push.apply(u[h], o);
    const r = u[h].length;
    for (let P = t; P < r; P++) u[h][P].amount = $(u[h][P].amount, Ce.YUAN), (j = l[h]) == null || j.rowWatch(u[h][P]);
    const M = te(f, () => {
      f.value && (f.value.initSelected(o.map((P) => ({ sn: P.sn, classifyId: P.classifyId }))), ie(() => {
        M();
      }));
    }, { immediate: true });
  }
  return E({ form: u, validate: d, handleClearByBasicClass: I }), (o, h) => {
    const t = le("common-button"), r = Ee, M = le("common-drawer");
    return re(), xe(we, null, [Z("div", null, [Z("div", Ke, [Z("div", De, [_e(o.$slots, "filterLeft")]), Z("div", Ge, [k(t, { class: "filter-item", type: "success", onClick: c }, { default: ee(() => h[2] || (h[2] = [ne(" 添加物料 ")])), _: 1, __: [2] }), k(Ue, { disabled: !U(u).materialType, template: N.value, "btn-name": "批量导入", "btn-size": "default", "btn-type": "primary", icon: "el-icon-upload", class: "filter-item", "open-loading": "", onSuccess: m }, null, 8, ["disabled", "template"]), k(Te, { disabled: !U(u).materialType, fn: U(Me), params: { basicClass: U(u).materialType, boolPartyA: U(u).boolPartyA }, class: "filter-item", "response-header-result": "" }, { default: ee(() => [ne(Ne(U(u).materialType ? U(T).VL[U(u).materialType] : "") + "盘盈模板下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])])]), k(r, { ref_key: "formRef", ref: g, model: U(u) }, { default: ee(() => [(re(), be(Pe(L.value), { ref_key: "otherRef", ref: _, "max-height": U(V), repeatList: y.repeatList, style: Ie(U(C)) }, null, 8, ["max-height", "repeatList", "style"]))]), _: 1 }, 8, ["model"])]), k(M, { ref_key: "drawerRef", ref: n, modelValue: p.value, "onUpdate:modelValue": h[1] || (h[1] = (j) => p.value = j), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: ee(() => {
      var j;
      return [k(Ve, { ref_key: "matSpecRef", ref: f, modelValue: U(u)[(j = U(T).V[b.value]) == null ? void 0 : j.LIST], "onUpdate:modelValue": h[0] || (h[0] = (P) => {
        var Y;
        return U(u)[(Y = U(T).V[b.value]) == null ? void 0 : Y.LIST] = P;
      }), "basic-class": b.value, "max-height": U(q), "row-init-fn": e, "table-width": 350, visible: p.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])];
    }), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  is as default
};
