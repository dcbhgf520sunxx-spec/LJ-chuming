import { resolveComponent as f } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as e } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as h } from "vue";
import { createBlock as g } from "vue";
import { createTextVNode as y } from "vue";
import { unref as c } from "vue";
import { renderSlot as k } from "vue";
import { Fragment as w } from "vue";
import { ElTableColumn as x } from "element-plus";
import { ElButton as B } from "element-plus";
import { u as v } from "../../../../../../modules/useTableTotal-3d22365a.js";
import { u as C } from "../../../../../../modules/useTableHeight-90797a0b.js";
import "../../../../../../shared/runtime.js";
const N = { class: "download-container" }, T = { key: 1 }, H = { __name: "collection", props: { data: { type: Array } }, setup(i) {
  const m = i, { getSummaries: p } = v(false, { defineData: ["collectionAmount"] }), { tableRef: d, maxHeight: u } = C();
  return (l, n) => {
    const t = x, _ = B, b = f("common-table");
    return a(), s(w, null, [e(b, { ref_key: "tableRef", ref: d, data: m.data, "max-height": c(u), "summary-method": c(p), "show-summary": "", stripe: "" }, { default: o(() => [e(t, { align: "center", label: "序号", type: "index" }), e(t, { align: "center", label: "收款日期", prop: "collectionDate" }), e(t, { align: "center", label: "凭证号", prop: "voucherNumber" }), e(t, { align: "center", label: "收款金额", prop: "collectionAmount" }), e(t, { align: "center", label: "付款单位", "min-width": "120", prop: "paymentUnit", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "创建人", prop: "writtenByName" }), e(t, { align: "center", label: "凭证", width: "100" }, { default: o(({ row: r }) => [h("div", N, [r.accessoryId ? (a(), g(_, { key: 0, plain: "", size: "default", type: "primary", onClick: (A) => l.download(r) }, { default: o(() => n[0] || (n[0] = [y("下载 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : (a(), s("span", T, "-"))])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"]), k(l.$slots, "default")], 64);
  };
} };
export {
  H as default
};
