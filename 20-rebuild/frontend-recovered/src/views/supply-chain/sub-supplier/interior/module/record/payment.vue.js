import { ref as s } from "vue";
import { inject as v } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as p } from "vue";
import { withDirectives as x } from "vue";
import { unref as n } from "vue";
import { createBlock as d } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as k } from "vue";
import { Fragment as C } from "vue";
import { ElTableColumn as N } from "element-plus";
import { ElButton as A } from "element-plus";
import { vLoading as D } from "element-plus";
import { x as T, D as j, P as B } from "../../../../../../shared/runtime.js";
import { j as P } from "../../../../../../modules/index-69cea220.js";
import { d as E } from "../../../../../../modules/upload-file-download-812f558c.js";
import { j as F } from "../../../../../../modules/self-healing-6f411a5c.js";
const L = { key: 1 }, Y = { __name: "payment", setup(z) {
  const r = s(), { table_item_data: _, size: u } = v("common");
  u.value = "55%";
  const { crud: o } = T({ title: "付款记录", crudApi: { get: () => P(_.value.id) } }, r), f = s([["paymentTime", ["parse-time", "{y}-{m}-{d}"]], ["paymentAmount", ["to-thousand", j.YUAN]]]), b = async (m) => {
    await E(m.attachment.id, F);
  };
  return (m, c) => {
    const t = N, g = A, y = w("common-table"), h = D;
    return a(), p(C, null, [x((a(), d(y, { ref_key: "table_ref", ref: r, data: n(o).data, "data-format": f.value, "empty-text": n(o).emptyText }, { default: l(() => [e(t, { align: "center", label: "序号", type: "index", width: "60" }), e(t, { align: "center", label: "付款日期", prop: "paymentTime" }), e(t, { align: "center", label: "供应商", prop: "supplier.supplierName" }), e(t, { align: "center", label: "采购合同号", prop: "contractNumber", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "凭证号", prop: "voucherNumber" }), e(t, { align: "center", label: "付款金额", prop: "paymentAmount" }), e(t, { align: "center", label: "办理人", prop: "user.name" }), e(t, { align: "center", label: "附件", prop: "attachment" }, { default: l(({ row: i }) => [i.attachment.length > 0 ? (a(), d(g, { key: 0, icon: "el-icon-download", plain: "", size: "default", type: "primary", onClick: (R) => b(i) }, { default: l(() => c[0] || (c[0] = [k("下载 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : (a(), p("span", L, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text"])), [[h, n(o).loading]]), e(B)], 64);
  };
} };
export {
  Y as default
};
