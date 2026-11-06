import { G as printSettingAllowed } from "../../../../shared/runtime.js";
import { ref as h } from "vue";
import { ElLoading as Se } from "element-plus";
import { ElNotification as Me } from "element-plus";
import { useStore as Oe } from "vuex";
import { computed as le } from "vue";
import { watch as q } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as U } from "vue";
import { Fragment as ne } from "vue";
import { renderList as Qe } from "vue";
import { createBlock as H } from "vue";
import { withCtx as u } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as j } from "vue";
import { toDisplayString as P } from "vue";
import { createCommentVNode as Y } from "vue";
import { unref as e } from "vue";
import { ElTag as ce } from "element-plus";
import { ElTooltip as He } from "element-plus";
import { Loading as pe } from "@element-plus/icons-vue";
import { ElIcon as me } from "element-plus";
import { inject as J } from "vue";
import { reactive as ue } from "vue";
import { resolveComponent as de } from "vue";
import { resolveDirective as $e } from "vue";
import { withDirectives as A } from "vue";
import { vShow as k } from "vue";
import { createElementVNode as d } from "vue";
import { normalizeStyle as Be } from "vue";
import { ElMessage as je } from "element-plus";
import { ElFormItem as Fe } from "element-plus";
import { View as ze } from "@element-plus/icons-vue";
import { ElPopover as De } from "element-plus";
import { ElCheckbox as qe } from "element-plus";
import { ElInput as Ge } from "element-plus";
import { ElInputNumber as We } from "element-plus";
import { ElForm as Ke } from "element-plus";
import { g as Je, a as Xe, b as Ye } from "../../../../modules/enclosure-6f8adfb8.js";
import { g as Ze, s as et, Q as tt, a as nt } from "../../../../modules/label-6ff6c88d.js";
import { $ as oe, _ as fe, B as ot, m as at, mx as lt, T as D, bo as ae, bh as Q, V as X, a3 as c, my as it, C as st, E as rt } from "../../../../shared/runtime.js";
import { _ as ut } from "../../../../modules/index-b238c21c.js";
import { _ as dt } from "../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import { a as ct } from "../../../../modules/index-8356a01a.js";
import { b as pt } from "../../../../modules/index-90569c81.js";
import "../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
function mt({ getPrintTotalNumber: m, getLabelInfo: $, getLoadingTextFunc: V, printLabelFunc: N, needAddPrintRecord: x = false, addPrintIdField: T = "taskId", addPrintRecordReq: E, batchPrintSuccessHook: F, printFinallyHook: g }) {
  const o = h();
  async function C(s) {
    try {
      await v(s), typeof batchPrintHook == "function" && F();
    } catch (p) {
      console.log("批量打印错误", p);
    }
  }
  async function v(s) {
    console.log(s), o.value = Se.service({ lock: true, text: "正在准备加入打印队列", spinner: "el-icon-loading", fullscreen: true });
    try {
      for (const p of s) console.log(p), await B(p);
      o.value.text = "已全部加入打印队列", await oe(500);
    } catch (p) {
      throw Me({ title: "加入打印队列失败，请重试", type: "error", duration: 2500 }), new Error(p);
    } finally {
      o.value.close(), typeof g == "function" && g();
    }
  }
  async function B(s) {
    var R;
    console.log(m(s), "printTotalNumber");
    let p = m(s), l = 0;
    const S = (/* @__PURE__ */ new Date()).getTime();
    try {
      if (s.boolOneCode) for (p = ((R = s.numberList) == null ? void 0 : R.length) || 0; p--; ) {
        const y = s.numberList[l];
        o.value.text = `正在加入打印队列：${V(s)}，当前一物一码编号：${y}`, await oe(500);
        const M = await $(s, y);
        await N(M), l++;
      }
      else {
        const y = await $(s);
        for (; p--; ) o.value.text = `正在加入打印队列：${V(s)} 第${l + 1}张`, await oe(500), await N(y), l++;
      }
    } catch (y) {
      throw console.log("打印标签时发生错误", y), new Error(y);
    } finally {
      const y = (/* @__PURE__ */ new Date()).getTime();
      x && (console.log(s, s[T], T), z(s, { taskId: s[T], quantity: l, startTime: S, endTime: y, numberList: s.numberList }));
    }
  }
  async function z(s, { taskId: p, quantity: l, startTime: S, endTime: R, numberList: y }) {
    if (!(!p || !l)) try {
      console.log("添加打印记录"), await E({ taskId: p, quantity: l, startTime: S, endTime: R, numberList: y }), s.printedQuantity += l, s.boolPrinted = true;
    } catch (M) {
      console.log("添加打印记录失败", M);
    }
  }
  return { batchPrint: C, print: v };
}
const ft = () => {
  const m = Oe();
  return m.state.config.loaded.enclosureProductLines || m.dispatch("config/fetchEnclosureProductLines"), { enclosureProductLines: le(() => m.state.config.enclosureProductLines), loaded: le(() => m.state.config.loaded.enclosureProductLines) };
};
const yt = { class: "production-lines-content" }, gt = { key: 1, style: { "font-size": "11px", color: "red" } }, _t = { key: 1, style: { "font-size": "11px" } }, bt = { __name: "production-line-box-select", props: { modelValue: { type: [Number, void 0], default: void 0 }, unselectable: { type: Boolean, default: false }, selectedAbleLineIds: { type: Array, default: () => [] }, selectedAbleLineLoading: { type: Boolean, default: true }, tip: { type: String, default: "* 没有含有任务的生产线" } }, emits: ["update:modelValue", "loaded", "change"], setup(m, { expose: $, emit: V }) {
  const N = V, x = m, { loaded: T, enclosureProductLines: E } = ft();
  q(T, (C) => {
    N("loaded");
  }, { immediate: true, deep: true });
  function F(C) {
    x.value !== C.id ? o(C.id) : x.unselectable && o(void 0);
  }
  function g() {
    if (!T.value) throw new Error("生产线未加载完成");
    return E.value;
  }
  function o(C) {
    N("update:modelValue", C), N("change", C);
  }
  return $({ getLines: g }), (C, v) => {
    const B = ce, z = He, s = pe, p = me;
    return b(), U("div", yt, [m.selectedAbleLineLoading ? (b(), U("span", _t, [v[0] || (v[0] = j("生产线加载中 ")), i(p, null, { default: u(() => [i(s)]), _: 1 })])) : (b(), U(ne, { key: 0 }, [m.selectedAbleLineIds && m.selectedAbleLineIds.length > 0 ? (b(true), U(ne, { key: 0 }, Qe(e(E), (l) => (b(), U(ne, { key: l.id }, [m.selectedAbleLineIds.includes(l.id) ? (b(), H(z, { key: 0, class: "item", effect: "light", content: `${l.name}`, placement: "top", "show-after": 1e3 }, { default: u(() => [i(B, { hit: "", effect: l.id == m.modelValue ? "light" : "plain", type: l.id == m.modelValue ? "success" : "info", "disable-transitions": true, onClick: (S) => F(l) }, { default: u(() => [j(P(l.name), 1)]), _: 2 }, 1032, ["effect", "type", "onClick"])]), _: 2 }, 1032, ["content"])) : Y("", true)], 64))), 128)) : (b(), U("span", gt, P(m.tip), 1))], 64))]);
  };
} }, vt = fe(bt, [["__scopeId", "data-v-b19a4ed2"]]);
const Lt = { class: "hed-container" }, It = { style: { display: "flex", "align-items": "center" } }, ht = { style: { "margin-top": "-40px" } }, Vt = ["innerHTML"], Et = { style: { "margin-left": "5px" } }, Ct = { style: { display: "flex", "align-items": "center" } }, Tt = { style: { display: "flex", "align-items": "center" } }, wt = { style: { "text-align": "right" } }, At = { key: 0 }, Nt = { __name: "label-print-header", setup(m, { expose: $ }) {
  const V = h([]), N = h({}), x = h([]), T = h(false), E = h([]), F = { serialNumber: "", monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, productionLineId: { value: void 0, resetAble: false } }, { crud: g, query: o, CRUD: C } = ot(F), { globalProjectId: v, user: B, requestUrl: z } = at(["globalProjectId", "user", "requestUrl"]), { projects: s } = lt(), p = J("permission"), l = J("productType"), S = J("printType"), R = [{ name: "压型彩板", no: D.PROFILED_PLATE.V, alias: "ENCLOSURE" }, { name: "压型楼承板", no: D.PRESSURE_BEARING_PLATE.V, alias: "ENCLOSURE" }, { name: "桁架楼承板", no: D.TRUSS_FLOOR_PLATE.V, alias: "ENCLOSURE" }, { name: "夹芯板", no: D.SANDWICH_BOARD.V, alias: "ENCLOSURE" }, { name: "折边件", no: D.BENDING.V, alias: "ENCLOSURE" }];
  C.HOOK.handleRefresh = (n, t) => {
    t.data.content = t.data.content.map((f) => (f.printedQuantity = f.printQuantity, f.printQuantity = 1, f));
  };
  const y = h(false), M = h(false), G = h(false);
  let a = ue({ weight: ae.NET.V, type: Q.COMMON.V, showArea: true, showMonomer: true, dateInProduced: true, manufacturerName: "", copiesQuantity: 1 });
  const L = h(X(a)), ye = ue({});
  function ge() {
    for (const n in Q.V) ye[n] = false;
  }
  ge();
  function Z(n) {
    return n ? "显示" : "不显示";
  }
  q(() => v.value, (n) => {
    o.category = void 0, o.planId = void 0, o.productionLineId = void 0, x.value = [], _e(), se(), te(), g.toQuery();
  });
  async function _e() {
    try {
      G.value = true;
      const n = await Ze(v.value, S);
      if (n) {
        const { type: t, weight: f, showArea: _, showMonomer: I, dateInProduced: w, manufacturerName: O, copiesQuantity: W } = n;
        a.weight = f, a.type = t, a.showArea = _, a.showMonomer = I, a.dateInProduced = w, a.manufacturerName = O, a.copiesQuantity = W || 1, L.value = X(a);
      }
    } catch (n) {
      console.log("项目打印配置", n);
    } finally {
      G.value = false;
    }
  }
  function be() {
    y.value = false, a = Object.assign(a, X(L.value));
  }
  async function ve() {
    if (!printSettingAllowed(p.printSetting)) return;
    try {
      M.value = true;
      const n = { ...a, projectId: v.value };
      await nt({ ...n, printType: S, showArea: a.showArea, showMonomer: a.showMonomer, dateInProduced: a.dateInProduced }), y.value = false, L.value = X(a), je({ message: "保存成功", type: "success" });
    } catch (n) {
      console.log("设置项目打印配置", n);
    } finally {
      M.value = false;
    }
  }
  function Le(n) {
    n || (a.copiesQuantity = 1);
  }
  function Ie({ monomerId: n, areaId: t }) {
    o.monomerId = n, o.areaId = t;
  }
  const ee = h(), ie = h([]);
  async function te() {
    const n = [];
    if (o.productionLineId = void 0, E.value = [], !(!o.areaId && !o.planId)) try {
      if (T.value = true, l !== c.ENCLOSURE.V) {
        const { ids: t } = await it({ areaId: o.areaId, productType: l });
        t && t.length > 0 && (E.value = t, o.productionLineId = E.value[0]);
      } else {
        const t = await Je({ planId: o.planId, category: o.category });
        for (const f in t) n.push(Number(f));
        n && n.length > 0 && (E.value = n, o.productionLineId = E.value[0]);
      }
    } catch (t) {
      console.log("获取有任务的生产线", t);
    } finally {
      T.value = false;
    }
  }
  function he() {
    ee.value && (ie.value = ee.value.getLines());
  }
  function Ve() {
    let n = {};
    for (const t of ie.value) {
      const f = t.workshopList || [];
      for (const _ of f) {
        const I = _.productionLineList || [];
        for (const w of I) if (w.id === o.productionLineId) {
          n = { id: w.id, name: w.name, factoryId: _.factoryId, factoryName: _.factoryName };
          break;
        }
      }
    }
    return n;
  }
  q([() => o.monomerId, () => o.areaId], ([n, t]) => {
    te(), n && t && o.productionLineId && g.toQuery();
  }, { immediate: true }), q(() => o.planId, (n) => {
    te(), g.toQuery();
  }), q(() => o.productionLineId, (n) => {
    g.toQuery();
  }, { immediate: true });
  const Ee = le(() => {
    var f, _;
    const n = [], t = (_ = (f = s.value) == null ? void 0 : f.find((I) => I.id === v.value)) == null ? void 0 : _.categorys;
    return t == null || t.forEach((I) => {
      n.push(I);
    }), R == null || R.forEach((I) => {
      (n == null ? void 0 : n.findIndex((w) => w === I.no)) > -1 && x.value.push(I);
    }), x.value;
  });
  async function se() {
    if (o.category) try {
      const n = await Xe({ category: o.category, projectId: v.value });
      n == null || n.forEach((t) => {
        t.id = t.planId, t.name = t.planName;
      }), V.value = n || [], V.value.length > 0 && (N.value = { id: V.value[0].id + "", name: V.value[0].name });
    } catch (n) {
      console.log("获取围护的批次失败", n);
    }
  }
  function Ce(n) {
    const { name: t } = n;
    o.planId = t, g.toQuery();
  }
  const { getLabelInfo: Te, printLabelFunc: we } = J("headerObj"), { batchPrint: Ae, print: Ne } = mt({ getPrintTotalNumber: (n) => (n.printQuantity || 0) * L.value.copiesQuantity, getLabelInfo: Te, printFinallyHook: g.toQuery, getLoadingTextFunc: (n) => `${n.name}-${n.serialNumber}`, printLabelFunc: we, needAddPrintRecord: true, addPrintIdField: "taskId", addPrintRecordReq: Ye });
  return $({ getLine: Ve, companyName: B.value && B.value.companyName, printConfig: L, spliceQrCodeUrl: et, QR_SCAN_PATH: tt, requestUrl: z, print: Ne }), (n, t) => {
    const f = de("common-radio-button"), _ = Fe, I = ze, w = me, O = de("common-button"), W = De, K = qe, Pe = Ge, xe = We, Re = Ke, ke = pe, Ue = ce, re = $e("permission");
    return b(), U("div", Lt, [A(d("div", null, [e(l) !== e(c).ENCLOSURE.V ? (b(), H(e(dt), { key: 0, "project-id": e(v), onChange: Ie, productType: e(l), needConvert: "" }, null, 8, ["project-id", "productType"])) : Y("", true), e(l) === e(c).ENCLOSURE.V ? (b(), H(f, { key: 1, modelValue: e(o).category, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(o).category = r), options: Ee.value, type: "other", default: "", dataStructure: { key: "no", label: "name", value: "no" }, class: "filter-item", onChange: se }, null, 8, ["modelValue", "options"])) : Y("", true), e(o).category && e(l) === e(c).ENCLOSURE.V ? (b(), H(e(ct), { key: 2, class: "filter-item", style: Be(V.value.length > 1 ? "width:calc(100% - 300px)" : "width:calc(100% - 100px)"), modelValue: e(o).planId, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(o).planId = r), "area-info": V.value, "default-tab": N.value, "show-type": 2, onTabClick: Ce }, null, 8, ["style", "modelValue", "area-info", "default-tab"])) : Y("", true), d("div", null, [i(e(ut), { productType: e(l), toQuery: e(g).toQuery, query: e(o) }, null, 8, ["productType", "toQuery", "query"]), i(e(st))])], 512), [[k, e(g).searchToggle]]), i(e(vt), { ref_key: "plBoxSelectRef", ref: ee, modelValue: e(o).productionLineId, "onUpdate:modelValue": t[2] || (t[2] = (r) => e(o).productionLineId = r), "selected-able-line-ids": E.value, "selected-able-line-loading": T.value, tip: e(l) !== e(c).ENCLOSURE.V ? "* 区域下没有含有任务的生产线" : "* 批次下没有含有任务的生产线", class: "filter-item", onLoaded: he }, null, 8, ["modelValue", "selected-able-line-ids", "selected-able-line-loading", "tip"]), i(e(rt), null, { optRight: u(() => [i(W, { visible: y.value, "onUpdate:visible": t[11] || (t[11] = (r) => y.value = r), placement: "bottom-start", width: "400" }, { reference: u(() => [A((b(), H(O, { type: "primary", disabled: G.value, size: "default" }, { default: u(() => t[17] || (t[17] = [j("打印设置")])), _: 1, __: [17] }, 8, ["disabled"])), [[re, e(p).printSetting]])]), default: u(() => [i(Re, { ref: "form", model: e(a), "label-width": "90px", size: "default" }, { default: u(() => [A(i(_, { label: "重量" }, { default: u(() => [i(f, { modelValue: e(a).weight, "onUpdate:modelValue": t[3] || (t[3] = (r) => e(a).weight = r), options: e(ae).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }, 512), [[k, e(l) & (e(c).ARTIFACT.V | e(c).MACHINE_PART.V)]]), i(_, { label: "标签类型" }, { default: u(() => [d("div", It, [i(f, { modelValue: e(a).type, "onUpdate:modelValue": t[4] || (t[4] = (r) => e(a).type = r), unshowVal: e(l) & e(c).ENCLOSURE.V ? [e(Q).SIMPLE.V, e(Q).CUSTOM.V] : [], options: e(Q).ENUM, type: "enum" }, null, 8, ["modelValue", "unshowVal", "options"]), i(W, { placement: "right", title: e(Q).VL[e(a).type], width: 400, trigger: "hover" }, { reference: u(() => [d("div", Et, [i(O, { size: "default", type: "info" }, { default: u(() => [i(w, null, { default: u(() => [i(I)]), _: 1 })]), _: 1 })])]), default: u(() => [d("div", ht, [d("span", { innerHTML: e(pt)({ productType: e(l), labelType: e(a).type, labelData: { printConfig: e(a) } }) }, null, 8, Vt)])]), _: 1 }, 8, ["title"])])]), _: 1 }), A(i(_, { label: "显示" }, { default: u(() => [d("span", Ct, [t[13] || (t[13] = d("span", { style: { "margin-right": "3px" } }, "单体", -1)), i(K, { modelValue: e(a).showMonomer, "onUpdate:modelValue": t[5] || (t[5] = (r) => e(a).showMonomer = r) }, null, 8, ["modelValue"]), t[14] || (t[14] = d("span", { style: { "margin-right": "3px" } }, "区域", -1)), i(K, { modelValue: e(a).showArea, "onUpdate:modelValue": t[6] || (t[6] = (r) => e(a).showArea = r) }, null, 8, ["modelValue"]), t[15] || (t[15] = d("span", { style: { "margin-right": "3px" } }, "生产日期", -1)), i(K, { modelValue: e(a).dateInProduced, "onUpdate:modelValue": t[7] || (t[7] = (r) => e(a).dateInProduced = r) }, null, 8, ["modelValue"])])]), _: 1 }, 512), [[k, e(l) & (e(c).ARTIFACT.V | e(c).MACHINE_PART.V)]]), A(i(_, { label: "显示" }, { default: u(() => [d("span", Tt, [t[16] || (t[16] = d("span", { style: { "margin-right": "3px" } }, "生产日期", -1)), i(K, { modelValue: e(a).dateInProduced, "onUpdate:modelValue": t[8] || (t[8] = (r) => e(a).dateInProduced = r) }, null, 8, ["modelValue"])])]), _: 1 }, 512), [[k, e(l) & e(c).ENCLOSURE.V]]), i(_, { label: "制造商名称" }, { default: u(() => [i(Pe, { modelValue: e(a).manufacturerName, "onUpdate:modelValue": t[9] || (t[9] = (r) => e(a).manufacturerName = r), modelModifiers: { trim: true }, maxlength: "30", clearable: "", style: { width: "250px" } }, null, 8, ["modelValue"])]), _: 1 }), i(_, { label: "份数" }, { default: u(() => [i(xe, { modelValue: e(a).copiesQuantity, "onUpdate:modelValue": t[10] || (t[10] = (r) => e(a).copiesQuantity = r), step: 1, min: 1, max: 999, style: { width: "250px" }, onChange: Le }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"]), d("div", wt, [i(O, { size: "default", type: "success", onClick: be }, { default: u(() => t[18] || (t[18] = [j("取 消")])), _: 1, __: [18] }), i(O, { loading: M.value, size: "default", type: "primary", onClick: ve }, { default: u(() => t[19] || (t[19] = [j("保 存")])), _: 1, __: [19] }, 8, ["loading"])])]), _: 1 }, 8, ["visible"]), i(Ue, { hit: "", size: "large", style: { "margin-left": "5px" }, effect: "plain" }, { default: u(() => [G.value ? (b(), H(w, { key: 1 }, { default: u(() => [i(ke)]), _: 1 })) : (b(), U("span", At, [d("span", null, "标签类型：" + P(e(Q).VL[L.value.type]) + "，", 1), A(d("span", null, "重量：" + P(e(ae).VL[L.value.weight]) + "，", 513), [[k, e(l) & (e(c).ARTIFACT.V | e(c).MACHINE_PART.V)]]), A(d("span", null, "区域：" + P(Z(L.value.showArea)) + "，", 513), [[k, e(l) & (e(c).ARTIFACT.V | e(c).MACHINE_PART.V)]]), A(d("span", null, "单体：" + P(Z(L.value.showMonomer)) + "，", 513), [[k, e(l) & (e(c).ARTIFACT.V | e(c).MACHINE_PART.V)]]), A(d("span", null, "生产日期：" + P(Z(L.value.dateInProduced)) + "，", 513), [[k, e(l) & (e(c).ARTIFACT.V | e(c).MACHINE_PART.V | e(c).ENCLOSURE.V)]]), d("span", null, "制造商名称：" + P(L.value.manufacturerName || "-") + "，", 1), d("span", null, "份数：" + P(L.value.copiesQuantity), 1)]))]), _: 1 })]), viewLeft: u(() => [A((b(), H(O, { type: "success", size: "default", disabled: e(g).selections.length === 0, onClick: t[12] || (t[12] = (r) => e(Ae)(e(g).selections)) }, { default: u(() => t[20] || (t[20] = [j("批量打印标签 ")])), _: 1, __: [20] }, 8, ["disabled"])), [[re, e(p).batchPrint]])]), _: 1 })]);
  };
} }, jt = fe(Nt, [["__scopeId", "data-v-b9832bad"]]);
export {
  jt as default
};
