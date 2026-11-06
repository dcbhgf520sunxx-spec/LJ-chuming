import { ref as d } from "vue";
import { inject as v } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as D } from "vue";
import { unref as f } from "vue";
import { createBlock as j } from "vue";
import { withCtx as F } from "vue";
import { createTextVNode as W } from "vue";
import { toDisplayString as $ } from "vue";
import { normalizeStyle as ee } from "vue";
import { createCommentVNode as z } from "vue";
import { ElNotification as K } from "element-plus";
import { ElTag as oe } from "element-plus";
import { provide as I } from "vue";
import { computed as h } from "vue";
import { watch as ae } from "vue";
import { nextTick as q } from "vue";
import { withDirectives as Q } from "vue";
import { createElementVNode as S } from "vue";
import { resolveDynamicComponent as te } from "vue";
import { createVNode as b } from "vue";
import { ElRadioGroup as ne } from "element-plus";
import { Fragment as le } from "vue";
import { renderList as se } from "vue";
import { ElRadioButton as ie } from "element-plus";
import { vShow as Y } from "vue";
import { isRef as re } from "vue";
import { normalizeClass as ce } from "vue";
import { ElDialog as ue } from "element-plus";
import { Loading as de } from "@element-plus/icons-vue";
import { ElIcon as pe } from "element-plus";
import { _ as ve, n as fe, a4 as me, a5 as ge, a6 as we, i as ye, a7 as _e, u as Se, b as Te, a as O } from "../shared/runtime.js";
import { i as ke, h as be, j as De, k as Ee, l as Ve } from "./bimfaceAPI-c2661893.js";
import { g as Ne } from "./model-0ac957f7.js";
const Ce = { class: "drawing-container" }, Ie = ["id"], he = { __name: "bim-drawing-view", setup(E, { expose: U }) {
  const s = { ERROR: { L: "获取图纸失败", K: "ERROR", V: "error", T: "danger" }, IS_NOT: { L: "非DWG文件", K: "IS_NOT", V: "isNot", T: "warning" }, PROCESSING: { L: "图纸正在转换，请稍后刷新重试", K: "PROCESSING", V: "processing", T: "warning" }, SUCCESS: { L: "成功", K: "SUCCESS", V: "success", T: "success" }, FAILED: { L: "图纸转换失败，请联系管理员或重新上传", K: "FAILED", V: "failed", T: "danger" }, QUERY: { L: "查询中...", K: "QUERY", V: "query", T: "primary" }, UNEXIST: { L: "未上传图纸", K: "UNEXIST", V: "unexist", T: "info" }, UPLOAD_PROCESSING: { L: "图纸正在上传", K: "UPLOAD_PROCESSING", V: "uploadProcessing", T: "warning" }, UPLOAD_SUCCESS: { L: "图纸未转换", K: "UPLOAD_SUCCESS", V: "uploadSuccess", T: "info" }, UPLOAD_FAILED: { L: "图纸上传失败", K: "UPLOAD_FAILED", V: "uploadFailed", T: "danger" } };
  fe(s);
  const t = d({ reason: "", status: "success", viewToken: "" }), _ = d(), e = d(), o = d(), i = d(s.QUERY.V), V = v("productId"), L = v("productType"), m = v("isPreview", false), p = v("id", ""), N = v("boolBim", true);
  async function g() {
    if (!N) {
      i.value = s.IS_NOT.V;
      return;
    }
    _.value = void 0, e.value = void 0, o.value = void 0;
    try {
      i.value = s.QUERY.V;
      const { viewToken: w, reason: r, status: c, fileId: y } = await Ne({ productId: V.value, productType: L.value });
      t.value = { fileId: y, viewToken: w, reason: r, status: c }, i.value = c, c === me.SUCCESS.V ? C(w) : K({ title: c ? s.VL[c] : "获取图纸失败", type: "error", duration: 2e3 });
    } catch (w) {
      const r = "获取图纸失败";
      r.value = s.ERROR.V, K({ title: r, type: "error", duration: 2e3 }), console.log("获取模型viewToken", w);
    }
  }
  async function C(w) {
    try {
      const r = await ke({ viewToken: w });
      o.value = be();
      const c = document.getElementById(`drawingView${p}`);
      c.innerHTML = "", o.value.domElement = c, m ? (o.value.Toolbars = ["MainToolbar"], o.value.Buttons = ["Home", "FullScreen"]) : o.value.Buttons = [], console.log(o, m, "_2DConfig");
      const y = De(o.value);
      e.value = y.getViewer(), console.log(e, y, "viewer2D"), r.viewToken && e.value.loadDrawing({ viewToken: r.viewToken }), _.value = Ee(), e.value.addEventListener(_.value.Loaded, async () => {
        const A = Ve("#525659");
        e.value.setBackgroundColor(A), window.onresize = function() {
          e.value.resize(document.documentElement.clientWidth, document.documentElement.clientHeight - 40);
        };
      }, { passive: false });
    } catch (r) {
      console.log(r);
    }
  }
  function R() {
    e.value && (e.value.zoomIn(), e.value.render());
  }
  function x() {
    e.value && (e.value.zoomOut(), e.value.render());
  }
  function P() {
    e.value && (e.value.home(), e.value.render());
  }
  return U({ fetchDrawing: g, reset: P, scaleZoomOut: x, scaleZoom: R }), (w, r) => {
    var y;
    const c = oe;
    return u(), D("div", Ce, [i.value !== s.SUCCESS.V && f(m) ? (u(), j(c, { key: 0, type: (y = s.V[i.value]) == null ? void 0 : y.T, style: ee(f(m) ? "margin-left: 10px;margin-top: 10px;" : "") }, { default: F(() => [W($(s.VL[i.value]) + " " + $(t.value.reason), 1)]), _: 1 }, 8, ["type", "style"])) : i.value === s.SUCCESS.V ? (u(), D("div", { key: 1, id: `drawingView${f(p)}`, class: "drawingView" }, null, 8, Ie)) : z("", true)]);
  };
} }, Le = ve(he, [["__scopeId", "data-v-8a0adedb"]]), Re = { id: "pdfBox", ref: "pdfBox", class: "pdf-box" }, xe = { __name: "pdf-view", emits: ["changeFileLoading"], setup(E, { expose: U, emit: s }) {
  const t = s, _ = v("productId"), e = v("productType"), o = v("projectType"), i = v("serialNumber"), V = v("monomerId"), L = v("multipleDrawing"), m = v("drawingSN"), p = "/assets", N = d(), g = d(1), C = d(0);
  function R(l) {
    t("changeFileLoading", l);
  }
  function x(l) {
    K({ title: "加载图纸失败，请确认是否已上传该编号图纸", type: "error", duration: 3e3 }), console.error(l);
  }
  async function P() {
    const l = document.getElementById("pdfBox");
    l && (l.scrollTop = 0);
    try {
      R(true);
      const k = { productId: _.value, productType: e.value, projectType: o.value, serialNumber: i == null ? void 0 : i.value, monomerId: V == null ? void 0 : V.value };
      L.value && ye(m.value) && (k.number = m.value);
      const a = await _e(k);
      if (a.headers["content-disposition"]) {
        const B = a.headers["content-disposition"].split("=")[1].split(".");
        if (B[B.length - 1] !== "pdf") throw new Error("非.pdf格式");
      } else throw new Error("获取文件格式失败");
      N.value = await w(a);
    } catch (k) {
      console.log("获取图纸", k), K({ title: "获取图纸失败", type: "error", duration: 2e3 }), N.value = null;
    } finally {
      R(false);
    }
  }
  function w(l) {
    return new Promise((k, a) => {
      if (l && l.data && l.data.size) {
        const B = l.data, Z = new window.FileReader();
        Z.readAsArrayBuffer(B), Z.onload = function(G) {
          console.log(G, B, "rrrr");
          const M = G.target.result, X = B.type, J = new Blob([M], { type: X }), H = window.URL.createObjectURL(J);
          console.log(H), k(H);
        };
      } else a();
    });
  }
  function r() {
    g.value += 0.2;
  }
  function c() {
    g.value -= 0.2;
  }
  function y() {
    C.value += 90;
  }
  function A() {
    C.value -= 90;
  }
  function T() {
    C.value = 0, g.value = 1;
  }
  function n(l) {
    g.value = l;
  }
  return U({ fetchDrawing: P, reset: T, setScale: n, scaleZoom: r, scaleZoomOut: c, clockwiseRotate: y, counterclockwiseRotate: A }), (l, k) => (u(), D("div", Re, [N.value ? (u(), j(f(we), { key: 0, url: N.value, scale: g.value, rotation: C.value, onPdfError: x, type: "canvas", watermarkImage: f(ge), watermarkOptions: { x: 0.88, y: 0.33, widthPercent: 0.09, opacity: 1 }, pdfjsDistPath: p }, null, 8, ["url", "scale", "rotation", "watermarkImage"])) : z("", true)], 512));
} };
const Be = { class: "root-content" }, Oe = { class: "operate-content" }, Ue = { key: 0, class: "operate-left" }, Pe = { key: 1, class: "operate-left" }, Ae = { class: "quick-operation" }, Fe = { key: 0, class: "load-box" }, Ze = { __name: "drawing-preview-fullscreen-dialog", props: { modelValue: { type: Boolean, default: false }, boolBim: { type: Boolean, default: false }, drawingSN: { type: [String, Array] }, curDrawingSN: { type: [String, Number] }, serialNumber: { type: String, default: void 0 }, monomerId: { type: [Number, String], default: void 0 }, productId: { type: Number, default: void 0 }, productType: { type: Number, default: void 0 }, projectType: { type: Number, default: void 0 } }, emits: ["update:modelValue"], setup(E, { emit: U }) {
  const s = U, t = E;
  I("productId", h(() => t.productId)), I("productType", h(() => t.productType)), I("projectType", h(() => t.projectType)), I("serialNumber", h(() => t.serialNumber)), I("monomerId", h(() => t.monomerId));
  const { visible: _, handleClose: e } = Se({ emit: s, props: t, field: "modelValue", showHook: R, closeHook: C }), o = d(), i = d(true), V = d(), L = d(), m = d(false), p = d(), N = h(() => t.boolBim ? Le : xe), g = h(() => {
    var T;
    return Array.isArray(t.drawingSN) && ((T = t.drawingSN) == null ? void 0 : T.length);
  });
  I("multipleDrawing", g), I("drawingSN", p), ae(() => p.value, () => {
    Te(p.value) || (V.value = 1, L.value = 1, q(() => {
      o.value.fetchDrawing(), o.value.reset();
    }));
  });
  function C() {
    p.value = void 0;
  }
  function R() {
    _.value && (g.value ? p.value = t.curDrawingSN || t.drawingSN[0] : (V.value = 1, L.value = 1, q(() => {
      o.value.fetchDrawing(), o.value.reset();
    })));
  }
  function x(T) {
    i.value = T;
  }
  function P(T) {
    m.value = T;
  }
  function w() {
    o.value.scaleZoom();
  }
  function r() {
    o.value.scaleZoomOut();
  }
  function c() {
    o.value.clockwiseRotate();
  }
  function y() {
    o.value.counterclockwiseRotate();
  }
  function A() {
    o.value.reset();
  }
  return (T, n) => {
    const l = de, k = pe;
    return u(), j(f(ue), { title: "图纸预览", modelValue: f(_), "onUpdate:modelValue": n[4] || (n[4] = (a) => re(_) ? _.value = a : null), width: "80%", fullscreen: true, class: ce("drawing-pdf-dialog"), "before-close": f(e) }, { default: F(() => [Q(S("div", Be, [S("div", { class: "preview-content", onDblclick: n[0] || (n[0] = (a) => x(true)), onClick: n[1] || (n[1] = (a) => x(false)) }, [(u(), j(te(N.value), { ref_key: "viewRef", ref: o, onChangeFileLoading: P }, null, 544))], 32), Q(S("div", Oe, [g.value ? (u(), D("div", Ue, [b(f(ne), { modelValue: p.value, "onUpdate:modelValue": n[2] || (n[2] = (a) => p.value = a), size: "default" }, { default: F(() => [(u(true), D(le, null, se(E.drawingSN, (a) => (u(), j(f(ie), { key: a, value: a }, { default: F(() => [W($(`${E.serialNumber}${a ? "_" + a : ""}`), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])])) : (u(), D("div", Pe, $(E.serialNumber), 1)), n[5] || (n[5] = S("div", { class: "operate-middle" }, null, -1)), n[6] || (n[6] = S("div", { class: "operate-right" }, null, -1))], 512), [[Y, i.value]]), S("div", Ae, [S("div", { class: "icon-box", onClick: w }, [b(O, { class: "icon", "icon-class": "comp-zoom" })]), S("div", { class: "icon-box", onClick: r }, [b(O, { class: "icon", "icon-class": "comp-zoom-out" })]), E.boolBim ? z("", true) : (u(), D("div", { key: 0, class: "icon-box", onClick: c }, [b(O, { class: "icon", "icon-class": "comp-clockwise-rotate" })])), E.boolBim ? z("", true) : (u(), D("div", { key: 1, class: "icon-box", onClick: y }, [b(O, { class: "icon", "icon-class": "comp-counterclockwise-rotate" })])), S("div", { class: "icon-box", onClick: A }, [b(O, { class: "icon", "icon-class": "comp-restore-size" })]), S("div", { class: "icon-box", onClick: n[3] || (n[3] = (...a) => f(e) && f(e)(...a)) }, [b(O, { class: "icon", "icon-class": "comp-quit" })])])], 512), [[Y, !m.value]]), m.value ? (u(), D("div", Fe, [b(k, null, { default: F(() => [b(l)]), _: 1 })])) : z("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  xe as _,
  Ze as a,
  Le as b
};
