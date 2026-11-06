import { G as printSettingAllowed } from "../../../../shared/runtime.js";
import { ref as T } from "vue";
import { inject as U } from "vue";
import { watch as q } from "vue";
import { reactive as fe } from "vue";
import { computed as Be } from "vue";
import { resolveComponent as $ } from "vue";
import { resolveDirective as je } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as I } from "vue";
import { vShow as V } from "vue";
import { unref as e } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as r } from "vue";
import { createBlock as A } from "vue";
import { mergeProps as Xe } from "vue";
import { createCommentVNode as E } from "vue";
import { withCtx as m } from "vue";
import { normalizeStyle as ae } from "vue";
import { createTextVNode as S } from "vue";
import { Fragment as ye } from "vue";
import { renderList as qe } from "vue";
import { toDisplayString as L } from "vue";
import { nextTick as $e } from "vue";
import { ElMessage as M } from "element-plus";
import { ElFormItem as We } from "element-plus";
import { View as Ke } from "@element-plus/icons-vue";
import { ElIcon as Ge } from "element-plus";
import { ElPopover as Ze } from "element-plus";
import { ElCheckbox as Je } from "element-plus";
import { ElInput as et } from "element-plus";
import { ElInputNumber as tt } from "element-plus";
import { ElForm as nt } from "element-plus";
import { Loading as at } from "@element-plus/icons-vue";
import { ElTag as ot } from "element-plus";
import { g as lt, s as it, Q as ut, a as rt } from "../../../../modules/label-6ff6c88d.js";
import { F as st } from "../../../../modules/base-6bc46ddf.js";
import { t as dt } from "../../../../modules/print-record-2e0b6340.js";
import { _ as mt, m4 as g, a3 as l, m as pt, B as ct, bo as oe, bh as N, bm as b, V as O, my as ft, ng as Ie, bZ as yt, nM as It, nL as ge, nN as gt, C as Tt, E as Vt } from "../../../../shared/runtime.js";
import { u as At } from "../../../../modules/use-label-print-e19db37a.js";
import { _ as Et } from "../../../../modules/index-b238c21c.js";
import { b as bt } from "../../../../modules/index-90569c81.js";
import ht from "./has-task-productLine-select.vue.js";
import { a as _t } from "../../../../modules/index-8356a01a.js";
import Lt from "./product-traceability-setting-drawer.vue.js";
import { u as Rt } from "../../../../modules/use-product-lines-79a95221.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
const vt = { key: 4 }, Ct = { style: { display: "flex", "align-items": "center" } }, wt = { style: { height: "365px", "margin-top": "-40px" } }, Nt = ["innerHTML"], Ut = { style: { "margin-left": "5px" } }, St = { style: { display: "flex", "justify-content": "space-evenly", width: "60%" } }, Pt = ["onClick"], Mt = { key: 0 }, Ot = { style: { display: "flex", "align-items": "center" } }, kt = { style: { display: "flex", "align-items": "center" } }, xt = { key: 0, style: { "text-align": "right" } }, Dt = { key: 0 }, Ht = { __name: "label-print-header", setup(Qt, { expose: Te }) {
  const le = { HOMEMADE: g.HOMEMADE, OUTSOURCE: g.OUTSOURCE, DIRECT: { L: "直发件", K: "DIRECT", V: l.MACHINE_PART.V | l.ASSEMBLE.V } }, k = { ONLY_PRINT_THE_UNPRINTED: { L: "仅打印未打印", K: "ONLY_PRINT_THE_UNPRINTED", V: 1 }, PRINT_ALL: { L: "打印全部", K: "PRINT_ALL", V: 2 } }, x = T([]), ie = T(false), D = T(false), W = T(false), Ve = T(false), H = T(k.ONLY_PRINT_THE_UNPRINTED.V), P = T(false), { productLines: Ae } = Rt(), K = [{ value: "zh", label: "中文" }, { value: "en", label: "ENGLISH" }, { value: "ru", label: "Русский" }], { globalProjectId: R, user: ue, requestUrl: Ee } = pt(["globalProjectId", "user", "requestUrl"]), be = { manufactureType: { value: g.HOMEMADE.V, resetAble: false }, serialNumber: void 0, monomerId: void 0, areaId: void 0, productionLineId: void 0, warehousingStatusEnum: void 0, TaskPrintEnum: void 0, shippingStatus: void 0, projectId: { value: void 0, resetAble: false } }, { crud: c, query: i, CRUD: he } = ct(be), Q = U("permission"), u = U("productType"), G = U("printType"), re = U("taskPrintAdd"), se = U("taskSubscribePrintAdd");
  q(() => R.value, async (n) => {
    c.query.projectId = R.value, c.query.productionLineId = void 0, c.query.monomerId = void 0, c.query.areaId = void 0, c.toQuery();
  }, { deep: true, immediate: true }), he.HOOK.handleRefresh = (n, t) => {
    t.data.content = t.data.content.map((s) => {
      var d;
      return s.whId = s.warehouseId || s.whId, s.printedQuantity = s.printQuantity, s.printQuantity = 1, (d = s.numberStatusDTOS) != null && d.length && (s.numberList = s.numberStatusDTOS.map((h) => h.number), s.printQuantity = s.numberStatusDTOS.length), s;
    });
  };
  const de = T(), me = T({}), z = T(false), Z = T(false), F = T(false);
  let a = fe({ weight: oe.NET.V, type: N.COMMON.V, labelSize: b.ONE.V, showArea: true, showMonomer: true, dateInProduced: true, showProductName: true, showLength: true, manufacturerName: "", copiesQuantity: 1, language: "zh" });
  const f = T(O(a)), _e = fe({});
  function Le() {
    for (const n in N.V) _e[n] = false;
  }
  Le();
  function Y(n) {
    return n ? "显示" : "不显示";
  }
  q(() => R.value, () => {
    Ce(), we();
  }, { immediate: true }), q([() => i.projectId, () => i.monomerId, () => i.areaId, () => i.areaBatchId], () => {
    pe(), c.toQuery();
  }, { immediate: true }), q(() => i.productionLineId, (n) => {
    c.toQuery();
  }, { immediate: true });
  function Re() {
    $e(() => {
      var t;
      const n = ((t = de.value) == null ? void 0 : t.planAreaBatch) || [];
      console.log("_list", n), me.value = n != null && n.length ? { id: `${n[0].id}`, name: n[0].name } : {};
    });
  }
  function ve(n) {
    c.toQuery(), i.manufactureType !== g.OUTSOURCE.V && pe();
  }
  async function pe() {
    i.productionLineId = void 0, x.value = [];
    try {
      ie.value = true;
      const { ids: n } = await ft({ projectId: R.value, monomerId: i.monomerId, areaId: i.areaId, productType: i.manufactureType === le.DIRECT.V ? l.ASSEMBLE.V | l.MACHINE_PART.V : u });
      n && n.length > 0 && (x.value = n);
    } catch (n) {
      console.log("获取有任务的生产线", n);
    } finally {
      ie.value = false;
    }
  }
  Be(() => {
    const n = Ae.value.reduce((d, h) => (h.workshopList.forEach((v) => {
      d.push(...v.productionLineList);
    }), d), []), t = x.value.length > 0 ? n.filter((d) => x.value.includes(d.id)) : [];
    return c.query.workshopId ? t.filter((d) => d.workshopId === c.query.workshopId) : t;
  });
  async function Ce() {
    if (!(!G || !R.value)) try {
      F.value = true;
      const n = await lt(R.value, G);
      if (n) {
        const { type: t, labelSize: s, language: d, weight: h, showArea: v, showMonomer: _, showBatch: B, dateInProduced: C, showProductName: J, showLength: ee, manufacturerName: j, copiesQuantity: te } = n;
        a.weight = h, a.type = t, a.labelSize = s || b.ONE.V, a.language = d, a.showArea = v, a.showMonomer = _, a.showBatch = B, a.dateInProduced = C, a.showProductName = J, a.showLength = ee, a.manufacturerName = j, a.copiesQuantity = te || 1, f.value = O(a);
      }
    } catch (n) {
      console.log("项目打印配置", n);
    } finally {
      F.value = false;
    }
  }
  async function we() {
    try {
      const n = await st();
      P.value = (n == null ? void 0 : n.boolPrintWarehousing) || false;
    } catch (n) {
      console.log("获取标签打印配置", n);
    }
  }
  function Ne() {
    z.value = false, a = Object.assign(a, O(f.value));
  }
  async function Ue() {
    if (!printSettingAllowed(Q.printSetting)) return;
    try {
      Z.value = true;
      const n = { ...a, projectId: R.value };
      await rt({ ...n, printType: G, showArea: a.showArea, showMonomer: a.showMonomer, showBatch: a.showBatch, dateInProduced: a.dateInProduced, showProductName: a.showProductName, showLength: a.showLength }), z.value = false, f.value = O(a), M({ message: "保存成功", type: "success" });
    } catch (n) {
      console.log("设置项目打印配置", n);
    } finally {
      Z.value = false;
    }
  }
  function Se(n) {
    n || (a.copiesQuantity = 1), u & l.AUXILIARY_MATERIAL.V && (f.value.copiesQuantity = a.copiesQuantity);
  }
  const { getLabelInfo: Pe, printLabelFunc: Me } = U("headerObj"), { batchPrint: ce, print: Oe } = At({ getPrintTotalNumber: (n) => (n.printQuantity || 0) * f.value.copiesQuantity, getLabelInfo: Pe, printFinallyHook: c.toQuery, getLoadingTextFunc: (n) => `${u & l.AUXILIARY_MATERIAL.V ? n.name : `${n.name}-${n.serialNumber}`}`, printLabelFunc: Me, needAddPrintRecord: true, addPrintIdField: "taskId", addPrintRecordReq: dt });
  function ke() {
    if (u === l.ARTIFACT.V && i.manufactureType === g.HOMEMADE.V) D.value = true;
    else {
      let n = c.selections;
      if (P.value && (n = c.selections.filter((t) => t.warehouseQuantity > 0)), !n.length) {
        P.value ? M.error("打印失败，所选产品未入库！") : M.warning("已选中数据都已打印，打印方式请选择打印全部！");
        return;
      }
      ce(n, u === l.AUXILIARY_MATERIAL.V ? "id" : i.manufactureType === g.OUTSOURCE.V ? "whId" : "taskId", i.manufactureType === g.OUTSOURCE.V ? se : re);
    }
  }
  function xe() {
    H.value = k.ONLY_PRINT_THE_UNPRINTED.V;
  }
  function De() {
    const n = H.value === k.ONLY_PRINT_THE_UNPRINTED.V, t = P.value;
    let s = O(c.selections);
    if (t && (s = s.filter((d) => d.warehouseQuantity > 0)), s = s.filter((d) => d.boolOneCode ? He(d, n, t) : n ? d.taskPrintEnum !== ge.PRINTED.V : true), !s.length) {
      t && !n ? M.error("打印失败，所选产品未入库！") : M.warning("已选中数据都已打印，打印方式请选择打印全部！");
      return;
    }
    ce(s, u === l.AUXILIARY_MATERIAL.V ? "id" : i.manufactureType === g.OUTSOURCE.V ? "whId" : "taskId", i.manufactureType === g.OUTSOURCE.V ? se : re), D.value = false;
  }
  function He(n, t, s) {
    return n.numberStatusDTOS = n.numberStatusDTOS.filter((d) => {
      const h = !t || !d.boolPrint, v = !s || d.status;
      return h && v;
    }), n.numberList = n.numberStatusDTOS.map((d) => d.number), n.numberStatusDTOS.length > 0;
  }
  return Te({ companyName: ue.value && ue.value.companyName, printConfig: f, spliceQrCodeUrl: it, QR_SCAN_PATH: ut, requestUrl: Ee, print: Oe, boolPrintWarehousing: P }), (n, t) => {
    const s = $("common-radio-button"), d = We, h = Ke, v = Ge, _ = $("common-button"), B = Ze, C = Je, J = et, ee = tt, j = nt, te = at, Qe = ot, ze = $("common-radio"), Fe = $("common-dialog"), ne = je("permission");
    return y(), w("div", null, [I(p("div", null, [r(s, { modelValue: e(i).manufactureType, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(i).manufactureType = o), options: e(u) & e(l).ARTIFACT.V ? le : e(g).ENUM, class: "filter-item", type: "enum", onChange: ve }, null, 8, ["modelValue", "options"]), e(u) !== e(l).AUXILIARY_MATERIAL.V ? (y(), A(ht, Xe({ key: 0, productType: e(u), "project-id": e(R) }, n.$attrs), null, 16, ["productType", "project-id"])) : E("", true), e(u) !== e(l).AUXILIARY_MATERIAL.V || e(u) === e(l).AUXILIARY_MATERIAL.V && e(i).manufactureType === e(g).HOMEMADE.V ? (y(), A(e(yt), { key: 1, ref_key: "monomerAreaRef", ref: de, monomerId: e(i).monomerId, "onUpdate:monomerId": t[2] || (t[2] = (o) => e(i).monomerId = o), areaId: e(i).areaId, "onUpdate:areaId": t[3] || (t[3] = (o) => e(i).areaId = o), productType: e(u), itemizedType: e(u) === e(l).ENCLOSURE.V ? e(Ie).ENCLOSURE.V : e(Ie).STRUCTURE.V, clearable: "", areaClearable: "", "project-id": e(i).projectId, style: ae(e(u) !== e(l).AUXILIARY_MATERIAL.V ? e(i).manufactureType !== e(g).OUTSOURCE.V ? "width: calc(100% - 390px)" : "width: calc(100% - 180px)" : ""), onAreaChange: Re }, { right: m(({ planAreaBatch: o, areaList: X }) => [o != null && o.length ? (y(), A(e(_t), { key: 0, modelValue: e(i).areaBatchId, "onUpdate:modelValue": t[1] || (t[1] = (Ye) => e(i).areaBatchId = Ye), "area-info": o, defaultTab: me.value, style: ae((X == null ? void 0 : X.length) > 0 ? "width:calc(100% - 430px)" : "width:calc(100% - 580px)"), class: "filter-item" }, null, 8, ["modelValue", "area-info", "defaultTab", "style"])) : E("", true)]), _: 1 }, 8, ["monomerId", "areaId", "productType", "itemizedType", "project-id", "style"])) : E("", true), e(u) !== e(l).AUXILIARY_MATERIAL.V && e(i).manufactureType !== e(g).OUTSOURCE.V ? (y(), A(s, { key: 2, modelValue: e(i).warehousingStatusEnum, "onUpdate:modelValue": t[4] || (t[4] = (o) => e(i).warehousingStatusEnum = o), options: e(It).ENUM, "show-option-all": "", class: "filter-item", type: "enum", onChange: e(c).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : E("", true), e(u) === e(l).ARTIFACT.V && e(i).manufactureType === e(g).HOMEMADE.V ? (y(), A(s, { key: 3, modelValue: e(i).taskPrintEnum, "onUpdate:modelValue": t[5] || (t[5] = (o) => e(i).taskPrintEnum = o), options: e(ge).ENUM, "show-option-all": "", class: "filter-item", type: "enum", onChange: e(c).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : E("", true), e(u) !== e(l).AUXILIARY_MATERIAL.V ? (y(), w("br", vt)) : E("", true), e(u) === e(l).ARTIFACT.V && e(i).manufactureType === e(g).HOMEMADE.V ? (y(), A(s, { key: 5, modelValue: e(i).shippingStatus, "onUpdate:modelValue": t[6] || (t[6] = (o) => e(i).shippingStatus = o), options: e(gt).ENUM, "show-option-all": "", class: "filter-item", type: "enum", onChange: e(c).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : E("", true), r(e(Et), { productType: e(u), query: e(i), toQuery: e(c).toQuery }, null, 8, ["productType", "query", "toQuery"]), r(e(Tt))], 512), [[V, e(c).searchToggle]]), r(e(Vt), null, { optRight: m(() => [r(B, { visible: z.value, "onUpdate:visible": t[16] || (t[16] = (o) => z.value = o), placement: "bottom-start", trigger: "click", width: "500" }, { reference: m(() => [I((y(), A(_, { disabled: F.value, size: "default", type: "primary" }, { default: m(() => t[26] || (t[26] = [S(" 打印设置 ")])), _: 1, __: [26] }, 8, ["disabled"])), [[ne, e(Q).printSetting]])]), default: m(() => [r(j, { ref: "form", model: e(a), "label-width": "90px", size: "default" }, { default: m(() => [I(r(d, { label: "重量" }, { default: m(() => [r(s, { modelValue: e(a).weight, "onUpdate:modelValue": t[7] || (t[7] = (o) => e(a).weight = o), options: e(oe).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }, 512), [[V, e(u) & (e(l).ARTIFACT.V | e(l).MACHINE_PART.V) && e(a).labelSize === e(b).ONE.V]]), I(r(d, { label: "标签类型" }, { default: m(() => [p("div", Ct, [r(s, { modelValue: e(a).type, "onUpdate:modelValue": t[8] || (t[8] = (o) => e(a).type = o), options: e(N).ENUM, unshowVal: e(u) & e(l).ENCLOSURE.V ? [e(N).SIMPLE.V, e(N).CUSTOM.V] : [], type: "enum" }, null, 8, ["modelValue", "options", "unshowVal"]), r(B, { title: e(N).VL[e(a).type], width: 400, placement: "right", teleported: "", trigger: "hover" }, { reference: m(() => [p("div", Ut, [r(_, { size: "default", type: "info" }, { default: m(() => [r(v, null, { default: m(() => [r(h)]), _: 1 })]), _: 1 })])]), default: m(() => [p("div", wt, [p("span", { innerHTML: e(bt)({ productType: e(u), labelType: e(a).type, labelData: { printConfig: e(a) } }) }, null, 8, Nt)])]), _: 1 }, 8, ["title"])])]), _: 1 }, 512), [[V, e(u) !== e(l).AUXILIARY_MATERIAL.V]]), r(d, { label: "语言" }, { default: m(() => [p("div", St, [(y(), w(ye, null, qe(K, (o) => (y(), w(ye, { key: o.value }, [p("span", { style: ae({ color: e(a).language === o.value ? "#409EFF" : "#888", cursor: "pointer", fontWeight: 700 }), onClick: (X) => e(a).language = o.value }, L(o.label), 13, Pt), o.value !== K[K.length - 1].value ? (y(), w("span", Mt, "/")) : E("", true)], 64))), 64))])]), _: 1 }), I(r(d, { label: "显示" }, { default: m(() => [p("span", Ot, [t[21] || (t[21] = p("span", { style: { "margin-right": "3px" } }, "单体", -1)), r(C, { modelValue: e(a).showMonomer, "onUpdate:modelValue": t[9] || (t[9] = (o) => e(a).showMonomer = o) }, null, 8, ["modelValue"]), t[22] || (t[22] = p("span", { style: { "margin-right": "3px" } }, "区域", -1)), r(C, { modelValue: e(a).showArea, "onUpdate:modelValue": t[10] || (t[10] = (o) => e(a).showArea = o) }, null, 8, ["modelValue"]), t[23] || (t[23] = p("span", { style: { "margin-right": "3px" } }, "批次", -1)), r(C, { modelValue: e(a).showBatch, "onUpdate:modelValue": t[11] || (t[11] = (o) => e(a).showBatch = o) }, null, 8, ["modelValue"]), t[24] || (t[24] = p("span", { style: { "margin-right": "3px" } }, "生产日期", -1)), r(C, { modelValue: e(a).dateInProduced, "onUpdate:modelValue": t[12] || (t[12] = (o) => e(a).dateInProduced = o) }, null, 8, ["modelValue"])])]), _: 1 }, 512), [[V, e(u) & (e(l).ARTIFACT.V | e(l).MACHINE_PART.V) && e(a).labelSize === e(b).ONE.V]]), I(r(d, { label: "显示" }, { default: m(() => [p("span", kt, [t[25] || (t[25] = p("span", { style: { "margin-right": "3px" } }, "生产日期", -1)), r(C, { modelValue: e(a).dateInProduced, "onUpdate:modelValue": t[13] || (t[13] = (o) => e(a).dateInProduced = o) }, null, 8, ["modelValue"])])]), _: 1 }, 512), [[V, e(u) & e(l).ENCLOSURE.V]]), I(r(d, { label: "制造商名称" }, { default: m(() => [r(J, { modelValue: e(a).manufacturerName, "onUpdate:modelValue": t[14] || (t[14] = (o) => e(a).manufacturerName = o), modelModifiers: { trim: true }, clearable: "", maxlength: "30", style: { width: "250px" } }, null, 8, ["modelValue"])]), _: 1 }, 512), [[V, e(a).labelSize === e(b).ONE.V && e(u) !== e(l).AUXILIARY_MATERIAL.V]]), r(d, { label: "份数" }, { default: m(() => [r(ee, { modelValue: e(a).copiesQuantity, "onUpdate:modelValue": t[15] || (t[15] = (o) => e(a).copiesQuantity = o), max: 999, min: 1, step: 1, style: { width: "250px" }, onChange: Se }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"]), e(u) !== e(l).AUXILIARY_MATERIAL.V ? (y(), w("div", xt, [r(_, { size: "default", type: "success", onClick: Ne }, { default: m(() => t[27] || (t[27] = [S("取 消")])), _: 1, __: [27] }), r(_, { loading: Z.value, size: "default", type: "primary", onClick: Ue }, { default: m(() => t[28] || (t[28] = [S("保 存 ")])), _: 1, __: [28] }, 8, ["loading"])])) : E("", true)]), _: 1 }, 8, ["visible"]), r(Qe, { effect: "plain", hit: "", size: "large", style: { "margin-left": "5px", "margin-right": "5px" } }, { default: m(() => [F.value ? (y(), A(v, { key: 1 }, { default: m(() => [r(te)]), _: 1 })) : (y(), w("span", Dt, [I(p("span", null, "标签类型：" + L(e(N).VL[f.value.type]) + "，", 513), [[V, e(u) !== e(l).AUXILIARY_MATERIAL.V]]), I(p("span", null, "重量：" + L(e(oe).VL[f.value.weight]) + "，", 513), [[V, e(u) & (e(l).ARTIFACT.V | e(l).MACHINE_PART.V) && f.value.labelSize === e(b).ONE.V]]), I(p("span", null, "区域：" + L(Y(f.value.showArea)) + "，", 513), [[V, e(u) & (e(l).ARTIFACT.V | e(l).MACHINE_PART.V) && f.value.labelSize === e(b).ONE.V]]), I(p("span", null, " 批次：" + L(Y(f.value.showBatch)) + "， ", 513), [[V, e(u) & (e(l).ARTIFACT.V | e(l).MACHINE_PART.V)]]), I(p("span", null, "单体：" + L(Y(f.value.showMonomer)) + "，", 513), [[V, e(u) & (e(l).ARTIFACT.V | e(l).MACHINE_PART.V) && f.value.labelSize === e(b).ONE.V]]), I(p("span", null, "生产日期：" + L(Y(f.value.dateInProduced)) + "，", 513), [[V, e(u) & (e(l).ARTIFACT.V | e(l).MACHINE_PART.V | e(l).ENCLOSURE.V) && f.value.labelSize === e(b).ONE.V]]), I(p("span", null, "制造商名称：" + L(f.value.manufacturerName || "-") + "，", 513), [[V, e(u) !== e(l).AUXILIARY_MATERIAL.V && f.value.labelSize === e(b).ONE.V]]), p("span", null, "份数：" + L(f.value.copiesQuantity), 1)]))]), _: 1 }), e(u) === e(l).ARTIFACT.V ? I((y(), A(_, { key: 0, size: "default", type: "primary", onClick: t[17] || (t[17] = (o) => W.value = true) }, { default: m(() => t[29] || (t[29] = [S(" 溯源查询系统设置 ")])), _: 1, __: [29] })), [[ne, e(Q).traceabilitySetting.get]]) : E("", true)]), viewLeft: m(() => [I((y(), A(_, { disabled: e(c).selections.length === 0, size: "default", type: "success", onClick: ke }, { default: m(() => t[30] || (t[30] = [S("批量打印标签 ")])), _: 1, __: [30] }, 8, ["disabled"])), [[ne, e(Q).batchPrint]])]), _: 1 }), r(Fe, { title: "选择打印方式", modelValue: D.value, "onUpdate:modelValue": t[19] || (t[19] = (o) => D.value = o), "close-on-click-modal": false, onOpen: xe, width: "550px" }, { titleRight: m(() => [r(_, { type: "primary", size: "default", loading: Ve.value, onClick: De }, { default: m(() => t[31] || (t[31] = [S(" 确认 ")])), _: 1, __: [31] }, 8, ["loading"])]), default: m(() => [r(j, { size: "default", "label-width": "150px" }, { default: m(() => [r(d, { label: "打印方式：" }, { default: m(() => [r(ze, { class: "filter-item", modelValue: H.value, "onUpdate:modelValue": t[18] || (t[18] = (o) => H.value = o), options: k, type: "enum", size: "default" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["modelValue"]), e(u) === e(l).ARTIFACT.V ? (y(), A(Lt, { key: 0, visible: W.value, "onUpdate:visible": t[20] || (t[20] = (o) => W.value = o), "edit-permission": e(Q).traceabilitySetting.edit }, null, 8, ["visible", "edit-permission"])) : E("", true)]);
  };
} }, an = mt(Ht, [["__scopeId", "data-v-01821c1b"]]);
export {
  an as default
};
