import { useStore as Ce } from "vuex";
import { computed as Z } from "vue";
import { watch as B } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as f } from "vue";
import { Fragment as I } from "vue";
import { renderList as O } from "vue";
import { createBlock as K } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as V } from "vue";
import { createCommentVNode as ke } from "vue";
import { unref as n } from "vue";
import { ElTag as ae } from "element-plus";
import { ElTooltip as Pe } from "element-plus";
import { Loading as le } from "@element-plus/icons-vue";
import { ElIcon as ie } from "element-plus";
import { inject as z } from "vue";
import { ref as L } from "vue";
import { reactive as ee } from "vue";
import { resolveComponent as te } from "vue";
import { resolveDirective as Te } from "vue";
import { withDirectives as ne } from "vue";
import { vShow as Ae } from "vue";
import { createElementVNode as d } from "vue";
import { ElMessage as Ne } from "element-plus";
import { View as Qe } from "@element-plus/icons-vue";
import { ElPopover as Ee } from "element-plus";
import { ElFormItem as Me } from "element-plus";
import { ElCheckbox as Ue } from "element-plus";
import { ElInput as $e } from "element-plus";
import { ElInputNumber as Be } from "element-plus";
import { ElForm as He } from "element-plus";
import { l as se, _ as re, B as Se, m as ze, bo as D, bc as G, V as R, C as Re, E as je, bt as oe } from "../../../../shared/runtime.js";
import { t as Fe } from "../../../../modules/print-record-c36add77.js";
import { s as qe, Q as Oe } from "../../../../modules/bridge-label-a62ef559.js";
import { u as De } from "../../../../modules/use-label-print-47f6f6b0.js";
import { _ as Ge } from "../../../../modules/index-2d037787.js";
import { _ as Ke } from "../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import { u as We } from "../../../../modules/use-bridge-product-lines-0fd5db98.js";
import { b as Je } from "../../../../modules/index-3b2e6e51.js";
import "../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../modules/index-8356a01a.js";
import "../../../../modules/label-logo-8a01bd73.js";
function Xe(r, y) {
  return se({ module: "bridge", url: "print/config", method: "get", params: { projectId: r, printType: y } });
}
function Ye({ printType: r, projectId: y, weight: b, copiesQuantity: u, printAll: l, type: x, showProductionLine: v, manufacturerName: C, showArea: M, showMonomer: k, dateInProduced: c }) {
  return se({ module: "bridge", url: "print/config", method: "post", data: { printType: r, projectId: y, weight: b, copiesQuantity: u, printAll: l, type: x, showProductionLine: v, manufacturerName: C, showArea: M, showMonomer: k, dateInProduced: c } });
}
const Ze = (r) => {
  const y = Ce(), b = Z(() => y.state.config.loaded.company);
  if (b.value || y.dispatch("config/fetchCompany"), r) {
    const u = B(b, (l) => {
      l && setTimeout(() => {
        r(), u();
      }, 0);
    }, { immediate: true });
  }
  return { company: Z(() => y.state.config.company), loaded: b };
};
const et = { class: "production-lines-content" }, tt = { key: 1, style: { "font-size": "11px", color: "red" } }, nt = { key: 1, style: { "font-size": "11px" } }, ot = { __name: "production-line-box-select", props: { modelValue: { type: [Number, void 0], default: void 0 }, unselectable: { type: Boolean, default: false }, selectedAbleLineIds: { type: Array, default: () => [] }, selectedAbleLineLoading: { type: Boolean, default: true }, tip: { type: String, default: "* 没有含有任务的生产线" } }, emits: ["update:modelValue", "loaded", "change"], setup(r, { expose: y, emit: b }) {
  const u = b, l = r, { loaded: x, productLines: v } = We();
  B(x, (c) => {
    u("loaded");
  }, { immediate: true, deep: true });
  function C(c) {
    l.value !== c.id ? k(c.id) : l.unselectable && k(void 0);
  }
  function M() {
    if (!x.value) throw new Error("生产线未加载完成");
    return v.value;
  }
  function k(c) {
    u("update:modelValue", c), u("change", c);
  }
  return y({ getLines: M }), (c, U) => {
    const j = ae, P = Pe, $ = le, T = ie;
    return p(), f("div", et, [r.selectedAbleLineLoading ? (p(), f("span", nt, [U[0] || (U[0] = E("生产线加载中 ")), a(T, null, { default: i(() => [a($)]), _: 1 })])) : (p(), f(I, { key: 0 }, [r.selectedAbleLineIds && r.selectedAbleLineIds.length > 0 ? (p(true), f(I, { key: 0 }, O(n(v), (t) => (p(), f(I, null, [(p(true), f(I, null, O(t.workshopList, (m) => (p(), f(I, null, [(p(true), f(I, null, O(m.productionLineList, (h) => (p(), f(I, { key: h.id }, [r.selectedAbleLineIds.includes(h.id) ? (p(), K(P, { key: 0, class: "item", effect: "light", content: `${t.name} - ${h.name}`, placement: "top", "show-after": 1e3 }, { default: i(() => [a(j, { hit: "", effect: h.id == r.modelValue ? "light" : "plain", type: h.id == r.modelValue ? "success" : "info", "disable-transitions": true, onClick: (W) => C(h) }, { default: i(() => [E(V(h.name), 1)]), _: 2 }, 1032, ["effect", "type", "onClick"])]), _: 2 }, 1032, ["content"])) : ke("", true)], 64))), 128))], 64))), 256))], 64))), 256)) : (p(), f("span", tt, V(r.tip), 1))], 64))]);
  };
} }, at = re(ot, [["__scopeId", "data-v-5ac4b4ab"]]);
const lt = { class: "hed-container" }, it = { style: { display: "flex", "align-items": "center" } }, st = { style: { height: "480px", "margin-top": "-40px" } }, rt = ["innerHTML"], dt = { style: { "margin-left": "5px" } }, ut = { style: { display: "flex", "align-items": "center" } }, ct = { style: { "text-align": "right" } }, pt = { key: 0 }, mt = { __name: "label-print-header", setup(r, { expose: y }) {
  const b = { serialNumber: "", monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, productionLineId: { value: void 0, resetAble: false } }, { crud: u, query: l, CRUD: x } = Se(b), { globalProjectId: v, user: C, requestUrl: M } = ze(["globalProjectId", "user", "requestUrl"]), k = z("permission"), c = z("productType"), U = z("printType"), { company: j } = Ze();
  x.HOOK.handleRefresh = (o, e) => {
    e.data.content = e.data.content.map((_) => (_.printedQuantity = _.printQuantity, _.printQuantity = 1, _));
  };
  const P = L(false), $ = L(false), T = L(false);
  let t = ee({ weight: D.NET.V, type: G.COMMON.V, showArea: true, showMonomer: true, dateInProduced: true, showProductionLine: true, manufacturerName: "", copiesQuantity: 1 });
  const m = L(R(t)), h = ee({});
  function W() {
    for (const o in G.V) h[o] = false;
  }
  W();
  function J(o) {
    return o ? "显示" : "不显示";
  }
  B(() => v.value, () => {
    de();
  }, { immediate: true });
  async function de() {
    try {
      T.value = true;
      const o = await Xe(v.value, U);
      if (o) {
        const { type: e, weight: _, showArea: w, showProductionLine: A, showMonomer: g, dateInProduced: S, manufacturerName: N, copiesQuantity: Q } = o;
        t.weight = _, t.type = e, t.showProductionLine = A, t.showArea = w, t.showMonomer = g, t.dateInProduced = S, t.manufacturerName = N, t.copiesQuantity = Q || 1, m.value = R(t);
      }
    } catch (o) {
      console.log("项目打印配置", o);
    } finally {
      T.value = false;
    }
  }
  function ue() {
    P.value = false, t = Object.assign(t, R(m.value));
  }
  async function ce() {
    try {
      $.value = true;
      const o = { ...t, projectId: v.value };
      await Ye({ ...o, printType: U, showProductionLine: t.showProductionLine, showArea: t.showArea, showMonomer: t.showMonomer, dateInProduced: t.dateInProduced }), P.value = false, m.value = R(t), Ne({ message: "保存成功", type: "success" });
    } catch (o) {
      console.log("设置项目打印配置", o);
    } finally {
      $.value = false;
    }
  }
  function pe(o) {
    o || (t.copiesQuantity = 1);
  }
  function me({ monomerId: o, areaId: e }) {
    l.monomerId = o, l.areaId = e;
  }
  const F = L(false), H = L([]), q = L(), X = L([]);
  async function fe() {
    if (console.log(c, "productType"), l.productionLineId = void 0, H.value = [], !!l.areaId) try {
      F.value = true, await oe({ areaId: l.areaId, productType: c });
      const { ids: o } = await oe({ areaId: l.areaId, productType: c });
      o && o.length > 0 && (H.value = o, l.productionLineId = H.value[0]);
    } catch (o) {
      console.log("获取有任务的生产线", o);
    } finally {
      F.value = false;
    }
  }
  function Y() {
    q.value && (X.value = q.value.getLines());
  }
  function ye() {
    let o = {};
    for (const e of X.value) {
      const _ = e.workshopList || [];
      for (const w of _) {
        const A = w.productionLineList || [];
        for (const g of A) if (g.id === l.productionLineId) {
          o = { id: g.id, name: g.name, factoryId: w.factoryId, factoryName: w.factoryName };
          break;
        }
      }
    }
    return o;
  }
  B([() => l.monomerId, () => l.areaId], ([o, e]) => {
    fe(), o && e && l.productionLineId && u.toQuery();
  }, { immediate: true }), B(() => l.productionLineId, (o) => {
    u.toQuery();
  }, { immediate: true });
  const { getLabelInfo: ge, printLabelFunc: _e } = z("headerObj"), { batchPrint: be, print: ve } = De({ getPrintTotalNumber: (o) => (o.printQuantity || 0) * m.value.copiesQuantity, getLabelInfo: ge, printFinallyHook: u.toQuery, getLoadingTextFunc: (o) => `${o.name}-${o.serialNumber}`, printLabelFunc: _e, needAddPrintRecord: true, addPrintIdField: "taskId", addPrintRecordReq: Fe });
  return y({ getLine: ye, handleLinesLoaded: Y, companyName: C.value && C.value.companyName, printConfig: m, spliceQrCodeUrl: qe, QR_SCAN_PATH: Oe, requestUrl: M, company: j, print: ve }), (o, e) => {
    const _ = te("common-radio-button"), w = Qe, A = ie, g = te("common-button"), S = Ee, N = Me, Q = Ue, he = $e, Le = Be, we = He, Ie = le, Ve = ae, xe = Te("permission");
    return p(), f("div", lt, [ne(d("div", null, [a(n(Ke), { "project-id": n(v), onChange: me }, null, 8, ["project-id"]), a(n(Ge), { productType: n(c), toQuery: n(u).toQuery, query: n(l) }, null, 8, ["productType", "toQuery", "query"]), a(n(Re))], 512), [[Ae, n(u).searchToggle]]), a(n(at), { ref_key: "plBoxSelectRef", ref: q, modelValue: n(l).productionLineId, "onUpdate:modelValue": e[0] || (e[0] = (s) => n(l).productionLineId = s), "selected-able-line-ids": H.value, "selected-able-line-loading": F.value, tip: "* 区域下没有含有任务的生产线", class: "filter-item", onLoaded: Y }, null, 8, ["modelValue", "selected-able-line-ids", "selected-able-line-loading"]), a(n(je), null, { optRight: i(() => [a(S, { visible: P.value, "onUpdate:visible": e[8] || (e[8] = (s) => P.value = s), placement: "bottom-start", width: "430" }, { reference: i(() => [a(g, { type: "primary", disabled: T.value, size: "default" }, { default: i(() => e[14] || (e[14] = [E("打印设置")])), _: 1, __: [14] }, 8, ["disabled"])]), default: i(() => [a(we, { ref: "form", model: n(t), "label-width": "90px", size: "default" }, { default: i(() => [a(N, { label: "重量" }, { default: i(() => [d("div", it, [a(_, { modelValue: n(t).weight, "onUpdate:modelValue": e[1] || (e[1] = (s) => n(t).weight = s), options: n(D).ENUM, type: "enum" }, null, 8, ["modelValue", "options"]), a(S, { placement: "right", title: n(G).VL[n(t).type], width: 430, trigger: "hover" }, { reference: i(() => [d("div", dt, [a(g, { size: "default", type: "info" }, { default: i(() => [a(A, null, { default: i(() => [a(w)]), _: 1 })]), _: 1 })])]), default: i(() => [d("div", st, [d("span", { innerHTML: n(Je)({ productType: n(c), labelType: n(t).type, labelData: { printConfig: n(t) } }) }, null, 8, rt)])]), _: 1 }, 8, ["title"])])]), _: 1 }), a(N, { label: "显示" }, { default: i(() => [d("span", ut, [e[10] || (e[10] = d("span", { style: { "margin-right": "3px" } }, "单体", -1)), a(Q, { modelValue: n(t).showMonomer, "onUpdate:modelValue": e[2] || (e[2] = (s) => n(t).showMonomer = s) }, null, 8, ["modelValue"]), e[11] || (e[11] = d("span", { style: { "margin-right": "3px" } }, "区域", -1)), a(Q, { modelValue: n(t).showArea, "onUpdate:modelValue": e[3] || (e[3] = (s) => n(t).showArea = s) }, null, 8, ["modelValue"]), e[12] || (e[12] = d("span", { style: { "margin-right": "3px" } }, "生产日期", -1)), a(Q, { modelValue: n(t).dateInProduced, "onUpdate:modelValue": e[4] || (e[4] = (s) => n(t).dateInProduced = s) }, null, 8, ["modelValue"]), e[13] || (e[13] = d("span", { style: { "margin-right": "3px" } }, "生产线", -1)), a(Q, { modelValue: n(t).showProductionLine, "onUpdate:modelValue": e[5] || (e[5] = (s) => n(t).showProductionLine = s) }, null, 8, ["modelValue"])])]), _: 1 }), a(N, { label: "制造商名称" }, { default: i(() => [a(he, { modelValue: n(t).manufacturerName, "onUpdate:modelValue": e[6] || (e[6] = (s) => n(t).manufacturerName = s), modelModifiers: { trim: true }, maxlength: "30", clearable: "", style: { width: "250px" } }, null, 8, ["modelValue"])]), _: 1 }), a(N, { label: "份数" }, { default: i(() => [a(Le, { modelValue: n(t).copiesQuantity, "onUpdate:modelValue": e[7] || (e[7] = (s) => n(t).copiesQuantity = s), step: 1, min: 1, max: 999, style: { width: "250px" }, onChange: pe }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"]), d("div", ct, [a(g, { size: "default", type: "success", onClick: ue }, { default: i(() => e[15] || (e[15] = [E("取 消")])), _: 1, __: [15] }), a(g, { loading: $.value, size: "default", type: "primary", onClick: ce }, { default: i(() => e[16] || (e[16] = [E("保 存")])), _: 1, __: [16] }, 8, ["loading"])])]), _: 1 }, 8, ["visible"]), a(Ve, { hit: "", size: "large", style: { "margin-left": "5px" }, effect: "plain" }, { default: i(() => [T.value ? (p(), K(A, { key: 1 }, { default: i(() => [a(Ie)]), _: 1 })) : (p(), f("span", pt, [d("span", null, "重量：" + V(n(D).VL[m.value.weight]) + "，", 1), d("span", null, "区域：" + V(J(m.value.showArea)) + "，", 1), d("span", null, "单体：" + V(J(m.value.showMonomer)) + "，", 1), d("span", null, "制造商名称：" + V(m.value.manufacturerName || "-") + "，", 1), d("span", null, "份数：" + V(m.value.copiesQuantity), 1)]))]), _: 1 })]), viewLeft: i(() => [ne((p(), K(g, { type: "success", size: "default", disabled: n(u).selections.length === 0, onClick: e[9] || (e[9] = (s) => n(be)(n(u).selections)) }, { default: i(() => e[17] || (e[17] = [E("批量打印标签 ")])), _: 1, __: [17] }, 8, ["disabled"])), [[xe, n(k).print]])]), _: 1 })]);
  };
} }, Ct = re(mt, [["__scopeId", "data-v-4951b294"]]);
export {
  Ct as default
};
