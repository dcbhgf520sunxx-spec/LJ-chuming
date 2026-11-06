import { ref as T } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as d } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { unref as r } from "vue";
import { createTextVNode as p } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as O } from "vue";
import { createElementVNode as s } from "vue";
import { withDirectives as R } from "vue";
import { createElementBlock as I } from "vue";
import { Fragment as _ } from "vue";
import { renderList as y } from "vue";
import { isRef as q } from "vue";
import { ElTag as B } from "element-plus";
import { ElDescriptionsItem as F } from "element-plus";
import { ElImage as L } from "element-plus";
import { ElDescriptions as U } from "element-plus";
import { l as V, _ as A, u as P, ua as v, G as $, L as G, z as H } from "../../../../../shared/runtime.js";
function M(l) {
  return V({ module: "project", url: "qhse-problem/pcV2", method: "get", params: l });
}
function J(l) {
  return V({ module: "project", url: `qhse-problem/downloadV2/${l}`, responseType: "blob", method: "get" });
}
const le = { get: M };
const K = { class: "imgs-box" }, Q = { class: "imgs-box" }, W = { __name: "detail", props: { detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(l, { emit: h }) {
  const w = h, x = l, k = T(), { visible: f, handleClose: D } = P({ emit: w, props: x });
  return (Y, m) => {
    const C = B, n = F, b = L, j = U, N = E("common-drawer"), S = z("parse-time");
    return d(), u(N, { ref_key: "detailRef", ref: k, "append-to-body": "", "close-on-click-modal": false, "before-close": r(D), modelValue: r(f), "onUpdate:modelValue": m[0] || (m[0] = (e) => q(f) ? f.value = e : null), title: "问题报告", "wrapper-closable": false, size: "50%" }, { titleAfter: a(() => {
      var e;
      return [t(C, { type: (e = r(v).V[l.detailInfo.boolChangeStatusV2]) == null ? void 0 : e.T }, { default: a(() => [p(i(r(v).VL[l.detailInfo.boolChangeStatusV2]), 1)]), _: 1 }, 8, ["type"])];
    }), titleRight: a(() => [r($)(l.permission.downloadFn) ? (d(), u(G, { key: 0, params: l.detailInfo.id, fn: r(J) }, { default: a(() => m[1] || (m[1] = [p("下载问题报告")])), _: 1, __: [1] }, 8, ["params", "fn"])) : O("", true)]), content: a(() => [t(j, { border: "", column: 2, size: "large" }, { default: a(() => [t(n, { "label-align": "center", label: "问题编号" }, { default: a(() => {
      var e;
      return [s("span", null, i((e = l.detailInfo) == null ? void 0 : e.number), 1)];
    }), _: 1 }), t(n, { "label-align": "center", label: "问题属性" }, { default: a(() => {
      var e;
      return [s("span", null, i((e = l.detailInfo) == null ? void 0 : e.isInternal), 1)];
    }), _: 1 }), t(n, { "label-align": "center", label: "检查人" }, { default: a(() => {
      var e;
      return [s("span", null, i((e = l.detailInfo) == null ? void 0 : e.promoterName), 1)];
    }), _: 1 }), t(n, { "label-align": "center", label: "日期" }, { default: a(() => {
      var e;
      return [R(s("span", null, null, 512), [[S, { val: (e = l.detailInfo) == null ? void 0 : e.problemDate, fmt: "{y}-{m}-{d}" }]])];
    }), _: 1 }), t(n, { "label-align": "center", label: "责任单位" }, { default: a(() => {
      var e;
      return [s("span", null, i((e = l.detailInfo) == null ? void 0 : e.supplierName), 1)];
    }), _: 1 }), t(n, { "label-align": "center", label: "责任人" }, { default: a(() => {
      var e;
      return [s("span", null, i((e = l.detailInfo) == null ? void 0 : e.userName), 1)];
    }), _: 1 }), t(n, { "label-align": "center", label: "项目" }, { default: a(() => {
      var e;
      return [s("span", null, i(r(H)((e = l.detailInfo) == null ? void 0 : e.project)), 1)];
    }), _: 1 }), t(n, { "label-align": "center", label: "质安类别" }, { default: a(() => {
      var e;
      return [s("span", null, i((e = l.detailInfo) == null ? void 0 : e.type), 1)];
    }), _: 1 }), t(n, { "label-align": "center", label: "处罚（元）" }, { default: a(() => {
      var e, o;
      return [s("span", null, i((o = (e = l.detailInfo) == null ? void 0 : e.problemDTO) == null ? void 0 : o.penalty), 1)];
    }), _: 1 }), t(n, { "label-align": "center", label: "分类" }, { default: a(() => {
      var e, o;
      return [s("span", null, i((o = (e = l.detailInfo) == null ? void 0 : e.problemDTO) == null ? void 0 : o.name), 1)];
    }), _: 1 }), t(n, { "label-align": "center", label: "整改前", span: 2 }, { default: a(() => {
      var e;
      return [s("div", K, [(d(true), I(_, null, y((e = l.detailInfo) == null ? void 0 : e.beforeChangeImgs, (o) => {
        var c;
        return d(), u(b, { "preview-src-list": (c = l.detailInfo) == null ? void 0 : c.beforeImgSrc, "initial-index": 1, key: o.id, src: o.tinyImageUrl, lazy: "", style: { margin: "0 2px" } }, null, 8, ["preview-src-list", "src"]);
      }), 128))])];
    }), _: 1 }), t(n, { "label-align": "center", label: "备注", span: 2 }, { default: a(() => [s("span", null, i(l.detailInfo.remark || "-"), 1)]), _: 1 }), t(n, { "label-align": "center", label: "整改后", span: 2 }, { default: a(() => {
      var e, o;
      return [s("div", Q, [(d(true), I(_, null, y((o = (e = l.detailInfo) == null ? void 0 : e.qhseChange) == null ? void 0 : o.afterChangeImgs, (c) => {
        var g;
        return d(), u(b, { "preview-src-list": (g = l.detailInfo) == null ? void 0 : g.afterImgSrc, "initial-index": 1, key: c.id, src: c.tinyImageUrl, lazy: "", style: { margin: "0 2px" } }, null, 8, ["preview-src-list", "src"]);
      }), 128))])];
    }), _: 1 }), t(n, { "label-align": "center", label: "备注", span: 2 }, { default: a(() => [s("span", null, i(l.detailInfo.problemDesc || "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, X = A(W, [["__scopeId", "data-v-3f5348d8"]]), ae = Object.freeze(Object.defineProperty({ __proto__: null, default: X }, Symbol.toStringTag, { value: "Module" }));
export {
  le as c,
  ae as d,
  X as m
};
