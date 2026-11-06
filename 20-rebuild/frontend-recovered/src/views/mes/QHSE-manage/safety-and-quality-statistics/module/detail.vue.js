import { ref as v } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as s } from "vue";
import { createBlock as f } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as b } from "vue";
import { unref as g } from "vue";
import { createTextVNode as B } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as d } from "vue";
import { createElementBlock as o } from "vue";
import { Fragment as y } from "vue";
import { renderList as D } from "vue";
import { isRef as C } from "vue";
import { ElDescriptionsItem as L } from "element-plus";
import { ElImage as O } from "element-plus";
import { ElDescriptions as T } from "element-plus";
import { vLoading as $ } from "element-plus";
import { e as j } from "../../../../../modules/index-d532b8ca.js";
import { _ as q, u as A, L as F, mZ as H } from "../../../../../shared/runtime.js";
const M = { class: "imgs-box" }, P = ["src"], Q = { class: "imgs-box" }, Z = ["src"], G = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(a, { emit: w }) {
  const h = v(), k = w, x = a, { visible: _, handleClose: U } = A({ emit: k, props: x, field: "visible" }), N = v(false);
  return (J, u) => {
    const i = L, p = O, V = T, I = R("common-drawer"), S = z("permission"), E = $;
    return s(), f(I, { ref_key: "drawerRef", ref: h, title: "安环问题报告", modelValue: g(_), "onUpdate:modelValue": u[0] || (u[0] = (e) => C(_) ? _.value = e : null), direction: "rtl", "before-close": g(U), size: "40%" }, { titleRight: l(() => {
      var e;
      return [b((s(), f(F, { type: "warning", size: "default", params: (e = a.detailData) == null ? void 0 : e.id, fn: g(j) }, { default: l(() => u[1] || (u[1] = [B(" 下载 ")])), _: 1, __: [1] }, 8, ["params", "fn"])), [[S, g(H).export]])];
    }), content: l(() => [b((s(), f(V, { data: a.detailData, column: 2, size: "large", border: "" }, { default: l(() => [n(i, { align: "center", label: "编号" }, { default: l(() => {
      var e;
      return [r("span", null, d(((e = a.detailData) == null ? void 0 : e.qhseNumber) || "-"), 1)];
    }), _: 1 }), n(i, { align: "center", label: "检查人" }, { default: l(() => {
      var e;
      return [r("span", null, d(((e = a.detailData) == null ? void 0 : e.userName) || "-"), 1)];
    }), _: 1 }), n(i, { align: "center", label: "责任人" }, { default: l(() => {
      var e;
      return [r("span", null, d(((e = a.detailData) == null ? void 0 : e.dutyName) || "-"), 1)];
    }), _: 1 }), n(i, { align: "center", label: "安环分类" }, { default: l(() => {
      var e;
      return [r("span", null, d(((e = a.detailData) == null ? void 0 : e.levelOneName) || "-"), 1)];
    }), _: 1 }), n(i, { align: "center", label: "子类" }, { default: l(() => {
      var e;
      return [r("span", null, d(((e = a.detailData) == null ? void 0 : e.levelTwoName) || "-"), 1)];
    }), _: 1 }), n(i, { align: "center", label: "扣分" }, { default: l(() => {
      var e;
      return [r("span", null, d(((e = a.detailData) == null ? void 0 : e.behaviorScore) || "-"), 1)];
    }), _: 1 }), n(i, { align: "center", label: "处罚" }, { default: l(() => {
      var e;
      return [r("span", null, d(((e = a.detailData) == null ? void 0 : e.penalty) ?? "-"), 1)];
    }), _: 1 }), n(i, { align: "center", label: "" }), n(i, { align: "center", label: "整改前", span: 2 }, { default: l(() => {
      var e;
      return [r("div", M, [(s(true), o(y, null, D((e = a.detailData) == null ? void 0 : e.attachmentDTOS, (t) => {
        var c, m;
        return s(), o("div", { key: t.id }, [((c = t.name) == null ? void 0 : c.split(".").slice(-1)[0]) !== "mp4" ? (s(), f(p, { "preview-src-list": (m = a.detailData) == null ? void 0 : m.imgUrls, "initial-index": 1, key: t.id, src: t.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"])) : (s(), o("video", { controls: "controls", poster: "", width: "100", height: "60", ref_for: true, ref: `media_${t.id}`, autoplay: false, loop: false, muted: true, key: t.imageUrl, src: t.imageUrl }, null, 8, P))]);
      }), 128))])];
    }), _: 1 }), n(i, { align: "center", label: "文字备注", span: 2 }, { default: l(() => {
      var e;
      return [r("span", null, d(((e = a.detailData) == null ? void 0 : e.remark) || "-"), 1)];
    }), _: 1 }), n(i, { align: "center", label: "整改后", span: 2 }, { default: l(() => {
      var e;
      return [r("div", Q, [(s(true), o(y, null, D((e = a.detailData) == null ? void 0 : e.rectifyAttachmentDTOS, (t) => {
        var c, m;
        return s(), o("div", { key: t.id }, [((c = t.name) == null ? void 0 : c.split(".").slice(-1)[0]) !== "mp4" ? (s(), f(p, { "preview-src-list": (m = a.detailData) == null ? void 0 : m.rectifyImgUrls, "initial-index": 1, key: t.id, src: t.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"])) : (s(), o("video", { controls: "controls", poster: "", width: "100", height: "60", ref_for: true, ref: `media_${t.id}`, autoplay: false, loop: false, muted: true, key: t.imageUrl, src: t.imageUrl }, null, 8, Z))]);
      }), 128))])];
    }), _: 1 }), n(i, { align: "center", label: "文字备注", span: 2 }, { default: l(() => {
      var e;
      return [r("span", null, d(((e = a.detailData) == null ? void 0 : e.rectifyRemark) || "-"), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data"])), [[E, N.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Y = q(G, [["__scopeId", "data-v-9f4cf4db"]]);
export {
  Y as default
};
