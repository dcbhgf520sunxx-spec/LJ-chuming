import { inject as s } from "vue";
import { computed as c } from "vue";
import { cloneDeep as p } from "lodash";
import { ref as i } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as e } from "vue";
import { withCtx as f } from "vue";
import { unref as b } from "vue";
import { ElTableColumn as v } from "element-plus";
import { D as t, dp as h } from "../../../../../../../shared/runtime.js";
import { u as y } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const C = { __name: "second", setup(D) {
  const o = s("approveInfo"), n = c(() => p(o.value.dto)), m = i([["paymentDate", ["parse-time", "{y}-{m}-{d}"]], ["paymentAmount", ["to-thousand", t.YUAN]], ["invoiceDate", ["parse-time", "{y}-{m}-{d}"]], ["invoiceAmount", ["to-thousand", t.YUAN]]]), { getSummaries: r } = y(false, { defineData: ["paymentAmount", "invoiceAmount"] });
  return (A, g) => {
    const a = v, l = u("common-table");
    return d(), _("div", null, [e(h, { "header-title": "付款及开票记录" }), e(l, { data: n.value, "data-format": m.value, "max-height": 200, returnSourceData: true, "summary-method": b(r), "show-summary": "" }, { default: f(() => [e(a, { align: "center", label: "序号", type: "index", width: "60" }), e(a, { align: "center", label: "付款日期", prop: "paymentDate" }), e(a, { align: "center", label: "付款金额", prop: "paymentAmount" }), e(a, { align: "center", label: "开票日期", prop: "invoiceDate" }), e(a, { align: "center", label: "开票金额", prop: "invoiceAmount" })]), _: 1 }, 8, ["data", "data-format", "summary-method"])]);
  };
} };
export {
  C as default
};
