import { useStore as Re } from "vuex";
import { ref as N } from "vue";
import { provide as ue } from "vue";
import { reactive as me } from "vue";
import { computed as B } from "vue";
import { watchEffect as $e } from "vue";
import { watch as $ } from "vue";
import { nextTick as A } from "vue";
import { resolveComponent as de } from "vue";
import { openBlock as Y } from "vue";
import { createElementBlock as ge } from "vue";
import { createVNode as U } from "vue";
import { withCtx as q } from "vue";
import { createElementVNode as G } from "vue";
import { unref as L } from "vue";
import { ElRadioGroup as Ae } from "element-plus";
import { Fragment as Oe } from "vue";
import { renderList as ke } from "vue";
import { createTextVNode as J } from "vue";
import { toDisplayString as X } from "vue";
import { createBlock as he } from "vue";
import { createCommentVNode as Be } from "vue";
import { resolveDynamicComponent as Ye } from "vue";
import { normalizeStyle as De } from "vue";
import { ElMessage as O } from "element-plus";
import { ElRadioButton as He } from "element-plus";
import { ElForm as Qe } from "element-plus";
import { rJ as te, am as _, vP as ie, vQ as ve, j as d, V as se, vR as ae, f3 as le, aI as ne, sT as je, i as W, iX as Ee, sU as Ke, v9 as ze, va as Ge, _ as Je, sQ as Xe, tB as Ze, wx as pe, wc as ye, c as _e, o as be, bs as et, wB as tt, vv as it, L as st, vw as at, vx as lt, cV as nt, cQ as ct, wp as ot, b as D } from "../../../../../../shared/runtime.js";
import rt from "../components/common-wrapper.vue.js";
import ft from "./module/steel-plate-table.vue.js";
import ut from "./module/section-steel-table.vue.js";
import mt from "./module/steel-coil-table.vue.js";
import dt from "../components/inventory-drawer.vue.js";
import "../components/common-footer.vue.js";
import "../components/confirm-dialog.vue.js";
import "../../../../../../modules/use-approval-cfg-0a67817c.js";
const k = te[_.STEEL_PLATE.V], ee = { title: "钢板申购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: k.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: k.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: k.length.precision, excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", precision: k.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: k.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (u) => {
  var e;
  if (!ie(u, ee.rules)) return;
  const E = await ve();
  d.state.wms.loaded.steelDensityCfg || await d.dispatch("config/fetchSteelDensityCfg");
  const F = d.state.wms.steelDensityCfg;
  d.state.config.loaded.matClsTree || await d.dispatch("config/fetchMatClsTree");
  const T = d.state.config.rawMatClsList.filter((t) => t.basicClass === _.STEEL_PLATE.V), h = d.state.config.rawMatClsKV, r = se(u), p = [];
  let y = [];
  if (r.forEach((t) => {
    let s = false;
    const c = ae(t.classifyName.split("/"));
    for (const o of T) if (o.fullPathName.length >= c.length && le(o.fullPathName.slice(-c.length), c)) {
      s = true, t.classifyId = o.id, p.push(o.id);
      break;
    }
    s || y.push(t.classifyName);
  }), y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((t) => `“${t}”`).join("、")}${y.length > 1 ? "等" : ""}物料种类不存在`);
  const g = d.state.config.classifySpec, I = p.filter((t) => g[t] === void 0);
  I.length > 0 && (I.forEach((t) => {
    g[t] = {};
  }), await d.dispatch("config/fetchMarClsSpec", I));
  for (const t of r) {
    if (((e = h == null ? void 0 : h[t.classifyId]) == null ? void 0 : e.isLeaf) === false) throw new Error(`${t.classifyName}不是末级科目`);
    const s = g[t.classifyId];
    if (s.hasUnitConfig === false) throw new Error(`${t.classifyName}未配置核算单位`);
    let c;
    const o = t.material ?? "";
    if (s && Array.isArray(s.specList)) {
      for (const n of s.specList) if (o === n.spec) {
        c = n;
        break;
      }
    }
    if (c) {
      t.uid = ne(), t.sn = c.sn, t.specificationLabels = c.specificationLabels, t.serialNumber = c.serialNumber, t.classifySerialNumber = c.classify.serialNumber, t.classifyId = c.classify.id, t.classifyFullName = c.classify.fullName, t.classifyName = c.classify.name, t.classifyParentFullName = c.classify.parentFullName, t.basicClass = c.classify.basicClass, t.specification = c.spec, t.specificationMap = c.specKV, t.measureUnit = c.classify.measureUnit, t.accountingUnit = c.classify.accountingUnit, t.accountingPrecision = c.classify.accountingPrecision, t.measurePrecision = c.classify.measurePrecision;
      let n = 0;
      for (const x in F) Number(x) === t.classifyId && (n = F[x]);
      t.steelDensity = n, t.theoryWeight = await je({ classifyId: t.classifyId, name: t.classifyFullName, length: t.length, width: t.width, thickness: t.thickness }), W(t.theoryWeight) && t.quantity ? t.theoryTotalWeight = Ee(t.theoryWeight * t.quantity, E[_.STEEL_PLATE.V].weight.precision) : t.theoryTotalWeight = void 0, t.weighingTotalWeight = t.weighingTotalWeight && !isNaN(t.weighingTotalWeight) ? t.weighingTotalWeight : t.theoryTotalWeight, t.mete = t.weighingTotalWeight;
    } else throw new Error(`${t.classifyName}下不存在规格为“${o}”的材料，请联系管理员/仓库人员添加`);
  }
  return r;
} }, Z = te[_.SECTION_STEEL.V], Te = { title: "型材申购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格/材质", field: "specification", excelField: "__EMPTY_1" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: Z.length.precision, excelField: "__EMPTY_2" }, { label: "数量（根）", field: "quantity", type: "number", precision: Z.measure.precision, excelField: "__EMPTY_3" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: Z.weight.precision, excelField: "__EMPTY_4" }, { label: "品牌", field: "brand", excelField: "__EMPTY_5" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "型材规格不能为空" }] }, format: async (u) => {
  var I;
  if (!ie(u, Te.rules)) return;
  const E = await ve();
  d.state.config.loaded.matClsTree || await d.dispatch("config/fetchMatClsTree");
  const F = d.state.config.rawMatClsList.filter((e) => e.basicClass === _.SECTION_STEEL.V), T = d.state.config.rawMatClsKV, h = se(u), r = [];
  let p = [];
  if (h.forEach((e) => {
    let t = false;
    const s = ae(e.classifyName.split("/"));
    console.log(F, "matList");
    for (const c of F) if (c.fullPathName.length >= s.length && le(c.fullPathName.slice(-s.length), s)) {
      t = true, e.classifyId = c.id, r.push(c.id);
      break;
    }
    t || p.push(e.classifyName);
  }), p = Array.from(new Set(p)), p.length > 0) throw new Error(`${p.map((e) => `“${e}”`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在`);
  const y = d.state.config.classifySpec, g = r.filter((e) => y[e] === void 0);
  g.length > 0 && (g.forEach((e) => {
    y[e] = {};
  }), await d.dispatch("config/fetchMarClsSpec", g));
  for (const e of h) {
    if (((I = T == null ? void 0 : T[e.classifyId]) == null ? void 0 : I.isLeaf) === false) throw new Error(`${e.classifyName}不是末级科目`);
    const t = y[e.classifyId];
    if (t.hasUnitConfig === false) throw new Error(`${e.classifyName}未配置核算单位`);
    let s;
    const c = ht(e.specification);
    if (t && Array.isArray(t.specList)) {
      for (const o of t.specList) if (c === o.spec) {
        s = o;
        break;
      }
    }
    if (s) e.uid = ne(), e.sn = s.sn, e.specificationLabels = s.specificationLabels, e.serialNumber = s.serialNumber, e.classifySerialNumber = s.classify.serialNumber, e.classifyId = s.classify.id, e.classifyFullName = s.classify.fullName, e.classifyName = s.classify.name, e.classifyParentFullName = s.classify.parentFullName, e.basicClass = s.classify.basicClass, e.specification = s.spec, e.specificationMap = s.specKV, e.measureUnit = s.classify.measureUnit, e.accountingUnit = s.classify.accountingUnit, e.accountingPrecision = s.classify.accountingPrecision, e.measurePrecision = s.classify.measurePrecision, e.unitWeight = s.unitWeight, e.theoryWeight = await Ke({ length: e.length, unitWeight: e.unitWeight }), W(e.theoryWeight) && e.quantity ? e.theoryTotalWeight = Ee(e.theoryWeight * e.quantity, E[_.SECTION_STEEL.V].weight.precision) : e.theoryTotalWeight = void 0, e.weighingTotalWeight = e.weighingTotalWeight && !isNaN(e.weighingTotalWeight) ? e.weighingTotalWeight : e.theoryTotalWeight, gt(e), e.mete = e.weighingTotalWeight;
    else throw new Error(`${e.classifyName}下不存在规格为“${c}”的材料，请联系管理员/仓库人员添加`);
  }
  return h;
} };
function gt(u) {
  W(u.length) && u.quantity ? u.totalLength = ze({ length: u.length, quantity: u.quantity }) : u.totalLength = void 0;
}
function ht(u) {
  const M = u.replace(/\s+/g, ""), E = M.lastIndexOf("*");
  return E > -1 ? M.substring(0, E) + " * " + M.substring(E + 1) : M.substring(E + 1);
}
const H = te[_.STEEL_COIL.V], we = { title: "钢卷申购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: H.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: H.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: H.length.precision, excelField: "__EMPTY_4" }, { label: "总重（kg）", field: "weighingTotalWeight", type: "number", precision: H.weight.precision, excelField: "__EMPTY_5" }, { label: "品牌", field: "brand", excelField: "__EMPTY_6" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (u) => {
  var I;
  if (!ie(u, we.rules)) return;
  d.state.config.loaded.matClsTree || await d.dispatch("config/fetchMatClsTree"), d.state.wms.loaded.steelDensityCfg || await d.dispatch("config/fetchSteelDensityCfg");
  const E = d.state.wms.steelDensityCfg, F = d.state.config.rawMatClsList.filter((e) => e.basicClass === _.STEEL_COIL.V), T = d.state.config.rawMatClsKV, h = se(u), r = [];
  let p = [];
  if (h.forEach((e) => {
    let t = false;
    const s = ae(e.classifyName.split("/"));
    for (const c of F) if (c.fullPathName.length >= s.length && le(c.fullPathName.slice(-s.length), s)) {
      t = true, e.classifyId = c.id, r.push(c.id);
      break;
    }
    t || p.push(e.classifyName);
  }), p = Array.from(new Set(p)), p.length > 0) throw new Error(`${p.map((e) => `“${e}”`).join("、")}${p.length > 1 ? "等" : ""}物料种类不存在`);
  const y = d.state.config.classifySpec, g = r.filter((e) => y[e] === void 0);
  g.length > 0 && (g.forEach((e) => {
    y[e] = {};
  }), await d.dispatch("config/fetchMarClsSpec", g));
  for (const e of h) {
    if (((I = T == null ? void 0 : T[e.classifyId]) == null ? void 0 : I.isLeaf) === false) throw new Error(`${e.classifyName}不是末级科目`);
    const t = y[e.classifyId];
    if (t.hasUnitConfig === false) throw new Error(`${e.classifyName}未配置核算单位`);
    let s;
    const c = e.material ?? "";
    if (t && Array.isArray(t.specList)) {
      for (const o of t.specList) if (c === o.spec) {
        s = o;
        break;
      }
    }
    if (s) {
      e.uid = ne(), e.sn = s.sn, e.specificationLabels = s.specificationLabels, e.serialNumber = s.serialNumber, e.classifySerialNumber = s.classify.serialNumber, e.classifyId = s.classify.id, e.classifyFullName = s.classify.fullName, e.classifyName = s.classify.name, e.classifyParentFullName = s.classify.parentFullName, e.basicClass = s.classify.basicClass, e.specification = s.spec, e.specificationMap = s.specKV, e.measureUnit = s.classify.measureUnit, e.accountingUnit = s.classify.accountingUnit, e.accountingPrecision = s.classify.accountingPrecision, e.measurePrecision = s.classify.measurePrecision;
      let o = 0;
      for (const n in E) Number(n) === e.classifyId && (o = E[n]);
      e.steelDensity = o, await pt(e), e.length = e.length ?? e.theoryLength, e.quantity = e.length, e.mete = e.weighingTotalWeight;
    } else throw new Error(`${e.classifyName}下不存在规格为“${c}”的材料，请联系管理员/仓库人员添加`);
  }
  return h;
} };
async function pt(u) {
  u.theoryLength = await Ge({ classifyId: u.classifyId, name: u.classifyFullName, weight: u.weighingTotalWeight, width: u.width, thickness: u.thickness });
}
const yt = { class: "steel-requisitions-application-container" }, _t = { class: "filter-container" }, bt = { class: "filter-left-box" }, vt = { class: "filter-right-box" }, Et = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false } }, emits: ["success"], setup(u, { emit: M }) {
  const E = Re(), F = M, T = u, { baseUnit: h } = Xe(), r = { steelPlateList: { K: "steelPlateList", L: "钢板", V: _.STEEL_PLATE.V, TABLE: ft }, sectionSteelList: { K: "sectionSteelList", L: "型材", V: _.SECTION_STEEL.V, TABLE: ut }, steelCoilList: { K: "steelCoilList", L: "钢卷", V: _.STEEL_COIL.V, TABLE: mt } }, p = { list: [], steelPlateList: [], sectionSteelList: [], steelCoilList: [], originInventoryInfo: {} }, y = N(), g = N(), I = N(), e = N(), t = N(false), s = N(false), c = N({}), o = N(), n = N(), x = N([]), ce = N({});
  ue("useInventoryInfo", ce);
  const P = me({ steelPlateList: null, sectionSteelList: null, steelCoilList: null });
  ue("matSpecRef", g);
  const oe = (a) => {
    const i = { steelPlateList: null, sectionSteelList: null, steelCoilList: null }, v = { steelPlateList: null, sectionSteelList: null, steelCoilList: null }, b = ["steelPlateList", "sectionSteelList", "steelCoilList"];
    let C = false;
    b.forEach((f) => {
      W(a[f]) && (C || (C = true, n.value = f), a[f] = a[f].map((w) => me(w)), i[f] = $(P, (w) => {
        w[f] && (a[f].forEach((m) => w[f].rowWatch(m)), v[f] = $(g, () => {
          g.value && (g.value.initSelected(a[f].map((m) => ({ sn: m.sn, classifyId: m.classifyId }))), A(() => {
            v[f]();
          }));
        }, { immediate: true }), A(() => {
          i[f]();
        }));
      }, { immediate: true, deep: true }));
    });
  }, { cu: S, form: l, FORM: re } = Ze({ title: "钢材申购", defaultForm: p, useDraftCallback: oe, clearDraftCallback: Q, api: T.isEdit ? pe.edit : pe.add }, I, T.detail), fe = B(() => {
    var a;
    return (a = l.list) == null ? void 0 : a.filter((i) => {
      var v, b;
      return (b = (v = S == null ? void 0 : S.submitResult) == null ? void 0 : v.data) == null ? void 0 : b.includes(i.classifyId);
    });
  });
  $e(() => {
    var a, i, v, b, C, f, w, m;
    if ((a = x.value) != null && a.length) {
      const R = {};
      for (let j = 0; j < x.value.length; j++) {
        const V = x.value[j];
        if (V.requisitionMode === ye.USE_INVENTORY.V) {
          const K = (i = l.originInventoryInfo[V.materialInventoryId]) == null ? void 0 : i.basicClass, z = K & _.STEEL_COIL.V && V.basicClass & _.STEEL_COIL.V ? _e(V.length, (b = (v = h.value[V.basicClass]) == null ? void 0 : v.length) == null ? void 0 : b.unit, (f = (C = h.value[K]) == null ? void 0 : C.measure) == null ? void 0 : f.unit, (m = (w = h.value[K]) == null ? void 0 : w.measure) == null ? void 0 : m.precision) : V.quantity;
          V.useQuantity = z, R[V.materialInventoryId] ? R[V.materialInventoryId] += z : R[V.materialInventoryId] = z;
        }
      }
      ce.value = R;
    }
  });
  const Le = B(() => {
    switch (n.value) {
      case r.steelPlateList.K:
        return ee;
      case r.sectionSteelList.K:
        return Te;
      case r.steelCoilList.K:
        return we;
      default:
        return ee;
    }
  });
  $(() => T.detail, (a = {}) => {
    l.type = a.type, l.materialType = a.materialType, l.projectId = a.projectId;
  }, { deep: true, immediate: true });
  const { maxHeight: Ie } = be({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => e.value.loaded), { maxHeight: Se, maxHeightStyle: Ce } = be({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 0 }), Ne = B(() => {
    var a;
    return ((a = r == null ? void 0 : r[n.value]) == null ? void 0 : a.TABLE) || r.steelPlateList.TABLE;
  }), xe = B(() => {
    let a = 0;
    return W(l.steelPlateList) && l.steelPlateList.forEach((i) => {
      a += i.weighingTotalWeight ? i.weighingTotalWeight : 0;
    }), W(l.sectionSteelList) && l.sectionSteelList.forEach((i) => {
      a += i.weighingTotalWeight ? i.weighingTotalWeight : 0;
    }), W(l.steelCoilList) && l.steelCoilList.forEach((i) => {
      a += i.weighingTotalWeight ? i.weighingTotalWeight : 0;
    }), et(a, 2);
  });
  $(n, (a) => {
    x.value = l[a], a && A(() => {
      P[a] || (P[a] = y.value);
    });
  }, { immediate: true }), $(x, (a) => {
    l[n.value] = a;
  }, { deep: true });
  function Pe(a, i) {
    c.value = a, o.value = i, s.value = true;
  }
  function Ve(a, i) {
    var C, f, w;
    const v = i.id;
    l.originInventoryInfo || (l.originInventoryInfo = {}), l.originInventoryInfo[v] = { quantity: i.quantity, frozenQuantity: i.frozenQuantity, basicClass: i.basicClass };
    const b = (C = r == null ? void 0 : r[n.value]) == null ? void 0 : C.V;
    b & _.STEEL_PLATE.V && (i.basicClass & _.STEEL_COIL.V ? (l[n.value][o.value].length = _e(a, (w = (f = h.value[i.basicClass]) == null ? void 0 : f.measure) == null ? void 0 : w.unit, h.value[b].length.unit, h.value[b].length.precision), l[n.value][o.value].quantity = 1, l[n.value][o.value].canUseQuantity = 1) : (l[n.value][o.value].length = i.length, l[n.value][o.value].quantity = a, l[n.value][o.value].canUseQuantity = i.quantity), l[n.value][o.value].width = i.width), b & _.SECTION_STEEL.V && (l[n.value][o.value].quantity = a, l[n.value][o.value].length = i.length, l[n.value][o.value].canUseQuantity = i.quantity), b & _.STEEL_COIL.V && (l[n.value][o.value].quantity = a, l[n.value][o.value].canUseQuantity = i.quantity), l[n.value][o.value].color = i.color, l[n.value][o.value].brand = i.brand, l[n.value][o.value].requisitionMode = ye.USE_INVENTORY.V, l[n.value][o.value].materialInventoryId = v;
  }
  Q(), re.HOOK.beforeToEdit = async (a, i) => {
    await tt(i), oe(i);
  }, re.HOOK.afterSubmit = () => {
    F("success"), Q();
  };
  function We() {
    if (l.type !== ot.PUBLIC.V && D(l.projectId)) return O.warning("请选择项目"), false;
    if (D(l.steelPlateList) && D(l.sectionSteelList) && D(l.steelCoilList)) return O.warning("请填写数据"), false;
    const a = Me();
    return a && (l.list = [...l.steelPlateList, ...l.sectionSteelList, ...l.steelCoilList], l.list.forEach((i) => {
      i.mete = i.weighingTotalWeight, i.weight = i.weighingTotalWeight;
    }), W(fe.value)) ? (O.error("请先删除标红数据并重新添加"), false) : a;
  }
  function Me() {
    return Object.keys(P).every((a) => P[a] ? P[a].validate() : true);
  }
  function Fe(a) {
    return console.log(a), y.value.rowInit(a);
  }
  function Q() {
    A(() => {
      P.steelPlateList = null, P.sectionSteelList = null, P.steelCoilList = null, n.value = r.steelPlateList.K, g.value && g.value.clear();
    });
  }
  function Ue() {
    var a, i;
    if (W(fe.value) && W((a = S == null ? void 0 : S.submitResult) == null ? void 0 : a.data)) {
      O.error("请删除全部标红数据");
      return;
    }
    t.value = true, ((i = S == null ? void 0 : S.submitResult) == null ? void 0 : i.code) === 40206 && g.value && (E.dispatch("config/fetchMatClsTree"), S.submitResult.code = null, E.state.config.classifySpec = { specKV: [] });
  }
  function qe(a) {
    try {
      S.props.import(a);
    } catch (i) {
      O.error({ message: i.message, duration: 5e3 });
    }
  }
  return S.props.import = (a) => {
    const i = n.value, v = l[i].length;
    l[i].push.apply(l[i], a);
    const b = l[i].length;
    for (let f = v; f < b; f++) P[i].rowWatch(l[i][f]);
    const C = $(g, () => {
      g.value && (g.value.initSelected(a.map((f) => ({ sn: f.sn, classifyId: f.classifyId }))), A(() => {
        C();
      }));
    }, { immediate: true });
  }, (a, i) => {
    var w;
    const v = He, b = de("common-button"), C = Qe, f = de("common-drawer");
    return Y(), ge("div", yt, [U(rt, { "basic-class": L(nt), "current-basic-class": (w = r == null ? void 0 : r[n.value]) == null ? void 0 : w.V, "show-total-amount": true, "total-value": xe.value, validate: We, "total-name": "总量合计", unit: "kg" }, { default: q(() => [G("div", _t, [G("div", bt, [U(L(Ae), { modelValue: n.value, "onUpdate:modelValue": i[0] || (i[0] = (m) => n.value = m), class: "filter-item", size: "default" }, { default: q(() => [(Y(), ge(Oe, null, ke(r, (m) => U(v, { key: m.K, disabled: m.V === L(_).STEEL_COIL.V, label: m.K }, { default: q(() => [J(X(m.L) + X(L(l)[m.K] && L(l)[m.K].length ? `(${L(l)[m.K].length})` : ""), 1)]), _: 2 }, 1032, ["disabled", "label"])), 64))]), _: 1 }, 8, ["modelValue"])]), G("div", vt, [U(b, { class: "filter-item", type: "success", onClick: Ue }, { default: q(() => i[4] || (i[4] = [J(" 添加物料 ")])), _: 1, __: [4] }), U(it, { template: Le.value, "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload", "open-loading": "", onSuccess: qe }, null, 8, ["template"]), n.value ? (Y(), he(st, { key: 0, fn: L(at), params: { basicClass: r[n.value].V, receiptType: L(lt).REQUISITIONS.V }, class: "filter-item", size: "default", type: "info" }, { default: q(() => [J(X(r[n.value].L) + "清单模板下载 ", 1)]), _: 1 }, 8, ["fn", "params"])) : Be("", true)])]), U(C, { ref_key: "formRef", ref: I, model: L(l) }, { default: q(() => [(Y(), he(Ye(Ne.value), { ref_key: "steelRef", ref: y, "max-height": L(Se), style: De(L(Ce)), onSearchInventory: Pe }, null, 40, ["max-height", "style"]))]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["basic-class", "current-basic-class", "total-value"]), U(f, { ref_key: "drawerRef", ref: e, modelValue: t.value, "onUpdate:modelValue": i[2] || (i[2] = (m) => t.value = m), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: q(() => {
      var m;
      return [U(ct, { ref_key: "matSpecRef", ref: g, modelValue: x.value, "onUpdate:modelValue": i[1] || (i[1] = (R) => x.value = R), "basic-class": (m = r == null ? void 0 : r[n.value]) == null ? void 0 : m.V, "max-height": L(Ie), "row-init-fn": Fe, "table-width": 350, visible: t.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])];
    }), _: 1 }, 8, ["modelValue"]), U(L(dt), { visible: s.value, "onUpdate:visible": i[3] || (i[3] = (m) => s.value = m), params: c.value, onUseInventory: Ve }, null, 8, ["visible", "params"])]);
  };
} }, Wt = Je(Et, [["__scopeId", "data-v-a06f9876"]]);
export {
  Wt as default
};
