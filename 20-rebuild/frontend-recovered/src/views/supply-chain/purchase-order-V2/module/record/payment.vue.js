import { ref as s } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as v } from "vue";
import { withCtx as m } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as E } from "vue";
import { unref as o } from "vue";
import { ElTableColumn as I } from "element-plus";
import { vLoading as L } from "element-plus";
import { _ as N, o as S, iv as A, eb as H, ec as M } from "../../../../../shared/runtime.js";
import { u as P } from "../../../../../modules/useTableTotal-3d22365a.js";
import { d as F } from "../../../../../modules/supplier-e2667d36.js";
import $ from "../../../../contract/standing-book/common/components/record/file-download.vue.js";
const z = { class: "collection-container" }, R = { class: "download-container" }, U = { key: 1 }, j = { __name: "payment", props: { orderId: { type: [Number, String] } }, setup(w) {
  const r = s(false), x = w, { requestData: p, total: d, getSummaries: D } = P(false, { defineData: ["paymentAmount"] }), { maxHeight: k } = S({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), u = s([]), _ = async () => {
    try {
      r.value = true;
      const { content: a, totalElements: l } = await F({ ...p, orderId: x.orderId });
      d.value = l, u.value = M(a);
    } catch (a) {
      console.log(a);
    } finally {
      r.value = false;
    }
  };
  _();
  const c = s(false), y = s([]);
  function C(a) {
    y.value = a.attachments, c.value = true;
  }
  return (a, l) => {
    const t = I, B = f("common-button"), V = f("common-table"), T = L;
    return i(), h("div", z, [q((i(), v(V, { data: u.value, "max-height": o(k), "summary-method": o(D), border: "", "show-summary": "", stripe: "" }, { default: m(() => [e(t, { align: "center", label: "序号", type: "index" }), e(t, { align: "center", label: "付款日期", prop: "paymentDate", width: "100" }), e(t, { align: "center", label: "付款类型", prop: "paymentType" }, { default: m(({ row: n }) => [b("span", null, E(o(A).VL[n.paymentType]), 1)]), _: 1 }), e(t, { align: "center", label: "付款金额", prop: "paymentAmount" }), e(t, { align: "center", label: "付款单位", "min-width": "160", prop: "contractSignBody.name" }), e(t, { align: "center", label: "收款单位", "min-width": "160", prop: "supplierName" }), e(t, { align: "center", label: "付款行", "min-width": "140", prop: "paymentBank" }), e(t, { align: "center", label: "办理人", prop: "paymentPerson.name", width: "120" }), e(t, { align: "center", label: "附件", prop: "attachment", width: "80" }, { default: m(({ row: n }) => {
      var g;
      return [b("div", R, [(g = n.attachments) != null && g.length ? (i(), v(B, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: (G) => C(n) }, null, 8, ["onClick"])) : (i(), h("span", U, "-"))])];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[T, r.value]]), e(H, { "request-data": o(p), total: o(d), onHandleChange: _ }, null, 8, ["request-data", "total"]), e($, { "file-list": y.value, modelValue: c.value, "onUpdate:modelValue": l[0] || (l[0] = (n) => c.value = n) }, null, 8, ["file-list", "modelValue"])]);
  };
} }, X = N(j, [["__scopeId", "data-v-146521ed"]]);
export {
  X as default
};
