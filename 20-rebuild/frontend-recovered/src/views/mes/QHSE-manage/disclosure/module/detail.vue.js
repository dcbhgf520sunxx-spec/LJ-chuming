import { ref as g } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as c } from "vue";
import { createBlock as m } from "vue";
import { withCtx as a } from "vue";
import { withDirectives as D } from "vue";
import { unref as d } from "vue";
import { createTextVNode as j } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as n } from "vue";
import { createElementBlock as y } from "vue";
import { Fragment as v } from "vue";
import { renderList as p } from "vue";
import { isRef as z } from "vue";
import { ElDescriptionsItem as R } from "element-plus";
import { ElImage as U } from "element-plus";
import { ElDescriptions as C } from "element-plus";
import { vLoading as q } from "element-plus";
import { g as F } from "../../../../../modules/index-cfd8d896.js";
import { _ as O, u as H, L as A, mG as G, y as M, i as P, p as _ } from "../../../../../shared/runtime.js";
const Q = { style: { "max-width": "300px", "word-break": "break-all" } }, $ = { class: "imgs-box" }, J = { class: "imgs-box" }, K = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(e, { emit: w }) {
  const x = g(), N = w, h = e, { visible: f, handleClose: k } = H({ emit: N, props: h, field: "visible" }), V = g(false);
  return (W, u) => {
    const t = R, b = U, E = C, L = S("common-drawer"), T = B("permission"), I = q;
    return c(), m(L, { ref_key: "drawerRef", ref: x, title: "QHSE事件曝光", modelValue: d(f), "onUpdate:modelValue": u[0] || (u[0] = (s) => z(f) ? f.value = s : null), direction: "rtl", "before-close": d(k), size: "55%" }, { titleRight: a(() => [D((c(), m(A, { type: "warning", size: "default", params: { id: e.detailData.id }, fn: d(F) }, { default: a(() => u[1] || (u[1] = [j("下载")])), _: 1, __: [1] }, 8, ["params", "fn"])), [[T, d(G).export]])]), content: a(() => [D((c(), m(E, { data: e.detailData, column: 2, size: "large", border: "" }, { default: a(() => [l(t, { align: "center", label: "项目" }, { default: a(() => {
      var s, r;
      return [i("span", null, n((s = e.detailData.project) == null ? void 0 : s.serialNumber) + "-" + n((r = e.detailData.project) == null ? void 0 : r.shortName), 1)];
    }), _: 1 }), l(t, { align: "center", label: "单体" }, { default: a(() => [i("span", null, n(e.detailData.monomerName), 1)]), _: 1 }), l(t, { align: "center", label: "制造人" }, { default: a(() => [i("span", null, n(e.detailData.dutyName), 1)]), _: 1 }), l(t, { align: "center", label: "质检人" }, { default: a(() => [i("span", null, n(e.detailData.userName), 1)]), _: 1 }), l(t, { align: "center", label: "问题类型" }, { default: a(() => [i("span", null, n(d(M).VL[e.detailData.type]), 1)]), _: 1 }), l(t, { align: "center", label: "工序" }, { default: a(() => [i("span", null, n(e.detailData.processName), 1)]), _: 1 }), l(t, { align: "center", label: "产品编号" }, { default: a(() => [i("span", null, n(e.detailData.productSerialNumber), 1)]), _: 1 }), l(t, { align: "center", label: "编号" }, { default: a(() => [i("div", Q, n(d(P)(e.detailData.numberList) ? e.detailData.numberList.join(",") : "-"), 1)]), _: 1 }), l(t, { align: "center", label: "问题类型" }, { default: a(() => [i("span", null, n(e.detailData.qualityTypeListStr), 1)]), _: 1 }), l(t, { align: "center", label: "日期" }, { default: a(() => [i("span", null, n(d(_)(e.detailData.createTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 }), l(t, { align: "center", label: "问题图片", span: 2 }, { default: a(() => {
      var s;
      return [i("div", $, [(c(true), y(v, null, p((s = e.detailData) == null ? void 0 : s.attachmentDTOS, (r) => {
        var o;
        return c(), m(b, { "preview-src-list": (o = e.detailData) == null ? void 0 : o.imgUrls, "initial-index": 1, key: r.id, src: r.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"]);
      }), 128))])];
    }), _: 1 }), l(t, { align: "center", label: "整改人" }, { default: a(() => [i("span", null, n(e.detailData.rectifyName), 1)]), _: 1 }), l(t, { align: "center", label: "日期" }, { default: a(() => [i("span", null, n(d(_)(e.detailData.rectifyTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 }), l(t, { align: "center", label: "整改图片", span: 2 }, { default: a(() => {
      var s;
      return [i("div", J, [(c(true), y(v, null, p((s = e.detailData) == null ? void 0 : s.rectifyAttachmentDTOS, (r) => {
        var o;
        return c(), m(b, { "preview-src-list": (o = e.detailData) == null ? void 0 : o.rectifyImgUrls, "initial-index": 1, key: r.id, src: r.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"]);
      }), 128))])];
    }), _: 1 }), l(t, { align: "center", label: "罚款", span: 2 }, { default: a(() => [i("span", null, n(e.detailData.forfeit), 1)]), _: 1 })]), _: 1 }, 8, ["data"])), [[I, V.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ee = O(K, [["__scopeId", "data-v-d7933f85"]]);
export {
  ee as default
};
