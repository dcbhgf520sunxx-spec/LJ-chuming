import { provide as S } from "vue";
import { computed as D } from "vue";
import { ref as d } from "vue";
import { watch as we } from "vue";
import { nextTick as me } from "vue";
import { openBlock as a } from "vue";
import { createBlock as L } from "vue";
import { withCtx as x } from "vue";
import { withDirectives as ve } from "vue";
import { createElementVNode as l } from "vue";
import { resolveDynamicComponent as Ne } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as r } from "vue";
import { unref as u } from "vue";
import { ElRadioGroup as ke } from "element-plus";
import { Fragment as M } from "vue";
import { renderList as W } from "vue";
import { ElRadioButton as he } from "element-plus";
import { createTextVNode as g } from "vue";
import { toDisplayString as s } from "vue";
import { vShow as pe } from "vue";
import { createCommentVNode as B } from "vue";
import { normalizeClass as ye } from "vue";
import { isRef as _e } from "vue";
import { ElDialog as be } from "element-plus";
import { useRoute as Ie } from "vue-router";
import { watchEffect as Ce } from "vue";
import { ElLoading as Te } from "element-plus";
import { resolveComponent as Ve } from "vue";
import { ElNotification as fe } from "element-plus";
import { ElTimeline as De } from "element-plus";
import { createSlots as xe } from "vue";
import { ElTimelineItem as Se } from "element-plus";
import { a as Be, b as $e, c as Ee } from "../../../modules/qr-scan-info-657de68e.js";
import { u as ge, b as je, a as V, _ as Le, p as Re } from "../../../shared/runtime.js";
import { b as qe, _ as Oe } from "../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import { b as ze } from "../../../modules/bim-model-view-dbf77a11.js";
import { c as Ue } from "../../../modules/index-f09320a8.js";
import "../../../modules/externalRequest-4308f5b0.js";
import "../../../modules/bimfaceAPI-c2661893.js";
import "../../../modules/model-0ac957f7.js";
import "../../../modules/index-d6a37d29.js";
import "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
const Fe = { class: "root-content" }, Ae = { class: "operate-content" }, He = { key: 0, class: "operate-left" }, Me = { key: 1, class: "operate-left" }, Pe = { class: "mobile-quick-operation" }, Ze = { key: 0, class: "load-box" }, Ge = { __name: "mobile-drawing-preview-fullscreen-dialog", props: { modelValue: { type: Boolean, default: false }, boolBim: { type: Boolean, default: false }, drawingSN: { type: [String, Array] }, curDrawingSN: { type: [String, Number] }, serialNumber: { type: String, default: void 0 }, monomerId: { type: [Number, String], default: void 0 }, productId: { type: Number, default: void 0 }, productType: { type: Number, default: void 0 }, projectType: { type: Number, default: void 0 } }, emits: ["update:modelValue"], setup(m, { emit: $ }) {
  const k = $, c = m;
  S("productId", D(() => c.productId)), S("productType", D(() => c.productType)), S("projectType", D(() => c.projectType)), S("serialNumber", D(() => c.serialNumber)), S("monomerId", D(() => c.monomerId));
  const { visible: p, handleClose: t } = ge({ emit: k, props: c, field: "modelValue", showHook: G, closeHook: Z }), n = d(), w = d(true), y = d(false), h = d(), v = d(), R = d(false), I = d(), P = D(() => c.boolBim ? qe : Oe), E = D(() => {
    var C;
    return Array.isArray(c.drawingSN) && ((C = c.drawingSN) == null ? void 0 : C.length);
  });
  S("multipleDrawing", E), S("drawingSN", I), we(() => I.value, () => {
    je(I.value) || (h.value = 1, v.value = 1, w.value = true, me(() => {
      n.value.fetchDrawing(), n.value.reset();
    }));
  });
  function Z() {
    I.value = void 0;
  }
  function G() {
    p.value && (E.value ? I.value = c.curDrawingSN || c.drawingSN[0] : (h.value = 1, v.value = 1, me(() => {
      n.value.fetchDrawing(), n.value.reset();
    })));
  }
  function q(C) {
    w.value = C;
  }
  function f(C) {
    R.value = C;
  }
  function Q() {
    n.value.scaleZoom();
  }
  function J() {
    n.value.scaleZoomOut();
  }
  function K() {
    n.value.clockwiseRotate();
  }
  function F() {
    n.value.counterclockwiseRotate();
  }
  function O() {
    n.value.reset();
  }
  function A() {
    y.value = !y.value;
  }
  return (C, o) => (a(), L(u(be), { title: "图纸预览", modelValue: u(p), "onUpdate:modelValue": o[4] || (o[4] = (e) => _e(p) ? p.value = e : null), width: "80%", fullscreen: true, "custom-class": "mobile-drawing-pdf-dialog", "before-close": u(t) }, { default: x(() => [ve(l("div", Fe, [l("div", { class: "preview-content", onDblclick: o[0] || (o[0] = (e) => q(true)), onClick: o[1] || (o[1] = (e) => q(false)) }, [(a(), L(Ne(P.value), { ref_key: "viewRef", ref: n, onChangeFileLoading: f }, null, 544))], 32), ve(l("div", Ae, [E.value ? (a(), i("div", He, [r(u(ke), { modelValue: I.value, "onUpdate:modelValue": o[2] || (o[2] = (e) => I.value = e), size: "small" }, { default: x(() => [(a(true), i(M, null, W(m.drawingSN, (e) => (a(), L(u(he), { key: e, label: e }, { default: x(() => [g(s(`${m.serialNumber}${e ? "_" + e : ""}`), 1)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["modelValue"])])) : (a(), i("div", Me, s(m.serialNumber), 1)), o[5] || (o[5] = l("div", { class: "operate-middle" }, null, -1)), o[6] || (o[6] = l("div", { class: "operate-right" }, null, -1))], 512), [[pe, w.value]]), l("div", Pe, [l("div", { class: "icon-box", onClick: o[3] || (o[3] = (...e) => u(t) && u(t)(...e)) }, [r(V, { class: "icon", "icon-class": "comp-quit" })]), y.value ? B("", true) : (a(), i("div", { key: 0, class: "icon-box", onClick: A }, [r(V, { class: "icon", "icon-class": "comp-unfold" })])), l("div", { id: "toolsList", class: ye(["tools-list", { show: y.value }]) }, [l("div", { class: "icon-box", onClick: Q }, [r(V, { class: "icon", "icon-class": "comp-zoom" })]), l("div", { class: "icon-box", onClick: J }, [r(V, { class: "icon", "icon-class": "comp-zoom-out" })]), m.boolBim ? B("", true) : (a(), i("div", { key: 0, class: "icon-box", onClick: K }, [r(V, { class: "icon", "icon-class": "comp-clockwise-rotate" })])), m.boolBim ? B("", true) : (a(), i("div", { key: 1, class: "icon-box", onClick: F }, [r(V, { class: "icon", "icon-class": "comp-counterclockwise-rotate" })])), l("div", { class: "icon-box", onClick: O }, [r(V, { class: "icon", "icon-class": "comp-restore-size" })]), y.value ? (a(), i("div", { key: 2, class: "icon-box", onClick: A }, [r(V, { class: "icon", "icon-class": "comp-fold" })])) : B("", true)], 2)])], 512), [[pe, !R.value]]), R.value ? (a(), i("div", Ze, o[7] || (o[7] = [l("i", { class: "el-icon-loading" }, null, -1)]))) : B("", true)]), _: 1 }, 8, ["modelValue", "before-close"]));
} };
const Qe = { __name: "trace-model-fullscreen-dialog", props: { modelValue: Boolean, monomerId: Number, serialNumber: String, productId: Number, productType: Number, modelElementIds: Array }, emits: ["update:modelValue"], setup(m, { emit: $ }) {
  const k = m, c = $, { visible: p, handleClose: t } = ge({ emit: c, props: k, field: "modelValue" });
  return (n, w) => {
    const y = V, h = be;
    return a(), L(h, { modelValue: u(p), "onUpdate:modelValue": w[0] || (w[0] = (v) => _e(p) ? p.value = v : null), fullscreen: true, class: ye("traceability-model-fullscreen-dialog"), "before-close": u(t), "show-close": false }, { default: x(() => [r(u(ze), { "monomer-id": m.monomerId, "serial-number": m.serialNumber, "product-id": m.productId, "product-type": m.productType, "model-element-ids": m.modelElementIds, "is-preview": "", "trace-page": "", visible: u(p), class: "bim-model" }, null, 8, ["monomer-id", "serial-number", "product-id", "product-type", "model-element-ids", "visible"]), r(y, { class: "exit-fullscreen-btn", "icon-class": "cancel", onClick: u(t) }, null, 8, ["onClick"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
const Je = { class: "trace-container" }, Ke = { class: "trace-head" }, We = { class: "company-name" }, Xe = { class: "trace-body" }, Ye = { class: "base-info" }, eo = { class: "info-title" }, oo = { class: "info-list" }, lo = { class: "info-item" }, to = { class: "info-item" }, so = { class: "info-item" }, ao = { class: "info-item" }, no = { class: "info-item" }, io = { class: "info-item" }, co = { class: "info-item" }, uo = { class: "info-button" }, ro = { class: "production-item" }, mo = { key: 0, class: "trace-info" }, vo = { class: "info-title" }, po = { key: 0, class: "el-timeline-item__custom-dot", style: { backgroundColor: "#017eff" } }, fo = { key: 1, class: "el-timeline-item__custom-dot", style: { backgroundColor: "#67C23A" } }, yo = { class: "process-name" }, _o = { class: "user-info" }, bo = { class: "user-name ellipsis-text" }, go = { class: "inspection-time" }, wo = { key: 1, class: "no-data" }, No = { key: 1, class: "trace-no-loaded" }, ko = { __name: "index", setup(m) {
  const $ = { companyName: "杭州初鸣建筑科技有限公司", systemName: "初鸣智造", productionBaseName: "杭州初鸣建筑科技有限公司" }, k = Ie(), c = d(k.query.lang), p = D(() => k.query.type), t = d({}), n = d([]), w = d(false), y = d(false), h = d(true), v = d({ ...$ }), R = document.title, I = D(() => (t.value.configItemVOList || []).filter((o) => (o == null ? void 0 : o.fieldName) && (o == null ? void 0 : o.fieldValue))), P = k.query.taskId, E = k.query.whId, Z = k.query.num, G = { taskId: P || E, number: Z }, q = window.location.origin, f = d();
  Ce(() => {
    c.value && p.value && (f.value = Ue({ productType: p.value, language: c.value }));
  }), S("externalUrl", q), Q(q, G);
  async function Q(o, e) {
    n.value = [], h.value = true;
    const _ = Te.service({ lock: true, text: "正在加载溯源信息", background: "rgba(0, 0, 0, 0.7)", fullscreen: true });
    try {
      const N = await Be(o, e);
      h.value = true, t.value = N, n.value = N.qrTaskInfoDetailDTOList, await J(o, N);
    } catch (N) {
      console.log("获取溯源信息失败", N), h.value = false;
    } finally {
      _.close();
    }
  }
  async function J(o, e) {
    var z, U;
    const _ = await K(o), N = ((z = e == null ? void 0 : e.project) == null ? void 0 : z.id) || (e == null ? void 0 : e.projectId), H = (U = e == null ? void 0 : e.project) == null ? void 0 : U.name;
    if (!N && !H) {
      v.value = { ..._ }, O(v.value.systemName);
      return;
    }
    try {
      const j = await $e(o, { projectId: N, projectName: H });
      v.value = F(_, j), O(v.value.systemName);
    } catch (j) {
      console.log("获取项目溯源配置失败", j), v.value = { ..._ }, O(v.value.systemName);
    }
  }
  async function K(o) {
    try {
      const e = await Ee(o);
      return F($, e);
    } catch (e) {
      return console.log("获取默认溯源配置失败", e), { ...$ };
    }
  }
  function F(o, e) {
    return { companyName: (e == null ? void 0 : e.companyName) || o.companyName, systemName: (e == null ? void 0 : e.systemName) || o.systemName, productionBaseName: (e == null ? void 0 : e.productionBaseName) || o.productionBaseName };
  }
  function O(o) {
    const e = R || document.title, _ = e.lastIndexOf("-");
    document.title = _ > -1 ? `${e.slice(0, _ + 1)}${o}` : o;
  }
  function A() {
    var o;
    if (!((o = t.value) != null && o.boolHavDrawing)) return fe({ title: "暂无图纸", type: "warning", duration: 2e3 });
    w.value = true;
  }
  function C() {
    var o;
    if (!((o = t.value) != null && o.boolHavModel)) return fe({ title: "未在模型中匹配到当前构件", type: "warning", duration: 2e3 });
    y.value = true;
  }
  return (o, e) => {
    var z, U, j, X, Y, ee, oe, le, te, se, ae, ne, ie, ce, ue, re, de;
    const _ = Ve("common-button"), N = Se, H = De;
    return a(), i("div", Je, [l("div", Ke, [l("h3", We, s(v.value.productionBaseName), 1), e[2] || (e[2] = l("h4", null, "溯源查询系统", -1))]), l("div", Xe, [h.value ? (a(), i(M, { key: 0 }, [l("div", Ye, [l("div", eo, s(f.value("productInfo")) + "：", 1), l("div", oo, [l("div", lo, [l("span", null, s(f.value("project")) + "：", 1), g(s((U = (z = t.value) == null ? void 0 : z.project) == null ? void 0 : U.name), 1)]), l("div", to, [l("span", null, s(f.value("monomer")) + "：", 1), g(s((X = (j = t.value) == null ? void 0 : j.monomer) == null ? void 0 : X.name), 1)]), l("div", so, [l("span", null, s(f.value("region")) + "：", 1), g(s((ee = (Y = t.value) == null ? void 0 : Y.area) == null ? void 0 : ee.name), 1)]), l("div", ao, [l("span", null, s(f.value("serialNumber")) + "：", 1), g(s((oe = t.value) == null ? void 0 : oe.serialNumber), 1)]), l("div", no, [l("span", null, s(f.value("Specifications")) + "：", 1), g(s((le = t.value) == null ? void 0 : le.specification), 1)]), l("div", io, [l("span", null, s(f.value("length")) + "：", 1), g(s((te = t.value) == null ? void 0 : te.length), 1)]), l("div", co, [l("span", null, s(f.value("material")) + "：", 1), g(s((se = t.value) == null ? void 0 : se.material), 1)]), (a(true), i(M, null, W(I.value, (b, T) => (a(), i("div", { key: T, class: "info-item" }, [l("span", null, s(b.fieldName) + "：", 1), g(s(b.fieldValue), 1)]))), 128)), l("div", uo, [r(_, { class: "btn-item", type: "warning", onClick: A }, { default: x(() => e[3] || (e[3] = [g("二维图纸")])), _: 1, __: [3] }), r(_, { class: "btn-item", type: "primary", onClick: C }, { default: x(() => e[4] || (e[4] = [g("三维模型")])), _: 1, __: [4] })]), l("div", ro, s(v.value.companyName), 1)])]), u(E) ? B("", true) : (a(), i("div", mo, [l("div", vo, s(f.value("productionInfo")), 1), (ae = n.value) != null && ae.length ? (a(), L(H, { key: 0, class: "timeline-list" }, { default: x(() => [(a(true), i(M, null, W(n.value, (b, T) => (a(), L(N, { key: T, type: b.processName.includes("质检") ? "danger" : "primary", size: T === 0 || T === n.value.length - 1 ? "large" : "normal" }, xe({ default: x(() => [l("div", yo, s(b.processName), 1), l("div", _o, [l("div", bo, s(b.userName), 1), l("div", go, s(u(Re)(b.inspectionOrReportingTime, "{y}-{m}-{d} {h}:{i}")), 1)])]), _: 2 }, [T === 0 || T === n.value.length - 1 ? { name: "dot", fn: x(() => [T === 0 ? (a(), i("div", po, e[5] || (e[5] = [l("span", null, "始", -1)]))) : B("", true), T === n.value.length - 1 ? (a(), i("div", fo, e[6] || (e[6] = [l("span", null, "终", -1)]))) : B("", true)]), key: "0" } : void 0]), 1032, ["type", "size"]))), 128))]), _: 1 })) : (a(), i("div", wo, "*暂无数据"))]))], 64)) : (a(), i("div", No, "未开启二维码溯源功能"))]), r(u(Ge), { modelValue: w.value, "onUpdate:modelValue": e[0] || (e[0] = (b) => w.value = b), "bool-bim": t.value.boolBim, "serial-number": t.value.serialNumber, productId: t.value.productId, productType: t.value.productType, drawingSN: t.value.numbers, monomerId: (ne = t.value.monomer) == null ? void 0 : ne.id }, null, 8, ["modelValue", "bool-bim", "serial-number", "productId", "productType", "drawingSN", "monomerId"]), r(u(Qe), { modelValue: y.value, "onUpdate:modelValue": e[1] || (e[1] = (b) => y.value = b), "monomer-id": (ce = (ie = t.value) == null ? void 0 : ie.monomer) == null ? void 0 : ce.id, "serial-number": (ue = t.value) == null ? void 0 : ue.serialNumber, modelElementIds: t.value.modelElementIds, "product-id": (re = t.value) == null ? void 0 : re.productId, "product-type": (de = t.value) == null ? void 0 : de.productType }, null, 8, ["modelValue", "monomer-id", "serial-number", "modelElementIds", "product-id", "product-type"])]);
  };
} }, Lo = Le(ko, [["__scopeId", "data-v-4bf70c67"]]);
export {
  Lo as default
};
