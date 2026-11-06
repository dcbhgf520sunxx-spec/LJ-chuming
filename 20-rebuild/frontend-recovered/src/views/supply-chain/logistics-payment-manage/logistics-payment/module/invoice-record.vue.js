import { computed as f } from "vue";
import { watch as S } from "vue";
import { ref as p } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as w } from "vue";
import { createBlock as T } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as j } from "vue";
import { createElementBlock as q } from "vue";
import { createCommentVNode as A } from "vue";
import { isRef as L } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElPagination as O } from "element-plus";
import { i as U } from "../../../../../modules/logistics-record-ledger-a6792d58.js";
import { t as F, u as J, J as G, bD as K, o as Q } from "../../../../../shared/runtime.js";
const W = { key: 0 }, $ = { __name: "invoice-record", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(b, { emit: _ }) {
  const { decimalPrecision: y } = F(), x = _, s = b, { visible: l, handleClose: C } = J({ emit: x, props: s }), { handleSizeChange: I, handleCurrentChange: N, total: R, setTotalPage: V, queryPage: c } = G({ fetchHook: h }), B = f(() => ({ branchCompanyId: s.detailInfo.branchCompanyId, supplierId: s.detailInfo.supplierId }));
  S(l, (n) => {
    n && h();
  });
  const m = p([]), d = p(), u = p(false), z = f(() => [["invoiceType", ["parse-enum", K]], ["receiveInvoiceDate", ["parse-time", "{y}-{m}-{d}"]], ["invoiceAmount", ["to-thousand", y.value.supplyChain]], ["taxRate", ["to-fixed", 2]]]), { maxHeight: k } = Q({ mainBox: ".invoice-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", extraHeight: "5vh", minHeight: 300, navbar: false, clientHRepMainH: true }, d);
  async function h() {
    let n = [];
    u.value = true;
    try {
      const { content: o = [], totalElements: e } = await U({ ...B.value, ...c });
      n = o, V(e);
    } catch (o) {
      console.log("获取开票记录失败", o);
    } finally {
      m.value = n, u.value = false;
    }
  }
  return (n, o) => {
    const e = M, H = g("common-table"), D = O, P = g("common-drawer");
    return w(), T(P, { ref_key: "dialogRef", ref: d, title: "收票记录", "close-on-click-modal": false, modelValue: a(l), "onUpdate:modelValue": o[0] || (o[0] = (i) => L(l) ? l.value = i : null), direction: "rtl", "before-close": a(C), "custom-class": "invoice-record", size: "80%" }, { titleRight: r(() => o[1] || (o[1] = [v("div", { class: "print-wrap" }, null, -1)])), content: r(() => [t(H, { data: m.value, "data-format": z.value, "max-height": a(k) }, { default: r(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { prop: "receiveInvoiceDate", label: "开票日期", align: "center", width: "100", "show-overflow-tooltip": "" }), t(e, { prop: "invoiceAmount", label: "开票额", align: "center", "min-width": "120", "show-overflow-tooltip": "" }), t(e, { prop: "invoiceType", label: "开票类型", align: "center", width: "110", "show-overflow-tooltip": "" }), t(e, { prop: "taxRate", label: "税率", align: "center", width: "70", "show-overflow-tooltip": "" }, { default: r(({ row: i }) => [v("span", null, [E(j(i.taxRate), 1), i.taxRate !== "-" ? (w(), q("span", W, "%")) : A("", true)])]), _: 1 }), t(e, { prop: "branchCompanyName", label: "购方单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), t(e, { prop: "supplierName", label: "销售单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), t(e, { prop: "invoiceSerialNumber", label: "发票编号", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), t(e, { prop: "writtenByName", label: "办理人", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), t(e, { prop: "auditUserName", label: "审核人", align: "center", "min-width": "100", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"]), t(D, { total: a(R), "current-page": a(c).pageNumber, "page-size": a(c).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(I), onCurrentChange: a(N) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  $ as default
};
