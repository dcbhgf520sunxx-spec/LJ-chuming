import { useRouter as ua } from "vue-router";
import { inject as da } from "vue";
import { computed as fe } from "vue";
import { ref as ue } from "vue";
import { watchEffect as De } from "vue";
import { nextTick as ee } from "vue";
import { watch as pa } from "vue";
import { resolveComponent as de } from "vue";
import { openBlock as U } from "vue";
import { createElementBlock as Ke } from "vue";
import { createElementVNode as pe } from "vue";
import { createVNode as V } from "vue";
import { withCtx as L } from "vue";
import { createBlock as Y } from "vue";
import { unref as g } from "vue";
import { normalizeStyle as ya } from "vue";
import { createCommentVNode as $ } from "vue";
import { Fragment as ha } from "vue";
import { normalizeClass as ma } from "vue";
import { ElMessage as ga } from "element-plus";
import { ElFormItem as ba } from "element-plus";
import { ElInput as _a } from "element-plus";
import { ElTooltip as Ea } from "element-plus";
import { ElForm as Pa } from "element-plus";
import { rJ as ge, am as P, vP as j, vQ as Je, j as d, V as R, vR as B, f3 as Q, aI as H, sT as Ta, i as le, iX as q, vS as ce, sU as Na, v9 as wa, va as Ma, vT as k, _ as xa, tC as Ca, ym as Sa, jU as G, jV as Fa, cV as ye, bR as ae, jZ as z, yn as Ua, cO as se, jl as ie, b as Ge, yo as Ia, yp as La, b4 as $a, vv as Va, bI as ze, cM as Ya } from "../../../../../../shared/runtime.js";
const { handleMeteChangeCalcPrice: qa } = ce("weighingTotalWeight"), J = ge[P.STEEL_PLATE.V], Xe = { title: "钢板入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: J.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: J.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: J.length.precision, excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", precision: J.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: J.weight.precision, excelField: "__EMPTY_6" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_7" }, { label: "金额", field: "amount", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_10" }, { label: "备注", field: "remark", excelField: "__EMPTY_11" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (f) => {
  var e;
  if (!j(f, Xe.rules)) return;
  const w = await Je();
  d.state.config.loaded.matClsTree || await d.dispatch("config/fetchMatClsTree");
  const b = d.state.config.rawMatClsList.filter((a) => a.basicClass === P.STEEL_PLATE.V), n = d.state.config.rawMatClsKV, _ = R(f), u = [];
  let p = [];
  if (_.forEach((a) => {
    let s = false;
    const t = B(a.classifyName.split("/"));
    for (const y of b) if (y.fullPathName.length >= t.length && Q(y.fullPathName.slice(-t.length), t)) {
      s = true, a.classifyId = y.id, u.push(y.id);
      break;
    }
    s || p.push(a.classifyName);
  }), p = Array.from(new Set(p)), p.length > 0) throw new Error(`${p.map((a) => `“${a}”`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在`);
  const i = d.state.config.classifySpec, E = u.filter((a) => i[a] === void 0);
  E.length > 0 && (E.forEach((a) => {
    i[a] = {};
  }), await d.dispatch("config/fetchMarClsSpec", E));
  for (const a of _) {
    if (((e = n == null ? void 0 : n[a.classifyId]) == null ? void 0 : e.isLeaf) === false) throw new Error(`${a.classifyName}不是末级科目`);
    const s = i[a.classifyId];
    if (s.hasUnitConfig === false) throw new Error(`${a.classifyName}未配置核算单位`);
    let t;
    const y = a.material ?? "";
    if (s && Array.isArray(s.specList)) {
      for (const N of s.specList) if (y === N.spec) {
        t = N;
        break;
      }
    }
    if (t) a.uid = H(), a.sn = t.sn, a.specificationLabels = t.specificationLabels, a.serialNumber = t.serialNumber, a.classifySerialNumber = t.classify.serialNumber, a.classifyId = t.classify.id, a.classifyFullName = t.classify.fullName, a.classifyName = t.classify.name, a.classifyParentFullName = t.classify.parentFullName, a.basicClass = t.classify.basicClass, a.specification = t.spec, a.specificationMap = t.specKV, a.measureUnit = t.classify.measureUnit, a.accountingUnit = t.classify.accountingUnit, a.accountingPrecision = t.classify.accountingPrecision, a.measurePrecision = t.classify.measurePrecision, a.theoryWeight = await Ta({ classifyId: a.classifyId, name: a.classifyFullName, length: a.length, width: a.width, thickness: a.thickness }), le(a.theoryWeight) && a.quantity ? a.theoryTotalWeight = q(a.theoryWeight * a.quantity, w[P.STEEL_PLATE.V].weight.precision) : a.theoryTotalWeight = void 0, a.weighingTotalWeight = a.weighingTotalWeight || a.theoryTotalWeight, (!a.unitPrice || !a.amount) && qa(a);
    else throw new Error(`${a.classifyName}下不存在规格为“${y}”的材料，请联系管理员/仓库人员添加`);
  }
  return _;
} }, { handleMeteChangeCalcPrice: Aa } = ce("weighingTotalWeight"), he = ge[P.SECTION_STEEL.V], Ze = { title: "型材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "材质", field: "material", excelField: "__EMPTY_2" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: he.length.precision, excelField: "__EMPTY_3" }, { label: "数量（根）", field: "quantity", type: "number", precision: he.measure.precision, excelField: "__EMPTY_4" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: he.weight.precision, excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "金额", field: "amount", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_9" }, { label: "备注", field: "remark", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "型材规格不能为空" }] }, format: async (f) => {
  var e;
  if (!j(f, Ze.rules)) return;
  const w = await Je();
  d.state.config.loaded.matClsTree || await d.dispatch("config/fetchMatClsTree");
  const b = d.state.config.rawMatClsList.filter((a) => a.basicClass === P.SECTION_STEEL.V), n = d.state.config.rawMatClsKV, _ = R(f), u = [];
  let p = [];
  if (_.forEach((a) => {
    let s = false;
    const t = B(a.classifyName.split("/"));
    for (const y of b) if (y.fullPathName.length >= t.length && Q(y.fullPathName.slice(-t.length), t)) {
      s = true, a.classifyId = y.id, u.push(y.id);
      break;
    }
    s || p.push(a.classifyName);
  }), p = Array.from(new Set(p)), p.length > 0) throw new Error(`${p.map((a) => `“${a}”`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在`);
  const i = d.state.config.classifySpec, E = u.filter((a) => i[a] === void 0);
  E.length > 0 && (E.forEach((a) => {
    i[a] = {};
  }), await d.dispatch("config/fetchMarClsSpec", E));
  for (const a of _) {
    if (((e = n == null ? void 0 : n[a.classifyId]) == null ? void 0 : e.isLeaf) === false) throw new Error(`${a.classifyName}不是末级科目`);
    const s = i[a.classifyId];
    if (s.hasUnitConfig === false) throw new Error(`${a.classifyName}未配置核算单位`);
    let t;
    const y = `${a.specification} * ${a.material}`;
    if (s && Array.isArray(s.specList)) {
      for (const N of s.specList) if (y === N.spec) {
        t = N;
        break;
      }
    }
    if (t) a.uid = H(), a.sn = t.sn, a.specificationLabels = t.specificationLabels, a.serialNumber = t.serialNumber, a.classifySerialNumber = t.classify.serialNumber, a.classifyId = t.classify.id, a.classifyFullName = t.classify.fullName, a.classifyName = t.classify.name, a.classifyParentFullName = t.classify.parentFullName, a.basicClass = t.classify.basicClass, a.specification = t.spec, a.specificationMap = t.specKV, a.measureUnit = t.classify.measureUnit, a.accountingUnit = t.classify.accountingUnit, a.accountingPrecision = t.classify.accountingPrecision, a.measurePrecision = t.classify.measurePrecision, a.unitWeight = t.unitWeight, a.theoryWeight = await Na({ length: a.length, unitWeight: a.unitWeight }), le(a.theoryWeight) && a.quantity ? a.theoryTotalWeight = q(a.theoryWeight * a.quantity, w[P.SECTION_STEEL.V].weight.precision) : a.theoryTotalWeight = void 0, a.weighingTotalWeight = a.weighingTotalWeight || a.theoryTotalWeight, Wa(a), (!a.unitPrice || !a.amount) && Aa(a);
    else throw new Error(`${a.classifyName}下不存在规格为“${y}”的材料，请联系管理员/仓库人员添加`);
  }
  return _;
} };
function Wa(f) {
  le(f.length) && f.quantity ? f.totalLength = wa({ length: f.length, quantity: f.quantity }) : f.totalLength = void 0;
}
const { handleMeteChangeCalcPrice: va } = ce("weighingTotalWeight"), te = ge[P.STEEL_COIL.V], ea = { title: "钢卷入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: te.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: te.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: te.length.precision, excelField: "__EMPTY_4" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: te.weight.precision, excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "金额", field: "amount", excelField: "__EMPTY_7" }, { label: "颜色", field: "color", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "卷号", field: "heatNoAndBatchNo", excelField: "__EMPTY_10" }, { label: "备注", field: "remark", excelField: "__EMPTY_11" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (f) => {
  var E;
  if (!j(f, ea.rules)) return;
  d.state.config.loaded.matClsTree || await d.dispatch("config/fetchMatClsTree");
  const w = d.state.config.rawMatClsList.filter((e) => e.basicClass === P.STEEL_COIL.V), b = d.state.config.rawMatClsKV, n = R(f), _ = [];
  let u = [];
  if (n.forEach((e) => {
    let a = false;
    const s = B(e.classifyName.split("/"));
    for (const t of w) if (t.fullPathName.length >= s.length && Q(t.fullPathName.slice(-s.length), s)) {
      a = true, e.classifyId = t.id, _.push(t.id);
      break;
    }
    a || u.push(e.classifyName);
  }), u = Array.from(new Set(u)), u.length > 0) throw new Error(`${u.map((e) => `“${e}”`).join("、")}${u.length > 1 ? "等" : ""}物料种类不存在`);
  const p = d.state.config.classifySpec, i = _.filter((e) => p[e] === void 0);
  i.length > 0 && (i.forEach((e) => {
    p[e] = {};
  }), await d.dispatch("config/fetchMarClsSpec", i));
  for (const e of n) {
    if (((E = b == null ? void 0 : b[e.classifyId]) == null ? void 0 : E.isLeaf) === false) throw new Error(`${e.classifyName}不是末级科目`);
    const a = p[e.classifyId];
    if (a.hasUnitConfig === false) throw new Error(`${e.classifyName}未配置核算单位`);
    let s;
    const t = e.material ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const y of a.specList) if (t === y.spec) {
        s = y;
        break;
      }
    }
    if (s) e.uid = H(), e.sn = s.sn, e.specificationLabels = s.specificationLabels, e.serialNumber = s.serialNumber, e.classifySerialNumber = s.classify.serialNumber, e.classifyId = s.classify.id, e.classifyFullName = s.classify.fullName, e.classifyName = s.classify.name, e.classifyParentFullName = s.classify.parentFullName, e.basicClass = s.classify.basicClass, e.specification = s.spec, e.specificationMap = s.specKV, e.measureUnit = s.classify.measureUnit, e.accountingUnit = s.classify.accountingUnit, e.accountingPrecision = s.classify.accountingPrecision, e.measurePrecision = s.classify.measurePrecision, await Oa(e), e.length = e.length || e.theoryLength, (!e.unitPrice || !e.amount) && va(e);
    else throw new Error(`${e.classifyName}下不存在规格为“${t}”的材料，请联系管理员/仓库人员添加`);
  }
  return n;
} };
async function Oa(f) {
  f.theoryLength = await Ma({ classifyId: f.classifyId, name: f.classifyFullName, weight: f.weighingTotalWeight, width: f.width, thickness: f.thickness });
}
const { handleMeteChangeCalcPrice: ka } = ce("mete"), me = { title: "辅材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "金额", field: "amount", excelField: "__EMPTY_7" }, { label: "颜色", field: "color", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "备注", field: "remark", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (f) => {
  var E;
  if (!j(f, me.rules)) return;
  d.state.config.loaded.matClsTree || await d.dispatch("config/fetchMatClsTree");
  const w = d.state.config.rawMatClsList.filter((e) => e.basicClass === P.MATERIAL.V), b = d.state.config.rawMatClsKV, n = R(f), _ = [];
  let u = [];
  if (n.forEach((e) => {
    let a = false;
    const s = B(e.classifyName.split("/"));
    for (const t of w) if (t.fullPathName.length >= s.length && Q(t.fullPathName.slice(-s.length), s)) {
      a = true, e.classifyId = t.id, _.push(t.id);
      break;
    }
    a || u.push(e.classifyName);
  }), u = Array.from(new Set(u)), u.length > 0) throw new Error(`${u.map((e) => `“${e}”`).join("、")}${u.length > 1 ? "等" : ""}物料种类不存在`);
  const p = d.state.config.classifySpec, i = _.filter((e) => p[e] === void 0);
  i.length > 0 && (i.forEach((e) => {
    p[e] = {};
  }), await d.dispatch("config/fetchMarClsSpec", i));
  for (const e of n) {
    if (((E = b == null ? void 0 : b[e.classifyId]) == null ? void 0 : E.isLeaf) === false) throw new Error(`${e.classifyName}不是末级科目`);
    const a = p[e.classifyId];
    if (a.hasUnitConfig === false) throw new Error(`${e.classifyName}未配置核算单位`);
    let s;
    const t = e.specification ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const y of a.specList) if (t === y.spec) {
        if (s = y, e.measureUnit) {
          if (!s.classify.measureUnit) throw new Error(`${e.classifyName}不存在计量单位`);
          if (!await k(s.classify.measureUnit, e.measureUnit)) throw new Error(`${e.classifyName}填写的计量单位错误，单位应为：“${s.classify.measureUnit}”`);
        }
        if (e.accountingUnit && !await k(s.classify.accountingUnit, e.accountingUnit)) throw new Error(`${e.classifyName}填写的核算单位错误，单位应为：“${s.classify.accountingUnit}”`);
        break;
      }
    }
    if (s) e.uid = H(), e.sn = s.sn, e.specificationLabels = s.specificationLabels, e.serialNumber = s.serialNumber, e.classifySerialNumber = s.classify.serialNumber, e.classifyId = s.classify.id, e.classifyFullPathId = s.classify.fullPathId, e.classifyFullName = s.classify.fullName, e.classifyName = s.classify.name, e.classifyParentFullName = s.classify.parentFullName, e.basicClass = s.classify.basicClass, e.specification = s.spec, e.specificationMap = s.specKV, e.measureUnit = s.classify.measureUnit, e.accountingUnit = s.classify.accountingUnit, e.accountingPrecision = s.classify.accountingPrecision, e.measurePrecision = s.classify.measurePrecision, e.quantity && (e.quantity = q(e.quantity, e.measurePrecision)), e.mete && (e.mete = q(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0), (!e.unitPrice || !e.amount) && ka(e);
    else throw new Error(`${e.classifyName}下不存在规格为“${t}”的材料，请联系管理员/仓库人员添加`);
  }
  return n;
} }, aa = { title: "其它入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "金额", field: "amount", excelField: "__EMPTY_7" }, { label: "颜色", field: "color", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "备注", field: "remark", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (f) => {
  var E;
  if (!j(f, aa.rules)) return;
  d.state.config.loaded.matClsTree || await d.dispatch("config/fetchMatClsTree");
  const w = d.state.config.rawMatClsList.filter((e) => e.basicClass === P.OTHER.V), b = d.state.config.rawMatClsKV, n = R(f), _ = [];
  let u = [];
  if (n.forEach((e) => {
    let a = false;
    const s = B(e.classifyName.split("/"));
    for (const t of w) if (t.fullPathName.length >= s.length && Q(t.fullPathName.slice(-s.length), s)) {
      a = true, e.classifyId = t.id, _.push(t.id);
      break;
    }
    a || u.push(e.classifyName);
  }), u = Array.from(new Set(u)), u.length > 0) throw new Error(`${u.map((e) => `“${e}”`).join("、")}${u.length > 1 ? "等" : ""}物料种类不存在`);
  const p = d.state.config.classifySpec, i = _.filter((e) => p[e] === void 0);
  i.length > 0 && (i.forEach((e) => {
    p[e] = {};
  }), await d.dispatch("config/fetchMarClsSpec", i));
  for (const e of n) {
    if (((E = b == null ? void 0 : b[e.classifyId]) == null ? void 0 : E.isLeaf) === false) throw new Error(`${e.classifyName}不是末级科目`);
    const a = p[e.classifyId];
    if (a.hasUnitConfig === false) throw new Error(`${e.classifyName}未配置核算单位`);
    let s;
    const t = e.specification ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const y of a.specList) if (t === y.spec) {
        if (s = y, e.measureUnit) {
          if (!s.classify.measureUnit) throw new Error(`${e.classifyName}不存在计量单位`);
          if (!await k(s.classify.measureUnit, e.measureUnit)) throw new Error(`${e.classifyName}填写的计量单位错误，单位应为：“${s.classify.measureUnit}”`);
        }
        if (e.accountingUnit && !await k(s.classify.accountingUnit, e.accountingUnit)) throw new Error(`${e.classifyName}填写的核算单位错误，单位应为：“${s.classify.accountingUnit}”`);
        break;
      }
    }
    if (s) e.uid = H(), e.sn = s.sn, e.specificationLabels = s.specificationLabels, e.serialNumber = s.serialNumber, e.classifySerialNumber = s.classify.serialNumber, e.classifyId = s.classify.id, e.classifyFullPathId = s.classify.fullPathId, e.classifyFullName = s.classify.fullName, e.classifyName = s.classify.name, e.classifyParentFullName = s.classify.parentFullName, e.basicClass = s.classify.basicClass, e.specification = s.spec, e.specificationMap = s.specKV, e.measureUnit = s.classify.measureUnit, e.accountingUnit = s.classify.accountingUnit, e.accountingPrecision = s.classify.accountingPrecision, e.measurePrecision = s.classify.measurePrecision, e.quantity && (e.quantity = q(e.quantity, e.measurePrecision)), e.mete && (e.mete = q(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0);
    else throw new Error(`${e.classifyName}下不存在规格为“${t}”的材料，请联系管理员/仓库人员添加`);
  }
  return n;
} }, sa = { title: "气体入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "金额", field: "amount", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }, { label: "备注", field: "remark", excelField: "__EMPTY_9" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (f) => {
  var E;
  if (!j(f, sa.rules)) return;
  d.state.config.loaded.matClsTree || await d.dispatch("config/fetchMatClsTree");
  const w = d.state.config.rawMatClsList.filter((e) => e.basicClass === P.GAS.V), b = d.state.config.rawMatClsKV, n = R(f), _ = [];
  let u = [];
  if (n.forEach((e) => {
    let a = false;
    const s = B(e.classifyName.split("/"));
    for (const t of w) if (t.fullPathName.length >= s.length && Q(t.fullPathName.slice(-s.length), s)) {
      a = true, e.classifyId = t.id, _.push(t.id);
      break;
    }
    a || u.push(e.classifyName);
  }), u = Array.from(new Set(u)), u.length > 0) throw new Error(`${u.map((e) => `“${e}”`).join("、")}${u.length > 1 ? "等" : ""}物料种类不存在`);
  const p = d.state.config.classifySpec, i = _.filter((e) => p[e] === void 0);
  i.length > 0 && (i.forEach((e) => {
    p[e] = {};
  }), await d.dispatch("config/fetchMarClsSpec", i));
  for (const e of n) {
    if (((E = b == null ? void 0 : b[e.classifyId]) == null ? void 0 : E.isLeaf) === false) throw new Error(`${e.classifyName}不是末级科目`);
    const a = p[e.classifyId];
    if (a.hasUnitConfig === false) throw new Error(`${e.classifyName}未配置核算单位`);
    let s;
    const t = e.specification ?? "";
    if (a && Array.isArray(a.specList)) {
      for (const y of a.specList) if (t === y.spec) {
        if (s = y, e.measureUnit) {
          if (!s.classify.measureUnit) throw new Error(`${e.classifyName}不存在计量单位`);
          if (!await k(s.classify.measureUnit, e.measureUnit)) throw new Error(`${e.classifyName}填写的计量单位错误，单位应为：“${s.classify.measureUnit}”`);
        }
        if (e.accountingUnit && !await k(s.classify.accountingUnit, e.accountingUnit)) throw new Error(`${e.classifyName}填写的核算单位错误，单位应为：“${s.classify.accountingUnit}”`);
        break;
      }
    }
    if (s) e.uid = H(), e.sn = s.sn, e.specificationLabels = s.specificationLabels, e.serialNumber = s.serialNumber, e.classifySerialNumber = s.classify.serialNumber, e.classifyId = s.classify.id, e.classifyFullPathId = s.classify.fullPathId, e.classifyFullName = s.classify.fullName, e.classifyName = s.classify.name, e.classifyParentFullName = s.classify.parentFullName, e.basicClass = s.classify.basicClass, e.specification = s.spec, e.specificationMap = s.specKV, e.measureUnit = s.classify.measureUnit, e.accountingUnit = s.classify.accountingUnit, e.accountingPrecision = s.classify.accountingPrecision, e.measurePrecision = s.classify.measurePrecision, e.quantity && (e.quantity = q(e.quantity, e.measurePrecision)), e.mete && (e.mete = q(e.mete, e.accountingPrecision)), e.measureUnit || (e.quantity = void 0);
    else throw new Error(`${e.classifyName}下不存在规格为“${t}”的材料，请联系管理员/仓库人员添加`);
  }
  return n;
} };
const ja = { class: "inbound-application-header flex-rbc" }, Ra = { class: "child-mr-7 flex-rsc" }, Ba = { __name: "common-header", props: { purchaseId: { type: String }, basicClass: { type: Number }, validate: { type: Function }, currentBasicClass: { type: Number }, isManuf: { type: Boolean, default: false }, edit: { type: Boolean, default: false } }, emits: ["update:purchaseId", "purchase-order-change"], setup(f, { expose: A, emit: w }) {
  const b = w, n = f, _ = ua(), u = da("matSpecRef"), { cu: p, form: i, FORM: E } = Ca(), { overDiffTip: e, weightOverDiff: a, diffSubmitValidate: s } = Sa(), t = (o, m, F) => {
    if (m == null) {
      F();
      return;
    }
    s(W.value.hasOver) ? F() : F(new Error("超出误差允许范围"));
  }, y = { purchaseId: [{ required: true, message: "请选择订单", trigger: "change" }], licensePlate: [{ pattern: ze, message: "请填写正确的车牌号", trigger: "blur" }], loadingWeight: [{ validator: t, trigger: "blur" }] }, N = { loadingWeight: [{ required: true, message: "请填写过磅重量", trigger: "blur" }, { validator: t, trigger: "blur" }] }, ia = { licensePlate: [{ required: true, message: "请填写车牌号", trigger: "blur" }, { pattern: ze, message: "请填写正确的车牌号", trigger: "blur" }] }, ta = fe(() => {
    const o = Object.assign({}, y);
    return M.value.logisticsTransportType === G.FREIGHT.V && M.value.logisticsPayerType === Fa.DEMAND.V && Object.assign(o, ia), n.basicClass & ye && M.value.weightMeasurementMode === ae.OVERWEIGHT.V && Object.assign(o, N), o;
  }), la = fe(() => {
    switch (n.currentBasicClass ?? n.basicClass) {
      case P.STEEL_PLATE.V:
        return Xe;
      case P.SECTION_STEEL.V:
        return Ze;
      case P.STEEL_COIL.V:
        return ea;
      case P.MATERIAL.V:
        return me;
      case P.OTHER.V:
        return aa;
      case P.GAS.V:
        return sa;
      default:
        return me;
    }
  }), C = ue(), W = ue({}), M = ue({}), be = fe(() => i.supplyType === z.PARTY_A.V);
  De(() => {
    W.value = a(i.loadingWeight, p.props.totalWeight), n.basicClass & ye && M.value.weightMeasurementMode === ae.OVERWEIGHT.V && C.value && C.value.validateField("loadingWeight");
  }), E.HOOK.afterSubmit = () => {
    _e(), ee(() => {
      C.value && C.value.resetFields();
    });
  };
  function ca() {
    _e(), ee(() => {
      C.value && C.value.clearValidate();
    });
  }
  function _e() {
    W.value = {}, M.value = {};
    const o = De(() => {
      u.value && (u.value.clear(), ee(() => {
        o();
      }));
    });
  }
  pa(() => i.supplyType, () => {
    if (i.supplyType && i.supplyType === z.PARTY_A.V) {
      ne(void 0);
      const o = { supplyType: i.supplyType, weightMeasurementMode: ae.THEORY.V, basicClass: n.basicClass };
      re(o);
    } else ne(void 0), re(void 0);
  }, { immediate: true });
  function ne(o) {
    ee(() => {
      var m;
      W.value = {}, (m = C == null ? void 0 : C.value) == null || m.clearValidate();
    }), i.purchaseId = o, b("update:purchaseId", o);
  }
  async function re(o, m) {
    var F;
    if (p.props.requisitions = {}, i.selectObj || (i.selectObj = {}), o && (o.requisitionsSN && na(o.requisitionsSN), o.logisticsTransportType === G.POST.V && (i.licensePlate = void 0), o.logisticsTransportType === G.FREIGHT.V && (i.shipmentNumber = void 0), M.value && M.value.weightMeasurementMode !== o.weightMeasurementMode && (i.loadingWeight = void 0), (F = o.applyPurchase) != null && F.length ? (o.boolApplyPurchase = true, o.projects = []) : o.boolApplyPurchase = false, o.id)) {
      const { content: x = [] } = await Ua(o.id);
      await se(x), await ie(x, { toNum: true }, { mete: ["mete", "inboundMete"], quantity: ["inboundQuantity", "quantity"] }), o.details = x == null ? void 0 : x.map((h) => {
        var Z, D, S, Ee, Pe, Te, Ne, we, Me, xe, Ce, Se, Fe, Ue, Ie, Le, $e, Ve;
        const X = {};
        h.mergeId = h.id, h.purchaseOrderDetailId = h.id, h.purchaseQuantity = h.quantity, h.purchaseMete = h.mete, h.boolApplyPurchase = false, h.canPurchaseQuantity = h.purchaseQuantity - h.inboundQuantity > 0 ? h.purchaseQuantity - h.inboundQuantity : 0;
        let I = false;
        (Z = i.selectObj) != null && Z[h.mergeId] ? I = (D = i.selectObj[h.mergeId]) == null ? void 0 : D.isSelected : n.edit && ((S = i == null ? void 0 : i.editObj) != null && S[h.mergeId]) && (I = (Pe = (Ee = i == null ? void 0 : i.editObj) == null ? void 0 : Ee[h.mergeId]) == null ? void 0 : Pe.isSelected);
        let r = h;
        if (I && (r = { ...r, ...(Te = i == null ? void 0 : i.selectObj) == null ? void 0 : Te[h.mergeId], ...(Ne = i == null ? void 0 : i.editObj) == null ? void 0 : Ne[h.mergeId] }), i.selectObj[h.mergeId] = { ...r, isSelected: I }, (we = r.applyPurchase) != null && we.length) {
          r.boolApplyPurchase = true;
          let v = 0, O = 0;
          const oe = [];
          r.applyPurchase.forEach((l) => {
            var Ye, qe, Ae, We, ve, Oe, ke, je, Re, Be;
            if (l.applyPurchaseSN = l.serialNumber, X[l.id] = l, r.basicClass & (P.SECTION_STEEL.V | P.STEEL_PLATE.V)) {
              const c = n.edit ? (Ye = i == null ? void 0 : i.editObj) == null ? void 0 : Ye[r.mergeId] : r;
              l.sn = c == null ? void 0 : c.sn, l.specificationLabels = c == null ? void 0 : c.specificationLabels, l.serialNumber = c == null ? void 0 : c.serialNumber, l.classifyId = c == null ? void 0 : c.classifyId, l.classifyFullName = c == null ? void 0 : c.classifyFullName, l.classifyName = c == null ? void 0 : c.classifyName, l.classifyParentFullName = c == null ? void 0 : c.classifyParentFullName, l.basicClass = c == null ? void 0 : c.basicClass, l.specification = c == null ? void 0 : c.specification, l.specificationMap = c == null ? void 0 : c.specKV, l.measureUnit = c == null ? void 0 : c.measureUnit, l.accountingUnit = c == null ? void 0 : c.accountingUnit, l.measurePrecision = c == null ? void 0 : c.measurePrecision, l.accountingPrecision = c == null ? void 0 : c.accountingPrecision, l.unitWeight = c == null ? void 0 : c.unitWeight, l.length = c == null ? void 0 : c.length, l.width = c == null ? void 0 : c.width, l.thickness = c == null ? void 0 : c.thickness;
            }
            if (r.basicClass & P.MATERIAL.V) {
              const c = n.edit ? (qe = i == null ? void 0 : i.editObj) == null ? void 0 : qe[r.mergeId] : r;
              (Ae = r.applyPurchase) != null && Ae.length && (l.measureUnit = c == null ? void 0 : c.measureUnit, l.accountingUnit = c == null ? void 0 : c.accountingUnit);
            }
            if ((!I || n.edit) && (l.applyPurchaseId = l.id, l.purchaseQuantity = l.quantity, l.purchaseMete = l.mete, l.quantity = null, l.mete = null), n.edit && ((ke = (Oe = (ve = (We = i == null ? void 0 : i.editObj) == null ? void 0 : We[r.mergeId]) == null ? void 0 : ve.applyPurchaseObj) == null ? void 0 : Oe[l.applyPurchaseId]) != null && ke.length)) {
              const c = (Be = (Re = (je = i == null ? void 0 : i.editObj) == null ? void 0 : je[r.mergeId]) == null ? void 0 : Re.applyPurchaseObj) == null ? void 0 : Be[l.applyPurchaseId];
              for (let K = 0; K < c.length; K++) {
                const T = c[K];
                l.unitWeight = T == null ? void 0 : T.unitWeight, l.length = T == null ? void 0 : T.length, l.width = T == null ? void 0 : T.width, l.thickness = T == null ? void 0 : T.thickness;
                const Qe = T.quantity, He = T.mete;
                l.quantity = Qe, O += Qe, l.mete = He, v += He, l.theoryWeight = T.theoryWeight, l.theoryTotalWeight = T.theoryTotalWeight, l.originQuantity = l.quantity, l.originMete = l.mete, l != null && l.project && o.projects.push(l == null ? void 0 : l.project), l.spanMerge = K === 0 ? c.length : 0, l.isBranch = K > 0, oe.push(JSON.parse(JSON.stringify(l)));
              }
            } else O += l.quantity || 0, v += l.mete || 0, l.originQuantity = l.quantity, l.originMete = l.mete, l != null && l.project && o.projects.push(l == null ? void 0 : l.project), oe.push(JSON.parse(JSON.stringify(l)));
          }), r.applyPurchase = oe, r.basicClass & P.MATERIAL.V && (n.edit ? (se(r.applyPurchase), ie(r.applyPurchase, { toNum: true }, { mete: ["inboundMete", "purchaseMete"], quantity: ["inboundQuantity", "purchaseQuantity"] })) : (se(r.applyPurchase), ie(r.applyPurchase, { toNum: true }, { mete: ["mete", "inboundMete", "purchaseMete"], quantity: ["inboundQuantity", "quantity", "purchaseQuantity"] }))), r.quantity = O, r.mete = v;
        } else r.quantity = null, r.mete = null;
        return n.edit && ((Me = i == null ? void 0 : i.editObj) != null && Me[r.mergeId]) ? (r.quantity = (Ce = (xe = i == null ? void 0 : i.editObj) == null ? void 0 : xe[r.mergeId]) == null ? void 0 : Ce.quantity, r.mete = (Fe = (Se = i == null ? void 0 : i.editObj) == null ? void 0 : Se[r.mergeId]) == null ? void 0 : Fe.mete) : I && (r.quantity = (Ie = (Ue = i == null ? void 0 : i.selectObj) == null ? void 0 : Ue[r.mergeId]) == null ? void 0 : Ie.quantity, r.mete = ($e = (Le = i == null ? void 0 : i.selectObj) == null ? void 0 : Le[r.mergeId]) == null ? void 0 : $e.mete), r.originQuantity = r.quantity, r.originMete = r.mete, n.edit && (r.needFirstCalcTheoryWeight = true), (Ve = h.inboundList) != null && Ve.length && (se(h.inboundList), ie(h.inboundList, { toNum: true }), h.inboundList.forEach((v) => {
          var O;
          v.applyPurchaseSN = (O = X[v.applyPurchaseId]) == null ? void 0 : O.applyPurchaseSN;
        })), r;
      });
    }
    M.value = o || {}, b("purchase-order-change", o, m);
  }
  async function na(o) {
    if (Ge(o)) return;
    const m = [];
    o.forEach((F) => {
      const x = Ia(F).then((h) => {
        p.props.requisitions[F] = h;
      });
      m.push(x);
    }), await Promise.all(m);
  }
  function ra(o) {
    try {
      p.props.import(o), n.validate();
    } catch (m) {
      ga.error({ message: m.message, duration: 5e3 });
    }
  }
  function oa() {
    Ya.set("ROUTER_PARAMS", { basicClass: n.basicClass }), _.push({ name: "RawMatInboundApplicationRecord" });
  }
  async function fa() {
    try {
      return C.value ? await C.value.validate() : false;
    } catch {
      return false;
    }
  }
  return A({ validate: fa }), (o, m) => {
    var D;
    const F = de("common-radio-button"), x = ba, h = _a, X = de("common-input-number"), I = Ea, r = Pa, Z = de("common-button");
    return U(), Ke("div", ja, [pe("div", null, [V(r, { ref_key: "formRef", ref: C, model: g(i), rules: ta.value, size: "default", "label-position": "right", inline: "", "label-width": "80px" }, { default: L(() => [n.isManuf ? $("", true) : (U(), Y(x, { key: 0, prop: "supplyType", "label-width": "0px" }, { default: L(() => [V(F, { modelValue: g(i).supplyType, "onUpdate:modelValue": m[0] || (m[0] = (S) => g(i).supplyType = S), disabled: f.edit, options: g(z).ENUM, style: ya([f.edit ? "" : "margin-left:10px", { "vertical-align": "middle" }]), default: "", type: "enumSL" }, { suffix: L(() => m[5] || (m[5] = [pe("span", null, "入库", -1)])), _: 1 }, 8, ["modelValue", "disabled", "options", "style"])]), _: 1 })), be.value ? $("", true) : (U(), Y(x, { key: 1, label: n.isManuf ? "订单号" : "", "label-width": n.isManuf ? "70px" : "0px", prop: "purchaseId" }, { default: L(() => [V(La, { modelValue: g(i).purchaseId, "onUpdate:modelValue": m[1] || (m[1] = (S) => g(i).purchaseId = S), "basic-class": n.basicClass, disabled: f.edit, class: "input-underline", style: { width: "300px" }, onChange: ne, onInfoChange: re }, null, 8, ["modelValue", "basic-class", "disabled"])]), _: 1 }, 8, ["label", "label-width"])), g(le)(M.value) ? (U(), Ke(ha, { key: 2 }, [M.value.logisticsTransportType === g(G).FREIGHT.V ? (U(), Y(x, { key: 0, label: "车牌号", "label-width": "70px", prop: "licensePlate" }, { default: L(() => [V(h, { modelValue: g(i).licensePlate, "onUpdate:modelValue": m[2] || (m[2] = (S) => g(i).licensePlate = S), modelModifiers: { trim: true }, class: "input-underline", placeholder: "车牌号", style: { width: "125px" } }, null, 8, ["modelValue"])]), _: 1 })) : $("", true), M.value.logisticsTransportType === g(G).POST.V ? (U(), Y(x, { key: 1, label: "物流单号", "label-width": "70px", prop: "shipmentNumber" }, { default: L(() => [V(h, { modelValue: g(i).shipmentNumber, "onUpdate:modelValue": m[3] || (m[3] = (S) => g(i).shipmentNumber = S), modelModifiers: { trim: true }, class: "input-underline", maxlength: "100", placeholder: "物流单号", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })) : $("", true), n.basicClass & g(ye) && M.value.weightMeasurementMode === g(ae).OVERWEIGHT.V ? (U(), Y(x, { key: 2, label: "车次过磅重量(t)", "label-width": "150px", prop: "loadingWeight" }, { default: L(() => [V(I, { content: `重量误差：${W.value.overNum} kg， ${g(e)}`, disabled: !W.value.hasOver, class: "item", effect: "dark", placement: "top" }, { default: L(() => [V(X, { modelValue: g(i).loadingWeight, "onUpdate:modelValue": m[4] || (m[4] = (S) => g(i).loadingWeight = S), class: ma([{ "over-weight-tip": W.value.hasOver }, "input-underline"]), controls: false, max: 999999999, min: 0, placeholder: "输入该车次重量", precision: 0, mode: "input", style: { width: "135px" } }, null, 8, ["modelValue", "class"])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 })) : $("", true)], 64)) : $("", true)]), _: 1 }, 8, ["model", "rules"])]), pe("div", Ra, [n.edit ? $("", true) : (U(), Y($a, { key: 0, type: "cu", onClear: ca })), be.value || g(Ge)((D = M.value) == null ? void 0 : D.details) ? (U(), Y(I, { key: 1, disabled: !!g(i).purchaseId && g(i).supplyType === g(z).SELF.V, content: "请先选择采购合同编号", effect: "light", placement: "bottom" }, { default: L(() => [V(Va, { disabled: !g(i).purchaseId && g(i).supplyType === g(z).SELF.V, template: la.value, icon: "el-icon-upload", "btn-name": "批量导入", "btn-size": "default", "btn-type": "success", "open-loading": "", onSuccess: ra }, null, 8, ["disabled", "template"])]), _: 1 }, 8, ["disabled"])) : $("", true), n.edit ? $("", true) : (U(), Y(Z, { key: 2, icon: "el-icon-clock", type: "info", size: "default", onClick: oa }))])]);
  };
} }, Da = xa(Ba, [["__scopeId", "data-v-64d367df"]]);
export {
  Da as default
};
