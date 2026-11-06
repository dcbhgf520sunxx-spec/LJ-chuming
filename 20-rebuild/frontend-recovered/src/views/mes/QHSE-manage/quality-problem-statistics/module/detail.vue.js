import { ref as w } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as c } from "vue";
import { createBlock as p } from "vue";
import { withCtx as t } from "vue";
import { withDirectives as R } from "vue";
import { unref as r } from "vue";
import { createTextVNode as z } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as o } from "vue";
import { createElementBlock as b } from "vue";
import { Fragment as B } from "vue";
import { renderList as L } from "vue";
import { isRef as $ } from "vue";
import { createCommentVNode as Y } from "vue";
import { ElDescriptionsItem as Z } from "element-plus";
import { ElImage as ee } from "element-plus";
import { ElDescriptions as ae } from "element-plus";
import { vLoading as te } from "element-plus";
import { d as le } from "../../../../../modules/index-d532b8ca.js";
import { _ as ie, u as ne, L as se, mV as re, iy as oe } from "../../../../../shared/runtime.js";
import { u as de } from "../../../../../modules/use-drawing-8a7ba23b.js";
import { b as ce } from "../../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../modules/index-18acf776.js";
const me = { class: "imgs-box" }, ue = ["src"], fe = { class: "imgs-box" }, pe = ["src"], be = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} } }, emits: ["update:visible", "detailClose"], setup(a, { emit: E }) {
  const P = w(), N = E, O = a, y = w(false), k = w(), { visible: _, handleClose: q } = ne({ emit: N, props: O, field: "visible", closeHook: A }), { showDrawing: D, drawingRow: m, drawingPreview: F } = de({ pidField: "productId" });
  function H(u) {
    u != null && u.drawingLabel ? (k.value = u == null ? void 0 : u.drawingLabel, y.value = true) : F(u);
  }
  function A() {
    N("detailClose");
  }
  const M = w(false);
  return (u, d) => {
    const n = Z, I = ee, G = j("common-button"), J = ae, K = j("common-drawer"), Q = X("permission"), W = te;
    return c(), p(K, { ref_key: "drawerRef", ref: P, title: "质量问题报告", modelValue: r(_), "onUpdate:modelValue": d[3] || (d[3] = (f) => $(_) ? _.value = f : null), direction: "rtl", "before-close": r(q), size: "40%" }, { titleRight: t(() => {
      var f;
      return [R((c(), p(se, { type: "warning", size: "default", params: (f = a.detailData) == null ? void 0 : f.id, fn: r(le) }, { default: t(() => d[4] || (d[4] = [z(" 下载 ")])), _: 1, __: [4] }, 8, ["params", "fn"])), [[Q, r(re).export]])];
    }), content: t(() => {
      var f, h, V, S, x, T, U, C;
      return [R((c(), p(J, { data: a.detailData, column: 2, size: "large", border: "" }, { default: t(() => [i(n, { align: "center", label: "项目", span: 2 }, { default: t(() => {
        var e, l;
        return [s("span", null, o((e = a.detailData.project) == null ? void 0 : e.serialNumber) + "-" + o((l = a.detailData.project) == null ? void 0 : l.shortName), 1)];
      }), _: 1 }), i(n, { align: "center", label: "编号" }, { default: t(() => {
        var e;
        return [s("span", null, o(((e = a.detailData) == null ? void 0 : e.productSerialNumber) || "-"), 1)];
      }), _: 1 }), i(n, { align: "center", label: "规格" }, { default: t(() => {
        var e;
        return [s("span", null, o(((e = a.detailData) == null ? void 0 : e.specification) || "-"), 1)];
      }), _: 1 }), i(n, { align: "center", label: "质检人" }, { default: t(() => {
        var e;
        return [s("span", null, o(((e = a.detailData) == null ? void 0 : e.userName) || "-"), 1)];
      }), _: 1 }), i(n, { align: "center", label: "责任班组" }, { default: t(() => {
        var e;
        return [s("span", null, o(((e = a.detailData) == null ? void 0 : e.dutyName) || "-"), 1)];
      }), _: 1 }), i(n, { align: "center", label: "工序" }, { default: t(() => {
        var e;
        return [s("span", null, o(((e = a.detailData) == null ? void 0 : e.processName) || "-"), 1)];
      }), _: 1 }), i(n, { align: "center", label: "质检编号" }, { default: t(() => {
        var e;
        return [s("span", null, o(((e = a.detailData) == null ? void 0 : e.qhseNumber) || "-"), 1)];
      }), _: 1 }), i(n, { align: "center", label: "质量分类" }, { default: t(() => {
        var e;
        return [s("span", null, o(((e = a.detailData) == null ? void 0 : e.levelOneName) || "-"), 1)];
      }), _: 1 }), i(n, { align: "center", label: "子类" }, { default: t(() => {
        var e;
        return [s("span", null, o(((e = a.detailData) == null ? void 0 : e.levelTwoName) || "-"), 1)];
      }), _: 1 }), i(n, { align: "center", label: "扣分" }, { default: t(() => {
        var e;
        return [s("span", null, o(((e = a.detailData) == null ? void 0 : e.behaviorScore) || "-"), 1)];
      }), _: 1 }), i(n, { align: "center", label: "处罚" }, { default: t(() => {
        var e;
        return [s("span", null, o(((e = a.detailData) == null ? void 0 : e.penalty) ?? "-"), 1)];
      }), _: 1 }), i(n, { align: "center", label: "整改前", span: 2 }, { default: t(() => {
        var e;
        return [s("div", me, [(c(true), b(B, null, L((e = a.detailData) == null ? void 0 : e.attachmentDTOS, (l) => {
          var g, v;
          return c(), b("div", { key: l.id }, [((g = l.name) == null ? void 0 : g.split(".").slice(-1)[0]) !== "mp4" ? (c(), p(I, { "preview-src-list": (v = a.detailData) == null ? void 0 : v.imgUrls, "initial-index": 1, key: l.id, src: l.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"])) : (c(), b("video", { controls: "controls", poster: "", width: "100", height: "60", ref_for: true, ref: `media_${l.id}`, autoplay: false, loop: false, muted: true, key: l.imageUrl, src: l.imageUrl }, null, 8, ue))]);
        }), 128))])];
      }), _: 1 }), i(n, { align: "center", label: "文字备注", span: 2 }, { default: t(() => {
        var e;
        return [s("span", null, o(((e = a.detailData) == null ? void 0 : e.remark) || "-"), 1)];
      }), _: 1 }), i(n, { align: "center", label: "整改后", span: 2 }, { default: t(() => {
        var e;
        return [s("div", fe, [(c(true), b(B, null, L((e = a.detailData) == null ? void 0 : e.rectifyAttachmentDTOS, (l) => {
          var g, v;
          return c(), b("div", { key: l.id }, [((g = l.name) == null ? void 0 : g.split(".").slice(-1)[0]) !== "mp4" ? (c(), p(I, { "preview-src-list": (v = a.detailData) == null ? void 0 : v.rectifyImgUrls, "initial-index": 1, key: l.id, src: l.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"])) : (c(), b("video", { controls: "controls", poster: "", width: "100", height: "60", ref_for: true, ref: `media_${l.id}`, autoplay: false, loop: false, muted: true, key: l.imageUrl, src: l.imageUrl }, null, 8, pe))]);
        }), 128))])];
      }), _: 1 }), i(n, { align: "center", label: "文字备注", span: 2 }, { default: t(() => {
        var e;
        return [s("span", null, o(((e = a.detailData) == null ? void 0 : e.rectifyRemark) || "-"), 1)];
      }), _: 1 }), i(n, { align: "center", label: "图纸标注", span: 2 }, { default: t(() => [i(G, { size: "default", type: "primary", onClick: d[0] || (d[0] = (e) => H(a.detailData)) }, { default: t(() => d[5] || (d[5] = [z("查看图纸")])), _: 1, __: [5] })]), _: 1 })]), _: 1 }, 8, ["data"])), [[W, M.value]]), i(r(ce), { visible: r(D), "onUpdate:visible": d[1] || (d[1] = (e) => $(D) ? D.value = e : null), "bool-bim": (f = r(m)) == null ? void 0 : f.boolBim, drawingSN: (h = r(m)) == null ? void 0 : h.drawingSN, "monomer-id": (V = r(m)) == null ? void 0 : V.monomerId, "area-id": (S = r(m)) == null ? void 0 : S.areaId, "serial-number": (x = r(m)) == null ? void 0 : x.serialNumber, productId: (T = r(m)) == null ? void 0 : T.productId, productType: (U = r(m)) == null ? void 0 : U.productType, projectType: (C = r(m)) == null ? void 0 : C.projectType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "area-id", "serial-number", "productId", "productType", "projectType"]), y.value ? (c(), p(oe, { key: 0, isVisible: y.value, showType: "attachment", id: k.value, onClose: d[2] || (d[2] = (e) => y.value = false) }, null, 8, ["isVisible", "id"])) : Y("", true)];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, xe = ie(be, [["__scopeId", "data-v-19cc62a4"]]);
export {
  xe as default
};
